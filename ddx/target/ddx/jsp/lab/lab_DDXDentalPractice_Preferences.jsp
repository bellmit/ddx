<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="General_middle_bottom_a">物流类型</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form method="get" action="">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left"><span>默认物流类型</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right">
	<select size="1" name="" id="practice-service-shipping">
		<option value="">---请选择快递服务---</option>
		<c:forEach items="${datas.casesShipping}" var="sh">
			<c:choose>
				<c:when test="${datas.labPracticePreferences.shippingId == sh.id}">
					<option value="${sh.id }" selected="selected">${sh.service }</option>
				</c:when>
				<c:otherwise>
					<option value="${sh.id }">${sh.service }</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</div>
</li>
<li style="display: none;" id="practice-service-shipping-ps">
<div class="General_middle_bottom_b_middle_left"><span></span><span class="General_middle_bottom_b_middle_a"></span></div>
<div class="General_middle_bottom_b_middle_right"  id="Outbound_Transit_Days_value-title"><i class="center_e" style="color: red;">请选择快递服务，如果还没有，请至->订单设置->添加运送类型</i></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">重定义在途时间</div>
<div class="General_middle_bottom_b_middle_right">
			<c:choose>
				<c:when test="${datas.labPracticePreferences.overrideTransitTime == 'true'}">
					<input type="checkbox" id="isOverrideTransitTime" checked="checked" value="" name="" onclick="overrideTransitTime();">
				</c:when>
				<c:otherwise>
					<input type="checkbox" id="isOverrideTransitTime" value="" name="" onclick="overrideTransitTime();">
				</c:otherwise>
			</c:choose>
</div>
</li>
<c:choose>
	<c:when test="${datas.labPracticePreferences.overrideTransitTime == 'true'}">
		<li id="Inbound_Transit_Days">
	</c:when>
	<c:otherwise>
		<li style="display: none;" id="Inbound_Transit_Days">
	</c:otherwise>
</c:choose>
<div class="General_middle_bottom_b_middle_left">寄来在途时间</div>
<div class="General_middle_bottom_b_middle_right">
<div class="DDXDentalPractice_Preferences">
<div class="DDXDentalPractice_Preferences_left"><input type="text" name="" id="Inbound_Transit_Days_value" value="${datas.labPracticePreferences.inboundTransitDays }"></div>
<div class="DDXDentalPractice_Preferences_right">
<div class="DDXDentalPractice_Preferences_right_top"><a href="javascript:void(0)" onclick="settingNumber('Inbound_Transit_Days_value','plus');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg"></a></div>
<div class="DDXDentalPractice_Preferences_right_bottom"><a href="javascript:void(0)" onclick="settingNumber('Inbound_Transit_Days_value','minus');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg"></a></div>
</div>
</div>
<div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="Inbound_Transit_Days_value-title"><i class="center_e" style="color: red;">请输数字</i></div>
</div>
</li>

<c:choose>
	<c:when test="${datas.labPracticePreferences.overrideTransitTime == 'true'}">
		<li id="Outbound_Transit_Days">
	</c:when>
	<c:otherwise>
		<li style="display: none;" id="Outbound_Transit_Days">
	</c:otherwise>
</c:choose>
<div class="General_middle_bottom_b_middle_left">回寄在途时间</div>
<div class="General_middle_bottom_b_middle_right">
<div class="DDXDentalPractice_Preferences">
<div class="DDXDentalPractice_Preferences_left"><input type="text" name="" id="Outbound_Transit_Days_value" value="${datas.labPracticePreferences.outboundTransitDays }"></div>
<div class="DDXDentalPractice_Preferences_right">
<div class="DDXDentalPractice_Preferences_right_top"><a href="javascript:void(0)" onclick="settingNumber('Outbound_Transit_Days_value','plus');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg"></a></div>
<div class="DDXDentalPractice_Preferences_right_bottom"><a href="javascript:void(0)" onclick="settingNumber('Outbound_Transit_Days_value','minus');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg"></a></div>
</div>
</div>
<div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="Outbound_Transit_Days_value-title"><i class="center_e" style="color: red;">请输数字</i></div>
</div>
</li>

</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_middle_bottom_a">价格政策</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form method="get" action="">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left"><span>报价单组别</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right">
	<select size="1" name="" id="practice-service-labPriceGroup">
	  <option value="">---请选择组别---</option>
	  <c:forEach items="${datas.labPriceGroup}" var="price">
			<c:choose>
				<c:when test="${datas.labPracticePreferences.priceGroupId==price.id}">
					<option value="${price.id }" selected="selected">${price.name }</option>
				</c:when>
				<c:otherwise>
					<option value="${price.id }">${price.name }</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</div>
</li>
<li style="display: none;" id="practice-service-labPriceGroup-ps">
<div class="General_middle_bottom_b_middle_left"><span></span><span class="General_middle_bottom_b_middle_a"></span></div>
<div class="General_middle_bottom_b_middle_right"  id="Outbound_Transit_Days_value-title"><i class="center_e" style="color: red;">请选择正确的价格组别，如果还没有组别请先创建工序，添加价格-创建价格组</i></div>
</li>

</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_middle_bottom_a">工序服务</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form method="get" action="">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left">工序组别</div>
<div class="General_middle_bottom_b_middle_right">
<select size="1" name="" id="practice-service-labProceduresGroup">
	<option value="0">---请选择工序组别---</option>
  <c:forEach items="${datas.labProceduresGroup}" var="proced">
			<c:choose>
				<c:when test="${datas.labPracticePreferences.proceduresGroupId==proced.id}">
					<option value="${proced.id }" selected="selected">${proced.name }</option>
				</c:when>
				<c:otherwise>
					<option value="${proced.id }">${proced.name }</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
</select></div>
</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="Addone"><a href="javascript:void(0)" onclick="saveLabPracticePreferences('${datas.labPracticePreferences.id}','${datas.unitId }','${datas.unitType }')">保存</a></div>