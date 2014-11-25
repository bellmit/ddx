$(function(){
		//今天待发货的订单 
	$('#num_ship').load(webContext+"/casesAction/getShipNum.do", {filter:'today'}, function(response,status){
		if (status!="success"){
			$('#num_ship').html('无法加载数据...请重试！');
		}
	});
	//今天待接收的订单  
	$('#num_arrive').load(webContext+"/casesAction/getArriveNum.do", {filter:'today'}, function(response,status){
		if (status!="success"){
			$('#num_arrive').html('无法加载数据...请重试！');
		}
	});
	//试戴的订单
	$('#num_tryIn').load(webContext+"/casesAction/getTryInNum.do", {}, function(response,status){
		if (status!="success"){
			$('#num_tryIn').html('无法加载数据...请重试！');
		}
	});
	//延迟/搁置的订单
	$('#num_onHold').load(webContext+"/casesAction/getOnHoldNum.do", {}, function(response,status){
		if (status!="success"){
			$('#num_onHold').html('无法加载数据...请重试！');
		}
	});
	//外包的订单
	$('#num_outsource').load(webContext+"/casesAction/getOutsourceNum.do", {}, function(response,status){
		if (status!="success"){
			$('#num_outsource').html('无法加载数据...请重试！');
		}
	});
	
	/* 
	$('#num_ship').click(function(){
		 $.get(
				 "${pageContext.request.contextPath}/casesAction/listShipByMonth.do",
				 {filter:'month',month:$('#month').val(),year:$('#year').val()},
				 function(result){
		    		$("div").html(result);
		  });
	});
	 */

	 //加载日志
	$$ajax( {
		url : "labAction/getActivitiesLog.do",
		data : {date:'today',week:'LastWeek',type:'all'},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#lab-main-log-div").html('正在加载数据...');
		},
		success : function(data, textStatus) {
			$("#lab-main-log-div").html(data);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
	
});
	
function num_arrive(){
	//'${pageContext.request.contextPath}/casesAction/listArriveByMonth.do?filter=month';
	window.location.href = webContext+"/labAction/query.do?method=toArrive&month="+$('#month').val()+"&year="+$('#year').val();
}

function num_ship(){
	//window.location.href= '${pageContext.request.contextPath}/casesAction/listShipByMonth.do?filter=month';
	window.location.href = webContext+"/labAction/query.do?method=toShip&month="+$('#month').val()+"&year="+$('#year').val();
}

function num_tryIn(){
	//window.location.href = '${pageContext.request.contextPath}/casesAction/listTryIn.do';
	window.location.href = webContext+"/labAction/query.do?method=openTryIns&month="+$('#month').val()+"&year="+$('#year').val();
}

function num_onHold(){
	//window.location.href = '${pageContext.request.contextPath}/casesAction/listOnHold.do';
	window.location.href = webContext+"/labAction/query.do?method=onHold&month="+$('#month').val()+"&year="+$('#year').val();
}

function num_outsource(){//
	window.location.href = webContext+"/labAction/query.do?method=toOutsource&month="+$('#month').val()+"&year="+$('#year').val();
}