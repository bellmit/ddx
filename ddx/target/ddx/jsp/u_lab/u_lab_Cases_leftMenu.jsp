<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>

<ul>
	<li><a href="${pageContext.request.contextPath}/labAction/query.do?method=byMonth&month=<%=ToolsKit.DateUtil.formatDate(new Date(),"M") %>&year=<%=ToolsKit.DateUtil.formatDate(new Date(),"yyyy") %>">按月份查询</a></li>
	<li><a href="${pageContext.request.contextPath}/labAction/query.do?method=toArrive">待抵达订单</a></li>
	<li><a href="${pageContext.request.contextPath}/labAction/query.do?method=toShip">待寄出订单</a></li>
	<li><a href="${pageContext.request.contextPath}/labAction/query.do?method=openTryIns">试戴订单</a></li>
	<li><a href="${pageContext.request.contextPath}/labAction/query.do?method=onHold">搁置订单</a></li>
	<li><a href="${pageContext.request.contextPath}/labAction/query.do?method=toOutsource">外包订单</a></li>
</ul>
