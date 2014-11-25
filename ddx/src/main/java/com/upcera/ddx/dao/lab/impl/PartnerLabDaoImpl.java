package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.IPartnerLabDao;
import com.upcera.ddx.entity.PartnerLab;
@Repository
public class PartnerLabDaoImpl extends BaseHibernateDao<PartnerLab, Integer> implements IPartnerLabDao{
	
	/***
	 * 根据实验室ID查询伙伴实验室
	 */
	@SuppressWarnings("unchecked")
	public List<PartnerLab> queryListByLabId(Integer labId){
		Query query = getSession().createQuery("from PartnerLab where labId = ?");
		query.setInteger(0, labId);
		return query.list();
	}
}
