package com.sunshineroad.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.checkstation.stationge.service.StationGeService;
import com.sunshineroad.checkstation.stationge.vo.StationGeVo;
import com.sunshineroad.framework.util.ResponseUtils;

/**
 * sunshineroad
 * com.sunshineroad.webservices
 * @{#} webservicesController.java Create on  2013-12-3 下午4:08:14
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
@Controller
@RequestMapping(value="webservices")
public class webservicesController {
	
	@Autowired
	private StationGeService stationGeService;
	
	@RequestMapping(value= "getstationgelist", method=RequestMethod.GET)
	public @ResponseBody List<StationGeVo> getStationGelist(){
		// System.out.print("---------------------------------");
		return stationGeService.list(); 
	}
}
