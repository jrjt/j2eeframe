package com.sunshineroad.xjnx.brcsignout.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.brcsignout.dao.BrcSignOutDao;
import com.sunshineroad.xjnx.brcsignout.vo.BrcSignOutVo;

@Repository("brcsignoutDao")
public class BrcSignOutDaoImpl extends HibernateDaoSupport<BrcSignOutVo, Integer> implements BrcSignOutDao<BrcSignOutVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
