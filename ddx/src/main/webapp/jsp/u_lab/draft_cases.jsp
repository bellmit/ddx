<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/practice/js/practice_index.js"></script>
<script type="text/javascript">
$(function(){		
	 $(".menu_all .menuright").click(function(){
		$(this).find(".menuright01").toggle();
		$(this).siblings().find(".menuright01").hide();
	});			
	 $(document).on('click', function(e) {
   		if ($('.menu_all li').is(e.target) || $('.menu_all li').has(e.target).length) {
     		return;
		}
        $('.menuright01').hide();

	});
});
</script>
<!--效果开始-->
<form action="" method="get">
<c:choose>
	<c:when test="${draftPm.total == 0 }">
		草案不存在
	</c:when>
	<c:otherwise>
		<dl class="practiceindexright_dl">
		<dt class="practiceindexright_dt">详情</dt>
		<dd class="practiceindexright_dd">操作</dd>
	</dl>
	<p style="clear: both;"></p>
	
	<c:forEach items="${draftPm.datas }" var="draft">
		<dl class="practiceindexright_dl01">
		<dt class="practiceindexright_dt01">
			<a href="javascript:void(0)" onclick="resumeCase(${draft.caseId});">
			 草案 <strong>#${draft.caseId }</strong>
			<c:if test="${ !empty draft.patient }">
				患者为:<strong>${draft.patient }</strong>
			</c:if>
			<c:if test="${ !empty draft.labName }">
				发给:<strong> ${draft.labName }</strong>											
			</c:if>
			</a>
		</dt>
		<dd class="practiceindexright_dd01">
			<ul class="menu_all">
				<li class="menuright"><a href="javascript:void(0)"></a>
					<ul class="menuright01" style="margin-left: -90px;">
						<li class="menuright02">
							<p class="menuright03">
								<a href="javascript:void(0)" onclick="resumeCase(${draft.caseId});">继续</a>
							</p>
							<p class="menuright03">
								<a href="javascript:void(0)" onclick="delCase(${draft.caseId})">删除</a>
							</p></li>
					</ul></li>
			</ul>
		</dd>
	</dl>
	
	</c:forEach>
	<p style="clear: both;"></p>
	</c:otherwise>
</c:choose>
	
</form>
<!--效果结果-->