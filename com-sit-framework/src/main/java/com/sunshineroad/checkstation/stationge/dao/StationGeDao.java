package com.sunshineroad.checkstation.stationge.dao;

import java.util.List;

import com.sunshineroad.checkstation.stationge.entity.StationGe;
import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;

public interface StationGeDao<T, ID> extends HibernateDao<T, ID>{
	public List<StationGe> findByIdsForHql();

}
