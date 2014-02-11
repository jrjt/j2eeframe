package com.sunshineroad.driverschool.cscustomerinfo.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.driverschool.cscustomerinfo.dao.CsCustomerInfoDao;
import com.sunshineroad.driverschool.cscustomerinfo.entity.CsCustomerInfo;
import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;


/**   
 * @Title: daoImpl
 * @Description: 客户信息
 * @author  
 * @date 2014-01-17 11:43:00
 * @version V1.0   
 *
 */
@Repository("CsCustomerInfoDao")
public class CsCustomerInfoDaoImpl extends HibernateDaoSupport<CsCustomerInfo, Integer> implements CsCustomerInfoDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public CsCustomerInfoDaoImpl(){
		this.getEntityClass();
	} 
  
}
