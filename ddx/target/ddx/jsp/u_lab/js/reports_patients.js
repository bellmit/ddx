function listPatients(pageNo,type){
	var param = {offset:pageNo,search:$("#search-patient").val(),type:type}
	$$ajax( {
		url : "labAction/reports/patients.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#reports_patients_div_show").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function listPatientCases(pageNo,id,type){
	var param = {offset:pageNo,id:id,type:type}
	$$ajax( {
		url : "labAction/reports/patient.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#reports_patient_div_show").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}


function listPatientsByPractice(pageNo,type){
	var unitId = $('#unitId').val();
	var unitType = $('#unitType').val();
	var param = {offset:pageNo,search:$("#search-patient").val(),type:type,unitId:unitId,unitType:unitType};
	$$ajax( {
		url : "labAction/reports/patientsByPractice.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#reports_patients_div_show").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

