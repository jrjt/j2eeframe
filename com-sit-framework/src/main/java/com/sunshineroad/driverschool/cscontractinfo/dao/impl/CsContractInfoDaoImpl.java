package com.sunshineroad.driverschool.cscontractinfo.dao.impl;

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

import com.sunshineroad.driverschool.cscontractinfo.dao.CsContractInfoDao;
import com.sunshineroad.driverschool.cscontractinfo.entity.CsContractInfo;
import com.sunshineroad.driverschool.cscontractinfo.entityvo.CsContractInfoVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 合同表
 * @author  
 * @date 2014-01-03 18:39:09
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
