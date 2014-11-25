<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${casesPermissions.newCase==true}">
		<li class="secs"><a href="javascript:void(0)" onclick="gotoNewCase(${requestAccountLab.id },'');">新建订单</a></li>
	</c:if>
	<!--<c:if test="${casesPermissions.caseEnclosures==true}">
		<li class="secs"><a href="javascript:void(0)">附加订单模型</a></li>
	</c:if>
	<c:if test="${casesPermissions.cancelCase}">
		<li class="secs"><a href="javascript:void(0)">取消订单</a></li>
	</c:if>
	<c:if test="${casesPermissions.listCasesArrivingToday==true}">
		<li class="secs"><a href="javascript:void(0)">列出今天到达订单</a></li>
	</c:if>
	--><c:if test="${casesPermissions.listCases==true}">
		<li class="secs"><a href="javascript:void(0)" onclick="showAllLabCases('',${requestAccountLab.id });">订单列表</a></li>
	</c:if>
	<c:if test="${casesPermissions.pickup==true}">
		<li class="secs"><a href="javascript:void(0)" onclick="goPickupPage(${requestAccountLab.id });">取件服务</a></li>
	</c:if>
	<!--<c:if test="${casesPermissions.disabledNotesOnReceived==true}">
		<li class="secs"><a href="javascript:void(0)">接收残缺笔记</a></li>
	</c:if>
	<c:if test="${casesPermissions.caseNotes==true}">
		<li class="secs"><a href="javascript:void(0)">订单备注</a></li>
	</c:if>
	<c:if test="${casesPermissions.attachCaseFiles==true}">
		<li class="secs"><a href="javascript:void(0)">附加订单附件</a></li>
	</c:if>-->
	<c:if test="${casesPermissions.newCase!=true and casesPermissions.listCases!=true and casesPermissions.pickup!=true}">
		<li class="secs">无操作权限！</li>
	</c:if>
