<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<link href="${pageContext.request.contextPath}/jsp/box/css/box.css"  rel="stylesheet" type="text/css"/>
<div class="top">
	<div class="top_a">
		<div class="top_a_left">
			<a href="#"><img src="${pageContext.request.contextPath}/jsp/common/images/loginlogo.gif" /></a>
		</div>
			<!-- 头部会话窗口-->
			<jsp:include page="../session.jsp"/>
	</div>
	<div class="top_b">
		<div class="top_b_left">
			<!-- 头部菜单 -->
			<jsp:include page="menu-dashboard.jsp" />
		</div>
		<div class="top_b_right">
			<!-- 头部搜索窗口 -->
			<jsp:include page="../serache.jsp" />
		</div>
	</div>
</div>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/jsp/u_practice/js/u_practice_addLab.js"></script>