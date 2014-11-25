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
@Table(name = "ddx_lab_Procedures_group_link")
public class LabProceduresGroupLink implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer proceduresId;
	private Integer practicesGroupId;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Procedures_group_link_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="Procedures_group_link_seq",sequenceName="Procedures_group_link_sequence")
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
	@Column(name = "PRACTICES_GROUP_ID")
	public Integer getPracticesGroupId() {
		return practicesGroupId;
	}
	public void setPracticesGroupId(Integer practicesGroupId) {
		this.practicesGroupId = practicesGroupId;
	}

}
