package com.sunshineroad.driverschool.cscontractinfo.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunshineroad.framework.support.service.IBaseService;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils; 

import com.sunshineroad.driverschool.cscontractinfo.entity.CsContractInfo;
import com.sunshineroad.driverschool.cscontractinfo.entityvo.CsContractInfoVo;
import com.sunshineroad.driverschool.cscontractinfo.service.CsContractInfoService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 合同
 * @author auto Generate
 * @date 2014-01-08 18:26:03
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="csContractInfo")
public class CsContractInfoController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CsContractInfoController.class);

	public CsContractInfoController(){		
	}

	@Autowired
	private CsContractInfoService csContractInfoService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		CsContractInfo csContractInfo= new CsContractInfo();
  
		return ResponseUtils.sendPagination(csContractInfoService.list(csContractInfo)) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody CsContractInfoVo csContractInfoVo) throws Exception{
		CsContractInfo csContractInfo =new CsContractInfo();
		PropertyUtils.copyProperties(csContractInfo, csContractInfoVo);
		this.csContractInfoService.update(csContractInfo);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody CsContractInfoVo csContractInfoVo) throws Exception{
		CsContractInfo csContractInfo =new CsContractInfo();
		PropertyUtils.copyProperties(csContractInfo, csContractInfoVo);
		return ResponseUtils.sendSuccess("保存成功",this.csContractInfoService.save(csContractInfo).getId());
	}
	
	@RequestMapping(value="{destroy/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody CsContractInfo csContractInfo) throws Exception{
		this.csContractInfoService.delete(csContractInfo);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
