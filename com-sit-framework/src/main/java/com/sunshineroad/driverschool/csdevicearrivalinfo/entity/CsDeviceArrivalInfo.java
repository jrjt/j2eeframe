package com.sunshineroad.driverschool.csdevicearrivalinfo.entity;
 

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
 * @Description: 设备到货信息
 * @author  
 * @date 2014-02-17 12:38:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "CS_DEVICE_ARRIVAL_INFO", schema = "")
public class CsDeviceArrivalInfo extends BaseEntity {
	/**ID*/
	private java.lang.Long id;
	/**设备到货证明ID*/
	private java.lang.String deviceInfoId;
	/**客户名称*/
	private java.lang.String customerName;
	/**合同编号/销单编号/签证编号*/
	private java.lang.String contractNumber;
	/**设备到货时间*/
	private java.util.Date deviceDate;
	/**设备名称*/
	private java.lang.String deviceName;
	/**设备型号*/
	private java.lang.String deviceModel;
	/**设备编码*/
	private java.lang.String deviceCode;
	/**设备实际数量*/
	private java.lang.Long deviceCount;
	/**设备预计数量*/
	private java.lang.Long deviceExpectCount;
	/**更新时间*/
	private java.util.Date updateDate;
	/**设备更新人*/
	private java.lang.String updateUser;
	/**设备负责人*/
	private java.lang.String deviceHead;
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
	private java.lang.String remark17;
	/**remark18*/
	private java.lang.String remark18;
	/**remark19*/
	private java.util.Date remark19;
	/**remark20*/
	private java.util.Date remark20;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  ID
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="CS_DEVICE_ARRIVAL_INFO_seq",allocationSize=1)
	@Column(name ="ID",nullable=false,precision=32,scale=0)
	public java.lang.Long getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  ID
	 */
	public void setId(java.lang.Long id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备到货证明ID
	 */
	@Column(name ="DEVICE_INFO_ID",nullable=false,length=50)
	public java.lang.String getDeviceInfoId(){
		return this.deviceInfoId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备到货证明ID
	 */
	public void setDeviceInfoId(java.lang.String deviceInfoId){
		this.deviceInfoId = deviceInfoId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	@Column(name ="CUSTOMER_NAME",nullable=false,length=100)
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号/销单编号/签证编号
	 */
	@Column(name ="CONTRACT_NUMBER",nullable=true,length=50)
	public java.lang.String getContractNumber(){
		return this.contractNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号/销单编号/签证编号
	 */
	public void setContractNumber(java.lang.String contractNumber){
		this.contractNumber = contractNumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  设备到货时间
	 */
	@Column(name ="DEVICE_DATE",nullable=true)
	public java.util.Date getDeviceDate(){
		return this.deviceDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  设备到货时间
	 */
	public void setDeviceDate(java.util.Date deviceDate){
		this.deviceDate = deviceDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备名称
	 */
	@Column(name ="DEVICE_NAME",nullable=false,length=100)
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
	@Column(name ="DEVICE_MODEL",nullable=false,length=100)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备编码
	 */
	@Column(name ="DEVICE_CODE",nullable=true,length=100)
	public java.lang.String getDeviceCode(){
		return this.deviceCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备编码
	 */
	public void setDeviceCode(java.lang.String deviceCode){
		this.deviceCode = deviceCode;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  设备实际数量
	 */
	@Column(name ="DEVICE_COUNT",nullable=true,precision=32,scale=0)
	public java.lang.Long getDeviceCount(){
		return this.deviceCount;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  设备实际数量
	 */
	public void setDeviceCount(java.lang.Long deviceCount){
		this.deviceCount = deviceCount;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  设备预计数量
	 */
	@Column(name ="DEVICE_EXPECT_COUNT",nullable=true,precision=32,scale=0)
	public java.lang.Long getDeviceExpectCount(){
		return this.deviceExpectCount;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  设备预计数量
	 */
	public void setDeviceExpectCount(java.lang.Long deviceExpectCount){
		this.deviceExpectCount = deviceExpectCount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_DATE",nullable=false)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备更新人
	 */
	@Column(name ="UPDATE_USER",nullable=false,length=50)
	public java.lang.String getUpdateUser(){
		return this.updateUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备更新人
	 */
	public void setUpdateUser(java.lang.String updateUser){
		this.updateUser = updateUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备负责人
	 */
	@Column(name ="DEVICE_HEAD",nullable=true,length=50)
	public java.lang.String getDeviceHead(){
		return this.deviceHead;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备负责人
	 */
	public void setDeviceHead(java.lang.String deviceHead){
		this.deviceHead = deviceHead;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark1
	 */
	@Column(name ="REMARK1",nullable=true,length=100)
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
	@Column(name ="REMARK2",nullable=true,length=100)
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
	@Column(name ="REMARK3",nullable=true,length=100)
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
	@Column(name ="REMARK4",nullable=true,length=100)
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
	@Column(name ="REMARK5",nullable=true,length=100)
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
	@Column(name ="REMARK6",nullable=true,length=100)
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
	@Column(name ="REMARK7",nullable=true,length=100)
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
	@Column(name ="REMARK8",nullable=true,length=100)
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
	@Column(name ="REMARK9",nullable=true,length=100)
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
	@Column(name ="REMARK10",nullable=true,length=100)
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
	@Column(name ="REMARK11",nullable=true,length=100)
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
	@Column(name ="REMARK12",nullable=true,length=100)
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
	@Column(name ="REMARK13",nullable=true,scale=0)
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
	@Column(name ="REMARK14",nullable=true,scale=0)
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
	@Column(name ="REMARK15",nullable=true,precision=10,scale=4)
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
	@Column(name ="REMARK16",nullable=true,precision=10,scale=4)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark17
	 */
	@Column(name ="REMARK17",nullable=true,length=100)
	public java.lang.String getRemark17(){
		return this.remark17;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark17
	 */
	public void setRemark17(java.lang.String remark17){
		this.remark17 = remark17;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark18
	 */
	@Column(name ="REMARK18",nullable=true,length=100)
	public java.lang.String getRemark18(){
		return this.remark18;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark18
	 */
	public void setRemark18(java.lang.String remark18){
		this.remark18 = remark18;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  remark19
	 */
	@Column(name ="REMARK19",nullable=true)
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
	@Column(name ="REMARK20",nullable=true)
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
