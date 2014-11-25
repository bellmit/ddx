/**   
 * @Title: IPatientDao.java 
 * @Package com.upcera.ddx.dao.practice 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:50:53 
 * @version V1.0   
 */ 
package com.upcera.ddx.dao.practice;

import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.entity.Patient;

/** 
 * @ClassName: IPatientDao 
 * @Description: 患者Dao
 * @author ERIC
 * @date 2014-6-11 下午02:50:53 
 *  
 */

public interface IPatientDao extends IBaseDao<Patient, Integer> {
	
	public List<Patient> queryPatientByCriteria(Patient patientQuery, Integer pageNo, Integer pageSize);
	
	public Long queryPatientCountByCriteria(Patient patientQuery);
	
	public List<Patient> queryPatientBySearch(Patient patientQuery, Integer pageNo, Integer pageSize);
	
	public Long queryPatientCountBySearch(Patient patientQuery);
	
	public List<Patient> queryPatientByPractice(Patient patientQuery, Integer pageNo, Integer pageSize);
	
	public Long queryPatientCountByPractice(Patient patientQuery);
	
}
