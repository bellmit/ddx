function sendPayment(){
	var amount = $('#amount').val();
	
	if(!isPriceNumber(amount)){
		$('#amount_info').show();
		return;
	}else{
		$('#amount_info').hide();
	}
	
	var params = {
		id:	$('#id').val(),
		amount:amount
	};
	$$ajax( {
		url : "practiceAction/finances/payment.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if(JSON.result == 'TRUE'){
				alert(JSON.info);
				window.location.href = webContext + "/practiceAction/practice.do?portal=financeOverview&id="+$('#id').val();
			}else{
				alert(JSON.failReasons);
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

function isPriceNumber(_keyword){
	if(_keyword == "0" || _keyword == "0." || _keyword == "0.0" || _keyword == "0.00"){
		_keyword = "0"; return true;
	}else{
		var index = _keyword.indexOf("0");
		var length = _keyword.length;
		if(index == 0 && length>1){/*0开头的数字串*/
			var reg = /^[0]{1}[.]{1}[0-9]{1,2}$/;
			if(!reg.test(_keyword)){
				return false;
			}else{
				return true;
			}
		}else{/*非0开头的数字*/
			var reg = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
			if(!reg.test(_keyword)){
				return false;
			}else{
				return true;
			}
		}			
		return false;
	}
}