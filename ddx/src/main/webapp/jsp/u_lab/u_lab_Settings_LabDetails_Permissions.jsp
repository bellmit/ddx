<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="General_middle_bottom_a">临床机构的权限</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left">订单</div>
<div class="General_middle_bottom_b_middle_right">
<dl>
<dt><span>
	<c:choose>
		<c:when test="${cases.newCase==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-newCase"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-newCase"/>
		</c:otherwise>
	</c:choose>
</span><span>创建订单</span></dt>
<dt><span>


<c:choose>
		<c:when test="${cases.caseEnclosures==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-caseEnclosures"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-caseEnclosures"/>
		</c:otherwise>
	</c:choose>
</span><span>附加随单附件</span></dt>
<dt><span>

<c:choose>
		<c:when test="${cases.cancelCase==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-cancelCase"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-cancelCase"/>
		</c:otherwise>
	</c:choose>
</span><span>取消订单</span></dt>
<dt><span>

<c:choose>
		<c:when test="${cases.listCasesArrivingToday==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-listCasesArrivingToday"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-listCasesArrivingToday"/>
		</c:otherwise>
	</c:choose>
</span><span>列出今天到达订单</span></dt>
<dt><span>

<c:choose>
		<c:when test="${cases.listCases==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-listCases"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-listCases"/>
		</c:otherwise>
	</c:choose>
</span><span>订单列表</span></dt>
<dt><span>

<c:choose>
		<c:when test="${cases.pickup==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-pickup"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-pickup"/>
		</c:otherwise>
	</c:choose>
</span><span>回收/收件</span></dt>
<dt><span>

<c:choose>
		<c:when test="${cases.disabledNotesOnReceived==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-disabledNotesOnReceived"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-disabledNotesOnReceived"/>
		</c:otherwise>
	</c:choose>
</span><span>接收残缺笔记</span></dt>
<dt><span>

<c:choose>
		<c:when test="${cases.caseNotes==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-caseNotes"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-caseNotes"/>
		</c:otherwise>
	</c:choose>
</span><span>订单备注</span></dt>
<dt><span>


<c:choose>
		<c:when test="${cases.attachCaseFiles==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-attachCaseFiles"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-attachCaseFiles"/>
		</c:otherwise>
	</c:choose>
</span><span>附加订单附件</span></dt>
</dl>
</div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">财务</div>
<div class="General_middle_bottom_b_middle_right">
<dl>
<dt><span>

<c:choose>
		<c:when test="${finances.accountPayment==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-accountPayment"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-accountPayment"/>
		</c:otherwise>
	</c:choose>
</span><span>账户支付</span></dt>
<dt><span>

<c:choose>
		<c:when test="${finances.priceList==true}">
			<input name="" value="" type="checkbox" checked="checked" id="lab-details-permissions-priceList"/>
		</c:when>
		<c:otherwise>
			<input name="" value="" type="checkbox" id="lab-details-permissions-priceList"/>
		</c:otherwise>
	</c:choose>
</span><span>价格列表</span></dt>
</dl>
</div>
</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_anniu"><a href="javascript:void(0)" onclick="savePermissions();">提交</a></div>
