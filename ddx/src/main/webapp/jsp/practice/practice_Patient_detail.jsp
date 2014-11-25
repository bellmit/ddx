<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>患者详细信息</title>
<link href="${pageContext.request.contextPath }/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath }/jsp/lab/css/lab.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/practice/js/patient.js"></script>
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="head-practice.jsp"/> 
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">临床</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
	<jsp:include page="practice-center-left-menu.jsp"/>
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">患者</div>

<div class="LabDetails_b">
<div class="LabDetails_b_left">
<dl>

<dt>姓:</dt>
<dd>
	${datas.patient.firstName }
</dd>

<dt>名:</dt>
<dd>
	${datas.patient.lastName }
</dd>

<dt>出生日期:</dt>
<dd>
	${datas.patient.birthday }
</dd>
</dl>
</div>
<div class="LabDetails_b_right">
<dl>

<dt>性别:</dt>
<dd>
	<c:choose>
		<c:when test="${datas.patient.sex eq 0 }">
			男
		</c:when>
		<c:otherwise>
			女
		</c:otherwise>
	</c:choose>
</dd>

<dt>
	<span>外部ID:</span>
</dt>
<dd>
	${datas.patient.externalId }
</dd>
</dl>
</div>
</div>

<div id="patient_detail_caseList_div">
	<jsp:include page="practice_Patient_detail_caseList.jsp" />
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
