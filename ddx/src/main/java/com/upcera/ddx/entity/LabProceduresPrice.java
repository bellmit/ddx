package com.upcera.ddx.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.upcera.ddx.pojo.PriceAttr;


@Entity
@Table(name = "DDX_LAB_PROCEDURES_PRICE")
public class LabProceduresPrice implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer proceduresId;
	private Integer priceGroupId;
	private Double price;
	private String attributes;
	private String priceGroupName;//页面显示用
	
	public static class PriceAttributes extends PriceAttr{
		public Map<String, Object> getTeeth_presence() {
			if(teeth==null){
				teeth = new HashMap<String, Object>();
			}
			return teeth;
		}

		public Map<String, Object> getAlloy_material_presence() {
			if(alloyMaterial==null){
				alloyMaterial = new HashMap<String, Object>();
			}
			return alloyMaterial;
		}

		public Map<String, Object> getCoping_presence() {
			if(coping==null){
				coping = new HashMap<String, Object>();
			}
			return coping;
		}

		public Map<String, Object> getPontic_contours_presence() {
			if(ponticContours==null){
				ponticContours = new HashMap<String, Object>();
			}
			return ponticContours;
		}

		public Map<String, Object> getMargin_presence() {
			if(margin==null){
				margin = new HashMap<String, Object>();
			}
			return margin;
		}

		public Map<String, Object> getRpd_presence() {
			if(rpd==null){
				rpd = new HashMap<String, Object>();
			}
			return rpd;
		}

		public Map<String, Object> getContacts_embrasures_presence() {
			if(contactsEmbrasures==null){
				contactsEmbrasures = new HashMap<String, Object>();
			}
			return contactsEmbrasures;
		}

		public Map<String, Object> getOcclusal_contact_presence() {
			if(occlusalContact==null){
				occlusalContact = new HashMap<String, Object>();
			}
			return occlusalContact;
		}

		public Map<String, Object> getInsufficient_room_presence() {
			if(insufficientRoom==null){
				insufficientRoom = new HashMap<String, Object>();
			}
			return insufficientRoom;
		}

		public Map<String, Object> getRetention_presence() {
			if(retention==null){
				retention = new HashMap<String, Object>();
			}
			return retention;
		}

		public Map<String, Object> getMargin_position_presence() {
			if(marginPosition==null){
				marginPosition = new HashMap<String, Object>();
			}
			return marginPosition;
		}

		public Map<String, Object> getEmergence_width_presence() {
			if(emergenceWidth==null){
				emergenceWidth = new HashMap<String, Object>();
			}
			return emergenceWidth;
		}

		public Map<String, Object> getStaining_presence() {
			if(staining==null){
				staining = new HashMap<String, Object>();
			}
			return staining;
		}

		public Map<String, Object> getStain_placement_presence() {
			if(stainPlacement==null){
				stainPlacement = new HashMap<String, Object>();
			}
			return stainPlacement;
		}

		public Map<String, Object> getSurface_texture_presence() {
			if(surfaceTexture==null){
				surfaceTexture = new HashMap<String, Object>();
			}
			return surfaceTexture;
		}

		public Map<String, Object> getSurface_finish_presence() {
			if(surfaceFinish==null){
				surfaceFinish = new HashMap<String, Object>();
			}
			return surfaceFinish;
		}

		public Map<String, Object> getTranslucency_shade_presence() {
			if(translucencyShade==null){
				translucencyShade = new HashMap<String, Object>();
			}
			return translucencyShade;
		}

		public Map<String, Object> getTranslucency_volume_presence() {
			if(translucencyVolume==null){
				translucencyVolume = new HashMap<String, Object>();
			}
			return translucencyVolume;
		}
		/***
		 * 活动义齿修复类属性
		 */
		public Map<String, Object> getId_presence() {
			if(id==null){
				id = new HashMap<String, Object>();
			}
			return id;
		}
		
		public Map<String, Object> getReinforcements_presence() {
			if(reinforcements==null){
				reinforcements = new HashMap<String, Object>();
			}
			return reinforcements;
		}
		public Map<String, Object> getTissueAcrylicShade_presence() {
			if(tissueAcrylicShade==null){
				tissueAcrylicShade = new HashMap<String, Object>();
			}
			return tissueAcrylicShade;
		}
		public Map<String, Object> getSportsGuardColor_presence() {
			if(sportsGuardColor==null){
				sportsGuardColor = new HashMap<String, Object>();
			}
			return sportsGuardColor;
		}
		
		/***
		 * 口腔矫治器复类属性
		 */
		public Map<String, Object> getColor_presence() {
			if(color==null){
				color = new HashMap<String, Object>();
			}
			return color;
		}
		public Map<String, Object> getDesign_presence() {
			if(design==null){
				design = new HashMap<String, Object>();
			}
			return design;
		}
		
		/***
		 * 种植体修复类属性
		 */
		public Map<String, Object> getSystem_presence() {
			if(system==null){
				system = new HashMap<String, Object>();
			}
			return system;
		}
		public Map<String, Object> getMarker_presence() {
			if(marker==null){
				marker = new HashMap<String, Object>();
			}
			return marker;
		}
	}
	
	@Id
	//@GeneratedValue
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lab_procedures_price_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="lab_procedures_price_seq",sequenceName="lab_procedures_price_sequence")
	@Column(name = "PRICE_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "PROCEDURES_ID")
	public Integer getProceduresId() {
		return proceduresId;
	}
	public void setProceduresId(Integer proceduresId) {
		this.proceduresId = proceduresId;
	}
	@Column(name = "PRICE_GROUP_ID")
	public Integer getPriceGroupId() {
		return priceGroupId;
	}
	public void setPriceGroupId(Integer priceGroupId) {
		this.priceGroupId = priceGroupId;
	}
	@Column(name = "PRICE")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Column(name = "ATTRIBUTES")
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public String getPriceGroupName() {
		return priceGroupName;
	}
	public void setPriceGroupName(String priceGroupName) {
		this.priceGroupName = priceGroupName;
	}

}
