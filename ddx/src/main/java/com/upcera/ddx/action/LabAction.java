package com.upcera.ddx.action;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.cache.impl.ProcedurePriceAttrCache;
import com.upcera.ddx.common.excel.AbstractExcelService;
import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.common.security.CtyptoUtil;
import com.upcera.ddx.common.target.Note;
import com.upcera.ddx.common.util.LogUtil;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.common.util.ToolsKit.DateUtil;
import com.upcera.ddx.common.util.ToolsKit.EmptyCheckUtil;
import com.upcera.ddx.common.util.ToolsKit.TypeConversionUtil;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.entity.CaseRemake;
import com.upcera.ddx.entity.CaseShipping;
import com.upcera.ddx.entity.CaseTerms;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.Caseschedulingholida;
import com.upcera.ddx.entity.DDXLog;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.LabPermissions;
import com.upcera.ddx.entity.LabPracticeNotes;
import com.upcera.ddx.entity.LabPracticePreferences;
import com.upcera.ddx.entity.LabPreference;
import com.upcera.ddx.entity.LabPriceGroup;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.entity.LabProcedureAttr;
import com.upcera.ddx.entity.LabProceduresOutLink;
import com.upcera.ddx.entity.LabProceduresPrice;
import com.upcera.ddx.entity.PartnerLab;
import com.upcera.ddx.entity.Patient;
import com.upcera.ddx.entity.ProcedureDisplayCategory;
import com.upcera.ddx.entity.ProcedureSubCategory;
import com.upcera.ddx.entity.ProcedureType;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.entity.UserAuthorities;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.AjaxResult.Booleans;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.LogPojo;
import com.upcera.ddx.pojo.Permissions;
import com.upcera.ddx.pojo.LogPojo.LogLevel;
import com.upcera.ddx.pojo.LogPojo.LogType;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.cases.ICaseCouponsService;
import com.upcera.ddx.service.cases.ICaseRemakeService;
import com.upcera.ddx.service.cases.ICaseSchedulingHolidaService;
import com.upcera.ddx.service.cases.ICaseTermsService;
import com.upcera.ddx.service.cases.ICaseholdService;
import com.upcera.ddx.service.cases.ICasesService;
import com.upcera.ddx.service.cases.ICasesShippingService;
import com.upcera.ddx.service.lab.ILabPermissionsService;
import com.upcera.ddx.service.lab.ILabPracticeNotesService;
import com.upcera.ddx.service.lab.ILabPreferenceService;
import com.upcera.ddx.service.lab.ILabPriceGroupService;
import com.upcera.ddx.service.lab.ILabProcedureAttrService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabProceduresOutLinkService;
import com.upcera.ddx.service.lab.ILabProceduresPriceService;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.lab.IPartnerLabService;
import com.upcera.ddx.service.lab.IPracticePreferencesService;
import com.upcera.ddx.service.lab.IProcedureDisplayCategoryService;
import com.upcera.ddx.service.lab.IProcedureSubCategoryService;
import com.upcera.ddx.service.lab.IProcedureTypeService;
import com.upcera.ddx.service.practice.IPatientService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.ILogService;
import com.upcera.ddx.service.user.IUserService;

/**
 * 
 * @Description: 技工间action
 * @author king 
 * @date 2014-6-24 10:32:54
 */
@Controller
@RequestMapping("/labAction")
public class LabAction extends BaseAction {
	@Autowired
	private BaseCache baseCache;
	@Autowired
	private CaseDataQuery caseDataQuery;
	@Autowired
	private ILabService labService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ILabPermissionsService labPermissionsService;
	@Autowired
	private IPartnerLabService partnerLabService;
	@Autowired
	private ILabPreferenceService preferenceService;
	@Autowired
	private IPracticeService practiceService;
	@Autowired
	private ICaseholdService caseholdService;
	@Autowired
	private IPracticePreferencesService practicePreferencesService;
	@Autowired
	private ILabPracticeNotesService labPracticeNotesService;
	@Autowired
	private ICaseRemakeService caseRemakeService;
	@Autowired
	private ICaseTermsService caseTermsService;
	@Autowired
	private IProcedureDisplayCategoryService procedureDisplayCategoryService;
	@Autowired
	private ILabProcedureService labProcedureService;
	@Autowired
	private IProcedureSubCategoryService procedureSubCategoryService;
	@Autowired
	private IProcedureTypeService procedureTypeService;
	@Autowired
	private ICaseSchedulingHolidaService caseSchedulingHolidaService;
	@Autowired
	private ICaseCouponsService caseCouponsService;
	@Autowired
	private ILabProceduresPriceService labProceduresPriceService;
	@Autowired
	private ILabProcedureAttrService labProcedureAttrService;
	@Autowired
	private ILabProceduresOutLinkService labProceduresOutLinkService;
	@Autowired
	private ICasesShippingService casesShippingService;
	@Autowired
	private ILabPriceGroupService labPriceGroupService;
	@Autowired
	private IPatientService patientService;
	@Autowired
	private ICasesService casesService;
	@Autowired
	private ILogService logService;
	
	private static final Logger logger = LoggerFactory.getLogger(LabAction.class); 
	/**
	 * 
	 * @Title: main 
	 * @Description: 技工间登陆成功主页跳转
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("month", month);
		map.put("year", year);
		return new MyModelAndView().setViewName("lab/lab_index").addAllObjects(map);
	}
	/**
	 * 
	 * @Title: main 
	 * @Description: 技工间注册成功主页跳转
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/signupSuccess")
	public ModelAndView signupSuccess(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new MyModelAndView().setViewName("u_lab/u_lab_index");
	}
	
	
	/**
	 * 
	 * @Title: /query 
	 * @Description: 通用数据展示
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/query")
	public ModelAndView query(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String method = req.getParameter("method");
		//分页标识
		String type = req.getParameter("type");
		String mappingUrl = baseCache.getModelAndViewMappingMap().get(method);
		//用于分页操作
		if("paging".equals(type)){
			mappingUrl += "_show";
		}
		Object datas = null;
		try {
			Method meth = caseDataQuery.getClass().getMethod(method, HttpServletRequest.class);
			datas = meth.invoke(caseDataQuery, req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return new MyModelAndView().setViewName(mappingUrl).addObject("datas", datas).addObject("method", method);
	}
	
	/**
	 * 
	 * @Title: reports 
	 * @Description: 技工间报告
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/reports")
	public ModelAndView reports(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new ModelAndView("u_lab/u_lab_Reports").addObject("filterOptions", getFilterOptions(null));
	}
	/**
	 * 
	 * @Title: finance 
	 * @Description: 财务报告
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/reports/finance")
	public ModelAndView finance(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new ModelAndView("u_lab/u_lab_Reports_finance");
	}
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 修改技工间用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/setting/updateUser")
	public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		User user = null;
		try {
			user = new User();
			DXObject.setValue(user, req);
			user.setPassword(CtyptoUtil.EncryptString(req.getParameter("password")));
			if(userService.updateUserSetting(user)>0){
				result.setResult(Booleans.TRUE);
				result.setInfo("修改成功");
			}
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
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 增加技工间用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/setting/addUser")
	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		User user = null;
		try {
			user = new User();
			DXObject.setValue(user, req);
			user.setPassword(CtyptoUtil.EncryptString(req.getParameter("password")));
			user.setLabId(getSessionUserByLoginEmail().getLabId());
			user.setUnitType(Constans.UNIT_LAB);
			
			UserAuthorities ua = new UserAuthorities();
			ua.setUsername(user.getEmail());
			ua.setAuthority(Constans.ROLE_LAB);
			
			userService.addLabUser(user, ua);
			result.setResult(Booleans.TRUE);
			result.setInfo("增加成功");
			if("requestAccount".equals(req.getParameter("operation"))){
				result.setInfo("requestAccount");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}finally{
			try {
				LogUtil.addUserLog(user, "增加账户:"+user.getFirstName()+user.getLastName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		outReturnAjaxResult(result, resp);
	}
	
	@RequestMapping("/addOnHold")
	public void addOnHold(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result=new AjaxResult(Booleans.FALSE,"增加失败");
		try{
			CaseHold caseHold=new CaseHold();
			DXObject.setValue(caseHold, req);
			caseHold.setLabId(getSessionUserByLoginEmail().getLabId());
			caseholdService.add(caseHold);
			result.setResult(Booleans.TRUE);
			result.setInfo("增加成功");
		}catch(Exception e){
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(result, resp);
	}
	
	@RequestMapping("/updateOnHold")
	public void updateOnHold(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result=new AjaxResult(Booleans.FALSE,"修改失败");
		try{
			CaseHold caseHold=new CaseHold();
			DXObject.setValue(caseHold, req);
			caseHold.setLabId(getSessionUserByLoginEmail().getLabId());
			caseholdService.update(caseHold);
			result.setResult(Booleans.TRUE);
			result.setInfo("修改成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
			}
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: deleteUser 
	 * @Description: 删除技工间用户
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/setting/deleteUser")
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
				LogUtil.addUserLog(user, "删除账户:"+user.getFirstName()+user.getLastName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		outReturnAjaxResult(result, resp);
	}
	
	
	
	/**
	 * 
	 * @Title: setting
	 * @Description: 案例设置页面视图跳转 
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting")
	public ModelAndView setting(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new MyModelAndView().setViewName("u_lab/u_lab_Settings");
	}
	
	/**
	 * 
	 * @Title: setting/details.do
	 * @Description:  设置页面-技工间详细信息页面（视图跳转）
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/details")
	public ModelAndView details(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new MyModelAndView().setViewName("u_lab/u_lab_Settings_LabDetails");
	}
	
	/**
	 * 
	 * @Title: general
	 * @Description:  设置页面-技工间详细信息页面（一般信息）
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/general")
	public ModelAndView general(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Integer labId = getSessionUserByLoginEmail().getLabId();
		return new MyModelAndView().setViewName("u_lab/u_lab_Settings_LabDetails_General").addObject("myLab", labService.get(labId));
	}
	/**
	 * 
	 * @Title: general
	 * @Description:  设置页面-技工间详细信息页面（首要信息）
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/preferences")
	public ModelAndView preferences(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		MyModelAndView mav = new MyModelAndView();
		LabPreference lp = preferenceService.getObjectByLabId(getSessionUserByLoginEmail().getLabId());
		LabPreference.Features features = null;
		try{
			if(lp != null && lp.getFeatures()!=null){
				features = ToolsKit.jsonUitl.toBean(LabPreference.Features.class, lp.getFeatures());
				mav.addObject("features",features);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mav
			.setViewName("u_lab/u_lab_Settings_LabDetails_Preferences")
			.addObject("labPre", lp);
	}
	/**
	 * 
	 * @Title: general
	 * @Description:  设置页面-技工间详细信息页面（权限信息）
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/permissions")
	public ModelAndView permissions(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Permissions per = getLabPermissions(getSessionUserByLoginEmail().getLabId());
		return new MyModelAndView()
			.setViewName("u_lab/u_lab_Settings_LabDetails_Permissions")
			.addObject("cases", per.getCases())
			.addObject("finances", per.getFinances());
	}
	/**
	 * 
	 * @Title: listUser 
	 * @Description: 技工间用户列表，页面跳转
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return u_lab_Settings_UserAccounts.jsp 整个首页
	 */
	@RequestMapping("/setting/users")
	public ModelAndView listUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//修改 2014-11-07 9:46 解决问题：增用户页面没有“优惠限度” by LiuCheng
		User sessionUser = getSessionUserByLoginEmail();
		Integer labId = sessionUser.getLabId();
		//默认取第一页
		Integer	pageNo = 1;
		
		User user = new User();
		user.setLabId(labId);
		//每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		List<User> datas = userService.listAllByEqual(user, pageNo,pageSize);
		
		PageModel pm = getPageModel(datas, userService.getCountByEqual(user), pageSize, pageNo);
		
		return new MyModelAndView().setViewName("u_lab/u_lab_Settings_UserAccounts").addObject("pm",pm).addObject("sessionUser", sessionUser);
	}
	
	/**
	 * 
	 * @Title: listUser 
	 * @Description: 技工间用户列表,根据条件查询
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return u_lab_Settings_UserAccounts_div.jsp 用户列表
	 */
	@RequestMapping("/setting/listUserSearch")
	public ModelAndView listUserSearch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer labId = getSessionUserByLoginEmail().getLabId();
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
		user.setLabId(labId);
		//每页显示10条
		Integer pageSize = 10;
		// 得到结果集
		List<User> datas = userService.listAllByLike(user, pageNo,pageSize);
		
		PageModel pm = getPageModel(datas, userService.getCountByLike(user), pageSize, pageNo);
		
		return new MyModelAndView().setViewName("u_lab/u_lab_Settings_UserAccounts_div").addObject("pm",pm).addObject("search", search);
	}
	/**
	 * 
	 * @Description:  设置审批状态提供在页面显示
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return void
	 * @throws Exception 
	 */
	public static void setMyApprovalStatus(List<?> list, List<PartnerLab> plist, String ApprovalType) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			Method method = list.get(i).getClass().getMethod("getId");
			Integer ilabId = ToolsKit.TypeConversionUtil.asInteger(method.invoke(list.get(i)));
			for (int j = 0; j < plist.size(); j++) {
				if ("Others".equals(ApprovalType)) {
					if (plist.get(j).getPartnerId().equals(ilabId)) {
						Method method2 = list.get(i).getClass().getMethod("setAccountStatus", String.class);
						method2.invoke(list.get(i), plist.get(j).getPartnerApprovalStatus());
					}
				} else if ("My".equals(ApprovalType)) {
					if (plist.get(j).getUnitId().equals(ilabId)) {
						Method method2 = list.get(i).getClass().getMethod("setAccountStatus", String.class);
						method2.invoke(list.get(i), plist.get(j).getPartnerApprovalStatus());
					}
				}

			}
		}
	}
	
	/**
	 * 
	 * @Title: general
	 * @Description:  设置页面-诊所,获取所有请求添加我为伙伴技工间的技工间和诊所
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/practices")
	public ModelAndView practices(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//外部页面跳请求转时默认查询参数
		String initId = req.getParameter("initId");
		String initType = req.getParameter("initType");
		
		String type = req.getParameter("type");
		String search = req.getParameter("search");
		if(ToolsKit.EmptyCheckUtil.isEmpty(search)){
			search = "";
		}
		//默认返回局部数据页面
		ModelAndView mav = new ModelAndView("u_lab/u_lab_Settings_Practices-div");
		//返回整个页面
		if(ToolsKit.EmptyCheckUtil.isEmpty(type)){
			type = "1";
			mav.setViewName("u_lab/u_lab_Settings_Practices");
		}
		Integer offset = getParameterAsInteger(req,"offset");
		if (ToolsKit.EmptyCheckUtil.isEmpty(offset)) {
			offset = 1;
		}
		Integer labId = getSessionUserByLoginEmail().getLabId();
		PageModel pm = null;
		if(ToolsKit.EmptyCheckUtil.isEmpty(initId) && ToolsKit.EmptyCheckUtil.isEmpty(initType)){
			if(Constans.UNIT_LAB.equals(type)) {
				pm = getPageModel( labService.getRequestAccountLab(labId, offset, 10, search),
						labService.getRequestAccountLabCount(labId, search), 10, offset);
			} else if (Constans.UNIT_PRACTICE.equals(type)) {
				pm = getPageModel(practiceService.getRequestAccountPractice(labId, offset, 10, search),
						practiceService.getRequestAccountPracticeCount(labId, search), 10, offset);
			} else {
				throw new Exception("数据传输错误！");
			}
			
			PartnerLab plab = new PartnerLab();
			plab.setPartnerId(labId);
			List<PartnerLab> plist = partnerLabService.listAllByEqual(plab, 0, 0);
			//设置我的审批状态
			setMyApprovalStatus(pm.getDatas(), plist,"My");
		}
		
		return mav.addObject("type", type).addObject("search", search).addObject("pm", pm).addObject("initId", initId).addObject("initType", initType);
	}
	/**
	 * 
	 * @Title: general
	 * @Description:  设置页面-案例设置
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/caseSetting")
	public ModelAndView caseSetting(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new MyModelAndView().setViewName("lab/lab_DDXDentalPractice_CaseSetting").addObject("menu", req.getParameter("menu")).addObject("item", req.getParameter("item"));
	}
	/**
	 * 
	 * @Title: general
	 * @Description:  设置页面-网站
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/website")
	public ModelAndView website(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new MyModelAndView().setViewName("u_lab/u_lab_Settings_DDXWebsite");
	}
	
	/**
	 * 
	 * @Title: updatePermissions
	 * @Description:  设置页面-修改技工间详细信息-针对诊所和其他技工间权限
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/setting/updatePermissions")
	public void updatePermissions(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		try {
			LabPermissions lp = new LabPermissions();
			DXObject.setValue(lp, req);
			lp.setLabId(getSessionUserByLoginEmail().getLabId());
			lp.setId(lp.getLabId());
			labPermissionsService.addOrUpdate(lp);
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons(e.getMessage());
			e.printStackTrace();
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: getAllLabs 
	 * @Description: 获取与某个诊所有关联的技工间
	 * @author ERIC 
	 * @date 2014-6-23下午03:10:19
	 * @param @return
	 * @return ModelAndView
	 */
	@RequestMapping("/getAllLabsOfPractice") 
	public ModelAndView getAllLabsOfPractice(HttpServletRequest request, HttpServletResponse response){
		//根据诊所ID去查询对应的技工间
		String pid = request.getParameter("practiceId");
		List<Lab> labList = labService.getPartnerLab(Integer.valueOf(pid));
		return new MyModelAndView().setViewName("u_practice/u_practice_AddLab").addObject("labList", labList);
	}
	
	/**
	 * 
	 * @Title: updateGeneral 
	 * @Description: 设置页面-修改技工间详细信息-针对通用(或一般)信息
	 * @author ERIC 
	 * @date 2014-7-10下午12:20:49
	 * @return void
	 */
	@RequestMapping("/setting/updateGeneral")
	public void updateGeneral(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		try {
			Lab lab = new Lab();
			DXObject.setValue(lab, req);
			labService.update(lab);
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons(e.getMessage());
			e.printStackTrace();
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: updatePreferences 
	 * @Description: 设置页面-修改技工间详细信息-针对偏好设置信息
	 * @author ERIC 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 */
	@RequestMapping("/setting/updatePreferences")
	public void updatePreferences(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		try {
			LabPreference lp = new LabPreference();
			DXObject.setValue(lp, req);
			lp.setLabId(getSessionUserByLoginEmail().getLabId());
			if(lp.getId()!=null && lp.getId()!=0){
				lp.setId(lp.getId());
				preferenceService.update(lp);
				result.setInfo(lp.getId().toString());
			}else{
				preferenceService.add(lp);
			}
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			result.setResult(Booleans.FALSE);
			result.setFailReasons(e.getMessage());
			e.printStackTrace();
		}
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: updatePracticeService 
	 * @Description: 设置页面-机构单位，编辑诊所或技工间-首要信息
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/setting/updatePracticeServicePreferences")
	public void updatePracticeServicePreferences(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		try {
			Integer unitId = getParameterAsInteger(req, "unitId");
			String unitType = req.getParameter("unitType");
			LabPracticePreferences labpp = new LabPracticePreferences();
			DXObject.setValue(labpp, req);
			
			if (Constans.UNIT_LAB.equals(unitType)) {
				labpp.setLabId(unitId);
			} else if (Constans.UNIT_PRACTICE.equals(unitType)) {
				labpp.setPracticeId(unitId);
			} else {
				throw new Exception("数据传输错误");
			}
			labpp.setLid(getSessionUnitId());
			if(ToolsKit.EmptyCheckUtil.isEmpty(labpp.getId())){
				practicePreferencesService.add(labpp);
				result.setResult(Booleans.TRUE);
				result.setInfo("保存成功");
			}else{
				int res = practicePreferencesService.updateLabPracticePreferences(labpp);
				if(res>0){
					result.setResult(Booleans.TRUE);
					result.setInfo("修改成功");
				}
			}
		} catch (Exception e) {
			throw new Exception("操作失败，错误："+e.getLocalizedMessage());
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: updatePracticeServiceDetails 
	 * @Description: 设置页面-机构单位，编辑诊所或技工间-详细信息
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/setting/updatePracticeServiceDetails")
	public void updatePracticeServiceDetails(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		String status = req.getParameter("status");
		Integer id = getParameterAsInteger(req,"id");

		PartnerLab plab = new PartnerLab();
		plab.setUnitId(id);
		plab.setPartnerId(getSessionUserByLoginEmail().getLabId());
		List<PartnerLab> plabList = partnerLabService.listAllByEqual(plab, 0, 0);
		if (ToolsKit.EmptyCheckUtil.isEmpty(plabList) || plabList.size() > 1) {
			throw new Exception("数据异常，查询结果集大于1");
		}
		PartnerLab iplab = plabList.get(0);
		iplab.setPartnerApprovalStatus(status);
		partnerLabService.update(iplab);
		
		result.setResult(Booleans.TRUE);
		result.setInfo("修改成功");
		//插入日志
		try {
			LogUtil.addPartnerLabAccountApprovalLog(status, iplab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: addShippingType 
	 * @Description: 设置页面-工序-一般信息-增加运送类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/addOrUpdateShippingType")
	public void addOrUpdateShippingType(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "新增失败");
		CaseShipping cs = new CaseShipping();
		DXObject.setValue(cs, req);
		cs.setLabId(getSessionUserByLoginEmail().getLabId());
		if(cs.getId()!=null){
			result.setInfo("修改成功");
		}else{
			result.setInfo("新增成功");
		}
		casesShippingService.addOrUpdate(cs);
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: getShiipingTypeById 
	 * @Description: 设置页面-工序-一般信息-根据ID查询运送类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/getShiipingTypeById")
	public void getShiipingTypeById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Integer id = getParameterAsInteger(req, "id");
		CaseShipping cs = casesShippingService.get(id);
		outReturnString(ToolsKit.jsonUitl.toJson(cs), resp);
	}
	/**
	 * 
	 * @Title: getShiipingTypeById 
	 * @Description: 设置页面-工序-一般信息-根据ID查询改造类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/getRemakesTypes")
	public void getRemakesTypes(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Integer id=getParameterAsInteger(req, "id");
		CaseRemake cr=caseRemakeService.get(id);
		outReturnString(ToolsKit.jsonUitl.toJson(cr), resp);
	}
	/**
	 * 
	 * @Title: getShiipingTypeById 
	 * @Description: 设置页面-工序-一般信息-根据ID查询延时搁置类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/getOnHoldType")
	public void getOnHoldType(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Integer id=getParameterAsInteger(req, "id");
		CaseHold ch=caseholdService.get(id);
		outReturnString(ToolsKit.jsonUitl.toJson(ch), resp);
	}
	/**
	 * 
	 * @Title: getShiipingTypeById 
	 * @Description: 设置页面-工序-一般信息-删除运送类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/deleteShippingType")
	public void deleteShippingType(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败");
		Integer id = getParameterAsInteger(req, "id");
		casesShippingService.delete(id);
		result.setResult(Booleans.TRUE);
		result.setInfo("删除成功");
		outReturnAjaxResult(result, resp);
	}
	
	
	/**
	 * 
	 * @Title: saveNotes 
	 * @Description: 设置页面-机构单位，编辑诊所或技工间-笔记信息
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/setting/saveNotes")
	public void saveNotes(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		String type = req.getParameter("type");
		Integer unitId = getParameterAsInteger(req, "unitId");
		
		LabPracticeNotes note = new LabPracticeNotes();
		if (Constans.UNIT_LAB.equals(type)) {
			note.setLabId(unitId);
		} else if (Constans.UNIT_PRACTICE.equals(type)) {
			note.setPracticeId(unitId);
		} else {
			throw new Exception("数据传输错误");
		}
		note.setId(getParameterAsInteger(req, "id"));
		note.setLid(getSessionUnitId());
		note.setNotes(req.getParameter("notes"));
		note.setExternalId(req.getParameter("externalId"));
		labPracticeNotesService.addOrUpdate(note);
		
		result.setResult(Booleans.TRUE);
		result.setInfo("修改成功");
		outReturnAjaxResult(result, resp);
	}
	@RequestMapping("/addRemake")
	public void addRemake(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		try{
		CaseRemake caseRemake=new CaseRemake();
		DXObject.setValue(caseRemake, req);
		caseRemake.setLabid(getSessionUserByLoginEmail().getLabId());
		caseRemakeService.add(caseRemake);
		result.setResult(Booleans.TRUE);
		result.setInfo("增加成功");
	}catch(Exception e){
		e.printStackTrace();
		result.setFailReasons(e.getMessage());
	}
	outReturnAjaxResult(result, resp);
	}
	@RequestMapping("/updateRemake")
	public void updateRemake(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		try{
			CaseRemake caseRemake=new CaseRemake();
			DXObject.setValue(caseRemake, req);
			caseRemake.setLabid(getSessionUserByLoginEmail().getLabId());
			caseRemakeService.update(caseRemake);
			result.setResult(Booleans.TRUE);
			result.setInfo("修改成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(result, resp);
	}
	@RequestMapping("/deleteHoldType")
	public void deleteHoldType(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败");
		try {
			Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
			caseholdService.delete(id);
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(result, resp);
	}
	@RequestMapping("/deleteRemake")
	public void deleteRemake(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败");
		try {
			Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
			caseRemakeService.delete(id);
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(result, resp);
	}
	@RequestMapping("/updateTerms")
	public void updateTerms(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "更新失败");
		try{
			CaseTerms ct=new CaseTerms();
			DXObject.setValue(ct, req);
			ct.setLabid(getSessionUserByLoginEmail().getLabId());
			caseTermsService.update(ct);
			result.setResult(Booleans.TRUE);
			result.setInfo("修改成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
			}
		outReturnAjaxResult(result, resp);
	}
	
	@RequestMapping("/addTerms")
	public void addTerms(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		try{
			CaseTerms ct=new CaseTerms();
			DXObject.setValue(ct, req);
			ct.setLabid(getSessionUserByLoginEmail().getLabId());
			caseTermsService.add(ct);
			result.setResult(Booleans.TRUE);
			result.setInfo("修改成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
			}
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: applyLabEmail 
	 * @Description: 更新技工间电子邮箱地址
	 * @author ERIC 
	 * @date 2014-7-23下午03:55:26
	 * @return void
	 */
	@RequestMapping("applyLabEmail")
	public void updateLab(HttpServletRequest request, HttpServletResponse response){
		Lab lab = new Lab();
		try {
			Integer labId = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("labId"));
			String email = ToolsKit.TypeConversionUtil.asString(request.getParameter("email"));
			lab = labService.get(labId);
			lab.setEmail(email);
			labService.update(lab);
			outJson(null, "applyLabEmail", "success", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @Title: saveNotes 
	 * @Description: 设置页面-案例设置-工序-显示类别，新增/修改 类别
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/editDisplayCategory")
	public void editDisplayCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		String method = req.getParameter("method");
		ProcedureDisplayCategory pdc = new ProcedureDisplayCategory();
		DXObject.setValue(pdc, req);
		pdc.setLabId(getSessionUserByLoginEmail().getLabId());
		String message = "";
		if("update".equals(method)){
			procedureDisplayCategoryService.update(pdc);
			message = "修改成功";
		}else if("save".equals(method)){
			procedureDisplayCategoryService.add(pdc);
			message = "新增成功";
		}else{
			throw new Exception("数据传输错误");
		}
		result.setResult(Booleans.TRUE);
		result.setInfo(message);
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: listLabProcedures 
	 * @Description: 设置页面-案例设置-工序-技工间工序
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/listLabProcedures")
	public ModelAndView listLabProcedures(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return new MyModelAndView().setViewName(baseCache.getModelAndViewMappingMap().get("labProcedures")).addObject("datas", caseDataQuery.labProcedures(req)).addObject("search", req.getParameter("search"));
	}
	/**
	 * 
	 * @Title: procedure 
	 * @Description: 设置页面-案例设置-工序-（首页初始化）一般信息新增/修改
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/procedure")
	public ModelAndView procedure(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new ModelAndView("lab/lab_DDXDentalPractice_CaseSetting_Procedures_LabProcedures_main").addObject("datas", caseDataQuery.general(req));
	}
	/**
	 * 
	 * @Title: getSubCategory 
	 * @Description: 设置页面-案例设置-工序-编辑-加载子类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/getSubCategory")
	public void getSubCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Integer id = getParameterAsInteger(req, "id");
		if(ToolsKit.EmptyCheckUtil.isEmpty(id)){
			throw new Exception("数据传输异常");
		}
		ProcedureSubCategory psc = new ProcedureSubCategory();
		psc.setCategoryId(id);
		List<ProcedureSubCategory> pscList = procedureSubCategoryService.listAllByEqual(psc, 0, 0);
		
		StringBuffer subCategory = new StringBuffer();
		for (int i = 0; i < pscList.size(); i++) {
			subCategory.append("<option value=\"").append(pscList.get(i).getId()).append("\">").append(pscList.get(i).getNameDesc()).append("</option>");
		}
		subCategory.append("<option value=\"\"></option>");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subCategory", subCategory);
		
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(pscList)){
			map.put("proceduresType", getgetProceduresTypeString(pscList.get(0).getId()));
		}
		outReturnString(ToolsKit.jsonUitl.toJson(map), resp);
	
	}
	/**
	 * 
	 * @Title: getProceduresType 
	 * @Description: 设置页面-案例设置-工序-编辑-加载工序类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/getProceduresType")
	public void getProceduresType(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		outReturnString(getgetProceduresTypeString(getParameterAsInteger(req, "id")), resp);
	}
	/**
	 * 
	 * @Title: getProceduresType 
	 * @Description: 设置页面-案例设置-工序-编辑-加载工序类型
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	public String getgetProceduresTypeString(Integer subId) throws Exception{
		ProcedureType pt = new ProcedureType();
		pt.setSubId(subId);
		List<ProcedureType> ptList = procedureTypeService.listAllByEqual(pt, 0, 0);
		StringBuffer proceduresType = new StringBuffer();
		for (int i = 0; i < ptList.size(); i++) {
			proceduresType.append("<option value=\"").append(ptList.get(i).getId()).append("\">").append(ptList.get(i).getNameDesc()).append("</option>");
		}
		return proceduresType.append("<option value=\"\"></option>").toString(); 
	}
	@RequestMapping("/updateSchedulingHolida")
	public void updateSchedulingHolida(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		try{
			Caseschedulingholida ct=new Caseschedulingholida();
			DXObject.setValue(ct, req);
			ct.setLabid(getSessionUserByLoginEmail().getLabId());
			caseSchedulingHolidaService.update(ct);
			result.setResult(Booleans.TRUE);
			result.setInfo("修改成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
			}
		outReturnAjaxResult(result, resp);
	}
	@RequestMapping("/addSchedulingHolida")
	public void addSchedulingHolida(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "新增成功");
		try{
			Caseschedulingholida ct=new Caseschedulingholida();
			DXObject.setValue(ct, req);
			ct.setLabid(getSessionUserByLoginEmail().getLabId());
			caseSchedulingHolidaService.add(ct);
			result.setResult(Booleans.TRUE);
			result.setInfo("新增成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
			}
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: saveProcedure 
	 * @Description: 设置页面-案例设置-工序-编辑-添加工序
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/saveProcedure")
	public void saveProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "新增失败");
		LabProcedure lp = new LabProcedure();
		DXObject.setValue(lp, req);
		lp.setLabId(getSessionUserByLoginEmail().getLabId());
		
		String newgroup = req.getParameter("newgroup");
		String newdisplayCategory = req.getParameter("newdisplayCategory");
		String displayPsGroup = req.getParameter("displayPsGroup");
		
		labProcedureService.addProedure(lp, displayPsGroup,newgroup,newdisplayCategory);
		result.setResult(Booleans.TRUE);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "新增成功");
		map.put("id", lp.getProceduresId());
		result.setInfo(map);
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: updateProcedure 
	 * @Description: 设置页面-案例设置-工序-编辑-修改工序
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/updateProcedure")
	public void updateProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		LabProcedure lp = new LabProcedure();
		DXObject.setValue(lp, req);
		lp.setLabId(getSessionUserByLoginEmail().getLabId());
		
		String newgroup = req.getParameter("newgroup");
		String newdisplayCategory = req.getParameter("newdisplayCategory");
		String displayPsGroup = req.getParameter("displayPsGroup");
		
		labProcedureService.updateProedure(lp, displayPsGroup,newgroup,newdisplayCategory);
		result.setResult(Booleans.TRUE);
		result.setInfo("修改成功");
		outReturnAjaxResult(result, resp);
		
	}
	/**
	 * 
	 * @Title: saveAttrbutes 
	 * @Description:增加优惠劵
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/addCoupons")
	public void addCoupons(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AjaxResult result = new AjaxResult(Booleans.FALSE, "增加失败");
		LabCaseCoupons coupons = new LabCaseCoupons();
		DXObject.setValue(coupons, req);
		String unit = req.getParameter("unit");
		Integer howmany = getParameterAsInteger(req, "howmany");
		String useType = coupons.getUseType();
		if (Constans.COUPONS_TYPE_MULTI.equals(useType)) {
			howmany = 1;
		}
		String[] unitG = unit.split(",");
		if (ToolsKit.EmptyCheckUtil.isEmpty(unit) || "null".equals(unit)) {
			unitG = new String[] { "0-0" };
		}
		Integer labId = getSessionUnitId();
		List<LabCaseCoupons> couList = new ArrayList<LabCaseCoupons>();
		for (int i = 0; i < unitG.length; i++) {
			for (int j = 0; j < howmany; j++) {
				LabCaseCoupons co = new LabCaseCoupons();
				DXObject.setValue(co, req);
				if (Constans.COUPONS_TYPE_SINGLE.equals(useType)) {
					co.setMaxUse(1);
				}
				co.setUseFrequency(0);
				co.setPrefix(coupons.getPrefix() + caseCouponsService.getCharAndNumr(12));
				if (!"0-0".equals(unitG[i])) {
					co.setUnitid(ToolsKit.TypeConversionUtil.asInteger(unitG[i].split("-")[0]));
					co.setUnittype(unitG[i].split("-")[1]);
				}
				co.setLabid(labId);
				couList.add(co);
			}
		}
		caseCouponsService.batchAdd(couList);
		result.setResult(Booleans.TRUE);
		result.setInfo("保存成功");

		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: loadUnitAndProcedure 
	 * @Description:加载我的工序和客户机构
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/loadUnitAndProcedure")
	public ModelAndView loadUnitAndProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("boundCoupons", getRequestUnit());
		map.put("pro", labProcedureService.getProedureAsHtml(getSessionUnitId()));
		return new ModelAndView("lab/lab_DDXDentalPractice_CaseSetting_Coupons_div").addObject("datas", map);
	}
	
	/**
	 * 
	 * @Title: saveAttrbutes 
	 * @Description: 设置页面-案例设置-工序-编辑-修改属性
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/saveAttrbutes")
	public void saveAttrbutes(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "失败");
		String type = req.getParameter("type");
		LabProcedureAttr attr = new LabProcedureAttr();
		DXObject.setValue(attr, req);
		if("add".equals(type)){
			labProcedureAttrService.add(attr);
			result.setInfo("增加成功");
		}else if("update".equals(type)){
			labProcedureAttrService.update(attr);
			result.setInfo("修改成功");
		}else{
			throw new Exception("数据传输错误");
		}
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: updateProcedure 
	 * @Description: 设置页面-案例设置-工序-编辑-修改外部链接
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/saveOutLink")
	public void saveOutLink(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "失败");
		String type = req.getParameter("otype");
		LabProceduresOutLink link = new LabProceduresOutLink();
		DXObject.setValue(link, req);
		if("add".equals(type)){
			labProceduresOutLinkService.add(link);
			result.setInfo("增加成功");
		}else if("update".equals(type)){
			labProceduresOutLinkService.update(link);
			result.setInfo("修改成功");
		}else{
			throw new Exception("数据传输错误");
		}
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: loadOutLinkProList 
	 * @Description: 设置页面-案例设置-工序-编辑-加载伙伴技工间的工序
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/loadOutLinkProList")
	public ModelAndView loadOutLinkProList(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Integer requestLabId = getParameterAsInteger(req, "requestLabId");
		User user = getSessionUserByLoginEmail();
		String unitType = user.getUnitType();
		
		List<LabProcedure> listPro = labProcedureService.getRequestLabProcedures(user.getUnitId(), unitType , requestLabId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listPro", listPro);
		return new ModelAndView("lab/out-link-pro-select").addObject("datas", map);
	}
	
	/**
	 * 
	 * @Title: assignPriceListGroups 
	 * @Description: 设置页面-案例设置-机构-分配价格组页面展示
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/assignPriceListGroups")
	public ModelAndView assignPriceListGroups(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		LabPriceGroup pg = new LabPriceGroup();
		pg.setLabId(getSessionUserByLoginEmail().getLabId());
		List<LabPriceGroup> gList = labPriceGroupService.listAllByEqual(pg, 0, 0);
		//机构信息
		List<Map<String, Object>> rlist = getRequestUnit();
		
		for (int i = 0; i < rlist.size(); i++) {
			Integer unitId = ToolsKit.TypeConversionUtil.asInteger(rlist.get(i).get("id"));
			String unitType = ToolsKit.TypeConversionUtil.asString(rlist.get(i).get("type"));
			Integer practicesGroupId = null;
			String practicesGroupName = "未指定";
			
			LabPracticePreferences lppf = new LabPracticePreferences();
			if(Constans.UNIT_LAB.equals(unitType)){
				lppf.setLabId(unitId);
			}else if(Constans.UNIT_PRACTICE.equals(unitType)){
				lppf.setPracticeId(unitId);
			}
			List<LabPracticePreferences> iglist = practicePreferencesService.listAllByEqual(lppf, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(iglist)){
				practicesGroupId = iglist.get(0).getPriceGroupId();
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(practicesGroupId)){
					LabPriceGroup lg = labPriceGroupService.get(practicesGroupId);
					if(ToolsKit.EmptyCheckUtil.isNotEmpty(lg)){
						practicesGroupName = lg.getName();
					}
				}
			}else{
				practicePreferencesService.add(lppf);
			}
			rlist.get(i).put("practicesGroupId", practicesGroupId);
			rlist.get(i).put("practicesGroupName", practicesGroupName);
		}
		
		return new ModelAndView("u_lab/u_lab_Settings_Practices_actions_AssignPriceListGroup").addObject("requestUnit", rlist).addObject("gList", gList);
	}
	/**
	 * 
	 * @Title: assignShippingServices 
	 * @Description: 设置页面-案例设置-机构-分配运送类型页面展示
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/assignShippingServices")
	public ModelAndView assignShippingServices(HttpServletRequest req, HttpServletResponse resp) throws Exception{

		CaseShipping pg = new CaseShipping();
		pg.setLabId(getSessionUserByLoginEmail().getLabId());
		List<CaseShipping> sList = casesShippingService.listAllByEqual(pg, 0, 0);
		//机构信息
		List<Map<String, Object>> rlist = getRequestUnit();
		
		for (int i = 0; i < rlist.size(); i++) {
			Integer unitId = ToolsKit.TypeConversionUtil.asInteger(rlist.get(i).get("id"));
			String unitType = ToolsKit.TypeConversionUtil.asString(rlist.get(i).get("type"));
			
			Integer shippingId = null;
			String shippingName = "未指定";
			
			LabPracticePreferences lppf = new LabPracticePreferences();
			if(Constans.UNIT_LAB.equals(unitType)){
				lppf.setLabId(unitId);
			}else if(Constans.UNIT_PRACTICE.equals(unitType)){
				lppf.setPracticeId(unitId);
			}
			List<LabPracticePreferences> iglist = practicePreferencesService.listAllByEqual(lppf, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(iglist)){
				shippingId = iglist.get(0).getShippingId();
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(shippingId)){
					CaseShipping cs = casesShippingService.get(shippingId);
					if(ToolsKit.EmptyCheckUtil.isNotEmpty(cs)){
						shippingName = cs.getService();
					}
				}
			}else{
				practicePreferencesService.add(lppf);
			}
			rlist.get(i).put("shippingId", shippingId);
			rlist.get(i).put("shippingName", shippingName);
		}
		
		return new ModelAndView("u_lab/u_lab_Settings_Practices_actions_AssignShippingService").addObject("requestUnit", rlist).addObject("sList", sList);
	
	}
	/**
	 * 
	 * @Title: batchUpdatePriceGroup 
	 * @Description: 设置页面-案例设置-机构-分配价格组批量修改
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/batchUpdatePriceGroup")
	public void batchUpdatePriceGroup(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		String[] unitId = req.getParameter("unitId").split(";");
		Integer priceGroupId = getParameterAsInteger(req, "groupId");
		int count = practicePreferencesService.batchUpdatePriceGroup(unitId, priceGroupId,getSessionLab().getId());
		if(count>0){
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}
	
	
	/**
	 * 
	 * @Title: batchUpdateShipping 
	 * @Description: 设置页面-案例设置-机构-分配运送类型批量修改
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/batchUpdateShipping")
	public void batchUpdateShipping(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		String[] unitId = req.getParameter("unitId").split(";");
		Integer shippingId = getParameterAsInteger(req, "shippingId");
		
		int count = practicePreferencesService.batchUpdateShiiping(unitId, shippingId,getSessionLab().getId());
		if(count>0){
			result.setResult(Booleans.TRUE);
		}
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: batchUpdateShipping 
	 * @Description: 删除ddx优惠劵
	 * @author liaomin 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("/deleteCoupons")
	public void deleteCoupons(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败");
		try {
			Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
			caseCouponsService.delete(id);
			result.setResult(Booleans.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailReasons(e.getMessage());
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: addOrUpdatePrice 
	 * @Description: 设置页面-案例设置-工序设置-新增价格
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/addOrUpdatePrice")
	public void addOrUpdatePrice(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "保存失败");
		Integer id = getParameterAsInteger(req, "id");
		String param = req.getParameter("param");
		Map map = ToolsKit.jsonUitl.toBean(Map.class, param);
		LabProceduresPrice price = new LabProceduresPrice();
		price.setProceduresId(ToolsKit.TypeConversionUtil.asInteger(map.get("proceduresId")));
		price.setPrice(ToolsKit.TypeConversionUtil.asDouble(map.get("price")));
		if(ToolsKit.TypeConversionUtil.asString(map.get("group")).equals("new")){
			String newGroupName = ToolsKit.TypeConversionUtil.asString(map.get("newGroupName"));
			LabPriceGroup group = new LabPriceGroup();
			group.setName(newGroupName);
			group.setLabId(getSessionUserByLoginEmail().getLabId());
			labPriceGroupService.add(group);
			price.setPriceGroupId(group.getId());
		}else{
			price.setPriceGroupId(ToolsKit.TypeConversionUtil.asInteger(map.get("group")));
		}
		//设置属性
		LabProceduresPrice.PriceAttributes pa = new LabProceduresPrice.PriceAttributes();
		List priceAttr = (List)map.get("attr");
		for (int j = 0; j < priceAttr.size(); j++) {
			Map m = (Map)priceAttr.get(j);
			if(ToolsKit.EmptyCheckUtil.isEmpty(m)){
				continue;
			}
			String method = ToolsKit.TypeConversionUtil.asString(m.get("id"));
			String[] value = ToolsKit.TypeConversionUtil.asString(m.get("value")).split(",");
			Map imap = (Map)LabProceduresPrice.PriceAttributes.class.getMethod(method).invoke(pa);
			for (int k = 0; k < value.length; k++) {
				imap.put(value[k], value[k]);
			}
		}
		price.setAttributes(ToolsKit.jsonUitl.toJson(pa));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(id)){
			price.setId(id);
			labProceduresPriceService.update(price);
		}else{
			labProceduresPriceService.add(price);
		}
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}
	/**
	 * 
	 * @Title: updatePrice 
	 * @Description: 设置页面-案例设置-工序设置-修改价格(批量)
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@RequestMapping("setting/updatePrice")
	public void updatePrice(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "保存失败");
		String param = req.getParameter("param");
		Integer proceduresId = getParameterAsInteger(req, "proceduresId");
		Map[] map = ToolsKit.jsonUitl.toBean(Map[].class, param);
		
		List<LabProceduresPrice> list = new ArrayList<LabProceduresPrice>();
		for (int i = 0; i < map.length; i++) {
			LabProceduresPrice price = new LabProceduresPrice();
			price.setProceduresId(proceduresId);
			price.setPrice(ToolsKit.TypeConversionUtil.asDouble(map[i].get("price")));
			price.setPriceGroupId(ToolsKit.TypeConversionUtil.asInteger(map[i].get("group")));
			
			//设置属性
			LabProceduresPrice.PriceAttributes pa = new LabProceduresPrice.PriceAttributes();
			List priceAttr = (List)map[i].get("attr");
			for (int j = 0; j < priceAttr.size(); j++) {
				Map m = (Map)priceAttr.get(j);
				String method = ToolsKit.TypeConversionUtil.asString(m.get("id"));
				String[] value = ToolsKit.TypeConversionUtil.asString(m.get("value")).split(",");
				Map imap = (Map)LabProceduresPrice.PriceAttributes.class.getMethod(method).invoke(pa);
				for (int k = 0; k < value.length; k++) {
					imap.put(value[k], value[k]);
				}
			}
			price.setAttributes(ToolsKit.jsonUitl.toJson(pa));
			list.add(price);
		}
		labProceduresPriceService.batchUpdatePrice(proceduresId, list);
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: queryProcedureAttr 
	 * @Description: 设置页面-案例设置-工序设置-价格增加时查询工序属性
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("setting/queryPriceAttr")
	public ModelAndView queryPriceAttr(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Integer proceduresId = getParameterAsInteger(req, "id");
		Integer priceId = getParameterAsInteger(req, "priceId");
		LabProcedureAttr labattr = null;
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(proceduresId)){
			LabProcedureAttr attr = new LabProcedureAttr();
			attr.setProcedures_id(proceduresId);
			List<LabProcedureAttr> list = labProcedureAttrService.listAllByEqual(attr, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(list)){
				labattr = list.get(0);
			}
		}
		List list = new ArrayList();
		LabProceduresPrice price = null;
		
		LabPriceGroup g = new LabPriceGroup();
		g.setLabId(getSessionUserByLoginEmail().getLabId());
		List<LabPriceGroup> groupList = labPriceGroupService.listAllByEqual(g, 0, 0);
		
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(priceId)){
			price = labProceduresPriceService.get(priceId);
			
		}
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(labattr)){
			LabProceduresPrice.PriceAttributes priceAttributes = null;
			
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(price)){
				String priAttr = price.getAttributes();
				try {
					priceAttributes = ToolsKit.jsonUitl.toBean(LabProceduresPrice.PriceAttributes.class, priAttr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			Method[] methods = labattr.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				if(methods[i].getName().startsWith("get") && methods[i].getName().endsWith("presence")){
					Map<String, Object> commentMap = AbstractExcelService.parseComment(methods[i],Note.class);
					boolean isShowByPriceAdd = ToolsKit.TypeConversionUtil.asBoolean(commentMap.get("isShowByPriceAdd"));
					if(!isShowByPriceAdd){
						continue;
					}
					String result = ToolsKit.TypeConversionUtil.asString(methods[i].invoke(labattr));
					if(!Constans.PRESENCE_NOT_APPLICABLE.equals(result) && ToolsKit.EmptyCheckUtil.isNotEmpty(result)){
						
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("label", commentMap.get("name"));
						String methodsName = methods[i].getName();
						map.put("id", methodsName);
						Method method = ProcedurePriceAttrCache.class.getMethod(methodsName);
						List attrList = (List)method.invoke(baseCache.getProcedurePriceAttrCache());
						StringBuffer option = new StringBuffer();
						for (int j = 0; j < attrList.size(); j++) {
							Map imap = (Map)attrList.get(j);
							String select = "";
							try {
								if(ToolsKit.EmptyCheckUtil.isNotEmpty(priceAttributes)){
									Map attrMap = (Map)LabProceduresPrice.PriceAttributes.class.getMethod(methodsName).invoke(priceAttributes);
									Iterator it = attrMap.entrySet().iterator();
									while(it.hasNext()){
										Map.Entry entry = (Map.Entry) it.next();
										String myKey = String.valueOf(entry.getKey());
										String key = String.valueOf(imap.get(Constans.CACHE_NAME_KEY));
										if(myKey!=null && myKey.equals(key)){
											select = "selected=\"selected\"";
										}
									}
								}
							} catch (Exception e) {
							}
							String str = "<option value=\""+imap.get(Constans.CACHE_NAME_KEY) +"\" "+select+" id=\""+methodsName+"-"+imap.get(Constans.CACHE_NAME_KEY) +"\" title=\""+imap.get(Constans.CACHE_NAME_VALUE)+"\">" + imap.get(Constans.CACHE_NAME_VALUE)+"</option>";
							option.append(str);
						}
						map.put("option", option.toString());
						list.add(map);
					}
				}
			}
		}
		return new ModelAndView("lab/lab_CaseSetting_Procedures_addPrice_div").addObject("datas", list).addObject("price", price).addObject("groupList", groupList);
	}
	
	/**
	 * 
	 * @Title: updateOperateTime 
	 * @Description: 更新营业时间
	 * @author ERIC 
	 * @date 2014-8-18下午02:25:05
	 * @return void
	 */
	@RequestMapping("/updateOperateTime")
	public void updateOperateTime(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "修改失败");
		Lab lab0  = getSessionLab();
		Lab lab = new Lab();
		DXObject.setValue(lab, req);
		lab.setId(lab0.getId());
		if(labService.updateOperateTime(lab)>0){
			result.setResult(Booleans.TRUE);
			result.setInfo("修改成功");
		}
		outReturnAjaxResult(result, resp);
	}
	
	/**
	 * 
	 * @Title: patients 
	 * @Description: 技工间的患者列表
	 * @author ERIC 
	 * @date 2014-8-22上午11:20:56
	 * @return ModelAndView
	 */
	@RequestMapping("/reports/patients")
	public ModelAndView patients(HttpServletRequest req, HttpServletResponse resp){
		try {
			Integer pageNo = getParameterAsInteger(req,"offset");
			String search = req.getParameter("search");
			String type = req.getParameter("type");
			//默认取第一页
			if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
				pageNo = 1;
			}
			Integer labId = getSessionUnitId();
			Patient patientQuery = new Patient();
			patientQuery.setLabId(labId);
			String url = "u_lab_Reports_Patients";
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(type)){
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
					patientQuery.setKeyword(search.toLowerCase());
				}
				
				url = "u_lab_Reports_Patients_show";
			}
			//每页显示20条
			Integer pageSize = 20;
			// 得到结果集
			List<Patient> patientList = patientService.queryPatientBySearch(patientQuery, pageNo, pageSize) ;
			PageModel pm = getPageModel(patientList, patientService.queryPatientCountBySearch(patientQuery), pageSize, pageNo);
			return new ModelAndView("u_lab/" + url).addObject("datas", pm).addObject("search", search);
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
	 * @date 2014-10-11下午03:58:55
	 * @return ModelAndView
	 */
	@RequestMapping("/reports/patient")
	public ModelAndView patient(HttpServletRequest req, HttpServletResponse resp){
		Map<String,Object> modelMap = new HashMap<String, Object>();
		String url = "u_lab_patient_view";
		try {
			Integer pageNo = getParameterAsInteger(req,"offset");
			//默认取第一页
			if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
				pageNo = 1;
			}
			//每页显示10条
			Integer pageSize = 2;

			Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
			String type = ToolsKit.TypeConversionUtil.asString(req.getParameter("type"));
			if("paging".equals(type)){
				url = "patient_view";
			}
			Patient patient = patientService.get(id);
			modelMap.put("patient", patient);
			Cases caseQuery = new Cases();
			caseQuery.setPatientId(id);
			List<Cases> casesList = casesService.listAllByEqual(caseQuery, pageNo, pageSize);
			PageModel casesPm = getPageModel(casesList,	casesService.getCountByEqual(caseQuery), pageSize, pageNo);
			modelMap.put("casesPm", casesPm);
			return new MyModelAndView().setViewName("u_lab/"+url).addAllObjects(modelMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: queryCaseRemake 
	 * @Description: 重制订单查询
	 * @author ERIC 
	 * @date 2014-9-10上午09:27:46
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/reports/queryCaseRemake")
	public ModelAndView queryCaseRemake(HttpServletRequest request, HttpServletResponse response) throws Exception{
		CasesFilter cf = new CasesFilter();
		Cases caseQuery = new Cases();
		Map<String,Object> modelMap = new HashMap<String,Object>();
		DXObject.setValue(cf, request);
		PageModel pm = new PageModel();
		caseQuery.setLabId(getSessionUnitId());
		if(null == cf.getStartDate() && null == cf.getEndDate()){
			cf.setEndDate(ToolsKit.DateUtil.getDayEnd(ToolsKit.DateUtil.nowDate()));
		}
		if(null != cf.getStartDate()){
			cf.setStartDate(ToolsKit.DateUtil.getDayBegin(cf.getStartDate()));
		}
		if(null != cf.getEndDate()){
			cf.setEndDate(ToolsKit.DateUtil.getDayEnd(cf.getEndDate()));
		}
		pm = casesService.queryCaseRemake(cf,caseQuery);
		
		if("csv".equals(cf.getFormat())){
			if(pm.getTotal()>0){
				//导出excel
//				String title = "practice:诊所:0,caseId:重制订单编号:1,returnSId:源订单编号:2,remakeTypeNam:重制原因:3";
				File file = AbstractExcelService.create(pm.getDatas(), Cases.class, "重制订单", Constans.FILE_DOWNLAOD_PATH+"/remakeCases/");
				outReturnString(file.getName(), response);
			}else{
				outReturnString(null, response);
			}
			
			return null;
		}
		modelMap.put("pm", pm);
		modelMap.put("filterOptions", getFilterOptions(cf));
		modelMap.put("startDate", cf.getStartDate());
		modelMap.put("endDate", cf.getEndDate());
		modelMap.put("unitType", cf.getUnitType());
		modelMap.put("unitId", cf.getUnitId());
		return new MyModelAndView().setViewName("u_lab/u_lab_Reports_CaseRemakes_Run").addAllObjects(modelMap);
	}

	/**
	 * 
	 * @Title: getActivitiesLog 
	 * @Description: 技工间主页显示日子
	 * @author king 
	 * @date 2014-9-10上午09:27:46
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/getActivitiesLog")
	public ModelAndView getActivitiesLog(HttpServletRequest req, HttpServletResponse response) throws Exception{
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
		User sessionUser = getSessionUserByLoginEmail();
		List<Map<String, Object>> result = logService.getActivitiesLog(type, startDate, endDate,sessionUser);
		
		return new ModelAndView("lab/lab-main-log").addObject("datas", result).addObject("startDate", ToolsKit.DateUtil.formatDate(startDate, "yyyy-MM-dd")).addObject("sessionUser", sessionUser);
	}
	
	/**
	 * 
	 * @Title: financeResults 
	 * @Description: 技工间财务报表
	 * @author king 
	 * @date 2014-9-10上午09:27:46
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/financeResults")
	public ModelAndView financeResults(HttpServletRequest req, HttpServletResponse response) throws Exception{
		String type = req.getParameter("type");
		String endTime = req.getParameter("endTime");
		String beginTime = req.getParameter("beginTime");
		Integer pageNo = getParameterAsInteger(req, "pageNo");
		if(EmptyCheckUtil.isEmpty(pageNo) || pageNo<1){
			pageNo = 1;
		}
		Date endDate = null;
		Date beginDate = null;
		if("month".equals(type)){
			beginDate = DateUtil.addSeconds(DateUtil.parse(beginTime, "yyyy-MM"), -1);
			endDate = DateUtil.add(DateUtil.parse(endTime, "yyyy-MM"),Calendar.MONTH, 1);
		}else if("custom".equals(type)){
			beginDate = DateUtil.addSeconds(DateUtil.parse(beginTime, "yyyy-MM-dd"), -1);
			endDate = DateUtil.addDay(DateUtil.parse(endTime, "yyyy-MM-dd"), 1);
		}
		
		Map<String, Object> resultMap = casesService.casesFinanceReport(getSessionUserByLoginEmail(), beginDate, endDate, 30, pageNo);
		List<Map<String, Object>> listMap = (List)resultMap.get("resultList");
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("type", type);
		result.put("unitName", getSessionUnitName());
		result.put("beginTime", beginTime);
		result.put("endTime", endTime);
		result.put("queryTime", DateUtil.nowDate().toLocaleString());
		result.put("totalFee", resultMap.get("sumPrice"));
		PageModel pagm = getPageModel(listMap, TypeConversionUtil.asLong(resultMap.get("count")), 30, pageNo);
		result.put("resultPM", pagm);
		
		return new ModelAndView("u_lab/u_lab_Reports_finance").addObject("datas", result);
	}
	
	@RequestMapping("/reports/patientsByPractice")
	public ModelAndView patientsByPractice(HttpServletRequest req, HttpServletResponse resp){
		try {
			Integer pageNo = getParameterAsInteger(req,"offset");
			String search = req.getParameter("search");
			String type = req.getParameter("type");
			Integer unitId = getParameterAsInteger(req, "unitId");
			Integer unitType = getParameterAsInteger(req, "unitType");
			//默认取第一页
			if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
				pageNo = 1;
			}
			Patient patientQuery = new Patient();
			patientQuery.setUnitType(unitType); 
			patientQuery.setLabId(getSessionUnitId());
			patientQuery.setPracticeId(unitId);
			String url = "u_lab_Reports_Patients_forPractice";
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(type)){
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
					patientQuery.setKeyword(search.toLowerCase());
				}
				url = "u_lab_Reports_Patients_show_forPractice";
			}
			//每页显示20条
			Integer pageSize = 20;
			// 得到结果集
			List<Patient> patientList = patientService.queryPatientByPractice(patientQuery, pageNo, pageSize) ;
			PageModel pm = getPageModel(patientList, patientService.queryPatientCountByPractice(patientQuery), pageSize, pageNo);
			return new ModelAndView("u_lab/" + url).addObject("datas", pm).addObject("search", search).addObject("unitId", unitId).addObject("unitType", unitType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/setting/deleteProcedure")
	public void deleteProcedure(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		AjaxResult result = new AjaxResult(Booleans.FALSE, "删除失败");
		labProcedureService.deleteProcedures(getParameterAsInteger(req, "id"));
		result.setResult(Booleans.TRUE);
		outReturnAjaxResult(result, resp);
	}
	
	
}
