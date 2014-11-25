/**   
 * @Title: ICaseDetailsDao.java 
 * @Package com.upcera.ddx.dao.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:05:27 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseDetails;

/** 
 * @ClassName: ICaseDetailsDao 
 * @Description: 案例详细工作要求DAO
 * @author ERIC
 * @date 2014-6-17 下午03:05:27 
 *  
 */
@Repository("caseDetailsDao")
public interface ICaseDetailsDao extends IBaseDao<CaseDetails, Integer> {
	
	public List<CaseDetails> queryDetailsByCriteria(CaseDetails details);

}
