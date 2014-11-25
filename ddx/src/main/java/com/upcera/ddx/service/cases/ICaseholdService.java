package com.upcera.ddx.service.cases;


import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.IBaseService;

public interface ICaseholdService extends IBaseService<CaseHold, Integer>  {
	public int updateUserSetting(CaseHold entity);
	
	public PageModel queryAllCaseHoldByLab(CaseHold caseHold);
	
}
