package com.sunshineroad.xjnx.cleanupaccount.service;

import java.util.List;

import com.sunshineroad.xjnx.cleanupaccount.vo.CleanUpAccountVo;

public interface CleanUpAccountService {

	public List<CleanUpAccountVo> getList(String acctno) throws Exception;
	
	public int CleanUpAcct(String acctno) throws Exception;


}
