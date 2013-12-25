package com.sunshineroad.xjnx.tellersignout.vo;

import java.math.BigDecimal;

/**
 * 
 * omplatform
 * com.sunshineroad.xjnx.tellersignout.vo
 * @{#} TellerSignOutVo.java Create on  2013-7-25 下午12:33:39
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）柜员签退  vo
 *
 */
public class TellerSignOutVo {
	
	private BigDecimal id;

	private String brccode;
	
	private String tellercode;	

	private String tellername;
	
	private String status;
	
	private Character workstate;
	
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getTellercode() {
		return tellercode;
	}

	public void setTellercode(String tellercode) {
		this.tellercode = tellercode;
	}

	public String getTellername() {
		return tellername;
	}

	public void setTellername(String tellername) {
		this.tellername = tellername;
	}

	public String getBrccode() {
		return brccode;
	}

	public void setBrccode(String brccode) {
		this.brccode = brccode;
	}

	public Character getWorkstate() {
		return workstate;
	}

	public void setWorkstate(Character workstate) {
		this.workstate = workstate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}