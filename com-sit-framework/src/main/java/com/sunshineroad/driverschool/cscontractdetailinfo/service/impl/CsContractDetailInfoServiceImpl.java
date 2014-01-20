package com.sunshineroad.driverschool.cscontractdetailinfo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.cscontractdetailinfo.service.CsContractDetailInfoService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.cscontractdetailinfo.dao.CsContractDetailInfoDao;
import com.sunshineroad.driverschool.cscontractdetailinfo.entity.CsContractDetailInfo;
import com.sunshineroad.driverschool.cscontractdetailinfo.entityvo.CsContractDetailInfoVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("csContractDetailInfoService")
@Transactional
public class CsContractDetailInfoServiceImpl extends BaseServiceImpl<CsContractDetailInfo, Integer>  implements CsContractDetailInfoService {
	@Autowired
	private CsContractDetailInfoDao  csContractDetailInfoDao;

	public List<CsContractDetailInfoVo> list(CsContractDetailInfo entity) {
		HQLParameter p = new HQLParameter(CsContractDetailInfo.class);	   
		return ListUtils.transform(csContractDetailInfoDao.findPageByHql(" from CsContractDetailInfo "   ),
				CsContractDetailInfoVo.class);
	}
	
		@Override
	public void update(CsContractDetailInfo model)  {
		this.csContractDetailInfoDao.update(model);	
	}
	
	@Override
	public CsContractDetailInfo save(CsContractDetailInfo model)   {
		this.csContractDetailInfoDao.save(model);	
		return model;
	}

	@Override
	public void delete(CsContractDetailInfo model)  {
		this.csContractDetailInfoDao.delete(model);	
	}
}


