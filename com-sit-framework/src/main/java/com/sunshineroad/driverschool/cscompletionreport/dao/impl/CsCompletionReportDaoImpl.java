package com.sunshineroad.driverschool.cscompletionreport.dao.impl;

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

import com.sunshineroad.driverschool.cscompletionreport.dao.CsCompletionReportDao;
import com.sunshineroad.driverschool.cscompletionreport.entity.CsCompletionReport;
import com.sunshineroad.driverschool.cscompletionreport.entityvo.CsCompletionReportVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 完工报告
 * @author  
 * @date 2014-01-15 11:57:35
 * @version V1.0   
 *
 */
@Repository("CsCompletionReportDao")
public class CsCompletionReportDaoImpl extends HibernateDaoSupport<CsCompletionReport, Integer> implements CsCompletionReportDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public CsCompletionReportDaoImpl(){
		this.getEntityClass();
	} 
  
}
