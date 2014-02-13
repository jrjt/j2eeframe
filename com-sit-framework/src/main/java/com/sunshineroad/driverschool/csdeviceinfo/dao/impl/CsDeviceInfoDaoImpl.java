package com.sunshineroad.driverschool.csdeviceinfo.dao.impl;

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

import com.sunshineroad.driverschool.csdeviceinfo.dao.CsDeviceInfoDao;
import com.sunshineroad.driverschool.csdeviceinfo.entity.CsDeviceInfo;
import com.sunshineroad.driverschool.csdeviceinfo.entityvo.CsDeviceInfoVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 设备信息表
 * @author  
 * @date 2014-02-07 13:55:34
 * @version V1.0   
 *
 */
@Repository("CsDeviceInfoDao")
public class CsDeviceInfoDaoImpl extends HibernateDaoSupport<CsDeviceInfo, Integer> implements CsDeviceInfoDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public CsDeviceInfoDaoImpl(){
		this.getEntityClass();
	} 
  
}
