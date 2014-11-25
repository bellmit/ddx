/**   
 * @Title: ICaseNotesDao.java 
 * @Package com.upcera.ddx.dao.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:11:40 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseNotes;
import com.upcera.ddx.pojo.PageModel;

/** 
 * @ClassName: ICaseNotesDao 
 * @Description: 案例笔记DAO 
 * @author ERIC
 * @date 2014-6-17 下午03:11:40 
 *  
 */
@Repository("caseNotesDao")
public interface ICaseNotesDao extends IBaseDao<CaseNotes, Integer> {
	
	public PageModel queryNotesByCriteria(CaseNotes notes);
	
}
