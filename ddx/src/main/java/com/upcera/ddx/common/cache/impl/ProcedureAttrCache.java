package com.upcera.ddx.common.cache.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.entity.LabProceduresCharacteris;
import com.upcera.ddx.service.lab.ILabProceduresCharacterisService;
import com.upcera.ddx.service.user.IUserService;


/***
 * 
 * 工序的属性对应的默认可选值
 * @author Administrator
 *
 */
@Controller
public class ProcedureAttrCache {
	@Autowired
	private IUserService userService;
	@Autowired
	private ILabProceduresCharacterisService labProceduresCharacterisService;
	
	private Map<String, Object> shadeValue;
	private Map<String, Object> stumpShadeValue;
	private Map<String, Object> alloyMaterialValue;//加载【材料】
	private Map<String, Object> copingValue;
	private Map<String, Object> ponticContoursValue;
	private Map<String, Object> marginValue;
	private Map<String, Object> rpdValue;
	private Map<String, Object> contactsEmbrasuresValue;
	private Map<String, Object> occlusalContactValue;
	private Map<String, Object> insufficientRoomValue;
	private Map<String, Object> retentionValue;
	private Map<String, Object> marginPositionValue;
	
	private Map<String, Object> emergenceWidthValue;
	private Map<String, Object> stainingValue;
	private Map<String, Object> stainPlacementValue;
	private Map<String, Object> surfaceTextureValue;
	private Map<String, Object> surfaceFinishValue;
	private Map<String, Object> translucencyShadeValue;
	private Map<String, Object> translucencyVolumeValue;
	
	//add by king. 2014-09-19
	private Map<String, Object> idValue;
	private Map<String, Object> reinforcementsValue;
	private Map<String, Object> tissueAcrylicShadeValue;//加载【亚克力色】
	private Map<String, Object> sportsGuardColorValue;//加载【运动防护色】
	
	private Map<String, Object> colorValue;//加载【正畸色】
	private Map<String, Object> designValue;//加载【正畸设计】
	private Map<String, Object> systemValue;//加载【种植系统】
	private Map<String, Object> markerValue;//加载【种植制作】
	
	
	
	public List<Map<String, Object>> getIdValue() {
		return map2list(idValue);
	}
	public void setIdValue(Map<String, Object> idValue) {
		this.idValue = idValue;
	}
	public List<Map<String, Object>> getReinforcementsValue() {
		return map2list(reinforcementsValue);
	}
	public void setReinforcementsValue(Map<String, Object> reinforcementsValue) {
		this.reinforcementsValue = reinforcementsValue;
	}
	public List<Map<String, Object>> getTissueAcrylicShadeValue() {
		return getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_ACRYLICCOLORS);
	}
	public void setTissueAcrylicShadeValue(Map<String, Object> tissueAcrylicShadeValue) {
		this.tissueAcrylicShadeValue = tissueAcrylicShadeValue;
	}
	public List<Map<String, Object>> getSportsGuardColorValue() {
		return getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_SPORTGUARDCOLORS);
	}
	public void setSportsGuardColorValue(Map<String, Object> sportsGuardColorValue) {
		this.sportsGuardColorValue = sportsGuardColorValue;
	}
	public List<Map<String, Object>> getColorValue() {
		return getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICCOLORS);
	}
	public void setColorValue(Map<String, Object> colorValue) {
		this.colorValue = colorValue;
	}
	public List<Map<String, Object>> getDesignValue() {
		return getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICDESIGNS);
	
	}
	public void setDesignValue(Map<String, Object> designValue) {
		this.designValue = designValue;
	}
	public List<Map<String, Object>> getSystemValue() {
		return getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_IMPLANTSYSTEMS);
	}
	public void setSystemValue(Map<String, Object> systemValue) {
		this.systemValue = systemValue;
	}
	public List<Map<String, Object>> getMarkerValue() {
		return getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_IMPLANTMARKERS);
	}
	public void setMarkerValue(Map<String, Object> markerValue) {
		this.markerValue = markerValue;
	}
	

	public List<Map<String, Object>> getShadeValue() {
		return map2list(shadeValue);
	}
	public void setShadeValue(Map<String, Object> shadeValue) {
		this.shadeValue = shadeValue;
	}
	public List<Map<String, Object>> getStumpShadeValue() {
		return map2list(stumpShadeValue);
	}
	public void setStumpShadeValue(Map<String, Object> stumpShadeValue) {
		this.stumpShadeValue = stumpShadeValue;
	}
	public List<Map<String, Object>> getAlloyMaterialValue() {
		return getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_MATERIALS);
	}
	public void setAlloyMaterialValue(Map<String, Object> alloyMaterialValue) {
		this.alloyMaterialValue = alloyMaterialValue;
	}
	public List<Map<String, Object>> getCopingValue() {
		return map2list(copingValue);
	}
	public void setCopingValue(Map<String, Object> copingValue) {
		this.copingValue = copingValue;
	}
	public List<Map<String, Object>> getPonticContoursValue() {
		return map2list(ponticContoursValue);
	}
	public void setPonticContoursValue(Map<String, Object> ponticContoursValue) {
		this.ponticContoursValue = ponticContoursValue;
	}
	public List<Map<String, Object>> getMarginValue() {
		return map2list(marginValue);
	}
	public void setMarginValue(Map<String, Object> marginValue) {
		this.marginValue = marginValue;
	}
	public List<Map<String, Object>> getRpdValue() {
		return map2list(rpdValue);
	}
	public void setRpdValue(Map<String, Object> prdValue) {
		this.rpdValue = prdValue;
	}
	public List<Map<String, Object>> getContactsEmbrasuresValue() {
		return map2list(contactsEmbrasuresValue);
	}
	public void setContactsEmbrasuresValue(Map<String, Object> contactsEmbrasuresValue) {
		this.contactsEmbrasuresValue = contactsEmbrasuresValue;
	}
	public List<Map<String, Object>> getOcclusalContactValue() {
		return map2list(occlusalContactValue);
	}
	public void setOcclusalContactValue(Map<String, Object> occlusalContactValue) {
		this.occlusalContactValue = occlusalContactValue;
	}
	public List<Map<String, Object>> getInsufficientRoomValue() {
		return map2list(insufficientRoomValue);
	}
	public void setInsufficientRoomValue(Map<String, Object> insufficientRoomValue) {
		this.insufficientRoomValue = insufficientRoomValue;
	}
	public List<Map<String, Object>> getRetentionValue() {
		return map2list(retentionValue);
	}
	public void setRetentionValue(Map<String, Object> retentionValue) {
		this.retentionValue = retentionValue;
	}
	public List<Map<String, Object>> getMarginPositionValue() {
		return map2list(marginPositionValue);
	}
	public void setMarginPositionValue(Map<String, Object> marginPositionValue) {
		this.marginPositionValue = marginPositionValue;
	}
	public List<Map<String, Object>> getEmergenceWidthValue() {
		return map2list(emergenceWidthValue);
	}
	public void setEmergenceWidthValue(Map<String, Object> emergenceWidthValue) {
		this.emergenceWidthValue = emergenceWidthValue;
	}
	public List<Map<String, Object>> getStainingValue() {
		return map2list(stainingValue);
	}
	public void setStainingValue(Map<String, Object> stainingValue) {
		this.stainingValue = stainingValue;
	}
	public List<Map<String, Object>> getStainPlacementValue() {
		return map2list(stainPlacementValue);
	}
	public void setStainPlacementValue(Map<String, Object> stainPlacementValue) {
		this.stainPlacementValue = stainPlacementValue;
	}
	public List<Map<String, Object>> getSurfaceTextureValue() {
		return map2list(surfaceTextureValue);
	}
	public void setSurfaceTextureValue(Map<String, Object> surfaceTextureValue) {
		this.surfaceTextureValue = surfaceTextureValue;
	}
	public List<Map<String, Object>> getSurfaceFinishValue() {
		return map2list(surfaceFinishValue);
	}
	public void setSurfaceFinishValue(Map<String, Object> surfaceFinishValue) {
		this.surfaceFinishValue = surfaceFinishValue;
	}
	public List<Map<String, Object>> getTranslucencyShadeValue() {
		return map2list(translucencyShadeValue);
	}
	public void setTranslucencyShadeValue(Map<String, Object> translucencyShadeValue) {
		this.translucencyShadeValue = translucencyShadeValue;
	}
	public List<Map<String, Object>> getTranslucencyVolumeValue() {
		return map2list(translucencyVolumeValue);
	}
	public void setTranslucencyVolumeValue(Map<String, Object> translucencyVolumeValue) {
		this.translucencyVolumeValue = translucencyVolumeValue;
	}
	
	@SuppressWarnings({ "unchecked" })
	private List<Map<String, Object>> map2list(Map<String, Object> map){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			if(ToolsKit.EmptyCheckUtil.isNotEmpty(map)){
				Iterator it = map.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry entry = (Map.Entry) it.next();
					Map<String, Object> imap = new HashMap<String, Object>();
					imap.put(Constans.CACHE_NAME_KEY, entry.getKey());
					imap.put(Constans.CACHE_NAME_VALUE, entry.getValue());
					list.add(imap);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//加载工序特征
	public  List<Map<String, Object>> getLabProceduresCharacteris(String type) {
		try {
			LabProceduresCharacteris ldc = new LabProceduresCharacteris();
			ldc.setType(type);
			ldc.setLabId(userService.getSessionUserByLoginEmail().getLabId());
			List<Map<String, Object>> listLpcMap = new ArrayList<Map<String,Object>>();
			List<LabProceduresCharacteris> listLpc = labProceduresCharacterisService.listAllByEqual(ldc, 0, 0);
			for (int i = 0; i < listLpc.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put(Constans.CACHE_NAME_KEY, listLpc.get(i).getId());
				map.put(Constans.CACHE_NAME_VALUE, listLpc.get(i).getCharacterName());
				listLpcMap.add(map);
			}
			return listLpcMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Map<String,Object>>();
	
	}
}
