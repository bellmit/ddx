<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工厂实验室-账户支付</title>
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
<div class="Cases_bottom_right_a">账户支付</div>
<div class="practice_FinancesAccountPayment">通过您设置的付款方式进行支付</div>
<form action="" method="post" id="payment_form">
<div class="Personalize">
<div class="Personalize_a">支付说明</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<ul>
<li>
<div class="Personalize_b_middle_left"><span>交易金额</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
<input type="hidden" id="id" value="${requestAccountLab.id}"/>
<input name="amount" id="amount" type="text" class="Personalize_b_middle_b"/>
</div>
</li>
<li id="amount_info" style="display: none;">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="practiceindex_Invite_cuowu_a">请输入正确的金额</i></div>
</li>
</ul>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Personalize_a">支付授权</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<ul>
<li>
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><span class="practice_FinancesOverview"><a href="javascript:void(0)" onclick="sendPayment();">支付</a></span></div>
</li>
</ul>
</div>
<div class="Personalize_b_bottom"></div>
</div>
</div>
</form>
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