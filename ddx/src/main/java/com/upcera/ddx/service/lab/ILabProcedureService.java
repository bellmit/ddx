/**   
 * @Title: ILabProcedureService.java 
 * @Package com.upcera.ddx.service.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:18:04 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.lab;

import java.util.List;
import java.util.Map;

import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ILabProcedureService 
 * @Description: 技工间工序Service 
 * @author ERIC
 * @date 2014-6-17 下午04:18:04 
 *  
 */

public interface ILabProcedureService extends IBaseService<LabProcedure, Integer> {

	public List<LabProcedure> getProedureByCriteria(LabProcedure lp);
	public void addProedure(LabProcedure labProcedure,String  linkGroup,String newGroup,String newCategory)throws Exception;
	public void updateProedure(LabProcedure labProcedure,String  linkGroup,String newGroup,String newCategory)throws Exception;
	
	public List<String> getProedureAsHtml(Integer requestLabId)throws Exception;
	
	public Integer queryMaxTurnAroudDays(List<Integer> procedureIdList);
	
	/**
	 * 
	 * @Description: 解析订单工序详细信息
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param thisLabId 当前登录用户机构id
	 * @param thisUnitType 当前登录用户机构类型
	 * @param requestLabId 查询对象的机构间ID
	 * @return List
	 */
	public List<LabProcedure> getRequestLabProcedures(Integer thisUnitId,String thisUnitType, Integer requestLabId)throws Exception ;
	
	/**
	 * 
	 * @Description: 解析订单工序详细信息
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param cases
	 * @return List
	 */
	public List<Map<String, Object>> getProceduresDetailed(Cases cases) throws Exception ;
	/**
	 * 
	 * @Description: 设置订单工序详细信息
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param cases，proceduresStr
	 * @return List
	 */
	public void setProceduresDetailed(Cases cases, String proceduresStr) throws Exception ;
	/**
	 * 
	 * @Description: 删除工序
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param id
	 * @return void
	 */
	public void deleteProcedures(Integer id) throws Exception ;
}
