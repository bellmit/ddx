<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 翻页处理 begin -->
			<div class="Settings_Practices_middle_b">
			<div class="Settings_Practices_middle_b_left">
			<c:choose>
				<c:when test="${ empty datas.cases.datas}">
					显示从0到0，共0
				</c:when>
				
				<c:otherwise>
					显示从${datas.cases.frist }到${datas.cases.last }，共${datas.cases.total }
				</c:otherwise>
			</c:choose>
			
			</div>
			<div class="Settings_Practices_middle_b_right">
				<c:choose>
					<c:when test="${datas.cases.offset==datas.cases.totalPage and datas.cases.offset==1}">
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></span>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${datas.cases.offset<=datas.cases.totalPage and datas.cases.offset>1}">
							<span><a href="javascript:void(0)" onclick="listTagsCases(${datas.cases.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
							</c:when>
							<c:otherwise>
							<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${datas.cases.offset<datas.cases.totalPage}">
							<span><a href="javascript:void(0)" onclick="listTagsCases(${datas.cases.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
	<table width="100%" border="0" cellspacing="0"
		cellpadding="0">
		<tr class="Settings_Practices_middle_c_a">
			<td>
				<span><a href="#"><img
							src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_13.jpg" class="ByMonth_a" />
				</a>
				</span>
				<span><div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img
								src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" />
						</a>
					</div>
					<div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" />
						</a>
					</div> </span>
			</td>
			<td>
				<span><a href="#"><img
							src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_16.jpg" class="ByMonth_a" />
				</a>
				</span>
				<span><div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img
								src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" />
						</a>
					</div>
					<div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" />
						</a>
					</div> </span>
			</td>
			<td>
				<span>订单</span>
				<span><div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img
								src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" />
						</a>
					</div>
					<div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" />
						</a>
					</div> </span>
			</td>
			<td>
				<span>发票</span>
				<span><div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img
								src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" />
						</a>
					</div>
					<div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" />
						</a>
					</div> </span>
			</td>
			<td>
				<span>主治医生</span>
				<span><div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img
								src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" />
						</a>
					</div>
					<div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" />
						</a>
					</div> </span>
			</td>
			<td>
				<span>技工间</span>
				<span><div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img
								src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" />
						</a>
					</div>
					<div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" />
						</a>
					</div> </span>
			</td>
			<td title="临床发往技工间的日期">
				<span>发货日期</span>
				<span><div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img
								src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg" />
						</a>
					</div>
					<div class="Settings_Practices_middle_c_a_a">
						<a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg" />
						</a>
					</div> </span>
			</td>
			<td title="从技工间发回的日期">
				<span>接收日期</span>
				<span><a href="#"
					class="Settings_Practices_middle_c_a_b"><img
							src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg" />
				</a>
				</span>
			</td>
		</tr>
		<c:if test="${!empty datas.cases.datas}">
			<c:forEach items="${datas.cases.datas}" var="cases">
				<tr>
					 <td>
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
					<td></td>
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
										</span><h2>●&nbsp;&nbsp;${pro.procedure_name }</h2></span>
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
					<td>
						${cases.invoice }
					</td>
					<td>
						${cases.provider }
					</td>
					<td class="practicemonthPatients_a">
						<a href="${pageContext.request.contextPath}/partners/requestAccount.do?labId=${cases.labId}">${cases.msg }</a>
					</td>
					<td>
						<fmt:formatDate value="${cases.sendToLabDate }" type="date" pattern="yyyy-MM-dd" />
					</td>
					<td>
						<fmt:formatDate value="${cases.deliveryDate }" type="date" pattern="yyyy-MM-dd" />
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty datas.cases.datas}">
			<tr align="center">
				<td colspan="8" style="text-align: center;">无数据</td>
			</tr>
		</c:if>
	</table>
</div>
<!-- 翻页处理 begin -->
			<div class="Settings_Practices_middle_b">
			<div class="Settings_Practices_middle_b_left">
			<c:choose>
				<c:when test="${ empty datas.cases.datas}">
					显示从0到0，共0
				</c:when>
				
				<c:otherwise>
					显示从${datas.cases.frist }到${datas.cases.last }，共${datas.cases.total }
				</c:otherwise>
			</c:choose>
			</div>
			<div class="Settings_Practices_middle_b_right">
				<c:choose>
					<c:when test="${datas.cases.offset==datas.cases.totalPage and datas.cases.offset==1}">
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
						<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></span>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${datas.cases.offset<=datas.cases.totalPage and datas.cases.offset>1}">
							<span><a href="javascript:void(0)" onclick="listTagsCases(${datas.cases.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
							</c:when>
							<c:otherwise>
							<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${datas.cases.offset<datas.cases.totalPage}">
							<span><a href="javascript:void(0)" onclick="listTagsCases(${datas.cases.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
