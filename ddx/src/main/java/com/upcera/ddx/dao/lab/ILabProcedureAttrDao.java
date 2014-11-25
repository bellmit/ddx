/**   
 * @Title: ILabProcedureAttrDao.java 
 * @Package com.upcera.ddx.dao.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:42:17 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.lab;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabProcedureAttr;

/** 
 * @ClassName: ILabProcedureAttrDao 
 * @Description: 技工间工序属性DAO 
 * @author ERIC
 * @date 2014-6-17 下午03:42:17 
 *  
 */
@Repository("labProcedureAttrDao")
public interface ILabProcedureAttrDao extends IBaseDao<LabProcedureAttr, Integer> {
	public void deleteAttrByProceduresId(Integer id) throws Exception;
}
