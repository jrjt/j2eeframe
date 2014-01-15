package com.sunshineroad.driverschool.sysparameter.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.driverschool.sysparameter.dao.SysParameterDao;
import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.sysparameter.entityvo.SysParameterVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;



import java.util.List;

import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.framework.util.TreeNode;

@Service("sysParameterService")
@Transactional
public class SysParameterServiceImpl extends BaseServiceImpl<SysParameter, Integer>  implements SysParameterService {
	@Autowired
	private SysParameterDao  sysParameterDao;

	public List<SysParameterVo> list(SysParameterVo entity) {
		HQLParameter p = new HQLParameter(SysParameter.class);	   
		StringBuffer hql= new StringBuffer(" FROM SysParameter  WHERE 1=1");
		if(null!=entity&&null!=entity.getId()){
			hql.append(" AND parUpId= "+entity.getId());
		}  
		if(null!=entity&&null!=entity.getParName()){
			hql.append(" AND ( 1!=1 ");

			hql.append(" or "+" parName like '%"+entity.getParName()+"%'   ");
			hql.append(" or "+" parCode like '%"+entity.getParName()+"%'   ");
			hql.append(" or "+" parType like '%"+entity.getParName()+"%'   ");
			hql.append("  )");
		}  
		 
		hql.append(" ORDER BY sortIndex");
		return ListUtils.transform(sysParameterDao.findPageByHql(hql.toString() ),
				SysParameterVo.class);
	}
	
		@Override
	public void update(SysParameter model)  {
		this.sysParameterDao.update(model);	
	}
	
	@Override
	public SysParameter save(SysParameter model)   {
		this.sysParameterDao.save(model);	
		return model;
	}

	@Override
	public void delete(SysParameter model)  {
		this.sysParameterDao.delete(model);	
	}

	@Override
	public List<TreeNode> getChildrenById(Long id) {
		HQLParameter p = new HQLParameter(SysParameter.class);	   
		 
		StringBuffer hql= new StringBuffer(" FROM SysParameter  WHERE 1=1");
		if(null!=id){
			hql.append(" AND parUpId= "+id);
		}
		return SysParameterVo.voList2TreenodeList(ListUtils.transform(sysParameterDao.findPageByHql(hql.toString()),
				SysParameterVo.class));
		 
	}
}


