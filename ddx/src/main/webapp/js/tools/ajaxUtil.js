/**
 * 替换 Jquery 自带$$post(url, [data], [callback], [type]);函数 解决不能设置 禁止全局Ajax事件的问题
 * 
 * @author 金德志
 * @param {}
 *            url
 * @param {}
 *            data
 * @param {}
 *            successCallback 成功处理函数
 * @param {}
 *            type
 * @param {}
 *            async
 * @param {}
 *            errorCallback 错误处理函数
 */
var $$post = function(url, data, successCallback, type, async, errorCallback) {
	var _async = (typeof (async) == "undefined") ? true : async;
	$$ajax( {
		url : url,
		data : data,
		type : "POST",
		async : _async,
		cache : false,
		global : false,
		dataType : type,
		success : successCallback,
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").show();
		},
		complete : function(XMLHttpRequest, textStatus) {
			$("#data-loading-div").hide();
		},
		error : (errorCallback == 'undefined') ? (function(XMLHttpRequest,
				textStatus) {
			if (textStatus == 'timeout') {
				alert('timeout');
			} else if (textStatus == 'error') {
				alert('error');
			} else if (textStatus == 'notmodified') {
				alert('notmodified');
			} else if (textStatus == 'parsererror') {
				alert('parsererror');
			}
		}) : errorCallback
	});
}
/**
 * 替换 Jquery 自带$.get(url, [data], [callback], [type]);函数 解决不能设置 禁止全局Ajax事件的问题
 * 
 * @author 金德志
 * @param {}
 *            url
 * @param {}
 *            data
 * @param {}
 *            successCallback 成功处理函数
 * @param {}
 *            type
 * @param {}
 *            async
 * @param {}
 *            errorCallback 错误处理函数
 */
var $$get = function(url, data, successCallback, type, async, errorCallback) {
	var _async = (typeof (async) == "undefined") ? true : async;
	$$ajax( {
		url : url,
		data : data,
		type : "GET",
		async : _async,
		cache : false,
		global : false,
		dataType : type,
		success : successCallback,
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").show();
		},
		complete : function(XMLHttpRequest, textStatus) {
			$("#data-loading-div").hide();
		},
		error : (errorCallback == 'undefined') ? (function(XMLHttpRequest,
				textStatus) {
			if (textStatus == 'timeout') {
				alert('timeout');
			} else if (textStatus == 'error') {
				alert('error');
			} else if (textStatus == 'notmodified') {
				alert('notmodified');
			} else if (textStatus == 'parsererror') {
				alert('parsererror');
			}
		}) : errorCallback
	});
}

// web根目录
var webContext = "/ddx";

// 重定义ajax方法，用于异常处理
var $$ajax = function(opt) {
	var OBJECT = this;
	var tmpOption = {};// 参数

	OBJECT.option = {
		url : "",
		data : {},
		type : "POST",
		async : "true",
		cache : false,
		global : false,
		dataType : "html"
	};
	//这里加上根目录是以防目录层次多而导致404
	opt.url = webContext + "/" + opt.url;
	$.extend(tmpOption, OBJECT.option, opt);
	var tmpDataType = tmpOption.dataType; // 取得参数中的dataType类型
	$.extend(tmpOption.data, {
		tmpDataType : tmpDataType
	}); // 在data中增加返回参数类型，以便判断

	if (tmpDataType == "json") {
		// 返回json时 重写success内容、
		tmpOption.success = function(data, textStatus) {
			var globalIntercept = data.globalIntercept;
			var ExceptionType = data.ExceptionType;
			var Session = data.SessionTimeout;
			if (globalIntercept == "fail") {
				if (Session != undefined && Session.isEqual("SessionTimeout")) {
					// json格式，session过期，返回登陆页
					alert("会话过期，请重新登录！");
					return;
				} else {
					//$("div[class^='ui-dialog']").remove();
					//$(".wrap .right").html("<div id='exception_div' class='error'></div>");
				}
			} else {
				opt.success(data, textStatus);
			}
		}
		tmpOption.error = function() {
			// $(".wrap .right").html(data);
			opt.error();
		}
	} else if (tmpDataType == "html") {
		// 返回html时 重写success内容、
		tmpOption.success = function(data, textStatus) {
			var htmldata = data;
			if (htmldata!=undefined && htmldata.indexOf("会话过期")!=-1) {
				// 返回为异常页面时,关闭dialog页面
				//$("div[class^='ui-dialog']").remove();
				//$(".wrap .right").html(data);
				if (confirm("会话已过期，是否跳转到重新登录？")) {
					 window.location.href = "http://"+location.host + webContext;
			    }
				return;
			} else if (htmldata == "SessionTimeout") {
				// session过期，返回登陆页
				//$("div[class^='ui-dialog']").remove();
				alert("会话过期，请重新登录！");
				return;
			} else {
				opt.success(data, textStatus);
			}
		}
	}
	$.ajax(tmpOption); // 执行ajax操作
}
/**
 * 去除空格
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
/**
 * 错误提示
 */
function alertError(e){
	if (e == undefined || e.responseText == undefined
			|| e.responseText == null || e.responseText == '') {
		alert("无法建立与服务器的连接，请检查是否已连接网络！");
	} else {
		try{
			$("#exception-div").html(e.responseText);
			$("#exception-div").dialog( {
				bgiframe : true,
				autoOpen : false,
				title : "出错了！",
				width : 800,
				height : 600,
				modal : true,
				draggable : true,
				resizable : false,
				closeText : "close",
				buttons : {
					'关闭' : function() {
						$('#exception-div').dialog('destroy');
					}
				}
			});
			$('#exception-div').dialog('open');
		}catch(e2){
			alert(e.responseText);
		}
	}
}
/**
 * table间隔颜色
 */
function doubleBgColor(Table,Bg1,Bg2) {
	try{
		for (var i=0;i<Table.rows.length;i++) Table.rows[i].bgColor=i%2?Bg2:Bg1;
	}catch(e){}
    
}

/**
 * 时间对象的格式化;
 */
Date.prototype.format = function(format) {
    /*
     * eg:format="YYYY-MM-dd hh:mm:ss";
     */
    var o = {
        "M+" :this.getMonth() + 1, // month
        "d+" :this.getDate(), // day
        "h+" :this.getHours(), // hour
        "m+" :this.getMinutes(), // minute
        "s+" :this.getSeconds(), // second
        "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter
        "S" :this.getMilliseconds()
    // millisecond
    }
 
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
    }
 
    for ( var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                    : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}
/**
 * 使用条款弹出窗
 */
function showLabSignupTerms(){
	$("#lab-signup-terms").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "使用条款",
		width : 1100,
		height : 700,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "关闭",
		buttons : {
			'关闭' : function() {
				$('#lab-signup-terms').dialog('destroy');
			}
		}
	});
	$('#lab-signup-terms').dialog('open');
}
/**
 * 服务条款弹出窗
 */
function showLabServiceAgree(){
	$("#lab-signup-service-agree").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "服务条款",
		width : 1100,
		height : 700,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "关闭",
		buttons : {
			'关闭' : function() {
				$("#lab-signup-service-agree").dialog('destroy');
			}
		}
	});
	$("#lab-signup-service-agree").dialog('open');
}
/**
 * 建议或意见弹出窗
 */
function suggestions(){
	$("#lab-suggestions").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "建议或意见",
		width : 800,
		height : 530,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "关闭",
		buttons : {
			'关闭' : function() {
				$('#lab-suggestions').dialog('destroy');
			},
			'提交' : function() {
				$('#lab-suggestions').dialog('destroy');
			}
		}
	});
	$('#lab-suggestions').dialog('open');
}
/**
 * 隐私政策弹出窗
 */
function privacy(){
	$("#lab_privacy").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "建议或意见",
		width : 800,
		height : 530,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "关闭",
		buttons : {
			'关闭' : function() {
				$("#lab_privacy").dialog('destroy');
			}
		}
	});
	$("#lab_privacy").dialog('open');
}