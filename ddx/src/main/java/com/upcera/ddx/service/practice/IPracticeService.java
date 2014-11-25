/**   
 * @Title: IPracticeService.java 
 * @Package com.upcera.ddx.service.practice 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:32:30 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.practice;

import java.util.List;
import java.util.Map;

import com.upcera.ddx.common.Response;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: IPracticeService 
 * @Description: 诊所Service
 * @author ERIC
 * @date 2014-6-11 下午02:32:30 
 *  
 */

public interface IPracticeService extends IBaseService<Practice, Integer> {
	
	/**
	 * 
	 * @Title: addData	 
	 * @Description: 插入账户信息和诊所信息
	 * @author ERIC 
	 * @date 2014-6-19上午11:46:47
	 * @param @return
	 * @return Response
	 */
	public Response addData(User user, Practice practice);
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的的诊所
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	public List<Practice> getRequestAccountPractice(Integer labId,int pageNo,int pageSize,String search);
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的诊所总数
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Long
	 */
	public Long getRequestAccountPracticeCount(Integer labId,String search);
	
	/**
	 * 
	 * @Title: updateOperateTime 
	 * @Description: 更新诊所营业时间
	 * @author ERIC 
	 * @date 2014-8-16下午04:08:02
	 * @return Long
	 */
	public Long updateOperateTime(Practice practice);
	
	
	public List<Map<String, Object>> getAllPartnerLabAndAuthority(Integer unitId) throws Exception;
	
	/**
	 * 
	 * @Title: queryPracticeServiedByLabO 
	 * @Description: 查询技工间服务的诊所
	 * @author ERIC 
	 * @date 2014-11-24上午11:47:40
	 * @return List<Practice>
	 */
	public List<Practice> queryPracticeServiedByLabO(Integer labId);

}
