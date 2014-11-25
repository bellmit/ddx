/**   
 * @Title: LabProcedure.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:43:08 
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
 * @ClassName: LabProcedure
 * @Description: 技工间工序实体类
 * @author ERIC
 * @date 2014-6-17 上午11:43:08
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_LAB_PROCEDURES")
public class LabProcedure implements Serializable {

	private Integer proceduresId;					//工序ID
	private Integer labId;							//实验室ID
	private Integer proceduresCategoryId;			//第一级工序类别ID
	private Integer proceduresCategorySubId;		//第二级工序子类别ID
	private Integer proceduresTypeId;				//第三级工序类型ID
	private Integer categoryId;						//工序显示归类ID
	private String displayName;						//显示_工序名称
	private String displayDescription;				//显示_工序描述
	private Integer displaySortRank;				//显示_工序排序排名
	private String displayUnitCount;				//显示_单位计数
	private String schedulingDefaultTurnAround;		//调度_默认运转天
	private String schedulingTurnAroundDays;		//调度_运转天
	private String schedulingOverrideDefault;		//调度_默认重写
	private String schedulingTurnAttribute;			//调度_运转按属性
	private String schedulingTurnAccount;			//调度_运转按账户
	private String schedulingIgnoreInboundDay;		//调度_忽略入站交通天数
	private String schedulingIgnoreOutboundDay;		//调度_忽略出战交通天数


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lab_procedure_seq")
	@SequenceGenerator(allocationSize = 1, initialValue = 500, name = "lab_procedure_seq", sequenceName = "lab_procedure_seq")
	@Column(name = "procedures_id")
	public Integer getProceduresId() {
		return proceduresId;
	}

	@Column(name = "lab_id")
	public Integer getLabId() {
		return labId;
	}


	@Column(name = "procedures_category_id")
	public Integer getProceduresCategoryId() {
		return proceduresCategoryId;
	}

	@Column(name = "procedures_type_id")
	public Integer getProceduresTypeId() {
		return proceduresTypeId;
	}

	@Column(name = "procedures_category_sub_id")
	public Integer getProceduresCategorySubId() {
		return proceduresCategorySubId;
	}

	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

	@Column(name = "display_description")
	public String getDisplayDescription() {
		return displayDescription;
	}

	@Column(name = "display_sort_rank")
	public Integer getDisplaySortRank() {
		return displaySortRank;
	}

	@Column(name = "display_unit_count")
	public String getDisplayUnitCount() {
		return displayUnitCount;
	}

	@Column(name = "scheduling_default_turn_around")
	public String getSchedulingDefaultTurnAround() {
		return schedulingDefaultTurnAround;
	}

	@Column(name = "scheduling_turn_around_days")
	public String getSchedulingTurnAroundDays() {
		return schedulingTurnAroundDays;
	}

	@Column(name = "scheduling_override_default")
	public String getSchedulingOverrideDefault() {
		return schedulingOverrideDefault;
	}

	@Column(name = "scheduling_turn_attribute")
	public String getSchedulingTurnAttribute() {
		return schedulingTurnAttribute;
	}

	@Column(name = "scheduling_turn_account")
	public String getSchedulingTurnAccount() {
		return schedulingTurnAccount;
	}

	@Column(name = "scheduling_ignore_inbound_day")
	public String getSchedulingIgnoreInboundDay() {
		return schedulingIgnoreInboundDay;
	}

	@Column(name = "scheduling_ignore_outbound_day")
	public String getSchedulingIgnoreOutboundDay() {
		return schedulingIgnoreOutboundDay;
	}
	@Column(name = "CATEGORY_ID")
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setProceduresId(Integer proceduresId) {
		this.proceduresId = proceduresId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}


	public void setProceduresCategoryId(Integer proceduresCategoryId) {
		this.proceduresCategoryId = proceduresCategoryId;
	}

	public void setProceduresTypeId(Integer proceduresTypeId) {
		this.proceduresTypeId = proceduresTypeId;
	}

	public void setProceduresCategorySubId(Integer proceduresCategorySubId) {
		this.proceduresCategorySubId = proceduresCategorySubId;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}

	public void setDisplaySortRank(Integer displaySortRank) {
		this.displaySortRank = displaySortRank;
	}

	public void setDisplayUnitCount(String displayUnitCount) {
		this.displayUnitCount = displayUnitCount;
	}

	public void setSchedulingDefaultTurnAround(String schedulingDefaultTurnAround) {
		this.schedulingDefaultTurnAround = schedulingDefaultTurnAround;
	}

	public void setSchedulingTurnAroundDays(String schedulingTurnAroundDays) {
		this.schedulingTurnAroundDays = schedulingTurnAroundDays;
	}

	public void setSchedulingOverrideDefault(String schedulingOverrideDefault) {
		this.schedulingOverrideDefault = schedulingOverrideDefault;
	}

	public void setSchedulingTurnAttribute(String schedulingTurnAttribute) {
		this.schedulingTurnAttribute = schedulingTurnAttribute;
	}

	public void setSchedulingTurnAccount(String schedulingTurnAccount) {
		this.schedulingTurnAccount = schedulingTurnAccount;
	}

	public void setSchedulingIgnoreInboundDay(String schedulingIgnoreInboundDay) {
		this.schedulingIgnoreInboundDay = schedulingIgnoreInboundDay;
	}

	public void setSchedulingIgnoreOutboundDay(String schedulingIgnoreOutboundDay) {
		this.schedulingIgnoreOutboundDay = schedulingIgnoreOutboundDay;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
