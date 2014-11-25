/**   
 * @Title: PatientServiceImpl.java 
 * @Package com.upcera.ddx.service.practice.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:41:03 
 * @version V1.0   
 */
package com.upcera.ddx.service.practice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upcera.ddx.common.Response;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.practice.IPatientDao;
import com.upcera.ddx.dao.practice.impl.PatientDaoImpl;
import com.upcera.ddx.entity.Patient;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.practice.IPatientService;

/**
 * @ClassName: PatientServiceImpl
 * @Description: 患者Service实现类
 * @author ERIC
 * @date 2014-6-11 下午02:41:03
 * 
 */
@Service
public class PatientServiceImpl extends BaseServiceImpl<Patient, Integer> implements IPatientService {

	@Resource
	IPatientDao patientDao;
	
	@Override
	public IBaseDao<Patient, Integer> getDao() {
		return patientDao;
	}

	@Override
	public Response addData(User user, Practice practice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> queryPatientByCriteria(Patient patientQuery, Integer pageNo, Integer pageSize) {
		return patientDao.queryPatientByCriteria(patientQuery, pageNo, pageSize);
	}

	@Override
	public Long queryPatientCountByCriteria(Patient patientQuery) {
		return patientDao.queryPatientCountByCriteria(patientQuery);
	}

	@Override
	public List<Patient> queryPatientBySearch(Patient patientQuery, Integer pageNo, Integer pageSize) {
		return patientDao.queryPatientBySearch(patientQuery, pageNo, pageSize);
	}

	@Override
	public Long queryPatientCountBySearch(Patient patientQuery) {
		return patientDao.queryPatientCountBySearch(patientQuery);
	}

	@Override
	public List<Patient> queryPatientByPractice(Patient patientQuery, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return patientDao.queryPatientByPractice(patientQuery, pageNo, pageSize);
	}

	@Override
	public Long queryPatientCountByPractice(Patient patientQuery) {
		return patientDao.queryPatientCountByPractice(patientQuery);
	}

}
