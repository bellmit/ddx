function searchLabs(unit){
	var by = $("#Search-PartnerLabs-by").val();
	var Country = $("#Search-PartnerLabs-Country").val();
	var value = $("#Search-PartnerLabs-value").val();
	if(value.trim()==''){
		alert("请输入关键字");
		return;
	}
	var params = {
			by:by,
			country:Country,
			value:value
	}
	$$ajax( {
		url : "partners/searchLabs.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#Search-PartnerLabs-result-div").html(data).show();
		    doubleBgColor(document.getElementById("searchLab-table"),"#FFFFFF","#F0F0F0");
			if('2'==unit){
				$("#PartnerLabsadmin-div").attr("style","width: 745px;");
				$("#searchLab-table").attr("style","width: 745px;");
				$(".abscdefg").attr("style","width: 745px;");
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

function hideSearch(){
	$('#Search-PartnerLabs-div').hide(1000);
	$('#Search-PartnerLabs-result-div').hide(1000);
}
function showFindWindow(){
	$("#find-labs-div").show();
	$("#my-labs-div").hide();
}

function getMyLasBypractice(){
	$$ajax( {
		url : "partners/partners.do",
		data : null,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#find-labs-div").hide();
			$("#my-labs-div").html(data).show();
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}