/**   
 * @Title: CasesDaoImpl.java 
 * @Package com.upcera.ddx.dao.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:16:15 
 * @version V1.0   
 */
package com.upcera.ddx.dao.cases.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICasesShippingDao;
import com.upcera.ddx.entity.CaseShipping;


@Repository
public class CasesShippingDaoImpl extends BaseHibernateDao<CaseShipping, Integer> implements ICasesShippingDao {

}
