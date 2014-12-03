
function limitAskPrice(askPrice){
	var preferentialLimit = parseFloat($('#preferentialLimit').val());
	 var originalPrice = parseFloat($('#originalPrice').val());
	 if(!askPrice){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('优惠价不能为空').end().show();
		 return false;
	 }
	 var strP=/^\d+(\.\d+)?$/;
	 if(!strP.test(askPrice)){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('请输入正确的金额').end().show();
		 return false;
	 }
	 try{
	 	 if(parseFloat(askPrice)!=askPrice){
	 		$('#askPrice_info').find('i.Addonecuowu_b').html('请输入正确的金额').end().show();
	 		 return false;
	 	 }
	 }catch(ex){
	   return false;
	 }
	 if(parseFloat(askPrice)> originalPrice){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('优惠价不能大于订单金额').end().show();
		 return false;
	 }
	 
	 //四舍五入去小数点后两位
	 if(parseFloat(askPrice) < originalPrice*(1-preferentialLimit/100).toFixed(2)){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('此价格的优惠幅度超出您的优惠限度').end().show();
		 $('#askBargain_div').show();
		 return false;
	 }else{
		 $('#askPrice_info').hide();
		 $('#askBargain_div').hide();
		 return true;
	 }
	 
}

//提交议价后的结果
function submitBargain(){
	var caseId = $('#caseId').val();
	var askPrice = $('#askPrice').val();
	if(limitAskPrice(askPrice)){
		$$ajax( {
			url : "casesAction/doCasesPreferential.do",
			data : {caseId:caseId,askPrice:askPrice},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在加载数据...').end().show();
			},
			success : function(data, textStatus) {
	            var JSON = eval('(' + data + ')');
	            if (JSON.result != 'TRUE') {
	                //alert(JSON.failReasons);
	                ShowFailTip(JSON.failReasons);
	            } else {
	                //alert('提交成功');
	                ShowSuccessTip('提交成功');
	                window.location.reload();
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

function limitBargainPrice(askPrice){
	 var originalPrice = parseFloat($('#originalPrice').val());
	 if(!askPrice){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('优惠价不能为空').end().show();
		 return false;
	 }
	 var strP=/^\d+(\.\d+)?$/;
	 if(!strP.test(askPrice)){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('请输入正确的金额').end().show();
		 return false;
	 }
	 try{
	 	 if(parseFloat(askPrice)!=askPrice){
	 		$('#askPrice_info').find('i.Addonecuowu_b').html('请输入正确的金额').end().show();
	 		 return false;
	 	 }
	 }catch(ex){
	   return false;
	 }
	 
	 if(parseFloat(askPrice)>originalPrice){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('优惠价不能大于订单金额').end().show();
		 return false;
	 }
	 
	 return true;
}

//跳转到申请更大优惠页面
function askBargain(){
	
	var caseId = $('#caseId').val();
	var askPrice = $('#askPrice').val();
	
	if(limitBargainPrice(askPrice)){
		$('#bargain_dialog').dialog('destroy');
		
		//动态获取
		$$ajax( {
			url : "casesAction/goBargainRequest.do",
			data : {caseId:caseId,askPrice:askPrice},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
			},
			success : function(data, textStatus) {
	                $('#bargain_request_dialog').html(data);
	                
	                $("#bargain_request_dialog").dialog( {
	            		bgiframe : true,
	            		autoOpen : true,
	            		title : "优惠申请",
	            		width : 850,
	            		height : 600,
	            		modal : true,
	            		draggable : true,
	            		resizable : true,
	            		close:function(){
	            			$(this).dialog('destroy');
	            	    }
	            	});
	            	
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

//提交优惠申请
function submitBargainRequest(){
	
	var caseId = $('#caseId').val();
	var askReason = $('#askReason').val();
	var verifierId = $('#verifier').val();
	var verifierName = $('#verifier').find('option:selected').text();
	var askPrice = $('#askPrice').val();
	
	if(verifierId == ''){
		$('#verifier_info').show();
		return;
	}else{
		$('#verifier_info').hide();
	}
	
	if(askReason.trim()!=''){
		if(askReason.length > 300){
			$('#askReason_info').find('i.Addonecuowu_b').html('申请描述字符不能超过300个').end().show();
			return;
		}else{
			$('#askReason_info').hide();
		}
	}
	
	var params = {
			caseId:caseId,
			verifierId:verifierId,
			verifierName:verifierName,
			askReason:askReason,
			askPrice:askPrice
	};
	
	
	$$ajax( {
		url : "casesAction/doBargainRequest.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
            if (JSON.result != 'TRUE') {
                //alert(JSON.failReasons);
            	ShowFailTip(JSON.failReasons);
            } else {
                //alert(JSON.info);
                ShowFailTip(JSON.info);
                $("#bargain_request_dialog").dialog("destroy");
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

function editBargainRequest(){
	var id = $('#id').val();
	var askReason = $('#askReason').val();
	var verifierId = $('#verifier').val();
	var verifierName = $('#verifier').find('option:selected').text();
	var askPrice = $('#askPrice').val();
	
	if(limitPrice(askPrice)){
		if(verifierId == ''){
			$('#verifier_info').show();
			return;
		}else{
			$('#verifier_info').hide();
		}
		
		if(askReason.trim()!=''){
			if(askReason.length > 300){
				$('#askReason_info').find('i.Addonecuowu_b').html('申请描述字符不能超过300个').end().show();
				return;
			}else{
				$('#askReason_info').hide();
			}
		}
		
		var params = {
				id:id,
				verifierId:verifierId,
				verifierName:verifierName,
				askReason:askReason,
				askPrice:askPrice
		};
		
		
		$$ajax( {
			url : "casesAction/editBargainRequest.do",
			data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
	            if (JSON.result != 'TRUE') {
	                //alert(JSON.failReasons);
	            	ShowFailTip(JSON.failReasons);
	            } else {
	                //alert(JSON.info);
	                ShowSuccessTip(JSON.info);
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
	
}


function limitPrice(askPrice){
	 if(!askPrice){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('优惠价不能为空').end().show();
		 return false;
	 }
	 var strP=/^\d+(\.\d+)?$/;
	 if(!strP.test(askPrice)){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('请输入正确的金额').end().show();
		 return false;
	 }
	 try{
	 	 if(parseFloat(askPrice)!=askPrice){
	 		$('#askPrice_info').find('i.Addonecuowu_b').html('请输入正确的金额').end().show();
	 		 return false;
	 	 }
	 }catch(ex){
	   return false;
	 }
	 var preferentialLimit = parseFloat($('#preferentialLimit').text());
	 var originalPrice = parseFloat($('#originalPrice').text());
	 //四舍五入去小数点后两位
	 if(parseFloat(askPrice) > originalPrice*(1-preferentialLimit/100).toFixed(2)){
		 $('#askPrice_info').find('i.Addonecuowu_b').html('此优惠金额在您的优惠限度内，无需申请').end().show();
		 return false;
	 }else{
		 $('#askPrice_info').hide();
		 return true;
	 }
	 
}