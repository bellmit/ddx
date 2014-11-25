/**   
 * @Title: IPatientService.java 
 * @Package com.upcera.ddx.service.practice 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:32:30 
 * @version V1.0   
 */ 
package com.upcera.ddx.service.practice;

import java.util.List;

import com.upcera.ddx.common.Response;
import com.upcera.ddx.entity.Patient;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.service.base.IBaseService;

/** 
 * @ClassName: IPatientService 
 * @Description: 患者Service
 * @author ERIC
 * @date 2014-6-11 下午02:32:30 
 *  
 */

public interface IPatientService extends IBaseService<Patient, Integer> {
	
	/**
	 * 
	 * @Title: addData	 
	 * @Description: 插入账户信息和诊所信息
	 * @author ERIC 
	 * @date 2014-6-19上午11:46:47
	 * @param @return
	 * @return Response
	 */
	public Response addData(User user, Practice practice);
	
	public List<Patient> queryPatientByCriteria(Patient patientQuery, Integer pageNo, Integer pageSize);
	
	public Long queryPatientCountByCriteria(Patient patientQuery);
	
	public List<Patient> queryPatientBySearch(Patient patientQuery, Integer pageNo, Integer pageSize);
	
	public Long queryPatientCountBySearch(Patient patientQuery);
	
	public List<Patient> queryPatientByPractice(Patient patientQuery, Integer pageNo, Integer pageSize);
	
	public Long queryPatientCountByPractice(Patient patientQuery);
	

}
