/**   
 * @Title: LabSignUpDirectSound
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:26:28 
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
 * @ClassName: CaseAttachs
 * @Description: 案例附件实体类
 * @author ERIC
 * @date 2014-6-17 上午11:26:28
 * 
 */

@Entity
@Table(name = "DDX_LABDIRECTSOUND")
public class LabSignUpDirectSound implements Serializable {

	private Integer id;				//ID
	private Integer labId;		//技工间ID
	private String shWorkdays;		//时间设定工作日
	private String shCutOfTime;		//时间设定下班时间
	private Integer shTurnAround;	//时间设定订单工期
	private String remakeName;		//返工类型名称
	private String holdTypeName;  //搁置类型名称
	private String displayCategoriesName;//工序列表名称
	private Integer displayCategoriesSortRank; //工序排序排名
	private String Materials; //工序材料
	private String classification; //工序分类
	private String Enclosures;//随单附件
	private String AcrylicColors; //塑胶袋名称
	private Integer type;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_labdirectsound_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_labdirectsound_seq",sequenceName="case_labdirectsound_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "LABID")
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	@Column(name = "SHWORKDAYS")
	public String getShWorkdays() {
		return shWorkdays;
	}
	public void setShWorkdays(String shWorkdays) {
		this.shWorkdays = shWorkdays;
	}
	@Column(name = "SHCUTOFTIME")
	public String getShCutOfTime() {
		return shCutOfTime;
	}
	public void setShCutOfTime(String shCutOfTime) {
		this.shCutOfTime = shCutOfTime;
	}
	
	
	@Column(name = "REMAKENAME")
	public String getRemakeName() {
		return remakeName;
	}
	public void setRemakeName(String remakeName) {
		this.remakeName = remakeName;
	}
	@Column(name = "SHTURNAROUND")
	public Integer getShTurnAround() {
		return shTurnAround;
	}
	public void setShTurnAround(Integer shTurnAround) {
		this.shTurnAround = shTurnAround;
	}
	@Column(name = "HOLDTYPENAME")
	public String getHoldTypeName() {
		return holdTypeName;
	}
	public void setHoldTypeName(String holdTypeName) {
		this.holdTypeName = holdTypeName;
	}
	@Column(name = "DISPLAYCATEGORIESNAME")
	public String getDisplayCategoriesName() {
		return displayCategoriesName;
	}
	public void setDisplayCategoriesName(String displayCategoriesName) {
		this.displayCategoriesName = displayCategoriesName;
	}
	@Column(name = "DISPLAYCATEGORIESSORTRANK")
	public Integer getDisplayCategoriesSortRank() {
		return displayCategoriesSortRank;
	}
	public void setDisplayCategoriesSortRank(Integer displayCategoriesSortRank) {
		this.displayCategoriesSortRank = displayCategoriesSortRank;
	}
	@Column(name = "MATERIALS")
	public String getMaterials() {
		return Materials;
	}
	public void setMaterials(String materials) {
		Materials = materials;
	}
	@Column(name = "ENCLOSURES")
	public String getEnclosures() {
		return Enclosures;
	}
	public void setEnclosures(String enclosures) {
		Enclosures = enclosures;
	}
	@Column(name = "ACRYLICCOLORS")
	public String getAcrylicColors() {
		return AcrylicColors;
	}
	
	public void setAcrylicColors(String acrylicColors) {
		AcrylicColors = acrylicColors;
	}
	public Integer getType() {
		return type;
	}
	@Column(name = "TYPE")
	public void setType(Integer type) {
		this.type = type;
	}
	public String getClassification() {
		return classification;
	}
	@Column(name = "CLASSIFICATION")
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	
}
