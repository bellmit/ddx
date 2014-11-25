package com.upcera.ddx.dao.cases.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseTermsDao;
import com.upcera.ddx.entity.CaseTerms;

@Repository
public class CaseTermsDaoImpl extends BaseHibernateDao<CaseTerms, Integer> implements ICaseTermsDao{
	
}
