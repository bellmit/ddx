/**   
 * @Title: ILabProcedureAttrService.java 
 * @Package com.upcera.ddx.service.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:19:19 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.lab;

import com.upcera.ddx.entity.LabProcedureAttr;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ILabProcedureAttrService 
 * @Description: 技工间工序属性Service
 * @author ERIC
 * @date 2014-6-17 下午04:19:19 
 *  
 */

public interface ILabProcedureAttrService extends IBaseService<LabProcedureAttr, Integer> {
	public void deleteAttrByProceduresId(Integer id) throws Exception;
}
