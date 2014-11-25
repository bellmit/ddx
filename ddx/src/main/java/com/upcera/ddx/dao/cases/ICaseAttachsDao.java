/**   
 * @Title: ICaseAttachsDao.java 
 * @Package com.upcera.ddx.dao.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午02:47:21 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseAttachs;

/** 
 * @ClassName: ICaseAttachsDao 
 * @Description: 案例附件DAO 
 * @author ERIC
 * @date 2014-6-17 下午02:47:21 
 *  
 */
@Repository("caseAttachsDao")
public interface ICaseAttachsDao extends IBaseDao<CaseAttachs, Integer> {

	public List<CaseAttachs> queryAttachsByCriteria(CaseAttachs attachs);
	
}
