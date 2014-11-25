<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>临床中心</title>
		<link
			href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${pageContext.request.contextPath}/jsp/practice/css/practice.css"
			rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="page">
			<!--底部开始-->
			<jsp:include page="head-practice.jsp" />
			<!--头部结束-->
			<!--中间开始-->
			<div class="center">
				<!--工厂实验室会员中心开始-->
				<div class="gcsyshyzx">

					<div class="Cases">
						<div class="Cases_top">
							临床
						</div>
						<div class="Cases_bottom">
							<div class="Cases_bottom_left">
								<ul>
									<li>
										<a href="#">医生</a>
									</li>
									<li>
										<a href="#">收到订单</a>
									</li>
									<li>
										<a href="#">标记的订单</a>
									</li>
									<li>
										<a href="#">用户</a>
									</li>
									<li>
										<a href="#">临床详情</a>
									</li>
								</ul>
							</div>
							<div class="Cases_bottom_right" id="my-practice-center-div">
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
