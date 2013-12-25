package test;

/**
 * omplatform
 * test
 * @{#} FileTest.java Create on  2013-7-8 上午4:49:50
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileTest
{
	private static ArrayList<String> filelist = new ArrayList<String>();
	private static SimpleDateFormat sdf1 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) throws Exception
	{

		String filePath = "D://Download";
		getFiles(filePath);
	}

	/*
	 * 通过递归得到某一路径下所有的目录及其文件
	 */
	static void getFiles(String filePath) throws IOException, ParseException
	{
		File root = new File(filePath);
		File[] files = root.listFiles();
		FileInputStream fis = null;
		long s = 0;
		for (File file : files)
		{
			if (file.isDirectory())
			{
				/*
				 * 递归调用
				 */
				getFiles(file.getAbsolutePath());
				filelist.add(file.getAbsolutePath());
				System.out.println("显示" + filePath + "下所有子目录及其文件"
						+ file.getAbsolutePath());
			} else
			{
				fis = new FileInputStream(file);
				s = fis.available();
				Long time = file.lastModified();
				System.out.println("显示" + filePath + "下所有子目录"
						+ file.getAbsolutePath());
				System.out.println("-----Size-----Time-----");
				System.out.println(file.getName() + " || " + FormetFileSize(s)
						+ " || " + sdf1.format(time));
				Date d = sdf2.parse(sdf2.format(time));
				Date td = sdf2.parse(sdf2.format(new Date()));
				boolean flag = d.before(td);

				//d.compareTo(td)>0晚于；<0早于；=0当天
				System.out.println(d.compareTo(td));
				if (flag)
				{
					System.out.println("早于今天");
				} else
				{
					if (d.compareTo(td) == 0)
					{
						System.out.println("今天");
					} else
					{
						System.out.println("晚于今天");
					}
				}
				System.out.println("--------------");
			}
		}
	}

	// 取得文件大小
	public long getFileSizes(File f) throws Exception
	{
		long s = 0;
		if (f.exists())
		{
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s = fis.available();
		} else
		{
			f.createNewFile();
			System.out.println("文件不存在");
		}
		return s;
	}

	// 递归
	// 取得文件夹大小
	public long getFileSize(File f) throws Exception
	{
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++)
		{
			if (flist[i].isDirectory())
			{
				size = size + getFileSize(flist[i]);
			} else
			{
				size = size + flist[i].length();
			}
		}
		return size;
	}

	// 转换文件大小
	public static String FormetFileSize(long fileS)
	{
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024)
		{
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576)
		{
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824)
		{
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else
		{
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

	// 递归求取目录文件个数
	public long getlist(File f)
	{
		long size = 0;
		File flist[] = f.listFiles();
		size = flist.length;
		for (int i = 0; i < flist.length; i++)
		{
			if (flist[i].isDirectory())
			{
				size = size + getlist(flist[i]);
				size--;
			}
		}
		return size;

	}
}
