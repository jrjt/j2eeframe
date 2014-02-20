package com.sunshineroad.driverschool.csdevicearrivalinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.csdevicearrivalinfo.service.CsDeviceArrivalInfoService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.csdevicearrivalinfo.dao.CsDeviceArrivalInfoDao;
import com.sunshineroad.driverschool.csdevicearrivalinfo.entity.CsDeviceArrivalInfo;
import com.sunshineroad.driverschool.csdevicearrivalinfo.entityvo.CsDeviceArrivalInfoVo;
import com.sunshineroad.driverschool.csdeviceinfo.entityvo.CsDeviceInfoVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import com.sunshineroad.framework.util.ListUtils;

@Service("csDeviceArrivalInfoService")
@Transactional
public class CsDeviceArrivalInfoServiceImpl extends BaseServiceImpl<CsDeviceArrivalInfo, Integer>  implements CsDeviceArrivalInfoService {
	@Autowired
	private CsDeviceArrivalInfoDao  csDeviceArrivalInfoDao;
	@Autowired
	private SysParameterService sysParameterService;
	
	
	
	
	public List<CsDeviceArrivalInfoVo> list(CsDeviceArrivalInfo entity) {
		HQLParameter p = new HQLParameter(CsDeviceArrivalInfo.class);
		
		StringBuffer hql = new StringBuffer(" FROM CsDeviceArrivalInfo WHERE 1=1 ");
		
		if (entity!=null && (entity.getCustomerName()!=null || entity.getContractNumber()!=null || entity.getDeviceModel()!=null)) {
			hql.append(" AND ( 1!=1 ");
			hql.append(" OR "+" customerName like '%"+entity.getCustomerName()+"%'   ");
			hql.append(" AND "+" contractNumber like '%"+entity.getContractNumber()+"%'   ");
			hql.append(" AND "+" deviceModel like '%"+entity.getDeviceModel()+"%'   ");
			hql.append("  )");
		}
		
		List<CsDeviceArrivalInfoVo> list = ListUtils.transform(csDeviceArrivalInfoDao.findPageByHql(hql.toString()  ),
				CsDeviceArrivalInfoVo.class);
		List<CsDeviceArrivalInfoVo> resultlist = new ArrayList<CsDeviceArrivalInfoVo>();
		for(CsDeviceArrivalInfoVo vo:list){
			if (vo.getDeviceModel()!=null) {
				vo.setDeviceModelName(sysParameterService.getParameterNameById(Long.parseLong(vo.getDeviceModel())));
			}
			resultlist.add(vo);
		}
		
            return list; 
		}
	
		@Override
	public void update(CsDeviceArrivalInfo model)  {
		this.csDeviceArrivalInfoDao.update(model);	
	}
	
	@Override
	public CsDeviceArrivalInfo save(CsDeviceArrivalInfo model)   {
		this.csDeviceArrivalInfoDao.save(model);	
		return model;
	}

	@Override
	public void delete(CsDeviceArrivalInfo model)  {
		this.csDeviceArrivalInfoDao.delete(model);	
	}
}


