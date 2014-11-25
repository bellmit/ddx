<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form>
	<div class="box_appointment_center01">
		<div class="box_appointment04">
			<span class="biaoti2">交付日期 <span class="biaocolor">*</span> </span><input
				id="delivery_date" readonly="readonly" class="box_date" type="text"
				title="delivery_date" maxlength="" name="delivery_date"> <span
				class="box_button"> <img
				src="${pageContext.request.contextPath}/jsp/box/images/box_time.png"
				width="37" height="26"
				onclick="WdatePicker({el:'delivery_date',minDate:'%y-%M-%d'})" />
			</span>
		</div>
		<div class="box_appointment04" style="display: none;"
			id="delivery_date_info">
			<span class="biaoti2"></span><span class="u_lab_case_field_cuowu_a">请选择交付日期</span>
		</div>
		<div class="box_appointment04">
			<span class="biaoti2">工序<span class="biaocolor">*</span>
			</span> <select name="select-procedure-name" size="1" id="add-pro-id-select"
				onchange="loadProcedure('0',this.value,'false')" class="box_date">
				<option value="">--请选择工序--</option> ${proOption }
			</select>
		</div>
		<div class="box_appointment04">
			<div name="procedure-div" id="reschedule-procedure-div">
				<div id="attributes-0"></div>
			</div>
		</div>
		<div class="box_appointment04" style="display: none;"
			id="select_procedure_info">
			<span class="biaoti2"></span><span class="u_lab_case_field_cuowu_a">请选择工序</span>
		</div>
	</div>
</form>
