/**   
 * @Title: ICasesBargainRequestService.java 
 * @Package com.upcera.ddx.service.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-10-24 下午02:26:32 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases;

import com.upcera.ddx.entity.CasesBargainRequest;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ICasesBargainRequestService 
 * @Description: 议价申请Service 
 * @author ERIC
 * @date 2014-10-24 下午02:26:32 
 *  
 */

public interface ICasesBargainRequestService extends IBaseService<CasesBargainRequest, Integer> {

	public int updateBargain(CasesBargainRequest bargainRequest) throws Exception;
	
}
