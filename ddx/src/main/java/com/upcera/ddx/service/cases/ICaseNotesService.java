/**   
 * @Title: ICaseNotesService.java 
 * @Package com.upcera.ddx.service.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:14:59 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.cases;

import com.upcera.ddx.entity.CaseNotes;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ICaseNotesService 
 * @Description: 案例笔记Service实现类 
 * @author ERIC
 * @date 2014-6-17 下午04:14:59 
 *  
 */

public interface ICaseNotesService extends IBaseService<CaseNotes, Integer> {
	
	public PageModel queryNotesByCriteria(CaseNotes notes);
	
}
