<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>订单管理</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/practice/css/practice.css" rel="stylesheet" type="text/css" />
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
	<jsp:include page="../practice/menu-left-unit-operating-authority.jsp"></jsp:include>	
</ul>
</div>

<div class="Cases_bottom_right">
<div class="CasesOverview">

<div class="CasesOverview_left">
<div class="CasesOverview_left_a">订单管理</div>
<div class="CasesOverview_left_b">
<dl>
<c:if test="${casesPermissions.newCase==true}">
	<dt><a href="javascript:void(0)" onclick="gotoNewCase(${requestAccountLab.id },'');">新建订单</a></dt>
	<dd>新建一个订单，并获得一个订单的预交付时间</dd>
</c:if>
<c:if test="${casesPermissions.listCases==true}">
	<dt><a href="javascript:void(0)"  onclick="showAllLabCases('',${requestAccountLab.id });">订单列表</a></dt>
	<dd>浏览与<strong>&nbsp;${requestAccountLab.name }&nbsp;</strong>合作的所有订单</dd>
</c:if>
<c:if test="${casesPermissions.pickup==true}">
		<dt><a href="javascript:void(0)" onclick="goPickupPage(${requestAccountLab.id });">取件服务</a></dt>
		<dd>要求合作技工间上门取单，无需在网上新建订单和输入订单详情</dd>
</c:if>
<c:if test="${casesPermissions.newCase!=true and casesPermissions.listCases!=true and casesPermissions.pickup!=true}">
		无任何操作权限！！！
</c:if>
</dl>
</div>
</div>
<div class="CasesOverview_right">
<div class="PartnerLabsadminqianjin_right">
<ul>
<c:if test="${casesPermissions.newCase==true}">
<li>
	<div class="PartnerLabsadminqianjin_right_top">
		<a href="javascript:void(0)" onclick="loadPro('${requestAccountLab.id}')">快速新建订单</a>
	</div>
	<div class="PartnerLabsadminqianjin_right_middle">
		<form action="" method="get" id="caseForm">
			<ul>
				<s:authorize ifAllGranted="ROLE_PRACTICE">
                <c:if test="${ !empty providers }">
                    <li>
                        <div class="PartnerLabsadminqianjin_right_middle_left">
                           <span>主治医师</span><span
							class="PartnerLabsadminqianjin_right_middle_a">*</span>
                        </div>
                        <div class="PartnerLabsadminqianjin_right_middle_right">
                            <select id="providers" class="PartnerLabsadminqianjin_right_middle_b">
                                <c:forEach items="${providers }" var="provider">
                                    <option value="${provider.accountId}">
                                        ${provider.salutation}${provider.firstName}${provider.lastName}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </li>
                </c:if>
                </s:authorize>
				<li>
					<div class="PartnerLabsadminqianjin_right_middle_left">
						<span>姓</span><span
							class="PartnerLabsadminqianjin_right_middle_a">*</span>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle_right">
						<input name="" type="text" id="firstName"
							class="PartnerLabsadminqianjin_right_middle_b" maxlength="10" />
					</div>
				</li>
				 <li style="display: none;" id="firstName_info">
					<div class="NewCase_a_middle_left_left">&nbsp;</div>
					<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请输入患者的姓</i></div>
				</li>
				<li>
					<div class="PartnerLabsadminqianjin_right_middle_left">
						<span>名</span><span
							class="PartnerLabsadminqianjin_right_middle_a">*</span>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle_right">
						<input name="" type="text" id="lastName" maxlength="10"
							class="PartnerLabsadminqianjin_right_middle_b" />
					</div>
				</li>
				 <li style="display: none;" id="lastName_info">
					<div class="NewCase_a_middle_left_left">&nbsp;</div>
					<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请输入患者的名</i></div>
				</li>
				
				<li>
					<div class="PartnerLabsadminqianjin_right_middle_left">
						<span>发送</span><span
							class="PartnerLabsadminqianjin_right_middle_a">*</span>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle_right">
						<span><input id="sendToLabDate" name="" type="text" readonly="readonly"
								class="PartnerLabsadminqianjin_right_middle_b" />
						</span><span class="PartnerLabsadminqianjin_right_middle_c"><a
							href="javascript:void(0)"
							onclick="WdatePicker({el:'sendToLabDate',minDate:'%y-%M-%d'})"></a>
						</span>
					</div>
				</li>
				<li style="display: none;" id="sendToLabDate_info">
					<div class="NewCase_a_middle_left_left">&nbsp;</div>
					<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请选择发送日期</i></div>
				</li>
				<li>
					<div class="PartnerLabsadminqianjin_right_middle_left">
					<span>工序 </span>
					<span class="PartnerLabsadminqianjin_right_middle_a" style="color: red;">*&nbsp;</span>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle_right">
						<span>
							<select name="" size="1" id="add-pro-id-select" onchange="loadProcedure('0',this.value,'false')">
							</select>
						</span>
					<span class="PartnerLabsadminqianjin_right_middle_d"><a href="javascript:void(0)"></a></span>
					</div>
				</li>
				<li>
					<div name="procedure-div">
						<div id="attributes-0"></div>
					</div>
				</li>
				 <li style="display: none;" id="procedure-select_info">
					 <div class="NewCase_a_middle_left_left">&nbsp;</div>
					 <div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请选择工序</i></div>
				 </li>
				 <li>
				 	<jsp:include page="../u_practice/teeth_tmpl.jsp"></jsp:include>
				 </li>
				<%--技工间协议是否显示 --%>
					<c:if test="${caseTerms.valid eq 'true' }">
						<li class="NewCase_c_middle_rightsd">
							<div class="NewCase_c_middle_right_left">
								<input type="checkbox" id="terms" />我同意所有的&nbsp;
							</div>
							<div class="NewCase_c_middle_right_right_01">
								<a href="javascript:void(0);" onclick="showTermsDialog()">协议条款</a>
							</div></li>
						<li style="display: none;" id="terms_info">
							<div class="NewCase_a_middle_left_left">&nbsp;</div>
							<div class="NewCase_a_middle_left_right">
								<i class="Addonecuowu_b">您必须同意此协议条款</i>
							</div></li>
					</c:if>
					<li>

					<div class="PartnerLabsadminqianjin_right_middle_left">
						&nbsp;
						<input type="hidden" id="newType" value="add" />
						<%--伙伴技工间ID --%>
                                    <input type="hidden" id="partnerLabId" value="${requestAccountLab.id }"/>
                                    <input type="hidden" id="term_valid" value="${caseTerms.valid}" />
					</div>

					<div class="PartnerLabsadminqianjin_right_middle_right">

						<span class="PartnerLabsadminqianjin_right_middle_g"> <a
							href="javascript:void(0)" onclick="quickAddCases();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提交</a>
						</span>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<div class="PartnerLabsadminqianjin_right_bottom"></div>
	 <%--用户使用协议及条款 --%>
                <div id="terms_dialog" style="display: none;">
                	<p>${caseTerms.terms }</p>
                </div>
</li>
</c:if>
<c:if test="${casesPermissions.listCasesArrivingToday==true}">
	<li>
	<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">今天待抵达的订单</a></div>
	<div class="PartnerLabsadminqianjin_right_middle">
	<form action="" method="get">
	<c:choose>
			<c:when test="${casesArrivePm.total == 0 }">
				<ul>
					<li>今天没有订单从&nbsp;&nbsp;${requestAccountLab.name }&nbsp;&nbsp;技工间抵达</li>
				</ul>
			</c:when>
			<c:otherwise>
				<table width="100%" id="cases_arrive">
				<thead>
					<tr>
						<td class="practiceindexright_a">
							<a href="#">订单</a>
						</td>
						<td class="practiceindexright_b">
							<a href="#">患者</a>
						</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${casesArrivePm.datas }" var="casesArrive">
						<tr>
							<td><a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${casesArrive.caseId }" >#${casesArrive.caseId }</a></td>
							<td>${casesArrive.patient }</td>
						</tr>
					</c:forEach>					
				</tbody>
			</table>
			</c:otherwise>
		</c:choose>
	</form>
	</div>
	<div class="PartnerLabsadminqianjin_right_bottom"></div>
	</li>
</c:if>
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">今天待寄出的订单</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<form action="" method="get">
<c:choose>
		<c:when test="${casesShipPm.total == 0 }">
			<ul><li>今天没有订单从&nbsp;&nbsp;${requestAccountLab.name }&nbsp;&nbsp;技工间发货</li></ul>
		</c:when>
		<c:otherwise>
			<table width="100%" id="cases_ship">
			<thead>
				<tr>
					<td class="practiceindexright_a">
						<a href="#">订单</a>
					</td>
					<td class="practiceindexright_b">
						<a href="#">患者</a>
					</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${casesShipPm.datas }" var="casesShip">
					<tr>
						<td><a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${casesShip.caseId }" >#${casesShip.caseId }</a></td>
						<td>${casesShip.patient }</td>
					</tr>
				</c:forEach>					
			</tbody>
		</table>
		</c:otherwise>
	</c:choose>
</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="javascript:void(0)">试戴中的订单</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
	<form action="" method="get">
	<c:choose>
			<c:when test="${casesTryInPm.total == 0 }">
				<ul><li>当前&nbsp;&nbsp;${requestAccountLab.name }&nbsp;&nbsp;技工间没有试戴的订单</li></ul>
			</c:when>
			<c:otherwise>
			<table width="100%" id="cases_tryin">
			<thead>
				<tr>
					<td class="practiceindexright_a">
						<a href="#">订单</a>
					</td>
					<td class="practiceindexright_b">
						<a href="#">患者</a>
					</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${casesTryInPm.datas }" var="casesTryIn">
					<tr>
						<td><a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${casesTryIn.caseId }" >#${casesTryIn.caseId }</a></td>
						<td>${casesTryIn.patient }</td>
					</tr>
				</c:forEach>					
			</tbody>
		</table>
			</c:otherwise>
			</c:choose>
</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="void(0)">联系方式</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<form action="" method="get">
<ul>
	<li><strong>${requestAccountLab.name }</strong></li>
	<li>${requestAccountLab.address }</li>
	<li>${requestAccountLab.city }</li>
	<li>${requestAccountLab.zipCode }</li>
	<li>${requestAccountLab.country }</li>
	<li><strong>电话</strong>${requestAccountLab.phoneNumber }</li>
	<li>${requestAccountLab.email }</li>
</ul>
</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
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
<jsp:include page="../bottom.jsp" />
<!--底部结束-->
</div>
</body>
</html>
