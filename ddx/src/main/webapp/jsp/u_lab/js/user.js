function editUser(url){
	var result = verification(url);
	if(result!=false){
		$$ajax( {
			url : url,
			data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					try{
						$("#add-lab-user-div").dialog('destroy');
						$("#add-practice-user-div").dialog('destroy');
					}catch(e){
						
					}
					if('requestAccount' == JSON.info){
						alert("增加成功");
						location.reload(true);
					}else if('addPracticeUser' == JSON.info){
						alert("添加成功");
						listPracticeUsers(1);
					}else if('updatePracticeUser' == JSON.info){
						alert("修改成功");
						if(JSON.failReasons=='true'){
							window.location.href = webContext + "/practiceAction/practice.do?portal=users";
						}
					}else{
						alert(JSON.info);
						if(JSON.info=='增加成功'){
							listLabUsers(1);
						}else{
							window.location.href = webContext + "/labAction/setting/users.do";
						}
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

}

function verification(url){
	var accountId = $("#edit-user-accountId").val();
	var salutation = $("#edit-user-salutation").val();
	var firstName = $("#edit-user-firstName").val();
	var accountInitial = $("#edit-user-accountInitial").val();
	var lastName = $("#edit-user-lastName").val();
	var externalID = $("#edit-user-externalID").val();
	var email = $("#edit-user-email").val();
	var ConfirmEmail = $("#edit-user-Confirm-email").val();
	var password = $("#edit-user-password").val();
	var ConfirmPassword = $("#edit-user-Confirm-password").val();
	var ddxNewsletter = $("#edit-user-ddxNewsletter").attr('checked')!=undefined?"checked":"false";
	var ddxDailySummary = $("#edit-user-ddxDailySummary").attr('checked')!=undefined?"checked":"false";
	
	var ddxActivityLog = {
			casesCreated:$("#edit-user-casesCreated").attr('checked')!=undefined?"true":"false",
			casesCreatedPracticeUpdatesOnly:$("#edit-user-casesCreatedPracticeUpdatesOnly").attr('checked')!=undefined?"true":"false",
			casesCreatedLabUpdatesOnly:$("#edit-user-casesCreatedLabUpdatesOnly").attr('checked')!=undefined?"true":"false",
			updatedCases:$("#edit-user-updatedCases").attr('checked')!=undefined?"true":"false",
			updatedCasesPracticeUpdatesOnly:$("#edit-user-updatedCasesPracticeUpdatesOnly").attr('checked')!=undefined?"true":"false",
			updatedCasesLabUpdatesOnly:$("#edit-user-updatedCasesLabUpdatesOnly").attr('checked')!=undefined?"true":"false",
			pickupRequests:$("#edit-user-pickupRequests").attr('checked')!=undefined?"true":"false",
			balancePayments:$("#edit-user-balancePayments").attr('checked')!=undefined?"true":"false",
			statements:$("#edit-user-statements").attr('checked')!=undefined?"true":"false",
			invoices:$("#edit-user-invoices").attr('checked')!=undefined?"true":"false",
			accounts:$("#edit-user-accounts").attr('checked')!=undefined?"true":"false",
			accountsPracticeUpdatesOnly:$("#edit-user-accountsPracticeUpdatesOnly").attr('checked')!=undefined?"true":"false",
			accountsLabUpdatesOnly:$("#edit-user-accountsLabUpdatesOnly").attr('checked')!=undefined?"true":"false"
	}
	
	var teethNotation = $('input[name="teethNotation"]:checked').val();
	var preferentialLimit = $('#preferential_limit').val();
	
	var isTrue = true;
	
	if (firstName== undefined || firstName.trim() == '') {
		isTrue = false;
		$("#edit-user-firstName-title").show();
		$("#edit-user-firstName").attr('class','Addonecuowu');
	}else{
		$("#edit-user-firstName-title").hide();
		$("#edit-user-firstName").attr('class','Personalize_b_middle_b');
	}
	
	if (lastName== undefined || lastName.trim() == '') {
		isTrue = false;
		$("#edit-user-lastName-title").show();
		$("#edit-user-lastName").attr('class','Addonecuowu');
	}else{
		$("#edit-user-lastName-title").hide();
		$("#edit-user-lastName").attr('class','Personalize_b_middle_b');
	}
	
	if (email== undefined || email.trim() == '') {
		isTrue = false;
		$("#edit-user-email-title").show();
		$("#edit-user-email").attr('class','Addonecuowu');
	}else{
		$("#edit-user-email-title").hide();
		$("#edit-user-email").attr('class','Personalize_b_middle_b');
	}
	
	if (ConfirmEmail== undefined || ConfirmEmail.trim() == '' || ConfirmEmail!=email) {
		isTrue = false;
		$("#edit-user-Confirm-email-title").show();
		$("#edit-user-Confirm-email").attr('class','Addonecuowu');
	}else{
		$("#edit-user-Confirm-email-title").hide();
		$("#edit-user-Confirm-email").attr('class','Personalize_b_middle_b');
	}
	
	if (password== undefined || password.trim() == '') {
		isTrue = false;
		$("#edit-user-password-title").show();
		$("#edit-user-password").attr('class','Addonecuowu');
	}else{
		$("#edit-user-password-title").hide();
		$("#edit-user-password").attr('class','Personalize_b_middle_b');
	}
	if (ConfirmPassword== undefined || ConfirmPassword.trim() == '' || ConfirmPassword!=password) {
		isTrue = false;
		$("#edit-user-Confirm-password-title").show();
		$("#edit-user-Confirm-password").attr('class','Addonecuowu');
	}else{
		$("#edit-user-Confirm-password-title").hide();
		$("#edit-user-Confirm-password").attr('class','Personalize_b_middle_b');
	}
	
	var role = $("#user_type").val();
	if(url.indexOf("practiceAction")!=-1){
		//当前操作为添加诊所用户
		if(role==null || role.trim()==''){
			isTrue = false;
			$("#user_type-title").show();
			$("#user_type").attr('class','Addonecuowu');
		}else{
			$("#user_type-title").hide();
			$("#user_type").attr('class','Personalize_b_middle_b');
		}
	}
	var autoFollowCase = $("#auto-Follow-Cases").val();
	var manager = $("#manager-Account").attr('checked')!=null?"true":"false";
	var createTages = $("#create-CaseTags").val();
	
	var permiss = new Array();
	$("#Lab-Permissions-div dl[name='partner-labs-permissons']").each(function (ii){
		var a = $(this);
		for(var i=0;i<a.length;i++){
			var tr_id = $(a.eq(i)).attr("id");
			var permissions = "";
			$(a.eq(i)).find("input").each(function (i){
				var b =  $(this);
				for (var j=0;j<b.length;j++) {
					var id = $(b.eq(j)).attr("id");
					var fied = id.split("-")[1];
					var c = $("#"+id).attr('checked')!=null?"true":"false";
					permissions+=fied+":"+c+";";
				}
			});
			permiss[ii]={id:tr_id,permissions:permissions}
		}
	});
	
	if(isTrue){
		$("#editErrorMessage").hide();
		var params = {
				accountId:accountId,
				salutation:salutation,
				firstName:firstName,
				accountInitial:accountInitial,
				lastName:lastName,
				externalID:externalID,
				email:email,
				password:password,
				ddxNewsletter:ddxNewsletter,
				ddxDailySummary:ddxDailySummary,
				teethNotation:teethNotation,
				ddxActivityLog:JSON.stringify(ddxActivityLog),
				role:role,
				autoFollowCases:autoFollowCase,
				managerAccount:manager,
				createCaseTags:createTages,
				labPermissions:JSON.stringify(permiss),
				preferentialLimit:preferentialLimit
		}
		return params;
	}else{
		$("#editErrorMessage").show();
	}
	return isTrue;
}


function showAddUserDialog(div_id){
	$("#add-lab-user-div").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "添加用户",
		width : 850,
		height : 800,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'取消' : function() {
				$("#add-lab-user-div").dialog('destroy');
			}
		}
	});
	$("#add-lab-user-div").dialog('open');
}

function listLabUsers(pageNo){
	var param = {offset:pageNo,search:$("#search-users").val()}
	$$ajax( {
		url : "labAction/setting/listUserSearch.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#user-list-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function deleteLabUser(id){
	if(!confirm("确认删除这个用户吗？")){
		return;
	}
	$$ajax( {
		url : "labAction/setting/deleteUser.do",
		data : {id:id},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				alert(JSON.failReasons);
			} else {
				alert("删除成功");
				listLabUsers(1);
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

function accountPending(id){
	var param = {
			labId:id,
			billType:$("#request-billtype").val()+"",
			userId:$("#request-account-ebill-user-select").val()+""
	}
	$$ajax( {
		url : "partners/accountPending.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#PartnerLabsadminqianjin_left-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}


function controlEnable(){
	var value = $("#request-account-ebill-user-select").val();
	if(value== null || value==''){
		$("#is-enable").html("未启用").attr('style','color: red;');
		$("#enabled-disabled-pts").html("启用，选择一个或多个帐户接收电子账单，然后点击&nbsp;“申请帐户”。");
	}else{
		$("#is-enable").html("已启用").attr('style','color: green;');
		$("#enabled-disabled-pts").html("禁用，取消选择一个或多个帐户接收电子账单，然后点击&nbsp;“申请帐户”。");
	}
}