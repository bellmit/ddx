/**   
 * @Title: LabPreference.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:34:13 
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
 * @ClassName: LabPreference
 * @Description: 技工间偏好设置实体类
 * @author ERIC
 * @date 2014-6-17 上午11:34:13
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_LAB_SET_PREFERENCES")
public class LabPreference implements Serializable {

	private Integer id;//ID
	private Integer labId;//技工间ID
	private String rxProcedureSort;//接受程序排序
	private String enableCoupons;//让优惠券
	private String panNumbers;//潘数字
	private String prefCasesMass;
	private String currency;//货币
	private String storeId;//店铺ID
	private String apiToken;//API令牌
	private String features;//产品特点
	
	//产品特点
	public static class Features{
		private boolean visa;
		private boolean masterCard;
		private boolean americanExpress;
		private boolean discover;
		private boolean onlineChecks;
		private boolean addressVerification;
		private boolean cvdChecks;
		public boolean isVisa() {
			return visa;
		}
		public void setVisa(boolean visa) {
			this.visa = visa;
		}
		public boolean isMasterCard() {
			return masterCard;
		}
		public boolean isAmericanExpress() {
			return americanExpress;
		}
		public boolean isDiscover() {
			return discover;
		}
		public boolean isOnlineChecks() {
			return onlineChecks;
		}
		public boolean isAddressVerification() {
			return addressVerification;
		}
		public boolean isCvdChecks() {
			return cvdChecks;
		}
		public void setMasterCard(boolean masterCard) {
			this.masterCard = masterCard;
		}
		public void setAmericanExpress(boolean americanExpress) {
			this.americanExpress = americanExpress;
		}
		public void setDiscover(boolean discover) {
			this.discover = discover;
		}
		public void setOnlineChecks(boolean onlineChecks) {
			this.onlineChecks = onlineChecks;
		}
		public void setAddressVerification(boolean addressVerification) {
			this.addressVerification = addressVerification;
		}
		public void setCvdChecks(boolean cvdChecks) {
			this.cvdChecks = cvdChecks;
		}
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_preference_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_preference_seq",sequenceName="lab_preference_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "lab_id")
	public Integer getLabId() {
		return labId;
	}
	
	@Column(name = "rx_procedure_sort")
	public String getRxProcedureSort() {
		return rxProcedureSort;
	}
	
	@Column(name = "enable_coupons")
	public String getEnableCoupons() {
		return enableCoupons;
	}
	
	@Column(name = "pan_numbers")
	public String getPanNumbers() {
		return panNumbers;
	}
	
	@Column(name = "pref_cases_mass")
	public String getPrefCasesMass() {
		return prefCasesMass;
	}

	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}
	
	@Column(name = "store_id")
	public String getStoreId() {
		return storeId;
	}
	
	@Column(name = "api_token")
	public String getApiToken() {
		return apiToken;
	}
	
	@Column(name = "features")
	public String getFeatures() {
		return features;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public void setRxProcedureSort(String rxProcedureSort) {
		this.rxProcedureSort = rxProcedureSort;
	}

	public void setEnableCoupons(String enableCoupons) {
		this.enableCoupons = enableCoupons;
	}

	public void setPanNumbers(String panNumbers) {
		this.panNumbers = panNumbers;
	}
	
	public void setPrefCasesMass(String prefCasesMass) {
		this.prefCasesMass = prefCasesMass;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}

	public void setFeatures(String features) {
		this.features = features;
	}
	
}
