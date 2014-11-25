package com.upcera.ddx.dao.user;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.ResetPassword;

@org.springframework.stereotype.Repository("IResetPasswordDao")
public interface IResetPasswordDao extends IBaseDao<ResetPassword, Integer>{

	public int updateResetwhether(ResetPassword entity);

}
