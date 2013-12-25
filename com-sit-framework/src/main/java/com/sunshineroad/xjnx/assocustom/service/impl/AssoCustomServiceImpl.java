package com.sunshineroad.xjnx.assocustom.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.xjnx.assocustom.dao.AssoCustomDao;
import com.sunshineroad.xjnx.assocustom.service.AssoCustomService;
import com.sunshineroad.xjnx.assocustom.vo.AssoCustomVo;

/**
 * omplatform
 * com.sunshineroad.xjnx.assocustom.service.impl
 * @{#} AssoCustomServiceImpl.java Create on  2013-6-13 上午9:48:06
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）客户号码关联操作
 *
 */
@Service("assocustomService")
public class AssoCustomServiceImpl implements AssoCustomService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected AssoCustomDao<AssoCustomVo, Integer> assoCustomDao;

	@Override
	public List<AssoCustomVo> list(String acctno,StringBuffer errorinfo) {
		String subsys_sql="";
		String subsys="";
		String customid_sql="";
		List<AssoCustomVo> subsys_list;
		List<AssoCustomVo> customid_list;
		List<AssoCustomVo> list = new ArrayList<AssoCustomVo>();
		if(StringUtils.isBlank(acctno)){
			return list;
		}
		//subsys
		subsys_sql =
				"select trim(subsys) as subsys from xjbank.pubacctnoidx0 where acctno=? union all " +
				"select trim(subsys) as subsys from xjbank.pubacctnoidx1 where acctno=? union all " +
				"select trim(subsys) as subsys from xjbank.pubacctnoidx2 where acctno=?";

		subsys_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
				"subsys",subsys_sql,acctno,acctno,acctno);
		if(subsys_list.size()==1) {
			subsys = subsys_list.get(0).getSubsys();
		}
		
		if(StringUtils.isNotBlank(subsys)){
			
			errorinfo.append("subsystem:"+subsys);
			StringBuffer error=new StringBuffer("");
			if(subsys.equals("CMS")){
				
				//customid cmscardinfo
				customid_sql =
						"select trim(custno) as customid from xjbank.cmscardinfo where cardno=?";
				customid_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
						"customid",customid_sql,acctno);
				
				for(AssoCustomVo temp:customid_list){
					if(temp.getCustomid()!=null){
						list.add(getcustominfo(temp.getCustomid(),error));		
					}
				}			
					
				//customid cmsacctm
				customid_sql =
						"select trim(custno) as customid from xjbank.cmsacctm where cardno=?";
				customid_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
						"customid",customid_sql,acctno);
				for(AssoCustomVo temp:customid_list){
					if(temp.getCustomid()!=null){
						list.add(getcustominfo(temp.getCustomid(),error));		
					}
				}
				
				//customid ciscustaccinfo
				customid_sql =
						"select trim(customid) as customid from xjbank.ciscustaccinfo " +
						"where acctno=(select acctno from xjbank.cmscardinfo where cardno=?)";
				customid_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
						"customid",customid_sql,acctno);
				for(AssoCustomVo temp:customid_list){
					if(temp.getCustomid()!=null){
						list.add(getcustominfo(temp.getCustomid(),error));		
					}
				}
			}else if(subsys.equals("DPS")){
				
				//customid ciscustaccinfo
				customid_sql =
						"select customid from xjbank.ciscustaccinfo where acctno=?";
				customid_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
						"customid",customid_sql,acctno);
				
				for(AssoCustomVo temp:customid_list){
					if(temp.getCustomid()!=null){
						list.add(getcustominfo(temp.getCustomid(),error));		
					}
				}
			}else if(subsys.equals("SHS")){
				
				//customid ciscustaccinfo
				customid_sql =
						"select customid from xjbank.ciscustaccinfo where acctno=?";
				customid_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
						"customid",customid_sql,acctno);
				
				for(AssoCustomVo temp:customid_list){
					if(temp.getCustomid()!=null){
						list.add(getcustominfo(temp.getCustomid(),error));		
					}
				}
			}else if(subsys.equals("LNS")){
				
				//customid ciscustaccinfo
				customid_sql =
						"select customid from xjbank.ciscustaccinfo where acctno=?";
				customid_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
						"customid",customid_sql,acctno);
				
				for(AssoCustomVo temp:customid_list){
					if(temp.getCustomid()!=null){
						list.add(getcustominfo(temp.getCustomid(),error));
					}
				}
			}else{
				errorinfo.setLength(0);
				errorinfo.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;subsys："+subsys+" 暂不支持！");
			}
		}else{
			if(subsys_list.size()==0) {
				errorinfo.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;subsys 不存在！<br />");
			}else{
				errorinfo.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;subsys 不唯一："+subsys_list.size()+"<br />");
			}
			errorinfo.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请检查账号是否正确！");
		}

		return list;
	}
	
	@Override
	public AssoCustomVo getcustominfo(String customid,StringBuffer errorinfo){
		AssoCustomVo custom= new AssoCustomVo();
		if(!customid.isEmpty()){
			String custom_sql=
					"select customid,idtype,idno,customname from xjbank.ciscustomerinfo where customid=?";
			List<AssoCustomVo> custom_list=this.assoCustomDao.selectBySql(AssoCustomVo.class, 
					"customid,idtype,idno,customname",custom_sql,customid);
			if(custom_list.size()==1){
				custom=custom_list.get(0);
			}else{
				errorinfo.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新客户号 不存在！" +
						"<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请检查新客户号是否正确！");
			}
		}
		return custom;
	}
	
	@Override
	public List<AssoCustomVo> update(AssoCustomVo assoCustom,StringBuffer errorinfo) throws Exception {
		String update_sql="";
		String newCustomid=assoCustom.getNewcustomid();
		String acctno=assoCustom.getAcctno();
		String subsys=assoCustom.getSubsys();
		int count=0;
		List<AssoCustomVo> list = new ArrayList<AssoCustomVo>();
		
		if(subsys.equals("CMS")){
			
			update_sql="update xjbank.cmscardinfo set custno=? where cardno=? ";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,acctno);
			AssoCustomVo cmscardinfo=new AssoCustomVo();
			cmscardinfo.setTablename_en("xjbank.cmscardinfo");
			cmscardinfo.setTablename_zh("卡片信息表");
			cmscardinfo.setCount(count);
			list.add(cmscardinfo);
			count=0;
							
			update_sql="update xjbank.cmsacctm set custno=? where cardno=? ";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,acctno);
			AssoCustomVo cmsacctm=new AssoCustomVo();
			cmsacctm.setTablename_en("xjbank.cmsacctm");
			cmsacctm.setTablename_zh("卡帐户对照表");
			cmsacctm.setCount(count);
			list.add(cmsacctm);
			count=0;
			
			update_sql="update xjbank.dpsaccountinfo set custname= " +
					"(select customname from xjbank.ciscustomerinfo where customid=?), " +
					"wthprf3=(select trim(idtype)||trim(idno) from xjbank.ciscustomerinfo " +
					"where customid=?) where acctno=(select acctno from xjbank.cmscardinfo where cardno=?)";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,newCustomid,acctno);			
			AssoCustomVo dpsaccountinfo=new AssoCustomVo();
			dpsaccountinfo.setTablename_en("xjbank.dpsaccountinfo");
			dpsaccountinfo.setTablename_zh("存款静态表");
			dpsaccountinfo.setCount(count);
			list.add(dpsaccountinfo);
			count=0;
			
			update_sql="update xjbank.ciscustaccinfo set customid=?, " +
					"chgdate=(select trandate from xjbank.pubsysctrlinfo ) " +
					"where acctno=(select acctno from xjbank.cmscardinfo where cardno=?)";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,acctno);			
			AssoCustomVo ciscustaccinfo=new AssoCustomVo();
			ciscustaccinfo.setTablename_en("xjbank.ciscustaccinfo");
			ciscustaccinfo.setTablename_zh("客户号帐号对照表");
			ciscustaccinfo.setCount(count);
			list.add(ciscustaccinfo);
			errorinfo.setLength(0);
		}else if(subsys.equals("DPS")){
			
			update_sql="update xjbank.dpsaccountinfo set custname= " +
					"(select customname from xjbank.ciscustomerinfo where customid=?), " +
					"wthprf3=(select trim(idtype)||trim(idno) from xjbank.ciscustomerinfo " +
					"where customid=?) where acctno=?";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,newCustomid,acctno);			
			AssoCustomVo dpsaccountinfo=new AssoCustomVo();
			dpsaccountinfo.setTablename_en("xjbank.dpsaccountinfo");
			dpsaccountinfo.setTablename_zh("存款静态表");
			dpsaccountinfo.setCount(count);
			list.add(dpsaccountinfo);
			count=0;
			
			update_sql="update xjbank.ciscustaccinfo set customid=?, " +
					"chgdate=(select trandate from xjbank.pubsysctrlinfo ) " +
					"where acctno=? ";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,acctno);			
			AssoCustomVo ciscustaccinfo=new AssoCustomVo();
			ciscustaccinfo.setTablename_en("xjbank.ciscustaccinfo");
			ciscustaccinfo.setTablename_zh("客户号帐号对照表");
			ciscustaccinfo.setCount(count);
			list.add(ciscustaccinfo);		
			errorinfo.setLength(0);
		}else if(subsys.equals("SHS")){
			
			update_sql="update xjbank.shsacctinfo set custname=(select customname " +
					"from xjbank.ciscustomerinfo where customid=? ), " +
					"shtname=substr((select customname from xjbank.ciscustomerinfo " +
					"where customid=? ),1,10),idprf=(select trim(idtype)||trim(idno) " +
					"from xjbank.ciscustomerinfo where customid=? ) where acctno=? ";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,newCustomid,newCustomid,acctno);			
			AssoCustomVo dpsaccountinfo=new AssoCustomVo();
			dpsaccountinfo.setTablename_en("xjbank.shsacctinfo");
			dpsaccountinfo.setTablename_zh("股金账户静态信息表");
			dpsaccountinfo.setCount(count);
			list.add(dpsaccountinfo);
			count=0;
			
			update_sql="update xjbank.ciscustaccinfo set customid=?," +
					"chgdate=(select trandate from xjbank.pubsysctrlinfo ) " +
					"where acctno=? ";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,acctno);			
			AssoCustomVo ciscustaccinfo=new AssoCustomVo();
			ciscustaccinfo.setTablename_en("xjbank.ciscustaccinfo");
			ciscustaccinfo.setTablename_zh("客户号帐号对照表");
			ciscustaccinfo.setCount(count);
			list.add(ciscustaccinfo);		
			errorinfo.setLength(0);
		}else if(subsys.equals("LNS")){

			update_sql="update xjbank.lnsacctinfo set name=(select customname " +
					"from xjbank.ciscustomerinfo where customid=? ) where acctno=? ";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,newCustomid,acctno);			
			AssoCustomVo dpsaccountinfo=new AssoCustomVo();
			dpsaccountinfo.setTablename_en("xjbank.dpsaccountinfo");
			dpsaccountinfo.setTablename_zh("贷款分户静态信息表");
			dpsaccountinfo.setCount(count);
			list.add(dpsaccountinfo);
			count=0;
			
			update_sql="update xjbank.ciscustaccinfo set customid=?," +
					"chgdate=(select trandate from xjbank.pubsysctrlinfo ) " +
					"where acctno=? ";
			count=this.assoCustomDao.updateBySql(update_sql, newCustomid,acctno);			
			AssoCustomVo ciscustaccinfo=new AssoCustomVo();
			ciscustaccinfo.setTablename_en("xjbank.ciscustaccinfo");
			ciscustaccinfo.setTablename_zh("客户号帐号对照表");
			ciscustaccinfo.setCount(count);
			list.add(ciscustaccinfo);		
			errorinfo.setLength(0);
		}
		
		return list;
	}
}
