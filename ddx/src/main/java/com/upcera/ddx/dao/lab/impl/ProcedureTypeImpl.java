package com.upcera.ddx.dao.lab.impl;


import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.IProcedureTypeDao;
import com.upcera.ddx.entity.ProcedureType;

@Repository
public class ProcedureTypeImpl extends BaseHibernateDao<ProcedureType, Integer> implements IProcedureTypeDao {

}
