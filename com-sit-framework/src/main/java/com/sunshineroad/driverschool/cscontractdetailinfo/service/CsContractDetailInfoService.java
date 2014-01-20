package com.sunshineroad.driverschool.cscontractdetailinfo.service;

import java.util.List;
 
import com.sunshineroad.driverschool.cscontractdetailinfo.entity.CsContractDetailInfo;
import com.sunshineroad.driverschool.cscontractdetailinfo.entityvo.CsContractDetailInfoVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface CsContractDetailInfoService extends IBaseService<CsContractDetailInfo, Integer>{
	public List<CsContractDetailInfoVo> list(CsContractDetailInfo entity) ;
}
