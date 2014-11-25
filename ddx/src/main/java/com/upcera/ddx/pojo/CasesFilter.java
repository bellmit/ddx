/**   
 * @Title: CasesFilter.java 
 * @Package com.upcera.ddx.pojo 
 * @author ERIC
 * @company UPCERA
 * @date 2014-8-26 下午03:37:35 
 * @version V1.0   
 */ 
package com.upcera.ddx.pojo;

import java.util.Date;


/** 
 * @ClassName: CasesFilter 
 * @Description: 订单列表过滤条件 
 * @author ERIC
 * @date 2014-8-26 下午03:37:35 
 *  
 */

public class CasesFilter {
	private String  filterBy;
	private Integer unitId;
	private Integer unitType;
	private Integer year;
	private Integer month;
	
	private Date startDate;
	private Date endDate;
	private String format;
	
	
	public String getFilterBy() {
		return filterBy;
	}
	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getUnitType() {
		return unitType;
	}
	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getFormat() {
		return format;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
}
