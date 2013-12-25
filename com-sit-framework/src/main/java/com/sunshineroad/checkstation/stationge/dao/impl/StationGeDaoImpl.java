package com.sunshineroad.checkstation.stationge.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunshineroad.checkstation.stationge.dao.StationGeDao;
import com.sunshineroad.checkstation.stationge.entity.StationGe;
import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;

@Repository("stationGeDao")
	public class StationGeDaoImpl extends HibernateDaoSupport<StationGe, Integer> implements StationGeDao<StationGe, Integer> {
	
	@Resource(name="sessionFactory_system")	
	public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	}
	
	public StationGeDaoImpl(){
		this.getEntityClass();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<StationGe> findByIdsForHql() {
		String hql="FROM StationGe WHERE latitude is not null";
		Query query = this.getSession().createQuery(hql);
		

		return query.list();
	}
	
}
