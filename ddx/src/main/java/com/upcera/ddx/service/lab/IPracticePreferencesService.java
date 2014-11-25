package com.upcera.ddx.service.lab;

import com.upcera.ddx.entity.LabPracticePreferences;
import com.upcera.ddx.service.base.IBaseService;

public interface IPracticePreferencesService extends IBaseService<LabPracticePreferences, Integer> {
	public int updateLabPracticePreferences(LabPracticePreferences labpp);
	public int batchUpdatePriceGroup(String[] unitId,Integer priceGroupId,Integer thisLadId);
	public int batchUpdateShiiping(String[] unitId,Integer ShippingId,Integer thisLadId);
}
