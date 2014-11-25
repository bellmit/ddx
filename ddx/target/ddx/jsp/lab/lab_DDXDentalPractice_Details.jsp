<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="General_middle_bottom_a">详细情况</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form method="get" action="">
<ul>
	<li>
	<div class="General_middle_bottom_b_middle_left">名称</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.name }</div>
	</li>
	<li>
	<div class="General_middle_bottom_b_middle_left">地址</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.address }</div>
	</li>
	<li>
	<div class="General_middle_bottom_b_middle_left">城市</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.city }</div>
	</li>
	<li>
	<div class="General_middle_bottom_b_middle_left">省</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.state }</div>
	</li>
	<li>
	<div class="General_middle_bottom_b_middle_left">邮编</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.zipCode }</div>
	</li>
	<li>
	<div class="General_middle_bottom_b_middle_left">国家</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.country }</div>
	</li>
	<li>
	<div class="General_middle_bottom_b_middle_left">电话</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.phoneNumber }</div>
	</li>
	<li>
	<div class="General_middle_bottom_b_middle_left">邮箱</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.email }</div>
	</li>
	<!-- 
	<li>
	<div class="General_middle_bottom_b_middle_left">时区</div>
	<div class="General_middle_bottom_b_middle_right">${datas.plab.timeZone }</div>
	</li>
	 -->
	<li>
	<div class="General_middle_bottom_b_middle_left"><span>状态</span><span
		class="General_middle_bottom_b_middle_a">*</span></div>
	<div class="General_middle_bottom_b_middle_right">
	<select size="1" name="" id="my-Approval-Status">
		<c:if test="${datas.plab.accountStatus==0}">
			<option value="0" selected="selected">审批通过</option>
			<option value="1">已关闭</option>
			<option value="2">待审批</option>
		</c:if>
		<c:if test="${datas.plab.accountStatus==1}">
			<option value="0">审批通过</option>
			<option value="1" selected="selected">已关闭</option>
			<option value="2">待审批</option>
		</c:if>
		<c:if test="${datas.plab.accountStatus==2}">
			<option value="0">审批通过</option>
			<option value="1">已关闭</option>
			<option value="2" selected="selected">待审批</option>
		</c:if>
		<c:if test="${datas.plab.accountStatus!=0 and datas.plab.accountStatus!=1 and datas.plab.accountStatus!=2}">
			<option value="" selected="selected">暂物状态</option>
			<option value="0">审批通过</option>
			<option value="1">已关闭</option>
			<option value="2">待审批</option>
		</c:if>
	</select></div>
	</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
<div class="Addone"><a href="javascript:void(0)" onclick="savePracticeDetails('${datas.plab.id}');">保存</a></div>
</div>
