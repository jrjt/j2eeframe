package com.sunshineroad.xjnx.openaccounting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.openaccounting.service.OpenAccountingService;
import com.sunshineroad.xjnx.openaccounting.usercase.OpenAccountingUC;

/**
 * omplatform com.sunshineroad.xjnx.assocustom.controller
 * 
 * @{# AssoCustomController.java Create on 2013-7-15 上午9:49:01
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：（中心管理）存贷取数
 * 
 */
@Controller
@RequestMapping(value = "openaccting")
public class OpenAccountingController
{
	@Autowired
	private OpenAccountingService opactservice;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	private UpdatelogService updatelogService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object list() throws Exception
	{

		HttpServletRequest request = WebUtils.getRequestByContext();
		String rschacctno = request.getParameter("rschacctno").trim();

		OpenAccountingUC opactUC = new OpenAccountingUC();
		return opactUC.getlist(opactservice, rschacctno);

	}

	@RequestMapping(value = "openacct", method = RequestMethod.GET)
	public @ResponseBody
	Object openAcct() throws Exception
	{
		HttpServletRequest request = WebUtils.getRequestByContext();
		String acctno = request.getParameter("acctno").trim();
		String acckind = request.getParameter("acckind").trim();
		String accpagetype = request.getParameter("accpagetype").trim();
		String accctrlflag = request.getParameter("accctrlflag").trim();

		OpenAccountingUC openacctUC = new OpenAccountingUC();
		return openacctUC.openAcct(opactservice, updatelogService,
				actionlogService, acctno, acckind, accpagetype, accctrlflag);
	}
	
	@RequestMapping(value = "closeacct", method = RequestMethod.GET)
	public @ResponseBody
	Object closeAcct() throws Exception
	{
		HttpServletRequest request = WebUtils.getRequestByContext();
		String acctno = request.getParameter("acctno").trim();
		String acckind = request.getParameter("acckind").trim();
		String accpagetype = request.getParameter("accpagetype").trim();
		String accctrlflag = request.getParameter("accctrlflag").trim();

		OpenAccountingUC openacctUC = new OpenAccountingUC();
		return openacctUC.closeAcct(opactservice, updatelogService,
				actionlogService, acctno, acckind, accpagetype, accctrlflag);
	}
}
