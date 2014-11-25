/**   
 * @Title: LabProceduresCharacteris.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-7-28 上午10:47:51 
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
 * @ClassName: LabProceduresCharacteris 
 * @Description: 技工间程序特性实体类 
 * @author ERIC
 * @date 2014-7-28 上午10:47:51 
 *  
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_LAB_PROCEDURES_CHARACTERIS")
public class LabProceduresCharacteris implements Serializable {
	
	private Integer id;//id
	private Integer labId;//技工间ID
	private String characterName;//名称
	private String classfication;//分类
	private Float defaultPrice;//默认价格
	private String taxable;//是否应纳税 0标识不纳税 1标识纳税
	private String type;//类型
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_procedure_character_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_procedure_character_seq",sequenceName="lab_procedure_character_seq")
	@Column(name = "characteris_id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "lab_id")
	public Integer getLabId() {
		return labId;
	}
	
	@Column(name = "name")
	public String getCharacterName() {
		return characterName;
	}
	
	@Column(name = "classifiucation")
	public String getClassfication() {
		return classfication;
	}
	
	@Column(name = "default_price")
	public Float getDefaultPrice() {
		return defaultPrice;
	}
	
	@Column(name = "taxable")
	public String getTaxable() {
		return taxable;
	}
	
	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public void setClassfication(String classfication) {
		this.classfication = classfication;
	}
	public void setDefaultPrice(Float defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	public void setTaxable(String taxable) {
		this.taxable = taxable;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
