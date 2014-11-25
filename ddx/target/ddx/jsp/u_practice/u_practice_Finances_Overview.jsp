<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账务管理</title>
<link href="${pageContext.request.contextPath }/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath }/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath }/jsp/u_practice/css/u_practice.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/u_practice/js/finance-payment.js"></script>
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="../head-dashboard.jsp" /> 
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">账务管理</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
<jsp:include page="finances-left-menu.jsp"/>
</div>

<div class="Cases_bottom_right">
<div class="CasesOverview">

<div class="CasesOverview_left">
<div class="CasesOverview_left_a">账务管理</div>
<div class="CasesOverview_left_b">
<dl>
<dt><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePayment&id=${requestAccountLab.id}">账户支付</a></dt>
<dd>授权你的账户进行支付</dd>
<dt><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePricerList&id=${requestAccountLab.id}">价格列表</a></dt>
<dd> 
查看或打印<strong>  ${requestAccountLab.name } </strong>对你授权的价格列表。 
</dd>
</dl>
</div>
</div>
<div class="CasesOverview_right">
<div class="PartnerLabsadminqianjin_right">
<ul>
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="javascript:void(0)">授权付款</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<form action="" method="get">
<ul>
<li>请输入您要支付的金额。</li>
<li>
<div class="PartnerLabsadminqianjin_right_middle_left"><span>支付金额</span><span class="PartnerLabsadminqianjin_right_middle_a">*</span></div>
<div class="PartnerLabsadminqianjin_right_middle_right">
<input type="hidden" id="id" value="${requestAccountLab.id }" />
<input name="amount" id="amount" type="text" class="PartnerLabsadminqianjin_right_middle_b"/></div>
</li>
<li id="amount_info" style="display: none;">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="practiceindex_Invite_cuowu_a">请输入正确的金额</i></div>
</li>
<li>
<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
<div class="PartnerLabsadminqianjin_right_middle_right"><span class="practice_FinancesOverview"><a href="javascript:void(0)" onclick="sendPayment();">支付</a></span></div>
</li>
</ul>
</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom"></div>
</li>
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="javascript:void(0)">联系方式</a></div>
<div class="PartnerLabsadminqianjin_right_middle">
<form action="" method="get">
<ul>
<li><strong>${requestAccountLab.name }</strong></li>
<li>${requestAccountLab.address }</li>
<li>${requestAccountLab.city }</li>
<li>${requestAccountLab.fax }</li>
<li>${requestAccountLab.country }</li>
<li><span><strong>电话</strong></span><span>${requestAccountLab.phoneNumber }</span></li>
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