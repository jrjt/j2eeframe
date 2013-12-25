package com.sunshineroad.xjnx.updateacctinfo.service;

import java.util.List;

import com.sunshineroad.xjnx.updateacctinfo.vo.UpdateAcctInfoVo;

/**
 * omplatform
 * com.sunshineroad.xjnx.updateacctinfo.service
 * @{#} UpdateAcctInfoService.java Create on  2013-7-23 上午9:07:25
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
public interface UpdateAcctInfoService
{
	public List<UpdateAcctInfoVo> getList(String acctno) throws Exception;
	
	public int updateacctinfo(UpdateAcctInfoVo updateacctVo) throws Exception;
}
