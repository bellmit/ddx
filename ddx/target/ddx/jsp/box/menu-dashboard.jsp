<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/common/js/menu.js"></script>
<ul class="menu">
	<s:authorize ifAllGranted="ROLE_LAB">
		<li class="first">主页
			<ul class="menu_s menu_s01">
			   <li class="sec"></li>
				<li class="secs"><a href="${pageContext.request.contextPath}/labAction/main.do">首页</a></li>
				<li class="secs"><a href="${pageContext.request.contextPath}/partners/partners.do">合作技工间</a></li>
			    <li class="secc"></li>
			</ul>
		</li>
	</s:authorize>
	<s:authorize ifAllGranted="ROLE_PRACTICE">
		<li class="first"><a href="${pageContext.request.contextPath}/practiceAction/main.do">主页</a>
	</s:authorize>
	<li class="first">${requestAccountLab.name }
	<ul class="menu_s menu_s03">
		<li class="sec"></li>
		<c:if test="${!empty listPartnerLabs}">
			<c:forEach items="${listPartnerLabs}" var="partnerLab">
				<li class="secs"><a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${partnerLab.id }">${partnerLab.name }</a></li>
			</c:forEach>
			<li class="secs"><font color="#DFDFDF">————————————</font></li>
		</c:if>
		<s:authorize ifAllGranted="ROLE_LAB">
			<li class="secs"><a href="${pageContext.request.contextPath}/partners/partners.do">增加伙伴技工间</a></li>
		</s:authorize>
		<s:authorize ifAllGranted="ROLE_PRACTICE">
			<li class="secs"><a href="${pageContext.request.contextPath}/practiceAction/partners.do">增加伙伴技工间</a></li>
		</s:authorize>
		<li class="secc"></li>
	</ul>
	</li>
	
	<jsp:include page="../practice/menu-top-unit-operating-authority.jsp"></jsp:include>
</ul>
