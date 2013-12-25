package com.sunshineroad.xjnx.cleanupaccount.vo;

import java.math.BigDecimal;


public class CleanUpAccountVo {
	
	private BigDecimal id;

	private String acctno;
	
	private String custname;
	
	private String stlacctno;
	
	private String stat;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getAcctno()
	{
		return acctno;
	}

	public void setAcctno(String acctno)
	{
		this.acctno = acctno;
	}

	public String getCustname()
	{
		return custname;
	}

	public void setCustname(String custname)
	{
		this.custname = custname;
	}

	public String getStlacctno()
	{
		return stlacctno;
	}

	public void setStlacctno(String stlacctno)
	{
		this.stlacctno = stlacctno;
	}

	public String getStat()
	{
		return stat;
	}

	public void setStat(String stat)
	{
		this.stat = stat;
	}

}