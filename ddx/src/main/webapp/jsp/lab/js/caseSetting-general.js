function listHoldType(pageNo) {
    var param = {
        offset: pageNo,
        search: $("#search-OnHold").val()
    }
    $$ajax({
        url: "casesAction/listOnHoldTypes.do",
        data: param,
        type: "POST",
        async: true,
        cache: false,
        global: false,
        dataType: "html",
        beforeSend: function(XMLHttpRequest) {
            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
        },
        success: function(data, textStatus) {
            $("#show-case-setting-content-div").html(data);
        },
        error: function(e) {
            alertError(e);
        },
        complete: function(msg) {
            $("#data-loading-div").hide();
        }
    });
}

function showAddHoldTypeDialog(id) {
	 $('#save-function').unbind('click');
    if (id != undefined && id != '') {
    	$('#save-function').click(function () {
    		updateonhold(id);
        });
        $$ajax({
            url: "labAction/getOnHoldType.do",
            data: {
                id: id
            },
            type: "POST",
            async: true,
            cache: false,
            global: false,
            dataType: "html",
            beforeSend: function(XMLHttpRequest) {
                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
            },
            success: function(data, textStatus) {
                var JSON = eval('(' + data + ')');
                $("#edit-lab-hold-id").val(JSON.id);
                $("#edit-lab-hold").val(JSON.name);

            },
            error: function(e) {
                alertError(e);
            },
            complete: function(msg) {
                $("#data-loading-div").hide();
            }
        });
        $("#add_lab_onhold").dialog({
            bgiframe: true,
            autoOpen: false,
            title: "修改搁置类型",
            width: 850,
            height: 400,
            modal: true,
            draggable: true,
            resizable: true,
            closeText: "close",
            buttons: {
                '取消': function() {
                    $("#add_lab_onhold").dialog('destroy');
                }
            }
        });
        $("#add_lab_onhold").dialog('open');
    } else {
        $("#edit-lab-hold").val('');
        $("#add_lab_onhold").dialog({
            bgiframe: true,
            autoOpen: false,
            title: "添加搁置类型",
            width: 850,
            height: 400,
            modal: true,
            draggable: true,
            resizable: true,
            closeText: "close",
            buttons: {
                '取消': function() {
                    $("#add_lab_onhold").dialog('destroy');
                }
            }
        });
        $("#add_lab_onhold").dialog('open');
        $('#save-function').click(function () {
    		updateonhold(id);
        });
    }
    
}


function listShipping(pageNo) {
    var param = {
        offset: pageNo,
        search: $("#search-Shipping").val()
    }
    $$ajax({
        url: "casesAction/listOnShipping.do",
        data: param,
        type: "POST",
        async: true,
        cache: false,
        global: false,
        dataType: "html",
        beforeSend: function(XMLHttpRequest) {
            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
        },
        success: function(data, textStatus) {
            $("#show-case-setting-content-div").html(data);
        },
        error: function(e) {
            alertError(e);
        },
        complete: function(msg) {
            $("#data-loading-div").hide();
        }
    });
}


function addOrUpdateShippingType() {
    var id = $("#add-shipping-id").val();
    var service = $("#add-shipping-service").val();
    var company = $("#add-shipping-company").val();
    var indays = $("#add-shipping-in-days").val();
    var outdays = $("#add-shipping-out-days").val();

    var isOk = true;
    if (service == undefined || service == '') {
        isOk = false;
        $("#add-shipping-service").attr("class", "Addonecuowu");
        $("#add-shipping-service-message").show();
    } else {
        $("#add-shipping-service").attr("class", "Personalize_b_middle_b");
        $("#add-shipping-service-message").hide();
    }
    if (company == undefined || company == '') {
        isOk = false;
        $("#add-shipping-company").attr("class", "Addonecuowu");
        $("#add-shipping-company-message").show();
    } else {
        $("#add-shipping-company").attr("class", "Personalize_b_middle_b");
        $("#add-shipping-company-message").hide();
    }
    if (!parseInt(indays) > 0) {
        isOk = false;
        $("#add-shipping-in-days").attr("class", "Addonecuowu");
        $("#add-shipping-in-days-message").show();
    } else {
        $("#add-shipping-in-days").attr("class", "Personalize_b_middle_b");
        $("#add-shipping-in-days-message").hide();
    }
    if (!parseInt(outdays) > 0) {
        isOk = false;
        $("#add-shipping-out-days").attr("class", "Addonecuowu");
        $("#add-shipping-out-days-message").show();
    } else {
        $("#add-shipping-out-days").attr("class", "Personalize_b_middle_b");
        $("#add-shipping-out-days-message").hide();
    }
    if (isOk) {
        var param = {
            id: id,
            service: service,
            company: company,
            inboundTransitDays: indays,
            outboundTransitDays: outdays
        }
        $$ajax({
            url: "labAction/addOrUpdateShippingType.do",
            data: param,
            type: "POST",
            async: true,
            cache: false,
            global: false,
            dataType: "html",
            beforeSend: function(XMLHttpRequest) {
                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
            },
            success: function(data, textStatus) {
                var JSON = eval('(' + data + ')');
                if (JSON.result != 'TRUE') {
                    alert(JSON.failReasons);
                } else {
                    alert(JSON.info);
                    $("#add-shipping-div").dialog('destroy');
                    query('shippingTypes');
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
}


function showAddShippingDialog(id) {
    if (id != undefined && id != '') {
        $$ajax({
            url: "labAction/getShiipingTypeById.do",
            data: {
                id: id
            },
            type: "POST",
            async: true,
            cache: false,
            global: false,
            dataType: "html",
            beforeSend: function(XMLHttpRequest) {
                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
            },
            success: function(data, textStatus) {
                var JSON = eval('(' + data + ')');
                $("#add-shipping-id").val(JSON.id);
                $("#add-shipping-service").val(JSON.service);
                $("#add-shipping-company").val(JSON.company);
                $("#add-shipping-in-days").val(JSON.inboundTransitDays);
                $("#add-shipping-out-days").val(JSON.outboundTransitDays);
            },
            error: function(e) {
                alertError(e);
            },
            complete: function(msg) {
                $("#data-loading-div").hide();
            }
        });
    }
    $("#add-shipping-div").dialog({
        bgiframe: true,
        autoOpen: false,
        title: "添加物流",
        width: 850,
        height: 430,
        modal: true,
        draggable: true,
        resizable: true,
        closeText: "close",
        buttons: {
            '取消': function() {
                $("#add-shipping-div").dialog('destroy');
            }
        }
    });
    $("#add-shipping-div").dialog('open');
}

function deleteShippingType(id) {
    if (!confirm("确认删除吗？")) {
        return;
    }
    $$ajax({
        url: "labAction/deleteShippingType.do",
        data: {
            id: id
        },
        type: "POST",
        async: true,
        cache: false,
        global: false,
        dataType: "html",
        beforeSend: function(XMLHttpRequest) {
            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
        },
        success: function(data, textStatus) {
            var JSON = eval('(' + data + ')');
            if (JSON.result != 'TRUE') {
                alert(JSON.failReasons);
            } else {
                alert(JSON.info);
                query('shippingTypes');
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


//5、调用后台，修改！
function updateonhold(id) {
	if(id != undefined && id != '')
	{
		 var result = verification(id);
		   
		    if (result != false) {
		        $$ajax({
		            url: "labAction/updateOnHold.do",
		            data: result,
		            type: "POST",
		            async: true,
		            cache: false,
		            global: false,
		            dataType: "html",
		            beforeSend: function(XMLHttpRequest) {
		                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		            },
		            success: function(data, textStatus) {
		                var JSON = eval('(' + data + ')');
		                if (JSON.result != 'TRUE') {
		                    alert(JSON.failReasons);
		                } else {
		                    alert('修改成功');
		                    $("#add_lab_onhold").dialog('destroy');
		                    query('onHoldTypes');
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
	}else{
		var result = verificationOnhold();
	    if (result != false) {
	        $$ajax({
	            url: "labAction/addOnHold.do",
	            data: result,
	            type: "POST",
	            async: true,
	            cache: false,
	            global: false,
	            dataType: "html",
	            beforeSend: function(XMLHttpRequest) {
	                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
	            },
	            success: function(data, textStatus) {
	                var JSON = eval('(' + data + ')');
	                if (JSON.result != 'TRUE') {
	                    alert(JSON.failReasons);
	                } else {
	                    alert('增加成功');
	                    $("#add_lab_onhold").dialog('destroy');
	                    query('onHoldTypes');
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
		
	}

}

function verification(id) {
	var id=id;
    var name = $("#edit-lab-hold").val();
    var isTrue = true;
    if (name == undefined || name.trim() == '') {
        $("#editErrorMessage").show();
        $("#edit-lab-hold").attr('class', 'Addonecuowu');
        isTrue = false;
    } else {
        $("editErrorMessage").hide();
        $("edit-lab-hold").attr('class', 'Personalize_b_middle_b');
    }
    if (isTrue) {
        $("#editErrorMessage").hide();
        var params = {
        		id:id,
            name: name
        }
        return params;
    } else {
        $("#editErrorMessage").show();
    }

    return isTrue;
}

function verificationOnhold() {
    var id = $("#edit-lab-hold-id").val();
    var name = $("#edit-lab-hold").val();
    var isTrue = true;
    if (name == undefined || name.trim() == '') {
        $("#editErrorMessage").show();
        $("#edit-hold-name").attr('class', 'Addonecuowu');
        isTrue = false;
    } else {
        $("#editErrorMessage").hide();
        $("#edit-hold-name").attr('class', 'Personalize_b_middle_b');
    }
    if (isTrue) {
        $("#editErrorMessage").hide();
        var params = {
            name: name
        }
        return params;
    } else {
        $("#editErrorMessage").show();
    }
    return isTrue;
}

function listRemake(pageNo) {
    var param = {
        offset: pageNo,
        search: $("#search-remakes").val()
    }
    $$ajax({
        url: "casesAction/listCaseRemake.do",
        data: param,
        type: "POST",
        async: true,
        cache: false,
        global: false,
        dataType: "html",
        beforeSend: function(XMLHttpRequest) {
            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
        },
        success: function(data, textStatus) {
            $("#show-case-setting-content-div").html(data);
        },
        error: function(e) {
            alertError(e);
        },
        complete: function(msg) {
            $("#data-loading-div").hide();
        }
    });
}

function showAddRemake(id) {
	 $('#edit-function').unbind('click');
    if (id != undefined && id != '') {
    	$('#edit-function').click(function () {
    		updateremake(id);
        });
        $$ajax({
            url: "labAction/getRemakesTypes.do",
            data: { id: id }, type: "POST", async: true, cache: false,global: false,dataType: "html",
            beforeSend: function(XMLHttpRequest) {
                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
            },
            success: function(data, textStatus) {
                var JSON = eval('(' + data + ')');
                $("#add-shipping-id").val(JSON.id);
                $("#edit-lab-remake").val(JSON.name);
            },
            error: function(e) {
                alertError(e);
            },
            complete: function(msg) {
                $("#data-loading-div").hide();
            }
        });
        $("#add-lab-remake").dialog({
            bgiframe: true,
            autoOpen: false,
            title: "修改返工类型",
            width: 850,
            height: 400,
            modal: true,
            draggable: true,
            resizable: true,
            closeText: "close",
            buttons: {
                '取消': function() {
                    $("#add-lab-remake").dialog('destroy');
                }
            }
        });
        $("#add-lab-remake").dialog('open');
        
    } else {
    	
        $("#edit-lab-remake").val('');
        $("#add-lab-remake").dialog({
            bgiframe: true,
            autoOpen: false,
            title: "增加返工类型",
            width: 850,
            height: 400,
            modal: true,
            draggable: true,
            resizable: true,
            closeText: "close",
            buttons: {
                '取消': function() {
                    $("#add-lab-remake").dialog('destroy');
                }
            }
        });
        $("#add-lab-remake").dialog('open');
        $('#edit-function').click(function () {
        	updateremake(id);
        });
        }
    	
}

function updateremake(id) {
	//id不为空是为修改
	if(id != undefined && id != '')
		{
		var result = verificationremake(id);
		if (result != false) {
	        $$ajax({
	            url: "labAction/updateRemake.do",
	            data: result,
	            type: "POST",
	            async: true,
	            cache: false,
	            global: false,
	            dataType: "html",
	            beforeSend: function(XMLHttpRequest) {
	                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
	            },
	            success: function(data, textStatus) {
	                var JSON = eval('(' + data + ')');
	                if (JSON.result != 'TRUE') {
	                    alert(JSON.failReasons);
	                } else {
	                    alert('修改成功');
	                    $("#add-lab-remake").dialog('destroy');
	                    query('remakeTypes');
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
		}
	else{
		var result = addverificationremake();
		if (result != false) {
	        $$ajax({
	            url: "labAction/addRemake.do",
	            data: result,
	            type: "POST",
	            async: true,
	            cache: false,
	            global: false,
	            dataType: "html",
	            beforeSend: function(XMLHttpRequest) {
	                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
	            },
	            success: function(data, textStatus) {
	                var JSON = eval('(' + data + ')');
	                if (JSON.result != 'TRUE') {
	                    alert(JSON.failReasons);
	                } else {
	                    alert('增加成功');
	                    $("#add-lab-remake").dialog('destroy');
	                    query('remakeTypes');
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
	}
    
}
//修改返工类型数据
function verificationremake(id) {
	var id=id;
    var name = $("#edit-lab-remake").val();
    var isTrue = true;
    if (name == undefined || name.trim() == '') {
        $("#edit-remake-error").show();
        $("#edit-lab-remake").attr('class', 'Addonecuowu');
        isTrue = false;
    } else {
        $("#edit-remake-error").hide();
        $("#edit-lab-remake").attr('class', 'Personalize_b_middle_b');
    }
    if (isTrue) {
        $("#edit-remake-error").hide();
        var params = {
        	id:id,
            name: name
        }
        return params;
    } else {
        $("#edit-remake-error").show();
    }
    return isTrue;
}
//增加返工类型数据
function addverificationremake() {
    var name = $("#edit-lab-remake").val();
    var isTrue = true;
    if (name == undefined || name.trim() == '') {
        $("#edit-remake-error").show();
        $("#edit-lab-remake").attr('class', 'Addonecuowu');
        isTrue = false;
    } else {
        $("#edit-remake-error").hide();
        $("#edit-lab-remake").attr('class', 'Personalize_b_middle_b');
    }
    if (isTrue) {
        $("#edit-remake-error").hide();
        var params = {
            name: name
        }
        return params;
    } else {
        $("#edit-remake-error").show();
    }
    return isTrue;
}

function deleteTerms() {
    if (document.getElementById("Ischecked").checked) {
        document.getElementById("terms_content").removeAttribute("disabled");
    } else {
        if (!confirm("你将禁用Rx条款并删掉改条款，确定吗？")) {
            var c = document.myform.mybox;
            c.checked = true;
            return;
        } else {
            $("#terms_content").val("");
            $("#terms_content").attr("disabled", "disabled");
        }
    }
}

function saveTerms() {
    var result = verifactionTerms();
	if(result!=false && result.id==''){
		$$ajax( {
			url : "labAction/addTerms.do",
			data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert(JSON.info);
					query('terms');
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
	else if (result != false) {
        $$ajax({
            url: "labAction/updateTerms.do",
            data: result,
            type: "POST",
            async: true,
            cache: false,
            global: false,
            dataType: "html",
            beforeSend: function(XMLHttpRequest) {
                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
            },
            success: function(data, textStatus) {
                var JSON = eval('(' + data + ')');
                if (JSON.result != 'TRUE') {
                    alert(JSON.failReasons);
                } else {
                    alert('修改成功');
                    query('terms');
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
}

function verifactionTerms() {
	var id = $("#lab_terms_id").val();
	var labid = $("#lab_terms_labid").val();
	var terms = document.getElementById("terms_content").value;
	var valid = $("#Ischecked").attr('checked') != undefined ? "true": "false";
	var isTrue = true;
	if (isTrue) {
	    $("#terms_error").hide();
	    var params = {
	        id: id,
	        labid: labid,
	        terms: terms,
	        valid: valid
	    }
	    return params;
	} else {
	    $("#terms_error").show();
	}
	return isTrue;
}


function showAddHoilDialog() {
	adopt();
    $("#temp-add-holi-hidden").val('');
    $("#temp-add-holi-hidden-div").dialog({
        bgiframe: true,
        autoOpen: false,
        title: "添加假期",
        width: 200,
        height: 150,
        modal: true,
        draggable: true,
        resizable: true,
        closeText: "close",
        buttons: {
            '取消': function() {
                $("#temp-add-holi-hidden-div").dialog('destroy');
            },
            '增加': function() {
                addHolidays($("#temp-add-holi-hidden").val());
                $("#temp-add-holi-hidden-div").dialog('destroy');
            }
        }
    });
    $("#temp-add-holi-hidden-div").dialog('open');
}


function addHolidays(val) {
    var isTrue = true;
    if (val == '') {
        isTrue = false;
    }
    if (isTrue) {
        $("#undefind-holiday").remove();
        var result = verifactionHoliday();
        var id = val;
        var str = '<tr id="' + val + '"><td>' + val + '</td><td><div class="General_SchedulingHolidays_middle_right" id="add-holidays-two">' + '<a href="javascript:void(0)" onclick="deleteHoliday(\'' + id + '\');" ></a></div></td></tr>';
        $("#add_holidays_table").append(str);
    }
    return isTrue;
}



function verifactionHoliday() {
    var id = $("#SchedulingId").val();
    var labid = $("#SchedulingLabId").val();
    var cutofftime = $("#cut_off_time").val();
    var caseturnaround = $("#case_turn_around").val();
    var pickupinstructions = $("#pick_up_instructions").val();
    var workdays = {
        monday: $("#monday").attr('checked') != undefined ? "true": "false",
        tuesday: $("#tuesday").attr('checked') != undefined ? "true": "false",
        wednesday: $("#wednesday").attr('checked') != undefined ? "true": "false",
        thursday: $("#thursday").attr('checked') != undefined ? "true": "false",
        friday: $("#friday").attr('checked') != undefined ? "true": "false",
        saturday: $("#saturday").attr('checked') != undefined ? "true": "false",
        sunday: $("#sunday").attr('checked') != undefined ? "true": "false"
    }
    var isTrue = true;
    var array = "";
    $("#add_holidays_table tr").each(function(i) {
        var a = $(this);
        for (var i = 0; i < a.length; i++) {
            array = array + a.eq(i).text().trim() + ",";
        }
    });
    var strArr = array.split(',');
    strArr.sort();
    var result = new Array();
    var tempStr = "";
    for (var i in strArr) {
        if (strArr[i] != tempStr) {
            result.push(strArr[i]);
            tempStr = strArr[i];
        } else {
            continue;
        }
    }
    var holidays = result.join(",");
    isTrue = true;
    if (isTrue) {
        var params = {
            id: id,
            labid: labid,
            cutofftime: cutofftime,
            caseturnaround: caseturnaround,
            pickupinstructions: pickupinstructions,
            workdays: JSON.stringify(workdays),
            holidays: holidays
        }
        return params;
    }
    return isTrue;
}


function saveSchedulingHolidays() {
	var result=verifactionHoliday();
	if(result!=false && result.id==''){
		$$ajax( {
			url : "labAction/addSchedulingHolida.do",
			data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert(JSON.info);
					query('schedulingAndHolidays');
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
	else if(result!=false){
			$$ajax( {
				url : "labAction/updateSchedulingHolida.do",
				data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				success : function(data, textStatus) {
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert(JSON.failReasons);
					} else {
						alert(JSON.info);
						query('schedulingAndHolidays');
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


function add() {
    var caseturnaround = $("#case_turn_around").val();
    var y = 0;
    y = parseInt(caseturnaround) + 1;
    $("#case_turn_around").val(y);
}
function cut() {
    var caseturnaround = $("#case_turn_around").val();
    var y = 0;
    y = parseInt(caseturnaround) - 1;
    if (y == 0 || y < 0) {
        $("#case_turn_around").val(0);
    } else {
        $("#case_turn_around").val(y);
    }
}


function deleteHold(id) {
    if (!confirm("确认删除吗？")) {
        return;
    }
    $$ajax({
        url: "labAction/deleteHoldType.do",
        data: {
            id: id
        },
        type: "POST",
        async: true,
        cache: false,
        global: false,
        dataType: "html",
        beforeSend: function(XMLHttpRequest) {
            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
        },
        success: function(data, textStatus) {
            var JSON = eval('(' + data + ')');
            if (JSON.result != 'TRUE') {
                alert(JSON.failReasons);
            } else {
                alert("删除成功");
                query('onHoldTypes');
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

function deleteRemake(id) {
    if (!confirm("确认删除吗？")) {
        return;
    }
    $$ajax({
        url: "labAction/deleteRemake.do",
        data: {
            id: id
        },
        type: "POST",
        async: true,
        cache: false,
        global: false,
        dataType: "html",
        beforeSend: function(XMLHttpRequest) {
            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
        },
        success: function(data, textStatus) {
            var JSON = eval('(' + data + ')');
            if (JSON.result != 'TRUE') {
                alert(JSON.failReasons);
            } else {
                alert("删除成功");
                query('remakeTypes');
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





function deleteHoliday(val) {
    $("#" + val).remove();
}
 
function adopt(){
	var result=verifactionHoliday();
	var t=result.workdays;
	var arraydate=new Array();
	var jj = eval('(' + t + ')');
	if(jj.monday=='false'){
		arraydate.push(1);
	}
	if(jj.tuesday=='false'){
		arraydate.push(2);
	}
	if(jj.wednesday=='false'){
		arraydate.push(3);
	}
	if(jj.thursday=='false'){
		arraydate.push(4);
	}
	if(jj.friday=='false'){
		arraydate.push(5);
	}
	if(jj.saturday=='false'){
		arraydate.push(6);
	}
	if(jj.sunday=='false'){
		arraydate.push(0);
	}
	arraydate.push(7);
	$("#temp-add-holi-hidden").attr("onclick","WdatePicker({el:'temp-add-holi-hidden',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d}',disabledDays:["+arraydate+"]})");
}

