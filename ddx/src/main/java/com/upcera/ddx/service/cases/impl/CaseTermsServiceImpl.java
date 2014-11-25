package com.upcera.ddx.service.cases.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseTermsDao;
import com.upcera.ddx.entity.CaseTerms;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseTermsService;
@Service
public class CaseTermsServiceImpl extends BaseServiceImpl<CaseTerms, Integer> implements ICaseTermsService{
	@Resource ICaseTermsDao caseTermsDao;
	@Override
	public IBaseDao<CaseTerms, Integer> getDao() {
		// TODO Auto-generated method stub
		return caseTermsDao;
	}

}
