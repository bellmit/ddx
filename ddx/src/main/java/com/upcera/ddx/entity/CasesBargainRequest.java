/**   
 * @Title: CasesBargainRequest.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-10-24 上午10:20:14 
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @ClassName: CasesBargainRequest
 * @Description: 订单议价申请
 * @author ERIC
 * @date 2014-10-24 上午10:20:14
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_CASES_BARGAIN_REQUEST")
public class CasesBargainRequest implements Serializable {
	private Integer id;
	private Integer caseId;			// 订单ID
	private Integer unitId;			// 订单的下单机构id
	private Integer unitType;		// 下单机构类型
	private Double originalPrice;	// 原价格
	private Double askPrice;		// 申请价
	private Integer applicantId;	// 申请人ID
	private String applicantName;	// 申请人名
	private Integer bargainLimit;	// 申请人优惠限度
	private String askReason;		// 申请人简述
	private Integer verifierId;		// 审核人id
	private String verifierName;	// 申请人
	private String status;			// 审核状态 通过、不通过 通过即立即更新订单的价格，不通过必须填审核意见
	private String verifyOpinion;	// 审核意见
	private Date askDate;			// 申请日期
	private Date verifyDate;		// 审核日期

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_bargainRequest_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_bargainRequest_seq",sequenceName="case_bargainRequest_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "case_id")
	public Integer getCaseId() {
		return caseId;
	}

	@Column(name = "unit_id")
	public Integer getUnitId() {
		return unitId;
	}

	@Column(name = "unit_type")
	public Integer getUnitType() {
		return unitType;
	}

	@Column(name = "original_price")
	public Double getOriginalPrice() {
		return originalPrice;
	}

	@Column(name = "ask_price")
	public Double getAskPrice() {
		return askPrice;
	}

	@Column(name = "applicant_id")
	public Integer getApplicantId() {
		return applicantId;
	}

	@Column(name = "applicant_name")
	public String getApplicantName() {
		return applicantName;
	}

	@Column(name = "bargain_limit")
	public Integer getBargainLimit() {
		return bargainLimit;
	}

	@Column(name = "ask_reason")
	public String getAskReason() {
		return askReason;
	}

	@Column(name = "verifier_id")
	public Integer getVerifierId() {
		return verifierId;
	}

	@Column(name = "verifier_name")
	public String getVerifierName() {
		return verifierName;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	@Column(name = "verify_opinion")
	public String getVerifyOpinion() {
		return verifyOpinion;
	}

	@Column(name = "ask_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAskDate() {
		return askDate;
	}

	@Column(name = "verify_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public void setAskPrice(Double askPrice) {
		this.askPrice = askPrice;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public void setBargainLimit(Integer bargainLimit) {
		this.bargainLimit = bargainLimit;
	}

	public void setAskReason(String askReason) {
		this.askReason = askReason;
	}

	public void setVerifierId(Integer verifierId) {
		this.verifierId = verifierId;
	}

	public void setVerifierName(String verifierName) {
		this.verifierName = verifierName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVerifyOpinion(String verifyOpinion) {
		this.verifyOpinion = verifyOpinion;
	}

	public void setAskDate(Date askDate) {
		this.askDate = askDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

}
