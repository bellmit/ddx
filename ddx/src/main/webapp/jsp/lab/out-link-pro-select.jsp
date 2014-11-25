<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<select size="1" name="" id="out-link-pro">
<option value=""></option>
<c:forEach items="${datas.listPro}" var="pro">
	<c:choose>
		<c:when test="${datas.link.outProceduresId==pro.proceduresId}">
			<option value="${pro.proceduresId }" selected="selected">
				${pro.displayName }
			</option>
		</c:when>
		<c:otherwise>
			<option value="${pro.proceduresId }">
				${pro.displayName }
				</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>
