<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<script type="text/javascript">
	$(function() {
		$("#Procedures-group-select").multiselect( {
			selectedList : 4,
			noneSelectedText : "请选择组别"
		});
		$("#ui-multiselect-Procedures-group-select-option-0")
				.click(
						function() {
							var isck = $(
									"#ui-multiselect-Procedures-group-select-option-0")
									.attr('checked') != undefined ? "checked"
									: "false";
							if (isck == 'checked') {
								$("#new-Procedures-group-div").show(500);
							} else {
								$("#new-Procedures-group-div").hide(500);
								$("#procedures-display-group-error-msg").hide(
										500);
							}
						});

		if($("#operation-type-hidden").val()=='add'){
			$("#procedures-Category-Sub-select-li").hide();
			$("#procedures-procedures-Type-select-li").hide();
		}
	});
</script>
<div class="General_middle_bottom_a">
	选择工序
	<input type="hidden" value="${datas.type }" id="operation-type-hidden"/>
</div>
<div class="General_middle_bottom_b">
	<div class="General_middle_bottom_b_top"></div>
	<div class="General_middle_bottom_b_middle">
		<form action="" method="get">
			<ul>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						<span>工序大类</span><span class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select name="" size="1" onchange="getSubCategory(this.value);" id="edit-Procedure-Category-select">
							<option value=""></option>
							<c:forEach items="${datas.pcList}" var="pc">
								<c:choose>
									<c:when test="${pc.id == datas.lpd.proceduresCategoryId }">
										<option id="${pc.id }" value="${pc.id }" key="${pc.categoryName }" selected="selected">
											${pc.nameDesc }
										</option>
									</c:when>
									<c:otherwise>
										<option id="${pc.id }" value="${pc.id }" key="${pc.categoryName }">
											${pc.nameDesc }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>

				<li id="procedures-Category-Sub-select-li">
					<div class="General_middle_bottom_b_middle_left">
						<span>工序子类</span><span class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select name="" size="1" onchange="getProceduresType(this.value);" id="procedures-Category-Sub-select">
							<option value=""></option>
							<c:forEach items="${datas.pscList}" var="psc">
								<c:choose>
									<c:when test="${psc.id == datas.lpd.proceduresCategorySubId }">
										<option value="${psc.id }" selected="selected">
											${psc.nameDesc }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${psc.id }">
											${psc.nameDesc }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>

				<li id="procedures-procedures-Type-select-li">
					<div class="General_middle_bottom_b_middle_left">
						<span>可选工序</span><span class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select name="" size="1" id="procedures-procedures-Type-select">
							<option value=""></option>
							<c:forEach items="${datas.ptList}" var="pt">
								<c:choose>
									<c:when test="${pt.id == datas.lpd.proceduresTypeId }">
										<option value="${pt.id }" selected="selected">
											${pt.nameDesc }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${pt.id }">
											${pt.nameDesc }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>

				<li style="display: none;" id="procedures-select-error-msg">
					<div class="Personalize_b_middle_left">
						&nbsp;
					</div>
					<div class="Personalize_b_middle_right">
						<i class="Addonecuowu_b">创建一个工序，选择一个类别</i>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_middle_bottom_a">
	定义工序
</div>
<div class="General_middle_bottom_b">
	<div class="General_middle_bottom_b_top"></div>
	<div class="General_middle_bottom_b_middle">
		<form action="" method="get">
			<ul>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						<span>定义名称</span><span class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<input name="" type="text" class="Personalize_b_middle_b"
							value="${datas.lpd.displayName }"
							id="edit-Procedure-display-Category-name" />
					</div>
				</li>
				<li style="display: none;" id="procedures-name-error-msg">
					<div class="Personalize_b_middle_left">
						&nbsp;
					</div>
					<div class="Personalize_b_middle_right">
						<i class="Addonecuowu_b">请输入工序的名字</i>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						说明
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<span class="Widgets_a"><textarea name=""
								id="edit-Procedure-display-Description" cols="" rows="">${datas.lpd.displayDescription }</textarea>
						</span>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						定义类型
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select name="" size="1" onchange="isNewCategory(this.value);"
							id="edit-Procedure-display-Category">
							<option value=""></option>
							<option value="new">
								新建类别
							</option>
							<c:forEach items="${datas.pdcList}" var="pdc">
								<c:choose>
									<c:when test="${pdc.id == datas.lpd.categoryId }">
										<option value="${pdc.id }" selected="selected">
											${pdc.name }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${pdc.id }">
											${pdc.name }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<li id="new-Procedures-Category-div" style="display: none;">
						<div class="General_middle_bottom_b_middle_left">
							<span>创建类别</span><span class="General_middle_bottom_b_middle_a">*</span>
						</div>
						<div class="General_middle_bottom_b_middle_right">
							<input name="" type="text"
								id="edit-Procedure-new-display-Category"
								class="Personalize_b_middle_b" />
						</div>
					</li>
					<li style="display: none;"
						id="procedures-display-Category-error-msg">
						<div class="Personalize_b_middle_left">
							&nbsp;
						</div>
						<div class="Personalize_b_middle_right">
							<i class="Addonecuowu_b">请输类别名字</i>
						</div>
					</li>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						定义组别
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select name="" multiple="multiple" id="Procedures-group-select">
							<option value="new">
								新建组别
							</option>
							<c:forEach items="${datas.groupLink}" var="link">
																	 	 ${link.option }
																	    </c:forEach>
						</select>
					</div>
				</li>
				<li id="new-Procedures-group-div" style="display: none;">
					<div class="General_middle_bottom_b_middle_left">
						<span>创建组</span><span class="General_middle_bottom_b_middle_a">*</span>
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<input name="" type="text" id="Procedures-new-group"
							class="Personalize_b_middle_b" />
					</div>
				</li>
				<li style="display: none;" id="procedures-display-group-error-msg">
					<div class="Personalize_b_middle_left">
						&nbsp;
					</div>
					<div class="Personalize_b_middle_right">
						<i class="Addonecuowu_b">请输组名字</i>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						排序
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<div class="DDXDentalPractice_Preferences">
							<div class="DDXDentalPractice_Preferences_left">
								<input name="" type="text" value="${datas.lpd.displaySortRank}"
									id="edit-Procedure-sort-rank" />
							</div>
							<div class="DDXDentalPractice_Preferences_right">
								<div class="DDXDentalPractice_Preferences_right_top">
									<a href="javascript:void(0)"
										onclick="settingNumber('edit-Procedure-sort-rank','plus')"><img
											src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg"
											onclick="settingNumber('edit-Procedure-sort-rank','plus')" />
									</a>
								</div>
								<div class="DDXDentalPractice_Preferences_right_bottom">
									<a href="javascript:void(0)"
										onclick="settingNumber('edit-Procedure-sort-rank','minus')"><img
											src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg"
											onclick="settingNumber('edit-Procedure-sort-rank','minus')" />
									</a>
								</div>
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						计数单位
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select name="" size="1" id="Procedures-display-UnitCoun">
							<c:if test="${datas.lpd.displayUnitCount=='1'}">
								<option value="1" selected="selected">
									通过牙齿
								</option>
								<option value="2">
									通过颌
								</option>
							</c:if>
							<c:if test="${datas.lpd.displayUnitCount=='2'}">
								<option value="1">
									通过牙齿
								</option>
								<option value="2" selected="selected">
									通过颌
								</option>
							</c:if>
							<c:if
								test="${datas.lpd.displayUnitCount!='1' and datas.lpd.displayUnitCount!='2'}">
								<option value="1">
									通过牙齿
								</option>
								<option value="2">
									通过颌
								</option>
							</c:if>
						</select>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_middle_bottom_a">
	周期设定
</div>
<div class="General_middle_bottom_b">
	<div class="General_middle_bottom_b_top"></div>
	<div class="General_middle_bottom_b_middle">
		<form action="" method="get">
			<ul>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						默认周期
					</div>
					<c:choose>
						<c:when test="${datas.lpd.schedulingOverrideDefault=='checked'}">
							<div class="General_middle_bottom_b_middle_right"
								style="text-decoration: line-through" id="default-10-days">
								10 day(s)
							</div>
						</c:when>
						<c:otherwise>
							<div class="General_middle_bottom_b_middle_right"
								id="default-10-days">
								10 day(s)
							</div>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						重设周期
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<c:choose>
							<c:when test="${datas.lpd.schedulingOverrideDefault=='checked'}">
								<input name="" type="checkbox" checked="checked" value=""
									id="isOverrideDays" onclick="showOverride();" />
							</c:when>
							<c:otherwise>
								<input name="" type="checkbox" value="" id="isOverrideDays"
									onclick="showOverride();" />
							</c:otherwise>
						</c:choose>
					</div>
				</li>
				<c:choose>
					<c:when test="${datas.lpd.schedulingOverrideDefault=='checked'}">
						<li id="OverrideDays-li">
					</c:when>
					<c:otherwise>
						<li style="display: none;" id="OverrideDays-li">
					</c:otherwise>
				</c:choose>
				<div class="General_middle_bottom_b_middle_left">
					工序周期
				</div>
				<div class="General_middle_bottom_b_middle_right">
					<div class="DDXDentalPractice_Preferences">
						<div class="DDXDentalPractice_Preferences_left">
							<input name="" type="text"
								value="${datas.lpd.schedulingTurnAroundDays}"
								id="edit-Procedure-TurnAround-days" />
						</div>
						<div class="DDXDentalPractice_Preferences_right">
							<div class="DDXDentalPractice_Preferences_right_top">
								<a href="javascript:void(0)"
									onclick="settingNumber('edit-Procedure-TurnAround-days','plus')"><img
										src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg"
										onclick="settingNumber('edit-Procedure-TurnAround-days','plus')" />
								</a>
							</div>
							<div class="DDXDentalPractice_Preferences_right_bottom">
								<a href="javascript:void(0)"
									onclick="settingNumber('edit-Procedure-TurnAround-days','minus')"><img
										src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg"
										onclick="settingNumber('edit-Procedure-TurnAround-days','minus')" />
								</a>
							</div>
						</div>
					</div>
				</div>
				</li>
				<li>
					如果选择忽略“寄来在途时间”，则默认此工序需要数字印模，且需要被上传
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						寄来在途时间
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<c:choose>
							<c:when test="${datas.lpd.schedulingIgnoreInboundDay=='checked'}">
								<input name="" type="checkbox" checked="checked" value=""
									id="Procedures-Ignore-Inbound" />
							</c:when>
							<c:otherwise>
								<input name="" type="checkbox" value=""
									id="Procedures-Ignore-Inbound" />
							</c:otherwise>
						</c:choose>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						寄回在途时间
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<c:choose>
							<c:when
								test="${datas.lpd.schedulingIgnoreOutboundDay=='checked'}">
								<input name="" type="checkbox" checked="checked" value=""
									id="Procedures-Ignore-Outbound" />
							</c:when>
							<c:otherwise>
								<input name="" type="checkbox" value=""
									id="Procedures-Ignore-Outbound" />
							</c:otherwise>
						</c:choose>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<div class="General_middle_bottom_b_bottom"></div>
</div>
<c:choose>
	<c:when test="${datas.type=='add' and empty datas.lpd.proceduresId}">
		<div class="LabDetails_f_e LabDetails_f_e_center">
			<div class="LabDetails_f_e_left">
				<a href="javascript:void(0)"
					onclick="editProcedure();">保存</a>
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
											onclick="editProcedure('next');">保存并下一步</a>
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
			<a href="javascript:void(0)" onclick="editProcedure()">提交</a>
		</div>
	</c:otherwise>
</c:choose>
