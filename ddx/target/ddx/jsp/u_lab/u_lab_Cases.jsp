<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>订单管理</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"	rel="stylesheet" type="text/css" />
</head>

<body>
<div class="page">
<!--头部开始--> 
	<jsp:include page="../head.jsp" /> 
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">订单</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="u_lab_Cases_leftMenu.jsp" />
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">订单管理</div>
<div class="Cases_bottom_right_b">
<dl>
	<dt><a href="${pageContext.request.contextPath}/labAction/query.do?method=byMonth&month=${datas.month }&year=${datas.year}">按月份查询</a></dt>
	<dd>通过月份浏览订单</dd>
	<dt><a href="${pageContext.request.contextPath}/labAction/query.do?method=toArrive">待抵达订单</a></dt>
	<dd>浏览等待被技工间确认抵达的订单</dd>
	<dt><a href="${pageContext.request.contextPath}/labAction/query.do?method=toShip">待寄出订单</a></dt>
	<dd>浏览等待被寄往临床机构的订单</dd>
	<dt><a href="${pageContext.request.contextPath}/labAction/query.do?method=openTryIns">试戴订单</a></dt>
	<dd>浏览已在流程中试戴的订单</dd>
	<dt><a href="${pageContext.request.contextPath}/labAction/query.do?method=onHold">搁置订单</a></dt>
	<dd>浏览被搁置的订单</dd>
	<dt><a href="${pageContext.request.contextPath}/labAction/query.do?method=toOutsource">外包订单</a></dt>
	<dd>浏览需要被外包的订单</dd>
</dl>
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
