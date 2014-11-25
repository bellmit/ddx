package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.IProcedureDisplayCategoryDao;
import com.upcera.ddx.entity.ProcedureDisplayCategory;

@Repository
public class ProcedureDisplayCategoryDaoImpl extends BaseHibernateDao<ProcedureDisplayCategory, Integer> implements IProcedureDisplayCategoryDao {

	@Override
	public List<ProcedureDisplayCategory> listAllProDispCategoryByCriteria(ProcedureDisplayCategory displayCategory) {
		Query query = getSession().createQuery("from ProcedureDisplayCategory t where t.labId = ? order by t.sort asc");
		query.setInteger(0, displayCategory.getLabId());
		return query.list();
	}



}
