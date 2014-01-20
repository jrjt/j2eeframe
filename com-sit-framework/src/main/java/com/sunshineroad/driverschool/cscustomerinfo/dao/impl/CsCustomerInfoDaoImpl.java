package com.sunshineroad.driverschool.cscustomerinfo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunshineroad.driverschool.cscustomerinfo.dao.CsCustomerInfoDao;
import com.sunshineroad.driverschool.cscustomerinfo.entity.CsCustomerInfo;
import com.sunshineroad.driverschool.cscustomerinfo.entityvo.CsCustomerInfoVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


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
