<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>临床标记的订单</title>
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
							医生
						</div>
						<div class="Cases_bottom">
							<div class="Cases_bottom_left">
								<jsp:include page="practice-center-left-menu.jsp" />
							</div>
							<div class="Cases_bottom_right">
								<div class="Cases_bottom_right_a">
									标记的订单
								</div>
								<div class="Settings_Practices">
									<div class="Settings_Practices_top"></div>
									<div class="Settings_Practices_middle">
										<form action="" method="get">
											<div class="Settings_Practices_middle_a">
												<div class="Settings_Practices_middle_a_left">
												</div>
												<div class="Settings_Practices_middle_a_right">
													<ul>
														<li>
															<select name="" onchange="listTagsCases('1')" id="select-tags-cases">
																<option value="" selected="selected">----请选择标签----</option>
																<c:forEach items="${datas.counts.datas}" var="data">
																	<option value="${data.tags }">
																		${data.tags }(${data.count })
																	</option>
																</c:forEach>
															</select>
														</li>
													</ul>
												</div>
											</div>
											<div id="tagsCases-list-div">
												<jsp:include page="practice_TaggedCases_div.jsp"/>
											</div>
										</form>
									</div>
									<div class="Settings_Practices_bottom"></div>
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
