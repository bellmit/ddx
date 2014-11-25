<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${labs}" var="lab">
	<div class="Personalize_b_middle_left" style="margin-top: 15px;">
	   	${lab.name }
	</div>
	<div class="Personalize_b_middle_right" style="margin-top: 15px;">
	   	<dl name="partner-labs-permissons" id="${lab.id}">
	   		<c:if test="${lab.cases.newCase == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.newCase=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-newCase"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-newCase"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				创建订单
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.caseEnclosures == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.caseEnclosures=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-caseEnclosures"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-caseEnclosures"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				随单附件
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.cancelCase == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.cancelCase=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-cancelCase"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-cancelCase"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				取消订单
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.listCasesArrivingToday == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.listCasesArrivingToday=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-listCasesArrivingToday"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-listCasesArrivingToday"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				列出今天到达订单
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.listCases == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.listCases=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-listCases"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-listCases"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				订单列表
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.pickup == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.pickup=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-pickup"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-pickup"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				取件服务
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.disabledNotesOnReceived == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.disabledNotesOnReceived=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-disabledNotesOnReceived"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-disabledNotesOnReceived"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				接收残缺笔记
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.caseNotes == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.caseNotes=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-caseNotes"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-caseNotes"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				订单备注
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.cases.attachCaseFiles == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.attachCaseFiles=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-attachCaseFiles"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-attachCaseFiles"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				附件订单附件
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.finances.accountPayment == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.accountPayment=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-accountPayment"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-accountPayment"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				账户支付
		   			</span>
	   			</dt>
	   		</c:if>
	   		<c:if test="${lab.finances.priceList == true}">
	   			<dt>
		   			<span>
		   				<c:choose>
							<c:when test="${lab.pMap.priceList=='true' }">
								<input type="checkbox" checked="checked" id="${lab.id}-priceList"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="${lab.id}-priceList"/>
							</c:otherwise>
						</c:choose>
		   			</span>
		   			<span>
		   				价格列表
		   			</span>
	   			</dt>
	   		</c:if>
	   	</dl>
	</div>
</c:forEach>
