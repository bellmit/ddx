/**   
 * @Title: CaseDetails.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午11:00:30 
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

/**
 * @ClassName: CaseDetails
 * @Description: 案例详细工作要求实体类
 * @author ERIC
 * @date 2014-6-17 上午11:00:30
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_CASE_DETAILS")
public class CaseDetails implements Serializable {

	private Integer id;						//ID
	private Integer caseId;					//案例ID
	private String units;					//单位
	private String procedures;				//工序（josn格式的存储）{{1:Procedures}{2:Procedures}}
	
	public static class Procedures{
		private String teeth;					//牙齿默认值
		private String shade;					//色彩默认值
		private String stumpShade;				//门牙色彩默认值
		private String alloyMaterial;			//合金材料默认值
		private String coping;					//应对默认值
		private String ponticContours;			//桥体轮廓默认值
		private String margin;					//余量默认值
		private String rpd;						//RPD默认值
		private String contactsEmbrasures;		//联系人默认值
		private String occlusalContact;			//咬合接触默认值
		private String insufficientRoom;		//空不足默认值
		private String retention;				//保留默认值
		private String marginPosition;			//
		private String emergenceWidth;			//
		private String staining;				//
		private String stainPlacement;			//
		private String surfaceTexture;			//
		private String surfaceFinish;			//
		private String translucencyShade;		//
		private String translucencyVolume;		//
		public void setTeeth(String teeth) {
			this.teeth = teeth;
		}
		public void setShade(String shade) {
			this.shade = shade;
		}
		public void setStumpShade(String stumpShade) {
			this.stumpShade = stumpShade;
		}
		public void setAlloyMaterial(String alloyMaterial) {
			this.alloyMaterial = alloyMaterial;
		}
		public void setCoping(String coping) {
			this.coping = coping;
		}
		public void setPonticContours(String ponticContours) {
			this.ponticContours = ponticContours;
		}
		public void setMargin(String margin) {
			this.margin = margin;
		}
		public void setRpd(String rpd) {
			this.rpd = rpd;
		}
		public void setContactsEmbrasures(String contactsEmbrasures) {
			this.contactsEmbrasures = contactsEmbrasures;
		}
		public void setOcclusalContact(String occlusalContact) {
			this.occlusalContact = occlusalContact;
		}
		public void setInsufficientRoom(String insufficientRoom) {
			this.insufficientRoom = insufficientRoom;
		}
		public void setRetention(String retention) {
			this.retention = retention;
		}
		public void setMarginPosition(String marginPosition) {
			this.marginPosition = marginPosition;
		}
		public void setEmergenceWidth(String emergenceWidth) {
			this.emergenceWidth = emergenceWidth;
		}
		public void setStaining(String staining) {
			this.staining = staining;
		}
		public void setStainPlacement(String stainPlacement) {
			this.stainPlacement = stainPlacement;
		}
		public void setSurfaceTexture(String surfaceTexture) {
			this.surfaceTexture = surfaceTexture;
		}
		public void setSurfaceFinish(String surfaceFinish) {
			this.surfaceFinish = surfaceFinish;
		}
		public void setTranslucencyShade(String translucencyShade) {
			this.translucencyShade = translucencyShade;
		}
		public void setTranslucencyVolume(String translucencyVolume) {
			this.translucencyVolume = translucencyVolume;
		}
		
		
		public String getTeeth_presence() {
			return teeth;
		}
		public String getShade_presence() {
			return shade;
		}
		public String getStump_shade_presence() {
			return stumpShade;
		}
		public String getAlloy_material_presence() {
			return alloyMaterial;
		}
		public String getCoping_presence() {
			return coping;
		}
		public String getPontic_contours_presence() {
			return ponticContours;
		}
		public String getMargin_presence() {
			return margin;
		}
		public String getRpd_presence() {
			return rpd;
		}
		public String getContacts_embrasures_presence() {
			return contactsEmbrasures;
		}
		public String getOcclusal_contact_presence() {
			return occlusalContact;
		}
		public String getInsufficient_room_presence() {
			return insufficientRoom;
		}
		public String getRetention_presence() {
			return retention;
		}
		public String getMargin_position_presence() {
			return marginPosition;
		}
		public String getEmergence_width_presence() {
			return emergenceWidth;
		}
		public String getStaining_presence() {
			return staining;
		}
		public String getStain_placement_presence() {
			return stainPlacement;
		}
		public String getSurface_texture_presence() {
			return surfaceTexture;
		}
		public String getSurface_finish_presence() {
			return surfaceFinish;
		}
		public String getTranslucency_shade_presence() {
			return translucencyShade;
		}
		public String getTranslucency_volume_presence() {
			return translucencyVolume;
		}
		
		
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_details_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_details_seq",sequenceName="case_details_seq")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	@Column(name = "case_id")
	public Integer getCaseId() {
		return caseId;
	}
	
	@Column(name = "units")
	public String getUnits() {
		return units;
	}
	@Column(name = "procedures")
	public String getProcedures() {
		return procedures;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	
	
	
}
