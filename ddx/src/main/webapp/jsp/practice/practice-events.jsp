<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" id="start-date" value="${startDate }"/>
<c:forEach items="${datas}" var="d">
	<li>
		<div class="practiceindex_a_middle_bottom_middle_middle_top"></div>
		<div class="practiceindex_a_middle_bottom_middle_middle_middle" style="height: 180px;">
			<dl>
				<dt>
					<div class="practiceindex_a_middle_bottom_middle_middle_middle_left">
						${d.day }
					</div>
					<div class="practiceindex_a_middle_bottom_middle_middle_middle_right">
						<a href="#"><img src="${pageContext.request.contextPath }/jsp/practice/images/practice40_03.jpg"></a>
					</div>
				</dt>
				<c:forEach items="${d.data}" var="dd">
					<dd>
						<span class="practice_order"><a href="#"><img src="${pageContext.request.contextPath }/jsp/practice/images/practice15_10.jpg"></a></span>
						<span class="practice_order01">订单&nbsp;#<a href="${pageContext.request.contextPath }/casesAction/getDataById.do?caseId=${dd.primaryId }">${dd.primaryId }</a>&nbsp;${dd.remarks }</span>
					</dd>
				<div class="box_clear"></div>
				</c:forEach>
				<dd></dd>
			</dl>
		</div>
		<div class="practiceindex_a_middle_bottom_middle_middle_bottom"></div>
	</li>
</c:forEach>
