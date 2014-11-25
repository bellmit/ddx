/**   
 * @Title: CasesBargainRequestServiceImpl.java 
 * @Package com.upcera.ddx.service.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-10-24 下午02:28:46 
 * @version V1.0   
 */
package com.upcera.ddx.service.cases.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICasesBargainRequestDao;
import com.upcera.ddx.dao.cases.ICasesDao;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.CasesBargainRequest;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICasesBargainRequestService;

/**
 * @ClassName: CasesBargainRequestServiceImpl
 * @Description: 议价申请
 * @author ERIC
 * @date 2014-10-24 下午02:28:46
 * 
 */
@Service
public class CasesBargainRequestServiceImpl extends BaseServiceImpl<CasesBargainRequest, Integer> implements ICasesBargainRequestService {

	@Resource
	ICasesBargainRequestDao bargainRequestDao;
	@Resource
	ICasesDao casesDao;

	@Override
	public IBaseDao<CasesBargainRequest, Integer> getDao() {
		return bargainRequestDao;
	}

	@Override
	public int updateBargain(CasesBargainRequest bargainRequest) throws Exception {
		int i = 0;
		bargainRequestDao.update(bargainRequest);
		if(Constans.CASES_BARGAIN_VERIFY_AGREE.equals(bargainRequest.getStatus())){
			Cases cases = casesDao.get(bargainRequest.getCaseId());
			cases.setFinishPrice( bargainRequest.getAskPrice());
			casesDao.updateCaseFinishPrice(cases);
		}
		i = 1;
		return i ;
	}

}
