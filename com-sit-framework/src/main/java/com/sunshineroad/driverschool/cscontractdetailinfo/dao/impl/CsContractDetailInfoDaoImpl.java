package com.sunshineroad.driverschool.cscontractdetailinfo.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.driverschool.cscontractdetailinfo.dao.CsContractDetailInfoDao;
import com.sunshineroad.driverschool.cscontractdetailinfo.entity.CsContractDetailInfo;
import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;


/**   
 * @Title: daoImpl
 * @Description: 合同明细
 * @author  
 * @date 2014-01-22 12:32:27
 * @version V1.0   
 *
 */
@Repository("CsContractDetailInfoDao")
public class CsContractDetailInfoDaoImpl extends HibernateDaoSupport<CsContractDetailInfo, Integer> implements CsContractDetailInfoDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public CsContractDetailInfoDaoImpl(){
		this.getEntityClass();
	} 
  
}
