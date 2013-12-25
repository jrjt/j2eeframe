package com.sunshineroad.xjnx.updatebonusflag.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.updatebonusflag.dao.UpdateBonusFlagDao;
import com.sunshineroad.xjnx.updatebonusflag.vo.UpdateBonusFlagVo;

@Repository("updatebonusflagDao")
public class UpdateBonusFlagDaoImpl extends HibernateDaoSupport<UpdateBonusFlagVo, Integer> implements UpdateBonusFlagDao<UpdateBonusFlagVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
