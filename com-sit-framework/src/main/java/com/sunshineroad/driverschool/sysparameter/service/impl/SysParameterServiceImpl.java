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

	public List<SysParameterVo> list(SysParameter entity) {
		HQLParameter p = new HQLParameter(SysParameter.class);	   
		return ListUtils.transform(sysParameterDao.findPageByHql(" from SysParameter "   ),
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
		return SysParameterVo.voList2TreenodeList(ListUtils.transform(sysParameterDao.findPageByHql(" from SysParameter "   ),
				SysParameterVo.class));
		 
	}
}


