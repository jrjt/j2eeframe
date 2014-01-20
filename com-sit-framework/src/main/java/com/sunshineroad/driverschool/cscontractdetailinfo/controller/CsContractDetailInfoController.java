package com.sunshineroad.driverschool.cscontractdetailinfo.controller;
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

import com.sunshineroad.driverschool.cscontractdetailinfo.entity.CsContractDetailInfo;
import com.sunshineroad.driverschool.cscontractdetailinfo.entityvo.CsContractDetailInfoVo;
import com.sunshineroad.driverschool.cscontractdetailinfo.service.CsContractDetailInfoService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 合同明细
 * @author auto Generate
 * @date 2014-01-15 13:45:01
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="csContractDetailInfo")
public class CsContractDetailInfoController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CsContractDetailInfoController.class);

	public CsContractDetailInfoController(){		
	}

	@Autowired
	private CsContractDetailInfoService csContractDetailInfoService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		CsContractDetailInfo csContractDetailInfo= new CsContractDetailInfo();
  
		return ResponseUtils.sendPagination(csContractDetailInfoService.list(csContractDetailInfo)) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody CsContractDetailInfoVo csContractDetailInfoVo) throws Exception{
		CsContractDetailInfo csContractDetailInfo =new CsContractDetailInfo();
		PropertyUtils.copyProperties(csContractDetailInfo, csContractDetailInfoVo);
		this.csContractDetailInfoService.update(csContractDetailInfo);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody CsContractDetailInfoVo csContractDetailInfoVo) throws Exception{
		CsContractDetailInfo csContractDetailInfo =new CsContractDetailInfo();
		PropertyUtils.copyProperties(csContractDetailInfo, csContractDetailInfoVo);
		return ResponseUtils.sendSuccess("保存成功",this.csContractDetailInfoService.save(csContractDetailInfo).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody CsContractDetailInfo csContractDetailInfo) throws Exception{
		this.csContractDetailInfoService.delete(csContractDetailInfo);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
