<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="Cases_bottom_right_a">条款和条件</div>
<div class="Addonecuowu_c" style="display:none;" id="terms_error">您提交的表单有错误，请查看一下详情</div>
<div class="Personalize">
<div class="Personalize_a">Rx 条款</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form method="get" action="" name="myform">
<ul>
<li>
<div class="Personalize_b_middle_left">有效的条款和条件</div>
<c:choose>
		<c:when test="${datas.valid==true}">
<div class="Personalize_b_middle_right"><input type="checkbox" checked="checked" value="" id="Ischecked" name="mybox" onclick="deleteTerms()"></div>
</c:when>
<c:otherwise>
			<input type="checkbox" value="" name="" id="Ischecked" onclick="deleteTerms()">
</c:otherwise>
</c:choose>
</li>
<c:choose>
		<c:when test="${datas.valid==false}">
<li><textarea rows="" cols="" name="" id="terms_content" disabled="disabled">${datas.terms}</textarea></li>
</c:when>
<c:otherwise>
			<li><textarea rows="" cols="" name="" id="terms_content" >${datas.terms}</textarea></li>
</c:otherwise>
</c:choose>
<div class="Personalize_b_middle_right"><input type="hidden" id="lab_terms_id"  value="${datas.id }"></div>
<div class="Personalize_b_middle_right"><input type="hidden" id="lab_terms_labid" value="${datas.labid }"></div>
</ul>
<li>
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right" style="display:none;" id="terms_message"><i class="Addonecuowu_b">给这个订单添加额外的信息</i></div>
</li>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Addone"><a href="javascript:void(0)" onclick="saveTerms()">保存</a></div>
</div>