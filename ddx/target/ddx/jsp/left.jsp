<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" language="javascript">
$(".Cases_bottom_left li ").click(function(){
	$(".Cases_bottom_left li a").css({"backgroundColor":"none","color":"#000"});
		$("a",this).css({"backgroundColor":"none","color":"#1591f9"});
	});
</script>
<div class="Cases_bottom_left">
<ul>
<li><a href="${pageContext.request.contextPath}/labAction/setting/details.do">机构详情</a></li>
<li><a href="${pageContext.request.contextPath}/labAction/setting/users.do">用户信息</a></li>
<li><a href="${pageContext.request.contextPath}/labAction/setting/practices.do">关联机构</a></li>
<li><a href="${pageContext.request.contextPath}/labAction/setting/caseSetting.do">订单设置</a></li>
<li><a href="${pageContext.request.contextPath}/labAction/setting/website.do">UPD网站</a></li>
</ul>
</div>
