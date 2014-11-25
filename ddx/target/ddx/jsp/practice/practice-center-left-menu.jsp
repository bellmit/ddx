<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
	<li>
		<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patients">患者</a>
	</li>
	<li>
		<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=arrive_cases">抵达订单</a>
	</li>
	<li>
		<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=tagged_cases">标签订单</a>
	</li>
	<c:if test="${sessionUser.isMain == 'true' or sessionUser.managerAccount=='true'}">
		<li>
			<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=users">用户信息</a>
		</li>
	</c:if>
	<li>
		<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=practice">临床详情</a>
	</li>
</ul>
