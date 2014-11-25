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
@Table(name = "ddx_lab_Practice_Preferences")
public class LabPracticePreferences implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer lid;//当前技工间ID
	//以下为申请方信息
	private Integer practiceId;//申请添加我的合作伙伴的诊所id
	private Integer labId;//申请添加我的合作伙伴的技工间id
	private Integer priceGroupId;
	private Integer proceduresGroupId;
	private Integer shippingId;
	private String overrideTransitTime;
	private Integer inboundTransitDays;
	private Integer outboundTransitDays;
	
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Practice_Preferences_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="Practice_Preferences_seq",sequenceName="Practice_Preferences_sequence")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "PRACTICE_ID")
	public Integer getPracticeId() {
		return practiceId;
	}
	public void setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
	}
	@Column(name = "LAB_ID")
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	@Column(name = "PRICE_GROUP_ID")
	public Integer getPriceGroupId() {
		return priceGroupId;
	}
	public void setPriceGroupId(Integer priceGroupId) {
		this.priceGroupId = priceGroupId;
	}
	@Column(name = "PROCEDURES_GROUP_ID")
	public Integer getProceduresGroupId() {
		return proceduresGroupId;
	}
	public void setProceduresGroupId(Integer proceduresGroupId) {
		this.proceduresGroupId = proceduresGroupId;
	}
	@Column(name = "SHIPPING_ID")
	public Integer getShippingId() {
		return shippingId;
	}
	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}
	@Column(name = "OVERRIDE_TRANSIT_TIME")
	public String getOverrideTransitTime() {
		return overrideTransitTime;
	}
	public void setOverrideTransitTime(String overrideTransitTime) {
		this.overrideTransitTime = overrideTransitTime;
	}
	@Column(name = "INBOUND_TRANSIT_DAYS")
	public Integer getInboundTransitDays() {
		return inboundTransitDays;
	}
	public void setInboundTransitDays(Integer inboundTransitDays) {
		this.inboundTransitDays = inboundTransitDays;
	}
	@Column(name = "OUTBOUND_TRANSIT_DAYS")
	public Integer getOutboundTransitDays() {
		return outboundTransitDays;
	}
	public void setOutboundTransitDays(Integer outboundTransitDays) {
		this.outboundTransitDays = outboundTransitDays;
	}
	@Column(name = "LID")
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	
}
