/**   
 * @Title: PracticeDaoImpl.java 
 * @Package com.upcera.ddx.dao.practice.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:52:30 
 * @version V1.0   
 */
package com.upcera.ddx.dao.practice.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.practice.IPracticeDao;
import com.upcera.ddx.entity.Practice;

/**
 * @ClassName: PracticeDaoImpl
 * @Description: 诊所Dao实现类
 * @author ERIC
 * @date 2014-6-11 下午02:52:30
 * 
 */
@Repository("practiceDao")
public class PracticeDaoImpl extends BaseHibernateDao<Practice, Integer> implements IPracticeDao {
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的诊所
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	@SuppressWarnings("unchecked")
	public List<Practice> getRequestAccountPractice(Integer labId,int pageNo,int pageSize,String search){
		// TODO Auto-generated method stub
		 Query query = getQuery(labId, search);
		 if(pageSize>0){
			 query.setFirstResult(pageNo * pageSize - pageSize);
			 query.setMaxResults(pageSize);
		 }
		 return query.list();
	
		
	}
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的诊所总数
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Long
	 */
	@Override
	public Long getRequestAccountPracticeCount(Integer labId,String search){
		return ToolsKit.TypeConversionUtil.asLong(getQuery(labId, search).list().size());
	}
	
	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的诊所
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Query
	 */
	private Query getQuery(Integer labId, String search) {
		Query query = getSession().createQuery("from Practice pra where pra.id in(select unitId from PartnerLab where partnerId = ? and unitType = '2') and (pra.name like :name or pra.state like :state or pra.city like :city or pra.address2 like :address2)");
		 query.setInteger(0, labId);
		 query.setString("name", "%"+search+"%");
		 query.setString("state", "%"+search+"%");
		 query.setString("city", "%"+search+"%");
		 query.setString("address2", "%"+search+"%");
		 return query;
	}
	
	
	@Override
	public Long updateOperateTime(Practice practice) {
		String queryString = "update Practice set sunOpen = ?,monOpen = ?,tueOpen = ?,wedOpen = ?,thuOpen = ?,friOpen = ?,satOpen = ?" +
				",sunFrom = ?,sunTo = ?,monFrom = ?,monTo = ?,tueFrom = ?,tueTo = ?,wedFrom = ?,wedTo = ?,thuFrom = ?,thuTo = ?" +
				",friFrom = ?,friTo = ?,satFrom = ?,satTo = ? where id = ?";
		Query query = getSession().createQuery(queryString);
		query.setInteger(0, practice.getSunOpen());
		query.setInteger(1, practice.getMonOpen());
		query.setInteger(2, practice.getTueOpen());
		query.setInteger(3, practice.getWedOpen());
		query.setInteger(4, practice.getThuOpen());
		query.setInteger(5, practice.getFriOpen());
		query.setInteger(6, practice.getSatOpen());
		
		query.setString(7, practice.getSunFrom());
		query.setString(8, practice.getSunTo());
		query.setString(9, practice.getMonFrom());
		query.setString(10, practice.getMonTo());
		query.setString(11, practice.getTueFrom());
		query.setString(12, practice.getTueTo());
		query.setString(13, practice.getWedFrom());
		
		query.setString(14, practice.getWedTo());
		query.setString(15, practice.getThuFrom());
		query.setString(16, practice.getThuTo());
		query.setString(17, practice.getFriFrom());
		query.setString(18, practice.getFriTo());
		query.setString(19, practice.getSatFrom());
		query.setString(20, practice.getSatTo());
		
		query.setInteger(21, practice.getId());
		return (long) query.executeUpdate();
	}
	@Override
	public List<Map<String, Object>> getAllPartnerLabAndAuthority(Integer unitId)  throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT A.LAB_ID, A.LAB_NAME,B.CASES, B.FINANCES  FROM DDX_LAB A, DDX_LAB_SET_PERMISSIONS B WHERE A.LAB_ID IN  (SELECT PARTNER_ID FROM DDX_LAB_PRACTICE_PARTNER WHERE UNIT_ID = ?)  AND A.LAB_ID = B.LAB_ID";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setInteger(0, unitId);
		List list = query.list();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			Object[] str = (Object[])list.get(i);
			map.put("labId", str[0]);
			map.put("labName", str[1]);
			map.put("cases", str[2]);
			map.put("finances", str[3]);
			result.add(map);
		}
		return result;
	}
	@Override
	public List<Practice> queryPracticeServiedByLabO(Integer labId) {
		Query query = getSession().createQuery("from Practice pra where pra.id in(select unitId from PartnerLab where partnerId = ? and unitType = '2' and partnerApprovalStatus= '0') ");
		query.setInteger(0, labId);
		return query.list();
	}
}
