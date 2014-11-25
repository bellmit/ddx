package com.upcera.ddx.open.service.cases;

import java.util.List;

import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.open.pojo.Request;

public interface ICasesServiceO {

	//查询技工间订单流水号列表
	public List<Integer> queryCasesSerialsByLab(Request request);
	
	//查询订单详情
	public Cases queryCasesDetailById(Request request);
	
}
