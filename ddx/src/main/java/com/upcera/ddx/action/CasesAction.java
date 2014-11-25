/**   
 * @Title: CasesAction.java 
 * @Package com.upcera.ddx.action 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:10:17 
 * @version V1.0   
 */
package com.upcera.ddx.action;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.Response;
import com.upcera.ddx.common.StatusCode;
import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.cache.impl.ProcedureAttrCache;
import com.upcera.ddx.common.excel.AbstractExcelService;
import com.upcera.ddx.common.excel.impl.CouponsExcel;
import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.common.target.Note;
import com.upcera.ddx.common.util.LogUtil;
import com.upcera.ddx.common.util.StringUtil;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.CaseAttachs;
import com.upcera.ddx.entity.CaseDetails;
import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.entity.CaseLog;
import com.upcera.ddx.entity.CaseNotes;
import com.upcera.ddx.entity.CaseRemake;
import com.upcera.ddx.entity.CaseShipping;
import com.upcera.ddx.entity.CaseTerms;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.CasesBargainRequest;
import com.upcera.ddx.entity.DDXLog;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.entity.LabProcedureAttr;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.entity.LabProceduresOutLink;
import com.upcera.ddx.entity.Patient;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.ProcedureDisplayCategory;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxCaseResult;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.LabProcedurePojo;
import com.upcera.ddx.pojo.LogPojo;
import com.upcera.ddx.pojo.LogPojo.LogLevel;
import com.upcera.ddx.pojo.LogPojo.LogType;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.pojo.Permissions;
import com.upcera.ddx.service.cases.ICaseAttachsService;
import com.upcera.ddx.service.cases.ICaseCouponsService;
import com.upcera.ddx.service.cases.ICaseDetailsService;
import com.upcera.ddx.service.cases.ICaseNotesService;
import com.upcera.ddx.service.cases.ICaseRemakeService;
import com.upcera.ddx.service.cases.ICaseTermsService;
import com.upcera.ddx.service.cases.ICaseholdService;
import com.upcera.ddx.service.cases.ICasesBargainRequestService;
import com.upcera.ddx.service.cases.ICasesService;
import com.upcera.ddx.service.cases.ICasesShippingService;
import com.upcera.ddx.service.lab.ILabProcedureAttrService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabProceduresCharacterisService;
import com.upcera.ddx.service.lab.ILabProceduresOutLinkService;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.lab.IPracticePreferencesService;
import com.upcera.ddx.service.lab.IProcedureDisplayCategoryService;
import com.upcera.ddx.service.practice.IPatientService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.ILogService;
import com.upcera.ddx.service.user.IUserService;

/**
 * @ClassName: CasesAction
 * @Description: 订单Action
 * @author ERIC
 * @date 2014-6-11 下午02:10:17
 * 
 */
@Controller
@RequestMapping("/casesAction")
public class CasesAction extends BaseAction {

	@Autowired
	private ICaseholdService chservice;
	@Autowired
	private ICaseCouponsService caseCouponsService;
	@Autowired
	private ICasesShippingService casesShippingService;
	@Autowired
	private ICaseholdService caseholdService;
	@Autowired
	private ILabService labService;
	@Autowired
	private ICaseRemakeService caseRemakeService;
	@Autowired
	private IProcedureDisplayCategoryService procedureDisplayCategoryService;
	@Autowired
	private ICasesService casesService;
	@Autowired
	private ICaseDetailsService detailsService;
	@Autowired
	private ICaseNotesService notesService;
	// @Autowired
	// private ICaseLogService logService;
	@Autowired
	private ILogService logService;
	@Autowired
	private ICaseAttachsService caseAttachsService;
	@Autowired
	private IPatientService patientService;
	@Autowired
	private ILabProceduresCharacterisService characterisService;
	@Autowired
	private IProcedureDisplayCategoryService displayCategoryService;
	@Autowired
	private ILabProcedureService labProcedureService;
	@Autowired
	private IPracticeService practiceService;
	@Autowired
	private ILabProceduresCharacterisService labProceduresCharacterisService;
	@Autowired
	private IUserService userService;
	@Autowired
	private CouponsExcel couponsExcel;
	@Autowired
	private BaseCache baseCache;
	@Autowired
	private ILabProcedureAttrService labProcedureAttrService;
	@Autowired
	private IPracticePreferencesService practicePreferencesService;
	@Autowired
	private ICaseTermsService termsService;
	@Autowired
	private ILabProceduresOutLinkService outLinkService;
	@Autowired
	private ICasesBargainRequestService bargainRequestService;

	/**
	 * 
	 * @Title: pageJump
	 * @Description: 页面跳转
	 * @author ERIC
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/pageJump")
	public ModelAndView pageJump(HttpServletRequest request) throws Exception {
		String method = request.getParameter("type");

		Integer reqAccLabId = getParameterAsInteger(request, "reqAccLabId");

		Lab reqAccLab = labService.get(reqAccLabId);

		String mappingUrl = baseCache.getModelAndViewMappingMap().get(method);

		Object datas = null;
		try {
			Method meth = this.getClass().getMethod(method, HttpServletRequest.class);
			datas = meth.invoke(this, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> modelMap = (Map) datas;

		Permissions per = getLabPermissions(reqAccLabId);
		// 提供的订单权限
		modelMap.put("financesPermissions", per.getFinances());
		// 提供的财政权限
		modelMap.put("casesPermissions", per.getCases());
		// 请求的技工间
		modelMap.put("requestAccountLab", reqAccLab);
		// 加载伙伴技工间
		modelMap.put("listPartnerLabs", getPartnerLabList());
		return new ModelAndView(mappingUrl).addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Description: 创建案例
	 * @author ERIC
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return ModelAndView
	 */
	public Object toNewCase(HttpServletRequest request) throws Exception {
		String newType = Constans.CASES_NEWTYPE_ADD;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer reqAccLabId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("reqAccLabId"));
		User user = getSessionUserByLoginEmail();
		String unitType = user.getUnitType();
		if (Constans.UNIT_PRACTICE.equals(unitType)) {
			Practice practice = (Practice) getSessionUnit();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(practice.getProviders())) {
				List<User> providers = userService.ListUser(practice.getProviders());
				modelMap.put("providers", providers);
			}
		}

		// modelMap.put("thisPratice", getSessionUnit());

		// 加载工序特征
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(reqAccLabId)) {
			LabProceduresCharacteris characteris = new LabProceduresCharacteris();
			characteris.setLabId(reqAccLabId);
			characteris.setType(Constans.PROCEDURES_CHARACTERIS_ENCLOSURES);
			List<LabProceduresCharacteris> enclosuresList = characterisService.listAllEnclosuresByLab(characteris);
			// 附件
			modelMap.put("enclosuresList", enclosuresList);
			modelMap.put("proOption", labProcedureService.getProedureAsHtml(reqAccLabId));
			modelMap.put("user", getSessionUserByLoginEmail());

			// 向接收方下订单的协议
			CaseTerms ct = new CaseTerms();
			ct.setLabid(reqAccLabId);
			List<CaseTerms> terms = termsService.listAllByEqual(ct, 0, 0);
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(terms)) {
				ct = terms.get(0);
				modelMap.put("caseTerms", ct);
			}

			// 获取比色卡数据
			modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
			modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());

			// 获取tags
			Cases caseQuery = new Cases();
			Integer unitId = getSessionUnitId();
			caseQuery.setLabId(reqAccLabId);
			caseQuery.setPracticeId(unitId);
			caseQuery.setUnitType(new Integer(user.getUnitType()));
			List<String> tags = loadTags(caseQuery);
			String tags_str = tags.toString().substring(1);
			tags_str = tags_str.substring(0, tags_str.length() - 1);
			modelMap.put("tags", tags_str);

			Integer return_id = getParameterAsInteger(request, "return_id");
			String return_type = ToolsKit.TypeConversionUtil.asString(request.getParameter("return_type"));
			if ("remake".equals(return_type)) {
				// 重制案例使用
				Integer remake_type = getParameterAsInteger(request, "remake_type");
				CaseRemake cr = new CaseRemake();
				cr.setId(remake_type);
				Cases cases = casesService.get(return_id);
				cases.setReturnSId(return_id);
				cases.setReturnType(return_type);
				cases.setRemakeType(remake_type);
				modelMap.put("cases", cases);
				Integer patientId = cases.getPatientId();
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientId)) {
					// 提取患者信息
					Patient patient = patientService.get(patientId);
					modelMap.put("patient", patient);
				}

				String procedureContent = cases.getProcedures();
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(procedureContent)) {
					List<LabProcedurePojo> lpList = ToolsKit.jsonUitl.toBeanList(LabProcedurePojo.class, procedureContent);
					modelMap.put("links", ToolsKit.jsonUitl.toJson(lpList));
				}

				String msg = "返回订单" + " #" + return_id + " 给技工间重制. 请在订单中写下重制的原因. ";
				modelMap.put("msg", msg);
				newType = Constans.CASES_NEWTYPE_REMAKE;
			}

			modelMap.put("CoupontPrice", judge(reqAccLabId));
			modelMap.put("newType", newType);

		} else {
			return new Exception("加载错误！");
		}
		return modelMap;
	}

	/**
	 * 
	 * @Description: 判断该技工间是否创建了对应诊所的优惠劵
	 * @author ERIC
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return ModelAndView
	 */
	public Boolean judge(Integer labId) throws Exception {
		LabCaseCoupons lcc = new LabCaseCoupons();
		lcc.setLabid(labId);
		Long count = caseCouponsService.getCountByEqual(lcc);
		return count > 0;
	}

	/**
	 * 
	 * @Title: loadTags
	 * @Description: 加载常用标签
	 * @author ERIC
	 * @date 2014-9-25下午02:27:57
	 * @return List<Object>
	 * @throws Exception
	 */
	private List<String> loadTags(Cases caseQuery) throws Exception {
		List<String> tags = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(caseQuery)) {
			tags = casesService.queryTags(caseQuery);
		}
		return tags;
	}

	/**
	 * 
	 * @Description: ？
	 * @author ERIC
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return ModelAndView
	 */
	public Object toProcedureWindow(HttpServletRequest req) {
		return null;
	}

	/**
	 * 
	 * @Description: 显示该技工间所有的订单
	 * @author ERIC
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return ModelAndView
	 */
	public Object showAllLabCases(HttpServletRequest req) throws Exception {
		Integer reqAccLabId = getParameterAsInteger(req, "reqAccLabId");
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, req);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Cases> caseList = new ArrayList<Cases>();
		PageModel pm = new PageModel();
		Cases casesQuery = new Cases();
		String utype = getSessionUserByLoginEmail().getUnitType();
		Integer unitId = getSessionUnitId();
		if (Constans.UNIT_LAB.equals(utype)) {
			casesQuery.setUnitType(1);
		} else if (Constans.UNIT_PRACTICE.equals(utype)) {
			casesQuery.setUnitType(2);
		}
		casesQuery.setPracticeId(unitId);
		casesQuery.setLabId(reqAccLabId);
		// casesQuery.setStatus(Constans.CASE_STATUS_OPEN);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(utype)) {
			caseList = casesService.queryAllLabCases(cf, casesQuery, 1, 20);
			pm = getPageModel(caseList, casesService.queryAllLabCasesCount(cf, casesQuery), 20, 1);
		}
		modelMap.put("pm", pm);
		modelMap.put("reqAccLabId", reqAccLabId);
		modelMap.put("multiFilters", cf);
		return modelMap;
	}

	/**
	 * 
	 * @Title: addData
	 * @Description: 新增
	 * @author ERIC
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 */
	@RequestMapping("/addData")
	public void addData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String newType = ToolsKit.TypeConversionUtil.asString(request.getParameter("newType"));
		Cases cases = null;
		if (Constans.CASES_NEWTYPE_ADD.equals(newType)) {
			// 直接创建订单
			cases = addCase(request, response);
		} else if (Constans.CASES_NEWTYPE_RESUME.equals(newType)) {
			// 基于草稿的建单
			cases = addCaseResume(request, response);
		} else if (Constans.CASES_NEWTYPE_REMAKE.equals(newType)) {
			// 基于订单的重制订单
			cases = addCaseRemake(request, response);
		} else if (Constans.CASES_NEWTYPE_OUTSOURCE.equals(newType)) {
			cases = addCaseOutsource(request, response);
		} else if (Constans.CASES_NEWTYPE_BASE_PATIENT.equals(newType)) {
			cases = addCaseBasePatient(request, response);
		}
		// 插日志
		try {
			LogUtil.addCasesLog(LogType.CASE_CREATE, LogLevel.GENERAL, Constans.casesNewType.get(newType),cases);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: addCaseBasePatient
	 * @Description: 基于已有患者创建订单
	 * @author ERIC
	 * @date 2014-9-15上午11:46:23
	 * @return void
	 */
	private Cases addCaseBasePatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Patient patient = new Patient();
		CaseNotes notes = new CaseNotes();
		// CaseLog log = new CaseLog();
		Date date = new Date();
		User user = getSessionUserByLoginEmail();
		// 发送方ID
		Integer unitId = getSessionUnitId();
		// 技工间向伙伴技工间下订单 接收方ID
		Integer labId = getParameterAsInteger(request, "labId");
		Integer patientId = getParameterAsInteger(request, "patientId");
		try {
			DXObject.setValue(cases, request);
			DXObject.setValue(patient, request);
			DXObject.setValue(notes, request);
			cases.setLabId(labId);
			cases.setPracticeId(unitId);
			patient.setId(patientId);
			patient.setLabId(labId);
			patient.setPracticeId(unitId);
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				cases.setUnitType(1);
				cases.setPractice(labService.get(unitId).getName());
				patient.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				cases.setUnitType(2);
				cases.setPractice(practiceService.get(unitId).getName());
				patient.setUnitType(2);
				// 设置自动跟踪(仅供诊所使用)
				if ("true".equals(user.getAutoFollowCases())) {
					cases.setIsFollow("Y");
				}
			}
			cases.setCreateDate(date);
			cases.setStatus(Constans.CASE_STATUS_OPEN);
			cases.setArrived(0);
			cases.setShipped(0);
			// 若交货日期未指定，则按规则设置
			if (ToolsKit.EmptyCheckUtil.isEmpty(cases.getDeliveryDate())) {
				// 待实现
				Date deliveryDate = computeDeliveryDate(cases);
				cases.setDeliveryDate(deliveryDate);
				// 设置发货日期
				cases.setShipDate(computeShipDate(cases));
			}
			patient.setAddDate(date);
			patient.setUpdateDate(date);
			notes.setCaseDate(cases.getCreateDate());
			notes.setCaseFor("技工间");
			notes.setCaseFrom(user.getFirstName() + user.getLastName() + "(诊所)");
			labProcedureService.setProceduresDetailed(cases, request.getParameter("procedures"));
			Response res = casesService.addDataBasePatient(cases, patient, notes);
			if (res.getStatusCode() == StatusCode.SUCCESS) {
				// log.setCaseId(cases.getCaseId());
				// log.setAccountId(user.getAccountId());
				// log.setCreateTime(cases.getCreateDate());
				// log.setOperationType("newCase");
				// log.setChanges("创建了");
				// saveCaseLog(log);
				cases.setLabId(labId);
				outJson(cases, "addCaseBasePatient", "success", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			outJson(cases, "addCaseBasePatient", "fail", response);
		}
		return cases;
	}

	/**
	 * 
	 * @Title: addCaseOutsource
	 * @Description: 外包订单生成
	 * @author ERIC
	 * @date 2014-9-11下午04:23:31
	 * @return void
	 */
	private Cases addCaseOutsource(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Patient patient = new Patient();
		CaseNotes notes = new CaseNotes();
		// CaseLog log = new CaseLog();
		Date date = new Date();
		User user = getSessionUserByLoginEmail();
		// 发送方ID
		Integer unitId = getSessionUnitId();
		// 技工间向伙伴技工间下订单 接收方ID
		Integer labId = getParameterAsInteger(request, "labId");
		try {
			DXObject.setValue(cases, request);
			DXObject.setValue(patient, request);
			DXObject.setValue(notes, request);
			cases.setLabId(labId);
			cases.setPracticeId(unitId);
			patient.setLabId(labId);
			patient.setPracticeId(unitId);
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				cases.setUnitType(1);
				cases.setPractice(labService.get(unitId).getName());
				patient.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				cases.setUnitType(2);
				cases.setPractice(practiceService.get(unitId).getName());
				patient.setUnitType(2);
				// 设置自动跟踪(仅供诊所使用)
				if ("true".equals(user.getAutoFollowCases())) {
					cases.setIsFollow("Y");
				}
			}
			cases.setCreateDate(date);
			cases.setSendToLabDate(date);
			cases.setStatus(Constans.CASE_STATUS_OPEN);
			cases.setArrived(0);
			cases.setShipped(0);
			// 若交货日期未指定，则按规则设置
			if (ToolsKit.EmptyCheckUtil.isEmpty(cases.getDeliveryDate())) {
				// 待实现
				Date deliveryDate = computeDeliveryDate(cases);
				cases.setDeliveryDate(deliveryDate);
				// 设置发货日期
				cases.setShipDate(computeShipDate(cases));
			} else {
				cases.setShipDate(cases.getDeliveryDate());
			}
			patient.setAddDate(date);
			patient.setUpdateDate(date);
			notes.setCaseDate(cases.getCreateDate());
			notes.setCaseFor("技工间");
			notes.setCaseFrom(user.getFirstName() + user.getLastName() + "(诊所)");
			labProcedureService.setProceduresDetailed(cases, request.getParameter("procedures"));
			cases.setParentId(cases.getCaseId());
			Response res = casesService.addData(cases, patient, notes);
			if (res.getStatusCode() == StatusCode.SUCCESS) {
				// log.setCaseId(cases.getCaseId());
				// log.setAccountId(user.getAccountId());
				// log.setCreateTime(cases.getCreateDate());
				// log.setOperationType("newCase");
				// log.setChanges("创建了");
				// saveCaseLog(log);
				cases.setLabId(labId);
				outJson(cases, "addCaseOutsource", "success", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			outJson(cases, "addCaseOutsource", "fail", response);
		}
		return cases;
	}

	/**
	 * 
	 * @Title: addCase
	 * @Description: 直接下订单
	 * @author ERIC
	 * @date 2014-9-3上午09:36:04
	 * @return void
	 */
	public Cases addCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Patient patient = new Patient();
		CaseNotes notes = new CaseNotes();
		// CaseLog log = new CaseLog();
		Date date = new Date();
		User user = getSessionUserByLoginEmail();
		// 发送方ID
		Integer unitId = getSessionUnitId();
		// 技工间向伙伴技工间下订单 接收方ID
		Integer labId = getParameterAsInteger(request, "labId");
		try {
			DXObject.setValue(cases, request);
			DXObject.setValue(patient, request);
			DXObject.setValue(notes, request);
			cases.setLabId(labId);
			cases.setLabName(labService.get(labId).getName());
			cases.setPracticeId(unitId);
			patient.setLabId(labId);
			patient.setPracticeId(unitId);
			notes.setUnitId(unitId);
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				cases.setUnitType(1);
				cases.setPractice(labService.get(unitId).getName());
				patient.setUnitType(1);
				notes.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				cases.setUnitType(2);
				cases.setPractice(practiceService.get(unitId).getName());
				patient.setUnitType(2);
				notes.setUnitType(2);
				// 设置自动跟踪(仅供诊所使用)
				if ("true".equals(user.getAutoFollowCases())) {
					cases.setIsFollow("Y");
				}
			}
			cases.setCreateDate(date);
			cases.setStatus(Constans.CASE_STATUS_OPEN);
			cases.setArrived(0);
			cases.setShipped(0);
			// 若交货日期未指定，则按规则设置
			if (ToolsKit.EmptyCheckUtil.isEmpty(cases.getDeliveryDate())) {
				// 待实现
				Date deliveryDate = computeDeliveryDate(cases);
				cases.setDeliveryDate(deliveryDate);
				// 设置发货日期
				cases.setShipDate(computeShipDate(cases));
			} else {
				cases.setShipDate(cases.getDeliveryDate());
			}
			patient.setAddDate(date);
			patient.setUpdateDate(date);
			notes.setCaseDate(cases.getCreateDate());
			notes.setCaseFor("技工间");
			notes.setCaseFrom(user.getFirstName() + user.getLastName() + "(诊所)");
			labProcedureService.setProceduresDetailed(cases, request.getParameter("procedures"));
			Response res = casesService.addData(cases, patient, notes);
			if (res.getStatusCode() == StatusCode.SUCCESS) {
				// log.setCaseId(cases.getCaseId());
				// log.setAccountId(user.getAccountId());
				// log.setCreateTime(cases.getCreateDate());
				// log.setOperationType("newCase");
				// log.setChanges("创建了");
				// saveCaseLog(log);
				cases.setLabId(labId);
				outJson(cases, "addData", "success", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			cases.setMsg(e.getMessage());
			outJson(cases, "addData", "fail", response);
		}
		return cases;
	}

	/**
	 * 
	 * @Title: addCaseResume
	 * @Description: 草稿提交
	 * @author ERIC
	 * @date 2014-9-3上午09:37:49
	 * @return void
	 */
	public Cases addCaseResume(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Patient patient = new Patient();
		CaseNotes notes = new CaseNotes();
		// CaseLog log = new CaseLog();
		Date date = new Date();
		User user = getSessionUserByLoginEmail();
		// 发送方ID
		Integer unitId = getSessionUnitId();
		// 技工间向伙伴技工间下订单 接收方ID
		Integer labId = getParameterAsInteger(request, "labId");
		Integer patientId = getParameterAsInteger(request, "patientId");
		try {
			DXObject.setValue(cases, request);
			DXObject.setValue(patient, request);
			DXObject.setValue(notes, request);
			cases.setLabId(labId);
			cases.setLabName(labService.get(labId).getName());
			cases.setPracticeId(unitId);
			patient.setId(patientId);
			patient.setLabId(labId);
			patient.setPracticeId(unitId);
			notes.setUnitId(unitId);
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				cases.setUnitType(1);
				cases.setPractice(labService.get(unitId).getName());
				patient.setUnitType(1);
				notes.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				cases.setUnitType(2);
				cases.setPractice(practiceService.get(unitId).getName());
				patient.setUnitType(2);
				notes.setUnitType(2);
				// 设置自动跟踪(仅供诊所使用)
				if ("true".equals(user.getAutoFollowCases())) {
					cases.setIsFollow("Y");
				}
			}
			cases.setCreateDate(date);
			cases.setStatus(Constans.CASE_STATUS_OPEN);
			cases.setArrived(0);
			cases.setShipped(0);
			// 若交货日期未指定，则按规则设置
			if (ToolsKit.EmptyCheckUtil.isEmpty(cases.getDeliveryDate())) {
				// 待实现
				Date deliveryDate = computeDeliveryDate(cases);
				cases.setDeliveryDate(deliveryDate);
				// 设置发货日期
				cases.setShipDate(computeShipDate(cases));
			}
			patient.setAddDate(date);
			patient.setUpdateDate(date);
			notes.setCaseDate(cases.getCreateDate());
			notes.setCaseFor("技工间");
			notes.setCaseFrom(user.getFirstName() + user.getLastName() + "(诊所)");
			labProcedureService.setProceduresDetailed(cases, request.getParameter("procedures"));
			Response res = casesService.updateResumeData(cases, patient, notes);
			if (res.getStatusCode() == StatusCode.SUCCESS) {
				// log.setCaseId(cases.getCaseId());
				// log.setAccountId(user.getAccountId());
				// log.setCreateTime(cases.getCreateDate());
				// log.setOperationType("newCase");
				// log.setChanges("创建了");
				// saveCaseLog(log);
				cases.setLabId(labId);
				outJson(cases, "addCaseResume", "success", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			cases.setMsg(e.getMessage());
			outJson(cases, "addCaseResume", "fail", response);
		}
		return cases;
	}

	/**
	 * 
	 * @Title: addCaseRemake
	 * @Description: 重制订单
	 * @author ERIC
	 * @date 2014-9-9下午04:25:31
	 * @return void
	 */
	private Cases addCaseRemake(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Cases sourceCases = new Cases();
		Patient patient = new Patient();
		CaseNotes notes = new CaseNotes();
		// CaseLog log = new CaseLog();
		Date date = new Date();
		User user = getSessionUserByLoginEmail();
		// 发送方ID
		Integer unitId = getSessionUnitId();
		// 技工间向伙伴技工间下订单 接收方ID
		Integer labId = getParameterAsInteger(request, "labId");
		try {
			DXObject.setValue(cases, request);
			DXObject.setValue(patient, request);
			DXObject.setValue(notes, request);
			cases.setLabId(labId);
			cases.setLabName(labService.get(labId).getName());
			cases.setPracticeId(unitId);
			patient.setLabId(labId);
			patient.setPracticeId(unitId);
			notes.setUnitId(unitId);
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				cases.setUnitType(1);
				cases.setPractice(labService.get(unitId).getName());
				patient.setUnitType(1);
				notes.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				cases.setUnitType(2);
				cases.setPractice(practiceService.get(unitId).getName());
				patient.setUnitType(2);
				notes.setUnitType(2);
				// 设置自动跟踪(仅供诊所使用)
				if ("true".equals(user.getAutoFollowCases())) {
					cases.setIsFollow("Y");
				}
			}
			cases.setCreateDate(date);
			cases.setStatus(Constans.CASE_STATUS_OPEN);
			cases.setArrived(0);
			cases.setShipped(0);
			// 若交货日期未指定，则按规则设置
			if (ToolsKit.EmptyCheckUtil.isEmpty(cases.getDeliveryDate())) {
				// 待实现
				Date deliveryDate = computeDeliveryDate(cases);
				cases.setDeliveryDate(deliveryDate);
				// 设置发货日期
				cases.setShipDate(computeShipDate(cases));
			} else {
				cases.setShipDate(cases.getDeliveryDate());
			}
			patient.setAddDate(date);
			patient.setUpdateDate(date);
			notes.setCaseDate(cases.getCreateDate());
			notes.setCaseFor("技工间");
			notes.setCaseFrom(user.getFirstName() + user.getLastName() + "(诊所)");
			labProcedureService.setProceduresDetailed(cases, request.getParameter("procedures"));

			if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getReturnSId())) {
				sourceCases = casesService.get(cases.getReturnSId());
				sourceCases.setRemakeType(cases.getRemakeType());
				sourceCases.setReturnType("remake");
			}
			// cases.setRemakeType(null);
			// cases.setReturnType(null);

			Response res = casesService.addRemakeData(sourceCases, cases, patient, notes);
			if (res.getStatusCode() == StatusCode.SUCCESS) {
				// log.setCaseId(cases.getCaseId());
				// log.setAccountId(user.getAccountId());
				// log.setCreateTime(cases.getCreateDate());
				// log.setOperationType("newCase");
				// log.setChanges("创建了");
				// saveCaseLog(log);
				cases.setLabId(labId);
				outJson(cases, "addCaseRemake", "success", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			cases.setMsg(e.getMessage());
			outJson(cases, "addCaseRemake", "fail", response);
		}
		return cases;
	}

	

	/**
	 * 
	 * @Title: addDataAsDraft
	 * @Description: 保存订单为草稿状态(需保存哪些信息，还需研究)
	 * @author ERIC
	 * @date 2014-7-21下午03:10:47
	 * @return void
	 */
	@RequestMapping("/addDataAsDraft")
	public void addDataAsDraft(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Patient patient = new Patient();
		CaseNotes notes = new CaseNotes();
		CaseLog log = new CaseLog();
		Date date = new Date();
		User user = getSessionUserByLoginEmail();
		Integer labId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("labId"));
		Integer unitId = getSessionUnitId();
		try {
			DXObject.setValue(cases, request);
			DXObject.setValue(patient, request);
			DXObject.setValue(notes, request);
			cases.setLabId(labId);
			cases.setLabName(labService.get(labId).getName());
			cases.setPracticeId(unitId);
			patient.setLabId(labId);
			patient.setPracticeId(unitId);
			notes.setUnitId(unitId);
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				cases.setUnitType(1);
				cases.setPractice(labService.get(unitId).getName());
				patient.setUnitType(1);
				notes.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				cases.setUnitType(2);
				cases.setPractice(practiceService.get(unitId).getName());
				patient.setUnitType(2);
				notes.setUnitType(2);
				// 设置自动跟踪(仅供诊所使用)
				if ("true".equals(user.getAutoFollowCases())) {
					cases.setIsFollow("Y");
				}
			}
			cases.setCreateDate(new Date());
			cases.setStatus(Constans.CASE_STATUS_OPEN);
			cases.setIsDraft("Y");
			cases.setArrived(0);
			cases.setShipped(0);
			// 若交货日期未指定，则按规则设置
			if (ToolsKit.EmptyCheckUtil.isEmpty(cases.getDeliveryDate())) {
				// 待实现
				Date deliveryDate = computeDeliveryDate(cases);
				cases.setDeliveryDate(deliveryDate);
			}
			patient.setAddDate(date);
			patient.setUpdateDate(date);
			notes.setCaseDate(cases.getCreateDate());
			notes.setCaseFor("技工间");
			notes.setCaseFrom(user.getFirstName() + user.getLastName() + "(诊所)");
			labProcedureService.setProceduresDetailed(cases, request.getParameter("procedures"));
			Response res = casesService.addData(cases, patient, notes);
			if (res.getStatusCode() == StatusCode.SUCCESS) {
				/*
				 * log.setCaseId(cases.getCaseId());
				 * log.setAccountId(user.getAccountId());
				 * log.setCreateTime(cases.getCreateDate());
				 * log.setOperationType("newCase"); saveCaseLog(log);
				 */
				cases.setLabId(labId);
				outJson(cases, "addDataAsDraft", "success", response);
				// 插日志
				try {
					LogUtil.addCasesLog(LogType.CASE_CREATE, LogLevel.GENERAL, Constans.casesNewType.get(Constans.CASES_NEWTYPE_RESUME),cases);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			cases.setMsg(e.getMessage());
			outJson(cases, "addDataAsDraft", "fail", response);
		}

	}

	/**
	 * 
	 * @Title: getDataById
	 * @Description: 获取单个订单详情
	 * @author ERIC
	 * @date 2014-7-18上午09:30:06
	 * @return ModelAndView
	 */
	@RequestMapping("/getDataById")
	public ModelAndView getDataById(HttpServletRequest req) throws Exception {
		Integer caseId = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("caseId"));
		Cases cases = casesService.get(caseId);
		return getCasesDataById(cases);
	}

	/**
	 * 
	 * @Title: getDataById
	 * @Description: 通用获取订单详细页面的数据
	 * @author ERIC
	 * @date 2014-7-25上午10:36:40
	 * @return ModelAndView
	 */
	public ModelAndView getCasesDataById(Cases obj) throws Exception {
		Lab lab = new Lab();
		Cases cases = new Cases();
		Patient patient = new Patient();
		CaseDetails details = new CaseDetails();
		CaseNotes notes = new CaseNotes();
		// CaseLog log = new CaseLog();
		CaseAttachs attachs = new CaseAttachs();
		List<CaseDetails> detailList = null;
		List<LabProceduresCharacteris> enclourseList = new ArrayList<LabProceduresCharacteris>();
		PageModel notePm = null;
		// PageModel logPm = null;
		List<CaseAttachs> attachsList = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		MyModelAndView mmav = new MyModelAndView();
		try {
			Integer caseId = ToolsKit.TypeConversionUtil.asInteger(obj.getCaseId());
			Integer labId = ToolsKit.TypeConversionUtil.asInteger(obj.getLabId());
			Integer patientId = ToolsKit.TypeConversionUtil.asInteger(obj.getPatientId());
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
				lab = labService.get(labId);
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(caseId)) {
				cases = casesService.get(caseId);
				details.setCaseId(caseId);
				notes.setCaseId(caseId);
				// log.setCaseId(caseId);
				attachs.setCaseId(caseId);
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientId)) {
				patient = patientService.get(patientId);
			}
			String enclosurestr = cases.getEnclosures();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(enclosurestr)) {
				LabProceduresCharacteris lpc = new LabProceduresCharacteris();
				lpc.setType("enclosures");
				String[] str = enclosurestr.split(",");
				List<Integer> ids = new ArrayList<Integer>();
				for (String s : str) {
					Integer ss = ToolsKit.TypeConversionUtil.asInteger(s);
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(ss)) {
						ids.add(ss);
					}
				}
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(ids)) {
					enclourseList = characterisService.queryCharacterisByIds(lpc, ids);
				}
				modelMap.put("enclourses", enclourseList);
			}

			CaseRemake cr = new CaseRemake();
			cr.setLabid(cases.getLabId());
			List<CaseRemake> caseRemakeList = caseRemakeService.listAllByEqual(cr, 0, 0);
			modelMap.put("caseRemakeList", caseRemakeList);

			String returnType = cases.getReturnType();
			if ("remake".equals(returnType)) {
				CaseRemake crk = caseRemakeService.get(cases.getRemakeType());
				cases.setRemakeTypeNam(crk.getName());
			}

			detailList = detailsService.queryDetailsByCriteria(details);
			notePm = notesService.queryNotesByCriteria(notes);

			DDXLog log = new DDXLog();
			log.setPrimaryId(caseId);
			List<DDXLog> logList = logService.listAllByEqual(log, 0, 0);
			PageModel logPm = new PageModel();
			logPm.setDatas(logList);

			attachsList = caseAttachsService.queryAttachsByCriteria(attachs);

			// 获取比色卡数据
			modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
			modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());
			
			// 伙伴技工间提供的权限
			Permissions per = getLabPermissions(labId);
			// 提供的订单权限
			modelMap.put("financesPermissions", per.getFinances());
			// 提供的财政权限
			modelMap.put("casesPermissions", per.getCases());

			modelMap.put("listPartnerLabs", getPartnerLabList());
			/* modelMap.put("gotoLab", lab); */
			modelMap.put("requestAccountLab", lab);

			User user = getSessionUserByLoginEmail();

			// 有下订单的权限
			if (per.getCases().isNewCase()) {
				// 向接收方下订单的协议
				CaseTerms ct = new CaseTerms();
				ct.setLabid(labId);
				List<CaseTerms> terms = termsService.listAllByEqual(ct, 0, 0);
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(terms)) {
					ct = terms.get(0);
					modelMap.put("caseTerms", ct);
				}
				// 获取比色卡数据
				modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
				modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());
				modelMap.put("user", user);
			}

			Integer unitId = getSessionUnitId();
			Object practice = null;
			if (user.getUnitType().equals(Constans.UNIT_PRACTICE)) {
				practice = practiceService.get(unitId);
			} else {
				practice = labService.get(unitId);
			}
			
			// 获取tags
			Cases caseQuery = new Cases();
			caseQuery.setLabId(labId);
			caseQuery.setPracticeId(unitId);
			caseQuery.setUnitType(new Integer(user.getUnitType()));
			List<String> tags = loadTags(caseQuery);
			String tags_str = tags.toString().substring(1);
			tags_str = tags_str.substring(0, tags_str.length() - 1);
			modelMap.put("tags", tags_str);
			
			modelMap.put("thisPractice", practice);
			modelMap.put("cases", cases);
			modelMap.put("patient", patient);
			modelMap.put("detailList", detailList);
			modelMap.put("notePm", notePm);
			modelMap.put("logListPm", logPm);
			modelMap.put("attachsList", attachsList);
			modelMap.put("proceduresList", labProcedureService.getProceduresDetailed(cases));
			modelMap.put("user", getSessionUserByLoginEmail());
		} catch (Exception e) {
			throw e;
		}
		return mmav.setViewName("practice/practice_Case_Details").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: updateData
	 * @Description: 修改
	 * @author ERIC
	 * @date 2014-6-11下午02:16:42
	 * @param
	 * @return void
	 */
	@RequestMapping("/updateData")
	public void updateData() {

	}

	/**
	 * 
	 * @Title: loadTabInfo
	 * @Description: 加载订单详情、笔记、日志
	 * @author ERIC
	 * @date 2014-7-19下午03:31:09
	 * @return void
	 */
	public void loadTabInfo(HttpServletRequest req) {
		Cases cases = new Cases();
		DXObject.setValue(cases, req);
		String type = req.getParameter("type");
		if ("detail".equals(type)) {// 制作详情

		} else if ("note".equals(type)) {// 订单笔记

		} else if ("log".equals(type)) {// 订单日志

		}

	}

	/**
	 * 
	 * @Title: selectDataForAccurate
	 * @Description: 持有类型分页查询
	 * @author ERIC
	 * @date 2014-6-11下午02:19:57
	 * @param
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/listOnHoldTypes")
	public ModelAndView listOnHoldTypes(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Integer labId = getSessionUserByLoginEmail().getLabId();
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = req.getParameter("search");
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		CaseHold ch = new CaseHold();
		ch.setLabId(labId);
		ch.setName(search);
		// 每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		List<CaseHold> datas = chservice.listAllByLike(ch, pageNo, pageSize);
		PageModel pm = getPageModel(datas, chservice.getCountByLike(ch), pageSize, pageNo);
		return new MyModelAndView().setViewName("lab/lab_DDXDentalPractice_CaseSetting_General_OnHoldTypes").addObject("datas", pm)
				.addObject("search", search);
	}

	@RequestMapping("/listDisplayCategories")
	public ModelAndView listDisplayCategories(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer labId = getSessionUserByLoginEmail().getLabId();
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = req.getParameter("search");
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		ProcedureDisplayCategory lp = new ProcedureDisplayCategory();
		lp.setLabId(labId);
		lp.setName(search);
		// 每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		List<ProcedureDisplayCategory> datas = procedureDisplayCategoryService.listAllByLike(lp, pageNo, pageSize);

		PageModel pm = getPageModel(datas, procedureDisplayCategoryService.getCountByLike(lp), pageSize, pageNo);

		return new MyModelAndView().setViewName("lab/lab_DDXDentalPractice_CaseSetting_Procedures_DisplayCategories")
				.addObject("datas", pm).addObject("search", search);
	}

	@RequestMapping("/listCoupons")
	public ModelAndView listCoupons(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer labId = getSessionUserByLoginEmail().getLabId();
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = req.getParameter("search");
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		LabCaseCoupons lcc = new LabCaseCoupons();
		lcc.setLabid(labId);
		lcc.setPrefix(search);
		// 每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		List<LabCaseCoupons> datas = caseCouponsService.listAllByLike(lcc, pageNo, pageSize);

		PageModel pm = getPageModel(datas, caseCouponsService.getCountByLike(lcc), pageSize, pageNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", pm);
		return new MyModelAndView().setViewName("lab/lab_DDXDentalPractice_CaseSetting_Coupons_DDXCoupons").addObject("datas", map)
				.addObject("search", search);
	}

	@RequestMapping("listOnShipping")
	public ModelAndView listOnShipping(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer labId = getSessionUserByLoginEmail().getLabId();
		String search = req.getParameter("search");
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		CaseShipping cs = new CaseShipping();
		cs.setLabId(labId);
		cs.setCompany(search);
		cs.setService(search);
		// 每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		List<CaseShipping> datas = casesShippingService.listAllByLike(cs, pageNo, pageSize);

		PageModel pm = getPageModel(datas, casesShippingService.getCountByLike(cs), pageSize, pageNo);

		return new MyModelAndView().setViewName("lab/lab_DDXDentalPractice_CaseSetting_General_ShippingTypes").addObject("datas", pm)
				.addObject("search", search);
	}

	@RequestMapping("listCaseRemake")
	public ModelAndView listCaseRemake(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer labId = getSessionUserByLoginEmail().getLabId();
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = req.getParameter("search");
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		CaseRemake caseRemake = new CaseRemake();
		caseRemake.setLabid(labId);
		caseRemake.setName(search);
		Integer pageSize = 10;
		List<CaseRemake> datas = caseRemakeService.listAllByLike(caseRemake, pageNo, pageSize);
		PageModel pm = getPageModel(datas, caseRemakeService.getCountByLike(caseRemake), pageSize, pageNo);
		return new MyModelAndView().setViewName("lab/lab_DDXDentalPractice_CaseSetting_General_RemakeTypes").addObject("datas", pm)
				.addObject("search", search);
	}

	/**
	 * 
	 * @Title: gotoUpload
	 * @Description: 跳转到上传页面
	 * @author ERIC
	 * @date 2014-7-22上午09:56:47
	 * @return ModelAndView
	 */
	@RequestMapping("gotoUpload")
	public ModelAndView gotoUpload(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer caseId = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("caseId"));
		Cases cases = casesService.get(caseId);
		modelMap.put("cases", cases);
		return new MyModelAndView().setViewName("u_lab/u_lab_Dashboard_PartnerLabs_cases_upload").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: upload
	 * @Description: 批量上传文件
	 * @author ERIC
	 * @date 2014-7-22下午04:05:27
	 * @return void
	 */
	@RequestMapping("upload")
	public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CaseAttachs caseAttachs = new CaseAttachs();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Integer caseId = ToolsKit.TypeConversionUtil.asInteger(multipartRequest.getParameter("caseId"));

		caseAttachs.setCaseId(caseId);
		caseAttachs.setCaseDate(new Date());

		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		MultipartFile multipartFile = null;
		for (Map.Entry<String, MultipartFile> set : fileMap.entrySet()) {
			multipartFile = set.getValue();//
		}
		caseAttachs = this.storeIOc(multipartRequest, multipartFile, caseAttachs);
		outJson(caseAttachs, "upload", "success", response);
	}

	// 接受图片，返回图片地址
	private CaseAttachs storeIOc(HttpServletRequest request, MultipartFile file, CaseAttachs caseAttachs) {
		if (file == null) {
			return null;
		}

		String fileName = "";
		String logImageName = "";
		String filePath = "";
		if (file.isEmpty()) {
			System.out.println("文件未上传");
		} else {
			String _fileName = file.getOriginalFilename();
			String suffix = _fileName.substring(_fileName.lastIndexOf("."));
			// /**使用UUID生成文件名称**/
			logImageName = UUID.randomUUID().toString() + suffix;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Date nowdate = new Date();
			String dstr = sdf.format(nowdate) + (int) Math.round(Math.random() * 1000);
			int year = 1900 + nowdate.getYear();

			String fileSavePath = Constans.FILE_DOWNLAOD_PATH + "\\casesAttach\\" + year + "\\";
			ToolsKit.FileUtil.createDir(fileSavePath);
			fileName = fileSavePath + logImageName;
			filePath = "/casesAttach/" + year + "/" + logImageName;
			File restore = new File(fileName);
			try {
				caseAttachs.setFileName(_fileName);
				caseAttachs.setFilePath(filePath);
				file.transferTo(restore);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return caseAttachs;
	}

	/**
	 * 
	 * @Title: addAttachInfo
	 * @Description: 保存上传文件信息
	 * @author ERIC
	 * @date 2014-7-23上午09:49:05
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("addAttachInfo")
	public void addAttachInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CaseAttachs caseAttachs = new CaseAttachs();
		// CaseLog log = new CaseLog();
		DXObject.setValue(caseAttachs, request);
		// DXObject.setValue(log, request);
		caseAttachs.setCaseDate(new Date());
		User user = getSessionUserByLoginEmail();
		String uniteType = user.getUnitType();
		Cases cases = casesService.get(caseAttachs.getCaseId());
		// 下单机构类型
		String caseType = cases.getUnitType().toString();
		if (Constans.UNIT_PRACTICE.equals(caseType)) {
			caseAttachs.setCaseFrom((ToolsKit.EmptyCheckUtil.isEmpty(user.getSalutation()) ? "" : user.getSalutation())
					+ user.getFirstName() + user.getLastName() + "(" + (!Constans.UNIT_PRACTICE.equals(uniteType) ? "技工间" : "诊所") + ")");
		}
		if (Constans.UNIT_LAB.equals(caseType)) {
			caseAttachs.setCaseFrom((ToolsKit.EmptyCheckUtil.isEmpty(user.getSalutation()) ? "" : user.getSalutation())
					+ user.getFirstName() + user.getLastName() + "("
					+ (!(Constans.UNIT_LAB.equals(uniteType) && cases.getPracticeId().equals(user.getLabId())) ? "诊所" : "技工间") + ")");
		}
		caseAttachsService.add(caseAttachs);
		// log.setOperationType("updatedCase");
		// log.setChanges("&nbsp;&nbsp;添加了文件&nbsp;" + caseAttachs.getFileName()
		// + "&nbsp;");

		outReturnString("success", response);
		// 插日志
		try {
			LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.WARNING, "添加了文件："+caseAttachs.getFileName(),cases);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: applyPatientAppointment
	 * @Description: 更新患者预约日期
	 * @author ERIC
	 * @date 2014-7-24上午11:32:30
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("applyPatientAppointment")
	public void applyPatientAppointment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flag = "success";
		Cases cases0 = new Cases();
		Cases cases = new Cases();
		DXObject.setValue(cases0, request);
		String patAppDate = ToolsKit.TypeConversionUtil.asString(request.getParameter("patAppDate"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		cases = casesService.get(cases0.getCaseId());
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(patAppDate)) {
			cases.setPatAppDate(sdf.parse(patAppDate));
			casesService.update(cases);
		} else {
			flag = "fail";
		}

		outJson(null, "applyPatientAppointment", flag, response);
	}

	/**
	 * 
	 * @Title: applyCaseArrive
	 * @Description: 更新订单到达日期
	 * @author ERIC
	 * @date 2014-8-29上午10:35:48
	 * @return void
	 */
	@RequestMapping("applyCaseArrive")
	public void applyCaseArrive(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer caseId = getParameterAsInteger(request, "caseId");
		String arriveDateStr = ToolsKit.TypeConversionUtil.asString(request.getParameter("arriveDate"));
		Date arriveDate = ToolsKit.DateUtil.parse(arriveDateStr);
		Cases cases = new Cases();
		cases = casesService.get(caseId);
		cases.setArriveDate(arriveDate);
		cases.setArrived(1);
		cases.setLastUpdateDate(new Date());
		casesService.update(cases);
		outJson(null, "applyCaseArrive", "success", response);
		LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.EVENTS, "已抵达",cases);
	}

	/**
	 * 
	 * @Title: cancelCases
	 * @Description: 取消订单
	 * @author ERIC
	 * @date 2014-7-24下午02:31:46
	 * @return void
	 */
	@RequestMapping("cancelCases")
	public void cancelCases(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flag = "fail";
		Cases cases = new Cases();
		Integer reqAccLabId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("reqAccLabId"));
		DXObject.setValue(cases, request);
		cases = casesService.get(cases.getCaseId());
		if (Constans.CASE_STATUS_CANCEL.equals(cases.getStatus())) {
			cases.setMsg("此订单已取消");
		} else if (Constans.CASE_STATUS_OPEN.equals(cases.getStatus())) {
			User user = getSessionUserByLoginEmail();
			cases.setCancelledBy(user.getFirstName() + user.getLastName());
			cases.setCancelledDate(new Date());
			cases.setStatus(Constans.CASE_STATUS_CANCEL);
			casesService.update(cases);
			flag = "success";
			LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.WARNING, "取消了订单",cases);
		}
		cases.setLabId(reqAccLabId);
		outJson(cases, "cancelCases", flag, response);
	}

	/**
	 * 
	 * @Title: overview
	 * @Description: 伙伴技工间概况页面
	 * @author ERIC
	 * @date 2014-7-24下午03:17:37
	 * @return ModelAndView
	 */
	@RequestMapping("overview")
	public ModelAndView overview(HttpServletRequest request) throws Exception {
		MyModelAndView mmav = new MyModelAndView();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Lab reqAccLab = null;

		Integer labId = ToolsKit.TypeConversionUtil.asInteger(request.getAttribute("reqAccLabId"));
		if (labId == null) {// 判断是否为action中请求跳转 还是 页面间请求跳转
			labId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("labId"));
		}

		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
			reqAccLab = labService.get(labId);
		}

		User user = getSessionUserByLoginEmail();
		String unitType = user.getUnitType();
		if (Constans.UNIT_PRACTICE.equals(unitType)) {
			Practice practice = (Practice) getSessionUnit();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(practice.getProviders())) {
				List<User> providers = userService.ListUser(practice.getProviders());
				modelMap.put("providers", providers);
			}
		}

		// 伙伴技工间提供的权限
		Permissions per = getLabPermissions(labId);

		Cases caseQuery = new Cases();
		caseQuery.setLabId(labId);
		caseQuery.setPracticeId(getSessionUnitId());
		// caseQuery.setPartnerLabId(labId);
		PageModel casesTryInPm = casesService.listCaseTryIn(caseQuery);
		PageModel casesShipPm = casesService.listCaseShipToday(caseQuery);
		PageModel casesArrivePm = casesService.listCaseArriveToday(caseQuery);

		modelMap.put("casesTryInPm", casesTryInPm);
		modelMap.put("casesShipPm", casesShipPm);
		modelMap.put("casesArrivePm", casesArrivePm);

		// 提供的订单权限
		modelMap.put("financesPermissions", per.getFinances());
		// 提供的财政权限
		modelMap.put("casesPermissions", per.getCases());

		if (per.getCases().isNewCase()) {
			// 获取比色卡数据
			modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
			modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());
		}

		// 向接收方下订单的协议
		CaseTerms ct = new CaseTerms();
		ct.setLabid(labId);
		List<CaseTerms> terms = termsService.listAllByEqual(ct, 0, 0);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(terms)) {
			ct = terms.get(0);
			modelMap.put("caseTerms", ct);
		}
		modelMap.put("user", user);
		modelMap.put("thisLab", getSessionUnit());
		modelMap.put("requestAccountLab", reqAccLab);
		modelMap.put("listPartnerLabs", getPartnerLabList());
		return mmav.setViewName("u_lab/u_lab_Cases_Overview").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: rescheduleSendDate
	 * @Description: 重新安排订单发出日期
	 * @author ERIC
	 * @date 2014-7-25上午10:12:17
	 * @return ModelAndView
	 */
	@RequestMapping("rescheduleSendDate")
	public void rescheduleSendDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases0 = new Cases();
		Cases cases = new Cases();
		try {
			DXObject.setValue(cases0, request);
			cases = casesService.get(cases0.getCaseId());
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases0.getSendToLabDate())) {
				cases.setSendToLabDate(cases0.getSendToLabDate());
			} else {
				cases.setSendToLabDate(new Date());
			}

			casesService.update(cases);
		} catch (Exception e) {
			e.printStackTrace();
		}
		outJson(cases, "rescheduleSendDate", "success", response);
	}

	/**
	 * 
	 * @Title: loadNaviData
	 * @Description: 加载导航条数据
	 * @author ERIC
	 * @date 2014-7-25上午10:24:54
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String, Object> loadNaviData(Integer labId) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Lab reqAccLab = null;
		Lab lab = null;
		List<LabProceduresCharacteris> enclosuresList = null;
		List<ProcedureDisplayCategory> displayCategoryList = null;
		List<LabProcedure> procedureList = null;
		LabProceduresCharacteris characteris = new LabProceduresCharacteris();
		ProcedureDisplayCategory displayCategory = new ProcedureDisplayCategory();
		LabProcedure labProcedure = new LabProcedure();

		lab = getSessionLab();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
			reqAccLab = labService.get(labId);
			characteris.setLabId(reqAccLab.getId());
			characteris.setType("enclosures");
			displayCategory.setLabId(reqAccLab.getId());
			labProcedure.setLabId(reqAccLab.getId());
			enclosuresList = characterisService.listAllEnclosuresByLab(characteris);
			displayCategoryList = displayCategoryService.listAllProDispCategoryByCriteria(displayCategory);
			procedureList = labProcedureService.getProedureByCriteria(labProcedure);
			// 附件
			modelMap.put("enclosuresList", enclosuresList);
			// 工序显示
			modelMap.put("displayCategoryList", displayCategoryList);
			// 工序
			modelMap.put("procedureList", procedureList);
		}

		// 伙伴技工间提供的权限
		Permissions per = getLabPermissions(labId);

		// 提供的订单权限
		modelMap.put("financesPermissions", per.getFinances());
		// 提供的财政权限
		modelMap.put("casesPermissions", per.getCases());

		modelMap.put("thisLab", lab);
		modelMap.put("requestAccountLab", reqAccLab);
		modelMap.put("listPartnerLabs", getPartnerLabList());
		return modelMap;
	}

	/**
	 * 
	 * @Title: toCreateCaseForPatient
	 * @Description: 跳转到为患者创建订单页面
	 * @author ERIC
	 * @date 2014-7-25下午03:17:59
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("toCreateCaseForPatient")
	public ModelAndView toCreateCaseForPatient(HttpServletRequest request) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 伙伴技工间ID
		Integer labId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("labId"));
		Patient patient = new Patient();
		DXObject.setValue(patient, request);
		modelMap = loadNaviData(labId);
		modelMap.put("patient", patient);

		String unitType = getSessionUserByLoginEmail().getUnitType();
		if (Constans.UNIT_PRACTICE.equals(unitType)) {
			Practice practice = (Practice) getSessionUnit();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(practice.getProviders())) {
				List<User> providers = userService.ListUser(practice.getProviders());
				modelMap.put("providers", providers);
			}
		}

		// 加载工序特征
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
			LabProceduresCharacteris characteris = new LabProceduresCharacteris();
			characteris.setLabId(labId);
			characteris.setType("enclosures");
			List<LabProceduresCharacteris> enclosuresList = characterisService.listAllEnclosuresByLab(characteris);
			// 附件
			modelMap.put("enclosuresList", enclosuresList);
			modelMap.put("proOption", labProcedureService.getProedureAsHtml(labId));
			modelMap.put("user", getSessionUserByLoginEmail());

			// 向接收方下订单的协议
			CaseTerms ct = new CaseTerms();
			ct.setLabid(labId);
			List<CaseTerms> terms = termsService.listAllByEqual(ct, 0, 0);
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(terms)) {
				ct = terms.get(0);
				modelMap.put("caseTerms", ct);
			}

			// 伙伴技工间提供的权限
			Permissions per = getLabPermissions(labId);
			// 提供的订单权限
			modelMap.put("casesPermissions", per.getCases());

			// 获取比色卡数据
			modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
			modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());
		}

		modelMap.put("newType", Constans.CASES_NEWTYPE_BASE_PATIENT);
		Cases cases = new Cases();
		cases.setSendToLabDate(new Date());
		modelMap.put("cases", cases);

		return new MyModelAndView().setViewName("u_practice/newCase").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: loadProByRequestLabId
	 * @Description: 获取合作技工间的工序
	 * @author ERIC
	 * @date 2014-8-4下午01:09:28
	 * @return ModelAndView
	 */
	@RequestMapping("/loadProByRequestLabId")
	public void loadProByRequestLabId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer requestId = getParameterAsInteger(request, "requestLabId");
		outReturnString(labProcedureService.getProedureAsHtml(requestId), response);
	}

	/**
	 * 
	 * @Title: listCasesByMonth
	 * @Description: 按月份查询订单
	 * @author ERIC
	 * @date 2014-8-4下午01:09:28
	 * @return ModelAndView
	 */
	@RequestMapping("/listCasesByMonth")
	public ModelAndView listCasesByMonth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		Integer year = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("year"));
		Integer month = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("month"));
		CasesFilter cf = new CasesFilter();
		cf.setYear(year);
		cf.setMonth(month);
		Cases caseQuery = new Cases();
		caseQuery.setLabId(getSessionLab().getId());
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		// 每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		Map<String, Object> map = new HashMap<String, Object>();
		List<Cases> casesList = casesService.listCaseByMonth(cf, caseQuery, pageNo, pageSize);

		PageModel pm = getPageModel(casesList, casesService.getCaseCountByMonth(cf, caseQuery), pageSize, pageNo);
		map.put("year", year);
		map.put("month", month);
		map.put("casesList", pm);

		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_ByMonth_list").addObject("datas", map);
	}

	/**
	 * 
	 * @Title: listCases
	 * @Description: 当前技工间外包给伙伴技工间的所有订单
	 * @author ERIC
	 * @date 2014-8-4下午01:10:27
	 * @return ModelAndView
	 */
	@RequestMapping("/listCases")
	public ModelAndView listCases(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		Integer reqAccLabId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("reqAccLabId"));

		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		// 每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		Cases cases = new Cases();
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);

		String utype = getSessionUserByLoginEmail().getUnitType();
		Integer unitId = getSessionUnitId();
		if (Constans.UNIT_LAB.equals(utype)) {
			cases.setUnitType(1);
		} else if (Constans.UNIT_PRACTICE.equals(utype)) {
			cases.setUnitType(2);
		}
		cases.setPracticeId(unitId);
		cases.setLabId(reqAccLabId);
		PageModel pm = new PageModel();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(utype)) {
			List<Cases> casesList = casesService.queryAllLabCases(cf, cases, pageNo, pageSize);
			pm = getPageModel(casesList, casesService.queryAllLabCasesCount(cf, cases), pageSize, pageNo);
		}

		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_ListCases_show").addObject("pm", pm)
				.addObject("reqAccLabId", reqAccLabId).addObject("multiFilters", cf);
	}

	/**
	 * 
	 * @Title: listCaseUnderDraft
	 * @Description: 处于草稿状态的订单
	 * @author ERIC
	 * @date 2014-8-4下午01:28:38
	 * @return void
	 */
	public void listCaseUnderDraft(HttpServletRequest request) {
		Cases caseQuery = new Cases();
		List<Cases> casesList = new ArrayList<Cases>();
		DXObject.setValue(caseQuery, request);
		caseQuery.setIsDraft("Y");
	}

	/**
	 * 
	 * @Title: listCaseArriveToday
	 * @Description: 当日有望到达的订单（伙伴技工间发出）
	 * @author ERIC
	 * @date 2014-8-4下午01:15:04
	 * @return void
	 */
	public void listCaseArriveToday() {
		PageModel pm = new PageModel();

	}

	/**
	 * 
	 * @Title: listCaseShipToday
	 * @Description: 当日计划发给伙伴技工间的订单
	 * @author ERIC
	 * @date 2014-8-4下午01:18:19
	 * @return void
	 */
	public void listCaseShipToday() {

	}

	/**
	 * 
	 * @Title: listCaseTryInsInProgress
	 * @Description: 当前处于伙伴技工间制造中的用于试戴的订单
	 * @author ERIC
	 * @date 2014-8-4下午01:25:15
	 * @return void
	 */
	public void listCaseTryInsInProgress() {

	}

	/**
	 * 
	 * @Title: confirmDeliveryDate
	 * @Description: 确认返回日期
	 * @author ERIC
	 * @date 2014-8-4下午06:25:07
	 * @return void
	 */
	@RequestMapping("/confirmDeliveryDate")
	public void confirmDeliveryDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "失败");
		Cases cases = new Cases();
		Cases cases0 = new Cases();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		DXObject.setValue(cases, request);
		cases0 = casesService.get(cases.getCaseId());
		if (null == cases0.getConfirmedReturnDay() || new Integer(0).equals(cases0.getConfirmedReturnDay())) {
			cases0.setConfirmedReturnDay(1);
			result.setInfo("确认日期");
		} else {
			cases0.setConfirmedReturnDay(0);
			result.setInfo("解除确认日期");
		}
		casesService.update(cases0);
		result.setResult(Booleans.TRUE);
		outJson(result, "confirmDeliveryDate", "success", response);

	}

	/**
	 * 
	 * @Title: confirmDeliveryDate
	 * @Description:ddx优惠劵视图
	 * @author ERIC
	 * @date 2014-8-4下午06:25:07
	 * @return void
	 */
	@RequestMapping("/CouponsView")
	public ModelAndView CouponsView(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));

		ModelAndView m = new ModelAndView("lab/lab_Settings_CaseSetting_Coupons_View");
		LabCaseCoupons caseCoupons = caseCouponsService.get(id);
		Map<String, Object> map = new HashMap<String, Object>();

		if (ToolsKit.EmptyCheckUtil.isNotEmpty(caseCoupons.getProceduresid())) {
			map.put("lpdatas", labProcedureService.get(caseCoupons.getProceduresid()));
		}
		map.put("caseCoupons", caseCoupons);
		if (Constans.UNIT_LAB.equals(caseCoupons.getUnittype())) {
			map.put("unitType", Constans.UNIT_LAB);
			map.put("unit", labService.get(caseCoupons.getUnitid()));
		} else if (Constans.UNIT_PRACTICE.equals(caseCoupons.getUnittype())) {
			map.put("unitType", Constans.UNIT_PRACTICE);
			map.put("unit", practiceService.get(caseCoupons.getUnitid()));
		}
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(caseCoupons.getProceduresid())) {
			map.put("proName", labProcedureService.get(caseCoupons.getProceduresid()).getDisplayName());
		}
		m.addObject("result", map);
		return m;

	}

	/**
	 * 
	 * @Title: goPickupPage
	 * @Description: 跳转到收件请求页面
	 * @author ERIC
	 * @date 2014-8-5上午10:51:11
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/goPickupPage")
	public ModelAndView goPickupPage(HttpServletRequest request) throws Exception {
		Integer labId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("labId"));

		Map<String, Object> modelMap = new HashMap<String, Object>();
		Lab reqAccLab = null;
		Lab lab = null;
		Practice practice = null;
		User user = getSessionUserByLoginEmail();

		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
			reqAccLab = labService.get(labId);
		}

		String unitType = user.getUnitType();
		String prefix = "";
		if (Constans.UNIT_LAB.equals(unitType)) {
			prefix = "u_lab";
			lab = (Lab) getSessionUnit();
			modelMap.put("lab", lab);
		} else if (Constans.UNIT_PRACTICE.equals(unitType)) {
			prefix = "u_practice";
			practice = (Practice) getSessionUnit();
			modelMap.put("practice", practice);
		}

		// 伙伴技工间提供的权限
		Permissions per = getLabPermissions(labId);

		// 提供的订单权限
		modelMap.put("financesPermissions", per.getFinances());
		// 提供的财政权限
		modelMap.put("casesPermissions", per.getCases());

		// 请求的伙伴技工间
		modelMap.put("requestAccountLab", reqAccLab);
		modelMap.put("listPartnerLabs", getPartnerLabList());

		return new MyModelAndView().setViewName(prefix + "/" + prefix + "_Cases_Pickup").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: updateOperateTime
	 * @Description: 修改诊所营业时间
	 * @author ERIC
	 * @date 2014-8-16下午04:05:44
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/updateOperateTime")
	public void updateOperateTime(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		User user = getSessionUserByLoginEmail();
		String unitType = user.getUnitType();
		Practice practice = null;
		Practice practice0 = new Practice();
		Lab lab = null;
		Lab lab0 = new Lab();
		if (Constans.UNIT_LAB.equals(unitType)) {
			lab = (Lab) getSessionUnit();
			DXObject.setValue(lab0, req);
			lab0.setId(lab.getId());
			if (labService.updateOperateTime(lab0) > 0) {
				result.setResult(Booleans.TRUE);
				result.setInfo("修改成功");
			}
		} else if (Constans.UNIT_PRACTICE.equals(unitType)) {
			practice = (Practice) getSessionUnit();
			DXObject.setValue(practice0, req);
			practice0.setId(practice.getId());
			if (practiceService.updateOperateTime(practice0) > 0) {
				result.setResult(Booleans.TRUE);
				result.setInfo("修改成功");
			}
		}
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: getShipNum
	 * @Description: 技工间首页 获取今天待发货的订单数
	 * @author ERIC
	 * @date 2014-8-5下午02:59:59
	 * @return void
	 */
	@RequestMapping("/getShipNum")
	public void getShipNum(HttpServletRequest request, HttpServletResponse response) {
		String filter = request.getParameter("filter");
		Lab lab = getSessionLab();
		Cases caseQuery = new Cases();
		caseQuery.setFilterType(filter);
		caseQuery.setLabId(lab.getId());
		PageModel pm = casesService.queryShipCaseByLab(caseQuery);
		Long shipNum = pm.getTotal();
		try {
			outReturnString(shipNum, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getArriveNum
	 * @Description: 技工间首页 获取今天到达的订单数
	 * @author ERIC
	 * @date 2014-8-5下午03:01:16
	 * @return void
	 */
	@RequestMapping("/getArriveNum")
	public void getArriveNum(HttpServletRequest request, HttpServletResponse response) {
		String filter = request.getParameter("filter");
		Lab lab = getSessionLab();
		Cases caseQuery = new Cases();
		caseQuery.setFilterType(filter);
		caseQuery.setLabId(lab.getId());
		PageModel pm = casesService.queryArriveCaseByLab(caseQuery);
		Long arriveNum = pm.getTotal();
		try {
			outReturnString(arriveNum, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getTryInNum
	 * @Description: 技工间首页 获取试戴的订单数
	 * @author ERIC
	 * @date 2014-8-5下午03:03:05
	 * @return void
	 */
	@RequestMapping("/getTryInNum")
	public void getTryInNum(HttpServletRequest request, HttpServletResponse response) {
		Lab lab = getSessionLab();
		Cases caseQuery = new Cases();
		caseQuery.setLabId(lab.getId());
		PageModel pm = casesService.queryTryInCaseByLab(caseQuery);
		Long tryInNum = pm.getTotal();
		try {
			outReturnString(tryInNum, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getOnHoldNum
	 * @Description: on hold的订单数
	 * @author ERIC
	 * @date 2014-8-8上午09:42:18
	 * @return void
	 */
	@RequestMapping("/getOnHoldNum")
	public void getOnHoldNum(HttpServletRequest request, HttpServletResponse response) {
		Lab lab = getSessionLab();
		Cases caseQuery = new Cases();
		caseQuery.setLabId(lab.getId());
		PageModel pm = casesService.queryOnHoldCaseByLab(caseQuery);
		Long tryInNum = pm.getTotal();
		try {
			outReturnString(tryInNum, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getOutsourceNum
	 * @Description: Outsource的订单数
	 * @author ERIC
	 * @date 2014-8-8上午09:42:18
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/getOutsourceNum")
	public void getOutsourceNum(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		Integer unitId = getSessionUnitId();
		Cases caseQuery = new Cases();
		caseQuery.setLabId(unitId);
		PageModel pm = casesService.queryOutsourceCaseByLab(caseQuery);
		Long outsourceNum = pm.getTotal();
		try {
			outReturnString(outsourceNum, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: listShipByMonth
	 * @Description: Case to ship
	 * @author ERIC
	 * @date 2014-8-5下午04:43:25
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/listShipByMonth")
	public ModelAndView listShipByMonth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		// 每页显示10条
		Integer pageSize = 10;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());

		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);

		// 得到结果集
		List<Cases> casesList = casesService.queryShipCaseByLabPage(cf, caseQuery, pageNo, pageSize);
		PageModel shipPm = getPageModel(casesList, casesService.queryShipCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);

		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_ToShip").addObject("shipPm", shipPm);
	}

	/**
	 * 
	 * @Title: listArriveByMonth
	 * @Description: Case to arrive
	 * @author ERIC
	 * @date 2014-8-5下午04:43:25
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/listArriveByMonth")
	public ModelAndView listArriveByMonth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		// 每页显示10条
		Integer pageSize = 10;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());

		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);

		// 得到结果集
		List<Cases> casesList = casesService.queryArriveCaseByLabPage(cf, caseQuery, pageNo, pageSize);

		PageModel arrivePm = getPageModel(casesList, casesService.queryArriveCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);

		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_ToArrive").addObject("arrivePm", arrivePm)
				.addObject("filterOptions", getFilterOptions(null));
	}

	/**
	 * 
	 * @Title: listTryIn
	 * @Description: Open Tryin Cases 打开试戴订单
	 * @author ERIC
	 * @date 2014-8-5下午04:43:25
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/listTryIn")
	public ModelAndView listTryIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		// 每页显示10条
		Integer pageSize = 10;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());
		// 得到结果集
		List<Cases> casesList = casesService.queryTryInCaseByLabPage(cf, caseQuery, pageNo, pageSize);

		PageModel tryInPm = getPageModel(casesList, casesService.queryTryInCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_OpenTryIns").addObject("tryInPm", tryInPm);
	}

	/**
	 * 
	 * @Title: listOnHold
	 * @Description: list on hold cases
	 * @author ERIC
	 * @date 2014-8-8上午09:49:12
	 * @return ModelAndView
	 */
	@RequestMapping("/listOnHold")
	public ModelAndView listOnHold(HttpServletRequest request, HttpServletResponse response) {
		PageModel onHoldPm = new PageModel();
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_OnHold").addObject("onHoldPm", onHoldPm);
	}

	/**
	 * 
	 * @Title: listOutsource
	 * @Description: list outsource cases
	 * @author ERIC
	 * @date 2014-8-8上午09:50:36
	 * @return ModelAndView
	 */
	@RequestMapping("/listOutsource")
	public ModelAndView listOutsource(HttpServletRequest request, HttpServletResponse response) {
		PageModel outsourcePm = new PageModel();
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_ToOutsource").addObject("outsourcePm", outsourcePm);
	}

	/**
	 * 
	 * @Title: scanArriveCase
	 * @Description: 跳转到到达订单的浏览页面
	 * @author ERIC
	 * @date 2014-8-6下午01:37:02
	 * @return ModelAndView
	 */
	@RequestMapping("/scanArriveCase")
	public ModelAndView scanArriveCase() {
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_ToArrive_Scan");
	}

	/**
	 * 
	 * @Title: searchScanCase
	 * @Description: 搜索到达的订单
	 * @author ERIC
	 * @date 2014-8-6下午03:03:32
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/lab/cases/arrive/search")
	public void searchScanCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flag = "failed";
		Cases[] cArry = new Cases[1];
		try {

			Integer caseId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("caseId"));
			Cases cases = null;
			Lab lab = getSessionLab();
			Date date = new Date();
			if (caseId == null) {
				outJson("", null, flag, response);
				return;
			}
			cases = casesService.getArriveCaseByLab(caseId, lab.getId());
			if (null != cases) {
				cases.setMsg(cases.getArrived() != 1 ? "订单尚未到达" : "订单已到达");
				cases.setCreateDate(date);
				cases.setMsg1(ToolsKit.DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
			} else {
				cases = new Cases();
				cases.setCaseId(caseId);
				cases.setMsg("订单不存在");
				cases.setCreateDate(new Date());
				cases.setMsg1(ToolsKit.DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
			}
			cArry[0] = cases;
			flag = "success";
		} catch (Exception e) {
			outJson("", null, flag, response);
			e.printStackTrace();
			return;
		}
		outJson(cArry, null, flag, response);

	}

	/**
	 * 
	 * @Title: shipCase
	 * @Description: 发货订单
	 * @author ERIC
	 * @date 2014-8-7下午04:19:41
	 * @return void
	 */
	@RequestMapping("/lab/cases/ship")
	public void shipCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean success = false;
		String[] strArry = request.getParameterValues("cases[]");
		Integer[] intArry = new Integer[strArry.length];
		AjaxCaseResult result = new AjaxCaseResult();
		AjaxCaseResult.CasesTmp[] acrArray = new AjaxCaseResult.CasesTmp[intArry.length];
		AjaxCaseResult.CasesTmp acr = null;
		for (int i = 0; i < strArry.length; i++) {
			intArry[i] = Integer.parseInt(strArry[i]);
			acr = new AjaxCaseResult.CasesTmp();
			acr.setId(intArry[i]);
			acr.setDate(new Date());
			acr.setMsg("订单已发货");
			Timestamp d = new Timestamp(System.currentTimeMillis());
			acr.setTimestamp(d);
			acrArray[i] = acr;
		}
		try {
			List<Cases> caseList = casesService.listCasesInId(intArry);
			for(Cases cases:caseList){
				
				if (ToolsKit.EmptyCheckUtil.isEmpty(cases.getFinishPrice()) || cases.getFinishPrice() == 0.0 ) {
					cases.setFinishPrice(cases.getOriginalPrice());
				}
			}
			casesService.updateCaseShipBatch(caseList);
			success = true;
			result.setCt(acrArray);
			result.setSuccess(success);
			outJson(result, response);
			LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.EVENTS, "已发货",casesService.listCasesInId(intArry).toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: scanShipCase
	 * @Description: 跳转到发货订单的搜索页面
	 * @author ERIC
	 * @date 2014-8-7下午04:23:48
	 * @return void
	 */
	@RequestMapping("/scanShipCase")
	public ModelAndView scanShipCase() {
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_ToShip_Scan");
	}

	/**
	 * 
	 * @Title: searchShipCase
	 * @Description: 搜索发货的订单
	 * @author ERIC
	 * @date 2014-8-7下午04:17:37
	 * @return void
	 */
	@RequestMapping("/lab/cases/ship/search")
	public void searchShipCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flag = "failed";
		Cases[] cArry = new Cases[1];
		try {

			Integer caseId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("caseId"));
			Cases cases = null;
			Lab lab = getSessionLab();
			Date date = new Date();
			if (caseId == null) {
				outJson("", null, flag, response);
				return;
			}
			cases = casesService.getShipCaseByLab(caseId, lab.getId());
			if (null != cases) {
				cases.setMsg(cases.getConfirmedReturnDay() != null ? "订单已发货" : "订单尚未发货");
				cases.setCreateDate(date);
				cases.setMsg1(ToolsKit.DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
			} else {
				cases = new Cases();
				cases.setCaseId(caseId);
				cases.setMsg("订单不存在");
				cases.setCreateDate(new Date());
				cases.setMsg1(ToolsKit.DateUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
			}
			cArry[0] = cases;
			flag = "success";
		} catch (Exception e) {
			outJson("", null, flag, response);
			e.printStackTrace();
			return;
		}
		outJson(cArry, null, flag, response);
	}

	/**
	 * 
	 * @Title: getCaseByLab
	 * @Description: 技工间跳转到单条订单页面
	 * @author ERIC
	 * @date 2014-8-8上午10:44:32
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/lab/cases/getCase")
	public ModelAndView getCaseByLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer caseId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("caseId"));
		Cases cases = new Cases();
		cases = casesService.get(caseId);
		Lab sessionLab = getSessionLab();

		CaseNotes notes = new CaseNotes();
		// CaseLog log = new CaseLog();
		CaseAttachs attachs = new CaseAttachs();
		List<LabProceduresCharacteris> enclourseList = new ArrayList<LabProceduresCharacteris>();
		PageModel notePm = null;
		// PageModel logPm = null;
		PageModel linkPm = null;
		List<CaseAttachs> attachsList = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer labId = sessionLab.getId();
		try {
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(caseId)) {
				notes.setCaseId(caseId);
				// log.setCaseId(caseId);
				attachs.setCaseId(caseId);

				Cases cq = new Cases();
				cq.setParentId(caseId);
				linkPm = casesService.queryOutsourceCase(cq);
				modelMap.put("linkPm", linkPm);
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
				CaseHold caseHold = new CaseHold();
				caseHold.setLabId(sessionLab.getId());
				PageModel caseHoldPm = caseholdService.queryAllCaseHoldByLab(caseHold);
				modelMap.put("caseHoldPm", caseHoldPm);
				CaseShipping shipper = new CaseShipping();
				shipper.setLabId(labId);
				List<CaseShipping> shipperList = casesShippingService.listAllByEqual(shipper, 0, 0);
				modelMap.put("shipperList", shipperList);
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getPatientId())) {
				Patient patient = patientService.get(cases.getPatientId());
				modelMap.put("patient", patient);
			}

			String enclosurestr = cases.getEnclosures();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(enclosurestr)) {
				LabProceduresCharacteris lpc = new LabProceduresCharacteris();
				lpc.setType("enclosures");
				String[] str = enclosurestr.split(",");
				List<Integer> ids = new ArrayList<Integer>();
				for (String s : str) {
					ids.add(new Integer(s));
				}
				enclourseList = characterisService.queryCharacterisByIds(lpc, ids);
				modelMap.put("enclourses", enclourseList);
			}

			// 重制原因
			String returnType = cases.getReturnType();
			if ("remake".equals(returnType)) {
				CaseRemake cr = caseRemakeService.get(cases.getRemakeType());
				cases.setRemakeTypeNam(cr.getName());
			}

			// 获取比色卡数据
			modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
			modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());

			List<Lab> partnerLabList = labService.getPartnerLabApproved(labId);
			notePm = notesService.queryNotesByCriteria(notes);

			DDXLog log = new DDXLog();
			log.setPrimaryId(caseId);
			PageModel logPm = new PageModel();
			logPm.setDatas(logService.listAllByEqual(log, 0, 0));

			attachsList = caseAttachsService.queryAttachsByCriteria(attachs);
			modelMap.put("notePm", notePm);
			modelMap.put("logListPm", logPm);
			modelMap.put("attachsList", attachsList);
			modelMap.put("cases", cases);
			modelMap.put("partnerLabList", partnerLabList);
			modelMap.put("proceduresList", labProcedureService.getProceduresDetailed(cases));
			modelMap.put("procedureIds", getProcedureIds(cases.getProcedures()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MyModelAndView().setViewName("lab/lab_case_details").addAllObjects(modelMap);
	}
	
	
	private String getProcedureIds(String procedureContent) throws Exception{
		List<LabProcedurePojo> lpList = ToolsKit.jsonUitl.toBeanList(LabProcedurePojo.class, procedureContent);
		List<Integer> intList = new ArrayList<Integer>();
		for (LabProcedurePojo lp : lpList) {
			intList.add(Integer.parseInt(lp.getProcedure_id()));
		}
		String ids = null;
		return intList.size() > 0 ? ids = StringUtil.listToString(intList) : null;
	}

	/**
	 * 
	 * @Title: arriveCase
	 * @Description: 收到订单处理
	 * @author ERIC
	 * @date 2014-8-11下午03:30:55
	 * @return void
	 */
	@RequestMapping("/lab/cases/arrive")
	public void arriveCase(HttpServletRequest req, HttpServletResponse resp) {
		boolean success = false;
		String[] strArry = req.getParameterValues("cases[]");
		Integer[] intArry = new Integer[strArry.length];
		AjaxCaseResult result = new AjaxCaseResult();
		AjaxCaseResult.CasesTmp[] acrArray = new AjaxCaseResult.CasesTmp[intArry.length];
		AjaxCaseResult.CasesTmp acr = null;
		for (int i = 0; i < strArry.length; i++) {
			intArry[i] = Integer.parseInt(strArry[i]);
			acr = new AjaxCaseResult.CasesTmp();
			acr.setId(intArry[i]);
			acr.setDate(new Date());
			acr.setMsg("订单已抵达");
			Timestamp d = new Timestamp(System.currentTimeMillis());
			acr.setTimestamp(d);
			acrArray[i] = acr;
		}
		try {
			casesService.updateCaseArriveBatch(intArry);
			success = true;
			result.setCt(acrArray);
			result.setSuccess(success);
			outJson(result, resp);
			LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.EVENTS, "已抵达",casesService.listCasesInId(intArry).toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: addNote
	 * @Description: 添加订单备注信息
	 * @author ERIC
	 * @date 2014-8-12下午04:47:24
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/cases/addNote")
	public void addNote(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CaseNotes notes = new CaseNotes();
		DXObject.setValue(notes, request);
		notes.setCaseDate(new Date());
		User user = getSessionUserByLoginEmail();
		String uniteType = user.getUnitType();
		Cases cases = casesService.get(notes.getCaseId());
		notes.setUnitId(user.getUnitId());
		notes.setUnitType(Integer.valueOf(uniteType));
		// 下单机构类型
		String caseType = cases.getUnitType().toString();
		if (Constans.UNIT_PRACTICE.equals(caseType)) {
			notes.setCaseFor(Constans.UNIT_PRACTICE.equals(uniteType) ? "技工间" : "诊所");
			notes.setCaseFrom((ToolsKit.EmptyCheckUtil.isEmpty(user.getSalutation()) ? "" : user.getSalutation()) + user.getFirstName()
					+ user.getLastName() + "(" + (!Constans.UNIT_PRACTICE.equals(uniteType) ? "技工间" : "诊所") + ")");
		}
		if (Constans.UNIT_LAB.equals(caseType)) {
			notes.setCaseFor((Constans.UNIT_LAB.equals(uniteType) && cases.getPracticeId().equals(user.getLabId())) ? "诊所" : "技工间");
			notes.setCaseFrom((ToolsKit.EmptyCheckUtil.isEmpty(user.getSalutation()) ? "" : user.getSalutation()) + user.getFirstName()
					+ user.getLastName() + "("
					+ (!(Constans.UNIT_LAB.equals(uniteType) && cases.getPracticeId().equals(user.getLabId())) ? "诊所" : "技工间") + ")");
		}
		notesService.add(notes);
		outJson(null, "addNote", "success", response);
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(notes.getCaseNote())){
			LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.WARNING, "添加备注:\""+
					notes.getCaseNote().replace("<p>", "").replace("</p>", "").replace("<br>", "").replace("</br>", "")+"\"",cases);
		}
	}

	/**
	 * 
	 * @Title: onHold
	 * @Description: 修改on hold状态
	 * @author ERIC
	 * @date 2014-8-13下午02:56:12
	 * @return void
	 */
	@RequestMapping("/lab/cases/onHold")
	public void onHold(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Cases cases0 = new Cases();
		DXObject.setValue(cases0, request);
		cases = casesService.get(cases0.getCaseId());
		if ("_OTHER_".equals(cases0.getOnHoldStatus())) {
			String customStatus = ToolsKit.TypeConversionUtil.asString(request.getParameter("customStatus"));
			cases.setOnHoldStatus(customStatus);
		} else {
			cases.setOnHoldStatus(cases0.getOnHoldStatus());
		}
		cases.setLastUpdateDate(new Date());
		casesService.update(cases);
		// User user = getSessionUserByLoginEmail();
		// CaseLog log = new CaseLog();
		// log.setCaseId(cases.getCaseId());
		// log.setAccountId(user.getAccountId());
		// log.setCreateTime(new Date());
		// log.setOperationType("updatedCase");
		// log.setChanges(" on hold status 更新到 &nbsp;&nbsp;" +
		// cases0.getOnHoldStatus());
		// logService.add(log);

		outReturnString("success", response);
		// 插日志
		try {
			LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.WARNING, "更新了订单延时状态到："+cases.getOnHoldStatus(),cases);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<?> partner() throws Exception {
		Integer sessionLabId = getSessionUserByLoginEmail().getLabId();
		List<Lab> list = labService.getPartnerLabApproved(sessionLabId);
		return list;
	}

	/**
	 * 
	 * @Title: forward
	 * @Description: 订单外包
	 * @author ERIC
	 * @date 2014-8-14上午11:37:31
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/lab/cases/forwardCase")
	public ModelAndView forwardCase(HttpServletRequest request) throws Exception {
		Cases cases0 = new Cases();
		DXObject.setValue(cases0, request);
		Integer labId = cases0.getLabId();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases0.getCaseId())) {
			cases0 = casesService.get(cases0.getCaseId());
		} else {
			return null;
		}

		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 伙伴技工间ID
		Patient patient = new Patient();
		DXObject.setValue(patient, request);
		modelMap = loadNaviData(labId);
		modelMap.put("patient", patient);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowdate = new Date();
		modelMap.put("shipDate", sdf.format(nowdate));
		cases0 = casesService.get(cases0.getCaseId());
		cases0.setSendToLabDate(nowdate);
		// 获取外包工序链接
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases0)) {
			modelMap.put("cases", cases0);
			String procedureContent = cases0.getProcedures();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(procedureContent)) {
				List<LabProcedurePojo> lpList = ToolsKit.jsonUitl.toBeanList(LabProcedurePojo.class, procedureContent);
				// 工序id集
				List<Integer> intList = new ArrayList<Integer>();
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(lpList)) {
					for (LabProcedurePojo lp : lpList) {
						LabProceduresOutLink linkQuery = new LabProceduresOutLink();
						LabProceduresOutLink outLink = null;
						linkQuery.setProceduresId(Integer.valueOf(lp.getProcedure_id()));

						List<LabProceduresOutLink> outLinkList = outLinkService.listAllByEqual(linkQuery, 0, 0);

						if (ToolsKit.EmptyCheckUtil.isNotEmpty(outLinkList)) {
							outLink = outLinkList.get(0);
						}
						if (ToolsKit.EmptyCheckUtil.isNotEmpty(outLink) && "checked".equals(outLink.getAutoRoute())) {
							intList.add(Integer.parseInt(lp.getProcedure_id()));
						}
					}
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(intList)) {
						List<Integer> outLinkList = outLinkService.queryOutLinks(intList);
						if (ToolsKit.EmptyCheckUtil.isNotEmpty(outLinkList)) {
							modelMap.put("outlinks", StringUtil.listToString(outLinkList));
						}
					}
				}
			}
		}

		String unitType = getSessionUserByLoginEmail().getUnitType();
		if (Constans.UNIT_PRACTICE.equals(unitType)) {
			Practice practice = (Practice) getSessionUnit();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(practice.getProviders())) {
				List<User> providers = userService.ListUser(practice.getProviders());
				modelMap.put("providers", providers);
			}
		}
		// 加载工序特征
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
			modelMap.put("proOption", labProcedureService.getProedureAsHtml(labId));
			modelMap.put("user", getSessionUserByLoginEmail());

			// 向接收方下订单的协议
			CaseTerms ct = new CaseTerms();
			ct.setLabid(labId);
			List<CaseTerms> terms = termsService.listAllByEqual(ct, 0, 0);
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(terms)) {
				ct = terms.get(0);
				modelMap.put("caseTerms", ct);
			}

			// 获取比色卡数据
			modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
			modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());
		}
		modelMap.put("newType", Constans.CASES_NEWTYPE_OUTSOURCE);
		return new MyModelAndView().setViewName("u_practice/newCase").addAllObjects(modelMap);

	}

	/**
	 * 
	 * @Title: getLinkedCases
	 * @Description: 获取转外包的订单
	 * @author ERIC
	 * @date 2014-8-14下午05:00:54
	 * @return void
	 * @throws Exception
	 */
	public void getLinkedCases(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		DXObject.setValue(cases, request);
		List<Cases> casesList = casesService.listAllByEqual(cases, 0, 0);
		outJson(ToolsKit.jsonUitl.toJson(casesList), response);

	}

	/**
	 * 
	 * @Title: practiceIndexLog
	 * @Description: 诊所主页订单动态
	 * @author ERIC
	 * @date 2014-8-16上午10:24:55
	 * @return void
	 */
	@RequestMapping("/practice_portal/index/log")
	public void practiceIndexLog(HttpServletRequest request, HttpServletResponse response) throws Exception {

	}

	/**
	 * 
	 * @Title: practiceIndexLog
	 * @Description:打印ddx优惠劵
	 * @author ERIC
	 * @date 2014-8-16上午10:24:55
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/stamp")
	public void stamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = couponsExcel.export(getSessionLab());
		outReturnString(name, response);
	}

	/**
	 * 
	 * @Title: procedureEmbed
	 * @Description: 获取工序的描述
	 * @author ERIC
	 * @date 2014-8-19上午10:56:41
	 * @return ModelAndView
	 */
	@RequestMapping("/procedureEmbed")
	public ModelAndView procedureEmbed(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = getParameterAsInteger(request, "id");
		LabProcedure procedure = labProcedureService.get(id);
		return new MyModelAndView().setViewName("u_practice/procedure_embed").addObject("procedure", procedure);
	}

	/**
	 * 
	 * @Title: getAttributes
	 * @Description: 获取选择的工序的属性
	 * @author king
	 * @date 2014-8-19上午10:56:41
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getAttributes")
	public ModelAndView getAttributes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer proceduresId = getParameterAsInteger(request, "id");
		String isLayout = request.getParameter("isLayout");
		LabProcedureAttr labattr = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(proceduresId)) {
			LabProcedureAttr attr = new LabProcedureAttr();
			attr.setProcedures_id(proceduresId);
			List<LabProcedureAttr> listlpa = labProcedureAttrService.listAllByEqual(attr, 0, 0);
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(listlpa)) {
				labattr = listlpa.get(0);
			}
		}
		List<Map<String, Object>> list = new ArrayList();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labattr)) {
			Method[] methods = labattr.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				if (methods[i].getName().startsWith("get") && methods[i].getName().endsWith("presence")) {
					String result = ToolsKit.TypeConversionUtil.asString(methods[i].invoke(labattr));
					if (!Constans.PRESENCE_NOT_APPLICABLE.equals(result) && ToolsKit.EmptyCheckUtil.isNotEmpty(result)) {
						Map<String, Object> commentMap = AbstractExcelService.parseComment(methods[i], Note.class);
						String methodsName = methods[i].getName();

						String getValueMethod = ToolsKit.TypeConversionUtil.asString(commentMap.get("getValueMethod"));
						String getValueDescriptionMethod = ToolsKit.TypeConversionUtil
								.asString(commentMap.get("getValueDescriptionMethod"));
						String createCaseShowType = ToolsKit.TypeConversionUtil.asString(commentMap.get("createCaseShowType"));
						String valueLoadChannel = ToolsKit.TypeConversionUtil.asString(commentMap.get("valueLoadChannel"));
						String dataType = ToolsKit.TypeConversionUtil.asString(commentMap.get("dataType"));

						String value = ToolsKit.TypeConversionUtil.asString(LabProcedureAttr.class.getMethod(getValueMethod)
								.invoke(labattr));
						List<Map<String, Object>> valueDescription = null;
						if (ToolsKit.EmptyCheckUtil.isNotEmpty(getValueDescriptionMethod)) {
							valueDescription = (List) ProcedureAttrCache.class.getMethod(getValueDescriptionMethod).invoke(
									baseCache.getProcedureAttrCache());
						}
						// if (ToolsKit.EmptyCheckUtil.isNotEmpty(value) &&
						// !"null".equals(value)) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", methodsName);
						map.put("label", commentMap.get("name"));

						String[] op = value.split(",");
						StringBuffer options = new StringBuffer();
						StringBuffer input = new StringBuffer();
						j: for (int j = 0; j < op.length; j++) {
							String title = "";

							String placeholder = "";
							if ("int".equals(dataType)) {
								placeholder = "placeholder=\"只能输入数字\"";
							}
							if (ToolsKit.EmptyCheckUtil.isNotEmpty(valueDescription)) {
								j2: for (int j2 = 0; j2 < valueDescription.size(); j2++) {
									if (valueDescription.get(j2).get(Constans.CACHE_NAME_KEY).equals(op[j])) {
										title = (String) valueDescription.get(j2).get(Constans.CACHE_NAME_VALUE);
										break j2;
									}
								}
								if ("input".equals(createCaseShowType)) {
									input.append("<input type=\"text\" " + placeholder + " dataType=\"" + dataType + "\" id=\""
											+ methodsName + "\" class=\"box_edit01\" key=\"" + value + "\" value=\"" + value/* title */
											+ "\" need=\"" + result + "\"/>");
									break j;
								} else {
									boolean isNull = false;
									if ("db".equals(valueLoadChannel)) {
										try {
											LabProceduresCharacteris lc = labProceduresCharacterisService.get(ToolsKit.TypeConversionUtil
													.asInteger(op[j]));
											title = lc.getCharacterName();
										} catch (Exception e) {
											isNull = true;
											//title = "数据错误：" + op[j];
											e.printStackTrace();
										}
									}
									if(!isNull){
										options.append("<option value=\"" + op[j] + "\">").append(title).append("</option>");
									}
								}
							} else {
								input.append("<input type=\"text\" " + placeholder + " dataType=\"" + dataType + "\" id=\"" + methodsName
										+ "\" class=\"box_edit01\" key=\"" + value + "\" value=\"" + value + "\" need=\"" + result + "\"/>");
								break j;
							}
						}
						if (ToolsKit.EmptyCheckUtil.isNotEmpty(options)) {
							map.put("option", "<select id=\"" + methodsName + "\" need=\"" + result + "\"><option value=\"\"></option>"
									+ options.toString() + "</select>");
						} else if (ToolsKit.EmptyCheckUtil.isNotEmpty(input)) {
							map.put("input", input.toString());
						}
						map.put("need", result);
						list.add(map);
						// }
					}
				}
			}
		}
		List<Map<String, Object>> left = new ArrayList();
		List<Map<String, Object>> right = new ArrayList();
		if ("false".equals(isLayout)) {
			left = list;
		} else {
			// 布局
			for (int i = 0; i < list.size(); i++) {
				if (i % 2 != 0) {
					left.add(list.get(i));
				} else {
					right.add(list.get(i));
				}
			}
		}
		return new ModelAndView("u_practice/add-cases-load-procedures").addObject("left", left).addObject("right", right);
	}

	/**
	 * 
	 * @Title: deleteCaseProcedure
	 * @Description: 删除订单工序
	 * @author king
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteCaseProcedure")
	public void deleteCaseProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败");
		String index = req.getParameter("index");
		Integer caseId = getParameterAsInteger(req, "caseId");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cases cases = casesService.get(caseId);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases)) {
			String proStr = cases.getProcedures();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(proStr)) {
				Map[] casesProMap = ToolsKit.jsonUitl.toBean(Map[].class, proStr);
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(casesProMap) && casesProMap.length > 0) {
					for (int i = 0; i < casesProMap.length; i++) {
						String ind = ToolsKit.TypeConversionUtil.asString(casesProMap[i].get("index"));
						if (!ToolsKit.TypeConversionUtil.asString(index).equals(ind)) {
							list.add(casesProMap[i]);
						}
					}
				}
			}
		}
		cases.setProcedures(ToolsKit.jsonUitl.toJson(list));
		casesService.updateCaseProcedureAndPrice(cases);
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: updateCaseProcedure
	 * @Description: 修改订单工序
	 * @author king
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/loadCaseProcedure")
	public void loadCaseProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String index = req.getParameter("index");
		Integer caseId = getParameterAsInteger(req, "caseId");

		List<Map<String, Object>> resultArray = new ArrayList<Map<String, Object>>();
		Cases cases = casesService.get(caseId);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases)) {
			String proStr = cases.getProcedures();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(proStr)) {
				Map[] casesProMap = ToolsKit.jsonUitl.toBean(Map[].class, proStr);
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(casesProMap) && casesProMap.length > 0) {
					for (int i = 0; i < casesProMap.length; i++) {
						String ind = ToolsKit.TypeConversionUtil.asString(casesProMap[i].get("index"));
						if (ToolsKit.TypeConversionUtil.asString(index).equals(ind)) {
							Cases.Procedures pro = ToolsKit.jsonUitl.toBean(Cases.Procedures.class,
									ToolsKit.jsonUitl.toJson(casesProMap[i].get("procedure")));
							if (ToolsKit.EmptyCheckUtil.isNotEmpty(pro)) {
								Method[] methods = Cases.Procedures.class.getMethods();
								for (int j = 0; j < methods.length; j++) {
									if (methods[j].getName().startsWith("get") && methods[j].getName().endsWith("presence")) {
										Map<String, Object> map = new HashMap<String, Object>();
										map.put("id", methods[j].getName());
										map.put("value", methods[j].invoke(pro));
										resultArray.add(map);
									}
								}
							}
						}
					}
				}
			}
		}
		outReturnString(ToolsKit.jsonUitl.toJson(resultArray), resp);
	}

	/**
	 * 
	 * @Title: applyCasesTags
	 * @Description: 订单标签编辑
	 * @author ERIC
	 * @date 2014-8-25下午05:28:18
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/applyCasesTags")
	public void applyCasesTags(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "失败");
		Integer caseId = getParameterAsInteger(req, "caseId");
		String tags = ToolsKit.TypeConversionUtil.asString(req.getParameter("tags"));
		Cases cases = casesService.get(caseId);
		cases.setTags(tags);
		casesService.update(cases);
		result.setResult(Booleans.TRUE);
		result.setInfo(tags);
		outJson(result, "applyCasesTags", "success", resp);
	}

	/**
	 * 
	 * @Title: applyFollowCase
	 * @Description: 订单跟踪
	 * @author ERIC
	 * @date 2014-8-26上午10:24:53
	 * @return void
	 */
	@RequestMapping("/applyFollowCase")
	public void applyFollowCase(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "失败");
		Integer caseId = getParameterAsInteger(req, "caseId");
		String isFollow = ToolsKit.TypeConversionUtil.asString(req.getParameter("followType"));
		Cases cases = casesService.get(caseId);
		cases.setIsFollow("UNFOLLOW".equals(isFollow) ? "N" : "Y");
		casesService.update(cases);
		result.setResult(Booleans.TRUE);
		result.setInfo(isFollow);
		outJson(result, "applyFollowCase", "success", resp);
	}

	/**
	 * 
	 * @Title: listFilter
	 * @Description: 订单列表过滤
	 * @author ERIC
	 * @date 2014-8-26下午03:10:31
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/listFilter")
	public ModelAndView listFilter(HttpServletRequest req) throws Exception {
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, req);
		// 默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		// 默认取第一页
		if (ToolsKit.EmptyCheckUtil.isEmpty(pageNo)) {
			pageNo = 1;
		}
		// 每页显示20条
		Integer pageSize = 20;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());

		List<Cases> casesList = null;
		PageModel pm = null;
		String urlString = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (Constans.CASES_FILTER_BYMONTH.equals(cf.getFilterBy())) {

			casesList = casesService.listCaseByMonth(cf, caseQuery, pageNo, pageSize);
			pm = getPageModel(casesList, casesService.getCaseCountByMonth(cf, caseQuery), pageSize, pageNo);
			map.put("year", cf.getYear());
			map.put("month", cf.getMonth());
			map.put("casesList", pm);
			modelMap.put("datas", map);
			urlString = "u_lab_Cases_ByMonth_show";

		} else if (Constans.CASES_FILTER_OPENTRYINS.equals(cf.getFilterBy())) {

			// 得到结果集
			casesList = casesService.queryTryInCaseByLabPage(cf, caseQuery, pageNo, pageSize);
			pm = getPageModel(casesList, casesService.queryTryInCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
			urlString = "u_lab_Cases_OpenTryIns_show";
			map.put("tryInPm", pm);

		} else if (Constans.CASES_FILTER_TOARRIVE.equals(cf.getFilterBy())) {

			casesList = casesService.queryArriveCaseByLabPage(cf, caseQuery, pageNo, pageSize);
			pm = getPageModel(casesList, casesService.queryArriveCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
			urlString = "u_lab_Cases_ToArrive_show";
			map.put("arrivePm", pm);

		} else if (Constans.CASES_FILTER_TOSHIP.equals(cf.getFilterBy())) {

			casesList = casesService.queryShipCaseByLabPage(cf, caseQuery, pageNo, pageSize);
			pm = getPageModel(casesList, casesService.queryShipCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
			urlString = "u_lab_Cases_ToShip_show";
			map.put("shipPm", pm);

		} else if (Constans.CASES_FILTER_ONHOLD.equals(cf.getFilterBy())) {
			casesList = casesService.queryOnHoldCaseByLabPage(cf, caseQuery, pageNo, pageSize);
			pm = getPageModel(casesList, casesService.queryOnHoldCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
			urlString = "u_lab_Cases_OnHold_show";
			map.put("onHoldPm", pm);

		} else if (Constans.CASES_FILTER_TOOUTSOURCE.equals(cf.getFilterBy())) {
			casesList = casesService.queryOutsourceCaseByLabPage(cf, caseQuery, pageNo, pageSize);
			pm = getPageModel(casesList, casesService.queryOutsourceCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
			urlString = "u_lab_Cases_ToOutsource_show";
			map.put("outsourcePm", pm);

		}

		map.put("filterOptions", getFilterOptions(null));

		return new MyModelAndView().setViewName("u_lab/" + urlString).addObject("datas", map).addObject("method", cf.getFilterBy())
				.addObject("multiFilters", cf);
	}

	/**
	 * 
	 * @Title: cancelCases
	 * @Description: 取消订单(接收方)
	 * @author ERIC
	 * @date 2014-7-24下午02:31:46
	 * @return void
	 */
	@RequestMapping("/lab/cancel")
	public void cancel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		DXObject.setValue(cases, request);
		cases = casesService.get(cases.getCaseId());
		User user = getSessionUserByLoginEmail();
		cases.setCancelledBy(user.getFirstName() + user.getLastName());
		cases.setCancelledDate(new Date());
		cases.setStatus(Constans.CASE_STATUS_CANCEL);
		casesService.update(cases);
		outJson(cases, "cancel", "success", response);
		LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.WARNING, "取消了订单",cases);
	}

	/**
	 * 
	 * @Title: close
	 * @Description: 关闭订单（接收方）
	 * @author ERIC
	 * @date 2014-9-1下午04:29:09
	 * @return void
	 */
	@RequestMapping("/lab/cases/close")
	public void close(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cases cases = new Cases();
		Date date = new Date();
		DXObject.setValue(cases, request);
		Cases caseEntity = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases.getCaseId())) {
			caseEntity = casesService.get(cases.getCaseId());
			caseEntity.setShipperId(cases.getShipperId());
			caseEntity.setWaybillNumber(cases.getWaybillNumber());
			caseEntity.setShipped(1);
			caseEntity.setShipDate(date);
			caseEntity.setLastUpdateDate(date);
			caseEntity.setStatus(Constans.CASE_STATUS_CLOSE);
			// 若finishPrice为空，则将originalPrice取出填入
			if (ToolsKit.EmptyCheckUtil.isEmpty(caseEntity.getFinishPrice()) || caseEntity.getFinishPrice() == 0.0) {
				caseEntity.setFinishPrice(caseEntity.getOriginalPrice());
			}
			casesService.updateCasesWhenClose(caseEntity);
		} else {
			throw new Exception("数据异常！");
		}
		outReturnString("success", response);
		LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.EVENTS, "已发货",caseEntity);
	}

	/**
	 * 
	 * @Title: delCase
	 * @Description: 删除草稿状态的订单
	 * @author ERIC
	 * @date 2014-9-2下午02:10:25
	 * @return void
	 */
	@RequestMapping("/delCase")
	public void delCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败！");
		Integer id = getParameterAsInteger(request, "id");
		Cases cases = casesService.get(id);
		cases.setStatus(Constans.CASE_STATUS_CLOSE);
		casesService.update(cases);
		result.setResult(Booleans.TRUE);
		result.setInfo("删除成功！");
		outReturnAjaxResult(result, response);
	}

	/**
	 * 
	 * @Title: resumeCase
	 * @Description: 继续订单
	 * @author ERIC
	 * @date 2014-9-2下午02:50:58
	 * @return void
	 */
	@RequestMapping("/resumeCase")
	public ModelAndView resumeCase(HttpServletRequest request, HttpServletResponse response) {
		Integer id = getParameterAsInteger(request, "id");
		Cases cases = casesService.get(id);

		Lab lab = new Lab();
		Patient patient = new Patient();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		MyModelAndView mmav = new MyModelAndView();
		try {
			Integer labId = ToolsKit.TypeConversionUtil.asInteger(cases.getLabId());
			Integer patientId = ToolsKit.TypeConversionUtil.asInteger(cases.getPatientId());
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(labId)) {
				lab = labService.get(labId);
				LabProceduresCharacteris characteris = new LabProceduresCharacteris();
				characteris.setLabId(labId);
				characteris.setType("enclosures");
				List<LabProceduresCharacteris> enclosuresList = characterisService.listAllEnclosuresByLab(characteris);
				// 附件
				modelMap.put("enclosuresList", enclosuresList);
				modelMap.put("proOption", labProcedureService.getProedureAsHtml(labId));
				modelMap.put("user", getSessionUserByLoginEmail());

				// 向接收方下订单的协议
				CaseTerms ct = new CaseTerms();
				ct.setLabid(labId);
				List<CaseTerms> terms = termsService.listAllByEqual(ct, 0, 0);
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(terms)) {
					ct = terms.get(0);
					modelMap.put("caseTerms", ct);
				}
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientId)) {
				patient = patientService.get(patientId);
			}

			String unitType = getSessionUserByLoginEmail().getUnitType();
			if (Constans.UNIT_PRACTICE.equals(unitType)) {
				Practice practice = (Practice) getSessionUnit();
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(practice.getProviders())) {
					List<User> providers = userService.ListUser(practice.getProviders());
					modelMap.put("providers", providers);
				}
			}

			// 获取比色卡数据
			modelMap.put("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
			modelMap.put("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());

			// 伙伴技工间提供的权限
			Permissions per = getLabPermissions(labId);
			// 提供的订单权限
			modelMap.put("financesPermissions", per.getFinances());
			// 提供的财政权限
			modelMap.put("casesPermissions", per.getCases());

			modelMap.put("listPartnerLabs", getPartnerLabList());
			modelMap.put("requestAccountLab", lab);
			modelMap.put("cases", cases);
			modelMap.put("patient", patient);
			modelMap.put("user", getSessionUserByLoginEmail());
			modelMap.put("newType", "resume");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mmav.setViewName("u_practice/newCase").addAllObjects(modelMap);
	}

	@RequestMapping("/lab/cases/gotoNote")
	public ModelAndView gotoNote(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = getParameterAsInteger(req, "caseId");
		Cases cases = casesService.get(id);
		return new MyModelAndView().setViewName("lab/lab_case_details_note").addObject("cases", cases);
	}

	/**
	 * 
	 * @Title: markTryIn
	 * @Description: 技工间标记订单为试戴
	 * @author ERIC
	 * @date 2014-10-9上午09:02:50
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/lab/markTryIn")
	public void markTryIn(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Cases cases = new Cases();
		try {
			String flag = "fail";
			DXObject.setValue(cases, req);
			cases = casesService.get(cases.getCaseId());
			cases.setLastUpdateDate(new Date());
			cases.setIsTryIn("Y");
			casesService.update(cases);
			flag = "success";
			outJson(null, "markTryIn", flag, resp);
			LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.WARNING, "标记为试戴", cases);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: addCaseProcedure
	 * @Description: 增加订单的工序
	 * @author king
	 * @date 2014-10-9上午09:02:50
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/addCaseProcedure")
	public void addCaseProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		Integer caseId = getParameterAsInteger(req, "caseId");
		String procedures = req.getParameter("procedures");
		Date sendToLabDate = ToolsKit.DateUtil.parse(req.getParameter("sendToLabDate"));
		Cases cases = new Cases();
		labProcedureService.setProceduresDetailed(cases, procedures);
		List<Map<String, Object>> list = ToolsKit.jsonUitl.toBean(List.class, cases.getProcedures());
		Cases cas = casesService.get(caseId);
		List<Map<String, Object>> proList = ToolsKit.jsonUitl.toBean(List.class, cas.getProcedures());
		for (int i = 0; i < list.size(); i++) {
			proList.add(list.get(i));
		}
		cas.setProcedures(ToolsKit.jsonUitl.toJson(proList));
		cas.setShipDate(computeShipDate(cas));
		cas.setDeliveryDate(computeDeliveryDate(cas));
		cas.setSendToLabDate(sendToLabDate);
		cas.setLastUpdateDate(new Date());
		int r = casesService.updateCasesProcedureAndDate(cas);
		if (r > 0) {
			result.setInfo("增加成功");
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: updateCaseProcedure
	 * @Description: 修改订单的工序
	 * @author king
	 * @date 2014-10-9上午09:02:50
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/updateCaseProcedure")
	public void updateCaseProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		Integer caseId = getParameterAsInteger(req, "caseId");
		String procedures = req.getParameter("procedures");
		String procedure_index = req.getParameter("procedure_index");
		Cases cas = casesService.get(caseId);
		List<Map<String, Object>> proList = ToolsKit.jsonUitl.toBean(List.class, cas.getProcedures());

		String proName = "";
		String isTryIn = "";
		Integer in = null;
		for (int i = 0; i < proList.size(); i++) {
			String index = ToolsKit.TypeConversionUtil.asString(proList.get(i).get("index"));
			if (procedure_index.equals(index)) {
				in = i;
				proName = ToolsKit.TypeConversionUtil.asString(proList.get(i).get("procedure_name"));
				isTryIn = ToolsKit.TypeConversionUtil.asString(proList.get(i).get("isTryIn"));
				break;
			}
		}

		if (in == null) {
			throw new Exception("修改失败，数据错误");
		}
		Cases cases = new Cases();
		labProcedureService.setProceduresDetailed(cases, procedures);
		List<Map<String, Object>> list = ToolsKit.jsonUitl.toBean(List.class, cases.getProcedures());
		if (ToolsKit.EmptyCheckUtil.isEmpty(list)) {
			throw new Exception("修改失败，数据错误");
		}
		Map m = list.get(0);
		m.put("isTryIn", isTryIn);
		m.put("procedure_name", proName);
		proList.set(in, m);
		int r = casesService.updateCasesProcedure(caseId, ToolsKit.jsonUitl.toJson(proList));
		if (r > 0) {
			result.setInfo("修改成功");
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title:
	 * @Description: 查询技工间相对应的优惠劵
	 * @author ERIC
	 * @date 2014-9-10上午09:27:46
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/findCoupon")
	public ModelAndView findCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer labId = getParameterAsInteger(request, "requestId");
		User seesionUser = getSessionUserByLoginEmail();
		List<LabCaseCoupons> labccList = caseCouponsService.loadCouponsByNewCases(seesionUser, labId);

		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labccList)) {
			LabProcedure lp = new LabProcedure();
			lp.setLabId(labId);
			List<LabProcedure> listlp = labProcedureService.listAllByEqual(lp, 0, 0);
			for (int i = 0; i < labccList.size(); i++) {
				LabCaseCoupons lc = labccList.get(i);
				p: for (int j = 0; j < listlp.size(); j++) {
					if (listlp.get(j).getProceduresId().equals(lc.getProceduresid())
							|| listlp.get(j).getProceduresId() == lc.getProceduresid()) {
						labccList.get(i).setProceduresName(listlp.get(j).getDisplayName());
						break p;
					}
				}
			}
		}
		return new MyModelAndView().setViewName("u_practice/addCoupontDialog").addObject("listCoupons", labccList);
	}

	/**
	 * 
	 * @Title:
	 * @Description: 校验优惠劵
	 * @author ERIC
	 * @date 2014-9-10上午09:27:46
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/checkCoupontValid")
	public void checkCoupontValid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		String proceduresIds = request.getParameter("proceduresId");
		Integer requestLabId = getParameterAsInteger(request, "requestLabId");
		outReturnAjaxResult(caseCouponsService.checkCoupontValid(getSessionUserByLoginEmail(), requestLabId, proceduresIds, code), response);
	}

	/**
	 * 
	 * @Title: updateCaseTryIn
	 * @Description: 修改订单工序试戴状态
	 * @author king
	 * @date 2014-10-9上午09:02:50
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/lab/cases/updateCaseTryIn")
	public void updateCaseTryIn(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		Integer casesId = getParameterAsInteger(req, "casesId");
		String indexs[] = req.getParameter("indexs").split(",");
		Cases cases = casesService.get(casesId);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases)) {
			String procedures = cases.getProcedures();
			Map[] map = ToolsKit.jsonUitl.toBean(Map[].class, procedures);
			for (int i = 0; i < indexs.length; i++) {
				for (int j = 0; j < map.length; j++) {
					String index = ToolsKit.TypeConversionUtil.asString(map[j].get("index"));
					if (indexs[i].equals(index)) {
						map[j].put("isTryIn", "ok");
						break;
					}
				}
			}
			int r = casesService.updateCasesProcedureAndStatus(casesId, ToolsKit.jsonUitl.toJson(map), Constans.CASE_ONHOLD_STATUS_TRYIN);
			if (r > 0) {
				result.setInfo("修改成功");
				result.setResult(Booleans.TRUE);
			}
		}
		outReturnAjaxResult(result, resp);
		LogUtil.addCasesLog(LogType.CASE_UPDATE, LogLevel.WARNING, "返回试戴", cases);
	}

	/**
	 * 
	 * @Title: defaultSearch
	 * @Description: 搜索
	 * @author ERIC
	 * @date 2014-10-16下午02:47:42
	 * @return void
	 */
	@RequestMapping("/default/search")
	public ModelAndView defaultSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String q = new String(request.getParameter("q").getBytes("ISO8859-1"), "UTF-8");
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(q)) {
			q = q.toLowerCase();
		}
		// 暂定为两种：病人、订单
		String type = ToolsKit.TypeConversionUtil.asString(request.getParameter("type"));
		// 病人搜索
		User user = getSessionUserByLoginEmail();
		Integer unitId = null;
		if (Constans.UNIT_LAB.equals(user.getUnitType())) {
			unitId = user.getLabId();
		} else if (Constans.UNIT_PRACTICE.equals(user.getUnitType())) {
			unitId = user.getPracticeId();
		}
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String url = "searchResult";

		// 每页显示4条
		Integer pageSize = 4;
		Integer pageNo = 1;
		if ("patients".equals(type) || ToolsKit.EmptyCheckUtil.isEmpty(type)) {
			Patient patientQuery = new Patient();
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				patientQuery.setLabId(unitId);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				patientQuery.setPracticeId(unitId);
				patientQuery.setUnitType(Integer.parseInt(user.getUnitType()));
			}
			patientQuery.setLabId(unitId);
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(q)) {
				patientQuery.setFirstName(q);
				patientQuery.setLastName(q);
				patientQuery.setExternalId(q);
			}

			if ("patients".equals(type)) {
				pageNo = 0;
				pageSize = 0;
				url = "searchResult_list";
			}

			List<Patient> patientList = patientService.queryPatientByCriteria(patientQuery, pageNo, pageSize);
			PageModel pm = new PageModel();
			if ("patients".equals(type)) {
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(patientList)) {
					pm.setTotal((long) patientList.size());
				}
				pm.setDatas(patientList);
			} else {
				pm = getPageModel(patientList, patientService.queryPatientCountByCriteria(patientQuery), pageSize, pageNo);
			}

			modelMap.put("patientPm", pm);
		}

		if ("cases".equals(type) || ToolsKit.EmptyCheckUtil.isEmpty(type)) {
			// 订单搜索
			Cases caseQuery = new Cases();
			if (StringUtil.isDigit(q)) {
				caseQuery.setCaseId(new Integer(q));
			}
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(q)) {
				caseQuery.setPatient(q);
			}
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				caseQuery.setLabId(unitId);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 诊所下单
				caseQuery.setPracticeId(unitId);
			}
			caseQuery.setUnitType(Integer.parseInt(user.getUnitType()));
			pageSize = 10;

			if ("cases".equals(type)) {
				pageNo = 0;
				pageSize = 0;
				url = "searchResult_list";
			}

			List<Cases> casesList = casesService.queryCasesBySearchCri(caseQuery, pageNo, pageSize);
			PageModel pmx = new PageModel();

			if ("cases".equals(type)) {
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(casesList)) {
					pmx.setTotal((long) casesList.size());
				}
				pmx.setDatas(casesList);
			} else {
				pmx = getPageModel(casesList, casesService.queryCasesCountBySearchCri(caseQuery), pageSize, pageNo);
			}

			modelMap.put("casesPm", pmx);
		}
		modelMap.put("q", q);
		modelMap.put("user", user);

		return new MyModelAndView().setViewName(url).addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: tryInUpdate
	 * @Description: 试戴订单-提交
	 * @author ERIC
	 * @date 2014-10-21下午02:53:00
	 * @return void
	 */
	@RequestMapping("/tryInUpdate")
	public void tryInUpdate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		Cases cases = new Cases();

		Integer caseId = getParameterAsInteger(req, "caseId");
		String procedures = req.getParameter("procedures");
		String patAppDate = req.getParameter("patAppDate");
		String caseNote = req.getParameter("caseNote");
		cases.setCaseId(caseId);
		// 病人预约
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(patAppDate)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			cases.setPatAppDate(sdf.parse(patAppDate));
		}
		// note
		CaseNotes note = new CaseNotes();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(caseNote)) {
			note.setCaseDate(new Date());
			User user = getSessionUserByLoginEmail();
			String uniteType = user.getUnitType();
			Cases cases2 = casesService.get(caseId);
			// 下单机构类型
			String caseType = cases2.getUnitType().toString();
			if (Constans.UNIT_PRACTICE.equals(caseType)) {
				note.setCaseFor(Constans.UNIT_PRACTICE.equals(uniteType) ? "技工间" : "诊所");
				note.setCaseFrom((ToolsKit.EmptyCheckUtil.isEmpty(user.getSalutation()) ? "" : user.getSalutation()) + user.getFirstName()
						+ user.getLastName() + "(" + (!Constans.UNIT_PRACTICE.equals(uniteType) ? "技工间" : "诊所") + ")");
			}
			if (Constans.UNIT_LAB.equals(caseType)) {
				note.setCaseFor((Constans.UNIT_LAB.equals(uniteType) && cases.getPracticeId().equals(user.getLabId())) ? "诊所" : "技工间");
				note.setCaseFrom((ToolsKit.EmptyCheckUtil.isEmpty(user.getSalutation()) ? "" : user.getSalutation()) + user.getFirstName()
						+ user.getLastName() + "("
						+ (!(Constans.UNIT_LAB.equals(uniteType) && cases.getPracticeId().equals(user.getLabId())) ? "诊所" : "技工间") + ")");
			}
			note.setCaseNote(caseNote);
			note.setCaseId(caseId);
		}
		// 工序
		String proJson = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(procedures) && !"[]".equals(procedures)) {
			labProcedureService.setProceduresDetailed(cases, procedures);
			List<Map<String, Object>> list = ToolsKit.jsonUitl.toBean(List.class, cases.getProcedures());
			Cases cas = casesService.get(caseId);
			List<Map<String, Object>> proList = ToolsKit.jsonUitl.toBean(List.class, cas.getProcedures());
			for (int i = 0; i < list.size(); i++) {
				proList.add(list.get(i));
			}
			proJson = ToolsKit.jsonUitl.toJson(proList);
		}

		int i = casesService.updateTryIn(cases, proJson, note);

		if (i > 0) {
			result.setInfo("提交成功");
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: getProcedureList
	 * @Description: 技工间动态获取订单对应的工序列表
	 * @author ERIC
	 * @date 2014-10-22上午09:15:32
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/lab/cases/getProcedureList")
	public ModelAndView getProcedureList(HttpServletRequest req) throws Exception {
		Integer caseId = getParameterAsInteger(req, "caseId");
		Cases cases = casesService.get(caseId);
		return new MyModelAndView().setViewName("lab/lab_return_tryin_dialog").addObject("proceduresList",
				labProcedureService.getProceduresDetailed(cases));
	}

	/**
	 * 
	 * @Title: goBargain
	 * @Description: 跳转到议价页面
	 * @author ERIC
	 * @date 2014-10-25下午01:51:59
	 * @return ModelAndView
	 */
	@RequestMapping("/goBargain")
	public ModelAndView goBargain(HttpServletRequest req) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer caseId = getParameterAsInteger(req, "caseId");
		Cases cases = casesService.get(caseId);
		modelMap.put("cases", cases);
		User user = getSessionUserByLoginEmail();
		modelMap.put("user", user);
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_bargain").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: doCasesPreferential
	 * @Description: 单一订单议价-改价
	 * @author ERIC
	 * @date 2014-10-25上午10:16:03
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/doCasesPreferential")
	public void doCasesPreferential(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		Integer caseId = getParameterAsInteger(req, "caseId");
		Double finishPrice = ToolsKit.TypeConversionUtil.asDouble(req.getParameter("askPrice"));
		Cases cases = new Cases();
		cases.setCaseId(caseId);
		cases.setFinishPrice(finishPrice);
		int i = casesService.updateCaseFinishPrice(cases);
		if (i > 0) {
			result.setInfo("提交成功");
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: goBargainRequest
	 * @Description: 跳转到优惠申请页面
	 * @author ERIC
	 * @date 2014-10-25上午11:49:01
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/goBargainRequest")
	public ModelAndView goBargainRequest(HttpServletRequest req) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer caseId = getParameterAsInteger(req, "caseId");
		Double finishPrice = ToolsKit.TypeConversionUtil.asDouble(req.getParameter("askPrice"));
		Cases cases = casesService.get(caseId);
		cases.setFinishPrice(finishPrice);
		modelMap.put("cases", cases);
		User user = getSessionUserByLoginEmail();
		modelMap.put("user", user);
		User userQuery = new User();
		userQuery.setLabId(user.getLabId());
		userQuery.setIsMain("true");
		List<User> users = userService.listAllByEqual(userQuery, 0, 0);
		for (User u : users) {
			if (u.getAccountId().equals(user.getAccountId())) {
				users.remove(u);
				break;
			}
		}
		modelMap.put("verifiers", users);
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_bargain_request").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: doBargainRequest
	 * @Description: 优惠申请提交
	 * @author ERIC
	 * @date 2014-10-25下午02:59:29
	 * @return void
	 * @throws Exception
	 */
	@RequestMapping("/doBargainRequest")
	public void doBargainRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		User user = getSessionUserByLoginEmail();
		CasesBargainRequest cbr = new CasesBargainRequest();
		DXObject.setValue(cbr, req);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cbr.getCaseId())) {
			Cases cases = casesService.get(cbr.getCaseId());
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(cases)) {
				cbr.setUnitId(cases.getPracticeId());
				cbr.setUnitType(cases.getUnitType());
				cbr.setOriginalPrice(cases.getOriginalPrice());
				cbr.setAskDate(new Date());
				cbr.setBargainLimit(user.getPreferentialLimit());
				cbr.setApplicantId(user.getAccountId());
				cbr.setApplicantName(user.getFirstName() + "." + user.getLastName());
				bargainRequestService.add(cbr);
				result.setInfo("提交成功");
				result.setResult(Booleans.TRUE);
			}
		}
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: goBargainVerify
	 * @Description: 跳转到优惠审批页面
	 * @author ERIC
	 * @date 2014-10-25下午04:28:39
	 * @return ModelAndView
	 */
	@RequestMapping("/goBargainVerify")
	public ModelAndView goBargainVerify(HttpServletRequest req) throws Exception {
		Integer id = getParameterAsInteger(req, "id");
		CasesBargainRequest cbr = bargainRequestService.get(id);
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_bargain_verify").addObject("bargainRequest", cbr)
				.addObject("user", getSessionUserByLoginEmail());
	}

	/**
	 * 
	 * @Title: doBargainVerify
	 * @Description: 议价-审批
	 * @author ERIC
	 * @date 2014-10-27上午10:31:50
	 * @return void
	 */
	@RequestMapping("/doBargainVerify")
	public void doBargainVerify(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		CasesBargainRequest cbr = new CasesBargainRequest();
		CasesBargainRequest bargainRequest = null;
		Integer isAgree = getParameterAsInteger(req, "isAgree");
		DXObject.setValue(cbr, req);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(cbr.getId())) {
			bargainRequest = bargainRequestService.get(cbr.getId());
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(bargainRequest)) {
				bargainRequest.setVerifyOpinion(cbr.getVerifyOpinion());
				bargainRequest.setVerifyDate(ToolsKit.DateUtil.nowDate());
				bargainRequest.setStatus(isAgree == 1 ? Constans.CASES_BARGAIN_VERIFY_AGREE : Constans.CASES_BARGAIN_VERIFY_DISAGREE);
				int i = bargainRequestService.updateBargain(bargainRequest);
				if (i > 0) {
					result.setInfo("提交成功");
					result.setResult(Booleans.TRUE);
				}
			}
		}
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: viewBargainVerify
	 * @Description: 查看议价-审核
	 * @author ERIC
	 * @date 2014-10-27下午01:43:04
	 * @return ModelAndView
	 */
	@RequestMapping("/viewBargainVerify")
	public ModelAndView viewBargainVerify(HttpServletRequest req) throws Exception {
		Integer id = getParameterAsInteger(req, "id");
		CasesBargainRequest cbr = bargainRequestService.get(id);
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_bargain_verify_view").addObject("bargainRequest", cbr)
				.addObject("user", getSessionUserByLoginEmail());
	}

	@RequestMapping("/viewBargainRequest")
	public ModelAndView viewBargainRequest(HttpServletRequest req) throws Exception {
		Integer id = getParameterAsInteger(req, "id");
		CasesBargainRequest cbr = bargainRequestService.get(id);
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_bargain_request_view").addObject("bargainRequest", cbr)
				.addObject("user", getSessionUserByLoginEmail());
	}

	@RequestMapping("/goEditBargainRequest")
	public ModelAndView goEditBargainRequest(HttpServletRequest req) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id = getParameterAsInteger(req, "id");
		CasesBargainRequest cbr = bargainRequestService.get(id);
		User user = getSessionUserByLoginEmail();
		modelMap.put("bargainRequest", cbr);
		User userQuery = new User();
		userQuery.setLabId(user.getLabId());
		userQuery.setIsMain("true");
		List<User> users = userService.listAllByEqual(userQuery, 0, 0);
		for (User u : users) {
			if (u.getAccountId().equals(user.getAccountId())) {
				users.remove(u);
				break;
			}
		}
		modelMap.put("verifiers", users);
		return new MyModelAndView().setViewName("u_lab/u_lab_Cases_bargain_request_edit").addAllObjects(modelMap);
	}

	@RequestMapping("/editBargainRequest")
	public void editBargainRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		User user = getSessionUserByLoginEmail();
		CasesBargainRequest cbr = new CasesBargainRequest();
		CasesBargainRequest bargainRequest = null;
		DXObject.setValue(cbr, req);
		bargainRequest = bargainRequestService.get(cbr.getId());
		bargainRequest.setAskPrice(cbr.getAskPrice());
		bargainRequest.setVerifierId(cbr.getVerifierId());
		bargainRequest.setVerifierName(user.getFirstName() + "," + user.getLastName());
		bargainRequest.setAskReason(cbr.getAskReason());
		bargainRequestService.update(bargainRequest);
		result.setInfo("提交成功");
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}

	/**
	 * 
	 * @Title: loadDraftCasesByLp
	 * @Description: 技工间-伙伴技工间页面加载草稿页面
	 * @author ERIC
	 * @date 2014-10-29上午09:06:24
	 * @return ModelAndView
	 */
	@RequestMapping("/loadDraftCasesByLp")
	public ModelAndView loadDraftCasesByLp(HttpServletRequest req) throws Exception {
		Integer labId = getParameterAsInteger(req, "rqLabId");
		MyModelAndView mav = new MyModelAndView();
		Cases caseQuery = new Cases();
		caseQuery.setLabId(labId);
		User user = getSessionUserByLoginEmail();
		caseQuery.setPracticeId(user.getLabId());
		caseQuery.setUnitType(Integer.valueOf(user.getUnitType()));
		// 草稿状态的订单
		PageModel pm = casesService.listCaseInDraf(caseQuery);
		mav.addObject("draftPm", pm);
		return mav.setViewName("u_lab/draft_cases");
	}

	/**
	 * 
	 * @Title: arrivePracticeCase 
	 * @Description: 诊所抵达
	 * @author ERIC 
	 * @date 2014-11-7下午04:50:20
	 * @return void
	 */
	@RequestMapping("/practice/cases/arrive")
	public void arrivePracticeCase(HttpServletRequest req, HttpServletResponse resp) {
		boolean success = false;
		String[] strArry = req.getParameterValues("cases[]");
		Integer[] intArry = new Integer[strArry.length];
		AjaxCaseResult result = new AjaxCaseResult();
		AjaxCaseResult.CasesTmp[] acrArray = new AjaxCaseResult.CasesTmp[intArry.length];
		AjaxCaseResult.CasesTmp acr = null;
		for (int i = 0; i < strArry.length; i++) {
			intArry[i] = Integer.parseInt(strArry[i]);
			acr = new AjaxCaseResult.CasesTmp();
			acr.setId(intArry[i]);
			acr.setDate(new Date());
			acr.setMsg("订单已抵达");
			Timestamp d = new Timestamp(System.currentTimeMillis());
			acr.setTimestamp(d);
			acrArray[i] = acr;
		}
		try {
			casesService.updateCasePracticeArriveBatch(intArry);
			success = true;
			result.setCt(acrArray);
			result.setSuccess(success);
			outJson(result, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: pickup 
	 * @Description: 诊所发出的收件请求
	 * @author ERIC 
	 * @date 2014-11-8下午03:05:11
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/pickup")
	public void pickup(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		Integer rqLabId = getParameterAsInteger(req, "reqAccLabId");
		String dateStr = ToolsKit.TypeConversionUtil.asString(req.getParameter("rqDate"));
		String timeStr = req.getParameter("rqTime");
		Date date = ToolsKit.DateUtil.parse(dateStr + " "+ timeStr);
		
		LogPojo log = new LogPojo();
		log.setLogLevel(LogLevel.GENERAL);
		log.setLogType(LogType.PICKUP_REQUEST);
		String unitName = "";
		Lab plab = labService.get(rqLabId);
		unitName = plab.getName();
		log.setPartnerId(plab.getId());
		log.setPartnerUnitType(Constans.UNIT_LAB);
		log.setPartnerUnitName(unitName);
		
		log.setRemarks(ToolsKit.DateUtil.formatDate(date, "yyyy-MM-dd") + "&nbsp;" + ToolsKit.DateUtil.getWeekCn(date));
		LogUtil.add(log);
		result.setInfo("提交成功");
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
		
	}
	
	/**
	 * 
	 * @Title: getRescheduleDialog 
	 * @Description: 跳转到重制订单页面
	 * @author ERIC 
	 * @date 2014-11-12下午05:07:50
	 * @return ModelAndView
	 */
	@RequestMapping("/lab/cases/getRescheduleDialog")
	public ModelAndView getRescheduleDialog(HttpServletRequest req) throws Exception{
		return new MyModelAndView().setViewName("lab/lab_reschedule_case_dialog").addObject("proOption", labProcedureService.getProedureAsHtml(getSessionUnitId()));
	}
	
	/**
	 * 
	 * @Title: applyRescheduleCase 
	 * @Description: 提交重制订单的修改
	 * @author ERIC 
	 * @date 2014-11-12下午05:07:45
	 * @return void
	 */
	@RequestMapping("/applyRescheduleCase")
	public void applyRescheduleCase(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "提交失败");
		Integer caseId = getParameterAsInteger(req, "caseId");
		String procedures = req.getParameter("procedures");
		Date deliveryDate = ToolsKit.DateUtil.parse(req.getParameter("deliveryDate"));
		Cases cases = new Cases();
		labProcedureService.setProceduresDetailed(cases, procedures);
		List<Map<String, Object>> list = ToolsKit.jsonUitl.toBean(List.class, cases.getProcedures());
		Cases cas = casesService.get(caseId);
		List<Map<String, Object>> proList = ToolsKit.jsonUitl.toBean(List.class, cas.getProcedures());
		for (int i = 0; i < list.size(); i++) {
			proList.add(list.get(i));
		}
		cas.setProcedures(ToolsKit.jsonUitl.toJson(proList));
		cas.setShipDate(deliveryDate);
		cas.setDeliveryDate(deliveryDate);
		cas.setLastUpdateDate(new Date());
		int r = casesService.updateCasesReschedule(cas);
		if (r > 0) {
			result.setInfo("提交成功");
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}
	
	@RequestMapping("/loadCaseCoupon")
	public ModelAndView loadCaseCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer caseId = getParameterAsInteger(request, "caseId");
		Cases caseQuery = casesService.get(caseId);
		List<LabCaseCoupons> labccList = caseCouponsService.queryCouponsByCases(caseQuery);

		if (ToolsKit.EmptyCheckUtil.isNotEmpty(labccList)) {
			LabProcedure lp = new LabProcedure();
			lp.setLabId(caseQuery.getLabId());
			List<LabProcedure> listlp = labProcedureService.listAllByEqual(lp, 0, 0);
			for (int i = 0; i < labccList.size(); i++) {
				LabCaseCoupons lc = labccList.get(i);
				p: for (int j = 0; j < listlp.size(); j++) {
					if (listlp.get(j).getProceduresId().equals(lc.getProceduresid())
							|| listlp.get(j).getProceduresId() == lc.getProceduresid()) {
						labccList.get(i).setProceduresName(listlp.get(j).getDisplayName());
						break p;
					}
				}
			}
		}
		return new MyModelAndView().setViewName("lab/addCoupontDialog").addObject("listCoupons", labccList);
	}
	
	@RequestMapping("/checkCaseCouponValid")
	public void checkCaseCouponValid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		String proceduresIds = request.getParameter("proceduresId");
		Integer requestLabId = getParameterAsInteger(request, "requestLabId");
		Integer caseId = getParameterAsInteger(request, "caseId");
		Cases cases = casesService.get(caseId);
		cases.setCouponCode(code);
		outReturnAjaxResult(caseCouponsService.checkCaseCouponValid(cases, requestLabId, proceduresIds, code), response);
	}
	
	@RequestMapping("/updateCouponDataToCases")
	public void saveCouponDataToCases(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		Integer caseId = getParameterAsInteger(request, "caseId");
		Cases cases = casesService.get(caseId);
		cases.setCouponCode(code);
		cases.setLastUpdateDate(new Date());
		outReturnAjaxResult(casesService.updateCouponDataToCases(cases), response);
	}
	
	@RequestMapping("/practicePrintWork")
	public ModelAndView practicePrintWork(HttpServletRequest request) throws Exception{
		Integer caseId = getParameterAsInteger(request, "caseId");
		Cases cases = casesService.get(caseId);
		Lab lab = labService.get(cases.getLabId());
		Practice practice = null;
		Lab pLab = null;
		if (cases.getUnitType().toString().equals(Constans.UNIT_PRACTICE)) {
			practice = practiceService.get(cases.getPracticeId());
		} else {
			pLab = labService.get(cases.getPracticeId());
		}
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<LabProceduresCharacteris> enclourseList = null;
		String enclosurestr = cases.getEnclosures();
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(enclosurestr)) {
			LabProceduresCharacteris lpc = new LabProceduresCharacteris();
			lpc.setType("enclosures");
			String[] str = enclosurestr.split(",");
			List<Integer> ids = new ArrayList<Integer>();
			for (String s : str) {
				ids.add(new Integer(s));
			}
			enclourseList = characterisService.queryCharacterisByIds(lpc, ids);
			modelMap.put("enclourses", enclourseList);
		}

		PageModel notePm = null;
		CaseNotes notes = new CaseNotes();
		notes.setCaseId(cases.getCaseId());
		User user = getSessionUserByLoginEmail();
		notes.setUnitId(user.getUnitId());
		notes.setUnitType(Integer.valueOf(user.getUnitType()));
		notePm = notesService.queryNotesByCriteria(notes);
		String cnote = null;
		if(notePm.getTotal()>0){
			for(int i=0;i<notePm.getDatas().size();i++){
				cnote = ((CaseNotes)notePm.getDatas().get(i)).getCaseNote();
				((CaseNotes)notePm.getDatas().get(i)).setCaseNote(cnote.replace("<p>", "").replace("</p>", "").replace("<br>", "").replace("</br>", ""));
			}
		}
		
		modelMap.put("notePm",notePm);
		modelMap.put("cases", cases);
		modelMap.put("lab", lab);
		modelMap.put("practice", practice == null ? pLab : practice);
		modelMap.put("proceduresList", labProcedureService.getProceduresDetailed(cases));
		
		return new MyModelAndView().setViewName("practice/print").addAllObjects(modelMap);
	}
	
	/**
	 * 
	 * @Title: workTicket 
	 * @Description: 跳转到工作单打印选项页面
	 * @author ERIC 
	 * @date 2014-11-19下午03:46:30
	 * @return ModelAndView
	 */
	@RequestMapping("/lab/case/workTicket")
	public ModelAndView workTicket(HttpServletRequest req){
		Integer casesId = getParameterAsInteger(req, "caseId");
		return new MyModelAndView().setViewName("u_lab/u_lab_workticket_option").addObject("caseId", casesId);
		
	}
	
	/**
	 * 
	 * @Title: printWorkTicket 
	 * @Description: 工作单打印
	 * @author ERIC 
	 * @date 2014-11-19下午03:47:00
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/lab/case/print")
	public ModelAndView printWorkTicket(HttpServletRequest req) throws Exception{
		Integer casesId = getParameterAsInteger(req, "caseId");
		Integer option_patient_info = getParameterAsInteger(req, "option_patient_info");
		Integer option_doctor_info = getParameterAsInteger(req, "option_doctor_info");
		Integer option_scheduling = getParameterAsInteger(req, "option_scheduling");
		Integer option_note = getParameterAsInteger(req, "option_note");
		Integer option_files = getParameterAsInteger(req, "option_files");
		Integer option_procedures = getParameterAsInteger(req, "option_procedures");
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		Cases cases = casesService.get(casesId);
		modelMap.put("cases", cases);
		
		if(option_patient_info.equals(Integer.valueOf(1))){
			Patient patient = patientService.get(cases.getPatientId());
			modelMap.put("patient", patient);
			modelMap.put("option_patient_info", option_patient_info);
		}
		
		if(option_doctor_info.equals(Integer.valueOf(1))){
			Practice practice = null;
			Lab pLab = null;
			if (cases.getUnitType().toString().equals(Constans.UNIT_PRACTICE)) {
				practice = practiceService.get(cases.getPracticeId());
			} else {
				pLab = labService.get(cases.getPracticeId());
			}
			modelMap.put("practice", practice == null ? pLab : practice);
			modelMap.put("option_doctor_info", option_doctor_info);
		}
		
		
		if(option_scheduling.equals(Integer.valueOf(1))){
			modelMap.put("option_scheduling", option_scheduling);
		}
		
		if(option_note.equals(Integer.valueOf(1))){
			PageModel notePm = null;
			CaseNotes notes = new CaseNotes();
			notes.setCaseId(cases.getCaseId());
			notePm = notesService.queryNotesByCriteria(notes);
			String cnote = null;
			if(notePm.getTotal()>0){
				for(int i=0;i<notePm.getDatas().size();i++){
					cnote = ((CaseNotes)notePm.getDatas().get(i)).getCaseNote();
					((CaseNotes)notePm.getDatas().get(i)).setCaseNote(cnote.replace("<p>", "").replace("</p>", "").replace("<br>", "").replace("</br>", ""));
				}
			}
			
			modelMap.put("notePm",notePm);
			modelMap.put("option_note", option_note);
		}
		
		if(option_files.equals(Integer.valueOf(1))){
			CaseAttachs attachs = new CaseAttachs();
			attachs.setCaseId(casesId);
			List<CaseAttachs> attachsList = caseAttachsService.queryAttachsByCriteria(attachs);
			modelMap.put("attachsList", attachsList);
			modelMap.put("option_files", option_files);
		}
		
		if(option_procedures.equals(Integer.valueOf(1))){
			modelMap.put("proceduresList", labProcedureService.getProceduresDetailed(cases));
			modelMap.put("option_procedures", option_procedures);
		}
		
		return new MyModelAndView().setViewName("lab/print_work_ticket").addAllObjects(modelMap);
	}
}
