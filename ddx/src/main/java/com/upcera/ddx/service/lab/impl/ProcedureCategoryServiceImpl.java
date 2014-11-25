package com.upcera.ddx.service.lab.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.IProcedureCategoryDao;
import com.upcera.ddx.entity.ProcedureCategory;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.IProcedureCategoryService;

@Service
public class ProcedureCategoryServiceImpl extends BaseServiceImpl<ProcedureCategory, Integer> implements IProcedureCategoryService {
	@Resource IProcedureCategoryDao procedureCategoryDao;
	@Override
	public IBaseDao<ProcedureCategory, Integer> getDao() {
		return procedureCategoryDao;
	}
}
