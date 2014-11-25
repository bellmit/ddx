/**   
 * @Title: Cases.java 
 * @Package com.upcera.ddx.entity 
 * @author ERIC
 * @company UPCERA
 * @date 2014-6-17 上午10:28:14 
 * @version V1.0   
 */ 
package com.upcera.ddx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.upcera.ddx.common.target.Excel;
import com.upcera.ddx.common.target.Note;
import com.upcera.ddx.common.util.ToolsKit;

/** 
 * @ClassName: Case 
 * @Description: 案例实体类 
 * @author ERIC
 * @date 2014-6-17 上午10:28:14 
 *  
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DDX_CASE")
public class Cases implements Serializable {
	private Integer caseId;				//案例ID
	private Integer labId;				//实验室ID(接收方)
	private String labName;				//实验室名称
	private Integer practiceId;			//下单机构ID
	private Integer unitType;			//下单机构类型(1、标识技工间;2、标识诊所)
	private String caseName;			//案例名称
	private String invoice;				//发票
	private String practice;			//下单机构名称
	private String provider;			//提供者
	private String patient;				//患者病人
	private Integer patientId;			//患者病人ID
	private Date shipDate;				//技工间送货时间
	private Date deliveryDate;			//技工间交货时间
	private Date lastUpdateDate;		//案例最新修改时间
	private String status;				//状态	约定：OPEN为打开  CANCEL为取消
	private String onHoldStatus;		//on hold status
	private Date createDate;			//创建时间
	private Date sendToLabDate;		//发送到技工间的时间
	private String isTryIn;			//是否试戴
	private String isEmeger;			//是否加急
	private String isFiles;			//是否入档
	private String waybillNumber;		//运单号
	private String tags;				//标签
	private String isFollow;			//是否跟进
	private String isDraft;			//是否为草案
	private String enclosures;			//快递件名称
	private Date patAppDate;		//患者预约日期
	private Date cancelledDate;		//案例取消日期
	private String cancelledBy;		//案例取消人
	private Integer arrived;		//是否到达 约定：0标识未到达 1标识到达
	private Date arriveDate;		//到达日期
	private Integer confirmedReturnDay;	//是否确认返回日期 0标识未确认 1标识确认
	private Integer shipped;		//是否发货	
	private String filterType;		//过滤方式
	private String msg;				//备用字段
	private String msg1;			//备用字段1
	private Object extObj;			//备用对象字段，存储非字符对象
	private Object proceduresObj;	//工序字段对象，前台页面显示用，数据库不创建此字段
	
	private String links;			//外包订单记录
	private Integer parentId;		//外包订单父ID
	
	private String shipper;			//货运商
	private Integer shipperId;		//货运商ID
	
	private Integer returnSId;		//源订单ID
	private Integer returnDId;		//基于源订单的重制订单ID
	private String returnType;		//返回订单类型
	private Integer	remakeType;		//重制类型
	private String remakeTypeNam;	//重制类型名
	private Integer isReturn;		//是否已重制
	
	private String procedures;		//工序
	private Double finishPrice;		//最终成交的价格
	private Double originalPrice;	//原价
	
	private String teethNotation;	//牙位标识
	private String couponCode;		//使用优惠券码
	
	private Integer practiceArrived; //诊所收到技工间的货物，标记发货已抵达 
	private Date practiceArriveDate; //诊所抵达日期
	
	public Cases(){
		
	}
	
	//用于诊所首页获取草稿
	public Cases(Integer caseId, Integer patientId, String patient,String labName){
		this.caseId = caseId;
		this.patientId = patientId;
		this.patient = patient;
		this.labName = labName;
	}
	
	//用于诊所首页获取试戴订单
	public Cases(Integer caseId, Integer patientId, String patient){
		this.caseId = caseId;
		this.patientId = patientId;
		this.patient = patient;
	}
	
	//用于重制订单查询
	public Cases(Integer caseId, Integer returnSId,Integer remakeType, String remakeTypeNam, String practice){
		this.caseId = caseId;
		this.returnSId = returnSId;
		this.remakeTypeNam = remakeTypeNam;
		this.remakeType = remakeType;
		this.practice = practice;
	}
	
	//用于外包订单查询
	public Cases(Integer caseId, String labName){
		this.caseId = caseId;
		this.labName = labName;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="case_seq")
	@SequenceGenerator(allocationSize=1,initialValue=500,name="case_seq",sequenceName="case_seq")
	@Excel(index=1,title="重制订单编号")
	@Column(name = "case_id")
	public Integer getCaseId() {
		return caseId;
	}
	@Column(name = "lab_id")
	public Integer getLabId() {
		return labId;
	}
	@Column(name = "unit_type")
	public Integer getUnitType() {
		return unitType;
	}
	@Column(name = "practice_id")
	public Integer getPracticeId() {
		return practiceId;
	}
	@Column(name = "case_name")
	public String getCaseName() {
		return caseName;
	}
	@Column(name = "invoice")
	public String getInvoice() {
		return invoice;
	}
	@Excel(index=0,title="诊所")
	@Column(name = "practice")
	public String getPractice() {
		return practice;
	}
	@Column(name = "provider")
	public String getProvider() {
		return provider;
	}
	
	@Column(name = "patient")
	public String getPatient() {
		return patient;
	}
	@Column(name = "ship_date")
	public Date getShipDate() {
		return shipDate;
	}
	@Column(name = "delivery_date")
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	@Column(name = "last_update_date")
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}
	@Column(name = "send_to_lab_date")
	public Date getSendToLabDate() {
		return sendToLabDate;
	}
	@Column(name = "is_try_in")
	public String getIsTryIn() {
		return isTryIn;
	}
	@Column(name = "is_emeger")
	public String getIsEmeger() {
		return isEmeger;
	}
	@Column(name = "is_files")
	public String getIsFiles() {
		return isFiles;
	}
	@Column(name = "waybill_number")
	public String getWaybillNumber() {
		return waybillNumber;
	}
	@Column(name = "tags")
	public String getTags() {
		return tags;
	}
	@Column(name = "is_follow")
	public String getIsFollow() {
		return isFollow;
	}
	@Column(name = "is_draft")
	public String getIsDraft() {
		return isDraft;
	}
	@Column(name = "enclosures")
	public String getEnclosures() {
		return enclosures;
	}
	@Column(name = "patient_appointment_date")
	public Date getPatAppDate() {
		return patAppDate;
	}
	@Column(name = "cancelled_date")
	public Date getCancelledDate() {
		return cancelledDate;
	}
	@Column(name = "cancelled_by")
	public String getCancelledBy() {
		return cancelledBy;
	}
	@Column(name = "patient_id")
	public Integer getPatientId() {
		return patientId;
	}
	@Column(name = "arrived")
	public Integer getArrived() {
		return arrived;
	}
	
	@Column(name = "arrive_date")
	public Date getArriveDate() {
		return arriveDate;
	}

	@Column(name = "confirm_delivery_date")
	public Integer getConfirmedReturnDay() {
		return confirmedReturnDay;
	}
	
	@Column(name = "on_hold_status")
	public String getOnHoldStatus() {
		return onHoldStatus;
	}
	@Transient
	public String getShipper() {
		return shipper;
	}
	
	@Column(name = "shipper_id")
	public Integer getShipperId() {
		return shipperId;
	}
	
	public void setOnHoldStatus(String onHoldStatus) {
		this.onHoldStatus = onHoldStatus;
	}
	
	@Transient
	public String getFilterType() {
		return filterType;
	}
	
	@Transient
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Transient
	public String getMsg1() {
		return msg1;
	}
	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public void setConfirmedReturnDay(Integer confirmedReturnDay) {
		this.confirmedReturnDay = confirmedReturnDay;
	}
	
	@Column(name = "shipped", columnDefinition="int default 0")
	public Integer getShipped() {
		return shipped;
	}
	@Column(name = "PROCEDURES")
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	public void setShipped(Integer shipped) {
		this.shipped = shipped;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}
	public void setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setSendToLabDate(Date sendToLabDate) {
		this.sendToLabDate = sendToLabDate;
	}

	public void setIsTryIn(String isTryIn) {
		this.isTryIn = isTryIn;
	}

	public void setIsEmeger(String isEmeger) {
		this.isEmeger = isEmeger;
	}

	public void setIsFiles(String isFiles) {
		this.isFiles = isFiles;
	}

	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setIsFollow(String isFollow) {
		this.isFollow = isFollow;
	}

	public void setIsDraft(String isDraft) {
		this.isDraft = isDraft;
	}

	public void setEnclosures(String enclosures) {
		this.enclosures = enclosures;
	}
	
	public void setPatAppDate(Date patAppDate) {
		this.patAppDate = patAppDate;
	}
	
	public void setCancelledDate(Date cancelledDate) {
		this.cancelledDate = cancelledDate;
	}

	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}
	
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public void setArrived(Integer arrived) {
		this.arrived = arrived;
	}
	
	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	
	@Transient
	public String getLinks() {
		return links;
	}
	
	public void setLinks(String links) {
		this.links = links;
	}
	
	@Column(name = "parent_id")
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}
	
	@Column(name = "lab_name")
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	
	@Excel(index=2,title="源订单编号")
	@Column(name = "return_sid")
	public Integer getReturnSId() {
		return returnSId;
	}
	
	@Column(name = "return_did")
	public Integer getReturnDId() {
		return returnDId;
	}

	@Column(name = "return_type")
	public String getReturnType() {
		return returnType;
	}

	@Column(name = "remake_type")
	public Integer getRemakeType() {
		return remakeType;
	}

	public void setReturnSId(Integer returnSId) {
		this.returnSId = returnSId;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public void setRemakeType(Integer remakeType) {
		this.remakeType = remakeType;
	}

	public void setReturnDId(Integer returnDId) {
		this.returnDId = returnDId;
	}

	@Column(name = "is_return")
	public Integer getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(Integer isReturn) {
		this.isReturn = isReturn;
	}

	@Excel(index=3,title="重制原因")
	@Transient
	public String getRemakeTypeNam() {
		return remakeTypeNam;
	}

	public void setRemakeTypeNam(String remakeTypeNam) {
		this.remakeTypeNam = remakeTypeNam;
	}
	@Column(name = "FINISH_PRICE",columnDefinition="number(10,2) default 0")
	public Double getFinishPrice() {
		return finishPrice;
	}

	public void setFinishPrice(Double finishPrice) {
		this.finishPrice = finishPrice;
	}
	
	@Column(name = "ORIGINAL_PRICE",columnDefinition="number(10,2) default 0")
	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@Transient
	public Object getExtObj() {
		return extObj;
	}

	public void setExtObj(Object extObj) {
		this.extObj = extObj;
	}

	@Transient
	public Object getProceduresObj() {
		try {
			return ToolsKit.jsonUitl.toBean(Map[].class, procedures);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setProceduresObj(Object proceduresObj) {
		this.proceduresObj = proceduresObj;
	}
	
	@Column(name = "TEETH_NOTATION")
	public String getTeethNotation() {
		return teethNotation;
	}


	public void setTeethNotation(String teethNotation) {
		this.teethNotation = teethNotation;
	}

	@Column(name = "COUPON_CODE")
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Column(name = "practice_arrived",columnDefinition="number(1) default 0")
	public Integer getPracticeArrived() {
		return practiceArrived;
	}

	public void setPracticeArrived(Integer practiceArrived) {
		this.practiceArrived = practiceArrived;
	}


	@Column(name = "practice_arrivedate")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPracticeArriveDate() {
		return practiceArriveDate;
	}

	public void setPracticeArriveDate(Date practiceArriveDate) {
		this.practiceArriveDate = practiceArriveDate;
	}


	//案例制作工序保存json对象
	public static class Procedures{
		private String teeth;					              
		private String shade;					              
		private String stumpShade;				          
		private String alloyMaterial;			          
		private String coping;				              
		private String ponticContours;	            
		private String margin;				             	
		private String rpd;					                
		private String contactsEmbrasures;	        
		private String occlusalContact;			        
		private String insufficientRoom;		        
		private String retention;				            
		private String marginPosition;	            
		private String emergenceWidth;	            
		private String staining;				            
		private String stainPlacement;	            
		private String surfaceTexture;		          
		private String surfaceFinish;			          
		private String translucencyShade;	          
		private String translucencyVolume;
		
		private String locators;
		private String id;
		private String reinforcements;
		private String mould;
		private String tissueAcrylicShade;
		private String sportsGuardColor;
		
		
		private String ballClasp;
		private String retentionSpur;
		private String arrowClasp;
		private String adamsClasp;
		private String cclasp;
		private String rest;
		private String spring;
		private String labialWire;
		private String bitePlate;
		private String expansionScrew;
		private String pontic;
		private String crozatClasp;
		private String color;
		private String design;
		
		private String system;
		private String diameter;
		private String style;
		private String marker;
		
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

		
		public void setLocators(String locators) {
			this.locators = locators;
		}
		public void setId(String id) {
			this.id = id;
		}
		public void setReinforcements(String reinforcements) {
			this.reinforcements = reinforcements;
		}
		public void setMould(String mould) {
			this.mould = mould;
		}
		public void setTissueAcrylicShade(String tissueAcrylicShade) {
			this.tissueAcrylicShade = tissueAcrylicShade;
		}
		public void setSportsGuardColor(String sportsGuardColor) {
			this.sportsGuardColor = sportsGuardColor;
		}
		
		
		public void setBallClasp(String ballClasp) {
			this.ballClasp = ballClasp;
		}
		public void setRetentionSpur(String retentionSpur) {
			this.retentionSpur = retentionSpur;
		}
		public void setArrowClasp(String arrowClasp) {
			this.arrowClasp = arrowClasp;
		}
		public void setAdamsClasp(String adamsClasp) {
			this.adamsClasp = adamsClasp;
		}
		public void setCclasp(String cclasp) {
			this.cclasp = cclasp;
		}
		public void setRest(String rest) {
			this.rest = rest;
		}
		public void setSpring(String spring) {
			this.spring = spring;
		}
		public void setLabialWire(String labialWire) {
			this.labialWire = labialWire;
		}
		public void setBitePlate(String bitePlate) {
			this.bitePlate = bitePlate;
		}
		public void setExpansionScrew(String expansionScrew) {
			this.expansionScrew = expansionScrew;
		}
		public void setPontic(String pontic) {
			this.pontic = pontic;
		}
		public void setCrozatClasp(String crozatClasp) {
			this.crozatClasp = crozatClasp;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public void setDesign(String design) {
			this.design = design;
		}
		public void setSystem(String system) {
			this.system = system;
		}
		public void setDiameter(String diameter) {
			this.diameter = diameter;
		}
		public void setStyle(String style) {
			this.style = style;
		}
		public void setMarker(String marker) {
			this.marker = marker;
		}
		
		@Note(name="setTeeth",getValueDescriptionMethod="")
		public String getTeeth_presence() {
			return teeth;
		}
		@Note(name="setShade",getValueDescriptionMethod="getShadeValue",isSplitArray=true)
		public String getShade_presence() {
			return shade;
		}
		@Note(name="setStumpShade",getValueDescriptionMethod="getStumpShadeValue",isSplitArray=true)
		public String getStump_shade_presence() {
			return stumpShade;
		}
		@Note(name="setAlloyMaterial",getValueDescriptionMethod="getAlloyMaterialValue",valueLoadChannel="db")
		public String getAlloy_material_presence() {
			return alloyMaterial;
		}
		@Note(name="setCoping",getValueDescriptionMethod="getCopingValue")
		public String getCoping_presence() {
			return coping;
		}
		@Note(name="setPonticContours",getValueDescriptionMethod="getPonticContoursValue")
		public String getPontic_contours_presence() {
			return ponticContours;
		}
		@Note(name="setMargin",getValueDescriptionMethod="getMarginValue")
		public String getMargin_presence() {
			return margin;
		}
		@Note(name="setRpd",getValueDescriptionMethod="getRpdValue")
		public String getRpd_presence() {
			return rpd;
		}
		@Note(name="setContactsEmbrasures",getValueDescriptionMethod="getContactsEmbrasuresValue")
		public String getContacts_embrasures_presence() {
			return contactsEmbrasures;
		}
		@Note(name="setOcclusalContact",getValueDescriptionMethod="getOcclusalContactValue")
		public String getOcclusal_contact_presence() {
			return occlusalContact;
		}
		@Note(name="setInsufficientRoom",getValueDescriptionMethod="getInsufficientRoomValue")
		public String getInsufficient_room_presence() {
			return insufficientRoom;
		}
		@Note(name="setRetention",getValueDescriptionMethod="getRetentionValue")
		public String getRetention_presence() {
			return retention;
		}
		@Note(name="setMarginPosition",getValueDescriptionMethod="getMarginPositionValue")
		public String getMargin_position_presence() {
			return marginPosition;
		}
		@Note(name="setEmergenceWidth",getValueDescriptionMethod="getEmergenceWidthValue")
		public String getEmergence_width_presence() {
			return emergenceWidth;
		}
		@Note(name="setStaining",getValueDescriptionMethod="getStainingValue")
		public String getStaining_presence() {
			return staining;
		}
		@Note(name="setStainPlacement",getValueDescriptionMethod="getStainPlacementValue")
		public String getStain_placement_presence() {
			return stainPlacement;
		}
		@Note(name="setSurfaceTexture",getValueDescriptionMethod="getSurfaceTextureValue")
		public String getSurface_texture_presence() {
			return surfaceTexture;
		}
		@Note(name="setSurfaceFinish",getValueDescriptionMethod="getSurfaceFinishValue")
		public String getSurface_finish_presence() {
			return surfaceFinish;
		}
		@Note(name="setTranslucencyShade",getValueDescriptionMethod="getTranslucencyShadeValue")
		public String getTranslucency_shade_presence() {
			return translucencyShade;
		}
		@Note(name="setTranslucencyVolume",getValueDescriptionMethod="getTranslucencyVolumeValue")
		public String getTranslucency_volume_presence() {
			return translucencyVolume;
		}
		
		/***
		 * 活动义齿修复类属性
		 */
		@Note(name = "setLocators",getValueDescriptionMethod="")
		public String getLocators_presence() {
			return locators;
		}
		
		@Note(name = "setId",getValueDescriptionMethod="getIdValue")
		public String getId_presence() {
			return id;
		}
	
		@Note(name = "setReinforcements",getValueDescriptionMethod="getReinforcementsValue")
		public String getReinforcements_presence() {
			return reinforcements;
		}
		
		@Note(name = "setMould",getValueDescriptionMethod="")
		public String getMould_presence() {
			return mould;
		}
		
		@Note(name = "setTissueAcrylicShade",getValueDescriptionMethod="getTissueAcrylicShadeValue",valueLoadChannel="db")
		public String getTissueAcrylicShade_presence() {
			return tissueAcrylicShade;
		}
		
		@Note(name = "setSportsGuardColor",getValueDescriptionMethod="getSportsGuardColorValue",valueLoadChannel="db")
		public String getSportsGuardColor_presence() {
			return sportsGuardColor;
		}
		
		
		/***
		 * 口腔矫治器复类属性
		 */
		@Note(name = "setBallClasp")
		public String getBallClasp_presence() {
			return ballClasp;
		}
		@Note(name = "setRetentionSpur")
		public String getRetentionSpur_presence() {
			return retentionSpur;
		}
		@Note(name = "setArrowClasp")
		public String getArrowClasp_presence() {
			return arrowClasp;
		}
		@Note(name = "setAdamsClasp")
		public String getAdamsClasp_presence() {
			return adamsClasp;
		}
		@Note(name = "setCclasp")
		public String getCclasp_presence() {
			return cclasp;
		}
		@Note(name = "setRest")
		public String getRest_presence() {
			return rest;
		}
		@Note(name = "setSpring")
		public String getSpring_presence() {
			return spring;
		}
		@Note(name = "setLabialWire")
		public String getLabialWire_presence() {
			return labialWire;
		}
		@Note(name = "setBitePlate")
		public String getBitePlate_presence() {
			return bitePlate;
		}
		@Note(name = "setExpansionScrew")
		public String getExpansionScrew_presence() {
			return expansionScrew;
		}
		@Note(name = "setPontic")
		public String getPontic_presence() {
			return pontic;
		}
		@Note(name = "setCrozatClasp")
		public String getCrozatClasp_presence() {
			return crozatClasp;
		}
		@Note(name = "setColor",getValueDescriptionMethod="getColorValue",valueLoadChannel="db")
		public String getColor_presence() {
			return color;
		}
		@Note(name = "setDesign",getValueDescriptionMethod="getDesignValue",valueLoadChannel="db")
		public String getDesign_presence() {
			return design;
		}
		
		/***
		 * 种植体修复类属性
		 */
		@Note(name = "setSystem",getValueDescriptionMethod="getSystemValue",valueLoadChannel="db")
		public String getSystem_presence() {
			return system;
		}
		@Note(name = "setDiameter")
		public String getDiameter_presence() {
			return diameter;
		}
		@Note(name = "setStyle")
		@Column(name = "style_presence")
		public String getStyle_presence() {
			return style;
		}
		@Note(name = "setMarker",getValueDescriptionMethod="getMarkerValue",valueLoadChannel="db")
		public String getMarker_presence() {
			return marker;
		}
		
	}
}
