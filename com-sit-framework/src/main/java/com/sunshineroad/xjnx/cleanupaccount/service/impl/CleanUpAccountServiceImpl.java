package com.sunshineroad.xjnx.cleanupaccount.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.xjnx.cleanupaccount.dao.CleanUpAccountDao;
import com.sunshineroad.xjnx.cleanupaccount.service.CleanUpAccountService;
import com.sunshineroad.xjnx.cleanupaccount.vo.CleanUpAccountVo;

@Service("cleanupaccountService")
public class CleanUpAccountServiceImpl implements CleanUpAccountService
{

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected CleanUpAccountDao<CleanUpAccountVo, Integer> cleanupaccountDao;

	private String table_name = "xjbank.shsacctinfo";
	
	@Override
	public List<CleanUpAccountVo> getList(String acctno) throws Exception
	{
		
		String trandate_sql = "select ROWNUM id, acctno,custname,stlacctno,stat from "+table_name+" where acctno= ? ";
		List<CleanUpAccountVo> tran_list = this.cleanupaccountDao.selectBySql(
				CleanUpAccountVo.class, "id,acctno,custname,stlacctno,stat",
				trandate_sql, acctno);
		return tran_list;
	}
	
	@Override
	public int CleanUpAcct(String acctno) throws Exception
	{
		String update_sql = "update " + table_name + " set stlacctno = ' ' where acctno = ?";
		return this.cleanupaccountDao.updateBySql(update_sql, acctno);
		
	}

}
