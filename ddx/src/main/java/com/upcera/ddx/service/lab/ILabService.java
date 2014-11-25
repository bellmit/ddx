package com.upcera.ddx.service.lab;

import java.util.List;

import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.service.base.IBaseService;

public interface ILabService extends IBaseService<Lab, Integer>{
	/**
	 * 
	 * @Description: 注册技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	public void addUserAndLab(User user,Lab lab);
	/**
	 * 
	 * @Description: 获取我请求添加的伙伴技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	public List<Lab> getPartnerLab(Integer labId);
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
	 * @Description: 更新诊所营业时间
	 * @author ERIC 
	 * @date 2014-8-16下午04:08:02
	 * @return Long
	 */
	public Long updateOperateTime(Lab lab);
}
