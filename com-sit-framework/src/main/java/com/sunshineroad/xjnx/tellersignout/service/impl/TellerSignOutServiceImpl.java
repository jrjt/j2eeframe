package com.sunshineroad.xjnx.tellersignout.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.xjnx.tellersignout.dao.TellerSignOutDao;
import com.sunshineroad.xjnx.tellersignout.service.TellerSignOutService;
import com.sunshineroad.xjnx.tellersignout.vo.TellerSignOutVo;

/**
 * 
 * omplatform
 * com.sunshineroad.xjnx.tellersignout.service.impl
 * @{#} TellerSignOutServiceImpl.java Create on  2013-7-25 下午12:32:42
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）柜员签退  service
 *
 */
@Service("tellersignoutService")
public class TellerSignOutServiceImpl implements TellerSignOutService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected TellerSignOutDao<TellerSignOutVo, Integer> tellersoDao;

	@Override
	public List<TellerSignOutVo> getList(TellerSignOutVo tellervo) throws Exception
	{
		String tellercode = tellervo.getTellercode();
		String workstate = null;
		if(tellervo.getWorkstate() != null){
			workstate = tellervo.getWorkstate().toString();
		}
		String tellerinfo_sql = "select rownum as id,brccode,tellercode,substr(name,1,10) as tellername,status,workstate from xjbank.tlstellerinfo where brccode<>'8009999' ";
		List<TellerSignOutVo> teller_list = new ArrayList<TellerSignOutVo>();
		if(StringUtils.isBlank(tellercode)){
			if(StringUtils.isNotBlank(workstate) && workstate.equalsIgnoreCase("1")){
				tellerinfo_sql = tellerinfo_sql + " and workstate = '5' ";

			}else if(StringUtils.isNotBlank(workstate) && workstate.equalsIgnoreCase("0")){
				tellerinfo_sql = tellerinfo_sql + " and workstate <> '5' ";
			}
			
			teller_list = this.tellersoDao.selectBySql(
				TellerSignOutVo.class, "id,brccode,tellercode,tellername,status,workstate", tellerinfo_sql);
		}else{
			tellerinfo_sql = tellerinfo_sql + " and tellercode = ? ";
			if(StringUtils.isNotBlank(workstate) && workstate.equalsIgnoreCase("1")){
				tellerinfo_sql = tellerinfo_sql + " and workstate = '5' ";

			}else if(StringUtils.isNotBlank(workstate) && workstate.equalsIgnoreCase("0")){
				tellerinfo_sql = tellerinfo_sql + " and workstate <> '5' ";
			}
			teller_list = this.tellersoDao.selectBySql(
					TellerSignOutVo.class, "id,brccode,tellercode,tellername,status,workstate", tellerinfo_sql, tellercode);
		}
 
		return teller_list;
	}
	
	@Override
	public void tellerSignOut( TellerSignOutVo tellervo ) throws Exception
	{
		String update_sql = "update xjbank.tlstellerinfo set workstate='5' where tellercode= ? ";
		String tellercode = tellervo.getTellercode();
		
		this.tellersoDao.updateBySql(update_sql, tellercode);
	}
	
	@Override
	public void tellerReset( TellerSignOutVo tellervo ) throws Exception
	{
		String update_sql = "update xjbank.tlstellerinfo set status=substr(status,1,1)||'0'||substr(status,3) where tellercode= ? ";
		String tellercode = tellervo.getTellercode();
		
		this.tellersoDao.updateBySql(update_sql, tellercode);
	}
}
