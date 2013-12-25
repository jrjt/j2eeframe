package com.sunshineroad.xjnx.updateacceptinfo.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.updateacceptinfo.dao.UpdateAcceptInfoDao;
import com.sunshineroad.xjnx.updateacceptinfo.vo.UpdateAcceptInfoVo;

@Repository("updateacceptinfoDao")
public class UpdateAcceptInfoDaoImpl extends HibernateDaoSupport<UpdateAcceptInfoVo, Integer> implements UpdateAcceptInfoDao<UpdateAcceptInfoVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
