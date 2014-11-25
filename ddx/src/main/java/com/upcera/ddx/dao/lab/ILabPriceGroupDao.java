package com.upcera.ddx.dao.lab;


import java.util.List;
import java.util.Map;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabPriceGroup;

@org.springframework.stereotype.Repository("labPriceGroupDao")
public interface ILabPriceGroupDao  extends IBaseDao<LabPriceGroup, Integer>  {
	List<Map<String, Object>> listUnitPriceList(String unitType,Integer unitId,Integer requestLabId,Integer procedures_id)throws Exception ;
}
