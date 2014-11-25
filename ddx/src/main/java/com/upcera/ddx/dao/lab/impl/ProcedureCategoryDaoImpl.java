/**   
 * @Title: LabProcedureDaoImpl.java 
 * @Package com.upcera.ddx.dao.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:41:27 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.lab.impl;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.lab.IProcedureCategoryDao;
import com.upcera.ddx.entity.ProcedureCategory;

@Repository
public class ProcedureCategoryDaoImpl extends BaseHibernateDao<ProcedureCategory, Integer> implements IProcedureCategoryDao {


}
