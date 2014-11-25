package com.upcera.ddx.dao.cases;

import org.springframework.stereotype.Repository;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.pojo.PageModel;

@Repository("caseHoldDao")
public interface ICaseHoldDao extends IBaseDao<CaseHold, Integer>{
	public int updateHoldSetting(CaseHold caseHold);
	
	public PageModel queryAllCaseHoldByLab(CaseHold caseHold);
}
