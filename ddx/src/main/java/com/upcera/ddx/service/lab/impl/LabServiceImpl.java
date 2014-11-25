package com.upcera.ddx.service.lab.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabDao;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.entity.UserAuthorities;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.lab.ILabSignUpDirectSoundService;
import com.upcera.ddx.service.lab.IPartnerLabService;
import com.upcera.ddx.service.user.IUserAuthoritiesService;
import com.upcera.ddx.service.user.IUserService;
@Service
public class LabServiceImpl extends BaseServiceImpl<Lab, Integer> implements ILabService{

	@Autowired
	private IUserService userService;
	
	@Resource ILabDao labDaoo;
	
	@Autowired
	private IUserAuthoritiesService userAuthoritiesService;
	
	@Autowired
	private IPartnerLabService partnerLabService;
	@Autowired
	private ILabSignUpDirectSoundService labSignUpDirectSoundService;
	@Override
	public IBaseDao<Lab, Integer> getDao() {
		// TODO Auto-generated method stub
		return labDaoo;
	}
	/**
	 * 
	 * @Description: 注册技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 */
	@Override
	public void addUserAndLab(User user, Lab lab) {
		// TODO Auto-generated method stub
		//增加技工间
		add(lab);
		
		//增加用户
		user.setLabId(lab.getId());
		userService.add(user);
		
		//用户注册权限
		UserAuthorities ua = new UserAuthorities();
		ua.setUsername(user.getEmail());
		ua.setAuthority(Constans.ROLE_LAB);
		userAuthoritiesService.add(ua);
		Integer labid=lab.getId();
		labSignUpDirectSoundService.queryDirectSound(labid);
	}
	
	/**
	 * 
	 * @Description: 获取我请求添加的伙伴技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	@Override
	public List<Lab> getPartnerLab(Integer labId) {
		// TODO Auto-generated method stub
		return labDaoo.getPartnerLab(labId);
	}
	
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	@Override
	public List<Lab> getRequestAccountLab(Integer labId,int pageNo,int pageSize,String search) {
		// TODO Auto-generated method stub
		return labDaoo.getRequestAccountLab(labId,pageNo,pageSize,search);
	}

	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的技工间总数
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Long
	 */
	@Override
	public Long getRequestAccountLabCount(Integer labId,String search){
		return labDaoo.getRequestAccountLabCount(labId, search);
	}
	
	@Override
	public List<Lab> getPartnerLabApproved(Integer labId) {
		return labDaoo.getPartnerLabApproved(labId);
	}
	
	
	@Override
	public Long updateOperateTime(Lab lab) {
		return labDaoo.updateOperateTime(lab);
	}

}
