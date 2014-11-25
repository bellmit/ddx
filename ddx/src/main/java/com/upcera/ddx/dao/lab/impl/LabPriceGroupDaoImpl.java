package com.upcera.ddx.dao.lab.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.ILabPriceGroupDao;
import com.upcera.ddx.entity.LabPriceGroup;

@Repository
public class LabPriceGroupDaoImpl extends BaseHibernateDao<LabPriceGroup, Integer> implements ILabPriceGroupDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listUnitPriceList(String unitType, Integer unitId, Integer requestLabId, Integer procedures_id)
			throws Exception {
		// TODO Auto-generated method stub
		String type = "";
		if (Constans.UNIT_LAB.equals(unitType)) {
			type = "a.lab_id";
		} else if (Constans.UNIT_PRACTICE.equals(unitType)) {
			type = "a.practice_id";
		}
		String byProceduresId = "";
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(procedures_id)) {
			byProceduresId = " and c.procedures_id = " + procedures_id;
		}
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		try {
			String sql = "select d.category_name,b.price,b.attributes,c.scheduling_turn_around_days,c.procedures_id,c.category_id,c.display_name"
					+ "  from ddx_lab_Practice_Preferences  a,                                           "
					+ "       ddx_lab_Procedures_price      b,                                           "
					+ "       ddx_lab_Procedures            c,                                           "
					+ "       ddx_lab_Procedures_d_Category d                                            "
					+ " where a.price_group_id = b.price_group_id                                        "
					+ "       and c.procedures_id = b.procedures_id                                      "
					+ "       and d.category_id  = c.category_id 										   "
					+ "		and (select count(1) from ddx_lab_Procedures_group_link l where l.procedures_id = c.procedures_id and l.practices_group_id = a.procedures_group_id) >0"
					+ "       and " + type + " = ? and a.lid= ?" + byProceduresId;
			if(unitId.equals(requestLabId)){
				sql = "select aa.*, bb.category_name                                          "+
				"     from (select                                                      "+
				"                  a.display_name,                                      "+
				"                  b.price,                                             "+
				"                  b.attributes,                                        "+
				"                  a.scheduling_turn_around_days,                       "+
				"                  a.procedures_id,                                     "+
				"                  a.category_id                                        "+
				"             from ddx_lab_Procedures a, ddx_lab_Procedures_price b     "+
				"            where b.procedures_id = a.procedures_id                    "+
				"              and a.lab_id = "+unitId+" and a.procedures_id = "+procedures_id+") aa  "+
				"     left join ddx_lab_Procedures_d_Category bb                        "+
				"       on aa.category_id = bb.category_id                              ";        
			}
			SQLQuery query = getSession().createSQLQuery(sql);
			if(!unitId.equals(requestLabId)){
				query.setInteger(0, unitId);
				query.setInteger(1, requestLabId);
			}
			List list = query.list();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(list)) {
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					Object[] obj = (Object[]) list.get(i);
					map.put("displayDescription", obj[6]);
					map.put("price", ToolsKit.TypeConversionUtil.asDouble(obj[1]));
					map.put("attrbutes", ToolsKit.TypeConversionUtil.asString(obj[2]));
					map.put("turnAroundDays", obj[3]);
					map.put("procedures_id", obj[4]);
					map.put("categoryName", obj[0]);
					resultList.add(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}



}
