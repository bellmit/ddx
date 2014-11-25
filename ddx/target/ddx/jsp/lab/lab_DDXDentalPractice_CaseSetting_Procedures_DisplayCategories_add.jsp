<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div id="edit-Display-Category-div"
	style="display: none; background-color: #FFFFFF">
<div class="Cases_bottom_right_a" style="display: none;">创建显示类别</div>
<div class="Addonecuowu_c" style="display: none;">您提交的表单有误，请看下面详细信息</div>
<div class="Personalize">
<div class="Personalize_a">详细信息</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form method="get" action="">
<ul>
	<li>
	<div class="Personalize_b_middle_left"><span>名称</span><span
		class="Personalize_b_middle_a">*</span></div>
	<div class="Personalize_b_middle_right"><input type="text"
		class="Personalize_b_middle_b" name="" id="add-Category-name"/>
		<input type="hidden" name="" id="add-Category-id" value=""/>
		</div>
	</li>
	<li>
	<div class="Personalize_b_middle_left">&nbsp;</div>
	<div class="Personalize_b_middle_right" style="display: none;" id="name-null-ps-message"><i class="Addonecuowu_b">必须输入类名</i></div>
	</li>
	<li>
	<div class="Personalize_b_middle_left"><span>排序</span><span
		class="Personalize_b_middle_a">*</span></div>
	<div class="Personalize_b_middle_right">
	<div class="Scan_b_middle_right_left_b_top">
	<div class="Scan_b_middle_right_left_b_top_left"><input
		type="text" name="" id="add-Category-sort"></div>
	<div class="Scan_b_middle_right_left_b_top_right">
	<div class="Scan_b_middle_right_left_b_top_right_top"><a href="javascript:void(0)" onclick="settingNumber('add-Category-sort','plus');"><img
		src="${pageContext.request.contextPath}/jsp//u_lab/images/Scan_03.jpg"></a></div>
	<div class="Scan_b_middle_right_left_b_top_right_bottom"><a
		href="javascript:void(0)" onclick="settingNumber('add-Category-sort','minus');"><img
		src="${pageContext.request.contextPath}/jsp//u_lab/images/scan_06.jpg"></a></div>
	</div>
	</div>
	</div>
	</li>
	<li>
	<div class="Personalize_b_middle_left">&nbsp;</div>
	<div class="Personalize_b_middle_right" style="display: none;" id="sort-null-ps-message"><i class="Addonecuowu_b">必须输入数字</i></div>
	</li>
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Addone"><a href="javascript:void(0)" id="dit-Display-Category-function">保存</a></div>
</div>
</div>