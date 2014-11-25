package com.upcera.ddx.dao.lab;

import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.Lab;

@org.springframework.stereotype.Repository("labDao")
public interface ILabDao  extends IBaseDao<Lab, Integer>  {
	/**
	 * 
	 * @Description: 获取我请求添加的伙伴技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	public List<Lab> getPartnerLab(Integer unitId);
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	public List<Lab> getRequestAccountLab(Integer labId,int pageNo,int pageSize,String search);
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的技工间总数
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Long
	 */
	public Long getRequestAccountLabCount(Integer labId,String search);
	/**
	 * 
	 * @Title: getPartnerLabApproved 
	 * @Description: 审批通过的伙伴技工间
	 * @author ERIC 
	 * @date 2014-8-13下午05:18:28
	 * @return List<Lab>
	 */
	public List<Lab> getPartnerLabApproved(Integer labId);
	
	/**
	 * 
	 * @Title: updateOperateTime 
	 * @Description: 更新营业时间
	 * @author ERIC 
	 * @date 2014-8-18下午02:22:16
	 * @return Long
	 */
	public Long updateOperateTime(Lab lab);
	
}
