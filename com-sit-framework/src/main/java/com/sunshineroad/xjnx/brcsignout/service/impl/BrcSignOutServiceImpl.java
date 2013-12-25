package com.sunshineroad.xjnx.brcsignout.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.xjnx.brcsignout.dao.BrcSignOutDao;
import com.sunshineroad.xjnx.brcsignout.service.BrcSignOutService;
import com.sunshineroad.xjnx.brcsignout.vo.BrcSignOutVo;

/**
 * 
 * omplatform
 * com.sunshineroad.xjnx.brcsignout.service.impl
 * @{#} BrcSignOutServiceImpl.java Create on  2013-7-23 下午5:40:59
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）机构签退  service
 *
 */
@Service("brcsignoutService")
public class BrcSignOutServiceImpl implements BrcSignOutService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected BrcSignOutDao<BrcSignOutVo, Integer> brcsoDao;

	@Override
	public List<BrcSignOutVo> getList(BrcSignOutVo brcvo) throws Exception
	{
		String brccode = brcvo.getBrccode();
		String status = null;
		if(brcvo.getStatus() != null){
			status = brcvo.getStatus().toString();
		}
		String branchinfo_sql = "select rownum as id,brccode,brcname,phone,status from xjbank.pubbranchinfo where brccode<>'8009999' ";
		List<BrcSignOutVo> brc_list = new ArrayList<BrcSignOutVo>();
		if(StringUtils.isBlank(brccode)){
			if(StringUtils.isNotBlank(status) && status.equalsIgnoreCase("1")){
				branchinfo_sql = branchinfo_sql + " and status = '4' ";

			}else if(StringUtils.isNotBlank(status) && status.equalsIgnoreCase("0")){
				branchinfo_sql = branchinfo_sql + " and status in ('2','3') ";
			}
			
			brc_list = this.brcsoDao.selectBySql(
				BrcSignOutVo.class, "id,brccode,brcname,phone,status", branchinfo_sql);
		}else{
			branchinfo_sql = branchinfo_sql + " and brccode = ? ";
			if(StringUtils.isNotBlank(status) && status.equalsIgnoreCase("1")){
				branchinfo_sql = branchinfo_sql + " and status = '4' ";

			}else if(StringUtils.isNotBlank(status) && status.equalsIgnoreCase("0")){
				branchinfo_sql = branchinfo_sql + " and status in ('2','3') ";
			}
			brc_list = this.brcsoDao.selectBySql(
					BrcSignOutVo.class, "id,brccode,brcname,phone,status", branchinfo_sql, brccode);
		}
 
		return brc_list;
	}
	
	@Override
	public void brcSignOut( BrcSignOutVo brcvo ) throws Exception
	{
		String update_sql = "update xjbank.pubbranchinfo set status='4' where brccode=? ";
		String brccode = brcvo.getBrccode();
		
		this.brcsoDao.updateBySql(update_sql, brccode);
	}
}
