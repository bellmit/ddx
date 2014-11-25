/**   
 * @Title: IPracticeDao.java 
 * @Package com.upcera.ddx.dao.practice 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:50:53 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.practice;

import java.util.List;
import java.util.Map;


import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.Practice;

/** 
 * @ClassName: IPracticeDao 
 * @Description: 诊所Dao
 * @author ERIC
 * @date 2014-6-11 下午02:50:53 
 *  
 */

public interface IPracticeDao extends IBaseDao<Practice, Integer> {
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的诊所
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
	 * @date 2014-8-16下午04:09:13
	 * @return Long
	 */
	public Long updateOperateTime(Practice practice);
	
	public List<Map<String, Object>> getAllPartnerLabAndAuthority(Integer unitId) throws Exception;
	
	/**
	 * 
	 * @Title: queryPracticeServiedByLabO 
	 * @Description: 查询技工间服务的诊所
	 * @author ERIC 
	 * @date 2014-11-24上午11:53:15
	 * @return List<Practice>
	 */
	public List<Practice> queryPracticeServiedByLabO(Integer labId);
}
