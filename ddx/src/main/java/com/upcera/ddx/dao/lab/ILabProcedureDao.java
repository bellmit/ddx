/**   
 * @Title: ILabProcedureDao.java 
 * @Package com.upcera.ddx.dao.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:38:31 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.lab;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabProcedure;

/** 
 * @ClassName: ILabProcedureDao 
 * @Description: 技工间工序DAO 
 * @author ERIC
 * @date 2014-6-17 下午03:38:31 
 *  
 */
@Repository("labProcedureDao")
public interface ILabProcedureDao extends IBaseDao<LabProcedure, Integer> {
	
	public List<LabProcedure> getProedureByCriteria(LabProcedure lp);
	
	public Integer queryMaxTurnAroudDays(List<Integer> procedureIdList);
	
	public List<LabProcedure> getRequestLabProcedures(Integer thisUnitId,String thisUnitType, Integer requestLabId)throws Exception;

}
