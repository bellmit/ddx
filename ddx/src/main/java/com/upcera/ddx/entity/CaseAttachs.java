/**   
 * @Title: CaseAttachs.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:26:28 
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
 * @ClassName: CaseAttachs
 * @Description: 案例附件实体类
 * @author ERIC
 * @date 2014-6-17 上午11:26:28
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_CASE_ATTACHED")
public class CaseAttachs implements Serializable {

	private Integer id;				//ID
	private Integer caseId;		//案例ID
	private String fileName;		//文件名
	private String filePath;		//文件存储路径
	private Date caseDate;			//上传日期
	private String caseFrom;		//上传者
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_attached_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_attached_seq",sequenceName="case_attached_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "case_id")
	public Integer getCaseId() {
		return caseId;
	}
	
	@Column(name = "file_name")
	public String getFileName() {
		return fileName;
	}
	
	@Column(name = "file_path")
	public String getFilePath() {
		return filePath;
	}

	@Column(name = "case_date")
	public Date getCaseDate() {
		return caseDate;
	}
	
	@Column(name = "case_from")
	public String getCaseFrom() {
		return caseFrom;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}

	public void setCaseFrom(String caseFrom) {
		this.caseFrom = caseFrom;
	}
	
}
