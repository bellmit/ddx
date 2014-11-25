/**   
 * @Title: Practice.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:33:14 
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
 * @ClassName: Practice 
 * @Description: 诊所实体类
 * @author ERIC
 * @date 2014-6-11 下午02:33:14 
 *  
 */
@SuppressWarnings("serial")
@Entity
@Table(name="DDX_PRACTICE")
public class Practice implements Serializable {
	
	private Integer id;					//诊所ID
	private String name;				//名称
	private String address;				//地址
	private String city;				//城市
	private String state;				//省
	private Integer zipCode;			//邮编
	private String country;				//国家
	private String phoneNumber;			//电话
	private String email;
	private String timeZone;			//时区
	private String accountStatus;		//账号状态
	private String fax;					//传真
	private String address2;			//地址2
	private String legalName;			//法律名称
	private String sikka;				//sikka
	private String providers;			//供应商
	private String sunFrom;				//周日开始时间
	private String sunTo;				//周日结束时间
	private String monFrom;				//周一开始时间
	private String monTo;				//周一结束时间
	private String tueFrom;				//周二开始时间
	private String tueTo;				//周二结束时间
	private String wedFrom;				//周三开始时间
	private String wedTo;				//周三结束时间
	private String thuFrom;				//周四开始时间
	private String thuTo;				//周四结束时间
	private String friFrom;				//周五开始时间
	private String friTo;				//周五结束时间
	private String satFrom;				//周六开始时间
	private String satTo;				//周六结束时间
	
	private Integer sunOpen;
	private Integer monOpen;
	private Integer tueOpen;
	private Integer wedOpen;
	private Integer thuOpen;
	private Integer	friOpen;
	private Integer satOpen;
	
	private String prefCaseLicense;		//证件号码
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="unit_seq")
	@SequenceGenerator(allocationSize=1,initialValue=1000,name="unit_seq",sequenceName="unit_seq")
	@Column(name = "practice_id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	@Column(name = "zip_code")
	public Integer getZipCode() {
		return zipCode;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	@Column(name = "telephone")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Column(name = "time_zone")
	public String getTimeZone() {
		return timeZone;
	}

	@Column(name = "account_status")
	public String getAccountStatus() {
		return accountStatus;
	}

	@Column(name = "fax")
	public String getFax() {
		return fax;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	@Column(name = "legal_name")
	public String getLegalName() {
		return legalName;
	}

	@Column(name = "sikka")
	public String getSikka() {
		return sikka;
	}

	@Column(name = "providers")
	public String getProviders() {
		return providers;
	}

	@Column(name = "sun_from")
	public String getSunFrom() {
		return sunFrom;
	}

	@Column(name = "sun_to")
	public String getSunTo() {
		return sunTo;
	}

	@Column(name = "mon_from")
	public String getMonFrom() {
		return monFrom;
	}

	@Column(name = "mon_to")
	public String getMonTo() {
		return monTo;
	}

	@Column(name = "tue_from")
	public String getTueFrom() {
		return tueFrom;
	}

	@Column(name = "tue_to")
	public String getTueTo() {
		return tueTo;
	}

	@Column(name = "wed_from")
	public String getWedFrom() {
		return wedFrom;
	}

	@Column(name = "wed_to")
	public String getWedTo() {
		return wedTo;
	}

	@Column(name = "thu_from")
	public String getThuFrom() {
		return thuFrom;
	}

	@Column(name = "thu_to")
	public String getThuTo() {
		return thuTo;
	}

	@Column(name = "fri_from")
	public String getFriFrom() {
		return friFrom;
	}

	@Column(name = "fri_to")
	public String getFriTo() {
		return friTo;
	}

	@Column(name = "sat_from")
	public String getSatFrom() {
		return satFrom;
	}

	@Column(name = "sat_to")
	public String getSatTo() {
		return satTo;
	}

	@Column(name = "sun_open")
	public Integer getSunOpen() {
		return sunOpen;
	}

	@Column(name = "mon_open")
	public Integer getMonOpen() {
		return monOpen;
	}

	@Column(name = "tue_open")
	public Integer getTueOpen() {
		return tueOpen;
	}

	@Column(name = "wed_open")
	public Integer getWedOpen() {
		return wedOpen;
	}

	@Column(name = "thu_open")
	public Integer getThuOpen() {
		return thuOpen;
	}

	@Column(name = "fri_open")
	public Integer getFriOpen() {
		return friOpen;
	}

	@Column(name = "sat_open")
	public Integer getSatOpen() {
		return satOpen;
	}

	@Column(name = "pref_case_license")
	public String getPrefCaseLicense() {
		return prefCaseLicense;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public void setSikka(String sikka) {
		this.sikka = sikka;
	}

	public void setProviders(String providers) {
		this.providers = providers;
	}

	public void setSunFrom(String sunFrom) {
		this.sunFrom = sunFrom;
	}

	public void setSunTo(String sunTo) {
		this.sunTo = sunTo;
	}

	public void setMonFrom(String monFrom) {
		this.monFrom = monFrom;
	}

	public void setMonTo(String monTo) {
		this.monTo = monTo;
	}

	public void setTueFrom(String tueFrom) {
		this.tueFrom = tueFrom;
	}

	public void setTueTo(String tueTo) {
		this.tueTo = tueTo;
	}

	public void setWedFrom(String wedFrom) {
		this.wedFrom = wedFrom;
	}

	public void setWedTo(String wedTo) {
		this.wedTo = wedTo;
	}

	public void setThuFrom(String thuFrom) {
		this.thuFrom = thuFrom;
	}

	public void setThuTo(String thuTo) {
		this.thuTo = thuTo;
	}

	public void setFriFrom(String friFrom) {
		this.friFrom = friFrom;
	}

	public void setFriTo(String friTo) {
		this.friTo = friTo;
	}

	public void setSatFrom(String satFrom) {
		this.satFrom = satFrom;
	}

	public void setSatTo(String satTo) {
		this.satTo = satTo;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSunOpen(Integer sunOpen) {
		this.sunOpen = sunOpen;
	}

	public void setMonOpen(Integer monOpen) {
		this.monOpen = monOpen;
	}

	public void setTueOpen(Integer tueOpen) {
		this.tueOpen = tueOpen;
	}

	public void setWedOpen(Integer wedOpen) {
		this.wedOpen = wedOpen;
	}

	public void setThuOpen(Integer thuOpen) {
		this.thuOpen = thuOpen;
	}

	public void setFriOpen(Integer friOpen) {
		this.friOpen = friOpen;
	}

	public void setSatOpen(Integer satOpen) {
		this.satOpen = satOpen;
	}
	
	public void setPrefCaseLicense(String prefCaseLicense) {
		this.prefCaseLicense = prefCaseLicense;
	}

}
