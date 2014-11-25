<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>出错了</title>
</head>
<body>
	<div>
		<h1 style="color: red;">出错了！<br/></h1>
		<div style="color: red;">${exception.localizedMessage }</div>
		<div style="margin-top: 30px;">
			会话超时或系统繁忙，请重新<a href="${pageContext.request.contextPath}/userAction/login.do">登录</a>或稍后再试！
		</div>
	</div>
</body>
</html>
