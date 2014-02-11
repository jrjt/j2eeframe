package com.sunshineroad.driverschool.cscontractinfo.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.driverschool.cscontractinfo.dao.CsContractInfoDao;
import com.sunshineroad.driverschool.cscontractinfo.entity.CsContractInfo;
import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;


/**   
 * @Title: daoImpl
 * @Description: 合同信息
 * @author  
 * @date 2014-01-15 16:16:59
 * @version V1.0   
 *
 */
@Repository("CsContractInfoDao")
public class CsContractInfoDaoImpl extends HibernateDaoSupport<CsContractInfo, Integer> implements CsContractInfoDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public CsContractInfoDaoImpl(){
		this.getEntityClass();
	} 
  
}
