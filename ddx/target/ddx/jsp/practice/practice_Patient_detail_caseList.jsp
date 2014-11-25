<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="Cases_bottom_right_a">订单</div>
<div class="LabDetails_b">
<div class="Settings_Practices" style="margin-left: 0px;">
<div class="Settings_Practices_top"></div>
<div class="Settings_Practices_middle">
<form action="" method="get">
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.casesPm.frist }到${datas.casesPm.last }共${datas.casesPm.total }个</div>
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${datas.casesPm.offset==datas.casesPm.totalPage and datas.casesPm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.casesPm.offset<=datas.casesPm.totalPage and datas.casesPm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${datas.casesPm.offset-1},${datas.patient.id});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.casesPm.offset<datas.casesPm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${datas.casesPm.offset-1},${datas.patient.id});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
<div class="Settings_Practices_middle_c">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr class="Settings_Practices_middle_c_a">
    <td>
    <span><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_13.jpg" class="ByMonth_a"/></a></span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>订单</span>
    <span><a href="#" class="Settings_Practices_middle_c_a_b"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab20_19.jpg"/></a></span>
    </td>
    <td> 
    <span>发票</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>主治医生</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>技工间</span>
     <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td title="发往技工间的日期">
    <span>发货日期</span>
     <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td title="从技工间回到临床的日期">
    <span>收货日期</span>
     <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
</tr>
 <c:forEach items="${datas.casesPm.datas }" var="cases">
	<tr>
	   <td>
       		<c:if test="${cases.status eq 'OPEN' && empty cases.onHoldStatus }">
       			<span title="订单进行中..." class="icon16 icon-case-open"></span>
       		</c:if>
       		<c:if test="${cases.status eq 'CLOSE' }">
       			<span title="订单已关闭" class="icon16 icon-case-closed"></span>
       		</c:if>
       		<c:if test="${cases.status eq 'OPEN' && !empty cases.onHoldStatus }">
       			<span title="订单处于搁置/延时状态 - ${cases.onHoldStatus }" class="ui-icon ui-iconx ui-icon-clock"></span>
       		</c:if>
       </td>	
       <td>
       		<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.caseId}">#${cases.caseId }</a>
			<c:forEach items="${cases.proceduresObj}" var="proName" varStatus="i">
				<blockquote>${proName.procedure_name}</blockquote>	
			</c:forEach>
		</td>
       <td>
       </td>
       <td>
       		${cases.provider }
      	</td>
       <td>
          <a href="javascript:void(0)">${cases.labName }</a>
       </td>
       <td>
       		<fmt:formatDate value="${cases.sendToLabDate }" type="date" />
       </td>
       <td>
       		<fmt:formatDate value="${cases.deliveryDate }" type="date" /> 
       	</td>
	</tr>
</c:forEach>

</table>
</div>
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.casesPm.frist }到${datas.casesPm.last }共${datas.casesPm.total }个</div>
<div class="Settings_Practices_middle_b_right">
<c:choose>
	<c:when test="${datas.casesPm.offset==datas.casesPm.totalPage and datas.casesPm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.casesPm.offset<=datas.casesPm.totalPage and datas.casesPm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${datas.casesPm.offset-1},${datas.patient.id});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.casesPm.offset<datas.casesPm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${datas.casesPm.offset-1},${datas.patient.id});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
</form>
</div>
<div class="Settings_Practices_bottom"></div>
</div>
</div>
