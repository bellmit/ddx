package com.upcera.ddx.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.cache.impl.ProcedureAttrCache;
import com.upcera.ddx.common.cache.impl.ProcedurePriceAttrCache;
import com.upcera.ddx.common.excel.AbstractExcelService;
import com.upcera.ddx.common.reflect.DXObject;
import com.upcera.ddx.common.target.Note;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.CaseHold;
import com.upcera.ddx.entity.CaseRemake;
import com.upcera.ddx.entity.CaseShipping;
import com.upcera.ddx.entity.CaseTerms;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.CasesBargainRequest;
import com.upcera.ddx.entity.Caseschedulingholida;
import com.upcera.ddx.entity.Lab;
import com.upcera.ddx.entity.LabCaseCoupons;
import com.upcera.ddx.entity.LabPracticeNotes;
import com.upcera.ddx.entity.LabPracticePreferences;
import com.upcera.ddx.entity.LabPriceGroup;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.entity.LabProcedureAttr;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.entity.LabProceduresComposition;
import com.upcera.ddx.entity.LabProceduresGroup;
import com.upcera.ddx.entity.LabProceduresGroupLink;
import com.upcera.ddx.entity.LabProceduresOutLink;
import com.upcera.ddx.entity.LabProceduresPrice;
import com.upcera.ddx.entity.PartnerLab;
import com.upcera.ddx.entity.Practice;
import com.upcera.ddx.entity.ProcedureCategory;
import com.upcera.ddx.entity.ProcedureDisplayCategory;
import com.upcera.ddx.entity.ProcedureSubCategory;
import com.upcera.ddx.entity.ProcedureType;
import com.upcera.ddx.entity.User;
import com.upcera.ddx.pojo.CasesFilter;
import com.upcera.ddx.pojo.FilterOption;
import com.upcera.ddx.pojo.MyModelAndView;
import com.upcera.ddx.pojo.PageModel;
import com.upcera.ddx.service.cases.ICaseCouponsService;
import com.upcera.ddx.service.cases.ICaseRemakeService;
import com.upcera.ddx.service.cases.ICaseSchedulingHolidaService;
import com.upcera.ddx.service.cases.ICaseTermsService;
import com.upcera.ddx.service.cases.ICaseholdService;
import com.upcera.ddx.service.cases.ICasesBargainRequestService;
import com.upcera.ddx.service.cases.ICasesService;
import com.upcera.ddx.service.cases.ICasesShippingService;
import com.upcera.ddx.service.lab.ILabPracticeNotesService;
import com.upcera.ddx.service.lab.ILabPriceGroupService;
import com.upcera.ddx.service.lab.ILabProcedureAttrService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabProceduresCharacterisService;
import com.upcera.ddx.service.lab.ILabProceduresCompositionService;
import com.upcera.ddx.service.lab.ILabProceduresGroupLinkService;
import com.upcera.ddx.service.lab.ILabProceduresGroupService;
import com.upcera.ddx.service.lab.ILabProceduresOutLinkService;
import com.upcera.ddx.service.lab.ILabProceduresPriceService;
import com.upcera.ddx.service.lab.ILabService;
import com.upcera.ddx.service.lab.IPartnerLabService;
import com.upcera.ddx.service.lab.IPracticePreferencesService;
import com.upcera.ddx.service.lab.IProcedureDisplayCategoryService;
import com.upcera.ddx.service.lab.IProcedureSubCategoryService;
import com.upcera.ddx.service.lab.IProcedureTypeService;
import com.upcera.ddx.service.practice.IPracticeService;
import com.upcera.ddx.service.user.IUserService;

@Controller
public class CaseDataQuery extends BaseAction{
	@Autowired
	private BaseCache baseCache;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICaseholdService chservice;
	@Autowired
	private IProcedureDisplayCategoryService procedureDisplayCategoryService;
	@Autowired
	private ICaseCouponsService caseCouponsService;
	@Autowired
	private IPracticeService practiceService;
	@Autowired
	private ILabService labService;
	@Autowired
	private IPartnerLabService partnerLabService;
	@Autowired
	private ICaseRemakeService caseRemakeService;
	@Autowired
	private IPracticePreferencesService practicePreferencesService;
	@Autowired
	private ICasesShippingService casesShippingService;
	@Autowired
	private ILabPriceGroupService labPriceGroupService;
	@Autowired
	private ILabProceduresGroupService labProceduresGroupService;
	@Autowired
	private ILabPracticeNotesService labPracticeNotesService;
	@Autowired
	private ICaseTermsService caseTermsService;
	@Autowired
	private ICaseSchedulingHolidaService caseSchedulingHolidaService;
	@Autowired
	private  ILabProcedureService labProcedureService;
	@Autowired
	private ICasesService casesService;
	@Autowired
	private ILabProceduresCharacterisService characterisService;
	@Autowired
	private ILabProceduresCompositionService compositionService;
	@Autowired
	private IProcedureSubCategoryService procedureSubCategoryService;
	@Autowired
	private IProcedureTypeService procedureTypeService;
	@Autowired
	private ILabProceduresGroupLinkService labProceduresGroupLinkService;
	@Autowired
	private ILabProcedureAttrService labProcedureAttrService;
	@Autowired
	private ILabProceduresOutLinkService labProceduresOutLinkService;
	@Autowired
	private ILabProceduresCharacterisService labProceduresCharacterisService;
	@Autowired
	private ILabProceduresPriceService labProceduresPriceService;
	@Autowired
	private ICasesBargainRequestService bargainRequestService;
	
	/**
	 * 
	 * @Description: 临床服务-编辑诊所或技工间-默认展示第一个面板（查询详细信息）
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return Object
	 */
	public Object myCooperationPractices(HttpServletRequest req) throws Exception {
		Object obj = null;
		//诊所id或技工间id
		Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
		String type = req.getParameter("type");

		if (Constans.UNIT_LAB.equals(type)) {
			obj = labService.get(id);
		} else if (Constans.UNIT_PRACTICE.equals(type)) {
			obj = practiceService.get(id);
		} else {
			throw new Exception("数据传输错误");
		}
		if(ToolsKit.EmptyCheckUtil.isEmpty(obj)){
			throw new Exception("数据传输错误");
		}
		PartnerLab plab = new PartnerLab();
		plab.setUnitId(id);
		plab.setPartnerId(userService.getSessionUserByLoginEmail().getLabId());
		List<PartnerLab> plist = partnerLabService.listAllByEqual(plab, 0, 0);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(plist)) {
			obj.getClass().getMethod("setAccountStatus", String.class).invoke(obj, plist.get(0).getPartnerApprovalStatus());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("plab", obj);
		map.put("type", type);
		return map;
	}
	/**
	 * 
	 * @Description: 临床服务-编辑诊所或技工间-查询首要信息
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return Object
	 */
	public Object practicePreferences(HttpServletRequest req) throws Exception {
		String type = req.getParameter("type");
		//诊所id或技工间id
		Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
		LabPracticePreferences labp = new LabPracticePreferences();
		if (Constans.UNIT_LAB.equals(type)) {
			labp.setLabId(id);
		} else if (Constans.UNIT_PRACTICE.equals(type)) {
			labp.setPracticeId(id);
		} else {
			throw new Exception("数据传输错误");
		}
		labp.setLid(getSessionUnitId());
		
		LabPracticePreferences pp = null;
		List<LabPracticePreferences> ppList = practicePreferencesService.listAllByEqual(labp, 0, 0);
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(ppList)){
			pp = ppList.get(0);
		}
		Integer thisLabId = getSessionUserByLoginEmail().getLabId();
		LabPriceGroup lpgQuery = new LabPriceGroup();
		lpgQuery.setLabId(thisLabId);
		List<LabPriceGroup> lpgList = labPriceGroupService.listAllByEqual(lpgQuery, 0, 0);
		
		LabProceduresGroup lpdgQuery = new LabProceduresGroup();
		lpdgQuery.setLabId(thisLabId);
		List<LabProceduresGroup> lpdgList = labProceduresGroupService.listAllByEqual(lpdgQuery, 0, 0);
		
		CaseShipping csquery = new CaseShipping();
		csquery.setLabId(thisLabId);
		List<CaseShipping> csList = casesShippingService.listAllByEqual(csquery, 0, 0);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("unitId", id);
		map.put("unitType", type);
		map.put("labPracticePreferences", pp);
		map.put("casesShipping", csList);
		map.put("labPriceGroup", lpgList);
		map.put("labProceduresGroup", lpdgList);
		return map;
	}
	/**
	 * 
	 * @Description: 临床服务-编辑诊所或技工间-查询联系人信息
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return Object
	 * @throws Exception 
	 */
	public Object practiceContacts(HttpServletRequest req) throws Exception {
		// 诊所id或技工间id
		Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
		
		PartnerLab plab = new PartnerLab();
		plab.setUnitId(id);
		plab.setPartnerId(userService.getSessionUserByLoginEmail().getLabId());
		
		List<PartnerLab> plist = partnerLabService.listAllByEqual(plab, 0, 0);
		if (plist != null && plist.size() > 1) {
			throw new Exception("数据错误，查询结果集大于1");
		}
		List<User> listUser = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(plist)) {
			PartnerLab iplab = plist.get(0);
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(iplab.getBillUserId())) {
				listUser = userService.ListUser(iplab.getBillUserId());
			}
		}
		return listUser;
	}
	/**
	 * 
	 * @Description: 临床服务-编辑诊所或技工间-查询笔记信息
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return Object
	 * @throws Exception 
	 */
	public Object practiceNotes(HttpServletRequest req) throws Exception {
		String type = req.getParameter("type");
		// 诊所id或技工间id
		Integer id = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("id"));
		
		LabPracticeNotes note = new LabPracticeNotes();
		if (Constans.UNIT_LAB.equals(type)) {
			note.setLabId(id);
		} else if (Constans.UNIT_PRACTICE.equals(type)) {
			note.setPracticeId(id);
		} else {
			throw new Exception("数据传输错误");
		}
		note.setLid(getSessionUnitId());
		LabPracticeNotes notes = null;
		List<LabPracticeNotes> noteList = labPracticeNotesService.listAllByEqual(note, 0, 0);
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(noteList)){
			notes = noteList.get(0);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("notes", notes);
		map.put("type", type);
		map.put("unitId", id);
		return map;
	}
	/**
	 * 
	 * @Description: 临床服务-编辑诊所或技工间-查询价格列表信息，同时支持诊所端查询合作技工间的报价列表
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return Object
	 * @throws Exception 
	 */
	public Object practicePriceList(HttpServletRequest req) throws Exception {
		String type = req.getParameter("type");
		Integer id = getParameterAsInteger(req, "id");
		Integer labId = getParameterAsInteger(req, "labId");
		if(ToolsKit.EmptyCheckUtil.isEmpty(labId)){
			labId = ToolsKit.TypeConversionUtil.asInteger(req.getAttribute("labId"));
			if(ToolsKit.EmptyCheckUtil.isEmpty(labId)){
				labId = getSessionUnitId();
			}
		}
		if(ToolsKit.EmptyCheckUtil.isEmpty(type)){
			type = ToolsKit.TypeConversionUtil.asString(req.getAttribute("type"));
		}
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(req.getAttribute("flag")) && "financePricerList".equals(req.getAttribute("flag"))){
			id = getSessionUnitId();
		}
		List<Map<String, Object>> list = labPriceGroupService.listUnitPriceList(type, id,labId,null);
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(list)){
			for (int i = 0; i < list.size(); i++) {
				String attr = ToolsKit.TypeConversionUtil.asString(list.get(i).get("attrbutes"));
				LabProceduresPrice.PriceAttributes pa = ToolsKit.jsonUitl.toBean(LabProceduresPrice.PriceAttributes.class, attr);
				Method[]  methods = pa.getClass().getMethods();
				
				List<Map<String, Object>> priceAttrList = new ArrayList<Map<String,Object>>();
				for (int j = 0; j < methods.length; j++) {
					if(methods[j].getName().startsWith("get") && methods[j].getName().endsWith("presence")){
						Map m = (Map)methods[j].invoke(pa);
						if(ToolsKit.EmptyCheckUtil.isNotEmpty(m)){
							
							Map<String, Object> imap = new HashMap<String, Object>();
							Map<String, Object> commentMap = AbstractExcelService.parseComment(LabProcedureAttr.class.getMethod(methods[j].getName()),Note.class);
							imap.put("lable", commentMap.get("name"));
							
							StringBuffer pattr = new StringBuffer();
							List plist = (List)ProcedurePriceAttrCache.class.getMethod(methods[j].getName()).invoke(baseCache.getProcedurePriceAttrCache());
							Iterator it = m.entrySet().iterator();
							while(it.hasNext()){
								Map.Entry entry = (Map.Entry) it.next();
								String key = String.valueOf(entry.getKey());
								for (int k = 0; k < plist.size(); k++) {
									Map mm = (Map)plist.get(k);
									if(ToolsKit.TypeConversionUtil.asString(mm.get(Constans.CACHE_NAME_KEY)).equals(key)){  
										pattr.append(mm.get(Constans.CACHE_NAME_VALUE)).append(";");
									}
								}
							}
							imap.put("attr", pattr.toString());
							priceAttrList.add(imap);
						}
					}
				}
				list.get(i).put("attrbutesList", priceAttrList);
			}
		}
		return list;
		
	}
	
	public Object onHoldTypes(HttpServletRequest req) throws Exception{
		Integer labId = getSessionUserByLoginEmail().getLabId();
		CaseHold ch = new CaseHold();
		ch.setLabId(labId);
		// 得到结果集
		List<CaseHold> datas = chservice.listAllByEqual(ch, 1,10);
		
		PageModel pm = getPageModel(datas, chservice.getCountByEqual(ch), 10, 1);
		return pm;
	}
	
	public Object displayCategories(HttpServletRequest req) throws Exception{
		Integer labId = getSessionUserByLoginEmail().getLabId();
		ProcedureDisplayCategory lp=new ProcedureDisplayCategory();
		lp.setLabId(labId);
		// 得到结果集
		List<ProcedureDisplayCategory> datas =procedureDisplayCategoryService.listAllByEqual(lp, 1,10);
		PageModel pm = getPageModel(datas, procedureDisplayCategoryService.getCountByEqual(lp), 10, 1);
		return pm;
	}
	
	public Object ddxCoupons(HttpServletRequest req) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer labId = getSessionUserByLoginEmail().getLabId();
		LabCaseCoupons lcc=new LabCaseCoupons();
		lcc.setLabid(labId);
		// 得到结果集
		List<LabCaseCoupons> datas =caseCouponsService.listAllByEqual(lcc, 1,10);
		PageModel pm = getPageModel(datas, caseCouponsService.getCountByEqual(lcc), 10, 1);
		map.put("datas", pm);
		return map;
	}
	
	public Object shippingTypes(HttpServletRequest req) throws Exception{
		Integer labId = getSessionUserByLoginEmail().getLabId();
		CaseShipping cs=new CaseShipping();
		cs.setLabId(labId);
		// 得到结果集
		List<CaseShipping> datas =casesShippingService.listAllByEqual(cs, 1,10);
		PageModel pm = getPageModel(datas, casesShippingService.getCountByEqual(cs), 10, 1);
		return pm;
	}
	
	public Object remakeTypes(HttpServletRequest req) throws Exception{
		Integer labId=getSessionUserByLoginEmail().getLabId();
		CaseRemake cr=new CaseRemake();
		cr.setLabid(labId);
		List<CaseRemake> datas=caseRemakeService.listAllByEqual(cr, 1, 10);
		PageModel pm=getPageModel(datas, caseRemakeService.getCountByEqual(cr), 10, 1);
		return pm;
	}
	/**
	 * 
	 * @Description: 案例设置-工序-查询所有工序
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return Object
	 * @throws Exception 
	 */
	public Object labProcedures(HttpServletRequest req) throws Exception {
		Integer pageNo = getParameterAsInteger(req,"offset");
		String search = req.getParameter("search");
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		Integer thisLabId = getSessionUserByLoginEmail().getLabId();
		LabProcedure lp = new LabProcedure();
		lp.setLabId(thisLabId);
		lp.setDisplayDescription(search);
		lp.setDisplayName(search);
		List<LabProcedure> data = labProcedureService.listAllByLike(lp, pageNo, 10);
		
		List<LabProcedureAttr> attrList = labProcedureAttrService.listAll();
		
		ProcedureDisplayCategory pc = new ProcedureDisplayCategory();
		pc.setLabId(thisLabId);
		List<ProcedureDisplayCategory>  pdcList = procedureDisplayCategoryService.listAllByEqual(pc, 0, 0);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("procedure", data.get(i));
			a:for (int j = 0; j < pdcList.size(); j++) {
				if(pdcList.get(j).getId().equals(data.get(i).getCategoryId())){
					map.put("category", pdcList.get(j).getName());
					break a;
				}
			}
			b: for (int j = 0; j < attrList.size(); j++) {
				if (data.get(i).getProceduresId().equals(attrList.get(j).getProcedures_id())) {
					StringBuffer attr = new StringBuffer();
					Method[] method = attrList.get(j).getClass().getMethods();
					for (int k = 0; k < method.length; k++) {
						String methodName = method[k].getName().toLowerCase();
						if (methodName.startsWith("get") && methodName.endsWith("presence")) {
							String obj = (String)method[k].invoke(attrList.get(j));
							if (ToolsKit.EmptyCheckUtil.isNotEmpty(obj) && !Constans.PRESENCE_NOT_APPLICABLE.equals(obj)) {
								Map<String, Object> commentMap = AbstractExcelService.parseComment(method[k],Note.class);
								attr.append(commentMap.get("name")).append(";");
							}
						}
					}
					map.put("attr", attr);
					break b;
				}
			}
			mapList.add(map);
		}
		return getPageModel(mapList, labProcedureService.getCountByLike(lp), 10, pageNo);
	}
	public Object terms(HttpServletRequest req) throws Exception {
		Integer labId=getSessionUserByLoginEmail().getLabId();
		CaseTerms ct=new CaseTerms();
		ct.setLabid(labId);
		List<CaseTerms> datas=caseTermsService.listAllByEqual(ct, 0, 0);
		if(datas.size()==0){
			return null;
		}else{
			CaseTerms caseTerms =datas.get(0);
			return caseTerms;
		}
		
	}
	public Object schedulingAndHolidays(HttpServletRequest req) throws Exception{
		Integer labId=getSessionUserByLoginEmail().getLabId();
		Integer pageNo=0;
		Integer pageSize = 0;
		Caseschedulingholida caseschedulingholida=new Caseschedulingholida();
		caseschedulingholida.setLabid(labId);
		List<Caseschedulingholida> datas= caseSchedulingHolidaService.listAllByEqual(caseschedulingholida, pageNo, pageSize);
		if(datas.size()==0){
			return null;
		}else{
			Caseschedulingholida  csh = datas.get(0);
			Caseschedulingholida.Workdays monday=null;
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(csh)) {
				monday = ToolsKit.jsonUitl.toBean(Caseschedulingholida.Workdays.class, csh.getWorkdays());
			}
			Map<String, Object> map = new HashMap<String, Object>();
			String holiday=csh.getHolidays();
			if(holiday!=null){
				String[] holidays = csh.getHolidays().split(",");
				map.put("csh", csh);
				map.put("holidays", holidays);
				map.put("monday", monday);
			}else{
				map.put("csh", csh);
				map.put("holidays", holiday);
				map.put("monday", monday);
			}
			return map;
		}
	}
	
	/**
	 * 
	 * @Title: main 
	 * @Description: 给技工间主页面赋值
	 * @author ERIC 
	 * @date 2014-7-23下午04:41:43
	 * @return Object
	 */
	public Object main(HttpServletRequest request) throws Exception{
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("month", month);
		map.put("year", year);
		return map;
	}
	
	/**
	 * 
	 * @Title: byMonth 
	 * @Description: 通过月份查询订单
	 * @author ERIC 
	 * @date 2014-7-23下午04:46:52
	 * @return Object
	 */
	public Object byMonth(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		Integer year = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("year"));
		Integer month = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("month"));
		if(null == year || null == month){
			return new Exception("参数错误！");
		}
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);
		Cases caseQuery = new Cases();
		caseQuery.setLabId(getSessionLab().getId());
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示20条
		Integer pageSize = 20;
		// 得到结果集
		List<Cases> casesList = casesService.listCaseByMonth(cf,caseQuery,pageNo,pageSize);
		
		PageModel pm = getPageModel(casesList, casesService.getCaseCountByMonth(cf,caseQuery), pageSize, pageNo);
		map.put("year", year);
		map.put("month", month);
		map.put("casesList", pm);
		map.put("filterOptions", getFilterOptions(cf));
		map.put("multiFilters", cf);
		return map;
	}
	
	/**
	 * 
	 * @Title: toArrive 
	 * @Description: 订单抵达
	 * @author ERIC 
	 * @date 2014-8-27上午08:49:19
	 * @return Object
	 * @throws Exception 
	 */
	public Object toArrive(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);
		//每页显示20条
		Integer pageSize = 20;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());
		// 得到结果集
		List<Cases> casesList = casesService.queryArriveCaseByLabPage(cf, caseQuery, pageNo, pageSize);
		
		PageModel arrivePm = getPageModel(casesList, casesService.queryArriveCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
		
		map.put("arrivePm", arrivePm);
		map.put("filterOptions", getFilterOptions(cf));
		map.put("multiFilters", cf);
		
		return map;
	}
	
	/**
	 * 
	 * @Title: toShip 
	 * @Description: 订单发货
	 * @author ERIC 
	 * @date 2014-8-27上午08:49:24
	 * @return Object
	 * @throws Exception 
	 */
	public Object toShip(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示20条
		Integer pageSize = 20;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);
		// 得到结果集
		List<Cases> casesList = casesService.queryShipCaseByLabPage(cf, caseQuery, pageNo, pageSize);
		PageModel shipPm = getPageModel(casesList, casesService.queryShipCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
		map.put("shipPm", shipPm); 
		map.put("filterOptions", getFilterOptions(cf));
		map.put("multiFilters", cf);
		return map;
	}
	
	/**
	 * 
	 * @Title: openTryIns 
	 * @Description: 试戴订单
	 * @author ERIC 
	 * @date 2014-8-27上午08:50:34
	 * @return Object
	 * @throws Exception 
	 */
	public Object openTryIns(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示20条
		Integer pageSize = 20;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);
		// 得到结果集
		List<Cases> casesList = casesService.queryTryInCaseByLabPage(cf, caseQuery, pageNo, pageSize);
		PageModel tryInPm = getPageModel(casesList, casesService.queryTryInCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
		map.put("tryInPm", tryInPm);
		map.put("filterOptions", getFilterOptions(cf));
		map.put("multiFilters", cf);
		return map;
	}
	
	/**
	 * 
	 * @Title: onHold 
	 * @Description: 保持订单
	 * @author ERIC 
	 * @date 2014-8-27上午08:51:11
	 * @return Object
	 * @throws Exception 
	 */
	public Object onHold(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示20条
		Integer pageSize = 20;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());
		CasesFilter cf = new CasesFilter();
		DXObject.setValue(cf, request);
		// 得到结果集
		List<Cases> casesList = casesService.queryOnHoldCaseByLabPage(cf, caseQuery, pageNo, pageSize);
		PageModel onHoldPm = getPageModel(casesList, casesService.queryOnHoldCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
		map.put("onHoldPm", onHoldPm);
		map.put("filterOptions", getFilterOptions(cf));
		map.put("multiFilters", cf);
		return map;
	}
	
	/**
	 * 
	 * @Title: toOutsource 
	 * @Description: 外包订单
	 * @author ERIC 
	 * @date 2014-8-27上午08:51:59
	 * @return Object
	 * @throws Exception 
	 */
	public Object toOutsource(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("offset"));
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示20条
		Integer pageSize = 20;
		Cases caseQuery = new Cases();
		Lab lab = getSessionLab();
		caseQuery.setLabId(lab.getId());
		CasesFilter cf = new CasesFilter(); 
		DXObject.setValue(cf, request);
		// 得到结果集
		List<Cases> casesList = casesService.queryOutsourceCaseByLabPage(cf, caseQuery, pageNo, pageSize);
		PageModel outsourcePm = getPageModel(casesList, casesService.queryOutsourceCaseCountByLabPage(cf, caseQuery), pageSize, pageNo);
		map.put("outsourcePm", outsourcePm);
		map.put("filterOptions", getFilterOptions(cf));
		map.put("multiFilters", cf);
		return map;
	}
	
	
	/**
	 * 
	 * @Title: materials 
	 * @Description: 工序-特性-材料
	 * @author ERIC 
	 * @date 2014-7-28上午11:31:06
	 * @return Object
	 */
	public Object materials(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_MATERIALS);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}
	/**
	 * 
	 * @Title: materials 
	 * @Description: 优惠劵-增加-绑定两个下拉框的值
	 * @author ERIC 
	 * @date 2014-7-28上午11:31:06
	 * @return Object
	 */
	public Object addcoupons(HttpServletRequest req) throws Exception{
		Integer labId = getSessionUserByLoginEmail().getLabId();
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> boundCoupons=new ArrayList<Map<String,Object>>();
		boundCoupons=getRequestUnit();
		map.put("boundCoupons", boundCoupons);
		map.put("pro", labProcedureService.getProedureAsHtml(labId));
		return map;
	}
	/**
	 * 
	 * @Title: enclosures 
	 * @Description: 工序-特性-附件
	 * @author ERIC 
	 * @date 2014-7-28下午12:22:14
	 * @return Object
	 */
	public Object enclosures(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_ENCLOSURES);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}
	
	/**
	 * 
	 * @Title: goMaterial 
	 * @Description: 跳转到工序-特性-材料 的新增修改页面
	 * @author ERIC 
	 * @date 2014-7-29下午02:14:23
	 * @return Object
	 */
	public Object goMaterial(HttpServletRequest request){
		PageModel pm = new PageModel();
		Map<String,Object> map = new HashMap<String,Object>();
		Integer id = ToolsKit.TypeConversionUtil.asInteger(request.getParameter("id"));
		LabProceduresCharacteris characteris = null;
		characteris = characterisService.get(id);
		LabProceduresComposition composition = new LabProceduresComposition();
		composition.setCharacterId(id);
		pm = compositionService.getCompositionByCriteria(composition);
		map.put("material", characteris);
		map.put("compostionPm", pm);
		return map;
	}
	
	/**
	 * 
	 * @Title: acrylicColors 
	 * @Description: 工序-特性-acrylicColors
	 * @author ERIC 
	 * @date 2014-7-28下午12:31:14
	 * @return Object
	 */
	public Object acrylicColors(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_ACRYLICCOLORS);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}
	
	/**
	 * 
	 * @Title: sportGuardColors 
	 * @Description: 工序-特性-sportGuardColors
	 * @author ERIC 
	 * @date 2014-7-28下午12:32:09
	 * @return Object
	 */
	public Object sportGuardColors(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_SPORTGUARDCOLORS);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}
	
	/**
	 * 
	 * @Title: orthodonticColors 
	 * @Description: 工序-特性-orthodonticColors
	 * @author ERIC 
	 * @date 2014-7-28下午12:32:35
	 * @return Object
	 */
	public Object orthodonticColors(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICCOLORS);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}
	
	/**
	 * 
	 * @Title: orthodonticDesigns 
	 * @Description: 工序-特性-orthodonticDesigns
	 * @author ERIC 
	 * @date 2014-7-28下午12:32:57
	 * @return Object
	 */
	public Object orthodonticDesigns(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICDESIGNS);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}
	
	/**
	 * 
	 * @Title: implantSystems 
	 * @Description: 工序-特性-implantSystems
	 * @author ERIC 
	 * @date 2014-7-28下午12:33:22
	 * @return Object
	 */
	public Object implantSystems(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_IMPLANTSYSTEMS);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}
	
	/**
	 * 
	 * @Title: implantMarkers 
	 * @Description: 工序-特性-implantMarkers
	 * @author ERIC 
	 * @date 2014-7-28下午12:33:53
	 * @return Object
	 */
	public Object implantMarkers(HttpServletRequest req) throws Exception{
		LabProceduresCharacteris lpc = new LabProceduresCharacteris();
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		String search = ToolsKit.TypeConversionUtil.asString(req.getParameter("search"));
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(search)){
			lpc.setCharacterName(search);
			map.put("search", search);
		}
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		lpc.setType(Constans.PROCEDURES_CHARACTERIS_IMPLANTMARKERS);
		lpc.setLabId(getSessionLab().getId());
		List<LabProceduresCharacteris> datas = characterisService.getCharacterByCriteria(lpc, pageNo, pageSize);
		PageModel pm = getPageModel(datas, characterisService.getCharacterCountByCriteria(lpc), pageSize, pageNo);
		map.put("pm", pm);
		return map;
	}

	/**
	 * 
	 * @Title: general 
	 * @Description: 设置页面-案例设置-工序-一般信息
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	public Object general(HttpServletRequest req) throws Exception {
		Integer updateId = getParameterAsInteger(req, "id");
		Integer labId = getSessionUserByLoginEmail().getLabId();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "add");
		map.put("title", "新增工序");
		LabProcedure lpd = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(updateId)) {
			lpd = labProcedureService.get(updateId);
			if(ToolsKit.EmptyCheckUtil.isEmpty(lpd)){
				throw new Exception("您要访问的对象不存在");
			}
			if (!labId.equals(lpd.getLabId())) {
				throw new Exception("非法操作，无权访问");
			}
			map.put("lpd", lpd);
			map.put("type", "update");
			map.put("title", "修改工序");
		}
		// 类型
		List<ProcedureCategory> pcList = baseCache.getProcedureTypeCache().getProcedureCategoryList();
		// 子类型
		ProcedureSubCategory psc = new ProcedureSubCategory();
		if (ToolsKit.TypeConversionUtil.asString(map.get("type")).equals("update")) {
			psc.setCategoryId(lpd.getProceduresCategoryId());
		} else {
			psc.setCategoryId(pcList.get(0)!=null?pcList.get(0).getId():null);
		}
		List<ProcedureSubCategory> pscList = procedureSubCategoryService.listAllByEqual(psc, 0, 0);
		// 工序
		ProcedureType pt = new ProcedureType();
		if (ToolsKit.TypeConversionUtil.asString(map.get("type")).equals("update")) {
			pt.setSubId(lpd.getProceduresCategorySubId());
		} else {
			pt.setSubId(pscList.get(0)!=null?pscList.get(0).getId():null);
		}
		List<ProcedureType> ptList = procedureTypeService.listAllByEqual(pt, 0, 0);

		// 显示类型
		ProcedureDisplayCategory pdc = new ProcedureDisplayCategory();
		pdc.setLabId(labId);
		List<ProcedureDisplayCategory> pdcList = procedureDisplayCategoryService.listAllByEqual(pdc, 0, 0);
		// 工序组
		LabProceduresGroup lpdgQuery = new LabProceduresGroup();
		lpdgQuery.setLabId(labId);
		List<LabProceduresGroup> lpdgList = labProceduresGroupService.listAllByEqual(lpdgQuery, 0, 0);

		List<LabProceduresGroupLink> lpdglList = null;
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(updateId)) {
			LabProceduresGroupLink lpdglQuery = new LabProceduresGroupLink();
			lpdglQuery.setProceduresId(updateId);
			lpdglList = labProceduresGroupLinkService.listAllByEqual(lpdglQuery, 0, 0);
		}
		List<Map<String, Object>> groupLink = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < lpdgList.size(); i++) {
			LabProceduresGroup group = lpdgList.get(i);
			StringBuffer html = new StringBuffer("<option value=\"" + group.getId() + "\"");
			if (ToolsKit.EmptyCheckUtil.isNotEmpty(lpdglList)) {
				for (int j = 0; j < lpdglList.size(); j++) {
					if (lpdglList.get(j).getPracticesGroupId().equals(group.getId())) {
						html.append(" selected=\"selected\"");
					}
				}
			}
			html.append(">" + group.getName() + "</option>");
			Map<String, Object> optionMap = new HashMap<String, Object>();
			optionMap.put("option", html.toString());
			groupLink.add(optionMap);
		}

		map.put("pcList", pcList);
		map.put("pdcList", pdcList);
		map.put("pscList", pscList);
		map.put("ptList", ptList);
		map.put("groupLink", groupLink);
		
		return map;
	}
	
	
	/**
	 * 
	 * @Title: procedure 
	 * @Description: 设置页面-案例设置-工序-属性查询
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	public Object attributes(HttpServletRequest req)throws Exception{
		Integer proceduresId = getParameterAsInteger(req, "id");
		LabProcedureAttr attr = new LabProcedureAttr();
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(proceduresId)){
			attr.setProcedures_id(proceduresId);
			List<LabProcedureAttr> list = labProcedureAttrService.listAllByEqual(attr, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(list)){
				attr = list.get(0);
			}
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("attr", attr);
		result.put("Shade", baseCache.getProcedureAttrCache().getShadeValue());
		result.put("StumpShade", baseCache.getProcedureAttrCache().getStumpShadeValue());
		
		//查询materials
		result.put("AlloyMaterial", getCheckbox(attr.getAlloy_material_d_value(), baseCache.getProcedureAttrCache().getAlloyMaterialValue()));
		result.put("Coping", getCheckbox(attr.getCoping_d_value(), baseCache.getProcedureAttrCache().getCopingValue()));
		result.put("PonticContours", getCheckbox(attr.getPontic_contours_d_value(), baseCache.getProcedureAttrCache().getPonticContoursValue()));
		result.put("Margin", getCheckbox(attr.getMargin_d_value(), baseCache.getProcedureAttrCache().getMarginValue()));
		result.put("Rpd", getCheckbox(attr.getRpd_d_value(), baseCache.getProcedureAttrCache().getRpdValue()));
		result.put("ContactsEmbrasures", getCheckbox(attr.getContacts_embrasures_d_value(), baseCache.getProcedureAttrCache().getContactsEmbrasuresValue()));
		result.put("OcclusalContac", getCheckbox(attr.getOcclusal_contact_d_value(), baseCache.getProcedureAttrCache().getOcclusalContactValue()));
		result.put("InsufficientRoom", getCheckbox(attr.getInsufficient_room_d_value(), baseCache.getProcedureAttrCache().getInsufficientRoomValue()));
		result.put("Retention", getCheckbox(attr.getRetention_d_value(), baseCache.getProcedureAttrCache().getRetentionValue()));
		result.put("MarginPosition", getCheckbox(attr.getMargin_position_d_value(), baseCache.getProcedureAttrCache().getMarginPositionValue()));
		result.put("EmergenceWidth", getCheckbox(attr.getEmergence_width_d_value(), baseCache.getProcedureAttrCache().getEmergenceWidthValue()));
		result.put("Staining", getCheckbox(attr.getStaining_d_value(), baseCache.getProcedureAttrCache().getStainingValue()));
		result.put("StainPlacement", getCheckbox(attr.getStain_placement_d_value(), baseCache.getProcedureAttrCache().getStainPlacementValue()));
		result.put("SurfaceTexture", getCheckbox(attr.getSurface_texture_d_value(), baseCache.getProcedureAttrCache().getSurfaceTextureValue()));
		result.put("SurfaceFinish", getCheckbox(attr.getSurface_finish_d_value(), baseCache.getProcedureAttrCache().getSurfaceFinishValue()));
		result.put("TranslucencyShade", getCheckbox(attr.getTranslucency_shade_d_value(), baseCache.getProcedureAttrCache().getTranslucencyShadeValue()));
		result.put("TranslucencyVolume", getCheckbox(attr.getTranslucency_volume_d_value(), baseCache.getProcedureAttrCache().getTranslucencyVolumeValue()));
		
		result.put("id", getCheckbox(attr.getId_d_value(), baseCache.getProcedureAttrCache().getIdValue()));
		result.put("reinforcements", getCheckbox(attr.getReinforcements_d_value(), baseCache.getProcedureAttrCache().getReinforcementsValue()));
		result.put("tissueAcrylicShade", getCheckbox(attr.getTissueAcrylicShade_d_value(), baseCache.getProcedureAttrCache().getTissueAcrylicShadeValue()));
		result.put("sportsGuardColor", getCheckbox(attr.getSportsGuardColor_d_value(), baseCache.getProcedureAttrCache().getSportsGuardColorValue()));
		
		result.put("color", getCheckbox(attr.getColor_d_value(), baseCache.getProcedureAttrCache().getColorValue()));
		result.put("design", getCheckbox(attr.getDesign_d_value(), baseCache.getProcedureAttrCache().getDesignValue()));
		result.put("system", getCheckbox(attr.getSystem_d_value(), baseCache.getProcedureAttrCache().getSystemValue()));
		result.put("marker", getCheckbox(attr.getMarker_d_value(), baseCache.getProcedureAttrCache().getMarkerValue()));
		
		result.put("type", req.getParameter("type"));
		return result;
	}
	/**
	 * 
	 * @Title: procedure 
	 * @Description: 设置页面-案例设置-工序-属性查询（多选框拼装显示）
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	private String getCheckbox(String attr, List<Map<String, Object>> listMap) throws Exception {
		StringBuffer html = new StringBuffer();
		String[] attrs = null;
		try {
			attrs = attr.split(",");
		} catch (Exception e) {
		}
		for (int i = 0; i < listMap.size(); i++) {
			Map<String, Object> map = listMap.get(i);
			StringBuffer option = new StringBuffer("<option value=\"" + map.get(Constans.CACHE_NAME_KEY) + "\"");
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(attrs)){
				for (int j = 0; j < attrs.length; j++) {
					if (attrs[j].equals(ToolsKit.TypeConversionUtil.asString(map.get(Constans.CACHE_NAME_KEY)))) {
						option.append(" selected=\"selected\"");
					}
				}
			}
			option.append(">" + map.get(Constans.CACHE_NAME_VALUE) + "</option>");
			html.append(option);
		}
		return html.toString();
	}
	/**
	 * 
	 * @Title: procedure 
	 * @Description: 设置页面-案例设置-工序-外部链接查询
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	public Object externalLinks(HttpServletRequest req)throws Exception{
		Integer proceduresId = getParameterAsInteger(req, "id");
		LabProceduresOutLink link = null;
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(proceduresId)){
			LabProceduresOutLink query = new LabProceduresOutLink();
			query.setProceduresId(proceduresId);
			List<LabProceduresOutLink> list = labProceduresOutLinkService.listAllByEqual(query, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(list)){
				link = list.get(0);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Lab> listLab = getPartnerLabList();
		
		User user = getSessionUserByLoginEmail();
		String unitType = user.getUnitType();
		
		Integer requestLabId = null;
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(link)){
			requestLabId = link.getOutPartnerLabId();
		}else{
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(listLab)){
				requestLabId = listLab.get(0).getId();
			}
		}
		
		List<LabProcedure> listPro = null;
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(requestLabId)){
			listPro = labProcedureService.getRequestLabProcedures(user.getUnitId(), unitType , requestLabId);
		}
		
		Map<String, Object> type = baseCache.getSironaConnectCache().getSironaConnectType();
		Map<String, Object> design = baseCache.getSironaConnectCache().getSironaConnectDesign();
		Map<String, Object> material = baseCache.getSironaConnectCache().getSironaConnectMaterial();
		map.put("link", link);
		map.put("listLab", listLab);
		map.put("listPro", listPro);
		map.put("sironaConnectType", type);
		map.put("sironaConnectDesign", design);
		map.put("sironaConnectMaterial", material);
		map.put("type", req.getParameter("type"));
		return map;
	}
	/**
	 * 
	 * @Title: procedure 
	 * @Description: 设置页面-案例设置-工序-价格列表查询
	 * @author king 
	 * @date 2014-7-10下午12:42:18
	 * @return void
	 * @throws Exception 
	 */
	public Object pricing(HttpServletRequest req)throws Exception{
		Integer proceduresId = getParameterAsInteger(req, "id");
		List<LabProceduresPrice> lpList = null;
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(proceduresId)){
			LabProcedureAttr queryAttr = new LabProcedureAttr();
			queryAttr.setProcedures_id(proceduresId);
			List<LabProcedureAttr> labPro =  labProcedureAttrService.listAllByEqual(queryAttr, 0, 0);
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(labPro) && labPro.size()>1){
				throw new Exception("数据错误，相关联的工序属性出现非正常冗余数据！");
			}
			LabProceduresPrice price = new LabProceduresPrice();
			
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(proceduresId)){
				price.setProceduresId(proceduresId);
				lpList = labProceduresPriceService.listAllByEqual(price, 0, 0);
				LabPriceGroup group = new LabPriceGroup();
				group.setLabId(getSessionUserByLoginEmail().getLabId());
				List<LabPriceGroup>  groupList = labPriceGroupService.listAllByEqual(group, 0, 0);
				for (int i = 0; i < lpList.size(); i++) {
					StringBuffer asHtml = new StringBuffer();
					LabProceduresPrice.PriceAttributes pa = ToolsKit.jsonUitl.toBean(LabProceduresPrice.PriceAttributes.class, lpList.get(i).getAttributes());
					Method[] methods = pa.getClass().getMethods();
					for (int j = 0; j < methods.length; j++) {
						if(methods[j].getName().startsWith("get") && methods[j].getName().endsWith("presence")){
							Map map = (Map)methods[j].invoke(pa);
							//如果保存的值不为空，并且该属性在“DDX_LAB_PROCEDURES_ATTRIBUTES”表中设置不是“NOT_APPLICABLE”
							String presence = "";
							if(ToolsKit.EmptyCheckUtil.isNotEmpty(labPro)){
								presence = ToolsKit.TypeConversionUtil.asString(LabProcedureAttr.class.getMethod(methods[j].getName()).invoke(labPro.get(0)));
							}
							if(ToolsKit.EmptyCheckUtil.isNotEmpty(map) && ToolsKit.EmptyCheckUtil.isNotEmpty(presence) && !Constans.PRESENCE_NOT_APPLICABLE.equals(presence)){
								asHtml.append("<strong id=\""+methods[j].getName()+"\" value=\"");
								Iterator it = map.entrySet().iterator();
								
								String value = "";
								while(it.hasNext()){
									Map.Entry entry = (Map.Entry) it.next();
									String key = String.valueOf(entry.getKey());
									asHtml.append(key).append(",");
									List priceAttr = (List)ProcedurePriceAttrCache.class.getMethod(methods[j].getName()).invoke(baseCache.getProcedurePriceAttrCache());
									a:for (int k = 0; k < priceAttr.size(); k++) {
										Map kMap = (Map)priceAttr.get(k);
										if(kMap!=null && ToolsKit.TypeConversionUtil.asString(kMap.get(Constans.CACHE_NAME_KEY)).equals(key)){
											value += ToolsKit.TypeConversionUtil.asString(kMap.get(Constans.CACHE_NAME_VALUE))+";";
											break a;
										}
									}
								}
								Map noteMap = AbstractExcelService.parseComment(LabProcedureAttr.class.getMethod(methods[j].getName()), Note.class);
								asHtml.append("\">"+noteMap.get("name")+"</strong>："+value+"<br>");
							}
						}
					}
					lpList.get(i).setAttributes(asHtml.toString());
					
					g:for (int j = 0; j < groupList.size(); j++) {
						if(lpList.get(i).getPriceGroupId()!=null && lpList.get(i).getPriceGroupId().equals(groupList.get(j).getId())){
							lpList.get(i).setPriceGroupName(groupList.get(j).getName());
							break g;
						}
					}
				}
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("price", lpList);
		map.put("type", req.getParameter("type"));
		return map;
	}
	
	public Object CouponsView(HttpServletRequest req) throws Exception{
		Integer Id = getParameterAsInteger(req, "id");
		Integer pageNo=0;
		Integer pageSize = 0;
		LabCaseCoupons caseCoupons=new LabCaseCoupons();
		caseCoupons.setId(Id);
		List<LabCaseCoupons> datas=caseCouponsService.listAllByEqual(caseCoupons, pageNo, pageSize);
		LabCaseCoupons lcc=datas.get(0);
		String unittype=lcc.getUnittype();
		List<Lab> list=new ArrayList<Lab>();
		List<Practice> list2=new ArrayList<Practice>();
		Lab labdatas=new Lab();
		Practice practicedatas=new Practice();
		Integer unitid=lcc.getUnitid();
		if(unittype.equals(1)){
			labdatas.setId(unitid);
			list=labService.listAllByEqual(labdatas, pageNo, pageSize);
			labdatas=list.get(0);
		}else{
			practicedatas.setId(unitid);
			list2=practiceService.listAllByEqual(practicedatas, pageNo, pageSize);
			practicedatas=list2.get(0);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", datas);
		map.put("labdatas", labdatas);
		map.put("practicedatas", practicedatas);
		return map;
	}
	
	/**
	 * 
	 * @Title: bargainVerify 
	 * @Description: 议价审核列表
	 * @author ERIC 
	 * @date 2014-10-25下午03:26:47
	 * @return Object
	 */
	public Object bargainVerify(HttpServletRequest req) throws Exception{
		User user = getSessionUserByLoginEmail();
		CasesBargainRequest cbr = new CasesBargainRequest();
		String viewType = null;
		if("true".equals(user.getIsMain())){
			cbr.setVerifierId(user.getAccountId());
			viewType = "bargain_verify";
		}else{
			cbr.setApplicantId(user.getAccountId());
			viewType = "bargain_request";
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		//默认取第一页
		Integer pageNo = ToolsKit.TypeConversionUtil.asInteger(req.getParameter("offset"));
		//默认取第一页
		if(ToolsKit.EmptyCheckUtil.isEmpty(pageNo)){
			pageNo = 1;
		}
		//每页显示10条
		Integer pageSize = 10;
		List<CasesBargainRequest> datas = bargainRequestService.listAllByEqual(cbr, pageNo, pageSize);
		PageModel pm = getPageModel(datas, bargainRequestService.getCountByEqual(cbr), pageSize, pageNo);
		map.put("pm", pm);
		map.put("viewType", viewType);
		return map;
	}
	
}
