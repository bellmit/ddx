<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>临床详细</title>
<link href="${pageContext.request.contextPath }/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/practice/js/patient.js"></script>
<script type="text/javascript">
	$(function(){
		$('#state').attr('value','${datas.state}')
	});
</script>
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="head-practice.jsp"/> 
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">临床</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
	<jsp:include page="practice-center-left-menu.jsp"/>
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a"></div>




<div class="Personalize">
<div class="Personalize_a" >临床详情</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="Personalize_b_middle_left"><span>临床名称</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input name="name" id="name" value="${datas.name }" type="text" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left">正式名称</div>
<div class="Personalize_b_middle_right"><input name="legalName" id="legalName" value="${datas.legalName }" type="text" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span>地址</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input name="address" id="address" value="${datas.address }" type="text" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left">地址 2</div>
<div class="Personalize_b_middle_right"><input name="address2" id="address2" value="${datas.address2 }" type="text" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span>国家</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
<select name="country" id="country" size="1">
  <option value="中国">中国</option>
</select></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span>省份</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
<select name="state" id="state" size="1">
  <jsp:include page="../state.jsp"></jsp:include>
</select></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span>城市</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input name="city" id="city" value="${datas.city }" type="text" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span>邮编</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input name="zipCode" id="zipCode" value="${datas.zipCode }" type="text" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span>电话</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right"><input name="phoneNumber" id="phoneNumber" value="${datas.phoneNumber }" type="text" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left">传真</div>
<div class="Personalize_b_middle_right"><input name="fax" id="fax" type="text" value="${datas.fax }" class="Personalize_b_middle_b"/></div>
</li>
<li>
<div class="Personalize_b_middle_left">邮箱</div>
<div class="Personalize_b_middle_right"><input name="email" id="email" type="text" value="${datas.email }" class="Personalize_b_middle_b"/></div>
</li>
<!-- 
<li>
<div class="Personalize_b_middle_left"><span>时区</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
<select name="timeZone" id="timeZone" size="1">
  <option value="1" <c:if test="${datas.timeZone eq '1' }">selected="selected"</c:if> >1</option>
  <option value="2" <c:if test="${datas.timeZone eq '2' }">selected="selected"</c:if> >2</option>
  <option value="3" <c:if test="${datas.timeZone eq '3' }">selected="selected"</c:if> >3</option>
  <option value="4" <c:if test="${datas.timeZone eq '4' }">selected="selected"</c:if> >4</option>
  <option value="5" <c:if test="${datas.timeZone eq '5' }">selected="selected"</c:if> >5</option>
</select></div>
</li>
 -->
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Personalize_a">工作时间</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<div class="practicemonthPracticeDetails">
<form action="" method="get">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="hours_of_operation">
<tr class="practicemonthPracticeDetails_e">
<td></td>
<td>星期日</td>
<td>星期一</td>
<td>星期二</td>
<td>星期三</td>
<td>星期四</td>
<td>星期五</td>
<td>星期六</td>
</tr>
<tr>
<td class="practicemonthPracticeDetails_e">营业</td>
<td><input name="hours_open_sun" class="hours_open" id="hours_open_sun" data-day="sun" <c:if test="${datas.sunOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
<td><input name="hours_open_mon" class="hours_open" id="hours_open_mon" data-day="mon" <c:if test="${datas.monOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
<td><input name="hours_open_tue" class="hours_open" id="hours_open_tue" data-day="tue" <c:if test="${datas.tueOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
<td><input name="hours_open_wed" class="hours_open" id="hours_open_wed" data-day="wed" <c:if test="${datas.wedOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
<td><input name="hours_open_thu" class="hours_open" id="hours_open_thu" data-day="thu" <c:if test="${datas.thuOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
<td><input name="hours_open_fri" class="hours_open" id="hours_open_fri" data-day="fri" <c:if test="${datas.friOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
<td><input name="hours_open_sat" class="hours_open" id="hours_open_sat" data-day="sat" <c:if test="${datas.satOpen eq 1 }"> checked = "checked" </c:if> type="checkbox" value="1" /></td>
</tr>
<tr>
<td class="practicemonthPracticeDetails_e">开始</td>
<td><input name="sun" id="hours_from_sun" value="${datas.sunFrom }" <c:if test="${datas.sunOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'hours_to_sun\')}'})"/></td>
<td><input name="mon" id="hours_from_mon" value="${datas.monFrom }" <c:if test="${datas.monOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'hours_to_mon\')}'})"/></td>
<td><input name="tue" id="hours_from_tue" value="${datas.tueFrom }" <c:if test="${datas.tueOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'hours_to_tue\')}'})"/></td>
<td><input name="wed" id="hours_from_wed" value="${datas.wedFrom }" <c:if test="${datas.wedOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'hours_to_wed\')}'})"/></td>
<td><input name="thu" id="hours_from_thu" value="${datas.thuFrom }" <c:if test="${datas.thuOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'hours_to_thu\')}'})"/></td>
<td><input name="fri" id="hours_from_fri" value="${datas.friFrom }" <c:if test="${datas.friOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'hours_to_fri\')}'})"/></td>
<td><input name="sat" id="hours_from_sat" value="${datas.satFrom }" <c:if test="${datas.satOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'hours_to_sat\')}'})"/></td>
</tr>
<tr>
<td class="practicemonthPracticeDetails_e">结束</td>
<td><input name="sun" id="hours_to_sun" value="${datas.sunTo }" <c:if test="${datas.sunOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:'#F{$dp.$D(\'hours_from_sun\')}'})"/></td>
<td><input name="mon" id="hours_to_mon" value="${datas.monTo }" <c:if test="${datas.monOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_mon').val()})"/></td>
<td><input name="tue" id="hours_to_tue" value="${datas.tueTo }" <c:if test="${datas.tueOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_tue').val()})"/></td>
<td><input name="wed" id="hours_to_wed" value="${datas.wedTo }" <c:if test="${datas.wedOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_wed').val()})"/></td>
<td><input name="thu" id="hours_to_thu" value="${datas.thuTo }" <c:if test="${datas.thuOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_thu').val()})"/></td>
<td><input name="fri" id="hours_to_fri" value="${datas.friTo }" <c:if test="${datas.friOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_fri').val()})"/></td>
<td><input name="sat" id="hours_to_sat" value="${datas.satTo }" <c:if test="${datas.satOpen ne 1 }"> disabled = "disabled" </c:if> type="text" class="practicemonthPracticeDetails_d" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm',minDate:$('#hours_from_sat').val()})"/></td>
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
</form>
</div>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Personalize_a">设置</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="Personalize_b_middle_left">证件号码</div>
<div class="Personalize_b_middle_right"><input name="prefCaseLicense" id="prefCaseLicense" value="${datas.prefCaseLicense }" type="text" class="Personalize_b_middle_b"/></div>
</li>
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>

<!-- <div class="Personalize_a">西卡</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="Personalize_b_middle_left"></div>
<div class="Personalize_b_middle_right"><a href="#"></a></div>
</li>
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div> -->

<div class="Personalize_a">主治医生</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="Personalize_b_middle_left">主治医生</div>
<div class="Personalize_b_middle_right">
<!-- 暂时预留 等待同事完成临床用户功能   -->
<select id="provider" multiple="multiple" style="height: 50px;width: 180px;">
</select>

</div>
</li>

</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Personalize_c"><a href="javascript:void(0)" onclick="savePractice();">提交</a></div>

</div>








</div>
</div>
</div>
</div>
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp" /> 
<!--底部结束-->
</div>
</body>
</html>
<script type="text/javascript">
$(function(){
	 $('#hours_of_operation').on('change', '[type=checkbox]', function(){
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
	 
	 //加载提供者
	 loadProviders();
	 
});

/**
 * 加载提供者
 */
function loadProviders(){
	$.get(
		"${pageContext.request.contextPath}/practiceAction/loadProviders.do", 
		null,
	   function(data){
			 var json = eval(data);
			 var providerStr = '${datas.providers}';
			 var providerArry = providerStr.split(',');
			 var str = '';
			 $.each(json, function (index, item) {
				if(json == undefined){
					return;
				} 
				var accountId = json[index].accountId;
				var	name =(json[index].salutation==null?'':json[index].salutation) + json[index].firstName + json[index].lastName;
				var flag = false;
				 for(var i=0;i<providerArry.length;i++){
					 if(providerArry[i] == accountId){
						flag = true;
						break;
					 }
				 }
				 
				 if(flag){
					 str += '<option value="'+ accountId +'" selected="selected">'+ name +'</option>';
				 }else{
					 if(json.length==1){
						 str += '<option value="'+ accountId +'" selected="selected">'+ name +'</option>';
					 }else{
						 str += '<option value="'+ accountId +'">'+ name +'</option>';						 
					 }
				 }
			 });
			 if(str != ''){
				 $('#provider').html(str);
			 }
	  });
}

</script>
