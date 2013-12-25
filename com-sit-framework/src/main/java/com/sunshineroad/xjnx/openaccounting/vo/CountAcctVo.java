package com.sunshineroad.xjnx.openaccounting.vo;

import java.math.BigDecimal;

/**
 * omplatform
 * com.sunshineroad.xjnx.openaccounting.vo
 * @{#} CountAcctVo.java Create on  2013-8-5 上午8:52:07
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
public class CountAcctVo
{
	private Character acckind;
	
	private Character accpagetype;
	
	private BigDecimal account;

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

	public BigDecimal getAccount()
	{
		return account;
	}

	public void setAccount(BigDecimal account)
	{
		this.account = account;
	}
	
	
}
