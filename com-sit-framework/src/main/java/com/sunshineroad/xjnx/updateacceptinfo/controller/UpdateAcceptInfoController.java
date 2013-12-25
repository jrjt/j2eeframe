package com.sunshineroad.xjnx.updateacceptinfo.controller;

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
import com.sunshineroad.xjnx.updateacceptinfo.service.UpdateAcceptInfoService;
import com.sunshineroad.xjnx.updateacceptinfo.usercase.UpdateAcceptInfoUC;
import com.sunshineroad.xjnx.updateacceptinfo.vo.UpdateAcceptInfoVo;

@Controller
@RequestMapping(value = "updateacceptinfos")
public class UpdateAcceptInfoController {

	@Autowired
	private UpdateAcceptInfoService updateacceptinfoService;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	private UpdatelogService updatelogService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object select() throws Exception {
		HttpServletRequest request = WebUtils.getRequestByContext();
		UpdateAcceptInfoUC updateacceptinfoUC = new UpdateAcceptInfoUC();
		
		return null;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Object update(@RequestBody UpdateAcceptInfoVo updateacceptinfoVo) throws Exception {
		UpdateAcceptInfoUC updateacceptinfoUC = new UpdateAcceptInfoUC();

		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Object insert(@RequestBody UpdateAcceptInfoVo updateacceptinfoVo) throws Exception {
		UpdateAcceptInfoUC updateacceptinfoUC = new UpdateAcceptInfoUC();

		return null;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Object delete(@RequestBody UpdateAcceptInfoVo updateacceptinfoVo) throws Exception {
		UpdateAcceptInfoUC updateacceptinfoUC = new UpdateAcceptInfoUC();

		return null;
	}
}
