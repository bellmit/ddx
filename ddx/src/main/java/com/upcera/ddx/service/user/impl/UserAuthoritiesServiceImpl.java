package com.upcera.ddx.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.user.IUserAuthoritiesDao;
import com.upcera.ddx.entity.UserAuthorities;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.user.IUserAuthoritiesService;
@Service
public class UserAuthoritiesServiceImpl extends BaseServiceImpl<UserAuthorities, Integer> implements IUserAuthoritiesService {

	
	@Resource IUserAuthoritiesDao useruthoritiesDaoo;
	@Override
	public IBaseDao<UserAuthorities, Integer> getDao() {
		// TODO Auto-generated method stub
		return useruthoritiesDaoo;
	}

}
