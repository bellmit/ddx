/**   
 * @Title: ICaseAttachsService.java 
 * @Package com.upcera.ddx.service.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:58:25 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases;

import java.util.List;

import com.upcera.ddx.entity.CaseAttachs;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ICaseAttachsService 
 * @Description: 案例附件Service 
 * @author ERIC
 * @date 2014-6-17 下午03:58:25 
 *  
 */

public interface ICaseAttachsService extends IBaseService<CaseAttachs, Integer> {
	
	public List<CaseAttachs> queryAttachsByCriteria(CaseAttachs attachs);

}
