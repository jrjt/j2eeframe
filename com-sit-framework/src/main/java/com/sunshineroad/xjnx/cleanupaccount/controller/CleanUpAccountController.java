package com.sunshineroad.xjnx.cleanupaccount.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.cleanupaccount.service.CleanUpAccountService;
import com.sunshineroad.xjnx.cleanupaccount.usercase.CleanUpAccountUC;

@Controller
@RequestMapping(value = "cleanupaccounts")
public class CleanUpAccountController {

	@Autowired
	private CleanUpAccountService cleanupaccountService;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	private UpdatelogService updatelogService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object select() throws Exception {
		HttpServletRequest request = WebUtils.getRequestByContext();
		String rschacctno = request.getParameter("rschacctno").trim();
		
		CleanUpAccountUC cleanupaccountUC = new CleanUpAccountUC();
		return cleanupaccountUC.getlist(cleanupaccountService, rschacctno);
	}

	@RequestMapping(value = "cleanup", method = RequestMethod.GET)
	public @ResponseBody
	Object cleanupAcct() throws Exception {
		
		HttpServletRequest request = WebUtils.getRequestByContext();
		String acctno = request.getParameter("acctno").trim();
		
		CleanUpAccountUC cleanupaccountUC = new CleanUpAccountUC();
		return cleanupaccountUC.cleanupAcct(cleanupaccountService, updatelogService,
				actionlogService, acctno);
	}
}
