package com.sunshineroad.xjnx.fundssums.usercase;

import java.util.List;

import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.AES;
import com.sunshineroad.framework.util.FilesUtils;
import com.sunshineroad.framework.util.FtpUtils;
import com.sunshineroad.framework.util.MailUtil;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.StringHandling;
import com.sunshineroad.framework.util.TelnetConn;
import com.sunshineroad.framework.util.ZipCompressor;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.connaddress.entity.Connaddress;
import com.sunshineroad.system.connaddress.service.ConnaddressService;
import com.sunshineroad.system.job.vo.RemoteActionVo;
import com.sunshineroad.xjnx.fundssums.service.FundsSumsService;

/**
 * omplatform com.sunshineroad.xjnx.fundssums.usercase
 * 
 * @{# FundsSumsUC.java Create on 2013-7-9 上午8:45:31
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0 功能说明：存贷款取数user case
 * 
 */
public class FundsSumsUC
{
	private static final Logger logger = Logger.getLogger(FundsSumsUC.class);

	private String actDesc;

	public Object getlist(FundsSumsService fservice,
			ConnaddressService connService, String researchdt) throws Exception
	{
		// get FTP address
		List<Connaddress> connaddrlist = connService.findByType("F001");

		RemoteActionVo rmtvo = new RemoteActionVo();

		if (connaddrlist.size() == 1)
		{
			rmtvo.setIpaddress(AES.decode(connaddrlist.get(0).getIpaddress()));
			rmtvo.setUserID(AES.decode(connaddrlist.get(0).getAccount()));
			rmtvo.setPassword(AES.decode(connaddrlist.get(0).getPassword()));
		}

		// 获取参数设置
		StringHandling srtinghandling = new StringHandling();
		String[] ss_entitys = srtinghandling.splitstring(connaddrlist.get(0)
				.getParameters(), "\\|");
		if (!(ss_entitys.length < 5))
		{
			rmtvo.setSrcfolder(ss_entitys[4]);
		} else
		{
			logger.info("参数[5]应该设置为文件所在目录");
			return ResponseUtils.sendPagination(fservice.getFiles(rmtvo),
					"参数[5]应该设置为文件所在目录");
		}

		String fileName = "xjnx_data_" + researchdt.replaceAll("-", "")
				+ ".txt";
		rmtvo.setFilename(fileName);

		return ResponseUtils.sendPagination(fservice.getFiles(rmtvo));
	}

	public Object commitjob(ConnaddressService connService,
			ActionlogService actionlogService) throws Exception
	{
		actDesc = "存贷款取数手动提交";
		// get FTP address
		List<Connaddress> connaddrlist = connService.findByType("F001");
		if (connaddrlist.size() == 1)
		{
			String ipaddress = AES.decode(connaddrlist.get(0).getIpaddress());
			String userid = AES.decode(connaddrlist.get(0).getAccount());
			String password = AES.decode(connaddrlist.get(0).getPassword());
			String commands = connaddrlist.get(0).getCommands();
			try
			{
				TelnetConn telnet = new TelnetConn();
				telnet.TelnetCmd(ipaddress, userid, password);
				logger.info("连接成功");

				// 发送命令
				telnet.sendCmd(commands);

				logger.info("发送命令结束");
				actionlogService.saveAlog(null, actDesc, true, "");
				telnet.disconnect();
			}
			catch (Exception e)
			{
				actionlogService.saveAlog(null, actDesc, false, "发送脚本命令失败");
				e.printStackTrace();
				return ResponseUtils.sendFailure("存贷款取数手动提交失败");
			}

		}

		return ResponseUtils.sendSuccess("操作提交成功");

	}

	public Object downfile(ConnaddressService connService,
			FundsSumsService fservice, String filename) throws Exception
	{
		// get FTP address
		List<Connaddress> connaddrlist = connService.findByType("F001");
		RemoteActionVo rmtvo = new RemoteActionVo();

		if (connaddrlist.size() == 1)
		{
			rmtvo.setIpaddress(AES.decode(connaddrlist.get(0).getIpaddress()));
			rmtvo.setUserID(AES.decode(connaddrlist.get(0).getAccount()));
			rmtvo.setPassword(AES.decode(connaddrlist.get(0).getPassword()));
		}

		// 获取参数设置
		StringHandling srtinghandling = new StringHandling();
		String[] ss_entitys = srtinghandling.splitstring(connaddrlist.get(0)
				.getParameters(), "\\|");
		if (!(ss_entitys.length < 5))
		{
			rmtvo.setSrcfolder(ss_entitys[4]);
		} else
		{
			logger.info("参数[5]应该设置为文件所在目录");
			return ResponseUtils.sendFailure("未设置参数【5】文件来源目录，<br>文件下载失败");
		}
		FtpUtils ftptools = new FtpUtils();
		FilesUtils filesutils = new FilesUtils();

		String scanPath = "download/funds_Sums/";
		String scanFolderPath = fservice.checkFilePath(scanPath);
		rmtvo.setTegfolder(scanFolderPath);
		rmtvo.setFilename(filename);
		String targetFile = scanFolderPath + filename;

		if (!ftptools.fileDownload(rmtvo))
		{
			return ResponseUtils.sendFailure("文件下载失败");
		}

		// txt文件zip压缩
		int last = filename.lastIndexOf(".");
		String filenamezip = filename.substring(0, last) + ".zip";

		ZipCompressor ziptxt = new ZipCompressor(scanFolderPath + filenamezip);
		ziptxt.compress(targetFile);

		// 删除txt文件
		filesutils.deleteFile(targetFile, true);
		return ResponseUtils.sendSuccess(scanPath + filenamezip);
	}

	public Object sendEmail(ConnaddressService connService,
			ActionlogService actionlogService, FundsSumsService fservice,
			String filename) throws Exception
	{
		actDesc = "存贷款取数邮件补发";
		List<Connaddress> connaddrlist = connService.findByType("F001");
		RemoteActionVo rmtvo = new RemoteActionVo();

		if (connaddrlist.size() == 1)
		{
			rmtvo.setIpaddress(AES.decode(connaddrlist.get(0).getIpaddress()));
			rmtvo.setUserID(AES.decode(connaddrlist.get(0).getAccount()));
			rmtvo.setPassword(AES.decode(connaddrlist.get(0).getPassword()));
		}

		// 获取参数设置
		StringHandling srtinghandling = new StringHandling();
		String[] ss_entitys = srtinghandling.splitstring(connaddrlist.get(0)
				.getParameters(), "\\|");
		if (!(ss_entitys.length < 5))
		{
			rmtvo.setSrcfolder(ss_entitys[4]);
		} else
		{
			logger.info("参数[5]应该设置为文件所在目录");
			return ResponseUtils.sendFailure("未设置参数【5】文件来源目录，<br>文件下载失败");
		}
		FtpUtils ftptools = new FtpUtils();
		FilesUtils filesutils = new FilesUtils();

		String scanPath = "download/funds_Sums/";
		String scanFolderPath = fservice.checkFilePath(scanPath);
		rmtvo.setTegfolder(scanFolderPath);
		rmtvo.setFilename(filename);
		String targetFile = scanFolderPath + filename;

		if (!ftptools.fileDownload(rmtvo))
		{
			return ResponseUtils.sendFailure("文件下载失败");
		}

		// txt文件zip压缩
		int last = filename.lastIndexOf(".");
		String filenamezip = filename.substring(0, last) + ".zip";

		ZipCompressor ziptxt = new ZipCompressor(scanFolderPath + filenamezip);
		ziptxt.compress(targetFile);

		// 删除txt文件
		filesutils.deleteFile(targetFile, true);

		// 获取邮件服务器相关设置
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

			if (rmtvo.getMailhost() != null && rmtvo.getMailsender() != null
					&& rmtvo.getMailpassword() != null
					&& rmtvo.getMailgetter() != null)
			{
				// 发送邮件
				MailUtil sendmail = new MailUtil();
				sendmail.setHost(rmtvo.getMailhost());
				sendmail.setPort(rmtvo.getMailport());
				sendmail.setUserName(rmtvo.getMailsender());
				sendmail.setPassWord(rmtvo.getMailpassword());
				sendmail.setTo(rmtvo.getMailgetter());
				sendmail.setFrom(rmtvo.getMailsender());
				sendmail.setSubject(rmtvo.getMailtitle());
				sendmail.setContent(rmtvo.getMailcontext());
				sendmail.attachfile(scanFolderPath + filenamezip);
				if (!sendmail.sendMail())
				{
					filesutils.deleteFile(scanFolderPath + filenamezip, true);
					return ResponseUtils.sendFailure("邮件补发失败");

				}
			} else
			{
				filesutils.deleteFile(scanFolderPath + filenamezip, true);
				return ResponseUtils.sendFailure("邮件服务器配置不正确");
			}
		} else
		{
			filesutils.deleteFile(scanFolderPath + filenamezip, true);
			return ResponseUtils.sendFailure("未配置邮件服务器【E001】");
		}
		filesutils.deleteFile(scanFolderPath + filenamezip, true);
		actionlogService.saveAlog(null, actDesc, true, "");
		return ResponseUtils.sendSuccess("邮件补发成功");

	}

}
