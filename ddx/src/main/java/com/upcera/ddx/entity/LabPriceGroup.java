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
@Table(name = "DDX_LAB_PRICE_GROUP")
public class LabPriceGroup implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer labId;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_price_group_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_price_group_seq",sequenceName="lab_price_group_sequence")
	@Column(name = "PRICE_GROUP_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "PRICE_GROUP_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "LAB_ID")
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
}
