package com.upcera.ddx.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.upcera.ddx.common.target.Excel;
@Entity
@Table(name = "DDX_lab_case_coupons")
public class LabCaseCoupons implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer labid;			//技工间编号
	private Integer proceduresid;	//工序编号
	private String prefix;			//代码
	private Timestamp expiry;		//失效时间
	private Timestamp effective;	//生效时间
	private Integer discount;		//折扣
	private String discountType;	//折扣类型
	private Integer unitid;			//机构id
	private String unittype;		//机构类型
	
	private Integer claimed;		//已产生额订单数
	private Integer maxUse;			//多次使用的优惠券最大使用次数
	private Integer useFrequency;	//已使用次数
	private String useType;			//优惠券类型
	private String remarks;			//备注
	
	private String proceduresName;	//工序名称，页面展示用
	private String labName;	//页面展示用
	private String unitName;	//页面展示用
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_coupons_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_coupons_seq",sequenceName="case_coupons_seq")
	@Column(name = "ID")
	@Excel(index=0,title="编号")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="LAB_ID")
	public Integer getLabid() {
		return labid;
	}
	public void setLabid(Integer labid) {
		this.labid = labid;
	}
	@Column(name="PROCEDURES_ID")
	public Integer getProceduresid() {
		return proceduresid;
	}
	public void setProceduresid(Integer proceduresid) {
		this.proceduresid = proceduresid;
	}
	@Column(name="PREFIX")
	@Excel(index=3,title="代码")
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	@Column(name="effective")
	@Excel(index=4,title="生效时间")
	public Timestamp getEffective() {
		return effective;
	}
	public void setEffective(Timestamp effective) {
		this.effective = effective;
	}
	@Column(name="EXPIRY")
	@Excel(index=5,title="失效时间")
	public Timestamp getExpiry() {
		return expiry;
	}
	public void setExpiry(Timestamp expiry) {
		this.expiry = expiry;
	}
	@Column(name="DISCOUNT",columnDefinition="int default 0")
	@Excel(index=6,title="折扣")
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	@Column(name="discountType")
	@Excel(index=7,title="折扣类型")
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	@Column(name="unit_id")
	public Integer getUnitid() {
		return unitid;
	}
	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}
	@Column(name="unit_type")
	@Excel(index=9,title="机构类型")
	public String getUnittype() {
		return unittype;
	}
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	@Column(name="claimed")
	@Excel(index=10,title="已产生订单数")
	public Integer getClaimed() {
		return claimed;
	}
	public void setClaimed(Integer claimed) {
		this.claimed = claimed;
	}
	@Column(name="maxUse",columnDefinition="int default 1")
	@Excel(index=11,title="最大使用次数")
	public Integer getMaxUse() {
		return maxUse;
	}
	public void setMaxUse(Integer maxUse) {
		this.maxUse = maxUse;
	}
	@Column(name="useFrequency",columnDefinition="int default 0")
	@Excel(index=12,title="已使用次数")
	public Integer getUseFrequency() {
		return useFrequency;
	}
	public void setUseFrequency(Integer useFrequency) {
		this.useFrequency = useFrequency;
	}
	@Column(name="useType")
	@Excel(index=13,title="优惠券类型")
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	@Excel(index=2,title="工序")
	@Transient
	public String getProceduresName() {
		return proceduresName;
	}
	public void setProceduresName(String proceduresName) {
		this.proceduresName = proceduresName;
	}
	@Column(name="remarks")
	@Excel(index=14,title="说明")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	@Excel(index=1,title="技工间")
	@Transient
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	@Excel(index=8,title="指定的机构")
	@Transient
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
}
