package com.sunshineroad.checkstation.stationge.vo;

import java.util.Date;

import com.sunshineroad.framework.support.entity.BaseEntity;




public class StationGeVo  {
	


	//private Integer id;
	
	private Integer stationId;
	
	private String stationName;
	
	private String latitude;
	
	private String longitude;//LONGITUDE
	
	//private String syb1;
	
	//private String syb2;
	
	//private String syb3;
	
	//private String syb4;
	

	private Date occurDatetime;
	
	private Integer occurCount;
	 
	/**
	 * @return the stationId
	 */
	
	public Integer getStationId() {
		return stationId;
	}
	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	/**
	 * @return the stationName
	 */

	public String getStationName() {
		return stationName;
	}
	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	/**
	 * @return the latitude
	 */

	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the occurDatetime
	 */
	public Date getOccurDatetime() {
		return occurDatetime;
	}
	/**
	 * @param occurDatetime the occurDatetime to set
	 */
	public void setOccurDatetime(Date occurDatetime) {
		this.occurDatetime = occurDatetime;
	}
	/**
	 * @return the occurCount
	 */
	public Integer getOccurCount() {
		return occurCount;
	}
	/**
	 * @param occurCount the occurCount to set
	 */
	public void setOccurCount(Integer occurCount) {
		this.occurCount = occurCount;
	}
	 
	
}
