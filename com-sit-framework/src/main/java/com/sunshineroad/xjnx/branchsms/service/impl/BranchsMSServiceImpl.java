package com.sunshineroad.xjnx.branchsms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.xjnx.branchsms.dao.BranchsMSDao;
import com.sunshineroad.xjnx.branchsms.service.BranchsMSService;
import com.sunshineroad.xjnx.branchsms.vo.BranchsMSVo;

@Service("branchsmsService")
public class BranchsMSServiceImpl implements BranchsMSService {

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected BranchsMSDao<BranchsMSVo, Integer> branchsmsDao;

	@Override
	public List<BranchsMSVo> getList(BranchsMSVo branchsmsVo) throws Exception {
		List<BranchsMSVo> list = new ArrayList<BranchsMSVo>();
		boolean prodate = StringUtils.isNotBlank(branchsmsVo.getProdate());
		boolean probrc = StringUtils.isNotBlank(branchsmsVo.getProbrc());
		boolean promode = false;
		if (branchsmsVo.getPromode() != null) {
			promode = true;
		}
		String vo_column = "prodate,probrc,promode,oppbrc,modidate,teller,proflag";
		String select_sql = "select prodate,probrc,promode,oppbrc,modidate,teller,flag as proflag"
				+ " from glsbrcprodef ";

		if (prodate) {
			if (probrc) {
				if (promode) {
					select_sql = select_sql
							+ "where prodate = ? and probrc = ? and promode = ? ";
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql, branchsmsVo.getProdate(),
							branchsmsVo.getProbrc(), branchsmsVo.getPromode());
				} else {
					select_sql = select_sql
							+ "where prodate = ? and probrc = ? ";
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql, branchsmsVo.getProdate(),
							branchsmsVo.getProbrc());
				}
			} else {
				if (promode) {
					select_sql = select_sql
							+ "where prodate = ? and promode = ? ";
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql, branchsmsVo.getProdate(),
							branchsmsVo.getPromode());
				} else {
					select_sql = select_sql + "where prodate = ? ";
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql, branchsmsVo.getProdate());
				}
			}
		} else {
			if (probrc) {
				if (promode) {
					select_sql = select_sql
							+ "where probrc = ? and promode = ? ";
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql, branchsmsVo.getProbrc(),
							branchsmsVo.getPromode());
				} else {
					select_sql = select_sql + "where  probrc = ? ";
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql, branchsmsVo.getProbrc());
				}
			} else {
				if (promode) {
					select_sql = select_sql + "where  promode = ? ";
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql, branchsmsVo.getPromode());
				} else {
					list = branchsmsDao.selectBySql(BranchsMSVo.class,
							vo_column, select_sql);
				}
			}
		}

		return list;
	}

	@Override
	public List<BranchsMSVo> getSplitlist(BranchsMSVo branchsmsVo)
			throws Exception {
		List<BranchsMSVo> list = new ArrayList<BranchsMSVo>();
		String vo_column = "splitflag,subsys,subctrlcode,acctno";
		String select_sql = "select flag as splitflag,subsys,subctrlcode,acctno"
				+ " from glsbrcsplitacctdef where probrc = ? and oppbrc = ?";
		list = branchsmsDao.selectBySql(BranchsMSVo.class, vo_column,
				select_sql, branchsmsVo.getProbrc(), branchsmsVo.getOppbrc());

		return list;
	}

	@Override
	public void saveApply(BranchsMSVo pubVo, List<BranchsMSVo> splitlist)
			throws Exception {
		String delete_sql = "delete glsbrcprodef where prodate = ? and probrc = ? " +
				"and promode = ? and splitseq = ? and oppbrc = ? ";
		this.branchsmsDao.updateBySql(delete_sql, pubVo.getProdate(),
				pubVo.getProbrc(), pubVo.getPromode(), pubVo.getSplitseq(),
				pubVo.getOppbrc());

		String update_sql = "insert into glsbrcprodef values(?,?,?,?,?,?,?,?)";
		this.branchsmsDao.updateBySql(update_sql, pubVo.getProdate(),
				pubVo.getProbrc(), pubVo.getPromode(), pubVo.getSplitseq(),
				pubVo.getOppbrc(), pubVo.getModidate(), pubVo.getTeller(),
				pubVo.getProflag());
		
		if (pubVo.getPromode().equals('2')) {
			delete_sql = "delete glsbrcsplitacctdef where probrc = ? and oppbrc = ? ";
			this.branchsmsDao.updateBySql(delete_sql, pubVo.getProbrc(),
				pubVo.getOppbrc());

			update_sql = "insert into glsbrcsplitacctdef values(?,?,?,?,?,?)";
			for (BranchsMSVo temp : splitlist) {
				this.branchsmsDao.updateBySql(update_sql, pubVo.getProbrc(),
						pubVo.getOppbrc(), temp.getSubsys(),
						temp.getSplitflag(), temp.getSubctrlcode(),
						temp.getAcctno());
			}
		}
	}

}
