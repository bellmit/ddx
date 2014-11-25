<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/common/js/menu.js"></script>
<ul class="menu">
	<li class="first"><a href="${pageContext.request.contextPath}/practiceAction/main.do">主页</a>
	</li>
	<li class="first">机构通道
	<ul class="menu_s menu_s03">
		<li class="sec"></li>
		<c:if test="${!empty listPartnerLabs}">
			<c:forEach items="${listPartnerLabs}" var="partnerLab">
				<li class="secs"><a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${partnerLab.id }">${partnerLab.name }</a></li>
			</c:forEach>
			<li class="secs"><font color="#DFDFDF">————————————</font></li>
		</c:if>
		<li class="secs"><a href="${pageContext.request.contextPath}/practiceAction/partners.do">增加伙伴技工间</a></li>
		<li class="secc"></li>
	</ul>
	</li>
</ul>
