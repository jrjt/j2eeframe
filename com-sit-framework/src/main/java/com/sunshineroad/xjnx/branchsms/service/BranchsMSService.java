package com.sunshineroad.xjnx.branchsms.service;

import java.util.List;

import com.sunshineroad.xjnx.branchsms.vo.BranchsMSVo;

public interface BranchsMSService {

	public List<BranchsMSVo> getList(BranchsMSVo branchsmsVo) throws Exception;

	public void saveApply(BranchsMSVo pubVo, List<BranchsMSVo> splitlist)
			throws Exception;

	public List<BranchsMSVo> getSplitlist(BranchsMSVo branchsmsVo) throws Exception;


}
