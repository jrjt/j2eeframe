package com.sunshineroad.xjnx.openaccounting.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.xjnx.openaccounting.dao.OpenAccountingDao;
import com.sunshineroad.xjnx.openaccounting.service.OpenAccountingService;
import com.sunshineroad.xjnx.openaccounting.vo.CountAcctVo;
import com.sunshineroad.xjnx.openaccounting.vo.OpenAccountingVo;

/**
 * omplatform com.sunshineroad.xjnx.assocustom.service.impl
 * 
 * @{# AssoCustomServiceImpl.java Create on 2013-7-19 上午9:48:06
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：打开手工记账
 * 
 */
@Service("openacctService")
public class OpenAccountingServiceImpl implements OpenAccountingService
{

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected OpenAccountingDao<OpenAccountingVo, Integer> opacctDao;

	@Autowired
	protected OpenAccountingDao<CountAcctVo, Integer> countDao;

	private String table_name = "xjbank.glsinbalacctinfo";

	@Override
	public List<OpenAccountingVo> getList(String acctno) throws Exception
	{
		String trandate_sql = "select ROWNUM id, acctno,acckind,accpagetype,accctrlflag,subctrlcode,seqno from "
				+ table_name + " where acctno= ? ";
		List<OpenAccountingVo> tran_list = this.opacctDao.selectBySql(
				OpenAccountingVo.class,
				"id,acctno,acckind,accpagetype,accctrlflag,subctrlcode,seqno",
				trandate_sql, acctno);
		return tran_list;
	}

	@Override
	public int OpenAccting(String acctno, String acckind, String accpagetype,
			String accctrlflag) throws Exception
	{

		String update_sql = "update " + table_name + " set ";
		if (!accctrlflag.equals("1")
				&& (acckind.equals("5") || accpagetype.equals("5")))
		{
			update_sql += "accctrlflag = '1',";
		} else if (!accctrlflag.equals("1"))
		{
			update_sql += "accctrlflag = '1'";
		}
		if (acckind.equals("5") && accpagetype.equals("5"))
		{
			update_sql += "acckind='3',";
		} else if (acckind.equals("5"))
		{
			update_sql += "acckind='3'";
		}
		if (accpagetype.equals("5"))
		{
			update_sql += "accpagetype='3'";
		}
		update_sql += " where acctno = ?";
		return this.opacctDao.updateBySql(update_sql, acctno);
	}

	@Override
	public int CloseAccting(String acctno, String old_accctrlflag,
			String old_acckind, String old_accpagetype) throws Exception
	{
		String update_sql = "update " + table_name + " set ";
		if (old_accctrlflag != null
				&& (old_acckind != null || old_accpagetype != null))
		{
			update_sql += "accctrlflag = '0',";
		} else if (old_accctrlflag != null)
		{
			update_sql += "accctrlflag = '0'";
		}
		if (old_acckind != null && old_accpagetype != null)
		{
			update_sql += "acckind='" + old_acckind + "',";
		} else if (old_acckind != null)
		{
			update_sql += "acckind='" + old_acckind + "'";
		}
		if (old_accpagetype != null)
		{
			update_sql += "accpagetype='" + old_accpagetype + "'";
		}
		update_sql += " where acctno = ?";
		return this.opacctDao.updateBySql(update_sql, acctno);
	}

	@Override
	public List<CountAcctVo> countAcct(String subctrlcode, BigDecimal seqno)
			throws Exception
	{
		String trandate_sql = "Select acckind,accpagetype, count('x') account from "+table_name
				+ " where accctrlflag='0' and subctrlcode=? and seqno="
				+ seqno
				+ " group by acckind,accpagetype order by account desc";
		List<CountAcctVo> tran_list = this.countDao.selectBySql(
				CountAcctVo.class, "acckind,accpagetype,account", trandate_sql,
				subctrlcode);
		return tran_list;

	}
}
