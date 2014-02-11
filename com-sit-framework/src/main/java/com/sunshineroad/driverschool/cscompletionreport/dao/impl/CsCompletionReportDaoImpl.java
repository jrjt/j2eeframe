package com.sunshineroad.driverschool.cscompletionreport.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.driverschool.cscompletionreport.dao.CsCompletionReportDao;
import com.sunshineroad.driverschool.cscompletionreport.entity.CsCompletionReport;
import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;


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
