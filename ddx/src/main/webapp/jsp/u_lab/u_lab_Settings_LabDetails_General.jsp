<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<script type="text/javascript">
	$(function(){
		$('#state').attr('value','${myLab.state}')
	});
</script>

<div class="General_middle_bottom_a">详细联系方式</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left">技工间编号</div>
<div class="General_middle_bottom_b_middle_right">${myLab.id }
<input type="hidden" id="labId" value="${myLab.id }" />
</div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left"><span>技工间名称</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right"><input class="General_middle_bottom_b_middle_b" id="labName" value="${myLab.name }" type="text"></div>
</li>
<li style="display: none;" id="labName_info">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入技工间名称</i></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left"><span>地址</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right"><input name="" class="General_middle_bottom_b_middle_b" id="address" value="${myLab.address }" type="text"></div>
</li>
<li style="display: none;" id="address_info">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入地址</i></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">地址2</div>
<div class="General_middle_bottom_b_middle_right"><input name="" class="General_middle_bottom_b_middle_b" id="address2" value="${myLab.address2 }" type="text"></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left"><span>国家</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right">
<select name="" size="1" id="country">
  <option value="中国">中国</option>
</select>
</div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left"><span>省份</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right">
<select name="" size="1" id="state">
  <jsp:include page="../state.jsp"></jsp:include>
</select>
</div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left"><span>城市</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="city" class="General_middle_bottom_b_middle_b" value="${myLab.city }" type="text"></div>
</li>
<li style="display: none;" id="city_info">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入城市</i></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left"><span>邮编</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="zipCode" class="General_middle_bottom_b_middle_b" value="${myLab.zipCode }" type="text" maxlength="6"></div>
</li>
<li style="display: none;" id="zipCode_info">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入邮编</i></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left"><span>电话</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="phoneNumber" class="General_middle_bottom_b_middle_b" value="${myLab.phoneNumber }" type="text" maxlength="11"></div>
</li>
<li style="display: none;" id="phoneNumber_info">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入电话</i></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">传真</div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="fax" class="General_middle_bottom_b_middle_b" type="text" value="${myLab.fax }" maxlength="20"></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">邮箱</div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="email" class="General_middle_bottom_b_middle_b" value="${myLab.email }" type="text"></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">网址</div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="website" class="General_middle_bottom_b_middle_b" type="text" value="${myLab.website }"></div>
</li>
<!-- 
<li>
<div class="General_middle_bottom_b_middle_left"><span>时区</span><span class="General_middle_bottom_b_middle_a">*</span></div>
<div class="General_middle_bottom_b_middle_right"><select name="" size="1">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select></div>
</li>
 -->
<li>
<div class="General_middle_bottom_b_middle_left">授权号</div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="licenseNumber" class="General_middle_bottom_b_middle_b" type="text" value="${myLab.licenseNumber }"></div>
</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_anniu"><a href="javascript:void(0)" onclick="saveGeneral();">提交</a></div>
