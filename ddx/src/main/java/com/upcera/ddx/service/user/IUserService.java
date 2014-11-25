package com.upcera.ddx.service.user;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import com.upcera.ddx.entity.User;
import com.upcera.ddx.entity.UserAuthorities;
import com.upcera.ddx.service.base.IBaseService;

/**
 * 用户管理
 * 
 * @author jindezhi
 * 
 */
public interface IUserService extends IBaseService<User, Integer> {
	
	/***
	 * @desc 得到当前登陆用户用户名密码及权限
	 * @return UserDetails
	 */
	public UserDetails getUserDetails();
	
	/***
	 * @desc 根据登陆邮箱得到当前登陆用户信息
	 * @return User
	 */
	public User getSessionUserByLoginEmail() throws Exception;
	/***
	 * @param User
	 * @desc 更新用户信息，只更新部分字段
	 * @return 影响行数 
	 */
	public int updateUserSetting(User entity);
	/***
	 * @param User
	 * @desc 更新用户信息，只更新密码
	 * @return 影响行数 
	 */
	public int updateUserPassword(User entity);
	/***
	 * @param User,UserAuthorities
	 * @desc 新增技工间用户
	 */
	public void addLabUser(User user,UserAuthorities ua);
	/***
	 * @param String
	 * @desc 根据批量id查询出用户,多个ID以逗号隔开
	 * @return List<User> 
	 */
	public List<User> ListUser(String ids);
	
	/**
	 * 
	 * @Title: queryPracticeProviders 
	 * @Description: 诊所用户获取
	 * @author ERIC 
	 * @date 2014-10-30上午10:15:18
	 * @return List<User>
	 */
	public List<User> queryPracticeProviders(User userQuery);
	
	public List<Map<String, Object>> getSessionUserGroupUnit(Integer mainUserId);
	
	/**
	 * 
	 * @Description: 获取当前登陆机构的名称
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 * @throws Exception 
	 */
	public String getSessionUnitName();
	
}
