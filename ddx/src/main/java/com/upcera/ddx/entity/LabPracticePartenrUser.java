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
@Table(name = "ddx_lab_practice_partner_user")
public class LabPracticePartenrUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private Integer partenrId;
	private Integer userId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="practice_partner_user_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="practice_partner_user_seq",sequenceName="practice_partner_user_seq")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "PARTNER_ID")
	public Integer getPartenrId() {
		return partenrId;
	}
	public void setPartenrId(Integer partenrId) {
		this.partenrId = partenrId;
	}
	@Column(name = "USER_ID")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
