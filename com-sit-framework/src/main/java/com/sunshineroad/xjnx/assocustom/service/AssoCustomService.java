package com.sunshineroad.xjnx.assocustom.service;

import java.util.List;

import com.sunshineroad.xjnx.assocustom.vo.AssoCustomVo;

public interface AssoCustomService {

	public List<AssoCustomVo> update(AssoCustomVo assoCustom,StringBuffer errorinfo) throws Exception;

	public List<AssoCustomVo> list(String acctno, StringBuffer errorinfo);

	public AssoCustomVo getcustominfo(String customid, StringBuffer errorinfo);
}
