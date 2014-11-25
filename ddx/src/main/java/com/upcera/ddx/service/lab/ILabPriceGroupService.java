package com.upcera.ddx.service.lab;

import java.util.List;
import java.util.Map;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.entity.LabPriceGroup;
import com.upcera.ddx.service.base.IBaseService;

public interface ILabPriceGroupService extends IBaseService<LabPriceGroup, Integer> {
	
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
	public List<Map<String, Object>> listUnitPriceList(String unitType, Integer unitId,Integer requestLabId,Integer procedures_id)throws Exception ;
}
