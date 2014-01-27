package com.sunshineroad.driverschool.cscontractdetailinfo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.cscontractdetailinfo.service.CsContractDetailInfoService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.cscontractdetailinfo.dao.CsContractDetailInfoDao;
import com.sunshineroad.driverschool.cscontractdetailinfo.entity.CsContractDetailInfo;
import com.sunshineroad.driverschool.cscontractdetailinfo.entityvo.CsContractDetailInfoVo;
import com.sunshineroad.driverschool.cscontractinfo.entityvo.CsContractInfoVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.ArrayList;
import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("csContractDetailInfoService")
@Transactional
public class CsContractDetailInfoServiceImpl extends BaseServiceImpl<CsContractDetailInfo, Integer>  implements CsContractDetailInfoService {
	@Autowired
	private CsContractDetailInfoDao  csContractDetailInfoDao;
	@Autowired	
	private SysParameterService sysParameterService;

	public List<CsContractDetailInfoVo> list(CsContractDetailInfo entity) {
		HQLParameter p = new HQLParameter(CsContractDetailInfo.class);	  
		StringBuffer hql = new StringBuffer(" FROM CsContractDetailInfo WHERE 1=1 ");
		
		if (null!=entity&&(null!=entity.getDeviceName()||null!=entity.getDeviceModel())) {
			hql.append(" AND ( 1!=1 ");
			hql.append(" or " + " deviceName like '%" + entity.getDeviceName() + "%'   ");
			hql.append(" AND " + " deviceModel like '%" + entity.getDeviceModel() + "%'   ");
			hql.append("  )");
		}
		
		//
		List<CsContractDetailInfoVo> list = ListUtils.transform(csContractDetailInfoDao.findPageByHql(hql.toString()), CsContractDetailInfoVo.class);
		List<CsContractDetailInfoVo> resultlist = new ArrayList<CsContractDetailInfoVo>();
		for(CsContractDetailInfoVo vo:list) {
			if (null!=vo.getDeviceModel()) {
				vo.setDeviceModelName(sysParameterService.getParameterNameById(Long.parseLong(vo.getDeviceModel())));
			}
			resultlist.add(vo);
		}
		
		return list;
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


