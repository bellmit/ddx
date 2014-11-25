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
@Table(name = "ddx_case_terms")
public class CaseTerms implements Serializable {
	private Integer id;
	private Integer labid;
	private String terms;
	private String valid;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_terms_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_terms_seq",sequenceName="case_terms_sequence")
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
	@Column(name="TERMS")
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	@Column(name="VALID")
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
}
