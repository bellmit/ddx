/**   
 * @Title: ICaseLogDao.java 
 * @Package com.upcera.ddx.dao.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:09:54 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseLog;
import com.upcera.ddx.pojo.PageModel;

/** 
 * @ClassName: ICaseLogDao 
 * @Description: 案例日志类DAO 
 * @author ERIC
 * @date 2014-6-17 下午03:09:54 
 *  
 */
@Repository("caseLogDao")
public interface ICaseLogDao extends IBaseDao<CaseLog, Integer> {
	
	public PageModel queryLogByCriteria(CaseLog log);

}
