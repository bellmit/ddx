//议价-优惠价审批
function doBargainVerify(){
	var id = $('#id').val();
	var isAgree = $('input[name="isAgree"]:checked').val();
	var verifyOpinion = $('#verifyOpinion').val();
	
	//验证
	if(isAgree==null){
		$('#isAgree_info').find('i.Addonecuowu_b').html('请选择是否同意该申请').end().show();
		return false;
	}else{
		$('#isAgree_info').hide();
	}
	
	if(verifyOpinion != null){
		if(verifyOpinion.length > 100){
			$('#verifyOpinion_info').find('i.Addonecuowu_b').html('字数过多').end().show();
			return false;
		}
	}else{
		$('#verifyOpinion_info').hide();
	}
	
	var params = {
		id:id,
		isAgree:isAgree,
		verifyOpinion:verifyOpinion
	};
	
	$$ajax( {
		url : "casesAction/doBargainVerify.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find("#msg").html('正在提交数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				alert(JSON.failReasons);
			} else {
				alert(JSON.info);
				window.location.href = webContext + '/labAction/query.do?method=bargainVerify';
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