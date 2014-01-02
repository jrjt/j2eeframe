package com.sunshineroad.driverschool.cscontractinfo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.cscontractinfo.service.CsContractInfoService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.cscontractinfo.dao.CsContractInfoDao;
import com.sunshineroad.driverschool.cscontractinfo.entity.CsContractInfo;
import com.sunshineroad.driverschool.cscontractinfo.entityvo.CsContractInfoVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("csContractInfoService")
@Transactional
public class CsContractInfoServiceImpl extends BaseServiceImpl<CsContractInfo, Integer>  implements CsContractInfoService {
	@Autowired
	private CsContractInfoDao  csContractInfoDao;

	public List<CsContractInfoVo> list(CsContractInfo entity) {
		HQLParameter p = new HQLParameter(CsContractInfo.class);	   
		return ListUtils.transform(csContractInfoDao.findPageByHql(" from CsContractInfo "   ),
				CsContractInfoVo.class);
	}
	
		@Override
	public void update(CsContractInfo model)  {
		this.csContractInfoDao.update(model);	
	}
	
	@Override
	public CsContractInfo save(CsContractInfo model)   {
		this.csContractInfoDao.save(model);	
		return model;
	}

	@Override
	public void delete(CsContractInfo model)  {
		this.csContractInfoDao.delete(model);	
	}
}


