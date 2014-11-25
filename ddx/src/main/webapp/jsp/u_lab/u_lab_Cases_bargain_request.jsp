<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>订单优惠申请</title>
</head>
<body>
	<div class="Personalize">
		<div class="Personalize_a">订单详情</div>
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
								<span id="preferentialLimit" class="Personalize_b_middle_b1">#${cases.caseId }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>申请人优惠限度</span>
							</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${user.preferentialLimit }%</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">订单金额</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${cases.originalPrice
									}</span>
						</li>
						<li>
							<div class="Personalize_b_middle_left">优惠价</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${cases.finishPrice }</span>
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
								<textarea rows="4" cols="50" id="askReason" class="Personalize_b_middle_b1"></textarea>
							</div>
						</li>
					</ul>
				</form>
			</div>
			<div class="Personalize_b_bottom"></div>
			
		</div>
		<div class="Addone">
			<input type="hidden" id="caseId" value="${cases.caseId }" />
			<input type="hidden" id="askPrice" value="${cases.finishPrice }" />
			<a href="javascript:void(0)" onclick="submitBargainRequest();">提交</a>
		</div>
	</div>
</body>
</html>
