package com.sunshineroad.xjnx.tellersignout.service;

import java.util.List;

import com.sunshineroad.xjnx.tellersignout.vo.TellerSignOutVo;

public interface TellerSignOutService {

	public List<TellerSignOutVo> getList(TellerSignOutVo tellervo) throws Exception;

	public void tellerSignOut(TellerSignOutVo tellervo) throws Exception;

	public void tellerReset(TellerSignOutVo tellervo) throws Exception;

}
