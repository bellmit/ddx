<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>工厂实验室-登陆_密码重置</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/login_lab/css/login_lab.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css" />
<jsp:include page="../common.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/login_lab/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/user.js"></script>
</head>
<body>
	<div class="page">
		<!--头部开始-->
		<div class="top">
			<div class="top_a">
				<div class="top_a_left">
					<a href="#"><img src="${pageContext.request.contextPath}/jsp/common/images/loginlogo.gif" /> </a>
				</div>
				<div class="top_a_right">
				<!-- <ul>
						<li><a href="#">英语</a></li>
						<li class="top_a_right_a">,</li>
						<li><a href="#">德语</a></li>
						<li class="top_a_right_a">,</li>
						<li><a href="#">荷兰</a></li>
					</ul> -->	
				</div>
			</div>
			<div class="top_b">
				<div class="top_b_left">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/jsp/login_lab/SignUp_lab_option.jsp">注册</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/userAction/login.do">登陆</a></li>
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
			<div class="center_c" style="display: none;" id="error_message">你提交的表单有错误，详情见下文.</div>
			<div class="center_h" style="display: none;" id="success_message">您的更改已记录，请去邮箱确认验证更改</div>
			<!--工厂实验室-登陆开始-->
			<div class="mmcz">重置密码</div>
			<div class="center_b">
				<div class="center_b_top"></div>
				<div class="center_b_middle">
					<form action="" method="get">
						<ul>
							<li>
								<div class="mmcz_left">
									<span>重置密码</span><span class="center_b_middle_left_a">*</span>
								</div>
								<div class="mmcz_right">
									<select name="" size="1" id="selectItems">
										<option value="1" id="option-lab">技工间</option>
										<option value="2" id="option-practice">临床</option>
									</select>
								</div>
							</li>
							<li>
								<div class="mmcz_left">
									<span>邮箱</span><span class="center_b_middle_left_a">*</span>
								</div>
								<div class="mmcz_right">
									<input name="" type="text" class="center_b_middle_right_a"
										id="reset_username" />
								</div></li>
							<li>
								<div class="mmcz_left"></div>
								<div class="mmcz_right" style="display:none;"
									id="affirm_username_error">
									<i class="center_e">请输入一个有效的邮箱地址</i>
								</div></li>

							<li>
								<div class="mmcz_left">
									<span>新密码</span><span class="center_b_middle_left_a">*</span>
								</div>
								<div class="mmcz_right">
									<input name="" type="password" class="center_b_middle_right_a"
										id="reset_new_password" />
								</div></li>
							<li>
								<div class="mmcz_left"></div>
								<div class="mmcz_right" style="display: none;"
									id="affirm_password_error">
									<i class="center_e">密码至少6位</i>
								</div></li>
							<li>
								<div class="mmcz_left">
									<span>确认新密码</span><span class="center_b_middle_left_a">*</span>
								</div>
								<div class="mmcz_right">
									<input name="" type="password" class="center_b_middle_right_a"
										id="affirm_reset_password" />
								</div></li>
							<li>
								<div class="mmcz_left"></div>
								<div class="mmcz_right" style="display: none;"
									id="mate_password_error">
									<i class="center_e">密码确认不匹配</i>
								</div></li>
							<li>
								<div class="mmcz_left"></div>
								<div class="mmcz_right">
									<i class="center_e"></i>
								</div></li>
							<li>
								<div class="mmcz_left"></div>
								<div class="mmcz_right">
									<span class="mmcz_a"><a href="javascript:void(0)"
										onclick="resetPassword()">重置密码</a> </span>
								</div>
							</li>
						</ul>
					</form>
				</div>
				<div class="center_b_bottom"></div>
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
