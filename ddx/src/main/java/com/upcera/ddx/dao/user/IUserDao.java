package com.upcera.ddx.dao.user;

import java.util.List;
import java.util.Map;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.User;


/**
 * 用户管理
 * @author 金德志
 *
 */
@org.springframework.stereotype.Repository("userDao")
public interface IUserDao extends IBaseDao<User, Integer> {
	/***
	 * @param User
	 * @desc 更新用户信息，只更新部分字段
	 * @return 影响行数 
	 */
	public int updateUserSetting(User user);
	
	/***
	 * @param String
	 * @desc 根据批量id查询出用户,多个ID以逗号隔开
	 * @return List<User> 
	 */
	public List<User> ListUser(String ids);
	public int updateUserPassword(User user);
	
	public List<User> queryPracticeProviders(User userQuery);
	
	public List<Map<String, Object>> getSessionUserGroupUnit(Integer mainUserId) throws Exception;
}
