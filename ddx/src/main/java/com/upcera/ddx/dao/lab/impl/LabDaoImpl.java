package com.upcera.ddx.dao.lab.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabDao;
import com.upcera.ddx.entity.Lab;
@Repository
public class LabDaoImpl  extends BaseHibernateDao<Lab, Integer> implements ILabDao {
	

	
	
	/**
	 * 
	 * @Description: 获取我请求添加的伙伴技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lab> getPartnerLab(Integer unitId) {
		// TODO Auto-generated method stub
		 Query query = getSession().createQuery("from Lab lab where lab.id in(select partnerId from PartnerLab where unitId = ?)");
		 query.setInteger(0, unitId);
		 return query.list();
	}

	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lab> getRequestAccountLab(Integer labId,int pageNo,int pageSize,String search) {
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
	 * @Description: 获取请求添加我为伙伴的技工间总数
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Long
	 */
	@Override
	public Long getRequestAccountLabCount(Integer labId, String search) {
		// TODO Auto-generated method stub
		return ToolsKit.TypeConversionUtil.asLong(getQuery(labId, search).list().size());
	}

	/**
	 * 
	 * @Description: 获取请求添加我为伙伴的技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Query
	 */
	private Query getQuery(Integer labId, String search) {
		Query query = getSession().createQuery(
						"from Lab lab where lab.id in(select unitId from PartnerLab where partnerId = ? and unitType = '1') " +
						"and (lab.name like :name or lab.city like :city or lab.state like :state or lab.address like:address )");
		query.setInteger(0, labId);
		query.setString("name", "%" + search + "%");
		query.setString("city", "%" + search + "%");
		query.setString("state", "%" + search + "%");
		query.setString("address", "%" + search + "%");
		return query;
	}

	@Override
	public List<Lab> getPartnerLabApproved(Integer labId) {
		 Query query = getSession().createQuery("from Lab lab where lab.id in(select partnerId from PartnerLab where partnerApprovalStatus = '0' and  unitId = ?)");
		 query.setInteger(0, labId);
		 return query.list();
	}

	@Override
	public Long updateOperateTime(Lab lab) {
		String queryString = "update Lab set sunOpen = ?,monOpen = ?,tueOpen = ?,wedOpen = ?,thuOpen = ?,friOpen = ?,satOpen = ?" +
				",sunFrom = ?,sunTo = ?,monFrom = ?,monTo = ?,tueFrom = ?,tueTo = ?,wedFrom = ?,wedTo = ?,thuFrom = ?,thuTo = ?" +
				",friFrom = ?,friTo = ?,satFrom = ?,satTo = ? where id = ?";
		Query query = getSession().createQuery(queryString);
		query.setInteger(0, lab.getSunOpen());
		query.setInteger(1, lab.getMonOpen());
		query.setInteger(2, lab.getTueOpen());
		query.setInteger(3, lab.getWedOpen());
		query.setInteger(4, lab.getThuOpen());
		query.setInteger(5, lab.getFriOpen());
		query.setInteger(6, lab.getSatOpen());
		
		query.setString(7, lab.getSunFrom());
		query.setString(8, lab.getSunTo());
		query.setString(9, lab.getMonFrom());
		query.setString(10, lab.getMonTo());
		query.setString(11, lab.getTueFrom());
		query.setString(12, lab.getTueTo());
		query.setString(13, lab.getWedFrom());
		
		query.setString(14, lab.getWedTo());
		query.setString(15, lab.getThuFrom());
		query.setString(16, lab.getThuTo());
		query.setString(17, lab.getFriFrom());
		query.setString(18, lab.getFriTo());
		query.setString(19, lab.getSatFrom());
		query.setString(20, lab.getSatTo());
		
		query.setInteger(21, lab.getId());
		return (long) query.executeUpdate();
	}
}
