package com.sunshineroad.xjnx.brcsignout.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.brcsignout.service.BrcSignOutService;
import com.sunshineroad.xjnx.brcsignout.usercase.BrcSignOutUC;
import com.sunshineroad.xjnx.brcsignout.vo.BrcSignOutVo;

/**
 * 
 * omplatform
 * com.sunshineroad.xjnx.brcsignout.controller
 * @{#} BrcSignOutController.java Create on  2013-7-23 下午5:14:23
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）机构签退 controller
 *
 */
@Controller
@RequestMapping(value="brcsignouts")
public class BrcSignOutController {

	@Autowired
	private BrcSignOutService brcsoService;
	
	@Autowired
	private ActionlogService actionlogService;
	
	@Autowired
    private UpdatelogService updatelogService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list()throws Exception{
		HttpServletRequest request =WebUtils.getRequestByContext();
		BrcSignOutVo brcvo = new BrcSignOutVo();
		brcvo.setBrccode(request.getParameter("brccode"));
		String status =request.getParameter("status");
		
		if(StringUtils.isNotBlank(status)){
			brcvo.setStatus(status.charAt(0));
		}
		BrcSignOutUC brcsoUC = new BrcSignOutUC();
		return brcsoUC.getlist(brcsoService, brcvo);
	}

	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object signout(@RequestBody BrcSignOutVo brcvo) throws Exception{
		BrcSignOutUC brcsoUC = new BrcSignOutUC();
		return brcsoUC.signout(brcsoService, updatelogService, actionlogService,brcvo);
	}	
}
