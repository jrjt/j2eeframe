package com.sunshineroad.xjnx.updatebonusflag.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.xjnx.updatebonusflag.dao.UpdateBonusFlagDao;
import com.sunshineroad.xjnx.updatebonusflag.service.UpdateBonusFlagService;
import com.sunshineroad.xjnx.updatebonusflag.vo.UpdateBonusFlagVo;

@Service("updatebonusflagService")
public class UpdateBonusFlagServiceImpl implements UpdateBonusFlagService
{

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected UpdateBonusFlagDao<UpdateBonusFlagVo, Integer> updatebonusflagDao;

	private String table_name = "xjbank.shsproaltreg";

	@Override
	public List<UpdateBonusFlagVo> getList(String acctno) throws Exception
	{
		String trandate_sql = "select ROWNUM id, acctno,year,clsamt,flag from "
				+ table_name + " where acctno= ? ";
		List<UpdateBonusFlagVo> tran_list = this.updatebonusflagDao
				.selectBySql(UpdateBonusFlagVo.class,
						"id,acctno,year,clsamt,flag", trandate_sql, acctno);
		return tran_list;
	}

	@Override
	public int updateFlag(UpdateBonusFlagVo updatebonusflagVo) throws Exception
	{
		String update_sql = "update " + table_name
				+ " set flag = ? where acctno = ? and year = "
				+ updatebonusflagVo.getYear();
		return this.updatebonusflagDao.updateBySql(update_sql,
				updatebonusflagVo.getFlag(), updatebonusflagVo.getAcctno());

	}

}
