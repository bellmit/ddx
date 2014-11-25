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
@Table(name = "ddx_lab_Procedures_out_Links")
public class LabProceduresOutLink implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer proceduresId;
	private Integer outPartnerLabId;
	private Integer outProceduresId;
	private String autoRoute;
	private String type;
	private String design;
	private String material;
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Procedures_out_Links_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="Procedures_out_Links_seq",sequenceName="Procedures_out_Links_sequence")
	@Column(name = "LINK_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "PROCEDURES_ID")
	public Integer getProceduresId() {
		return proceduresId;
	}
	public void setProceduresId(Integer proceduresId) {
		this.proceduresId = proceduresId;
	}
	@Column(name = "OUT_LAB_ID")
	public Integer getOutPartnerLabId() {
		return outPartnerLabId;
	}
	public void setOutPartnerLabId(Integer outPartnerLabId) {
		this.outPartnerLabId = outPartnerLabId;
	}
	@Column(name = "OUT_PROCEDURES_ID")
	public Integer getOutProceduresId() {
		return outProceduresId;
	}
	public void setOutProceduresId(Integer outProceduresId) {
		this.outProceduresId = outProceduresId;
	}
	@Column(name = "SIRONA_CONNECT_TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name = "SIRONA_CONNECT_DESIGN")
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	@Column(name = "SIRONA_CONNECT_MATERIAL")
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	@Column(name = "AUTO_ROUTE")
	public String getAutoRoute() {
		return autoRoute;
	}
	public void setAutoRoute(String autoRoute) {
		this.autoRoute = autoRoute;
	}
	
	
}
