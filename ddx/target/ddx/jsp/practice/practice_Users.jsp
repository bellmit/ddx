<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>临床用户信息</title>
	</head>

	<body onload="listPracticeUsers('1')">
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
							设置
						</div>
						<div class="Cases_bottom">
							<div class="Cases_bottom_left">
								<jsp:include page="practice-center-left-menu.jsp" />
							</div>
							<div class="Cases_bottom_right" id="user-list-div">
							<jsp:include page="practice_UserAccounts_div.jsp"/>
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
			<div style="display: none;background-color: #FFFFFF" id="add-practice-user-div">
				<jsp:include page="../u_lab/u_lab_Setting_UserEdit_div.jsp?url=practiceAction/addUser.do" />
			</div>
		</div>
	</body>
</html>
