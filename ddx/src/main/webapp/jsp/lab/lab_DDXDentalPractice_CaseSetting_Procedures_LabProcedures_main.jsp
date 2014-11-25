<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>工序</title>
		<link
			href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
			rel="stylesheet" type="text/css" />
		<link
			href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/jsp/lab/css/lab.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting-procedures.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/jsp/lab/js/caseSetting-procedure_Characteristics.js"></script>
	</head>

	<body>
		<div class="page">
			<!--头部开始-->
			<jsp:include page="../head.jsp" />
			<!--头部结束-->
			<!--中间开始-->
			<div class="center">
				<!--工厂实验室会员中心开始-->
				<div class="gcsyshyzx">

					<div class="Cases">
						<div class="Cases_top">
							设置
						</div>
						<div class="Cases_bottom">

							<jsp:include page="../left.jsp" />

							<div class="Cases_bottom_right">
								<div class="Cases_bottom_right_a">
									${datas.title }
									<input type="hidden" value="${datas.type }" id="operation-flag"/>
									<input type="hidden" value="${datas.lpd.proceduresId}" id="operation-procedure-id"/>
								</div>
								<div class="Addonecuowu_c" style="display: none;" id="detils-error-msg">
									有你的表单提交的错误，请看下面的细节。
								</div>
								<div class="General">
									<div class="General_top"></div>
									<div class="General_middle">
										<div class="General_middle_top">
											<ul>
												<li class="Lab_DDXDentalPractice_a">
													<a href="javascript:void(0)" onclick="procedure('general');">一般</a>
												</li>
												<li class="Lab_DDXDentalPractice_c">
													<a href="javascript:void(0)" onclick="procedure('attributes');">属性</a>
												</li>
												<li class="Lab_DDXDentalPractice_b">
													<a href="javascript:void(0)" onclick="procedure('externalLinks');">外包链接</a>
												</li>
												<li class="Lab_DDXDentalPractice_d">
													<a href="javascript:void(0)" onclick="procedure('pricing');">价格</a>
												</li>
											</ul>
										</div>
										<div class="General_middle_bottom" id="show-procedures-info-div">
											<div id="edit-Procedures-general-div">
												<jsp:include page="lab_DDXDentalPractice_CaseSetting_Procedures_LabProcedures_Edit_General.jsp"/>
											</div>
											<div id="edit-Procedures-attributes-div">
											</div>
											<div id="edit-Procedures-externalLinks-div">
											</div>
											<div id="edit-Procedures-pricing-div">
											</div>
										</div>
									</div>
									<div class="General_bottom"></div>
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
<script type="text/javascript" language="javascript">
$(".General_middle_top li ").live("click",function(){
	$(".General_middle_top li a").css({"backgroundColor":"none","color":"#000"});
		$("a",this).css({"backgroundColor":"none","color":"#1591f9"});
	});
</script>