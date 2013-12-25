package com.sunshineroad.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;

import com.sunshineroad.system.job.vo.RemoteActionVo;
import com.sunshineroad.xjnx.fundssums.vo.FundsSumsVo;

/**
 * omplatform com.sunshineroad.framework.util
 * 
 * @{# FtpUtils.java Create on 2013-7-8 上午8:29:31
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：ftp上传、下载
 * 
 */
public class FtpUtils
{
	/**
	 * FTP上传单个文件测试
	 * 
	 * @return
	 */
	public static boolean fileUpload(String ipaddr, String user,
			String password, String scrFile, String targetPath,
			String newFilename)
	{
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;

		try
		{
			ftpClient.connect(ipaddr);
			ftpClient.login(user, password);

			File srcFile = new File(scrFile);
			fis = new FileInputStream(srcFile);
			// 设置上传目录
			ftpClient.changeWorkingDirectory(targetPath);
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("GBK");
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.storeFile(newFilename, fis);
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("FTP客户端出错！", e);
		} finally
		{
			IOUtils.closeQuietly(fis);
			try
			{
				ftpClient.disconnect();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
	}

	/**
	 * FTP下载单个文件测试
	 * 
	 * @return
	 */
	public boolean fileDownload(RemoteActionVo rmtvo)
	{
		FTPClient ftpClient = new FTPClient();
		FileOutputStream fos = null;
		try
		{
			ftpClient.connect(rmtvo.getIpaddress());
			ftpClient.login(rmtvo.getUserID(), rmtvo.getPassword());

			ftpClient.setBufferSize(1024);
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			
			String scrFile = rmtvo.getSrcfolder() + rmtvo.getFilename();
			String targetFile = rmtvo.getTegfolder() + rmtvo.getFilename();
			if (ftpClient.listNames(scrFile) != null)
			{
				if (ftpClient.listNames(scrFile).length > 0)
				{
					fos = new FileOutputStream(targetFile);
					ftpClient.retrieveFile(scrFile, fos);
					IOUtils.closeQuietly(fos);
					return true;
				} else
				{
					try
					{
						ftpClient.disconnect();
					}
					catch (IOException e)
					{
						e.printStackTrace();
						throw new RuntimeException("关闭FTP连接发生异常！", e);
					}
					return false;
				}

			} else
			{
				try
				{
					ftpClient.disconnect();
				}
				catch (IOException e)
				{
					e.printStackTrace();
					throw new RuntimeException("关闭FTP连接发生异常！", e);
				}
				return false;
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("FTP客户端出错！", e);
		}
	}

	public List<FundsSumsVo> filelist(RemoteActionVo rmtvo)
	{
		List<FundsSumsVo> filelist = new ArrayList<FundsSumsVo>();
		
		String ipaddress = rmtvo.getIpaddress();
		String userID = rmtvo.getUserID();
		String password = rmtvo.getPassword();
		String scrFile = rmtvo.getSrcfolder() + rmtvo.getFilename();
		
		if (ipaddress != null && userID != null && password != null)
		{
			FTPClient ftpClient = new FTPClient();
			FilesUtils fileutil = new FilesUtils();

			try
			{
				ftpClient.connect(ipaddress);
				ftpClient.login(userID, password);

				ftpClient.setBufferSize(1024);
				// 设置文件类型（二进制）
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				FTPListParseEngine engine = ftpClient
						.initiateListParsing(scrFile);
				while (engine.hasNext())
				{
					FTPFile[] files = engine.getNext(5);
					for (int i = 0; i < files.length; i++)
					{
						FundsSumsVo filevo = new FundsSumsVo();

						// 获取文件大小
						long size = files[i].getSize();
						filevo.setId(i + 1);
						// 获取文件名
						String fileFullname = files[i].getName();
						int account = fileFullname.lastIndexOf("/");
						if(account>0)
						{
							String filename=fileFullname.substring(account+1, fileFullname.length());
							filevo.setFilename(filename);
						}else{
							filevo.setFilename(fileFullname);
						}
						filevo.setFilesize(fileutil.FormetFileSize(size));
						// 获取文件创建时间
						filevo.setFiletime(files[i].getTimestamp().getTime());
						filelist.add(filevo);

					}
				}
				try
				{
					ftpClient.disconnect();
				}
				catch (IOException e)
				{
					e.printStackTrace();
					throw new RuntimeException("关闭FTP连接发生异常！", e);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
				throw new RuntimeException("FTP客户端出错！", e);
			}
		}
		return filelist;
	}
}
