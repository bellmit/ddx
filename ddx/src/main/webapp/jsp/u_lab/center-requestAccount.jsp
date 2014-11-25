<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.multiselect.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="gcsyshyzx02">

<div class="PartnerLabsadminqianjin">
<div class="PartnerLabsadminqianjin_left" id="PartnerLabsadminqianjin_left-div">
<div class="PartnerLabsadminqianjin_left_a">合作账号申请</div>
<div class="PartnerLabsadminqianjin_left01">
<dl>
<dt>申请技工间的合作账号 </dt>
<dd>点击下方"申请合作"按钮</dd>
<dd>等待技工间进行账户设置</dd>
<dd>等待审批的账号在1-7天内激活</dd>
</dl>
</div>
<div class="PartnerLabsadminqianjin_left_a">电子账单设置</div>
<div class="PartnerLabsadminqianjin_left01">
<dl>
<dt>技工间将通过电子邮件接收账单</dt>
<dd>电子账单状态 <strong style="color: red;" id="is-enable">未启用</strong>.</dd>
<dd id="enabled-disabled-pts">启用，选择一个或多个账户接收电子账单。</dd>
</dl>
</div>
<div class="PartnerLabsadminqianjin_left02">
<label title="" for="providers"> 收件人（S） </label>

<select id="request-account-ebill-user-select" name="example-list" multiple="multiple" onchange="controlEnable();">
	<c:if test="${!empty myLabUserList}">
		<c:forEach items="${myLabUserList}" var="user">
				<option label="" value="${user.accountId }" >${user.firstName }${user.lastName }</option>
		</c:forEach>
	</c:if>
</select>
<span><a href="javascript:void(0)" onclick="showAddUserDialog();" id="add-user-a">[+]</a></span>
</div>
<div class="PartnerLabsadminqianjin_left02">
<label title="" for="providers">账单类型</label>
<select size="1" name="example-list" id="request-billtype">
	<option label="" value="1">账单</option>
	<option label="" value="2">账单和发票</option>
</select>
</div>
<div class="PartnerLabsadminqianjin_left_a">申请合作说明</div>
<div class="PartnerLabsadminqianjin_left01">
<dl>
<dt>如点击下方”申请合作“按钮，您将同意与合作的技工间分享您的相关账户信息 </dt>
<dd></dd>
<dd></dd>
</dl>
</div>
<div class="PartnerLabsadminqianjin_left03"><a href="javascript:void(0)" onclick="accountPending('${requestAccountLab.id}');">申请合作</a></div>
</div>
<div class="PartnerLabsadminqianjin_right">
<ul>
<li>
<div class="PartnerLabsadminqianjin_right_top"><a href="javascript:void(0)">技工间详细信息</a></div>
<div class="PartnerLabsadminqianjin_right_middle01">
<form action="" method="get">
<ul>
<li><strong>${requestAccountLab.name}</strong></li>
<li>${requestAccountLab.address}</li>
<li> ${requestAccountLab.city}</li>
<li>${requestAccountLab.zipCode}</li>
<li>${requestAccountLab.country}</li>
<li><strong>电话</strong>${requestAccountLab.phoneNumber}</li>
<li><a href="mailto:${requestAccountLab.email }">${requestAccountLab.email}</a></li>
</ul>
</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom01"></div>
</li>
</ul>
</div>
</div>


</div>
