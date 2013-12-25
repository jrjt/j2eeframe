package test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.sunshineroad.framework.util.AES;
import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.framework.util.FilesUtils;
import com.sunshineroad.framework.util.FtpUtils;
import com.sunshineroad.framework.util.MailUtil;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.StringHandling;
import com.sunshineroad.framework.util.TelnetConn;
import com.sunshineroad.framework.util.TxtParser;
import com.sunshineroad.framework.util.ZipCompressor;
import com.sunshineroad.system.job.service.util.DownLoadFileScheduledExecutor;
import com.sunshineroad.system.usersigned.service.UsersignedService;
import com.sunshineroad.xjnx.fundssums.service.FundsSumsService;
import com.sunshineroad.xjnx.fundssums.service.impl.FundsSumsServiceImpl;
import com.sunshineroad.xjnx.fundssums.usercase.FundsSumsUC;
import com.sunshineroad.xjnx.fundssums.vo.FundsSumsVo;
import java.lang.*;

public class testExample
{
	private static final Logger logger = Logger.getLogger(testExample.class);
	
	@SuppressWarnings("unused")
	private FundsSumsService fs;
	

	public void testString(){
		String pattern = "$<>";
		char[] strChar = pattern.toCharArray();
		String sb ="asdfasdfsfasdffadf>";
		int i=0;
		for (char temp : strChar)
		{
			if ('>' == temp)
			{
				System.out.println(pattern.substring(i, i+1));
				if (sb.endsWith(pattern.substring(i, i+1)))
				{
					System.out.print(sb);
				}
			}
			i++;
		}
	}
	
	@Test
	public void testwork() throws Exception
	{
		
		String date = "2013-07-12";
		String format = "yyyy-MM-dd";
		System.out.println(DateUtils.dateFormatD(date, "yyyy-MM-dd"));
		

	/*	String ipaddress = "10.1.25.5";
		String userid = "xjtest";
		String password = "xjtest2013";
		String commands = "ls";
		
		try
		{
			TelnetConn telnet = new TelnetConn();
			telnet.TelnetCmd(ipaddress, userid, password);
			logger.info("连接成功");

			// 发送命令
			String feedback = telnet.sendCmd(commands);
			System.out.println(feedback);

			logger.info("发送命令结束");

			telnet.disconnect();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}*/
		
/*		String format = "yyyyMMdd";
		String date = "2013-07-19";
//		String formatdt = DateUtils.dateFormatS(new Date(), format);
		String formatdt = DateUtils.addDayS(new Date(), -1, "d", format);
		String formatdt2 = DateUtils.addDayS(date, 1, "d", format);
		
		System.out.println(formatdt);
		System.out.println(formatdt2);
		*/
/*		ZipCompressor zca = new ZipCompressor("E:\\szhzipant.zip");  
        zca.compress("E:\\src"); */
        FilesUtils filesu = new FilesUtils();
        filesu.deleteFile("E:\\src2", true);
/*		StringHandling srtinghandling = new StringHandling();
//		String test ="10|20|123456|aaa|aaa|aaa|aa|bbb";
		String test = "xjnx_data_20130717.txt";
		int last = test.lastIndexOf(".");
		String subsb = test.substring(0,last);
		String subs = test.substring(last+1, test.length());
		String[] ss_entitys = srtinghandling.splitstring(test, "\\.");
		for(int i=0;i<ss_entitys.length;i++)
		{
			System.out.println(ss_entitys[i]);
		}
		
		System.out.println(last);
		System.out.println(subsb);
		System.out.println(subs);*/
/*
		String format1 = "yyyyMMdd";
		String format = "yyyy-MM-dd";
		String researchdt = "2013-07-15";
		String dd = DateUtils.dateFormatS(researchdt, format);
		String dd1 = DateUtils.dateFormatS(researchdt, format1);
		Date dd2 = DateUtils.dateFormatD(dd, format);
		String dd3 = DateUtils.dateFormatS(dd2, format1);
		System.out.println(dd);
		System.out.println(dd1);
		System.out.println(dd2);
		System.out.println(dd3);
		System.out.println(researchdt.replaceAll("-", ""));
*/		
/*		String szDate = "2013-07-31";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Start Date :" + fmt.parse(szDate));
 
        szDate = addDay(szDate, 1,"y");
        Date date = fmt.parse(szDate);
        System.out.println("End Date :" + date);
        
        System.out.println(StringUtils.isNotBlank("%"+null+"%"));
        System.out.println("%"+null+"%");
        
        System.out.println(fmt.parse(szDate));*/
        
/*		String path = this.getClass().getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		String folderPath = "download/funds_Sums/";
		String scanFolderPath;
		String scrFile = "/bank/xjtest/user/lhl/pingtest2.sh";
		
		String ipaddress="10.1.25.5";
		String userid = "xjtest";
		String password = "xjtest";

		if (path.indexOf("WEB-INF") > 0)
		{
			scanFolderPath = path.substring(0,
					path.indexOf("WEB-INF"))
					+ folderPath;
		} else
		{
			throw new IllegalAccessException("路径获取错误");
		}

		String targetFile = scanFolderPath + "pingtest.sh";
		File newFile = new File(scanFolderPath);
		if (!newFile.exists())
		{
			newFile.mkdirs();
		}

		DownLoadFileScheduledExecutor schedule = new DownLoadFileScheduledExecutor();
		schedule.addOneTask(1, 30, TimeUnit.SECONDS,4,
				ipaddress, userid, password, folderPath, scrFile,
				targetFile);*/
		
/*		ScheduledExecutorTest test = new ScheduledExecutorTest();
		test.lanuchTimer();
//		Thread.sleep(1000*5);//5秒钟之后添加新任务
		test.addOneTask(5,5);*/
		
/*		String path = this.getClass().getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		
		System.out.println(path);*/
		
/*		FundsSumsService fss= new FundsSumsServiceImpl();
		List<FundsSumsVo> fsl = fss.getFiles("D://Download");
		if (!fsl.isEmpty())
		{
			for (FundsSumsVo temp : fsl)
			{
				System.out.println(temp.getFilename() + " || "
						+ temp.getFilesize() + " || " + temp.getFiletime());
			}
		}*/
/*		
		FtpUtils ftptools= new FtpUtils();
		String filename = "test.java";
        String ipaddr= "10.1.45.1";
        String user = "weblogic";
        String password = "weblogic";
        String scrFile= "/app/weblogic/wars/"+filename;
        String targetFile = "E:/"+filename;
        
        boolean filedownl = ftptools.fileDownload(ipaddr, user, password, scrFile, targetFile);
        if(filedownl)
        {
        	System.out.println("Success!");
        	
        }else if(!filedownl)
        {
        	System.out.println("File is no exist!");
        }
        
*/		
/*		TxtParser txt = new TxtParser();
		String filePath="E:\\test.txt";
		List<String> txts = txt.readTxtFile(filePath);
		int y=0;
		for (int i = 0; i < txts.size(); i++)
		{
				System.out.println(txts.get(i));
				y=i;
		}*/
		
/*		String txtb=txt.getTextFromTxt(filePath);
		System.out.println(txtb);*/
		
		//Mail handle
/*		
		MailUtil sendmail = new MailUtil();
        sendmail.setHost("smtp.qq.com");
        sendmail.setPort("25");
        sendmail.setUserName("82221324@qq.com");  
        sendmail.setPassWord("19860212yl!");  
        sendmail.setTo("371917461@qq.com,82221324@qq.com");  
        sendmail.setFrom("82221324@qq.com");
        sendmail.setSubject("你好，这是测试邮件！");  
        sendmail.setContent("你好这是一个带附件的测试！");  
        sendmail.attachfile("D:\\Andy\\Myeclipse10\\.metadata\\.me_tcat\\webapps\\omplatform\\upload\\20130624030503_项目经理培训学员名单.xlsx");  
        
        System.out.println(sendmail.sendMail()); 
 */       
		/*
		List<List> datas;
		String file = "E:\\my.xls";
		ExcelSheetParser parser = new ExcelSheetParser(file);
		boolean isExcel2003 = true;
		//对文件的合法性进行验证
		if (file.matches("^.+\\.(?i)(xlsx)$"))
		{
			isExcel2003 = false;
		}
		if (isExcel2003)
		{
			datas = parser.getDatasInSheet(0);
		} else
		{
			datas = parser.getDatasInSheetX(0);
		}
		for (int i = 0; i < datas.size(); i++)
		{
			List row = datas.get(i);
			if (row.get(0) == null)
			{
				System.out.println("Blank lines '" + null + "'");
				break;
			} else if (StringUtils.isBlank(row.get(0).toString()))
			{
				System.out.println("Blank lines" + "'Spaces'");
				break;
			}
			for (short j = 0; j < row.size(); j++)
			{
				Object value = row.get(j);
				String data = String.valueOf(value);
				System.out.println(data + "\t");
			}
			System.out.println("Columns account : " + row.size());
			System.out.println();
		}
		System.out.println("rows account : " + datas.size());*/

		/*
		 * System.out.println("第【"+new
		 * Date().getDate()/7+"】天 "+"Missing u so much!");
		 * 
		 * System.out.println(new Date().getTime());
		 * 
		 * 
		 * 
		 * SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		 * SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
		 * 
		 * System.out.println(sdf1.format(new Date()));
		 * System.out.println(sdf2.format(new Date()));
		 * System.out.println(sdf3.format(new Date()));
		 */

		/*
		 * try { // AES.generatekey(); String str = new String("abcb");
		 * System.out.println("原  字  串：" + str); str = AES.encode(str);
		 * System.out.println("加密字串：" + str); str = AES.decode(str);
		 * System.out.println("解密字串：" + str);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
	}
	
	public static String addDay(String s, int n,String unit) {   
        try {   
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
  
                 Calendar cd = Calendar.getInstance();   
                 cd.setTime(sdf.parse(s));   
     			if (unit.equals("d"))
    			{
    				cd.add(Calendar.DATE, n);// 增加一天
    			}
    			if (unit.equals("m"))
    			{
    				cd.add(Calendar.MONTH, n);// 增加一个月
    			}
    			if (unit.equals("y"))
    			{
    				cd.add(Calendar.YEAR, n);// 增加一个月
    			}
    			System.out.println("---"+cd.getTime());
                return sdf.format(cd.getTime());   
       
             } catch (Exception e) {   
                 return null;   
             }   
     }  
	
	public static void main(String[] args) throws Exception {
		
/*		String path = testExample.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		String folderPath = "download/funds_Sums/";
		String scanFolderPath;
		String scrFile = "/bank/xjtest/user/lhl/pingtest.sh";
		
		String ipaddress="10.1.25.5";
		String userid = "xjtest";
		String password = "xjtest";

		if (path.indexOf("WEB-INF") > 0)
		{
			scanFolderPath = path.substring(0,
					path.indexOf("WEB-INF"))
					+ folderPath;
		} else
		{
			throw new IllegalAccessException("路径获取错误");
		}

		String targetFile = scanFolderPath + "pingtest.sh";
		File newFile = new File(scanFolderPath);
		if (!newFile.exists())
		{
			newFile.mkdirs();
		}
		
		FtpUtils ftputil = new FtpUtils();
		boolean downloadsucc = ftputil.fileDownload(RemoteActionVo );
		System.out.println(downloadsucc);
		*/
	}
}
