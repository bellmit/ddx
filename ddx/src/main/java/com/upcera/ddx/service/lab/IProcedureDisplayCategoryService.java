package com.upcera.ddx.service.lab;

import java.util.List;

import com.upcera.ddx.entity.ProcedureDisplayCategory;
import com.upcera.ddx.service.base.IBaseService;

public interface IProcedureDisplayCategoryService extends IBaseService<ProcedureDisplayCategory, Integer> {
	
	public List<ProcedureDisplayCategory> listAllProDispCategoryByCriteria(ProcedureDisplayCategory displayCategory);
}
