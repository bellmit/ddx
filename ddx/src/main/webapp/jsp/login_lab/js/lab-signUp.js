/**
 * 更换图片
 * 
 * @param obj
 */
function updateImg(obj){
	// obj.src = null;
	obj.src = webContext + "/kaptchaAction/getVerify.do?" + Math.floor(Math.random() * 100);
}
/**
 * 提交前校验验证码
 * 
 */
function verifyCode(result){
	$$ajax( {
		url : "kaptchaAction/chkVerify.do",
		data : {verifyCode:result.verifyCode},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			if(data!='true'){
				$("#signup-lab-account-VerificationCode-title-msg").html("验证码输入错误！");
				$("#signup-lab-account-VerificationCode-title").show();
				$("#signup-lab-account-VerificationCode").attr('class','center_f');
			}else{
				 $("#signup-lab-account-VerificationCode-title").hide();
				 $("#signup-lab-account-VerificationCode").attr('class','center_b_middle_right_a');
				 signUp(result);
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
function signUp(result){
	$$ajax( {
		url : "userAction/signUp.do",
		data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				if(JSON.failReasons=='duplicate_email'){
					alert("注册失败，账号邮箱已存在，请更换邮箱再试！");
				}else if(JSON.failReasons=='error_verify_code'){
					alert("注册失败，验证码输入不正确，请重新输入验证码再试！");
				}else{
					alert(JSON.failReasons);
				}
			} else {
				$("#sigupLoginForm-username").val(result.email);
				$("#sigupLoginForm-password").val(result.password);
				document.sigupLoginForm.submit();
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
function signupLabAccount() {
	var result = verification();
	if (result != false) {
		verifyCode(result);
	}
}
function verification() {
	// 验证账户表单
	var Salutation = $("#signup-lab-account-Salutation").val();
	var DDXNewsletter = $("#signup-lab-account-isDDXNewsletter").attr('checked');
	var AccountType = $("#signup-lab-account-type").val();
	var FirstName = $("#signup-lab-account-FirstName").val();
	var LastName = $("#signup-lab-account-LastName").val();
	var Email = $("#signup-lab-account-Email").val();
	var ConfirmEmail = $("#signup-lab-account-ConfirmEmail").val();
	var Password = $("#signup-lab-account-Password").val();
	var ConfirmPassword = $("#signup-lab-account-ConfirmPassword").val();
	// 验证实验室表
	var Address2 = $("#signup-lab-Address2").val();
	var Country = $("#signup-lab-Country").val();
	var State = $("#signup-lab-State").val();
	var labEmail = $("#signup-lab-Email").val();
	var TimeZone = $("#signup-lab-TimeZone").val();
	var Subdomain = $("#signup-lab-Subdomain").val();
	var Services = {
			fixedRestorations:$("#signup-lab-isFixedRestorations").attr('checked')!=undefined?true:false,
					removableRestorations:$("#signup-lab-isRemovableRestorations").attr('checked')!=undefined?true:false,
							dentalAppliancesOrthodontics:$("#signup-lab-isDentalAppliancesOrthodontics").attr('checked')!=undefined?true:false,
									implantRestorations:$("#signup-lab-isImplantRestorations").attr('checked')!=undefined?true:false,
											dentalWingsServices:$("#signup-lab-isDentalWingsServices").attr('checked')!=undefined?true:false,
													e4dServices:$("#signup-lab-isE4DServices").attr('checked')!=undefined?"true":false,
															lavaCOSServices:$("#signup-lab-isLavaCOSServices").attr('checked')!=undefined?true:false,
																	zirluxFCServices:$("#signup-lab-isZirluxFCServices").attr('checked')!=undefined?true:false
			
	}
	var LabName = $("#signup-lab-name").val();
	var Address = $("#signup-lab-Address").val();
	var City = $("#signup-lab-City").val();
	var PostalCode = $("#signup-lab-PostalCode").val();
	var Telephone = $("#signup-lab-Telephone").val();
	var Agree = $("#signup-lab-account-isAgree").attr('checked');
	var VerificationCode = $("#signup-lab-account-VerificationCode").val();
	
	var isTrue = true;
	if (AccountType.trim() == '') {
		isTrue = false;
		$("#signup-lab-account-type-title").show();
		$("#signup-lab-account-type").attr('class','center_f');
	}else{
		$("#signup-lab-account-type-title").hide();
		$("#signup-lab-account-type").attr('class','center_b_middle_right_a');
	}
	if (FirstName.trim() == '') {
		isTrue = false;
		$("#signup-lab-account-FirstName-title").show();
		$("#signup-lab-account-FirstName").attr('class','center_f');
	}else{
		$("#signup-lab-account-FirstName-title").hide();
		$("#signup-lab-account-FirstName").attr('class','center_b_middle_right_a');
	}
	if (LastName.trim() == '') {
		isTrue = false;
		 $("#signup-lab-account-LastName-title").show();
		 $("#signup-lab-account-LastName").attr('class','center_f');
	}else{
		$("#signup-lab-account-LastName-title").hide();
		$("#signup-lab-account-LastName").attr('class','center_b_middle_right_a');
	}
	if (Email.trim() == '') {
		isTrue = false;
		$("#signup-lab-account-Email-title").show();
		$("#signup-lab-account-Email").attr('class','center_f');
	}else{
		// 校验邮箱格式
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(Email)){
			isTrue = false;
			$("#signup-lab-account-Email-title").show();
			$("#signup-lab-account-Email").attr('class','center_f');
		}else{
			$("#signup-lab-account-Email-title").hide();
			$("#signup-lab-account-Email").attr('class','center_b_middle_right_a');
			
		}
		//$("#signup-lab-account-Email-title").hide();
		//$("#signup-lab-account-Email").attr('class','center_b_middle_right_a');
	}
	if (ConfirmEmail.trim() == '' || ConfirmEmail.trim()!=Email.trim()) {
		isTrue = false;
		 $("#signup-lab-account-ConfirmEmail-title").show();
		 $("#signup-lab-account-ConfirmEmail").attr('class','center_f');
	}else{
		 $("#signup-lab-account-ConfirmEmail-title").hide();
		 $("#signup-lab-account-ConfirmEmail").attr('class','center_b_middle_right_a');
	}
	if (Password.trim() == '') {
		isTrue = false;
		$("#signup-lab-account-Password-title").show();
		$("#signup-lab-account-Password").attr('class','center_f');
	}else if(Password.trim().length<6){
		isTrue = false;
		$("#signup-lab-account-Password-title").show();
		$("#signup-lab-account-Password").attr('class','center_f');
	}else{
		$("#signup-lab-account-Password-title").hide();
		$("#signup-lab-account-Password").attr('class','center_b_middle_right_a');
	}
	if (ConfirmPassword.trim() == '' || ConfirmPassword.trim()!=Password.trim()) {
		isTrue = false;
		$("#signup-lab-account-ConfirmPassword-title").show();
		$("#signup-lab-account-ConfirmPassword").attr('class','center_f');
	}else{
		$("#signup-lab-account-ConfirmPassword-title").hide();
		$("#signup-lab-account-ConfirmPassword").attr('class','center_b_middle_right_a');
	}
	if (LabName.trim() == '') {
		isTrue = false;
		$("#signup-lab-name-title").show();
		$("#signup-lab-name").attr('class','center_f');
	}else{
		$("#signup-lab-name-title").hide();
		$("#signup-lab-name").attr('class','center_b_middle_right_a');
	}
	if (Address.trim() == '') {
		isTrue = false;
		$("#signup-lab-Address-title").show();
		$("#signup-lab-Address").attr('class','center_f');
	}else{
		$("#signup-lab-Address-title").hide();
		$("#signup-lab-Address").attr('class','center_b_middle_right_a');
	}
	if (City.trim() == '') {
		isTrue = false;
		$("#signup-lab-City-title").show();
		$("#signup-lab-City").attr('class','center_f');
	}else{
		$("#signup-lab-City-title").hide();
		$("#signup-lab-City").attr('class','center_b_middle_right_a');
	}
	if (PostalCode.trim() == '') {
		isTrue = false;
		$("#signup-lab-PostalCode-title").show();
		$("#signup-lab-PostalCode").attr('class','center_f');
	}else{
		$("#signup-lab-PostalCode-title").hide();
		$("#signup-lab-PostalCode").attr('class','center_b_middle_right_a');
	}
	if (Telephone.trim() == '') {
		isTrue = false;
		$("#signup-lab-Telephone-title").show();
		$("#signup-lab-Telephone").attr('class','center_f');
	}else{
		$("#signup-lab-Telephone-title").hide();
		$("#signup-lab-Telephone").attr('class','center_b_middle_right_a');
	}
	if (Agree == undefined || Agree == '' || Agree == false) {
		isTrue = false;
		$("#signup-lab-account-isAgree-title").show();
		//$("#signup-lab-account-isAgree").attr('class','center_f');
	}else{
		$("#signup-lab-account-isAgree-title").hide();
		//$("#signup-lab-account-isAgree").attr('class','center_b_middle_right_a');
	}
	if (VerificationCode.trim() == '') {
		isTrue = false;
		 $("#signup-lab-account-VerificationCode-title").show();
		 $("#signup-lab-account-VerificationCode").attr('class','center_f');
	}else{
		 $("#signup-lab-account-VerificationCode-title").hide();
		 $("#signup-lab-account-VerificationCode").attr('class','center_b_middle_right_a');
	}
	if(isTrue){
		var params = {
				salutation:Salutation,
				ddxNewsletter:DDXNewsletter,
				type:AccountType,
				firstName:FirstName,
				lastName:LastName,
				email:Email,
				ConfirmEmail:ConfirmEmail,
				password:Password,
				ConfirmPassword:ConfirmPassword,
				
				address2:Address2,
				country:Country,
				state:State,
				labEmail:labEmail,
				timeZone:TimeZone,
				subdomain:Subdomain,
				services:JSON.stringify(Services),
				name:LabName,
				address:Address,
				city:City,
				zipCode:PostalCode,
				phoneNumber:Telephone,
				verifyCode:VerificationCode
		}
		return params;
	}else{
		$("#signUp-errors").show();
	}
	return isTrue;
}
