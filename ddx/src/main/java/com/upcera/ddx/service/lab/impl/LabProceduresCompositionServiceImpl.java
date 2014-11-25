/**   
 * @Title: LabProceduresCompositionServiceImpl.java 
 * @Package com.upcera.ddx.service.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:31:12 
 * @version V1.0   
 */
package com.upcera.ddx.service.lab.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.impl.LabProceduresCompositionDaoImpl;
import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProceduresCompositionService;

/**
 * @ClassName: ILabProceduresCompositionServiceImpl
 * @Description: 技工间工序特性-材料组成Service实现类
 * @author ERIC
 * @date 2014-6-17 下午04:31:12
 * 
 */
@Service
public class LabProceduresCompositionServiceImpl extends BaseServiceImpl<LabProceduresComposition, Integer> implements ILabProceduresCompositionService {

	@Resource
	LabProceduresCompositionDaoImpl labProceduresCompositionDao;

	@Override
	public IBaseDao<LabProceduresComposition, Integer> getDao() {
		return labProceduresCompositionDao;
	}

	@Override
	public PageModel getCompositionByCriteria(LabProceduresComposition compostion) {
		return labProceduresCompositionDao.getCompositionByCriteria(compostion);
	}

}
