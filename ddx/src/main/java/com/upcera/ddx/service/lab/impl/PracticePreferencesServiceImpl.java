package com.upcera.ddx.service.lab.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.IPracticePreferencesDao;
import com.upcera.ddx.entity.LabPracticePreferences;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.IPracticePreferencesService;
@Service
public class PracticePreferencesServiceImpl extends BaseServiceImpl<LabPracticePreferences, Integer> implements IPracticePreferencesService{
	@Autowired
	private IPracticePreferencesDao practicePreferencesDao;
	@Override
	public IBaseDao<LabPracticePreferences, Integer> getDao() {
		// TODO Auto-generated method stub
		return practicePreferencesDao;
	}
	@Override
	public int updateLabPracticePreferences(LabPracticePreferences labpp) {
		// TODO Auto-generated method stub
		return practicePreferencesDao.updateLabPracticePreferences(labpp);
	}
	@Override
	public int batchUpdatePriceGroup(String[] unitId, Integer priceGroupId,Integer thisLadId) {
		// TODO Auto-generated method stub
		return practicePreferencesDao.batchUpdatePriceGroup(unitId, priceGroupId,thisLadId);
	}
	@Override
	public int batchUpdateShiiping(String[] unitId, Integer ShippingId,Integer thisLadId) {
		// TODO Auto-generated method stub
		return practicePreferencesDao.batchUpdateShipping(unitId, ShippingId,thisLadId);
	}

}
