<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="Cases_bottom_right_a">时间设定</div>
<div class="Personalize">
<div class="Personalize_a">一般情况</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form method="get" action="">
<ul>
<li>
<div class="Personalize_b_middle_left"><span>工作日</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input type="hidden" id="SchedulingId" value="${datas.csh.id }"></div>
<div class="Personalize_b_middle_right"><input type="hidden" id="SchedulingLabId" value="${datas.csh.labid }"></div>
<div class="Personalize_b_middle_right"><input type="hidden" id="SchedulingHoliday" value="${datas.csh.holidays }">
<dl>
<dt><span>
<c:choose>
		<c:when test="${datas.monday.monday==true}">
			<input type="checkbox" value="" name="" id="monday" checked="checked">
		</c:when>
		<c:otherwise>
			<input type="checkbox" value="" name="" id="monday">
		</c:otherwise>
</c:choose>
</span><span>星期一</span></dt>
<dt><span>
<c:choose>
		<c:when test="${datas.monday.tuesday==true}">
			<input type="checkbox" value="" name="" id="tuesday" checked="checked">
		</c:when>
		<c:otherwise>
			<input type="checkbox" value="" name="" id="tuesday">
		</c:otherwise>
</c:choose>
</span><span>星期二</span></dt>
<dt><span>
<c:choose>
		<c:when test="${datas.monday.wednesday==true}">
			<input type="checkbox" value="" name="" id="wednesday" checked="checked">
		</c:when>
		<c:otherwise>
			<input type="checkbox" value="" name="" id="wednesday">
		</c:otherwise>
</c:choose>
</span>
<span>星期三</span></dt>
<dt><span>
<c:choose>
		<c:when test="${datas.monday.thursday==true}">
			<input type="checkbox" value="" name="" id="thursday" checked="checked">
		</c:when>
		<c:otherwise>
			<input type="checkbox" value="" name="" id="thursday">
		</c:otherwise>
	</c:choose>
	</span>
<span>星期四</span></dt>
<dt><span>
<c:choose>
	<c:when test="${datas.monday.friday==true}">
		<input type="checkbox" value="" name="" id="friday" checked="checked">
	</c:when>
	<c:otherwise>
			<input type="checkbox" value="" name="" id="friday">
		</c:otherwise>
</c:choose>
</span>
<span>星期五</span></dt>
<dt><span>
<c:choose>
		<c:when test="${datas.monday.saturday==true}">
			<input type="checkbox" value="" name="" id="saturday" checked="checked">
		</c:when>
		<c:otherwise>
			<input type="checkbox" value="" name="" id="saturday">
		</c:otherwise>
</c:choose>
</span>
<span>星期六</span></dt>
<dt><span>
<c:choose>
		<c:when test="${datas.monday.sunday==true}">
			<input type="checkbox" value="" name="" id="sunday" checked="checked">
		</c:when>
		<c:otherwise>
			<input type="checkbox" value="" name="" id="sunday">
		</c:otherwise>
</c:choose>
</span>
<span>星期天</span></dt>
</dl>
</div>
</li>
<li>
<div class="Personalize_b_middle_left"><span id="">下班时间</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input type="text"  readonly="readonly" class="Personalize_b_middle_b" name="" value="${datas.csh.cutofftime }"  id="cut_off_time"  onclick="WdatePicker({el:'cut_off_time',dateFmt:'H:mm:ss'})"/></div>
</li>
<li>
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right" style="display: none" id="cut_off_time_error"><i class="Addonecuowu_b">请输入一个正确的时间</i></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span id="">订单工期</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
<div class="Scan_b_middle_right_left_b_top">
<div class="Scan_b_middle_right_left_b_top_left">
<c:choose>
		<c:when test="${datas.csh.caseturnaround==null}">
<input type="text" name="0"  id="case_turn_around" onkeyup="this.value=this.value.replace(/\D/g,'')">
</c:when>
<c:otherwise>
	<input type="text" name="" value="${datas.csh.caseturnaround }" id="case_turn_around" onkeyup="this.value=this.value.replace(/\D/g,'')">
</c:otherwise>
</c:choose>
</div>
<div class="Scan_b_middle_right_left_b_top_right">
<div class="Scan_b_middle_right_left_b_top_right_top"><a href="javascript:void(0)" onclick="settingNumber('case_turn_around','plus')"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg"></a></div>
<div class="Scan_b_middle_right_left_b_top_right_bottom"><a href="javascript:void(0)" onclick="settingNumber('case_turn_around','minus')" ><img src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg"></a></div>
</div>
</div>
</div>
<div class="Personalize_b_middle_right" style="display: none;" id="error_turn_around"><i class="Addonecuowu_b">输入的病例周转日期只能是整数</i></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span id="">取单说明</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input type="text" class="Addone_a" name="" value="${datas.csh.pickupinstructions }" id="pick_up_instructions"></div>
</li>
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Personalize_a">假期安排</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form method="get" action="">
<div class="General_SchedulingHolidays">
<div class="General_SchedulingHolidays_top">时间</div>
<div class="General_SchedulingHolidays_middle">
<ol>
<li>
<div class="General_SchedulingHolidays_middle_left">
<c:choose>
		<c:when test="${!empty datas.holidays}">
			<table width="50%" border="0" cellspacing="0" cellpadding="0" id="add_holidays_table">
				<c:forEach items="${datas.holidays }" var="ho" varStatus="status">
					<tr id="${ho}">
					<td>${ho} </td>
					<td><div class="General_SchedulingHolidays_middle_right" id="add-holidays-two"><a href="javascript:void(0)" onclick="deleteHoliday('${ho}')" ></a></div></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<table width="50%" border="0" cellspacing="0" cellpadding="0" id="add_holidays_table">
			</table>
			<div id="undefind-holiday">
			<span id="temp-add-hidden">您还未定义节假日</span>
			<span><a href="javascript:void(0)" onclick="showAddHoilDialog();">增加一个</a></span>
			</div>
		</c:otherwise>
</c:choose>
</div>
</li>
</ol>
</div>
<div class="General_SchedulingHolidays_bottom"><a href="javascript:void(0)" onclick="showAddHoilDialog();"></a></div>
</div>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Addone"><a href="javascript:void(0)" onclick="saveSchedulingHolidays()">保存</a></div>
</div>
<div id="temp-add-holi-hidden-div" style="display: none;">
	<input type="text" readonly="readonly" id="temp-add-holi-hidden" onclick="WdatePicker({el:'temp-add-holi-hidden',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d}'})"/>
</div>
