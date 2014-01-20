package com.sunshineroad.driverschool.cscustomerinfo.controller;
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

import com.sunshineroad.driverschool.cscustomerinfo.entity.CsCustomerInfo;
import com.sunshineroad.driverschool.cscustomerinfo.entityvo.CsCustomerInfoVo;
import com.sunshineroad.driverschool.cscustomerinfo.service.CsCustomerInfoService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 客户信息
 * @author auto Generate
 * @date 2014-01-17 11:42:58
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="csCustomerInfo")
public class CsCustomerInfoController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CsCustomerInfoController.class);

	public CsCustomerInfoController(){		
	}

	@Autowired
	private CsCustomerInfoService csCustomerInfoService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		CsCustomerInfo csCustomerInfo= new CsCustomerInfo();
  
		return ResponseUtils.sendPagination(csCustomerInfoService.list(csCustomerInfo)) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody CsCustomerInfoVo csCustomerInfoVo) throws Exception{
		CsCustomerInfo csCustomerInfo =new CsCustomerInfo();
		PropertyUtils.copyProperties(csCustomerInfo, csCustomerInfoVo);
		this.csCustomerInfoService.update(csCustomerInfo);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody CsCustomerInfoVo csCustomerInfoVo) throws Exception{
		CsCustomerInfo csCustomerInfo =new CsCustomerInfo();
		PropertyUtils.copyProperties(csCustomerInfo, csCustomerInfoVo);
		return ResponseUtils.sendSuccess("保存成功",this.csCustomerInfoService.save(csCustomerInfo).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody CsCustomerInfo csCustomerInfo) throws Exception{
		this.csCustomerInfoService.delete(csCustomerInfo);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
