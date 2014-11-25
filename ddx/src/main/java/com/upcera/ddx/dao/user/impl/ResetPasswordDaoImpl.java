package com.upcera.ddx.dao.user.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.user.IResetPasswordDao;
import com.upcera.ddx.entity.ResetPassword;

@Repository
public class ResetPasswordDaoImpl extends BaseHibernateDao<ResetPassword, Integer> implements IResetPasswordDao{
	/***
	 * @param User
	 * @desc 更新用户信息，只更新部分字段
	 * @return 影响行数 
	 */
	@Override
	public int updateResetwhether(ResetPassword entity){
		// TODO Auto-generated method stub
		String hql="update ResetPassword r set r.resetwhether=? where r.resetemail=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getResetwhether());
		query.setString(1,entity.getResetemail());
		return query.executeUpdate();
	}
}
