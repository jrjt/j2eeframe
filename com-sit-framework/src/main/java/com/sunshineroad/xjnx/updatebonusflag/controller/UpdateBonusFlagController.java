package com.sunshineroad.xjnx.updatebonusflag.controller;

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
import com.sunshineroad.xjnx.cleanupaccount.usercase.CleanUpAccountUC;
import com.sunshineroad.xjnx.updatebonusflag.service.UpdateBonusFlagService;
import com.sunshineroad.xjnx.updatebonusflag.usercase.UpdateBonusFlagUC;
import com.sunshineroad.xjnx.updatebonusflag.vo.UpdateBonusFlagVo;

@Controller
@RequestMapping(value = "updatebonusflags")
public class UpdateBonusFlagController {

	@Autowired
	private UpdateBonusFlagService updatebonusflagService;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	private UpdatelogService updatelogService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object select() throws Exception {
		HttpServletRequest request = WebUtils.getRequestByContext();
		String rschacctno = request.getParameter("rschacctno").trim();
		
		UpdateBonusFlagUC updatebonusflagUC = new UpdateBonusFlagUC();
		return updatebonusflagUC.getlist(updatebonusflagService, rschacctno);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Object update(@RequestBody UpdateBonusFlagVo updatebonusflagVo) throws Exception {

		UpdateBonusFlagUC updatebonusflagUC = new UpdateBonusFlagUC();
		return updatebonusflagUC.updatflag(updatebonusflagService, updatelogService, actionlogService, updatebonusflagVo);
	}
}
