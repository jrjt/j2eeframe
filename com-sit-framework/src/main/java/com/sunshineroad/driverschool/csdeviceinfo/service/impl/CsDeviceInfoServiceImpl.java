package com.sunshineroad.driverschool.csdeviceinfo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.star.i18n.ForbiddenCharacters;
import com.sunshineroad.driverschool.cscompletionreport.entityvo.CsCompletionReportVo;
import   com.sunshineroad.driverschool.csdeviceinfo.service.CsDeviceInfoService;
 





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.driverschool.csdeviceinfo.dao.CsDeviceInfoDao;
import com.sunshineroad.driverschool.csdeviceinfo.entity.CsDeviceInfo;
import com.sunshineroad.driverschool.csdeviceinfo.entityvo.CsDeviceInfoVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;







import java.util.ArrayList;
import java.util.List;

import com.sunshineroad.framework.util.ListUtils;

@Service("csDeviceInfoService")
@Transactional
public class CsDeviceInfoServiceImpl extends BaseServiceImpl<CsDeviceInfo, Integer>  implements CsDeviceInfoService {
	@Autowired
	private CsDeviceInfoDao  csDeviceInfoDao;
	@Autowired
	private SysParameterService sysParameterService;

	public List<CsDeviceInfoVo> list(CsDeviceInfo entity) {
		HQLParameter p = new HQLParameter(CsDeviceInfo.class);	
		
		StringBuffer hql = new StringBuffer(" FROM CsDeviceInfo WHERE 1=1 ");
	
		if (null!=entity&&(null!=entity.getDeviceName()||null!=entity.getDeviceModel()||null!=entity.getDeviceDestination()
				||null!=entity.getOperationMode()	
				)){
			hql.append(" AND ( 1!=1 ");
			hql.append(" or "+" deviceName like '%"+entity.getDeviceName()+"%'   ");
			hql.append(" AND "+" deviceModel like '%"+entity.getDeviceModel()+"%'   ");
			hql.append(" AND "+" deviceDestination like '%"+entity.getDeviceDestination()+"%'   ");
			hql.append(" AND "+" operationMode like '%"+entity.getOperationMode()+"%'   ");
			hql.append("  )");	
		  
		}
		
		List<CsDeviceInfoVo> list = ListUtils.transform(csDeviceInfoDao.findPageByHql(hql.toString()),
				CsDeviceInfoVo.class);
		List<CsDeviceInfoVo> resultlist = new ArrayList<CsDeviceInfoVo>();
		for(CsDeviceInfoVo vo:list){
			if (vo.getDeviceModel()!=null) {
				vo.setDeviceModelName(sysParameterService.getParameterNameById(Long.parseLong(vo.getDeviceModel())));
				vo.setOperationModeName(sysParameterService.getParameterNameById(Long.parseLong(vo.getOperationMode())));
			}
			resultlist.add(vo);
		}
		
            return list; 
		}
	
	@Override
	public void update(CsDeviceInfo model)  {
		this.csDeviceInfoDao.update(model);	
	}
	
	@Override
	public CsDeviceInfo save(CsDeviceInfo model)   {
		this.csDeviceInfoDao.save(model);	
		return model;
	}

	@Override
	public void delete(CsDeviceInfo model)  {
		this.csDeviceInfoDao.delete(model);	
	}
}


