package com.sunshineroad.driverschool.cscontractdetailinfo.entityvo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

import java.util.List;

import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;

import com.sunshineroad.framework.support.entity.BaseEntity;

/**   
 * @Title: Entity
 * @Description: 合同明细
 * @author  
 * @date 2014-01-15 13:45:03
 * @version V1.0   
 *
 */

public class CsContractDetailInfoVo   {
	/**id*/
	private java.lang.Long id;
	/**合同/销单/签证编号*/
	private java.lang.String contractNumber;
	/**设备名称*/
	private java.lang.String deviceName;
	/**设备型号*/
	private java.lang.String deviceModel;
	/**设备单价*/
	private java.math.BigDecimal equipmentPrice;
	/**SIM卡开始时间*/
	private java.util.Date openDate;
	/**SIM卡结束时间*/
	private java.util.Date endDate;
	/**remark1*/
	private java.lang.String remark1;
	/**remark2*/
	private java.lang.String remark2;
	/**remark3*/
	private java.lang.String remark3;
	/**remark4*/
	private java.lang.String remark4;
	/**remark5*/
	private java.lang.String remark5;
	/**remark6*/
	private java.lang.String remark6;
	/**remark7*/
	private java.lang.String remark7;
	/**remark8*/
	private java.lang.String remark8;
	/**remark9*/
	private java.lang.String remark9;
	/**remark10*/
	private java.lang.String remark10;
	/**remark11*/
	private java.lang.String remark11;
	/**remark12*/
	private java.lang.String remark12;
	/**remark13*/
	private java.lang.Integer remark13;
	/**remark14*/
	private java.lang.Integer remark14;
	/**remark15*/
	private java.math.BigDecimal remark15;
	/**remark16*/
	private java.math.BigDecimal remark16;
	/**remark17*/
	private java.math.BigDecimal remark17;
	/**remark18*/
	private java.math.BigDecimal remark18;
	/**remark19*/
	private java.util.Date remark19;
	/**remark20*/
	private java.util.Date remark20;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
public java.lang.Long getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  id
	 */
	public void setId(java.lang.Long id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同/销单/签证编号
	 */
public java.lang.String getContractNumber(){
		return this.contractNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同/销单/签证编号
	 */
	public void setContractNumber(java.lang.String contractNumber){
		this.contractNumber = contractNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备名称
	 */
public java.lang.String getDeviceName(){
		return this.deviceName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备名称
	 */
	public void setDeviceName(java.lang.String deviceName){
		this.deviceName = deviceName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备型号
	 */
public java.lang.String getDeviceModel(){
		return this.deviceModel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备型号
	 */
	public void setDeviceModel(java.lang.String deviceModel){
		this.deviceModel = deviceModel;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  设备单价
	 */
public java.math.BigDecimal getEquipmentPrice(){
		return this.equipmentPrice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  设备单价
	 */
	public void setEquipmentPrice(java.math.BigDecimal equipmentPrice){
		this.equipmentPrice = equipmentPrice;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  SIM卡开始时间
	 */
public java.util.Date getOpenDate(){
		return this.openDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  SIM卡开始时间
	 */
	public void setOpenDate(java.util.Date openDate){
		this.openDate = openDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  SIM卡结束时间
	 */
public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  SIM卡结束时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark1
	 */
public java.lang.String getRemark1(){
		return this.remark1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark1
	 */
	public void setRemark1(java.lang.String remark1){
		this.remark1 = remark1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark2
	 */
public java.lang.String getRemark2(){
		return this.remark2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark2
	 */
	public void setRemark2(java.lang.String remark2){
		this.remark2 = remark2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark3
	 */
public java.lang.String getRemark3(){
		return this.remark3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark3
	 */
	public void setRemark3(java.lang.String remark3){
		this.remark3 = remark3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark4
	 */
public java.lang.String getRemark4(){
		return this.remark4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark4
	 */
	public void setRemark4(java.lang.String remark4){
		this.remark4 = remark4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark5
	 */
public java.lang.String getRemark5(){
		return this.remark5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark5
	 */
	public void setRemark5(java.lang.String remark5){
		this.remark5 = remark5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark6
	 */
public java.lang.String getRemark6(){
		return this.remark6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark6
	 */
	public void setRemark6(java.lang.String remark6){
		this.remark6 = remark6;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark7
	 */
public java.lang.String getRemark7(){
		return this.remark7;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark7
	 */
	public void setRemark7(java.lang.String remark7){
		this.remark7 = remark7;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark8
	 */
public java.lang.String getRemark8(){
		return this.remark8;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark8
	 */
	public void setRemark8(java.lang.String remark8){
		this.remark8 = remark8;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark9
	 */
public java.lang.String getRemark9(){
		return this.remark9;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark9
	 */
	public void setRemark9(java.lang.String remark9){
		this.remark9 = remark9;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark10
	 */
public java.lang.String getRemark10(){
		return this.remark10;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark10
	 */
	public void setRemark10(java.lang.String remark10){
		this.remark10 = remark10;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark11
	 */
public java.lang.String getRemark11(){
		return this.remark11;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark11
	 */
	public void setRemark11(java.lang.String remark11){
		this.remark11 = remark11;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark12
	 */
public java.lang.String getRemark12(){
		return this.remark12;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark12
	 */
	public void setRemark12(java.lang.String remark12){
		this.remark12 = remark12;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  remark13
	 */
public java.lang.Integer getRemark13(){
		return this.remark13;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  remark13
	 */
	public void setRemark13(java.lang.Integer remark13){
		this.remark13 = remark13;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  remark14
	 */
public java.lang.Integer getRemark14(){
		return this.remark14;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  remark14
	 */
	public void setRemark14(java.lang.Integer remark14){
		this.remark14 = remark14;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  remark15
	 */
public java.math.BigDecimal getRemark15(){
		return this.remark15;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  remark15
	 */
	public void setRemark15(java.math.BigDecimal remark15){
		this.remark15 = remark15;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  remark16
	 */
public java.math.BigDecimal getRemark16(){
		return this.remark16;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  remark16
	 */
	public void setRemark16(java.math.BigDecimal remark16){
		this.remark16 = remark16;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  remark17
	 */
public java.math.BigDecimal getRemark17(){
		return this.remark17;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  remark17
	 */
	public void setRemark17(java.math.BigDecimal remark17){
		this.remark17 = remark17;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  remark18
	 */
public java.math.BigDecimal getRemark18(){
		return this.remark18;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  remark18
	 */
	public void setRemark18(java.math.BigDecimal remark18){
		this.remark18 = remark18;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  remark19
	 */
public java.util.Date getRemark19(){
		return this.remark19;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  remark19
	 */
	public void setRemark19(java.util.Date remark19){
		this.remark19 = remark19;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  remark20
	 */
public java.util.Date getRemark20(){
		return this.remark20;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  remark20
	 */
	public void setRemark20(java.util.Date remark20){
		this.remark20 = remark20;
	}
}
