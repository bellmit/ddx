package com.upcera.ddx.service.cases.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseRemakeDao;
import com.upcera.ddx.entity.CaseRemake;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseRemakeService;
@Service
public class CaseRemakeServiceImpl extends BaseServiceImpl<CaseRemake, Integer> implements ICaseRemakeService{
	@Resource ICaseRemakeDao remakeDao;
	@Override
	public IBaseDao<CaseRemake, Integer> getDao() {
		// TODO Auto-generated method stub
		return remakeDao;
	}
	
}
