<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>重制订单</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp" />
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="reports">
<div class="reports_top">记录报告</div>
<div class="reports_bottom">
<div class="reports_bottom_a"><a href="#">订单重做</a></div>
<div class="reports_bottom_b">查看已被重做的订单，并问为什么？</div>
<div class="reports_bottom_c">
<div class="reports_bottom_c_a">患者</div>
<div class="reports_bottom_c_b">
<div class="reports_bottom_c_b_top"></div>
<div class="reports_bottom_c_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="reports_bottom_c_b_middle_left"><span>开始时间</span><span class="reports_bottom_c_b_middle_a">*</span></div>
<div class="reports_bottom_c_b_middle_right"><select name="" size="1">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select></div>
</li>
<li>
<div class="reports_bottom_c_b_middle_left"><span>结束时间</span><span class="reports_bottom_c_b_middle_a">*</span></div>
<div class="reports_bottom_c_b_middle_right"><input name="" type="text" class="reports_bottom_c_b_middle_b"/></div>
</li>
<li>
<div class="reports_bottom_c_b_middle_left"><span>医生</span><span class="reports_bottom_c_b_middle_a">*</span></div>
<div class="reports_bottom_c_b_middle_right"><input name="" type="text" class="reports_bottom_c_b_middle_b"/></div>
</li>
<li>
<div class="reports_bottom_c_b_middle_left"><span>格式</span><span class="reports_bottom_c_b_middle_a">*</span></div>
<div class="reports_bottom_c_b_middle_right"><input name="" type="text" class="reports_bottom_c_b_middle_b"/></div>
</li>
<li>
<div class="reports_bottom_c_b_middle_left"></div>
<div class="reports_bottom_c_b_middle_right">
<span class="reports_bottom_c_b_middle_c"><a href="#"></a></span>
</div>
</li>
</ul>
</form>
</div>
<div class="reports_bottom_c_b_bottom"></div>
</div>
</div>
<div class="reports_bottom_a"><a href="#">患者</a></div>
<div class="reports_bottom_b">查看患者病历.</div>

</div>
</div>
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<div class="bottom">
<div class="bottom_left">
<ul>
<li><a href="#">使用条款</a></li>
<li><a href="#">建议或意见</a></li>
</ul>
</div>
<div class="bottom_middle">爱尔创技术支持</div>
<div class="bottom_right">深圳爱尔创科技股份有限公司版权所有</div>
</div>
<!--底部结束-->
</div>
</body>
</html>
