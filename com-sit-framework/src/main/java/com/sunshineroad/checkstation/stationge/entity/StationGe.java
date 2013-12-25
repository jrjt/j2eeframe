package com.sunshineroad.checkstation.stationge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sunshineroad.framework.support.entity.BaseEntity;

@Entity
@Table(name="CS_STATION_GE")
public class StationGe extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer stationId;
	
	private String stationName;
	
	private Double latitude;
	
	private Double longitude;//LONGITUDE
	
	private String syb1;
	
	private String syb2;
	
	private String syb3;
	
	private Double syb4;
	
	private Date occurDatetime;
	
	private Integer occurCount;
	
	@Id 
	@GeneratedValue
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	 
	/**
	 * @return the stationId
	 */
	@Column(name="station_id")
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
	@Column(name="station_Name")
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
	@Column(name="latitude")
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	@Column(name="longitude")
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the syb1
	 */
	@Column(name="syb1")
	public String getSyb1() {
		return syb1;
	}
	/**
	 * @param syb1 the syb1 to set
	 */
	public void setSyb1(String syb1) {
		this.syb1 = syb1;
	}
	/**
	 * @return the syb2
	 */
	@Column(name="syb2")
	public String getSyb2() {
		return syb2;
	}
	/**
	 * @param syb2 the syb2 to set
	 */
	public void setSyb2(String syb2) {
		this.syb2 = syb2;
	}
	/**
	 * @return the syb3
	 */
	@Column(name="syb3")
	public String getSyb3() {
		return syb3;
	}
	/**
	 * @param syb3 the syb3 to set
	 */
	public void setSyb3(String syb3) {
		this.syb3 = syb3;
	}
	/**
	 * @return the syb4
	 */
	@Column(name="syb4")
	public Double getSyb4() {
		return syb4;
	}
	/**
	 * @param syb4 the syb4 to set
	 */
	public void setSyb4(Double syb4) {
		this.syb4 = syb4;
	}
	/**
	 * @return the occurDatetime
	 */
	@Column(name="occur_datetime")
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
	@Column(name="occur_count")
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
