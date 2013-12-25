package com.sunshineroad.xjnx.branchsms.usercase;

import java.util.List;
import org.apache.log4j.Logger;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.branchsms.service.BranchsMSService;
import com.sunshineroad.xjnx.branchsms.vo.BranchsMSVo;

public class BranchsMSUC
{
	private static final Logger logger = Logger.getLogger(BranchsMSUC.class);

	public Object getlist(BranchsMSService branchsmsService,BranchsMSVo branchsmsVo) throws Exception
	{
		List<BranchsMSVo> getlist = branchsmsService.getList(branchsmsVo);

		return ResponseUtils.sendPagination(getlist);
	}
	
	public Object getsplitlist(BranchsMSService branchsmsService,BranchsMSVo branchsmsVo) throws Exception
	{
		List<BranchsMSVo> getlist = branchsmsService.getSplitlist(branchsmsVo);

		return ResponseUtils.sendPagination(getlist);
	}
	
	public Object saveApply(BranchsMSService branchsmsService,UpdatelogService updatelogService,
			ActionlogService actionlogService, BranchsMSVo pubVo, List<BranchsMSVo> splitlist) throws Exception
	{
		String actDesc = "农信银机构撤并拆分";
		branchsmsService.saveApply(pubVo,splitlist);
		
/*		Updatelog ulog = new Updatelog();
		ulog.setAction(actDesc);
		ulog.setTable_name("xjbank.pubbranchinfo");
		ulog.setKeys("tellercode");
		ulog.setKey_value(brcvo.getBrccode());
		ulog.setColumns("status");
		ulog.setOld_value(brcvo.getStatus().toString());
		ulog.setNew_value("4");
		
		updatelogService.saveUlog(ulog);*/
		
		actionlogService.saveAlog(null, actDesc, true, "");
		
		return ResponseUtils.sendSuccess("提交成功");
	}
}
