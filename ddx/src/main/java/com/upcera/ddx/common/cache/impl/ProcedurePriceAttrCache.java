package com.upcera.ddx.common.cache.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.upcera.ddx.constans.Constans;
import com.upcera.ddx.pojo.PriceAttr;

@Controller
public class ProcedurePriceAttrCache extends PriceAttr{
	
	@Autowired
	private ProcedureAttrCache procedureAttrCache;

	@SuppressWarnings( { "unchecked" })
	private List<Map<String, Object>> map2list(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Map<String, Object> imap = new HashMap<String, Object>();
			imap.put(Constans.CACHE_NAME_KEY, entry.getKey());
			imap.put(Constans.CACHE_NAME_VALUE, entry.getValue());
			list.add(imap);
		}
		return list;
	}
	/***
	 * 固定义齿修复类属性
	 */
	public List<Map<String, Object>> getTeeth_presence() {
		return map2list(teeth);
	}
	//加载【材料】
	public List<Map<String, Object>> getAlloy_material_presence() {
		return procedureAttrCache.getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_MATERIALS);
	}

	public List<Map<String, Object>> getCoping_presence() {
		return map2list(coping);
	}

	public List<Map<String, Object>> getPontic_contours_presence() {
		return map2list(ponticContours);
	}

	public List<Map<String, Object>> getMargin_presence() {
		return map2list(margin);
	}

	public List<Map<String, Object>> getRpd_presence() {
		return map2list(rpd);
	}

	public List<Map<String, Object>> getContacts_embrasures_presence() {
		return map2list(contactsEmbrasures);
	}

	public List<Map<String, Object>> getOcclusal_contact_presence() {
		return map2list(occlusalContact);
	}

	public List<Map<String, Object>> getInsufficient_room_presence() {
		return map2list(insufficientRoom);
	}

	public List<Map<String, Object>> getRetention_presence() {
		return map2list(retention);
	}

	public List<Map<String, Object>> getMargin_position_presence() {
		return map2list(marginPosition);
	}

	public List<Map<String, Object>> getEmergence_width_presence() {
		return map2list(emergenceWidth);
	}

	public List<Map<String, Object>> getStaining_presence() {
		return map2list(staining);
	}

	public List<Map<String, Object>> getStain_placement_presence() {
		return map2list(stainPlacement);
	}

	public List<Map<String, Object>> getSurface_texture_presence() {
		return map2list(surfaceTexture);
	}

	public List<Map<String, Object>> getSurface_finish_presence() {
		return map2list(surfaceFinish);
	}

	public List<Map<String, Object>> getTranslucency_shade_presence() {
		return map2list(translucencyShade);
	}

	public List<Map<String, Object>> getTranslucency_volume_presence() {
		return map2list(translucencyVolume);
	}
	
	/***
	 * 活动义齿修复类属性
	 */
	public List<Map<String, Object>> getId_presence() {
		return  map2list(id);
	}
	
	public List<Map<String, Object>> getReinforcements_presence() {
		return map2list(reinforcements);
	}
	//加载【亚克力色】
	public List<Map<String, Object>> getTissueAcrylicShade_presence() {
		return procedureAttrCache.getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_ACRYLICCOLORS);
	}
	//加载【运动防护色】
	public List<Map<String, Object>> getSportsGuardColor_presence() {
		return procedureAttrCache.getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_SPORTGUARDCOLORS);
	}
	
	/***
	 * 口腔矫治器复类属性
	 */
	//加载【正畸色】
	public List<Map<String, Object>> getColor_presence() {
		return procedureAttrCache.getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICCOLORS);
	}
	//加载【正畸设计】
	public List<Map<String, Object>> getDesign_presence() {
		return procedureAttrCache.getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_ORTHODONTICDESIGNS);
	}
	
	/***
	 * 种植体修复类属性
	 */
	//加载【种植系统】
	public List<Map<String, Object>> getSystem_presence() {
		return procedureAttrCache.getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_IMPLANTSYSTEMS);
	}
	//加载【种植制作】
	public List<Map<String, Object>> getMarker_presence() {
		return procedureAttrCache.getLabProceduresCharacteris(Constans.PROCEDURES_CHARACTERIS_IMPLANTMARKERS);
	}
}
