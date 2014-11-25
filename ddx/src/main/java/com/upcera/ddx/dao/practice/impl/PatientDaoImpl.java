/**   
 * @Title: PatientDaoImpl.java 
 * @Package com.upcera.ddx.dao.practice.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:52:30 
 * @version V1.0   
 */
package com.upcera.ddx.dao.practice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.practice.IPatientDao;
import com.upcera.ddx.entity.Patient;

/**
 * @ClassName: PatientDaoImpl
 * @Description: 患者Dao实现类
 * @author ERIC
 * @date 2014-6-11 下午02:52:30
 * 
 */
@Repository("patientDao")
public class PatientDaoImpl extends BaseHibernateDao<Patient, Integer> implements IPatientDao {

	@Override
	public List<Patient> queryPatientByCriteria(Patient patientQuery, Integer pageNo, Integer pageSize) {
		StringBuffer hqlBuf = new StringBuffer(
				"select p from Patient p where (lower(p.firstName) like :firstName or lower(p.lastName) like :lastName or lower(p.externalId) like :externalId or lower(p.firstName||p.lastName) like :firstName ) ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("firstName", "%" + patientQuery.getFirstName() + "%");
		params.put("lastName", "%" + patientQuery.getLastName() + "%");
		params.put("externalId", "%" + patientQuery.getExternalId() + "%");
		try {
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getPracticeId())) {
				hqlBuf.append(" and p.practiceId = :practiceId and p.unitType = :unitType");
				params.put("practiceId", patientQuery.getPracticeId());
				params.put("unitType", patientQuery.getUnitType());
			} else {
				hqlBuf.append(" and p.labId = :labId");
				params.put("labId", patientQuery.getLabId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		hqlBuf.append(" order by p.addDate desc");
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryPatientCountByCriteria(Patient patientQuery) {
		StringBuffer hqlBuf = new StringBuffer(
				"select count(p.id) from Patient p where (lower(p.firstName) like :firstName or lower(p.lastName) like :lastName or lower(p.externalId) like :externalId or lower(p.firstName||p.lastName) like :firstName) ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("firstName", "%" + patientQuery.getFirstName() + "%");
		params.put("lastName", "%" + patientQuery.getLastName() + "%");
		params.put("externalId", "%" + patientQuery.getExternalId() + "%");
		try {
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getPracticeId())) {
				hqlBuf.append(" and p.practiceId = :practiceId and p.unitType = :unitType ");
				params.put("practiceId", patientQuery.getPracticeId());
				params.put("unitType", patientQuery.getUnitType());
			} else {
				hqlBuf.append(" and p.labId = :labId");
				params.put("labId", patientQuery.getLabId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryCountByCriteria(hqlBuf.toString(), params);
	}

	@Override
	public List<Patient> queryPatientBySearch(Patient patientQuery, Integer pageNo, Integer pageSize) {
		StringBuffer hqlBuf = new StringBuffer("select p from Patient p where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getPracticeId())) {
				hqlBuf.append(" and p.practiceId = :practiceId ");
				params.put("practiceId", patientQuery.getPracticeId());
				hqlBuf.append(" and p.unitType = :unitType");
				params.put("unitType", patientQuery.getUnitType());
			} else {
				hqlBuf.append(" and p.labId = :labId");
				params.put("labId", patientQuery.getLabId());
			}

			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getKeyword())) {
				hqlBuf.append(" and (lower(p.firstName) like :firstName or lower(p.lastName) like :lastName or lower(p.firstName||p.lastName) like :firstName )");
				params.put("firstName", "%" + patientQuery.getKeyword() + "%");
				params.put("lastName", "%" + patientQuery.getKeyword() + "%");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		hqlBuf.append(" order by p.addDate desc");
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryPatientCountBySearch(Patient patientQuery) {
		StringBuffer hqlBuf = new StringBuffer("select count(p.id) from Patient p where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getPracticeId())) {
				hqlBuf.append(" and p.practiceId = :practiceId ");
				params.put("practiceId", patientQuery.getPracticeId());
				hqlBuf.append(" and p.unitType = :unitType");
				params.put("unitType", patientQuery.getUnitType());
			} else {
				hqlBuf.append(" and p.labId = :labId");
				params.put("labId", patientQuery.getLabId());
			}

			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getKeyword())) {
				hqlBuf.append(" and (lower(p.firstName) like :firstName or lower(p.lastName) like :lastName or lower(p.firstName||p.lastName) like :firstName )");
				params.put("firstName", "%" + patientQuery.getKeyword() + "%");
				params.put("lastName", "%" + patientQuery.getKeyword() + "%");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return queryCountByCriteria(hqlBuf.toString(), params);
	}

	@Override
	public List<Patient> queryPatientByPractice(Patient patientQuery, Integer pageNo, Integer pageSize) {
		StringBuffer hqlBuf = new StringBuffer("select p from Patient p where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			hqlBuf.append(" and p.practiceId = :practiceId ");
			params.put("practiceId", patientQuery.getPracticeId());
			hqlBuf.append(" and p.labId = :labId");
			params.put("labId", patientQuery.getLabId());

			hqlBuf.append(" and p.unitType = :unitType");
			params.put("unitType", patientQuery.getUnitType());

			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getKeyword())) {
				hqlBuf.append(" and (lower(p.firstName) like :firstName or lower(p.lastName) like :lastName or lower(p.firstName||p.lastName) like :firstName )");
				params.put("firstName", "%" + patientQuery.getKeyword() + "%");
				params.put("lastName", "%" + patientQuery.getKeyword() + "%");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		hqlBuf.append(" order by p.addDate desc");
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryPatientCountByPractice(Patient patientQuery) {
		StringBuffer hqlBuf = new StringBuffer("select count(p.id) from Patient p where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			hqlBuf.append(" and p.practiceId = :practiceId ");
			params.put("practiceId", patientQuery.getPracticeId());
			hqlBuf.append(" and p.labId = :labId");
			params.put("labId", patientQuery.getLabId());

			hqlBuf.append(" and p.unitType = :unitType");
			params.put("unitType", patientQuery.getUnitType());

			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientQuery.getKeyword())) {
				hqlBuf.append(" and (lower(p.firstName) like :firstName or lower(p.lastName) like :lastName or lower(p.firstName||p.lastName) like :firstName )");
				params.put("firstName", "%" + patientQuery.getKeyword() + "%");
				params.put("lastName", "%" + patientQuery.getKeyword() + "%");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return queryCountByCriteria(hqlBuf.toString(), params);
	}

}
