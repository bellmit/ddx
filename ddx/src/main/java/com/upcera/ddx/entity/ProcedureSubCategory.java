/**   
 * @Title: ProcedureSubCategory.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-7-16 下午03:18:09 
 * @version V1.0   
 */
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
 * @ClassName: ProcedureSubCategory
 * @Description: 工序子类别
 * @author ERIC
 * @date 2014-7-16 下午03:18:09
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_LAB_PROCEDURES_PTS_CATEGOR")
public class ProcedureSubCategory implements Serializable {

	private Integer id;
	private Integer categoryId;
	private String categorySubName;
	private String nameDesc;//工序中文说明
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lab_pro_pts_cat_seq")
	@SequenceGenerator(allocationSize = 1, initialValue = 500, name = "lab_pro_pts_cat_seq", sequenceName = "lab_pro_pts_cat_seq")
	@Column(name = "procedures_category_sub_id")
	public Integer getId() {
		return id;
	}

	@Column(name = "procedures_category_id")
	public Integer getCategoryId() {
		return categoryId;
	}

	@Column(name = "procedures_category_sub_name")
	public String getCategorySubName() {
		return categorySubName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategorySubName(String categorySubName) {
		this.categorySubName = categorySubName;
	}
	@Column(name = "name_desc")
	public String getNameDesc() {
		return nameDesc;
	}

	public void setNameDesc(String nameDesc) {
		this.nameDesc = nameDesc;
	}

}
