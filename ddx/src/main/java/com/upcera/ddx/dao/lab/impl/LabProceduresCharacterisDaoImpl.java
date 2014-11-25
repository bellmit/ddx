/**   
 * @Title: LabProceduresCharacterisDaoImpl.java 
 * @Package com.upcera.ddx.dao.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:41:27 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.lab.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabProceduresCharacterisDao;
import com.upcera.ddx.entity.LabProceduresCharacteris;

/** 
 * @ClassName: LabProceduresCharacterisDaoImpl 
 * @Description:  技工间工序特性DAO实现类 
 * @author ERIC
 * @date 2014-6-17 下午03:41:27 
 *  
 */
@Repository
public class LabProceduresCharacterisDaoImpl extends BaseHibernateDao<LabProceduresCharacteris, Integer> implements  ILabProceduresCharacterisDao {

	@Override
	public List<LabProceduresCharacteris> getCharacterByCriteria(LabProceduresCharacteris lp, Integer pageNo, Integer pageSize){
		
		StringBuffer buffer = new StringBuffer("select lpc from LabProceduresCharacteris lpc where lpc.type = :type and lpc.labId = :labId");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("type", lp.getType());
		params.put("labId", lp.getLabId());
		
		try {
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(lp.getCharacterName())){
				buffer.append(" and lpc.characterName like :characterName");
				params.put("characterName", "%"+lp.getCharacterName()+"%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		buffer.append(" order by lpc.id desc");

		return queryListByCriteria(buffer.toString(), params, pageNo, pageSize);
	}

	@Override
	public List<LabProceduresCharacteris> listAllEnclosuresByLab(LabProceduresCharacteris lp) {
		Query query = getSession().createQuery("select lpc from LabProceduresCharacteris lpc where lpc.type = ? and lpc.labId = ?");
		query.setString(0, lp.getType());
		query.setInteger(1, lp.getLabId());
		return query.list();
	}

	@Override
	public List<LabProceduresCharacteris> queryCharacterisByIds(LabProceduresCharacteris lp,List<Integer> ids) {
		Query query = getSession().createQuery("from LabProceduresCharacteris lpc where lpc.id in(:ids)");
		query.setParameterList("ids", ids);
		return query.list();
	}

	@Override
	public Long getCharacterCountByCriteria(LabProceduresCharacteris lp) {
		StringBuffer buffer = new StringBuffer("select count(lpc.id) from LabProceduresCharacteris lpc where lpc.type = :type and lpc.labId = :labId");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("type", lp.getType());
		params.put("labId", lp.getLabId());
		
		try {
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(lp.getCharacterName())){
				buffer.append(" and lpc.characterName like :characterName");
				params.put("characterName", "%"+lp.getCharacterName()+"%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryCountByCriteria(buffer.toString(), params);
	}

}
