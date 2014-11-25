<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>工厂实验室网站广告</title>
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
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">订单</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="../left.jsp" />
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">UPD网站</div>
<div class="Cases_bottom_right_b">
<dl>
<dt><a href="#">个性化</a></dt>
<dd>用您的标志，公司概况，以及所提供的服务自定义您的UPD网站用您的标志，公司概况</dd>
<dt><a href="#">UPD广告</a></dt>
<dd>创建UPD广告来宣传您的技工间。</dd>
<dt><a href="#">链接</a></dt>
<dd>自定义的UPD链接放置在网站上，以吸引流量到您的UPD技工间 </dd>
<dt><a href="#">小工具</a></dt>
<dd>放置在您的网站的HTML小插件</dd>
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
<jsp:include page="../bottom.jsp" />
<!--底部结束-->
</div>
</body>
</html>
