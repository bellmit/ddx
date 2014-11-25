<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>延时订单</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/u_lab_cases.js"></script>  
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp"/>
<!--头部结束-->
<!--中间开始-->
<div id="div_show">
	<jsp:include page="u_lab_Cases_OnHold_show.jsp" />
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp"/>
<!--底部结束-->
</div> 
</body>
</html>
