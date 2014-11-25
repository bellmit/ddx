package com.upcera.ddx.dao.cases.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseSchedulingHolidaDao;
import com.upcera.ddx.entity.Caseschedulingholida;
/**
 * @ClassName: CasesDaoImpl
 * @Description: 假期DAO实现类
 * @author ERIC
 * @date 2014-6-17 下午03:16:15
 * 
 */
@Repository
public class CaseSchedulingHolidDaoImpl extends BaseHibernateDao<Caseschedulingholida, Integer> implements ICaseSchedulingHolidaDao{
	
}
