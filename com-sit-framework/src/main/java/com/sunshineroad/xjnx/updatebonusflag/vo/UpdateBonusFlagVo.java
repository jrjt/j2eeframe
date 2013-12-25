package com.sunshineroad.xjnx.updatebonusflag.vo;

import java.math.BigDecimal;


public class UpdateBonusFlagVo {
	
	private BigDecimal id;

	private String acctno;
	
	private BigDecimal year;
	
	private BigDecimal clsamt;
	
	private String flag;
	
	private String originalValue;

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
		this.acctno = acctno.trim();
	}

	public BigDecimal getYear()
	{
		return year;
	}

	public void setYear(BigDecimal year)
	{
		this.year = year;
	}

	public BigDecimal getClsamt()
	{
		return clsamt;
	}

	public void setClsamt(BigDecimal clsamt)
	{
		this.clsamt = clsamt;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag.trim();
	}

	public String getOriginalValue()
	{
		return originalValue;
	}

	public void setOriginalValue(String originalValue)
	{
		this.originalValue = originalValue;
	}

}