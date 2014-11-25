/**   
 * @Title: PracticeAction.java 
 * @Package com.upcera.ddx.action 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-11 下午02:10:17 
 * @version V1.0   
 */
package com.upcera.ddx.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.common.security.CtyptoUtil;
import com.upcera.ddx.common.util.LogUtil;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.DDXLog;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.LabPermissions;
import com.upcera.ddx.entity.Patient;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.entity.UserAuthorities;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.pojo.LogPojo;
import com.upcera.ddx.pojo.LogPojo.LogLevel;
import com.upcera.ddx.pojo.LogPojo.LogType;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.pojo.Permissions;
import com.upcera.ddx.service.cases.ICasesService;
import com.upcera.ddx.service.lab.ILabPermissionsService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.practice.IPatientService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.ILogService;
import com.upcera.ddx.service.user.IUserService;

/**
 * @ClassName: PracticeAction
 * @Description: 诊所端Action
 * @author ERIC
 * @date 2014-6-11 下午02:10:17
 * 
 */
@Controller
@RequestMapping("/practiceAction")
public class PracticeAction extends BaseAction {

	@Autowired
	private IPracticeService service;
	@Autowired
	private BaseCache baseCache;
	@Autowired
	private ICasesService casesService;
	@Autowired
	private IPatientService patientService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ILabPermissionsService labPermissionsService;
	@Autowired
	private ILabService labService;
	@Autowired
	private CaseDataQuery caseDataQuery;
	@Autowired
	private ILabProcedureService labProcedureService;
	@Autowired
	private ILogService logService;
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 诊所登陆成功主页
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Cases caseQuery = new Cases();
		Map<String,Object> modelMap = new HashMap<String,Object>();
		PageModel pm = new PageModel();
		//试戴订单
		caseQuery.setPracticeId(getSessionPractice().getId());
		pm = casesService.listCaseTryInByPractice(caseQuery);
		modelMap.put("tryInPm", pm);
		//草稿状态的订单
		pm = casesService.listCaseInDraf(caseQuery);
		modelMap.put("draftPm", pm);
		
		//需跟踪的订单
		User user = getSessionUserByLoginEmail();
		if(!"false".equals(user.getAutoFollowCases())){
			pm = casesService.listCaseIsFollowed(caseQuery);
			modelMap.put("followedPm", pm);
		}
		//获取与诊所合作的技工间
		return new MyModelAndView().setViewName("practice/practice_index").addAllObjects(modelMap).addObject("listPartnerLabs",getPartnerLabList())
		.addObject("authority", service.getAllPartnerLabAndAuthority(getSessionUnitId()));
	}

	/**
	 * 
	 * @Title: pageJump
	 * @Description: 页面跳转
	 * @author ERIC
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return ModelAndView
	 */
	@RequestMapping("/pageJump")
	public ModelAndView pageJump(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String type = request.getParameter("type");
		if("signUpToPortal".equals(type)){
			mav.setViewName("u_practice/u_practice_AddLab");
		}
		return mav;

	}

	/**
	 * 
	 * @Title: partners
	 * @Description: 搜索伙伴技工间
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/partners")
	public ModelAndView partners(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<Lab> listLab = getPartnerLabList();
		return new ModelAndView("u_practice/u_practice_AddLab").addObject("listPartnerLabs",listLab );
	}
	/**
	 * 
	 * @Title: practice
	 * @Description: 诊所中心
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/practice")
	public ModelAndView practice(HttpServletRequest req,HttpServletResponse response) throws Exception{

		Map<String,Object> modelMap = new HashMap<String,Object>();
		String method = req.getParameter("portal");
		//请求伙伴技工间的labid
		Integer id = getParameterAsInteger(req, "id");
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(id)){
			modelMap.put("requestAccountLab", labService.get(id));
			
			Permissions per = getLabPermissions(id);
			//提供的订单权限
			modelMap.put("financesPermissions", per.getFinances());
			//提供的财政权限
			modelMap.put("casesPermissions", per.getCases());
		}
		
		String mappingUrl = baseCache.getModelAndViewMappingMap().get(method);
		
		Object datas = null;
		try {
			Method meth = this.getClass().getMethod(method, HttpServletRequest.class);
			
			datas = meth.invoke(this, req);
			modelMap.put("datas", datas);
			modelMap.put("listPartnerLabs",getPartnerLabList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.put("sessionUser", getSessionUserByLoginEmail());
		return new MyModelAndView().setViewName(mappingUrl).addAllObjects(modelMap);
	}
	/**
	 * 
	 * @Description: 病人
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	public Object patients(HttpServletRequest req){
		try {
			Integer pageNo = getParameterAsInteger(req,"offset");
			String isSearch = req.getParameter("isSearch");
			String search = req.getParameter("search");
			//默认取第一页
			if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
				pageNo = 1;
			}
			Patient patientQuery = new Patient();
			User user = getSessionUserByLoginEmail();
			// 发送方ID
			Integer unitId = getSessionUnitId();
			// 技工间向伙伴技工间下订单 接收方ID
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				patientQuery.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 技工间下单
				patientQuery.setUnitType(2);
			}
			
			patientQuery.setPracticeId(unitId);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(isSearch)){
				patientQuery.setKeyword(search.toLowerCase());
			}
			//每页显示10条
			Integer pageSize = 10;
			// 得到结果集
			List<Patient> patientList = patientService.queryPatientBySearch(patientQuery, pageNo, pageSize);
			PageModel pm = getPageModel(patientList, patientService.queryPatientCountBySearch(patientQuery), pageSize, pageNo);
			return pm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: patient 
	 * @Description: 患者详情
	 * @author ERIC 
	 * @date 2014-8-16下午02:13:03
	 * @return Object
	 * @throws Exception 
	 */
	public Object patient(HttpServletRequest req) throws Exception{
		Integer pageNo = getParameterAsInteger(req,"offset");
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;

		Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
		Patient patient = patientService.get(id);
		Cases caseQuery = new Cases();
		caseQuery.setPatientId(id);
		List<Cases> casesList = casesService.queryCasesByPatient(caseQuery, pageNo, pageSize);
		PageModel casesPm = getPageModel(casesList,	casesService.queryCasesCountByPatient(caseQuery), pageSize, pageNo);
		Map<String,Object> modelMap = new HashMap<String, Object>();
		modelMap.put("patient", patient);
		modelMap.put("casesPm", casesPm);
		return modelMap;
	}
	
	/**
	 * 
	 * @Description: 抵达案例
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	public Object arrive_cases(HttpServletRequest req) throws Exception{
		Integer pageNo = getParameterAsInteger(req,"offset");
		String search = req.getParameter("search");
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		
		Integer unitId = getSessionUnitId();
		Cases cases = new Cases();
		cases.setArrived(0);
		cases.setPracticeId(unitId);
		cases.setUnitType(Integer.parseInt(Constans.UNIT_PRACTICE));
		//搜索字段设置
		cases.setCaseName(search);
		List<Cases> caseList = casesService.queryArriveCasesByPratice(cases, pageNo, pageSize);
		for (int i = 0; i < caseList.size(); i++) {
			Integer labId = caseList.get(i).getLabId();
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(labId)){
				Lab lab = labService.get(labId);
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(lab)){
					caseList.get(i).setMsg(lab.getName());
				}
			}
			Integer pId = caseList.get(i).getPatientId();
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(pId)){
				Patient pa = patientService.get(pId);
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(pa)){
					caseList.get(i).setPatient(pa.getFirstName()+pa.getLastName());
				}
			}
			caseList.get(i).setExtObj(labProcedureService.getProceduresDetailed(caseList.get(i)));
			
		}
		return getPageModel(caseList, casesService.queryArriveCasesCountByPratice(cases), pageSize, pageNo);
	}
	/**
	 * 
	 * @Description: 标签案例
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	public Object tagged_cases(HttpServletRequest req) throws Exception{
		PageModel pm = new PageModel();
		Cases caseQuery = new Cases();
		caseQuery.setPracticeId(getSessionUnitId());
		caseQuery.setUnitType(Integer.parseInt(Constans.UNIT_PRACTICE));
		pm.setDatas(casesService.queryEveryTagAndCount(caseQuery));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("counts", pm);
		result.put("cases", new PageModel());
		return result;
	}
	/**
	 * 
	 * @Description: 用户
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	public Object users(HttpServletRequest req){
		return null;
	}
	/**
	 * 
	 * @Description: 诊所详情
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	public Object practice(HttpServletRequest req){
		Practice practice = getSessionPractice();
		return practice;
	}
	/**
	 * 
	 * @Description: 诊所端查询价格列表
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	public Object financePricerList(HttpServletRequest req) throws Exception{
		req.setAttribute("flag", "financePricerList");
		req.setAttribute("labId", getParameterAsInteger(req, "id"));//合作伙伴id
		req.setAttribute("type", getSessionUserByLoginEmail().getUnitType());
		return caseDataQuery.practicePriceList(req);
	}
	
	/**
	 * 
	 * @Title: 分页查询标记案例
	 * @Description: 诊所中心
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/listTagsCases")
	public ModelAndView listTagsCases(HttpServletRequest req,HttpServletResponse response) throws Exception{
		String tags = req.getParameter("tags");
		Integer pageSize = 10;
		Integer pageNo = getParameterAsInteger(req,"offset");
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		PageModel pm = new PageModel();
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(tags)){
			Cases cases = new Cases();
			cases.setTags(tags);
			cases.setPracticeId(getSessionUnitId());
			cases.setUnitType(Integer.parseInt(Constans.UNIT_PRACTICE));
			List<Cases> listCase = casesService.queryCasesByTags(cases, pageNo, pageSize);
			for (int i = 0; i < listCase.size(); i++) {
				Integer unitId = listCase.get(i).getLabId();
				if(unitId!=null){
					Lab lab = labService.get(unitId);
					if(lab!=null){
						listCase.get(i).setMsg(lab.getName());
					}
				}
				listCase.get(i).setExtObj(labProcedureService.getProceduresDetailed(listCase.get(i)));
			}
			pm = getPageModel(listCase, casesService.queryCasesCountByTags(cases), pageSize, pageNo);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("cases", pm);
		return new ModelAndView("practice/practice_TaggedCases_div").addObject("datas", result);
	}
	/**
	 * 
	 * @Title: 分页查询已抵达案例
	 * @Description: 诊所中心
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/listArriveCases")
	public ModelAndView listArriveCases(HttpServletRequest req,HttpServletResponse response) throws Exception{
		return new ModelAndView("practice/practice_ArriveCases_div").addObject("datas", arrive_cases(req));
	}
	
	/**
	 * 
	 * @Description: 诊所发生事项
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getEvents")
	public ModelAndView getEvents(HttpServletRequest req,HttpServletResponse response) throws Exception{
		String dateStr = req.getParameter("date");
		String type = req.getParameter("type");
		
		Date date =  ToolsKit.DateUtil.parse(dateStr, "yyyy-MM-dd");
		Integer dayint = null;
		if("LastWeek".equals(type)){
			dayint = -5;
		}else if("NextWeek".equals(type)){
			dayint = 5;
		}
		Date startDate = ToolsKit.DateUtil.addDay(date, dayint);
		Date endDate = ToolsKit.DateUtil.addDay(startDate, +6);
		
		DDXLog log = new DDXLog();
		User sessionUser = getSessionUserByLoginEmail();
		log.setUnitId(sessionUser.getUnitId());
		log.setUnitType(sessionUser.getUnitType());
		log.setLogLevel(LogLevel.EVENTS.toString());
		log.setPartnerUnitType(sessionUser.getUnitType());
		log.setLogType(LogType.CASE_UPDATE.toString()+","+LogType.CASE_CREATE.toString());
		List<DDXLog> logs = LogUtil.getLogService().loadLog(log, startDate, endDate);
		
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < logs.size(); i++) {
			String createDate = ToolsKit.DateUtil.formatDate(logs.get(i).getCreateDate(), "yyyy-MM-dd");
			List<DDXLog> list = (List)map.get(createDate);
			if(list==null){
				list = new ArrayList<DDXLog>();
				map.put(createDate, list);
			}
			list.add(logs.get(i));
		}
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 6; i++) {
			String day = ToolsKit.DateUtil.formatDate(ToolsKit.DateUtil.addDay(startDate, i), "yyyy-MM-dd");
			Map<String, Object> imap = new HashMap<String, Object>();
			imap.put("day", day);
			imap.put("data", map.get(day));
			result.add(imap);
		}
		return new ModelAndView("practice/practice-events").addObject("datas", result).addObject("startDate", ToolsKit.DateUtil.formatDate(startDate, "yyyy-MM-dd"));
	}
	
	/**
	 * 
	 * @Description: 诊所警示
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/getAlert")
	public ModelAndView getAlert(HttpServletRequest req,HttpServletResponse response){
		return new ModelAndView("practice/practice-alert");
	}
	/**
	 * 
	 * @Description: 诊所动态
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/getActivity")
	public ModelAndView getActivity(HttpServletRequest req,HttpServletResponse response) throws Exception{
		Date date =  null;
		String week = req.getParameter("week");
		String type = req.getParameter("type");
		String dateStr = req.getParameter("date");
		if("today".equals(dateStr)){
			date = ToolsKit.DateUtil.nowDate();
		}else{
			date =  ToolsKit.DateUtil.parse(dateStr, "yyyy-MM-dd");
		}
		Integer dayint = null;
		if("LastWeek".equals(week)){
			dayint = -7;
		}else if("NextWeek".equals(week)){
			dayint = 7;
		}
		Date startDate = ToolsKit.DateUtil.addDay(date, dayint);
		Date endDate = ToolsKit.DateUtil.addDay(startDate, +8);
		User sessionUser = userService.getSessionUserByLoginEmail();
		List<Map<String, Object>> result = logService.getActivitiesLog(type, startDate, endDate,sessionUser);
		
		return new ModelAndView("lab/lab-main-log").addObject("datas", result).addObject("startDate", ToolsKit.DateUtil.formatDate(startDate, "yyyy-MM-dd")).addObject("sessionUser", sessionUser);
	
	
	}
	/**
	 * 
	 * @Description: 诊所新闻
	 * @author king
	 * @date 2014-6-11下午02:16:08
	 * @param
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/getNews")
	public ModelAndView getNews(HttpServletRequest req,HttpServletResponse response){
		return new ModelAndView("practice/practice-news");
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
	@RequestMapping("/patients")
	public ModelAndView patients(HttpServletRequest request,HttpServletResponse response){
		
		try {
			Integer pageNo = getParameterAsInteger(request,"offset");
			String isSearch = request.getParameter("isSearch");
			String search = request.getParameter("search");
			//默认取第一页
			if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
				pageNo = 1;
			}
			Patient patientQuery = new Patient();
			
			User user = getSessionUserByLoginEmail();
			// 发送方ID
			Integer unitId = getSessionUnitId();
			// 技工间向伙伴技工间下订单 接收方ID
			if ((Constans.UNIT_LAB).equals(user.getUnitType())) {
				// 技工间下单
				patientQuery.setUnitType(1);
			}
			if ((Constans.UNIT_PRACTICE).equals(user.getUnitType())) {
				// 技工间下单
				patientQuery.setUnitType(2);
			}
			
			patientQuery.setPracticeId(unitId);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
				patientQuery.setKeyword(search.toLowerCase());
			}
			//每页显示10条
			Integer pageSize = 10;
			// 得到结果集
			List<Patient> patientList = patientService.queryPatientBySearch(patientQuery, pageNo, pageSize) ;
			PageModel pm = getPageModel(patientList, patientService.queryPatientCountBySearch(patientQuery), pageSize, pageNo);
			return new MyModelAndView().setViewName("practice/practice_Patients_show").addObject("datas", pm).addObject("search", search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @Title: getPatientById 
	 * @Description: 获取患者及患者对应的订单
	 * @author ERIC 
	 * @date 2014-8-15上午10:57:47
	 * @return ModelAndView
	 */
	@RequestMapping("/patient")
	public ModelAndView getPatientById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Integer pageNo = getParameterAsInteger(request,"offset");
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;

		Integer id = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("id"));
		Patient patient = patientService.get(id);
		Cases caseQuery = new Cases();
		caseQuery.setPatientId(id);
		List<Cases> casesList = casesService.listAllByEqual(caseQuery, pageNo, pageSize);
		PageModel casesPm = getPageModel(casesList,	casesService.getCountByEqual(caseQuery), pageSize, pageNo);
		return new MyModelAndView().setViewName("practice/practice_Patient_detail").addObject("patient", patient)
				.addObject("casesPm", casesPm).addObject("listPartnerLabs",getPartnerLabList());
	}
	
	/**
	 * 
	 * @Title: details 
	 * @Description: 获取诊所详情
	 * @author ERIC 
	 * @date 2014-8-15上午09:20:25
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/details")
	public ModelAndView details(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Practice practice = getSessionPractice();
		Map<String,Object> modelMap = new HashMap<String, Object>();
		modelMap.put("practice", practice);
		modelMap.put("listPartnerLabs",getPartnerLabList());
		return new MyModelAndView().setViewName("practice/practice_month_PracticeDetails").addAllObjects(modelMap);
	}
	
	@RequestMapping("/loadProviders")
	public void loadProviders(HttpServletRequest request,HttpServletResponse response) throws Exception{
		User user0 = new User();
		user0.setUnitType(Constans.UNIT_PRACTICE);
		Practice practice = getSessionPractice();
		user0.setPracticeId(practice.getId());
		List<User> userList = userService.queryPracticeProviders(user0);
		outReturnString(ToolsKit.jsonUitl.toJson(userList), response);
	}

	/**
	 * 
	 * @Title: updatePractice 
	 * @Description: 更新诊所信息
	 * @author ERIC 
	 * @date 2014-8-15下午04:05:25
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/updatePractice")
	public void updatePractice(HttpServletRequest request,HttpServletResponse response) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
				
		try {
			Practice practice = new Practice();
			Practice practice0 = new Practice();
			DXObject.setValue(practice, request);
			String[] arry = request.getParameterValues("providers[]");
			String arryStr = "";
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(arry)){
				for(int i = 0 ;i < arry.length;i++){
					arryStr += arry[i]+",";
				}
				if(arryStr.length()>0){
					arryStr = arryStr.substring(0, arryStr.length()-1);
				}
				practice.setProviders(arryStr);
			}
			practice0 = getSessionPractice();
			Integer id = practice0.getId();
			practice.setId(id);
			practice.setAccountStatus(practice0.getAccountStatus());
			service.update(practice);
			result.setResult(Booleans.TRUE);
			result.setInfo("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(result, response);
	}
	
	/**
	 * 
	 * @Title: identity 
	 * @Description: 更新诊所信息成功后跳转到的页面
	 * @author ERIC 
	 * @date 2014-8-15下午05:07:35
	 * @return ModelAndView
	 */
	@RequestMapping("/identity")
	public ModelAndView identity(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Practice practice = getSessionPractice();
		return new MyModelAndView().setViewName("practice/practice_detail_identity").addObject("practice", practice).addObject("listPartnerLabs",getPartnerLabList());
	}
	
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 修改诊所用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/updateUser")
	public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		Map<String, String> respMap = new HashMap<String, String>();
		User user = null;
		try {
			user = new User();
			DXObject.setValue(user, req);
			user.setPassword(CtyptoUtil.EncryptString(req.getParameter("password")));
			
			String labPermissions = req.getParameter("labPermissions");
			
			user.setLabPermissions(ToolsKit.jsonUitl.toJson(setLabPermissions(labPermissions)));
			
			if(userService.updateUserSetting(user)>0){
				result.setResult(Booleans.TRUE);
			}
			result.setInfo("updatePracticeUser");
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}finally{
			try {
				LogUtil.addUserLog(user, "修改账户:"+user.getFirstName()+user.getLastName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String isManagerAccount = "false";
		if("true".equals(getSessionUserByLoginEmail().getIsMain()) || "true".equals(getSessionUserByLoginEmail().getManagerAccount())){
			isManagerAccount = "true";
		}
		result.setFailReasons(isManagerAccount);
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Description: 设置用户的技工间操作权限
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> setLabPermissions(String json) throws Exception{
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object>[] map = ToolsKit.jsonUitl.toBean(Map[].class, json);
		for (int i = 0; i < map.length; i++) {
			String str = ToolsKit.TypeConversionUtil.asString(map[i].get("permissions"));
			String[] str2 = str.split(";");
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(str2) && str2.length>1){
				Map<String, Object> imap = new HashMap<String, Object>();
				for (int j = 0; j < str2.length; j++) {
					String fied = str2[j].split(":")[0];
					String check = str2[j].split(":")[1];
					imap.put(fied, check);
				}
				m.put(ToolsKit.TypeConversionUtil.asString(map[i].get("id")), imap);
			}
		}
		return m;
	}
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 增加诊所用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/addUser")
	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		User user = null;
		try {
			user = new User();
			DXObject.setValue(user, req);
			user.setPassword(CtyptoUtil.EncryptString(req.getParameter("password")));
			user.setPracticeId(getSessionUserByLoginEmail().getPracticeId());
			
			UserAuthorities ua = new UserAuthorities();
			ua.setUsername(user.getEmail());
			ua.setAuthority(Constans.ROLE_PRACTICE);
			user.setUnitType(Constans.UNIT_PRACTICE);
			
			String labPermissions = req.getParameter("labPermissions");
			
			user.setLabPermissions(ToolsKit.jsonUitl.toJson(setLabPermissions(labPermissions)));
			userService.addLabUser(user, ua);
			
			result.setResult(Booleans.TRUE);
			result.setInfo("addPracticeUser");
			if("requestAccount".equals(req.getParameter("operation"))){
				result.setInfo("requestAccount");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}finally{
			try {
				LogUtil.addUserLog(user,"增加账户:"+user.getFirstName()+user.getLastName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		outReturnAjaxResult(result, resp);
	}
	
	
	/**
	 * 
	 * @Title: deleteUser 
	 * @Description: 删除诊所用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/deleteUser")
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		User user = null;
		try {
			Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
			user = userService.get(id);
			userService.delete(id);
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}finally{
			try {
				LogUtil.addUserLog(user,"删除账户:"+user.getFirstName()+user.getLastName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: listUser 
	 * @Description: 诊所用户列表,根据条件查询
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return practice_UserAccounts_div.jsp 用户列表
	 */
	@RequestMapping("/listUserSearch")
	public ModelAndView listUserSearch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User sessionUser = getSessionUserByLoginEmail();
		if(!"true".equals(sessionUser.getIsMain()) && 
				!"true".equals(sessionUser.getManagerAccount())){
			throw new Exception("权限不足，禁止访问！");
		}
		Integer practiceId = sessionUser.getPracticeId();
		Integer pageNo = getParameterAsInteger(req,"offset");
		String search = req.getParameter("search");
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		User user = new User();
		user.setEmail(search);
		user.setFirstName(search);
		user.setLastName(search);
		user.setUserName(search);
		user.setSalutation(search);
		user.setPracticeId(practiceId);
		//每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		List<User> datas = userService.listAllByLike(user, pageNo,pageSize);
		
		PageModel pm = getPageModel(datas, userService.getCountByLike(user), pageSize, pageNo);
		
		return new MyModelAndView().setViewName("practice/practice_UserAccounts_div").addObject("pm",pm).addObject("search", search);
	}
	/**
	 * 
	 * @Title: getPartnerLabList 
	 * @Description: 获取合作技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getPartnerLabList")
	public ModelAndView getPartnerLabList(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Integer userId = getParameterAsInteger(req, "userId");
		Map<String, Object> lpermiss = null;
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(userId)){
			User user = userService.get(userId);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(user.getLabPermissions())){
				lpermiss = ToolsKit.jsonUitl.toBean(Map.class, user.getLabPermissions());
			}
		}
		List<Lab> labs = getPartnerLabList();
		for (int i = 0; i < labs.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", labs.get(i).getId());
			map.put("name", labs.get(i).getName());
			
			LabPermissions lp = new LabPermissions();
			lp.setLabId(labs.get(i).getId());
			List<LabPermissions> lpList = labPermissionsService.listAllByEqual(lp, 0, 0);
			
			LabPermissions.Cases cases = null;
			LabPermissions.Finances finances = null;
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(lpList)){
				if(lpList.size()==1){
					cases = ToolsKit.jsonUitl.toBean(LabPermissions.Cases.class, lpList.get(0).getCases());
					finances = ToolsKit.jsonUitl.toBean(LabPermissions.Finances.class, lpList.get(0).getFinances());
				}else if(lpList.size()>1){
					throw new Exception("数据错误,数据库出现冗余授权记录，技工间："+labs.get(i).getName());
				}
			}
			map.put("cases", cases);
			map.put("finances", finances);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(lpermiss)){
				Map pMap = (Map)lpermiss.get(labs.get(i).getId()+"");
				map.put("pMap", pMap);
			}
			
			list.add(map);
		}
		return new ModelAndView("u_practice/labPermissions").addObject("labs", list);
	}
	/**
	 * 
	 * @Title: getUser 
	 * @Description: 根据id查询用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/getUser")
	public ModelAndView getUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer userId = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("userId"));
		User user = userService.get(userId);
		User.DDXActivityLog log = null;
		try {
			log = ToolsKit.jsonUitl.toBean(User.DDXActivityLog.class, user.getDdxActivityLog());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return new MyModelAndView()
					.setViewName("u_practice/u_practice_UserAccounts_Edit")
					.addObject("MyUser",user)
					.addObject("LogSetting", log)
					.addObject("sessionUser", getSessionUserByLoginEmail())
					.addObject("listPartnerLabs",getPartnerLabList());
	}
	
	/**
	 * 
	 * @Title: financeOverview 
	 * @Description: 跳转至账户概述
	 * @author ERIC 
	 * @date 2014-8-22下午03:03:50
	 * @return Object
	 */
	public Object financeOverview(HttpServletRequest req){
		return null;
	}
	
	/**
	 * 
	 * @Title: financePayment 
	 * @Description: 跳转至账户支付
	 * @author ERIC 
	 * @date 2014-8-22下午03:04:13
	 * @return Object
	 */
	public Object financePayment(HttpServletRequest req){
		return null;
	}

	/**
	 * 
	 * @Title: payment 
	 * @Description: 账户支付
	 * @author ERIC 
	 * @date 2014-8-22下午04:24:13
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/finances/payment")
	public void payment(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "error");
		Integer labId = getParameterAsInteger(req, "id");
		String amount = req.getParameter("amount");
		LogPojo log = new LogPojo();
		log.setLogLevel(LogLevel.GENERAL);
		log.setLogType(LogType.PAYMENT);
		Practice p = getSessionPractice();
		log.setRemarks("来自"+p.getName() +"的对" + amount +"元的账户余额付款授权");
		try {
			LogUtil.add(log);
			result.setResult(Booleans.TRUE);
			result.setInfo("保存成功！");
			outReturnAjaxResult(result, resp);
		} catch (Exception e) {
			result.setFailReasons("出错了！");
			e.printStackTrace();
		}
		
	}
}
