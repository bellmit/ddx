/**   
 * @Title: LabProcedureServiceImpl.java 
 * @Package com.upcera.ddx.service.lab.impl 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 下午04:31:12 
 * @version V1.0   
 */
package com.upcera.ddx.service.lab.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upcera.ddx.common.cache.impl.BaseCache;
import com.upcera.ddx.common.cache.impl.ProcedureAttrCache;
import com.upcera.ddx.common.excel.AbstractExcelService;
import com.upcera.ddx.common.target.Note;
import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.dao.lab.impl.LabProcedureDaoImpl;
import com.upcera.ddx.entity.Cases;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.entity.LabProcedureAttr;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.entity.LabProceduresGroup;
import com.upcera.ddx.entity.LabProceduresGroupLink;
import com.upcera.ddx.entity.ProcedureDisplayCategory;
import com.upcera.ddx.service.base.impl.BaseServiceImpl;
import com.upcera.ddx.service.lab.ILabProcedureAttrService;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabProceduresGroupLinkService;
import com.upcera.ddx.service.lab.ILabProceduresGroupService;
import com.upcera.ddx.service.lab.ILabProceduresOutLinkService;
import com.upcera.ddx.service.lab.ILabProceduresPriceService;
import com.upcera.ddx.service.lab.IProcedureDisplayCategoryService;
import com.upcera.ddx.service.user.IUserService;

/**
 * @ClassName: LabProcedureServiceImpl
 * @Description: 技工间工序Service实现类
 * @author ERIC
 * @date 2014-6-17 下午04:31:12
 * 
 */
@Service
public class LabProcedureServiceImpl extends BaseServiceImpl<LabProcedure, Integer> implements ILabProcedureService {
	@Autowired
	private BaseCache baseCache;
	@Autowired
	private IUserService userService;
	@Resource
	LabProcedureDaoImpl labProcedureDao;
	@Autowired
	private ILabProceduresGroupService groupServer;
	@Autowired
	private ILabProceduresGroupLinkService groupLinkService;
	@Autowired
	private IProcedureDisplayCategoryService procedureDisplayCategoryService;
	
	@Autowired
	private ILabProceduresPriceService labProceduresPriceService;
	@Autowired
	private ILabProcedureAttrService labProcedureAttrService;
	@Autowired
	private ILabProceduresOutLinkService labProceduresOutLinkService;
	
	
	@Override
	public IBaseDao<LabProcedure, Integer> getDao() {
		return labProcedureDao;
	}
	@Override
	public List<LabProcedure> getProedureByCriteria(LabProcedure lp) {
		return labProcedureDao.getProedureByCriteria(lp);
	}
	@Override
	public void addProedure(LabProcedure labProcedure, String  linkGroup,String newGroup,String newCategory) throws Exception{
		// TODO Auto-generated method stub
		//新增显示类别
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(newCategory)){
			ProcedureDisplayCategory ca = new ProcedureDisplayCategory();
			ca.setName(newCategory);
			ca.setLabId(labProcedure.getLabId());
			procedureDisplayCategoryService.add(ca);
			labProcedure.setCategoryId(ca.getId());
		}
		//新增工序
		labProcedureDao.add(labProcedure);
		
		List<LabProceduresGroupLink> linkList = new ArrayList<LabProceduresGroupLink>();
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(linkGroup)){
			String[] array = linkGroup.split(",");
			for (int i = 0; i < array.length; i++) {
				Integer id = ToolsKit.TypeConversionUtil.asInteger(array[i]);
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(id)){
					LabProceduresGroupLink link = new LabProceduresGroupLink();
					link.setProceduresId(labProcedure.getProceduresId());
					link.setPracticesGroupId(id);
					linkList.add(link);
				}
			}
		}
		
		//新增工序组
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(newGroup)){
			LabProceduresGroup groups = new LabProceduresGroup();
			groups.setLabId(labProcedure.getLabId());
			groups.setName(newGroup);
			groupServer.add(groups);
			LabProceduresGroupLink l = new LabProceduresGroupLink();
			l.setPracticesGroupId(groups.getId());
			l.setProceduresId(labProcedure.getProceduresId());
			linkList.add(l);
		}
		//工序组关联
		groupLinkService.batchAdd(linkList);
	}
	@Override
	public void updateProedure(LabProcedure labProcedure,String  linkGroup,String newGroup,String newCategory) throws Exception {
		// TODO Auto-generated method stub
		//新增显示类别
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(newCategory)){
			ProcedureDisplayCategory ca = new ProcedureDisplayCategory();
			ca.setName(newCategory);
			ca.setLabId(labProcedure.getLabId());
			procedureDisplayCategoryService.add(ca);
			labProcedure.setCategoryId(ca.getId());
		}
		//修改工序
		labProcedureDao.update(labProcedure);
		
		List<LabProceduresGroupLink> linkList = new ArrayList<LabProceduresGroupLink>();
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(linkGroup)){
			String[] array = linkGroup.split(",");
			for (int i = 0; i < array.length; i++) {
				Integer id = ToolsKit.TypeConversionUtil.asInteger(array[i]);
				if(ToolsKit.EmptyCheckUtil.isNotEmpty(id)){
					LabProceduresGroupLink link = new LabProceduresGroupLink();
					link.setProceduresId(labProcedure.getProceduresId());
					link.setPracticesGroupId(id);
					linkList.add(link);
				}
		}
		}
		//新增工序组
		if(ToolsKit.EmptyCheckUtil.isNotEmpty(newGroup)){
			LabProceduresGroup groups = new LabProceduresGroup();
			groups.setLabId(labProcedure.getLabId());
			groups.setName(newGroup);
			groupServer.add(groups);
			LabProceduresGroupLink l = new LabProceduresGroupLink();
			l.setProceduresId(labProcedure.getProceduresId());
			l.setPracticesGroupId(groups.getId());
			linkList.add(l);
		}
		//工序组关联
		groupLinkService.updateGroupLink(labProcedure.getProceduresId(), linkList);
	}
	
	/**
	 * 
	 * @Description: 加载合作技工间的工序，进行分类，返回拼装好的html代码。（只有合作技工间的工序所在的组别和本机构所在的组别相同时，或工序所在的组别为空时，才能被加载）
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param requestLabId 查询对象的机构间ID
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getProedureAsHtml(Integer requestLabId) throws Exception {
		// TODO Auto-generated method stub
		String unitType = userService.getSessionUserByLoginEmail().getUnitType();
		Integer unitId = null;
		if(Constans.UNIT_LAB.equals(unitType)){
			unitId = userService.getSessionUserByLoginEmail().getLabId();
		}else if(Constans.UNIT_PRACTICE.equals(unitType)){
			unitId = userService.getSessionUserByLoginEmail().getPracticeId();
		}
		List<LabProcedure> data = this.getRequestLabProcedures(unitId,unitType, requestLabId);
		
		Map<String, Object> cMap = new HashMap<String, Object>();
		Map<String, Object> dMap = new HashMap<String, Object>();
		ProcedureDisplayCategory pd = new ProcedureDisplayCategory();
		pd.setLabId(requestLabId);
		List<ProcedureDisplayCategory> cList = procedureDisplayCategoryService.listAllByEqual(pd, 0, 0);
		for (int i = 0; i < data.size(); i++) {
			String cName = "未指定类别";
			Integer cid = data.get(i).getCategoryId();
			for (int j = 0; j < cList.size(); j++) {
				if (cList.get(j).getId().equals(cid)) {
					cName = cList.get(j).getName();
					break;
				}
			}
			if (cMap.get(cName) != null) {
				List li = (List) dMap.get(cName);
				if (li == null) {
					li = new ArrayList();
					dMap.put(cName, li);
				}
				li.add("<option value=\"" + data.get(i).getProceduresId() + "\">" + data.get(i).getDisplayName() + "</option>");
			} else {
				cMap.put(cName, cName);
				List li = new ArrayList();
				li.add("<option value=\"" + data.get(i).getProceduresId() + "\">" + data.get(i).getDisplayName() + "</option>");
				dMap.put(cName, li);
			}
		}
		List<String> proList = new ArrayList<String>();
		Iterator it = cMap.entrySet().iterator();
		while (it.hasNext()) {
			StringBuffer html = new StringBuffer();
			Map.Entry entry = (Map.Entry) it.next();
			String key = String.valueOf(entry.getKey());
			html.append("<optgroup label=\"" + key + "\">");
			List li = (List) dMap.get(key);
			for (int i = 0; i < li.size(); i++) {
				html.append(li.get(i));
			}
			html.append("</optgroup>");
			proList.add(html.toString());
		}
		return proList;
	}
	
	@Override
	public Integer queryMaxTurnAroudDays(List<Integer> procedureIdList) {
		// TODO Auto-generated method stub
		return labProcedureDao.queryMaxTurnAroudDays(procedureIdList);
	}
	/**
	 * 
	 * @Description: 加载合作技工间的工序,（只有合作技工间的工序所在的组别和本机构所在的组别相同时才能被加载）
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param thisLabId 当前登录用户机构id
	 * @param thisUnitType 当前登录用户机构类型
	 * @param requestLabId 查询对象的机构间ID
	 * @return List
	 */
	@Override
	public List<LabProcedure> getRequestLabProcedures(Integer thisLabId,String thisUnitType,  Integer requestLabId) throws Exception{
		// TODO Auto-generated method stub
		return labProcedureDao.getRequestLabProcedures(thisLabId,thisUnitType, requestLabId);
	}
	
	
	/**
	 * 
	 * @Description: 解析订单工序详细信息
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return List
	 */
	public List<Map<String, Object>> getProceduresDetailed(Cases cases) throws Exception {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		if(ToolsKit.EmptyCheckUtil.isEmpty(cases.getProcedures())){
			return resultList;
		}
		Map[] map = ToolsKit.jsonUitl.toBean(Map[].class, cases.getProcedures());
		for (int i = 0; i < map.length; i++) {
			Map<String, Object> resMap = new HashMap<String, Object>();
			Map proMap = (Map) map[i].get("procedure");
			String id = String.valueOf(map[i].get("procedure_id"));
			Cases.Procedures procedures = ToolsKit.jsonUitl.toBean(Cases.Procedures.class, ToolsKit.jsonUitl.toJson(proMap));
			Method[] method = Cases.Procedures.class.getMethods();
				
			String te = "";
			List<Map<String, Object>> attrList = new ArrayList<Map<String, Object>>();
			for (int j = 0; j < method.length; j++) {
				Map<String, Object> m = new HashMap<String, Object>();
				String methodName = method[j].getName();
				if (methodName.startsWith("get") && methodName.endsWith("presence")) {
					Map<String, Object> comment = AbstractExcelService.parseComment(LabProcedureAttr.class.getMethod(methodName),Note.class);
					String lable = ToolsKit.TypeConversionUtil.asString(comment.get("name"));
					String val = "";
					try {
						val = ToolsKit.TypeConversionUtil.asString(method[j].invoke(procedures));
					} catch (Exception e) {
						//忽略
						//e.printStackTrace();
					}
					if (ToolsKit.EmptyCheckUtil.isEmpty(val)) {
						continue;
					}
					if("getTeeth_presence".equals(methodName)){
						te = val;
					}
					String getValueDesMethod = ToolsKit.TypeConversionUtil.asString(AbstractExcelService.parseComment(method[j], Note.class).get("getValueDescriptionMethod"));
					String valueLoadChannel = ToolsKit.TypeConversionUtil.asString(AbstractExcelService.parseComment(method[j], Note.class).get("valueLoadChannel"));
					boolean isSplitArray = ToolsKit.TypeConversionUtil.asBoolean(AbstractExcelService.parseComment(method[j], Note.class).get("isSplitArray"));
					String desc = "";
					if ("db".equals(valueLoadChannel)) {
						//LabProceduresCharacteris lc = labProceduresCharacterisService.get(ToolsKit.TypeConversionUtil.asInteger(val));
						LabProceduresCharacteris lc = baseCache.getListLabProCharacterisCache().get(val);
						if(null!=lc){
							desc = lc.getCharacterName();
						}
					} else if (ToolsKit.EmptyCheckUtil.isNotEmpty(getValueDesMethod)) {
						List<Map<String, Object>> vdList = (List) ProcedureAttrCache.class.getMethod(getValueDesMethod).invoke(baseCache.getProcedureAttrCache());
						if (isSplitArray) {
							// 牙位染色
							String[] array1 = val.split(";");
							for (int l = 0; l < array1.length; l++) {
								String[] array2 = array1[l].split(" ");
								String shade = "";
								String teeth = "";
								String regions = "";
								if (ToolsKit.EmptyCheckUtil.isNotEmpty(array2) && array2.length == 1) {
									shade = array2[0];
								} else if (ToolsKit.EmptyCheckUtil.isNotEmpty(array2) && array2.length == 2) {
									shade = array2[0];
									teeth = array2[1];
								} else if (ToolsKit.EmptyCheckUtil.isNotEmpty(array2) && array2.length == 3) {
									shade = array2[0];
									teeth = array2[1];
									if (ToolsKit.EmptyCheckUtil.isNotEmpty(array2[2])) {
										regions = "指定区域:&nbsp;" + array2[2] + ";";
									}
								}
								l: for (int k = 0; k < vdList.size(); k++) {
									if (vdList.get(k).get(Constans.CACHE_NAME_KEY).equals(shade)) {
										String d = ToolsKit.TypeConversionUtil.asString(vdList.get(k).get(Constans.CACHE_NAME_VALUE));
										String teethStr = "";
										if (ToolsKit.EmptyCheckUtil.isNotEmpty(teeth)) {
											teethStr = "牙位:&nbsp;&nbsp;" + teeth + ",&nbsp;&nbsp;";
										}
										desc += teethStr + lable + ":&nbsp;&nbsp;" + d + ";&nbsp;" + regions + "<br/>";
										break l;
									}
								}
							}
						} else {
							for (int k = 0; k < vdList.size(); k++) {
								if (vdList.get(k).get(Constans.CACHE_NAME_KEY).equals(val)) {
									desc = ToolsKit.TypeConversionUtil.asString(vdList.get(k).get(Constans.CACHE_NAME_VALUE));
									break;
								}
							}

						}
					} else {
						desc = val;
					}
					String valueDes = desc;
					m.put("val", val);
					m.put("lable", lable);
					m.put("id", methodName);
					m.put("valueDes", valueDes);
					attrList.add(m);
				}
			}
			
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(ToolsKit.TypeConversionUtil.asInteger(id)) && ToolsKit.TypeConversionUtil.asInteger(id)>0){
				resMap.put("procedure_name", map[i].get("procedure_name"));
				resMap.put("procedure_id", id);
				resMap.put("isTryIn", map[i].get("isTryIn"));
				resMap.put("index", map[i].get("index"));
				
				String ps = "";
				Integer count = 0;
				//统计计数
				//LabProcedure lp = this.get(ToolsKit.TypeConversionUtil.asInteger(id));
				LabProcedure lp = baseCache.getListLabProceduresCache().get(""+id);
				if(lp!=null && Constans.COUNT_UNIT_TEETH.equals(lp.getDisplayUnitCount())){
					//按牙齿计数
					ps = "按牙齿计数";
					count = te.split(",").length;
				}else if(lp!=null && Constans.COUNT_UNIT_ARCH.equals(lp.getDisplayUnitCount())){
					ps = "按拱门计数";
					boolean[] arch = new boolean[]{false,false,false,false};
					//按拱门计数
					//获取牙位标记方式
					String notation = cases.getTeethNotation();
					if(ToolsKit.EmptyCheckUtil.isEmpty(notation)){
						//默认FDI
						notation = Constans.TEETH_NOTATION_FDI;
					}
					if(Constans.TEETH_NOTATION_FDI.equals(notation)){
						ps += "，FDI牙位标记法";
					}else if(Constans.TEETH_NOTATION_UNIVERSAL.equals(notation)){
						ps += "，普通牙位标记法";
					}
					String[] teeths = te.split(",");
					for (int j = 0; j < teeths.length; j++) {
						Integer t = ToolsKit.TypeConversionUtil.asInteger(teeths[j]);
						if(ToolsKit.EmptyCheckUtil.isEmpty(t)){
							continue;
						}
						if(Constans.TEETH_NOTATION_FDI.equals(notation)){
							if(t>=11 && t<=18){
								arch[0] = true;
							}else if(t>=21 && t<=28){
								arch[1] = true;
							}else if(t>=41 && t<=48){
								arch[2] = true;
							}else if(t>=31 && t<=38){
								arch[3] = true;
							}
						}else if(Constans.TEETH_NOTATION_UNIVERSAL.equals(notation)){
							if(t>=1 && t<=8){
								arch[0] = true;
							}else if(t>=9 && t<=16){
								arch[1] = true;
							}else if(t>=17 && t<=24){
								arch[2] = true;
							}else if(t>=25 && t<=32){
								arch[3] = true;
							}
						}
					}
					for (int j = 0; j < arch.length; j++) {
						if(arch[j]){
							count++;
						}
					}
					
				}
				resMap.put("count", count);
				resMap.put("ps", ps);
				resMap.put("attrList", attrList);
				resultList.add(resMap);
			}
		}
		return resultList;
	}
	
	/**
	 * 
	 * @Description: 设置订单工序详细信息
	 * @author king 
	 * @date 2014-6-11下午02:13:59
	 * @param @return
	 * @return List
	 */
	@Override
	public void setProceduresDetailed(Cases cases, String proceduresStr) throws Exception {
		// TODO Auto-generated method stub

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map[] proceduresMap = ToolsKit.jsonUitl.toBean(Map[].class, proceduresStr);
		for (int i = 0; i < proceduresMap.length; i++) {
			if (ToolsKit.EmptyCheckUtil.isEmpty(proceduresMap[i])) {
				continue;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			String procedure_id = ToolsKit.TypeConversionUtil.asString(proceduresMap[i].get("procedure_id"));
			String procedure_name = ToolsKit.TypeConversionUtil.asString(proceduresMap[i].get("procedure_name"));
			String isTryIn = ToolsKit.TypeConversionUtil.asString(proceduresMap[i].get("isTryIn"));
			List<Map<String, Object>> select1 = (List<Map<String, Object>>) proceduresMap[i].get("select1");
			List<Map<String, Object>> select2 = (List<Map<String, Object>>) proceduresMap[i].get("select2");
			List<Map<String, Object>> input1 = (List<Map<String, Object>>) proceduresMap[i].get("input1");
			List<Map<String, Object>> input2 = (List<Map<String, Object>>) proceduresMap[i].get("input2");

			Cases.Procedures pro = new Cases.Procedures();
			for (int j = 0; j < select1.size(); j++) {
				String method = ToolsKit.TypeConversionUtil.asString(select1.get(j).get("id"));
				String value = ToolsKit.TypeConversionUtil.asString(select1.get(j).get("val"));
				Map comment = AbstractExcelService.parseComment(Cases.Procedures.class.getMethod(method), Note.class);
				String setMethod = ToolsKit.TypeConversionUtil.asString(comment.get("name"));
				Cases.Procedures.class.getMethod(setMethod, String.class).invoke(pro, value);

			}
			for (int j = 0; j < select2.size(); j++) {
				String method = ToolsKit.TypeConversionUtil.asString(select2.get(j).get("id"));
				String value = ToolsKit.TypeConversionUtil.asString(select2.get(j).get("val"));
				Map comment = AbstractExcelService.parseComment(Cases.Procedures.class.getMethod(method), Note.class);
				String setMethod = ToolsKit.TypeConversionUtil.asString(comment.get("name"));
				Cases.Procedures.class.getMethod(setMethod, String.class).invoke(pro, value);
			}
			for (int j = 0; j < input1.size(); j++) {
				String method = ToolsKit.TypeConversionUtil.asString(input1.get(j).get("id"));
				//String value = ToolsKit.TypeConversionUtil.asString(input1.get(j).get("key"));
				String value = ToolsKit.TypeConversionUtil.asString(input1.get(j).get("val"));
				Map comment = AbstractExcelService.parseComment(Cases.Procedures.class.getMethod(method), Note.class);
				String setMethod = ToolsKit.TypeConversionUtil.asString(comment.get("name"));
				Cases.Procedures.class.getMethod(setMethod, String.class).invoke(pro, value);
			}
			for (int j = 0; j < input2.size(); j++) {
				String method = ToolsKit.TypeConversionUtil.asString(input2.get(j).get("id"));
				//String value = ToolsKit.TypeConversionUtil.asString(input2.get(j).get("key"));
				String value = ToolsKit.TypeConversionUtil.asString(input2.get(j).get("val"));
				Map comment = AbstractExcelService.parseComment(Cases.Procedures.class.getMethod(method), Note.class);
				String setMethod = ToolsKit.TypeConversionUtil.asString(comment.get("name"));
				Cases.Procedures.class.getMethod(setMethod, String.class).invoke(pro, value);
			}
			map.put("index", ToolsKit.DateUtil.ssss()+i);
			map.put("procedure_id", procedure_id);
			map.put("procedure_name", procedure_name);
			map.put("procedure", pro);
			map.put("isTryIn", isTryIn);
			list.add(map);
		}
		cases.setProcedures(ToolsKit.jsonUitl.toJson(list));
		//设置订单的牙位标记法
		cases.setTeethNotation(userService.getSessionUserByLoginEmail().getTeethNotation());
	}
	@Override
	public void deleteProcedures(Integer id) throws Exception {
		// TODO Auto-generated method stub
		this.delete(id);
		labProceduresPriceService.deletePriceByProceduresId(id);
		labProcedureAttrService.deleteAttrByProceduresId(id);
		labProceduresOutLinkService.deleteOutLinkByProceduresId(id);
	}

}
