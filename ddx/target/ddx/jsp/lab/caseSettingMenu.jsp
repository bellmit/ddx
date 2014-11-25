<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" language="javascript">
$(".LabCaseSetting_a li ").click(function(){
	$(".LabCaseSetting_a li a").css({"backgroundColor":"none","color":"#000"});
		$("a",this).css({"backgroundColor":"none","color":"#1591f9"});
	});
	
$(".LabCaseSetting_b li ").live("click",function(){
	$(".LabCaseSetting_b li a").css({"backgroundColor":"none","font-weight":"","color":"#000"});
		$("a",this).css({"backgroundColor":"none","font-weight":"bold" ,"color":"#1591f9"});
	});
</script>
<div id="case-setting-menu-General" style="display: none;">
	<ul >
	<li ><a href="javascript:void(0)" onclick="query('schedulingAndHolidays');" title="设置上下班时间">时间设定</a></li>
	<li><a href="javascript:void(0)" onclick="query('remakeTypes');">返工类型</a></li>
	<li><a href="javascript:void(0)" onclick="query('shippingTypes');">物流方案</a></li>
	<li><a href="javascript:void(0)" onclick="query('onHoldTypes');">搁置类型</a></li>
	<li><a href="javascript:void(0)" onclick="query('terms');">处方条款</a></li>
	</ul>
</div>
<div id="case-setting-menu-Procedures" style="display: none;">
	<ul>
		<li><a href="javascript:void(0)" onclick="query('labProcedures');">工序设置</a></li>
		<li><a href="javascript:void(0)" onclick="query('displayCategories');">工序列表</a></li>
	</ul>
</div>
<div id="case-setting-menu-Procedure_Characteristics" style="display: none;">
	<ul>
	<li><a href="javascript:void(0)" onclick="query('materials');">工序材料</a></li>
	<li><a href="javascript:void(0)" onclick="query('enclosures');">随单附件</a></li>
	<li><a href="javascript:void(0)" onclick="query('acrylicColors');">朔胶袋</a></li>
	<li><a href="javascript:void(0)" onclick="query('sportGuardColors');">包装盒</a></li>
	<li><a href="javascript:void(0)" onclick="query('orthodonticColors');">矫治器</a></li>
	<li><a href="javascript:void(0)" onclick="query('orthodonticDesigns');">矫治器设计</a></li>
	<li><a href="javascript:void(0)" onclick="query('implantSystems');">种植系统</a></li>
	<li><a href="javascript:void(0)" onclick="query('implantMarkers');">种植导板</a></li>
	</ul>
</div>
<div id="case-setting-menu-Coupons" style="display: none;">
	<ul>
		<li><a href="javascript:void(0)" onclick="query('ddxCoupons');">优惠劵</a></li>
	</ul>
</div>

   
