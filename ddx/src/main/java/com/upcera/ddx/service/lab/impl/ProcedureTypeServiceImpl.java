package com.upcera.ddx.service.lab.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.IProcedureTypeDao;
import com.upcera.ddx.entity.ProcedureType;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.IProcedureTypeService;

@Service
public class ProcedureTypeServiceImpl extends BaseServiceImpl<ProcedureType, Integer> implements IProcedureTypeService {
	@Resource IProcedureTypeDao procedureTypeDao;
	@Override
	public IBaseDao<ProcedureType, Integer> getDao() {
		return procedureTypeDao;
	}
}
