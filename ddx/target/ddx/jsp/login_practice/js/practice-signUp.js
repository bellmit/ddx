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
 * 注册
 */
function signUpPractice() {
	
	var type = $("#type").val();
	// 验证账户表单
	var salutation = $("#salutation").val();
	var ddxNewsletter = $("#ddxNewsletter").attr('checked');
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var role =  $("#user_type").val();
	var email = $("#email").val();
	var confirmEmail = $("#confirmEmail").val();
	var password = $("#password").val();
	var confirmPassword = $("#confirmPassword").val();
	// 验证诊所表单
	var name = $("#name").val();
	var address = $("#address").val();
	var city = $("#city").val();
	var state = $("#state").val();
	var zipCode = $("#zipCode").val();
	var country = $("#country").val();
	var phoneNumber = $("#phoneNumber").val();
	var practice_email = $("#practice_email").val();
	var address2 = $("#address2").val();
	var agree = $("#agree").attr('checked');
	var verificationCode = $("#verificationCode").val();
	
	var flag = true;
	
	//姓
	if(firstName.trim() == ''){
		$('#firstName_info').show();
		$('#firstName').attr("class","center_f");
		return;
	}else{
		$('#firstName_info').hide();
		$('#firstName').attr("class","center_b_middle_right_a");
	}
	//名
	if(lastName.trim() == ''){
		$('#lastName_info').show();
		$('#lastName').attr("class","center_f");
		return;
	}else{
		$('#lastName_info').hide();
		$('#lastName').attr("class","center_b_middle_right_a");
	}
	//角色
	if(role.trim() == ''){
		$('#role_info').show();
		$('#role').attr("class","center_f");
		return;
	}else{
		$('#role_info').hide();
		$('#role').attr("class","center_b_middle_right_a");
	}
	//邮箱
	if(email.trim() == ''){
		$('#email_info').show();
		$('#email').attr("class","center_f");
		$('#email_info').find('i').html('请输入您的邮箱');
		if(confirmEmail.trim() != ''){
			$('#confirmEmail_info').hide();
			$('#confirmEmail').attr("class","center_b_middle_right_a");
			$('#confirmEmail').val('');
		}
		return;
	}else{
		if(!checkMail(email)){
			$('#email').attr("class","center_f");
			$('#email_info').find('i').html('请输入有效的邮箱').end().show();
			return;
		}else{
			$('#email_info').hide();
			$('#email').attr("class","center_b_middle_right_a");
			if(confirmEmail != email){
				$('#confirmEmail').attr("class","center_f");
				$('#confirmEmail_info').find('i').html('邮箱不一致，请重新输入').end().show();
				return;
			}else{
				$('#confirmEmail_info').hide();
				$('#confirmEmail').attr("class","center_b_middle_right_a");
			}
		}
	}
	//密码
	if(password.trim() == ''){
		$('#password_info').show();
		$('#password').attr("class","center_f");
		return;
	}else{
		$('#password_info').hide();
		$('#password').attr("class","center_b_middle_right_a");
		if(confirmPassword.trim() != password.trim()){
			$('#confirmPassword_info').show();
			$('#confirmPassword').attr("class","center_f");
			return;
		}else{
			$('#confirmPassword_info').hide();
			$('#confirmPassword').attr("class","center_b_middle_right_a");
		}
		
	}

	//诊所名称
	if(name.trim() == ''){
		$('#name_info').show();
		$('#name').attr("class","center_f");
		return;
	}else{
		$('#name_info').hide();
		$('#name').attr("class","center_b_middle_right_a");
	}
	//地址
	if(address.trim() == ''){
		$('#address_info').show();
		$('#address').attr("class","center_f");
		return;
	}else{
		$('#address_info').hide();
		$('#address').attr("class","center_b_middle_right_a");
	}
	//国家
	if(country.trim() == ''){
		$('#country_info').show();
		$('#country').attr("class","center_f");
		return;
	}else{
		$('#country_info').hide();
		$('#country').attr("class","center_b_middle_right_a");
	}
	//州/省
	if(state.trim() == ''){
		$('#state_info').show();
		$('#state').attr("class","center_f");
		return;
	}else{
		$('#state_info').hide();
		$('#state').attr("class","center_b_middle_right_a");
	}
	//城市
	if(city.trim() == ''){
		$('#city_info').show();
		$('#city').attr("class","center_f");
		return;
	}else{
		$('#city_info').hide();
		$('#city').attr("class","center_b_middle_right_a");
	}
	//邮编
	if(zipCode.trim() == ''){
		$('#zipCode_info').show();
		$('#zipCode').attr("class","center_f");
		return;
	}else{
		$('#zipCode_info').hide();
		$('#zipCode').attr("class","center_b_middle_right_a");
	}
	//电话
	if(phoneNumber.trim() == ''){
		$('#phoneNumber_info').show();
		$('#phoneNumber').attr("class","center_f");
		return;
	}else{
		$('#phoneNumber_info').hide();
		$('#phoneNumber').attr("class","center_b_middle_right_a");
	}
	//我同意
	if(agree != 'checked'){
		$('#agree_info').show();
		$('#agree').attr("class","center_f");
		return;
	}else{
		$('#agree_info').hide();
		$('#agree').attr("class","center_b_middle_right_a");
	}
	//验证码
	if(verificationCode == ''){
		$('#verificationCode_info').show();
		$('#verificationCode').attr("class","center_f");
		return;
	}else{
		$('#verificationCode_info').hide();
		$('#verificationCode').attr("class","center_b_middle_right_a");
	}
	
	var params = {
			type:type,
			salutation:salutation,
			ddxNewsletter:ddxNewsletter,
			firstName:firstName,
			lastName:lastName,
			role:role,
			email:email,
			password:password,
			name:name,
			address:address,
			address2:address2,
			country:country,
			state:state,
			city:city,
			zipCode:zipCode,
			country:country,
			phoneNumber:phoneNumber,
			practice_email:practice_email,
			verificationCode:verificationCode
	}
	
	
	
	if(flag!=false && flag != undefined){
		$$ajax( {
			url : "userAction/signUpForPractice.do",
			data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					if(JSON.failReasons=='error_verify_code'){
						$('#verificationCode_info').show();
						$('#verificationCode_info').find('i').eq(0).html('请输入正确的验证码');
						$('#verificationCode').attr("class","center_f");
						$('#verificationCode').focus();
						$('#verificationCode').val('');
					}else if(JSON.failReasons=='duplicate_email'){
						$('#email_info').show();
						$('#email_info').find('i').eq(0).html("邮箱重复！");
					}else{
						alert(JSON.failReasons);
					}
				} else {
					$("#sigupLoginForm-username").val(params.email);
					$("#sigupLoginForm-password").val(params.password);
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
}

/**
 * 检测验证码是否正确
 */
function chkCode(){
	var flag = true;
	var verifyCode = $("#verificationCode").val();
	if(verifyCode != '' && verifyCode.length == 5){
		$.ajax({
			url: webContext + '/kaptchaAction/chkVerify.do',
			type: 'POST',
			data:{verifyCode:verifyCode},
			dataType: 'text',
			cache:false,
			error: function(){
				flag = false;
			},
			success: function(result){
				if(result == 'true'){
					$('#verificationCode_info').hide();
					$('#verificationCode').attr("class","center_b_middle_right_a");
					$('#sign_action').attr('disabled','');
				}else{
					flag = false;
					$('#verificationCode_info').show();
					$('#verificationCode_info').find('i').eq(0).html('请输入正确的验证码');
					$('#verificationCode').attr("class","center_f");
					$('#sign_action').attr('disabled','disabled');
					$('#verificationCode').focus();
				}
			}

			});
	}else if(verifyCode.length > 5){
		$('#verificationCode_info').show();
		$('#verificationCode_info').find('i').eq(0).html('请输入正确的验证码');
		$('#sign_action').attr('disabled','disabled');
		$('#verificationCode').focus();
		flag = false;
	}else{
		flag = false;
	}
	return flag;
}

/*
 * 验证邮箱唯一性
 */
function testEmail(){
	var email = $('#email').val();
	if(email != ''){
		var result = {email:email};
		$$ajax( {
			url : "userAction/isExistEmail.do",
			data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的检测数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON == true) {
					$('#email_info').show();
					$('#email_info').find('i').eq(0).html("邮箱重复！");
					//$('#sign_action').attr('disabled','disabled');
					//$('#email').focus();
				} else{
					$('#email_info').find('i').eq(0).html("");
					//$('#sign_action').attr('disabled','');
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

function checkMail(mail) {
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (filter.test(mail)) return true;
    else {
        return false;
    }
}