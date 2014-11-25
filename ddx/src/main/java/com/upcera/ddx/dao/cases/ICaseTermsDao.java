package com.upcera.ddx.dao.cases;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseTerms;

@Repository("caseTermsDao")
public interface ICaseTermsDao extends IBaseDao<CaseTerms, Integer>{
		
}
