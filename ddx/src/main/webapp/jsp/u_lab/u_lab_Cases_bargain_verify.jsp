<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>
	优惠审批	
</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/bargain-verify.js"></script>  
</head>

<body> 
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp"/>
<!--头部结束-->
<!--中间开始-->
<div id="div_show">
<div class="center">
	<div class="Personalize">
		<div class="Personalize_a">
		优惠审批	
		</div>
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
								<span id="preferentialLimit" class="Personalize_b_middle_b1">#${bargainRequest.caseId }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>申请人</span>
							</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${bargainRequest.applicantName }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>申请人优惠限度</span>
							</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${bargainRequest.bargainLimit }&nbsp;%</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left"><span>订单金额</span></div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${bargainRequest.originalPrice
									}</span>
						</li>
						<li>
							<div class="Personalize_b_middle_left"><span>优惠价格</span></div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${bargainRequest.askPrice }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left"><span>申请理由</span></div>
							<div class="Personalize_b_middle_right">
								<span>${bargainRequest.askReason }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left"><span>审批人</span></div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1" id="verifier">${bargainRequest.verifierName}
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>是否同意</span>
								<span class="Personalize_b_middle_a">*</span>
							</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">同意&nbsp;&nbsp;<input type="radio" name="isAgree" value="1"/>
								&nbsp;&nbsp;
								不同意&nbsp;&nbsp;<input type="radio" name="isAgree" value="0"/>
								</span>
							</div>
						</li>
						<li id="isAgree_info" style="display: none;">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right">
								<i class="Addonecuowu_b"></i>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">审批意见</div>
							<div class="Personalize_b_middle_right">
								<textarea rows="4" cols="50" id="verifyOpinion" class="Personalize_b_middle_b1">${bargainRequest.verifyOpinion }</textarea>
							</div>
						</li>
						<li id="verifyOpinion_info" style="display: none;">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right">
								<i class="Addonecuowu_b"></i>
							</div>
						</li>
					</ul>
				</form>
			</div>
			<div class="Personalize_b_bottom"></div>
			
		</div>
		<div class="Addone">
			<input type="hidden" id="id" value="${bargainRequest.id }"/>
			<a href="javascript:void(0)" onclick="doBargainVerify();">提交</a>
		</div>
	</div>
</div>
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp"/>
<!--底部结束-->
</div> 
</body>
<script type="text/javascript">
	$(function(){
		//默认选中是否同意 
		 $("input[type=radio][name=isAgree][value="+'${bargainRequest.status}'+"]").attr("checked",true);  
	});
</script>
</html>
