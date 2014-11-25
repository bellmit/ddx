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
@Table(name = "ddx_case_Shipping")
public class CaseShipping implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer labId;
	private String service;
	private String company;
	private Integer inboundTransitDays;
	private Integer outboundTransitDays;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_Shipping_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_Shipping_seq",sequenceName="case_Shipping_sequence")
	@Column(name = "SHIPPING_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "LAB_ID")
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	@Column(name = "SERVICE")
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
}
