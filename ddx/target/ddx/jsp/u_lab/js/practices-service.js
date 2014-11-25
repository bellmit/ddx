function overrideTransitTime(){
	var isOverRide = $("#isOverrideTransitTime").attr('checked')!=undefined?"true":"false";
	if(isOverRide=='true'){
		$("#Inbound_Transit_Days").show();
		$("#Outbound_Transit_Days").show();
	}else{
		$("#Inbound_Transit_Days").hide();
		$("#Outbound_Transit_Days").hide();
	}
}

function settingNumber(id,type){
	var obj = $("#"+id);
	if('plus'==type){
		var val = obj.val();
		obj.val(parseInt(val)+1);
	}else if('minus'==type){
		var val = obj.val();
		if(val-1>=0){
			obj.val(val-1);
		}
	}
}

function saveNotes(id,type,unitId){
	var externalId = $("#externalId").val();
	var notes = $("#notes").val();

	var params = {
			id:id,
			externalId:externalId,
			notes:notes,
			type:type,
			unitId:unitId
		}
	$$ajax( {
		url : "labAction/setting/saveNotes.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			try{
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert(JSON.info);
					query('practiceNotes',unitId,type);
				}
			}catch(e){
				alert("请重新登录");
			}
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});

}

function savePracticeDetails(id){
	var params = {id:id,status:$("#my-Approval-Status").val()}
	$$ajax( {
		url : "labAction/setting/updatePracticeServiceDetails.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			try{
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert(JSON.info);
				}
			}catch(e){
				alert("请重新登录");
			}
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function saveLabPracticePreferences(id,unitId,unitType){
	var shipping = $("#practice-service-shipping").val();
	var isOverrideTransitTime = $("#isOverrideTransitTime").attr('checked')!=undefined?"true":"false";
	var Inbound_Transit_Days_value = parseInt($("#Inbound_Transit_Days_value").val());
	var Outbound_Transit_Days_value = parseInt($("#Outbound_Transit_Days_value").val());
	var labPriceGroup = $("#practice-service-labPriceGroup").val();
	var labProceduresGroup = $("#practice-service-labProceduresGroup").val();
	var isOk = true;
	if(isOverrideTransitTime=='true'){
		if(Inbound_Transit_Days_value>=0){
			$("#Inbound_Transit_Days_value-title").hide();
			$("#Inbound_Transit_Days_value").attr("style","border-color: #cbcbcb");
		}else{
			isOk = false;
			$("#Inbound_Transit_Days_value").attr("style","border-color: red");
			$("#Inbound_Transit_Days_value-title").show();
		}
		if(Outbound_Transit_Days_value>=0){
			$("#Outbound_Transit_Days_value-title").hide();
			$("#Outbound_Transit_Days_value").attr("style","border-color: #cbcbcb");
		}else{
			isOk = false;
			$("#Outbound_Transit_Days_value").attr("style","border-color: red");
			$("#Outbound_Transit_Days_value-title").show();
		}
	}
	if(labPriceGroup==null || labPriceGroup.trim()==''){
		isOk = false;
		$("#practice-service-labPriceGroup").attr("style","border-color: red");
		$("#practice-service-labPriceGroup-ps").show();
	}else{
		$("#practice-service-labPriceGroup").attr("style","border-color: cbcbcb");
		$("#practice-service-labPriceGroup-ps").hide();
	}
	if(shipping==null || shipping.trim()==''){
		isOk = false;
		$("#practice-service-shipping").attr("style","border-color: red");
		$("#practice-service-shipping-ps").show();
	}else{
		$("#practice-service-shipping").attr("style","border-color: cbcbcb");
		$("#practice-service-shipping-ps").hide();
	}
	
	if(isOk){
		var params = {
				id:id,
				unitId:unitId,
				unitType:unitType,
				shippingId:shipping,
				overrideTransitTime:isOverrideTransitTime,
				inboundTransitDays:Inbound_Transit_Days_value,
				outboundTransitDays:Outbound_Transit_Days_value,
				priceGroupId:labPriceGroup,
				proceduresGroupId:labProceduresGroup
		}
		$$ajax( {
			url : "labAction/setting/updatePracticeServicePreferences.do",
			data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				try{
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert(JSON.failReasons);
					} else {
						alert(JSON.info);
						query('practicePreferences',unitId,unitType);
					}
				}catch(e){
					alert("请重新登录");
				}
			},
			error : function(e) {
				alertError(e);
			},
			complete : function(msg) {
				$("#data-loading-div").hide();
			}
		});
	}
}
function changeShippingGroup(){
	var shipping = $("#practices-shipping-select").val();
	if(shipping==undefined || shipping.trim()==''){
		$("#no-select-shipping-error").show();
	}else{
		$("#no-select-shipping-error").hide();
	}
	$("#assign-shipping-unit tr").each(function (i){
		var a = $(this);
		for(var i=0;i<a.length;i++){
			var tr_id = $(a.eq(i)).attr("id");
			var shippingId = $("#"+tr_id+"-checkbox").val();
			if(shipping==undefined || shipping.trim()==''){
				$("#"+tr_id+"-checkbox").attr("checked",false);
				$("#"+tr_id+"-shippingName").show();
			}else{
				if(shipping==shippingId){
					$("#"+tr_id+"-checkbox").attr("checked",true);
					$("#"+tr_id+"-shippingName").hide();
				}else{
					$("#"+tr_id+"-checkbox").attr("checked",false);
					$("#"+tr_id+"-shippingName").show();
				}
			}
		}
	});
}
function saveChangeShippingGroup(){
	var unitId = "";
	var shippingId = $("#practices-shipping-select").val();
	if(shippingId==undefined || shippingId.trim()==''){
		$("#no-select-shipping-error").show();
	}else{
		$("#no-select-shipping-error").hide();
		$("#assign-shipping-unit tr").each(function (i){
			var a = $(this);
			for(var i=0;i<a.length;i++){
				//array = array + a.eq(i).text().trim()+",";
				var tr_id = $(a.eq(i)).attr("id");
				var isChecked = $("#"+tr_id+"-checkbox").attr('checked')!=undefined?"true":"false";
				if(isChecked=="true"){
					unitId+=tr_id+","+$("#"+tr_id).attr("type")+";";
				}
			}
		});
	}
	if(unitId!=""){
		var parma = {unitId:unitId,shippingId:shippingId};
		$$ajax( {
			url : "labAction/setting/batchUpdateShipping.do",
			data : parma,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				try{
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert(JSON.failReasons);
					} else {
						alert("修改成功");
						Assign('assignShippingServices.do');
					}
				}catch(e){
					alert("请重新登录");
				}
			},
			error : function(e) {
				alertError(e);
			},
			complete : function(msg) {
				$("#data-loading-div").hide();
			}
		});
	}
}

function changePracticesGroup(){
	var group = $("#practices-group-select").val();
	if(group==undefined || group.trim()==''){
		$("#no-select-group-error").show();
	}else{
		$("#no-select-group-error").hide();
	}
	$("#assign-price-unit tr").each(function (i){
		var a = $(this);
		for(var i=0;i<a.length;i++){
			var tr_id = $(a.eq(i)).attr("id");
			var grupId = $("#"+tr_id+"-checkbox").val();
			if(group==undefined || group.trim()==''){
				$("#"+tr_id+"-checkbox").attr("checked",false);
				$("#"+tr_id+"-groupName").show();
			}else{
				if(group==grupId){
					$("#"+tr_id+"-checkbox").attr("checked",true);
					$("#"+tr_id+"-groupName").hide();
				}else{
					$("#"+tr_id+"-checkbox").attr("checked",false);
					$("#"+tr_id+"-groupName").show();
				}
			}
		}
	});
	
}
function saveChangePracticesGroup(){
	var unitId = "";
	var group = $("#practices-group-select").val();
	if(group==undefined || group.trim()==''){
		$("#no-select-group-error").show();
	}else{
		$("#no-select-group-error").hide();
		$("#assign-price-unit tr").each(function (i){
			var a = $(this);
			for(var i=0;i<a.length;i++){
				//array = array + a.eq(i).text().trim()+",";
				var tr_id = $(a.eq(i)).attr("id");
				var isChecked = $("#"+tr_id+"-checkbox").attr('checked')!=undefined?"true":"false";
				if(isChecked=="true"){
					unitId+=tr_id+","+$("#"+tr_id).attr("type")+";";
				}
			}
		});
	}
	if(unitId!=""){
		var parma = {unitId:unitId,groupId:group};
		$$ajax( {
			url : "labAction/setting/batchUpdatePriceGroup.do",
			data : parma,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				try{
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert(JSON.failReasons);
					} else {
						alert("修改成功");
						Assign('assignPriceListGroups.do');
					}
				}catch(e){
					alert("请重新登录");
				}
			},
			error : function(e) {
				alertError(e);
			},
			complete : function(msg) {
				$("#data-loading-div").hide();
			}
		});
	}
}
function Assign(action){
	$$ajax( {
		url : "labAction/setting/"+action,
		data : null,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#show-Cooperation-Practices-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});

}
function ExportToExcel(){
	
}