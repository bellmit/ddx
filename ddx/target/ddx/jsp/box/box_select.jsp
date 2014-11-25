<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>

</head>

<script type="text/javascript">
$(function(){
	$("#log_type").click(function(event){
		var e=window.event || event;
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
			e.cancelBubble = true;
		}   
		$("#select-log-view").show();
	});
	$("#select-log-view").click(function(event){
		var e=window.event || event;
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
			e.cancelBubble = true;
		}
	});
	document.onclick = function(){
		$("#select-log-view").hide();
	};
	$("#showOrHide-img").click(function(event){
		var e=window.event || event;
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
			e.cancelBubble = true;
		}   
		var flag = $("#select-log-view").attr("flag");
		if(flag=="hide"){
			$("#select-log-view").show();
			$("#select-log-view").attr("flag","show")
		}else{
			$("#select-log-view").hide();
			$("#select-log-view").attr("flag","hide")
		}
	});
})
</script>
<body>
<div class="box_selectscroll" style="display:none; position:absolute; background-color:#FFFFFF; *margin-top:-3px;" id="select-log-view" flag="hide">
<div class="box_selectscroll01">
<h1>全部</h1>
</div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">全部</span>
	<span class="box_selectscrollspan01">全部更新</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">全部
	- 临床</span> <span class="box_selectscrollspan01">只显示临床</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">全部
	- 技工间</span> <span class="box_selectscrollspan01">只显示技工间</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll01">
<h1>订单创建 </h1>
</div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt01"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">订单
	</span> <span class="box_selectscrollspan01">所有更新</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt01"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">订单创建
	 - 临床</span> <span class="box_selectscrollspan01">只显示临床</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt01"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">订单创建 - 技工间</span> <span class="box_selectscrollspan01">只显示技工间</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll01">
<h1>修改订单</h1>
</div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt02"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">订单修改</span> <span class="box_selectscrollspan01">全部修改</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt02"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">订单修改 - 临床</span> <span class="box_selectscrollspan01">只显示临床</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt02"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">订单修改 - 技工间</span> <span class="box_selectscrollspan01">只显示技工间</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll01">
<h1>账户操作日志</h1>
</div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt03"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">账户操作日志</span> <span class="box_selectscrollspan01">全部记录</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt03"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">账户操作日志 - 临床</span> <span class="box_selectscrollspan01">只显示临床</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll02">
<dl>
	<dt class="box_selectscrolldt03"></dt>
	<dd><a href="#"><span class="box_selectscrollspan">账户操作日志 - 技工间</span> <span class="box_selectscrollspan01">只显示技工间</span> </a></dd>
</dl>
</div>
<div class="box_clear"></div>
<div class="box_selectscroll04">
<h2><a href="#">发票</a></h2>
</div>
<div class="box_selectscroll04">
<h2><a href="#">报表</a></h2>
</div>
<div class="box_selectscroll05">
<h2><a href="#">取件服务</a></h2>
</div>
<div class="box_selectscroll06">
<h2><a href="#">付款</a></h2>
</div>
</div>
</body>
</html>
