package com.upcera.ddx.service.cases.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseSchedulingHolidaDao;
import com.upcera.ddx.entity.Caseschedulingholida;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseSchedulingHolidaService;

@Service
public class CaseSchedulingHolidaServiceImpl extends BaseServiceImpl<Caseschedulingholida, Integer> implements ICaseSchedulingHolidaService{
	@Resource ICaseSchedulingHolidaDao caseSchedulingHolidaDao;

	@Override
	public IBaseDao<Caseschedulingholida, Integer> getDao() {
		// TODO Auto-generated method stub
		return caseSchedulingHolidaDao;
	}
	
}
