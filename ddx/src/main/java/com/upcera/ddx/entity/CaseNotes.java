/**   
 * @Title: CaseNotes.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:12:46 
 * @version V1.0   
 */
package com.upcera.ddx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @ClassName: CaseNotes
 * @Description: 案例笔记实体类
 * @author ERIC
 * @date 2014-6-17 上午11:12:46
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_CASE_NOTES")
public class CaseNotes implements Serializable {

	private Integer id;			//ID
	private Integer caseId;	//案例ID
	private Date caseDate;		//时间
	private String caseFor;	//关于
	private String caseFrom;	//来自
	private String caseNote;	//内容
	private String subject;		//主题
	private String isEmeger;	//是否加急
	
	private Integer unitId;
	private Integer unitType;
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_notes_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_notes_seq",sequenceName="case_notes_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "case_id")
	public Integer getCaseId() {
		return caseId;
	}
	
	@Column(name = "case_date")
	public Date getCaseDate() {
		return caseDate;
	}
	
	@Column(name = "case_for")
	public String getCaseFor() {
		return caseFor;
	}
	
	@Column(name = "case_from")
	public String getCaseFrom() {
		return caseFrom;
	}
	
	@Column(name = "case_note")
	public String getCaseNote() {
		return caseNote;
	}
	
	@Column(name = "subject")
	public String getSubject() {
		return subject;
	}
	
	@Column(name = "is_emeger")
	public String getIsEmeger() {
		return isEmeger;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}

	public void setCaseFor(String caseFor) {
		this.caseFor = caseFor;
	}

	public void setCaseFrom(String caseFrom) {
		this.caseFrom = caseFrom;
	}

	public void setCaseNote(String caseNote) {
		this.caseNote = caseNote;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setIsEmeger(String isEmeger) {
		this.isEmeger = isEmeger;
	}

	@Column(name = "unit_id")
	public Integer getUnitId() {
		return unitId;
	}

	@Column(name = "unit_type")
	public Integer getUnitType() {
		return unitType;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}
	
}
