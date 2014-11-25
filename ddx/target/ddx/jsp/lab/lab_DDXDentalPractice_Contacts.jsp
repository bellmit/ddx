<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="General_middle_bottom_a">联系人</div>
<div class="DDXDentalPractice_Contacts">
<form method="get" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="ebill-user-table">

	<tbody>
		<tr align="center">
			<td class="DDXDentalPractice_Contacts_a" align="center"><a
				href="javascript:void(0)">主账户</a></td>
			<td class="DDXDentalPractice_Contacts_b" align="center"><a
				href="javascript:void(0)">名字</a></td>
			<td class="DDXDentalPractice_Contacts_c" align="center"><a
				href="javascript:void(0)">邮箱</a></td>
			<td class="DDXDentalPractice_Contacts_d" align="center"><a
				href="javascript:void(0)">角色</a></td>
		</tr>
		<c:if test="${!empty datas}">
			<c:forEach items="${datas}" var="data">
				<tr align="center">
					<td align="center">
						<c:choose>
							<c:when test="${data.isMain=='true'}">
								<input type="checkbox" checked="checked" disabled="disabled"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" disabled="disabled"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td align="center">${data.firstName }${data.lastName }</td>
					<td align="center"><a href="mailto:${data.email}">${data.email }</a></td>
					<td align="center">${datau.role }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty datas}">
			<tr align="center">
				<td colspan="4" align="center">没有启用电子账单</td>
			</tr>
		</c:if>
	</tbody>
</table>
</form>
<div class="Addone"></div>
</div>