package com.sunshineroad.system.fileupload.controller;

/**
 * omplatform
 * com.sunshineroad.system.fileupload.vo
 * @{#} test.java Create on  2013-6-17 上午3:50:14
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：文件上传
 *
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ExcelSheetParser;
import com.sunshineroad.framework.util.FilesUtils;
import com.sunshineroad.system.fileupload.vo.FileUploadVo;

@Controller
@RequestMapping(value = "fileupload")
public class FileUploadController
{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "connconfig", method = RequestMethod.POST)
	public @ResponseBody
	void create(FileUploadVo uploadItem, BindingResult result,
			ServletResponse servletResponse) throws IOException,
			IllegalAccessException
	{
		FilesUtils filesutils = new FilesUtils();
		// 上传路径
		String uploadPath = "upload/";
		// 允许的文件类型
		String fileregex = "^.+\\.(?i)((xls)|(xlsx))$";
		String filename = filesutils.UploadFiles(uploadItem.getUserfile(),
				uploadPath, fileregex, servletResponse, result);
		if (filename != null)
		{
			System.out.println(filename);
			List<List> datas;
			ExcelSheetParser parser = new ExcelSheetParser(filename);
			boolean isExcel2003 = true;
			/** 对文件的合法性进行验证 */
			if (filename.matches("^.+\\.(?i)(xlsx)$"))
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
			System.out.println("rows account : " + datas.size());
			
			//读取完成后删除文件
			filesutils.deleteFile(filename, true);
		} else
		{
			System.out.println("Fault");
		}
	}

}
