<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="Cases_bottom_right_a">
	标记为到达的订单
</div>
<div class="Settings_Practices">
	<div class="Settings_Practices_top"></div>
	<div class="Settings_Practices_middle">
		<form action="" method="get">
			<div class="Settings_Practices_middle_a">
				<div class="Settings_Practices_middle_a_left">
					<!-- 索搜框开始 -->
					<!--
					<div class="Settings_Practices_middle_a_leftsearch">
						<div class="Settings_Practices_middle_a_leftsearch01">
							搜 索：
						</div>
						<div class="Settings_Practices_middle_a_leftsearch02">
							<input name="input" type="text" value="${search }" id="search-users"/>
							<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listArriveCases('1')"/>
							</a>
						</div>
					</div>
					 -->
					<!-- 索搜框结束-->	
				</div>
				<div class="Settings_Practices_middle_a_right">
					<ul>
						<li class="practicemonthArriveCases">
							<a href="javascript:void(0)" onclick="showCheckCases();">抵达所选</a>
						</li>
					</ul>
				</div>
				<div style="display: none;" id="showCheckCases-div"></div>
			</div>
			<!-- 翻页处理 begin -->
			<div class="Settings_Practices_middle_b">
			<div class="Settings_Practices_middle_b_left">显示从${datas.frist }到${datas.last }，共${datas.total }</div>
			<div class="Settings_Practices_middle_b_right">
				<c:choose>
					<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></span>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
							<span><a href="javascript:void(0)" onclick="listArriveCases(${datas.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
							</c:when>
							<c:otherwise>
							<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${datas.offset<datas.totalPage}">
							<span><a href="javascript:void(0)" onclick="listArriveCases(${datas.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
							</c:when>
							<c:otherwise>
							<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</div>
			</div>
			<!-- 翻页处理 end -->
			<div class="Settings_Practices_middle_c">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr class="Settings_Practices_middle_c_a">
						<td width="43" style="text-align: center">
							<a href="javascript:void(0)" title="状态"><img alt="状态" src="${pageContext.request.contextPath}/jsp/practice/images/practice71_03.jpg"/></a>
						</td>
						<td width="400" style="text-align: center">
							订单
						</td>
						<td width="100">
							技工间
						</td>
						<td width="50">
							发票
						</td>
						<td width="50">
							患者
						</td>
						<td width="100">
							返回时间
						</td>
					</tr>
					<c:forEach items="${datas.datas}" var="cases">
						<tr name="text" style="cursor: pointer;" onclick="setColor('${cases.caseId }');" id="${cases.caseId }" flag="" title="订单#${ cases.caseId}来自 ${cases.msg } 的患者 ${cases.patient } ">
							 <td style="padding-left:15px">
					       		<c:if test="${cases.status eq 'OPEN' && empty cases.onHoldStatus }">
					       			<span title="订单进行中..." class="icon16 icon-case-open"></span>
					       		</c:if>
					       		<c:if test="${cases.status eq 'CLOSE' }">
					       			<span title="订单已关闭" class="icon16 icon-case-closed"></span>
					       		</c:if>
					       		<c:if test="${cases.status eq 'OPEN' && !empty cases.onHoldStatus }">
					       			<span title="订单处于搁置/延时状态 - ${cases.onHoldStatus }" class="ui-icon ui-iconx ui-icon-clock"></span>
					       		</c:if>
					        </td>
							<td class="practicemonthArriveCases_a">
								<dl>
									<dt>
										<span><a href="${pageContext.request.contextPath}/casesAction/getDataById.do?caseId=${cases.caseId}">#${cases.caseId }</a>
										</span>
										<c:if test="${cases.status == 'CLOSE'}">
											<span><a href="#"><img src="${pageContext.request.contextPath}/jsp/practice/images/practice74_07.jpg" />
											</a>
											</span>
										</c:if>
										
									</dt>
									<c:forEach items="${cases.extObj}" var="pro">
										<dd>
											<div style="font-style: oblique;">
												</span>&nbsp;&nbsp;${pro.procedure_name }</span>
											</div>
											<div class="practicemonthArriveCases_b">
												<table style="width: 100%;">
									  					<c:forEach items="${pro.attrList}" var="attr">
									  						<c:if test="${!empty attr.valueDes }">
									  							<tr>
											  						<td><strong>${attr.lable }</strong></td>
											  						<td>${attr.valueDes }</td>
												  				</tr>
									  						</c:if>
									  					</c:forEach>
									  			</table>
											</div>
										</dd>
									</c:forEach>
								</dl>
							</td>
							<td class="practicemonthPatients_a">
								<a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${cases.labId}">${cases.msg }</a>
							</td>
							<td>
								${cases.invoice }
							</td>
							<td class="practicemonthPatients_a">
								<a href="#">${cases.patient }</a>
							</td>
							<td>
								<fmt:formatDate value="${cases.deliveryDate }" type="date"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- 翻页处理 begin -->
			<div class="Settings_Practices_middle_b">
			<div class="Settings_Practices_middle_b_left">显示从${datas.frist }到${datas.last }，共${datas.total }</div>
			<div class="Settings_Practices_middle_b_right">
				<c:choose>
					<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></span>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
							<span><a href="javascript:void(0)" onclick="listArriveCases(${datas.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
							</c:when>
							<c:otherwise>
							<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${datas.offset<datas.totalPage}">
							<span><a href="javascript:void(0)" onclick="listArriveCases(${datas.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
							</c:when>
							<c:otherwise>
							<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</div>
			</div>
			<!-- 翻页处理 end -->
		</form>
	</div>
	<div class="Settings_Practices_bottom"></div>
</div>
