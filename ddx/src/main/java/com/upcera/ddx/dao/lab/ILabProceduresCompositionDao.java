/**   
 * @Title: ILabProceduresCompositionDao.java 
 * @Package com.upcera.ddx.dao.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:38:31 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.lab;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.pojo.PageModel;

/** 
 * @ClassName: ILabProceduresCompositionDao 
 * @Description: 技工间工序特性-材料组成特点DAO 
 * @author ERIC
 * @date 2014-6-17 下午03:38:31 
 *  
 */
@Repository("labProceduresCompositionDao")
public interface ILabProceduresCompositionDao extends IBaseDao<LabProceduresComposition, Integer> {
	
	public PageModel getCompositionByCriteria(LabProceduresComposition compostion);
	
	public void deleteComposition(List<Integer> ids);
	
}
