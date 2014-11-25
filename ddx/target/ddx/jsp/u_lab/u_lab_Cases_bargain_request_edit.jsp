<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>优惠申请编辑</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/bargain-request.js"></script> 
</head>
<body>
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp"/>
<!--头部结束-->
<!--中间开始-->
<div class="center">
	<div class="Personalize">
		<div class="Personalize_a">优惠申请编辑</div>
		<div class="Personalize_b">
			<div class="Personalize_b_top"></div>
			<div class="Personalize_b_middle middle">
				<form action="" method="get">
					<ul>
						<li>
							<div class="Personalize_b_middle_left">
								<span>订单号</span>
							</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">#${bargainRequest.caseId }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>申请人优惠限度</span>
							</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1" id="preferentialLimit">${bargainRequest.bargainLimit }%</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">订单金额</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1" id="originalPrice">${bargainRequest.originalPrice
									}</span>
						</li>
						<li>
							<div class="Personalize_b_middle_left">优惠价</div>
							<div class="Personalize_b_middle_right">
								<input type="text" class="Personalize_b_middle_b" value="${bargainRequest.askPrice }" id="askPrice">
							</div>
						</li>
						<li id="askPrice_info" style="display: none;">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right">
								<i class="Addonecuowu_b"></i>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">审批人</div>
							<div class="Personalize_b_middle_right">
								<select class="Personalize_b_middle_b1" id="verifier">
									<option value="">--请选择--</option>
									<c:forEach items="${verifiers }" var="verifier">
										<option value="${verifier.accountId }">${verifier.firstName }.${verifier.lastName }</option>
									</c:forEach>
								</select>
							</div>
						</li>
						<li id="verifier_info" style="display: none;">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right">
								<i class="Addonecuowu_b">请选择审批人</i>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">申请描述</div>
							<div class="Personalize_b_middle_right">
								<textarea rows="4" cols="50" id="askReason" class="Personalize_b_middle_b1">${bargainRequest.askReason }</textarea>
							</div>
						</li>
					</ul>
				</form>
			</div>
			<div class="Personalize_b_bottom"></div>
			
		</div>
		<div class="Addone">
			<input type="hidden" id="id" value="${bargainRequest.id }" />
			<a href="javascript:void(0)" onclick="editBargainRequest();">提交</a>
		</div>
	</div>
	</div>
	
<jsp:include page="../bottom.jsp"/>
	
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#verifier option[value="'+'${bargainRequest.verifierId}'+'"]').attr('selected',true);
	});
</script>
</html>
