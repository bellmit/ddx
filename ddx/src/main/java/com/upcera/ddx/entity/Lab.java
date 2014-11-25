package com.upcera.ddx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "ddx_lab")
public class Lab implements Serializable {
	private static final long serialVersionUID = 1748L;

	private Integer id;
	private String name;
	private String phoneNumber;
	private Integer zipCode;
	private String address;
	private String address2;
	private String country;
	private String state;
	private String city;
	private String fax;
	private String email;
	private String website;
	private String timeZone;
	private String licenseNumber;
	private String subdomain;
	private String services;
	private String accountStatus;
	
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

	public static class Services{
		private boolean fixedRestorations;
		private boolean removableRestorations;
		private boolean dentalAppliancesOrthodontics;
		private boolean implantRestorations;
		private boolean dentalWingsServices;
		private boolean e4dServices;
		private boolean lavaCOSServices;
		private boolean zirluxFCServices;
		public boolean isFixedRestorations() {
			return fixedRestorations;
		}
		public void setFixedRestorations(boolean fixedRestorations) {
			this.fixedRestorations = fixedRestorations;
		}
		public boolean isRemovableRestorations() {
			return removableRestorations;
		}
		public void setRemovableRestorations(boolean removableRestorations) {
			this.removableRestorations = removableRestorations;
		}
		public boolean isDentalAppliancesOrthodontics() {
			return dentalAppliancesOrthodontics;
		}
		public void setDentalAppliancesOrthodontics(boolean dentalAppliancesOrthodontics) {
			this.dentalAppliancesOrthodontics = dentalAppliancesOrthodontics;
		}
		public boolean isImplantRestorations() {
			return implantRestorations;
		}
		public void setImplantRestorations(boolean implantRestorations) {
			this.implantRestorations = implantRestorations;
		}
		public boolean isDentalWingsServices() {
			return dentalWingsServices;
		}
		public void setDentalWingsServices(boolean dentalWingsServices) {
			this.dentalWingsServices = dentalWingsServices;
		}
		public boolean isE4dServices() {
			return e4dServices;
		}
		public void setE4dServices(boolean e4dServices) {
			this.e4dServices = e4dServices;
		}
		public boolean isLavaCOSServices() {
			return lavaCOSServices;
		}
		public void setLavaCOSServices(boolean lavaCOSServices) {
			this.lavaCOSServices = lavaCOSServices;
		}
		public boolean isZirluxFCServices() {
			return zirluxFCServices;
		}
		public void setZirluxFCServices(boolean zirluxFCServices) {
			this.zirluxFCServices = zirluxFCServices;
		}
	}
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="unit_seq")
	@SequenceGenerator(allocationSize=1,initialValue=1000,name="unit_seq",sequenceName="unit_sequence")
	@Column(name = "LAB_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "LAB_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "ZIP_CODE")
	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "ADDRESS2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "FAX")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "WEBSITE")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	@Column(name = "TIME_ZONE")
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	@Column(name = "LICENSE_NUMBER")
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	@Column(name = "SUBDOMAIN")
	public String getSubdomain() {
		return subdomain;
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	@Column(name = "SERVICES")
	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}
	@Column(name = "ACCOUNT_STATUS")
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Column(name = "sun_from")
	public String getSunFrom() {
		return sunFrom;
	}

	public void setSunFrom(String sunFrom) {
		this.sunFrom = sunFrom;
	}

	@Column(name = "sun_to")
	public String getSunTo() {
		return sunTo;
	}

	public void setSunTo(String sunTo) {
		this.sunTo = sunTo;
	}

	@Column(name = "mon_from")
	public String getMonFrom() {
		return monFrom;
	}

	public void setMonFrom(String monFrom) {
		this.monFrom = monFrom;
	}

	@Column(name = "mon_to")
	public String getMonTo() {
		return monTo;
	}

	public void setMonTo(String monTo) {
		this.monTo = monTo;
	}

	@Column(name = "tue_from")
	public String getTueFrom() {
		return tueFrom;
	}

	public void setTueFrom(String tueFrom) {
		this.tueFrom = tueFrom;
	}

	@Column(name = "tue_to")
	public String getTueTo() {
		return tueTo;
	}

	public void setTueTo(String tueTo) {
		this.tueTo = tueTo;
	}

	@Column(name = "wed_from")
	public String getWedFrom() {
		return wedFrom;
	}

	public void setWedFrom(String wedFrom) {
		this.wedFrom = wedFrom;
	}

	@Column(name = "wed_to")
	public String getWedTo() {
		return wedTo;
	}

	public void setWedTo(String wedTo) {
		this.wedTo = wedTo;
	}

	@Column(name = "thu_from")
	public String getThuFrom() {
		return thuFrom;
	}

	public void setThuFrom(String thuFrom) {
		this.thuFrom = thuFrom;
	}

	@Column(name = "thu_to")
	public String getThuTo() {
		return thuTo;
	}

	public void setThuTo(String thuTo) {
		this.thuTo = thuTo;
	}

	@Column(name = "fri_from")
	public String getFriFrom() {
		return friFrom;
	}

	public void setFriFrom(String friFrom) {
		this.friFrom = friFrom;
	}

	@Column(name = "fri_to")
	public String getFriTo() {
		return friTo;
	}

	public void setFriTo(String friTo) {
		this.friTo = friTo;
	}

	@Column(name = "sat_from")
	public String getSatFrom() {
		return satFrom;
	}

	public void setSatFrom(String satFrom) {
		this.satFrom = satFrom;
	}

	@Column(name = "sat_to")
	public String getSatTo() {
		return satTo;
	}

	public void setSatTo(String satTo) {
		this.satTo = satTo;
	}

	@Column(name = "sun_open")
	public Integer getSunOpen() {
		return sunOpen;
	}

	public void setSunOpen(Integer sunOpen) {
		this.sunOpen = sunOpen;
	}

	@Column(name = "mon_open")
	public Integer getMonOpen() {
		return monOpen;
	}

	public void setMonOpen(Integer monOpen) {
		this.monOpen = monOpen;
	}

	@Column(name = "tue_open")
	public Integer getTueOpen() {
		return tueOpen;
	}

	public void setTueOpen(Integer tueOpen) {
		this.tueOpen = tueOpen;
	}

	@Column(name = "wed_open")
	public Integer getWedOpen() {
		return wedOpen;
	}

	public void setWedOpen(Integer wedOpen) {
		this.wedOpen = wedOpen;
	}

	@Column(name = "thu_open")
	public Integer getThuOpen() {
		return thuOpen;
	}

	public void setThuOpen(Integer thuOpen) {
		this.thuOpen = thuOpen;
	}

	@Column(name = "fri_open")
	public Integer getFriOpen() {
		return friOpen;
	}

	public void setFriOpen(Integer friOpen) {
		this.friOpen = friOpen;
	}

	@Column(name = "sat_open")
	public Integer getSatOpen() {
		return satOpen;
	}

	public void setSatOpen(Integer satOpen) {
		this.satOpen = satOpen;
	}
	
	
}
