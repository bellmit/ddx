/**
 * 通用方法
 * @param url
 * @param params
 * @param genre
 */
function sendData(url, params ,genre){
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
			if(genre == 'addEnclosure'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_enclosure_div").dialog('destroy');
					query('enclosures');
				}
			}else if(genre == 'updateEnclosure'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_enclosure_div").dialog('destroy');
					query('enclosures');
				}
			}else if(genre == 'addAcrylicColor'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_acrylicColor_div").dialog('destroy');
					query('acrylicColors');
				}
			}else if(genre == 'updateAcrylicColor'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_acrylicColor_div").dialog('destroy');
					query('acrylicColors');
				}
			}else if(genre == 'addSportGuardColor'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_sportGuardColor_div").dialog('destroy');
					query('sportGuardColors');
				}
			}else if(genre == 'updateSportGuardColor'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_sportGuardColor_div").dialog('destroy');
					query('sportGuardColors');
				}
			}else if(genre == 'addOrthodonticColor'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_orthodonticColor_div").dialog('destroy');
					query('orthodonticColors');
				}
			}else if(genre == 'updateOrthodonticColor'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_orthodonticColor_div").dialog('destroy');
					query('orthodonticColors');
				}
			}else if(genre == 'addOrthodonticDesign'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_orthodonticDesign_div").dialog('destroy');
					query('orthodonticDesigns');
				}
			}else if(genre == 'updateOrthodonticDesign'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_orthodonticDesign_div").dialog('destroy');
					query('orthodonticDesigns');
				}
			}else if(genre == 'addImplantMarker'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_implantMarker_div").dialog('destroy');
					query('implantMarkers');
				}
			}else if(genre == 'updateImplantMarker'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_implantMarker_div").dialog('destroy');
					query('implantMarkers');
				}
			}else if(genre == 'addImplantSystem'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_implantSystem_div").dialog('destroy');
					query('implantSystems');
				}
			}else if(genre == 'updateImplantSystem'){
				if(flag == 'success'){
					alert(obj.info);
					$("#add_edit_implantSystem_div").dialog('destroy');
					query('implantSystems');
				}
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

function removeInputVal(){
    $(':input','#editForm')  
    .not(':button, :submit, :reset')  
    .val('')  
    .removeAttr('checked')  
    .removeAttr('selected');
    $('#name_info').hide();
	$('#defaultPrice_info').hide();
}

function queryCharacter(url,params,genre){
	$$ajax( {
		url : url,
		data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			if(genre == 'goMaterial'){
				$("#show-case-setting-content-div").html(data);
				$('#save_material_fun').unbind('click');
				if(params.id == 0){
					//ie8以下的ie浏览器不支持jquery attr onclick
					/*$('#save_material_fun').attr('onclick','submitMaterial(0);');*/
					$('#save_material_fun').click(function(){
						submitMaterial(0);
					});
				}else{
					$('#save_material_fun').click(function(){
						submitMaterial(1);
					});
				}
			}else if(genre == 'addMaterial'){
				alert('新增成功');
				ol_num = undefined;
				query('materials');
			}else if(genre == 'updateMaterial'){
				alert('更新成功');
				ol_num = undefined;
				query('materials');
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
 * 调用案例材料新增-修改弹出层
 */
function goMaterial(id){
	var url = "labAction/query.do";
	var params = {method:'goMaterial',id:id};
	queryCharacter(url,params,'goMaterial');
}

//减少
function minus(rows){
	var pt = $("#percentage_"+rows).val();
	if(pt == undefined || pt == ''){
		flag = 0;
	}else{
		flag = parseFloat(pt);
	}
	if(flag>0){
		flag --;
	}else{
		return;
	}
	$("#percentage_"+rows).val(flag);
}

//增加
function add(rows){
	var pt = $("#percentage_"+rows).val();
	if(pt == undefined || pt == ''){
		flag = 0;
	}else{
		flag = parseFloat(pt);
	}
	flag ++;
	$("#percentage_"+rows).val(flag);
}

//限制百分比数值的输入
function limitPercentage(rows){
	var $pt = $("#percentage_"+rows);
	var cur = parseFloat($pt.val()),
    max = parseInt($pt.attr("max")),
    min = parseInt($pt.attr("min"));
	if (cur > max) {
	    $pt.val(max);
	};
	if (cur < min) {
	    $pt.val(min);
	}
}

/**
 * 提交材料修改信息
 */
function submitMaterial(type){
	var genre = (type == 0?"addMaterial":"updateMaterial");
	var url = "casesSettingAction/" + genre + ".do" ;
	var id = $('#id').val();
	var name = $('#name').val();
	var classfication = $('#classfication').val();
	var defaultPrice = $('#defaultPrice').val();
	var taxable = $('#taxable').attr('checked')!=undefined?'1':'0';
	
	if(name == undefined || name.trim()==''){
		$("#name_info").show();
		$("#name").attr('class','Addonecuowu');
		return;
	}else{
		$("#name_info").hide();
		$("#name").attr('class','General_middle_bottom_b_middle_b');
	}
	
	if(defaultPrice != undefined && defaultPrice != ''){
		if(!isFloat(defaultPrice)){
			$("#defaultPrice_info").show();
			$("#defaultPrice").attr('class','Addonecuowu');
			return;
		}else{
			$("#defaultPrice_info").hide();
			$("#defaultPrice").attr('class','General_middle_bottom_b_middle_b');
		}
	}
	
	var compostion = {};
	var compositionArry = new Array();
	//获取元素组成
	var material_ols = $('.Materials_Edit ol');
	material_ols.each(function(k , v){
		material_ol = $(v);
		element = material_ol.find("select[name=element]").val();
		percentage = material_ol.find("input[name=percentage]").val();
		compostion = {
			'element':element,
			'percentage':percentage
		}
		compositionArry.push(compostion);
	});

	var params = {
			method:'materials',
			id:id,
			characterName:name,
			classfication:classfication,
			defaultPrice:defaultPrice,
			taxable:taxable,
			composition:JSON.stringify(compositionArry)
	}
	queryCharacter(url,params,genre);
}



/**
 * 调用案例附件新增-修改弹出层
 */
function showEnclosureDialog(id,name,price,taxable,type){
	var title = '';
	title = type == 1?"修改":"添加";
	type == 1 ? setVal(id,name,price,taxable) : null; 
	$("#add_edit_enclosure_div").dialog( {
		bgiframe : true,
		title : title + "随单附件",
		width : 850,
		height : 380,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'提交': function(){
				type == 1 ? updateData('updateEnclosure') : addData('addEnclosure');
			},
			'取消' : function() {
				$("#add_edit_enclosure_div").dialog('close');
			}
		},
		close : function(){
			removeInputVal();
			$("#add_edit_enclosure_div").dialog('destroy');
		}
	});
	
}

/**
 * 添加案例附件/亚克力色/......
 */
function addData(genre){
	var characterName = $('#name').val();
	var classfication = $('#classfication').val();
	var defaultPrice = $('#defaultPrice').val();
	var taxable = $('#taxable').attr('checked')!=undefined?'1':'0';
	
	if(characterName == undefined || characterName.trim()==''){
		$("#name_info").show();
		$("#name").attr('class','Addonecuowu');
		return;
	}else{
		$("#name_info").hide();
		$("#name").attr('class','General_middle_bottom_b_middle_b');
	}
	
	if(defaultPrice != undefined && defaultPrice != ''){
		
		if(!isFloat(defaultPrice)){
			$("#defaultPrice_info").show();
			$("#defaultPrice").attr('class','Addonecuowu');
			return;
		}else{
			$("#defaultPrice_info").hide();
			$("#defaultPrice").attr('class','General_middle_bottom_b_middle_b');
		}
	}
	
	var params = {
			characterName:characterName,
			classfication:classfication,
			defaultPrice:defaultPrice,
			taxable:taxable
	}
	var url = 'casesSettingAction/' + genre + '.do';
	sendData(url,params,genre);
}

/**
 * 修改案例附件/亚克力色/......
 */
function updateData(genre){
	var id = $('#id').val();
	var characterName = $('#name').val();
	var defaultPrice = $('#defaultPrice').val();
	var classfication = $('#classfication').val();
	var taxable = $('#taxable').attr('checked')!=undefined?'1':'0';
	
	if(characterName == undefined || characterName.trim()==''){
		$("#name_info").show();
		$("#name").attr('class','Addonecuowu');
		return;
	}else{
		$("#name_info").hide();
		$("#name").attr('class','General_middle_bottom_b_middle_b');
	}
	
	if(defaultPrice != undefined && defaultPrice != ''){
		if(!isFloat(defaultPrice)){
			$("#defaultPrice_info").show();
			$("#defaultPrice").attr('class','Addonecuowu');
			return;
		}else{
			$("#defaultPrice_info").hide();
			$("#defaultPrice").attr('class','General_middle_bottom_b_middle_b');
		}
	}
	
	var params = {
			id:id,
			characterName:characterName,
			classfication:classfication,
			defaultPrice:defaultPrice,
			taxable:taxable
	}
	var url = 'casesSettingAction/' + genre + '.do';
	sendData(url,params,genre);
}

/**
 * 调用acrylicColors新增-修改弹出层
 */
function showAcrylicColorDialog(id,name,price,taxable,type){
	
	var title = '';
	title = type == 1?"修改":"添加";
	type == 1 ? setVal(id,name,price,taxable) : null; 
	$("#add_edit_acrylicColor_div").dialog( {
		bgiframe : true,
		title : title + "塑胶袋",
		width : 850,
		height : 380,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'保存': function(){
				type == 1 ? updateData('updateAcrylicColor') : addData('addAcrylicColor');
			},
			'取消' : function() {
				$("#add_edit_acrylicColor_div").dialog('close');
			}
		},
		close : function(){
			removeInputVal();
			$("#add_edit_acrylicColor_div").dialog('destroy');
		}
	});
	
}

/**
 * 调用sportGuardColors新增-修改弹出层
 */
function showSportGuardColorDialog(id,name,price,taxable,type){
	
	var title = '';
	title = type == 1?"修改":"添加";
	type == 1 ? setVal(id,name,price,taxable) : null; 
	$("#add_edit_sportGuardColor_div").dialog( {
		bgiframe : true,
		title : title + "包装盒",
		width : 850,
		height : 380,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'保存': function(){
				type == 1 ? updateData('updateSportGuardColor') : addData('addSportGuardColor');
			},
			'取消' : function() {
				$("#add_edit_sportGuardColor_div").dialog('close');
			}
		},
		close : function(){
			removeInputVal();
			$("#add_edit_sportGuardColor_div").dialog('destroy');
		}
	});
	
}

/**
 * 调用orthodonticColorS新增-修改弹出层
 */
function showOrthodonticColorDialog(id,name,price,taxable,type){
	
	var title = '';
	title = type == 1?"修改":"添加";
	type == 1 ? setVal(id,name,price,taxable) : null; 
	$("#add_edit_orthodonticColor_div").dialog( {
		bgiframe : true,
		title : title + "矫治器",
		width : 850,
		height : 380,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'保存': function(){
				type == 1 ? updateData('updateOrthodonticColor') : addData('addOrthodonticColor');
			},
			'取消' : function() {
				$("#add_edit_orthodonticColor_div").dialog('close');
			}
		},
		close : function(){
			removeInputVal();
			$("#add_edit_orthodonticColor_div").dialog('destroy');
		}
	});
	
}

function setVal(id,name,price,taxable){
	$('#id').val(id);
	$('#name').val(name);
	$('#defaultPrice').val(price);
	$('#taxable').attr('checked',taxable == 1 ? true:false);
}

function clearVal(){
	$('#id').val('');
	$('#name').val('');
	$('#name_info').hide();
	$('#defaultPrice').val('');
	$('#defaultPrice_info').hide();
	$('#taxable').attr('checked',false);
}

/**
 * 调用orthodonticDesigns新增-修改弹出层
 */
function showOrthodonticDesignDialog(id,name,price,taxable,type){
	
	var title = '';
	title = type == 1?"修改":"添加";
	type == 1 ? setVal(id,name,price,taxable) : null; 
	$("#add_edit_orthodonticDesign_div").dialog( {
		bgiframe : true,
		title : title + "矫治器设计",
		width : 850,
		height : 380,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'保存': function(){
				type == 1 ? updateData('updateOrthodonticDesign') : addData('addOrthodonticDesign');
			},
			'取消' : function() {
				$("#add_edit_orthodonticDesign_div").dialog('close');
			}
		},
		close : function(){
			removeInputVal();
			$("#add_edit_orthodonticDesign_div").dialog('destroy');
		}
	});
	
}

function showImplantSystemDialog(id,name,classfication,price,taxable,type){
	
	var title = '';
	title = type == 1?"修改":"添加";
	type == 1 ? setVal(id,name,price,taxable) : null;
	type == 1 ? $('#classfication').val(classfication) : $('#classfication').val('');
	$("#add_edit_implantSystem_div").dialog( {
		bgiframe : true,
		title : title + "种植系统",
		width : 850,
		height : 380,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'保存': function(){
				type == 1 ? updateData('updateImplantSystem') : addData('addImplantSystem');
			},
			'取消' : function() {
				$("#add_edit_implantSystem_div").dialog('close');
			}
		},
		close : function(){
			removeInputVal();
			$("#add_edit_implantSystem_div").dialog('destroy');
		}
	});
	
}


/**
 * 调用implantMarkers新增-修改弹出层
 */
function showImplantMarkerDialog(id,name,price,taxable,type){
	
	var title = '';
	title = type == 1?"修改":"添加";
	type == 1 ? setVal(id,name,price,taxable) : null; 
	$("#add_edit_implantMarker_div").dialog( {
		bgiframe : true,
		title : title + "种植导板",
		width : 850,
		height : 380,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'保存': function(){
				type == 1 ? updateData('updateImplantMarker') : addData('addImplantMarker');
			},
			'取消' : function() {
				$("#add_edit_implantMarker_div").dialog('close');
			}
		},
		close : function(){
			removeInputVal();
			$("#add_edit_implantMarker_div").dialog('destroy');
		}
	});
	
}

/**
 * 删除
 */
function delCharacter(genre,id){
	if(window.confirm("确定删除吗？")){
	var url= '';
	if(genre == 'delEnclosure' || genre == 'delAcrylicColor'
		|| genre == 'delSportGuardColor' || genre == 'delOrthodonticColor'
			|| genre == 'delOrthodonticDesign' || genre == 'delImplantMarker'
				|| genre == 'delImplantSystem'){
		url = 'casesSettingAction/delCharacter.do';
	}else if(genre == 'delMaterial'){
		url = 'casesSettingAction/delMaterial.do'
	}
	
	$$ajax( {
		url : url,
		data : {id:id,genre:genre},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			var genre = JSON.genre;
			var flag = JSON.flag;
			var obj = JSON.obj;
			
			if(genre == 'delMaterial'){
				if(flag == 'success'){
					alert(obj.info);
					query('materials');
				}
			}else if(genre == 'delEnclosure'){
				if(flag == 'success'){
					alert(obj.info);
					query('enclosures');
				}
			}else if(genre == 'delAcrylicColor'){
				if(flag == 'success'){
					alert(obj.info);
					query('acrylicColors');
				}
			}else if(genre == 'delSportGuardColor'){
				if(flag == 'success'){
					alert(obj.info);
					query('sportGuardColors');
				}
			}else if(genre == 'delOrthodonticColor'){
				if(flag == 'success'){
					alert(obj.info);
					query('orthodonticColors');
				}
			}else if(genre == 'delOrthodonticDesign'){
				if(flag == 'success'){
					alert(obj.info);
					query('orthodonticDesigns');
				}
			}else if(genre == 'delImplantMarker'){
				if(flag == 'success'){
					alert(obj.info);
					query('implantMarkers');
				}
			}else if(genre == 'delImplantSystem'){
				if(flag == 'success'){
					alert(obj.info);
					query('implantSystems');
				}
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

function isPriceNumber(_keyword){
	if(_keyword == "0" || _keyword == "0." || _keyword == "0.0" || _keyword == "0.00"){
		_keyword = "0"; return true;
	}else{
		var index = _keyword.indexOf("0");
		var length = _keyword.length;
		if(index == 0 && length>1){/*0开头的数字串*/
			var reg = /^[0]{1}[.]{1}[0-9]{1,2}$/;
			if(!reg.test(_keyword)){
				return false;
			}else{
				return true;
			}
		}else{/*非0开头的数字*/
			var reg = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
			if(!reg.test(_keyword)){
				return false;
			}else{
				return true;
			}
		}			
		return false;
	}
}

function isFloat(oNum){
	 if(!oNum){
		 return false;
	 }
	 var strP=/^\d+(\.\d+)?$/;
	 if(!strP.test(oNum)){
		 return false;
	 }
	 try{
	 	 if(parseFloat(oNum)!=oNum){
	 		 return false;
	 	 }
	 }catch(ex){
	   return false;
	 }
	 return true;
}


/**
 * 分页
 */
function listCharacter(pageNo,type){
	 var param = {
        offset: pageNo,
        search: $("#search").val(),
        method: type
     };
    $$ajax({
        url: "labAction/query.do",
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
