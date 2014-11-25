<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<li class="dropdown_search">患者</li>
<c:forEach items="${patientPm.datas }" var="patient">
	<li class="dropdown_search01">
	<c:if test="${user.unitType == '1' }">
		<a href="${pageContext.request.contextPath}/labAction/reports/patient.do?id=${patient.id}" >${patient.firstName },${patient.lastName }</a>
	</c:if>
	<c:if test="${user.unitType == '2' }">
		<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patient&id=${patient.id}" >${patient.firstName },${patient.lastName }</a>
	</c:if>
	</li>
</c:forEach>
<c:if test="${patientPm.total > patientPm.last }">
	<li class="dropdown_search01"><a href="${pageContext.request.contextPath}/casesAction/default/search.do?q=${q}&type=patients" ><em>查看剩余的 ${patientPm.total - patientPm.last } 条记录</em></a></li>
</c:if>
<c:if test="${patientPm.total == 0 }">
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
		<li class="dropdown_search04" title="订单处于搁置/延时状态-${cases.onHoldStatus }">
	</c:if>
	<c:if test="${user.unitType == '1' }">
		<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${cases.caseId }">
		订单号 #${cases.caseId } 
		for 接收方 ${cases.practice } 
		for 患者 ${cases.patient }
		<c:if test="${ !empty cases.procedures }">
			工序(
			<c:forEach items="${cases.proceduresObj }" var="obj">
				<em>${obj.procedure_name}</em>&nbsp;&nbsp;
			</c:forEach>
			)
		</c:if> 
		</a>
	</c:if>
	<c:if test="${user.unitType == '2' }">
		<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.caseId }">
		订单号 #${cases.caseId } 
		for 接收方 ${cases.practice } 
		for 患者 ${cases.patient } 
		<c:if test="${ !empty cases.procedures }">
			工序(
			<c:forEach items="${cases.proceduresObj }" var="obj">
				<em>${obj.procedure_name}</em>&nbsp;&nbsp;
			</c:forEach>
			)
		</c:if> 
		</a>
	</c:if>
	</li>
</c:forEach>
<c:if test="${casesPm.total > casesPm.last }">
	<li class="dropdown_search01"><a href="${pageContext.request.contextPath}/casesAction/default/search.do?q=${q}&type=cases"><em>查看剩余的 ${casesPm.total - casesPm.last } 条记录</em></a></li>
</c:if>
<c:if test="${casesPm.total == 0 }">
	<li class="dropdown_search01">没有找到你要的数据</li>
</c:if>

