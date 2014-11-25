<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="../common.jsp"></jsp:include>
<head>
<title>${requestAccountLab.name }</title>
<link	href="${pageContext.request.contextPath}/jsp/common/css/commom.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/u_lab_cases.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/xixi.js"></script>
</head>

<body>
<div class="page"><!--底部开始--> 
<jsp:include page="head-dashboard.jsp"/>
<!--头部结束--> 
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<jsp:include page="../u_lab/center-yachi.jsp"></jsp:include>
<!--工厂实验室会员中心结束--></div>
<!--中间结束--> 
<!--底部开始--> 
<jsp:include page="../bottom.jsp" /> 
<!--底部结束-->
</div>
</body>
</html>
