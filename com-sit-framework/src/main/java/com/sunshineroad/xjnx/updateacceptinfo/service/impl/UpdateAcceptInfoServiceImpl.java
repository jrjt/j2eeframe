package com.sunshineroad.xjnx.updateacceptinfo.service.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.xjnx.updateacceptinfo.dao.UpdateAcceptInfoDao;
import com.sunshineroad.xjnx.updateacceptinfo.service.UpdateAcceptInfoService;
import com.sunshineroad.xjnx.updateacceptinfo.vo.UpdateAcceptInfoVo;

@Service("updateacceptinfoService")
public class UpdateAcceptInfoServiceImpl implements UpdateAcceptInfoService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected UpdateAcceptInfoDao<UpdateAcceptInfoVo, Integer> updateacceptinfoDao;

	@Override
	public List<UpdateAcceptInfoVo> getList(UpdateAcceptInfoVo updateacceptinfoVo) throws Exception
	{

		return null;
	}
	

}
