package com.sunshineroad.system.job.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.util.AES;
import com.sunshineroad.framework.util.StringHandling;
import com.sunshineroad.framework.util.TelnetConn;
import com.sunshineroad.system.connaddress.entity.Connaddress;
import com.sunshineroad.system.connaddress.service.ConnaddressService;
import com.sunshineroad.system.errorlog.entity.Errorlog;
import com.sunshineroad.system.errorlog.service.ErrorlogService;
import com.sunshineroad.system.monitor.entity.Monitor;

/**
 * omplatformNew
 * com.sunshineroad.system.job.service.impl
 * @{#} LargeMicrofinance.java Create on  2013-6-13 上午4:42:57
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：大小额监控
 *
 */
//@Service("largeMicrofinance")
public class LargeMicrofinance {
	
	private static final Logger logger = Logger.getLogger(TelnetConn.class);
	
	@Autowired
	protected ErrorlogService elogservice;
	
	@Autowired
	protected ConnaddressService connService;
	
	public void work()
 	{
 		
 		try {
 			
 			logger.info("发送命令开始");
 			List<Connaddress> connaddrlist=connService.findByType("M001");
 			if(connaddrlist.size()==1)
 			{
 				String ipaddress=AES.decode(connaddrlist.get(0).getIpaddress());
 				logger.debug("IP Address:"+ipaddress);
 				
 				String userid=AES.decode(connaddrlist.get(0).getAccount());
 				logger.debug("Account:"+userid);
 			
 				String password=AES.decode(connaddrlist.get(0).getPassword());
 				logger.debug("Password:"+password);
 				
 				String commands=connaddrlist.get(0).getCommands();
 				logger.debug("Commands:"+commands);
 			
/*  			String ipaddress="10.1.25.5";
 				String userid="xjtest";
 				String password="xjtest";*/
 			
 				TelnetConn telnet = new TelnetConn();
 				telnet.TelnetCmd(ipaddress, userid, password);    
 				logger.info("连接成功");
 			
 				StringHandling srtinghandling= new StringHandling();
// 				String text="sh user/lhl/monitor.sh";
 				String out_telnet_message = telnet.sendCmd(commands);
 		 
 				// Split the string and get line 2
 		        String[] ss_lines = srtinghandling.splitstring(out_telnet_message, "\r\n");
 		        String commonMsg="正确进程数: ";
 		        String pflag="P";
 		        String mflag="M";
 		        if(ss_lines.length>1)
 		           {
 		        	   logger.debug(ss_lines[1]);
 		        	   logger.debug("********************");
 		        	   String[] ss_entitys = srtinghandling.splitstring(ss_lines[1], " ");
 		        	   String terminal="M001";
 		        	   Date occurdate=new Date();
 		        	   Timestamp timestamp=new Timestamp(System.currentTimeMillis());

 		        	   if(srtinghandling.isnumeral(ss_entitys[0]))
 		        	   {
 		        		 //the number of thread “recvmbfe” should be 6
 		        		 //otherwise record the error message
		                 if (Integer.parseInt(ss_entitys[0])!=6)
 		                 {
		                	 Errorlog elog = new Errorlog();
		                	 Monitor monitor = new Monitor();
		                	 monitor.setTerminal(terminal);
		                	 elog.setMonitor(monitor);
		                	 //elog.setTerminal(terminal);
		                	 elog.setOccurdate(occurdate);
		                	 elog.setDescription("当前recvmbfe(大额行内接口程序)的进程数：【"+ss_entitys[0]+"】; " +commonMsg+"【6】");
		                	 elog.setFlag(pflag);
		                	 elog.setDimension("recvmbfe");
		                	 elog.setTimestamp(timestamp);
		                	 this.elogservice.save(elog);
		                	 
 		                 } 
 		        		 //the number of thread “mbfeprogram” should be 7
 		        		 //otherwise record the error message
		                 if (Integer.parseInt(ss_entitys[1])!=7)
 		                 {
		                	 Errorlog elog = new Errorlog();
		                	 Monitor monitor = new Monitor();
		                	 monitor.setTerminal(terminal);
		                	 elog.setMonitor(monitor);
	 		             	 //elog.setTerminal(terminal);
	 		             	 elog.setOccurdate(occurdate);
	 		             	 elog.setDescription("当前mbfeprogram(大额前置程序)的进程数：【"+ss_entitys[1]+"】; " +commonMsg+"【7】");
		                	 elog.setFlag(pflag);
		                	 elog.setDimension("mbfeprogram");
	 		             	 elog.setTimestamp(timestamp);
	 		             	 this.elogservice.save(elog);
 		                 }
 		        		 //the number of thread “BEPSMBFE” should be 9
 		        		 //otherwise record the error message
		                 if (Integer.parseInt(ss_entitys[2])!=9)
 		                 {
	 		             	 Errorlog elog = new Errorlog();
	 		             	 Monitor monitor = new Monitor();
		                	 monitor.setTerminal(terminal);
		                	 elog.setMonitor(monitor);
	 		             	 //elog.setTerminal(terminal);
	 		             	 elog.setOccurdate(occurdate);
	 		             	 elog.setDescription("当前BEPSMBFE(小额前置程序)的进程数：【"+ss_entitys[2]+"】; " +commonMsg+"【9】");
		                	 elog.setFlag(pflag);
		                	 elog.setDimension("BEPSMBFE");
	 		             	 elog.setTimestamp(timestamp);
	 		             	 this.elogservice.save(elog);
 		                 }
 		        		 //the number of thread “Vstart” should be 1
 		        		 //otherwise record the error message
		                 if (Integer.parseInt(ss_entitys[3])!=1)
 		                 {
	 		             	 Errorlog elog = new Errorlog();
	 		             	 Monitor monitor = new Monitor();
		                	 monitor.setTerminal(terminal);
		                	 elog.setMonitor(monitor);
	 		             	 //elog.setTerminal(terminal);
	 		             	 elog.setOccurdate(occurdate);
	 		             	 elog.setDescription("当前Vstart(小额接口处理程序)的进程数：【"+ss_entitys[3]+"】; " +commonMsg+"【1】");
		                	 elog.setFlag(pflag);
		                	 elog.setDimension("Vstart");
	 		             	 elog.setTimestamp(timestamp);
	 		             	 this.elogservice.save(elog);
 		                 }
 		        		 //the number of thread “TransPro” should be 5
 		        		 //otherwise record the error message
		                 if (Integer.parseInt(ss_entitys[4])!=5)
 		                 {
	 		             	 Errorlog elog = new Errorlog();
	 		             	 Monitor monitor = new Monitor();
		                	 monitor.setTerminal(terminal);
		                	 elog.setMonitor(monitor);
	 		             	 //elog.setTerminal(terminal);
	 		             	 elog.setOccurdate(occurdate);
	 		             	 elog.setDescription("当前TransPro(小额接口处理程序)的进程数：【"+ss_entitys[4]+"】; " +commonMsg+"【5】");
		                	 elog.setFlag(pflag);
		                	 elog.setDimension("TransPro");
	 		             	 elog.setTimestamp(timestamp);
	 		             	 this.elogservice.save(elog);
 		                 }
 		        		 //The memory used should be lower than 10%
 		        		 //otherwise record the error message
		                 if (Integer.parseInt(ss_entitys[5])>10)
 		                 {
	 		             	 Errorlog elog = new Errorlog();
	 		             	 Monitor monitor = new Monitor();
		                	 monitor.setTerminal(terminal);
		                	 elog.setMonitor(monitor);
	 		             	 //elog.setTerminal(terminal);
	 		             	 elog.setOccurdate(occurdate);
		                	 elog.setDescription("当前内存使用量："+ss_entitys[5]+"%");
		                	 elog.setFlag(mflag);
		                	 elog.setTimestamp(timestamp);
		                	 this.elogservice.save(elog);
 		                 }
 		        	   }
 		           }
 		           logger.info("发送命令结束");
 		           telnet.disconnect();
 			}else{
 				logger.error("未配置连接地址!");
 				throw new Exception("未配置连接地址!");
 			}
 			}catch( Exception e ) {
 				e.printStackTrace();
 			}
 		
 	}
}
