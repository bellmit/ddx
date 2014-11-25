<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>安排新订单</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/css/u_practice.css" rel="stylesheet" type="text/css"/>
</head>

<body> 
<div class="page">
<!-- 头部开始 -->
<jsp:include page="../head-dashboard.jsp" /> 
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="Patients">
<div class="Patients_a">安排新订单</div>
<div class="NewCase">
<div class="NewCase_a">
<div class="NewCase_a_top">联系方式</div>
<div class="NewCase_a_middle">
<div class="NewCase_a_middle_left">
<form action="" method="get">
<ul>
<li>
<div class="NewCase_a_middle_right_left"><span>信息提供者</span><span class="NewCase_a_middle_a">*</span></div>
<div class="NewCase_a_middle_right_right">
<select name="" id="provider" size="1">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select>
</div>
</li>
<li>
<div class="NewCase_a_middle_left_left">姓</div>
<div class="NewCase_a_middle_left_right"><input name="" id="firstName" type="text" class="NewCase_a_middle_b"/></div>
</li>
<li>
<div class="NewCase_a_middle_left_left"><span>名</span><span class="NewCase_a_middle_a">*</span></div>
<div class="NewCase_a_middle_left_right"><input name="" id="lastName" type="text" class="NewCase_a_middle_b"/></div>
</li>
</ul>
</form>
</div>
<div class="NewCase_a_middle_right">
<form action="" method="get">
<ul>
<li>
<div class="NewCase_a_middle_right_left">性别</div>
<div class="NewCase_a_middle_right_right">
<select name="" size="1">
  <option value="">--请选择--</option>
  <option value="1">男</option>
  <option value="2">女</option>
</select>
</div>
</li>
<li>
<div class="NewCase_a_middle_right_left">病例</div>
<div class="NewCase_a_middle_right_right"><input name="" type="text" class="NewCase_a_middle_b"/></div>
</li>
<li>
<div class="NewCase_a_middle_right_left">生日</div>
<div class="NewCase_a_middle_right_right">
	<span>
		<input name="" id="birth" type="text" class="NewCase_a_middle_b"/>
	</span>
	<span class="NewCase_a_middle_c"><a href="#" onclick="WdatePicker({el:'birth'})"></a></span></div>
</li>
</ul>
</form>
</div>
</div>
<div class="NewCase_a_bottom"></div>
</div>
<div class="NewCase_b">
<div class="NewCase_b_top">修复体质要求</div>
<div class="NewCase_b_middle">
<div class="NewCase_b_middle_left">
<form action="" method="get">
<ul>
<li>
<div class="NewCase_b_middle_left_left"><span>发送日期</span><span class="NewCase_b_middle_a">*</span></div>
<div class="NewCase_b_middle_left_right">
	<span>
		<input name="" id="sendDate" type="text" class="NewCase_b_middle_b"/>
	</span>
	<span class="NewCase_b_middle_c">
		<a href="#" onclick="WdatePicker({el:'sendDate'})" ></a>
	</span>
</div>
</li>
<li>
<div class="NewCase_b_middle_left_left"><span>工序</span><span class="NewCase_b_middle_a">*</span></div>
<div class="NewCase_b_middle_left_right">
<span>
<select name="" size="1">
	<option>--请选择工序--</option>
	<optgroup label="fixed">
		<option value="fix1">fix1</option>
		<option value="fix2">fix2</option>
		<option value="fix3">fix3</option>
	</optgroup>
	<optgroup label="Implant">
		<option value="implant1">implant1</option>
		<option value="implant2">implant2</option>
		<option value="implant3">implant3</option>
	</optgroup>  
</select>
</span>
<span class="NewCase_b_middle_d"><a href="#"></a></span>
<span class="NewCase_b_middle_g"><a href="#"></a></span>
</div>
</li>
<li>
<div class="NewCase_b_middle_left_left">&nbsp;</div>
<div class="NewCase_b_middle_left_right"><span class="NewCase_b_middle_f"><a href="#"></a></span></div>
</li>
</ul>
</form>
</div>
<div class="NewCase_b_middle_right">
<form action="" method="get">
<ul>
<li>
<div class="NewCase_b_middle_right_left">附件</div>
<div class="NewCase_b_middle_right_right">
<select name="" size="1">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select>
</div>
</li>
</ul>
</form>
</div>
</div>
<div class="NewCase_b_bottom"></div>
</div>

<div class="NewCase_c">
<div class="NewCase_c_top">订单备注</div>
<div class="NewCase_c_middle">
<div class="NewCase_c_middle_left">
<form action="" method="get">
<textarea name="" cols="" rows=""></textarea>
</form>
</div>
<div class="NewCase_c_middle_right">
<ul>
<li>
<ol>
<li class="NewCase_c_middle_right_right_a"><a href="#" id="isTryIn">试戴</a></li>
<li class="practice_CasesNewCase_a"><a href="#">加急</a></li>
<li class="practice_CasesNewCase_b"><a href="#">入档</a></li>
</ol>
</li>
<li class="practice_CasesNewCase">
<ol>
<li><input name="" type="checkbox" value=""/></li>
<li>我同意所有</li>
<li><a href="#">使用条款和条件</a></li>
</ol>
</li>
<li>
<div class="NewCase_c_middle_right_left">标签</div>
<div class="NewCase_c_middle_right_right"><input name="" type="text" class="NewCase_c_middle_a"/></div>
</li>
<li>
<ol>
<li class="NewCase_c_middle_right_right_c"><a href="#"></a></li>
<li class="NewCase_c_middle_right_right_d"><a href="#"></a></li>
</ol>
</li>
</ul>
</div>
</div>
<div class="NewCase_c_bottom"></div>
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
