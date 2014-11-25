/**   
 * @Title: LabPreferenceServiceImpl.java 
 * @Package com.upcera.ddx.service.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:28:37 
 * @version V1.0   
 */
package com.upcera.ddx.service.lab.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.impl.LabPreferenceDaoImpl;
import com.upcera.ddx.entity.LabPreference;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabPreferenceService;

/**
 * @ClassName: LabPreferenceServiceImpl
 * @Description: 技工间偏好设置Service实现类
 * @author ERIC
 * @date 2014-6-17 下午04:28:37
 * 
 */
@Service
public class LabPreferenceServiceImpl extends BaseServiceImpl<LabPreference, Integer> implements ILabPreferenceService {

	@Resource
	LabPreferenceDaoImpl labPreferenceDao;

	@Override
	public IBaseDao<LabPreference, Integer> getDao() {
		return labPreferenceDao;
	}

	@Override
	public LabPreference getObjectByLabId(Integer labId) {
		return labPreferenceDao.getObjectByLabId(labId);
	}

}
