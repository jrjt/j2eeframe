package com.sunshineroad.xjnx.fundssums.vo;

import java.util.Date;



public class FundsSumsVo {

	private Integer id;
		
	private String filename;
	
	private Date filetime;	
	
	private String filesize;
	
	private String trandate;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public Date getFiletime()
	{
		return filetime;
	}

	public void setFiletime(Date filetime)
	{
		this.filetime = filetime;
	}

	public String getFilesize()
	{
		return filesize;
	}

	public void setFilesize(String filesize)
	{
		this.filesize = filesize;
	}

	public String getTrandate()
	{
		return trandate;
	}

	public void setTrandate(String trandate)
	{
		this.trandate = trandate;
	}

}