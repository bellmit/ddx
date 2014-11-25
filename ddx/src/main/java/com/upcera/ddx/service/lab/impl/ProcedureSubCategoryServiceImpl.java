package com.upcera.ddx.service.lab.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.IProcedureSubCategoryDao;
import com.upcera.ddx.entity.ProcedureSubCategory;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.IProcedureSubCategoryService;

@Service
public class ProcedureSubCategoryServiceImpl extends BaseServiceImpl<ProcedureSubCategory, Integer> implements IProcedureSubCategoryService {
	@Resource IProcedureSubCategoryDao procedureSubCategoryDao;
	@Override
	public IBaseDao<ProcedureSubCategory, Integer> getDao() {
		return procedureSubCategoryDao;
	}
}
