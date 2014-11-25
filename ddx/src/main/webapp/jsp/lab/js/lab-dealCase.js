$(function(){
	
	//页面操作元素显隐
	var isTryIn = $('#isTryIn').val();
	var status = $('#status').val();
	var arrived = $('#arrived').val();
	var shipped = $('#shipped').val();
	var caseId = $('#caseId').val();
	if(status == 'CANCEL'){
		$('#lab_case_details_content').html('<p><h2>订单 #'+ caseId +'</h3><p><p><strong>此订单已取消！</strong></p>');
		return;
	}

	if(status == 'OPEN'){
		if(isTryIn == 'Y' && arrived == 1){
			$('#return_tryin_li').show();
		}
		if(arrived == 0){
			$('#return_tryin_li').hide();
			$('#arrive_case_li').show();
		}else{
			$('#close_li').show();
			$('#add_coupon_li').show();
		}
		
		//标记为试戴订单
		if(isTryIn != 'Y'){
			$('#mark_as_tryin_li').show();
		}else{
			$('#mark_as_tryin_li').hide();
		}
		
		if(shipped == 1){
			$('#shipping_li').show();
		}
	}
	
	if(status == 'CLOSE'){
		$('#cancelBtn').hide();
		$('#return_tryin_li').hide();
		$('#outsource_li').hide();
		if(shipped == 1){
			$('#shipping_li').show();
		}
		$('#work_ticket_li').hide();
		$('#add_coupon_li').show();
	}
	
	
	$('#lab_patient_appt_action').click(function(){
		$("#set_patient_appointment_div").dialog({
				title: '患者预约',
		        modal: true,
		        width:507,
		        height:359,
		        buttons: {
		            "取消": function() {
		                $( this ).dialog( "close" );
		            },
		            "保存": function() {
		            	lab_applyPatientAppointment();
		            }
		        }
    	});
	});
	
	
	$('#arrive_case_action').click(function(){
		$("#arrive_case_dialog").dialog({
				title: '订单抵达',
		        modal: true,
		        width:400,
		        height:280,
		        buttons: {
		            "取消": function() {
		                $( this ).dialog( "close" );
		            },
		            "保存": function() {
		            	applyCaseArrive();
		            }
		        }
    	});
	});
	
	$('#mark_as_tryin_li_action').click(function(){
		var caseId = $('#caseId').val();
		var url = "casesAction/lab/markTryIn.do";
		var params = {
				caseId:caseId
		};
		sendDataForLab(url, params, 'markTryIn');
	});
	
	$('#reschedule_case_action').click(function(){
		$$ajax( {
			url : "casesAction/lab/cases/getRescheduleDialog.do",
			data : null,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find("#msg").html('正在加载数据...').end().show();
			},
			success : function(data, textStatus) {
				$('#reschedule_case_dialog').html(data);
				$("#reschedule_case_dialog").dialog({
					title: '重排订单',
			        modal: true,
			        width:450,
			        height:500,
			        buttons: {
			            "取消": function() {
			                $( this ).dialog( "close" );
			            },
			            "提交": function() {
			            	applyRescheduleCase();
			            }
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
		
		
	});
	
	$('#return_tryin_action').click(function () {
	    var url = 'casesAction/lab/cases/getProcedureList.do?caseId=' + $('#caseId').val();
	 
	    $$ajax({
	        url: url,
	        data: null,
	        type: "POST",
	        async: true,
	        cache: false,
	        global: false,
	        dataType: "html",
	        beforeSend: function (XMLHttpRequest) {
	            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
	        },
	        success: function (data, textStatus) {
	            $("#return_tryin_dialog").html(data);
	            $("#return_tryin_dialog").dialog({
	                title: '返回诊所试戴',
	                resizable: false,
	                modal: true,
	                height: 400,
	                width: 720,
	                buttons: {
	                    "取消": function () {
	                        $(this).dialog("close");
	                    },
	                    "保存": function () {
	                        var index = "";
	                        //(window.frames["return-tryin-iframe"].document)
	                        $("#return_tryin_dialog").find("input[name='checkedTryIn']:checked").each(function (j) {
	                            index += $(this).attr("index") + ",";
	                        });
	                        if (index == null || index.trim().length == 0) {
	                            alert("请选择工序");
	                            return;
	                        }
	                        $$ajax({
	                            url: "casesAction/lab/cases/updateCaseTryIn.do",
	                            data: {
	                                indexs: index,
	                                casesId: $("#tryInCaseId").val()
	                            },
	                            type: "POST",
	                            async: true,
	                            cache: false,
	                            global: false,
	                            dataType: "html",
	                            beforeSend: function (XMLHttpRequest) {
	                                $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
	                            },
	                            success: function (data, textStatus) {
	                                var JSON = eval('(' + data + ')');
	                                if (JSON.result != 'TRUE') {
	                                    alert(JSON.failReasons);
	                                } else {
	                                    alert(JSON.info);
	                                    window.location.reload();
	                                }
	                            },
	                            error: function (e) {
	                                alertError(e);
	                            },
	                            complete: function (msg) {
	                                $("#data-loading-div").hide();
	                            }
	                        });
	                    }
	                }
	            });
	        },
	        error: function (e) {
	            alertError(e);
	        },
	        complete: function (msg) {
	            $("#data-loading-div").hide();
	        }
	    });
	 
	});
	

	$('#add_note_action').click(function(){
		var url = webContext + '/casesAction/lab/cases/gotoNote.do?caseId='+$('#caseId').val();
		/*$("#case_note_dialog").html('<iframe name="note_iframe" style="border: 0px;width:100%;height:100%;" src="' + url + '"></iframe>').dialog({
			title: '订单笔记',
	        width:700,
	        height:400,
	        modal: false,
	        buttons: {
	            "取消": function() {
	                $( this ).dialog( "close" );
	            },
	            "保存": function() {
	            	$(window.frames["note_iframe"].document).find("input#caseId").trigger("click");
	            }
	            	
	            	
	        }
		});*/
		$("#case_note_dialog").dialog({
			title: '订单备注',
	        width:700,
	        height:400,
	        modal: false,
	        buttons: {
	            "取消": function() {
	                $( this ).dialog( "close" );
	            },
	            "保存": function(event) {
	            	var content = CKEDITOR.instances.case_note.getData();
	            	if (content == "") {
	    				$('#case_note_info').show();
	    				$('#case_note_info').find('i').eq(0).html('内容不能为空');
	    				return;
	    			}else if(content.length > 300){
	    				$('#case_note_info').show();
	    				$('#case_note_info').find('i').eq(0).html('字数过多');
	    				return;
	    			}else{
	    				$('#case_note_info').hide();
	    			}
	    			
	            	$$ajax( {
						url : "casesAction/cases/addNote.do",
						data : {caseId:$('#caseId').val(),caseNote:content},type : "POST",async : true,cache : false,global : false,dataType : "html",
						beforeSend : function(XMLHttpRequest) {
							$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
						},
						success : function(data, textStatus) {
							var JSON = eval('(' + data + ')');
							if (JSON.flag != 'success') {
								alert("提交失败");
							} else {
								alert("提交成功");
								$("#case_note_dialog").dialog("destroy");
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
	        },
	        open:function(){
	        	var editor = null;
	        	editor = CKEDITOR.replace('case_note');
	        	editor.updateElement();
	        }
		});
	});

	$('#change_status_action,#change_status').click(function(){
		$("#onhold_dialog").dialog({
	    	title:'暂停订单',
	        resizable: false,
	        modal: true,
	        height:400,
	        width:600,
	        buttons: {
	            "取消": function() {
	                $(this).dialog("destroy");
	            },
	            "提交":function(){
	            	 updateOnHoldStatus();
	            }
	        }
	    });
	});

	$('#outsource_action').click(function(){
		$("#outsource_dialog").dialog({
	    	title:'外包订单',
	        resizable: false,
	        modal: true,
	        height:200,
	        width:400,
	        buttons: {
	            "取消": function() {
	                $(this).dialog("close");
	            },
	            "提交":function(){
	            	if($('#labId').val()!=''){
	            		document.forwardForm.submit();	            		
	            	}else{
	            		alert('请选择具体的技工间再试！');
	            	}
	            }
	        }
	    });
	});
	
	$('#close_action').click(function(){
		$("#close_dialog").dialog({
	    	title:'关闭订单',
	        resizable: false,
	        modal: true,
	        height:400,
	        width:500,
	        buttons: {
	            "取消": function() {
	                $(this).dialog("close");
	            },
	            "提交":function(){
	            	applyCaseClose();
	            }
	        }
	    });
	});
	
	$('#shipping_action').click(function(){
		$("#close_dialog").dialog({
	    	title:'shipping',
	        resizable: false,
	        modal: true,
	        height:400,
	        width:500,
	        buttons: {
	            "取消": function() {
	                $(this).dialog("close");
	            },
	            "提交":function(){
	            	applyCaseClose();
	            }
	        }
	    });
	});
	
	//打印工作单
	$('#work_ticket_action').click(function(){
		window.location.href = webContext + '/casesAction/lab/case/workTicket.do?caseId=' + $('#caseId').val();
	});
	
	//议价
	$('#bargain_action').click(function(event){
		var caseId = $('#caseId').val();
		//动态获取
		$$ajax( {
			url : "casesAction/goBargain.do",
			data : {caseId:caseId},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
	                $('#bargain_dialog').html(data);
	                $('#bargain_dialog').dialog({
	        			title:'议价',
	        			resizable:false,
	        			modal:true,
	        			height:400,
	        			width:800
	        		});
	            	
			},
			error : function(e) {
				alertError(e);
			},
			complete : function(msg) {
				$("#data-loading-div").hide();
			}
		});
		
	});
	
	//弹出优惠券对话框
	$('#add_coupon_action').click(function(){
		$('#add_coupons_dialog').dialog({
			title:'使用优惠券',
	        resizable: false,
	        modal: true,
	        height:400,
	        width:500,
	        buttons: {
	            "取消": function() {
	                $(this).dialog("close");
	            },
	            "提交":function(){
	            	makeCouponForCases();
	            }
	        }
		});
	});
	
	
	$(".preview").click(function(event){
        event.preventDefault();
        var $this = $(this),
            src = $this.data('src'),
            $dialog = $('<div style="overflow: scroll"></div>'),
            image = new Image(),
            height = parseInt($(window).height() * 0.9),
            width = parseInt($(window).width() * 0.9),
            paddingH = 40,
            paddingV = 60;
        
        if (height < 350) {
            height = 350;
        }
        
        if (width < 700) {
            width = 700;
        }
        
        image.onload = function() {
            $dialog.empty();
            
            if (this.width > (width - paddingH)) {
                var multiplier = (width - paddingH) / this.width;
                
                this.width = Math.round(this.width * multiplier);
                this.height = Math.round(this.height * multiplier);
            }
            
            if (this.height > (height - paddingV)) {
                var multiplier = (height - paddingV) / this.height;
                
                this.width = Math.round(this.width * multiplier);
                this.height = Math.round(this.height * multiplier);
            }
            
            $dialog.dialog('option', 'height', Math.round(this.height + paddingV));
            $dialog.dialog('option', 'width', Math.round(this.width + paddingH));
            $dialog.dialog('option', 'position', 'center');
            
            $dialog.html(this);
        }
        
        $dialog.html('<p>Loading...</p>')
            .dialog({
                autoOpen: true,
                modal: true,
                title: $this.data('title'),
                open: function() {
					var link = '';
                    image.src = link + src;
                }
            });
        $dialog.dialog('open');
    });
	
	
	$("#attach_files_action").click(function(event){
   	 	event.preventDefault();
		file_uploader();
     });
    

});

var fileUploaderWindow = null;
function file_uploader(inline) {
	inline = typeof inline !== 'undefined' ? inline : false;

	if (!inline) {
	
	    if (fileUploaderWindow && !fileUploaderWindow.closed && fileUploaderWindow.location) {
	        if (window.focus) {
	            fileUploaderWindow.focus()
	        }
	    }else {
	        var width = 500;
	        var height = 375;
	        var top = screen.height;
	        var left = screen.width;
	        if (top < height) {
	            top = 0;
	        } else {
	            top = (top - height) / 2;
	        }
	        if (left < width) {
	            left = 0;
	        } else {
	            left = (left - width) / 2;
	        }
	        var caseId = $('#caseId').val();
	        fileUploaderWindow = window.open(webContext + '/casesAction/gotoUpload.do?caseId='+caseId, '', 'location=no,menubar=no,toolbar=no,directories=no,personalbar=no,status=no,scrollbars=yes,top=' + top + ',left=' + left + ',width=' + width + ',height=' + height);
	    }
	} else {
	    window.location = webContext + '/casesAction/gotoUpload.do?caseId='+caseId;
	}
	
}

/**
 * 专用于技工间处理订单
 */

/**
 * 通用方法
 * @param url
 * @param params
 * @param genre
 */
function sendDataForLab(url, params ,genre){
	$$ajax( {
		url : url,
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			var genre = JSON.genre;
			var flag = JSON.flag;
			var obj = JSON.obj;
			//对各种返回的处理
			if(genre == 'cancel'){
				if(flag == 'success'){
					alert('取消成功！')
					document.location.href = webContext + '/labAction/query.do?method=main';
				}else{
					alert('取消失败！');
				}
			}else if(genre == 'markTryIn'){
				if(flag == 'success'){
					alert('成功标记订单为试戴');
					window.location.reload();
				}else{
					alert('标记失败');
				}
				
			}else{
				
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

//技工间-取消订单
function cancel(){
	var caseId = $('#caseId').val();
	if(window.confirm("确定取消订单 #"+caseId)){
		var url = "casesAction/lab/cancel.do";
		var params = {
				caseId:caseId
		};
		sendDataForLab(url, params, 'cancel');
	}
}

/**
 * 患者预约
 */
function lab_applyPatientAppointment(){
	var patient_appointment_date = $('#patient_appointment_date').val();
	var patient_appointment_time = $('#patient_appointment_time').val();
	
	//日期
	if(patient_appointment_date == ''){
		$('#patient_appointment_date_info').show();
		return;
	}else{
		$('#patient_appointment_date_info').hide();
	}
	//时间
	if(patient_appointment_time == ''){
		$('#patient_appointment_time_info').show();
		return;
	}else{
		$('#patient_appointment_time_info').hide();
	}
	var url = webContext + "/casesAction/applyPatientAppointment.do";
	var params = {
			caseId:$('#caseId').val(),
			patAppDate:(patient_appointment_date + ' ' + patient_appointment_time)
	}
	 $.post(
			 url,
			 params,
			 function(result){
				 var JSON = eval('(' + result + ')');
				 var flag = JSON.flag;
				 if(flag == 'success'){
					 window.location.reload();			 
				 }
	});
}

/**
 * 订单抵达 
 */
function applyCaseArrive(){
	var arrive_date = $('#arrive_date').val();
	var arrive_time = $('#arrive_time').val();
	
	//日期
	if(arrive_date == ''){
		$('#arrive_date_info').show();
		return;
	}else{
		$('#arrive_date_info').hide();
	}
	//时间
	if(arrive_time == ''){
		$('#arrive_time_info').show();
		return;
	}else{
		$('#arrive_time_info').hide();
	}
	
	var url = webContext + "/casesAction/applyCaseArrive.do";
	var params = {
			caseId:$('#caseId').val(),
			arriveDate:(arrive_date + ' ' + arrive_time)
	}
	 $.post(
			 url,
			 params,
			 function(result){
				 var JSON = eval('(' + result + ')');
				 var flag = JSON.flag;
				 if(flag == 'success'){
					 window.location.reload();			 
				 }
	});
}

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
 * 获取诊所信息 
 */
function getPractice(){
	return;
	var url = "${pageContext.request.contextPath}/userAction/getUser.do";
	var practiceId = $('#practiceId').val();
	var partnerLabId = $('#partnerLabId').val();
	var userId =  practiceId== '' ? partnerLabId :practiceId;
	url += "?userId=" + userId;
	window.location.href = url;
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
 * on hold status change
 */
function changeHold(){
	var val = $('#onhold').val();
	if(val=='_OTHER_'){
		$('#custom_onhold').parent().css('display','block');
	}else{
		$('#custom_onhold').parent().css('display','none');
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

function showAttrX(id){
	var flag = $("#"+id+"-a-x").attr("flag");
	if(flag=='show'){
		$("#"+id+"-a-x").html("[+]");
		$("#"+id+"-tr-x").hide(500);
		$("#"+id+"-a-x").attr("flag","hide");
	}else{
		$("#"+id+"-a-x").html("[-]");
		$("#"+id+"-tr-x").show(500);
		$("#"+id+"-a-x").attr("flag","show");
	}
}

/**
 * 更新on hold状态
 */
function updateOnHoldStatus(){
	var url = webContext + '/casesAction/lab/cases/onHold.do';
	var onHoldStatus = $('#onhold').val();
	var customStatus = $('#custom_onhold').val();
	
	
	if(onHoldStatus == '_OTHER_'){
		if(customStatus == ''){
			$('#customStatus_info').show();
			return;
		}else{
			$('#customStatus_info').hide();
		}
	}
	var params = {
			caseId:$('#caseId').val(),
			onHoldStatus:onHoldStatus,
			customStatus:customStatus
	};
	$.post(
		 url,
		 params,
		 function(result){
		 if(result == 'success'){
			 window.location.reload();    			 
		 }
	});
}

/**
 * 关闭订单
 */
function applyCaseClose(){
	var url = webContext +　'/casesAction/lab/cases/close.do'
	var shipperId = $('#shipper').val();
	var waybillNumber = $('#trackNo').val();
	
	//货运商
	if(shipperId == ''){
		$('#shipper_info').show();
		return;
	}else{
		$('#shipper_info').hide();
	}
	//货运单号
	if(waybillNumber == ''){
		$('#trackNo_info').show();
		return;
	}else{
		$('#trackNo_info').hide();
	}
	
	var params = {
		 caseId:$('#caseId').val(),
		 shipperId:shipperId,
		 waybillNumber:waybillNumber
	 }
	$.post(
		 url,
		 params,
		 function(result){
		 if(result == 'success'){
			 window.location.reload();    			 
		 }
	});
}
/**
 * 删除订单工序
 */
function deleteCaseProcedure(index,caseId){

	$$ajax( {
		url : "casesAction/deleteCaseProcedure.do",
		data : {index:index,caseId:caseId},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
            var JSON = eval('(' + data + ')');
            if (JSON.result != 'TRUE') {
                alert(JSON.failReasons);
            } else {
                alert('删除成功');
                $("#"+index+"-tr-head").remove();
                $("#"+index+"-tr").remove();
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
 * 修改订单工序
 */
function loadCaseProcedure(index,procedure_id,caseId,procedure_name){
	$$ajax( {
		url : "casesAction/getAttributes.do",
		data : {id:procedure_id},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var addHtml = "<div><table style=\"margin-left: 30px;\"><tr><td>工序名称：</td><td><select disabled=\"disabled\"><option>"+procedure_name+"</option></select></td></tr></table></div><div>&nbsp;</div>";
			$("#update-case-pro-attributes").html(addHtml+data);
			$$ajax( {
				url : "casesAction/loadCaseProcedure.do",
				data : {index:index,caseId:caseId},type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				success : function(data, textStatus) {
					var json = eval(data);
					$.each(json, function (index, item) {
						if(json == undefined){
							return;
						} 
						var id = json[index].id;
						var	value = json[index].value;
						$("#"+id).val(value);
					 });
					$("#update-case-pro-attributes").dialog( {
						bgiframe : true,
						autoOpen : false,
						title : "修改订单工序",
						width : 850,
						height : 478,
						modal : true,
						draggable : true,
						resizable : true,
						closeText : "close",
						buttons : {
							'取消' : function() {
								$("#update-case-pro-attributes").dialog('destroy');
							},
							'提交' : function() {
								addCaseProcedure('update',caseId,'update-case-pro-attributes',index,procedure_id);
							}
						}
					});
					$("#update-case-pro-attributes").dialog('open');
				},
				error : function(e) {
					alertError(e);
				},
				complete : function(msg) {
					$("#data-loading-div").hide();
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

function applyRescheduleCase(){
	isOk = true;
	var arr = new Array();
	var casesid = $('#caseId').val();
	var procedure_id = $("#add-pro-id-select").val();
	var procedure_name = $("#add-pro-id-select").find("option:selected").text();
	
	//若为工序新增，则校验是否选择工序、交付日期
	var delivery_date = $('#delivery_date').val();
	
	if(delivery_date == undefined || delivery_date == ''){
		$('#delivery_date_info').show();
		return;
	}else{
		$('#delivery_date_info').hide();
	}
	
	if(procedure_id==undefined || procedure_id==''){
		$('#select_procedure_info').show();
		return;
	}else{
		$('#select_procedure_info').hide();
	}
	
	//获取工序对应属性值
	arr = getProAttr(procedure_id,procedure_name,'reschedule-procedure-div');
	
	if(isOk){
		var params = {
				caseId:casesid,
				procedures:JSON.stringify(arr),
				deliveryDate:delivery_date
		}
		var url = "applyRescheduleCase.do";
		$$ajax( {
			url : "casesAction/"+url,
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

function getProAttr(procedure_id,procedure_name,attr_div_id){
	var arr = new Array();
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
	return arr;
}

//查询订单可用的优惠券
function loadCaseCoupon(caseId){
	var param={
		caseId:caseId
	}
	$$ajax( {
		url : "casesAction/loadCaseCoupon.do",
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

function addCoupontToCases(id,code,proceduresid){
	$('#addCoupon').dialog('destroy');
	$("#coupon_code").val(code);
	checkCaseCoupontValid(code, proceduresid,$("#labId").val());
}
function applyCoupon(requestLabId){
	var code = $("#coupon_code").val();
	checkCaseCoupontValid(code, null,requestLabId);
}
//检查是否有效
function checkCaseCoupontValid(code,proceduresid,requestLabId){
	var isValid = false;
	var selectProceduresid = "";
	var list = $('#procedureIds').val().split(',');
	for(var i=0;i<list.length;i++){
		var procedure_id = list[i];
		selectProceduresid+=procedure_id+",";
		if(proceduresid==procedure_id){
			isValid = true;
		}
	}
	if(proceduresid!=undefined && proceduresid.trim()!='' && !isValid){
		$("#isValid-msg-div").html("优惠券不能使用，请核对优惠券指定的工序").css("color","red");
	}else{
		$$ajax( {
			url : "casesAction/checkCaseCouponValid.do",
			data : {caseId:$('#caseId').val(),code:code,proceduresId:selectProceduresid,requestLabId:requestLabId},type : "POST",async : true,cache : false,global : false,dataType : "html",
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

function removeCaseCoupon(){
	$("#coupon_code").val('');
	$("#isValid-msg-div").val('');
	$("#coupon_error").hide();
}

function makeCouponForCases(){
	var caseId = $('#caseId').val();
	var couponCode = $('#coupon_code').val();
	if(couponCode!=undefined && couponCode.trim()!=''){
			//验证优惠券
			var selectProceduresid = "";
			var list = $('#procedureIds').val().split(',');
            for (var i = 0; i < list.length; i++) {
                var procedure_id = list[i];
                selectProceduresid += procedure_id + ",";
            }
			$$ajax( {
				url : "casesAction/checkCaseCouponValid.do",
				data : {caseId:caseId,code:couponCode,proceduresId:selectProceduresid,requestLabId:$('#labId').val()},type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				success : function(data, textStatus) {
					var retJsonInfo = eval('(' + data + ')');
					if (retJsonInfo.result != 'TRUE') {
						$("#isValid-msg-div").html(retJsonInfo.failReasons).css("color","red");
						$("#coupon_error").show();
					} else {
						updateCouponDataToCases(caseId,couponCode);
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
			$("#isValid-msg-div").html('请选择优惠券').css("color","red");
		}
}

function updateCouponDataToCases(caseId,code){
    $$ajax({
        url: "casesAction/updateCouponDataToCases.do",
        data: {
            caseId: caseId,
            code: code
        },
        type: "POST",
        async: true,
        cache: false,
        global: false,
        dataType: "html",
        beforeSend: function(XMLHttpRequest){
            $("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
        },
        success: function(data, textStatus){
            var retJsonInfo = eval('(' + data + ')');
            if (retJsonInfo.result != 'TRUE') {
                $("#isValid-msg-div").html(retJsonInfo.failReasons).css("color", "red");
                $("#coupon_error").show();
            }
            else {
                alert('成功使用了优惠券');
                window.location.href = window.location.href;
            }
        },
        error: function(e){
            alertError(e);
        },
        complete: function(msg){
            $("#data-loading-div").hide();
        }
    });
}

//提交打印工作单选项
function submitWorkTicketOption() {
    var caseId = $('#caseId').val();
    var option_patient_info = $('#option_patient_info').attr('checked') != undefined ? '1' : '0';
    var option_doctor_info = $('#option_doctor_info').attr('checked') != undefined ? '1' : '0';
 
    var option_scheduling = $('#option_scheduling').attr('checked') != undefined ? '1' : '0';
    var option_note = $('#option_note').attr('checked') != undefined ? '1' : '0';
    var option_files = $('#option_files').attr('checked') != undefined ? '1' : '0';
    var option_procedures = $('#option_procedures').attr('checked') != undefined ? '1' : '0';
 
    window.location.href = webContext + '/casesAction/lab/case/print.do?caseId=' + caseId + '&option_patient_info=' +option_patient_info + 
		'&option_doctor_info=' + option_doctor_info + '&option_scheduling=' + option_scheduling + '&option_note=' + option_note +
        '&option_files=' + option_files + '&option_procedures=' + option_procedures;
 
}
