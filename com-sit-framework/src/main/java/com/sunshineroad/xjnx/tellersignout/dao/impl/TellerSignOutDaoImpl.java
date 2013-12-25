package com.sunshineroad.xjnx.tellersignout.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.tellersignout.dao.TellerSignOutDao;
import com.sunshineroad.xjnx.tellersignout.vo.TellerSignOutVo;

@Repository("tellersignoutDao")
public class TellerSignOutDaoImpl extends HibernateDaoSupport<TellerSignOutVo, Integer> implements TellerSignOutDao<TellerSignOutVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
