package com.sunshineroad.xjnx.branchsms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.sunshineroad.xjnx.assocustom.vo.AssoCustomVo;
import com.sunshineroad.xjnx.branchsms.service.BranchsMSService;
import com.sunshineroad.xjnx.branchsms.usercase.BranchsMSUC;
import com.sunshineroad.xjnx.branchsms.vo.BranchsMSVo;

@Controller
@RequestMapping(value = "branchsms")
public class BranchsMSController {

	@Autowired
	private BranchsMSService branchsmsService;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	private UpdatelogService updatelogService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object select() throws Exception {
		HttpServletRequest request = WebUtils.getRequestByContext();
		BranchsMSUC branchsmsUC = new BranchsMSUC();
		
		BranchsMSVo brcmsVo = new BranchsMSVo();
		String ACTION = request.getParameter("action");
		
		if(StringUtils.isNotBlank(ACTION)&&ACTION.equalsIgnoreCase("splitlist")){
			brcmsVo.setProbrc(request.getParameter("probrc"));
			brcmsVo.setOppbrc(request.getParameter("oppbrc"));
			return branchsmsUC.getsplitlist(branchsmsService, brcmsVo);
		}

		if(StringUtils.isNotBlank(request.getParameter("prodate"))){
			brcmsVo.setProdate(request.getParameter("prodate").substring(0, 10));
		}
		brcmsVo.setProbrc(request.getParameter("probrc"));
		
		if(StringUtils.isNotBlank(request.getParameter("promode"))){
			brcmsVo.setPromode(request.getParameter("promode").charAt(0));
		}
		
		return branchsmsUC.getlist(branchsmsService, brcmsVo);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Object update(@RequestBody BranchsMSVo branchsmsVo) throws Exception {
		BranchsMSUC branchsmsUC = new BranchsMSUC();

		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Object save() throws Exception {
		HttpServletRequest request = WebUtils.getRequestByContext();
		BranchsMSUC branchsmsUC = new BranchsMSUC();
		List<BranchsMSVo> splitlist = new ArrayList<BranchsMSVo>();
		BranchsMSVo pubVo = new BranchsMSVo();
		
		if(StringUtils.isNotBlank(request.getParameter("prodate"))){
			pubVo.setProdate(request.getParameter("prodate").substring(0, 10));
		}
		pubVo.setProbrc(request.getParameter("probrc"));
		pubVo.setPromode(request.getParameter("promode").charAt(0));
		//pubVo.setSplitseq(Integer.valueOf(request.getParameter("splitseq")));
		pubVo.setSplitseq(1);
		pubVo.setOppbrc(request.getParameter("oppbrc"));
		if(StringUtils.isNotBlank(request.getParameter("modidate"))){
			pubVo.setModidate(request.getParameter("modidate").substring(0, 10));
		}
		//pubVo.setTeller(request.getParameter("teller"));
		pubVo.setTeller("zzzz");
		//pubVo.setProflag(request.getParameter("proflag"));
		pubVo.setProflag('0');
		
		if(pubVo.getPromode().toString().equalsIgnoreCase("2")){
			String strJson=request.getParameter("strJson");
			JSONArray js=JSONArray.fromObject(strJson);
			JSONObject jo=null;
			Iterator<?> it=js.iterator();
			while(it.hasNext()){
				BranchsMSVo temp = new BranchsMSVo();
			     jo=(JSONObject)it.next();
			     temp.setSplitflag(jo.getString("splitflag").charAt(0));
			     temp.setSubsys(jo.getString("subsys"));
			     temp.setSubctrlcode(jo.getString("subctrlcode"));
			     temp.setAcctno(jo.getString("acctno"));
			     splitlist.add(temp);
			}
		}
		return branchsmsUC.saveApply(branchsmsService, updatelogService, 
				actionlogService, pubVo, splitlist);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Object delete(@RequestBody BranchsMSVo branchsmsVo) throws Exception {
		BranchsMSUC branchsmsUC = new BranchsMSUC();

		return null;
	}
}
