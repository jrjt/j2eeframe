package com.sunshineroad.xjnx.assocustom.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.credentials.service.CredentialsService;
import com.sunshineroad.system.credentials.vo.CredentialsVo;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.assocustom.service.AssoCustomService;
import com.sunshineroad.xjnx.assocustom.vo.AssoCustomVo;

/**
 * omplatform
 * com.sunshineroad.xjnx.assocustom.controller
 * @{#} AssoCustomController.java Create on  2013-6-13 上午9:49:01
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）客户号码关联
 *
 */
@Controller
@RequestMapping(value="assocustoms")
public class AssoCustomController {

	@Autowired
	private AssoCustomService assoCustomService;
	
	@Autowired
    private UpdatelogService updatelogService;
	
	@Autowired
	private ActionlogService actionlogService;
	
	@Autowired
    private CredentialsService creService;
	
	private AssoCustomVo curr_custom=new AssoCustomVo();
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list()throws Exception{
		HttpServletRequest request =WebUtils.getRequestByContext();
		String acctno=request.getParameter("acctno");
		String newcustomid=request.getParameter("newcustomid");
//		String user_id=request.getParameter("userid");
		String update=request.getParameter("update");
		List<AssoCustomVo> list = new ArrayList<AssoCustomVo>();
		List<CredentialsVo> cre_list = new ArrayList<CredentialsVo>();
		StringBuffer errorinfo=new StringBuffer("");
		
		if(StringUtils.isNotBlank(update)){
			if(update.equals("search_acctno")){
				cre_list=creService.list();
				list=assoCustomService.list(acctno,errorinfo);
				int subsys_index=errorinfo.toString().indexOf("subsystem:");
				if(subsys_index!=-1){
					subsys_index=errorinfo.toString().indexOf(":");
					int length=errorinfo.toString().length();
					curr_custom.setSubsys(errorinfo.toString().substring(subsys_index+1,length));
					errorinfo.setLength(0);
				}
				if(list.size()!=0){
					//默认一个账号对应一个customid
					curr_custom.setCustomid(list.get(0).getCustomid());
					for(AssoCustomVo temp:list){
						for(CredentialsVo cre:cre_list){
							if(cre.getIdtype().equals(temp.getIdtype())){
								temp.setIdname(cre.getIdname());
								break;
							}
						}
					}
				}
			}else if(update.equals("search_customid")){	
				curr_custom.setAcctno(acctno);
				curr_custom.setNewcustomid(newcustomid);
				
				cre_list=creService.list();
				
				AssoCustomVo new_custom=
						assoCustomService.getcustominfo(newcustomid,errorinfo);	
				if(new_custom.getCustomid()!=null){
					for(CredentialsVo cre:cre_list){
						if(cre.getIdtype().equals(new_custom.getIdtype())){
							new_custom.setIdname(cre.getIdname());
							break;
						}
					}
					list.add(new_custom);
					errorinfo.setLength(0);
				}
			}else if(update.equals("update")){
				//关联新客户号码
				list=assoCustomService.update(curr_custom,errorinfo);
				
				//关联成功后，记录更改信息
				if(StringUtils.isBlank(errorinfo.toString())){
					String actDesc="客户号码关联";

					for(AssoCustomVo temp:list){
						if(temp.getCount()!=0){
							Updatelog ulog = new Updatelog();
							ulog.setAction(actDesc);
							ulog.setTable_name(temp.getTablename_en());
							ulog.setKeys("acctno");
							ulog.setKey_value(curr_custom.getAcctno());
							ulog.setColumns("customid");
							ulog.setOld_value(curr_custom.getCustomid());
							ulog.setNew_value(curr_custom.getNewcustomid());

							updatelogService.saveUlog(ulog);
						}
					}
					
					//记录用户操作信息
					actionlogService.saveAlog("",actDesc,true,"");
				}
			}
		}
		
		return ResponseUtils.sendPagination(list,errorinfo.toString());
	}

	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody AssoCustomVo assoCustom) throws Exception{
		return ResponseUtils.sendSuccess("保存成功");
	}	
}
