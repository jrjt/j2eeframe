package com.sunshineroad.driverschool.cscontractinfo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunshineroad.driverschool.cscontractdetailinfo.entityvo.CsContractDetailInfoVo;
import com.sunshineroad.driverschool.cscontractinfo.service.CsContractInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.cscontractinfo.dao.CsContractInfoDao;
import com.sunshineroad.driverschool.cscontractinfo.entity.CsContractInfo;
import com.sunshineroad.driverschool.cscontractinfo.entityvo.CsContractInfoVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;

import java.util.ArrayList;
import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("csContractInfoService")
@Transactional
public class CsContractInfoServiceImpl extends
		BaseServiceImpl<CsContractInfo, Integer> implements
		CsContractInfoService {
	@Autowired
	private CsContractInfoDao csContractInfoDao;
	@Autowired
	private SysParameterService sysParameterService;
	
	public List<CsContractInfoVo> list(CsContractInfo entity) {
		HQLParameter p = new HQLParameter(CsContractInfo.class);
		StringBuffer hql = new StringBuffer(" FROM CsContractInfo  WHERE 1=1");

		if (entity.getArea().length()==0&&
				entity.getCustomerName().length()==0&&
				entity.getContractType().length()==0&&
				entity.getCustomerType().length()==0) {// 查询参数全空时 返回全表结果
			hql = new StringBuffer("From CsContractInfo Where 1=1");
		}else{
			if (null != entity
					&& (null != entity.getArea()
							|| null != entity.getCustomerName()
							|| null != entity.getCustomerType() || null != entity
							.getContractType())) {
				hql.append(" AND ( 1!=1 ");
				hql.append(" or " + " area like '%" + entity.getArea() + "%'   ");
				hql.append(" AND " + " customerName like '%" + entity.getCustomerName() + "%'   ");
				hql.append(" AND " + " customerType like '%" + entity.getCustomerType() + "%'   ");
				hql.append(" AND " + " contractType like '%" + entity.getContractType() + "%'   ");
				hql.append("  )");
			}
		}
		// hql.append(" ORDER BY sortIndex");

		// 获取参数树
		List<CsContractInfoVo> list = ListUtils.transform(csContractInfoDao.findPageByHql(hql.toString()), CsContractInfoVo.class);
		List<CsContractInfoVo> resultlist = new ArrayList<CsContractInfoVo>();
		for(CsContractInfoVo vo:list) {
			if (null!=vo.getArea()) {
				vo.setAreaName(sysParameterService.getParameterNameById(Long.parseLong(vo.getArea())));
				vo.setCustomerTypeName(sysParameterService.getParameterNameById(Long.parseLong(vo.getCustomerType())));
				vo.setContractTypeName(sysParameterService.getParameterNameById(Long.parseLong(vo.getContractType())));
			}
			resultlist.add(vo);
		}
		
		return list;
		
//		return ListUtils.transform(
//				csContractInfoDao.findPageByHql(hql.toString()),
//				CsContractInfoVo.class);
	}

	@Override
	public void update(CsContractInfo model) {
		this.csContractInfoDao.update(model);
	}

	@Override
	public CsContractInfo save(CsContractInfo model) {
		this.csContractInfoDao.save(model);
		return model;
	}

	@Override
	public void delete(CsContractInfo model) {
		this.csContractInfoDao.delete(model);
	}
}
