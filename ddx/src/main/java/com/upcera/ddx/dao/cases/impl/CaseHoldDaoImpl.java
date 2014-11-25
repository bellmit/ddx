package com.upcera.ddx.dao.cases.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseHoldDao;
import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.pojo.PageModel;

@Repository
public class CaseHoldDaoImpl extends BaseHibernateDao<CaseHold, Integer> implements ICaseHoldDao{

	@Override
	public int updateHoldSetting(CaseHold entity) {
		// TODO Auto-generated method stub
		String sql="update CaseHold c set c.name=? where c.id=?";
		Query query= getSession().createQuery(sql);
		query.setString(0,entity.getName());
		query.setInteger(1,entity.getId());
		return query.executeUpdate();
	}

	@Override
	public PageModel queryAllCaseHoldByLab(CaseHold caseHold) {
		PageModel pm = new PageModel();
		String sqlString = " from CaseHold ch where ch.labId = ? order by ch.labId asc ";
		Query query= getSession().createQuery(sqlString);
		query.setInteger(0,caseHold.getLabId());
		List list = query.list();
		if(null != list){
			int size = list.size();
			pm.setDatas(list);
			pm.setTotal((long)size);
		}
		return pm;
	}

}
