package com.sunshineroad.driverschool.csdevicearrivalinfo.controller;
import java.io.UnsupportedEncodingException;
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

import com.sunshineroad.driverschool.csdevicearrivalinfo.entity.CsDeviceArrivalInfo;
import com.sunshineroad.driverschool.csdevicearrivalinfo.entityvo.CsDeviceArrivalInfoVo;
import com.sunshineroad.driverschool.csdevicearrivalinfo.service.CsDeviceArrivalInfoService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 设备到货信息
 * @author auto Generate
 * @date 2014-02-17 12:38:40
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="csDeviceArrivalInfo")
public class CsDeviceArrivalInfoController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CsDeviceArrivalInfoController.class);

	public CsDeviceArrivalInfoController(){		
	}

	@Autowired
	private CsDeviceArrivalInfoService csDeviceArrivalInfoService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		CsDeviceArrivalInfo csDeviceArrivalInfo= new CsDeviceArrivalInfo();
		
		
		String paramsCustomerName = request.getParameter("paramsCustomerName");
		String paramsContractNumber = request.getParameter("paramsContractNumber");
		String paramsDeviceModel = request.getParameter("paramsDeviceModel");
		
		System.out.println( paramsCustomerName);
		System.out.println( paramsContractNumber );
		System.out.println( paramsDeviceModel);
		
		if (paramsCustomerName!=null || paramsContractNumber!=null || paramsDeviceModel!=null) {
			byte b[];
			try {
				b = paramsCustomerName.getBytes("GBK"); 
				paramsCustomerName = new String(b);
				
				b = paramsContractNumber.getBytes("GBK");
				paramsContractNumber = new String(b);
				
				b = paramsDeviceModel.getBytes("GBK");
				paramsDeviceModel = new String(b);
				
			} catch (UnsupportedEncodingException e) {
				paramsCustomerName = null;
				paramsContractNumber = null;
				paramsDeviceModel = null;
			}
		} if (paramsCustomerName!=null || paramsContractNumber!=null || paramsDeviceModel!=null) {
			csDeviceArrivalInfo.setCustomerName(paramsCustomerName);
			csDeviceArrivalInfo.setContractNumber(paramsContractNumber);
			csDeviceArrivalInfo.setDeviceModel(paramsDeviceModel);
		}
		return ResponseUtils.sendPagination(csDeviceArrivalInfoService.list(csDeviceArrivalInfo)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody CsDeviceArrivalInfoVo csDeviceArrivalInfoVo) throws Exception{
		CsDeviceArrivalInfo csDeviceArrivalInfo =new CsDeviceArrivalInfo();
		csDeviceArrivalInfo.setId(csDeviceArrivalInfoVo.getId());
		PropertyUtils.copyProperties(csDeviceArrivalInfo, csDeviceArrivalInfoVo);
		this.csDeviceArrivalInfoService.update(csDeviceArrivalInfo);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody CsDeviceArrivalInfoVo csDeviceArrivalInfoVo) throws Exception{
		CsDeviceArrivalInfo csDeviceArrivalInfo =new CsDeviceArrivalInfo();
		PropertyUtils.copyProperties(csDeviceArrivalInfo, csDeviceArrivalInfoVo);
		return ResponseUtils.sendSuccess("保存成功",this.csDeviceArrivalInfoService.save(csDeviceArrivalInfo).getId());
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody CsDeviceArrivalInfoVo csDeviceArrivalInfoVo) throws Exception{
		CsDeviceArrivalInfo csDeviceArrivalInfo =new CsDeviceArrivalInfo();
		csDeviceArrivalInfo.setId(csDeviceArrivalInfoVo.getId());
		this.csDeviceArrivalInfoService.delete(csDeviceArrivalInfo);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
