package com.sunshineroad.xjnx.cleanupaccount.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.cleanupaccount.dao.CleanUpAccountDao;
import com.sunshineroad.xjnx.cleanupaccount.vo.CleanUpAccountVo;

@Repository("cleanupaccountDao")
public class CleanUpAccountDaoImpl extends HibernateDaoSupport<CleanUpAccountVo, Integer> implements CleanUpAccountDao<CleanUpAccountVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
