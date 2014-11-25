package com.upcera.ddx.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "ddx_log")
public class DDXLog implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;					//id
	private Integer userId;				//产生日志的用户
	private String userName;			//产生日志的用户名字
	private Integer unitId;				//产生日志的用户的机构ID
	private String unitName;			//产生日志的用户的机构名称
	private String unitType;			//产生日志的用户的机构类型
	private String logType;				//日志类型
	private String logLevel;			//日志级别
	private Integer primaryId;			//被操作对象的主键ID
	private Integer partnerUnitId;		//伙伴机构ID，操作案例时需设置，以便通知对方
	private String partnerUnitType;		//伙伴机构类型，操作案例时需设置，以便通知对方
	private String partnerUnitName;		//伙伴机构名称，操作案例时需设置，以便通知对方
	private String remarks;				//日志备注，自定义
	private Timestamp createDate;		//日志产生时间
	
	private Integer patientId;			//患者id，数据库不创建此字段，页面显示用到
	private String patientFirstName;	//患者姓氏，数据库不创建此字段，页面显示用到
	private String patientLastName;		//患者名字，数据库不创建此字段，页面显示用到
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ddx_log_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="ddx_log_seq",sequenceName="ddx_log_sequence")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "USER_ID")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "UNIT_ID")
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	@Column(name = "UNIT_TYPE")
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	@Column(name = "LOG_TYPE")
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	@Column(name = "LOG_LEVEL")
	public String getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}
	@Column(name = "primary_Id")
	public Integer getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}
	@Column(name = "PARTNER_UNIT_ID")
	public Integer getPartnerUnitId() {
		return partnerUnitId;
	}
	public void setPartnerUnitId(Integer partnerId) {
		this.partnerUnitId = partnerId;
	}
	@Column(name = "PARTNER_UNIT_NAME")
	public String getPartnerUnitName() {
		return partnerUnitName;
	}
	public void setPartnerUnitName(String partnerUnitName) {
		this.partnerUnitName = partnerUnitName;
	}
	@Column(name = "PARTNER_UNIT_TYPE")
	public String getPartnerUnitType() {
		return partnerUnitType;
	}
	public void setPartnerUnitType(String partnerUnitType) {
		this.partnerUnitType = partnerUnitType;
	}
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Column(name = "CREATE_DATE")
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Column(name = "UNIT_NAME")
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	@Transient
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	@Transient
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	@Transient
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	
}
