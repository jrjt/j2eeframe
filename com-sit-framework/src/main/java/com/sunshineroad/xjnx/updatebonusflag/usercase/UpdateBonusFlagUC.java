package com.sunshineroad.xjnx.updatebonusflag.usercase;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.updateacctinfo.service.UpdateAcctInfoService;
import com.sunshineroad.xjnx.updateacctinfo.vo.UpdateAcctInfoVo;
import com.sunshineroad.xjnx.updatebonusflag.service.UpdateBonusFlagService;
import com.sunshineroad.xjnx.updatebonusflag.vo.UpdateBonusFlagVo;

public class UpdateBonusFlagUC
{
	private static final Logger logger = Logger.getLogger(UpdateBonusFlagUC.class);
	
	private String actDesc = "清除红利入账标志";

	public Object getlist(UpdateBonusFlagService updatebonusflagService,String acctno) throws Exception
	{
		List<UpdateBonusFlagVo> getlist = updatebonusflagService.getList(acctno);

		if (getlist.size() <= 0)
		{
			return ResponseUtils.sendFailure("无此账号信息，请确认账号是否正确");
		}
		
		return ResponseUtils.sendPagination(getlist);
	}
	
	public Object updatflag(UpdateBonusFlagService updatebonusflagService,
			UpdatelogService updatelogService,
			ActionlogService actionlogService, UpdateBonusFlagVo updatebonusflagVo)
			throws Exception
	{
		String chkmessage = "记录已被修改，请查询确认后在作修改";
		//check whether the record has already changed
		List<UpdateBonusFlagVo> recordchk = updatebonusflagService.getList(updatebonusflagVo.getAcctno());
		if(recordchk.get(0).getFlag().equals(updatebonusflagVo.getOriginalValue()))
		{
			return ResponseUtils.sendFailure(chkmessage);
		}
		
		int account = updatebonusflagService.updateFlag(updatebonusflagVo);
		if (account > 0)
		{
			// save action log
			actionlogService.saveAlog(null, actDesc, true, "");

			// save update log
			String table = "xjbank.shsproaltreg";
			String keys = "acctno|year";
			String keyvalues = updatebonusflagVo.getAcctno()+"|"+updatebonusflagVo.getYear();
			String columns = "flag";
			String oldvalue = updatebonusflagVo.getOriginalValue();
			String newvalue = updatebonusflagVo.getFlag();

		
			Updatelog ulog = new Updatelog();
			ulog.setAction(actDesc);
			ulog.setTable_name(table);
			ulog.setKeys(keys);
			ulog.setKey_value(keyvalues);
			ulog.setColumns(columns);
			ulog.setOld_value(oldvalue);
			ulog.setNew_value(newvalue);

			updatelogService.saveUlog(ulog);
			
			return ResponseUtils.sendSuccess("更改红利入账标志成功");
		}
		
		actionlogService.saveAlog(null, actDesc, false, "更改红利入账标志失败");
		return ResponseUtils.sendFailure("更改红利入账标志失败");
		
	}
}
