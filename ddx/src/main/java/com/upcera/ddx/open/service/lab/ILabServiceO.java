/**   
 * @Title: ILabServcieO.java 
 * @Package com.upcera.ddx.open.service.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-11-24 上午11:22:42 
 * @version V1.0   
 */ 
package com.upcera.ddx.open.service.lab;

import java.util.List;

import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.open.pojo.Request;

/** 
 * @ClassName: ILabServcieO 
 * @Description: 技工间开发接口 
 * @author ERIC
 * @date 2014-11-24 上午11:22:42 
 *  
 */

public interface ILabServiceO {
	
	//查询技工间服务的诊所列表
	public List<Practice> queryPracticeServicedByLab(Request request);
	
}
