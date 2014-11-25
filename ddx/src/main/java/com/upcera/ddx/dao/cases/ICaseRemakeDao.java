package com.upcera.ddx.dao.cases;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.CaseRemake;

/** 
 * @ClassName: ICaseRemakeDao
 * @Description: 改造类型DAO 
 * @author ERIC
 * @date 2014-6-17 下午02:47:21 
 *  
 */
@Repository("caseRemakeDao")
public interface ICaseRemakeDao extends IBaseDao<CaseRemake, Integer>{

}
