package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabProceduresOutLinkDao;
import com.upcera.ddx.entity.LabProceduresOutLink;

@Repository
public class LabProceduresOutLinkDaoImpl extends BaseHibernateDao<LabProceduresOutLink, Integer> implements ILabProceduresOutLinkDao {

	@Override
	public List<Integer> queryOutLinks(List<Integer> idList) {
		Query query = getSession().createQuery("select lp.outProceduresId from LabProceduresOutLink lp where lp.proceduresId in (:pIdList)");
		query.setParameterList("pIdList", idList);
		return query.list();
	}

	@Override
	public void deleteOutLinkByProceduresId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String hql = "delete LabProceduresOutLink where proceduresId=:proceduresId";
		Query query = getSession().createQuery(hql);
		query.setInteger("proceduresId", id);
		query.executeUpdate();
	}


}
