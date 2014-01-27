package com.sunshineroad.driverschool.cscontractinfo.entityvo;

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
 * @Description: 合同信息
 * @author  
 * @date 2014-01-15 16:16:54
 * @version V1.0   
 *
 */

public class CsContractInfoVo   {
	/**id*/
	private java.lang.Long id;
	/**区域*/
	private java.lang.String area;
	private java.lang.String areaName;
	/**客户名称*/
	private java.lang.String customerName;
	/**客户类型*/
	private java.lang.String customerType;
	private java.lang.String customerTypeName;
	/**合同/销单/签证编号*/
	private java.lang.String contractNumber;
	/**合同名称*/
	private java.lang.String contractName;
	/**合同类型*/
	private java.lang.String contractType;
	private java.lang.String contractTypeName;
	public java.lang.String getAreaName() {
		return areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(java.lang.String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public java.lang.String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(java.lang.String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	/**项目编号*/
	private java.lang.String projectNumber;
	/**签订时间*/
	private java.util.Date signDate;
	/**到期时间*/
	private java.util.Date endDate;
	/**合同额*/
	private java.math.BigDecimal contractMoney;
	/**结算凭证金额*/
	private java.math.BigDecimal settlementMoney;
	/**是否立项*/
	private java.lang.String projectInfo;
	/**首付款金额*/
	private java.math.BigDecimal firstPaymoney;
	/**首付款回款时间*/
	private java.util.Date firstPaymoneyDate;
	/**第二笔金额*/
	private java.math.BigDecimal secondPaymoney;
	/**第二笔回款时间*/
	private java.util.Date secondPaymoneyDate;
	/**尾款金额*/
	private java.math.BigDecimal endPaymoney;
	/**尾款回款时间*/
	private java.util.Date endPaymoneyDate;
	/**其他回款金额*/
	private java.math.BigDecimal otherPaymoney;
	/**其他回款时间*/
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
	 *@return: java.lang.String  区域
	 */
public java.lang.String getArea(){
		return this.area;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域
	 */
	public void setArea(java.lang.String area){
		this.area = area;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
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
	 *@return: java.lang.String  客户类型
	 */
public java.lang.String getCustomerType(){
		return this.customerType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户类型
	 */
	public void setCustomerType(java.lang.String customerType){
		this.customerType = customerType;
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
	 *@return: java.lang.String  合同名称
	 */
public java.lang.String getContractName(){
		return this.contractName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同名称
	 */
	public void setContractName(java.lang.String contractName){
		this.contractName = contractName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同类型
	 */
public java.lang.String getContractType(){
		return this.contractType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同类型
	 */
	public void setContractType(java.lang.String contractType){
		this.contractType = contractType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */
public java.lang.String getProjectNumber(){
		return this.projectNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setProjectNumber(java.lang.String projectNumber){
		this.projectNumber = projectNumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订时间
	 */
public java.util.Date getSignDate(){
		return this.signDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签订时间
	 */
	public void setSignDate(java.util.Date signDate){
		this.signDate = signDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到期时间
	 */
public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到期时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  合同额
	 */
public java.math.BigDecimal getContractMoney(){
		return this.contractMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  合同额
	 */
	public void setContractMoney(java.math.BigDecimal contractMoney){
		this.contractMoney = contractMoney;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  结算凭证金额
	 */
public java.math.BigDecimal getSettlementMoney(){
		return this.settlementMoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  结算凭证金额
	 */
	public void setSettlementMoney(java.math.BigDecimal settlementMoney){
		this.settlementMoney = settlementMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否立项
	 */
public java.lang.String getProjectInfo(){
		return this.projectInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否立项
	 */
	public void setProjectInfo(java.lang.String projectInfo){
		this.projectInfo = projectInfo;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  首付款金额
	 */
public java.math.BigDecimal getFirstPaymoney(){
		return this.firstPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  首付款金额
	 */
	public void setFirstPaymoney(java.math.BigDecimal firstPaymoney){
		this.firstPaymoney = firstPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  首付款回款时间
	 */
public java.util.Date getFirstPaymoneyDate(){
		return this.firstPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  首付款回款时间
	 */
	public void setFirstPaymoneyDate(java.util.Date firstPaymoneyDate){
		this.firstPaymoneyDate = firstPaymoneyDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  第二笔金额
	 */
public java.math.BigDecimal getSecondPaymoney(){
		return this.secondPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  第二笔金额
	 */
	public void setSecondPaymoney(java.math.BigDecimal secondPaymoney){
		this.secondPaymoney = secondPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  第二笔回款时间
	 */
public java.util.Date getSecondPaymoneyDate(){
		return this.secondPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  第二笔回款时间
	 */
	public void setSecondPaymoneyDate(java.util.Date secondPaymoneyDate){
		this.secondPaymoneyDate = secondPaymoneyDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  尾款金额
	 */
public java.math.BigDecimal getEndPaymoney(){
		return this.endPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  尾款金额
	 */
	public void setEndPaymoney(java.math.BigDecimal endPaymoney){
		this.endPaymoney = endPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  尾款回款时间
	 */
public java.util.Date getEndPaymoneyDate(){
		return this.endPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  尾款回款时间
	 */
	public void setEndPaymoneyDate(java.util.Date endPaymoneyDate){
		this.endPaymoneyDate = endPaymoneyDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  其他回款金额
	 */
public java.math.BigDecimal getOtherPaymoney(){
		return this.otherPaymoney;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  其他回款金额
	 */
	public void setOtherPaymoney(java.math.BigDecimal otherPaymoney){
		this.otherPaymoney = otherPaymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  其他回款时间
	 */
public java.util.Date getOtherPaymoneyDate(){
		return this.otherPaymoneyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  其他回款时间
	 */
	public void setOtherPaymoneyDate(java.util.Date otherPaymoneyDate){
		this.otherPaymoneyDate = otherPaymoneyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段1
	 */
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
