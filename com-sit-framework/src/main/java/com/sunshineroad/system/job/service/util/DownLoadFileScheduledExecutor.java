package com.sunshineroad.system.job.service.util;

/**
 * omplatform
 * test
 * @{#} testetest.java Create on  2013-7-10 上午5:15:55
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0
 * 功能说明：定时通过FTP下载文件
 *
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.FilesUtils;
import com.sunshineroad.framework.util.FtpUtils;
import com.sunshineroad.framework.util.MailUtil;
import com.sunshineroad.framework.util.StringHandling;
import com.sunshineroad.framework.util.TelnetConn;
import com.sunshineroad.framework.util.ZipCompressor;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.job.vo.RemoteActionVo;
import com.sunshineroad.xjnx.fundssums.service.FundsSumsService;

public class DownLoadFileScheduledExecutor
{
	private static final Logger logger = Logger.getLogger(TelnetConn.class);

	// 线程池能按时间计划来执行任务，允许用户设定计划执行任务的时间，int类型的参数是设定
	// 线程池中线程的最小数目。当任务较多时，线程池可能会自动创建更多的工作线程来执行任务
	public ScheduledExecutorService scheduExec = Executors
			.newScheduledThreadPool(1);

	public int count = 0;
	
	public int times;

	public FilesUtils filesutils = new FilesUtils();
	
	public FtpUtils ftputil = new FtpUtils();

	public String actDesc = "存贷款取数自动";
	
	// 默认参数
	public long dltime = 15;
	public long feq = 15;
	public TimeUnit timeunit = TimeUnit.MINUTES;

	// 启动计时器
	public void lanuchTimer()
	{
		Runnable task = new Runnable() {
			public void run()
			{
				throw new RuntimeException();
			}
		};
		scheduExec.scheduleWithFixedDelay(task, 5, 10, TimeUnit.SECONDS);
	}

	// 添加新任务
	public void addOneTask(final RemoteActionVo rmtvo,final FundsSumsService fundssService, final ActionlogService actionlogService)
			throws Exception
	{

		times = 4;

		// 获取参数设置
		StringHandling srtinghandling = new StringHandling();
		String[] ss_entitys = srtinghandling.splitstring(rmtvo.getParameters(),
				"\\|");
		if (!(ss_entitys.length < 5))
		{
			if (srtinghandling.isnumeral(ss_entitys[0]))
			{
				dltime = Math.round(Integer.parseInt(ss_entitys[0]));
			} else
			{
				logger.info("提交频率类型必须为数字，系统将使用默认设置");
			}

			if (srtinghandling.isnumeral(ss_entitys[1]))
			{
				feq = Math.round(Integer.parseInt(ss_entitys[1]));
			} else
			{
				logger.info("提交频率类型必须为数字，系统将使用默认设置");
			}

			if (ss_entitys[2].equals("s"))
			{
				timeunit = TimeUnit.SECONDS;
			} else if (ss_entitys[2].equals("m"))
			{
				timeunit = TimeUnit.MINUTES;
			} else if (ss_entitys[2].equals("h"))
			{
				timeunit = TimeUnit.HOURS;
			}

			if (srtinghandling.isnumeral(ss_entitys[3]))
			{
				times = Math.round(Integer.parseInt(ss_entitys[3]));
			} else
			{
				logger.info("提交次数必须为数字，系统将使用默认设置");
			}

		} else
		{
			logger.info("参数设置不正确，系统将使用默认设置");
		}
		
		Runnable task = new Runnable() {
			public void run()
			{

				count++;
				// ftp download file
				boolean downloadsucc = ftputil.fileDownload(rmtvo);

				// if downloaded file successful then send mail and close the
				// schedule
				try
				{
					if (downloadsucc)
					{
						// 压缩文件为zip格式
						String tegFolderPath = rmtvo.getTegfolder();
						String targetFile = tegFolderPath + rmtvo.getFilename();
						
						int last = rmtvo.getFilename().lastIndexOf(".");
						String filenamezip = rmtvo.getFilename().substring(0, last)
								+ ".zip";

						ZipCompressor ziptxt = new ZipCompressor(rmtvo.getTegfolder()
								+ filenamezip);
						ziptxt.compress(targetFile);

						// 删除txt文件
						filesutils.deleteFile(targetFile, true);

						// Send email

						MailUtil sendmail = new MailUtil();
						sendmail.setHost(rmtvo.getMailhost());
						sendmail.setPort(rmtvo.getMailport());
						sendmail.setUserName(rmtvo.getMailsender());
						sendmail.setPassWord(rmtvo.getMailpassword());
						sendmail.setTo(rmtvo.getMailsender());
						sendmail.setFrom(rmtvo.getMailsender());
						sendmail.setSubject(rmtvo.getMailtitle());
						sendmail.setContent(rmtvo.getMailcontext());
						sendmail.attachfile(tegFolderPath + filenamezip);

						boolean sendsucc = sendmail.sendMail();
						System.out.println(sendsucc);

						// if send mail successful then delete file if
						if (sendsucc)
						{
							filesutils.deleteFile(tegFolderPath + filenamezip,
									true);
							actionlogService.saveAlog("system", actDesc, true,
									"");

						} else
						{
							filesutils.deleteFile(tegFolderPath + filenamezip,
									true);
							actionlogService.saveAlog("system", actDesc, false,
									"邮件发送失败");
						}

						scheduExec.shutdown();
						System.out.println("job has been shotdowned!");
					}
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (count > times - 1)
				{
					try
					{
						actionlogService.saveAlog("system", actDesc, false,
								"未获取到文件");
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					scheduExec.shutdown();
					System.out.println("job has been shotdowned!");
				}
			}
		};
		scheduExec.scheduleWithFixedDelay(task, dltime, feq, timeunit);
	}
}
