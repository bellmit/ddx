<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a_left">${datas.plab.name }</div>
<div class="Cases_bottom_right_a_right">
 <!--小菜单下拉开始-->
		<ol class="menu_all">
     <li class="first first01">
		<a href="javascript:void(0)">操作</a>    
	     <ol id="menuu_s01" class="menuu_s">
		     <li style=" width:160px;">
		       <ol class="menu_bgrightcenter">
				<li class="menu_bgrighttop" style="width: 158px;"><img
					src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg"
					width="160" height="4" />
				</li>

				<li class="menu_bgrighttop01" style="width: 153px;padding-left: 5px;">患者</li>
				<li class="menu_bgrighttop01" style="width: 158px;padding-bottom: 10px;"><a
					href="${pageContext.request.contextPath}/labAction/reports/patientsByPractice.do?unitId=${datas.plab.id}&&unitType=${datas.type}">所有患者</a></li>
				<li class="menu_bgrighttop01"
					style="padding-left: 5px;width: 153px; border-top: 1px solid #CCCCCC;">报告</li>
				<li class="menu_bgrighttop01" style="width: 158px;padding-bottom: 10px;"><a
					href="${pageContext.request.contextPath}/labAction/reports/queryCaseRemake.do?unitId=${datas.plab.id}&&unitType=${datas.type}">重制订单</a></li>

				<li class="menu_bgrightbottom"><img
					src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg"
					width="160" height="4" />
				</li>
			</ol>
		     </li>
	     </ol>
     </li>
</ol>
</div>
<div class="General">
<div class="General_top"></div>
<div class="General_middle">
<div class="General_middle_top">
<ul>
	<li class="Lab_DDXDentalPractice_a"><a href="javascript:void(0)" onclick="$('#my-cooperation-lab-div').html($('#my-cooperation-lab-Details').html())">详细情况</a></li>
	<li class="Lab_DDXDentalPractice_b"><a href="javascript:void(0)" onclick="query('practicePreferences','${datas.plab.id}',${datas.type })">首要信息</a></li>
	<li class="Lab_DDXDentalPractice_c"><a href="javascript:void(0)" onclick="query('practiceContacts','${datas.plab.id}',${datas.type })">联系人</a></li>
	<li class="Lab_DDXDentalPractice_d"><a href="javascript:void(0)" onclick="query('practiceNotes','${datas.plab.id}',${datas.type })">备注</a></li>
	<li class="Lab_DDXDentalPractice_e"><a href="javascript:void(0)" onclick="query('practicePriceList','${datas.plab.id}',${datas.type })">报价表</a></li>
</ul>
</div>
<div class="General_middle_bottom" id="my-cooperation-lab-div">
	<jsp:include page="lab_DDXDentalPractice_Details.jsp"/>
</div>
<div style="display: none;" id="my-cooperation-lab-Details" >
	<jsp:include page="lab_DDXDentalPractice_Details.jsp"/>
</div>
</div>
<div class="General_bottom"></div>
</div>
</div>