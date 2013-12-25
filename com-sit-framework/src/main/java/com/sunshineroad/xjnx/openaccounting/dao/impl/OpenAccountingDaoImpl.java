package com.sunshineroad.xjnx.openaccounting.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.openaccounting.dao.OpenAccountingDao;
import com.sunshineroad.xjnx.openaccounting.vo.OpenAccountingVo;

@Repository("openacctDao")
public class OpenAccountingDaoImpl extends HibernateDaoSupport<OpenAccountingVo, Integer> implements OpenAccountingDao<OpenAccountingVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
