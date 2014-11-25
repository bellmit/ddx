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
@Table(name = "DDX_CASE_REMAKE")
public class CaseRemake implements Serializable {
	private Integer id;
	private Integer labid;
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_remake_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_remake_seq",sequenceName="case_remake_seq")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="LAB_ID")
	public Integer getLabid() {
		return labid;
	}
	public void setLabid(Integer labid) {
		this.labid = labid;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
