package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabSignUpDirectSoundDao;
import com.upcera.ddx.entity.LabSignUpDirectSound;
@Repository
public class LabSignUpDirectSoundDaoImpl extends BaseHibernateDao<LabSignUpDirectSound, Integer> implements ILabSignUpDirectSoundDao{
	@Override
	public List<LabSignUpDirectSound> queryDirectSound(Integer type){
		Query query=getSession().createQuery("from LabSignUpDirectSound where type=?");
		query.setInteger(0, type);
		return query.list();
	}
}
