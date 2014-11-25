<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title></title>
</head>
<body>
	<h1>技工厂首页</h1>
	欢迎您<s:authentication property="name"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="lab_logout">退出系统</a><br/>
		<s:authorize ifAllGranted="ROLE_ADMIN">
			<a href="admin.jsp">进入admin.jsp页面</a><br/><hr/>
			<a href="">新增</a><br/>
			<a href="">删除</a><br/>
			<a href="">修改</a><br/>
		</s:authorize>
		<s:authorize ifAllGranted="ROLE_MANAGER">
			<a href="manager.jsp">进入manager.jsp页面</a><br/>
			<hr/>
			<a href="">新增</a><br/>
			<a href="">删除</a><br/>
			<a href="">修改</a><br/>
			<hr/>
		</s:authorize>
	</body>
</html>
