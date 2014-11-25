/**   
 * @Title: FilterOption.java 
 * @Package com.upcera.ddx.pojo 
 * @author ERIC
 * @company UPCERA
 * @date 2014-8-26 下午03:09:25 
 * @version V1.0   
 */ 
package com.upcera.ddx.pojo;

/** 
 * @ClassName: FilterOption 
 * @Description: 订单过滤中机构选项 
 * @author ERIC
 * @date 2014-8-26 下午03:09:25 
 *  
 */

public class FilterOption{
	private String unitType;//机构类型 1技工间 2诊所
	private Integer unitId;	//机构ID
	private String  uniteName;//机构名称
	
	public FilterOption(String unitType,Integer unitId,String uniteName){
		this.unitType = unitType;
		this.unitId = unitId;
		this.uniteName = uniteName;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUniteName() {
		return uniteName;
	}
	public void setUniteName(String uniteName) {
		this.uniteName = uniteName;
	}
}