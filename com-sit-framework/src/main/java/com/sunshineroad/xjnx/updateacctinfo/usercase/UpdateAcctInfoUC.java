package com.sunshineroad.xjnx.updateacctinfo.usercase;

import java.util.List;

import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.updateacctinfo.service.UpdateAcctInfoService;
import com.sunshineroad.xjnx.updateacctinfo.vo.UpdateAcctInfoVo;

/**
 * omplatform com.sunshineroad.xjnx.fundssums.usercase
 * 
 * @{# FundsSumsUC.java Create on 2013-7-23 上午8:45:31
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0 功能说明：更新贷款信息user case
 * 
 */
public class UpdateAcctInfoUC
{
	private static final Logger logger = Logger
			.getLogger(UpdateAcctInfoUC.class);

	private String actDesc = "修改贷款信息";

	private String successtxt;
	private String comments;
	private String columns;
	private String keys;
	private String keyvalues;
	private String oldvalue;
	private String newvalue;

	public Object getlist(UpdateAcctInfoService updateacctservice, String acctno)
			throws Exception
	{
		List<UpdateAcctInfoVo> getlist = updateacctservice.getList(acctno);
		if (getlist.size() == 0)
		{
			return ResponseUtils.sendFailure("无此账号信息，请确认账号是否正确");
		} else if (getlist.size() > 1)
		{
			return ResponseUtils.sendFailure("此账号信息多于一条，不可执行更新操作");
		}
		return ResponseUtils.sendPagination(getlist);
	}

	public Object updateacctinfo(UpdateAcctInfoService updateacctservice,
			UpdatelogService updatelogService,
			ActionlogService actionlogService, UpdateAcctInfoVo updateacctVo)
			throws Exception
	{
		keys = "acctno";
		keyvalues = updateacctVo.getAcctno();
		oldvalue = updateacctVo.getOriginalValue();
		String chkmessage = "记录已被修改，请查询确认后在作修改";
		// check whether the record has already changed
		List<UpdateAcctInfoVo> recordchk = updateacctservice.getList(keyvalues);

		if (updateacctVo.isOpendatechged())
		{
			if (!recordchk.get(0).getOpendate().equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（开户日期）";
			successtxt = "开户日期更新成功";
			comments = "开户日期更新失败";
			columns = "opendate";
			newvalue = updateacctVo.getOpendate();
		}

		if (updateacctVo.isCurrduedatechged())
		{
			if (!recordchk.get(0).getCurrduedate().equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（当前到期日）";
			successtxt = "当前到期日更新成功";
			comments = "当前到期日更新失败";
			columns = "currduedate";
			String format = "yyyy-MM-dd";
			newvalue = DateUtils.dateFormatS(updateacctVo.getCurrduedate(),
					format);
		}

		if (updateacctVo.isIntrestres1chged())
		{
			if (!recordchk.get(0).getIntrestres1().toString().equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（基准利率）";
			successtxt = "基准利率更新成功";
			comments = "基准利率更新失败";
			columns = "intrestres1";
			newvalue = updateacctVo.getIntrestres1().toString();
		}

		if (updateacctVo.isDiscountflagchged())
		{
			if (!recordchk.get(0).getDiscountflag().equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（贴息标志）";
			successtxt = "贴息标志更新成功";
			comments = "贴息标志更新失败";
			columns = "substr(flag1,3,1)";
			newvalue = updateacctVo.getDiscountflag();
		}

		if (updateacctVo.isNoaccrualflagchged())
		{
			if (!recordchk.get(0).getNoaccrualflag().equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（非应计标志）";
			successtxt = "非应计标志更新成功";
			comments = "非应计标志更新失败";
			columns = "substr(flag1,12,1)";
			newvalue = updateacctVo.getNoaccrualflag();
		}

		if (updateacctVo.isLoantype1chged())
		{
			if (!recordchk.get(0).getLoantype1().toString().equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（贷款种类1）";
			successtxt = "贷款种类1更新成功";
			comments = "贷款种类1更新失败";
			columns = "loantype1";
			newvalue = updateacctVo.getLoantype1().toString();
		}

		if (updateacctVo.isLoanstatchged())
		{
			if (!recordchk.get(0).getLoanstat().equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（贷款状态）";
			successtxt = "贷款状态更新成功";
			comments = "贷款状态更新失败";
			columns = "loanstat";
			newvalue = updateacctVo.getLoanstat();
			if (updateacctVo.getOriginalValue().equals("08"))
			{
				columns = "loanstat|loantype1|authteller";
				oldvalue += "|" + updateacctVo.getLoantype1() + "|"
						+ updateacctVo.getAuthteller();
				newvalue += "|1|0";
			}
		}

		if (updateacctVo.isDbacctchged() || updateacctVo.isDiacctchged())
		{
			String checkvalue;
			if(updateacctVo.isDbacctchged()){
				checkvalue = recordchk.get(0).getDbacct() + "|" + updateacctVo.getDiacct();
			}else
			{
				checkvalue = recordchk.get(0).getDiacct() + "|" + updateacctVo.getDbacct();
			}
			if (!checkvalue.equals(oldvalue))
			{
				return ResponseUtils.sendFailure(chkmessage);
			}
			actDesc += "（还款账号）";
			successtxt = "还款账号更新成功";
			comments = "还款账号更新失败";
			columns = "dbacct|diacct";
			newvalue = " | ";
		}

		int account = updateacctservice.updateacctinfo(updateacctVo);
		if (account > 0)
		{
			// save action log
			actionlogService.saveAlog(null, actDesc, true, "");

			// save update log
			String table = "xjbank.lnsacctinfo";
			Updatelog ulog = new Updatelog();
			ulog.setAction(actDesc);
			ulog.setTable_name(table);
			ulog.setKeys(keys);
			ulog.setKey_value(keyvalues);
			ulog.setColumns(columns);
			ulog.setOld_value(oldvalue);
			ulog.setNew_value(newvalue);

			updatelogService.saveUlog(ulog);

			if (updateacctVo.getOriginalValue().equals("08") && account > 1)
			{
				Updatelog ulogo = new Updatelog();
				table = "xjbank.lnsacctdyninfo";
				keys = "acctno|status";
				keyvalues += "|1";
				columns = "status";
				oldvalue = "1";
				newvalue = "0";
				ulogo.setAction(actDesc);
				ulogo.setTable_name(table);
				ulogo.setKeys(keys);
				ulogo.setKey_value(keyvalues);
				ulogo.setColumns(columns);
				ulogo.setOld_value(oldvalue);
				ulogo.setNew_value(newvalue);

				updatelogService.saveUlog(ulogo);
			}

			return ResponseUtils.sendSuccess(successtxt);
		}
		actionlogService.saveAlog(null, actDesc, false, comments);
		return ResponseUtils.sendFailure(comments);
	}

}
