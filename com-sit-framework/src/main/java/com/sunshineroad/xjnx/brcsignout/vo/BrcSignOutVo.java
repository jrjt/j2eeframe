package com.sunshineroad.xjnx.brcsignout.vo;

import java.math.BigDecimal;



public class BrcSignOutVo {
	
	private BigDecimal id;

	private String brccode;
	
	private String brcname;	

	private String phone;
	
	private Character status;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getBrccode() {
		return brccode;
	}

	public void setBrccode(String brccode) {
		this.brccode = brccode;
	}

	public String getBrcname() {
		return brcname;
	}

	public void setBrcname(String brcname) {
		this.brcname = brcname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

}