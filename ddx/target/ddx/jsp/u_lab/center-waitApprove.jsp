<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="gcsyshyzx02">

<div class="PartnerLabsadminqianjin">
<div class="PartnerLabsadminqianjin_left">
	<c:if test="${approveStatus=='1'}">
		<div style="margin-top: 10px;">
			<h1>账户已被关闭</h1>
			与<strong>${requestAccountLab.name }</strong>的请求已被关闭。有关您的帐户的状态的更多详细信息，请直接与<strong>${requestAccountLab.name }</strong>联系。
		</div>
	</c:if>
	<c:if test="${approveStatus=='2'}">
		<div style="margin-top: 10px;">
			<h1>合作账号激活中</h1>
			您申请的<strong>${requestAccountLab.name }</strong>技工间账号请求正在等待审批,如想了解更多申请状态的细节请直接联系<strong>${requestAccountLab.name }</strong>技工间。
		</div>
	</c:if>
	<c:if test="${approveStatus!='1' and approveStatus!='2'}">
		<div style="margin-top: 10px;">
			<h1>状态异常</h1>
			数据异常，请联系管理员。
		</div>
	</c:if>
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
<li><a href="#">${requestAccountLab.email}</a></li>
</ul>
</form>
</div>
<div class="PartnerLabsadminqianjin_right_bottom01"></div>
</li>
</ul>
</div>
</div>


</div>
