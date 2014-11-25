<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<body>
<h3>用户登录</h3>
${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
<form
	action="${pageContext.request.contextPath}/j_spring_security_check"
	method="post">用户名:<input name="j_username" type="text"><br />
密&nbsp;&nbsp;码:<input type="password" name="j_password" /><br />
<input type="submit" value="登录"></input></form>
</body>
</html>
