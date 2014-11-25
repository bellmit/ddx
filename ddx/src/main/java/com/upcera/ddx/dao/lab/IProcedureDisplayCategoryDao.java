package com.upcera.ddx.dao.lab;


import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.ProcedureDisplayCategory;

@org.springframework.stereotype.Repository("procedureDisplayCategoryDao")
public interface IProcedureDisplayCategoryDao  extends IBaseDao<ProcedureDisplayCategory, Integer>  {
	
	public List<ProcedureDisplayCategory> listAllProDispCategoryByCriteria(ProcedureDisplayCategory displayCategory);
	
}
