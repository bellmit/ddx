/**   
 * @Title: CaseAttachsDaoImpl.java 
 * @Package com.upcera.ddx.dao.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午02:49:18 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseAttachsDao;
import com.upcera.ddx.entity.CaseAttachs;

/** 
 * @ClassName: CaseAttachsDaoImpl 
 * @Description: 案例附件DAO实现 
 * @author ERIC
 * @date 2014-6-17 下午02:49:18 
 *  
 */
@Repository
public class CaseAttachsDaoImpl extends BaseHibernateDao<CaseAttachs, Integer> implements ICaseAttachsDao {

	@Override
	public List<CaseAttachs> queryAttachsByCriteria(CaseAttachs attachs) {
		String queryString = "select ca from CaseAttachs ca where ca.caseId = ? order by ca.caseDate desc";
		Query query = getSession().createQuery(queryString);
		query.setInteger(0, attachs.getCaseId());
		return query.list();
	}

}
