package com.sunshineroad.framework.util;

/**
 * omplatform
 * com.sunshineroad.framework.util
 * @{#} FileUtils.java Create on  2013-6-20 上午3:10:34
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：文件操作的一个类，包括文件的类型获取，文件、文件夹操作、文件上传等
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import com.sunshineroad.framework.web.support.pagination.PaginationUtils;
import com.sunshineroad.xjnx.fundssums.vo.FundsSumsVo;
 
public class FilesUtils {
	
	private String uploadFolderPath;
	
	private static SimpleDateFormat sdfc = new SimpleDateFormat("yyyyMMdd");
 
    public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();
    static {
        getAllFileType(); // 初始化文件类型信息
    }
 
    /**
     * 将常见文件类型放入到map中
     */
    private static void getAllFileType() {
        FILE_TYPE_MAP.put("jpg", "FFD8FF"); // JPEG (jpg)
        FILE_TYPE_MAP.put("png", "89504E47"); // PNG (png)
        FILE_TYPE_MAP.put("gif", "47494638"); // GIF (gif)
        FILE_TYPE_MAP.put("tif", "49492A00"); // TIFF (tif)
        FILE_TYPE_MAP.put("bmp", "424D"); // Windows Bitmap (bmp)
        FILE_TYPE_MAP.put("dwg", "41433130"); // CAD (dwg)
        FILE_TYPE_MAP.put("html", "68746D6C3E"); // HTML (html)
        FILE_TYPE_MAP.put("rtf", "7B5C727466"); // Rich Text Format (rtf)
        FILE_TYPE_MAP.put("xml", "3C3F786D6C");
        FILE_TYPE_MAP.put("zip", "504B0304");
        FILE_TYPE_MAP.put("rar", "52617221");
        FILE_TYPE_MAP.put("psd", "38425053"); // Photoshop (psd)
        FILE_TYPE_MAP.put("eml", "44656C69766572792D646174653A"); // Email
        FILE_TYPE_MAP.put("dbx", "CFAD12FEC5FD746F"); // Outlook Express (dbx)
        FILE_TYPE_MAP.put("pst", "2142444E"); // Outlook (pst)
        FILE_TYPE_MAP.put("xls", "D0CF11E0"); // MS Word
        FILE_TYPE_MAP.put("doc", "D0CF11E0"); // MS Excel 注意：word 和 excel的文件头一样
        FILE_TYPE_MAP.put("mdb", "5374616E64617264204A"); // MS Access (mdb)
        FILE_TYPE_MAP.put("wpd", "FF575043"); // WordPerfect (wpd)
        FILE_TYPE_MAP.put("eps", "252150532D41646F6265");
        FILE_TYPE_MAP.put("ps", "252150532D41646F6265");
        FILE_TYPE_MAP.put("pdf", "255044462D312E"); // Adobe Acrobat (pdf)
        FILE_TYPE_MAP.put("qdf", "AC9EBD8F"); // Quicken (qdf)
        FILE_TYPE_MAP.put("pwl", "E3828596"); // Windows Password (pwl)
        FILE_TYPE_MAP.put("wav", "57415645"); // Wave (wav)
        FILE_TYPE_MAP.put("avi", "41564920");
        FILE_TYPE_MAP.put("ram", "2E7261FD"); // Real Audio (ram)
        FILE_TYPE_MAP.put("rm", "2E524D46"); // Real Media (rm)
        FILE_TYPE_MAP.put("mpg", "000001BA"); //   
        FILE_TYPE_MAP.put("mov", "6D6F6F76"); // Quicktime (mov)
        FILE_TYPE_MAP.put("asf", "3026B2758E66CF11"); // Windows Media (asf)
        FILE_TYPE_MAP.put("mid", "4D546864"); // MIDI (mid)
    }
 
    /**
     * 获取文件类型,包括图片,若格式不是已配置的,则返回null
     *
     * @param file
     * @return
     */
    public static String getFileTypeByFile(File file) {
        String filetype = null;
        byte[] b = new byte[50];
        try {
            InputStream is = new FileInputStream(file);
            is.read(b);
            filetype = getFileTypeByStream(b);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filetype;
    }
    
    public static String getFileTypeByFile(MultipartFile file) {
        String filetype = null;
        byte[] b = new byte[50];
        try {
            InputStream is = file.getInputStream();
            is.read(b);
            filetype = getFileTypeByStream(b);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filetype;
    }
 
    /**
     * 通过字节流获得文件类型
     */
    
    public static String getFileTypeByStream(byte[] b) {
        String filetypeHex = String.valueOf(getFileHexString(b));
        Iterator<Entry<String, String>> entryiterator = FILE_TYPE_MAP
                .entrySet().iterator();
        while (entryiterator.hasNext()) {
            Entry<String, String> entry = entryiterator.next();
            String fileTypeHexValue = entry.getValue();
            if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {
                return entry.getKey();
            }
        }
        return null;
    }
 
//  /**
//   * 判断文件是不是图片
//   * @param file
//   * @return
//   */
//  public static final boolean isImage(File file) {
//      boolean flag = false;
//      try {
//          BufferedImage bufreader = ImageIO.read(file);
//          int width = bufreader.getWidth();
//          int height = bufreader.getHeight();
//          if (width == 0 || height == 0) {
//              flag = false;
//          }
//          else {
//              flag = true;
//          }
//      } catch (IOException e) {
//          flag = false;
//      } catch (Exception e) {
//          flag = false;
//      }
//      return flag;
//  }
 
    /**
     * 获得文件的16进制数据
     *
     * @param b
     * @return
     */
    public static String getFileHexString(byte[] b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (b == null || b.length <= 0) {
            return null;
        }
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
     
    /**
     * 删除path（该path可能是文件也可能是文件夹）
     *
     * @param file 要删除的文件或者目录
     * @param includeSubFile 如果被删出的是目录，是否循环删除该目录中的子目录
     * @return 操作是否成功
     */
    public final boolean deleteFile(File file, boolean includeSubFile) {
        if (! file.exists()) {
            return false;
        }
        if (file.isFile()) {
            System.out.println("del file:" + file.toString());
            return file.delete();
        }
        else if (file.isDirectory()) {
             
            File[] fileList = file.listFiles();
            if (includeSubFile) {
                for (int i = 0; i < fileList.length; i++) {
                    deleteFile(fileList[i], includeSubFile);
                }                
            }
            else {
                for (int i = 0; i < fileList.length; i++) {
                    if (fileList[i].isFile()) {
                        deleteFile(fileList[i], includeSubFile);
                    }
                }
            }
        }
        return true;
    }
     
    /**
     * 删除path（该path可能是文件也可能是文件夹）
     *
     * @param path 要删除的文件或者目录
     * @param includeSubFile 如果被删出的是目录，是否循环删除该目录中的子目录
     * @return 操作是否成功
     */
    public final boolean deleteFile(String path, boolean includeSubFile) {
        return deleteFile(new File(path), includeSubFile);
    }
    
	private final boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                deleteDir(new File(dir, children[i]));
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
     
    /**
     * 赋值文件scrFile到目地目录destFolder
     *
     * @param scrFile 源文件，可能是文件，可能是目录
     * @param destFolder 目地文件，只能是目录
     * @param includeSubFile 如果源文件是目录，是否循环复制源文件的子目录
     * @return 操作是否成功
     * @return
     */
    public final boolean copyFile(File scrFile, File destFolder, boolean includeSubFile) {
        //未实现
        return true;
    }
     
    /**
     * 赋值文件scrFile到目地目录destFolder
     *
     * @param scrFile 源文件，可能是文件，可能是目录
     * @param destFolder 目地文件，只能是目录
     * @param includeSubFile 如果源文件是目录，是否循环复制源文件的子目录
     * @return 操作是否成功
     * @return
     */
    public final boolean copyFile(String scrFile, String destFolder, boolean includeSubFile) {
        //未实现
        return copyFile(new File(scrFile), new File(destFolder), includeSubFile);
    }
     
    /**
     * 创建文件或者目录
     * @param file
     * @return
     */
    public final boolean createFile(File file) {
        try {
            if (file.isDirectory()) {
                return file.mkdirs();
            }
            else {
                return file.createNewFile();
            }
        } catch (IOException e) {
            return false;
        }
    }
    /**
     * 创建文件或者目录
     *
     * @param file
     * @return
     */
    public final boolean createFile(String file) {
        return createFile(new File(file));
    }
    
    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @param uploadPath 
     * @param fileregex 文件后缀的正则表达式
     * @param ServletResponse servletResponse 
     * @param BindingResult result
     * @return fileName 上传的文件名
     */
    
	public String UploadFiles(MultipartFile file, String uploadPath,String fileregex,
			ServletResponse servletResponse, BindingResult result)
			throws IOException, IllegalAccessException
	{
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setContentType("text/html");
		ExtJSFormResult extjsFormResult = new ExtJSFormResult();
		String fileName = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		if (file.getOriginalFilename().matches(fileregex))
		{

			String path = FilesUtils.class.getProtectionDomain()
					.getCodeSource().getLocation().getPath();
			if (path.indexOf("WEB-INF") > 0)
			{
				uploadFolderPath = path.substring(0, path.indexOf("WEB-INF"))
						+ uploadPath;
			} else
			{
				throw new IllegalAccessException("路径获取错误");
			}

			if (result.hasErrors())
			{
				for (ObjectError error : result.getAllErrors())
				{
					System.err.println("Error: " + error.getCode() + " - "
							+ error.getDefaultMessage());
				}

				// 设置ExtJS返回 - error
				extjsFormResult.setSuccess(false);
				extjsFormResult.setInfo("路径获取错误！");
				// response.getOutputStream().println(extjsFormResult.toResult());
				response.getWriter().println(extjsFormResult.toResult());
				return null;
			}

			// Some type of file processing...
			if (file != null && file.getSize() > 0)
			{
				inputStream = file.getInputStream();
				if (file.getSize() > 1024*1024*10)
				{
					extjsFormResult.setSuccess(false);
					extjsFormResult.setInfo("文件大于10M！");
					response.getWriter().println(extjsFormResult.toResult());
					return null;
				}
				// System.out.println("size::" + file.getSize());

				File newFile = new File(uploadFolderPath);
				if (!newFile.exists())
				{
					newFile.mkdirs();
				}

				fileName = uploadFolderPath
						+ (new java.text.SimpleDateFormat("yyyyMMddHHmmss"))
								.format(new Date()).toString() + "_"
						+ file.getOriginalFilename();

				outputStream = new FileOutputStream(fileName);
				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
				{
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			} else
			{
				// 设置ExtJS返回 - error
				extjsFormResult.setSuccess(false);
				extjsFormResult.setInfo("上载错误！");
				response.getWriter().println(extjsFormResult.toResult());
				return null;
			}

			// 设置ExtJS返回 - sucsess
			extjsFormResult.setSuccess(true);
			extjsFormResult.setInfo("文件上传成功！");
			response.getWriter().println(extjsFormResult.toResult());
			return fileName;
		} else
		{
			extjsFormResult.setSuccess(false);
			extjsFormResult.setInfo("文件格式错误！");
			response.getWriter().println(extjsFormResult.toResult());
			return null;
		}
	}
	
	// 获取指定目录的文件清单
	public List<FundsSumsVo> getFiles(String filePath) throws Exception
	{
		FilesUtils fileutil = new FilesUtils();
		List<FundsSumsVo> filelist = new ArrayList<FundsSumsVo>();
		File root = new File(filePath);
		File[] files = root.listFiles();
		FileInputStream fis = null;
		String timeformat = "yyyy-MM-dd HH:mm:ss";
		int i=0;
		for (File file : files)
		{
			if (!file.isDirectory())
			{
				i++;
				FundsSumsVo filevo = new FundsSumsVo();
				fis = new FileInputStream(file);
				String fsize = fileutil.FormetFileSize(fis.available());
				Date ftime = fileutil.getFileTimeD(file,timeformat);
				filevo.setId(i);
				filevo.setFilename(file.getName());
				filevo.setFilesize(fsize);
				filevo.setFiletime(ftime);
				filelist.add(filevo);
			}
		}
		PaginationUtils.setTotal(i);
		return filelist;
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
	
	//取得文件创建时间
	public Date getFileTimeD(File f,String format)throws Exception
	{
		SimpleDateFormat sdft = new SimpleDateFormat(format);
		Long time = f.lastModified();
		return sdft.parse(sdft.format(time));
	}
	
	public String getFileTimeS(File f,String format)throws Exception
	{
		SimpleDateFormat sdft = new SimpleDateFormat(format);
		Long time = f.lastModified();
		return sdft.format(time);
	}
	
	//比较文件创建时间
	//0 创建时间=比较时间；-1创建时间早于比较时间；1创建时间晚于比较时间
	public int conpareByTime(File f, Date cdate) throws ParseException
	{
		Date d = sdfc.parse(sdfc.format(f.lastModified()));
		return d.compareTo(cdate);
		
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
	public String FormetFileSize(long fileS)
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
