/**   
 * @Title: CaseNotesDaoImpl.java 
 * @Package com.upcera.ddx.dao.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:12:29 
 * @version V1.0   
 */
package com.upcera.ddx.dao.cases.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICaseNotesDao;
import com.upcera.ddx.entity.CaseNotes;
import com.upcera.ddx.pojo.PageModel;

/**
 * @ClassName: CaseNotesDaoImpl
 * @Description: 案例笔记DAO实现类
 * @author ERIC
 * @date 2014-6-17 下午03:12:29
 * 
 */
@Repository
public class CaseNotesDaoImpl extends BaseHibernateDao<CaseNotes, Integer> implements ICaseNotesDao {

	@Override
	public PageModel queryNotesByCriteria(CaseNotes notes) {
		PageModel pm = new PageModel();
		StringBuffer buffer = new StringBuffer("select cn from CaseNotes cn where cn.caseId = :caseId");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("caseId", notes.getCaseId());
		if(notes.getUnitId()!=null && notes.getUnitType()!=null){
			buffer.append(" and cn.unitId = :unitId and cn.unitType = :unitType");
			params.put("unitId", notes.getUnitId());
			params.put("unitType", notes.getUnitType());
		}
		buffer.append(" order by cn.caseDate desc");
		
		List<CaseNotes> noteList = queryListByCriteria(buffer.toString(), params);
		if(noteList != null){
			pm.setDatas(noteList);
			pm.setTotal((long) noteList.size());
		}
		return pm;
	}

}
