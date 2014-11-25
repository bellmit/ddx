/**   
 * @Title: ICaseDetailsService.java 
 * @Package com.upcera.ddx.service.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:04:11 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases;

import java.util.List;

import com.upcera.ddx.entity.CaseDetails;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ICaseDetailsService 
 * @Description: 案例详细工作要求Service
 * @author ERIC
 * @date 2014-6-17 下午04:04:11 
 *  
 */

public interface ICaseDetailsService extends IBaseService<CaseDetails, Integer> {
	
	public List<CaseDetails> queryDetailsByCriteria(CaseDetails details);

}
