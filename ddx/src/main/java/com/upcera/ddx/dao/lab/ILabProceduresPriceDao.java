package com.upcera.ddx.dao.lab;


import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabProceduresPrice;

@org.springframework.stereotype.Repository("labProceduresPriceDao")
public interface ILabProceduresPriceDao  extends IBaseDao<LabProceduresPrice, Integer>  {
	public void batchUpdatePrice(Integer proceduresId, List<LabProceduresPrice> priceList);
	public void deletePriceByProceduresId(Integer id) throws Exception;
}
