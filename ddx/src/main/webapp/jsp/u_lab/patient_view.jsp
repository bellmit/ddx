<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/reports_patients.js"></script> 


<div class="box_clear"></div>
<div class="Patients_b_middlecenter">订单</div>
<div class="Patients_b_middlebottom">
<div class="Patients_b_middlebottom_a">
<div class="Patients_b_middlebottom_aleft">显示从${casesPm.frist }到${casesPm.last },共${casesPm.total }个</div>
<div class="Patients_b_middlebottom_aright">
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${casesPm.offset==casesPm.totalPage and casesPm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${casesPm.offset<=casesPm.totalPage and casesPm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${casesPm.offset-1},${patient.id},'paging');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${casesPm.offset<casesPm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${casesPm.offset+1},${patient.id},'paging');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
</div>
<div class="Patients_b_middlebottom_b">
<table width="930">
  <tr class="Patients_b_middlebottom_btr">
    <td>
    <span><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_13.jpg" class="ByMonth_a"/></a></span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>订单</span>
    <span><a class="Settings_Practices_middle_c_a_b" href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg" width="7" height="4" /></a></span>
    </td>
    <%-- <td>
    <span>发票</span>
    <span>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" width="7" height="4"></a></div>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" width="7" height="4"></a></div>
    </span>
    </td> --%>
    <td>
    <span>提供者</span>
    <span>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" width="7" height="4"></a></div>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" width="7" height="4"></a></div>
    </span>
    </td>
    <td>
    <span>临床</span>
    <span>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" width="7" height="4"></a></div>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" width="7" height="4"></a></div>
    </span>
    </td>
    <td title="技工间发货日期">
    <span>预寄回时间</span>
    <span>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" width="7" height="4"></a></div>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" width="7" height="4"></a></div>
    </span>
    </td>
    <td title="临床收货日期">
    <span>预交付时间</span>
    <span>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" width="7" height="4"></a></div>
    <div class="Settings_Practices_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" width="7" height="4"></a></div>
    </span>
    </td>
  </tr>
   <c:forEach items="${casesPm.datas }" var="cases">
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
       		<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${cases.caseId}">#${cases.caseId }</a>
			<c:forEach items="${cases.proceduresObj}" var="proName">
				<blockquote>${proName.procedure_name}</blockquote>	
			</c:forEach>
		</td>
      <!--  <td>
       		发票（静态）
       </td> -->
       <td>
       		${cases.provider }
      	</td>
       <td>
          <a href="javascript:void(0)">${cases.practice }</a>          
       </td>
       <td>
       		<fmt:formatDate value="${cases.shipDate }" type="date" />
       </td>
       <td>
       		<fmt:formatDate value="${cases.deliveryDate }" type="date" /> 
       	</td>
	</tr>
</c:forEach>
</table>

</div>
<div class="Patients_b_middlebottom_c">
<div class="Patients_b_middlebottom_aleft">显示从${casesPm.frist }到${casesPm.last },共${casesPm.total }个</div>
<div class="Patients_b_middlebottom_cright">
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${casesPm.offset==casesPm.totalPage and casesPm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${casesPm.offset<=casesPm.totalPage and casesPm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${casesPm.offset-1},${patient.id},'paging');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${casesPm.offset<casesPm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatientCases(${casesPm.offset+1},${patient.id},'paging');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
</div>
</div>

