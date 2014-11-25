<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script>
function turnoff(obj){
	document.getElementById(obj).style.display="none";
}
</script>
<div class="box_appointment" id="add-user-group-div" style="display: none;background-color: #FFFFFF">
<div class="box_top">
<div class="box_relatedtopleft"></div>
<div class="box_relatedtopcenter"></div>
<div class="box_relatedtopright"></div>
</div>
<div class="box_addcenter">
<!--<div class="box_appointment_biaoti">
<div class="box_changepatient_biaotileft"><img src="${pageContext.request.contextPath}/jsp/box/images/box_leftbg.png" width="12" height="32" /></div>
--><!--<div class="box_changepatient_biaoticenter">
<span class="box_appointment_biaoti_left">添加相关的用户账户</span>
<a href="#" onclick="javascript:turnoff('add-user-group-div')"><span class="box_appointment_biaoti_right"><img src="${pageContext.request.contextPath}/jsp/box/images/box_close.png" width="21" height="20" onmouseover="this.src='${pageContext.request.contextPath}/jsp/box/images/box_close01.png'" onmouseout="this.src='${pageContext.request.contextPath}/jsp/box/images/box_close.png'"/></span></a>
</div>
--><!--<div class="box_procedurepatient_biaotiright"><img src="${pageContext.request.contextPath}/jsp/box/images/box_rightbg.png" width="12" height="32" /></div>
</div>-->
<div class="box_clear"></div>
<div class="box_account">
<div class="box_account_top" align="left">账户验证</div>
<div class="box_account_center">
<!-- 
<div class="box_account_centercontent">你如果有多个UPD账号，你可以使用你自己私人的,也可组织在一起，允许他们相互切换. 与分组账户: </div>
<ul class="box_account_centercontent01">
<li>•你总是用这个作为你的主用户账户登录. 你不能直接登录这个由其他账号添加进组的账号</li>
<li>•您可以访问的任何用户账户的集团用户下拉菜单,选择切换到其他账户.</li>
</ul>
<div class="box_account_centercontent">用户账户添加到你的小组通过输入该用户的凭据。 </div>
 -->

<div class="box_appointment02" align="left"><span class="biaoti_add">角色</span>
<select id="add-user-group-By" class="box_role"  style="width: 201px;">
  <option value ="1">技工间</option>
  <option value ="2">临床</option>
</select></div>
<div class="box_clear"></div>
<div class="box_appointment02" align="left"><span class="biaoti_add">邮箱<span class="biaocolor">*</span></span>
<input id="add-user-group-email" class="box_date" type="text" title="Date" maxlength="" name="Date" style="width: 200px;"/></div>
<div class="box_clear"></div>
<div class="box_appointment02" align="left"><span class="biaoti_add">密码<span class="biaocolor">*</span></span>
<input id="add-user-group-password" class="box_date" type="text" title="Date" maxlength="" name="Date" style="width: 200px;"/></div>
<div class="box_clear"></div>
<!--<div class="box_add"><a href="#"><img src="${pageContext.request.contextPath}/jsp/box/images/box_add.png" width="106" height="26" onmouseover="this.src='${pageContext.request.contextPath}/jsp/box/images/box_addhover.png'" onmouseout="this.src='${pageContext.request.contextPath}/jsp/box/images/box_add.png'" /></a></div>
--></div>
<div class="box_account_bottom"></div>
</div>
<div class="box_clear"></div>
<!--<div class="box_account_line"></div>
--><!--<div class="box_appointment_centerright"><a href="#"><img src="${pageContext.request.contextPath}/jsp/box/images/box_cancel.png" width="86" height="26" onmouseover="this.src='${pageContext.request.contextPath}/jsp/box/images/box_cancel01.png'" onmouseout="this.src='${pageContext.request.contextPath}/jsp/box/images/box_cancel.png'" /></a>
</div>
--></div>
<div class="box_bottom">
<div class="box_relatedbottomleft"></div>
<div class="box_relatedbottomcenter"></div>
<div class="box_relatedbottomright"></div>
</div>
<div id="add-group-user-error-message" style="color: red;"></div>
<div class="box_add" align="center"><a href="javascript:void(0)" onclick="addUserGroup();">+ 提交</a></div>
</div>
