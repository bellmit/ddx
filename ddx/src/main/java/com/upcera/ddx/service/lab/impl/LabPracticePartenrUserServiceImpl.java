package com.upcera.ddx.service.lab.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabPracticePartenrUserDao;
import com.upcera.ddx.entity.LabPracticePartenrUser;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabPracticePartenrUserService;
@Service
public class LabPracticePartenrUserServiceImpl extends BaseServiceImpl<LabPracticePartenrUser, Integer> implements ILabPracticePartenrUserService{
	@Autowired
	private ILabPracticePartenrUserDao labPracticePartenrUserDao;
	@Override
	public IBaseDao<LabPracticePartenrUser, Integer> getDao() {
		// TODO Auto-generated method stub
		return labPracticePartenrUserDao;
	}
}
