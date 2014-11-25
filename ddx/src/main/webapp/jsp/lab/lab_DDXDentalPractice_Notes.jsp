<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="General_middle_bottom_a">备注</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">
<form method="get" action="">
<ul>
<li>
<div class="General_middle_bottom_b_middle_left">外部ID</div>
<div class="General_middle_bottom_b_middle_right"><input type="text" class="Personalize_b_middle_b" name="" id="externalId" value="${datas.notes.externalId }"/></div>
</li>
<li>
<div class="General_middle_bottom_b_middle_left">备注</div>
<div class="General_middle_bottom_b_middle_right"><span class="Widgets_a"><textarea rows="" cols="" id="notes" name="">${datas.notes.notes }</textarea></span></div>
</li>
</ul>
</form>
</div>
<div class="General_middle_bottom_b_bottom"></div>
<div class="Addone"><a href="javascript:void(0)" onclick="saveNotes('${datas.notes.id }','${datas.type }','${datas.unitId }')">保存</a></div>
</div>
