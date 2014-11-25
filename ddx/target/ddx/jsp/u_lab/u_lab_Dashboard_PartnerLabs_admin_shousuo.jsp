<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>技工间搜索</title>
		<link
			href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab01.css"
			rel="stylesheet" type="text/css" />
		<script
			src="${pageContext.request.contextPath}/jsp/u_lab/js/partner-lab.js"
			type="text/javascript"></script>
	</head>
	<script type="text/javascript">
	function hideSearch() {
		$('#Search-PartnerLabs-div').hide(1000);
		$('#Search-PartnerLabs-result-div').hide(1000);
	}
</script>
	<body>
		<div class="page">
			<!--底部开始-->
			<jsp:include page="../head.jsp" />
			<!--头部结束-->
			<!--中间开始-->
			<div class="center">
				<!--工厂实验室会员中心开始-->
				<div class="gcsyshyzx">
					<ul>
						<li class="gcsyshyzx_a">
							技工间合作伙伴
						</li>
						<li id="PartnerLabsadmin_g">
							我申请的技工间合作伙伴
						</li>
						<li>
							<div class="PartnerLabsadmin">
								<!--合作技工间列表-->
								<jsp:include page="PartnerLabs.jsp"></jsp:include>
							</div>
						</li>
						<!--技工间查找-->
						<jsp:include page="labs-find.jsp"></jsp:include>
					</ul>
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
