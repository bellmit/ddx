<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>订单设置</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/lab/css/lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting-general.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting-procedures.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting-procedure_Characteristics.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting-coupons.js"></script>
</head>

<body onload="init('${menu }','${item }');"> 
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp" />
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">设置</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="../left.jsp" />
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">订单设置</div>
<div class="LabCaseSetting">
<div class="LabCaseSetting_a">
<ul>
<li class="LabCaseSetting_a_a"><a href="javascript:void(0)" onclick="$('#show-case-setting-menu-div').html($('#case-setting-menu-General').html());">一般情况</a></li>
<li class="LabCaseSetting_a_b"><a href="javascript:void(0)" onclick="$('#show-case-setting-menu-div').html($('#case-setting-menu-Procedures').html());">工序</a></li>
<li class="LabCaseSetting_a_c"><a href="javascript:void(0)" onclick="$('#show-case-setting-menu-div').html($('#case-setting-menu-Procedure_Characteristics').html());">工序特征</a></li>
<li class="LabCaseSetting_a_d"><a href="javascript:void(0)" onclick="$('#show-case-setting-menu-div').html($('#case-setting-menu-Coupons').html());">优惠劵</a></li>
</ul>
</div>
<jsp:include page="caseSettingMenu.jsp" />
<!-- 菜单填充 -->
<div class="LabCaseSetting_b" id="show-case-setting-menu-div">
<ul>
	<li><a href="javascript:void(0)" onclick="query('schedulingAndHolidays');">时间设定</a></li>
	<li><a href="javascript:void(0)" onclick="query('remakeTypes');">返工类型</a></li>
	<li><a href="javascript:void(0)" onclick="query('shippingTypes');">物流方案</a></li>
	<li><a href="javascript:void(0)" onclick="query('onHoldTypes');">搁置类型</a></li>
	<li><a href="javascript:void(0)" onclick="query('terms');">治疗条款</a></li>
	</ul>
</div>
</div>
<!-- 内容填充 -->
<div class="LabCaseSetting" id="show-case-setting-content-div"></div>
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

