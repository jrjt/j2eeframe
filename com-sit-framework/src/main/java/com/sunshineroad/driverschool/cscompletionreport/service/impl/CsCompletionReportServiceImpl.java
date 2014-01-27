package com.sunshineroad.driverschool.cscompletionreport.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.cscompletionreport.service.CsCompletionReportService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.cscompletionreport.dao.CsCompletionReportDao;
import com.sunshineroad.driverschool.cscompletionreport.entity.CsCompletionReport;
import com.sunshineroad.driverschool.cscompletionreport.entityvo.CsCompletionReportVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("csCompletionReportService")
@Transactional
public class CsCompletionReportServiceImpl extends BaseServiceImpl<CsCompletionReport, Integer>  implements CsCompletionReportService {
	@Autowired
	private CsCompletionReportDao  csCompletionReportDao;
	
	@Autowired
	private SysParameterService sysParameterService;

	public List<CsCompletionReportVo> list(CsCompletionReport entity) {
		HQLParameter p = new HQLParameter(CsCompletionReport.class);	   
//		return ListUtils.transform(csCompletionReportDao.findPageByHql(" from CsCompletionReport "   ),
//				CsCompletionReportVo.class);
		StringBuffer hql = new StringBuffer(" FROM CsCompletionReport WHERE 1=1 ");
		if (null!=entity&&(null!=entity.getReportNumber()||null!=entity.getContractNumber()||null!=entity.getReportType())) {
			hql.append(" AND ( 1!=1 ");
			hql.append(" or "+" reportNumber like '%"+entity.getReportNumber()+"%'   ");
			hql.append(" AND "+" contractNumber like '%"+entity.getContractNumber()+"%'   ");
			hql.append(" AND "+" reportType like '%"+entity.getReportType()+"%'   ");
			hql.append("  )");
		}
		
		
		// 以下通过ID获取参数名
		List<CsCompletionReportVo> list = ListUtils.transform(csCompletionReportDao.findPageByHql(hql.toString()),
				CsCompletionReportVo.class);
		List<CsCompletionReportVo> resultlist = new ArrayList<CsCompletionReportVo>();
		for(CsCompletionReportVo vo:list){
			if (vo.getReportType()!=null) {
				vo.setParameterName(sysParameterService.getParameterNameById(Long.parseLong(vo.getReportType())));
			}
			resultlist.add(vo);
		}
		return list;
	}
	
		@Override
	public void update(CsCompletionReport model)  {
		this.csCompletionReportDao.update(model);	
	}
	
	@Override
	public CsCompletionReport save(CsCompletionReport model)   {
		this.csCompletionReportDao.save(model);	
		return model;
	}

	@Override
	public void delete(CsCompletionReport model)  {
		this.csCompletionReportDao.delete(model);	
	}
}


