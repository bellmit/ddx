<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" deferredSyntaxAllowedAsLiteral="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/u_lab/js/list_cases.js"></script>
<script id="shipTmpl" type="text/x-jquery-tmpl">
<div title="发货订单">
<p>以下是发货订单的处理结果：</p>
<dl>
{{tmpl(ct) "#shipItems"}}
</dl>
</div>
</script>
<script id="shipItems" type="text/x-jquery-tmpl">
<dt>订单 #{{= id }}</dt>
<dd>{{= msg }}</dd>
</script>

<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="Patients">
<div class="Patients_a">待发货订单</div>
<div class="Patients_b">
<div class="Patients_b_top"></div>
<div class="Patients_b_middle">
<form action="" method="get">
<div class="Patients_b_middle_a">
<div class="Patients_b_middle_a_left">
</div>
<div class="Patients_b_middle_a_right">
<ul>
<li class="ToShip"><a href="javascript:;" id="ship_action">发货</a></li>
<li class="ToArrive_b"><a href="javascript:;" id="scan_action">浏览</a></li>
<li class="ByMonth"><a href="javascript:;" id="filter_action">过滤</a></li>
</ul>
</div>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${datas.shipPm.frist }到${datas.shipPm.last },共${datas.shipPm.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${datas.shipPm.offset==datas.shipPm.totalPage and datas.shipPm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.shipPm.offset<=datas.shipPm.totalPage and datas.shipPm.offset>1}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.shipPm.offset-1},'toShip');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.shipPm.offset<datas.shipPm.totalPage}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.shipPm.offset+1},'toShip');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="cases" class="cases-list">
  <tr class="Patients_b_middle_c_a">
    <td>
    <span><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_13.jpg" class="ByMonth_a"/></a></span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_16.jpg" class="ByMonth_a"/></a></span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
   <td>
    <span>订单</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>发票</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>下单机构</span>
    </td>
    <td>
    <span>医生 </span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>患者</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span title="技工间发货的日期">预寄出时间</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span title="交付给临床的日期">预交付时间</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td title="全选/取消">
    	<input type="checkbox" id="caseCheckAll"/>
    </td>
</tr>
<c:forEach items="${datas.shipPm.datas}" var="cases" varStatus="i">
	<c:choose>
		<c:when test="${(i.index+1)%2 eq 1 }">
			<tr class="odd" data-id="${cases.caseId}">
		</c:when>
		<c:otherwise>
			<tr class="even" data-id="${cases.caseId}">
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
        <td></td>
		<td>
			<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${cases.caseId }&labId=${requestAccountLab.id }&patientId=${cases.patientId}" >#${cases.caseId }</a>
			<c:forEach items="${cases.proceduresObj}" var="proName" varStatus="i">
				<blockquote>${proName.procedure_name}</blockquote>	
			</c:forEach>
		</td>
		<td></td>
		<td>${cases.practice }</td>
		<td>${cases.provider }</td>
		<td>${cases.patient }</td>
		<td><fmt:formatDate value="${cases.shipDate }" type="date"/></td>
		<td><fmt:formatDate value="${cases.deliveryDate }" type="date"/></td>
		<td>
			<input type="checkbox" data-id="${cases.caseId}" value="1" name="toShip">
		</td>
	</tr>
</c:forEach>
</table>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${datas.shipPm.frist }到${datas.shipPm.last },共${datas.shipPm.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${datas.shipPm.offset==datas.shipPm.totalPage and datas.shipPm.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.shipPm.offset<=datas.shipPm.totalPage and datas.shipPm.offset>1}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.shipPm.offset-1},'toShip');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.shipPm.offset<datas.shipPm.totalPage}">
				<span><a href="javascript:void(0)" onclick="queryCasesList(${datas.shipPm.offset+1},'toShip');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
<div id="change_filter" class="ui-dialog-content ui-widget-content" style="width: auto; min-height: 45.4333px; height: auto;display: none;" scrolltop="0" scrollleft="0">
	<jsp:include page="filter_template.jsp" />
</div>
<!-- 过滤弹出窗 end -->

<script type="text/javascript">
$(function(){
	 $("#filter_action").click(function(){

         $("#change_filter").dialog({
        	 title:'过滤',
             resizable: false,
             modal: true,
             buttons: {
                 "取消": function() {
                     $(this).dialog("close");
                 },
                 "应用": function() {
                	 listFilter();
                	 $(this).dialog("destroy");
                 }
             }
         });
         
     });
	 
$('#ship_action').click(function() {
    var checked = [];
    $("#cases").find("input[name='toShip']:checked").each(function(){
        checked.push($(this).data("id"));
    });
    if (checked.length > 0) {
    	if(confirm('您确定要执行此操作吗？')){
	        $.getJSON(
	            "${pageContext.request.contextPath}/casesAction/lab/cases/ship.do",
	            {"cases[]": checked},
	            function(d) {
	            	//var d = eval('('+ d +')');
	                if (d.hasOwnProperty("success") && d.success == true) {
	
	                    $("#shipTmpl").tmpl(d).appendTo("body").dialog({
	                        modal: true,
	                        buttons: {
	                            Ok: function() {
	                                $( this ).dialog( "close" );
	                            }
	                        },
	                        height: 500,
	                        close:function(){
	                        	window.location.reload();
	                        }
	                    });
	
	                    /* for (var i in checked) {
	                        $("#cases").find("input[data-id=" + checked[i] +"]").parent().parent().remove();
	                    } */
	                }
	            }
	        );
    	}
    } else {
    	ShowInfoTip('请选择具体的订单');
    }
});

$('#scan_action').click(function(){
	window.location.href = webContext + '/casesAction/scanShipCase.do'	
});

$('#caseCheckAll').click(function(){
	$('input[name=toShip]').attr('checked',this.checked);		
});

});
</script>
