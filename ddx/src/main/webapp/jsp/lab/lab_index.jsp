<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>
<html>
	<head>
		<title>工厂实验室首页</title>
		<link
			href="${pageContext.request.contextPath}/jsp/common/css/commom.css"	rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/jsp/lab/css/lab.css"	rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="page">
			<!--頭部开始-->
			<jsp:include page="../head.jsp" />
			<!--头部结束-->
			<!--中间开始-->
			<div class="center">
				<!--工厂实验室开始-->
				<div class="Lab">
					<div class="Lab_a">
						欢迎
						<s:authentication property="name" />
					</div>
					<div class="Lab_b">
						<div class="Lab_b_left">
							<div class="Lab_b_left_a">
								订单
							</div>
							<div class="Lab_b_left_b">
								<div class="Lab_b_left_b_top"></div>
								<div class="Lab_b_left_b_middle">
									<ul>
										<li>
											<div class="Lab_b_left_b_middle_a">
												<div class="Lab_b_left_b_middle_a_top"></div>
												<div class="Lab_b_left_b_middle_a_middle">
													<div class="Lab_b_left_b_middle_a_middle_top">
														今天待接收的订单
													</div>
													<div class="Lab_b_left_b_middle_a_middle_bottom">
														<div class="Lab_b_left_b_middle_a_middle_bottom_left"
															id="num_arrive" onclick="num_arrive();"></div>
														<div class="Lab_b_left_b_middle_a_middle_bottom_right">
															<!-- <a href="#"></a> -->
														</div>
													</div>
												</div>
												<div class="Lab_b_left_b_middle_a_bottom"></div>
											</div>
										</li>
										<li>
											<div class="Lab_b_left_b_middle_a">
												<div class="Lab_b_left_b_middle_a_top"></div>
												<div class="Lab_b_left_b_middle_a_middle">
													<div class="Lab_b_left_b_middle_a_middle_top">
														今天待寄出的订单
													</div>
													<div class="Lab_b_left_b_middle_a_middle_bottom">
														<div class="Lab_b_left_b_middle_a_middle_bottom_left"
															id="num_ship" onclick="num_ship();"></div>
														<div class="Lab_b_left_b_middle_a_middle_bottom_right">
															<!-- <a href="#"></a> -->
														</div>
													</div>
												</div>
												<div class="Lab_b_left_b_middle_a_bottom"></div>
											</div>
										</li>
										<li>
											<div class="Lab_b_left_b_middle_a">
												<div class="Lab_b_left_b_middle_a_top"></div>
												<div class="Lab_b_left_b_middle_a_middle">
													<div class="Lab_b_left_b_middle_a_middle_top">
														试戴订单
													</div>
													<div class="Lab_b_left_b_middle_a_middle_bottom">
														<div class="Lab_b_left_b_middle_a_middle_bottom_left"
															id="num_tryIn" onclick="num_tryIn();"></div>
														<div class="Lab_b_left_b_middle_a_middle_bottom_right"></div>
													</div>
												</div>
												<div class="Lab_b_left_b_middle_a_bottom"></div>
											</div>
										</li>
										<li>
											<div class="Lab_b_left_b_middle_a">
												<div class="Lab_b_left_b_middle_a_top"></div>
												<div class="Lab_b_left_b_middle_a_middle">
													<div class="Lab_b_left_b_middle_a_middle_top">
														搁置订单
													</div>
													<div class="Lab_b_left_b_middle_a_middle_bottom">
														<div class="Lab_b_left_b_middle_a_middle_bottom_left"
															id="num_onHold" onclick="num_onHold();"></div>
														<div class="Lab_b_left_b_middle_a_middle_bottom_right">
															<!-- <a href="#"></a> -->
														</div>
													</div>
												</div>
												<div class="Lab_b_left_b_middle_a_bottom"></div>
											</div>
										</li>
										<li>
											<div class="Lab_b_left_b_middle_a">
												<div class="Lab_b_left_b_middle_a_top"></div>
												<div class="Lab_b_left_b_middle_a_middle">
													<div class="Lab_b_left_b_middle_a_middle_top">
														外包订单
													</div>
													<div class="Lab_b_left_b_middle_a_middle_bottom">
														<div class="Lab_b_left_b_middle_a_middle_bottom_left"
															id="num_outsource" onclick="num_outsource();"></div>
														<div class="Lab_b_left_b_middle_a_middle_bottom_right"></div>
													</div>
												</div>
												<div class="Lab_b_left_b_middle_a_bottom"></div>
											</div>
										</li>
									</ul>
								</div>
								<div class="Lab_b_left_b_bottom"></div>
							</div>
						</div>
						<div class="Lab_b_right">
							<div class="Lab_b_right_top"></div>
							<div class="Lab_b_right_middle">
								<div class="Lab_b_right_middle_top">
									<a href="#">动态</a>
								</div>
								<div class="Lab_b_right_middle_bottom">
										<div class="Lab_b_right_middle_bottom_a">
											<div class="Lab_b_right_middle_bottom_a_left">
												活动日志
											</div>
											<div class="Lab_b_right_middle_bottom_a_right">
												<a href="#"><img
														src="${pageContext.request.contextPath}/jsp/lab/images/Lab_10.jpg" />
												</a>
											</div>
										</div>
										<div class="Lab_b_right_middle_bottom_b">
											<div class="Lab_b_right_middle_bottom_b_left">
												视图
											</div>
											<div class="Lab_b_right_middle_bottom_b_right">
												<ul style="margin: 0px; padding: 0px;">
													<li class="top_b_right_a" style="margin: 0px; padding: 0px;">
														<form action="" method="get">
															<span class="top_b_right_a_left"> 
															    <input name="log_type" type="text" id="log_type" class="log large" style="height: 20px; * line-height: 20px; * vertical-align: middle;cursor: pointer;" />
															</span>
															<span class="top_b_right_a_right"> 
															<!--<input	name="" type="image" src="${pageContext.request.contextPath}/jsp/u_lab/images/select.jpg"/>-->
																<img src="${pageContext.request.contextPath}/jsp/u_lab/images/select.jpg" style="cursor: pointer;" id="showOrHide-img">
															</span>
														</form>
													</li>
												</ul>
												<jsp:include page="../box/box_select.jsp" />
											</div>
										</div>
										<div class="Lab_b_right_middle_bottom_c" id="lab-main-log-div">
											
										</div>
										<div class="Lab_b_right_middle_bottom_d">
											<ul>
												<li class="Lab_b_right_middle_bottom_d_a">
													<a href="#">旧的</a>
												</li>
												<li class="Lab_b_right_middle_bottom_d_b">
													<a href="#">新的</a>
												</li>
											</ul>
										</div>
								</div>
							</div>
							<div class="Lab_b_right_bottom"></div>
						</div>
					</div>
				</div>
				<!--工厂实验室结束-->
			</div>
			<!--中间结束-->
			<!--底部开始-->
			<jsp:include page="../bottom.jsp" />
			<!--底部结束-->
			<input type="hidden" id="month"
				value="<%=ToolsKit.DateUtil.formatDate(new Date(),"MM") %>" />
			<input type="hidden" id="year"
				value="<%=ToolsKit.DateUtil.formatDate(new Date(),"yyyy") %>" />
		</div>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/lab_index.js"></script>
</html>
