package com.upcera.ddx.service.lab.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabPriceGroupDao;
import com.upcera.ddx.entity.LabPriceGroup;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabPriceGroupService;
@Service
public class LabPriceGroupServiceImpl extends BaseServiceImpl<LabPriceGroup, Integer> implements ILabPriceGroupService{
	@Autowired
	private ILabPriceGroupDao labPriceGroupDao;
	@Override
	public IBaseDao<LabPriceGroup, Integer> getDao() {
		// TODO Auto-generated method stub
		return labPriceGroupDao;
	}
	
	/**
	 * 
	 * @Description: 查询技工间价格列表信息，同时支持诊所端查询合作技工间的报价列表
	 * @param unitType 查询人的机构类型
	 * @param unitId 查询人的机构ID
	 * @param labId 需要查询的技工间ID
	 * @param procedures_id 工序ID,根据工序ID过滤，可以不传
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	  * @return List<Map>(
	 * 				displayDescription 工序名称
					categoryName		工序类别名称
					price				价格
					attrbutes			价格属性
					turnAroundDays		周转天数
					procedures_id		工序ID
					)
	 * @throws Exception 
	 */
	@Override
	public List<Map<String, Object>> listUnitPriceList(String unitType, Integer unitId,Integer requestLabId,Integer procedures_id)throws Exception {
		// TODO Auto-generated method stub
		return labPriceGroupDao.listUnitPriceList(unitType, unitId,requestLabId,procedures_id) ;
	}
}
