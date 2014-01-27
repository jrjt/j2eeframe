package com.sunshineroad.driverschool.cscustomerinfo.service;

import java.util.List;
 
import com.sunshineroad.driverschool.cscustomerinfo.entity.CsCustomerInfo;
import com.sunshineroad.driverschool.cscustomerinfo.entityvo.CsCustomerInfoVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface CsCustomerInfoService extends IBaseService<CsCustomerInfo, Integer>{
	public List<CsCustomerInfoVo> list(CsCustomerInfoVo entity) ;
}
