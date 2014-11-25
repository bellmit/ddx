<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<dl>
	<c:choose>
		<c:when test="${!empty datas}">
			<c:forEach items="${datas}" var="data">
				<c:if test="${!empty data.data}">
					<dt>
						${data.day }
					</dt>
					<c:forEach items="${data.data}" var="log">
						<!-- 订单更新 -->
						<c:if test="${log.logType=='CASE_UPDATE'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab_35.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>订单</span>
									<span>
										<s:authorize ifAllGranted="ROLE_LAB">
											<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${log.primaryId}">#${log.primaryId }</a>
										</s:authorize>
										<s:authorize ifAllGranted="ROLE_PRACTICE">
											<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${log.primaryId}">#${log.primaryId }</a>
										</s:authorize>
									</span>
									<span>来自</span>
									<span>
										<c:choose>
												<c:when test="${sessionUser.unitId==log.unitId}">
													${log.unitName }
												</c:when>
												<c:otherwise>
													<s:authorize ifAllGranted="ROLE_LAB">
														<a href="${pageContext.request.contextPath}/labAction/setting/practices.do?initId=${log.unitId }&initType=${log.unitType}">${log.unitName }</a>
													</s:authorize>
													<s:authorize ifAllGranted="ROLE_PRACTICE">
														<a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${log.unitId }">${log.unitName }</a>
													</s:authorize>
												</c:otherwise>
											</c:choose>
									</span>
									<span>的患者:&nbsp;
										<s:authorize ifAllGranted="ROLE_LAB">
											<a href="${pageContext.request.contextPath}/labAction/reports/patient.do?id=${log.patientId}">${log.patientFirstName }${log.patientLastName }&nbsp;</a>
										</s:authorize>
										<s:authorize ifAllGranted="ROLE_PRACTICE">
											<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patient&id=${log.patientId}">${log.patientFirstName }${log.patientLastName }&nbsp;</a>
										</s:authorize>
									</span>
								</div>
							</dd>
							<dd>
								<i>
									<span>${log.remarks }</span>
								</i>
							</dd>
						</c:if>
						<!-- 订单创建 -->
						<c:if test="${log.logType=='CASE_CREATE'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab3_03.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>订单</span>
									<span>
										<s:authorize ifAllGranted="ROLE_LAB">
											<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${log.primaryId}">#${log.primaryId }</a>
										</s:authorize>
										<s:authorize ifAllGranted="ROLE_PRACTICE">
											<a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${log.primaryId}">#${log.primaryId }</a>
										</s:authorize>
									</span>
									<span>来自</span>
									<span>
										<c:choose>
												<c:when test="${sessionUser.unitId==log.unitId}">
													${log.unitName }
												</c:when>
												<c:otherwise>
													<s:authorize ifAllGranted="ROLE_LAB">
														<a href="${pageContext.request.contextPath}/labAction/setting/practices.do?initId=${log.unitId }&initType=${log.unitType}">${log.unitName }</a>
													</s:authorize>
													<s:authorize ifAllGranted="ROLE_PRACTICE">
														<a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${log.unitId }">${log.unitName }</a>
													</s:authorize>
												</c:otherwise>
											</c:choose>
									</span>
									<span>的患者:&nbsp;
										<s:authorize ifAllGranted="ROLE_LAB">
											<a href="${pageContext.request.contextPath}/labAction/reports/patient.do?id=${log.patientId}">${log.patientFirstName }${log.patientLastName }&nbsp;</a>
										</s:authorize>
										<s:authorize ifAllGranted="ROLE_PRACTICE">
											<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patient&id=${log.patientId}">${log.patientFirstName }${log.patientLastName }&nbsp;</a>
										</s:authorize>
									</span>
								</div>
							</dd>
							<dd>
								<i>
									<span>${log.remarks }</span>
								</i>
							</dd>
						</c:if>
						<!-- 收件要求 -->
						<c:if test="${log.logType=='PICKUP_REQUEST'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab_43.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>收件请求来自&nbsp;</span>
									<span>
										<c:choose>
												<c:when test="${sessionUser.unitId==log.unitId}">
													${log.unitName }
												</c:when>
												<c:otherwise>
													<s:authorize ifAllGranted="ROLE_LAB">
														<a href="${pageContext.request.contextPath}/labAction/setting/practices.do?initId=${log.unitId }&initType=${log.unitType}">${log.unitName }</a>
													</s:authorize>
													<s:authorize ifAllGranted="ROLE_PRACTICE">
														<a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId==${log.unitId }">${log.unitName }</a>
													</s:authorize>
												</c:otherwise>
											</c:choose>
									</span>
									<span>&nbsp;收货日期&nbsp;${log.remarks }</span>
								</div>
							</dd>
						</c:if>
						<!-- 账户支付-->
						<c:if test="${log.logType=='PAYMENT'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab_43.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>${log.unitName }</span>
									<span>&nbsp;${log.remarks }</span>
								</div>
							</dd>
						</c:if>
						<!-- 账单报表 -->
						<c:if test="${log.logType=='BILL_REPORT'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab_43.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>${log.userName }</span>
									<span>&nbsp;${log.remarks }</span>
								</div>
							</dd>
						</c:if>
						<!-- 发票 -->
						<c:if test="${log.logType=='INVOICE'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab_43.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>${log.unitName }</span>
									<span>&nbsp;${log.remarks }</span>
								</div>
							</dd>
						</c:if>
						<!-- 账户 -->
						<c:if test="${log.logType=='ACCOUNT'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab_32.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>${log.partnerUnitName }</span>
									<span>&nbsp;${log.remarks }</span>
								</div>
							</dd>
						</c:if>
						<!-- 其他 -->
						<c:if test="${log.logType=='OTHER'}">
							<dd>
								<div class="Lab_b_right_middle_bottom_c_left">
									<img
										src="${pageContext.request.contextPath}/jsp/lab/images/Lab_43.jpg" />
								</div>
								<div class="Lab_b_right_middle_bottom_c_right">
									<span>${log.remarks }</span>
								</div>
							</dd>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</c:when>
		<c:otherwise>
			暂无日志记录！！！
		</c:otherwise>
	</c:choose>
</dl>
