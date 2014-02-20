package com.sunshineroad.driverschool.csdevicearrivalinfo.service;

import java.util.List;
 
import com.sunshineroad.driverschool.csdevicearrivalinfo.entity.CsDeviceArrivalInfo;
import com.sunshineroad.driverschool.csdevicearrivalinfo.entityvo.CsDeviceArrivalInfoVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface CsDeviceArrivalInfoService extends IBaseService<CsDeviceArrivalInfo, Integer>{
	public List<CsDeviceArrivalInfoVo> list(CsDeviceArrivalInfo entity) ;
}
