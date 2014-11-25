function switchLogin(action, username, password) {
	document.switchForm.action = action;
	$("#switchForm-username").val(username);
	$("#switchForm-password").val(password);
	document.switchForm.submit();
}

function showAddUserGroupDialog() {
	$("#add-user-group-div").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "绑定账户",
		width : 536,
		height : 400,
		modal : true,
		draggable : true,
		resizable : false,
		closeText : "close",
		buttons : {
			'取消' : function() {
				$('#add-user-group-div').dialog('destroy');
			}
		}
	});
	$('#add-user-group-div').dialog('open');
}

function addUserGroup(){
	var email = $("#add-user-group-email").val();
	var password = $("#add-user-group-password").val();
	if(email.trim()=='' || password.trim()==''){
		$("#add-group-user-error-message").html("邮箱和密码不能为空");
		return;
	}
	
	var param = {email:email,password:password,role:$("#add-user-group-By").val()}
	$$ajax( {
		url : "userAction/addUserGroup.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				$("#add-group-user-error-message").html("增加失败，"+JSON.failReasons);
			} else {
				alert("增加用户成功");
				location.reload(true);
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