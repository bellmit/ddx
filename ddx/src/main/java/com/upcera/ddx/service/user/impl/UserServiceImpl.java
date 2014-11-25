package com.upcera.ddx.service.user.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.user.IUserDao;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.entity.UserAuthorities;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.IUserAuthoritiesService;
import com.upcera.ddx.service.user.IUserService;

/**
 * 用户管理
 * @author 金德志
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements IUserService {

	@Resource IUserDao userDao;
	
	@Autowired
	private IUserAuthoritiesService userAuthoritiesService;
	
	@Autowired
	private ILabService labService;
	@Autowired
	private IPracticeService practiceService;
	
	@Override
	public IBaseDao<User, Integer> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	/***
	 * @desc 得到当前登陆用户用户名密码及权限
	 * @return UserDetails
	 */
	@Override
	public UserDetails getUserDetails() {
		// TODO Auto-generated method stub
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	/***
	 * @desc 根据登陆邮箱得到当前登陆用户信息
	 * @return User
	 */
	@Override
	public User getSessionUserByLoginEmail() throws Exception {
		// TODO Auto-generated method stub
		String email = getUserDetails().getUsername();
		User query = new User();
		query.setEmail(email);
		List<User> list = listAll();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				if (email.equals(list.get(i).getEmail())) {
					return list.get(i);
				}
			}
		}
		return null;
	}
	/***
	 * @param User
	 * @desc 更新用户信息，只更新部分字段
	 * @return 影响行数 
	 */
	@Override
	public int updateUserSetting(User entity) {
		// TODO Auto-generated method stub
		return userDao.updateUserSetting(entity);
	}
	/***
	 * @param User
	 * @desc 更新用户信息，只更新密码
	 * @return 影响行数 
	 */
	@Override
	public int updateUserPassword(User entity){
		// TODO Auto-generated method stub
		return userDao.updateUserPassword(entity);
	}
	/***
	 * @param User,UserAuthorities
	 * @desc 新增技工间用户
	 */
	@Override
	public void addLabUser(User user, UserAuthorities ua) {
		// TODO Auto-generated method stub
		this.add(user);
		userAuthoritiesService.add(ua);
	}
	
	/***
	 * @param String
	 * @desc 根据批量id查询出用户,多个ID以逗号隔开
	 * @return List<User> 
	 */
	@Override
	public List<User> ListUser(String ids){
		return userDao.ListUser(ids);
	}
	@Override
	public List<User> queryPracticeProviders(User userQuery) {
		return userDao.queryPracticeProviders(userQuery);
	}
	@Override
	public List<Map<String, Object>> getSessionUserGroupUnit(Integer mainUserId) {
		// TODO Auto-generated method stub
		try {
			return userDao.getSessionUserGroupUnit(mainUserId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String getSessionUnitName() {

		try {
			//获取当前用户
			User user = getSessionUserByLoginEmail();
			//获取当前用户的伙伴技工间
			String unitName = "";
			try {
				if(Constans.UNIT_LAB.equals(user.getUnitType())){
					unitName = labService.get(user.getLabId()).getName();
				}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
					unitName = practiceService.get(user.getPracticeId()).getName();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return unitName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
}
  