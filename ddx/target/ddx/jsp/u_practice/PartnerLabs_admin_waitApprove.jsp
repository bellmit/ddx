<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>技工间合作伙伴申请</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/user.js"></script>
</head>

<body> 
<div class="page">
<!--头部开始-->
<jsp:include page="../practice/head-practice.jsp"/>
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<jsp:include page="../u_lab/center-waitApprove.jsp"/>
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp"/>
<!--底部结束-->
</div>
</body>
<script type="text/javascript">
	$(function(){
	
		$("select").multiselect({
			selectedList: 4
		});
		
	});
</script>
<div style="display: none;background-color: #FFFFFF" id="add-lab-user-div">
	<jsp:include page="../u_lab/u_lab_Setting_UserEdit_div.jsp?url=labAction/setting/addUser.do" />
</div>
</html>
