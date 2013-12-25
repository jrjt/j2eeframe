package com.sunshineroad.xjnx.updateacctinfo.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.updateacctinfo.dao.UpdateAcctInfoDao;
import com.sunshineroad.xjnx.updateacctinfo.vo.UpdateAcctInfoVo;

@Repository("updateacctinfoDao")
public class UpdateAcctInfoDaoImpl extends HibernateDaoSupport<UpdateAcctInfoVo, Integer> implements UpdateAcctInfoDao<UpdateAcctInfoVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
