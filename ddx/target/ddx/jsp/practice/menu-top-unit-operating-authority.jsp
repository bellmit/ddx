<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<li class="first">订单
	<ul class="menu_s menu_s03">
		<li class="sec"></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/casesAction/overview.do?labId=${requestAccountLab.id}">订单概况</a></li>
		<jsp:include page="../practice/menu-left-unit-operating-authority.jsp"></jsp:include>
		<li class="secc"></li>
	</ul>
	</li>
	<li class="first">账务管理
		<ul class="menu_s menu_s03">
		<li class="sec"></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financeOverview&id=${requestAccountLab.id}">账务概况</a></li>
		<c:if test="${financesPermissions.accountPayment==true}">
			<li class="secs"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePayment&id=${requestAccountLab.id}">账户支付</a></li>
		</c:if>
		<li class="secs"><a href="#">账户档案</a></li>
		<c:if test="${financesPermissions.priceList==true}">
			<li class="secs"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePricerList&id=${requestAccountLab.id}">价格列表</a></li>
		</c:if>
		<li class="secc"></li>
	</ul>
	</li>
