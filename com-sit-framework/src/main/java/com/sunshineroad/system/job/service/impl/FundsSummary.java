package com.sunshineroad.system.job.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunshineroad.framework.util.AES;
import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.framework.util.StringHandling;
import com.sunshineroad.framework.util.TelnetConn;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.connaddress.entity.Connaddress;
import com.sunshineroad.system.connaddress.service.ConnaddressService;
import com.sunshineroad.system.job.service.util.DownLoadFileScheduledExecutor;
import com.sunshineroad.system.job.vo.RemoteActionVo;
import com.sunshineroad.xjnx.fundssums.service.FundsSumsService;

/**
 * omplatform com.sunshineroad.system.job.service.impl
 * 
 * @{# FundsSummary.java Create on 2013-7-10 上午1:57:32
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0 功能说明：存贷款取数
 * 
 */
public class FundsSummary
{
	private static final Logger logger = Logger.getLogger(TelnetConn.class);

	@Autowired
	protected ConnaddressService connService;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	private FundsSumsService fundssService;

	public void work() throws Exception
	{

		String actDesc = "存贷款取数自动";

		RemoteActionVo rmtvo = new RemoteActionVo();

		String user = "system";
		if (fundssService.getTranDate())
		{

			try
			{

				logger.info("发送命令开始");
				List<Connaddress> connaddrlist = connService.findByType("F001");
				if (connaddrlist.size() == 1)
				{
					rmtvo.setIpaddress(AES.decode(connaddrlist.get(0)
							.getIpaddress()));
					logger.debug("IP Address:" + rmtvo.getIpaddress());

					rmtvo.setUserID(AES
							.decode(connaddrlist.get(0).getAccount()));
					logger.debug("Account:" + rmtvo.getUserID());

					rmtvo.setPassword(AES.decode(connaddrlist.get(0)
							.getPassword()));
					logger.debug("Password:" + rmtvo.getPassword());

					rmtvo.setCommands(connaddrlist.get(0).getCommands());
					logger.debug("Commands:" + rmtvo.getCommands());
					
					rmtvo.setParameters(connaddrlist.get(0).getParameters());
					logger.debug("Commands:" + rmtvo.getParameters());

					TelnetConn telnet = new TelnetConn();
					telnet.TelnetCmd(rmtvo.getIpaddress(), rmtvo.getUserID(), rmtvo.getPassword());
					logger.info("连接成功");

					// 发送命令
					telnet.sendCmd(rmtvo.getCommands());

					logger.info("发送命令结束");
					telnet.disconnect();

					// 默认参数
					rmtvo.setSrcfolder("/bank/xjbank/rpt/xjnx_data");
					
					//获取源目录
					StringHandling srtinghandling = new StringHandling();
					String[] ss_entitys = srtinghandling.splitstring(rmtvo.getParameters(),
							"\\|");
					if (!(ss_entitys.length < 5))
					{
						rmtvo.setSrcfolder(ss_entitys[4]);
					}
					
					// 验证download的目标目录
					String folderPath = "download/funds_Sums/";
					String tegFolderPath = fundssService
							.checkFilePath(folderPath);
					rmtvo.setTegfolder(tegFolderPath);
					
					//文件名
					String format = "yyyyMMdd";
//					String formatdt = DateUtils.dateFormatS(new Date(), format);
					String formatdt = DateUtils.addDayS(new Date(), -1, "d", format);
					String filename = "xjnx_data_" + formatdt + ".txt";
					rmtvo.setFilename(filename);
					
					// 获取邮件服务器
					connaddrlist = connService.findByType("E001");
					if (connaddrlist.size() == 1)
					{
						rmtvo.setMailhost(AES.decode(connaddrlist.get(0).getIpaddress()));
						rmtvo.setMailsender(AES.decode(connaddrlist.get(0).getAccount()));
						rmtvo.setMailpassword(AES.decode(connaddrlist.get(0).getPassword()));
						rmtvo.setMailgetter(connaddrlist.get(0).getCommands());
						if (connaddrlist.get(0).getParameters() != null)
						{
							ss_entitys = srtinghandling.splitstring(connaddrlist.get(0)
									.getParameters(), "\\|");
							if (!(ss_entitys.length < 2))
							{
								rmtvo.setMailtitle(ss_entitys[0]);
								rmtvo.setMailcontext(ss_entitys[1]);
							} else
							{
								rmtvo.setMailtitle("存贷取数");
								rmtvo.setMailcontext("存贷取数");

							}
						} else
						{
							rmtvo.setMailtitle("存贷取数");
							rmtvo.setMailcontext("存贷取数");

						}
						rmtvo.setMailport("25");

						if (rmtvo.getMailhost() != null && rmtvo.getMailsender() != null && rmtvo.getMailpassword() != null
								&& rmtvo.getMailgetter() != null)
						{
							DownLoadFileScheduledExecutor schedule = new DownLoadFileScheduledExecutor();
							schedule.addOneTask(rmtvo,fundssService,actionlogService);
						} else
						{
							logger.error("邮件服务器配置不正确!");
							actionlogService.saveAlog(user, actDesc, false,
									"邮件服务器配置不正确");
						}
					} else
					{
						logger.error("未配置邮件服务器!");
						actionlogService.saveAlog(user, actDesc, false,
								"未配置邮件服务器");
					}

				} else
				{
					logger.error("未配置连接地址!");
					actionlogService.saveAlog(user, actDesc, false, "发送脚本命令失败");
					throw new Exception("未配置连接地址!");
				}
			}
			catch (Exception e)
			{
				actionlogService.saveAlog(user, actDesc, false, "发送脚本命令失败");
				e.printStackTrace();
			}
		} else
		{

			actionlogService.saveAlog(user, actDesc, false, "系统尚未日切");
		}

	}
}
