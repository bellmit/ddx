<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<title>临床医生注册-第二步</title>
<link href="../common/css/commom.css" rel="stylesheet" type="text/css" />
<link href="../login_lab/css/login_lab.css" rel="stylesheet"
	type="text/css" />
<link href="css/login_practice.css" rel="stylesheet" type="text/css" />
<link href="../box/css/box.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/practice-signUp.js"></script>
</head>
<body>
	<div class="page">
		<!--头部开始-->
		<jsp:include page="../head-signUp.jsp" />
		<!--头部结束-->
		<!--中间开始-->
		<div class="center">
			<!--工厂实验室注册第二步开始-->
			<div class="gcsyszcdeb">
				<div class="gcsyszcdeb_left">
					<div class="gcsyszcdeb_left_a">注册临床账户</div>
					<div class="gcsyszcdeb_left_e" id="signUp-errors"
						style="display: none;">你提交的表单有错误，请查看详情</div>
					<div class="gcsyszcdeb_left_b">基本账号</div>
					<div class="gcsyszcdeb_left_c">
						<div class="gcsyszcdeb_left_c_top"></div>
						<div class="gcsyszcdeb_left_c_middle">
							<form action="" method="get">
								<ul>
									<li>账号信息</li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">昵称</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="salutation" type="text"
												class="gcsyszcdeb_left_c_middle_right_a" />
											<%--用户类型为2：诊所 --%>
											<input type="hidden" id="type" value="2" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>姓名</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="firstName" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="firstName_info">
											<i class="center_e">请输入您的姓氏</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>名</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="lastName" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="lastName_info">
											<i class="center_e">请输入您的名字</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>角色</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<!-- <input name="" id="role" type="text" class="center_b_middle_right_a"/> -->
											<jsp:include page="../u_practice/role.jsp" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="role_info">
											<i class="center_e">请选择您的角色</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>邮箱</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="email" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="email_info">
											<i class="center_e">请输入您的邮箱</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>确认邮箱</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="confirmEmail" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="confirmEmail_info">
											<i class="center_e">请确认您的邮箱</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>密码</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="password" type="password"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="password_info">
											<i class="center_e">请输入您的密码</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>确认密码</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="confirmPassword" type="password"
												onpaste="return false" class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="confirmPassword_info">
											<i class="center_e">密码不一致</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">新闻资讯</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="ddxNewsletter" type="checkbox" value="" />
										</div></li>
								</ul>
							</form>
						</div>
						<div class="gcsyszcdeb_left_c_bottom"></div>
					</div>
					<div class="gcsyszcdeb_left_b">机构信息</div>
					<div class="gcsyszcdeb_left_c">
						<div class="gcsyszcdeb_left_c_top"></div>
						<div class="gcsyszcdeb_left_c_middle">
							<form action="" method="get">
								<ul>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>简称</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="name" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="name_info">
											<i class="center_e">请输入您的临床名称</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>地址</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="address" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="address_info">
											<i class="center_e">请输入您的地址</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>地址2</span><span class="center_b_middle_left_a"></span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="address2" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>国家</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<select name="" id="country" size="1">
												<option value="中国">中国</option>
											</select>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="country_info">
											<i class="center_e">请选择临床所在国家</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>省份 </span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<select name="" id="state" size="1">
												<jsp:include page="../state.jsp"></jsp:include>
											</select>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="state_info">
											<i class="center_e">请选择临床所在的省份</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>城市</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="city" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="city_info">
											<i class="center_e">请输入临床所在城市</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>邮编</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="zipCode" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="zipCode_info">
											<i class="center_e">请输入临床所在地邮编</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>电话</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="phoneNumber" type="text"
												class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="phoneNumber_info">
											<i class="center_e">请输入联系电话</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">邮箱</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="practice_email" type="text"
												class="center_b_middle_right_a" />
										</div></li>

									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>我同意</span><span class="center_b_middle_right_e"><a
												href="javascript:void(0)" onclick="showLabSignupTerms();">使用条款</a>
											</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<span><input name="" id="agree" type="checkbox"
												value="" />
											</span>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="agree_info">
											<i class="center_e">您必须同意用户协议</i>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left">
											<span>验证码</span><span class="center_b_middle_left_a">*</span>
										</div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<a href="javascript:void(0)" style="text-decoration: none;"><img
												src="${pageContext.request.contextPath}/kaptchaAction/getVerify.do"
												onclick="updateImg(this)" />
											</a><span>不区分大小写、点击图片刷新验证码</span>
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right">
											<input name="" id="verificationCode"
												type="text" class="center_b_middle_right_a" />
										</div></li>
									<li>
										<div class="gcsyszcdeb_left_c_middle_left"></div>
										<div class="gcsyszcdeb_left_c_middle_right"
											style="display: none;" id="verificationCode_info">
											<i class="center_e">请输入验证码</i>
										</div></li>
								</ul>
							</form>
						</div>
						<div class="gcsyszcdeb_left_c_bottom"></div>
					</div>
					<div class="gcsyszcdeb_left_d">
						<a href="javascript:void(0)" onclick="signUpPractice();" id="sign_action">注&nbsp;&nbsp;册</a>
					</div>
					<div>
						<form action="${pageContext.request.contextPath}/practice_login"
							id="sigupLoginForm" name="sigupLoginForm" method="post">
							<input type="hidden" id="sigupLoginForm-username"
								name="j_username" /> <input type="hidden"
								id="sigupLoginForm-password" name="j_password" />
						</form>
					</div>
				</div>
				<div class="gcsyszcdeb_right">
					<div class="zsyszce">
						<div class="zsyszce_a">已有账号？</div>
						<div class="zsyszce_b">
							<span>您的临床已有DDX账号？ </span><span class="center_b_middle_right_e"><a
								href="${pageContext.request.contextPath}/userAction/login.do">登录</a>
							</span>
						</div>
						<div class="zsyszce_a">DDX是什么？</div>
						<div class="zsyszce_b">DDX是为了你的临床和管理技工间的加工的免费软件。</div>
						<div class="zsyszce_b">
							<span>观看</span><span class="zsyszce_c"><a
								href="javascript:void(0)">一段视频简介</a>
							</span>更多信息请致电: 888-888-8888
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--工厂实验室注册第二步结束-->
		<!--中间结束-->
		<!--底部开始-->
		<jsp:include page="../bottom.jsp" />
		<!--底部结束-->
	</div>
</body>

</html>
