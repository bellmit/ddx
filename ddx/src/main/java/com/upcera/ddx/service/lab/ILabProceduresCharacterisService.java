/**   
 * @Title: ILabProceduresCharacterisService.java 
 * @Package com.upcera.ddx.service.lab 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:18:04 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.lab;

import java.util.List;

import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: ILabProceduresCharacterisService 
 * @Description: 技工间工序特性Service 
 * @author ERIC
 * @date 2014-6-17 下午04:18:04 
 *  
 */

public interface ILabProceduresCharacterisService extends IBaseService<LabProceduresCharacteris, Integer> {

	public List<LabProceduresCharacteris> getCharacterByCriteria(LabProceduresCharacteris lp, Integer pageNo, Integer pageSize);
	
	public Long getCharacterCountByCriteria(LabProceduresCharacteris lp);
	
	public void addMaterialAndComposition(LabProceduresCharacteris lp, List<LabProceduresComposition> compList);
	
	public void updateMaterialAndCompostion(LabProceduresCharacteris lp, List<LabProceduresComposition> compList);
	
	public void deleteMaterial(Integer id,List<Integer> ids);
	
	public List<LabProceduresCharacteris> listAllEnclosuresByLab(LabProceduresCharacteris lp);
	
	public List<LabProceduresCharacteris> queryCharacterisByIds(LabProceduresCharacteris lp,List<Integer> ids);
	
}
