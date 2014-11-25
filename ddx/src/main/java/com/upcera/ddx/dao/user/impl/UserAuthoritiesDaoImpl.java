package com.upcera.ddx.dao.user.impl;


import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.user.IUserAuthoritiesDao;
import com.upcera.ddx.entity.UserAuthorities;
@Repository
public class UserAuthoritiesDaoImpl extends BaseHibernateDao<UserAuthorities, Integer> implements IUserAuthoritiesDao {

}
