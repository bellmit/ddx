<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/lab-details.js"></script>
</head>

<body> 
<div class="page">
<!--头部开始-->
<jsp:include page="../head.jsp"/>
<!--头部结束-->
<div class="top_b">
  <div class="top_b_left">
    <ul>
      <li><a href="#">首页</a></li>
      <li><a href="#">订单</a></li>
      <li><a href="#">设置</a></li>
      <li><a href="#">记录报告</a></li>
    </ul>
  </div>
  <div class="top_b_right">
    <ul>
      <li class="top_b_right_a">
      <form action="" method="get">
      <span class="top_b_right_a_left"><input name="" type="text" /></span>
      <span class="top_b_right_a_right"><input name="" type="image" src="images/u_lab_07.jpg" /></span>
      </form>
      </li>
      <li><a href="#">帮助</a></li>
    </ul>
  </div>
</div>
</div>
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">设置</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<ul>
<li><a href="#">技工间详情</a></li>
<li><a href="#">用户账户</a></li>
<li><a href="#">医生</a></li>
<li><a href="#">DDX网站</a></li>
</ul>
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">我的技工间设置</div>
<div class="LabUpdated">技工间更新</div>
<div class="Cases_bottom_right_b">
<dl>
<dt><a href="#">技工间详情</a></dt>
<dd>管理你的技工间明细， 包括技工间联络信息，图标，付款处理。</dd>
<dt><a href="#">用户账户</a></dt>
<dd>管理你的技工间的ddx用户， 包括增加新用户，修改现有用户。</dd>
<dt><a href="#">医生</a></dt>
<dd>显示你的ddx现有医生</dd>
<dt><a href="#">DDX网站</a></dt>
<dd>管理你的ddx技工间网页，取得放在外部网页的链接和html窗口小控件。</dd>
</dl>
</div>
</div>
</div>
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
