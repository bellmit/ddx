/**   
 * @Title: LabProcedureDaoImpl.java 
 * @Package com.upcera.ddx.dao.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:41:27 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabProcedureDao;
import com.upcera.ddx.entity.LabProcedure;

/** 
 * @ClassName: LabProcedureDaoImpl 
 * @Description:  技工间工序DAO实现类 
 * @author ERIC
 * @date 2014-6-17 下午03:41:27 
 *  
 */
@Repository
public class LabProcedureDaoImpl extends BaseHibernateDao<LabProcedure, Integer> implements ILabProcedureDao {

	@Override
	public List<LabProcedure> getProedureByCriteria(LabProcedure lp) {
		Query query = getSession().createQuery("select lp from LabProcedure lp, ProcedureCategory pc where lp.proceduresCategoryId = pc.id and lp.labId = ? order by lp.displaySortRank");
		query.setInteger(0, lp.getLabId());
		return query.list();
	}

	@Override
	public Integer queryMaxTurnAroudDays(List<Integer> procedureIdList) {
		Integer i = 0;
		Query query = getSession().createQuery("select max(lp.schedulingTurnAroundDays) from LabProcedure lp where lp.proceduresId in (:pIdList)");
		query.setParameterList("pIdList", procedureIdList);
		if(null != query.uniqueResult()){
			i = Integer.valueOf(query.uniqueResult().toString());
		}
		return i;
	}

	@Override
	public List<LabProcedure> getRequestLabProcedures(Integer thisUnitId,String thisUnitType, Integer requestLabId) throws Exception {
		// TODO Auto-generated method stub
		String str = "";
		if(Constans.UNIT_LAB.equals(thisUnitType)){
			str = "c.labId";
		}else if(Constans.UNIT_PRACTICE.equals(thisUnitType)){
			str = "c.practiceId";
		}
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(str)){
			boolean isQueryThis = false;
			String hql = "select a from LabProcedure a,LabProceduresGroupLink b,LabPracticePreferences c where a.proceduresId = b.proceduresId and b.practicesGroupId = c.proceduresGroupId and a.labId =:requestLabId and "+str+" =:thisUnitId";
			//查询自己的工序
			if(Constans.UNIT_LAB.equals(thisUnitType) && thisUnitId.equals(requestLabId)){
				isQueryThis = true;
				hql = "select a from LabProcedure a where a.labId =:requestLabId";
			}
			Query query = getSession().createQuery(hql);
			query.setInteger("requestLabId", requestLabId);
			if(!isQueryThis){
				query.setInteger("thisUnitId", thisUnitId);
			}
			return query.list();
		}
		return null;
	}

}
