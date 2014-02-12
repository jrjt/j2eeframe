package com.sunshineroad.driverschool.cscustomerinfo.controller;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.driverschool.cscustomerinfo.entity.CsCustomerInfo;
import com.sunshineroad.driverschool.cscustomerinfo.entityvo.CsCustomerInfoVo;
import com.sunshineroad.driverschool.cscustomerinfo.service.CsCustomerInfoService;
import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils;
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
//	private static final Logger logger = Logger.getLogger(CsCustomerInfoController.class);

	public CsCustomerInfoController(){		
	}

	@Autowired
	private CsCustomerInfoService csCustomerInfoService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		CsCustomerInfoVo csCustomerInfoVo = new CsCustomerInfoVo();
		
		// 接受查询参数
		String paramsArea = request.getParameter("paramsArea");
		String paramsCustomerName = request.getParameter("paramsCustomerName");
		String paramsCustomerType = request.getParameter("paramsCustomerType");
		String paramsCustomerPeople = request.getParameter("paramsCustomerPeople");
		
		if (null!=paramsArea) {
			byte b[];
			try {
				b = paramsArea.getBytes("GBK"); 
				paramsArea = new String(b);
				
				b = paramsCustomerName.getBytes("GBK");
				paramsCustomerName = new String(b);
				
				b = paramsCustomerType.getBytes("GBK"); 
				paramsCustomerType = new String(b);
				
				b = paramsCustomerPeople.getBytes("GBK"); 
				paramsCustomerPeople = new String(b);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				paramsArea = null;
				paramsCustomerPeople = null;
				paramsCustomerName = null;
				paramsCustomerType = null;
			}
			if (null!=paramsArea) {
				csCustomerInfoVo.setArea(paramsArea);
				csCustomerInfoVo.setCustomerName(paramsCustomerName);
				csCustomerInfoVo.setCustomerType(paramsCustomerType);
				csCustomerInfoVo.setCustomerPeople(paramsCustomerPeople);
			}
		}
		
		return ResponseUtils.sendPagination(csCustomerInfoService.list(csCustomerInfoVo)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody CsCustomerInfoVo csCustomerInfoVo) throws Exception{
		CsCustomerInfo csCustomerInfo =new CsCustomerInfo();
		csCustomerInfo.setId(csCustomerInfoVo.getId());
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
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody CsCustomerInfoVo csCustomerInfoVo) throws Exception{
		CsCustomerInfo csCustomerInfo = new CsCustomerInfo();
		csCustomerInfo.setId(csCustomerInfoVo.getId());
		this.csCustomerInfoService.delete(csCustomerInfo);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
