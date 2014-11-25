<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp"></jsp:include>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>抵达订单浏览</title>
<link href="${pageContext.request.contextPath }/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 

</head>

<body> 
<div class="page">
<!--头部开始-->
<jsp:include page="../head.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery.tablesorter.widgets.min.js"></script>
<script id="scannedTmpl" type="text/x-jquery-tmpl">
<tr>
<td>{{= caseId}}</td>
<td>{{= msg}}</td>
<td>
<span data-timestamp="{{= createDate}}">{{= msg1}}</span>
</td>
</tr>
</script>
<script type="text/javascript">
$(function(){
	 $("#scan_results").tablesorter();
	 var tableInited = false;
	 $("#scans").focus();
	 $("#scans").change(function(){
		    var $scans = $(this);

		    if ($scans.val().length > 0) {
		        $.getJSON(
		            "${pageContext.request.contextPath}/casesAction/lab/cases/arrive/search.do",
		            {
		                "caseId":$scans.val()
		            },
		            function(d) {
		                if (d.hasOwnProperty("flag") && d.flag == 'success') {
		                    $scans.val("");
		                    $scans.focus();
		                    var $scan_results = $("#scan_results");
		                     if (!tableInited) {
		                        $("#scannedTmpl").tmpl(d.obj).appendTo($scan_results);

		                       $scan_results.show().tablesorter({
		                            sortList: [[3,1]],
		                            widgets: ["zebra"],
		                            headers: {
		                                2: {
		                                    sorter: "createDate"
		                                }
		                            },
		                            textExtraction: function(node) {
		                                return node.innerHTML;
		                            }
		                        });
		                        tableInited = true;

		                    } else {
		                        $("#scannedTmpl").tmpl(d.obj).appendTo($scan_results);
		                    }  
		                } else {
		                    $("#scan_error").dialog({
		                        modal: true,
		                        buttons: {
		                            Ok: function() {
		                                $( this ).dialog( "close" );
		                            }
		                        }
		                    });
		                }
		            }
		        );
		    }
		});
	 
});

</script>
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">订单</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="../u_lab/u_lab_Cases_leftMenu.jsp" />
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">浏览收到的订单</div>
<div class="Scan">
<div class="Scan_a">浏览</div>
<div class="Scan_b">
<div class="Scan_b_top"></div>
<div class="Scan_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="Scan_b_middle_left">订单浏览</div>
<div class="Scan_b_middle_right">
	<input name="scans" id="scans" type="text" class="Scan_b_middle_b"/>
</div>
</li>
</ul>
</form>
</div>
<div class="Scan_b_bottom"></div>

<div>
</div>

</div>
<p></p>
<div>
<table id="scan_results" class="grid sortable no_pointer" style="width: 100%;display: none;">
<thead>
<tr class="Patients_b_middle_c_a">
<th style="width: 30%">
<span>Case</span>
<div> </div>
</th>
<th style="width: 40%">
<span>Result</span>
<div> </div>
</th>
<th style="width: 30%">
<span>Time</span>
</th>
</tr>
</thead>
<tbody>
</tbody>
</table>
</div>

<div id="scan_error" style="display: none" title="Scan Error">
	<p>查询过程中发生错误，请重试.</p>
</div>

</div>
</div>

</div>
</div>
</div>
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp" />
<!--底部结束-->
</div>
</body>
</html>
