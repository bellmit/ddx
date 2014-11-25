package com.upcera.ddx.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.CaseTerms;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.PartnerLab;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.pojo.Permissions;
import com.upcera.ddx.service.cases.ICaseTermsService;
import com.upcera.ddx.service.cases.ICasesService;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.lab.IPartnerLabService;
import com.upcera.ddx.service.user.IUserService;

/**
 * 
 * @Description: 技工间合作伙伴action
 * @author king 
 * @date 2014-6-24 10:32:54
 */
@Controller
@RequestMapping("/partners")
public class LabPartnersAction extends BaseAction{
	@Autowired
	private BaseCache baseCache;
	@Autowired
	private ILabService labService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICasesService casesService;
	@Autowired
	private IPartnerLabService partnerLabService;
	@Autowired
	private ICaseTermsService termsService;
	
	/**
	 * 
	 * @Title: partners 
	 * @Description: 获取伙伴技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/partners")
	public ModelAndView partners(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		List<Lab> list = getPartnerLabList();
		
		//设置审批状态
		PartnerLab plab = new PartnerLab();
		plab.setUnitId(getSessionUnitId());
		List<PartnerLab> plist = partnerLabService.listAllByEqual(plab, 0, 0);
		//Others：获取我申请的合作技工间审批状态，My：获取别人申请我为合作技工间 我的审批状态
		LabAction.setMyApprovalStatus(list, plist,"Others");
		String url = "";
		User user = getSessionUserByLoginEmail();
		
		
		if(Constans.UNIT_LAB.equals(user.getUnitType())){
			url = "u_lab/u_lab_Dashboard_PartnerLabs_admin_shousuo";
		}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
			url = "u_practice/u_practice_partners_list";
		}
		return new MyModelAndView().setViewName(url).addObject("listPartnerLab", list);
	}
	
	/**
	 * 
	 * @Title: searchLabs 
	 * @Description: 查找技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 */
	@RequestMapping("/searchLabs")
	public ModelAndView searchLabs(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		java.util.List<Lab> list = new ArrayList<Lab>();
		//String country = req.getParameter("country");
		String by = req.getParameter("by");
		String value = req.getParameter("value");
		
		Lab lab = new Lab();
		//lab.setCountry(country);
		if("name".equals(by)){
			lab.setName(value);
		}else if("state".equals(by)){
			lab.setState(value);
		}else if("zip".equals(by)){
			Integer zcode = ToolsKit.TypeConversionUtil.asInteger(value);
			if(zcode!=null){
				lab.setZipCode(zcode);
			}else{
				return new MyModelAndView().setViewName("u_lab/search-partner-lab").addObject("searchLab", list);
			}
		}
		
		Integer unitId = getSessionUnitId();
		
		list = labService.listAllByLike(lab, 0, 0);
		for (int i = 0; i < list.size(); i++) {
			Lab ilab = list.get(i);
			if(String.valueOf(ilab.getId()).equals(String.valueOf(unitId))){
				list.remove(i);
			}else{
				if(ToolsKit.EmptyCheckUtil.isEmpty(ilab.getServices())){
					continue;
				}
				Lab.Services service = ToolsKit.jsonUitl.toBean(Lab.Services.class, ilab.getServices());
				StringBuffer serviceAsHTML = new StringBuffer("<div>");
				java.lang.reflect.Method[] method = service.getClass().getMethods();
				for (int j = 0; j < method.length; j++) {
					String methodName = method[j].getName();
					if(methodName.startsWith("is")){
						Boolean result = (Boolean)method[j].invoke(service);
						if(result){
							serviceAsHTML.append("<li>●&nbsp;&nbsp;"+baseCache.getMessage_CN_Map().get(methodName)+"</li>");
						}
					}
				}
				ilab.setServices(serviceAsHTML.append("</div>").toString());
			}
		}
		return new MyModelAndView().setViewName("u_lab/search-partner-lab").addObject("searchLab", list);
	}
	
	/**
	 * 
	 * @Title: requestAccount 
	 * @Description: 前往伙伴技工间或申请账号
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/requestAccount")
	public ModelAndView requestAccount(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MyModelAndView mav = new MyModelAndView();
		Integer labId = getParameterAsInteger(req,"labId");
		if (ToolsKit.EmptyCheckUtil.isEmpty(labId)) {
			throw new Exception("数据传输错误");
		}
		// 伙伴技工间
		Lab lab = labService.get(labId);
		if(ToolsKit.EmptyCheckUtil.isEmpty(lab)){
			throw new Exception("您要访问的对象不存在");
		}
		String prefix = "";
		// 查询审批状态
		PartnerLab plab = new PartnerLab();
		User user = getSessionUserByLoginEmail();
		Integer unitId = 0;
		String unitType = user.getUnitType();
		if(Constans.UNIT_LAB.equals(unitType)){
			prefix = "u_lab";
			unitId = getSessionUserByLoginEmail().getLabId();
		}else if(Constans.UNIT_PRACTICE.equals(unitType)){
			prefix = "u_practice";
			unitId = getSessionUserByLoginEmail().getPracticeId();
		}
		plab.setUnitId(unitId);
		plab.setPartnerId(labId);
		List<PartnerLab> list = partnerLabService.listAllByEqual(plab, 0, 0);
		
		String approveStatus = "";
		
		//初始化页面为等待审批
		String url = "/PartnerLabs_admin_waitApprove";
		
		//已经进行申请操作
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(list)) {
			approveStatus = list.get(0).getPartnerApprovalStatus();

			//已经通过审批操作
			if (Constans.PLAB_APPROVAL_OK.equals(approveStatus)) {
				url = "/PartnerLabs_admin_qianjin_yachi";
				mav.addObject("thisLab", getSessionUnit());
				
				// 伙伴技工间提供的权限
				
				Permissions per = getLabPermissions(labId);
				
				//提供的案例权限
				mav.addObject("financesPermissions", per.getFinances());
				//提供的财政权限
				mav.addObject("casesPermissions", per.getCases());
				
				Cases caseQuery = new Cases();
				caseQuery.setLabId(labId);
				caseQuery.setPracticeId(unitId);
				PageModel casesTryInPm = casesService.listCaseTryIn(caseQuery);
				PageModel casesShipPm = casesService.listCaseShipToday(caseQuery);
				PageModel casesArrivePm = casesService.listCaseArriveToday(caseQuery);
				
				mav.addObject("casesTryInPm", casesTryInPm);
				mav.addObject("casesShipPm", casesShipPm);
				mav.addObject("casesArrivePm", casesArrivePm);
				
				//向接收方下订单的协议
				CaseTerms ct = new CaseTerms();
				ct.setLabid(labId);
				List<CaseTerms> terms = termsService.listAllByEqual(ct, 0, 0);
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(terms)){
					ct = terms.get(0);
					mav.addObject("caseTerms", ct);
				}
				//获取比色卡数据
				mav.addObject("shade_data", baseCache.getProcedureAttrCache().getShadeValue());
				mav.addObject("stumpShade_data", baseCache.getProcedureAttrCache().getStumpShadeValue());
				mav.addObject("user", user);
				
				if (Constans.UNIT_PRACTICE.equals(unitType)) {
					Practice practice = (Practice) getSessionUnit();
					if (ToolsKit.EmptyCheckUtil.isNotEmpty(practice.getProviders())) {
						List<User> providers = userService.ListUser(practice.getProviders());
						mav.addObject("providers", providers);
					}
				}
				
			}
			//审批状态
			mav.addObject("approveStatus", approveStatus);
			
		}
		//未进行申请操作
		else{
			url = "/PartnerLabs_admin_requestAccount";
			User query = new User();
			query.setLabId(user.getLabId());
			query.setPracticeId(user.getPracticeId());
			//获取当前技工间用户，设置电子账单接收者
			mav.addObject("myLabUserList", userService.listAllByEqual(query, 0, 0)) ;
		}
		return mav.setViewName(prefix + url).addObject("requestAccountLab", lab).addObject("listPartnerLabs",getPartnerLabList());
	}
	
	/**
	 * 
	 * @Title: accountPending 
	 * @Description: 申请账号
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/accountPending")
	public ModelAndView accountPending(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Lab lab = null;
		Integer labId = getParameterAsInteger(req,"labId");
		String billtype = req.getParameter("billType");
		String userId = req.getParameter("userId");
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(labId)){
			lab = labService.get(labId);
		}
		
		User user = getSessionUserByLoginEmail();
		
		PartnerLab plab = new PartnerLab();
		plab.setUnitId(user.getUnitId());
		plab.setUnitType(user.getUnitType());
		plab.setPartnerId(labId);
		plab.setBillType(ToolsKit.EmptyCheckUtil.isEmpty(billtype)?"":billtype);
		plab.setBillUserId(ToolsKit.EmptyCheckUtil.isEmpty(userId)?"":userId);
		plab.setPartnerApprovalStatus(Constans.PLAB_APPROVAL_WAIT);
		
		partnerLabService.add(plab);
		
		return new MyModelAndView().setViewName("u_lab/u_lab_Dashboard_PartnerLabs_admin_accountPending").addObject("requestAccountLab", lab);//.addObject("listPartnerLabs", getPartnerLabList());
	}
	
}
