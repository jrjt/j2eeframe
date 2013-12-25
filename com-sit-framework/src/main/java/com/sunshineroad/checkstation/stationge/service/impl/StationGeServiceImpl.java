package com.sunshineroad.checkstation.stationge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.checkstation.stationge.dao.StationGeDao;
import com.sunshineroad.checkstation.stationge.entity.StationGe;
import com.sunshineroad.checkstation.stationge.service.StationGeService;
import com.sunshineroad.checkstation.stationge.vo.StationGeVo;

@Service("StationGeService")
public class StationGeServiceImpl implements StationGeService{
	
	@Autowired
	private StationGeDao<StationGe, Integer> stationGeDao;

	@Override
	public List<StationGeVo> list() { 
		List<StationGe> enList =this.stationGeDao.findByIdsForHql();
		if(null==enList)return null;
		List<StationGeVo> resultList= new ArrayList<StationGeVo>();
		for(StationGe en:enList){
			resultList.add(stationGeToVo(en));
		}
		
		return resultList;
	}
	 
	public List<StationGe> alllist() { 
		 
		return this.stationGeDao.findByIdsForHql();
	}
	
	public StationGeVo stationGeToVo(StationGe en){
		if(null==en){
			return null;
		}
		StationGeVo vo = new StationGeVo();
		//vo.setId(en.getId());
		vo.setStationId(en.getStationId());
		vo.setStationName(en.getStationName());
		vo.setLatitude(en.getLatitude()==null?"0":en.getLatitude().toString());
		vo.setLongitude(en.getLongitude()==null?"0":en.getLongitude().toString());
		vo.setOccurCount(en.getOccurCount());
		vo.setOccurDatetime(en.getOccurDatetime());
		//vo.setSyb1(en.getSyb1());
		//vo.setSyb2(en.getSyb2());
		//vo.setSyb3(en.getSyb3());
		//vo.setSyb4(en.getSyb4()==null?"0":en.getSyb4().toString());
		return vo;
	}
}
