
/**
 * 通用方法
 * @param url
 * @param params
 * @param genre
 */
function sendData(url, params ,genre){
	$$ajax( {
		url : url,
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#div_show").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

/******************************* toArrive start ***************************************/
//列表过滤
function listFilter(){
	$("#filter").submit();
}

function queryCasesList(offset,type){
	var filter_by = $('#filter_by').val();
	var unit_id = $('#unit_id').val();
	//1 、2
	var unit_type = $("#unit_id").find("option:selected").attr("unitType");
	var year = $('#year').val();
	var month = $('#month').val();
	var params = {
		filterBy:filter_by,
		unitId:unit_id,
		unitType:unit_type,
		year:year,
		month:month,
		offset:offset,
		type:'paging'
	};

	$$ajax( {
		url : "labAction/query.do?method=" + type,
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#div_show").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

/******************************* toArrive end   ***************************************/