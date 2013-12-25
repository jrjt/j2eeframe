package com.sunshineroad.xjnx.cleanupaccount.usercase;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.cleanupaccount.service.CleanUpAccountService;
import com.sunshineroad.xjnx.cleanupaccount.vo.CleanUpAccountVo;

/**
 * omplatform com.sunshineroad.xjnx.fundssums.usercase
 * 
 * @{# FundsSumsUC.java Create on 2013-8-7 上午8:45:31
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0 功能说明：清除股金关联结算账号user case
 * 
 */

public class CleanUpAccountUC
{
	private static final Logger logger = Logger
			.getLogger(CleanUpAccountUC.class);

	private String actDesc = "清除股金关联结算账号";

	public Object getlist(CleanUpAccountService cleanupaccountService,
			String acctno) throws Exception
	{
		List<CleanUpAccountVo> getlist = cleanupaccountService.getList(acctno);

		if (getlist.size() <= 0)
		{
			return ResponseUtils.sendFailure("无此账号信息，请确认账号是否正确");
		}

		return ResponseUtils.sendPagination(getlist);
	}

	public Object cleanupAcct(CleanUpAccountService cleanupaccountService,
			UpdatelogService updatelogService,
			ActionlogService actionlogService, String acctno) throws Exception
	{
		String chkmessage = "记录已被修改，请查询确认后在作修改";
		List<CleanUpAccountVo> recordchk = cleanupaccountService.getList(acctno);
		if(!StringUtils.isNotBlank(recordchk.get(0).getStlacctno()))
		{
			return ResponseUtils.sendFailure(chkmessage);
		}
		
		int account = cleanupaccountService.CleanUpAcct(acctno);
		if (account > 0)
		{
			// save action log
			actionlogService.saveAlog(null, actDesc, true, "");

			// save update log
			String table = "xjbank.glsinbalacctinfo";
			String keys = "acctno";
			String keyvalues = acctno;
			String columns = "stlacctno";
			String oldvalue = recordchk.get(0).getStlacctno();
			String newvalue = "";
			
			Updatelog ulog = new Updatelog();
			ulog.setAction(actDesc);
			ulog.setTable_name(table);
			ulog.setKeys(keys);
			ulog.setKey_value(keyvalues);
			ulog.setColumns(columns);
			ulog.setOld_value(oldvalue);
			ulog.setNew_value(newvalue);
			ulog.setFlag("O");

			updatelogService.saveUlog(ulog);
			return ResponseUtils.sendSuccess("清除股金关联结算账号成功");
		}
		
		actionlogService.saveAlog(null, actDesc, false, "清除股金关联结算账号失败");
		return ResponseUtils.sendFailure("清除股金关联结算账号失败");

	}
}
