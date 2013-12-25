package com.sunshineroad.system.fileupload.vo;

/**
 * omplatform
 * com.sunshineroad.system.fileupload.vo
 * @{#} test.java Create on  2013-6-17 上午3:50:14
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadVo {

	private CommonsMultipartFile userfile;

	public CommonsMultipartFile getUserfile()
	{
		return userfile;
	}

	public void setUserfile(CommonsMultipartFile userfile)
	{
		this.userfile = userfile;
	}

}
