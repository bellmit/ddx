<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type="text/javascript">
	$(function(){
		$("select[name='checkbox-select']").multiselect( {
			selectedList : 4,
			noneSelectedText : "请选择组别"
		});
	});
</script>
<div class="General_middle_bottom_a">
	属性
</div>
<div class="General_middle_bottom_b">
	<div class="General_middle_bottom_b_top"></div>
	<div class="General_middle_bottom_b_middle">
		<form method="get" action="" name="procedure-attributes-form">
			<ul>
				<li class="Attributes" inCategory="Fixed Restoration,Removable Restoration,Orthodontic Appliance,Implant Restoraion">
					牙位
				</li>
				<li inCategory="Fixed Restoration,Removable Restoration,Orthodontic Appliance,Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence" id="procedure-attributes-Teeth-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.teeth_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.teeth_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.teeth_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration,Removable Restoration,Orthodontic Appliance,Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-Teeth-Value" value="${datas.attr.teeth_d_value }">
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration,Removable Restoration">
					牙体颜色
				</li>
				<li inCategory="Fixed Restoration,Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Shade-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.shade_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.shade_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.shade_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration,Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name=""  id="procedure-attributes-Shade-Value">
							<option value=""></option>
							<c:forEach items="${datas.Shade}" var="ss">
								<c:choose>
									<c:when test="${ss.key == datas.attr.shade_d_value}">
										<option value="${ss.key }" selected="selected">
											${ss.value }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${ss.key }">
											${ss.value }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					牙桩颜色
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Stump-Shade-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.stump_shade_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.stump_shade_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.stump_shade_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name=""  id="procedure-attributes-Stump-Shade-Value">
							<option value=""></option>
							<c:forEach items="${datas.StumpShade}" var="ss">
								<c:choose>
									<c:when
										test="${ss.key == datas.attr.stump_shade_d_value}">
										<option value="${ss.key }" selected="selected">
											${ss.value }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${ss.key }">
											${ss.value }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration,Implant Restoraion">
					合金/材料
				</li>
				<li inCategory="Fixed Restoration,Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Alloy-Material-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.alloy_material_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.alloy_material_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.alloy_material_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration,Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select" id="procedure-attributes-Alloy-Material-Value">
								${datas.AlloyMaterial }
							</select>
						</span>
						<span class="NewCase_b_middle_d"><a href="javascript:void(0)" onclick="showProcedureCharacteristic('materials')"></a></span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					内冠
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Coping-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.coping_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.coping_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.coping_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Coping-Value">
								${datas.Coping }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					桥体轮廓
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Pontic_Contours-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.pontic_contours_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.pontic_contours_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.pontic_contours_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Pontic_Contours-Value">
								${datas.PonticContours }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					边距
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Margin-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.margin_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.margin_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.margin_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Margin-Value">
								${datas.Margin }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration,Removable Restoration">
					可摘局部义齿
				</li>
				<li inCategory="Fixed Restoration,Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-RPD-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.rpd_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.rpd_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.rpd_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration,Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-RPD-Value">
								${datas.Rpd }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					接触面/状隙
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Contacts_Embrasures-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.contacts_embrasures_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.contacts_embrasures_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.contacts_embrasures_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Contacts_Embrasures-Value">
								${datas.ContactsEmbrasures }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					咬合面
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Occlusal_Contact-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.occlusal_contact_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.occlusal_contact_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.occlusal_contact_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Occlusal_Contact-Value">
								${datas.OcclusalContac }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					不足空间
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Insufficient_Room-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.insufficient_room_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.insufficient_room_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.insufficient_room_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Insufficient_Room-Value">
								${datas.InsufficientRoom }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					固定方式
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Retention-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.retention_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.retention_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.retention_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Retention-Value">
								${datas.Retention }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					边缘位置
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Margin_Position-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.margin_position_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.margin_position_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.margin_position_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Margin_Position-Value">
								${datas.MarginPosition }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					种植基台露出宽度
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Emergence_Width-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.emergence_width_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.emergence_width_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.emergence_width_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Emergence_Width-Value">
								${datas.EmergenceWidth }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					着色
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Staining-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.staining_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.staining_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.staining_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Staining-Value">
								${datas.Staining }
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					着色点
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Stain_Placement-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.stain_placement_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.stain_placement_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.stain_placement_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Stain_Placement-Value">
								${ datas.StainPlacement}
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					牙面纹理
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Surface_Texture-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.surface_texture_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.surface_texture_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.surface_texture_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Surface_Texture-Value">
								${ datas.SurfaceTexture}
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					牙面处理
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Surface_Finish-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.surface_finish_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.surface_finish_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.surface_finish_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Surface_Finish-Value">
								${ datas.SurfaceFinish}
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					半透明颜色
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Translucency_Shade-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.translucency_shade_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.translucency_shade_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.translucency_shade_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Translucency_Shade-Value">
								${ datas.TranslucencyShade}
							</select>
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Fixed Restoration">
					半透明程度
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Translucency_Volume-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.translucency_volume_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.translucency_volume_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.translucency_volume_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Fixed Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Translucency_Volume-Value">
								${datas.TranslucencyVolume }
							</select>
						</span>
					</div>
				</li>
				
				<!-- 活动义齿修复类属性 begin -->
				<li class="Attributes" inCategory="Removable Restoration">
					定位器
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-locators-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.locators_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.locators_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.locators_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-locators-Value" value="${datas.attr.locators_d_value }">
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Removable Restoration">
					id
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-id-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.id_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.id_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.id_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-id-Value">
								${datas.id }
							</select>
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Removable Restoration">
					加固
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Reinforcements-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.reinforcements_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.reinforcements_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.reinforcements_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-Reinforcements-Value">
								${datas.reinforcements }
							</select>
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Removable Restoration">
					模具
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-Mould-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.mould_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.mould_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.mould_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-Mould-Value" value="${datas.attr.mould_d_value }">
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Removable Restoration">
					胶托颜色
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-tissueAcrylicShade-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.tissueAcrylicShade_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.tissueAcrylicShade_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.tissueAcrylicShade_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-tissueAcrylicShade-Value">
								${datas.tissueAcrylicShade }
							</select>
						</span>
						<span class="NewCase_b_middle_d"><a href="javascript:void(0)" onclick="showProcedureCharacteristic('acrylicColors')"></a></span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Removable Restoration">
					运动牙套颜色
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-sportsGuardColor-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.sportsGuardColor_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.sportsGuardColor_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.sportsGuardColor_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Removable Restoration">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span><select multiple="multiple" name="checkbox-select"  id="procedure-attributes-sportsGuardColor-Value">
								${datas.sportsGuardColor }
							</select>
						</span>
						<span class="NewCase_b_middle_d"><a href="javascript:void(0)"  onclick="showProcedureCharacteristic('sportGuardColors')"></a></span>
					</div>
				</li>
				<!-- 活动义齿修复类属性 end -->
				
				<!-- 口腔矫治器复类属性 begin -->
				<li class="Attributes" inCategory="Orthodontic Appliance">
					球形卡环
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-ballClasp-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.ballClasp_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.ballClasp_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.ballClasp_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-ballClasp-Value" value="${datas.attr.ballClasp_d_value }">
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					保持柱
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-retentionSpur-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.retentionSpur_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.retentionSpur_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.retentionSpur_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-retentionSpur-Value" value="${datas.attr.retentionSpur_d_value}">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					箭形卡环
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-arrowClasp-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.arrowClasp_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.arrowClasp_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.arrowClasp_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-arrowClasp-Value" value="${datas.attr.arrowClasp_d_value}">
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					Adams卡环
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-adamsClasp-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.adamsClasp_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.adamsClasp_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.adamsClasp_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-adamsClasp-Value" value="${datas.attr.adamsClasp_d_value }">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					C 卡环
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-cclasp-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.cclasp_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.cclasp_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.cclasp_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-cclasp-Value" value="${datas.attr.cclasp_d_value }">
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					支架
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-rest-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.rest_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.rest_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.rest_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-rest-Value" value="${datas.attr.rest_d_value }">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					弹簧
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-spring-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.spring_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.spring_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.spring_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-spring-Value" value="${datas.attr.spring_d_value }">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					唇弓丝
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-labialWire-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.labialWire_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.labialWire_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.labialWire_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-labialWire-Value" value="${datas.attr.labialWire_d_value }">
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					咬合托
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-bitePlate-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.bitePlate_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.bitePlate_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.bitePlate_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-bitePlate-Value" value="${datas.attr.bitePlate_d_value }">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					扩张器 螺丝
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-expansionScrew-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.expansionScrew_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.expansionScrew_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.expansionScrew_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-expansionScrew-Value" value="${datas.attr.expansionScrew_d_value }">
						</span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					桥体
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-pontic-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.pontic_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.pontic_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.pontic_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-pontic-Value" value="${datas.attr.pontic_d_value }">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					Crozat卡环
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-crozatClasp-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.crozatClasp_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.crozatClasp_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.crozatClasp_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-crozatClasp-Value" value="${datas.attr.crozatClasp_d_value }">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					颜色
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-color-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.color_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.color_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.color_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<select multiple="multiple" name="checkbox-select"  id="procedure-attributes-color-Value">
							${datas.color }
							</select>
						</span>
						<span class="NewCase_b_middle_d"><a href="javascript:void(0)" onclick="showProcedureCharacteristic('orthodonticColors')"></a></span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Orthodontic Appliance">
					设计
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-design-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.design_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.design_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.design_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Orthodontic Appliance">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<select multiple="multiple" name="checkbox-select"  id="procedure-attributes-design-Value">
							${datas.design }
							</select>
						</span>
						<span class="NewCase_b_middle_d"><a href="javascript:void(0)" onclick="showProcedureCharacteristic('orthodonticDesigns')"></a></span>
					</div>
				</li>
				<!-- 口腔矫治器复类属性 end -->
				
				<!-- 种植体修复类属性 begin -->
				<li class="Attributes" inCategory="Implant Restoraion">
					直径
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-diameter-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.diameter_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.diameter_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.diameter_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-diameter-Value" value="${datas.attr.diameter_d_value }">
						</span>
					</div>
				</li>
				<li class="Attributes" inCategory="Implant Restoraion">
					款式
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-style-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.style_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.style_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.style_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<input type="text" class="Personalize_b_middle_b" name="" id="procedure-attributes-style-Value" value="${datas.attr.style_d_value }">
						</span>
					</div>
				</li>
				
				
				<li class="Attributes" inCategory="Implant Restoraion">
					种植系统
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-system-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.system_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.system_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.system_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<select multiple="multiple" name="checkbox-select"  id="procedure-attributes-system-Value">
							${datas.system }
							</select>
						</span>
						<span class="NewCase_b_middle_d"><a href="javascript:void(0)" onclick="showProcedureCharacteristic('implantSystems')"></a></span>
					</div>
				</li>
				
				<li class="Attributes" inCategory="Implant Restoraion">
					种植标记
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						<span>是否必选</span><span
							class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="presence"  id="procedure-attributes-marker-Presence">
							<option value="NOT_APPLICABLE" <c:if test="${datas.attr.marker_presence=='NOT_APPLICABLE'}">selected="selected"</c:if>>
								不需要
							</option>
							<option value="REQUIRED" <c:if test="${datas.attr.marker_presence=='REQUIRED'}">selected="selected"</c:if>>
								需要
							</option>
							<option value="OPTIONAL" <c:if test="${datas.attr.marker_presence=='OPTIONAL'}">selected="selected"</c:if>>
								可选
							</option>
						</select>
					</div>
				</li>
				<li inCategory="Implant Restoraion">
					<div class="General_middle_bottom_b_middle_left">
						默认值
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span>
							<select multiple="multiple" name="checkbox-select"  id="procedure-attributes-marker-Value">
							${datas.marker }
							</select>
						</span>
						<span class="NewCase_b_middle_d"><a href="javascript:void(0)" onclick="showProcedureCharacteristic('implantMarkers')"></a></span>
					</div>
				</li>
				
				
				<!-- 种植体修复类属性 end -->
				
			</ul>
		</form>
	</div>
	<div class="General_middle_bottom_b_bottom"></div>
</div>
<div style="display: none;" id="lab_DDXDentalPractice_CaseSetting-characteristic">
	<jsp:include page="lab_DDXDentalPractice_CaseSetting-characteristic.jsp"></jsp:include>
</div>
<c:choose>
	<c:when test="${datas.type=='add' and empty datas.attr.attributes_id}">
		<div class="LabDetails_f_e LabDetails_f_e_center">
			<div class="LabDetails_f_e_left">
				<a href="javascript:void(0)"
					onclick="editAttrbutes('','');">保存</a>
			</div>
			<div class="LabDetails_f_e_right">
				<!--小菜单下拉开始-->
				<ol class="menu_all">
					<li class="first">
						<a href="javascript:void(0)"></a>
						<ol class="menuu_s">
							<li>
								<ol class="menu_bgrightcenter">
									<li class="menu_bgrighttop">
										<img
											src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg"
											width="160" height="4" />
									</li>
									<li class="menu_bgright">
										<a href="javascript:void(0)"
											onclick="editAttrbutes('','next');">保存并下一步</a>
									</li>
									<li class="menu_bgrightbottom">
										<img
											src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg"
											width="160" height="4" />
									</li>
								</ol>
							</li>
						</ol>
					</li>
				</ol>
				<!--小菜单下拉结束-->
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="Addone">
			<a href="javascript:void(0)" onclick="editAttrbutes('${datas.attr.attributes_id}','')">提交</a>
		</div>
	</c:otherwise>
</c:choose>