package com.sunshineroad.xjnx.openaccounting.vo;

import java.math.BigDecimal;

/**
 * omplatform
 * com.sunshineroad.xjnx.openaccounting.vo
 * @{#} OpenAccountingVo.java Create on  2013-7-19 上午8:48:40
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
public class OpenAccountingVo
{
	private BigDecimal id;
	
	private String acctno;
	
	private Character acckind;
	
	private Character accpagetype;
	
	private Character accctrlflag;
	
	private String subctrlcode;
	
	private BigDecimal seqno;

	public BigDecimal getId()
	{
		return id;
	}

	public void setId(BigDecimal id)
	{
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

	public Character getAcckind()
	{
		return acckind;
	}

	public void setAcckind(Character acckind)
	{
		this.acckind = acckind;
	}

	public Character getAccpagetype()
	{
		return accpagetype;
	}

	public void setAccpagetype(Character accpagetype)
	{
		this.accpagetype = accpagetype;
	}

	public Character getAccctrlflag()
	{
		return accctrlflag;
	}

	public void setAccctrlflag(Character accctrlflag)
	{
		this.accctrlflag = accctrlflag;
	}

	public String getSubctrlcode()
	{
		return subctrlcode;
	}

	public void setSubctrlcode(String subctrlcode)
	{
		this.subctrlcode = subctrlcode;
	}

	public BigDecimal getSeqno()
	{
		return seqno;
	}

	public void setSeqno(BigDecimal seqno)
	{
		this.seqno = seqno;
	}

}
