package com.sunshineroad.xjnx.updatebonusflag.service;

import java.util.List;

import com.sunshineroad.xjnx.updatebonusflag.vo.UpdateBonusFlagVo;

public interface UpdateBonusFlagService {

	public List<UpdateBonusFlagVo> getList(String acctno) throws Exception;

	public int updateFlag(UpdateBonusFlagVo updatebonusflagVo)throws Exception;

}
