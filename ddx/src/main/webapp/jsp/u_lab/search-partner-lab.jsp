<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<li id="PartnerLabsadmin_g" class="abscdefg">搜索结果</li>
<li>
<div class="PartnerLabsadmin" id="PartnerLabsadmin-div">
<form action="" method="get">
<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0" id="searchLab-table">
	<tr
		style="font-size: 14px; font-weight: bold; height: 30px; background-color: #DCEDF7">
		<td class="" width="15%">技工间</td>
		<td class="" width="10%">省份</td>
		<td class="" width="10%">城市</td>
		<td class="" width="10%">电话号码</td>
		<td class="" width="30%">服务项目</td>
		<td class="" width="5%"></td>
	</tr>
	<c:if test="${empty searchLab}">
		<tr>
			<td colspan="6" align="center"><font color="red">根据你的条件没有找到相关技工间！</font></td>
		</tr>
	</c:if>
	<c:if test="${!empty searchLab}">
		<c:forEach items="${searchLab}" var="PartnerLab">
			<tr>
				<td>${PartnerLab.name }</td>
				<td>${PartnerLab.state }</td>
				<td>${PartnerLab.city }</td>
				<td>${PartnerLab.phoneNumber }</td>
				<td>${PartnerLab.services }</td>
				<td align="right">
					<div class="PartnerLabsadmin_f"><a
						href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${PartnerLab.id }"></a>
					</div>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</form>
</div>
</li>



