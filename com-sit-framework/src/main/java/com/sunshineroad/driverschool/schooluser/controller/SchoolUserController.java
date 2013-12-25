package com.sunshineroad.driverschool.schooluser.controller;
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

import com.sunshineroad.driverschool.schooluser.entity.SchoolUser;
import com.sunshineroad.driverschool.schooluser.entityvo.SchoolUserVo;
import com.sunshineroad.driverschool.schooluser.service.SchoolUserService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: uu
 * @author auto Generate
 * @date 2013-12-25 14:03:28
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="schoolUsers")
public class SchoolUserController extends BaseControllerImpl {
	/**
	 * Logger for this c    
	 */
	private static final Logger logger = Logger.getLogger(SchoolUserController.class);

	public SchoolUserController(){		
	}

	@Autowired
	private SchoolUserService schoolUserService;
	 
 
 @RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		SchoolUser schoolUser= new SchoolUser();
  
		return ResponseUtils.sendPagination(schoolUserService.list(schoolUser)) ;
	}
 
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody SchoolUserVo schoolUserVo) throws Exception{
		SchoolUser schoolUser =new SchoolUser();
		PropertyUtils.copyProperties(schoolUser, schoolUserVo);
		this.schoolUserService.update(schoolUser);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody SchoolUserVo schoolUserVo) throws Exception{
		SchoolUser schoolUser =new SchoolUser();
		PropertyUtils.copyProperties(schoolUser, schoolUserVo);
		return ResponseUtils.sendSuccess("保存成功",this.schoolUserService.save(schoolUser));
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody SchoolUser schoolUser) throws Exception{
		this.schoolUserService.delete(schoolUser);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
