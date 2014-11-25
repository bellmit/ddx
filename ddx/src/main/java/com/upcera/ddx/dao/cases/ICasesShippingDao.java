/**   
 * @Title: ICasesDao.java 
 * @Package com.upcera.ddx.dao.cases 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:15:26 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseShipping;


@Repository("casesShippingDao")
public interface ICasesShippingDao extends IBaseDao<CaseShipping, Integer> {

}
