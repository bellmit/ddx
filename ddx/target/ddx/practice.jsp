<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
<h1>临床首页</h1>
	欢迎您<s:authentication property="name"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="practice_logout">退出系统</a><br/>
</body>
</html>
