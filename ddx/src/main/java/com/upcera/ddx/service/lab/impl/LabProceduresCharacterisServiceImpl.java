/**   
 * @Title: LabProceduresCharacterisServiceImpl.java 
 * @Package com.upcera.ddx.service.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:31:12 
 * @version V1.0   
 */
package com.upcera.ddx.service.lab.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.ILabProceduresCharacterisDao;
import com.upcera.ddx.dao.lab.ILabProceduresCompositionDao;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProceduresCharacterisService;

/**
 * @ClassName: LabProceduresCharacterisServiceImpl
 * @Description: 技工间工序特性Service实现类
 * @author ERIC
 * @date 2014-6-17 下午04:31:12
 * 
 */
@Service
public class LabProceduresCharacterisServiceImpl extends BaseServiceImpl<LabProceduresCharacteris, Integer> implements ILabProceduresCharacterisService {
	@Autowired
	private BaseCache baseCache;
	@Resource
	ILabProceduresCharacterisDao characterisDao;
	
	@Resource
	ILabProceduresCompositionDao compositionDao;

	@Override
	public IBaseDao<LabProceduresCharacteris, Integer> getDao() {
		return characterisDao;
	}
	@Override
	public List<LabProceduresCharacteris> getCharacterByCriteria(LabProceduresCharacteris lpc, Integer pageNo, Integer pageSize) {
		return characterisDao.getCharacterByCriteria(lpc,pageNo,pageSize);
	}
	@Override
	public void addMaterialAndComposition(LabProceduresCharacteris lp, List<LabProceduresComposition> compList) {
		characterisDao.add(lp);
		for(LabProceduresComposition comp : compList){
			comp.setCharacterId(lp.getId());
			compositionDao.add(comp);
		}
	}
	@Override
	public void updateMaterialAndCompostion(LabProceduresCharacteris lp, List<LabProceduresComposition> compList) {
		characterisDao.update(lp);
		LabProceduresComposition comp = new LabProceduresComposition();
		comp.setCharacterId(lp.getId());
		PageModel pm = compositionDao.getCompositionByCriteria(comp);
		List<LabProceduresComposition> compdList = (List<LabProceduresComposition>) pm.getDatas();
		for(LabProceduresComposition composition : compdList){
			compositionDao.delete(composition.getId());
		}
		for(LabProceduresComposition compa : compList){
			compa.setCharacterId(lp.getId());
			compositionDao.add(compa);
		}
	}
	@Override
	public void deleteMaterial(Integer id, List<Integer> ids) {
		characterisDao.delete(id);
		compositionDao.deleteComposition(ids);
	}

	@Override
	public List<LabProceduresCharacteris> listAllEnclosuresByLab(LabProceduresCharacteris lp) {
		return characterisDao.listAllEnclosuresByLab(lp);
	}
	@Override
	public List<LabProceduresCharacteris> queryCharacterisByIds(LabProceduresCharacteris lp,List<Integer> ids) {
		return characterisDao.queryCharacterisByIds(lp,ids);
	}
	@Override
	public Long getCharacterCountByCriteria(LabProceduresCharacteris lp) {
		// TODO Auto-generated method stub
		return characterisDao.getCharacterCountByCriteria(lp);
	}

}
