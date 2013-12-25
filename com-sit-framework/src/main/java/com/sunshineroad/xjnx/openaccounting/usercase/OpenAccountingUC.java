package com.sunshineroad.xjnx.openaccounting.usercase;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.StringHandling;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.xjnx.openaccounting.service.OpenAccountingService;
import com.sunshineroad.xjnx.openaccounting.vo.CountAcctVo;
import com.sunshineroad.xjnx.openaccounting.vo.OpenAccountingVo;

/**
 * omplatform com.sunshineroad.xjnx.fundssums.usercase
 * 
 * @{# FundsSumsUC.java Create on 2013-7-9 上午8:45:31
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0 功能说明：打开手工记账user case
 * 
 */
public class OpenAccountingUC
{
	private static final Logger logger = Logger
			.getLogger(OpenAccountingUC.class);

	private String actDesc = "打开手工记账";

	private String columns;
	private String keys = "acctno";
	private String keyvalues;
	private String oldvalue;
	private String newvalue;

	public Object getlist(OpenAccountingService opactservice, String acctno)
			throws Exception
	{
		List<OpenAccountingVo> getlist = opactservice.getList(acctno);
		if (getlist.size() == 0)
		{
			return ResponseUtils.sendFailure("无此账号信息，请确认账号是否正确");
		} else if (getlist.size() > 1)
		{
			return ResponseUtils.sendFailure("此账号信息多于一条，不可执行打开手工记账操作");
		}
		return ResponseUtils.sendPagination(getlist);
	}

	public Object openAcct(OpenAccountingService opactservice,
			UpdatelogService updatelogService,
			ActionlogService actionlogService, String acctno, String acckind,
			String accpagetype, String accctrlflag) throws Exception
	{
		String chkmessage = "记录已被修改，请查询确认后在作修改";
		actDesc += "（打开）";
		List<OpenAccountingVo> recordchk = opactservice.getList(acctno);
		if (!recordchk.get(0).getAcckind().toString().equals(acckind)
				|| !recordchk.get(0).getAccpagetype().toString()
						.equals(accpagetype)
				|| !recordchk.get(0).getAccctrlflag().toString()
						.equals(accctrlflag))
		{
			return ResponseUtils.sendFailure(chkmessage);
		}

		int account = opactservice.OpenAccting(acctno, acckind, accpagetype,
				accctrlflag);
		if (account > 0)
		{
			// save action log
			actionlogService.saveAlog(null, actDesc, true, "");

			// save update log
			String table = "xjbank.glsinbalacctinfo";
			keyvalues = acctno;
			if (!accctrlflag.equals("1"))
			{
				columns = "accctrlflag";
				oldvalue = accctrlflag;
				newvalue = "1";
			}

			if (acckind.equals("5"))
			{
				if (!StringUtils.isNotBlank(columns))
				{
					columns = "acckind";
					oldvalue = acckind;
					newvalue = "3";
				} else
				{
					columns += "|acckind";
					oldvalue += "|" + acckind;
					newvalue += "|3";
				}
			}
			if (accpagetype.equals("5"))
			{
				if (!StringUtils.isNotBlank(columns))
				{
					columns = "accpagetype";
					oldvalue = accpagetype;
					newvalue = "3";
				} else
				{
					columns += "|accpagetype";
					oldvalue += "|" + accpagetype;
					newvalue += "|3";
				}
			}
			Updatelog ulog = new Updatelog();
			ulog.setAction(actDesc);
			ulog.setTable_name(table);
			ulog.setKeys(keys);
			ulog.setKey_value(keyvalues);
			ulog.setColumns(columns);
			ulog.setOld_value(oldvalue);
			ulog.setNew_value(newvalue);
			ulog.setFlag("O");

			updatelogService.saveUlog(ulog);
		}

		return ResponseUtils.sendSuccess("记账功能打开成功");

	}

	public Object closeAcct(OpenAccountingService opactservice,
			UpdatelogService updatelogService,
			ActionlogService actionlogService, String acctno, String acckind,
			String accpagetype, String accctrlflag) throws Exception
	{
		String chkmessage = "记录已被修改，请查询确认后在作修改";
		actDesc += "（关闭）";
		List<OpenAccountingVo> recordchk = opactservice.getList(acctno);
		if (!recordchk.get(0).getAcckind().toString().equals(acckind)
				|| !recordchk.get(0).getAccpagetype().toString()
						.equals(accpagetype)
				|| !recordchk.get(0).getAccctrlflag().toString()
						.equals(accctrlflag))
		{
			return ResponseUtils.sendFailure(chkmessage);
		}
		// get the old value
		String table = "xjbank.glsinbalacctinfo";
		String flag = "O";
		String keyvalues = acctno;
		String old_accctrlflag = null;
		String old_acckind = null;
		String old_accpagetype = null;
		StringHandling srtinghandling = new StringHandling();
		List<Updatelog> openhistory = updatelogService.findRecord(table, keys,
				keyvalues, flag);
		if (openhistory != null && openhistory.size() > 0)
		{
			columns = openhistory.get(0).getColumns();
			newvalue = openhistory.get(0).getOld_value();
			String[] col_entitys = srtinghandling.splitstring(columns, "\\|");
			String[] val_entitys = srtinghandling.splitstring(newvalue, "\\|");
			if (col_entitys.length == 3)
			{
				// first column be checked
				if (col_entitys[0].equals("accctrlflag"))
				{
					old_accctrlflag = val_entitys[0];
					oldvalue = recordchk.get(0).getAccctrlflag().toString();
				} else if (col_entitys[0].equals("acckind"))
				{
					old_acckind = val_entitys[0];
					oldvalue = recordchk.get(0).getAcckind().toString();
				} else
				{
					old_accpagetype = val_entitys[0];
					oldvalue = recordchk.get(0).getAccpagetype().toString();
				}

				// second column be checked
				if (col_entitys[1].equals("accctrlflag"))
				{
					old_accctrlflag = val_entitys[1];
					oldvalue += "|"
							+ recordchk.get(0).getAccctrlflag().toString();
				} else if (col_entitys[1].equals("acckind"))
				{
					old_acckind = val_entitys[1];
					oldvalue += "|" + recordchk.get(0).getAcckind().toString();
				} else
				{
					old_accpagetype = val_entitys[1];
					oldvalue += "|"
							+ recordchk.get(0).getAccpagetype().toString();
				}

				// third column be checked
				if (col_entitys[2].equals("accctrlflag"))
				{
					old_accctrlflag = val_entitys[2];
					oldvalue += "|"
							+ recordchk.get(0).getAccctrlflag().toString();
				} else if (col_entitys[2].equals("acckind"))
				{
					old_acckind = val_entitys[2];
					oldvalue += "|" + recordchk.get(0).getAcckind().toString();
				} else
				{
					old_accpagetype = val_entitys[2];
					oldvalue += "|"
							+ recordchk.get(0).getAccpagetype().toString();
				}
			}

			if (col_entitys.length == 2)
			{
				// first column be checked
				if (col_entitys[0].equals("accctrlflag"))
				{
					old_accctrlflag = val_entitys[0];
					oldvalue = recordchk.get(0).getAccctrlflag().toString();
				} else if (col_entitys[0].equals("acckind"))
				{
					old_acckind = val_entitys[0];
					oldvalue = recordchk.get(0).getAcckind().toString();
				} else
				{
					old_accpagetype = val_entitys[0];
					oldvalue = recordchk.get(0).getAccpagetype().toString();
				}

				// second column be checked
				if (col_entitys[1].equals("accctrlflag"))
				{
					old_accctrlflag = val_entitys[1];
					oldvalue += "|"
							+ recordchk.get(0).getAccctrlflag().toString();
				} else if (col_entitys[1].equals("acckind"))
				{
					old_acckind = val_entitys[1];
					oldvalue += "|" + recordchk.get(0).getAcckind().toString();
				} else
				{
					old_accpagetype = val_entitys[1];
					oldvalue += "|"
							+ recordchk.get(0).getAccpagetype().toString();
				}

			}

			if (col_entitys.length == 1)
			{
				// first column be checked
				if (col_entitys[0].equals("accctrlflag"))
				{
					old_accctrlflag = val_entitys[0];
					oldvalue = recordchk.get(0).getAccctrlflag().toString();
				} else if (col_entitys[0].equals("acckind"))
				{
					old_acckind = val_entitys[0];
					oldvalue = recordchk.get(0).getAcckind().toString();
				} else
				{
					old_accpagetype = val_entitys[0];
					oldvalue = recordchk.get(0).getAccpagetype().toString();
				}
			}
		} else
		{
			List<CountAcctVo> countResult = opactservice.countAcct(recordchk
					.get(0).getSubctrlcode(), recordchk.get(0).getSeqno());
			if (countResult != null && countResult.size() > 0)
			{
				old_accctrlflag = "0";
				columns = "accctrlflag";
				newvalue = "0";
				oldvalue = accctrlflag;
				if (!countResult.get(0).getAcckind().toString().equals(acckind))
				{
					old_acckind = countResult.get(0).getAcckind().toString();
					columns += "|acckind";
					newvalue += "|" + old_acckind;
					oldvalue += "|" + acckind;
				}
				if (!countResult.get(0).getAccpagetype().toString()
						.equals(accpagetype))
				{
					old_accpagetype = countResult.get(0).getAccpagetype()
							.toString();
					columns += "|accpagetype";
					newvalue += "|" + old_accpagetype;
					oldvalue += "|" + accpagetype;
				}

			} else
			{
				old_accctrlflag = "0";
				columns = "accctrlflag";
				newvalue = "0";
				oldvalue = accctrlflag;
			}
		}

		int account = opactservice.CloseAccting(acctno, old_accctrlflag,
				old_acckind, old_accpagetype);
		if (account > 0)
		{
			// save action log
			actionlogService.saveAlog(null, actDesc, true, "");

			// save update log

			Updatelog ulog = new Updatelog();
			ulog.setAction(actDesc);
			ulog.setTable_name(table);
			ulog.setKeys(keys);
			ulog.setKey_value(keyvalues);
			ulog.setColumns(columns);
			ulog.setOld_value(oldvalue);
			ulog.setNew_value(newvalue);
			ulog.setFlag("C");

			updatelogService.saveUlog(ulog);
		}

		return ResponseUtils.sendSuccess("记账功能关闭成功");

	}
}
