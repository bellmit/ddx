<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>

<script type="text/javascript">
	$(function() {

		//默认选中 
		$("#filter_by option[value='${method}']").attr("selected", true);
		
		$('#filterBy_tmp').val('${method}');

		var filter = $("#filter_by").change(function() {
			var filter = $(this).val();
			if (filter == 'byMonth' || filter == 'invoices') {

				$('#filter .options').show();
				$('#year').attr('name','year');
				$('#month').attr('name','month');
			} else {
				$('#filter .options').hide();
				$('#year').removeAttr('name');
				$('#month').removeAttr('name');
			}
		}).val();

		if (filter != 'byMonth' && filter != 'invoices') {
			$("#filter .options").hide();
			$('#year').removeAttr('name');
			$('#month').removeAttr('name');
		}
		
		if('${datas.multiFilters.month}'!=''){
			$('#month').val('${datas.multiFilters.month}');			
		}else{
			$('#month').val('<%=ToolsKit.DateUtil.formatDate(new Date(), "M")%>');
		}

		$('#unit_id').change(function() {
			var ut = $("#unit_id").find("option:selected").attr("unitType");
			$('#unitType_tmp').val(ut);
		});
		

	});
</script>

<form id="filter" accept-charset="utf-8" method="get" action="${pageContext.request.contextPath}/labAction/query.do">

	<div class="box_appointment_changecenter01">
		<div class="box_appointment_filter">过滤器</div>
		<div class="box_appointment_filtertop"></div>
		<div class="box_appointment_filtercenter01">
			<div class="box_appointment03">
				<span class="biaoti">通过</span> <select id="filter_by" name="method"
					class="box_date">
					<option value="byMonth">月份</option>
					<option value="toArrive">收货</option>
					<option value="toShip">发货</option>
					<option value="openTryIns">试戴</option>
					<option value="onHold">暂停</option>
					<option value="toOutsource">外包</option>
				</select>
			</div>
		</div>
		<div class="box_appointment_filtercenter01">
			<div class="box_appointment03">
				<span class="biaoti">临床</span> <select id="unit_id" class="box_date"
					name="unitId">
					<option label="All" value="">All</option> ${datas.filterOptions }
				</select>
				<input type="hidden" id="unitType_tmp" name="unitType" value="${multiFilters == null ? datas.multiFilters.unitType : multiFilters.unitType }" />
			</div>
		</div>
		<div class="box_appointment_filterbottom"></div>
		<div class="box_clear"></div>
		<div class="options">
			<div class="box_appointment_filter">选项</div>
			<div class="box_appointment_filtertop"></div>
			<div class="box_appointment_filtercenter">
				<div class="box_appointment03">
					<span class="biaoti">年份</span> <select id="year" name="year" class="box_date01">
						<option
							value="<%=ToolsKit.DateUtil.formatDate(new Date(), "yyyy")%>"><%=ToolsKit.DateUtil.formatDate(new Date(), "yyyy")%></option>
					</select>
					<script type="text/javascript">
						var sel = document.getElementById("year");
						sel.style.width = ((sel.offsetWidth < 70) ? '70'
								: ((sel.offsetWidth > 90) ? '90'
										: sel.offsetWidth));
					</script>
				</div>
				
				<div class="box_appointment03">
					<span class="biaoti">月份</span> <select id="month" name="month"
						class="box_date01">
						<option value="1">一月</option>
						<option value="2">二月</option>
						<option value="3">三月</option>
						<option value="4">四月</option>
						<option value="5">五月</option>
						<option value="6">六月</option>
						<option value="7">七月</option>
						<option value="8">八月</option>
						<option value="9">九月</option>
						<option value="10">十月</option>
						<option value="11">十一月</option>
						<option value="12">十二月</option>
					</select>
				</div>
				
			</div>
			<div class="box_appointment_filterbottom"></div>
		</div>
	</div>
	
</form>