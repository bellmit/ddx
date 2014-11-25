<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>设置中心</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
</head>

<body> 
<div class="page">
<!--底部开始-->

<!--头部结束-->
<jsp:include page="../head.jsp"/>
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">设置</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="../left.jsp"/>
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">我的技工间设置</div>
<div class="Cases_bottom_right_b">
<dl>
<dt><a href="${pageContext.request.contextPath}/labAction/setting/details.do">技工间详情</a></dt>
<dd>管理你的技工间明细， 包括技工间联络信息，图标，付款处理。</dd>
<dt><a href="${pageContext.request.contextPath}/labAction/setting/users.do">用户账户</a></dt>
<dd>管理你的技工间的ddx用户， 包括增加新用户，修改现有用户。</dd>
<dt><a href="${pageContext.request.contextPath}/labAction/setting/practices.do">临床</a></dt>
<dd>显示你的DDS现有临床</dd>

<dt><a href="#">账务管理</a></dt>
<dd>管理你的财务设置，如税收和发票。</dd>
<dt><a href="${pageContext.request.contextPath}/labAction/setting/caseSetting.do">订单设置</a></dt>
<dd>管理你的情况下设置，这样一个可用的情况下，程序，材料，外壳，和更多。</dd>

<dt><a href="${pageContext.request.contextPath}/labAction/setting/website.do">UPD网站</a></dt>
<dd>管理你的UPD技工间网页，取得放在外部网页的链接和html窗口小控件。 </dd>
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
<jsp:include page="../bottom.jsp"/>
<!--底部结束-->
</div>
</body>
</html>
