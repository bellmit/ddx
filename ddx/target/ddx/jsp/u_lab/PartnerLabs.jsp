<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<form action="" method="get">
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td class="PartnerLabsadmin_a"><a href="#">技工间</a></td>
    <td class="PartnerLabsadmin_b"><a href="#">城市</a></td>
    <td class="PartnerLabsadmin_c"><a href="#">电话号码</a></td>
    <td class="PartnerLabsadmin_a"><a href="#">申请状态</a></td>
    <td class="PartnerLabsadmin_e" style="width: auto;"></td>
  </tr>
	<c:forEach items="${listPartnerLab}" var="PartnerLab">
		<tr>
			<td>${PartnerLab.name }</td>
			<td>${PartnerLab.city }</td>
			<td>${PartnerLab.phoneNumber }</td>
			<c:if test="${PartnerLab.accountStatus ==0}">
				<td>
					审批通过
				</td>
			</c:if>
			<c:if test="${PartnerLab.accountStatus ==1}">
				<td>
					已关闭
				</td>
			</c:if>
			<c:if test="${PartnerLab.accountStatus ==2}">
				<td>
					待审批
				</td>
			</c:if>
			<c:if test="${PartnerLab.accountStatus !=0 and PartnerLab.accountStatus !=1 and PartnerLab.accountStatus !=2}">
				<td>
					状态数据异常，请联系管理员
				</td>
			</c:if>
			<td>
			<div class="PartnerLabsadmin_f">
				<a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${PartnerLab.id}"></a>
			</div>
			</td>
		</tr>
	</c:forEach>
</table>
<s:authorize ifAllGranted="ROLE_LAB">
	<div class="PartnerLabsadmin_h"><a href="javascript:void(0)" onclick="$('#Search-PartnerLabs-div').show()"></a></div>
</s:authorize>
</form>
