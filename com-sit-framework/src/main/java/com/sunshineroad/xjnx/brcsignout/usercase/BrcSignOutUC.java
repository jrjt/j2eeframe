package com.sunshineroad.xjnx.brcsignout.usercase;

import java.util.List;

import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.brcsignout.service.BrcSignOutService;
import com.sunshineroad.xjnx.brcsignout.vo.BrcSignOutVo;

/**
 * 
 * omplatform
 * com.sunshineroad.xjnx.brcsignout.usercase
 * @{#} BrcSignOutUC.java Create on  2013-7-23 下午5:29:48
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）机构签退  user case
 *
 */
public class BrcSignOutUC
{
	private static final Logger logger = Logger.getLogger(BrcSignOutUC.class);

	public Object getlist(BrcSignOutService brcsoservice,BrcSignOutVo brcvo) throws Exception
	{
		List<BrcSignOutVo> getlist = brcsoservice.getList(brcvo);
		return ResponseUtils.sendPagination(getlist);
	}

	public Object signout(BrcSignOutService brcsoservice,UpdatelogService updatelogService,
			ActionlogService actionlogService, BrcSignOutVo brcvo) throws Exception
	{
		String actDesc = "机构签退";
		
		brcsoservice.brcSignOut(brcvo);

		Updatelog ulog = new Updatelog();
		ulog.setAction(actDesc);
		ulog.setTable_name("xjbank.pubbranchinfo");
		ulog.setKeys("tellercode");
		ulog.setKey_value(brcvo.getBrccode());
		ulog.setColumns("status");
		ulog.setOld_value(brcvo.getStatus().toString());
		ulog.setNew_value("4");
		
		updatelogService.saveUlog(ulog);
		actionlogService.saveAlog(null, actDesc, true, "");
		
		return ResponseUtils.sendSuccess("签退成功");
	}

}
