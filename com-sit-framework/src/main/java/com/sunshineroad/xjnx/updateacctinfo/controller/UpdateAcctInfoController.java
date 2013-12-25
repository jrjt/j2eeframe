package com.sunshineroad.xjnx.updateacctinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.updateacctinfo.service.UpdateAcctInfoService;
import com.sunshineroad.xjnx.updateacctinfo.usercase.UpdateAcctInfoUC;
import com.sunshineroad.xjnx.updateacctinfo.vo.UpdateAcctInfoVo;

/**
 * omplatform
 * com.sunshineroad.xjnx.updateacctinfo.controller
 * @{#} UpdateAcctInfoController.java Create on  2013-7-23 上午9:26:46
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：更新贷款信息
 *
 */
@Controller
@RequestMapping(value = "updateacctinfo")
public class UpdateAcctInfoController
{
	@Autowired
	private UpdateAcctInfoService updateacctservice;

	@Autowired
	private ActionlogService actionlogService;
	
	@Autowired
    private UpdatelogService updatelogService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object list() throws Exception
	{

		HttpServletRequest request = WebUtils.getRequestByContext();
		String rschacctno = request.getParameter("rschacctno");

		UpdateAcctInfoUC updateacctUC = new UpdateAcctInfoUC();
		return updateacctUC.getlist(updateacctservice, rschacctno);

	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody UpdateAcctInfoVo updateacctVo) throws Exception{
		
		UpdateAcctInfoUC updateacctUC = new UpdateAcctInfoUC();
		return updateacctUC.updateacctinfo(updateacctservice, updatelogService, actionlogService, updateacctVo);
	}	
}
