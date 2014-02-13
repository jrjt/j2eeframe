package com.sunshineroad.driverschool.csdeviceinfo.service;

import java.util.List;
 
import com.sunshineroad.driverschool.csdeviceinfo.entity.CsDeviceInfo;
import com.sunshineroad.driverschool.csdeviceinfo.entityvo.CsDeviceInfoVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface CsDeviceInfoService extends IBaseService<CsDeviceInfo, Integer>{
	public List<CsDeviceInfoVo> list(CsDeviceInfo entity) ;
}
