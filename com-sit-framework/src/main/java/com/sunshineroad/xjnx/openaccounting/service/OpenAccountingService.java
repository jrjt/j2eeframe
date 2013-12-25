package com.sunshineroad.xjnx.openaccounting.service;

import java.math.BigDecimal;
import java.util.List;

import com.sunshineroad.xjnx.openaccounting.vo.CountAcctVo;
import com.sunshineroad.xjnx.openaccounting.vo.OpenAccountingVo;

/**
 * omplatform com.sunshineroad.xjnx.openaccounting.service
 * 
 * @{# OpenAccountingService.java Create on 2013-7-19 上午8:56:05
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：
 * 
 */
public interface OpenAccountingService
{
	public List<OpenAccountingVo> getList(String acctno) throws Exception;

	public List<CountAcctVo> countAcct(String subctrlcode, BigDecimal seqno)
			throws Exception;

	public int OpenAccting(String acctno, String acckind, String accpagetype,
			String accctrlflag) throws Exception;

	public int CloseAccting(String acctno, String old_accctrlflag,
			String old_acckind, String old_accpagetype) throws Exception;
}
