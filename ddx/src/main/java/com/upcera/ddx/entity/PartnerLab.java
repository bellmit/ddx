package com.upcera.ddx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "DDX_LAB_PRACTICE_PARTNER")
public class PartnerLab implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;	//主键
	private Integer unitId;//技工间或诊所ID，由字段unitType指定
	private String unitType;//1：技工间，2：诊所
	
	private Integer partnerId;//伙伴ID
	private String partnerApprovalStatus;//伙伴审批状态
	private String billType;//电子账单类型，1：账单、2：账单和发票
	private String billUserId;//电子账单接收者，多个用户之间用逗号隔开
	
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_Partner_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_Partner_seq",sequenceName="lab_Partner_sequence")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "PARTNER_ID")
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	@Column(name = "PARTNER_APPROVAL_STATUS")
	public String getPartnerApprovalStatus() {
		return partnerApprovalStatus;
	}
	public void setPartnerApprovalStatus(String partnerApprovalStatus) {
		this.partnerApprovalStatus = partnerApprovalStatus;
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
	@Column(name = "BILL_TYPE")
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	@Column(name = "BILL_USER_ID")
	public String getBillUserId() {
		return billUserId;
	}
	public void setBillUserId(String billUserId) {
		this.billUserId = billUserId;
	}
	


}
