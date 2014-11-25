<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>搜索</title>
<link
	href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/lab/css/lab.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="page">
		<!--頭部开始-->
		<jsp:include page="head.jsp" />
		<!--头部结束-->
		<!--中间开始-->
		<div class="center">
			<li class="dropdown_search">患者</li>
			<c:forEach items="${patientPm.datas }" var="patient">
			<li class="dropdown_search01">
			<c:if test="${user.unitType == '1' }">
				<span><a href="${pageContext.request.contextPath}/labAction/reports/patient.do?id=${patient.id}" >${patient.firstName },${patient.lastName }</a></span>
			</c:if>
			<c:if test="${user.unitType == '2' }">
				<span><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patient&id=${patient.id}" >${patient.firstName },${patient.lastName }</a></span>
			</c:if>
			</li>
			</c:forEach>
			<c:if test="${patientPm.total == null }">
				<li class="dropdown_search01">没有找到你要的数据</li>
			</c:if>

			<li class="dropdown_search02">订单</li>
			<c:forEach items="${casesPm.datas }" var="cases">
				<c:if test="${cases.status eq 'OPEN' && empty cases.onHoldStatus }">
					<li class="dropdown_search05" title="订单进行中...">
				</c:if>
				<c:if test="${cases.status eq 'CLOSE' }">
					<li class="dropdown_search03" title="订单已关闭">
				</c:if>
				<c:if test="${cases.status eq 'OPEN' && !empty cases.onHoldStatus }">
					<li class="dropdown_search04"
						title="订单处于搁置/延时状态-${cases.onHoldStatus }">
				</c:if>
				<c:if test="${user.unitType == '1' }">
				<span>
					<a
						href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${cases.caseId }">
						订单号#&nbsp;&nbsp;${cases.caseId } 
						for 接收方&nbsp;&nbsp;${cases.practice } 
						for 患者&nbsp;&nbsp;${cases.patient }
						<c:if test="${ !empty cases.procedures }">
							工序(
							<c:forEach items="${cases.proceduresObj }" var="obj">
								<em>${obj.procedure_name}</em>&nbsp;&nbsp;
							</c:forEach>
							)
						</c:if> 
					</a>
				</span>
				</c:if>
				<c:if test="${user.unitType == '2' }">
				<span>
					<a
						href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.caseId }">
						订单号#&nbsp;&nbsp;${cases.caseId } 
						for 接收方&nbsp;&nbsp;${cases.practice } 
						for 患者&nbsp;&nbsp;${cases.patient }
						<c:if test="${ !empty cases.procedures }">
							工序(
							<c:forEach items="${cases.proceduresObj }" var="obj">
								<em>${obj.procedure_name}</em>&nbsp;&nbsp;
							</c:forEach>
							)
						</c:if>   
					</a>
				</c:if>
				</span>
				</li>
			</c:forEach>
			<c:if test="${casesPm.total == null }">
				<li class="dropdown_search01">没有找到你要的数据</li>
			</c:if>
		</div>
		<jsp:include page="bottom.jsp" />
	</div>
</body>
<link href="${pageContext.request.contextPath}/js/tools/totop/css/animateToTop.css" rel="stylesheet" type="text/css" />	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/totop/js/animateToTop.js"></script>
<script type="text/javascript">
$(function (){
	$(window).animateToTop({
		showHeight : 100,	//设置滚动高度时显示 
		speed : 500 	//返回顶部的速度以毫秒为单位 
	});
});
</script>