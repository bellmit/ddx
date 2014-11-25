package com.upcera.ddx.dao.lab;


import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabPracticePreferences;

@org.springframework.stereotype.Repository("practicePreferencesDao")
public interface IPracticePreferencesDao  extends IBaseDao<LabPracticePreferences, Integer>  {
	public int updateLabPracticePreferences(LabPracticePreferences labpp);
	public int batchUpdatePriceGroup(String[] unitId, Integer priceGroupId,Integer thisLadId);
	public int batchUpdateShipping(String[] unitId, Integer ShippingId,Integer thisLadId);
}
