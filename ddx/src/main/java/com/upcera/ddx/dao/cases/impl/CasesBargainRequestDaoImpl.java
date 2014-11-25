/**   
 * @Title: CasesBargainRequestDaoImpl.java 
 * @Package com.upcera.ddx.dao.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-10-24 下午02:34:10 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.cases.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICasesBargainRequestDao;
import com.upcera.ddx.entity.CasesBargainRequest;

/** 
 * @ClassName: CasesBargainRequestDaoImpl 
 * @Description: 议价申请dao
 * @author ERIC
 * @date 2014-10-24 下午02:34:10 
 *  
 */
@Repository
public class CasesBargainRequestDaoImpl extends BaseHibernateDao<CasesBargainRequest, Integer> implements ICasesBargainRequestDao {

}
