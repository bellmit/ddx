/**   
 * @Title: ILabPreferenceService.java 
 * @Package com.upcera.ddx.service.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:16:53 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.lab;

import com.upcera.ddx.entity.LabPreference;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ILabPreferenceService 
 * @Description: 技工间偏好设置Service 
 * @author ERIC
 * @date 2014-6-17 下午04:16:53 
 *  
 */

public interface ILabPreferenceService extends IBaseService<LabPreference, Integer> {
	
	public LabPreference getObjectByLabId(Integer labId);
	

}
