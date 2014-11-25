package com.upcera.ddx.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.CaseShipping;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.LabPermissions;
import com.upcera.ddx.entity.LabPracticePreferences;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.AjaxResult;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.FilterOption;
import com.upcera.ddx.pojo.LabProcedurePojo;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.pojo.Permissions;
import com.upcera.ddx.service.cases.ICasesShippingService;
import com.upcera.ddx.service.lab.ILabPermissionsService;
import com.upcera.ddx.service.lab.ILabProcedureAttrService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.lab.IPracticePreferencesService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.IUserService;

@Controller
@RequestMapping("/baseAction")
public class BaseAction{

	@Autowired
	private IUserService userService;
	@Autowired
	private ILabService labService;
	@Autowired
	private IPracticeService practiceService;
	@Autowired
	private ILabPermissionsService labPermissionsService;
	@Autowired
	private ILabProcedureService labProcedureService;
	@Autowired
	private ILabProcedureAttrService labProcedureAttrService;
	@Autowired
	private IPracticePreferencesService practicePreferencesService;
	@Autowired
	private ICasesShippingService casesShippingService;
	
	public Integer getParameterAsInteger(HttpServletRequest req,String key){
		return ToolsKit.TypeConversionUtil.asInteger(req.getParameter(key));
	}
	
	public Long getParameterAsLong(HttpServletRequest req,String key){
		return ToolsKit.TypeConversionUtil.asLong(req.getParameter(key));
	}
	
	
	/***
	 * @param Obj 对象
	 * @param resp HttpServletResponse
	 * @desc http响应，返回字符串
	 * @return void
	 */
	public static void outReturnString(Object Obj, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		PrintWriter pw = resp.getWriter();
		pw.write(ToolsKit.TypeConversionUtil.asString(Obj));
		pw.close();
	}
	/***
	 * @param Obj 对象
	 * @param resp HttpServletResponse
	 * @desc http响应，返回AjaxResult JSON格式
	 * @return void
	 */
	public static void outReturnAjaxResult(AjaxResult result, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		PrintWriter pw = resp.getWriter();
		pw.write(ToolsKit.jsonUitl.toJson(result));
		pw.close();
	}
	
	/**
	 * 
	 * @Title: outJson 
	 * @Description: 返回JSON格式的数据
	 * @author ERIC 
	 * @date 2014-7-17上午08:56:05
	 * @return void
	 */
	public void outJson(Object obj, String genre, String flag, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("obj", obj);
		map.put("flag", flag);
		map.put("genre", genre);
		PrintWriter pw = resp.getWriter();
		pw.write(ToolsKit.jsonUitl.toJson(map));
		map.clear();
		map = null;
		pw.close();
	}
	
	/***
	 * @desc 初始化注册权限，注册与登录校验专用，未登录情况下service层禁止访问返回不允许访问
	 * @return void
	 */
	@SuppressWarnings("deprecation")
	public void setRegistrationRole(){
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority role = new GrantedAuthorityImpl(Constans.ROLE_SIGN);
		authorities.add(role);
		Authentication authentication = new UsernamePasswordAuthenticationToken("sign", "sign", authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	/***
	 * @param datas 查询出的数据结果集
	 * @param Total 数据总记录数
	 * @param pageSize 每页取多少条
	 * @param pageNo 第几页
	 * @desc 数据分业查询模板
	 * @return PageModel
	 */
	public PageModel getPageModel(List<?> datas,Long Total,Integer pageSize,Integer pageNo){
		if(pageNo<=0){
			pageNo = 1;
		}
		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(Total);
		pm.setDatas(datas);
		// 总页数=记录数/每页大小 （仅当结果大于0时页数+1）
		Long totalPage = ((pm.getTotal() % pageSize) > 0) ? (pm.getTotal() / pageSize) + 1 : (pm.getTotal() / pageSize);
		pm.setTotalPage(totalPage);
		pm.setOffset(pageNo);
		
		//当前页面显示的记录从第几条开始
		int frist = pageNo*pageSize-pageSize + 1;
		pm.setFrist(frist==0?1:frist);
		if(Total==0){
			pm.setFrist(0);
		}
		
		//当前页面显示的记录到第几条结束
		int last = pageNo*pageSize;
		if(pm.getDatas().size()<pageSize){
			int difference = pageSize - pm.getDatas().size();
			last = last - difference;
		}
		pm.setLast(last);
		
		return pm;
	}

	/***
	 * @desc 得到当前登陆用户用户名密码及权限
	 * @return UserDetails
	 */
	public UserDetails getSecurityContextHolderUserDetails() {
		return userService.getUserDetails();
	}

	/***
	 * @desc 根据登陆邮箱得到当前登陆用户
	 * @return User
	 */
	public User getSessionUserByLoginEmail() throws Exception {
		return userService.getSessionUserByLoginEmail();
	}
	/***
	 * @desc 获取当前登陆账户的技工间
	 * @return User
	 */
	public Lab getSessionLab(){
		try {
			return labService.get(getSessionUserByLoginEmail().getLabId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/***
	 * @desc 获取当前登陆机构
	 * @return unit
	 */
	public Object getSessionUnit(){
		try {
			User user = getSessionUserByLoginEmail();
			if(Constans.UNIT_LAB.equals(user.getUnitType())){
				return labService.get(user.getLabId());
			}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
				return practiceService.get(user.getPracticeId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Description: 获取当前登陆机构的ID
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 * @throws Exception 
	 */
	public Integer getSessionUnitId() throws Exception{
		//获取当前用户
		User user = getSessionUserByLoginEmail();
		//获取当前用户的伙伴技工间
		Integer unitId = null;
		if(Constans.UNIT_LAB.equals(user.getUnitType())){
			unitId = user.getLabId();
		}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
			unitId = user.getPracticeId();
		}
		return unitId;
	}
	
	/**
	 * 
	 * @Description: 获取当前登陆机构的名称
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 * @throws Exception 
	 */
	public String getSessionUnitName() throws Exception{
		return userService.getSessionUnitName();
	}
	
	/**
	 * 
	 * @Description: 获取当前用户的伙伴技工间
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 * @throws Exception 
	 */
	public java.util.List<Lab> getPartnerLabList() throws Exception{
		//获取当前用户
		User user = getSessionUserByLoginEmail();
		//获取当前用户的伙伴技工间
		Integer unitId = null;
		if(Constans.UNIT_LAB.equals(user.getUnitType())){
			unitId = user.getLabId();
		}else if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
			unitId = user.getPracticeId();
		}
		return labService.getPartnerLab(unitId);
	}
	
	/**
	 * 
	 * @Description: 获取请求添加当前技工间为伙伴的机构
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 * @throws Exception 
	 */
	public List<Map<String, Object>> getRequestUnit() throws Exception{
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Integer labId = getSessionUserByLoginEmail().getLabId();
		List<Lab> listLab = labService.getRequestAccountLab(labId, 0, 0, "");
		List<Practice> listPra = practiceService.getRequestAccountPractice(labId, 0, 0, "");
		for (int i = 0; i < listLab.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", listLab.get(i).getId());
			map.put("name", listLab.get(i).getName());
			map.put("type", Constans.UNIT_LAB);
			list.add(map);
		}
		for (int i = 0; i < listPra.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", listPra.get(i).getId());
			map.put("name", listPra.get(i).getName());
			map.put("type", Constans.UNIT_PRACTICE);
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 
	 * @Description: 获取技工间的授权
	 * @author king 
	 * @date 2014-6-24 10:33:22
	 * @return List<Lab>
	 * @throws Exception 
	 */
	public Permissions getLabPermissions(Integer labId) throws Exception{
		User user = getSessionUserByLoginEmail();
		// 伙伴技工间提供的权限
		LabPermissions.Cases cases = null;
		LabPermissions.Finances finances = null;
		LabPermissions lp = labPermissionsService.get(labId);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(lp)) {
			cases = ToolsKit.jsonUitl.toBean(LabPermissions.Cases.class, lp.getCases());
			finances = ToolsKit.jsonUitl.toBean(LabPermissions.Finances.class, lp.getFinances());
		}
		if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
			//获取主账户给子账户的授权
			if(!"true".equals(user.getIsMain())){
				Map<String, Object> map = ToolsKit.jsonUitl.toBean(Map.class, user.getLabPermissions());
				String jsonStr = ToolsKit.jsonUitl.toJson(map.get(labId+""));
				cases = ToolsKit.jsonUitl.toBean(LabPermissions.Cases.class,jsonStr);
				finances = ToolsKit.jsonUitl.toBean(LabPermissions.Finances.class,jsonStr);
			}
		}
		Permissions per = new Permissions();
		per.setCases(cases);
		per.setFinances(finances);
		return per;
	}
	
	/**
	 * 
	 * @Title: getSessionPractice 
	 * @Description: 获取当前登陆账户的诊所
	 * @author ERIC 
	 * @date 2014-8-5下午01:56:29
	 * @return Practice
	 */
	public Practice getSessionPractice(){
		try {
			//获取当前用户
			User user = getSessionUserByLoginEmail();
			//获取当前用户的伙伴技工间
			Integer unitId = null;
			if(Constans.UNIT_PRACTICE.equals(user.getUnitType())){
				unitId = user.getPracticeId();
			}
			return practiceService.get(unitId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: outJson 
	 * @Description: 订单操作返回
	 * @author ERIC 
	 * @date 2014-8-11下午04:47:36
	 * @return void
	 */
	public void outJson(Object obj,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		ObjectMapper objectmapper = new ObjectMapper();
		objectmapper.writeValue(pw, obj);
	}
	
	/**
	 * 
	 * @Title: getFilterOptions 
	 * @Description: 获取技工间列表页面过滤条件
	 * @author ERIC 
	 * @date 2014-8-26上午11:37:45
	 * @return Object
	 * @throws Exception 
	 */
	public Object getFilterOptions(CasesFilter cf) throws Exception{
		Integer unitId = getSessionUnitId();
		List<Lab> labList = labService.getRequestAccountLab(unitId, 0, 0, "");
		List<Practice> practiceList = practiceService.getRequestAccountPractice(unitId, 0, 0, "");
		List<FilterOption> filterOptions = new ArrayList<FilterOption>();
		for(Lab lab : labList){
			filterOptions.add(new FilterOption("1",lab.getId(),lab.getName()));
		}
		for(Practice p: practiceList){
			filterOptions.add(new FilterOption("2",p.getId(),p.getName()));
		}
		StringBuffer sb = new StringBuffer();
		for(FilterOption fo : filterOptions){
			if(null != cf){
				if(fo.getUnitType().equals(cf.getUnitType()+"") && fo.getUnitId().equals(cf.getUnitId())){
					sb.append("<option value=\""+fo.getUnitId()+"\" unitType=\""+fo.getUnitType()+"\" selected='selected'>" + fo.getUniteName() + "</option>" );
				}else{
					sb.append("<option value=\""+fo.getUnitId()+"\" unitType=\""+fo.getUnitType()+"\">" + fo.getUniteName() + "</option>" );
				}
			}else{
				sb.append("<option value=\""+fo.getUnitId()+"\" unitType=\""+fo.getUnitType()+"\">" + fo.getUniteName() + "</option>" );
			}
		}
		
		return sb.toString();
	}
	
	// 计算发货日期
	public Date computeShipDate(Cases cases) throws Exception {
		// 订单所添加工序的最大周转天数
		Integer maxTurnAroundDays = getMaxTurnAroudDaysByPro(cases.getProcedures());
		// 发送方指定的入站天数
		Integer transitDays = getInTransitDays(cases);
		Date shipDate = ToolsKit.DateUtil.addDay(cases.getSendToLabDate(), maxTurnAroundDays + transitDays);
		return shipDate;
	}

	// 计算交货日期
	public Date computeDeliveryDate(Cases cases) throws Exception {
		// 订单所添加工序的最大周转天数
		Integer maxTurnAroundDays = getMaxTurnAroudDaysByPro(cases.getProcedures());
		// 发送方指定的入站、出站天数
		Integer transitDays = getInOutTransitDays(cases);
		Date deliveryDate = ToolsKit.DateUtil.addDay(cases.getSendToLabDate(), maxTurnAroundDays + transitDays);
		return deliveryDate;
	}

	// 订单所添加工序的最大周转天数
	private Integer getMaxTurnAroudDaysByPro(String procedureContent) throws Exception {
		Integer maxTurnAroudDays = 10;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(procedureContent)) {
			List<LabProcedurePojo> lpList = ToolsKit.jsonUitl.toBeanList(LabProcedurePojo.class, procedureContent);
			List<Integer> intList = new ArrayList<Integer>();
			for (LabProcedurePojo lp : lpList) {
				intList.add(Integer.parseInt(lp.getProcedure_id()));
			}
			maxTurnAroudDays = labProcedureService.queryMaxTurnAroudDays(intList);

		}
		return maxTurnAroudDays;
	}

	// 发送方指定的入站天数
	private Integer getInTransitDays(Cases cases) throws Exception {
		String days = "0";
		LabPracticePreferences labp = new LabPracticePreferences();
		if (1 == cases.getUnitType()) {
			labp.setLabId(cases.getPracticeId());
		} else if (2 == cases.getUnitType()) {
			labp.setPracticeId(cases.getPracticeId());
		} else {
			return 0;
		}

		LabPracticePreferences pp = new LabPracticePreferences();
		List<LabPracticePreferences> ppList = practicePreferencesService.listAllByEqual(labp, 0, 0);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(ppList)) {
			pp = ppList.get(0);
		}
		if ("true".equals(pp.getOverrideTransitTime())) {
			days = pp.getInboundTransitDays() + "";
		} else {
			CaseShipping cs = new CaseShipping();
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(pp.getShippingId())) {
				// 得到结果集
				cs = casesShippingService.get(pp.getShippingId());
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(cs)) {
					days = cs.getInboundTransitDays() + "";
				}
			}
		}
		return Integer.valueOf(days);
	}

	// 发送方指定的入站、出站天数
	private Integer getInOutTransitDays(Cases cases) throws Exception {
		String days = "0";
		LabPracticePreferences labp = new LabPracticePreferences();
		if (1 == cases.getUnitType()) {
			labp.setLabId(cases.getPracticeId());
		} else if (2 == cases.getUnitType()) {
			labp.setPracticeId(cases.getPracticeId());
		} else {
			return 0;
		}

		LabPracticePreferences pp = new LabPracticePreferences();
		List<LabPracticePreferences> ppList = practicePreferencesService.listAllByEqual(labp, 0, 0);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(ppList)) {
			pp = ppList.get(0);
		}
		if ("true".equals(pp.getOverrideTransitTime())) {
			days = pp.getInboundTransitDays() + pp.getOutboundTransitDays() + "";
		} else {
			CaseShipping cs = new CaseShipping();
			// 得到结果集
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(pp.getShippingId())) {
				cs = casesShippingService.get(pp.getShippingId());
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(cs)) {
					days = cs.getInboundTransitDays() + cs.getOutboundTransitDays() + "";
				}
			}

		}
		return Integer.valueOf(days);
	}
	
	
}