package com.sunshineroad.xjnx.fundssums.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.framework.util.FtpUtils;
import com.sunshineroad.system.job.vo.RemoteActionVo;
import com.sunshineroad.xjnx.fundssums.dao.FundsSumsDao;
import com.sunshineroad.xjnx.fundssums.service.FundsSumsService;
import com.sunshineroad.xjnx.fundssums.vo.FundsSumsVo;

/**
 * omplatform com.sunshineroad.xjnx.assocustom.service.impl
 * 
 * @{# AssoCustomServiceImpl.java Create on 2013-6-13 上午9:48:06
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0 功能说明：（中心管理）客户号码关联操作
 * 
 */
@Service("fundssumsService")
public class FundsSumsServiceImpl implements FundsSumsService
{

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected FundsSumsDao<FundsSumsVo, Integer> fundsDao;

	@Override
	public List<FundsSumsVo> getFiles(RemoteActionVo rmtvo) throws Exception
	{
		FtpUtils ftptools= new FtpUtils();
		return ftptools.filelist(rmtvo);
	}

	@Override
	public boolean getTranDate()
	{
		String trandate_sql = "select trandate from xjbank.pubsysctrlinfo";

		List<FundsSumsVo> tran_list = this.fundsDao.selectBySql(
				FundsSumsVo.class, "trandate", trandate_sql);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (tran_list.size() > 0)
		{
			if (tran_list.get(0).getTrandate().equals(sdf.format(new Date())))
			{
				return true;
			}
			
		}
		return false;
	}
	
	public int updateTranDate()
	{
		String format = "yyyy-MM-dd";
		String Nxtdate = DateUtils.addDayS(new Date(), 1, "d", format);
		String update_sql="update xjbank.pubsysctrlinfo set trandate=?";
		return this.fundsDao.updateBySql(update_sql, Nxtdate);
	}

	@Override
	public String checkFilePath(String scanPath) throws Exception{
		String path = this.getClass().getProtectionDomain()
				.getCodeSource().getLocation().getPath();

		String scanFolderPath;
		if (path.indexOf("WEB-INF") > 0)
		{
			scanFolderPath = path.substring(0, path.indexOf("WEB-INF"))
					+ scanPath;
		} else
		{
			throw new IllegalAccessException("路径获取错误");
		}
		
		File newFile = new File(scanFolderPath);
		if (!newFile.exists())
		{
			newFile.mkdirs();
		}
		
		return scanFolderPath;
		
	}
}
