<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>服务机构</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/lab/css/lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/practices.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/practices-service.js"></script>
</head>
<script type="text/javascript">
	function refresh(type){
		$("#search-lab-practices").val("");
		listLabAndPractices('1',type);
	}
</script>
<body onload="myCooperationPractices('${initId }','${initType }');"> 
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp"/>

<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">设置</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="../left.jsp"/>
</div>
<div class="Cases_bottom_right" id="show-Cooperation-Practices-div">
<div class="LabCaseSetting_a">
<ul>
<li class="LabCaseSetting_a_b"><a href="javascript:void(0)" onclick="refresh('1');">技工间</a></li>
<li class="LabCaseSetting_a_a"><a href="javascript:void(0)" onclick="refresh('2');">临床</a></li>
</ul>
</div>
<div class="Settings_Practices">
<div class="Settings_Practices_top"></div>
<div class="Settings_Practices_middle" id="lab-practices-list-div">
	<jsp:include page="u_lab_Settings_Practices-div.jsp"/>
</div>
<div class="Settings_Practices_bottom"></div>
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
<script type="text/javascript" language="javascript">
$(".LabCaseSetting_a li ").live("click",function(){
	$(".LabCaseSetting_a li a").css({"backgroundColor":"none","color":"#000"});
		$("a",this).css({"backgroundColor":"none","color":"#1591f9"});
	});
</script>
</body>
</html>
