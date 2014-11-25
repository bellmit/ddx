package com.upcera.ddx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * @ClassName: ProcedureType
 * @Description: 技工间工序类型
 * @author king
 * @date 2014-6-17 上午11:43:08
 * 
 */
@Entity
@Table(name = "ddx_lab_Procedures_type")
public class ProcedureType implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer subId;
	private String name;
	private String nameDesc;//工序中文说明
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lab_p_type_seq")
	@SequenceGenerator(allocationSize = 1, initialValue = 500, name = "lab_p_type_seq", sequenceName = "lab_p_type_sequence")
	@Column(name = "Procedures_type_id")	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "Procedures_Category_sub_id")
	public Integer getSubId() {
		return subId;
	}
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	@Column(name = "Procedures_type_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "name_desc")
	public String getNameDesc() {
		return nameDesc;
	}
	public void setNameDesc(String nameDesc) {
		this.nameDesc = nameDesc;
	}
	

}
