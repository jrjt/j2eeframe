package com.sunshineroad.xjnx.tellersignout.controller;


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
import com.sunshineroad.xjnx.tellersignout.service.TellerSignOutService;
import com.sunshineroad.xjnx.tellersignout.usercase.TellerSignOutUC;
import com.sunshineroad.xjnx.tellersignout.vo.TellerSignOutVo;

/**
 * 
 * omplatform
 * com.sunshineroad.xjnx.tellersignout.controller
 * @{#} TellerSignOutController.java Create on  2013-7-24 下午7:17:29
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）柜员签退 controller
 *
 */
@Controller
@RequestMapping(value="tellersignouts")
public class TellerSignOutController {

	@Autowired
	private TellerSignOutService tellersoService;
	
	@Autowired
	private ActionlogService actionlogService;
	
	@Autowired
    private UpdatelogService updatelogService;
	
	private final static String ACTION_SIGNOUT = "signout";
	
	private final static String ACTION_RESET = "reset"; 
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list()throws Exception{
		HttpServletRequest request =WebUtils.getRequestByContext();
		TellerSignOutVo tellervo = new TellerSignOutVo();
		tellervo.setTellercode(request.getParameter("tellercode"));
		String workstate =request.getParameter("workstate");
		
		if(StringUtils.isNotBlank(workstate)){
			tellervo.setWorkstate(workstate.charAt(0));
		}
		TellerSignOutUC brcsoUC = new TellerSignOutUC();
		return brcsoUC.getlist(tellersoService, tellervo);
	}

	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object save(@RequestBody TellerSignOutVo tellervo) throws Exception{
		TellerSignOutUC tellerUC = new TellerSignOutUC();
		String action = tellervo.getAction();
		Object result = null;
		
		if(action.equalsIgnoreCase(ACTION_SIGNOUT)){
			result = tellerUC.signout(tellersoService, updatelogService, actionlogService,tellervo);
		}else if(action.equalsIgnoreCase(ACTION_RESET)){
			result = tellerUC.reset(tellersoService, updatelogService, actionlogService,tellervo);
		}
		
		return result;
	}	
}
