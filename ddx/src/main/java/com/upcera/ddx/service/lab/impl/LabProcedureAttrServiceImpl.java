/**   
 * @Title: LabProcedureAttrServiceImpl.java 
 * @Package com.upcera.ddx.service.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:33:44 
 * @version V1.0   
 */
package com.upcera.ddx.service.lab.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.impl.LabProcedureAttrDaoImpl;
import com.upcera.ddx.entity.LabProcedureAttr;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProcedureAttrService;

/**
 * @ClassName: LabProcedureAttrServiceImpl
 * @Description: 技工间工序属性Service实现类
 * @author ERIC
 * @date 2014-6-17 下午04:33:44
 * 
 */
@Service
public class LabProcedureAttrServiceImpl extends BaseServiceImpl<LabProcedureAttr, Integer> implements ILabProcedureAttrService {

	@Resource
	LabProcedureAttrDaoImpl labProcedureAttrDao;

	@Override
	public IBaseDao<LabProcedureAttr, Integer> getDao() {
		return labProcedureAttrDao;
	}

	@Override
	public void deleteAttrByProceduresId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		labProcedureAttrDao.deleteAttrByProceduresId(id);
	}

}
