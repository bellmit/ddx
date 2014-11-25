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
@Table(name = "DDX_CASE_HOLD")
public class CaseHold implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;//保持类型ID
	private Integer labId; 
	private String name;// 名称
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_hold_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_hold_seq",sequenceName="case_hold_seq")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="LAB_ID")
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
