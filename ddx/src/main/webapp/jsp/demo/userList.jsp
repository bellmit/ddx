
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>ddx</title>
</head>
<body>
<table border="10">
	<tr>
		<td>ID</td>
		<td>实验室ID</td>
		<td>临床ID</td>
		<td>账号</td>
		<td>密码</td>
		<td>类型</td>
		<td>用户昵称</td>
		<td>名</td>
		<td>姓</td>
		<td>用户外部标示</td>
		<td>邮件</td>
		<td>UPD通讯</td>
	</tr>
	<c:forEach items="${list}" var="user">
		<tr>
			<td>${user.accountId }</td>
			<td>${user.id }</td>
			<td>${user.practiceId}</td>
			<td>${user.userName }</td>
			<td>${user.password }</td>
			<td>${user.type }</td>
			<td>${user.salutation }</td>
			<td>${user.firstName }</td>
			<td>${user.lastName }</td>
			<td>${user.externalID }</td>
			<td>${user.email }</td>
			<td>${user.ddxNewsletter }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>