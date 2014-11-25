<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<title>我的临床</title>
<link href="${pageContext.request.contextPath }/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/practice/js/patient.js"></script>
</head>

<body> 
<div class="page">
<!--头部开始-->
<jsp:include page="head-practice.jsp"/> 
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">
<div class="Cases_bottom_right_a">管理我的临床</div>
<div class="Personalize_cuowu">临床信息已经更新</div>
<div class="Cases_bottom_right_b">
<dl>
<dt><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=users">临床用户</a></dt>
<dd>查看并管理 ${practice.name} 的所有用户.</dd>
<dt><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=practice">临床详情</a></dt>
<dd>管理我的临床详情.</dd>
</dl>
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
