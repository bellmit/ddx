package com.upcera.ddx.dao.cases.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseRemakeDao;
import com.upcera.ddx.entity.CaseRemake;
@Repository
public class CaseRemakeDaoImpl extends BaseHibernateDao<CaseRemake, Integer> implements ICaseRemakeDao{

}
