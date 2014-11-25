package com.upcera.ddx.dao.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.user.IUserDao;
import com.upcera.ddx.entity.User;
/**
 * 用户管理
 * @author 金德志
 *
 */
@Repository
public class UserDaoImpl extends BaseHibernateDao<User, Integer> implements IUserDao  {
	/***
	 * @param User
	 * @desc 更新用户信息，只更新部分字段
	 * @return 影响行数 
	 */
	@Override
	public int updateUserSetting(User entity) {
		// TODO Auto-generated method stub
		String hql = "update User u set u.salutation=?,u.firstName=?,u.accountInitial=?,u.lastName=?,u.externalID=?," +
				"u.email=?,u.password=?,u.ddxNewsletter=?,u.ddxDailySummary=?,u.teethNotation=?,u.ddxActivityLog=?," +
				"u.licenseNumber=?,u.signature=?,u.autoFollowCases=?,u.role=?,u.managerAccount=?,u.createCaseTags=?,u.labPermissions=?,u.preferentialLimit=? where u.accountId=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, entity.getSalutation());
		query.setString(1,entity.getFirstName());
		query.setString(2,entity.getAccountInitial());
		query.setString(3,entity.getLastName());
		query.setString(4,entity.getExternalID());
		query.setString(5,entity.getEmail());
		query.setString(6,entity.getPassword());
		query.setString(7,entity.getDdxNewsletter());
		query.setString(8,entity.getDdxDailySummary());
		query.setString(9,entity.getTeethNotation());
		query.setString(10,entity.getDdxActivityLog());
		
		query.setString(11, ToolsKit.TypeConversionUtil.asString(entity.getLicenseNumber()));
		query.setString(12, ToolsKit.TypeConversionUtil.asString(entity.getSignature()));
		query.setString(13, ToolsKit.TypeConversionUtil.asString(entity.getAutoFollowCases()));
		query.setString(14, ToolsKit.TypeConversionUtil.asString(entity.getRole()));
		
		User user = get(entity.getAccountId());
		if(user!=null && "true".equals(user.getIsMain())){
			query.setString(15, "true");
			query.setString(16, "true");
		}else{
			query.setString(15, ToolsKit.TypeConversionUtil.asString(entity.getManagerAccount()));
			query.setString(16, ToolsKit.TypeConversionUtil.asString(entity.getCreateCaseTags()));
		}
		
		query.setString(17, ToolsKit.TypeConversionUtil.asString(entity.getLabPermissions()));
		if(entity.getPreferentialLimit() == null){
			query.setInteger(18,0);
		}else{
			query.setInteger(18,entity.getPreferentialLimit());
		}
		query.setInteger(19,entity.getAccountId());
		return query.executeUpdate();	
	}
	/***
	 * @param User
	 * @desc 更新用户信息，只更新部分字段
	 * @return 影响行数 
	 */
	@Override
	public int updateUserPassword(User entity){
		// TODO Auto-generated method stub
		String hql="update User u set u.password=? where u.email=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, entity.getPassword());
		query.setString(1,entity.getEmail());
		return query.executeUpdate();
	}
	
	
	/***
	 * @param String
	 * @desc 根据批量id查询出用户,多个ID以逗号隔开
	 * @return List<User> 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> ListUser(String ids){
		String hql = "from User u where u.accountId in("+ids+")";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	@Override
	public List<User> queryPracticeProviders(User userQuery) {
		Query query = getSession().createQuery("select u from User u where u.unitType = ? and u.practiceId = ?");
		query.setString(0, userQuery.getUnitType());
		query.setInteger(1, userQuery.getPracticeId());
		return query.list();
	}
	@Override
	public List<Map<String, Object>> getSessionUserGroupUnit(Integer mainUserId) throws Exception {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		String sql = "select a.email,a.last_name,b.lab_name as name,'lab_login' as logType,a.password from ddx_user a,ddx_lab b where a.lab_id = b.lab_id and a.parent_id =:mainId union all select a.email,a.last_name,b.name,'practice_login' as logType,a.password from ddx_user a,ddx_practice b where a.practice_id = b.practice_id and a.parent_id =:mainId";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setInteger("mainId", mainUserId);
		List<Object> objList = query.list();
		for (int i = 0; i < objList.size(); i++) {
			Object[] obj = (Object[])objList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userEmal", obj[0]);
			map.put("userLastName", obj[1]);
			map.put("unitName", obj[2]);
			map.put("logType", obj[3]);
			map.put("password", obj[4]);
			result.add(map);
		}
		return result;
	}

	
} 
 