package com.sunshineroad.driverschool.csdeviceinfo.controller;
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
import com.sunshineroad.driverschool.csdeviceinfo.entity.CsDeviceInfo;
import com.sunshineroad.driverschool.csdeviceinfo.entityvo.CsDeviceInfoVo;
import com.sunshineroad.driverschool.csdeviceinfo.service.CsDeviceInfoService;
import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 设备信息表
 * @author auto Generate
 * @date 2014-02-07 13:55:33
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="csDeviceInfo")
public class CsDeviceInfoController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CsDeviceInfoController.class);

	public CsDeviceInfoController(){		
	}

	@Autowired
	private CsDeviceInfoService csDeviceInfoService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		CsDeviceInfo csDeviceInfo= new CsDeviceInfo();
		
		String paramsDeviceName = request.getParameter("paramsDeviceName");
		String paramsDeviceModel = request.getParameter("paramsDeviceModel");
		String paramsDeviceDestination = request.getParameter("paramsDeviceDestination");
		String paramsDeviceOperationMode = request.getParameter("paramsDeviceOperationMode");
		
		
		System.out.println(paramsDeviceName);
		System.out.println(paramsDeviceModel);
		System.out.println(paramsDeviceOperationMode);
		System.out.println(paramsDeviceDestination);
		
		
		if (null!=paramsDeviceName||null!=paramsDeviceModel||null!=paramsDeviceOperationMode
				||null!=paramsDeviceDestination			
				) {
			byte b[];
			try {
				b = paramsDeviceName.getBytes("GBK"); 
				paramsDeviceName = new String(b);
				
				b = paramsDeviceModel.getBytes("GBK"); 
				paramsDeviceModel = new String(b);
				
				b= paramsDeviceDestination.getBytes("GBK");
				paramsDeviceDestination = new String(b);
				
				b= paramsDeviceOperationMode.getBytes("GBK");
			    paramsDeviceOperationMode = new String(b);
				
				
			} catch(UnsupportedEncodingException e){
				paramsDeviceName = null;
				paramsDeviceModel = null;
				paramsDeviceDestination = null;
				paramsDeviceOperationMode = null;
				
				
			}if(null!=paramsDeviceName||null!=paramsDeviceModel||null!=paramsDeviceOperationMode
					||null!=paramsDeviceDestination
						
					){
				csDeviceInfo.setDeviceName(paramsDeviceName);
				csDeviceInfo.setDeviceModel(paramsDeviceModel);
				csDeviceInfo.setDeviceDestination(paramsDeviceDestination);
				csDeviceInfo.setOperationMode(paramsDeviceOperationMode);
		
		        
			}
		}

		return ResponseUtils.sendPagination(csDeviceInfoService.list(csDeviceInfo)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody CsDeviceInfoVo csDeviceInfoVo) throws Exception{
		CsDeviceInfo csDeviceInfo =new CsDeviceInfo();
		csDeviceInfo.setId(csDeviceInfoVo.getId());
		PropertyUtils.copyProperties(csDeviceInfo, csDeviceInfoVo);
		this.csDeviceInfoService.update(csDeviceInfo);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody CsDeviceInfoVo csDeviceInfoVo) throws Exception{
		CsDeviceInfo csDeviceInfo =new CsDeviceInfo();
		PropertyUtils.copyProperties(csDeviceInfo, csDeviceInfoVo);
		return ResponseUtils.sendSuccess("保存成功",this.csDeviceInfoService.save(csDeviceInfo).getId());
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody CsDeviceInfoVo csDeviceInfoVo) throws Exception{
		CsDeviceInfo csDeviceInfo = new CsDeviceInfo();
		csDeviceInfo.setId(csDeviceInfoVo.getId());
		this.csDeviceInfoService.delete(csDeviceInfo);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
