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
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="Patients">
<div class="Patients_a">患者</div>
<div class="Patients_b">
<div class="Patients_b_top"></div>
<div class="Patients_b_middle">

<div class="Patients_b_middletop">
<h1><a href="javascript:history.back(-1);">返回</a></h1>
<div class="box_clear"></div>
<div class="Patients_b_middletop_left">
<dl>
<dt>姓：</dt>
<dd>${patient.firstName }</dd>
<dt>名：</dt>
<dd>${patient.lastName }</dd>
<dt>出生日期：</dt>
<dd>${patient.birthday }</dd>
</dl>
</div>
<div class="Patients_b_middletop_right">
<dl>
<dt>性别：</dt>
<dd>
  <c:if test="${patient.sex eq '0' }">
  	男
  </c:if>
  <c:if test="${patient.sex eq '1' }">
  	女
  </c:if>
</dd>
<dt>外部ID：</dt>
<dd>${patient.externalId }</dd>
</dl>
</div>
</div>

<!--中间开始-->
<div id="reports_patient_div_show">
	<jsp:include page="patient_view.jsp" />
</div>

</div>
<div class="Patients_b_bottom"></div>
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
