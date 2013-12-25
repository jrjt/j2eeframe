package com.sunshineroad.xjnx.branchsms.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.xjnx.branchsms.dao.BranchsMSDao;
import com.sunshineroad.xjnx.branchsms.vo.BranchsMSVo;

@Repository("branchsmsDao")
public class BranchsMSDaoImpl extends HibernateDaoSupport<BranchsMSVo, Integer> implements BranchsMSDao<BranchsMSVo, Integer> {

    @Resource(name="sessionFactory_xjnx")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
