package com.sunshineroad.checkstation.stationge.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.checkstation.stationge.entity.StationGe;
import com.sunshineroad.checkstation.stationge.service.StationGeService;

@Controller
@RequestMapping("StationGe")
public class StationGeController {

	@Autowired
	private StationGeService stationGeService;
	
	@RequestMapping(value= "getstationgelist", method=RequestMethod.GET)
	public @ResponseBody List<StationGe> getStationGelist(){
		 
		return stationGeService.alllist(); 
	}
}
