/**   
 * @Title: CaseDetailsServiceImpl.java 
 * @Package com.upcera.ddx.service.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:05:21 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseDetailsDao;
import com.upcera.ddx.entity.CaseDetails;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseDetailsService;

/** 
 * @ClassName: CaseDetailsServiceImpl 
 * @Description: 案例详细工作要求Service实现类 
 * @author ERIC
 * @date 2014-6-17 下午04:05:21 
 *  
 */
@Service
public class CaseDetailsServiceImpl extends BaseServiceImpl<CaseDetails, Integer> implements ICaseDetailsService {

	@Resource ICaseDetailsDao caseDetailsDao;
	
	@Override
	public IBaseDao<CaseDetails, Integer> getDao() {
		return caseDetailsDao;
	}

	@Override
	public List<CaseDetails> queryDetailsByCriteria(CaseDetails details) {
		return caseDetailsDao.queryDetailsByCriteria(details);
	}

}
