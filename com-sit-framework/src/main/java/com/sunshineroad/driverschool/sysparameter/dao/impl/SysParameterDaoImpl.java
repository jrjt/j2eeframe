package com.sunshineroad.driverschool.sysparameter.dao.impl;

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

import com.sunshineroad.driverschool.sysparameter.dao.SysParameterDao;
import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.sysparameter.entityvo.SysParameterVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 参数
 * @author  
 * @date 2014-01-09 10:34:34
 * @version V1.0   
 *
 */
@Repository("SysParameterDao")
public class SysParameterDaoImpl extends HibernateDaoSupport<SysParameter, Integer> implements SysParameterDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public SysParameterDaoImpl(){
		this.getEntityClass();
	} 
  
}
