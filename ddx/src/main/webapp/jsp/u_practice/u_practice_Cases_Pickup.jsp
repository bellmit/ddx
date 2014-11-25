<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>取件服务</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_practice/css/u_practice.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/u_lab_cases.js"></script>
</head>

<body> 
<div class="page">
<!--头部开始-->
<jsp:include page="../head-dashboard.jsp" />
<!--头部结束--> 
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<input type="hidden" id="reqAccLabId" value="${requestAccountLab.id}"/>

<div class="Cases">
<div class="Cases_top">订单</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<ul>
<jsp:include page="../practice/menu-left-unit-operating-authority.jsp"></jsp:include>
</ul>
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">取件服务</div>
<div class="practiceCasesPickup">
<div class="practiceCasesPickup_a">订单回寄要求</div>
<div class="practiceCasesPickup_b">
<div class="practiceCasesPickup_b_top"></div>
<div class="practiceCasesPickup_b_middle">
<form action="" method="post">
<ul>
<li>
<div class="practiceCasesPickup_b_middle_left"><span>取件日期</span><span class="practiceCasesPickup_b_middle_a">*</span></div>
<div class="practiceCasesPickup_b_middle_right"><span><input name="" id="rqDate" type="text" class="practiceCasesPickup_b_middle_b" readonly="readonly"/></span><span class="practiceCasesPickup_b_middle_c"><a href="javascript:void(0)" onclick="WdatePicker({el:'rqDate'})"></a></span></div>
</li>
<li id="rqDate_info" style="display: none;">
<div class="practiceCasesPickup_b_middle_left"><span>&nbsp;</span></div>
<div class="practiceCasesPickup_b_middle_right"><i class="Addonecuowu_b">日期不能为空</i></span></div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left"><span>最早取件时间</span><span class="practiceCasesPickup_b_middle_a">*</span></div>
<div class="practiceCasesPickup_b_middle_right"><span><input name="" type="text" id="rqTime" class="practiceCasesPickup_b_middle_b" readonly="readonly"/></span><span class="practiceCasesPickup_b_middle_d"><a href="javascript:void(0)" onclick="WdatePicker({el:'rqTime',dateFmt:'HH:mm:ss'})"></a></span></div>
</li>
<li id="rqTime_info" style="display: none;">
<div class="practiceCasesPickup_b_middle_left"><span>&nbsp;</span></div>
<div class="practiceCasesPickup_b_middle_right"><i class="Addonecuowu_b">最早取件时间不能为空</i></span></div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left">&nbsp;</div>
<div class="practiceCasesPickup_b_middle_right"><span class="practiceCasesPickup_b_middle_e"><a href="javascript:void(0)" onclick="pickup();">提交</a></span></div>
</li>
</ul>
</form>
</div>
<div class="practiceCasesPickup_b_bottom"></div>
</div>
<div class="practiceCasesPickup_a">工作日</div>
<div class="practiceCasesPickup_b">
<div class="practiceCasesPickup_b_top"></div>
<div class="practiceCasesPickup_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="practiceCasesPickup_b_middle_left">星期天</div>
<div class="practiceCasesPickup_b_middle_right">
<span>
<c:choose>
	<c:when test="${practice.sunOpen eq 1 }">
		${practice.sunFrom } ~ ${practice.sunTo }
	</c:when>
	<c:otherwise>
		关闭	
	</c:otherwise>
</c:choose>
</span>
</div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left">星期一</div>
<div class="practiceCasesPickup_b_middle_right">
<span>
<c:choose>
	<c:when test="${practice.monOpen eq 1 }">
		${practice.monFrom } ~ ${practice.monTo }
	</c:when>
	<c:otherwise>
		关闭	
	</c:otherwise>
</c:choose>
</span>
</div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left">星期二</div>
<div class="practiceCasesPickup_b_middle_right">
<span>
<c:choose>
	<c:when test="${practice.tueOpen eq 1 }">
		${practice.tueFrom } ~ ${practice.tueTo }
	</c:when>
	<c:otherwise>
		关闭	
	</c:otherwise>
</c:choose>
</span>
</div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left">星期三</div>
<div class="practiceCasesPickup_b_middle_right">
<span>
<c:choose>
	<c:when test="${practice.wedOpen eq 1 }">
		${practice.wedFrom } ~ ${practice.wedTo }
	</c:when>
	<c:otherwise>
		关闭	
	</c:otherwise>
</c:choose>
</span>
</div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left">星期四</div>
<div class="practiceCasesPickup_b_middle_right">
<span>
<c:choose>
	<c:when test="${practice.thuOpen eq 1 }">
		${practice.thuFrom } ~ ${practice.thuTo }
	</c:when>
	<c:otherwise>
		关闭	
	</c:otherwise>
</c:choose>
</span>
</div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left">星期五</div>
<div class="practiceCasesPickup_b_middle_right">
<span>
<c:choose>
	<c:when test="${practice.friOpen eq 1 }">
		${practice.friFrom } ~ ${practice.friTo }
	</c:when>
	<c:otherwise>
		关闭	
	</c:otherwise>
</c:choose>
</span>
</div>
</li><li>
<div class="practiceCasesPickup_b_middle_left">星期六</div>
<div class="practiceCasesPickup_b_middle_right">
<span>
<c:choose>
	<c:when test="${practice.satOpen eq 1 }">
		${practice.satFrom } ~ ${practice.satTo }
	</c:when>
	<c:otherwise>
		关闭	
	</c:otherwise>
</c:choose>
</span>
</div>
</li>
<li>
<div class="practiceCasesPickup_b_middle_left">&nbsp;</div>
<div class="practiceCasesPickup_b_middle_right"><span class="practiceCasesPickup_b_middle_f"><a href="javascript:void(0)" onclick="showHoursEditDialog();">编辑时间</a></span></div>
</li>
<li><i>此处设定的时间是合作技工间可上门取件的时间</i></li>
</ul>
</form>
</div>
<div class="practiceCasesPickup_b_bottom"></div>
</div>
</div>
</div>
</div>
</div>
</div>
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp"/>
<!--底部结束-->
</div>
</body>
</html>

<div id="edit_hours_dialog" style="display: none;">
<div class="box_edithourscontent">
<h1>营业时间</h1>
<div class="box_edithourscontenttop">
<div class="box_edithourscontentbottomleft"></div>
<div class="box_edithourscontentbottomcenter"></div>
<div class="box_edithourscontentbottomright"></div>
</div>
<div class="box_clear"></div>
<div class="box_edithourscontentcenter">
<table width="610" border="0" class="box_edithourscontenttable">
  <tr>
    <td>&nbsp;</td>
    <td class="box_edithourscontentbold">星期天</td>
    <td class="box_edithourscontentbold">星期一</td>
    <td class="box_edithourscontentbold">星期二</td>
    <td class="box_edithourscontentbold">星期三</td>
    <td class="box_edithourscontentbold">星期四</td>
    <td class="box_edithourscontentbold">星期五</td>
    <td class="box_edithourscontentbold">星期六</td>
  </tr>
  <tr>
    <td class="box_edithourscontentbold">打开</td>
    <td><input name="hours_open_sun" class="hours_open" id="hours_open_sun" data-day="sun" <c:if test="${practice.sunOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
	<td><input name="hours_open_mon" class="hours_open" id="hours_open_mon" data-day="mon" <c:if test="${practice.monOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
	<td><input name="hours_open_tue" class="hours_open" id="hours_open_tue" data-day="tue" <c:if test="${practice.tueOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
	<td><input name="hours_open_wed" class="hours_open" id="hours_open_wed" data-day="wed" <c:if test="${practice.wedOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
	<td><input name="hours_open_thu" class="hours_open" id="hours_open_thu" data-day="thu" <c:if test="${practice.thuOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
	<td><input name="hours_open_fri" class="hours_open" id="hours_open_fri" data-day="fri" <c:if test="${practice.friOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
	<td><input name="hours_open_sat" class="hours_open" id="hours_open_sat" data-day="sat" <c:if test="${practice.satOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
  </tr>
  <tr>
    <td class="box_edithourscontentbold">来自</td>
    <td><input name="sun" id="hours_from_sun" value="${practice.sunFrom }" <c:if test="${practice.sunOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:$('#hours_to_sun').val()})"/></td>
	<td><input name="mon" id="hours_from_mon" value="${practice.monFrom }" <c:if test="${practice.monOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:$('#hours_to_mon').val()})"/></td>
	<td><input name="tue" id="hours_from_tue" value="${practice.tueFrom }" <c:if test="${practice.tueOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:$('#hours_to_tue').val()})"/></td>
	<td><input name="wed" id="hours_from_wed" value="${practice.wedFrom }" <c:if test="${practice.wedOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:$('#hours_to_wed').val()})"/></td>
	<td><input name="thu" id="hours_from_thu" value="${practice.thuFrom }" <c:if test="${practice.thuOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:$('#hours_to_thu').val()})"/></td>
	<td><input name="fri" id="hours_from_fri" value="${practice.friFrom }" <c:if test="${practice.friOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:$('#hours_to_fri').val()})"/></td>
	<td><input name="sat" id="hours_from_sat" value="${practice.satFrom }" <c:if test="${practice.satOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:$('#hours_to_sat').val()})"/></td>
  </tr>
  <tr>
    <td class="box_edithourscontentbold">到</td>
    <td><input name="sun" id="hours_to_sun" value="${practice.sunTo }" <c:if test="${practice.sunOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_sun').val()})"/></td>
	<td><input name="mon" id="hours_to_mon" value="${practice.monTo }" <c:if test="${practice.monOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_mon').val()})"/></td>
	<td><input name="tue" id="hours_to_tue" value="${practice.tueTo }" <c:if test="${practice.tueOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_tue').val()})"/></td>
	<td><input name="wed" id="hours_to_wed" value="${practice.wedTo }" <c:if test="${practice.wedOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_wed').val()})"/></td>
	<td><input name="thu" id="hours_to_thu" value="${practice.thuTo }" <c:if test="${practice.thuOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_thu').val()})"/></td>
	<td><input name="fri" id="hours_to_fri" value="${practice.friTo }" <c:if test="${practice.friOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_fri').val()})"/></td>
	<td><input name="sat" id="hours_to_sat" value="${practice.satTo }" <c:if test="${practice.satOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="hour_range" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_sat').val()})"/></td>
  </tr>
  <tr id="hours_error_tr">
      <td id="hours_error" colspan="8">
      	<label id="hours_from_sun_error" style="display: none;" class="error">星期天开始时间必须设置</label>
      	<label id="hours_to_sun_error" style="display: none;" class="error">星期天结束时间必须设置</label>
      	
      	<label id="hours_from_mon_error" style="display: none;" class="error">星期一开始时间必须设置</label>
      	<label id="hours_to_mon_error" style="display: none;" class="error">星期一结束时间必须设置</label>
      	
      	<label id="hours_from_tue_error" style="display: none;" class="error">星期二 开始时间必须设置</label>
      	<label id="hours_to_tue_error" style="display: none;" class="error">星期二结束时间必须设置</label>
      	
      	<label id="hours_from_wed_error" style="display: none;" class="error">星期三开始时间必须设置</label>
      	<label id="hours_to_wed_error" style="display: none;" class="error">星期三结束时间必须设置</label>
      	
      	<label id="hours_from_thu_error" style="display: none;" class="error">星期四开始时间必须设置</label>
      	<label id="hours_to_thu_error" style="display: none;" class="error">星期四结束时间必须设置</label>
      	
      	<label id="hours_from_fri_error" style="display: none;" class="error">星期五开始时间必须设置</label>
      	<label id="hours_to_fri_error" style="display: none;" class="error">星期五结束时间必须设置</label>
      	
      	<label id="hours_from_sat_error" style="display: none;" class="error">星期六开始时间必须设置</label>
      	<label id="hours_to_sat_error" style="display: none;" class="error">星期六结束时间必须设置</label>
      </td>
  </tr>
</table>
<div style="height:30px;"></div>
</div>
<div class="box_clear"></div>
<div class="box_edithourscontentbottom">
<div class="box_edithourscontentbottomleft01"></div>
<div class="box_edithourscontentbottomcenter01"></div>
<div class="box_edithourscontentbottomright01"></div>
</div>
</div>
</div>

<script type="text/javascript">
	$(function(){
		
		$('.box_edithourscontenttable').on('change', '[type=checkbox]', function(){
		    var $this = $(this);

		    if (!$this.is(':checked')) {
		        var day = $this.data('day');

		        if (day && day.length) {
		            $('#hours_from_' + day + ', #hours_to_' + day).val('').attr('disabled', 'disabled');
		        }
		    } else {
		        var day = $this.data('day');

		        if (day && day.length) {
		            $('#hours_from_' + day + ', #hours_to_' + day).removeAttr('disabled');
		        }
		    }
		});

	});
</script>
