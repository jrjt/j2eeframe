package com.sunshineroad.xjnx.fundssums.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.fundssums.dao.FundsSumsDao;
import com.sunshineroad.xjnx.fundssums.vo.FundsSumsVo;

@Repository("fundssumsDao")
public class FundsSumsDaoImpl extends HibernateDaoSupport<FundsSumsVo, Integer> implements FundsSumsDao<FundsSumsVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
