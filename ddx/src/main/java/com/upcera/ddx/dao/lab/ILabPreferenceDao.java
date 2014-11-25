package com.upcera.ddx.dao.lab;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.LabPreference;
/**
 * 
 * @ClassName: ILabPreferenceDao 
 * @Description:  技工间偏好设置DAO 
 * @author ERIC
 * @date 2014-6-18 上午09:30:23 
 *
 */
@Repository("labPreferenceDao")
public interface ILabPreferenceDao extends IBaseDao<LabPreference, Integer> {
	
	public LabPreference getObjectByLabId(Integer labId);
}
