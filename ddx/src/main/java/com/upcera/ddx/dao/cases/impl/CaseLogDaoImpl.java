/**   
 * @Title: CaseLogDaoImpl.java 
 * @Package com.upcera.ddx.dao.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:10:44 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseLogDao;
import com.upcera.ddx.entity.CaseLog;
import com.upcera.ddx.pojo.PageModel;

/** 
 * @ClassName: CaseLogDaoImpl 
 * @Description: 案例日志DAO实现类 
 * @author ERIC
 * @date 2014-6-17 下午03:10:44 
 *  
 */
@Repository
public class CaseLogDaoImpl extends BaseHibernateDao<CaseLog, Integer> implements ICaseLogDao {

	@Override
	public PageModel queryLogByCriteria(CaseLog log) {
		PageModel pm = new PageModel();
		Query query = getSession().createQuery("select cl from CaseLog cl where cl.caseId = ? order by cl.createTime desc");
		query.setInteger(0, log.getCaseId());
		List<CaseLog> logList = query.list();
		if(logList != null){
			pm.setDatas(logList);
			pm.setTotal((long)logList.size());
		}
		return pm;
	}

}
