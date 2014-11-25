<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="Patients">
<div class="Patients_a">
<c:if test="${multiFilters.filterBy == 'toArrive' }">
即将抵达的订单
</c:if>
<c:if test="${multiFilters.filterBy == 'toShip' }">
即将发货的订单
</c:if>
<c:if test="${multiFilters.filterBy != 'toShip' && multiFilters.filterBy != 'toArrive' }">
<c:choose>
	<c:when test="${multiFilters.filterBy == 'byMonth' }">
		${multiFilters.year }年${multiFilters.month }月的订单
	</c:when>
	<c:otherwise>
		<%=ToolsKit.DateUtil.formatDate(new Date(),"yyyy年MM月") %>的订单
	</c:otherwise>
</c:choose>
</c:if>
<input type="hidden" id="reqAccLabId" value="${reqAccLabId }" />
</div>
<div class="Patients_b">
<div class="Patients_b_top"></div>
<div class="Patients_b_middle">
<form action="" method="get">
<div class="Patients_b_middle_a">
<div class="Patients_b_middle_a_left">
</div>
<div class="Patients_b_middle_a_right">
<ul>
<li class="ByMonth"><a href="javascript:void(0)" id="filter">过滤</a></li>
</ul>
</div>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${pm.frist }到${pm.last },共${pm.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${pm.offset==pm.totalPage and pm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${pm.offset<=pm.totalPage and pm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listCases(${pm.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pm.offset<pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listCases(${pm.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="cases-list">
  <tr class="Patients_b_middle_c_a">
    <th>
    <span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_13.jpg" class="ByMonth_a"/></a></span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
    <th>
    <span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_16.jpg" class="ByMonth_a"/></a></span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
   <th>
    <span>订单</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
    <th>
    <span>发票</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
    <th>
    <span>下单机构</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
    <th>
    <span>患者</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
    <th title="临床发出日期">
    <span>预寄出时间</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
    <th title="技工间发货日期">
    <span>预寄回时间</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
    <th title="从技工间返回的日期">
    <span>预交付时间</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </th>
</tr>

<c:forEach items="${pm.datas}" var="cases" varStatus="i">
	<c:choose>
		<c:when test="${(i.index+1)%2 eq 1 }">
			<tr class="odd">
		</c:when>
		<c:otherwise>
			<tr class="even">
		</c:otherwise>
	</c:choose>
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
		</td>
		<td>
			<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.caseId }" >#${cases.caseId }</a>
			<c:forEach items="${cases.proceduresObj}" var="proName" varStatus="i">
				<blockquote>${proName.procedure_name}</blockquote>	
			</c:forEach>
		</td>
		<td></td>
		<td>${cases.practice }</td>
		<td>${cases.patient }</td>
		<td><fmt:formatDate value="${cases.sendToLabDate }" type="date"/></td>
		<td><fmt:formatDate value="${cases.shipDate }" type="date"/></td>
		<td><fmt:formatDate value="${cases.deliveryDate }" type="date"/></td>
		
	</tr>
</c:forEach>

</table>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${pm.frist }到${pm.last },共${pm.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${pm.offset==pm.totalPage and pm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${pm.offset<=pm.totalPage and pm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listCases(${pm.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pm.offset<pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listCases(${pm.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
<!--中间结束-->

<!-- 过滤弹出窗 start -->
<div id="change_filter" style="width: auto; min-height: 45.4333px; height: auto;display: none;" scrolltop="0" scrollleft="0">
	<jsp:include page="filter_template_part.jsp" />
</div>
<!-- 过滤弹出窗 end -->

<script type="text/javascript">
	$(function(){
        $("#filter").click(function(){
            $("#change_filter").dialog({
            	title:'更改过滤',
                resizable: false,
                modal: true,
                buttons: {
                    "取消": function() {
                        $(this).dialog("close");
                    },
                    "应用": function() {
                    	$('form#filter').submit();
                    	$(this).dialog("destroy");
                    }
                }
            });
        });
	});
	
	function changeFilter(){
		var byValue = $('#By').val();
		if(byValue == '1'){
			$(".box_appointment_filter").hide();
			$(".box_appointment_filtercenter").hide();
		}else{
			$(".box_appointment_filter").show();
			$(".box_appointment_filtercenter").show();
		}
	}
</script> 

