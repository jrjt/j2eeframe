package com.sunshineroad.xjnx.tellersignout.usercase;

import java.util.List;

import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.tellersignout.service.TellerSignOutService;
import com.sunshineroad.xjnx.tellersignout.vo.TellerSignOutVo;

/**
 * 
 * omplatform
 * com.sunshineroad.xjnx.tellersignout.usercase
 * @{#} TellerSignOutUC.java Create on  2013-7-25 下午12:33:07
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）柜员签退 user case
 *
 */
public class TellerSignOutUC
{
	private static final Logger logger = Logger.getLogger(TellerSignOutUC.class);

	public Object getlist(TellerSignOutService tellersoservice,TellerSignOutVo tellervo) throws Exception
	{
		List<TellerSignOutVo> getlist = tellersoservice.getList(tellervo);

		return ResponseUtils.sendPagination(getlist);
	}

	public Object signout(TellerSignOutService tellersoservice,UpdatelogService updatelogService,
			ActionlogService actionlogService, TellerSignOutVo tellervo) throws Exception
	{
		String actDesc = "柜员签退";
		
		tellersoservice.tellerSignOut(tellervo);
		
		Updatelog ulog = new Updatelog();
		ulog.setAction(actDesc);
		ulog.setTable_name("xjbank.tlstellerinfo");
		ulog.setKeys("tellercode");
		ulog.setKey_value(tellervo.getTellercode());
		ulog.setColumns("workstate");
		ulog.setOld_value(tellervo.getWorkstate().toString());
		ulog.setNew_value("5");
		
		updatelogService.saveUlog(ulog);
		actionlogService.saveAlog(null, actDesc, true, "");
		
		return ResponseUtils.sendSuccess("签退成功");
	}
	
	public Object reset(TellerSignOutService tellersoservice,UpdatelogService updatelogService,
			ActionlogService actionlogService, TellerSignOutVo tellervo) throws Exception
	{
		String actDesc = "柜员重置";
	
		tellersoservice.tellerReset(tellervo);
		
		Updatelog ulog = new Updatelog();
		ulog.setAction(actDesc);
		ulog.setTable_name("xjbank.tlstellerinfo");
		ulog.setKeys("tellercode");
		ulog.setKey_value(tellervo.getTellercode());
		ulog.setColumns("status");
		ulog.setOld_value(tellervo.getStatus());
		ulog.setNew_value(tellervo.getStatus().substring(0, 1)+
				"0"+tellervo.getStatus().substring(2));
		
		updatelogService.saveUlog(ulog);
		actionlogService.saveAlog(null, actDesc, true, "");
		
		return ResponseUtils.sendSuccess("重置成功");
	}

}
