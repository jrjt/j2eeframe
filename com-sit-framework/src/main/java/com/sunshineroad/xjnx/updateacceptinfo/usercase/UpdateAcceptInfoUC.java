package com.sunshineroad.xjnx.updateacceptinfo.usercase;

import java.util.List;
import org.apache.log4j.Logger;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.updateacceptinfo.service.UpdateAcceptInfoService;
import com.sunshineroad.xjnx.updateacceptinfo.vo.UpdateAcceptInfoVo;

public class UpdateAcceptInfoUC
{
	private static final Logger logger = Logger.getLogger(UpdateAcceptInfoUC.class);

	public Object getlist(UpdateAcceptInfoService updateacceptinfoService,UpdateAcceptInfoVo updateacceptinfoVo) throws Exception
	{
		List<UpdateAcceptInfoVo> getlist = updateacceptinfoService.getList(updateacceptinfoVo);

		return ResponseUtils.sendPagination(getlist);
	}
}
