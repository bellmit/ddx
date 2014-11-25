package com.upcera.ddx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ddx_lab_set_permissions")
public class LabPermissions implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer labId;
	private String cases;
	private String finances;
	
	public static class Cases{
		private boolean newCase;
		private boolean caseEnclosures;
		private boolean cancelCase;
		private boolean listCasesArrivingToday;
		private boolean listCases;
		private boolean pickup;
		private boolean disabledNotesOnReceived;
		private boolean caseNotes;
		private boolean attachCaseFiles;
		
		
		public boolean isNewCase() {
			return newCase;
		}
		public void setNewCase(boolean newCase) {
			this.newCase = newCase;
		}
		public boolean isCaseEnclosures() {
			return caseEnclosures;
		}
		public void setCaseEnclosures(boolean caseEnclosures) {
			this.caseEnclosures = caseEnclosures;
		}
		public boolean isCancelCase() {
			return cancelCase;
		}
		public void setCancelCase(boolean cancelCase) {
			this.cancelCase = cancelCase;
		}
		public boolean isListCasesArrivingToday() {
			return listCasesArrivingToday;
		}
		public void setListCasesArrivingToday(boolean listCasesArrivingToday) {
			this.listCasesArrivingToday = listCasesArrivingToday;
		}
		public boolean isListCases() {
			return listCases;
		}
		public void setListCases(boolean listCases) {
			this.listCases = listCases;
		}
		public boolean isPickup() {
			return pickup;
		}
		public void setPickup(boolean pickup) {
			this.pickup = pickup;
		}
		public boolean isDisabledNotesOnReceived() {
			return disabledNotesOnReceived;
		}
		public void setDisabledNotesOnReceived(boolean disabledNotesOnReceived) {
			this.disabledNotesOnReceived = disabledNotesOnReceived;
		}
		public boolean isCaseNotes() {
			return caseNotes;
		}
		public void setCaseNotes(boolean caseNotes) {
			this.caseNotes = caseNotes;
		}
		public boolean isAttachCaseFiles() {
			return attachCaseFiles;
		}
		public void setAttachCaseFiles(boolean attachCaseFiles) {
			this.attachCaseFiles = attachCaseFiles;
		}
	}
	public static class Finances{
		private boolean accountPayment;
		private boolean priceList;
		public boolean isAccountPayment() {
			return accountPayment;
		}
		public void setAccountPayment(boolean accountPayment) {
			this.accountPayment = accountPayment;
		}
		public boolean isPriceList() {
			return priceList;
		}
		public void setPriceList(boolean priceList) {
			this.priceList = priceList;
		}
	}
	@Id
	//	@GeneratedValue
	//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_set_permissions")
	//	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_set_permissions",sequenceName="lab_set_permissions_sequence")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "LAB_ID")
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	@Column(name = "CASES")
	public String getCases() {
		return cases;
	}
	public void setCases(String cases) {
		this.cases = cases;
	}
	@Column(name = "FINANCES")
	public String getFinances() {
		return finances;
	}
	public void setFinances(String finances) {
		this.finances = finances;
	}
}
