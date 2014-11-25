<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="Cases_bottom_right_a">添加工序材料</div>
<div class="Personalize">
<div class="Personalize_a">详情</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="Personalize_b_middle_left"><span>名称</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
	<input type="hidden" id="id" value="${datas.material.id }"/>
	<input name="" id="name" value="${datas.material.characterName }" maxlength="30" type="text" class="Personalize_b_middle_b"/>
</div>
</li>
<li style="display: none;" id="name_info">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入名称</i></div>
</li>
<li>
<div class="Personalize_b_middle_left"><span>分类</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
<select name="classfication" id="classfication" size="1">
  <option value="High Noble" <c:if test="${datas.material.classfication == 'High Noble' }">selected="selected"</c:if> >高惰性金属</option>
  <option value="Nobel" <c:if test="${datas.material.classfication == 'Nobel' }">selected="selected"</c:if> >惰性金属</option>
  <option value="Base" <c:if test="${datas.material.classfication == 'Base' }">selected="selected"</c:if> >盐基</option>
  <option value="Titanium" <c:if test="${datas.material.classfication == 'Titanium' }">selected="selected"</c:if> >钛</option>
  <option value="Alumina Ceramic" <c:if test="${datas.material.classfication == 'Alumina Ceramic' }">selected="selected"</c:if> >氧化铝陶瓷</option>
  <option value="Yitrim Zirconia" <c:if test="${datas.material.classfication == 'Yitrim Zirconia' }">selected="selected"</c:if> >氧化锆</option>
</select>
</div>
</li>
<li>
<div class="Personalize_b_middle_left">默认价格</div>
<div class="Personalize_b_middle_right"><span><input name="defaultPrice" id="defaultPrice" maxlength="10" value="${datas.material.defaultPrice }" type="text" class="Personalize_b_middle_b"/></span><span>/ g</span></div>
</li>
<li style="display: none;" id="defaultPrice_info">
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right" ><i class="Addonecuowu_b">请输入正确的价格</i></div>
</li>
<li>
<div class="Personalize_b_middle_left">是否应纳税</div>
<div class="Personalize_b_middle_right"><input name="taxable" id="taxable" type="checkbox" <c:if test="${datas.material.taxable == 1 }">checked="true"</c:if> value="" /></div>
</li>
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Personalize_a">成分</div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="LabCaseSettingCoupons_b"><a href="javascript:void(0)" onclick="appendRow();">增加</a></div>
<div style="display: none;" >
<ol id="cp_ol">
	<li class="Personalize_b_middle_right">
	<select name="element" id="element" size="1">
		<option value="">选择元素</option>
		<option value="Gold">金</option>
		<option value="Palladium">钯</option>
		<option value="Platinum">铂</option>
		<option value="Titanium">钛</option>
		<option value="Cobalt">钴</option>
		<option value="Yttrium Zirconia">氧化锆</option>
		<option value="Rhodium">铑</option>
		<option value="Indium">铟</option>
		<option value="Osmium">锇</option>
		<option value="Ruthenium">钌</option>
	</select>
	</li>
	<li class="Personalize_b_middle_right">
	<div class="Scan_b_middle_right_left_b_top">
	<div class="Scan_b_middle_right_left_b_top_left"><input name="percentage" id="percentage" value="0" type="text"  autocomplete="off" min="0" max="100"/></div>
	<div class="Scan_b_middle_right_left_b_top_right">
	<div class="Scan_b_middle_right_left_b_top_right_top"><a name="add_a" href="javascript:void(0)" onclick="add();"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/Scan_03.jpg"/></a></div>
	<div class="Scan_b_middle_right_left_b_top_right_bottom"><a name="minus_a" href="javascript:void(0)" onclick="minus();" ><img src="${pageContext.request.contextPath }/jsp/u_lab/images/scan_06.jpg"/></a></div>
	</div>
	</div>
	</li>
	<li>%</li>
	<li class="General_SchedulingHolidays_middle_right">
	<a href="javascript:void(0)" onclick="delRow(this);"></a>
	</li>
</ol>
</div>
<div class="Materials_Edit">
<c:forEach items="${datas.compostionPm.datas }" var="composition" varStatus="status">
	<ol id="cp_ol_" + '${status.index }'>
	<li class="Personalize_b_middle_right">
	<select name="element" id="element" size="1">
		<option value="">Select Element</option>
		<option <c:if test="${composition.element == 'Gold' }">selected="selected"</c:if> value="Gold">Gold</option>
		<option <c:if test="${composition.element == 'Palladium' }">selected="selected"</c:if> value="Palladium">Palladium</option>
		<option <c:if test="${composition.element == 'Platinum' }">selected="selected"</c:if> value="Platinum">Platinum</option>
		<option <c:if test="${composition.element == 'Titanium' }">selected="selected"</c:if> value="Titanium">Titanium</option>
		<option <c:if test="${composition.element == 'Cobalt' }">selected="selected"</c:if> value="Cobalt">Cobalt</option>
		<option <c:if test="${composition.element == 'Yttrium Zirconia' }">selected="selected"</c:if> value="Yttrium Zirconia">Yttrium Zirconia</option>
		<option <c:if test="${composition.element == 'Rhodium' }">selected="selected"</c:if> value="Rhodium">Rhodium</option>
		<option <c:if test="${composition.element == 'Indium' }">selected="selected"</c:if> value="Indium">Indium</option>
		<option <c:if test="${composition.element == 'Osmium' }">selected="selected"</c:if> value="Osmium">Osmium</option>
		<option <c:if test="${composition.element == 'Ruthenium' }">selected="selected"</c:if> value="Ruthenium">Ruthenium</option>
	</select>
	</li>
	<li class="Personalize_b_middle_right">
	<div class="Scan_b_middle_right_left_b_top">
	<div class="Scan_b_middle_right_left_b_top_left"><input name="percentage" id="percentage_${status.index }" value="${composition.percentage }" onkeyup="limitPercentage(${status.index})" type="text" max="100" min="0" /></div>
	<div class="Scan_b_middle_right_left_b_top_right">
	<div class="Scan_b_middle_right_left_b_top_right_top"><a name="add_a" href="javascript:void(0)" onclick="add(${status.index})"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/Scan_03.jpg"/></a></div>
	<div class="Scan_b_middle_right_left_b_top_right_bottom"><a name="minus_a" href="javascript:void(0)" onclick="minus(${status.index})"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/scan_06.jpg"/></a></div>
	</div>
	</div>
	</li>
	<li>%</li>
	<li class="General_SchedulingHolidays_middle_right">
	<a href="javascript:void(0)" onclick="delRow(this)"></a>
	</li>
	</ol>
</c:forEach>
</div>
</li>
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
<div class="Addone"><a href="javascript:void(0)" id="save_material_fun">提交</a></div>
</div>

<script type="text/javascript">
//添加行 
var num = parseInt('${datas.compostionPm.total}');
var ol_num = isNaN(num) ? 0 :num ;
function appendRow(){
    var ol = $("#cp_ol").clone(true);//克隆一行
    ol.attr("id","cp_ol_"+ol_num);
    ol.find("input[name='percentage']").attr("id","percentage_"+ol_num);
    ol.find("a[name='add_a']").attr("onclick","add("+ol_num+")");
    ol.find("a[name='minus_a']").attr("onclick","minus("+ol_num+")");
    ol.find("input[name='percentage']").attr("onkeyup","limitPercentage("+ol_num+")");
    if(ol_num == 0){
    	$('.Materials_Edit').html(ol);
    }else{
    	ol.insertAfter(".Materials_Edit ol:last");
    }
    ol_num ++;
}  
//删除相对应的行  
function delRow(rows){
	if(ol_num > 0){
		$(rows).parent("li").parent("ol").remove();
	    ol_num --;
	}
}
</script>
