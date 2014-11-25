<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工厂实验室验证更新错误</title>
<link
	href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/jsp/login_lab/css/login_lab.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"
	rel="stylesheet" type="text/css" />
<jsp:include page="../common.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jsp/login_lab/js/login.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jsp/u_lab/js/user.js"></script>
</head>

<body>
	<div class="page">
		<!--头部开始-->
		<div class="top">
			<div class="top_a">
				<div class="top_a_left">
					<a href="#"><img src="${pageContext.request.contextPath}/jsp/common/images/loginlogo.gif" />
					</a>
				</div>
				<div class="top_a_right">
					<!--  <ul>
						<li><a href="#">UK</a>
						</li>
						<li class="top_a_right_a">,</li>
						<li><a href="#">Deutsch</a>
						</li>
						<li class="top_a_right_a">,</li>
						<li><a href="#">Nederlands</a>
						</li>
					</ul>-->
				</div>
			</div>
			<div class="top_b">
				<div class="top_b_left">
					<ul>
						<li><a href="${pageContext.request.contextPath}/jsp/login_lab/SignUp_lab_option.jsp">注册</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/userAction/login.do">登陆</a>
						</li>
					</ul>
				</div>
				<div class="top_b_right">
					<ul>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
		</div>
		<!--头部结束-->
		<!--中间开始-->
		<div class="center">
			<!--工厂实验室-登陆开始-->
			<div class="gcsyszc_a">重新认证</div>
			<div class="center_c" id="gcsyszccuowu">更新身份验证失败</div>
			<div class="center_g">
				<dl>
					<dt>无法更新你的身份验证可能是由一下原因导致：</dt>
					<dd>你的认证更新请求已失效，请重新启动认证更新过程</dd>
					<dd>请确认完整的邮箱地址黏贴到你的浏览器地址栏</dd>
				</dl>
			</div>
			<!--工厂实验室-登陆结束-->
		</div>
		<!--中间结束-->
		<!--底部开始-->
		<jsp:include page="../bottom.jsp" />
		<!--底部结束-->
	</div>
</body>
</html>
