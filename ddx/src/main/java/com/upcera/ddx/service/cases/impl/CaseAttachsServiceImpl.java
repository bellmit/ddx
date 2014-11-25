/**   
 * @Title: CaseAttachsServiceImpl.java 
 * @Package com.upcera.ddx.service.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:59:34 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseAttachsDao;
import com.upcera.ddx.entity.CaseAttachs;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseAttachsService;

/** 
 * @ClassName: CaseAttachsServiceImpl 
 * @Description: 案例附件Service实现类 
 * @author ERIC
 * @date 2014-6-17 下午03:59:34 
 *  
 */
@Service
public class CaseAttachsServiceImpl extends BaseServiceImpl<CaseAttachs, Integer> implements ICaseAttachsService {

	@Resource ICaseAttachsDao caseAttachsDao;
	
	@Override
	public IBaseDao<CaseAttachs, Integer> getDao() {
		return caseAttachsDao;
	}

	@Override
	public List<CaseAttachs> queryAttachsByCriteria(CaseAttachs attachs) {
		return caseAttachsDao.queryAttachsByCriteria(attachs);
	}

}
