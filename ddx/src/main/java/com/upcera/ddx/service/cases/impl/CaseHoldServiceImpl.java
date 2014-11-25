package com.upcera.ddx.service.cases.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseHoldDao;
import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseholdService;

@Service
public class CaseHoldServiceImpl extends BaseServiceImpl<CaseHold, Integer> implements ICaseholdService {
	@Resource ICaseHoldDao caseHoldDao;
	@Override
	public IBaseDao<CaseHold, Integer> getDao() {
		return caseHoldDao;
	}
	@Override
	public int updateUserSetting(CaseHold entity) {
		// TODO Auto-generated method stub
		return caseHoldDao.updateHoldSetting(entity);
	}
	@Override
	public PageModel queryAllCaseHoldByLab(CaseHold caseHold) {
		return caseHoldDao.queryAllCaseHoldByLab(caseHold);
	}
}
