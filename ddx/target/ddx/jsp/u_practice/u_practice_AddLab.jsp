<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<html>
	<head>
		<title>新增技工间</title>
		<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css"	rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/jsp/u_practice/css/u_practice.css"	rel="stylesheet" type="text/css" />
	</head>
	<body onload="initHtml()">
		<div class="page">
		<!--头部开始-->
			<jsp:include page="../practice/head-practice.jsp"></jsp:include>
		<!--头部结束-->
		<!--中间开始-->
		<div class="center">
			<!--工厂实验室会员中心开始-->
			<div class="gcsyshyzx">

				<div class="Cases">
					<div class="Cases_top">
						技工间
					</div>
					<div class="Cases_bottom">
						<div class="Cases_bottom_left">
							<ul>
								<li>
									<a href="javascript:void(0)" onclick="getMyLasBypractice();">我的技工间</a>
								</li>
								<li>
									<a href="javascript:void(0)" onclick="showFindWindow();">搜索技工间</a>
								</li>
							</ul>
						</div>
						<div class="Cases_bottom_right">
							<div class="zsyshyzx" id="find-labs-div">
								<ul style="margin: 0px;">
									<li class="zsyshyzx_a">
										新增技工间
									</li>
									<jsp:include page="../u_lab/labs-find.jsp?unit=2"></jsp:include>
								</ul>
							</div>
							<div id="my-labs-div" style="display: none;"></div>
						</div>
					</div>
				</div>

			</div>
			<!--工厂实验室会员中心结束-->
		</div>
		<!--中间结束-->
		<!--底部开始-->
		<jsp:include page="../bottom.jsp"></jsp:include>
		<!--底部结束-->
		</div>
	</body>
</html>
