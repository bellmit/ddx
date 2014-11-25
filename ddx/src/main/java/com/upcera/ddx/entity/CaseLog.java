/**   
 * @Title: CaseLog.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:19:42 
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
 * @ClassName: CaseLog
 * @Description: 案例日志实体类
 * @author ERIC
 * @date 2014-6-17 上午11:19:42
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_CASE_LOG")
public class CaseLog implements Serializable {

	private Integer id;					//ID
	private Integer caseId;			//案例ID
	private Integer proceduresId;		//工序ID
	private Integer accountId;			//操作账号ID
	private Date createTime;			//创建时间
	private String operationType;		//操作类型
	private String changes;				//更新
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_log_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_log_seq",sequenceName="case_log_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "case_id")
	public Integer getCaseId() {
		return caseId;
	}
	
	@Column(name = "procedures_id")
	public Integer getProceduresId() {
		return proceduresId;
	}
	
	@Column(name = "account_id")
	public Integer getAccountId() {
		return accountId;
	}
	
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}
	
	@Column(name = "operation_type")
	public String getOperationType() {
		return operationType;
	}

	@Column(name = "changes")
	public String getChanges() {
		return changes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public void setProceduresId(Integer proceduresId) {
		this.proceduresId = proceduresId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	public void setChanges(String changes) {
		this.changes = changes;
	}
}
