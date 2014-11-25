function listCoupons(pageNo){
	var param = {offset:pageNo,search:$("#search-coupons").val()}
	$$ajax( {
		url : "casesAction/listCoupons.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
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
function stamp(){
	var param = {}
	$$ajax( {
		url : "casesAction/stamp.do",
		data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			 var path = '/coupons/'+data;
			 window.location.href=webContext+"/downloadFileAction/download.do?download="+path+"&fileName="+data;
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function changeShowTypeFlag(value){
	if(value=='P'){
		$("#discount-type-flag").html("%");
	}else{
		$("#discount-type-flag").html("￥");
	}
}


function addCoupons() {
	$$ajax( {
		url : "labAction/loadUnitAndProcedure.do",
		data : null,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#add-Coupons-div-html").html(data);
			$("#amount").val("S");
			$("#amount-li").show();
			$("#maxUse-li").hide();
			$("#discount-type").val("P");
			$("#discount-type-flag").html("%");
		    $("#add_coupons").dialog({
		        bgiframe: true,
		        autoOpen: false,
		        title: "添加优惠劵",
		        width: 900,
		        height: 750,
		        modal: true,
		        draggable: true,
		        resizable: true,
		        closeText: "close",
		        buttons: {
		            '取消': function() {
		                $("#add_coupons").dialog('destroy');
		            }
		        }
		    });
		    $("#add_coupons").dialog('open');
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function changeCouponsType(value){
	if(value=='S'){
		$("#amount-li").show();
		$("#maxUse-li").hide();
	}else if(value=='M'){
		$("#amount-li").hide();
		$("#maxUse-li").show();
	}
}

function queryCoupons(url,params){
	$$ajax( {
		url : url,
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

function showCouponsView(id){
	$$ajax( {
		url : "casesAction/CouponsView.do",
		data : {id:id},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#Coupons-view-html").html(data);
			$("#Coupons-view-html").dialog({
		        bgiframe: true,
		        autoOpen: false,
		        title: "优惠劵",
		        width: 900,
		        height: 700,
		        modal: true,
		        draggable: true,
		        resizable: true,
		        closeText: "close",
		        buttons: {
		            '关闭': function() {
		                $("#Coupons-view-html").dialog('destroy');
		            }
		        }
		    });
		    $("#Coupons-view-html").dialog('open');
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});

}

function saveCoupons() {
    var result = verifactionCounpons();
    if (result != false) {
        $$ajax({
            url: "labAction/addCoupons.do",
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
                    $("#add_coupons").dialog('destroy');
                    query('ddxCoupons');
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
function verifactionCounpons() {
	var useType = $("#UseType").val();//使用类型
	var maxUse = $("#maxUse").val();//最大使用次数
	var howmany = $("#amount").val();//单次使用个数
    var prefix = $("#coupons_prefix").val();//前缀代码
    var effective = $("#coupons_Effective").val(); //生效日期
    var expiry = $("#coupons_expiry").val(); //失效日期
    var discountType = $("#discount-type").val();//折扣类型
    var discount = $("#coupons_discount").val();//折扣
    var unit = $("#coupons_institution").val();//机构
    var proceduresid = $("#coupons_process").val();//工序
    isTrue = true;
    if (expiry == undefined || expiry.trim() == '') {
        isTrue = false;
        $("#error_coupons_expiry").show();
        $("#coupons_expiry").attr('class', 'Addonecuowu');

    } else {
        $("#error_coupons_expiry").hide();
        $("#coupons_expiry").attr('class', 'Personalize_b_middle_b');
    }
    if (effective == undefined || effective.trim() == '') {
        isTrue = false;
        $("#error_coupons_Effective").show();
        $("#coupons_Effective").attr('class', 'Addonecuowu');

    } else {
        $("#error_coupons_Effective").hide();
        $("#coupons_Effective").attr('class', 'Personalize_b_middle_b');
    }
    if("M"==useType){
    	if (maxUse == undefined || maxUse.trim() == '') {
            isTrue = false;
            $(error_maxUse).show();
            $(maxUse).attr('class', 'Addonecuowu');

        } else {
            $(error_maxUse).hide();
            $(maxUse).attr('class', 'Personalize_b_middle_b');
        }
    }
    
    if (discount == undefined || discount.trim() == '') {
        isTrue = false;
        $("#error_coupons_discount").show();
        $("#coupons_discount").attr('class', 'Addonecuowu');
    } else {
        $("#error_coupons_discount").hide();
        $("coupons_discount").attr('class', 'Personalize_b_middle_b');
    }
    if (isTrue) {
        $("#errormessage").hide();
        var params = {
            howmany: howmany,
            prefix: prefix,
            expiry: expiry+" 23:59:59",
            discount: discount,
            unit:unit+"",
            proceduresid: proceduresid,
            
            useType:useType,
            maxUse:maxUse,
            effective:effective+" 00:00:00",
            discountType:discountType
        }
        return params;
    } else {
        $("#errormessage").show();
        isTrue = false;
    }
    return isTrue;
}

function deleteCoupons(id) {
    if (!confirm("确认删除吗？")) {
        return;
    }
    $$ajax({
        url: "labAction/deleteCoupons.do",
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
                query('ddxCoupons');
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
