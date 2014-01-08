package com.sunshineroad.driverschool.sysparameter.controller;
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

import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.sysparameter.entityvo.SysParameterVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 参数
 * @author auto Generate
 * @date 2014-01-08 20:17:19
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="sysParameter")
public class SysParameterController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SysParameterController.class);

	public SysParameterController(){		
	}

	@Autowired
	private SysParameterService sysParameterService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		SysParameter sysParameter= new SysParameter();
  
		return ResponseUtils.sendPagination(sysParameterService.list(sysParameter)) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody SysParameterVo sysParameterVo) throws Exception{
		SysParameter sysParameter =new SysParameter();
		PropertyUtils.copyProperties(sysParameter, sysParameterVo);
		this.sysParameterService.update(sysParameter);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody SysParameterVo sysParameterVo) throws Exception{
		SysParameter sysParameter =new SysParameter();
		PropertyUtils.copyProperties(sysParameter, sysParameterVo);
		return ResponseUtils.sendSuccess("保存成功",this.sysParameterService.save(sysParameter).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody SysParameter sysParameter) throws Exception{
		this.sysParameterService.delete(sysParameter);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
