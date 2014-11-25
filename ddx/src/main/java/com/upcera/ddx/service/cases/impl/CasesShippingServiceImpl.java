/**   
 * @Title: CasesServiceImpl.java 
 * @Package com.upcera.ddx.service.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:25:02 
 * @version V1.0   
 */
package com.upcera.ddx.service.cases.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICasesShippingDao;
import com.upcera.ddx.entity.CaseShipping;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICasesShippingService;


@Service
public class CasesShippingServiceImpl extends BaseServiceImpl<CaseShipping, Integer> implements ICasesShippingService {

	@Resource
	ICasesShippingDao casesShippingDao;

	@Override
	public IBaseDao<CaseShipping, Integer> getDao() {
		return casesShippingDao;
	}

}
