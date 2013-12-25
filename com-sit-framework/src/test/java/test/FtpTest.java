package test;

/**
 * omplatform
 * test
 * @{#} FtpTest.java Create on  2013-7-8 上午8:19:49
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
import org.apache.commons.io.IOUtils; 
import org.apache.commons.net.ftp.FTPClient; 

import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.FileOutputStream; 

public class FtpTest { 
    public static void main(String[] args) { 
        testUpload(); 
//        testDownload(); 
    } 

    /** 
     * FTP上传单个文件测试 
     */ 
    public static void testUpload() { 
        FTPClient ftpClient = new FTPClient(); 
        FileInputStream fis = null; 

        String ipaddr= "10.1.45.1";
        String user = "weblogic";
        String password = "weblogic";
        try { 
        	ftpClient.connect(ipaddr); 
            ftpClient.login(user, password); 

            File srcFile = new File("E:\\TelnetUtil.java"); 
            fis = new FileInputStream(srcFile); 
            //设置上传目录 
            ftpClient.changeWorkingDirectory("/app/weblogic/wars/"); 
            ftpClient.setBufferSize(1024); 
            ftpClient.setControlEncoding("GBK"); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.storeFile("test.java", fis); 
        } catch (IOException e) { 
            e.printStackTrace(); 
            throw new RuntimeException("FTP客户端出错！", e); 
        } finally { 
            IOUtils.closeQuietly(fis); 
            try { 
                ftpClient.disconnect(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
                throw new RuntimeException("关闭FTP连接发生异常！", e); 
            } 
        } 
    } 

    /** 
     * FTP下载单个文件测试 
     */ 
    public static void testDownload() { 
        FTPClient ftpClient = new FTPClient(); 
        FileOutputStream fos = null; 

        String ipaddr= "10.1.45.1";
        String user = "weblogic";
        String password = "weblogic";

        try { 
            ftpClient.connect(ipaddr); 
            ftpClient.login(user, password); 

            String remoteFileName = "/app/weblogic/wars/omplatform.war"; 
            fos = new FileOutputStream("e:/omplatform.war"); 

            ftpClient.setBufferSize(1024); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.retrieveFile(remoteFileName, fos); 
        } catch (IOException e) { 
            e.printStackTrace(); 
            throw new RuntimeException("FTP客户端出错！", e); 
        } finally { 
            IOUtils.closeQuietly(fos); 
            try { 
                ftpClient.disconnect(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
                throw new RuntimeException("关闭FTP连接发生异常！", e); 
            } 
        } 
    } 
} 