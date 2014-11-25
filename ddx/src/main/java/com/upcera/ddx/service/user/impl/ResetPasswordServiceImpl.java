package com.upcera.ddx.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.user.IResetPasswordDao;
import com.upcera.ddx.entity.ResetPassword;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.user.IResetPasswordService;

@Service
public class ResetPasswordServiceImpl extends BaseServiceImpl<ResetPassword, Integer> implements IResetPasswordService{
	@Resource IResetPasswordDao resetPasswordDao;
	@Override
	public IBaseDao<ResetPassword, Integer> getDao() {
		// TODO Auto-generated method stub
		return resetPasswordDao;
	}
	/***
	 * @param User
	 * @desc 更新更新密码，更新状态
	 * @return 影响行数 
	 */
	@Override
	public int updateResetwhether(ResetPassword entity){
		// TODO Auto-generated method stub
		return resetPasswordDao.updateResetwhether(entity);
	}
}
