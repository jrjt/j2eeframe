package com.sunshineroad.xjnx.updateacctinfo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.xjnx.updateacctinfo.dao.UpdateAcctInfoDao;
import com.sunshineroad.xjnx.updateacctinfo.service.UpdateAcctInfoService;
import com.sunshineroad.xjnx.updateacctinfo.vo.UpdateAcctInfoVo;

/**
 * omplatform com.sunshineroad.xjnx.updateacctinfo.service.impl
 * 
 * @{# UpdateAcctInfoServiceImpl.java Create on 2013-7-23 上午9:12:50
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：
 * 
 */
@Service("updateacctinfoService")
public class UpdateAcctInfoServiceImpl implements UpdateAcctInfoService
{

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected UpdateAcctInfoDao<UpdateAcctInfoVo, Integer> updateacctDao;

	@Override
	public List<UpdateAcctInfoVo> getList(String acctno) throws Exception
	{
		String table_sql = "xjbank.lnsacctinfo";
		String trandate_sql = "select ROWNUM id,acctno,opendate,diacct,dbacct,"
				+ "substr(flag1,3,1) discountflag,substr(flag1,12,1) noaccrualflag,"
				+ "currduedate,loantype1,loanstat,intrestres1,authteller "
				+ "from " + table_sql + " where acctno= ? ";
		String fields = "id,acctno,opendate,diacct,dbacct,discountflag,"
				+ "noaccrualflag,currduedate,loantype1,loanstat,intrestres1,authteller";

		List<UpdateAcctInfoVo> tran_list = this.updateacctDao.selectBySql(
				UpdateAcctInfoVo.class, fields, trandate_sql, acctno);
		return tran_list;

	}

	@Override
	public int updateacctinfo(UpdateAcctInfoVo updateacctVo) throws Exception
	{
		String table_sql = "xjbank.lnsacctinfo";
		String update_set_sql = "update " + table_sql + " set ";
		String where_sql = " where acctno= ? ";
		String column_sql = null;
		String newvalue = null;
		String update_sql = null;

		// 更新开户日期
		if (updateacctVo.isOpendatechged())
		{
			newvalue = updateacctVo.getOpendate();
			column_sql = "opendate= ? ";

		}

		// 更新当前到期日
		if (updateacctVo.isCurrduedatechged())
		{
			String format = "yyyy-MM-dd";
			newvalue = DateUtils.dateFormatS(updateacctVo.getCurrduedate(),
					format);
			column_sql = "currduedate= ? ";

		}

		// 更新基本利率
		if (updateacctVo.isIntrestres1chged())
		{
			BigDecimal bigdvalue = updateacctVo.getIntrestres1();
			column_sql = "intrestres1= " + bigdvalue;
			update_sql = update_set_sql + column_sql + where_sql;
			return this.updateacctDao.updateBySql(update_sql,
					updateacctVo.getAcctno());

		}

		// 更新贴息标识
		if (updateacctVo.isDiscountflagchged())
		{
			newvalue = updateacctVo.getDiscountflag();
			column_sql = "flag1= substr(flag1,1,2)||?||substr(flag1,4)";

		}

		// 更新非应计标志
		if (updateacctVo.isNoaccrualflagchged())
		{
			newvalue = updateacctVo.getNoaccrualflag();
			column_sql = "flag1= substr(flag1,1,11)||?||substr(flag1,13)";

		}

		// 更新贷款种类1
		if (updateacctVo.isLoantype1chged())
		{
			Character charvalue = updateacctVo.getLoantype1();
			column_sql = "loantype1= " + charvalue;
			update_sql = update_set_sql + column_sql + where_sql;
			return this.updateacctDao.updateBySql(update_sql,
					updateacctVo.getAcctno());
		}

		// 更新贷款状态
		if (updateacctVo.isLoanstatchged())
		{
			newvalue = updateacctVo.getLoanstat();
			column_sql = "loanstat = ? ";
			if (updateacctVo.getOriginalValue().equals("08"))
			{
				column_sql = "loantype1= '1',authteller='0',loanstat = ? ";
				update_sql = update_set_sql + column_sql + where_sql;
				int account = this.updateacctDao.updateBySql(update_sql,
						newvalue, updateacctVo.getAcctno());
				if (account > 0)
				{
					table_sql = "xjbank.lnsacctdyninfo";
					update_set_sql = "update " + table_sql + " set ";
					where_sql = " where acctno= ? and status='1'";
					column_sql = "status='0' ";
					update_sql = update_set_sql + column_sql + where_sql;
					account += this.updateacctDao.updateBySql(update_sql,
							updateacctVo.getAcctno());
				}
				return account;
			}

		}

		// 还款账号
		if (updateacctVo.isDbacctchged() || updateacctVo.isDiacctchged())
		{
			newvalue = " ";
			column_sql = "dbacct= ? ,diacct= ? ";
			update_sql = update_set_sql + column_sql + where_sql;
			return this.updateacctDao.updateBySql(update_sql, newvalue,
					newvalue, updateacctVo.getAcctno());
		}
		update_sql = update_set_sql + column_sql + where_sql;
		return this.updateacctDao.updateBySql(update_sql, newvalue,
				updateacctVo.getAcctno());
	}
}
