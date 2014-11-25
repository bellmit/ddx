<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>
	查看优惠审批申请	
</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/u_lab_cases.js"></script>  
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
		查看优惠审批申请	
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
							<div class="Personalize_b_middle_left">订单金额</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${bargainRequest.originalPrice
									}</span>
						</li>
						<li>
							<div class="Personalize_b_middle_left">优惠价</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1">${bargainRequest.askPrice }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">申请理由</div>
							<div class="Personalize_b_middle_right">
								<span>${bargainRequest.askReason }</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">审批人</div>
							<div class="Personalize_b_middle_right">
								<span class="Personalize_b_middle_b1" id="verifier">${bargainRequest.verifierName}
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">是否同意</div>
							<div class="Personalize_b_middle_right">
								<span>
									<c:choose>
										<c:when test="${bargainRequest.status == '1' }">
											同意
										</c:when>
										<c:otherwise>
											不同意
										</c:otherwise>
									</c:choose>
								</span>
							</div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">审批意见</div>
							<div class="Personalize_b_middle_right">
								<span>${bargainRequest.verifyOpinion }</span>
							</div>
						</li>
					</ul>
				</form>
			</div>
			<div class="Personalize_b_bottom"></div>
			
		</div>
		<div class="Addone">
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
</html>
