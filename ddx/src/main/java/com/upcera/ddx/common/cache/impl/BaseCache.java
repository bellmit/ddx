package com.upcera.ddx.common.cache.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.common.cache.AbstractCache;
import com.upcera.ddx.entity.LabProcedure;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.service.lab.ILabProcedureService;
import com.upcera.ddx.service.lab.ILabProceduresCharacterisService;
import com.upcera.ddx.service.lab.impl.LabProcedureServiceImpl;
import com.upcera.ddx.service.lab.impl.LabProceduresCharacterisServiceImpl;
@Controller
public class BaseCache extends AbstractCache{
	@Autowired
	private ILabProcedureService procedureService;
	@Autowired
	private ILabProceduresCharacterisService labProceduresCharacterisService;
	
	
	@Autowired
	private SironaConnectCache sironaConnectCache;
	@Autowired
	private ProcedureAttrCache procedureAttrCache;
	@Autowired
	private ProcedureCache procedureTypeCache;
	@Autowired
	private ProcedurePriceAttrCache procedurePriceAttrCache;
	
	private Map<String, String> message_CN_Map;
	private Map<String, String> modelAndViewMappingMap;
	private String httpConfig;
	private static Map<String, LabProceduresCharacteris> listLabProCharacterisCache = new HashMap<String, LabProceduresCharacteris>();
	private static Map<String, LabProcedure> listLabProcedureCache = new HashMap<String, LabProcedure>();
	private Map<String, String> apiUrl;
	
	public String getHttpConfig() {
		return httpConfig;
	}
	public void setHttpConfig(String httpConfig) {
		this.httpConfig = httpConfig;
	}
	public void setModelAndViewMappingMap(Map<String, String> modelAndViewMappingMap) {
		this.modelAndViewMappingMap = modelAndViewMappingMap;
	}
	public void setMessage_CN_Map(Map<String, String> messageCNMap) {
		message_CN_Map = messageCNMap;
	}
	public Map<String, String> getMessage_CN_Map() {
		return message_CN_Map;
	}
	public Map<String, String> getModelAndViewMappingMap() {
		return modelAndViewMappingMap;
	}
	public SironaConnectCache getSironaConnectCache() {
		return sironaConnectCache;
	}
	public ProcedureAttrCache getProcedureAttrCache() {
		return procedureAttrCache;
	}
	public ProcedureCache getProcedureTypeCache() {
		return procedureTypeCache;
	}
	public ProcedurePriceAttrCache getProcedurePriceAttrCache() {
		return procedurePriceAttrCache;
	}
	public Map<String, LabProceduresCharacteris> getListLabProCharacterisCache() {
		try {
			return load(listLabProCharacterisCache);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<String, LabProceduresCharacteris>();
	}
	public Map<String, LabProcedure> getListLabProceduresCache() {
		try {
			return load(listLabProcedureCache);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<String, LabProcedure>();
	}
	public Map<String, String> getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(Map<String, String> apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		initlistLabProCharacteris();
		initlistLabProcedure();
	}
	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		listLabProcedureCache.clear();
		listLabProCharacterisCache.clear();
	}
	
	
	public void initlistLabProCharacteris(){
		try {
			
			List<LabProceduresCharacteris> pcList = labProceduresCharacterisService.listAll();
			for (int i = 0; i < pcList.size(); i++) {
				listLabProCharacterisCache.put(""+pcList.get(i).getId(), pcList.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void initlistLabProcedure(){
		try {
			
			List<LabProcedure> pcList = procedureService.listAll();
			for (int i = 0; i < pcList.size(); i++) {
				listLabProcedureCache.put(""+pcList.get(i).getProceduresId(), pcList.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshCacheByAOP(JoinPoint j){
		String className = j.getTarget().getClass().getName();
		if(className.equals(LabProceduresCharacterisServiceImpl.class.getName())){
			listLabProCharacterisCache.clear();
		}else if(className.equals(LabProcedureServiceImpl.class.getName())){
			listLabProcedureCache.clear();
		}
	}
}
