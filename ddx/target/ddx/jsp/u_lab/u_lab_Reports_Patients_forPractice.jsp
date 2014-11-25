<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>报告-患者</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp" />
<!--头部结束-->
<!--中间开始-->
<div id="reports_patients_div_show">
	<jsp:include page="u_lab_Reports_Patients_show_forPractice.jsp" />
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp" />
<!--底部结束-->
</div> 
</body>
</html>
