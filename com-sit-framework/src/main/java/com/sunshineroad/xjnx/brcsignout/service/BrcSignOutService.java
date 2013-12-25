package com.sunshineroad.xjnx.brcsignout.service;

import java.util.List;

import com.sunshineroad.xjnx.brcsignout.vo.BrcSignOutVo;

public interface BrcSignOutService {

	public List<BrcSignOutVo> getList(BrcSignOutVo brcvo) throws Exception;

	public void brcSignOut(BrcSignOutVo brcvo) throws Exception;

}
