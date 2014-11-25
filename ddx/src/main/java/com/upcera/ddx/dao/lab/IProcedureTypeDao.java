package com.upcera.ddx.dao.lab;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.ProcedureType;

@Repository("procedureTypeDao")
public interface IProcedureTypeDao extends IBaseDao<ProcedureType, Integer> {
	
}
