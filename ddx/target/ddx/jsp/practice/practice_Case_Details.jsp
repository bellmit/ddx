<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<title>订单详细信息</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/tagit-simple-grey.css"  rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/tagit.js"></script>
<script type="text/javascript">
	$(function(){
		var status = '${cases.status}';
		var shipped = '${cases.shipped}';
		var arrived = '${cases.arrived}';
		var notePerm = '${casesPermissions.caseNotes}';
		var attachFilePerm = '${casesPermissions.attachCaseFiles}'
		var returnType = '${cases.returnType}';
		var onHoldStatus = '${cases.onHoldStatus}';
		
		if(status == 'CANCEL'){
			$('#practice_case_details_content').html('<p><h2>订单 #${cases.caseId }</h3><p><p><strong>此订单已取消！</strong></p>');
			return;
		}
		
		if(shipped==1){
			$('#remake').show();
			$('#li_attach').hide();
			$('#li_pro').hide();
			$('#li_reschedule').hide();
			$('#li_appt').hide();
		}
		if(attachFilePerm!='true'){
			$('#li_attach').hide();
		}
		//
		if(onHoldStatus == '__TRYIN__'){
			$('#li_appt').hide();
			$('#li_pro').hide();
		}
		
		if(returnType == 'remake'){
			$('#remake').hide();
		}
		
		if(status=='CANCEL' || arrived == 1){
			$('#cancelBtn').hide();
		}
		
		$("ol#li_remakeType li.menu_bgrighttop01 a").click(function(){
			//选择的重制类型 
			var val = $(this).text();
			var remake_type = $(this).attr('remake-type');
			var reqLabId = $('#reqAccLabId').val();
			var return_id = $('#caseId').val();
			window.location.href = webContext +　'/casesAction/pageJump.do?type=toNewCase&reqAccLabId='+ $('#reqAccLabId').val()+'&return_id='+return_id+'&return_type=remake&remake_type='+remake_type;
		});
	});
</script>
</head>

<body> 
<div class="page">

<!--头部开始-->
<jsp:include page="../head-dashboard.jsp" />
<!--头部结束--> 

<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">订单</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<ul>
<%--通用页面跳转表单 --%>
<li>
<form name="casesDetailForm" action="${pageContext.request.contextPath }/casesAction/getDataById.do" method="post">
<input type="hidden" id="caseId" name="caseId" value="${cases.caseId }" />
<input type="hidden" id="unitType" name="unitType" value="${cases.unitType }" />
<%--伙伴技工间ID --%>
<input type="hidden" id="reqAccLabId" name="labId" value="${requestAccountLab.id }" />
</form>
</li>
<li>
<jsp:include page="menu-left-unit-operating-authority.jsp"></jsp:include>
</li>
</ul>
</div>
<div class="Cases_bottom_right">
<div class="CasesOverview" id="practice_case_details_content">
<div class="practiceCaseDetails">
<div class="practiceCaseDetails_top">
<div class="practiceCaseDetails_top_a">
<div class="practiceCaseDetails_top_a_left">订单 #${cases.caseId }</div>
<div class="practiceCaseDetails_top_a_right">
<ul>
<li class="practiceCaseDetails_top_a_right_a">
    <div class="practiceCaseDetails_top_a_right_a_left"><a href="javascript:void(0)" onclick="printPracticeWork();">打印</a></div>
    <div class="practiceCaseDetails_top_a_right_a_right">
    	<a href="javascript:void(0)"></a>
    </div>
</li>
<li class="practiceCaseDetails_top_a_right_b">
<c:if test="${casesPermissions.cancelCase == true }">
	<a id="cancelBtn" href="javascript:void(0)" onclick="cancelCases();">取消</a>
</c:if>
</li>
</ul>
</div>
</div>
<div class="practiceCaseDetails_top_b">
<div class="practiceCaseDetails_top_b_left">
<dl>
<dt title="预计订单交付给${thisPractice.name }的日期">预交付时间:</dt>
<dd>
<span><fmt:formatDate value="${cases.deliveryDate }" type="date" pattern="yyyy-MM-dd"/></span>
<span class="practiceCaseDetails_top_b_a">
<a href="javascript:void(0)" onclick="confirmDeliveryDate();"></a>
</span>
<span>
<form action="${pageContext.request.contextPath }/casesAction/confirmDeliveryDate.do" method="post" name="confirmDeliveryDateForm">
	<input type="hidden" name="labId" value="${requestAccountLab.id }" />
	<input type="hidden" name="caseId" value="${cases.caseId }" />
</form>
</span>
</dd>
<dt title="预计订单从${thisPractice.name }发出的日期">预寄出时间:</dt>
<dd><fmt:formatDate value="${cases.sendToLabDate }" type="date" pattern="yyyy-MM-dd"/></dd>
<c:if test="${cases.provider != null}">
	<dt>主治医师:</dt>
	<dd>${cases.provider }</dd>
</c:if>
<dt>订单跟踪:</dt>
<dd>
	<span id="isFollow">
		<c:choose>
			<c:when test="${cases.isFollow == 'Y' }">
				跟踪
			</c:when>
			<c:otherwise>
				未跟踪
			</c:otherwise>
		</c:choose>
	</span>
	<span class="practiceCaseDetails_top_b_b"><a href="javascript:void(0)" onclick="showFollowCaseDialog();"></a></span>
</dd>
<dt>试戴:</dt>
<dd>
	<span class="practiceCaseDetails_top_b_b">
		<c:choose>
			<c:when test="${cases.isTryIn eq 'Y'  }">是</c:when>
			<c:otherwise>否</c:otherwise>
		</c:choose>
	</span>
</dd>
</dl>
</div>
<div class="practiceCaseDetails_top_b_right">
<dl>
<dt>患者:</dt>
<dd>
	<span class="practiceCaseDetails_top_b_f" title="id:${patient.id },firstName:${patient.firstName},lastName:${patient.lastName},externalId:${patient.externalId}"><a href="javascript:void(0)">${cases.patient }</a></span>
	<span class="practiceCaseDetails_top_b_c">
		<a href="javascript:void(0)" onclick="toCreateCaseForPatient();" title="为此患者创建一张新的订单"></a>
		<form action="${pageContext.request.contextPath }/casesAction/toCreateCaseForPatient.do" method="post" name="toCreateCaseForPatientForm">
			<input type="hidden" name="labId" value="${requestAccountLab.id }"/>
			<input type="hidden" name="id" value="${patient.id }"/>
			<input type="hidden" name="practiceId" value="${patient.practiceId }"/>
			<input type="hidden" name="firstName" value="${patient.firstName }"/>
			<input type="hidden" name="lastName" value="${patient.lastName }"/>
			<input type="hidden" name="birthday" value="${patient.birthday }"/>
			<input type="hidden" name="sex" value="${patient.sex }"/>
			<input type="hidden" name="externalId" value="${patient.externalId }"/>
			<input type="hidden" name="addDate" value="${patient.addDate }"/>
			<input type="hidden" name="updateDate" value="${patient.updateDate }"/>
		</form>
	</span>
</dd>
<dt>患者预约:</dt>
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

<c:if test="${cases.isReturn eq 1 }">
<dt>
<span>重制订单：</span>
</dt>
<dd>
基于源订单 #<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.returnSId }">${cases.returnSId }</a>
&nbsp;
<c:if test="${ !empty cases.remakeTypeNam }">
(${cases.remakeTypeNam })
</c:if>
</dd>
</c:if>

<c:if test="${ !empty cases.returnDId }">
<dt>
<span>重制订单：</span>
</dt>
<dd>目标订单 #<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.returnDId }">${cases.returnDId }</a>
<c:if test="${ !empty cases.remakeTypeNam }">
(${cases.remakeTypeNam })
</c:if>
</dd>
</c:if>


<c:if test="${ !empty cases.isEmeger }">
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
</c:if>
<dt>状态:</dt>
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
<c:if test="${ !empty cases.waybillNumber }">
<dt>货运单号#:</dt>
<dd>
&nbsp;<a href="javascript:void(0)">${cases.waybillNumber }</a>&nbsp;
</dd>
</c:if>
<dt>临床抵达:</dt>
<dd>
<c:choose>
<c:when test="${cases.practiceArrived eq 1 }">
已到达(<fmt:formatDate value="${cases.practiceArriveDate }" type="date"/>)
</c:when>
<c:otherwise>
未到达
</c:otherwise>
</c:choose>

</dd>

<c:if test="${user.createCaseTags eq 'true' || !empty cases.tags }">
<dt>标签:</dt>
<dd>
	<span id="tags_value">${cases.tags }</span>
	<span class="practiceCaseDetails_top_b_d">
	<c:if test="${(cases.unitType == 1 && cases.practiceId eq user.labId)||(cases.unitType == 2 && cases.practiceId eq user.practiceId)  }">
		<a href="javascript:void(0)" onclick="showTagsDialog();"></a>
	</c:if>
	</span>
</dd>
</c:if>
</dl>
</div>
</div>
</div>
<div class="practiceCaseDetails_bottom">
<div class="practiceCaseDetails_bottom_top"></div>
<div class="practiceCaseDetails_bottom_middle">
<div class="practiceCaseDetails_bottom_middle_top">
<ul>
<li class="practiceCaseDetails_bottom_middle_top_a"><a href="javascript:void(0)" onclick="loadTabInfo('detail');">订单详情</a></li>
<li class="practiceCaseDetails_bottom_middle_top_b">
	<a href="javascript:void(0)" onclick="loadTabInfo('note')">
	备注记录
	<c:if test="${notePm.total > 0 }">
	(${notePm.total })
	</c:if>
	</a>
</li>
<li class="practiceCaseDetails_bottom_middle_top_c"><a href="javascript:void(0)" onclick="loadTabInfo('log')">订单动态(${logListPm.total })</a></li>
</ul>
</div>
<div id="detail">
<div class="practiceCaseDetails_bottom_middle_bottom">
<div class="practiceCaseDetails_bottom_middle_bottom_a">制作工序</div>
<div class="practiceCaseDetails_bottom_middle_bottom_b">
<form action="" method="get">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="practiceCaseDetails_bottom_middle_bottom_b_a"><a href="javascript:void(0)">数量</a></td>
    <td class="practiceCaseDetails_bottom_middle_bottom_b_b"><a href="javascript:void(0)">说明</a></td>
  </tr>
  <c:forEach items="${proceduresList}" var="pro">
  		<tr class="practiceCaseDetails_bottom_middle_bottom_b">
		    <td><a style="text-decoration: none;" href="javascript:void(0)" title="${pro.ps }">${pro.count }</a></td>
		    <td onclick="showAttr('${pro.index }');">
		    <span>
	    		<c:if test="${pro.isTryIn == 'ok' }">
	    			<img src="${pageContext.request.contextPath}/jsp/lab/images/ok.jpg" alt="ok" />
	    			<input type="hidden" value="${pro.isTryIn }" id="caseIsTryInHidden"/>
	    		</c:if>
	    	</span>
		    <span>${pro.procedure_name }</span>
		    <span class="practiceCaseDetails_bottom_middle_bottom_b_c"><a href="javascript:void(0)" id="${pro.index }-a" flag="hide">[+]</a></span>
		    </td>
		  </tr>
		  <tr id="${pro.index }-tr" style="display: none;">
		  	<td></td>
		  	<td>
		  		<div>
		  			<table style="width: 100%;margin-left: 20px;">
		  					<c:forEach items="${pro.attrList}" var="attr">
		  						<c:if test="${!empty attr.valueDes }">
		  							<tr>
				  						<td><h2>${attr.lable }</h2></td>
					  				</tr>
					  				<tr>
					  					<td>${attr.valueDes }</td>
					  				</tr>
		  						</c:if>
		  					</c:forEach>
		  			</table>
		  		</div>
		  	</td>
		  </tr>
  </c:forEach>
</table>
</form>
</div>
<div class="practiceCaseDetails_bottom_middle_bottom_c">
<dl>
<c:if test="${!empty enclourses }">
<dt>随单附件</dt>
<c:forEach items="${enclourses }" var="obj">
	<dd style="margin-top: 0px;">${obj.characterName }</dd>
</c:forEach>
</c:if>
</dl>
<dl>
<dt>附件</dt>
<dd>
<table>
<c:choose>
	<c:when test="${empty attachsList }">
	<tr>
		<th>
		<div style="padding-right: 20px;position: relative; top: 0px; left: 0px;margin-left: 40px;">
		无
		</div>
		</th>
	</tr>
	</c:when>
	<c:otherwise>
		<c:forEach items="${attachsList }" var="attachs">
		<tr>
		<td>
			<div style="padding-right: 20px;position: relative; top: 0px; left: 0px;">
			<a href="javascript:void(0)" data-src="${pageContext.request.contextPath}/temp${attachs.filePath }" data-title="${attachs.fileName }"  class="preview" ><img style="height: 40px;width: 40px;" src="${pageContext.request.contextPath}/temp${attachs.filePath }" alt="${attachs.fileName }" /></a>
			<a href="javascript:void(0)" onclick="downloadFile('${attachs.filePath }', '${attachs.fileName }');">下载</a><hr>
			日期：<fmt:formatDate value="${attachs.caseDate }" type="both"/>
			来自：${attachs.caseFrom }
			</div>
		</td>
		</tr>
		</c:forEach>	
	</c:otherwise>
</c:choose>
</table>
</dd>
</dl>
</div>
</div>
</div>

<div id="note" style="display: none;">
<div class="practiceCaseNotes">备注</div>
<c:forEach items="${notePm.datas }" var="note">
<div class="practiceCaseNotes_a">
<ul>
<li>
<div class="practiceCaseNotes_a_left">日期:</div>
<div class="practiceCaseNotes_a_right"><fmt:formatDate value="${note.caseDate }" type="both"/></div>
</li>
<li>
<div class="practiceCaseNotes_a_left">接收方:</div>
<div class="practiceCaseNotes_a_right">${note.caseFor }</div>
</li>
<li>
<div class="practiceCaseNotes_a_left">发送方:</div>
<div class="practiceCaseNotes_a_right">${note.caseFrom }</div>
</li>
<li class="practiceCaseNotes_b">${note.caseNote }</li>
</ul>
<hr/>
</div>
</c:forEach>
</div>

<div id="log" style="display: none;">
<div class="practiceCaseActivityLog"><dl>活动日志</dl>
<dl>
<c:forEach items="${logListPm.datas }" var="log">
	<dt><fmt:formatDate value="${log.createDate }" type="date"/></dt>
	<dd>
		<div class="practiceCaseActivityLog_left">
			<img
				src="${pageContext.request.contextPath}/jsp/lab/images/Lab_35.jpg" />
		</div>
		<div class="practiceCaseActivityLog_right">
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
<div class="practiceCaseDetails_bottom_bottom"></div>
</div>



</div>
<div class="CasesOverview_right">
<div class="PartnerLabsadminqianjin_right">
<ul id="rightActionMenu">
<li id="remake" style="display: none;">
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">重制订单</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
	<form action="" method="get">
		<ul>
		<li>
			<span>将订单返回给技工间以便于重制。</span>
		</li>
		<li>
		<div class="PartnerLabsadminqianjin_right_middle_left"></div>
		<div class="PartnerLabsadminqianjin_right_middle_right">
			<ul>
			<li>
				<!--小菜单下拉开始-->
				   <ol class="menu_all">
				     <li class="first first02">
						<a href="javascript:void(0)">返回重制</a>    
					     <ol id="menuu_s01" class="menu_right01 menuu_s" style=" margin-left:0px;">
						     <li style="width:160px;">
						       <ol class="menu_bgrightcenter" id="li_remakeType">
						     	<li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
						     	<c:forEach items="${caseRemakeList }" var="obj">
						     		<li id="menu_right01" class="menu_bgrighttop01"><a href="javascript:void(0);" remake-type="${obj.id }">${obj.name }</a></li>
						     	</c:forEach>
						     	<li class="menu_bgrightbottom"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg" width="160" height="4" /></li>
						       </ol>
						     </li>
					     </ol>
				     </li>
				</ol>
			</li>
			</ul>
		</div>
		</li>
		</ul>
	</form>	
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
<li id="li_appt">
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">患者预约</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<c:choose>
	<c:when test="${cases.arrived eq 1 && cases.shipped ne 1 }">
		This case has been received and is in progress. You cannot automatically Cancel or Reschedule it, but you can use the below options to alert ${requestAccountLab.name } of the changes you require. 
	</c:when>
	<c:otherwise>
		<form action="" method="get">
			<ul>
			<li>
			<div class="PartnerLabsadminqianjin_right_middle_left">
				<span>日期</span>
				<span class="PartnerLabsadminqianjin_right_middle_a">*</span>
			</div>
			<div class="PartnerLabsadminqianjin_right_middle_right">
				<span>
				<input name="patient_appointment_date" id="patient_appointment_date" type="text" readonly="readonly" class="PartnerLabsadminqianjin_right_middle_b"/>
				</span>
				<span class="PartnerLabsadminqianjin_right_middle_c">
				<a href="javascript:void(0)" onclick="WdatePicker({el:'patient_appointment_date',minDate:'${cases.deliveryDate}'})"></a>
				</span>
			</div>
			</li>
			<li id="patient_appointment_date_info" style="display: none;">
				<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
				<div class="PartnerLabsadminqianjin_right_middle_right"><i class="practiceindex_Invite_cuowu_a">请选择日期</i></div>
			</li>
			<li>
			<div class="PartnerLabsadminqianjin_right_middle_left">时间</div>
			<div class="PartnerLabsadminqianjin_right_middle_right">
				<input name="patient_appointment_time" id="patient_appointment_time" readonly="readonly" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm'})" type="text" class="PartnerLabsadminqianjin_right_middle_b"/>
			</div>
			</li>
			<li id="patient_appointment_time_info" style="display: none;">
				<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
				<div class="PartnerLabsadminqianjin_right_middle_right"><i class="practiceindex_Invite_cuowu_a">请选择时间</i></div>
			</li>
			<li>
			<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
			<div class="PartnerLabsadminqianjin_right_middle_right">
				<span class="practiceCaseDetails_b"><a href="javascript:void(0)" onclick="applyPatientAppointment();">应用</a></span>
			</div>
			</li>
			</ul>
		</form>	
	</c:otherwise>
</c:choose>

</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
<li id="li_reschedule">
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">重排预寄出时间</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<c:choose>
	<c:when test="${cases.arrived eq 1 && cases.shipped ne 1 }">
		This case has been received and is in progress. It cannot be automatically rescheduled. Please contact Upcera Dental Lab directly.  
	</c:when>
	<c:otherwise>
		<form action="" method="get" name="rescheduleForm">
		<ul>
		<li>
		<div class="PartnerLabsadminqianjin_right_middle_left"><span>日期</span><span class="PartnerLabsadminqianjin_right_middle_a">*</span></div>
		<div class="PartnerLabsadminqianjin_right_middle_right">
		<span>
		<input type="hidden" id="reschd_caseId" value="${cases.caseId}" />
		<input type="hidden" id="reschd_labId" value="${requestAccountLab.id}" />
		<input id="reschedule_send_to_lab_date" type="text" class="PartnerLabsadminqianjin_right_middle_b" readonly="readonly"/>
		</span>
		<span class="PartnerLabsadminqianjin_right_middle_c">
		<a href="javascript:void(0)" onclick="WdatePicker({el:'reschedule_send_to_lab_date',minDate:'%y-%M-%d'})"></a>
		</span>
		</div>
		</li>
		<li id="reschedule_send_to_lab_date_info" style="display: none;">
			<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
			<div class="PartnerLabsadminqianjin_right_middle_right"><i class="practiceindex_Invite_cuowu_a">请选择日期</i></div>
		</li>
		<li>
		<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
		<div class="PartnerLabsadminqianjin_right_middle_right"><span class="practiceCaseDetails_c"><a href="javascript:void(0)" onclick="rescheduleSendDate();">更新</a></span></div>
		</li>
		</ul>
		</form>
	</c:otherwise>
</c:choose>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
<li id="li_pro">
<div class="PartnerLabsadminqianjin_right_top"><a href="javascript:void(0)" onclick="loadPro('${requestAccountLab.id}')">给订单添加工序</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<c:choose>
	<c:when test="${cases.arrived eq 1 && cases.shipped ne 1 }">
		订单正在进行中，现在不能对制作工序进行修改！  
	</c:when>
	<c:otherwise>
		<form action="" method="get">
		<ul>
		<li>
			<div class="PartnerLabsadminqianjin_right_middle_left">
			<span class="PartnerLabsadminqianjin_right_middle_a" style="color: red;">*&nbsp;</span>
				<span>工序 </span>
			</div>
			<div class="PartnerLabsadminqianjin_right_middle_right">
				<span>
					<select name="select-procedure-name" size="1" id="add-pro-id-select" onchange="loadProcedure('0',this.value,'false')">
					</select>
				</span>
			<span class="PartnerLabsadminqianjin_right_middle_d"><a href="javascript:void(0)"></a></span>
			</div>
		</li>
		<li>
		<div name="procedure-div" id="add-procedure-div">
			<div id="attributes-0"></div>
		</div>
		</li>
		<li style="display: none;" id="procedure_select_info">
			 <div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
			 <div class="PartnerLabsadminqianjin_right_middle_right"><i class="Addonecuowu_b">请选择工序</i></div>
		</li>
		<li>
		<div class="PartnerLabsadminqianjin_right_middle_left"><span class="PartnerLabsadminqianjin_right_middle_a" style="color: red;">*&nbsp;</span><span>发送</span></div>
		<div class="PartnerLabsadminqianjin_right_middle_right"><span><input readonly="readonly" name="send_to_lab_date" id="send_to_lab_date" type="text" class="PartnerLabsadminqianjin_right_middle_b"/></span><span class="PartnerLabsadminqianjin_right_middle_c"><a href="javascript:void(0)" onclick="WdatePicker({el:'send_to_lab_date',minDate:'%y-%M-%d'})"></a></span></div>
		</li>
		<li style="display: none;" id="send_to_lab_date_info">
			 <div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
			 <div class="PartnerLabsadminqianjin_right_middle_right"><i class="Addonecuowu_b">请选择发送日期</i></div>
		</li>
		
		<li>
		<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
		<div class="PartnerLabsadminqianjin_right_middle_right"><span class="practiceCaseDetails_d"><a href="javascript:void(0)" onclick="addCaseProcedure('add','${cases.caseId}','add-procedure-div')">增加</a></span></div>
		</li>
		</ul>
		</form>
	</c:otherwise>
</c:choose>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
<c:if test="${casesPermissions.caseNotes==true}">
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">订单备注</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
		<form action="" method="get">
		<table>
		<tr>
		<td>
		<textarea name="" cols="" rows="" id="notes" class="ckeditor"></textarea>
		</td>
		</tr>
		<tr><td>
		<li id="notes_info" style="display: none;">
			<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
			<div class="PartnerLabsadminqianjin_right_middle_right"><i class="practiceindex_Invite_cuowu_a">内容不能为空</i></div>
		</li>
		</td></tr>
		<tr><td>
		<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
		<div class="PartnerLabsadminqianjin_right_middle_right"><span class="practiceCaseDetails_e"><a href="javascript:void(0)" onclick="addNote();">提交</a></span></div>
		</td></tr>
		
		</table>
		</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
</c:if>
<li id="li_attach">
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">附加文件</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<form action="" method="get">
<ul>
<li>
<!-- <div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div> -->
<div class="PartnerLabsadminqianjin_right_middle_right">
<%-- <c:choose>
	<c:when test="${requestAccountLab.email != null }">
		<span class="practiceCaseDetails_f">
			<a href="javascript:void(0)" onclick="showUploadDialog();" id="file_uploader">上传文件 </a>
		</span>
	</c:when>
	<c:otherwise>
		<span>
			<p>
				<em>此技工间没有确定的邮箱地址。文件将不能通过邮箱传送到此技工间。</em>
			</p>
			<p>
				<strong>提供此技工间的邮箱地址</strong>
			</p>
			<strong>
				<p>
					<label for="">Email:</label> <input
						name="provide_email" id="provide_email" class="PartnerLabsadminqianjin_right_middle_b"
						type="text">
						<div class="PartnerLabsadminqianjin_right_middle_right" id="provide_email_info" style="display: none;"><i class="practiceindex_Invite_cuowu_a">邮箱不能为空</i></div>
						<span class="practiceCaseDetails_c">
							<a href="javascript:void(0)" name="update_lab_email" onclick="applyLabEmail();" title="更新邮箱地址" >更新</a>
						</span>
				</p>

			<p></p> </strong>
		</span>
	</c:otherwise>
</c:choose> --%>
<span class="practiceCaseDetails_f">
	<a href="javascript:void(0)" id="file_uploader">上传文件 </a>
</span>
</div>
</li>
</ul>
</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>

<c:if test="${cases.onHoldStatus=='__TRYIN__'}">
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)" onclick="loadTryInPro('${requestAccountLab.id}')" >返回试戴</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<div class="box_appointment_changecenter01">
<div class="box_clear"></div>
<div class="box_appointment_filter">病人预约</div>
<div class="box_appointment_filtertop"></div>
<div class="box_appointment_filtercenter">
<div class="box_appointment03">
<span class="biaoti"  style="display: inline-block;">日期</span>
<input type="text" readonly="readonly" id="app_date" class="box_app_date"/>
<span class="PartnerLabsadminqianjin_right_middle_c" style="display: inline-block;">
<a href="javascript:void(0)" onclick="WdatePicker({el:'app_date',minDate:'${cases.deliveryDate}'})"></a>
</span>
</div>
<div class="box_appointment03">
<span class="biaoti">时间</span>
<input type="text" class="box_app_date" id="app_time" readonly="readonly" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'H:mm'})"/>
</div>
</div>
<div class="box_appointment_filterbottom"></div>
<div class="box_clear"></div>
<div class="box_appointment_filter">添加工序</div>
<div class="box_appointment_filtertop"></div>
<div class="box_appointment_filtercenter">
<div class="box_appointment03">
<span class="biaoti">工序</span>
<span>
	<select name="select-procedure-name" class="box_app_date" size="1" id="load-pro-id-select" onchange="loadTryInProcedureAttr('0',this.value,'false')">
	</select>
</span>
<span>
<div name="procedure-div" id="tryin-procedure-div">
	<div id="tryin_attributes-0"></div>
</div>
</span>
</div>
<div class="box_appointment03">
<span class="biaoti">发送日期</span>
<input type="text" class="box_app_date" id="tryin_sendDate" readonly="readonly" />
<span class="PartnerLabsadminqianjin_right_middle_c" style="display: inline-block;">
<a href="javascript:void(0)" onclick="WdatePicker({el:'tryin_sendDate',minDate:'%y-%M-%d'})"></a>
</span>
</div>
</div>
<div class="box_appointment_filterbottom"></div>
<div class="box_clear"></div>
<div class="box_appointment_filter">备注</div>
<div class="box_appointment_filtertop"></div>
<div class="box_appointment_filtercenter">

<textarea name="return_tryin_notes" cols="" rows="" id="return_tryin_notes" class="ckeditor"></textarea>

</div>
<div class="box_appointment_filterbottom"></div>
</div>
<div>
<p>
<div class="PartnerLabsadminqianjin_right_middle_right"><span class="practiceCaseDetails_e"><a href="javascript:void(0)" onclick="doTryIn('add','${cases.caseId}');">提交</a></span></div>
</p>
</div>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
</c:if>

</ul>
</div>
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
<jsp:include page="../bottom.jsp"/>
<!--底部结束-->
</div>

<!-- 附件上传div start -->
<div id="attach_Upload_div" style="display: none;">
</div>

<!-- 标签、关键字设置 -->
<div id="tags_dialog" style="display: none;">
	<form action="" method="post">
		<p>
			<ul id="tags-ul" onmouseout="return false;"></ul>
			<input type="hidden" id="tags" />
			<input type="hidden" id="tags-exist" value="${cases.tags }" />
			<input type="hidden" id="tags-available" value="${cases.tags }" />
		</p>
		<p id="tags_info" style="display: none;">
			<i class="practiceindex_Invite_cuowu_a"></i>
		</p>
	</form>
</div>

<!-- 跟踪订单设置 -->
<div id="follow_case_dialog" style="display: none;">
	<form action="" method="post">
		<fieldset>
			<legend>跟踪订单</legend>
			<div class="PartnerLabsadminqianjin_right_middle_left">
				<label>类型</label>
			</div>
			<div class="PartnerLabsadminqianjin_right_middle_right">
				<select id="follow_type">
					<option value="UNFOLLOW">不更新</option>
					<option value="ALL_FOLLOW">所有更新</option>
					<option value="LAB_FOLLOW">技工间更新</option>
				</select>
			</div>
		</fieldset>
	</form>
</div>

<!-- 牙齿选择dialog 开始 -->
<jsp:include page="../u_practice/teeth_tmpl.jsp" />
<!-- 牙齿选择dialog 结束 -->

<!-- 附件上传div end   -->
<script type="text/javascript">
$(function(){
	
	//可选标签  
    var availableTags = $('#tags-available').val().split(',');

    $('#tags-ul').tagit({
   	 	tagSource:availableTags,
   	 	singleField: true,             
        singleFieldNode: $('#tags'),
        maxTags:5,
        maxLength:10,
        initialTags:$('#tags-exist').val().split(',')
     });
    
	$(".preview").click(function(event){
        event.preventDefault();
        var $this = $(this),
            src = $this.data('src'),
            $dialog = $('<div style="overflow: scroll"></div>'),
            image = new Image(),
            height = parseInt($(window).height() * 0.9),
            width = parseInt($(window).width() * 0.9),
            paddingH = 40,
            paddingV = 60;
        
        if (height < 350) {
            height = 350;
        }
        
        if (width < 700) {
            width = 700;
        }
        
        image.onload = function() {
            $dialog.empty();
            
            if (this.width > (width - paddingH)) {
                var multiplier = (width - paddingH) / this.width;
                
                this.width = Math.round(this.width * multiplier);
                this.height = Math.round(this.height * multiplier);
            }
            
            if (this.height > (height - paddingV)) {
                var multiplier = (height - paddingV) / this.height;
                
                this.width = Math.round(this.width * multiplier);
                this.height = Math.round(this.height * multiplier);
            }
            
            $dialog.dialog('option', 'height', Math.round(this.height + paddingV));
            $dialog.dialog('option', 'width', Math.round(this.width + paddingH));
            $dialog.dialog('option', 'position', 'center');
            
            $dialog.html(this);
        }
        
        $dialog.html('<p>Loading...</p>')
            .dialog({
                autoOpen: true,
                modal: true,
                title: $this.data('title'),
                open: function() {
					var link = '';
                    image.src = link + src;
                }
            });
        $dialog.dialog('open');
    });
	
	
	$("#file_uploader").click(function(event){
   	 	event.preventDefault();
		file_uploader();
     });
    

});

/**
 * 显示上传对话框 
 */
function showUploadDialog(){
	$("#attach_Upload_div").append($("<iframe width='580' height='380' frameborder='0' scrolling='no' src='${pageContext.request.contextPath}/casesAction/gotoUpload.do?caseId=${cases.caseId}&reqAccLabId=${requestAccountLab.id}' ></iframe>")).dialog({
    	title:'上传附件',
        resizable: false,
        modal: true,
        height:400,
        width:600,
        cancel:false,
        buttons: {
            "关闭": function() {
                $(this).dialog("close");
                parent.location.reload();
            }
        }
    });
}


var fileUploaderWindow = null;
function file_uploader(inline) {
	inline = typeof inline !== 'undefined' ? inline : false;

	if (!inline) {
	
	    if (fileUploaderWindow && !fileUploaderWindow.closed && fileUploaderWindow.location) {
	        if (window.focus) {
	            fileUploaderWindow.focus()
	        }
	    }else {
	        var width = 500;
	        var height = 375;
	        var top = screen.height;
	        var left = screen.width;
	        if (top < height) {
	            top = 0;
	        } else {
	            top = (top - height) / 2;
	        }
	        if (left < width) {
	            left = 0;
	        } else {
	            left = (left - width) / 2;
	        }
	        fileUploaderWindow = window.open(webContext + '/casesAction/gotoUpload.do?caseId=${cases.caseId}&reqAccLabId=${requestAccountLab.id}&mod=uploader', '', 'location=no,menubar=no,toolbar=no,directories=no,personalbar=no,status=no,scrollbars=yes,top=' + top + ',left=' + left + ',width=' + width + ',height=' + height);
	    }
	} else {
	    window.location = webContext + '/casesAction/gotoUpload.do?caseId=${cases.caseId}&reqAccLabId=${requestAccountLab.id}&mod=uploader';
	}
	
}

</script>
</body>
</html>
