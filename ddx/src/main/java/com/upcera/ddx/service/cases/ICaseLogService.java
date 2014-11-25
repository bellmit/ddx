/**   
 * @Title: ICaseLogService.java 
 * @Package com.upcera.ddx.service.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:10:01 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases;

import com.upcera.ddx.entity.CaseLog;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ICaseLogService 
 * @Description: 案例日志Service 
 * @author ERIC
 * @date 2014-6-17 下午04:10:01 
 *  
 */

public interface ICaseLogService extends IBaseService<CaseLog, Integer> {
	
//	public PageModel queryLogByCriteria(CaseLog log);

}
