function login(){
	var fate = $("#selectFate").val();
	var username = $("#login-username").val();
	var password = $("#login-password").val();
	var securityType = $('input[name="security-type"]:checked').val();
	var param = {fate:fate,username:username,password:password,securityType:securityType};
	$$ajax( {
		url : "userAction/checkUser.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find("#msg").html('正在登陆...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				$("#login-sessionScope").html(JSON.failReasons);
			} else {
				$("#data-login-div").find("#msg").html('登陆成功，正在跳转...').end().show();
				if(fate.trim()=='1'){
					document.loginForm.action = document.loginForm.action+"/lab_login";
				}else if(fate.trim()=='2'){
					document.loginForm.action = document.loginForm.action+"/practice_login";
				}
				document.loginForm.submit();
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

function onkeydownSubmit(event){
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if(e && e.keyCode==13){ 
		login();
	}
}

function resetPassword(){
	 var result = verificationRestPassword();
	 if(result!=false){
		 $$ajax( {
				url : "userAction/checkReset.do",
				data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				success : function(data, textStatus) {
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert(JSON.failReasons);
					} else {
						$("#success_message").show();
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
function verificationRestPassword(){
	 var selectItems=$("#selectItems").val();
	 var username=$("#reset_username").val();
	 var newPassword=$("#reset_new_password").val();
	 var affirmPassword=$("#affirm_reset_password").val();
	 var isTrue = true;
		 if(username.trim()!=''||username!=undefined){
			 var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;  
			 var  isok=pattern.test(username);
			 if(!isok){
				 isTrue=false;
				 $("#affirm_username_error").show();
				 $("#reset_username").attr('class','Addonecuowu');
			 }else{
				 $("#affirm_username_error").hide();
				 $("#reset_username").attr('class','Personalize_b_middle_b');
			 }
		 }else{
			 $("#affirm_username_error").show();
			 $("#reset_username").attr('class','Addonecuowu');
		 }
	 if(newPassword == undefined || newPassword.trim()=='' ||newPassword.trim().length<6 ){
		 isTrue=false;
		 $("#affirm_password_error").show();
		 $("#reset_new_password").attr('class','Addonecuowu');
	 }else{
		 $("#affirm_password_error").hide();
		 $("#reset_new_password").attr('class','Personalize_b_middle_b');
	 }
	 if(affirmPassword==undefined||affirmPassword.trim()==''||newPassword!=affirmPassword){
		 isTrue=false;
		 $("#mate_password_error").show();
		 $("#affirm_reset_password").attr('class','Addonecuowu');
	 }else{
		 $("#mate_password_error").hide();
		 $("#affirm_reset_password").attr('class','Personalize_b_middle_b');
	 }
	 if(isTrue){
		 $("#error_message").hide();
		 var params={
				 selectItems:selectItems,
				 email:username,
				 newPassword:newPassword
		 }
		 return params;
	 }else{
			$("#error_message").show();
		}
		return isTrue;
}

function sendmail(email,newPassword){
	var params = {email:email,newPassword:newPassword}
	$$ajax( {
		url : "userAction/sendmail.do",
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
