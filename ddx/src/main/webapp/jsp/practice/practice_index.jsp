<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="java.util.Date"%>

<html>
	<head>
		<title>临床医生首页</title>
	</head>

	<body onload="init();">
		<div class="page">
		<!--底部开始-->
		<jsp:include page="head-practice.jsp"/> 
		<!--头部结束-->
		<!--中间开始-->
		<div class="center">
			<!--工厂实验室会员中心开始-->
			<div class="gcsyshyzx">

				<div class="PartnerLabsadminqianjin">
					<div class="practiceindex">
						<div class="practiceindex_ab" style="height: 60px;line-height:60px;">
							<h1>欢迎<s:authentication property="name" /></h1>
						</div>
						<div class="practiceindex_a">
							<div class="practiceindex_a_top">
								事项
							</div>
							<div class="practiceindex_a_middle">
								<div class="practiceindex_a_middle_top">
									<div class="practiceindex_a_middle_top_left">
										<span> <%=ToolsKit.DateUtil.formatDate(new Date(),"yyyy年MM月dd日") %> </span>&nbsp;&nbsp;
										<span><a href="javascript:void(0)" onclick="getEvents('<%=ToolsKit.DateUtil.formatDate(new Date(),"yyyy-MM-dd") %>','LastWeek');">今天</a></span><span></span>
									</div>
									<div class="practiceindex_a_middle_top_right">
										<!--小菜单下拉开始-->
										<ol class="menu_all">
											<li class="first"><a href="javascript:void(0)" class="lab_new">新增订单</a>
												<ol class="menuu_xiao" style=" margin-left:-20px; *margin-left:-145px">
													<li>
														<ol id="menu_bgrightcenter" class="menu_bgrightcenter">
															<li class="menu_bgrighttop"><img
																src="${pageContext.request.contextPath}/jsp/box/images/menu_bg11.jpg"
																width="145" height="4" />
															</li>
															<c:forEach items="${authority}" var="plab">
																<c:if test="${plab.casesPermissions.newCase==true or plab.casesPermissions.pickup==true}">
																	<li class="menu_bgdelete01"><strong>${plab.labName }</strong></li>
																	<c:if test="${plab.casesPermissions.newCase==true}">
																		<li class="menu_bgdelete01"><a href="${pageContext.request.contextPath}/casesAction/pageJump.do?type=toNewCase&reqAccLabId=${plab.labId}">创建订单</a></li>
																	</c:if>
																	<c:if test="${plab.casesPermissions.pickup==true}">
																		<li class="menu_bgdelete01"><a href="${pageContext.request.contextPath}/casesAction/goPickupPage.do?labId=${plab.labId}">收货要求</a></li>
																	</c:if>
																</c:if>
															</c:forEach>
															<c:if test="${empty listPartnerLabs}">
																<li class="menu_bgdelete01"><a href="${pageContext.request.contextPath}/practiceAction/partners.do">添加技工间</a></li>
															</c:if>
															
															<li class="menu_bgrightbottom"><img
																src="${pageContext.request.contextPath}/jsp/box/images/menu_bg10.jpg" width="145" height="4" />
															</li>
														</ol></li>
												</ol></li>
										</ol>
										<!--小菜单下拉结束-->
									</div>
								</div>
								<div class="practiceindex_a_middle_bottom">
										<div class="practiceindex_a_middle_bottom_left">
											<a href="javascript:void(0)" onclick="loadEventsByWeek('LastWeek');" title="上一周" id="LastWeek-a"></a>
										</div>
										<div class="practiceindex_a_middle_bottom_middle">
											<div class="practiceindex_a_middle_bottom_middle_top"></div>
											<div class="practiceindex_a_middle_bottom_middle_middle" style="height: 415px;">
												<!--事项-->
												<ul id="practice-index-events-div">
													
												</ul>
												</div>
											<div class="practiceindex_a_middle_bottom_middle_bottom"></div>
										</div>
										<div class="practiceindex_a_middle_bottom_right">
											<a href="javascript:void(0)" onclick="loadEventsByWeek('NextWeek');" title="下一周" id="NextWeek-a"></a>
										</div>
								</div>
							</div>
							<div class="practiceindex_a_bottom"></div>
						</div>
						<div class="practiceindex_b">
							<div class="practiceindex_b_top">
								<!-- 警示 &  -->
								动态
							</div>
							<div class="practiceindex_b_middle">
								<div class="practicerili">
									<form method="get" action="">
										<div class="practicerili_top"></div>
										<div class="practicerili_middle">
											<div class="practicerili_middle_top">
												<ul>
													<!-- 
													<li class="practicerili_middle_top_a">
														<a href="javascript:void(0)" onclick="getAlert();">提醒</a>
													</li>
													-->
													<li class="practicerili_middle_top_b">
														<a href="javascript:void(0)" onclick="getActivity();">动态</a>
													</li>
												</ul>
											</div>
											<!--警示 和 动态-->
											<div class="practicerili_middle_bottom">
												<div class="practicerliebiao_a">
													<div class="practicerliebiao_a_left">
														<span>查看</span>
													</div>
													<div class="Lab_b_right_middle_bottom_b_right">
														<ul style="margin: 0px; padding: 0px;">
															<li class="top_b_right_a"
																style="margin: 0px; padding: 0px;width: 180px;">
																<form action="" method="get">
																	<span class="top_b_right_a_left"> <input
																			name="log_type" type="text" id="log_type"
																			class="log large"
																			style="height: 13px; * line-height: 13px; * vertical-align: middle;cursor: pointer;" />
																	</span>
																	<span class="top_b_right_a_right"> <!--<input	name="" type="image" src="${pageContext.request.contextPath}/jsp/u_lab/images/select.jpg"/>-->
																		<img src="${pageContext.request.contextPath}/jsp/u_lab/images/select.jpg" style="cursor: pointer;" id="showOrHide-img"></img> </span>
																</form>
															</li>
														</ul>
														<div>
															<jsp:include page="../box/box_select.jsp" />
														</div>
													</div>
													<div class="practicerliebiao_a_right">
														<a href="#">订阅</a>
													</div>
												</div>
												<div class="practicerliebiao" id="practice-index-alert-and-activity-div">
													<jsp:include page="../lab/lab-main-log.jsp"/>
												</div>
												<div>
													<div class="Lab_b_right_middle_bottom_d_b" style="float:left">
														<a href="#">新动态</a>
													</div>
													<div class="" style="float:left">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</div>
													<div class="Lab_b_right_middle_bottom_d_a" style="float:left">
														<a href="#">旧动态</a>
													</div>
												</div>
											</div>
										</div>
										<div class="practicerili_bottom"></div>
									</form>
								</div>
							</div>
							<div class="practiceindex_b_bottom"></div>
						</div>
					</div>
					<div class="PartnerLabsadminqianjin_right" style="margin-top: 50px;">
						<ul>
							<li>
								<div class="PartnerLabsadminqianjin_right_top">
									<a href="javascript:void(0)">新闻资讯</a>
								</div>
								<div class="PartnerLabsadminqianjin_right_middle" style="display: block">
									<form method="get" action="">
										<ul>
											<li id="practice-index-news">
												
											</li>
										</ul>
									</form>
								</div>
								<div class="PartnerLabsadminqianjin_right_bottom" style="display: block"></div>
							</li>
							<li>
								<div class="PartnerLabsadminqianjin_right_top">
									<a href="javascript:void(0)">正在试戴的订单</a>
								</div>
								<div class="PartnerLabsadminqianjin_right_middle" style="display: none;">
									<form method="get" action="">
									<c:choose>
											<c:when test="${tryInPm.total == 0 }">
												<ul><li>没有正在试戴的订单</li></ul>
											</c:when>
											<c:otherwise>
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
						
											<thead>
												<tr>
													<td class="practiceindexright_a">
														<a href="javascript:void(0)">订单号</a>
													</td>
													<td class="practiceindexright_b">
														<a href="javascript:void(0)">患者</a>
													</td>
												</tr>
											</thead>
											<tbody>
											
												<c:forEach items="${tryInPm.datas }" var="tryIn">
													<tr class="practiceindexright_c">
														<td>
															<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${tryIn.caseId }" >${tryIn.caseId }</a>
														</td>
														<td>
															<a href="javascript:void(0)">${tryIn.patient }</a>
														</td>
													</tr>
												</c:forEach>												
											</tbody>
										</table>
										</c:otherwise>
									</c:choose>
									</form>
								</div>
								<div class="PartnerLabsadminqianjin_right_bottom"  style="display: none;"></div>
							</li>
							<li>
								<div class="PartnerLabsadminqianjin_right_top">
									<a href="javascript:void(0)">需追踪的订单</a>
								</div>
								<div class="PartnerLabsadminqianjin_right_middle" style="display: none;">
									<form method="get" action="">
									 <c:choose>
									 	<c:when test="${followedPm.total == 0 }">
											<ul>
												<li>
													没有需要追踪的订单
												</li>
											</ul>									 	
									 	</c:when>
									 	<c:otherwise>
									 	<table width="100%" border="0" cellspacing="0" cellpadding="0">
						
											<thead>
												<tr>
													<td class="practiceindexright_a">
														<a href="javascript:void(0)">订单号</a>
													</td>
													<td class="practiceindexright_b">
														<a href="javascript:void(0)">患者</a>
													</td>
												</tr>
											</thead>
											<tbody>
													<c:forEach items="${followedPm.datas }" var="follow">
													<tr class="practiceindexright_c">
														<td>
															<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${follow.caseId }" >${follow.caseId }</a>
														</td>
														<td>
															<a href="javascript:void(0)">${follow.patient }</a>
														</td>
													</tr>
												</c:forEach>												
											
											</tbody>
										</table>
									 	</c:otherwise>
									 </c:choose>
									</form>
								</div>
								<div class="PartnerLabsadminqianjin_right_bottom" style="display: none;"></div>
							</li>
							<li>
								<div class="PartnerLabsadminqianjin_right_top">
									<a href="javascript:void(0)">治疗方案草稿</a>
								</div>
								<div class="PartnerLabsadminqianjin_right_middle" style="display: none;">
									<!--效果开始-->
									<form action="" method="get">
									<c:choose>
										<c:when test="${draftPm.total == 0 }">
											<strong>草案不存在</strong>
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
								</div>
								<div class="PartnerLabsadminqianjin_right_bottom" style="display: none;"></div>
							</li>
						</ul>
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
