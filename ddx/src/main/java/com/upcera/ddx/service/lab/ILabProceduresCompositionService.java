/**   
 * @Title: ILabProceduresCompositionService.java 
 * @Package com.upcera.ddx.service.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:18:04 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.lab;

import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ILabProceduresCompositionService 
 * @Description: 技工间工序特性-材料组成Service 
 * @author ERIC
 * @date 2014-6-17 下午04:18:04 
 *  
 */

public interface ILabProceduresCompositionService extends IBaseService<LabProceduresComposition, Integer> {

	public PageModel getCompositionByCriteria(LabProceduresComposition compostion);
	
}
