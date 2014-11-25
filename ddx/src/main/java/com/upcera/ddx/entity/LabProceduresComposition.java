/**   
 * @Title: LabProceduresComposition.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-7-28 下午04:02:01 
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
 * @ClassName: LabProceduresComposition 
 * @Description: 技工间工序特性-材料组成实体类 
 * @author ERIC
 * @date 2014-7-28 下午04:02:01 
 *  
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ddx_lab_Procedures_Composition")
public class LabProceduresComposition implements Serializable {

	private Integer id;//主键ID
	private Integer characterId;//工序特性ID
	private String element;//元素
	private Float  percentage;//元素百分比
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_procedure_composition_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_procedure_composition_seq",sequenceName="lab_procedure_composition_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "characteris_id")
	public Integer getCharacterId() {
		return characterId;
	}
	
	@Column(name = "element")
	public String getElement() {
		return element;
	}
	
	@Column(name = "percentage")
	public Float getPercentage() {
		return percentage;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	
}
