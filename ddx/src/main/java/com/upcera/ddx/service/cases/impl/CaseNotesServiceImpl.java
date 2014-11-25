/**   
 * @Title: CaseNotesServiceImpl.java 
 * @Package com.upcera.ddx.service.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:23:12 
 * @version V1.0   
 */
package com.upcera.ddx.service.cases.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseNotesDao;
import com.upcera.ddx.entity.CaseNotes;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseNotesService;

/**
 * @ClassName: CaseNotesServiceImpl
 * @Description: 案例笔记Service
 * @author ERIC
 * @date 2014-6-17 下午04:23:12
 * 
 */
@Service
public class CaseNotesServiceImpl extends BaseServiceImpl<CaseNotes, Integer> implements ICaseNotesService {

	@Resource
	ICaseNotesDao caseNotesDao;

	@Override
	public IBaseDao<CaseNotes, Integer> getDao() {
		return caseNotesDao;
	}

	@Override
	public PageModel queryNotesByCriteria(CaseNotes notes) {
		return caseNotesDao.queryNotesByCriteria(notes);
	}

}
