/**   
 * @Title: LabProcedureServiceImpl.java 
 * @Package com.upcera.ddx.service.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:31:12 
 * @version V1.0   
 */
package com.upcera.ddx.service.lab.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabProceduresPriceDao;
import com.upcera.ddx.entity.LabProceduresPrice;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProceduresPriceService;


@Service
public class LabProceduresPriceServiceImpl extends BaseServiceImpl<LabProceduresPrice, Integer> implements ILabProceduresPriceService {

	@Resource
	ILabProceduresPriceDao labProceduresPriceDao;

	@Override
	public IBaseDao<LabProceduresPrice, Integer> getDao() {
		return labProceduresPriceDao;
	}

	@Override
	public void batchUpdatePrice(Integer proceduresId, List<LabProceduresPrice> priceList) throws Exception {
		// TODO Auto-generated method stub
		labProceduresPriceDao.batchUpdatePrice(proceduresId, priceList);
	}

	@Override
	public void deletePriceByProceduresId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		labProceduresPriceDao.deletePriceByProceduresId(id);
	}

}
