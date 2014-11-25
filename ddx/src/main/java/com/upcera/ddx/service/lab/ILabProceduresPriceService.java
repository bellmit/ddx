/**   
 * @Title: ILabPreferenceService.java 
 * @Package com.upcera.ddx.service.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:16:53 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.lab;

import java.util.List;

import com.upcera.ddx.entity.LabProceduresPrice;
import com.upcera.ddx.service.base.IBaseService;


public interface ILabProceduresPriceService extends IBaseService<LabProceduresPrice, Integer> {
	
	public void batchUpdatePrice(Integer proceduresId,List<LabProceduresPrice> priceList) throws Exception;
	public void deletePriceByProceduresId(Integer id) throws Exception;

}
