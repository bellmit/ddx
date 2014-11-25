package com.upcera.ddx.service.user;

import com.upcera.ddx.entity.ResetPassword;
import com.upcera.ddx.service.base.IBaseService;

public interface IResetPasswordService extends IBaseService<ResetPassword, Integer>{
	/***
	 * @param User
	 * @desc 更新用户信息，只更状态
	 * @return 影响行数 
	 */
	public int updateResetwhether(ResetPassword entity);
}
