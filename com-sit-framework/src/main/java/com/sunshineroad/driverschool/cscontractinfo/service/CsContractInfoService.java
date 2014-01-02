package com.sunshineroad.driverschool.cscontractinfo.service;

import java.util.List;
 
import com.sunshineroad.driverschool.cscontractinfo.entity.CsContractInfo;
import com.sunshineroad.driverschool.cscontractinfo.entityvo.CsContractInfoVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface CsContractInfoService extends IBaseService<CsContractInfo, Integer>{
	public List<CsContractInfoVo> list(CsContractInfo entity) ;
}
