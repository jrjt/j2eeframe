package com.sunshineroad.driverschool.cscustomerinfo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.cscustomerinfo.service.CsCustomerInfoService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.cscustomerinfo.dao.CsCustomerInfoDao;
import com.sunshineroad.driverschool.cscustomerinfo.entity.CsCustomerInfo;
import com.sunshineroad.driverschool.cscustomerinfo.entityvo.CsCustomerInfoVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.ArrayList;
import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("csCustomerInfoService")
@Transactional
public class CsCustomerInfoServiceImpl extends BaseServiceImpl<CsCustomerInfo, Integer>  implements CsCustomerInfoService {
	@Autowired
	private CsCustomerInfoDao  csCustomerInfoDao;
	@Autowired
	private SysParameterService sysParameterService;

	public List<CsCustomerInfoVo> list(CsCustomerInfo entity) {
		HQLParameter p = new HQLParameter(CsCustomerInfo.class);	   
//		return ListUtils.transform(csCustomerInfoDao.findPageByHql(" from CsCustomerInfo "   ),
//				CsCustomerInfoVo.class);
		// 通过ID获取参数名
		List<CsCustomerInfoVo> list = ListUtils.transform(csCustomerInfoDao.findPageByHql("from CsCustomerInfo"), CsCustomerInfoVo.class);
		List<CsCustomerInfoVo> resultlist = new ArrayList<CsCustomerInfoVo>();
		for(CsCustomerInfoVo vo:list){
			if (vo.getArea()!=null) {
				vo.setAreaName(sysParameterService.getParameterNameById(Long.parseLong(vo.getArea())));
				vo.setCustomerTypeName(sysParameterService.getParameterNameById(Long.parseLong(vo.getCustomerType())));
			}
			resultlist.add(vo);
		}
		return list;
	}
	
		@Override
	public void update(CsCustomerInfo model)  {
		this.csCustomerInfoDao.update(model);	
	}
	
	@Override
	public CsCustomerInfo save(CsCustomerInfo model)   {
		this.csCustomerInfoDao.save(model);	
		return model;
	}

	@Override
	public void delete(CsCustomerInfo model)  {
		this.csCustomerInfoDao.delete(model);	
	}
}


