package com.sunshineroad.driverschool.sysparameter.entityvo;

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
 * @Description: 参数
 * @author  
 * @date 2014-01-08 20:17:21
 * @version V1.0   
 *
 */

public class SysParameterVo   {
	/**id*/
	private java.lang.Long id;
	/**参数名称*/
	private java.lang.String parName;
	/**参数代码*/
	private java.lang.String parCode;
	/**上级参数*/
	private java.lang.Long parUpId;
	
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
	 *@return: java.lang.String  参数名称
	 */
public java.lang.String getParName(){
		return this.parName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数名称
	 */
	public void setParName(java.lang.String parName){
		this.parName = parName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数代码
	 */
public java.lang.String getParCode(){
		return this.parCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数代码
	 */
	public void setParCode(java.lang.String parCode){
		this.parCode = parCode;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  上级参数
	 */
public java.lang.Long getParUpId(){
		return this.parUpId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  上级参数
	 */
	public void setParUpId(java.lang.Long parUpId){
		this.parUpId = parUpId;
	}
}
