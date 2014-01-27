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

	public List<CsCustomerInfoVo> list(CsCustomerInfoVo entity) {
		HQLParameter p = new HQLParameter(CsCustomerInfo.class);
		StringBuffer hql = new StringBuffer("FROM CsCustomerInfo WHERE 1=1");
		if (null != entity
				&& (null != entity.getArea()
						|| null != entity.getCustomerName()
						|| null != entity.getCustomerType() || null != entity
						.getCustomerPeople())) {
			hql.append(" AND ( 1!=1 ");
			hql.append(" or " + " area like '%" + entity.getArea() + "%'   ");
			hql.append(" and " + " customerName like '%" + entity.getCustomerName() + "%'   ");
			hql.append(" and " + " customerType like '%" + entity.getCustomerType() + "%'   ");
			hql.append(" and " + " customerPeople like '%" + entity.getCustomerPeople() + "%'   ");
			hql.append("  )");
		}else{
			hql = new StringBuffer("FROM CsCustomerInfo WHERE 1=1");
		}
		
		// 通过ID获取参数名
		List<CsCustomerInfoVo> list = ListUtils.transform(csCustomerInfoDao.findPageByHql(hql.toString()), CsCustomerInfoVo.class);
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


