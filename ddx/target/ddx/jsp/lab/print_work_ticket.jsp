<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${practice.name } - 订单 ${cases.caseId }</title>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/jsp/lab/css/style.css"	type="text/css">
<style type="text/css">
input[type=button],input[type=submit],input[type=reset],button {	margin-right: 2px;
	margin-left: 2px; text-decoration: none;
	color: #ffffff; padding: 0.2em 0.5em 0.2em 0.5em !important;
	border: 1px solid #005dab; -moz-border-radius-topleft: 5px;
	-webkit-border-top-left-radius: 5px; order-top-left-radius: 5px;
	-moz-border-radius-topright: 5px; -webkit-border-top-right-radius: 5px;
	border-top-right-radius: 5px; -moz-border-radius-bottomleft: 5px;
	-webkit-border-bottom-left-radius: 5px; border-bottom-left-radius: 5px;
	-moz-border-radius-bottomright: 5px; -webkit-border-bottom-right-radius: 5px;
	border-bottom-right-radius: 5px; font-weight: bold;	vertical-align: top;}
input[type=button].ui-button,input[type=submit].ui-button,input[type=reset].ui-button,button.ui-button
	{ padding: 0.2em 0.8em 0.2em 0.0em !important;}
input[type=button] .ui-button-text,input[type=submit] .ui-button-text,input[type=reset] .ui-button-text,button .ui-button-text
	{ padding: 0em 0.2em 0em 1.9em !important;}
a.button {	float: left;	margin-right: 2px;	margin-left: 2px;
	text-decoration: none;	color: #ffffff;
	padding: 0.2em 0.5em 0.2em 0.5em !important;	background:50% 50% #005dab;
	border: 1px solid #005dab;	 
	-moz-border-radius-topleft: 5px;
	-webkit-border-top-left-radius: 5px;	
	border-top-left-radius: 5px;
	-moz-border-radius-topright: 5px;	
	-webkit-border-top-right-radius: 5px;
	border-top-right-radius: 5px;	
	-moz-border-radius-bottomleft: 5px;
	-webkit-border-bottom-left-radius: 5px;	
	border-bottom-left-radius: 5px;
	-moz-border-radius-bottomright: 5px;
	-webkit-border-bottom-right-radius: 5px;
	border-bottom-right-radius: 5px;
	font: 13px arial, helvetica, clean, sans-serif;
	font-weight: bold;
}
a.button:hover {background:	repeat-x scroll 50% 50% #eeeeee; border: 1px solid #d6e9f5;	color: #000000;}
input[type=button]:hover,input[type=submit]:hover,input[type=reset]:hover,button:hover,a.button:hover
	{ background:repeat-x scroll 50% 50% #eeeeee;	border: 1px solid #d6e9f5;	color: #000000;}
.print_only { display: none;}
@media print { .no_print { display: none;	}
.print_only { display: block;}
}
-->
</style>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/jsp/lab/js/masonry-A100.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		window.print();

		$(".no_print").on("click", ".print", function(event) {
			event.stopPropagation();
			event.preventDefault();

			window.print();
		});

		$('.attachments').imagesLoaded(function() {
			$('.attachments').masonry({
				itemSelector : 'li'
			});
		});
	});
</script>
</head>
<body>
	<div id="wrapper" style="width:800px; padding-top: 10px;margin-left:20px">
		<div class="no_print">
			<a class="button ui-button ui-button-text-icon-primary print"
				href="javascript:void(0)" title="Print Again"><span
				class="ui-button-icon-primary ui-icon ui-icon-print"></span><span
				class="ui-button-text">重新打印</span> </a> <a
				class="button ui-button ui-button-text-icon-primary"
				href="${pageContext.request.contextPath }/casesAction/lab/cases/getCase.do?caseId=${cases.caseId }"
				title="Return to case"><span
				class="ui-button-icon-primary ui-icon ui-icon-arrowreturnthick-1-w"></span><span
				class="ui-button-text">返回订单 #${cases.caseId }</span> </a>
		</div>
		<h1 style="clear: both; padding-top: 10px; text-align: left;">订单 #${cases.caseId }</h1>
		<div class="yui-g">
			<div class="yui-u first" style="width: 60%;">
				<c:if test="${option_doctor_info eq '1'}">
					<div class="yui-g">
						<div class="yui-u first" style="width: 50%;">
							<dl>
								<dt>临床</dt>
								<dd>
									<div>${practice.name }</div>
									<div>${practice.country } ${practice.state } ${practice.city }  ${practice.zipCode }</div>
								</dd>
							</dl>
						</div>
						<div class="yui-u" style="width: 50%;">
							<dl>
								<dt>主治医师</dt>
								<dd>${cases.provider }</dd>
							</dl>
						</div>
					</div>
				</c:if>
				<c:if test="${option_patient_info eq '1'}">
					<div class="yui-g">
						<div class="yui-u first" style="width: 50%;">
							<dl>
								<dt>患者</dt>
								<dd>${patient.firstName }${patient.lastName }</dd>
							</dl>
						</div>
						<div class="yui-u" style="width: 50%;">
							<dl>
								<dt>患者预约</dt>
								<dd>
								<c:choose>
									<c:when test="${ empty cases.patAppDate }">
										没有预约
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${cases.patAppDate}" type="date"/></dd>									
									</c:otherwise>
								</c:choose>
							</dl>
						</div>
					</div>
				</c:if>
				<div class="yui-g">
					<div class="yui-u first" style="width: 50%;">
						<dl>
						</dl>
					</div>
					<div class="yui-u" style="width: 50%;">
						<dl>
						</dl>
					</div>
				</div>
				<c:if test="${option_scheduling eq '1' }">
					<h2>日程表</h2>
					<div class="yui-g">
						<div class="yui-u first" style="width: 50%;">
							<dl>
								<dt>预回寄日期</dt>
								<dd><fmt:formatDate value="${cases.shipDate}" type="date"/></dd>
								<dt>接收</dt>
								<dd>
								<c:choose>
									<c:when test="${cases.arrived eq '1'  }">
										已接收(日期：<fmt:formatDate value="${cases.arriveDate}" type="date"/>)
									</c:when>
									<c:otherwise>
										未接收
									</c:otherwise>
								</c:choose>
								</dd>
							</dl>
						</div>
						<div class="yui-u" style="width: 50%;">
							<dl>
								<dt>加工状态</dt>
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
								<dt class="return_date">预交付日期</dt>
								<dd class="return_date"><fmt:formatDate value="${cases.deliveryDate}" type="date"/></dd>
							</dl>
						</div>
					</div>
				</c:if>
				<c:if test="${option_procedures eq '1' }">
					<h2 style="height:40px; line-height:40px; clear:both">制作工序</h2>
					<div class="yui-g">
						<div class="yui-u" style="width: 100%;">
							<table id="case_procedures" class="" width="100%" cellpadding="0"
								cellspacing="0">
								<thead>
									<tr>
										<th class="ui-corner-left" width="50"><span>计数</span></th>
										<th><span>描述</span>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${proceduresList}" var="pro">
										<tr>
											<td valign="top">${pro.count }</td>
											<td valign="top"><span class="procedure">${pro.procedure_name }</span>
												<dl class="case_attributes" style="margin-left: 10px;">
													<c:forEach items="${pro.attrList}" var="attr">
														<c:if test="${!empty attr.valueDes }">
															<dt>${attr.lable }</dt>
															<dd>${attr.valueDes }</dd>
														</c:if>
													</c:forEach>
												</dl></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>
				<c:if test="${option_files eq '1' }">
					<h2 style="height:40px; line-height:40px; clear:both">附件</h2>
					<div class="yui-g">
						<div class="yui-u" style="width: 100%;">
							<ul style="position: relative; height: 374px;"
								class="attachments masonry">
								<c:choose>
									<c:when test="${ !empty attachsList }">
										<c:forEach items="${attachsList }" var="attachs">
											<li>
												<div class="thumbnail">
													<img
														src="${pageContext.request.contextPath}/temp/${attachs.filePath }"
														alt="${attachs.fileName }" width="128" >
												</div>
												<div title="">
													<strong>文件:</strong> ${attachs.fileName }
												</div>
												<div title="<fmt:formatDate value="${attachs.caseDate }" type="both"/>">
													<strong>日期：</strong> <fmt:formatDate value="${attachs.caseDate }" type="both"/>
												</div>
												<div>
													<strong>来自：</strong> ${attachs.caseFrom }
												</div></li>
										</c:forEach>									
									</c:when>
									<c:otherwise>
										<li>没有数据...</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</c:if>
			</div>
			<div class="yui-u" style="width: 40%;">
				<c:if test="${option_note eq '1' }">
					<div style="padding-left: 10px">
						<h2>订单备注</h2>
						<c:choose>
							<c:when test="${notePm.total > 0 }">
								<c:forEach items="${notePm.datas }" var="note">
									<div class="note">
										<p>${note.caseNote }</p>
									</div>
								</c:forEach>	
							</c:when>
							<c:otherwise>
								<div class="note">
									<p>没有数据...</p>
								</div>
							</c:otherwise>
						</c:choose>
						
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
