package com.sunshineroad.driverschool.freeTable.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.freeTable.entity.MyDataBase;
import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;

public interface FreeTableDao extends HibernateDao<SysParameter, Integer>{
	
}
