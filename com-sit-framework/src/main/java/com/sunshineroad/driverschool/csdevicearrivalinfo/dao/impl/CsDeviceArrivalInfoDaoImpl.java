package com.sunshineroad.driverschool.csdevicearrivalinfo.dao.impl;

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

import com.sunshineroad.driverschool.csdevicearrivalinfo.dao.CsDeviceArrivalInfoDao;
import com.sunshineroad.driverschool.csdevicearrivalinfo.entity.CsDeviceArrivalInfo;
import com.sunshineroad.driverschool.csdevicearrivalinfo.entityvo.CsDeviceArrivalInfoVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 设备到货信息
 * @author  
 * @date 2014-02-17 12:38:42
 * @version V1.0   
 *
 */
@Repository("CsDeviceArrivalInfoDao")
public class CsDeviceArrivalInfoDaoImpl extends HibernateDaoSupport<CsDeviceArrivalInfo, Integer> implements CsDeviceArrivalInfoDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public CsDeviceArrivalInfoDaoImpl(){
		this.getEntityClass();
	} 
  
}
