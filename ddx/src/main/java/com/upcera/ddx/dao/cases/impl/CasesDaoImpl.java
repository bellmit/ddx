/**   
 * @Title: CasesDaoImpl.java 
 * @Package com.upcera.ddx.dao.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午03:16:15 
 * @version V1.0   
 */
package com.upcera.ddx.dao.cases.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.common.util.ToolsKit.TypeConversionUtil;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.impl.BaseHibernateDao;
import com.upcera.ddx.dao.cases.ICasesDao;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.PageModel;

/**
 * @ClassName: CasesDaoImpl
 * @Description: 订单DAO实现类
 * @author ERIC
 * @date 2014-6-17 下午03:16:15
 * 
 */
@Repository
public class CasesDaoImpl extends BaseHibernateDao<Cases, Integer> implements ICasesDao {

	@Override
	public PageModel listCaseTryIn(Cases caseQuery) {
		PageModel pm = new PageModel();
		Query query = getSession()
				.createQuery(
						"select c from Cases c where c.status = 'OPEN' and c.isTryIn = 'Y' and c.labId = ? and c.practiceId = ? order by c.createDate desc ");
		query.setInteger(0, caseQuery.getLabId());
		query.setInteger(1, caseQuery.getPracticeId());
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public List<Cases> listCaseByMonth(CasesFilter cf ,Cases caseQuery,Integer pageNo, Integer pageSize) {
		StringBuffer buffer = new StringBuffer();
		Map<String,Object> params = new HashMap<String,Object>();
		buffer.append("select c from Cases c where c.status != 'CANCEL' and c.labId = :labId and c.createDate >= :createDate_start and c.createDate < :createDate_end ");
		params.put("labId", caseQuery.getLabId());
		Calendar c = Calendar.getInstance();
		c.set(cf.getYear(), cf.getMonth()-1, 0,23,59,59);
		params.put("createDate_start", c.getTime());
		c.set(cf.getYear(), cf.getMonth(),+1,0,0,0);
		params.put("createDate_end", c.getTime());
		
		try {
			if(Integer.valueOf(Constans.UNIT_PRACTICE).equals(cf.getUnitType()) && ToolsKit.EmptyCheckUtil.isNotEmpty(cf.getUnitId())){
				buffer.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
			if(Integer.valueOf(Constans.UNIT_LAB).equals(cf.getUnitType()) && ToolsKit.EmptyCheckUtil.isNotEmpty(cf.getUnitId())){
				buffer.append(" and c.practiceId = :partnerLabId");
				params.put("partnerLabId", cf.getUnitId());
			}
			buffer.append(" order by c.createDate desc ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return queryListByCriteria(buffer.toString(), params, pageNo, pageSize);
	}
	
	@Override
	public Long getCaseCountByMonth(CasesFilter cf,Cases caseQuery) {
		StringBuffer buffer = new StringBuffer();
		Map<String,Object> params = new HashMap<String,Object>();
		buffer.append("select count(c.caseId) from Cases c where c.status != 'CANCEL' and c.labId = :labId and c.createDate >= :createDate_start and c.createDate < :createDate_end ");
		params.put("labId", caseQuery.getLabId());
		Calendar c = Calendar.getInstance();
		c.set(cf.getYear(), cf.getMonth()-1, 0,23,59,59);
		params.put("createDate_start", c.getTime());
		c.set(cf.getYear(), cf.getMonth(),+1,0,0,0);
		params.put("createDate_end", c.getTime());
		try {
			if(Integer.valueOf(Constans.UNIT_PRACTICE).equals(cf.getUnitType()) && ToolsKit.EmptyCheckUtil.isNotEmpty(cf.getUnitId())){
				buffer.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
			if(Integer.valueOf(Constans.UNIT_LAB).equals(cf.getUnitType()) && ToolsKit.EmptyCheckUtil.isNotEmpty(cf.getUnitId())){
				buffer.append(" and c.practiceId = :partnerLabId");
				params.put("partnerLabId", cf.getUnitId());
			}
			buffer.append(" order by c.createDate desc ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryCountByCriteria(buffer.toString(), params);
	}

	@Override
	public PageModel listCaseArriveToday(Cases cases) {
		PageModel pm = new PageModel();
		Query query = getSession()
				.createQuery(
						"from Cases c where c.status = 'OPEN' and c.arrived = 0 and c.labId = ? and c.practiceId = ? and to_char(c.deliveryDate,'yyyy-MM-dd') <= to_char(?,'yyyy-MM-dd') order by c.caseId desc");
		query.setInteger(0, cases.getLabId());
		query.setInteger(1, cases.getPracticeId());
		query.setDate(2, new Date());
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel listCaseShipToday(Cases cases) {
		PageModel pm = new PageModel();
		Query query = getSession()
				.createQuery(
						"from Cases c where c.status = 'OPEN' and c.shipped = 0 and c.labId = ? and c.practiceId = ? and to_char(c.sendToLabDate,'yyyy-MM-dd') <= to_char(?,'yyyy-MM-dd') order by c.caseId desc");
		query.setDate(0, new Date());
		query.setInteger(0, cases.getLabId());
		query.setInteger(1, cases.getPracticeId());
		query.setDate(2, new Date());
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel listCaseTryInsInProgress(Cases cases) {
		PageModel pm = new PageModel();
		Query query = getSession()
				.createQuery(
						"select c from Cases c where c.status = 'OPEN' and c.isTryIn = 'Y' and c.labId = ? and c.practiceId = ? order by c.createDate desc ");
		query.setInteger(0, cases.getLabId());
		query.setInteger(1, cases.getPracticeId());
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel listCaseTryInByPractice(Cases caseQuery) {
		PageModel pm = new PageModel();
		Query query = getSession()
				.createQuery(
						"select new Cases(c.caseId,c.patientId,p.firstName || p.lastName) from Cases c,Patient p where c.patientId = p.id and c.status = 'OPEN' and c.isTryIn = 'Y' and c.practiceId = ? order by c.createDate desc ");
		query.setInteger(0, caseQuery.getPracticeId());
		List<Cases> list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel listCaseCurWeek(Cases caseQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel listCaseInDraf(Cases caseQuery) {
		PageModel pm = new PageModel();
		Query query = getSession()
				.createQuery(
						"select new Cases(c.caseId,c.patientId,p.firstName || p.lastName,lab.name) from Cases c,Patient p, Lab lab where c.patientId = p.id and c.labId = lab.id and c.status = 'OPEN' and c.isDraft = 'Y' and c.practiceId = ? order by c.createDate desc ");
		query.setInteger(0, caseQuery.getPracticeId());
		List<Cases> list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel queryShipCaseByLab(Cases caseQuery) {
		PageModel pm = new PageModel();
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.shipped = 0");
		hqlBuf.append(" and c.labId = ? ");
		Query query = null;
		String filterType = caseQuery.getFilterType();
		if(null == filterType || "today".equals(filterType) ){
			hqlBuf.append(" and to_char(c.deliveryDate,'yyyy-MM-dd') <= to_char(?,'yyyy-MM-dd') ");
			hqlBuf.append(" order by c.createDate desc ");
			query = getSession().createQuery(hqlBuf.toString());
			query.setInteger(0, caseQuery.getLabId());
			query.setDate(1, new Date());
		}else if("week".equals(filterType)){
			hqlBuf.append(" and c.deliveryDate > ? and c.deliveryDate < ? ");
			hqlBuf.append(" order by c.createDate desc ");
			Date mondayOfWeek = ToolsKit.DateUtil.getMondayOFWeek();
			Date nextMonday = ToolsKit.DateUtil.getNextMonday();
			query = getSession().createQuery(hqlBuf.toString());
			query.setInteger(0, caseQuery.getLabId());
			query.setDate(1, mondayOfWeek);
			query.setDate(2, nextMonday);
		}else if("month".equals(filterType)){
			hqlBuf.append(" and c.deliveryDate > ? and c.deliveryDate < ? ");
			hqlBuf.append(" order by c.createDate desc ");
			Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
			Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
			query = getSession().createQuery(hqlBuf.toString());
			query.setInteger(0, caseQuery.getLabId());
			query.setDate(1, firstMonthDay);
			query.setDate(2, nextMonthFirst);
		}
		
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel queryArriveCaseByLab(Cases caseQuery) {
		PageModel pm = new PageModel();
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.arrived = 0");
		hqlBuf.append(" and c.labId = ? ");
		Query query = null;
		String filterType = caseQuery.getFilterType();
		if(null == filterType || "today".equals(filterType) ){
			hqlBuf.append(" and to_char(c.sendToLabDate,'yyyy-MM-dd') <= to_char(?,'yyyy-MM-dd') ");
			hqlBuf.append(" order by c.createDate desc ");
			query = getSession().createQuery(hqlBuf.toString());
			query.setInteger(0, caseQuery.getLabId());
			query.setDate(1, new Date());
		}else if("week".equals(filterType)){
			hqlBuf.append(" and c.sendToLabDate > ? and c.sendToLabDate < ? ");
			hqlBuf.append(" order by c.createDate desc ");
			Date mondayOfWeek = ToolsKit.DateUtil.getMondayOFWeek();
			Date nextMonday = ToolsKit.DateUtil.getNextMonday();
			query = getSession().createQuery(hqlBuf.toString());
			query.setInteger(0, caseQuery.getLabId());
			query.setDate(1, mondayOfWeek);
			query.setDate(2, nextMonday);
		}else if("month".equals(filterType)){
			hqlBuf.append(" and c.sendToLabDate > ? and c.sendToLabDate < ? ");
			hqlBuf.append(" order by c.createDate desc ");
			Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
			Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
			query = getSession().createQuery(hqlBuf.toString());
			query.setInteger(0, caseQuery.getLabId());
			query.setDate(1, firstMonthDay);
			query.setDate(2, nextMonthFirst);
		}
		
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel queryTryInCaseByLab(Cases caseQuery) {
		PageModel pm = new PageModel();
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.isTryIn = 'Y'");
		hqlBuf.append(" and c.labId = ? ");
		hqlBuf.append(" order by c.createDate desc ");
		Query query = getSession().createQuery(hqlBuf.toString());
		query.setInteger(0, caseQuery.getLabId());
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public List<Cases> queryTryInCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		Map<String,Object> params = new HashMap<String,Object>(); 
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.isTryIn = 'Y'");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		hqlBuf.append(" order by c.createDate desc ");
		
		return queryListByCriteria(hqlBuf.toString(),params,pageNo,pageSize);
	}
	
	@Override
	public Long queryTryInCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		Map<String,Object> params = new HashMap<String,Object>(); 
		StringBuffer hqlBuf = new StringBuffer("select count(c.caseId) from Cases c where c.status = 'OPEN' and c.isTryIn = 'Y'");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		return queryCountByCriteria(hqlBuf.toString(), params);
	}

	@Override
	public List<Cases> queryArriveCaseByLabPage(CasesFilter cf,Cases caseQuery, Integer pageNo, Integer pageSize) {
		Map<String,Object> params = new HashMap<String,Object>(); 
		Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
		Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.arrived = 0");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		/*hqlBuf.append(" and c.sendToLabDate > :stld_min and c.sendToLabDate < :stld_max ");
		params.put("stld_min", firstMonthDay);
		params.put("stld_max", nextMonthFirst);*/
		
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		
		hqlBuf.append(" order by c.createDate desc ");
		
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryArriveCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		Map<String,Object> params = new HashMap<String,Object>(); 
		Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
		Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
		StringBuffer hqlBuf = new StringBuffer("select count(c.caseId) from Cases c where c.status = 'OPEN' and c.arrived = 0");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		/*hqlBuf.append(" and c.sendToLabDate > :stld_min and c.sendToLabDate < :stld_max ");
		params.put("stld_min", firstMonthDay);
		params.put("stld_max", nextMonthFirst);*/
		
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		return queryCountByCriteria(hqlBuf.toString(), params);
	}

	@Override
	public List<Cases> queryShipCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		Map<String,Object> params = new HashMap<String,Object>(); 
		Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
		Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.shipped != 1");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		/*hqlBuf.append(" and c.deliveryDate > :deliveryDate_min and c.deliveryDate < :deliveryDate_max ");
		params.put("deliveryDate_min", firstMonthDay);
		params.put("deliveryDate_max", nextMonthFirst);*/
		
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		
		hqlBuf.append(" order by c.createDate desc ");
		
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryShipCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		Map<String,Object> params = new HashMap<String,Object>(); 
		Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
		Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
		StringBuffer hqlBuf = new StringBuffer("select count(c.caseId) from Cases c where c.status = 'OPEN' and c.shipped != 1");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		/*hqlBuf.append(" and c.deliveryDate > :deliveryDate_min and c.deliveryDate < :deliveryDate_max ");
		params.put("deliveryDate_min", firstMonthDay);
		params.put("deliveryDate_max", nextMonthFirst);*/
		
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		
		return queryCountByCriteria(hqlBuf.toString(), params);
	}

	@Override
	public Cases getArriveCaseByLab(Integer caseId, Integer labId) {
		//String hql = "select c from Cases c where c.caseId = ? and ((c.practiceId is null and c.practiceId = ?) or (c.practiceId is not null and c.labId = ?))";
		String hql = "select c from Cases c where c.caseId = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, caseId);
//		query.setInteger(1, labId);
//		query.setInteger(2, labId);
		List list = query.list();
		if(null != list && list.size()>0){
			return (Cases) list.get(0);
		}
		return null;
	}

	@Override
	public Cases getShipCaseByLab(Integer caseId, Integer labId) {
		//String hql = "select c from Cases c where c.caseId = ? and ((c.practiceId is null and c.practiceId = ?) or (c.practiceId is not null and c.labId = ?))";
		String hql = "select c from Cases c where c.caseId = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, caseId);
//		query.setInteger(1, labId);
//		query.setInteger(2, labId);
		List list = query.list();
		if(null != list && list.size()>0){
			return (Cases) list.get(0);
		}
		return null;
	}

	@Override
	public void updateCaseArriveBatch(Integer[] idArry) {
		String hql = "update Cases c set c.arrived = 1,c.arriveDate = ? where c.caseId = ?";
		Query query = getSession().createQuery(hql);
		for(Integer id : idArry){
			query.setDate(0, new Date());
			query.setInteger(1, id);
			query.executeUpdate();
		}
	}

	@Override
	public void updateCaseShipBatch(List<Cases> casesList) {
		String hql = "update Cases c set c.shipped = 1,c.finishPrice = ? where c.caseId = ?";
		Query query = getSession().createQuery(hql);
		for(Cases cases : casesList){
			query.setDouble(0, cases.getFinishPrice());
			query.setInteger(1, cases.getCaseId());
			query.executeUpdate();
		}
	}

	@Override
	public PageModel queryOnHoldCaseByLab(Cases caseQuery) {
		PageModel pm = new PageModel();
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.onHoldStatus is not null");
		hqlBuf.append(" and c.labId = ? ");
		hqlBuf.append(" order by c.createDate desc ");
		Query query = getSession().createQuery(hqlBuf.toString());
		query.setInteger(0, caseQuery.getLabId());
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public List<Cases> listAllLabCases(Cases caseQuery, Integer pageNo, Integer pageSize) {
		String queryString = "select c.caseId as caseId,c.labId as labId,c.practiceId as practiceId,c.unitType as unitType,c.invoice as invoice,c.provider as provider,p.name as practice" +
				" from Cases c,Practice p where c.practiceId = p.id and c.labId = ? and c.practiceId = ? and c.unitType = ?";
		Query query = getSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(Cases.class));
		query.setInteger(0, caseQuery.getLabId());
		query.setInteger(1, caseQuery.getPracticeId());
		query.setInteger(2, caseQuery.getUnitType());
		if(pageSize>0){
			query.setFirstResult(pageNo * pageSize - pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	@Override
	public Long getAllLabCasesCount(Cases caseQuery) {
		String queryString = "select count(c.caseId) from Cases c,Practice p where c.practiceId = p.id and c.labId = ? and c.practiceId = ? and c.unitType = ?";
		Query query = getSession().createQuery(queryString);
		query.setInteger(0, caseQuery.getLabId());
		query.setInteger(1, caseQuery.getPracticeId());
		query.setInteger(2, caseQuery.getUnitType());
		return (Long) query.uniqueResult();
	}

	@Override
	public List<Cases> queryOnHoldCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.onHoldStatus is not null");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		
		hqlBuf.append(" order by c.createDate desc ");
		
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryOnHoldCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hqlBuf = new StringBuffer("select count(c.caseId) from Cases c where c.status = 'OPEN' and c.onHoldStatus is not null");
		hqlBuf.append(" and c.labId = :labId ");
		params.put("labId", caseQuery.getLabId());
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		
		return queryCountByCriteria(hqlBuf.toString(), params);
	}
	
	@Override
	public PageModel listCaseIsFollowed(Cases caseQuery) {
		PageModel pm = new PageModel();
		StringBuffer hqlBuf = new StringBuffer("select new Cases(c.caseId,c.patientId,p.firstName || p.lastName) from Cases c,Patient p where c.patientId = p.id and c.status = 'OPEN' and c.isFollow = 'Y' and c.practiceId = ? order by c.createDate ");
		Query query = getSession().createQuery(hqlBuf.toString());
		query.setInteger(0, caseQuery.getPracticeId());
		List list = query.list();
		if(null != list && list.size()>0){
			pm.setDatas(list);
			pm.setTotal((long)list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> countTags(Integer unitId, Integer unitType) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select a.tags,count(a.tags) as count from ddx_case a where a.tags is not null and a.practice_id=:practice_id and a.unit_type=:unit_type group by a.tags";
		Query query = getSession().createSQLQuery(sql);
		query.setInteger("practice_id", unitId);
		query.setInteger("unit_type", unitType);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<Object> list = query.list();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				Object[] obj = (Object[]) list.get(i);
				map.put("tags", obj[0]);
				map.put("count", obj[1]);
				result.add(map);
			}
		}
		return result;
	}

	@Override
	public PageModel queryCaseRemake(CasesFilter cf,Cases caseQuery) {
		PageModel pm = new PageModel();
		String param_url = "";
		StringBuffer hqlBuf = new StringBuffer(
				"select new Cases(c.caseId,c.returnSId,c.remakeType,cr.name,p.name) from Cases c,CaseRemake cr,#");
		hqlBuf.append(" where c.isReturn = 1 and c.remakeType = cr.id and c.practiceId = p.id");
		Map<String,Object> params = new HashMap<String,Object>();
		if(null != caseQuery.getLabId()){
			hqlBuf.append(" and c.labId = :labId");
			params.put("labId", caseQuery.getLabId());
		}
		
		if(null != cf.getStartDate()){
			hqlBuf.append(" and c.createDate >= :startDate");
			params.put("startDate", cf.getStartDate());
		}
		if(null != cf.getEndDate()){
			hqlBuf.append(" and c.createDate <= :endDate");
			params.put("endDate", cf.getEndDate());
		}
		
		List<Cases> list = new ArrayList<Cases>();
		List<Cases> labList = new ArrayList<Cases>();
		List<Cases> practiceList = new ArrayList<Cases>();
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
				hqlBuf.append(" and c.practiceId = :unitId");
				params.put("unitId", cf.getUnitId());
				if(Constans.UNIT_LAB.equals(cf.getUnitType()+"")){
					param_url = "Lab p";
					String str = hqlBuf.toString();
					str = str.replaceFirst("#", param_url);
					labList = queryListByCriteria(str, params);
					list = labList;
				}
				if(Constans.UNIT_PRACTICE.equals(cf.getUnitType()+"")){
					param_url = "Practice p";
					String str = hqlBuf.toString().replaceFirst("#", param_url);
					practiceList = queryListByCriteria(str, params);
					list = practiceList;
				}
			}else{
				hqlBuf.append(" and c.unitType = :unitType");
				param_url = "Lab p";
				params.put("unitType", 1);
				String str = hqlBuf.toString();
				String labStr = str;
				str = str.replaceFirst("#", param_url);
				labList = queryListByCriteria(str, params);
				param_url = "Practice p";
				params.remove("unitType");
				params.put("unitType", 2);
				labStr = labStr.replaceFirst("#", param_url);
				practiceList = queryListByCriteria(labStr, params);
				//合并
				if(labList.size()>0){
					for(Cases c:labList){
						list.add(c);
					}
					if(practiceList.size()>0){
						for(Cases c:practiceList){
							list.add(c);
						}
					}
				}else{
					if(practiceList.size()>0){
						for(Cases c:practiceList){
							list.add(c);
						}
					}
				}
				
			}
			
		}
		
		if(null != list){
			pm.setDatas(list);
			pm.setTotal((long) list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel queryOutsourceCase(Cases caseQuery) {
		PageModel pm = new PageModel();
		String hqlString = "select new Cases(c.caseId,lab.name) from Cases c ,Lab lab where c.labId = lab.id and c.parentId = ?";
		Query query = getSession().createQuery(hqlString);
		query.setInteger(0, caseQuery.getParentId());
		List<Cases> list = query.list();
		if(null != list){
			pm.setDatas(list);
			pm.setTotal((long) list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public PageModel queryOutsourceCaseByLab(Cases caseQuery) {
		PageModel pm = new PageModel();
		String hqlString = "select c.caseId from Cases c where c.status = 'OPEN' and c.parentId is not null and c.labId = ?";
		Query query = getSession().createQuery(hqlString);
		query.setInteger(0, caseQuery.getLabId());
		List<Cases> list = query.list();
		if(null != list){
			pm.setDatas(list);
			pm.setTotal((long) list.size());
		}else{
			pm.setTotal(0l);
		}
		return pm;
	}

	@Override
	public List<Cases> queryOutsourceCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		StringBuffer hqlBuf = new StringBuffer("select c from Cases c where c.status = 'OPEN' and c.parentId is not null and c.labId = :labId");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("labId", caseQuery.getLabId());
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		
		hqlBuf.append(" order by c.createDate desc ");
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryOutsourceCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		StringBuffer hqlBuf = new StringBuffer("select count(c.caseId) from Cases c where c.status = 'OPEN' and c.parentId is not null and c.labId = :labId");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("labId", caseQuery.getLabId());
		if(null != cf){
			if(null != cf.getUnitType()){
				hqlBuf.append(" and c.unitType = :unitType");
				params.put("unitType", cf.getUnitType());
			}
			if(null != cf.getUnitId()){
				hqlBuf.append(" and c.practiceId = :practiceId");
				params.put("practiceId", cf.getUnitId());
			}
		}
		return queryCountByCriteria(hqlBuf.toString(), params);
	}

	@Override
	public List<Map<String,Object>> queryEveryTagAndCount(Cases caseQuery) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		StringBuffer hqlBuf = new StringBuffer("select c.tags from Cases c where c.status != 'CANCEL' and c.practiceId = ? and c.unitType = ?");
		Query query = null;
		hqlBuf.append(" order by c.createDate desc ");
		query = getSession().createQuery(hqlBuf.toString());
		query.setInteger(0, caseQuery.getPracticeId());
		query.setInteger(1, caseQuery.getUnitType());

		List<String> list = query.list();
		List<String> distList = new ArrayList<String>();
		List<String> secList = new ArrayList<String>();
		Set<String> setx = new HashSet<String>();
		for (String str : list) {
			try {
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(str)) {
					String[] strArray = str.split(",");
					for (int i = 0; i < strArray.length; i++) {
						if (ToolsKit.EmptyCheckUtil.isNotEmpty((strArray[i]))) {
							secList.add(strArray[i]);
							setx.add(strArray[i]);
						}

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		distList.clear();
		distList.addAll(setx);
		// 计算distList每个标签在secList中的个数
		Map<String, Object> map = null;
		for (int i = 0; i < distList.size(); i++) {
			map = new HashMap<String, Object>();
			map.put("tags", distList.get(i));
			map.put("count", Collections.frequency(secList, distList.get(i)));
			result.add(map);
		}
		return result;
	}
	
	@Override
	public List<String> queryTags(Cases caseQuery) {
		StringBuffer hqlBuf = new StringBuffer("select c.tags from Cases c where c.status != 'CANCEL' and c.practiceId = ? and c.unitType = ?");
		Query query = null;
		try {
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery.getLabId())){
				hqlBuf.append(" and c.labId = ?");
			}
			hqlBuf.append(" order by c.createDate desc ");
			query = getSession().createQuery(hqlBuf.toString());
			query.setInteger(0, caseQuery.getPracticeId());
			query.setInteger(1, caseQuery.getUnitType());
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery.getLabId())){
				query.setInteger(2, caseQuery.getLabId());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		List<String> list = query.list();
		List<String> distList = new ArrayList<String>();
		Set<String> setx = new HashSet<String>();
		for(String str:list){
			try {
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(str)) {
					String[] strArray = str.split(",");
					for (int i = 0; i < strArray.length; i++) {

						if (ToolsKit.EmptyCheckUtil.isNotEmpty((strArray[i]))) {
							setx.add(strArray[i]);
						}

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		distList.clear();
		distList.addAll(setx);
		return distList;
	}

	@Override
	public List<Cases> queryAllLabCases(CasesFilter cf,Cases caseQuery,int pageNo, int pageSize) {
		StringBuffer hqlBuf = new StringBuffer(
				"select c from Cases c where c.status != 'CANCEL' and c.unitType = :unitType and c.practiceId = :practiceId and c.labId = :labId");
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("unitType", caseQuery.getUnitType());
		params.put("practiceId", caseQuery.getPracticeId());
		params.put("labId", caseQuery.getLabId());
		
		if(null != cf){
			String filterBy = cf.getFilterBy();
			if("byMonth".equals(filterBy)){
				hqlBuf.append(" and c.createDate >= :createDate_start and c.createDate < :createDate_end");
				Calendar c = Calendar.getInstance();
				c.set(cf.getYear(), cf.getMonth()-1, 0,23,59,59);
				params.put("createDate_start", c.getTime());
				c.set(cf.getYear(), cf.getMonth(),+1,0,0,0);
				params.put("createDate_end", c.getTime());
			}else if("toArrive".equals(filterBy)){
				hqlBuf.append(" and c.arrived != 1");
			}else if("toShip".equals(filterBy)){
				hqlBuf.append(" and c.shipped != 1");
			}else{
				hqlBuf.append(" and c.createDate >= :createDate_ms and c.createDate < :createDate_max");
				Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
				Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
				params.put("createDate_ms", firstMonthDay);
				params.put("createDate_max", nextMonthFirst);
			}
		}
		
		hqlBuf.append(" order by c.createDate desc ");
		
		return queryListByCriteria(hqlBuf.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryAllLabCasesCount(CasesFilter cf,Cases caseQuery) {
		StringBuffer hqlBuf = new StringBuffer(
				"select count(c.caseId) from Cases c where c.status != 'CANCEL' and c.unitType = :unitType and c.practiceId = :practiceId and c.labId = :labId");
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("unitType", caseQuery.getUnitType());
		params.put("practiceId", caseQuery.getPracticeId());
		params.put("labId", caseQuery.getLabId());
		
		if(null != cf){
			String filterBy = cf.getFilterBy();
			if("byMonth".equals(filterBy)){
				hqlBuf.append(" and c.createDate >= :createDate_start and c.createDate < :createDate_end");
				Calendar c = Calendar.getInstance();
				c.set(cf.getYear(), cf.getMonth()-1, 0,23,59,59);
				params.put("createDate_start", c.getTime());
				c.set(cf.getYear(), cf.getMonth(),+1,0,0,0);
				params.put("createDate_end", c.getTime());
			}else if("toArrive".equals(filterBy)){
				hqlBuf.append(" and c.arrived != 1");
			}else if("toShip".equals(filterBy)){
				hqlBuf.append(" and c.shipped != 1");
			}else{
				hqlBuf.append(" and c.createDate >= :createDate_ms and c.createDate < :createDate_max");
				Date firstMonthDay = ToolsKit.DateUtil.getFirstMonthDate();
				Date nextMonthFirst = ToolsKit.DateUtil.getNextMonthFirstDate();
				params.put("createDate_ms", firstMonthDay);
				params.put("createDate_max", nextMonthFirst);
			}
		}
		
		return queryCountByCriteria(hqlBuf.toString(), params);
	}

	@Override
	public int updateCasesProcedure(Integer casesId,String procedures) {
		// TODO Auto-generated method stub
		String hql = "update Cases c set c.procedures=:procedures where c.caseId=:caseId";
		Query query = getSession().createQuery(hql);
		query.setString("procedures", procedures);
		query.setInteger("caseId", casesId);
		return query.executeUpdate();
	}

	@Override
	public int updateTeethNotation(Integer caeseId, String TeethNotation) {
		// TODO Auto-generated method stub
		String hql = "update Cases c set c.teethNotation=:teethNotation where c.caseId=:caseId";
		Query query = getSession().createQuery(hql);
		query.setString("teethNotation", TeethNotation);
		query.setInteger("caseId", caeseId);
		return query.executeUpdate();
	}

	@Override
	public List<Cases> queryCasesBySearchCri(Cases caseQuery, int pageNo, int pageSize) {
		StringBuffer hql = new StringBuffer("select c from Cases c where c.status != 'CANCEL' and (lower(c.patient) like :patient ");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("patient", "%"+caseQuery.getPatient()+"%");
		try {
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery.getCaseId())){
				hql.append(" or c.caseId = :caseId");
				params.put("caseId", caseQuery.getCaseId());
			}
			hql.append(")");
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery.getPracticeId())){
				hql.append(" and c.practiceId = :practiceId");
				params.put("practiceId", caseQuery.getPracticeId());
			}else{
				hql.append(" and c.labId = :labId");
				params.put("labId", caseQuery.getLabId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		hql.append(" order by c.caseId desc");
		return queryListByCriteria(hql.toString(), params, pageNo, pageSize);
	}

	@Override
	public Long queryCasesCountBySearchCri(Cases caseQuery) {
		StringBuffer hql = new StringBuffer("select count(c.caseId) from Cases c where c.status != 'CANCEL' and (lower(c.patient) like :patient ");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("patient", "%"+caseQuery.getPatient()+"%");
		try {
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery.getCaseId())){
				hql.append(" or c.caseId = :caseId");
				params.put("caseId", caseQuery.getCaseId());
			}
			hql.append(")");
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery.getPracticeId())){
				hql.append(" and c.practiceId = :practiceId");
				params.put("practiceId", caseQuery.getPracticeId());
			}else{
				hql.append(" and c.labId = :labId");
				params.put("labId", caseQuery.getLabId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryCountByCriteria(hql.toString(), params);
	}

	@Override
	public int updateAppointDate(Cases caseQuery) {
		String hql = "update Cases c set c.patAppDate = :patAppDate where c.caseId = :caseId";
		Query query = getSession().createQuery(hql);
		query.setTimestamp("patAppDate", caseQuery.getPatAppDate());
		query.setInteger("caseId", caseQuery.getCaseId());
		return query.executeUpdate();
	}

	@Override
	public int updateCasesOnHoldStatus(Cases caseQuery) {
		String hql = "update Cases c set c.onHoldStatus = null where c.caseId=:caseId";
		Query query = getSession().createQuery(hql);
		query.setInteger("caseId", caseQuery.getCaseId());
		return query.executeUpdate();
	}

	@Override
	public int updateCasesStatus(Integer casesId, String status) {
		String hql = "update Cases c set c.onHoldStatus = :status, c.arrived = 0, c.arriveDate = null where c.caseId = :caseId";
		Query query = getSession().createQuery(hql);
		query.setString("status", status);
		query.setInteger("caseId", casesId);
		return query.executeUpdate();
	}

	@Override
	public int updateCasesPrice(Integer casesId, Double originalPrice) {
		String hql = "update Cases c set c.originalPrice = :originalPrice where c.caseId = :caseId";
		Query query = getSession().createQuery(hql);
		query.setDouble("originalPrice", originalPrice);
		query.setInteger("caseId", casesId);
		return query.executeUpdate();
	}

	@Override
	public int updateCaseFinishPrice(Cases cases) throws Exception {
		String hql = "update Cases c set c.finishPrice = :finishPrice where c.caseId = :caseId";
		Query query = getSession().createQuery(hql);
		query.setDouble("finishPrice", cases.getFinishPrice());
		query.setInteger("caseId", cases.getCaseId());
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> casesFinanceReport(User sessionUser, Date beginDate, Date endDate, int pageSize, int pageNo)
			throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		int startRow = pageSize * pageNo - pageSize;
		int endRow = pageSize * pageNo;
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("SELECT * FROM (SELECT P.*, ROWNUM RN FROM (select cc.unitId,                        ")
				.append("       cc.unitName,cc.unitType,                                                   ")
				.append("       cc.case_id,                                                                ")
				.append("       cc.create_date,                                                            ")
				.append("       cc.procedures,                                                             ")
				.append("       cc.coupon_code,                                                            ")
				.append("       dd.discount,                                                               ")
				.append("       dd.discountType,                                                           ")
				.append("       dd.remarks,cc.finish_price,cc.teeth_notation                               ")
				.append("  from (select *  from (                                                          ")
				.append("                         select a.practice_id as unitId, a.name as unitName, '2' as unitType   ")
				.append("                                  from ddx_practice a                             ")
				.append("                                 where a.practice_id in                           ")
				.append("                                       (select b.unit_id                          ")
				.append("                                          from DDX_LAB_PRACTICE_PARTNER b         ")
				.append("                                         where b.partner_id = :partnerId          ")
				.append("                                           and b.unit_type = '2')                 ")
				.append("                                union all                                         ")
				.append("                                select a.lab_id as unitId,                        ")
				.append("                                       a.lab_name as unitName,                    ")
				.append("                                       '1' as unitType                            ")
				.append("                                  from ddx_lab a                                  ")
				.append("                                 where a.lab_id in                                ")
				.append("                                       (select b.unit_id                          ")
				.append("                                          from DDX_LAB_PRACTICE_PARTNER b         ")
				.append("                                         where b.partner_id = :partnerId          ")
				.append("                                           and b.unit_type = '1')) aa             ")
				.append("          left join ddx_case bb                                                   ")
				.append("            on bb.lab_id =:partnerId                                              ")
				.append("           and bb.practice_id = aa.unitId) cc                                     ")
				.append("  left join ddx_lab_case_coupons dd                                               ")
				.append("  on dd.prefix = cc.COUPON_CODE  where cc.create_date >:beginDate and cc.create_date <:endDate ) P WHERE ROWNUM <= :endRow) WHERE RN >=:startRow");
		SQLQuery query = getSession().createSQLQuery(sqlStr.toString());
		query.setInteger("partnerId", sessionUser.getUnitId());
		query.setInteger("startRow", startRow);
		query.setInteger("endRow", endRow);
		query.setTimestamp("beginDate", beginDate);
		query.setTimestamp("endDate", endDate);
		List<Object> list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("unitId", obj[0]);
			map.put("unitName", obj[1]);
			map.put("unitType", obj[2]);
			map.put("caseId", obj[3]);
			try {
				map.put("createDate", ((Date)obj[4]).toLocaleString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("procedures", TypeConversionUtil.ClobToString((java.sql.Clob)obj[5]));
			map.put("couponCode", obj[6]);
			map.put("discount", obj[7]);
			map.put("discountType", obj[8]);
			map.put("remarks", obj[9]);
			map.put("finishPrice", obj[10]);
			map.put("teethNotation", obj[11]);
			result.add(map);
		}
		return result;
	}
	@Override
	public Map<String, Object> casesFinanceReport(User sessionUser, Date beginDate, Date endDate) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select sum(cc.finish_price),count(1)												   ")
				.append("  from (select *  from (                                                          ")
				.append("   select a.practice_id as unitId, a.name as unitName, '2' as unitType   		   ")
				.append("                                  from ddx_practice a                             ")
				.append("                                 where a.practice_id in                           ")
				.append("                                       (select b.unit_id                          ")
				.append("                                          from DDX_LAB_PRACTICE_PARTNER b         ")
				.append("                                         where b.partner_id = :partnerId          ")
				.append("                                           and b.unit_type = '2')                 ")
				.append("                                union all                                         ")
				.append("                                select a.lab_id as unitId,                        ")
				.append("                                       a.lab_name as unitName,                    ")
				.append("                                       '1' as unitType                            ")
				.append("                                  from ddx_lab a                                  ")
				.append("                                 where a.lab_id in                                ")
				.append("                                       (select b.unit_id                          ")
				.append("                                          from DDX_LAB_PRACTICE_PARTNER b         ")
				.append("                                         where b.partner_id = :partnerId          ")
				.append("                                           and b.unit_type = '1')) aa             ")
				.append("          left join ddx_case bb                                                   ")
				.append("            on bb.lab_id =:partnerId                                              ")
				.append("           and bb.practice_id = aa.unitId) cc                                     ")
				.append("  left join ddx_lab_case_coupons dd                                               ")
				.append("  on dd.prefix = cc.COUPON_CODE  where cc.create_date >:beginDate and cc.create_date <:endDate");
		SQLQuery query = getSession().createSQLQuery(sqlStr.toString());
		query.setInteger("partnerId", sessionUser.getUnitId());
		query.setTimestamp("beginDate", beginDate);
		query.setTimestamp("endDate", endDate);
		Map<String, Object> map = new HashMap<String, Object>();
		List list = query.list();
		map.put("sumPrice", TypeConversionUtil.asDouble(((Object[])list.get(0))[0]));
		map.put("count", ((Object[])list.get(0))[1]);
		return map;
	}

	@Override
	public List<Cases> queryArriveCasesByPratice(Cases caseQuery, Integer pageNo, Integer pageSize) {
		String hqlString = "from Cases c where c.status = 'CLOSE' and (c.practiceArrived is null or c.practiceArrived = 0) and c.unitType = ? and c.practiceId = ? order by c.caseId desc";
		Query query = getSession().createQuery(hqlString);
		query.setInteger(0, caseQuery.getUnitType());
		query.setInteger(1, caseQuery.getPracticeId());
		if(pageSize>0){
			query.setFirstResult(pageNo * pageSize - pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}

	@Override
	public Long queryArriveCasesCountByPratice(Cases caseQuery) {
		String hqlString = "select count(c.caseId) from Cases c where c.status = 'CLOSE' and (c.practiceArrived is null or c.practiceArrived = 0) and c.unitType = ? and c.practiceId = ?";
		Query query = getSession().createQuery(hqlString);
		query.setInteger(0, caseQuery.getUnitType());
		query.setInteger(1, caseQuery.getPracticeId());
		return (Long) query.uniqueResult();
	}

	@Override
	public List<Cases> queryCasesByPatient(Cases caseQuery, Integer pageNo, Integer pageSize) {
		String hqlString = "from Cases c where c.status != 'CANCEL' and c.patientId = ? order by c.caseId desc";
		Query query = getSession().createQuery(hqlString);
		query.setInteger(0, caseQuery.getPatientId());
		return query.list();
	}

	@Override
	public Long queryCasesCountByPatient(Cases caseQuery) {
		String hqlString = "select count(c.caseId) from Cases c where c.status != 'CANCEL' and c.patientId = ? ";
		Query query = getSession().createQuery(hqlString);
		query.setInteger(0, caseQuery.getPatientId());
		return (Long) query.uniqueResult();
	}

	@Override
	public List<Cases> queryCasesByTags(Cases caseQuery, Integer pageNo, Integer pageSize) {
		String hqlString = "from Cases c where c.status != 'CANCEL' and ','||c.tags||',' like ? and c.practiceId = ? and c.unitType = ? order by c.caseId desc";
		Query query = getSession().createQuery(hqlString);
		query.setString(0, "%,"+caseQuery.getTags()+",%");
		query.setInteger(1, caseQuery.getPracticeId());
		query.setInteger(2, caseQuery.getUnitType());
		return query.list();
	}

	@Override
	public Long queryCasesCountByTags(Cases caseQuery) {
		String hqlString = "select count(c.caseId) from Cases c where c.status != 'CANCEL' and ','||c.tags||',' like ? and c.practiceId = ? and c.unitType = ? ";
		Query query = getSession().createQuery(hqlString);
		query.setString(0, "%,"+caseQuery.getTags()+",%");
		query.setInteger(1, caseQuery.getPracticeId());
		query.setInteger(2, caseQuery.getUnitType());
		return (Long) query.uniqueResult();
	}

	@Override
	public List<Cases> listCasesInId(Integer... id) {
		// TODO Auto-generated method stub
		String hql = "from Cases c where c.caseId in(:casesId)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("casesId", id);
		return query.list();
	}

	@Override
	public int updateCasesDates(Cases cases) throws Exception {
		String hqlString = "update Cases c set c.sendToLabDate = ?, c.shipDate = ?, c.deliveryDate = ?, c.lastUpdateDate = ? where c.caseId = ?";
		Query query = getSession().createQuery(hqlString);
		query.setTimestamp(0, cases.getSendToLabDate());
		query.setTimestamp(1, cases.getShipDate());
		query.setTimestamp(2, cases.getDeliveryDate());
		query.setTimestamp(3, cases.getLastUpdateDate());
		query.setInteger(4, cases.getCaseId());
		return query.executeUpdate();
	}

	public void updateCasePracticeArriveBatch(Integer[] idArry) {
		String hql = "update Cases c set c.practiceArrived = 1,c.practiceArriveDate = ? where c.caseId = ?";
		Query query = getSession().createQuery(hql);
		for(Integer id : idArry){
			query.setTimestamp(0, new Date());
			query.setInteger(1, id);
			query.executeUpdate();
		}
	}

	@Override
	public int updateCasesDeliveryDates(Cases cases) throws Exception {
		String hqlString = "update Cases c set c.deliveryDate = ?, c.shipDate = ?, c.lastUpdateDate = ? where c.caseId = ?";
		Query query = getSession().createQuery(hqlString);
		query.setTimestamp(0, cases.getDeliveryDate());
		query.setTimestamp(1, cases.getShipDate());
		query.setTimestamp(2, cases.getLastUpdateDate());
		query.setInteger(3, cases.getCaseId());
		return query.executeUpdate();
	}

	@Override
	public List<Integer> queryCasesSerialsByLabO(Cases caseQuery, Date sd, Date ed) {
		Query query = getSession().createQuery("select c.caseId from Cases c where c.labId = ? and c.createDate >= ? and c.createDate <= ? order by c.caseId desc");
		query.setInteger(0, caseQuery.getLabId());
		Date nowDate = new Date();
		if(null != sd){
			query.setTimestamp(1, sd);
		}else{
			query.setTimestamp(1, ToolsKit.DateUtil.getDayBegin(nowDate));
		}
		if(null != ed){
			query.setTimestamp(2, ed);
		}else{
			query.setTimestamp(2, ToolsKit.DateUtil.getDayEnd(nowDate));
		}
		List list = query.list();
		List<Integer> distList = new ArrayList<Integer>();
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
		{
		    Integer results = it.next();
		    distList.add(results);
		}
		return distList;
	}
	
}
