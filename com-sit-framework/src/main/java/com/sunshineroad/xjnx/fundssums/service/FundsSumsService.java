package com.sunshineroad.xjnx.fundssums.service;

import java.util.List;

import com.sunshineroad.system.job.vo.RemoteActionVo;
import com.sunshineroad.xjnx.fundssums.vo.FundsSumsVo;

public interface FundsSumsService {

	public List<FundsSumsVo> getFiles(RemoteActionVo rmtvo) throws Exception;
	
	public String checkFilePath(String scanPath) throws Exception;
	
	public boolean getTranDate();
	
	public int updateTranDate();

}
