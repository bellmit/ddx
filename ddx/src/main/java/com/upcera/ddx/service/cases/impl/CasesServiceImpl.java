/**   
 * @Title: CasesServiceImpl.java 
 * @Package com.upcera.ddx.service.cases.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:25:02 
 * @version V1.0   
 */
package com.upcera.ddx.service.cases.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.common.Response;
import com.upcera.ddx.common.StatusCode;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.common.util.ToolsKit.EmptyCheckUtil;
import com.upcera.ddx.common.util.ToolsKit.TypeConversionUtil;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.cases.ICaseDetailsDao;
import com.upcera.ddx.dao.cases.ICaseNotesDao;
import com.upcera.ddx.dao.cases.ICasesDao;
import com.upcera.ddx.dao.practice.IPatientDao;
import com.upcera.ddx.entity.CaseNotes;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.Patient;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.cases.ICaseCouponsService;
import com.upcera.ddx.service.cases.ICasesService;
import com.upcera.ddx.service.lab.ILabPriceGroupService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.user.IUserService;

/**
 * @ClassName: CasesServiceImpl
 * @Description: 订单Service实现类
 * @author ERIC
 * @date 2014-6-17 下午04:25:02
 * 
 */
@Service
public class CasesServiceImpl extends BaseServiceImpl<Cases, Integer> implements ICasesService {

	@Resource
	ICasesDao casesDao;
	
	@Resource
	ICaseDetailsDao detailsDao;
	
	@Resource
	ICaseNotesDao notesDao;
	
	@Resource
	IPatientDao patientDao;
	
	@Autowired
	IUserService userService;

	@Autowired
	private ILabPriceGroupService labPriceGroupService;
	
	@Autowired
	private ICaseCouponsService caseCouponsService;
	
	@Override
	public IBaseDao<Cases, Integer> getDao() {
		return casesDao;
	}
	@Autowired
	private ILabProcedureService labProcedureService;
	
	@Autowired
	private ICaseCouponsService couponsService;

	@Override
	public Response addData(Cases cases, Patient patient, CaseNotes notes) {
		Response res = new Response();
		try{
			if(ToolsKit.EmptyCheckUtil.isEmpty(cases.getPatientId())){
				patientDao.add(patient);
				cases.setPatientId(patient.getId());
			}
			casesDao.add(cases);
			this.updateCasesPrice(cases.getCaseId());
			notes.setCaseId(cases.getCaseId());
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(notes.getCaseNote())){
				notesDao.add(notes);
			}
			updateCounponsStatus(cases);
			res.setStatusCode(StatusCode.SUCCESS);
		}catch (Exception e) {
			res.setStatusCode(StatusCode.FAILED);
			e.printStackTrace();
		}
		return res;
	}
	
	private synchronized void updateCounponsStatus(Cases cases) throws Exception {
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getCouponCode())) {
			Map[] proMap = ToolsKit.jsonUitl.toBean(Map[].class, cases.getProcedures());
			StringBuffer strb = new StringBuffer();
			for (int i = 0; i < proMap.length; i++) {
				strb.append(proMap[i].get("procedure_id")).append(",");
			}
			User sessionUser = userService.getSessionUserByLoginEmail();
			// 校验
			AjaxResult result = caseCouponsService.checkCoupontValid(sessionUser, cases.getLabId(), strb.toString(), cases.getCouponCode());
			if (!result.getResult().equals(Booleans.TRUE)) {
				throw new Exception(result.getFailReasons());
			}

			List<LabCaseCoupons> labcList = caseCouponsService.loadCouponsByNewCases(sessionUser, cases.getLabId(), cases.getCouponCode());
			if (labcList != null && labcList.size() > 1) {
				throw new Exception("数据错误，优惠券码大于1");
			}
			LabCaseCoupons labc = labcList.get(0);
			Integer useFrequency = labc.getUseFrequency() == null ? 0 : labc.getUseFrequency();
			labc.setUseFrequency(useFrequency + 1);
			caseCouponsService.update(labc);
		}
	}
	
	private synchronized void updateCounponsStatusByLab(Cases cases) throws Exception {
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getCouponCode())) {
			Map[] proMap = ToolsKit.jsonUitl.toBean(Map[].class, cases.getProcedures());
			StringBuffer strb = new StringBuffer();
			for (int i = 0; i < proMap.length; i++) {
				strb.append(proMap[i].get("procedure_id")).append(",");
			}
			// 校验
			AjaxResult result = caseCouponsService.checkCaseCouponValid(cases, cases.getLabId(), strb.toString(), cases.getCouponCode());
			if (!result.getResult().equals(Booleans.TRUE)) {
				throw new Exception(result.getFailReasons());
			}

			List<LabCaseCoupons> labcList = caseCouponsService.queryCouponsByLab(cases);
			if (labcList != null && labcList.size() > 1) {
				throw new Exception("数据错误，优惠券码大于1");
			}
			LabCaseCoupons labc = labcList.get(0);
			Integer useFrequency = labc.getUseFrequency() == null ? 0 : labc.getUseFrequency();
			labc.setUseFrequency(useFrequency + 1);
			caseCouponsService.update(labc);
		}
	}

	@Override
	public PageModel listCaseTryIn(Cases caseQuery) {
		return casesDao.listCaseTryIn(caseQuery);
	}

	@Override
	public List<Cases> listCaseByMonth(CasesFilter cf,Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.listCaseByMonth(cf,caseQuery,pageNo,pageSize);
	}

	@Override
	public Long getCaseCountByMonth(CasesFilter cf,Cases caseQuery) {
		return casesDao.getCaseCountByMonth(cf,caseQuery);
	}

	@Override
	public PageModel listCaseArriveToday(Cases cases) {
		return casesDao.listCaseArriveToday(cases);
	}

	@Override
	public PageModel listCaseShipToday(Cases cases) {
		return casesDao.listCaseShipToday(cases);
	}

	@Override
	public PageModel listCaseTryInsInProgress(Cases cases) {
		return casesDao.listCaseTryInsInProgress(cases);
	}

	@Override
	public PageModel listCaseTryInByPractice(Cases caseQuery) {
		return casesDao.listCaseTryInByPractice(caseQuery);
	}

	@Override
	public PageModel listCaseCurWeek(Cases caseQuery) {
		return casesDao.listCaseCurWeek(caseQuery);
	}

	@Override
	public PageModel listCaseInDraf(Cases caseQuery) {
		return casesDao.listCaseInDraf(caseQuery);
	}

	@Override
	public PageModel queryShipCaseByLab(Cases caseQuery) {
		return casesDao.queryShipCaseByLab(caseQuery);
	}

	@Override
	public PageModel queryArriveCaseByLab(Cases caseQuery) {
		return casesDao.queryArriveCaseByLab(caseQuery);
	}

	@Override
	public PageModel queryTryInCaseByLab(Cases caseQuery) {
		return casesDao.queryTryInCaseByLab(caseQuery);
	}

	@Override
	public List<Cases> queryTryInCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryTryInCaseByLabPage(cf,caseQuery,pageNo,pageSize);
	}
	
	@Override
	public Long queryTryInCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		return casesDao.queryTryInCaseCountByLabPage(cf,caseQuery);
	}

	@Override
	public List<Cases> queryArriveCaseByLabPage(CasesFilter cf,Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryArriveCaseByLabPage(cf, caseQuery, pageNo, pageSize);
	}

	@Override
	public Long queryArriveCaseCountByLabPage(CasesFilter cf,Cases caseQuery) {
		return casesDao.queryArriveCaseCountByLabPage(cf, caseQuery);
	}

	@Override
	public List<Cases> queryShipCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryShipCaseByLabPage(cf, caseQuery, pageNo, pageSize);
	}

	@Override
	public Long queryShipCaseCountByLabPage(CasesFilter cf,Cases caseQuery) {
		return casesDao.queryShipCaseCountByLabPage(cf, caseQuery);
	}

	@Override
	public Cases getArriveCaseByLab(Integer caseId, Integer labId) {
		return casesDao.getArriveCaseByLab(caseId,labId);
	}

	@Override
	public Cases getShipCaseByLab(Integer caseId, Integer labId) {
		return casesDao.getShipCaseByLab(caseId,labId);
	}

	@Override
	public void updateCaseArriveBatch(Integer[] idArry) {
		casesDao.updateCaseArriveBatch(idArry);
	}

	@Override
	public void updateCaseShipBatch(List<Cases> casesList) {
		casesDao.updateCaseShipBatch(casesList);
	}

	@Override
	public PageModel queryOnHoldCaseByLab(Cases caseQuery) {
		return casesDao.queryOnHoldCaseByLab(caseQuery);
	}

	@Override
	public List<Cases> queryOnHoldCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryOnHoldCaseByLabPage(cf, caseQuery, pageNo, pageSize);
	}

	@Override
	public Long queryOnHoldCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		return casesDao.queryOnHoldCaseCountByLabPage(cf, caseQuery);
	}

	@Override
	public List<Map<String, Object>> countTags(Integer unitId, Integer unitType) throws Exception {
		// TODO Auto-generated method stub
		return casesDao.countTags(unitId, unitType);
	}

	@Override
	public PageModel listCaseIsFollowed(Cases caseQuery) {
		return casesDao.listCaseIsFollowed(caseQuery);
	}

	@Override
	public Response updateResumeData(Cases cases, Patient patient, CaseNotes notes) {
		Response res = new Response();
		try{
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getPatientId())){
				patientDao.update(patient);
			}
			this.updateCasesPrice(cases.getCaseId());
			List<CaseNotes> cnList = notesDao.listAllByEqual(notes, 0, 0);
			CaseNotes cn = new CaseNotes();
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(cnList)){
				cn = cnList.get(0);
				notes.setId(cn.getId());
			}
			notes.setCaseId(cases.getCaseId());
			notesDao.addOrUpdate(notes);
			updateCounponsStatus(cases);
			res.setStatusCode(StatusCode.SUCCESS);
		}catch (Exception e) {
			res.setStatusCode(StatusCode.FAILED);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Response addRemakeData(Cases sourceCases, Cases cases, Patient patient, CaseNotes notes) {
		Response res = new Response();
		try{
			if(ToolsKit.EmptyCheckUtil.isEmpty(cases.getPatientId())){
				patientDao.add(patient);
				cases.setPatientId(patient.getId());
			}
			cases.setIsReturn(1);
			cases.setReturnSId(sourceCases.getCaseId());
			casesDao.add(cases);
			this.updateCasesPrice(cases.getCaseId());
			sourceCases.setReturnDId(cases.getCaseId());
			casesDao.update(sourceCases);
			notes.setCaseId(cases.getCaseId());
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(notes.getCaseNote())){
				notesDao.add(notes);
			}
			updateCounponsStatus(cases);
			res.setStatusCode(StatusCode.SUCCESS);
		}catch (Exception e) {
			res.setStatusCode(StatusCode.FAILED);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public PageModel queryCaseRemake(CasesFilter cf,Cases caseQuery) {
		return casesDao.queryCaseRemake(cf,caseQuery);
	}

	@Override
	public PageModel queryOutsourceCase(Cases caseQuery) {
		return casesDao.queryOutsourceCase(caseQuery);
	}

	@Override
	public Response addDataBasePatient(Cases cases, Patient patient, CaseNotes notes) {
		Response res = new Response();
		try{
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getPatientId())){
				patientDao.update(patient);
				cases.setPatientId(patient.getId());
			}else{
				res.setStatusCode(StatusCode.FAILED);
			}
			casesDao.add(cases);
			this.updateCasesPrice(cases.getCaseId());
			notes.setCaseId(cases.getCaseId());
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(notes.getCaseNote())){
				notesDao.add(notes);
			}
			updateCounponsStatus(cases);
			res.setStatusCode(StatusCode.SUCCESS);
		}catch (Exception e) {
			res.setStatusCode(StatusCode.FAILED);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public PageModel queryOutsourceCaseByLab(Cases caseQuery) {
		return casesDao.queryOutsourceCaseByLab(caseQuery);
	}

	@Override
	public List<Cases> queryOutsourceCaseByLabPage(CasesFilter cf, Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryOutsourceCaseByLabPage(cf, caseQuery, pageNo, pageSize);
	}

	@Override
	public Long queryOutsourceCaseCountByLabPage(CasesFilter cf, Cases caseQuery) {
		return casesDao.queryOutsourceCaseCountByLabPage(cf, caseQuery);
	}

	@Override
	public List<String> queryTags(Cases caseQuery) {
		return casesDao.queryTags(caseQuery);
	}

	@Override
	public List<Cases> queryAllLabCases(CasesFilter cf,Cases caseQuery,int pageNo, int pageSize) {
		return casesDao.queryAllLabCases(cf,caseQuery,pageNo,pageSize);
	}

	@Override
	public Long queryAllLabCasesCount(CasesFilter cf,Cases caseQuery) {
		return casesDao.queryAllLabCasesCount(cf,caseQuery);
	}

	@Override
	public int updateCasesProcedure(Integer casesId,String procedures) throws Exception{
		// TODO Auto-generated method stub
		User user = userService.getSessionUserByLoginEmail();
		casesDao.updateTeethNotation(casesId, user.getTeethNotation());
		return casesDao.updateCasesProcedure(casesId, procedures);
	}

	@Override
	public List<Cases> queryCasesBySearchCri(Cases caseQuery, int pageNo, int pageSize) {
		return casesDao.queryCasesBySearchCri(caseQuery, pageNo, pageSize);
	}

	@Override
	public Long queryCasesCountBySearchCri(Cases caseQuery) {
		return casesDao.queryCasesCountBySearchCri(caseQuery);
	}

	@Override
	public Double queryCasesPrice(Integer casesId) throws Exception {
		// TODO Auto-generated method stub
		User user = userService.getSessionUserByLoginEmail();
		Cases cases = casesDao.get(casesId);
		String casesJson = cases.getProcedures();
		Map<String, Object>[] map = ToolsKit.jsonUitl.toBean(Map[].class, casesJson);
		Double countPrice = Double.valueOf(0);
		for (int i = 0; i < map.length; i++) {
			Double price = Double.valueOf(0);
			List<Map<String, Object>> plist = labPriceGroupService.listUnitPriceList(user.getUnitType(), user.getUnitId(), cases.getLabId(), ToolsKit.TypeConversionUtil.asInteger(map[i].get("procedure_id")));
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(plist)){
				for (int j = 0; j < plist.size(); j++) {
					Double pri = ToolsKit.TypeConversionUtil.asDouble(plist.get(j).get("price"));
					if(pri>0){
						if(price==0){
							price = pri;
						}else if(pri<price){
							price = pri;
						}
					}
				}
			}
			countPrice+=price;
		}
		return countPrice;
	}

	@Override
	public int updateTryIn(Cases caseQuery, String proJson, CaseNotes note) throws Exception {
		int flag = 0;
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery.getPatAppDate())){
			casesDao.updateAppointDate(caseQuery);
		}
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(note.getCaseNote())){
			notesDao.add(note);
		}
		User user = userService.getSessionUserByLoginEmail();
		casesDao.updateTeethNotation(caseQuery.getCaseId(), user.getTeethNotation());
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(proJson)){
			casesDao.updateCasesProcedure(caseQuery.getCaseId(), proJson);
			this.updateCasesPrice(caseQuery.getCaseId());
		}
		casesDao.updateCasesOnHoldStatus(caseQuery);
		flag = 1;
		return flag;
	}

	@Override
	public int updateCasesProcedureAndStatus(Integer casesId, String procedures, String status) throws Exception {
		User user = userService.getSessionUserByLoginEmail();
		casesDao.updateTeethNotation(casesId, user.getTeethNotation());
		casesDao.updateCasesProcedure(casesId, procedures);
		return casesDao.updateCasesStatus(casesId,status);
	}

	@Override
	public int updateCasesPrice(Integer casesId) throws Exception {
		// 获取价格
		User user = userService.getSessionUserByLoginEmail();
		Cases cases = casesDao.get(casesId);

		LabCaseCoupons couponsQuery = new LabCaseCoupons();
		LabCaseCoupons coupons = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getCouponCode())) {
			couponsQuery.setPrefix(cases.getCouponCode());
			coupons = couponsService.queryCouponsByPrefix(couponsQuery);
		}
		// 折扣类型
		boolean isF = false;
		// 指定工序
		boolean isAssignPro = false;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(coupons)) {
			if ("F".equals(coupons.getDiscountType())) {
				isF = true;
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(coupons.getProceduresid())) {
				isAssignPro = true;
			}
		}
		String casesJson = cases.getProcedures();
		Map<String, Object>[] map = ToolsKit.jsonUitl.toBean(Map[].class, casesJson);
		Double countPrice = Double.valueOf(0);
		for (int i = 0; i < map.length; i++) {
			Double price = Double.valueOf(0);
			List<Map<String, Object>> plist = labPriceGroupService.listUnitPriceList(user.getUnitType(), user.getUnitId(),
					cases.getLabId(), ToolsKit.TypeConversionUtil.asInteger(map[i].get("procedure_id")));
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(plist)) {
				for (int j = 0; j < plist.size(); j++) {
					Double pri = ToolsKit.TypeConversionUtil.asDouble(plist.get(j).get("price"));
					if (pri > 0) {
						if (price == 0) {
							price = pri;
						} else if (pri < price) {
							price = pri;
						}
					}
				}
			}

			if (null != coupons) {
				// 指定工序
				if (isAssignPro && coupons.getProceduresid().equals(ToolsKit.TypeConversionUtil.asInteger(map[i].get("procedure_id")))) {
					if (isF) {
						price -= coupons.getDiscount();
					} else {
						price = price * coupons.getDiscount() / 100;
					}

				}
			}

			countPrice += price;
		}

		if (null != coupons) {
			// 未指定工序
			if (!isAssignPro) {
				if (isF) {
					countPrice -= coupons.getDiscount();
				} else {
					countPrice = countPrice * coupons.getDiscount() / 100;
				}

			}
		}
		// 更新价格
		return casesDao.updateCasesPrice(casesId, countPrice);
	}

	@Override
	public int updateCaseProcedureAndPrice(Cases caseQuery) throws Exception {
		casesDao.updateCasesProcedure(caseQuery.getCaseId(), caseQuery.getProcedures());
		return this.updateCasesPrice(caseQuery.getCaseId());
	}

	@Override
	public int updateCaseFinishPrice(Cases cases) throws Exception {
		return casesDao.updateCaseFinishPrice(cases);
	}

	@Override
	public Map<String, Object> casesFinanceReport(User sessionUser, Date beginDate, Date endDate, int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = casesDao.casesFinanceReport(sessionUser, beginDate, endDate, pageSize, pageNo);
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		//排序，分组
		Map<String, Map> unitCaseInfo = new HashMap<String, Map>();
		for (int i = 0; i < list.size(); i++) {
			String unitId = TypeConversionUtil.asString(list.get(i).get("unitId"));
			if(EmptyCheckUtil.isNotEmpty(unitCaseInfo.get(unitId))){
				((List)unitCaseInfo.get(unitId).get("data")).add(list.get(i));
			}else{
				List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
				list2.add(list.get(i));
				Map map = new HashMap();
				map.put("data", list2);
				map.put("name", list.get(i).get("unitName"));
				unitCaseInfo.put(unitId, map);
			}
		}
		Iterator it = unitCaseInfo.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", entry.getKey());
			map.put("name", ((Map)entry.getValue()).get("name"));
			List date = (List)((Map)entry.getValue()).get("data");
			
			Double totalPrice = 0d;
			for (int i = 0; i < date.size(); i++) {
				// 设置工序详细信息
				Map imap = (Map) date.get(i);
				totalPrice += TypeConversionUtil.asDouble(imap.get("finishPrice"));
				Cases cases = new Cases();
				cases.setProcedures(TypeConversionUtil.asString(imap.get("procedures")));
				cases.setTeethNotation(TypeConversionUtil.asString(imap.get("teethNotation")));
				List<Map<String, Object>> proceduresDetailed = labProcedureService.getProceduresDetailed(cases);
				imap.put("proceduresDetailed", proceduresDetailed);
			}
			map.put("data", date);
			map.put("totalPrice", totalPrice);
			listMap.add(map);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> m = casesDao.casesFinanceReport(sessionUser, beginDate, endDate);
		result.put("sumPrice", m.get("sumPrice"));
		result.put("count", m.get("count"));
		result.put("resultList", listMap);
		return result;
	}

	@Override
	public List<Cases> queryArriveCasesByPratice(Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryArriveCasesByPratice(caseQuery, pageNo, pageSize);
	}

	@Override
	public Long queryArriveCasesCountByPratice(Cases caseQuery) {
		return casesDao.queryArriveCasesCountByPratice(caseQuery);
	}

	@Override
	public List<Cases> queryCasesByPatient(Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryCasesByPatient(caseQuery, pageNo, pageSize);
	}
	@Override
	public Long queryCasesCountByPatient(Cases caseQuery) {
		return casesDao.queryCasesCountByPatient(caseQuery);
	}

	@Override
	public List<Cases> queryCasesByTags(Cases caseQuery, Integer pageNo, Integer pageSize) {
		return casesDao.queryCasesByTags(caseQuery, pageNo, pageSize);
	}

	@Override
	public Long queryCasesCountByTags(Cases caseQuery) {
		return casesDao.queryCasesCountByTags(caseQuery);
	}

	@Override
	public List<Map<String, Object>> queryEveryTagAndCount(Cases caseQuery) {
		return casesDao.queryEveryTagAndCount(caseQuery);
	}

	@Override
	public void updateCasesWhenClose(Cases cases) {
		// TODO Auto-generated method stub
		casesDao.update(cases);
	}

	@Override
	public List<Cases> listCasesInId(Integer... id) {
		// TODO Auto-generated method stub
		return casesDao.listCasesInId(id);
	}

	@Override
	public int updateCasesProcedureAndDate(Cases cases) throws Exception {
		//更新工序、牙位标识、价格
		updateCasesProcedure(cases.getCaseId(),cases.getProcedures());
		return updateCasesDates(cases);
	}

	@Override
	public int updateCasesDates(Cases cases) throws Exception {
		return casesDao.updateCasesDates(cases);
	}
	
	public int updateCasesDeliveryDates(Cases cases) throws Exception {
		return casesDao.updateCasesDeliveryDates(cases);
	}

	@Override
	public void updateCasePracticeArriveBatch(Integer[] idArry) {
		casesDao.updateCasePracticeArriveBatch(idArry);
	}

	@Override
	public int updateCasesReschedule(Cases cases) throws Exception {
		updateCasesProcedure(cases.getCaseId(),cases.getProcedures());
		return updateCasesDeliveryDates(cases);
	}

	@Override
	public AjaxResult updateCouponDataToCases(Cases cases) throws Exception {
		//更新优惠券字段
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		this.update(cases);
		this.updateCounponsStatusByLab(cases);
		this.updateCasesPriceByLab(cases.getCaseId());
		result.setResult(Booleans.TRUE);
		result.setInfo("提交成功");
		return result;
	}
	

	public int updateCasesPriceByLab(Integer casesId) throws Exception {
		// 获取价格
		Cases cases = casesDao.get(casesId);

		LabCaseCoupons couponsQuery = new LabCaseCoupons();
		LabCaseCoupons coupons = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getCouponCode())) {
			couponsQuery.setPrefix(cases.getCouponCode());
			coupons = couponsService.queryCouponsByPrefix(couponsQuery);
		}
		// 折扣类型
		boolean isF = false;
		// 指定工序
		boolean isAssignPro = false;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(coupons)) {
			if ("F".equals(coupons.getDiscountType())) {
				isF = true;
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(coupons.getProceduresid())) {
				isAssignPro = true;
			}
		}
		String casesJson = cases.getProcedures();
		Map<String, Object>[] map = ToolsKit.jsonUitl.toBean(Map[].class, casesJson);
		Double countPrice = Double.valueOf(0);
		for (int i = 0; i < map.length; i++) {
			Double price = Double.valueOf(0);
			List<Map<String, Object>> plist = labPriceGroupService.listUnitPriceList(cases.getUnitType().toString(), cases.getPracticeId(),
					cases.getLabId(), ToolsKit.TypeConversionUtil.asInteger(map[i].get("procedure_id")));
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(plist)) {
				for (int j = 0; j < plist.size(); j++) {
					Double pri = ToolsKit.TypeConversionUtil.asDouble(plist.get(j).get("price"));
					if (pri > 0) {
						if (price == 0) {
							price = pri;
						} else if (pri < price) {
							price = pri;
						}
					}
				}
			}

			if (null != coupons) {
				// 指定工序
				if (isAssignPro && coupons.getProceduresid().equals(ToolsKit.TypeConversionUtil.asInteger(map[i].get("procedure_id")))) {
					if (isF) {
						price -= coupons.getDiscount();
					} else {
						price = price * coupons.getDiscount() / 100;
					}

				}
			}

			countPrice += price;
		}

		if (null != coupons) {
			// 未指定工序
			if (!isAssignPro) {
				if (isF) {
					countPrice -= coupons.getDiscount();
				} else {
					countPrice = countPrice * coupons.getDiscount() / 100;
				}

			}
		}
		// 更新价格
		return casesDao.updateCasesPrice(casesId, countPrice);
	}

	@Override
	public List<Integer> queryCasesSerialsByLabO(Cases caseQuery, Date sd, Date ed) {
		// TODO Auto-generated method stub
		return casesDao.queryCasesSerialsByLabO(caseQuery,sd,ed);
	}
	
}
