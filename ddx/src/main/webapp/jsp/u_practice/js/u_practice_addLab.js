function searchLabs(){
	var by = $("#by").val();
	var Country = $("#county").val();
	var value = $("#searchValue").val();
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
		url : "labAction/searchLabs.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#Search-PartnerLabs-result-div").html(data).show();
		    doubleBgColor(document.getElementById("searchLab-table"),"#FFFFFF","#F0F0F0");
			
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}
function doubleBgColor(Table,Bg1,Bg2) {
    for (var i=0;i<Table.rows.length;i++) Table.rows[i].bgColor=i%2?Bg2:Bg1;
}

function hideSearch(){
	$('#Search-PartnerLabs-div').hide(1000);
	$('#Search-PartnerLabs-result-div').hide(1000);
}