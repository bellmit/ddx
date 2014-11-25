/**   
 * @Title: CaseLogServiceImpl.java 
 * @Package com.upcera.ddx.service.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:12:24 
 * @version V1.0   
 */
package com.upcera.ddx.service.cases.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseLogDao;
import com.upcera.ddx.entity.CaseLog;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseLogService;

/**
 * @ClassName: CaseLogServiceImpl
 * @Description: 案例日志Service实现类
 * @author ERIC
 * @date 2014-6-17 下午04:12:24
 * 
 */
@Service
public class CaseLogServiceImpl extends BaseServiceImpl<CaseLog, Integer> implements ICaseLogService {

	@Resource
	ICaseLogDao caseLogDao;

	@Override
	public IBaseDao<CaseLog, Integer> getDao() {
		return caseLogDao;
	}

//	@Override
//	public PageModel queryLogByCriteria(CaseLog log) {
//		return caseLogDao.queryLogByCriteria(log);
//	}

}
