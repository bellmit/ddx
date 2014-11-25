package com.upcera.ddx.service.lab.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabProceduresGroupDao;
import com.upcera.ddx.entity.LabProceduresGroup;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProceduresGroupService;
@Service
public class LabProceduresGroupServiceImpl extends BaseServiceImpl<LabProceduresGroup, Integer> implements ILabProceduresGroupService{
	@Autowired
	private ILabProceduresGroupDao LabProceduresGroupDao;
	@Override
	public IBaseDao<LabProceduresGroup, Integer> getDao() {
		// TODO Auto-generated method stub
		return LabProceduresGroupDao;
	}
}
