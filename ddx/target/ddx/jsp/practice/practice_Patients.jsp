<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp"></jsp:include>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>患者</title>
<link href="${pageContext.request.contextPath }/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/practice/js/patient.js"></script>
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="head-practice.jsp"/> 
<!--头部结束-->
<!--中间开始-->
<div id="patient_div_show">
	<jsp:include page="practice_Patients_show.jsp" />
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp" /> 
<!--底部结束-->
</div>
</body>
</html>
