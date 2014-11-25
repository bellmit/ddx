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
@Table(name="ddx_case_scheduling_holida")
public class Caseschedulingholida implements Serializable {
	private Integer id;
	private Integer labid;
	private String workdays;
	private String cutofftime;
	private Integer caseturnaround;
	private String  pickupinstructions;
	private String holidays;
	
	public static class Workdays{
		private boolean monday;
		private boolean tuesday;
		private boolean wednesday;
		private boolean thursday;
		private boolean friday;
		private boolean saturday;
		private boolean sunday;
		public boolean isMonday() {
			return monday;
		}
		public void setMonday(boolean monday) {
			this.monday = monday;
		}
		public boolean isTuesday() {
			return tuesday;
		}
		public void setTuesday(boolean tuesday) {
			this.tuesday = tuesday;
		}
		public boolean isWednesday() {
			return wednesday;
		}
		public void setWednesday(boolean wednesday) {
			this.wednesday = wednesday;
		}
		public boolean isThursday() {
			return thursday;
		}
		public void setThursday(boolean thursday) {
			this.thursday = thursday;
		}
		public boolean isFriday() {
			return friday;
		}
		public void setFriday(boolean friday) {
			this.friday = friday;
		}
		public boolean isSaturday() {
			return saturday;
		}
		public void setSaturday(boolean saturday) {
			this.saturday = saturday;
		}
		public boolean isSunday() {
			return sunday;
		}
		public void setSunday(boolean sunday) {
			this.sunday = sunday;
		}
		
	}
	
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="scheduling_holida_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="scheduling_holida_seq",sequenceName="scheduling_holida_sequence")
	@Column(name = "ID")
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
	@Column(name="WORK_DAYS")
	public String getWorkdays() {
		return workdays;
	}
	public void setWorkdays(String workdays) {
		this.workdays = workdays;
	}
	@Column(name="CUT_OFF_TIME")
	public String getCutofftime() {
		return cutofftime;
	}
	public void setCutofftime(String cutofftime) {
		this.cutofftime = cutofftime;
	}
	@Column(name="CASE_TURN_AROUND")
	public Integer getCaseturnaround() {
		return caseturnaround;
	}
	public void setCaseturnaround(Integer caseturnaround) {
		this.caseturnaround = caseturnaround;
	}
	@Column(name="PICKUP_INSTRUCTIONS")
	public String getPickupinstructions() {
		return pickupinstructions;
	}
	public void setPickupinstructions(String pickupinstructions) {
		this.pickupinstructions = pickupinstructions;
	}
	@Column(name="HOLIDAYS")
	public String getHolidays() {
		return holidays;
	}
	public void setHolidays(String holidays) {
		this.holidays = holidays;
	}
	
}
