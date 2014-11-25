package com.upcera.ddx.service.lab.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabPermissionsDao;
import com.upcera.ddx.entity.LabPermissions;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabPermissionsService;
@Service
public class LabPermissionsServiceImpl extends BaseServiceImpl<LabPermissions, Integer> implements ILabPermissionsService{

	@Autowired
	private ILabPermissionsDao labPermissionsDao;
	@Override
	public IBaseDao<LabPermissions, Integer> getDao() {
		// TODO Auto-generated method stub
		return labPermissionsDao;
	}

}
