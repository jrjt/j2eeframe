package com.sunshineroad.driverschool.cscontractinfo.entity;
 

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
 * @Description: 合同表
 * @author  
 * @date 2014-01-03 18:39:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cs_contract_info", schema = "")
public class CsContractInfo extends BaseEntity {
	/**id*/
	private java.lang.Long id;
	/**数据项含义*/
	private java.lang.String area;
	/**区域*/
	private java.lang.String customerName;
	/**客户名称*/
	private java.lang.String customerType;
	/**客户类型*/
	private java.lang.String contractNumber;
	/**合同编号/销单编号/签证编号*/
	private java.lang.String contractName;
	/**合同名称*/
	private java.lang.String contractType;
	/**合同类型*/
	private java.lang.String projectNumber;
	/**项目编号*/
	private java.util.Date signDate;
	/**签订时间*/
	private java.util.Date endDate;
	/**到期时间*/
	private java.math.BigDecimal contractMoney;
	/**合同额*/
	private java.math.BigDecimal settlementMoney;
	/**结算凭证金额*/
	private java.lang.String projectInfo;
	/**是否立项*/
	private java.math.BigDecimal firstPaymoney;
	/**首付款金额*/
	private java.util.Date firstPaymoneyDate;
	/**首付款回款时间*/
	private java.math.BigDecimal secondPaymoney;
	/**第二笔金额*/
	private java.util.Date secondPaymoneyDate;
	/**第二笔回款时间*/
	private java.math.BigDecimal endPaymoney;
	/**尾款金额*/
	private java.util.Date endPaymoneyDate;
	/**尾款回款时间*/
	private java.math.BigDecimal otherPaymoney;
	/**其他回款金额*/
	private java.util.Date otherPaymoneyDate;
	/**备用字段1*/
	private java.lang.String remark1;
	/**备用字段2*/
	private java.lang.String remark2;
	/**备用字段3*/
	private java.lang.String remark3;
	/**备用字段4*/
	private java.lang.String remark4;
	/**备用字段5*/
	private java.lang.String remark5;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="cs_contract_info_seq",allocationSize=1)
	@Column(name ="ID",nullable=false,precision=32,scale=0)
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
	 *@return: java.lang.String  数据项含义
	 */
	@Column(name ="AREA",nullable=true,length=50)
	public java.lang.String getArea(){
		return this.area;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据项含义
	 */
	public void setArea(java.lang.String area){
		this.area = area;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区域
	 */
	@Column(name ="CUSTOMER_NAME",nullable=true,length=50)
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	@Column(name ="CUSTOMER_TYPE",nullable=true,length=10)
	public java.lang.String getCustomerType(){
		return this.customerType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCustomerType(java.lang.String customerType){
		this.customerType = customerType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户类型
	 */
	@Column(name ="CONTRACT_NUMBER",nullable=true,length=50)
	public java.lang.String getContractNumber(){
		return this.contractNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户类型
	 */
	public void setContractNumber(java.lang.String contractNumber){
		this.contractNumber = contractNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号/销单编号/签证编号
	 */
	@Column(name ="CONTRACT_NAME",nullable=true,length=100)
	public java.lang.String getContractName(){
		return this.contractName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号/销单编号/签证编号
	 */
	public void setContractName(java.lang.String contractName){
		this.contractName = contractName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同名称
	 */
	@Column(name ="CONTRACT_TYPE",nullable=true,length=10)
	public java.lang.String getContractType(){
		return this.contractType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同名称
	 */
	public void setContractType(java.lang.String contractType){
		this.contractType = contractType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同类型
	 */
	@Column(name ="PROJECT_NUMBER",nullable=true,length=50)
	public java.lang.String getProjectNumber(){
		return this.projectNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同类型
	 */
	public void setProjectNumber(java.lang.String projectNumber){
		this.projectNumber = projectNumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  项目编号
	 */
	@Column(name ="SIGN_DATE",nullable=true)
	public java.util.Date getSignDate(){
		return this.signDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  项目编号
	 */
	public void setSignDate(java.util.Date signDate){
		this.signDate = signDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订时间
	 */
	@Column(name ="END_DATE",nullable=true)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签订时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  到期时间
	 */
	@Column(name ="CONTRACT_MONEY",nullable=true,precision=20,scale=8)
	public java.math.BigDecimal getContractMoney(){
		return this.contractMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  到期时间
	 */
	public void setContractMoney(java.math.BigDecimal contractMoney){
		this.contractMoney = contractMoney;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  合同额
	 */
	@Column(name ="SETTLEMENT_MONEY",nullable=true,precision=20,scale=8)
	public java.math.BigDecimal getSettlementMoney(){
		return this.settlementMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  合同额
	 */
	public void setSettlementMoney(java.math.BigDecimal settlementMoney){
		this.settlementMoney = settlementMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算凭证金额
	 */
	@Column(name ="PROJECT_INFO",nullable=true,length=310)
	public java.lang.String getProjectInfo(){
		return this.projectInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算凭证金额
	 */
	public void setProjectInfo(java.lang.String projectInfo){
		this.projectInfo = projectInfo;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  是否立项
	 */
	@Column(name ="FIRST_PAYMONEY",nullable=true,precision=20,scale=8)
	public java.math.BigDecimal getFirstPaymoney(){
		return this.firstPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  是否立项
	 */
	public void setFirstPaymoney(java.math.BigDecimal firstPaymoney){
		this.firstPaymoney = firstPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  首付款金额
	 */
	@Column(name ="FIRST_PAYMONEY_DATE",nullable=true)
	public java.util.Date getFirstPaymoneyDate(){
		return this.firstPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  首付款金额
	 */
	public void setFirstPaymoneyDate(java.util.Date firstPaymoneyDate){
		this.firstPaymoneyDate = firstPaymoneyDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  首付款回款时间
	 */
	@Column(name ="SECOND_PAYMONEY",nullable=true,precision=20,scale=8)
	public java.math.BigDecimal getSecondPaymoney(){
		return this.secondPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  首付款回款时间
	 */
	public void setSecondPaymoney(java.math.BigDecimal secondPaymoney){
		this.secondPaymoney = secondPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  第二笔金额
	 */
	@Column(name ="SECOND_PAYMONEY_DATE",nullable=true)
	public java.util.Date getSecondPaymoneyDate(){
		return this.secondPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  第二笔金额
	 */
	public void setSecondPaymoneyDate(java.util.Date secondPaymoneyDate){
		this.secondPaymoneyDate = secondPaymoneyDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  第二笔回款时间
	 */
	@Column(name ="END_PAYMONEY",nullable=true,precision=20,scale=8)
	public java.math.BigDecimal getEndPaymoney(){
		return this.endPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  第二笔回款时间
	 */
	public void setEndPaymoney(java.math.BigDecimal endPaymoney){
		this.endPaymoney = endPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  尾款金额
	 */
	@Column(name ="END_PAYMONEY_DATE",nullable=true)
	public java.util.Date getEndPaymoneyDate(){
		return this.endPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  尾款金额
	 */
	public void setEndPaymoneyDate(java.util.Date endPaymoneyDate){
		this.endPaymoneyDate = endPaymoneyDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  尾款回款时间
	 */
	@Column(name ="OTHER_PAYMONEY",nullable=true,precision=20,scale=8)
	public java.math.BigDecimal getOtherPaymoney(){
		return this.otherPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  尾款回款时间
	 */
	public void setOtherPaymoney(java.math.BigDecimal otherPaymoney){
		this.otherPaymoney = otherPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  其他回款金额
	 */
	@Column(name ="OTHER_PAYMONEY_DATE",nullable=true)
	public java.util.Date getOtherPaymoneyDate(){
		return this.otherPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  其他回款金额
	 */
	public void setOtherPaymoneyDate(java.util.Date otherPaymoneyDate){
		this.otherPaymoneyDate = otherPaymoneyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段1
	 */
	@Column(name ="REMARK1",nullable=true,length=100)
	public java.lang.String getRemark1(){
		return this.remark1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段1
	 */
	public void setRemark1(java.lang.String remark1){
		this.remark1 = remark1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段2
	 */
	@Column(name ="REMARK2",nullable=true,length=100)
	public java.lang.String getRemark2(){
		return this.remark2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段2
	 */
	public void setRemark2(java.lang.String remark2){
		this.remark2 = remark2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段3
	 */
	@Column(name ="REMARK3",nullable=true,length=100)
	public java.lang.String getRemark3(){
		return this.remark3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段3
	 */
	public void setRemark3(java.lang.String remark3){
		this.remark3 = remark3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段4
	 */
	@Column(name ="REMARK4",nullable=true,length=100)
	public java.lang.String getRemark4(){
		return this.remark4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段4
	 */
	public void setRemark4(java.lang.String remark4){
		this.remark4 = remark4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段5
	 */
	@Column(name ="REMARK5",nullable=true,length=100)
	public java.lang.String getRemark5(){
		return this.remark5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段5
	 */
	public void setRemark5(java.lang.String remark5){
		this.remark5 = remark5;
	}
}
