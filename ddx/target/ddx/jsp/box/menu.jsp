<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/common/js/menu.js"></script>
<ul class="menu">
	<li class="first">主页
	<ul class="menu_s menu_s01">
	   <li class="sec"></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/main.do">首页</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/partners/partners.do">合作技工间</a></li>
	    <li class="secc"></li>
	</ul>
	</li>
	<li class="first">订单
	<ul class="menu_s menu_s02">
	    <li class="sec"></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=main">订单概况</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=byMonth&month=<%=ToolsKit.DateUtil.formatDate(new Date(),"M") %>&year=<%=ToolsKit.DateUtil.formatDate(new Date(),"yyyy") %>">按月份查询</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=toArrive">待抵达订单</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=toShip">待寄出订单</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=openTryIns">试戴订单</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=onHold">搁置订单</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=toOutsource">外包订单</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/query.do?method=bargainVerify">议价订单</a></li>
	    <li class="secc"></li>
	</ul>
	</li>
	<li class="first">设置
	<ul class="menu_s menu_s03">
	    <li class="sec"></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/setting.do">概况</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/setting/details.do">机构详情</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/setting/users.do">用户信息</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/setting/practices.do">关联机构</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/setting/caseSetting.do">订单设置</a></li>
		<li class="secs"><a href="${pageContext.request.contextPath}/labAction/setting/website.do">UPD网站</a></li>
	    <li class="secc"></li>
	</ul>
	</li>
	<li class="first"><a href="${pageContext.request.contextPath}/labAction/reports.do">记录报告</a></li>
</ul>

