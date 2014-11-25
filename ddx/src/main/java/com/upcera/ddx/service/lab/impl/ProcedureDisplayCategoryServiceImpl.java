package com.upcera.ddx.service.lab.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.IProcedureDisplayCategoryDao;
import com.upcera.ddx.entity.ProcedureDisplayCategory;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.IProcedureDisplayCategoryService;
@Service
public class ProcedureDisplayCategoryServiceImpl extends BaseServiceImpl<ProcedureDisplayCategory, Integer> implements IProcedureDisplayCategoryService{
	@Autowired
	private IProcedureDisplayCategoryDao procedureDisplayCategoryDao;
	@Override
	public IBaseDao<ProcedureDisplayCategory, Integer> getDao() {
		// TODO Auto-generated method stub
		return procedureDisplayCategoryDao;
	}
	
	@Override
	public List<ProcedureDisplayCategory> listAllProDispCategoryByCriteria(ProcedureDisplayCategory displayCategory) {
		// TODO Auto-generated method stub
		return procedureDisplayCategoryDao.listAllProDispCategoryByCriteria(displayCategory);
	}
}
