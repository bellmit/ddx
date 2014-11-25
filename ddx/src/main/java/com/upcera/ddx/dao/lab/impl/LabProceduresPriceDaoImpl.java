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
import com.upcera.ddx.dao.lab.ILabProceduresPriceDao;
import com.upcera.ddx.entity.LabProceduresPrice;


@Repository
public class LabProceduresPriceDaoImpl extends BaseHibernateDao<LabProceduresPrice, Integer> implements ILabProceduresPriceDao {

	@Override
	public void batchUpdatePrice(Integer proceduresId, List<LabProceduresPrice> priceList) {
		// TODO Auto-generated method stub
		String deleteHql = "delete LabProceduresPrice where proceduresId=:proceduresId";
		Query query = getSession().createQuery(deleteHql);
		query.setInteger("proceduresId", proceduresId);
		query.executeUpdate();
		
		batchAdd(priceList);
	}

	@Override
	public void deletePriceByProceduresId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String hql = "delete LabProceduresPrice where proceduresId =:proceduresId";
		Query query = getSession().createQuery(hql);
		query.setInteger("proceduresId", id);
		query.executeUpdate();
	}


}
