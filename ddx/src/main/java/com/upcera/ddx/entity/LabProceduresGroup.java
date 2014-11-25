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
@Table(name = "ddx_lab_Procedures_group")
public class LabProceduresGroup implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer labId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Procedures_group_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="Procedures_group_seq",sequenceName="Procedures_group_sequence")
	@Column(name = "PRACTICES_GROUP_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "PRACTICES_GROUP_NAME")
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
