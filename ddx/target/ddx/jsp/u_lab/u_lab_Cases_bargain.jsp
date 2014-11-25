<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>订单议价</title>
</head>
<body>

	<div class="Personalize">
		<div class="Personalize_a">详情</div>
		<div class="Personalize_b">
			<div class="Personalize_b_top"></div>
			<div class="Personalize_b_middle">
				<form action="" method="get">
					<ul>
						<li>
							<div class="Personalize_b_middle_left">
								<span>优惠限度</span>
								<span class="Personalize_b_middle_a">*</span>
							</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${user.preferentialLimit }%</span>
								<input type="hidden" id="preferentialLimit" value="${user.preferentialLimit}"/>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">订单金额</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1" >${cases.originalPrice}</span>
								<input type="hidden" id="originalPrice" value="${cases.originalPrice}"/>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>优惠价</span>
								<span class="Personalize_b_middle_a">*</span>
							</div>
							<div class="Personalize_b_middle_right">
								<input id="askPrice" class="Personalize_b_middle_b" type="text"
									maxlength="10" name="askPrice">
							</div>
						</li>
						<li id="askPrice_info" style="display: none;">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right">
								<i class="Addonecuowu_b"></i>
							</div>
						</li>
						<li id="askBargain_div" style="display: none;">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right">
								<a href="javascript:void(0)" onclick="askBargain();"
									style="text-decoration: underline;">超出优惠限度，请向上级申请</a>
							</div></li>
					</ul>
				</form>
			</div>
			<div class="Personalize_b_bottom"></div>
		</div>
		<div class="Addone">
			<a href="javascript:void(0)" onclick="submitBargain();">提交</a>
		</div>
	</div>

	<%--优惠申请div --%>
	<div id="bargain_request_dialog" style="display: none;">
	</div>

</body>
</html>