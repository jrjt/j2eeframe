package com.sunshineroad.xjnx.fundssums.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.connaddress.service.ConnaddressService;
import com.sunshineroad.xjnx.fundssums.service.FundsSumsService;
import com.sunshineroad.xjnx.fundssums.usercase.FundsSumsUC;

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
@RequestMapping(value = "fundssums")
public class FundsSumsController
{
	@Autowired
	private FundsSumsService fservice;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	protected ConnaddressService connService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object list() throws Exception
	{

		HttpServletRequest request = WebUtils.getRequestByContext();
		String format = "yyyy-MM-dd";
		String researchdt = DateUtils.addDayS(request.getParameter("get_time"), -1, "d", format);
/*		String researchdt = DateUtils.dateFormatS(
				request.getParameter("get_time"), format);*/
		FundsSumsUC fundsUC = new FundsSumsUC();

		return fundsUC.getlist(fservice, connService, researchdt);

	}

	@RequestMapping(value = "commitjob", method = RequestMethod.GET)
	public @ResponseBody
	Object commitJob() throws Exception
	{
		FundsSumsUC fundsUC = new FundsSumsUC();
		return fundsUC.commitjob(connService, actionlogService);
	}

	@RequestMapping(value = "download", method = RequestMethod.GET)
	public @ResponseBody
	Object download() throws Exception
	{
		HttpServletRequest request = WebUtils.getRequestByContext();
		String filename = request.getParameter("filename");

		FundsSumsUC fundsUC = new FundsSumsUC();
		return fundsUC.downfile(connService, fservice, filename);
	}

	@RequestMapping(value = "sendmail", method = RequestMethod.GET)
	public @ResponseBody
	Object sendmail() throws Exception
	{

		HttpServletRequest request = WebUtils.getRequestByContext();
		String filename = request.getParameter("filename");
		
		FundsSumsUC fundsUC = new FundsSumsUC();
		return fundsUC.sendEmail(connService, actionlogService, fservice, filename);
	}
	
	@RequestMapping(value = "updatetrandate", method = RequestMethod.PUT)
	public @ResponseBody
	Object updatetrandate() throws Exception
	{
		String format = "yyyy-MM-dd";
		String Nxtdate = DateUtils.addDayS(new Date(), 1, "d", format);
		
		if(fservice.updateTranDate()<0)
		{
			return ResponseUtils.sendFailure("日切日期更新失败");
		}
		return ResponseUtils.sendSuccess("日切日期更新为【 "+Nxtdate+" 】");
	}
}
