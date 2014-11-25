/**   
 * @Title: LabProcedureAttr.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:54:37 
 * @version V1.0   
 */
package com.upcera.ddx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.upcera.ddx.common.target.Note;

/**
 * @ClassName: LabProcedureAttr
 * @Description: 技工间工序属性实体类
 * @author ERIC
 * @date 2014-6-17 上午11:54:37
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_LAB_PROCEDURES_ATTRIBUTES")
public class LabProcedureAttr implements Serializable {
	
	
	/***
	 * 固定义齿修复类属性
	 */
	private Integer attributes_id;					
	private Integer procedures_id;					
	private String teeth_presence;					
	private String teeth_d_value;						
	private String shade_presence;					
	private String shade_d_value;						
	private String stump_shade_presence;		
	private String stump_shade_d_value;			
	private String alloy_material_presence;	
	private String alloy_material_d_value;	
	private String coping_presence;					
	private String coping_d_value;				   
	private String pontic_contours_presence;	
	private String pontic_contours_d_value;		
	private String margin_presence;		
	private String margin_d_value;		
	private String rpd_presence;			
	private String rpd_d_value;				
	private String contacts_embrasures_presence;	    
	private String contacts_embrasures_d_value;	      
	private String occlusal_contact_presence;		      
	private String occlusal_contact_d_value;		      
	private String insufficient_room_presence;		    
	private String insufficient_room_d_value;		      
	private String retention_presence;					      
	private String retention_d_value;				          
	private String margin_position_presence;			    
	private String margin_position_d_value;		        
	private String emergence_width_presence;		      
	private String emergence_width_d_value;		        
	private String staining_presence;				          
	private String staining_d_value;				          
	private String stain_placement_presence;          
	private String stain_placement_d_value;		        
	private String surface_texture_presence;			    
	private String surface_texture_d_value;	          
	private String surface_finish_presence;			      
	private String surface_finish_d_value;		        
	private String translucency_shade_presence;	      
	private String translucency_shade_d_value;	      
	private String translucency_volume_presence;	    
	private String translucency_volume_d_value;
	
	//add by 金德志，2014-9-15 17:25:57
	/***
	 * 活动义齿修复类属性
	 */
	private String locators_presence;
	private String locators_d_value;
	private String id_presence;
	private String id_d_value;
	private String reinforcements_presence;
	private String reinforcements_d_value;
	private String mould_presence;
	private String mould_d_value;
	private String tissueAcrylicShade_presence;
	private String tissueAcrylicShade_d_value;
	private String sportsGuardColor_presence;
	private String sportsGuardColor_d_value;
	/***
	 * 口腔矫治器复类属性
	 */
	private String ballClasp_presence;
	private String retentionSpur_presence;
	private String arrowClasp_presence;
	private String adamsClasp_presence;
	private String cclasp_presence;
	private String rest_presence;
	private String spring_presence;
	private String labialWire_presence;
	private String bitePlate_presence;
	private String expansionScrew_presence;
	private String pontic_presence;
	private String crozatClasp_presence;
	private String color_presence;
	private String design_presence;
	
	private String ballClasp_d_value;
	private String retentionSpur_d_value;
	private String arrowClasp_d_value;
	private String adamsClasp_d_value;
	private String cclasp_d_value;
	private String rest_d_value;
	private String spring_d_value;
	private String labialWire_d_value;
	private String bitePlate_d_value;
	private String expansionScrew_d_value;
	private String pontic_d_value;
	private String crozatClasp_d_value;
	private String color_d_value;
	private String design_d_value;
	/***
	 * 种植体修复类属性
	 */
	private String system_presence;
	private String diameter_presence;
	private String style_presence;
	private String marker_presence;
	
	private String system_d_value;
	private String diameter_d_value;
	private String style_d_value;
	private String marker_d_value;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_procedure_attr_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_procedure_attr_seq",sequenceName="lab_procedure_attr_seq")
	@Column(name = "Attributes_id")
	public Integer getAttributes_id() {
		return attributes_id;
	}
	
	@Column(name = "procedures_id")
	public Integer getProcedures_id() {
		return procedures_id;
	}
	
	/***
	 * 固定义齿修复类属性
	 */
	@Note(name = "牙位",getValueMethod="getTeeth_d_value",getValueDescriptionMethod="")//此处配置为空的字段表示为input输入类型
	@Column(name = "teeth_presence")
	public String getTeeth_presence() {
		return teeth_presence;
	}
	
	@Column(name = "teeth_d_value")
	public String getTeeth_d_value() {
		return teeth_d_value;
	}
	@Note(name = "牙体颜色",isShowByPriceAdd=false,getValueMethod="getShade_d_value",getValueDescriptionMethod="getShadeValue",createCaseShowType="input")
	@Column(name = "shade_presence")
	public String getShade_presence() {
		return shade_presence;
	}
	
	@Column(name = "shade_d_value")
	public String getShade_d_value() {
		return shade_d_value;
	}
	@Note(name = "牙桩颜色",isShowByPriceAdd=false,getValueMethod="getStump_shade_d_value",getValueDescriptionMethod="getStumpShadeValue",createCaseShowType="input")
	@Column(name = "stump_shade_presence")
	public String getStump_shade_presence() {
		return stump_shade_presence;
	}

	@Column(name = "stump_shade_d_value")
	public String getStump_shade_d_value() {
		return stump_shade_d_value;
	}
	@Note(name = "合金/材料",getValueMethod="getAlloy_material_d_value",getValueDescriptionMethod="getAlloyMaterialValue",valueLoadChannel="db")
	@Column(name = "alloy_material_presence")
	public String getAlloy_material_presence() {
		return alloy_material_presence;
	}
	
	@Column(name = "alloy_material_d_value")
	public String getAlloy_material_d_value() {
		return alloy_material_d_value;
	}
	@Note(name = "内冠",getValueMethod="getCoping_d_value",getValueDescriptionMethod="getCopingValue")
	@Column(name = "coping_presence")
	public String getCoping_presence() {
		return coping_presence;
	}
	
	@Column(name = "coping_d_value")
	public String getCoping_d_value() {
		return coping_d_value;
	}
	@Note(name = "桥体轮廓",getValueMethod="getPontic_contours_d_value",getValueDescriptionMethod="getPonticContoursValue")
	@Column(name = "pontic_contours_presence")
	public String getPontic_contours_presence() {
		return pontic_contours_presence;
	}
	
	@Column(name = "pontic_contours_d_value")
	public String getPontic_contours_d_value() {
		return pontic_contours_d_value;
	}
	@Note(name = "边距",getValueMethod="getMargin_d_value",getValueDescriptionMethod="getMarginValue")
	@Column(name = "margin_presence")
	public String getMargin_presence() {
		return margin_presence;
	}
	
	@Column(name = "margin_d_value")
	public String getMargin_d_value() {
		return margin_d_value;
	}
	@Note(name = "可摘局部义齿",getValueMethod="getRpd_d_value",getValueDescriptionMethod="getRpdValue")
	@Column(name = "rpd_presence")
	public String getRpd_presence() {
		return rpd_presence;
	}
	
	@Column(name = "rpd_d_value")
	public String getRpd_d_value() {
		return rpd_d_value;
	}
	@Note(name = "接触面/状隙",getValueMethod="getContacts_embrasures_d_value",getValueDescriptionMethod="getContactsEmbrasuresValue")
	@Column(name = "contacts_embrasures_presence")
	public String getContacts_embrasures_presence() {
		return contacts_embrasures_presence;
	}
	
	@Column(name = "contacts_embrasures_d_value")
	public String getContacts_embrasures_d_value() {
		return contacts_embrasures_d_value;
	}
	@Note(name = "咬合面",getValueMethod="getOcclusal_contact_d_value",getValueDescriptionMethod="getOcclusalContactValue")
	@Column(name = "occlusal_contact_presence")
	public String getOcclusal_contact_presence() {
		return occlusal_contact_presence;
	}
	
	@Column(name = "occlusal_contact_d_value")
	public String getOcclusal_contact_d_value() {
		return occlusal_contact_d_value;
	}
	@Note(name = "不足空间",getValueMethod="getInsufficient_room_d_value",getValueDescriptionMethod="getInsufficientRoomValue")
	@Column(name = "insufficient_room_presence")
	public String getInsufficient_room_presence() {
		return insufficient_room_presence;
	}
	
	@Column(name = "insufficient_room_d_value")
	public String getInsufficient_room_d_value() {
		return insufficient_room_d_value;
	}
	@Note(name = "固定方式",getValueMethod="getRetention_d_value",getValueDescriptionMethod="getRetentionValue")
	@Column(name = "retention_presence")
	public String getRetention_presence() {
		return retention_presence;
	}
	
	@Column(name = "retention_d_value")
	public String getRetention_d_value() {
		return retention_d_value;
	}
	@Note(name = "边缘位置",getValueMethod="getMargin_position_d_value",getValueDescriptionMethod="getMarginPositionValue")
	@Column(name = "margin_position_presence")
	public String getMargin_position_presence() {
		return margin_position_presence;
	}
	
	@Column(name = "margin_position_d_value")
	public String getMargin_position_d_value() {
		return margin_position_d_value;
	}
	@Note(name = "种植基台露出宽度",getValueMethod="getEmergence_width_d_value",getValueDescriptionMethod="getEmergenceWidthValue")
	@Column(name = "emergence_width_presence")
	public String getEmergence_width_presence() {
		return emergence_width_presence;
	}
	
	@Column(name = "emergence_width_d_value")
	public String getEmergence_width_d_value() {
		return emergence_width_d_value;
	}
	@Note(name = "着色",getValueMethod="getStaining_d_value",getValueDescriptionMethod="getStainingValue")
	@Column(name = "staining_presence")
	public String getStaining_presence() {
		return staining_presence;
	}
	
	@Column(name = "staining_d_value")
	public String getStaining_d_value() {
		return staining_d_value;
	}
	@Note(name = "着色点",getValueMethod="getStain_placement_d_value",getValueDescriptionMethod="getStainPlacementValue")
	@Column(name = "stain_placement_presence")
	public String getStain_placement_presence() {
		return stain_placement_presence;
	}
	
	@Column(name = "stain_placement_d_value")
	public String getStain_placement_d_value() {
		return stain_placement_d_value;
	}
	@Note(name = "牙面纹理",getValueMethod="getSurface_texture_d_value",getValueDescriptionMethod="getSurfaceTextureValue")
	@Column(name = "surface_texture_presence")
	public String getSurface_texture_presence() {
		return surface_texture_presence;
	}
	
	@Column(name = "surface_texture_d_value")
	public String getSurface_texture_d_value() {
		return surface_texture_d_value;
	}
	@Note(name = "牙面处理",getValueMethod="getSurface_finish_d_value",getValueDescriptionMethod="getSurfaceFinishValue")
	@Column(name = "surface_finish_presence")
	public String getSurface_finish_presence() {
		return surface_finish_presence;
	}
	
	@Column(name = "surface_finish_d_value")
	public String getSurface_finish_d_value() {
		return surface_finish_d_value;
	}
	@Note(name = "半透明颜色",getValueMethod="getTranslucency_shade_d_value",getValueDescriptionMethod="getTranslucencyShadeValue")
	@Column(name = "translucency_shade_presence")
	public String getTranslucency_shade_presence() {
		return translucency_shade_presence;
	}
	
	@Column(name = "translucency_shade_d_value")
	public String getTranslucency_shade_d_value() {
		return translucency_shade_d_value;
	}
	@Note(name = "半透明程度",getValueMethod="getTranslucency_volume_d_value",getValueDescriptionMethod="getTranslucencyVolumeValue")
	@Column(name = "translucency_volume_presence")
	public String getTranslucency_volume_presence() {
		return translucency_volume_presence;
	}
	
	@Column(name = "translucency_volume_d_value")
	public String getTranslucency_volume_d_value() {
		return translucency_volume_d_value;
	}
	
	/***
	 * 活动义齿修复类属性
	 */
	@Note(name = "定位器",isShowByPriceAdd = false,getValueMethod="getLocators_d_value")
	@Column(name = "locators_presence")
	public String getLocators_presence() {
		return locators_presence;
	}
	@Column(name = "locators_d_value")
	public String getLocators_d_value() {
		return locators_d_value;
	}
	@Note(name = "ID",getValueMethod="getId_d_value",getValueDescriptionMethod="getIdValue")
	@Column(name = "id")
	public String getId_presence() {
		return id_presence;
	}
	@Column(name = "id_d_value")
	public String getId_d_value() {
		return id_d_value;
	}
	@Note(name = "加固",getValueMethod="getReinforcements_d_value",getValueDescriptionMethod="getReinforcementsValue")
	@Column(name = "reinforcements_presence")
	public String getReinforcements_presence() {
		return reinforcements_presence;
	}
	@Column(name = "reinforcements_d_value")
	public String getReinforcements_d_value() {
		return reinforcements_d_value;
	}
	@Note(name = "模具",isShowByPriceAdd = false,getValueMethod="getMould_d_value")
	@Column(name = "mould_presence")
	public String getMould_presence() {
		return mould_presence;
	}
	@Column(name = "mould_d_value")
	public String getMould_d_value() {
		return mould_d_value;
	}
	@Note(name = "胶托颜色",getValueMethod="getTissueAcrylicShade_d_value",getValueDescriptionMethod="getTissueAcrylicShadeValue",valueLoadChannel="db")
	@Column(name = "tissueAcrylicShade_presence")
	public String getTissueAcrylicShade_presence() {
		return tissueAcrylicShade_presence;
	}
	@Column(name = "tissueAcrylicShade_d_value")
	public String getTissueAcrylicShade_d_value() {
		return tissueAcrylicShade_d_value;
	}
	@Note(name = "运动牙套颜色",getValueMethod="getSportsGuardColor_d_value",getValueDescriptionMethod="getSportsGuardColorValue",valueLoadChannel="db")
	@Column(name = "sportsGuardColor_presence")
	public String getSportsGuardColor_presence() {
		return sportsGuardColor_presence;
	}
	@Column(name = "sportsGuardColor_d_value")
	public String getSportsGuardColor_d_value() {
		return sportsGuardColor_d_value;
	}
	
	
	/***
	 * 口腔矫治器复类属性
	 */
	@Note(name = "球形卡环",isShowByPriceAdd = false,getValueMethod="getBallClasp_d_value",dataType="int")
	@Column(name = "ballClasp_presence")
	public String getBallClasp_presence() {
		return ballClasp_presence;
	}
	@Note(name = "保持柱",isShowByPriceAdd = false,getValueMethod="getRetentionSpur_d_value",dataType="int")
	@Column(name = "retentionSpur_presence")
	public String getRetentionSpur_presence() {
		return retentionSpur_presence;
	}
	@Note(name = "箭形卡环",isShowByPriceAdd = false,getValueMethod="getArrowClasp_d_value",dataType="int")
	@Column(name = "arrowClasp_presence")
	public String getArrowClasp_presence() {
		return arrowClasp_presence;
	}
	@Note(name = "Adams卡环",isShowByPriceAdd = false,getValueMethod="getAdamsClasp_d_value",dataType="int")
	@Column(name = "adamsClasp_presence")
	public String getAdamsClasp_presence() {
		return adamsClasp_presence;
	}
	@Note(name = "C卡环",isShowByPriceAdd = false,getValueMethod="getCclasp_d_value",dataType="int")
	@Column(name = "cclasp_presence")
	public String getCclasp_presence() {
		return cclasp_presence;
	}
	@Note(name = "支架",isShowByPriceAdd = false,getValueMethod="getRest_d_value",dataType="int")
	@Column(name = "rest_presence")
	public String getRest_presence() {
		return rest_presence;
	}
	@Note(name = "弹簧",isShowByPriceAdd = false,getValueMethod="getSpring_d_value",dataType="int")
	@Column(name = "spring_presence")
	public String getSpring_presence() {
		return spring_presence;
	}
	@Note(name = "唇弓丝",isShowByPriceAdd = false,getValueMethod="getLabialWire_d_value",dataType="int")
	@Column(name = "labialWire_presence")
	public String getLabialWire_presence() {
		return labialWire_presence;
	}
	@Note(name = "咬合托",isShowByPriceAdd = false,getValueMethod="getBitePlate_d_value",dataType="int")
	@Column(name = "bitePlate_presence")
	public String getBitePlate_presence() {
		return bitePlate_presence;
	}
	@Note(name = "扩张器螺丝",isShowByPriceAdd = false,getValueMethod="getExpansionScrew_d_value",dataType="int")
	@Column(name = "expansionScrew_presence")
	public String getExpansionScrew_presence() {
		return expansionScrew_presence;
	}
	@Note(name = "桥体",isShowByPriceAdd = false,getValueMethod="getPontic_d_value",dataType="int")
	@Column(name = "pontic_presence")
	public String getPontic_presence() {
		return pontic_presence;
	}
	@Note(name = "Crozat卡环",isShowByPriceAdd = false,getValueMethod="getCrozatClasp_d_value",dataType="int")
	@Column(name = "crozatClasp_presence")
	public String getCrozatClasp_presence() {
		return crozatClasp_presence;
	}
	@Note(name = "颜色",getValueMethod="getColor_d_value",getValueDescriptionMethod="getColorValue",valueLoadChannel="db")
	@Column(name = "color_presence")
	public String getColor_presence() {
		return color_presence;
	}
	@Note(name = "设计",getValueMethod="getDesign_d_value",getValueDescriptionMethod="getDesignValue",valueLoadChannel="db")
	@Column(name = "design_presence")
	public String getDesign_presence() {
		return design_presence;
	}
	
	@Column(name = "ballClasp_d_value")
	public String getBallClasp_d_value() {
		return ballClasp_d_value;
	}
	@Column(name = "retentionSpur_d_value")
	public String getRetentionSpur_d_value() {
		return retentionSpur_d_value;
	}
	@Column(name = "arrowClasp_d_value")
	public String getArrowClasp_d_value() {
		return arrowClasp_d_value;
	}
	@Column(name = "adamsClasp_d_value")
	public String getAdamsClasp_d_value() {
		return adamsClasp_d_value;
	}
	@Column(name = "cclasp_d_value")
	public String getCclasp_d_value() {
		return cclasp_d_value;
	}
	@Column(name = "rest_d_value")
	public String getRest_d_value() {
		return rest_d_value;
	}
	@Column(name = "spring_d_value")
	public String getSpring_d_value() {
		return spring_d_value;
	}
	@Column(name = "labialWire_d_value")
	public String getLabialWire_d_value() {
		return labialWire_d_value;
	}
	@Column(name = "bitePlate_d_value")
	public String getBitePlate_d_value() {
		return bitePlate_d_value;
	}
	@Column(name = "expansionScrew_d_value")
	public String getExpansionScrew_d_value() {
		return expansionScrew_d_value;
	}
	@Column(name = "pontic_d_value")
	public String getPontic_d_value() {
		return pontic_d_value;
	}
	@Column(name = "crozatClasp_d_value")
	public String getCrozatClasp_d_value() {
		return crozatClasp_d_value;
	}
	@Column(name = "color_d_value")
	public String getColor_d_value() {
		return color_d_value;
	}
	@Column(name = "design_d_value")
	public String getDesign_d_value() {
		return design_d_value;
	}
	
	
	/***
	 * 种植体修复类属性
	 */
	@Note(name = "种植系统",getValueMethod="getSystem_d_value",getValueDescriptionMethod="getSystemValue",valueLoadChannel="db")
	@Column(name = "system_presence")
	public String getSystem_presence() {
		return system_presence;
	}
	@Note(name = "直径",isShowByPriceAdd = false,getValueMethod="getDiameter_d_value")
	@Column(name = "diameter_presence")
	public String getDiameter_presence() {
		return diameter_presence;
	}
	@Note(name = "款式",isShowByPriceAdd = false,getValueMethod="getStyle_d_value")
	@Column(name = "style_presence")
	public String getStyle_presence() {
		return style_presence;
	}
	@Note(name = "种植标记",getValueMethod="getMarker_d_value",getValueDescriptionMethod="getMarkerValue",valueLoadChannel="db")
	@Column(name = "marker_presence")
	public String getMarker_presence() {
		return marker_presence;
	}
	@Column(name = "system_d_value")
	public String getSystem_d_value() {
		return system_d_value;
	}
	@Column(name = "diameter_d_value")
	public String getDiameter_d_value() {
		return diameter_d_value;
	}
	@Column(name = "style_d_value")
	public String getStyle_d_value() {
		return style_d_value;
	}
	@Column(name = "marker_d_value")
	public String getMarker_d_value() {
		return marker_d_value;
	}
	
	
	
	
	
	public void setAttributes_id(Integer attributes_id) {
		this.attributes_id = attributes_id;
	}
	public void setProcedures_id(Integer procedures_id) {
		this.procedures_id = procedures_id;
	}
	public void setTeeth_presence(String teeth_presence) {
		this.teeth_presence = teeth_presence;
	}
	public void setTeeth_d_value(String teeth_d_value) {
		this.teeth_d_value = teeth_d_value;
	}
	public void setShade_presence(String shade_presence) {
		this.shade_presence = shade_presence;
	}
	public void setShade_d_value(String shade_d_value) {
		this.shade_d_value = shade_d_value;
	}
	public void setStump_shade_presence(String stump_shade_presence) {
		this.stump_shade_presence = stump_shade_presence;
	}
	public void setStump_shade_d_value(String stump_shade_d_value) {
		this.stump_shade_d_value = stump_shade_d_value;
	}
	public void setAlloy_material_presence(String alloy_material_presence) {
		this.alloy_material_presence = alloy_material_presence;
	}
	public void setAlloy_material_d_value(String alloy_material_d_value) {
		this.alloy_material_d_value = alloy_material_d_value;
	}
	public void setCoping_presence(String coping_presence) {
		this.coping_presence = coping_presence;
	}
	public void setCoping_d_value(String coping_d_value) {
		this.coping_d_value = coping_d_value;
	}
	public void setPontic_contours_presence(String pontic_contours_presence) {
		this.pontic_contours_presence = pontic_contours_presence;
	}
	public void setPontic_contours_d_value(String pontic_contours_d_value) {
		this.pontic_contours_d_value = pontic_contours_d_value;
	}
	public void setMargin_presence(String margin_presence) {
		this.margin_presence = margin_presence;
	}
	public void setMargin_d_value(String margin_d_value) {
		this.margin_d_value = margin_d_value;
	}
	public void setRpd_presence(String rpd_presence) {
		this.rpd_presence = rpd_presence;
	}
	public void setRpd_d_value(String rpd_d_value) {
		this.rpd_d_value = rpd_d_value;
	}
	public void setContacts_embrasures_presence(String contacts_embrasures_presence) {
		this.contacts_embrasures_presence = contacts_embrasures_presence;
	}
	public void setContacts_embrasures_d_value(String contacts_embrasures_d_va) {
		this.contacts_embrasures_d_value = contacts_embrasures_d_va;
	}
	public void setOcclusal_contact_presence(String occlusal_contact_presence) {
		this.occlusal_contact_presence = occlusal_contact_presence;
	}
	public void setOcclusal_contact_d_value(String occlusal_contact_d_value) {
		this.occlusal_contact_d_value = occlusal_contact_d_value;
	}
	public void setInsufficient_room_presence(String insufficient_room_presence) {
		this.insufficient_room_presence = insufficient_room_presence;
	}
	public void setInsufficient_room_d_value(String insufficient_room_d_valu) {
		this.insufficient_room_d_value = insufficient_room_d_valu;
	}
	public void setRetention_presence(String retention_presence) {
		this.retention_presence = retention_presence;
	}
	public void setRetention_d_value(String retention_d_value) {
		this.retention_d_value = retention_d_value;
	}
	public void setMargin_position_presence(String margin_position_presence) {
		this.margin_position_presence = margin_position_presence;
	}
	public void setMargin_position_d_value(String margin_position_d_value) {
		this.margin_position_d_value = margin_position_d_value;
	}
	public void setEmergence_width_presence(String emergence_width_presence) {
		this.emergence_width_presence = emergence_width_presence;
	}
	public void setEmergence_width_d_value(String emergence_width_d_value) {
		this.emergence_width_d_value = emergence_width_d_value;
	}
	public void setStaining_presence(String staining_presence) {
		this.staining_presence = staining_presence;
	}
	public void setStaining_d_value(String staining_d_value) {
		this.staining_d_value = staining_d_value;
	}
	public void setStain_placement_presence(String stain_placement_presence) {
		this.stain_placement_presence = stain_placement_presence;
	}
	public void setStain_placement_d_value(String stain_placement_d_value) {
		this.stain_placement_d_value = stain_placement_d_value;
	}
	public void setSurface_texture_presence(String surface_texture_presence) {
		this.surface_texture_presence = surface_texture_presence;
	}
	public void setSurface_texture_d_value(String surface_texture_d_value) {
		this.surface_texture_d_value = surface_texture_d_value;
	}
	public void setSurface_finish_presence(String surface_finish_presence) {
		this.surface_finish_presence = surface_finish_presence;
	}
	public void setSurface_finish_d_value(String surface_finish_d_value) {
		this.surface_finish_d_value = surface_finish_d_value;
	}
	public void setTranslucency_shade_presence(String translucency_shade_presence) {
		this.translucency_shade_presence = translucency_shade_presence;
	}
	public void setTranslucency_shade_d_value(String translucency_shade_d_val) {
		this.translucency_shade_d_value = translucency_shade_d_val;
	}
	public void setTranslucency_volume_presence(String translucency_volume_presence) {
		this.translucency_volume_presence = translucency_volume_presence;
	}
	public void setTranslucency_volume_d_value(String translucency_volume_d_va) {
		this.translucency_volume_d_value = translucency_volume_d_va;
	}
	public void setLocators_presence(String locatorsPresence) {
		locators_presence = locatorsPresence;
	}
	public void setLocators_d_value(String locatorsDefaultValue) {
		locators_d_value = locatorsDefaultValue;
	}
	public void setId_presence(String idPresence) {
		id_presence = idPresence;
	}
	public void setId_d_value(String idDefaultValue) {
		id_d_value = idDefaultValue;
	}
	public void setReinforcements_presence(String reinforcementsPresence) {
		reinforcements_presence = reinforcementsPresence;
	}
	public void setReinforcements_d_value(String reinforcementsDefaultValue) {
		reinforcements_d_value = reinforcementsDefaultValue;
	}
	public void setMould_presence(String mouldPresence) {
		mould_presence = mouldPresence;
	}
	public void setMould_d_value(String mouldDefaultValue) {
		mould_d_value = mouldDefaultValue;
	}
	public void setTissueAcrylicShade_presence(String tissueAcrylicShadePresence) {
		tissueAcrylicShade_presence = tissueAcrylicShadePresence;
	}
	public void setTissueAcrylicShade_d_value(String tissueAcrylicShadeDefaultVa) {
		tissueAcrylicShade_d_value = tissueAcrylicShadeDefaultVa;
	}
	public void setSportsGuardColor_presence(String sportsGuardColorPresence) {
		sportsGuardColor_presence = sportsGuardColorPresence;
	}
	public void setSportsGuardColor_d_value(String sportsGuardColorDefaultVa) {
		sportsGuardColor_d_value = sportsGuardColorDefaultVa;
	}

	public void setBallClasp_presence(String ballClaspPresence) {
		ballClasp_presence = ballClaspPresence;
	}
	public void setRetentionSpur_presence(String retentionSpurPresence) {
		retentionSpur_presence = retentionSpurPresence;
	}
	public void setArrowClasp_presence(String arrowClaspPresence) {
		arrowClasp_presence = arrowClaspPresence;
	}
	public void setAdamsClasp_presence(String adamsClaspPresence) {
		adamsClasp_presence = adamsClaspPresence;
	}
	public void setCclasp_presence(String cclaspPresence) {
		cclasp_presence = cclaspPresence;
	}
	public void setRest_presence(String restPresence) {
		rest_presence = restPresence;
	}
	public void setSpring_presence(String springPresence) {
		spring_presence = springPresence;
	}
	public void setLabialWire_presence(String labialWirePresence) {
		labialWire_presence = labialWirePresence;
	}
	public void setBitePlate_presence(String bitePlatePresence) {
		bitePlate_presence = bitePlatePresence;
	}
	public void setExpansionScrew_presence(String expansionScrewPresence) {
		expansionScrew_presence = expansionScrewPresence;
	}
	public void setPontic_presence(String ponticPresence) {
		pontic_presence = ponticPresence;
	}
	public void setCrozatClasp_presence(String crozatClaspPresence) {
		crozatClasp_presence = crozatClaspPresence;
	}
	public void setColor_presence(String colorPresence) {
		color_presence = colorPresence;
	}
	public void setDesign_presence(String designPresence) {
		design_presence = designPresence;
	}
	public void setBallClasp_d_value(String ballClaspDefaultValue) {
		ballClasp_d_value = ballClaspDefaultValue;
	}
	public void setRetentionSpur_d_value(String retentionSpurDefaultValue) {
		retentionSpur_d_value = retentionSpurDefaultValue;
	}
	public void setArrowClasp_d_value(String arrowClaspDefaultValue) {
		arrowClasp_d_value = arrowClaspDefaultValue;
	}
	public void setAdamsClasp_d_value(String adamsClaspDefaultValue) {
		adamsClasp_d_value = adamsClaspDefaultValue;
	}
	public void setCclasp_d_value(String cclaspDefaultValue) {
		cclasp_d_value = cclaspDefaultValue;
	}
	public void setRest_d_value(String restDefaultValue) {
		rest_d_value = restDefaultValue;
	}
	public void setSpring_d_value(String springDefaultValue) {
		spring_d_value = springDefaultValue;
	}
	public void setLabialWire_d_value(String labialWireDefaultValue) {
		labialWire_d_value = labialWireDefaultValue;
	}
	public void setBitePlate_d_value(String bitePlateDefaultValue) {
		bitePlate_d_value = bitePlateDefaultValue;
	}
	public void setExpansionScrew_d_value(String expansionScrewDefaultValue) {
		expansionScrew_d_value = expansionScrewDefaultValue;
	}
	public void setPontic_d_value(String ponticDefaultValue) {
		pontic_d_value = ponticDefaultValue;
	}
	public void setCrozatClasp_d_value(String crozatClaspDefaultValue) {
		crozatClasp_d_value = crozatClaspDefaultValue;
	}
	public void setColor_d_value(String colorDefaultValue) {
		color_d_value = colorDefaultValue;
	}
	public void setDesign_d_value(String designDefaultValue) {
		design_d_value = designDefaultValue;
	}

	public void setSystem_presence(String systemPresence) {
		system_presence = systemPresence;
	}
	public void setDiameter_presence(String diameterPresence) {
		diameter_presence = diameterPresence;
	}
	public void setStyle_presence(String stylePresence) {
		style_presence = stylePresence;
	}
	public void setMarker_presence(String markerPresence) {
		marker_presence = markerPresence;
	}
	public void setSystem_d_value(String systemDefaultValue) {
		system_d_value = systemDefaultValue;
	}
	public void setDiameter_d_value(String diameterDefaultValue) {
		diameter_d_value = diameterDefaultValue;
	}
	public void setStyle_d_value(String styleDefaultValue) {
		style_d_value = styleDefaultValue;
	}
	public void setMarker_d_value(String markerDefaultValue) {
		marker_d_value = markerDefaultValue;
	}
}
