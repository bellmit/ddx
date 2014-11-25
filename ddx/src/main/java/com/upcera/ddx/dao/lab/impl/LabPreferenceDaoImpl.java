/**   
 * @Title: LabPreferenceDaoImpl.java 
 * @Package com.upcera.ddx.dao.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:36:20 
 * @version V1.0   
 */
package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabPreferenceDao;
import com.upcera.ddx.entity.LabPreference;

/**
 * @ClassName: LabPreferenceDaoImpl
 * @Description: 技工间偏好设置DAO实现类
 * @author ERIC
 * @date 2014-6-17 下午03:36:20
 * 
 */
@Repository
public class LabPreferenceDaoImpl extends BaseHibernateDao<LabPreference, Integer> implements ILabPreferenceDao {

	@Override
	public LabPreference getObjectByLabId(Integer labId) {
		Query query = getSession().createQuery("select lp from LabPreference lp where lp.labId = ?");
		query.setInteger(0, labId);
		List<LabPreference> labList = query.list();
		LabPreference labPre = null;
		if(labList.size() > 0){
			labPre = (LabPreference) query.list().get(0);
		}
		return labPre;
	}

}
