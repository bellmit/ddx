/**   
 * @Title: ProcedureCategory.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-7-16 下午03:05:36 
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
 * @ClassName: ProcedureCategory 
 * @Description: 工序类别
 * @author ERIC
 * @date 2014-7-16 下午03:05:36 
 *  
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_LAB_PROCEDURES_PT_CATEGORY")
public class ProcedureCategory implements Serializable {
	
	private Integer id;//ID
	private String categoryName; //工序类别名
	private String nameDesc;//工序中文说明
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_pro_pt_cat_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_pro_pt_cat_seq",sequenceName="lab_pro_pt_cat_seq")
	@Column(name = "procedures_category_id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "procedures_category_name")
	public String getCategoryName() {
		return categoryName;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Column(name = "name_desc")
	public String getNameDesc() {
		return nameDesc;
	}

	public void setNameDesc(String nameDesc) {
		this.nameDesc = nameDesc;
	}

}
