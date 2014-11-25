<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>打印工作单</title>
<link
	href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jsp/lab/js/lab-dealCase.js"></script>
</head>

<body>
	<div class="page">
		<!--底部开始-->
		<jsp:include page="../head.jsp" />
		<!--头部结束-->
		<!--中间开始-->
		<div class="center">
			<!--工厂实验室会员中心开始-->
			<div class="gcsyshyzx">

				<div class="Cases">
					<div class="Cases_top">设置</div>
					<div class="Cases_bottom">
						<div class="Cases_bottom_left">
							<jsp:include page="../left.jsp" />
						</div>
						<div class="Cases_bottom_right">
							<div class="Cases_bottom_right_a">打印工作单选项</div>
							<div class="General">
								<!-- <div class="General_top"></div>
								<div class="General_middle">
									<div class="General_middle_top"></div> -->
									<!--视图展示区-->
									<div class="General_middle_bottom" id="my-lab-details-div">
										<div class="General_middle_bottom_a">打印详情</div>
										<div class="General_middle_bottom_b">
											<div class="General_middle_bottom_b_top"></div>
											<div class="General_middle_bottom_b_middle">
												<form action="" method="get">
													<ul>
														<li>
															<div class="General_middle_bottom_b_middle_left"><span>患者信息</span></div>
															<div class="General_middle_bottom_b_middle_right">
																<input type="checkbox" id="option_patient_info" checked="checked"/>
															</div>
														</li>

														<li>
															<div class="General_middle_bottom_b_middle_left">
																<span>医生信息</span>
															</div>
															<div class="General_middle_bottom_b_middle_right">
																<input type="checkbox" id="option_doctor_info" checked="checked"/>
															</div>
														</li>

														<li>
															<div class="General_middle_bottom_b_middle_left">
																<span>日程信息</span>
															</div>
															<div class="General_middle_bottom_b_middle_right">
																<input type="checkbox" id="option_scheduling" checked="checked"/>
															</div>
														</li>

														<li>
															<div class="General_middle_bottom_b_middle_left">备注信息</div>
															<div class="General_middle_bottom_b_middle_right">
																<input type="checkbox" id="option_note" checked="checked"/>
															</div>
														</li>
														<li>
															<div class="General_middle_bottom_b_middle_left">
																<span>附件信息</span>
															</div>
															<div class="General_middle_bottom_b_middle_right">
																<input type="checkbox" id="option_files" checked="checked"/>
															</div>
														</li>
														<li>
															<div class="General_middle_bottom_b_middle_left">
																<span>工序信息</span>
															</div>
															<div class="General_middle_bottom_b_middle_right">
																<input type="checkbox" id="option_procedures" checked="checked"/>
															</div>
														</li>

													</ul>
												</form>
											</div>
											<div class="General_middle_bottom_b_bottom"></div>
										</div>
										<div class="General_anniu">
											<input type="hidden" id="caseId" value="${caseId }"/>
											<a href="javascript:void(0)" onclick="submitWorkTicketOption();">提交</a>
										</div>
									</div>

								<!-- </div>
								<div class="General_bottom"></div> -->
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
