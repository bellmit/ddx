/**   
 * @Title: ILabProceduresCharacterisDao.java 
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
import com.upcera.ddx.entity.LabProceduresCharacteris;

/** 
 * @ClassName: ILabProceduresCharacterisDao 
 * @Description: 技工间工序特点DAO 
 * @author ERIC
 * @date 2014-6-17 下午03:38:31 
 *  
 */
@Repository("labProceduresCharacterisDao")
public interface ILabProceduresCharacterisDao extends IBaseDao<LabProceduresCharacteris, Integer> {
	
	public List<LabProceduresCharacteris> getCharacterByCriteria(LabProceduresCharacteris lp, Integer pageNo, Integer pageSize);
	
	public Long getCharacterCountByCriteria(LabProceduresCharacteris lp);
	
	public List<LabProceduresCharacteris> listAllEnclosuresByLab(LabProceduresCharacteris lp);
	
	public List<LabProceduresCharacteris> queryCharacterisByIds(LabProceduresCharacteris lp,List<Integer> ids);

}
