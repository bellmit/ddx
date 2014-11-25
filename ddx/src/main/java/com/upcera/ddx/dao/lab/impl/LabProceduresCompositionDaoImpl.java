/**   
 * @Title: LabProceduresCompositionDaoImpl.java 
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

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabProceduresCompositionDao;
import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.pojo.PageModel;

/** 
 * @ClassName: LabProceduresCompositionDaoImpl 
 * @Description:  技工间工序特性-材料组成DAO实现类 
 * @author ERIC
 * @date 2014-6-17 下午03:41:27 
 *  
 */
@Repository
public class LabProceduresCompositionDaoImpl extends BaseHibernateDao<LabProceduresComposition, Integer> implements  ILabProceduresCompositionDao {

	@Override
	public PageModel getCompositionByCriteria(LabProceduresComposition compostion) {
		PageModel pm = new PageModel();
		Query query = getSession().createQuery("select lpc from LabProceduresComposition lpc where lpc.characterId = ? order by lpc.percentage desc");
		query.setInteger(0, compostion.getCharacterId());
		List list = query.list();
		if(list != null){
			pm.setDatas(list);
			pm.setTotal((long) list.size());
		}
		return pm;
	}

	@Override
	public void deleteComposition(List<Integer> ids) {
		if(null != ids) {
			for(Integer id : ids) {
				getSession().delete(getSession().load(LabProceduresComposition.class, id));
			}
		}
	}

}
