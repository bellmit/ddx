<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<title>订单详细</title>
<link href="${pageContext.request.contextPath }/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/lab/css/lab.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath }/jsp/box/css/box.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath }/jsp/lab/css/form.css" rel="stylesheet" type="text/css"/>  
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/lab-dealCase.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/u_lab_cases.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/teeth_selector.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/bargain-request.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/ckeditor/ckeditor.js"></script>
</head>

<body> 
<script type="text/javascript" language="javascript">
$(".General_middle_top li ").live("click",function(){
	$(".General_middle_top li a").css({"backgroundColor":"none","color":"#000"});
		$("a",this).css({"backgroundColor":"none","color":"#1591f9"});
	});
	</script>
<div class="page">
<!--头部开始-->
<jsp:include page="../head.jsp" />
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂技工间会员中心开始-->
<div class="gcsyshyzx">
<div class="Cases">
<div class="Cases_top">订单</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="../u_lab/u_lab_Cases_leftMenu.jsp" />
</div>
<div class="Cases_bottom_right" id="lab_case_details_content">
<div class="LabDetails">
<div class="LabDetails_a">
<div class="LabDetails_a_left">
订单#${cases.caseId }

<input type="hidden" id="isTryIn" value="${cases.isTryIn }"/>
<input type="hidden" id="status" value="${cases.status }"/>
<input type="hidden" id="arrived" value="${cases.arrived }"/>
<input type="hidden" id="shipped" value="${cases.shipped }"/>
<form name="casesDetailForm" action="${pageContext.request.contextPath }/casesAction/getDataById.do" method="post">
<input type="hidden" name="caseId" value="${cases.caseId }" id="tryInCaseId" />
<%--伙伴技工间ID --%>
<input type="hidden" name="labId" value="${requestAccountLab.id }" />
</form>
</div>
<div class="LabDetails_a_right">
<ul>
<li class="LabDetails_a_right_a"><a id="cancelBtn" href="javascript:void(0)" onclick="cancel();">取消</a></li>
<li class="LabDetails_a_right_b">
 <!--小菜单下拉开始-->
   <ol class="menu_all">
     <li class="first first01">
		<a href="javascript:void(0)">操作</a>    
	     <ol id="menuu_s01" class="menuu_s">
		     <li style=" width:160px;">
		       <ol class="menu_bgrightcenter">
		     	<li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
				<li class="menu_bgrighttop01" id="return_tryin_li" style="display: none;"><a href="javascript:void(0)" id="return_tryin_action">返回试戴</a></li>		     	
				<li class="menu_bgrighttop01" id="arrive_case_li" style="display: none;"><a href="javascript:void(0)" id="arrive_case_action">抵达订单</a></li>
				<li class="menu_bgrighttop01" id="mark_as_tryin_li" style="display: none;"><a href="javascript:void(0)" id="mark_as_tryin_li_action">标记为试戴订单</a></li>
				<li class="menu_bgrighttop01" id="add_note_li"><a href="javascript:void(0)" id="add_note_action">订单备注</a></li>
				<li class="menu_bgrighttop01" id="attach_files_li"><a href="javascript:void(0)" id="attach_files_action">上传文件</a></li>
				<li class="menu_bgrighttop01" id="change_status_li"><a href="javascript:void(0)" id="change_status_action">改变状态</a></li>
				<li class="menu_bgrighttop01" id="shipping_li" style="display: none;"><a href="javascript:void(0)" id="shipping_action">Shipping</a></li>
				<li class="menu_bgrighttop01" id="outsource_li"><a href="javascript:void(0)" id="outsource_action">外包订单</a></li>
				<li class="menu_bgrighttop01" id="close_li" style="display: none;"><a href="javascript:void(0)" id="close_action">关闭订单</a></li>
				<c:if test="${ empty cases.couponCode }">
					<li class="menu_bgrighttop01" id="add_coupon_li" style="display: none;"><a href="javascript:void(0)" id="add_coupon_action">使用优惠券</a></li>
				</c:if>
				<li class="menu_bgrighttop01" id="work_ticket_li"><a href="javascript:void(0)" id="work_ticket_action">打印工作单</a></li>
				<li class="menu_bgrighttop01" id="bargain_li"><a href="javascript:void(0)" id="bargain_action">议价</a></li>
		     	<li class="menu_bgrightbottom"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg" width="160" height="4" /></li>
		       </ol>
		     </li>
	     </ol>
     </li>
</ol>
</li>
</ul>
</div>
</div>
<div class="LabDetails_b">
<div class="LabDetails_b_left">
<dl>
<dt>临床:</dt>
<dd><a href="javascript:void(0)" onclick="getPractice();">${cases.practice }</a></dd>

<c:choose>
	<c:when test="${cases.practiceId != null }">
	</c:when>
	<c:otherwise>
		<dt>医生:</dt>
		<dd>
			${cases.provider }
		</dd>
	</c:otherwise>
</c:choose>
<c:if test="${ !empty cases.couponCode}">
<dt>优惠券:</dt>
<dd>
	${cases.couponCode }
</dd>
</c:if>
<dt>试戴:</dt>
<dd>
<c:choose>
	<c:when test="${cases.isTryIn == 'Y' }">
		是	
	</c:when>
	<c:otherwise>
		否
	</c:otherwise>
</c:choose>
</dd>

<dt>紧急:</dt>
<dd>
<c:choose>
	<c:when test="${cases.isEmeger == 'Y' }">
		是	
	</c:when>
	<c:otherwise>
		否
	</c:otherwise>
</c:choose>
</dd>

</dl>
</div>
<div class="LabDetails_b_right">
<dl>
<dt>患者:</dt>
<dd><a href="javascript:void(0)">${cases.patient }</a></dd>
<dt>
	<span>患者预约:</span>
	<c:if test="${cases.status eq 'OPEN' }">
		<span><a href="javascript:void(0)" id="lab_patient_appt_action"><img src="${pageContext.request.contextPath }/jsp/lab/images/Lab80_03.jpg"/></a></span>
	</c:if>
</dt>
<dd>
<c:choose>
	<c:when test="${cases.patAppDate != null }">
		<fmt:formatDate value="${cases.patAppDate }" type="both" pattern="yyyy-MM-dd HH:mm"/>
	</c:when>
	<c:otherwise>
		没有预约	
	</c:otherwise>
</c:choose>
</dd>
<c:if test="${!empty cases.tags }">
<dt>标签:</dt>
<dd>${cases.tags }</dd>
</c:if>
</dl>
</div>
</div>
<div class="LabDetails_c">日程表</div>
<div class="LabDetails_b">
<div class="LabDetails_b_left">
<dl>
<dt>建单时间:</dt>
<dd>
<c:choose>
	<c:when test="${cases.createDate != null }">
		<fmt:formatDate value="${cases.createDate }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>	
	</c:when>
	<c:otherwise>
		&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
</dd>
<c:if test="${cases.lastUpdateDate != null }">
<dt>最新更新日期:</dt>
<dd>
	<fmt:formatDate value="${cases.lastUpdateDate }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>	
</dd>
</c:if>

<dt>预寄出时间:</dt>
<dd>
<c:choose>
	<c:when test="${cases.sendToLabDate != null }">
		<fmt:formatDate value="${cases.sendToLabDate }" type="date" />	
	</c:when>
	<c:otherwise>
		&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
</dd>
<c:if test="${cases.arrived eq 1 }">
<dt>预抵达时间:</dt>
<dd>
<c:choose>
	<c:when test="${cases.arriveDate != null }">
		<fmt:formatDate value="${cases.arriveDate }" type="date" pattern="yyyy-MM-dd"/>	
	</c:when>
	<c:otherwise>
		&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
</dd>
</c:if>
<dt>
	<span>预交付时间:</span>
	<span>
		<c:if test="${cases.status eq 'OPEN' }">
			<a href="javascript:void(0)" id="reschedule_case_action"><img src="${pageContext.request.contextPath }/jsp/lab/images/Lab80_03.jpg"/></a>
		</c:if>
	</span>
</dt>
<dd>&nbsp;<fmt:formatDate value="${cases.deliveryDate }" type="date" pattern="yyyy-MM-dd"/>&nbsp;</dd>
</dl>
</div>
<div class="LabDetails_b_right">

<c:if test="${cases.isReturn eq 1 }">
<dl>
<dt>
<span>重制订单：</span>
</dt>
<dd>基于源订单 #<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${cases.returnSId }">${cases.returnSId }</a>
<c:if test="${ !empty cases.remakeTypeNam }">
&nbsp;(${cases.remakeTypeNam })
</c:if>
</dd>
</dl>
</c:if>

<c:if test="${ !empty cases.returnDId }">
<dl>
<dt>
<span>重制订单：</span>
</dt>
<dd>目标订单 #<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${cases.returnDId }">${cases.returnDId }</a>
<c:if test="${ !empty cases.remakeTypeNam }">
&nbsp;(${cases.remakeTypeNam })
</c:if>
</dd>
</dl>
</c:if>

<dl>
<dt>
<span>加工状态:</span>
<span>
<c:if test="${cases.status ne 'CLOSE' }">
<a href="javascript:void(0)" id="change_status"><img src="${pageContext.request.contextPath }/jsp/lab/images/Lab80_03.jpg"/></a>
</c:if>
</span>
</dt>
<dd>
<c:if test="${cases.status eq 'OPEN' }">
<c:choose>
<c:when test="${cases.onHoldStatus != null }">
	延时/搁置状态 -  
	<c:choose> 
	<c:when test="${cases.onHoldStatus == '__TRYIN__' }">
		试戴
	</c:when>
	<c:otherwise>
		${cases.onHoldStatus }
	</c:otherwise>
	</c:choose>
</c:when>
<c:otherwise>
		订单进行中...
</c:otherwise>
</c:choose>
</c:if>
<c:if test="${cases.status eq 'CLOSE' }">
	已关闭
</c:if>
</dd>
</dl>
<c:if test="${ !empty cases.shipDate}">
<dl>
<dt>预回寄时间:</dt>
<dd>
&nbsp;<fmt:formatDate value="${cases.shipDate }" type="date" pattern="yyyy-MM-dd"/>&nbsp;
</dd>
</dl>
</c:if>
<c:if test="${ !empty cases.waybillNumber }">
<dl>
<dt>货运单号#:</dt>
<dd>
&nbsp;<a href="javascript:void(0)">${cases.waybillNumber }</a>&nbsp;
</dd>
</dl>
</c:if>


<c:if test="${ !empty linkPm.datas }">
<dl>
<dt><span>外包订单链接:</span></dt>
<c:forEach items="${linkPm.datas }" var="linkCase">
	<dd>${linkCase.labName } #<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${linkCase.caseId }" style="text-decoration: underline;" >${linkCase.caseId }</a></dd>
</c:forEach>
</dl>
</c:if>
</div>
</div>

</div>
<div class="General" id="LabDetails_d">
<div class="General_top"></div>
<div class="General_middle">
<div class="General_middle_top">
<ul>
<li class="Lab_DDXDentalPractice_a"><a href="javascript:void(0)" onclick="loadTabInfo('detail');">订单详情</a></li>
<li class="Lab_DDXDentalPractice_b"><a href="javascript:void(0)" onclick="loadTabInfo('note');">备注记录(${notePm.total })</a></li>
<li class="Lab_DDXDentalPractice_c"><a href="javascript:void(0)" onclick="loadTabInfo('log');"> 订单动态(${logListPm.total })</a></li>
</ul>
</div>
<div id="detail">
<div class="General_middle_bottom">
<div class="LabDetails_e">制作工序</div>
<div class="LabDetails_f">
<form action="" method="get">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="LabDetails_f_a"><a href="#">数量</a></td>
    <td class="LabDetails_f_b"><a href="#">说明</a></td>
    <td class="LabDetails_f_c"></td>
  </tr>
  
  <c:forEach items="${proceduresList}" var="pro">
  		<tr id="${pro.index }-tr-head" class="practiceCaseDetails_bottom_middle_bottom_b" onmouseover="$(this).attr('style','background-color: #ededed;')" onmouseout="$(this).attr('style','background-color: #ffffff;')">
		    <td><a style="text-decoration: none;" href="javascript:void(0)" title="${pro.ps }">${pro.count }</a></td>
		    <td onclick="showAttr('${pro.index }');">
		    	<span>
		    		<c:if test="${pro.isTryIn == 'ok' }">
		    			<img src="${pageContext.request.contextPath}/jsp/lab/images/ok.jpg" alt="ok" />
		    			<input type="hidden" value="${pro.isTryIn }" id="caseIsTryInHidden"/>
		    		</c:if>
		    	</span>
		    	<span>${pro.procedure_name }</span>
		    	<span class="practiceCaseDetails_bottom_middle_bottom_b_c">
		    		&nbsp;&nbsp;&nbsp;
		    		<a href="javascript:void(0)" id="${pro.index }-a" flag="hide">[+]</a>
		    	</span>
		    </td>
		    <td>
		    	 <div class="LabDetails_f_e">
		    	 <c:if test="${cases.status == 'OPEN' }">
		    	 <c:if test="${pro.isTryIn != 'ok' }">
			    <div class="LabDetails_f_e_left"><a href="javascript:void(0)" onclick="loadCaseProcedure('${pro.index }','${pro.procedure_id }','${cases.caseId }','${pro.procedure_name }');">编辑</a></div>
			    <div class="LabDetails_f_e_right">
			    	<!--小菜单下拉开始-->
					   <ol class="menu_all">
					     <li class="first"><a href="javascript:void(0)"></a>         	
					     <ol class="menuu_s">
					     <li>
					       <ol class="menu_bgrightcenter">
					     <li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
					     <li class="menu_bgdelete">
					     	<a href="javascript:void(0)" onclick="deleteCaseProcedure('${pro.index }','${cases.caseId }');">删除</a>
					     </li>
					     <li class="menu_bgrightbottom"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg" width="160" height="4" /></li>
					       </ol>
					       </li>
					      </ol>
					    </li>
					  </ol>
				 	<!--小菜单下拉结束-->
			    </div>
			    </c:if>
			    <c:if test="${pro.isTryIn == 'ok' }">
			    	<strong>已完成</strong>
			    </c:if>
			    </c:if>
			    </div>
		    </td>
		  </tr>
		  <tr id="${pro.index }-tr" style="display: none;" class="LabDetails_f_h">
		  	<td style="padding: 0"></td>
		  	<td style="padding: 0">
		  		<div>
		  			<table style="width: 100%;margin-left: 20px;">
		  					<c:forEach items="${pro.attrList}" var="attr">
		  						<c:if test="${!empty attr.valueDes }">
		  							<tr>
					  					<td style="padding: 0" class="LabDetails_f_b"><strong>${attr.lable }</strong></td>
					  				</tr>
					  				<tr>
					  					<td style="padding: 0" class="LabDetails_f_b">${attr.valueDes }</td>
				  					</tr>
		  						</c:if>
		  					</c:forEach>
		  			</table>
		  		</div>
		  	</td>
		  	<td></td>
		  </tr>
  </c:forEach>
</table>
</form>
</div>
<div class="LabDetails_g">
<c:if test="${ !empty enclourses }">
<dl>
<dt>随单附件</dt>
<c:forEach items="${enclourses }" var="obj">
	<dd>${obj.characterName }</dd>
</c:forEach>
</dl>
</c:if>
<c:if test="${ !empty attachsList }">
<dl>
<dt>附件</dt>
<table>
<c:forEach items="${attachsList }" var="attachs">
<tr>
<th>
	<div style="padding-right: 20px;position: relative; top: 0px; left: 0px;">
	<a href="javascript:void(0)" data-src="${pageContext.request.contextPath}/temp${attachs.filePath }" data-title="${attachs.fileName }"  class="preview" ><img style="height: 40px;width: 40px;" src="${pageContext.request.contextPath}/temp/${attachs.filePath }" alt="${attachs.fileName }" /></a>
	<a href="javascript:void(0)" onclick="downloadFile('${attachs.filePath }', '${attachs.fileName }');">下载</a><hr>
	日期：<fmt:formatDate value="${attachs.caseDate }" type="both"/>
	来自：${attachs.caseFrom }
	</div>
</th>
</tr>
</c:forEach>
</table>
</dl>
</c:if>
</div>
</div>
</div>

<div id="note" style="display: none;">
<div class="LabDetailsNotes">备注</div>
<c:forEach items="${notePm.datas }" var="note">
<div class="LabDetailsNotes_a">
<ul>
<li>
<div class="LabDetailsNotes_a_left">日期:</div>
<div class="LabDetailsNotes_a_right"><fmt:formatDate value="${note.caseDate }" type="both"/></div>
</li>
<li>
<div class="LabDetailsNotes_a_left">接受方:</div>
<div class="LabDetailsNotes_a_right">${note.caseFor }</div>
</li>
<li>
<div class="LabDetailsNotes_a_left">发送方:</div>
<div class="LabDetailsNotes_a_right">${note.caseFrom }</div>
</li>
<li class="LabDetailsNotes_b">${note.caseNote }</li>
</ul>
<hr/>
</div>
</c:forEach>
</div>

<div id="log" style="display: none;">
<div class="LabDetailsActivityLog_a">活动日志
<div class="LabDetailsActivityLog">
<dl>
<c:forEach items="${logListPm.datas }" var="log">
	<dt><fmt:formatDate value="${log.createDate }" type="date"/></dt>
	<dd>
		<div class="LabDetailsActivityLog_left">
			<img
				src="${pageContext.request.contextPath}/jsp/lab/images/Lab_35.jpg" />
		</div>
		<div class="LabDetailsActivityLog_right">
			<span>订单</span> <span><a href="#">#${cases.caseId }</a>
				</span> <span>为</span> <span>患者&nbsp;<a href="#">${cases.patient }</a>&nbsp;
				</span> <span>${log.remarks }&nbsp;&nbsp;于<fmt:formatDate value="${log.createDate }" type="both"/></span>
		</div>
	</dd>
</c:forEach>
</dl>
</div>
</div>
</div>

</div>
<div class="General_bottom"></div>
</div>
</div>
</div>
</div>
</div>
<!--工厂技工间会员中心结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp" />
<!--底部结束-->
</div>

<div id="set_patient_appointment_div" title="Change Patient Appointment" style="display: none;">
<form action="" method="get">    
	<div class="box_appointment_center01">
		<div class="box_appointment01">当前患者预约:<fmt:formatDate value="${note.patAppDate }" type="date" pattern="yyyy-MM-dd HH:mm"/></div>
		<div class="box_appointment04">
		<span class="biaoti">日期: <span class="biaocolor">*</span></span><input id="patient_appointment_date" class="box_date" type="text" readonly="readonly" title="patient_appointment_date" maxlength="" name="patient_appointment_date">
		<span class="box_button">
		<img src="${pageContext.request.contextPath}/jsp/box/images/box_time.png" width="37" height="26" onclick="WdatePicker({el:'patient_appointment_date',minDate:'${cases.deliveryDate}'})"/></span>
		</div>
		<div class="box_appointment04" style="display: none;" id="patient_appointment_date_info">
		<span class="biaoti"></span><span class="u_lab_case_field_cuowu_a">请选择日期</span>
		</div>
		<div class="box_appointment04">
		<span class="biaoti">时间 :<span class="biaocolor">*</span></span> <input id="patient_appointment_time" class="box_Time" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" title="patient_appointment_time" maxlength="" name="patient_appointment_time">
		</div>
		<div class="box_appointment04" style="display: none;" id="patient_appointment_time_info">
		<span class="biaoti"></span><span class="u_lab_case_field_cuowu_a">请选择时间</span>
		</div>
	</div>
</form>
</div>

<div id="arrive_case_dialog" style="display: none;">
<form action="" method="get">    
	<div class="box_appointment_center01">
		<div class="box_appointment04">
		<span class="biaoti">日期 <span class="biaocolor">*</span></span><input id="arrive_date" readonly="readonly" class="box_date" type="text" title="arrive_date" maxlength="" name="arrive_date">
		<span class="box_button">
			<img src="${pageContext.request.contextPath}/jsp/box/images/box_time.png" width="37" height="26" onclick="WdatePicker({el:'arrive_date',minDate:'${cases.createDate}',maxDate:'%y-%M-%d'})"/>
		</span>
		</div>
		<div class="box_appointment04" style="display: none;" id="arrive_date_info">
		<span class="biaoti"></span><span class="u_lab_case_field_cuowu_a">请选择日期</span>
		</div>
		<div class="box_appointment04">
		<span class="biaoti">时间</span> <input id="arrive_time" class="box_Time" type="text" onfocus="WdatePicker({dateFmt:'H:mm'})" title="arrive_time" maxlength="" name="arrive_time">
		</div>
		<div class="box_appointment04" style="display: none;" id="arrive_time_info">
		<span class="biaoti"></span><span class="u_lab_case_field_cuowu_a">请选择时间</span>
		</div>
	</div>
</form>
</div>

<div id="onhold_dialog" style="display:none">
<div>
    <p>更新延时/搁置状态.</p>

    <form
        action=""
        method="post"
        id="onhold_form"
        accept-charset="utf-8">

        <p>
            <label for="onhold" title="On hold status">选项 <span class="form_required">*</span></label>
            <select
                id="onhold"
                name="onhold"
                class="large" onchange="changeHold();">
               <option value="">Not On Hold</option>
				<c:forEach items="${caseHoldPm.datas }" var="caseHold">
					<option value="${caseHold.name }">${caseHold.name }</option>
				</c:forEach>
                <option value="_OTHER_">Other</option>
            </select>


                    </p>

		<p></p>
        <p style="display: none;">
            <label for="custom_onhold" title="Why are you marking this cases as on hold?">自定义状态 <span class="form_required">*</span></label>
            <input
                type="text"
                id="custom_onhold"
                name="custom_onhold"
                class="large"
                maxlength="32"
            />
            <div class="box_appointment04" style="display: none;" id="customStatus_info">
		<label>&nbsp;</label><span class="u_lab_case_field_cuowu_a">请输入Custom Status</span>
		</div>
            

                    </p>
    </form>
</div>
</div>

<!-- 重排订单dialog -->
<div id="reschedule_case_dialog" style="display: none;">
</div>

<!-- 订单备注dialog -->
<div id="case_note_dialog" style="display: none;">
<form id="case_note_form" accept-charset="utf-8" name="case_note_form" method="post" >
<div style="height: 90%;width: 98%;">
	<div>
		<textarea id="case_note" rows="10" cols="60" name="case_note"></textarea>	
	</div>
<div id="case_note_info" style="display: none;">
	<span class="biaoti">&nbsp;</span>
	<span class="u_lab_case_field_cuowu_a"><i class="practiceindex_Invite_cuowu_a">内容不能为空</i></span>
</div>
</div>
</form>
</div>

<!-- 附件上传div start -->
<div id="attach_Upload_div" style="display: none;">
</div>

<!-- 返回试戴 -->
<div id="return_tryin_dialog" style="display: none;">
</div>
<!-- 外包订单弹出框 -->
<div id="outsource_dialog" style="width: auto; min-height: 0px; height: 45.4333px;display: none;" scrolltop="0" scrollleft="0">
<form id="forward" name="forwardForm" accept-charset="utf-8" method="post" action="${pageContext.request.contextPath}/casesAction/lab/cases/forwardCase.do?caseId=${cases.caseId}">
<p>
<label title="Choose a partner lab to send this case to" for="lab_id">
技工间
<span style="color: red;">*</span>
</label>
<select id="labId"  title="Choose a partner lab to send this case to" name="labId" aria-disabled="false">
<option label="Select a Lab" value="">Select a Lab</option>
<c:forEach items="${partnerLabList }" var="partnerLab">
	<option value="${partnerLab.id }">${partnerLab.name }</option>
</c:forEach>
</select>
<input type="hidden" name="id" value="${patient.id }">
<input type="hidden" name="practiceId" value="${patient.practiceId }">
<input type="hidden" name="firstName" value="${patient.firstName }">
<input type="hidden" name="lastName" value="${patient.lastName }">
<input type="hidden" name="birthday" value="${patient.birthday }">
<input type="hidden" name="sex" value="${patient.sex }">
<input type="hidden" name="externalId" value="${patient.externalId }">
<input type="hidden" name="addDate" value="${patient.addDate }">
<input type="hidden" name="updateDate" value="${patient.updateDate }">
</p>
</form>
</div>


<!-- close case -->
<div id="close_dialog" style="display: none;">
<form action="" method="get">
<div class="box_appointment_center011">
		<div class="box_appointment04">
		<span class="biaoti">货运商<span class="biaocolor">*</span> </span>
		<select id="shipper" class="box_date">
			<option value="">--请选择--</option>
			<c:forEach items="${shipperList }" var="shipper">
				<option value="${shipper.id }">${shipper.company }</option>
			</c:forEach>
		</select>
		</div>
		<div class="box_appointment04" style="display: none;" id="shipper_info">
		<span class="biaoti">&nbsp;</span>
		<span class="u_lab_case_field_cuowu_a">请选择货运商</span>
		</div>
		<div class="box_appointment04">
		<span class="biaoti">货运单号 </span>
		<input type="text" class="box_Time" id="trackNo" maxlength="20"/> 
		</div>
		<div class="box_appointment04" style="display: none;" id="trackNo_info">
		<span class="biaoti">&nbsp;</span>
		<span class="u_lab_case_field_cuowu_a">请输入货运单号</span>
		</div>
	</div>    
</form>
</div>

<%--议价div --%>
<div id="bargain_dialog" style="display: none;">
</div>

<!-- 优惠券dialog -->
<div id="add_coupons_dialog" style="display: none;">
<div class="NewCase_c_middle_righttop">
<div class="NewCase_c_middle_righttop_left" style="width: auto;">
使用优惠券&nbsp;
<input  type="text" id="coupon_code"/>
</div>
<div class="NewCase_c_middle_righttop_right">
<ul>
<li class="NewCase_c_middle_righttop_rightli"><a href="javascript:void(0)" onclick="loadCaseCoupon('${cases.caseId }')"></a></li>
<li class="NewCase_c_middle_righttop_rightli01"><a href="javascript:void(0)" onclick="removeCaseCoupon();">删除</a></li>
<li class="NewCase_c_middle_righttop_rightli02"><a href="javascript:void(0)" onclick="applyCoupon('${cases.labId }');">应用</a></li>
	<li>
		<div style="display: none;" id="coupon_error">
			<div class="box_clear"></div>
			<div class="NewCase_c_middle_righttop01" id="isValid-msg-div"
				style="padding-left: 0px; height: auto; font-weight: normal"></div>
		</div></li>
</ul>
</div>
</div>
</div>

 <div style="display: none;" id="addCoupon">
	<jsp:include page="addCoupontDialog.jsp" />
</div>

<input type="hidden" id="caseId" value="${cases.caseId }"/>
<input type="hidden" id="practiceId" value="${cases.practiceId }"/>
<input type="hidden" id="labId" value="${cases.labId}"/>
<input type="hidden" id="procedureIds" value="${procedureIds }"/>
<!-- 订单工序编辑窗口 -->
<div class="box_editcontent02" id="update-case-pro-attributes" name="procedure-div" style="display: none;"></div>
<jsp:include page="../u_practice/teeth_tmpl.jsp"/>
</body>
</html>

