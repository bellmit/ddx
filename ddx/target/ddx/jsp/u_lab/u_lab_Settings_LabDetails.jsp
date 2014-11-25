<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>技工间详细</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/lab-details.js"></script>
</head>

<body onload="loadLabDetailsInfo('labAction/setting/general.do');"> 
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
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">我的技工间</div>
<div class="General">
<div class="General_top"></div>
<div class="General_middle">
<div class="General_middle_top">
<ul>
<li class="General_middle_top_a"><a href="javascript:void(0)" onclick="loadLabDetailsInfo('labAction/setting/general.do');">一般情况</a></li>
<li class="General_middle_top_b"><a href="javascript:void(0)" onclick="loadLabDetailsInfo('labAction/setting/preferences.do');">首要</a></li>
<li class="General_middle_top_c"><a href="javascript:void(0)" onclick="loadLabDetailsInfo('labAction/setting/permissions.do');">权限</a></li>
</ul>
</div>
<!--视图展示区-->
<div class="General_middle_bottom" id="my-lab-details-div"></div>

</div>
<div class="General_bottom"></div>
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
$(".General_middle_top li ").live("click",function(){
	$(".General_middle_top li a").css({"backgroundColor":"none","color":"#000"});
		$("a",this).css({"backgroundColor":"none","color":"#1591f9"});
	});
</script>
</body>
</html>
