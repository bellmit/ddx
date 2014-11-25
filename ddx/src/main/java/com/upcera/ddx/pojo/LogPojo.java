package com.upcera.ddx.pojo;

import java.io.Serializable;

public class LogPojo implements Serializable{
	private static final long serialVersionUID = 1L;
	private LogType logType;			//日志类型
	private LogLevel logLevel;			//日志级别
	private Integer primaryId;			//被操作对象的主键ID
	private Integer partnerId;			//伙伴机构ID，操作案例时需设置，以便通知对方
	private String partnerUnitType;		//伙伴机构类型，操作案例时需设置，以便通知对方
	private String partnerUnitName;		//伙伴机构名称，操作案例时需设置，以便通知对方
	private String remarks;				//日志备注，自定义
	
	
	
	public LogType getLogType() {
		return logType;
	}
	public void setLogType(LogType logType) {
		this.logType = logType;
	}
	public LogLevel getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}
	public Integer getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerUnitType() {
		return partnerUnitType;
	}
	public void setPartnerUnitType(String partnerUnitType) {
		this.partnerUnitType = partnerUnitType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPartnerUnitName() {
		return partnerUnitName;
	}
	public void setPartnerUnitName(String partnerUnitName) {
		this.partnerUnitName = partnerUnitName;
	}

	public enum LogType {
		CASE_CREATE,//案例创建
		CASE_UPDATE,//案例更新
		PICKUP_REQUEST,//收件要求
		PAYMENT,//账户支付
		BILL_REPORT,//账单报表
		INVOICE,//发票
		ACCOUNT,//账户
		OTHER;//其他
	}
	public enum LogLevel{
		GENERAL,//一般
		EVENTS,//待办
		WARNING//警告，改变案例状态时，必须设为警告
	}
	
}
