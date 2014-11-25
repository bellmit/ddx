/**   
 * @Title: CaseDetailsDaoImpl.java 
 * @Package com.upcera.ddx.dao.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:06:30 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseDetailsDao;
import com.upcera.ddx.entity.CaseDetails;

/** 
 * @ClassName: CaseDetailsDaoImpl 
 * @Description: 案例详细工作要求DAO实现类 
 * @author ERIC
 * @date 2014-6-17 下午03:06:30 
 *  
 */
@Repository
public class CaseDetailsDaoImpl extends BaseHibernateDao<CaseDetails, Integer> implements ICaseDetailsDao {

	@Override
	public List<CaseDetails> queryDetailsByCriteria(CaseDetails details) {
		Query query = getSession().createQuery("select cd from CaseDetails cd where cd.caseId = ?");
		query.setInteger(0, details.getCaseId());
		return query.list();
	}

}
