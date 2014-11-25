
/**
 * 查询重制订单
 */
function queryCaseRemake(){
	var startDate = $('#startDate').val();
	var endDate = $('#endDate').val();
	var unitId = $('#unitId').val();
	var unitType = $("#unitId").find("option:selected").attr("unitType");
	var format = $('#cases_remakes_format').val();
	var params = {
			startDate:startDate,
			endDate:endDate,
			unitId:unitId,
			unitType:unitType,
			format:format
		};
	var url = '';
	if(format!=''){
		//导出excel
		exportRemakeExcel(params);
	}else{
		//display on screen
		var url = '/labAction/reports/queryCaseRemake.do?startDate='+startDate+'&endDate='+endDate+'&unitType='+unitType+'&unitId='+unitId;
		window.location.href = webContext + url;
	}
		
}

/**
 * 导出重制订单
 */
function exportRemakeExcel(params){
	var param = params;
	$$ajax( {
		url : "labAction/reports/queryCaseRemake.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find("#msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			if(data == undefined || data == ''){
				$("#no-data-div").find("#msg").html('没有数据...').end().show().delay(1000).hide(0);
			}else{
				var path = '/remakeCases/'+data;
				window.location.href=webContext+"/downloadFileAction/download.do?download="+coding(path)+"&fileName="+coding(data);
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
 * 转码，将字符串（汉字）转码
 * @param param
 * @returns
 */
function coding(param){
	if(param != undefined && param != null){
		param = encodeURI(encodeURI(param));
	} 
	return param;
}

function financeResults(){
	var monthd = $('input[name="report-radio"]:checked').val();
	var begin = "";
	var end = "";
	var type = "month";
	if(monthd =='custom'){
		type = "custom";
		begin = $("#custom-reports-date-begin").val();
		end = $("#custom-reports-date-end").val();
	}else{
		begin = monthd;
		end = monthd;
	}
	if(begin==undefined || begin.trim()=='' || end==undefined || end.trim()=='' ){
		alert("日期不能为空！");
	}else{
		window.open(webContext+"/labAction/financeResults.do?beginTime="+begin+"&endTime="+end+"&type="+type, 'newwindow', 'height=768px, width=1024px, scrollbars=yes, resizable=yes,alwaysRaised=yes');
	}
}