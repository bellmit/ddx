<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){
		$('#rxProcedureSort').attr('value','${labPre.rxProcedureSort}'=='1'?'Rank':'Alpha-numeric');
		$('#prefCasesMass').attr('value','${labPre.prefCasesMass}');
		$('#currency').attr('value','${labPre.currency}');
	});
</script>
<div class="General_middle_bottom_a">订单偏好设置</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left">Rx分类流程</div>
<div class="General_middle_bottom_b_middle_right">
<input type="hidden" id="id" value="${labPre.id }" />
<select name="" size="1" id="rxProcedureSort">
  <option value="Alpha-numeric">字母数字</option>
  <option value="Rank">等级</option>
</select>
</div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">可用的优惠劵</div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="enableCoupons"  <c:if test="${labPre.enableCoupons == '0' }">checked="true"</c:if> type="checkbox"></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">Pan数量</div>
<div class="General_middle_bottom_b_middle_right"><select name="" size="1" id="panNumbers">
  <option value="PRENUMBERED" <c:if test="${labPre.panNumbers == '1' }">selected="true"</c:if> >预先编号</option>
  <option value="SAME_AS_CASE" <c:if test="${labPre.panNumbers == '2' }">selected="true"</c:if> >相同订单</option>
</select></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">合金含量</div>
<div class="General_middle_bottom_b_middle_right"><select name="" size="1" id="prefCasesMass">
  <option value="gram">克</option>
  <option value="pennyweight">英国重量单位</option>
  <option value="grain">粮食</option>
</select></div>
</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_middle_bottom_a">财务</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left">货币</div>
<div class="General_middle_bottom_b_middle_right"><select name="" size="1" id="currency">
  <option value="CNY" >人民币</option>
  <option value="US_DOLLAR">美元</option>
</select></div>
</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_middle_bottom_a">付款处理配置</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left">店铺代码</div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="storeId" value="${labPre.storeId }" maxlength="20" class="General_middle_bottom_b_middle_b" type="text"></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">权限代码</div>
<div class="General_middle_bottom_b_middle_right"><input name="" id="apiToken" value="${labPre.apiToken }" maxlength="20" class="General_middle_bottom_b_middle_b" type="text"></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">特征</div>
<div class="General_middle_bottom_b_middle_right">
<dl>
<dt><span><input name="" id="visa" <c:if test="${features.visa == 'true' }">checked="checked"</c:if>  type="checkbox"></span><span>VISA</span></dt>
<dt><span><input name="" id="masterCard" <c:if test="${features.masterCard == 'true' }">checked="checked"</c:if> type="checkbox"></span><span>信用卡</span></dt>
<dt><span><input name="" id="americanExpress" <c:if test="${features.americanExpress == 'true' }">checked="checked"</c:if> type="checkbox"></span><span>美国运通</span></dt>
<dt><span><input name="" id="discover" <c:if test="${features.discover == 'true' }">checked="checked"</c:if> type="checkbox"></span><span>发现</span></dt>
<dt><span><input name="" id="onlineChecks" <c:if test="${features.onlineChecks == 'true' }">checked="checked"</c:if> type="checkbox"></span><span>在线检查</span></dt>
<dt><span><input name="" id="addressVerification" <c:if test="${features.addressVerification == 'true' }">checked="checked"</c:if> type="checkbox"></span><span>邮箱地址认证</span></dt>
<dt><span><input name="" id="cvdChecks" <c:if test="${features.cvdChecks == 'true' }">checked="checked"</c:if> type="checkbox"></span><span>心血管疾病检查</span></dt>
</dl>
</div>
</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_anniu"><a href="javascript:void(0)" onclick="savePreferences();">提交</a></div>

