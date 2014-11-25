
/**
 * 跳转到收件请求页面
 */
function goPickupPage(labId){
	window.location.href = webContext + "/casesAction/goPickupPage.do?labId=" + labId;
}

/**
 * 页面加载完成后，初始化页面信息
 */
function init(){
	//1、初始化事项
	getEvents(new Date().format("yyyy-MM-dd"),"LastWeek");
	//2、初始化警示
	getActivity();
	
	//3、初始化首页新闻
	getNews();
}


function getAlert(){
	$$ajax( {
		url : "practiceAction/getAlert.do",
		data : null,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#practice-index-alert-and-activity-div").html('正在拼命的加载数据...').show();
		},
		success : function(data, textStatus) {
			$("#practice-index-alert-and-activity-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function getNews(){
	$$ajax( {
		url : "practiceAction/getNews.do",
		data : null,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#practice-index-news").html('正在拼命的加载数据...').show();
		},
		success : function(data, textStatus) {
			$("#practice-index-news").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function getActivity(){
	$$ajax( {
		url : "practiceAction/getActivity.do",
		data : {date:'today',week:'LastWeek',type:'all'},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#practice-index-alert-and-activity-div").html('正在拼命的加载数据...').show();
		},
		success : function(data, textStatus) {
			$("#practice-index-alert-and-activity-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});

}
function loadEventsByWeek(type){
	$("#LastWeek-a").attr("style","display: none;");
	$("#NextWeek-a").attr("style","display: none;");
	getEvents($("#start-date").val(),type);
}

function getEvents(date,type){
	var eventParams = {date:date,type:type}
	$$ajax( {
		url : "practiceAction/getEvents.do",
		data : eventParams,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#practice-index-events-div").html('正在拼命的加载数据...');
		},
		success : function(data, textStatus) {
			$("#practice-index-events-div").html(data);
			$("#LastWeek-a").attr("style","display: block;");
			$("#NextWeek-a").attr("style","display: block;");
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function listPracticeUsers(pageNo){
	var param = {offset:pageNo,search:$("#search-users").val()}
	$$ajax( {
		url : "practiceAction/listUserSearch.do",
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


function deletePracticeUser(id){
	if(!confirm("确认删除这个用户吗？")){
		return;
	}
	$$ajax( {
		url : "practiceAction/deleteUser.do",
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
				listPracticeUsers(1);
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
function loadLabPermissions(userId){
	$$ajax( {
		url : "practiceAction/getPartnerLabList.do",
		data : {userId:userId},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#Lab-Permissions-div").html('正在拼命的加载数据...');
		},
		success : function(data, textStatus) {
			$("#Lab-Permissions-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});

}

function showAddPracticeUserDialog(){
	loadLabPermissions();
	$("#add-practice-user-div").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "添加用户",
		width : 850,
		height : 800,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "关闭",
		buttons : {
			'取消' : function() {
				$("#add-practice-user-div").dialog('destroy');
			}
		}
	});
	$("#add-practice-user-div").dialog('open');
}

function listArriveCases(pageNo){
	$$ajax( {
		url : "practiceAction/listArriveCases.do",
		data : {offset:pageNo/*,search:$("#search").val()*/},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#ArriveCases-list-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}
function setColor(id) {
	if ($("#" + id).attr("flag") == "check") {
		$("#" + id).attr("flag", "");
		$("#" + id).attr("style", "cursor: pointer;background-color: #FFFFFF");
	} else {
		$("#" + id).attr("flag", "check");
		$("#" + id).attr("style", "cursor: pointer;background-color: #D6E9F5");
	}
}
function showCheckCases(){
	var html = '<h2>' + '标记订单已抵达?' + '</h2><br/>';
	
    var selected = $("table tr[flag='check']");
    
    $("#showCheckCases-div").dialog({
        resizable: true,
        modal: true,
        width: 400,
        open: function() {
            var $this = $(this);
            $this.empty();

            if (selected.length > 0) {
            	selected.each(function(){
                	var list = $(this);
            		for(var i=0;i<list.length;i++){
            			html += "●&nbsp;&nbsp;"+$(list.eq(i)).attr("title")+"<br/>";
            		}
                });
                $this.html(html);
            } else {
                $this.html('<strong>' + '没有订单被选中!' + '</strong>');
            }
        },
        buttons: {
            "取消": function() {
                $(this).dialog("close");
            },
            "确定": function() {
                if (selected.length !== 0 ) {
                	var checked = [];
                    selected.each(function(i){
                    	checked.push($(this).attr("id"));
                    });
                    var url = webContext + '/casesAction/practice/cases/arrive.do'
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: {"cases[]":checked},
                        success: function(result) {
                            if (result) {
                               /* selected.each(function(){
                                   this.remove();
                                });*/
                                alert('标记抵达订单成功');
                                window.location.reload();
                            } else {
                                alert('标记抵达订单，出错了...');
                            }
                            $("#showCheckCases-div").dialog("close");
                        },
                        dataType: 'json',
                        traditional: true,
                        error: function() {
                            alert('标记抵达订单，出错了...');
                            $("#showCheckCases-div").dialog("close");
                        }
                    });
                    
                } else {
                    $(this).dialog("close");
                }
            }
        }
    });
}

//删除草稿
function delCase(id){
	if(!confirm("确认删除吗？")){
		return;
	}
	$$ajax( {
		url : "casesAction/delCase.do",
		data : {id:id},type : "POST",async : true,cache : false,global : false,dataType : "html",
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

//继续订单
function resumeCase(id){
	window.location.href = webContext + '/casesAction/resumeCase.do?id='+id;
}
function listTagsCases(pageNo){
	$$ajax( {
		url : "practiceAction/listTagsCases.do",
		data : {offset:pageNo,tags:$("#select-tags-cases").val()},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#tagsCases-list-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});

}