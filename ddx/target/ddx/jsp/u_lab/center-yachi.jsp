<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/teeth_selector.js"></script>
<div class="gcsyshyzx">
<input type="hidden" id="reqAccLabId" value="${requestAccountLab.id}">
	<div class="PartnerLabsadminqianjin">
		<div class="PartnerLabsadminqianjin_left">
			<div class="PartnerLabsadminqianjin_left_a">
				欢迎来到${requestAccountLab.name }
			</div>
			<div class="PartnerLabsadminqianjin_left_a">
				&nbsp;
			</div>
			<!--
			<div class="PartnerLabsadminqianjin_left_c"><i>这不是DDX授权的技工间</i></div>
			<div class="PartnerLabsadminqianjin_left_d">
			<ul>
			<li>电子邮件地址没有提供这个实验室. 订单文件不能被传送到实验室与一个电子邮件地址.</li>
			<li>新增一个邮箱地址, 跳到附加现有文件.</li>
			</ul>
			</div>
			-->
			<div class="PartnerLabsadminqianjin_left_a">
				订单管理
			</div>
			<div class="PartnerLabsadminqianjin_left_b">
				<dl>
					<c:if test="${casesPermissions.newCase==true}">
						<dt>
							<a href="javascript:void(0)"
								onclick="gotoNewCase(${requestAccountLab.id },${thisLab.id });">新建订单</a>
						</dt>
						<dd>
							新建一个订单，并获得一个订单的预交付时间
						</dd>
					</c:if>
					<!--<c:if test="${casesPermissions.caseEnclosures==true}">
						<dt style="text-decoration: line-through">
							<a href="javascript:void(0)">附加订单模型</a>
						</dt>
						<dd style="text-decoration: line-through">
							附加订单模型
						</dd>
					</c:if>
					<c:if test="${casesPermissions.cancelCase}">
						<dt style="text-decoration: line-through">
							<a href="javascript:void(0)">取消订单</a>
						</dt>
						<dd style="text-decoration: line-through">
							取消订单
						</dd>
					</c:if>
					<c:if test="${casesPermissions.listCasesArrivingToday==true}">
						<dt style="text-decoration: line-through">
							<a href="javascript:void(0)">列出今天到达订单</a>
						</dt>
						<dd style="text-decoration: line-through">
							列出今天到达订单
						</dd>
					</c:if>
					--><c:if test="${casesPermissions.listCases==true}">
						<dt>
							<a href="javascript:void(0)"
								onclick="showAllLabCases(${thisLab.id},${requestAccountLab.id });">订单列表</a>
						</dt>
						<dd>
							浏览与&nbsp;&nbsp;
							<strong>${requestAccountLab.name }</strong>&nbsp;&nbsp;合作的所有订单
						</dd>
					</c:if>
					<c:if test="${casesPermissions.pickup==true}">
						<dt>
							<a href="javascript:void(0)" onclick="goPickupPage(${requestAccountLab.id });">取件服务</a>
						</dt>
						<dd>
							要求合作技工间上门取订单，无需在网上新建订单和输入订单详情
						</dd>
					</c:if>
					<!--<c:if test="${casesPermissions.disabledNotesOnReceived==true}">
						<dt style="text-decoration: line-through">
							<a href="javascript:void(0)">接收残缺笔记</a>
						</dt>
						<dd style="text-decoration: line-through">
							接收残缺笔记
						</dd>
					</c:if>
					<c:if test="${casesPermissions.caseNotes==true}">
						<dt style="text-decoration: line-through">
							<a href="javascript:void(0)">订单备注</a>
						</dt>
						<dd style="text-decoration: line-through">
							订单备注
						</dd>
					</c:if>
					<c:if test="${casesPermissions.attachCaseFiles==true}">
						<dt style="text-decoration: line-through">
							<a href="javascript:void(0)">附加订单附件</a>
						</dt>
						<dd style="text-decoration: line-through">
							附加订单附件
						</dd>
					</c:if>
					--><c:if
						test="${casesPermissions.newCase!=true and casesPermissions.caseEnclosures!=true and casesPermissions.cancelCase!=true and casesPermissions.listCasesArrivingToday != true 
			and casesPermissions.listCases!=true and casesPermissions.pickup!=true and casesPermissions.disabledNotesOnReceived!=true and casesPermissions.caseNotes!=true and casesPermissions.attachCaseFiles!=true}">
		无权限进行任何操作！
	</c:if>
				</dl>
			</div>
			<div class="PartnerLabsadminqianjin_left_a">
				账务管理
			</div>
			<div class="PartnerLabsadminqianjin_left_b">
				<dl>
					<c:if test="${financesPermissions.accountPayment==true}">
						<dt>
							<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePayment&id=${requestAccountLab.id}">账户支付</a>
						</dt>
						<dd>
							授权你的账户进行支付
						</dd>
					</c:if>

					<dt>
						<a href="javascript:void(0)">账户档案</a>
					</dt>
					<dd>
						管理账户上的付款信息
					</dd>

					<c:if test="${financesPermissions.priceList==true}">
						<dt>
							<a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePricerList&id=${requestAccountLab.id}">价格列表</a>
						</dt>
						<dd>
							查看或打印<strong>${requestAccountLab.name }</strong> 对你授权的价格列表
						</dd>
					</c:if>
				</dl>
			</div>
		</div>
		<div class="PartnerLabsadminqianjin_right" style="margin-top: 50px;">
			<ul>
			<c:if test="${casesPermissions.newCase==true}">
				<li>
					<div class="PartnerLabsadminqianjin_right_top">
						<a href="javascript:void(0)" onclick="loadPro('${requestAccountLab.id}')">快速新建订单</a>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle">
						<form action="" method="get" id="caseForm">
							<ul>
								<s:authorize ifAllGranted="ROLE_PRACTICE">
                <c:if test="${ !empty providers }">
                    <li>
                        <div class="PartnerLabsadminqianjin_right_middle_left">
                           <span>主治医师</span><span
							class="PartnerLabsadminqianjin_right_middle_a">*</span>
                        </div>
                        <div class="PartnerLabsadminqianjin_right_middle_right">
		                            <select id="providers" class="PartnerLabsadminqianjin_right_middle_b">
		                                <c:forEach items="${providers }" var="provider">
		                                    <option value="${provider.accountId}">
		                                        ${provider.salutation}${provider.firstName}${provider.lastName}
		                                    </option>
		                                </c:forEach>
		                            </select>
		                        </div>
		                    </li>
		                </c:if>
		                </s:authorize>
								<li>
									<div class="PartnerLabsadminqianjin_right_middle_left">
										<span>姓</span><span
											class="PartnerLabsadminqianjin_right_middle_a">*</span>
									</div>
									<div class="PartnerLabsadminqianjin_right_middle_right">
										<input name="" type="text" id="firstName" maxlength="10"
											class="PartnerLabsadminqianjin_right_middle_b" />
									</div>
								</li>
								 <li style="display: none;" id="firstName_info">
									<div class="NewCase_a_middle_left_left">&nbsp;</div>
									<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请输入患者的姓</i></div>
								</li>
								<li>
									<div class="PartnerLabsadminqianjin_right_middle_left">
										<span>名</span><span
											class="PartnerLabsadminqianjin_right_middle_a">*</span>
									</div>
									<div class="PartnerLabsadminqianjin_right_middle_right">
										<input name="" type="text" id="lastName" maxlength="10"
											class="PartnerLabsadminqianjin_right_middle_b" />
									</div>
								</li>
								 <li style="display: none;" id="lastName_info">
									<div class="NewCase_a_middle_left_left">&nbsp;</div>
									<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请输入患者的名</i></div>
								</li>
								
								<li>
									<div class="PartnerLabsadminqianjin_right_middle_left">
										<span>发送</span><span
											class="PartnerLabsadminqianjin_right_middle_a">*</span>
									</div>
									<div class="PartnerLabsadminqianjin_right_middle_right">
										<span><input id="sendToLabDate" name="" type="text" readonly="readonly"
												class="PartnerLabsadminqianjin_right_middle_b" />
										</span><span class="PartnerLabsadminqianjin_right_middle_c"><a
											href="javascript:void(0)"
											onclick="WdatePicker({el:'sendToLabDate',minDate:'%y-%M-%d'})"></a>
										</span>
									</div>
								</li>
								<li style="display: none;" id="sendToLabDate_info">
									<div class="NewCase_a_middle_left_left">&nbsp;</div>
									<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请选择发送日期</i></div>
								</li>
								<li>
									<div class="PartnerLabsadminqianjin_right_middle_left">
									<span>工序 </span>
									<span class="PartnerLabsadminqianjin_right_middle_a" style="color: red;">*&nbsp;</span>
									</div>
									<div class="PartnerLabsadminqianjin_right_middle_right">
										<span>
											<select name="" size="1" id="add-pro-id-select" onchange="loadProcedure('0',this.value,'false')">
											</select>
										</span>
									<span class="PartnerLabsadminqianjin_right_middle_d"><a href="javascript:void(0)"></a></span>
									</div>
								</li>
								<li>
									<div name="procedure-div">
										<div id="attributes-0"></div>
									</div>
								</li>
								 <li style="display: none;" id="procedure-select_info">
									 <div class="NewCase_a_middle_left_left">&nbsp;</div>
									 <div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请选择工序</i></div>
								 </li>
								 <li>
								 	<jsp:include page="../u_practice/teeth_tmpl.jsp"></jsp:include>
								 </li>
								<%--技工间协议是否显示 --%>
									<c:if test="${caseTerms.valid eq 'true' }">
										<li class="NewCase_c_middle_rightsd">
											<div class="NewCase_c_middle_right_left">
												<input type="checkbox" id="terms" />我同意所有的&nbsp;
											</div>
											<div class="NewCase_c_middle_right_right_01">
												<a href="javascript:void(0);" onclick="showTermsDialog()">协议条款</a>
											</div></li>
										<li style="display: none;" id="terms_info">
											<div class="NewCase_a_middle_left_left">&nbsp;</div>
											<div class="NewCase_a_middle_left_right">
												<i class="Addonecuowu_b">您必须同意此协议条款</i>
											</div></li>
									</c:if>
									<li>

									<div class="PartnerLabsadminqianjin_right_middle_left">
										&nbsp;
										<input type="hidden" id="newType" value="add" />
										<%--伙伴技工间ID --%>
                                        <input type="hidden" id="partnerLabId" value="${requestAccountLab.id }"/>
                                        <input type="hidden" id="term_valid" value="${caseTerms.valid}" />
									</div>

									<div class="PartnerLabsadminqianjin_right_middle_right">

										<span class="PartnerLabsadminqianjin_right_middle_g"> <a
											href="javascript:void(0)" onclick="quickAddCases();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提交</a>
										</span>
									</div>
								</li>
							</ul>
						</form>
					</div>
					<div class="PartnerLabsadminqianjin_right_bottom"></div>
					 <%--用户使用协议及条款 --%>
                    <div id="terms_dialog" style="display: none;">
                    	<p>${caseTerms.terms }</p>
                    </div>
				</li>
				</c:if>
				<c:if test="${casesPermissions.listCasesArrivingToday==true}">
					<li>
						<div class="PartnerLabsadminqianjin_right_top">
							<a href="javascript:void(0)">今天待抵达的订单</a>
						</div>
						<div class="PartnerLabsadminqianjin_right_middle">
							<form action="" method="get">
								<c:choose>
									<c:when test="${casesArrivePm.total == 0 }">
										<ul>
											<li>
												今天没有从&nbsp;&nbsp;${requestAccountLab.name}&nbsp;&nbsp;技工间抵达的订单
											</li>
										</ul>
									</c:when>
									<c:otherwise>
										<table width="100%" id="cases_arrive">
											<thead>
												<tr>
													<td class="practiceindexright_a">
														<a href="#">订单</a>
													</td>
													<td class="practiceindexright_b">
														<a href="#">患者</a>
													</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${casesArrivePm.datas }" var="casesArrive">
													<tr>
														<td>
															<a
																href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${casesArrive.caseId }">#${casesArrive.caseId
																}</a>
														</td>
														<td>
															${casesArrive.patient }
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:otherwise>
								</c:choose>
	
							</form>
						</div>
						<div class="PartnerLabsadminqianjin_right_bottom"></div>
					</li>
				</c:if>
				<li>
					<div class="PartnerLabsadminqianjin_right_top">
						<a href="javascript:void(0)">今天待寄出的订单</a>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle">
						<form action="" method="get">
							<c:choose>
								<c:when test="${casesShipPm.total == 0 }">
									<ul>
										<li>
											今天没有发往&nbsp;&nbsp;${requestAccountLab.name
											}&nbsp;&nbsp;技工间的订单
										</li>
									</ul>
								</c:when>
								<c:otherwise>
									<table width="100%" id="cases_ship">
										<thead>
											<tr>
												<td class="practiceindexright_a">
													<a href="#">订单</a>
												</td>
												<td class="practiceindexright_b">
													<a href="#">患者</a>
												</td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${casesShipPm.datas }" var="casesShip">
												<tr>
													<td>
														<a
															href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${casesShip.caseId }">#${casesShip.caseId
															}</a>
													</td>
													<td>
														${casesShip.patient }
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:otherwise>
							</c:choose>
						</form>
					</div>
					<div class="PartnerLabsadminqianjin_right_bottom"></div>
				</li>
				<li>
					<div class="PartnerLabsadminqianjin_right_top">
						<a href="javascript:void(0)">试戴订单</a>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle">
						<form action="" method="get">
							<c:choose>
								<c:when test="${casesTryInPm.total == 0 }">
									<ul>
										<li>
											当前&nbsp;&nbsp;${requestAccountLab.name
											}&nbsp;&nbsp;技工间没有试戴的订单
										</li>
									</ul>
								</c:when>
								<c:otherwise>
									<table width="100%" id="cases_tryin">
										<thead>
											<tr>
												<td class="practiceindexright_a">
													<a href="#">订单</a>
												</td>
												<td class="practiceindexright_b">
													<a href="#">患者</a>
												</td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${casesTryInPm.datas }" var="casesTryIn">
												<tr>
													<td>
														<a
															href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${casesTryIn.caseId }">#${casesTryIn.caseId
															}</a>
													</td>
													<td>
														${casesTryIn.patient }
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:otherwise>
							</c:choose>
						</form>
					</div>
					<div class="PartnerLabsadminqianjin_right_bottom"></div>
				</li>
				<c:if test="${user.unitType == 1 }">
				<li>
					<div class="PartnerLabsadminqianjin_right_top">
						<a href="javascript:void(0)" onclick="loadDraftCasesByLabPartner(${requestAccountLab.id});">治疗方案草稿</a>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle" style="display: none;" id="lp_draft_cases_div">
						
					</div>
					<div class="PartnerLabsadminqianjin_right_bottom" style="display: none;"></div>
				</li>
				</c:if>
				
				<li>
					<div class="PartnerLabsadminqianjin_right_top">
						<a href="javascript:void(0)">联系方式</a>
					</div>
					<div class="PartnerLabsadminqianjin_right_middle">
						<form action="" method="get">
							<ul>
								<li>
									<strong>${requestAccountLab.name }</strong>
								</li>
								<li>
									${requestAccountLab.address }
								</li>
								<li>
									${requestAccountLab.city }
								</li>
								<li>
									${requestAccountLab.zipCode }
								</li>
								<li>
									${requestAccountLab.country }
								</li>
								<li>
									<strong>电话</strong>${requestAccountLab.phoneNumber }
								</li>
							</ul>
						</form>
					</div>
					<div class="PartnerLabsadminqianjin_right_bottom"></div>
				</li>
			</ul>
		</div>
	</div>
</div>
