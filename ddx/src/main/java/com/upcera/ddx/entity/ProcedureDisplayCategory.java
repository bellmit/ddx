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
 * @ClassName: ProcedureDisplayCategory 
 * @Description: 工序显示类别
 * @author ERIC
 * @date 2014-7-16 下午03:05:36 
 *  
 */
@Entity
@Table(name = "ddx_lab_Procedures_d_Category")
public class ProcedureDisplayCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer labId;
	private String name;
	private Integer sort;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lab_Pro_d_Cy_seq")
	@SequenceGenerator(allocationSize = 1, initialValue = 500, name = "lab_Pro_d_Cy_seq", sequenceName = "lab_Pro_d_Cy_sequence")
	@Column(name = "CATEGORY_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "LAB_ID")
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	@Column(name = "CATEGORY_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "SORT_RANK")
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
