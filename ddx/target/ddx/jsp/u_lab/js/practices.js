function listLabAndPractices(pageNo,type){
	var param = {offset:pageNo,search:$("#search-lab-practices").val(),type:type}
	$$ajax( {
		url : "labAction/setting/practices.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#lab-practices-list-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}
function query(method,id,type){
	var param = {id:id,method:method,type:type} 
	$$ajax( {
		url : "labAction/query.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#my-cooperation-lab-div").html(data);
			if("practiceContacts"==method){
				doubleBgColor(document.getElementById("ebill-user-table"),"#FFFFFF","#F0F0F0");
			}else if("practicePriceList"==method){
				doubleBgColor(document.getElementById("price-list-table"),"#FFFFFF","#F0F0F0");
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

function myCooperationPractices(id,type){
	if(id!=undefined && id.trim()!='' && type!=undefined && type.trim()!=''){
		var param = {id:id,type:type,method:'myCooperationPractices'} 
		$$ajax( {
			url : "labAction/query.do",
			data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
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
}