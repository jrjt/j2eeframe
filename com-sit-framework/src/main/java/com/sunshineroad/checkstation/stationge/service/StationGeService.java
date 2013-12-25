package com.sunshineroad.checkstation.stationge.service;

import java.util.List;

import com.sunshineroad.checkstation.stationge.entity.StationGe;
import com.sunshineroad.checkstation.stationge.vo.StationGeVo;

public interface StationGeService {

	
	public List<StationGeVo> list();
	public List<StationGe> alllist();
}
