/***************************************工厂实验室会员中心_u_lab_Dashboard_PartnerLabs_admin_qianjin_yachi 开始**************************************/

/**
 * 跳转到新增订单页面
 */
function gotoNewCase(reqAccLabId,labId){
	window.location.href = webContext + "/casesAction/pageJump.do?type=toNewCase&reqAccLabId="+reqAccLabId;
}
/**
 * 显示技工间所有的订单
 * @param labId
 * @param reqAccLabId
 */
function showAllLabCases(labId,reqAccLabId){
	window.location.href = webContext + "/casesAction/pageJump.do?type=showAllLabCases&reqAccLabId="+reqAccLabId;
}

/**
 * 加载试戴中的订单
 */
function loadCaseTryIn(){
	var url = "";
	sendData(url, params, 'loadCaseTryIn');
}
/***************************************工厂实验室会员中心_u_lab_Dashboard_PartnerLabs_admin_qianjin_yachi 结束**************************************/

/**
 * 动态加载case enclosure 》》 新建订单页面 == u_lab_Cases_NewCase.jsp
 */
function loadCaseEnclosure(){
	$$ajax( {
		url : "casesAction/searchLabs.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			
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
			$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			var genre = JSON.genre;
			var flag = JSON.flag;
			var obj = JSON.obj;
			//对各种返回的处理
			if(genre == 'loadProcedure'){

			}else if(genre == 'loadCaseTryIn'){
				
			}else if(genre == 'addData'){
				if(flag == 'success'){
					ShowSuccessTip('新增成功！');
					//alert('新增成功！');
					//清空表单
					$(':input','#caseForm').not(':button,:submit,:reset,:hidden').val('').removeAttr('checked')
					var caseId = obj.caseId;
					var labId = obj.labId;
					var patientId = obj.patientId;
					window.location.href = webContext + '/casesAction/getDataById.do?caseId=' + caseId;
				}else{
					//alert('新增失败！'+obj.msg);
					ShowFailTip('新增失败！'+obj.msg);
				}
			}else if(genre == 'addCaseResume'){
				if(flag == 'success'){
					ShowSuccessTip('草案转订单成功！');
					//alert('草案转订单成功！');
					var caseId = obj.caseId;
					var labId = obj.labId;
					var patientId = obj.patientId;
					window.location.href = webContext + '/casesAction/getDataById.do?caseId=' + caseId;
				}else{
					ShowFailTip('草案转订单失败！'+obj.msg);
					//alert('草案转订单失败！'+obj.msg);
				}
			}else if(genre == 'addCaseRemake'){
				if(flag == 'success'){
					ShowSuccessTip('重制订单创建成功！');
					//alert('重制订单创建成功！');
					var caseId = obj.caseId;
					window.location.href = webContext + '/casesAction/getDataById.do?caseId=' + caseId;
				}else{
					ShowFailTip('重制订单创建失败！'+obj.msg);
				}
			}else if(genre == 'addCaseOutsource'){
				if(flag == 'success'){
					ShowSuccessTip('外包订单创建成功！');
					var caseId = obj.caseId;
					window.location.href = webContext + '/casesAction/getDataById.do?caseId=' + caseId;
				}else{
					ShowFailTip('外包订单创建失败！'+obj.msg);
				}
			}else if(genre == 'addCaseBasePatient'){
				if(flag == 'success'){
					ShowSuccessTip('订单创建成功！');
					var caseId = obj.caseId;
					window.location.href = webContext + '/casesAction/getDataById.do?caseId=' + caseId;
				}else{
					ShowFailTip('订单创建失败！'+obj.msg);
				}
			}else if(genre == 'addDataAsDraft'){
				if(flag == 'success'){
					ShowSuccessTip('保存草稿成功！');
					var url = '';
					if(obj.unitType == '2'){
						url = '/practiceAction/main.do';
					}else if(obj.unitType=='1'){
						url = '/partners/requestAccount.do?labId='+obj.labId;
					}
					window.location.href = webContext + url;
				}else{
					ShowFailTip('保存草稿失败！'+obj.msg);
				}
			}else if(genre == 'applyLabEmail'){
				if(flag == 'success'){
					ShowSuccessTip('更新技工间电子邮箱成功！');
					document.casesDetailForm.submit();
				}
			}else if(genre == 'applyPatientAppointment'){
				if(flag == 'success'){
					ShowSuccessTip('更新患者预约日期成功！');
					//window.location.reload();
					document.casesDetailForm.submit();
				}
			}else if(genre == 'rescheduleSendDate'){
				if(flag == 'success'){
					ShowSuccessTip('重排发送日期成功！')
					document.casesDetailForm.submit();
				}
			}
			else if(genre == 'cancelCases'){
				if(flag == 'success'){
					ShowSuccessTip('取消订单成功！');
				}else{
					ShowFailTip(obj.msg);
				}
				var reqAccLabId = $('#reqAccLabId').val();
				window.location.href = webContext + '/casesAction/overview.do?labId=' + reqAccLabId;
			}else if(genre == 'confirmDeliveryDate'){
				if(flag == 'success'){
					ShowSuccessTip(obj.info + '成功！');
					//变换图标
				}
			}else if(genre == 'applyCasesTags'){
				if(flag == 'success'){
					ShowSuccessTip('更新成功！');
					$('#tags_div').hide();
					$('#tags_value').text(obj.info);
				}
			}else if(genre == 'applyFollowCase'){
				if(flag == 'success'){
					var tex = '';
					if(obj.info == 'UNFOLLOW'){
						tex = '未跟踪';
					}else if(obj.info == 'LAB_FOLLOW'){
						tex = '跟踪';
					}else{
						tex = '跟踪';
					}
					$('#isFollow').text(tex);
				}
			}else if(genre == 'addNote'){
				if(flag == 'success'){
					ShowSuccessTip('备注添加成功！')
					document.casesDetailForm.submit();
				}
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
 * 显示工序选择界面
 */
function showProcedureDialog(){
	$("#procedure_window_div").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "选择工序",
		width : 850,
		height : 780,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'取消' : function() {
				$("#procedure_window_div").dialog('destroy');
			}
		}
	});
	$("#procedure_window_div").dialog('open');
}
function loadProcedure(index,value,isLayout){
	//选择工序，加载工序属性 
	 var params = {
             id: value,isLayout:isLayout
         }
         $$ajax({
             url: "casesAction/getAttributes.do",
             data: params,
             type: "POST",
             async: true,
             cache: false,
             global: false,
             dataType: "html",
             beforeSend: function(XMLHttpRequest) {
                 $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
             },
             success: function(data, textStatus) {
					$("#attributes-"+index).html(data);
					if('false'==isLayout){
						$(".biaoti_add01").attr('style','margin-left:0px;width:auto;');
						$(".box_edit01").attr('style','width:auto;');
					}
			 },
             error: function(e) {
                 alertError(e);
             },
             complete: function(msg) {
                 $("#data-loading-div").hide();
             }
         });
   }


var proNum = 1;
/**
 * 创建增加工序窗口
 */
function createNewProInput(){
	var str = "<div class=\"newcase_middle\" name=\"procedure-div\" id=\"add-procedure-div-"+proNum+"\">"+$("#init-select-procedure-div").html()+"</div><p style=\"clear:both\"></p>";
	var html = str.replace(/delete-div-flag/g, 'removeProcInput('+(proNum)+');').replace(/select-index/g, proNum).replace(/attributes-index/g, "attributes-"+proNum);
	$("#procedure-list-div").append(html);
	++proNum;
}

/**
 * 移除添加的工序录入窗口
 * @param id
 */
function removeProcInput(id){
	$('#add-procedure-div-'+id).remove();
}

/**
 * 显示工序窗口
 */
function showProcedureEmbedDialog(title,id){
	var $dialog = $('#procedure_embed');
	var href = webContext + '/casesAction/procedureEmbed.do?id='+id;
	 $dialog.html('<iframe style="border: 0px; " src="' + href + '" width="100%" height="100%"></iframe>').dialog({
		 title:title,
         resizable: true,
         height: 850,
         width: 900,
         modal: true,
         draggable: true
     });
}

/**
 * 设置订单是否加急、是否试戴 
 * @param id
 */
function setAttr(id){
	var isTryIn_v = $('#isTryIn').val();
	var isEmeger_v = $('#isEmeger').val();
	var isFiles_v = $('#isFiles').val();
	var filesPerm_v = $('#filesPerm').val();
	if(id == 'isTryIn'){
		if(isTryIn_v != 'Y'){
			$('#isTryIn_a').addClass('isTryIn_a_active').css('color','#fff');
			$('#isTryIn').val('Y');
		}else{
			$('#isTryIn_a').removeClass('isTryIn_a_active').css('color','');
			$('#isTryIn').val('N');
		}
		
	}else if(id == 'isEmeger'){
		var cx = filesPerm_v == 'true'?'isEmeger_a_active':'isEmeger_a_active_2';
		if(isEmeger_v != 'Y'){
			$('#isEmeger_a').addClass(cx).css('color','#fff');
			$('#isEmeger').val('Y');
		}else{
			$('#isEmeger_a').removeClass(cx).css('color','');
			$('#isEmeger').val('N');
		}
		
	}else if(id == 'isFiles'){
		if(isFiles_v != 'Y'){
			$('#isFiles_a').addClass('isFiles_active').css('color','#fff');
			$('#isFiles').val('Y');
		}else{
			$('#isFiles_a').removeClass('isFiles_active').css('color','');
			$('#isFiles').val('N');
		}
	}
}
var isOk = true;
function check(id,val,need,dataType,div_id){
	if(need=='REQUIRED'){
		if(val==null || val.trim()==''){
			isOk = false;
			if(div_id!=undefined && div_id.trim()!=''){
				$("#"+div_id).find("#"+id).attr("style","border-color:red");
			}else{
				$("#"+id).attr("style","border-color:red");
			}
		}else{
			if(div_id!=undefined && div_id.trim()!=''){
				$("#"+div_id).find("#"+id).attr("style","border-color:#cbcbcb");
			}else{
				$("#"+id).attr("style","border-color:#cbcbcb");
			}
		}
	}

	if(dataType=='int'){
		if(val!=null && val.trim()!=''){
			if(!isNaN(val)){
				if(div_id!=undefined && div_id.trim()!=''){
					$("#"+div_id).find("#"+id).attr("style","border-color:#cbcbcb");
				}else{
					$("#"+id).attr("style","border-color:#cbcbcb");
				}
			}else{
				isOk = false;
				if(div_id!=undefined && div_id.trim()!=''){
					$("#"+div_id).find("#"+id).attr("style","border-color:red");
				}else{
					$("#"+id).attr("style","border-color:red");
				}
			}
		}
	}

}

function showAttr(id){
	var flag = $("#"+id+"-a").attr("flag");
	if(flag=='show'){
		$("#"+id+"-a").html("[+]");
		$("#"+id+"-tr").hide(500);
		$("#"+id+"-a").attr("flag","hide");
	}else{
		$("#"+id+"-a").html("[-]");
		$("#"+id+"-tr").show(500);
		$("#"+id+"-a").attr("flag","show");
	}
}

/**
 * 保存订单
 * @param type
 */
function saveCase(type){
	
	var caseId = $('#caseId').val();
	var newType = $('#newType').val();
	var returnSId = $('#returnSId').val();
    var returnType = $('#returnType').val();
    var remakeType = $('#remakeType').val();
    
	//病人患者
    var provider = $('#providers').find("option:selected").text();
	var firstName = $('#firstName').val(); //
	var lastName = $('#lastName').val();	//
	var sex = $('#sex').val();
	var externalId = $('#externalId').val();
	var birthday = $('#birthday').val();
	var patientId = $('#patientId').val();
	
	//制作需求
	var sendToLabDate = $('#sendToLabDate').val(); //
	var deliveryDate = $('#deliveryDate').val();
	
	var enclosures = $("#enclosures").multiselect("getChecked").map(function(){
        return this.value;    
	}).get().toString();
	
	var caseNote = CKEDITOR.instances.caseNote.getData();
	var couponCode = $('#coupon_code').val();
	var tags = '';
	var string = '';
	var tagsPerm = $('#tagsPerm').val();
	//创建标签的权限判断
	if(tagsPerm == 'true'){
		var tags_obj = $('#tags-ul').tagit('tags');
		for (var i in tags_obj)
		string += tags_obj[i].value + ",";
		
		if(string.charAt(string.length - 1)==','){
			string = string.substr(0,string.length-1);
		}
	}
	
	var tags = string;
	var isTryIn = $('#isTryIn').val();
	var isEmeger = $('#isEmeger').val();
	var isFiles = $('#isFiles').val();
	
	var partnerLabId = $('#partnerLabId').val();
	
	var caseId = $('#parentId').val();
	
	var procedure_select = $("div#procedure-list-div").find('select[name=select-procedure-name]');
	
	var terms = $('#terms').attr('checked');
	var term_valid = $('#term_valid').val();
	
	
	var genre = "";
	genre = (type == 1)?"addData":"addDataAsDraft";
	var url = "casesAction/"+ genre +".do";
	
	//姓
	if(firstName.trim() == ''){
		$('#firstName_info').show();
		//$('#firstName').attr("class","Addonecuowu_b");
		return;
	}else{
		$('#firstName_info').hide();
		$('#firstName').attr("class","NewCase_a_middle_b");
	}
	//名
	if(lastName.trim() == ''){
		$('#lastName_info').show();
		//$('#lastName').attr("class","Addonecuowu_b");
		return;
	}else{
		$('#lastName_info').hide();
		$('#lastName').attr("class","NewCase_a_middle_b");
	}
	//发送日期
	if(sendToLabDate.trim() == ''){
		$('#sendToLabDate_info').show();
		//$('#sendToLabDate').attr("class","Addonecuowu_b");
		return;
	}else{
		$('#sendToLabDate_info').hide();
		$('#sendToLabDate').attr("class","NewCase_a_middle_b");
	}
	
	//工序
	/*if(procedure_select.trim() == ''){
		$('#procedure-select_info').show();
		//$('#procedure-select').attr("class","Addonecuowu_b");
		return;
	}else{
		$('#procedure-select_info').hide();
		$('#procedure-select').attr("class","NewCase_a_middle_b");
	}*/
	var pro_selected = true;
	procedure_select.each(function(){
		if($(this).val().trim() == ''){
			pro_selected = false;
		}
	});
	
	if(!pro_selected){
		$('#procedure-select_info').show();
		return;
	}else{
		$('#procedure-select_info').hide();
		$('#procedure-select').attr("class","NewCase_a_middle_b");
	}
	
	//重制订单对重做原因进行验证
	if(newType == 'remake'){
		if(caseNote == ''){
			$('#caseNote_info').show();
			$('#caseNote_info').find('i').html('请填写重制原因！');
			return;
		}
	}
	
	if(strlen(caseNote)>300){
		$('#caseNote_info').find('i').html('字数过多！');
		$('#caseNote_info').show();
		return;
	}else{
		$('#caseNote_info').hide();
	}
	
	//我同意
	if(term_valid == 'true'){
		if(terms != 'checked'){
			$('#terms_info').show();
			$('#terms').attr("class","Addonecuowu_b");
			return;
		}else{
			$('#terms_info').hide();
			$('#terms').attr("class","");
		}
	}
	
	//标签
	if(tags.trim()!='' && tags.trim().length > 30){
		$('#tags_info').show();
		return;
	}else{
		$('#tags_info').hide();
	}
	
	
	/***
	 * 
	 * 未完成，请勿修改：金德志，2014-8-28 11:30:54
	 * 
	 */
	isOk = true;
	var arr = new Array();
	$("div[name='procedure-div']").each(function (ii){
		var list = $(this);
		var div_id = $(this).attr("id");
		for(var i=0;i<list.length;i++){
			var procedure_id = $(list.eq(i)).find("select[name='select-procedure-name']").val();
			var procedure_name = $(list.eq(i)).find("select[name='select-procedure-name']").find("option:selected").text();
			var select1 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-left").find("select").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var val = $(list2.eq(j)).val();
					check(id, val, need,"",div_id);
					select1[jj]={id:id,val:val}
				}
			});
			var select2 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-right").find("select").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var val = $(list2.eq(j)).val();
					check(id, val, need,"",div_id);
					select2[jj]={id:id,val:val}
				}
			});
			var input1 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-left").find("input").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var key = $(list2.eq(j)).attr("key");
					var dataType = $(list2.eq(j)).attr("dataType");
					var val = $(list2.eq(j)).val();
					check(id, val, need,dataType,div_id);
					input1[jj]={id:id,key:key,val:val}
				}
			});
			var input2 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-right").find("input").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var key = $(list2.eq(j)).attr("key");
					var dataType = $(list2.eq(j)).attr("dataType");
					var val = $(list2.eq(j)).val();
					check(id, val, need,dataType,div_id);
					input2[jj]={id:id,key:key,val:val}
				}
			});
			arr[ii]={procedure_id:procedure_id,procedure_name:procedure_name,select1:select1,select2:select2,input1:input1,input2:input2}
		}
	});
	if(isOk){
		var params = {
				caseId:caseId,
				newType:newType,
				returnSId:returnSId,
				returnType:returnType,
				remakeType:remakeType,
				patientId:patientId,
				labId:partnerLabId,
				provider:provider,
				firstName:firstName,
				lastName:lastName,
				patient:(firstName+lastName),
				sex:sex,
				externalId:externalId,
				birthday:birthday,
				patientId:patientId,
				sendToLabDate:sendToLabDate,
				deliveryDate:deliveryDate,
				caseNote:caseNote,
				tags:tags,
				isTryIn:isTryIn,
				isEmeger:isEmeger,
				isFiles:isFiles,
				enclosures:enclosures,
				parentId:caseId,
				couponCode:couponCode,
				procedures:JSON.stringify(arr)
		}
		
		if(couponCode!=undefined && couponCode.trim()!=''){
			//验证优惠券
			var selectProceduresid = "";
			$("div[name='procedure-div']").each(function (ii){
				var list = $(this);
				for(var i=0;i<list.length;i++){
					var procedure_id = $(list.eq(i)).find("select[name='select-procedure-name']").val();
					selectProceduresid+=procedure_id+",";
				}
			});
			$$ajax( {
				url : "casesAction/checkCoupontValid.do",
				data : {code:couponCode,proceduresId:selectProceduresid,requestLabId:partnerLabId},type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				success : function(data, textStatus) {
					var retJsonInfo = eval('(' + data + ')');
					if (retJsonInfo.result != 'TRUE') {
						$("#isValid-msg-div").html(retJsonInfo.failReasons).css("color","red");
						$("#coupon_error").show();
					} else {
						sendData(url, params , genre);
					}
				},
				error : function(e) {
					alertError(e);
				},
				complete : function(msg) {
					$("#data-loading-div").hide();
				}
			});
		}else{
			sendData(url, params , genre);
		}
	}
	
}
//单个工序的新增或修改
function addCaseProcedure(type,casesid,attr_div_id,procedure_index,procedureId){
	isOk = true;
	var arr = new Array();
	var procedure_id = $("#add-pro-id-select").val();
	var procedure_name = $("#add-pro-id-select").find("option:selected").text();
	
	//若为工序新增，则校验是否选择工序、发送日期
	var send_to_lab_date = $('#send_to_lab_date').val();
	if('add'==type){
		if(procedure_id==undefined || procedure_id==''){
			$('#procedure_select_info').show();
			return;
		}else{
			$('#procedure_select_info').hide();
		}
		if(send_to_lab_date == undefined || send_to_lab_date == ''){
			$('#send_to_lab_date_info').show();
			return;
		}else{
			$('#send_to_lab_date_info').hide();
		}
	}
	
	if('update'==type){
		procedure_id = procedureId; 
	}
	$("div#"+attr_div_id).each(function (ii){
		var list = $(this);
		for(var i=0;i<list.length;i++){
			
			var select1 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-left").find("select").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var val = $(list2.eq(j)).val();
					check(id, val, need);
					select1[jj]={id:id,val:val}
				}
			});
			
			var select2 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-right").find("select").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var val = $(list2.eq(j)).val();
					check(id, val, need);
					select2[jj]={id:id,val:val}
				}
			});
			
			var input1 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-left").find("input").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var key = $(list2.eq(j)).attr("key");
					var dataType = $(list2.eq(j)).attr("dataType");
					var val = $(list2.eq(j)).val();
					check(id, val, need,dataType);
					input1[jj]={id:id,key:key,val:val}
				}
			});
			
			var input2 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-right").find("input").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var key = $(list2.eq(j)).attr("key");
					var dataType = $(list2.eq(j)).attr("dataType");
					var val = $(list2.eq(j)).val();
					check(id, val, need,dataType);
					input2[jj]={id:id,key:key,val:val}
				}
			});
			
			arr[ii]={procedure_id:procedure_id,procedure_name:procedure_name,select1:select1,select2:select2,input1:input1,input2:input2}
		}
	});
	
	if(isOk){
		var params = {
				caseId:casesid,
				procedure_index:procedure_index,
				procedures:JSON.stringify(arr),
				sendToLabDate:send_to_lab_date
		}
		var url = type=='add'?"addCaseProcedure.do":"updateCaseProcedure.do";
		$$ajax( {
			url : "casesAction/"+url,
			data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					ShowFailTip(JSON.failReasons);
				} else {
					ShowSuccessTip(JSON.info);
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

/************诊所医生practice_Case_Details start************/
/**
 * 订单详情中的 制作详情、备注、日志
 */
function loadTabInfo(type){
	if(type == 'detail'){
		$('#detail').show();
		$('#note').hide();
		$('#log').hide();
	}else if(type == 'note'){
		$('#detail').hide();
		$('#note').show();
		$('#log').hide();
	}else if(type == 'log'){
		$('#detail').hide();
		$('#note').hide();
		$('#log').show();
	}
}

/**
 * 下载文件
 * @param path
 * @param fileName
 */
function downloadFile(path, fileName) {
	var url = webContext + '/downloadFileAction/download.do?download=' + path + '&fileName='
			+ encodeURI(encodeURI(fileName));
	window.location.href = url;
}

/**
 * 患者预约
 */
function applyPatientAppointment(){
	var patient_appointment_date = $('#patient_appointment_date').val();
	var patient_appointment_time = $('#patient_appointment_time').val();
	
	//日期
	if(patient_appointment_date.trim() == ''){
		$('#patient_appointment_date_info').show();
		return;
	}else{
		$('#patient_appointment_date_info').hide();
	}
	//时间
	if(patient_appointment_time.trim() == ''){
		$('#patient_appointment_time_info').show();
		return;
	}else{
		$('#patient_appointment_time_info').hide();
	}
	
	var url = "casesAction/applyPatientAppointment.do";
	var params = {
			caseId:$('#caseId').val(),
			patAppDate:(patient_appointment_date + ' ' + patient_appointment_time)
	}
	sendData(url, params, 'applyPatientAppointment');
}

/**
 * 更新技工间电子邮箱地址
 */
function applyLabEmail(){
	var labId = $('#reqAccLabId').val();
	var email = $('#provide_email').val();
	
	if(email.trim() == ''){
		$('#provide_email_info').show();
		return;
	}else{
		$('#provide_email_info').hide();
	}
	
	var params = {
			labId:labId,
			email:email.trim()
	}
	var url = "labAction/applyLabEmail.do";
	sendData(url, params, 'applyLabEmail');
}

/**
 * 取消订单
 */
function cancelCases(){
	var url = "casesAction/cancelCases.do";
	var params = {
			caseId:$('#caseId').val(),
			reqAccLabId:$('#reqAccLabId').val()//伙伴技工间LAB ID
	}
	if(window.confirm('确定取消订单'+$('#caseId').val()+'吗？')){
		sendData(url, params, 'cancelCases');
	}
}

/**
 * 重新安排订单发出日期
 */
function rescheduleSendDate(){
	var url = "casesAction/rescheduleSendDate.do";
	var sendToLabDate = $('#reschedule_send_to_lab_date').val();
	if(sendToLabDate == ''){
		$('#reschedule_send_to_lab_date_info').show();
		return;
	}else{
		$('#reschedule_send_to_lab_date_info').hide();
	}
	
	var params = {
			caseId:$('#reschd_caseId').val(),
			labId:$('#reschd_labId').val(),//伙伴技工间LAB ID
			sendToLabDate:sendToLabDate
	}
	sendData(url, params, 'rescheduleSendDate');
}

/**
 * 跳转到指定患者订单新建页面
 */
function toCreateCaseForPatient(){
	document.toCreateCaseForPatientForm.submit();
}

/**
 * 确认技工间交货日期
 */
function confirmDeliveryDate(){
	var url = "casesAction/confirmDeliveryDate.do";
	var params = {
		caseId:$('#caseId').val(),
		labId:$('#reqAccLabId').val()//伙伴技工间LAB ID
	};
	sendData(url, params, 'confirmDeliveryDate');
}

/**
 * 添加订单笔记
 */
function addNote(){
	var url = "casesAction/cases/addNote.do";
	var notes = CKEDITOR.instances.notes.getData();
	if(notes == ''){
		$('#notes_info').find('i').html('内容不能为空').end().show();
		return;
	}else{
		if(notes.length>300){
			$('#notes_info').find('i').html('字数过多').end().show();
			retrun;
		}
		$('#notes_info').hide();
	}
	var params = {
		caseId:$('#caseId').val(),
		unitType:$('#unitType').val(),
		caseNote:notes
	};
	sendData(url, params, 'addNote');
}

/**
 * 跳转到收件请求页面
 */
function goPickupPage(labId){
	//var labId = $('#reqAccLabId').val();//伙伴技工间LAB ID
	window.location.href = webContext + "/casesAction/goPickupPage.do?labId=" + labId;
}

/**
 * 显示时间修改对话框
 */
function showHoursEditDialog(){
	$('#edit_hours_dialog').dialog({
        resizable: true,
        height:350,
        width: 660,
        modal: true,
        title:'编辑时间',
        open: function(event, ui) {
            //initDialogValidation();
        },
        buttons: {
        	"保存": function() {
        		editOperateTime();
            },
            "取消": function() {
                $(this).dialog("destroy");
            }
        },
        close:function(){
        	$(this).dialog("destroy");
        }
    });
	
}

/**
 * 显示标签编辑对话框
 */
function showTagsDialog(){
	$('#tags_dialog').dialog({
        resizable: true,
        height:300,
        width: 400,
        modal: true,
        title:'编辑标签',
        buttons: {
        	"保存": function() {
        		setTimeout('editCasesTags()',2000);
            },
            "取消": function() {
                $(this).dialog("close");
            }
        }
    });
}


function editCasesTags(){
	var str = '';
	var tags_obj = $('#tags-ul').tagit('tags');
	if(tags_obj.length>0){
		for (var i in tags_obj){
			str += tags_obj[i].value + ",";
		}
		if(str.charAt(str.length - 1)==','){
			str = str.substr(0,str.length-1);
		}
	}
	
	if(strlen(str)>300){
		$('#tags_info').find('i').html('字数过多！').end().show();
		$('#tags-ul').addClass('tags_ul_red');
		return;
	}else{
		$('#tags_info').hide();
		$('#tags-ul').removeClass('tags_ul_red');
	}
	
	var params = {
			caseId:$('#caseId').val(),
			tags:str
	};
	var url = "casesAction/applyCasesTags.do";
	sendData(url, params, 'applyCasesTags');
	$('#tags_dialog').dialog("destroy");
}

/**
 * 显示跟踪订单对话框 
 */
function showFollowCaseDialog(){
	$("#follow_case_dialog").dialog({
    	title:'跟踪订单',
        resizable: false,
        modal: true,
        height:200,
        width:350,
        buttons: {
        	"应用": function() {
        		var params = {
        				caseId:$('#caseId').val(),
        				followType:$('#follow_type').val()};
        		var url = "casesAction/applyFollowCase.do";
        		sendData(url, params, 'applyFollowCase');
        		$(this).dialog("close");
        	},
            "取消": function() {
                $(this).dialog("close");
            }
        }
    });
}


function editOperateTime(){
	
	var hours_open_sun = $('#hours_open_sun').attr('checked')!=undefined ? 1 : 0;
	var hours_open_mon = $('#hours_open_mon').attr('checked')!=undefined ? 1 : 0;
	var hours_open_tue = $('#hours_open_tue').attr('checked')!=undefined ? 1 : 0;
	var hours_open_wed = $('#hours_open_wed').attr('checked')!=undefined ? 1 : 0;
	var hours_open_thu = $('#hours_open_thu').attr('checked')!=undefined ? 1 : 0;
	var hours_open_fri = $('#hours_open_fri').attr('checked')!=undefined ? 1 : 0;
	var hours_open_sat = $('#hours_open_sat').attr('checked')!=undefined ? 1 : 0;
	
	var flag = true;
	var hours_from_sun = $('#hours_from_sun').val();
	var hours_to_sun = $('#hours_to_sun').val();
	if(hours_open_sun == 1){
		if(hours_from_sun == ''){
			$('#hours_from_sun_error').show();
			flag = false;
		}else{
			$('#hours_from_sun_error').hide();
		}
		if(hours_to_sun == ''){
			$('#hours_to_sun_error').show();
			flag = false;
		}else{
			$('#hours_to_sun_error').hide();
		}
	}else{
		$('#hours_from_sun_error').hide();
		$('#hours_to_sun_error').hide();
	}
	
	var hours_from_mon = $('#hours_from_mon').val();
	var hours_to_mon = $('#hours_to_mon').val();
	if(hours_open_mon == 1){
		if(hours_from_mon == ''){
			$('#hours_from_mon_error').show();
			flag = false;
		}else{
			$('#hours_from_mon_error').hide();
		}
		if(hours_to_mon == ''){
			$('#hours_to_mon_error').show();
			flag = false;
		}else{
			$('#hours_to_mon_error').hide();
		}
	}else{
		$('#hours_from_mon_error').hide();
		$('#hours_to_mon_error').hide();
	}
	
	var hours_from_tue = $('#hours_from_tue').val();
	var hours_to_tue = $('#hours_to_tue').val();
	if(hours_open_tue == 1){
		if(hours_from_tue == ''){
			$('#hours_from_tue_error').show();
			flag = false;
		}else{
			$('#hours_from_tue_error').hide();
		}
		if(hours_to_tue == ''){
			$('#hours_to_tue_error').show();
			flag = false;
		}else{
			$('#hours_to_tue_error').hide();
		}
	}else{
		$('#hours_from_tue_error').hide();
		$('#hours_to_tue_error').hide();
	}
	
	var hours_from_wed = $('#hours_from_wed').val();
	var hours_to_wed = $('#hours_to_wed').val();
	if(hours_open_wed == 1){
		if(hours_from_wed == ''){
			$('#hours_from_wed_error').show();
			flag = false;
		}else{
			$('#hours_from_wed_error').hide();
		}
		if(hours_to_wed == ''){
			$('#hours_to_wed_error').show();
			flag = false;
		}else{
			$('#hours_to_wed_error').hide();
		}
	}else{
		$('#hours_from_wed_error').hide();
		$('#hours_to_wed_error').hide();
	}
	
	var hours_from_thu = $('#hours_from_thu').val();
	var hours_to_thu = $('#hours_to_thu').val();
	if(hours_open_thu == 1){
		if(hours_from_thu == ''){
			$('#hours_from_thu_error').show();
			flag = false;
		}else{
			$('#hours_from_thu_error').hide();
		}
		if(hours_to_thu == ''){
			$('#hours_to_thu_error').show();
			flag = false;
		}else{
			$('#hours_to_thu_error').hide();
		}
	}else{
		$('#hours_from_thu_error').hide();
		$('#hours_to_thu_error').hide();
	}
	
	var hours_from_fri = $('#hours_from_fri').val();
	var hours_to_fri = $('#hours_to_fri').val();
	if(hours_open_fri == 1){
		if(hours_from_fri == ''){
			$('#hours_from_fri_error').show();
			flag = false;
		}else{
			$('#hours_from_fri_error').hide();
		}
		if(hours_to_fri == ''){
			$('#hours_to_fri_error').show();
			flag = false;
		}else{
			$('#hours_to_fri_error').hide();
		}
	}else{
		$('#hours_from_fri_error').hide();
		$('#hours_to_fri_error').hide();
	}
	
	var hours_from_sat = $('#hours_from_sat').val();
	var hours_to_sat = $('#hours_to_sat').val();
	if(hours_open_sat == 1){
		if(hours_from_sat == ''){
			$('#hours_from_sat_error').show();
			flag = false;
		}else{
			$('#hours_from_sat_error').hide();
		}
		if(hours_to_sat == ''){
			$('#hours_to_sat_error').show();
			flag = false;
		}else{
			$('#hours_to_sat_error').hide();
		}
	}else{
		$('#hours_from_sat_error').hide();
		$('#hours_to_sat_error').hide();
	}
	
	if(flag){
		var params = {
				sunOpen:hours_open_sun,
				monOpen:hours_open_mon,
				tueOpen:hours_open_tue,
				wedOpen:hours_open_wed,
				thuOpen:hours_open_thu,
				friOpen:hours_open_fri,
				satOpen:hours_open_sat,
				sunFrom:hours_from_sun,
				monFrom:hours_from_mon,
				tueFrom:hours_from_tue,
				wedFrom:hours_from_wed,
				thuFrom:hours_from_thu,
				friFrom:hours_from_fri,
				satFrom:hours_from_sat,
				sunTo:hours_to_sun,
				monTo:hours_to_mon,
				tueTo:hours_to_tue,
				wedTo:hours_to_wed,
				thuTo:hours_to_thu,
				friTo:hours_to_fri,
				satTo:hours_to_sat
		};
		
		$$ajax( {
			url : "casesAction/updateOperateTime.do",
			data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert(JSON.info);
					$('#edit_hours_dialog').dialog('destroy');
					window.location.href=window.location.href;
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

//发送收件请求
function pickup(){
	var reqAccLabId = $('#reqAccLabId').val();
	var rqDate = $('#rqDate').val();
	var rqTime = $('#rqTime').val();
	
	if(rqDate == ''){
		$('#rqDate_info').show();
		return;
	}else{
		$('#rqDate_info').hide();
	}
	
	if(rqTime == ''){
		$('#rqTime_info').show();
		return;
	}else{
		$('#rqTime_info').hide();
	}
	
	var params = {
		reqAccLabId:$('#reqAccLabId').val(),
		rqDate:$('#rqDate').val(),
		rqTime:$('#rqTime').val()
	};
	$$ajax( {
		url : "casesAction/pickup.do",
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				alert(JSON.failReasons);
			} else {
				alert(JSON.info);
				window.location.href=window.location.href;
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

/************诊所医生practice_Case_Details end**************/

/***** u_lab_cases_ByMonth.jsp start ******/
function listCasesByMonth(offset,type){
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
/***** end   ******/

/****** u_lab_Cases_ListCases_show.jsp 分页 start ********/
function listCases(offset){
	var filter_by = $('#filter_by').val();
	var year = $('#year').val();
	var month = $('#month').val();
	
	var param = {
			offset:offset,
			reqAccLabId:$('#reqAccLabId').val(),
			filterBy:filter_by,
			year:year,
			month:month
	}
	$$ajax( {
		url : "casesAction/listCases.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#u_lab_listcases_show_div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}
/****** u_lab_Cases_ListCases_show.jsp end ********/

/******* list cases for page query start 	*******************/
function queryList(offset,type){
	var param = {
			offset:offset,
			type:'paging'
	}
	$$ajax( {
		url : "labAction/query.do?method=" + type,
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
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
/******* list cases for page query end 	*******************/


//继续增加工序-加载工序列表
function loadPro(requestLabId){
	if($("#add-pro-id-select").html()==undefined || $("#add-pro-id-select").html().trim()==''){
		$$ajax( {
			url : "casesAction/loadProByRequestLabId.do",
			data : {requestLabId:requestLabId},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				$("#add-pro-id-select").html("<option value=\"\">--请选择工序--</option>"+data);
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

//ckeditor字数统计(去除格式符)
function strlen(str) { 
	var regExp = new RegExp(" ","g"); 
	str = str.replace(regExp , ""); 
	str = str.replace(/\r\n/g,""); 
	var realLength = 0, len = str.length, charCode = -1; 
	for (var i = 0; i < len; i++) { 
		charCode = str.charCodeAt(i); 
		if (charCode >= 0 && charCode <= 128) 
			realLength += 1; 
		else
			realLength += 2; } 
	return realLength; 
}

//显示用户协议条款 
function showTermsDialog(){
	$('#terms_dialog').dialog({
		resizable:true,
		height:400,
		width:600,
		modal:true,
		title:'协议及条款',
		buttons:{
			"同意":function(){
				$('#terms').attr('checked',true);
				$(this).dialog('destroy');
			}
		}
	});
}

/**
 * 快速下订单-提交
 */
function quickAddCases(){
	var newType = $('#newType').val();
    
	//病人患者
	var provider = $('#providers').find("option:selected").text();
	var firstName = $('#firstName').val(); //
	var lastName = $('#lastName').val();	//
	
	//制作需求
	var sendToLabDate = $('#sendToLabDate').val(); //
	var deliveryDate = $('#deliveryDate').val();
	
	var partnerLabId = $('#partnerLabId').val();
	
	var procedure_select = $('#add-pro-id-select').val();
	var procedure_name = $("#add-pro-id-select").find("option:selected").text();
	var terms = $('#terms').attr('checked');
	var term_valid = $('#term_valid').val();
	
	
	var url = "casesAction/addData.do";
	
	//姓
	if(firstName.trim() == ''){
		$('#firstName_info').show();
		return;
	}else{
		$('#firstName_info').hide();
		$('#firstName').attr("class","NewCase_a_middle_b");
	}
	//名
	if(lastName.trim() == ''){
		$('#lastName_info').show();
		return;
	}else{
		$('#lastName_info').hide();
		$('#lastName').attr("class","NewCase_a_middle_b");
	}
	//发送日期
	if(sendToLabDate.trim() == ''){
		$('#sendToLabDate_info').show();
		return;
	}else{
		$('#sendToLabDate_info').hide();
		$('#sendToLabDate').attr("class","NewCase_a_middle_b");
	}
	
	//工序
	if(procedure_select.trim() == ''){
		$('#procedure-select_info').show();
		return;
	}else{
		$('#procedure-select_info').hide();
	}
	//我同意
	if(term_valid == 'true'){
		if(terms != 'checked'){
			$('#terms_info').show();
			$('#terms').attr("class","Addonecuowu_b");
			return;
		}else{
			$('#terms_info').hide();
			$('#terms').attr("class","");
		}
	}
	
	
	isOk = true;
	var arr = new Array();
	$("div[name='procedure-div']").each(function (ii){
		var list = $(this);
		for(var i=0;i<list.length;i++){
			
			var select1 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-left").find("select").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var val = $(list2.eq(j)).val();
					check(id, val, need);
					select1[jj]={id:id,val:val}
				}
			});
			
			var select2 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-right").find("select").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var val = $(list2.eq(j)).val();
					check(id, val, need);
					select2[jj]={id:id,val:val}
				}
			});
			
			var input1 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-left").find("input").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var key = $(list2.eq(j)).attr("key");
					var dataType = $(list2.eq(j)).attr("dataType");
					var val = $(list2.eq(j)).val();
					check(id, val, need,dataType);
					input1[jj]={id:id,key:key,val:val}
				}
			});
			
			var input2 = new Array();
			$(list.eq(i)).find("#add-cases-procedures-right").find("input").each(function (jj){
				var list2 = $(this);
				for(var j=0;j<list2.length;j++){
					var id = $(list2.eq(j)).attr("id");
					var need = $(list2.eq(j)).attr("need");
					var key = $(list2.eq(j)).attr("key");
					var dataType = $(list2.eq(j)).attr("dataType");
					var val = $(list2.eq(j)).val();
					check(id, val, need,dataType);
					input2[jj]={id:id,key:key,val:val}
				}
			});
			
			arr[ii]={procedure_id:procedure_select,procedure_name:procedure_name,select1:select1,select2:select2,input1:input1,input2:input2}
		}
	});
	
	if(isOk){
		var params = {
				newType:newType,
				labId:partnerLabId,
				provider:provider,
				firstName:firstName,
				lastName:lastName,
				patient:(firstName+lastName),
				sendToLabDate:sendToLabDate,
				deliveryDate:deliveryDate,
				procedures:JSON.stringify(arr)
			}
			
			sendData(url, params , "addData");
	}
}

//同步获取工序属性
function loadProAttr(index, value, isLayout) {
	//选择工序，加载工序属性 
	var params = {
		id : value,
		isLayout : isLayout
	}
	$$ajax({
		url : "casesAction/getAttributes.do",
		data : params,
		type : "POST",
		async : false,
		cache : false,
		global : false,
		dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end()
					.show();
		},
		success : function(data, textStatus) {
			$("#attributes-" + index).html(data);
			if ('false' == isLayout) {
				$(".biaoti_add01").attr('style', 'margin-left:0px;width:auto;');
				$(".box_edit01").attr('style', 'width:auto;');
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
//给工序属性赋值
function setProAttrVal(i, index, caseId) {
	$$ajax({
		url : "casesAction/loadCaseProcedure.do",
		data : {
			index : index,
			caseId : caseId
		},
		type : "POST",
		async : false,
		cache : false,
		global : false,
		dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end()
					.show();
		},
		success : function(data, textStatus) {
			var json = eval(data);
			$.each(json, function(index, item) {
				if (json == undefined) {
					return;
				}
				var id = json[index].id;
				var value = json[index].value;
				$('div#attributes-' + i).find('#' + id).val(value);
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

//诊所端 ---返回试戴加载工序

function loadTryInPro(requestLabId){
	if($("#load-pro-id-select").html()==undefined || $("#load-pro-id-select").html().trim()==''){
		$$ajax( {
			url : "casesAction/loadProByRequestLabId.do",
			data : {requestLabId:requestLabId},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				$("#load-pro-id-select").html("<option value=\"\">--请选择工序--</option>"+data);
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

function loadTryInProcedureAttr(index,value,isLayout){
	//选择工序，加载工序属性 
	 var params = {
             id: value,isLayout:isLayout
         }
         $$ajax({
             url: "casesAction/getAttributes.do",
             data: params,
             type: "POST",
             async: true,
             cache: false,
             global: false,
             dataType: "html",
             beforeSend: function(XMLHttpRequest) {
                 $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
             },
             success: function(data, textStatus) {
					$("#tryin_attributes-"+index).html(data);
					if('false'==isLayout){
						$(".biaoti_add01").attr('style','margin-left:0px;width:auto;');
						$(".box_edit01").attr('style','width:auto;');
					}
			 },
             error: function(e) {
                 alertError(e);
             },
             complete: function(msg) {
                 $("#data-loading-div").hide();
             }
         });
   }

//订单试戴-submit
function doTryIn(type,casesid){
		isOk = true;
		
		//病人预约
		var app_date = $('#app_date').val();
		var app_time = $('#app_time').val();
		
		if(app_time.trim()!='' && app_date.trim()==''){
			alert('请选择日期');
			$('#app_date').focus();
			return;
		}
		
		//note
		var caseNote = CKEDITOR.instances.return_tryin_notes.getData();
		
		var arr = new Array();
		var procedure_id = $("#load-pro-id-select").val();
		var procedure_name = $("#load-pro-id-select").find("option:selected").text();
		//选择了工序的情形
		if(procedure_id != undefined && '' != procedure_id){
			$("div#tryin-procedure-div").each(function (ii){
				var list = $(this);
				for(var i=0;i<list.length;i++){
					
					var select1 = new Array();
					$(list.eq(i)).find("#add-cases-procedures-left").find("select").each(function (jj){
						var list2 = $(this);
						for(var j=0;j<list2.length;j++){
							var id = $(list2.eq(j)).attr("id");
							var need = $(list2.eq(j)).attr("need");
							var val = $(list2.eq(j)).val();
							check(id, val, need);
							select1[jj]={id:id,val:val}
						}
					});
					
					var select2 = new Array();
					$(list.eq(i)).find("#add-cases-procedures-right").find("select").each(function (jj){
						var list2 = $(this);
						for(var j=0;j<list2.length;j++){
							var id = $(list2.eq(j)).attr("id");
							var need = $(list2.eq(j)).attr("need");
							var val = $(list2.eq(j)).val();
							check(id, val, need);
							select2[jj]={id:id,val:val}
						}
					});
					
					var input1 = new Array();
					$(list.eq(i)).find("#add-cases-procedures-left").find("input").each(function (jj){
						var list2 = $(this);
						for(var j=0;j<list2.length;j++){
							var id = $(list2.eq(j)).attr("id");
							var need = $(list2.eq(j)).attr("need");
							var key = $(list2.eq(j)).attr("key");
							var dataType = $(list2.eq(j)).attr("dataType");
							var val = $(list2.eq(j)).val();
							check(id, val, need,dataType);
							input1[jj]={id:id,key:key,val:val}
						}
					});
					
					var input2 = new Array();
					$(list.eq(i)).find("#add-cases-procedures-right").find("input").each(function (jj){
						var list2 = $(this);
						for(var j=0;j<list2.length;j++){
							var id = $(list2.eq(j)).attr("id");
							var need = $(list2.eq(j)).attr("need");
							var key = $(list2.eq(j)).attr("key");
							var dataType = $(list2.eq(j)).attr("dataType");
							var val = $(list2.eq(j)).val();
							check(id, val, need,dataType);
							input2[jj]={id:id,key:key,val:val}
						}
					});
					
					arr[ii]={procedure_id:procedure_id,procedure_name:procedure_name,select1:select1,select2:select2,input1:input1,input2:input2}
				}
			});
		}
		
		
		if(isOk){
			var params = {
					caseId:casesid,
					patAppDate:(app_date + ' ' + app_time),
					caseNote:caseNote,
					procedures:JSON.stringify(arr)
			}
			var url = "tryInUpdate.do";
			$$ajax( {
				url : "casesAction/"+url,
				data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find("#msg").html('正在拼命的加载数据...').end().show();
				},
				success : function(data, textStatus) {
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert(JSON.failReasons);
					} else {
						alert(JSON.info);
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

function loadMyCoupon(requestId){
	var param={
		requestId:requestId
	}
	$$ajax( {
		url : "casesAction/findCoupon.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#addCoupon").html(data);
			$("#addCoupon").dialog({
		        bgiframe: true,
		        autoOpen: false,
		        title: "选择优惠券",
		        width: 750,
		        height: 400,
		        modal: true,
		        draggable: true,
		        resizable: true,
		        closeText: "close",
		        buttons: {
		            '取消': function() {
		                $("#addCoupon").dialog('destroy');
		            }
		        }
		    });
		   $('#addCoupon').dialog('open');
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function addCoupontTo(id,code,proceduresid){
	$('#addCoupon').dialog('destroy');
	$("#coupon_code").val(code);
	checkCoupontValid(code, proceduresid,$("#partnerLabId").val());
}
function apply(requestLabId){
	var code = $("#coupon_code").val();
	checkCoupontValid(code, null,requestLabId);
}
//检查是否有效
function checkCoupontValid(code,proceduresid,requestLabId){
	var isValid = false;
	var selectProceduresid = "";
	$("div[name='procedure-div']").each(function (ii){
		var list = $(this);
		for(var i=0;i<list.length;i++){
			var procedure_id = $(list.eq(i)).find("select[name='select-procedure-name']").val();
			selectProceduresid+=procedure_id+",";
			if(proceduresid==procedure_id){
				isValid = true;
			}
		}
	});
	if(proceduresid!=undefined && proceduresid.trim()!='' && !isValid){
		$("#isValid-msg-div").html("优惠券不能使用，请核对优惠券指定的工序").css("color","red");
	}else{
		$$ajax( {
			url : "casesAction/checkCoupontValid.do",
			data : {code:code,proceduresId:selectProceduresid,requestLabId:requestLabId},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					$("#isValid-msg-div").html(JSON.failReasons).css("color","red");
				} else {
					var sale = JSON.info.discountType=='P'?"%":"￥";
					$("#isValid-msg-div").html("优惠："+JSON.info.discount+sale+"，指定工序："+JSON.info.proceduresName).css("color","green");
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
	$("#coupon_error").show();
}

function removecoupont(){
	$("#coupon_code").val('');
	$("#isValid-msg-div").val('');
	$("#coupon_error").hide();
}

//技工间-伙伴技工间页面加载草稿订单
function loadDraftCasesByLabPartner(rqLabId){
	//动态获取
	if($('#lp_draft_cases_div').html()==undefined || $('#lp_draft_cases_div').html().trim() == ''){
		$$ajax( {
			url : "casesAction/loadDraftCasesByLp.do",
			data : {rqLabId:rqLabId},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
			},
			success : function(data, textStatus) {
	             $('#lp_draft_cases_div').html(data);
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

function printPracticeWork(){
	window.location.href = webContext + '/casesAction/practicePrintWork.do?caseId='+$('#caseId').val();
}