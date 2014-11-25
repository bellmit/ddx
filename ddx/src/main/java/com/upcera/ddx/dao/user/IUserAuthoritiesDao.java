package com.upcera.ddx.dao.user;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.UserAuthorities;

@org.springframework.stereotype.Repository("userAuthoritiesDao")
public interface IUserAuthoritiesDao extends IBaseDao<UserAuthorities, Integer> {

}
