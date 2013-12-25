package com.sunshineroad.xjnx.assocustom.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.assocustom.dao.AssoCustomDao;
import com.sunshineroad.xjnx.assocustom.vo.AssoCustomVo;

@Repository("assocustomDao")
public class AssoCustomDaoImpl extends HibernateDaoSupport<AssoCustomVo, Integer> implements AssoCustomDao<AssoCustomVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
