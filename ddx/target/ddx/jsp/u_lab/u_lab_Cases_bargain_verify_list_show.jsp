<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" deferredSyntaxAllowedAsLiteral="true" %>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/u_lab/js/list_cases.js"></script>
 
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="Patients">
<div class="Patients_a">
<c:choose>
	<c:when test="${datas.viewType == 'bargain_request' }">
		优惠申请列表
	</c:when>
	<c:otherwise>
		优惠审批列表						
	</c:otherwise>
</c:choose>
</div>
<div class="Patients_b">
<div class="Patients_b_top"></div>
<div class="Patients_b_middle">
<form action="" method="get">
<div class="Patients_b_middle_a">
<div class="Patients_b_middle_a_left">
</div>
<div class="Patients_b_middle_a_right">
</div>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${datas.pm.frist }到${datas.pm.last },共${datas.pm.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${datas.pm.offset==datas.pm.totalPage and datas.pm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.pm.offset<=datas.pm.totalPage and datas.pm.offset>1}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.pm.offset-1},'bargainVerify');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.pm.offset<datas.pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.pm.offset+1},'bargainVerify');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
<div class="Patients_b_middle_c">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="cases">
  <tr class="Patients_b_middle_c_a">
  	<td>
    <span>序号</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>订单</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>订单金额</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>申请金额</span>
    </td>
    <td>
    <span>申请人</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>申请日期</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>状态</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td><span>操作</span></td>
</tr>

<c:forEach items="${datas.pm.datas}" var="cbr" varStatus="i">
	<c:choose>
		<c:when test="${(i.index+1)%2 eq 1 }">
			<tr class="odd" data-id="${cbr.caseId}">
		</c:when>
		<c:otherwise>
			<tr class="even" data-id="${cbr.caseId}">
		</c:otherwise>
	</c:choose>
		<td>${cbr.id }</td>
		<td><a id="hasUnderLine" href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${cbr.caseId }" >#${cbr.caseId }</a></td>
		<td>${cbr.originalPrice }</td>
		<td>${cbr.askPrice }</td>
		<td>${cbr.applicantName }</td>
		<td><fmt:formatDate value="${cbr.askDate }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>
			<c:choose>
				<c:when test="${ !empty cbr.status }">
					已审批
				</c:when>
				<c:otherwise>
					未审批
				</c:otherwise>
			</c:choose>
		</td>
		<td class="UserAccounts_a">
				<c:choose>
					<c:when test="${ !empty cbr.status }">
						<c:choose>
							<c:when test="${datas.viewType == 'bargain_request' }">
								<a href="${pageContext.request.contextPath}/casesAction/viewBargainRequest.do?id=${cbr.id}">查看</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/casesAction/viewBargainVerify.do?id=${cbr.id}">查看</a>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${datas.viewType == 'bargain_request' }">
								<a href="${pageContext.request.contextPath}/casesAction/goEditBargainRequest.do?id=${cbr.id}">编辑</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/casesAction/goBargainVerify.do?id=${cbr.id}">审批</a>							
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			
		</td>
		
	</tr>
</c:forEach>

</table>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${datas.pm.frist }到${datas.pm.last },共${datas.pm.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${datas.pm.offset==datas.pm.totalPage and datas.pm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.pm.offset<=datas.pm.totalPage and datas.pm.offset>1}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.pm.offset-1},'bargainVerify');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.pm.offset<datas.pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.pm.offset+1},'bargainVerify');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
<div class="Patients_b_bottom"></div>
</div>
</div>
<!--工厂实验室会员中心结束-->
</div>
