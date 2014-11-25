/**   
 * @Title: LabProcedureAttr.java 
 * @Package com.upcera.ddx.dao.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:43:03 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.lab.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabProcedureAttrDao;
import com.upcera.ddx.entity.LabProcedureAttr;

/** 
 * @ClassName: LabProcedureAttr 
 * @Description: 技工间工序属性DAO实现类 
 * @author ERIC
 * @date 2014-6-17 下午03:43:03 
 *  
 */
@Repository
public class LabProcedureAttrDaoImpl extends BaseHibernateDao<LabProcedureAttr, Integer> implements ILabProcedureAttrDao {

	@Override
	public void deleteAttrByProceduresId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String hql = "delete LabProcedureAttr where procedures_id=:procedures_id";
		Query query = getSession().createQuery(hql);
		query.setInteger("procedures_id", id);
		query.executeUpdate();
	}

}
