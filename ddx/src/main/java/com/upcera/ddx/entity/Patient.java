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
import javax.persistence.Transient;

/** 
 * @ClassName: Patient 
 * @Description: 患者病人 
 * @author ERIC
 * @date 2014-7-3 上午11:34:26 
 *  
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_LAB_PRACTICE_PATIENTS")
public class Patient implements Serializable {

	private Integer id; 			//主键ID
	private Integer labId;			//技工间ID
	private Integer practiceId;		//下单机构ID
	private Integer unitType;		//下单机构类型 1标识技工间 2标识诊所
	private String firstName;		//名
	private String lastName;		//姓
	private String birthday;		//生日
	private String sex;				//性别
	private String externalId;		//外部ID
	private String idCard;			//身份证号码
	private Date addDate;			//添加日期
	private Date updateDate;		//更新日期
	
	private String keyword;			//搜索关键字 未持久化
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="LAB_PRACTICE_PATIENTS_SEQ")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="LAB_PRACTICE_PATIENTS_SEQ",sequenceName="LAB_PRACTICE_PATIENTS_SEQ")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "lab_id")
	public Integer getLabId() {
		return labId;
	}
	
	@Column(name = "practice_id")
	public Integer getPracticeId() {
		return practiceId;
	}
	
	@Column(name = "unit_type")
	public Integer getUnitType() {
		return unitType;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	@Column(name = "birthday")
	public String getBirthday() {
		return birthday;
	}
	
	@Column(name = "sex")
	public String getSex() {
		return sex;
	}
	
	@Column(name = "external_id")
	public String getExternalId() {
		return externalId;
	}
	
	@Column(name = "id_card")
	public String getIdCard() {
		return idCard;
	}

	@Column(name = "add_date")
	public Date getAddDate() {
		return addDate;
	}

	@Column(name = "update_date")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	public void setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
	}
	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Transient
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
