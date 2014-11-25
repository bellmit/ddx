function query(method){
	var params = {method:method }
	$$ajax( {
		url : "labAction/query.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#show-case-setting-content-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function init(menu,item){
	if("procedure"==menu){
		$('#show-case-setting-menu-div').html($('#case-setting-menu-Procedures').html());
	}
	if(item!=undefined && item.trim()!=''){
		query(item);
	}
}