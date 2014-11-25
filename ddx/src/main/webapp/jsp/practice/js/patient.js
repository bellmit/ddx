/**
 * 患者列表页面分页
 * @param pageNo
 * @param isSearch
 */
function listPatients(pageNo,isSearch){
	var param = {offset:pageNo,search:$("#search-patient").val(),isSearch:isSearch}
	$$ajax( {
		url : "practiceAction/patients.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#patient_div_show").html(data);
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
 * 患者详情页面的订单分页
 * @param pageNo
 * @param id
 */
function listPatientCases(pageNo,id){
	var param = {offset:pageNo,id:id}
	$$ajax( {
		url : "practiceAction/patient.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#patient_detail_caseList_div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function savePractice(){
	var name = $('#name').val();
	var legalName = $('#legalName').val();
	var address = $('#address').val();
	var address2 = $('#address2').val();
	var country = $('#country').val();
	var state = $('#state').val();
	var city = $('#city').val();
	var zipCode = $('#zipCode').val();
	var phoneNumber = $('#phoneNumber').val();
	var fax = $('#fax').val();
	var email = $('#email').val();
	var timeZone = $('#timeZone').val();
	var hours_open_sun = $('#hours_open_sun').attr('checked')!=undefined ? 1 : 0;
	var hours_open_mon = $('#hours_open_mon').attr('checked')!=undefined ? 1 : 0;
	var hours_open_tue = $('#hours_open_tue').attr('checked')!=undefined ? 1 : 0;
	var hours_open_wed = $('#hours_open_wed').attr('checked')!=undefined ? 1 : 0;
	var hours_open_thu = $('#hours_open_thu').attr('checked')!=undefined ? 1 : 0;
	var hours_open_fri = $('#hours_open_fri').attr('checked')!=undefined ? 1 : 0;
	var hours_open_sat = $('#hours_open_sat').attr('checked')!=undefined ? 1 : 0;
	
	var hours_from_sun = $('#hours_from_sun').val();
	var hours_from_mon = $('#hours_from_mon').val();
	var hours_from_tue = $('#hours_from_tue').val();
	var hours_from_wed = $('#hours_from_wed').val();
	var hours_from_thu = $('#hours_from_thu').val();
	var hours_from_fri = $('#hours_from_fri').val();
	var hours_from_sat = $('#hours_from_sat').val();
	
	var hours_to_sun = $('#hours_to_sun').val();
	var hours_to_mon = $('#hours_to_mon').val();
	var hours_to_tue = $('#hours_to_tue').val();
	var hours_to_wed = $('#hours_to_wed').val();
	var hours_to_thu = $('#hours_to_thu').val();
	var hours_to_fri = $('#hours_to_fri').val();
	var hours_to_sat = $('#hours_to_sat').val();
	
	var flag = true;
	if(hours_open_sun == 1){
		if(hours_from_sun == ''){
			$('#hours_from_sun_error').show();
			flag = false;
		}else{
			$('#hours_from_sun_error').hide();
		}
		if(hours_to_sun == ''){
			$('#hours_to_sun_error').show();
			flag = false;
		}else{
			$('#hours_to_sun_error').hide();
		}
	}else{
		$('#hours_from_sun_error').hide();
		$('#hours_to_sun_error').hide();
	}
	
	if(hours_open_mon == 1){
		if(hours_from_mon == ''){
			$('#hours_from_mon_error').show();
			flag = false;
		}else{
			$('#hours_from_mon_error').hide();
		}
		if(hours_to_mon == ''){
			$('#hours_to_mon_error').show();
			flag = false;
		}else{
			$('#hours_to_mon_error').hide();
		}
	}else{
		$('#hours_from_mon_error').hide();
		$('#hours_to_mon_error').hide();
	}
	
	if(hours_open_tue == 1){
		if(hours_from_tue == ''){
			$('#hours_from_tue_error').show();
			flag = false;
		}else{
			$('#hours_from_tue_error').hide();
		}
		if(hours_to_tue == ''){
			$('#hours_to_tue_error').show();
			flag = false;
		}else{
			$('#hours_to_tue_error').hide();
		}
	}else{
		$('#hours_from_tue_error').hide();
		$('#hours_to_tue_error').hide();
	}
	
	if(hours_open_wed == 1){
		if(hours_from_wed == ''){
			$('#hours_from_wed_error').show();
			flag = false;
		}else{
			$('#hours_from_wed_error').hide();
		}
		if(hours_to_wed == ''){
			$('#hours_to_wed_error').show();
			flag = false;
		}else{
			$('#hours_to_wed_error').hide();
		}
	}else{
		$('#hours_from_wed_error').hide();
		$('#hours_to_wed_error').hide();
	}
	
	if(hours_open_thu == 1){
		if(hours_from_thu == ''){
			$('#hours_from_thu_error').show();
			flag = false;
		}else{
			$('#hours_from_thu_error').hide();
		}
		if(hours_to_thu == ''){
			$('#hours_to_thu_error').show();
			flag = false;
		}else{
			$('#hours_to_thu_error').hide();
		}
	}else{
		$('#hours_from_thu_error').hide();
		$('#hours_to_thu_error').hide();
	}
	
	if(hours_open_fri == 1){
		if(hours_from_fri == ''){
			$('#hours_from_fri_error').show();
			flag = false;
		}else{
			$('#hours_from_fri_error').hide();
		}
		if(hours_to_fri == ''){
			$('#hours_to_fri_error').show();
			flag = false;
		}else{
			$('#hours_to_fri_error').hide();
		}
	}else{
		$('#hours_from_fri_error').hide();
		$('#hours_to_fri_error').hide();
	}
	
	if(hours_open_sat == 1){
		if(hours_from_sat == ''){
			$('#hours_from_sat_error').show();
			flag = false;
		}else{
			$('#hours_from_sat_error').hide();
		}
		if(hours_to_sat == ''){
			$('#hours_to_sat_error').show();
			flag = false;
		}else{
			$('#hours_to_sat_error').hide();
		}
	}else{
		$('#hours_from_sat_error').hide();
		$('#hours_to_sat_error').hide();
	}
	
	var prefCaseLicense = $('#prefCaseLicense').val();
	
	var provider = $('#provider').val();
	
	if(flag){
		var params = {
				name:name,
				legalName:legalName,
				address:address,
				address2:address2,
				country:country,
				state:state,
				city:city,
				zipCode:zipCode,
				phoneNumber:phoneNumber,
				fax:fax,
				email:email,
				timeZone:timeZone,
				sunOpen:hours_open_sun,
				monOpen:hours_open_mon,
				tueOpen:hours_open_tue,
				wedOpen:hours_open_wed,
				thuOpen:hours_open_thu,
				friOpen:hours_open_fri,
				satOpen:hours_open_sat,
				sunFrom:hours_from_sun,
				monFrom:hours_from_mon,
				tueFrom:hours_from_tue,
				wedFrom:hours_from_wed,
				thuFrom:hours_from_thu,
				friFrom:hours_from_fri,
				satFrom:hours_from_sat,
				sunTo:hours_to_sun,
				monTo:hours_to_mon,
				tueTo:hours_to_tue,
				wedTo:hours_to_wed,
				thuTo:hours_to_thu,
				friTo:hours_to_fri,
				satTo:hours_to_sat,
				providers:provider,
				prefCaseLicense:prefCaseLicense
		};
		
		$$ajax( {
			url : "practiceAction/updatePractice.do",
			data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					window.location.href = webContext+"/practiceAction/identity.do";
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