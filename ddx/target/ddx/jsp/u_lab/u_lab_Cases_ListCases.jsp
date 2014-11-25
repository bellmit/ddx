<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<title>订单列表</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/u_lab_cases.js"></script> 
</head>

<body> 
<div class="page">
<!--头部开始--> 
	<jsp:include page="../head-dashboard.jsp" /> 
<!--头部结束-->
<!--中间开始-->
<div class="center" id="u_lab_listcases_show_div">
<!--工厂实验室会员中心开始-->
	<jsp:include page="u_lab_Cases_ListCases_show.jsp" />
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
 <!--底部开始--> 
 	<jsp:include page="../bottom.jsp" /> 
 <!--底部结束-->
</div>

</body>
</html>