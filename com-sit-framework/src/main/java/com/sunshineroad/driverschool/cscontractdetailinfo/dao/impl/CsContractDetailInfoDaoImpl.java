package com.sunshineroad.driverschool.cscontractdetailinfo.dao.impl;

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

import com.sunshineroad.driverschool.cscontractdetailinfo.dao.CsContractDetailInfoDao;
import com.sunshineroad.driverschool.cscontractdetailinfo.entity.CsContractDetailInfo;
import com.sunshineroad.driverschool.cscontractdetailinfo.entityvo.CsContractDetailInfoVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 合同明细
 * @author  
 * @date 2014-01-15 13:45:03
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
