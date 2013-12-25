package com.sunshineroad.xjnx.updateacctinfo.vo;

import java.math.BigDecimal;

/**
 * omplatform
 * com.sunshineroad.xjnx.openaccounting.vo
 * @{#} OpenAccountingVo.java Create on  2013-7-23 上午8:48:40
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
public class UpdateAcctInfoVo
{
	private BigDecimal id;
	
	private String acctno;
	
	private String opendate;
	
	private String diacct;
	
	private String dbacct;
	
	private String discountflag;
	
	private String noaccrualflag;
	
	private String currduedate;
	
	private Character loantype1;
	
	private String loanstat;
	
	private BigDecimal intrestres1;
	
	private boolean opendatechged;
	
	private boolean diacctchged;
	
	private boolean dbacctchged;
	
	private boolean discountflagchged;
	
	private boolean noaccrualflagchged;
	
	private boolean currduedatechged;
	
	private boolean loantype1chged;
	
	private boolean loanstatchged;
	
	private boolean intrestres1chged;
	
	private String originalValue;
	
	private String authteller;
	
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
		this.acctno = acctno.trim();
	}

	public String getOpendate()
	{
		return opendate;
	}

	public void setOpendate(String opendate)
	{
		this.opendate = opendate;
	}

	public String getDiacct()
	{
		return diacct;
	}

	public void setDiacct(String diacct)
	{
		this.diacct = diacct.trim();
	}

	public String getDbacct()
	{
		return dbacct;
	}

	public void setDbacct(String dbacct)
	{
		this.dbacct = dbacct.trim();
	}

	public String getDiscountflag()
	{
		return discountflag;
	}

	public void setDiscountflag(String discountflag)
	{
		this.discountflag = discountflag;
	}

	public String getNoaccrualflag()
	{
		return noaccrualflag;
	}

	public void setNoaccrualflag(String noaccrualflag)
	{
		this.noaccrualflag = noaccrualflag;
	}

	public String getCurrduedate()
	{
		return currduedate;
	}

	public void setCurrduedate(String currduedate)
	{
		this.currduedate = currduedate;
	}

	public Character getLoantype1()
	{
		return loantype1;
	}

	public void setLoantype1(Character loantype1)
	{
		this.loantype1 = loantype1;
	}

	public String getLoanstat()
	{
		return loanstat;
	}

	public void setLoanstat(String loanstat)
	{
		this.loanstat = loanstat;
	}

	public BigDecimal getIntrestres1()
	{
		return intrestres1;
	}

	public void setIntrestres1(BigDecimal intrestres1)
	{
		this.intrestres1 = intrestres1;
	}

	public boolean isOpendatechged()
	{
		return opendatechged;
	}

	public void setOpendatechged(boolean opendatechged)
	{
		this.opendatechged = opendatechged;
	}

	public boolean isDiacctchged()
	{
		return diacctchged;
	}

	public void setDiacctchged(boolean diacctchged)
	{
		this.diacctchged = diacctchged;
	}

	public boolean isDbacctchged()
	{
		return dbacctchged;
	}

	public void setDbacctchged(boolean dbacctchged)
	{
		this.dbacctchged = dbacctchged;
	}

	public boolean isDiscountflagchged()
	{
		return discountflagchged;
	}

	public void setDiscountflagchged(boolean discountflagchged)
	{
		this.discountflagchged = discountflagchged;
	}

	public boolean isNoaccrualflagchged()
	{
		return noaccrualflagchged;
	}

	public void setNoaccrualflagchged(boolean noaccrualflagchged)
	{
		this.noaccrualflagchged = noaccrualflagchged;
	}

	public boolean isCurrduedatechged()
	{
		return currduedatechged;
	}

	public void setCurrduedatechged(boolean currduedatechged)
	{
		this.currduedatechged = currduedatechged;
	}

	public boolean isLoantype1chged()
	{
		return loantype1chged;
	}

	public void setLoantype1chged(boolean loantype1chged)
	{
		this.loantype1chged = loantype1chged;
	}

	public boolean isLoanstatchged()
	{
		return loanstatchged;
	}

	public void setLoanstatchged(boolean loanstatchged)
	{
		this.loanstatchged = loanstatchged;
	}

	public boolean isIntrestres1chged()
	{
		return intrestres1chged;
	}

	public void setIntrestres1chged(boolean intrestres1chged)
	{
		this.intrestres1chged = intrestres1chged;
	}

	public String getOriginalValue()
	{
		return originalValue;
	}

	public void setOriginalValue(String originalValue)
	{
		this.originalValue = originalValue;
	}

	public String getAuthteller()
	{
		return authteller;
	}

	public void setAuthteller(String authteller)
	{
		this.authteller = authteller;
	}

}
