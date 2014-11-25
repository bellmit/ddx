function loadLabDetailsInfo(url){
	$$ajax( {
		url : url,
		data : null,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#my-lab-details-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function savePermissions(){
	var cases = {
			newCase:$("#lab-details-permissions-newCase").attr('checked')!=undefined?"true":"false",
			caseEnclosures:$("#lab-details-permissions-caseEnclosures").attr('checked')!=undefined?"true":"false",
			cancelCase:$("#lab-details-permissions-cancelCase").attr('checked')!=undefined?"true":"false",
			listCasesArrivingToday:$("#lab-details-permissions-listCasesArrivingToday").attr('checked')!=undefined?"true":"false",
			listCases:$("#lab-details-permissions-listCases").attr('checked')!=undefined?"true":"false",
			pickup:$("#lab-details-permissions-pickup").attr('checked')!=undefined?"true":"false",
			disabledNotesOnReceived:$("#lab-details-permissions-disabledNotesOnReceived").attr('checked')!=undefined?"true":"false",
			caseNotes:$("#lab-details-permissions-caseNotes").attr('checked')!=undefined?"true":"false",
			attachCaseFiles:$("#lab-details-permissions-attachCaseFiles").attr('checked')!=undefined?"true":"false"
	}
	
	var finances = {
			accountPayment:$("#lab-details-permissions-accountPayment").attr('checked')!=undefined?"true":"false",
			priceList:$("#lab-details-permissions-priceList").attr('checked')!=undefined?"true":"false"
	}
	
	var params = {
			cases:JSON.stringify(cases),
			finances:JSON.stringify(finances)
	}
	$$ajax( {
		url : "labAction/setting/updatePermissions.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				alert(JSON.failReasons);
			} else {
				alert("修改成功");
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

/**
 * 验证技工间字段
 */
function verifyGeneral(){
	//页面取值
	var id = $("#labId").val();
	var name = $("#labName").val();
	var address = $("#address").val();
	var address2 = $("#address2").val();
	var country = $('#country').val();
	var state = $('#state').val();
	var city = $("#city").val();
	var zipCode = $("#zipCode").val();
	var phoneNumber = $("#phoneNumber").val();
	var fax = $("#fax").val();
	var email = $("#email").val();
	var website = $("#website").val();
	var licenseNumber = $("#licenseNumber").val();
	
	
	var isTrue = true;
	
	//单个元素错误提示
	if (name== undefined || name.trim() == '') {
		$("#labName_info").show();
		$("#labName").attr('class','Addonecuowu');
		return;
	}else{
		$("#labName_info").hide();
		$("#labName").attr('class','General_middle_bottom_b_middle_b');
	}
	if (address== undefined || address.trim() == '') {
		$("#address_info").show();
		$("#address").attr('class','Addonecuowu');
		return;
	}else{
		$("#address_info").hide();
		$("#address").attr('class','General_middle_bottom_b_middle_b');
	}
	if (city== undefined || city.trim() == '') {
		$("#city_info").show();
		$("#city").attr('class','Addonecuowu');
		return;
	}else{
		$("#city_info").hide();
		$("#city").attr('class','General_middle_bottom_b_middle_b');
	}
	if (zipCode== undefined || zipCode.trim() == '') {
		$("#zipCode_info").show();
		$("#zipCode").attr('class','Addonecuowu');
		return;
	}else{
		$("#zipCode_info").hide();
		$("#zipCode").attr('class','General_middle_bottom_b_middle_b');
	}
	if (phoneNumber== undefined || phoneNumber.trim() == '') {
		$("#phoneNumber_info").show();
		$("#phoneNumber").attr('class','Addonecuowu');
		return;
	}else{
		$("#phoneNumber_info").hide();
		$("#phoneNumber").attr('class','General_middle_bottom_b_middle_b');
	}
	
	if(isTrue){
		//封装待提交参数
		var params = {
				id:id,
				name:name,
				address:address,
				address2:address2,
				country:country,
				state:state,
				city:city,
				zipCode:zipCode,
				phoneNumber:phoneNumber,
				fax:fax,
				email:email,
				website:website,
				licenseNumber:licenseNumber
		};
		return params;
	}
	return isTrue;
}

/**
 * 修改通用设置
 */
function saveGeneral(){
	var result = verifyGeneral();
	if(result!=false && result != undefined){
		$$ajax( {
			url : "labAction/setting/updateGeneral.do",
			data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert("修改成功");
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

/**
 * 修改首要设置
 */
function savePreferences(){
	
	var features = {
			visa:$("#visa").attr('checked') != undefined ? "true":"false",
			masterCard:$("#masterCard").attr('checked') != undefined ? "true":"false",
			americanExpress:$("#americanExpress").attr('checked') != undefined ? "true":"false",
			discover:$("#discover").attr('checked') != undefined ? "true":"false",
			onlineChecks:$("#onlineChecks").attr('checked') != undefined ? "true":"false",
			addressVerification:$("#addressVerification").attr('checked') != undefined ? "true":"false",
			cvdChecks:$("#cvdChecks").attr('checked') != undefined ? "true":"false"
	}
	
	var params = {
			id:$("#id").val(),
			rxProcedureSort:$("#rxProcedureSort").val() != 'Rank' ? '0':'1',
			enableCoupons:$("#enableCoupons").attr('checked') != undefined ? '0':'1',
			panNumbers:$("#panNumbers").val()=='PRENUMBERED'?'1':'2',
			prefCasesMass:$("#prefCasesMass").val(),
			currency:$("#currency").val(),
			storeId:$("#storeId").val(),
			apiToken:$("#apiToken").val(),
			features:JSON.stringify(features)
	}
	
	$$ajax( {
		url : "labAction/setting/updatePreferences.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				alert(JSON.failReasons);
			} else {
				alert("修改成功");
				$("#id").val(JSON.info);
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