package com.upcera.ddx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.upcera.ddx.constans.Constans;


@Entity
@Table(name = "ddx_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer accountId;
	private Integer labId;			//实验室ID
	private Integer practiceId;		//诊所ID
	private String userName;		//账号
	private String password;		//密码
	private String type;			//类型（技工间专用字段）
	private String groupType;		//类别。组
	private String salutation;		//用户昵称
	private String firstName;		//名字
	private String lastName;		//姓
	private String externalID;		//用户外部标识
	private String email;			//邮件
	private String ddxNewsletter;	//DDX时事通讯
	private String ddxDailySummary;	//DDX每日摘要
	private String ddxActivityLog;	//DDX活动日志
	private String teethNotation;	//牙齿符号
	private String accountInitial;	//首字母
	private String licenseNumber;	//许可证号
	private String signature;		//签名
	private String autoFollowCases;	//自动跟随案例（诊所专用）（true/false）
	private String role;			//角色（诊所专用）
	private String managerAccount;	//是否可以管理账户权限（true/false）
	private String createCaseTags;	//是否可以创建标签权限(true/false)
	private String labPermissions;	//主账户对其的技工间操作授权（诊所专用）
	
	private String unitType;		//add by king. 2014-8-14 14:53:14、 此用户所属机构类型：1：技工间，2：诊所
	private String isMain;			//在当前技工间或诊所里是否为注册机构的主账户，此身份在注册的时候后台自动给定：true
	private Integer parentId;		//添加用户组关联时判断是否有父ID，如果有则为已被绑定的子账户，否则为未被绑定的主账户
	
	private Integer preferentialLimit;//议价的优惠额度，技工间主账户可以为自身及其子账户设置此参数
	
	private Integer unitId;			//机构ID，备用字段
	
	public static class DDXActivityLog {
		private boolean casesCreated;
		private boolean casesCreatedPracticeUpdatesOnly;
		private boolean casesCreatedLabUpdatesOnly;
		private boolean updatedCases;
		private boolean updatedCasesPracticeUpdatesOnly;
		private boolean updatedCasesLabUpdatesOnly;
		private boolean pickupRequests;
		private boolean balancePayments;
		private boolean statements;
		private boolean invoices;
		private boolean accounts;
		private boolean accountsPracticeUpdatesOnly;
		private boolean accountsLabUpdatesOnly;
		public boolean isCasesCreated() {
			return casesCreated;
		}
		public void setCasesCreated(boolean casesCreated) {
			this.casesCreated = casesCreated;
		}
		public boolean isCasesCreatedPracticeUpdatesOnly() {
			return casesCreatedPracticeUpdatesOnly;
		}
		public void setCasesCreatedPracticeUpdatesOnly(boolean casesCreatedPracticeUpdatesOnly) {
			this.casesCreatedPracticeUpdatesOnly = casesCreatedPracticeUpdatesOnly;
		}
		public boolean isCasesCreatedLabUpdatesOnly() {
			return casesCreatedLabUpdatesOnly;
		}
		public void setCasesCreatedLabUpdatesOnly(boolean casesCreatedLabUpdatesOnly) {
			this.casesCreatedLabUpdatesOnly = casesCreatedLabUpdatesOnly;
		}
		public boolean isUpdatedCases() {
			return updatedCases;
		}
		public void setUpdatedCases(boolean updatedCases) {
			this.updatedCases = updatedCases;
		}
		public boolean isUpdatedCasesPracticeUpdatesOnly() {
			return updatedCasesPracticeUpdatesOnly;
		}
		public void setUpdatedCasesPracticeUpdatesOnly(boolean updatedCasesPracticeUpdatesOnly) {
			this.updatedCasesPracticeUpdatesOnly = updatedCasesPracticeUpdatesOnly;
		}
		public boolean isUpdatedCasesLabUpdatesOnly() {
			return updatedCasesLabUpdatesOnly;
		}
		public void setUpdatedCasesLabUpdatesOnly(boolean updatedCasesLabUpdatesOnly) {
			this.updatedCasesLabUpdatesOnly = updatedCasesLabUpdatesOnly;
		}
		public boolean isPickupRequests() {
			return pickupRequests;
		}
		public void setPickupRequests(boolean pickupRequests) {
			this.pickupRequests = pickupRequests;
		}
		public boolean isBalancePayments() {
			return balancePayments;
		}
		public void setBalancePayments(boolean balancePayments) {
			this.balancePayments = balancePayments;
		}
		public boolean isStatements() {
			return statements;
		}
		public void setStatements(boolean statements) {
			this.statements = statements;
		}
		public boolean isInvoices() {
			return invoices;
		}
		public void setInvoices(boolean invoices) {
			this.invoices = invoices;
		}
		public boolean isAccounts() {
			return accounts;
		}
		public void setAccounts(boolean accounts) {
			this.accounts = accounts;
		}
		public boolean isAccountsPracticeUpdatesOnly() {
			return accountsPracticeUpdatesOnly;
		}
		public void setAccountsPracticeUpdatesOnly(boolean accountsPracticeUpdatesOnly) {
			this.accountsPracticeUpdatesOnly = accountsPracticeUpdatesOnly;
		}
		public boolean isAccountsLabUpdatesOnly() {
			return accountsLabUpdatesOnly;
		}
		public void setAccountsLabUpdatesOnly(boolean accountsLabUpdatesOnly) {
			this.accountsLabUpdatesOnly = accountsLabUpdatesOnly;
		}
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="user_seq",sequenceName="user_sequence")
	@Column(name = "ACCOUNT_ID")
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	@Column(name = "GROUP_TYPE")
	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	@Column(name = "LAB_ID")
	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	@Column(name = "PRACTICE_ID")
	public Integer getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
	}

	@Column(name = "USERNAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "SALUTATION")
	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EXTERNAL_ID")
	public String getExternalID() {
		return externalID;
	}

	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "DDX_NEWSLETTER")
	public String getDdxNewsletter() {
		return ddxNewsletter;
	}

	public void setDdxNewsletter(String ddxNewsletter) {
		this.ddxNewsletter = ddxNewsletter;
	}

	@Column(name = "DDX_DAILY_SUMMARY")
	public String getDdxDailySummary() {
		return ddxDailySummary;
	}

	public void setDdxDailySummary(String ddxDailySummary) {
		this.ddxDailySummary = ddxDailySummary;
	}

	@Column(name = "DDX_ACTIVITY_LOG")
	public String getDdxActivityLog() {
		return ddxActivityLog;
	}

	public void setDdxActivityLog(String ddxActivityLog) {
		this.ddxActivityLog = ddxActivityLog;
	}

	@Column(name = "TEETH_NOTATION")
	public String getTeethNotation() {
		return teethNotation;
	}

	public void setTeethNotation(String teethNotation) {
		this.teethNotation = teethNotation;
	}

	@Column(name = "ACCOUNT_INITIAL")
	public String getAccountInitial() {
		return accountInitial;
	}

	public void setAccountInitial(String accountInitial) {
		this.accountInitial = accountInitial;
	}

	@Column(name = "LICENSE_NUMBER")
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@Column(name = "SIGNATURE")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "AUTO_FOLLOW_CASES")
	public String getAutoFollowCases() {
		return autoFollowCases;
	}

	public void setAutoFollowCases(String autoFollowCases) {
		this.autoFollowCases = autoFollowCases;
	}

	@Column(name = "ROLE")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Column(name = "IS_MAIN")
	public String getIsMain() {
		return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	@Column(name = "PARENT_ID")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Column(name = "UNIT_TYPE")
	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	@Column(name = "MANAGER_ACCOUNT")
	public String getManagerAccount() {
		return managerAccount;
	}

	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}
	@Column(name = "CREATE_CASE_TAGS")
	public String getCreateCaseTags() {
		return createCaseTags;
	}

	public void setCreateCaseTags(String createCaseTags) {
		this.createCaseTags = createCaseTags;
	}
	@Column(name = "LAB_PERMISSIONS")
	public String getLabPermissions() {
		return labPermissions;
	}

	public void setLabPermissions(String labPermissions) {
		this.labPermissions = labPermissions;
	}

	@Column(name = "PREFERENTIAL_LIMIT",columnDefinition = "number(10) default 0")
	public Integer getPreferentialLimit() {
		return preferentialLimit;
	}

	public void setPreferentialLimit(Integer preferentialLimit) {
		this.preferentialLimit = preferentialLimit;
	}
	
	@Transient
	public Integer getUnitId() {
		if (Constans.UNIT_LAB.equals(unitType)) {
			unitId = labId;
		} else if (Constans.UNIT_PRACTICE.equals(unitType)) {
			unitId = practiceId;
		}
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	
}
