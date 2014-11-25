function listDisplayCategories(pageNo){
	var param = {offset:pageNo,search:$("#search-DisplayCategory").val()}
	$$ajax( {
		url : "casesAction/listDisplayCategories.do",
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

function listLabProcedures(pageNo){
	var param = {offset:pageNo,search:$("#search-procedure").val()}
	$$ajax( {
		url : "labAction/setting/listLabProcedures.do",
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

//跳转到新增工序界面
function gotoNewProcedure(){
	window.location.href = webContext + "/labProcedureAction/pageJump.do?type=toNewProcedure&labId="+ id;
}

function showAddDisplayCategoryDialog(title,functions,pk,name,sort){
	$("#add-Category-id").val(pk);
	$("#add-Category-name").val(name);
	$("#add-Category-sort").val(sort);
	$("#dit-Display-Category-function").attr('onclick',functions);
	
	$("#edit-Display-Category-div").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : title,
		width : 850,
		height : 478,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'取消' : function() {
				$("#edit-Display-Category-div").dialog('destroy');
			}
		}
	});
	$("#edit-Display-Category-div").dialog('open');

}
function updateDisplayCategory(){
	editDisplayCategory("update");
}
function saveDisplayCategory(){
	editDisplayCategory("save");
}
function editDisplayCategory(method){
	var param = verifications();
	if(param!=false){
		$$ajax( {
			url : "labAction/setting/editDisplayCategory.do?method="+method,
			data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert(JSON.info);
					$("#edit-Display-Category-div").dialog('destroy');
					query('displayCategories');
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
function verifications(){
	var id = $("#add-Category-id").val();
	var name = $("#add-Category-name").val();
	var sort = $("#add-Category-sort").val();
	var isTrue=true;
	if(name==undefined || name.trim()==''){
		$("#name-null-ps-message").show();
		$("#add-Category-name").attr('class', 'Addonecuowu');
		isTrue=false;
	}else{
		$("#name-null-ps-message").hide();
		$("#add-Category-name").attr('class', 'Personalize_b_middle_b');
	}
	if(parseInt(sort)>=0){
		$("#sort-null-ps-message").hide();
		$("#add-Category-sort").attr('class', 'Personalize_b_middle_b');
	}else{
		$("#sort-null-ps-message").show();
		$("#add-Category-sort").attr('class', 'Addonecuowu');
		isTrue=false;
	}
	if(isTrue){
		var params={
				id:id,
				sort:parseInt(sort),
				name:name
		}
		return params;
	}
	return isTrue;	
}


function verificationsProcedure(proceduresId){
	var CategorySelect = $("#edit-Procedure-Category-select").val();
	var CategorySubselect = $("#procedures-Category-Sub-select").val();
	var ProceduresTypeselect = $("#procedures-procedures-Type-select").val();
	
	var displayCategoryname = $("#edit-Procedure-display-Category-name").val();
	var displayCategorySelect = $("#edit-Procedure-display-Category").val();
	var displayDescription = $("#edit-Procedure-display-Description").val();
	var displayProceduresGroupSelect = $("#Procedures-group-select").val()+"";
	var displayProcedureSortRank = $("#edit-Procedure-sort-rank").val();
	var displayUnitCounSelect = $("#Procedures-display-UnitCoun").val();
	
	var isOverrideDays = $("#isOverrideDays").attr('checked')!=undefined?"checked":"false";
	var TurnAroundDays = $("#edit-Procedure-TurnAround-days").val();
	var IgnoreInbound = $("#Procedures-Ignore-Inbound").attr('checked')!=undefined?"checked":"false";
	var IgnoreOutbound = $("#Procedures-Ignore-Outbound").attr('checked')!=undefined?"checked":"false";
	
	var newdisplayCategory = $("#edit-Procedure-new-display-Category").val();
	var newgroup = $("#Procedures-new-group").val();
	
	var isOk = true;
	if(CategorySelect==undefined || CategorySelect.trim()=='' || CategorySubselect==undefined || CategorySubselect.trim()=='' || ProceduresTypeselect==undefined || ProceduresTypeselect.trim()==''){
		isOk = false;
		$("#procedures-select-error-msg").show();
	}else{
		$("#procedures-select-error-msg").hide();
	}
	if(displayCategoryname==undefined || displayCategoryname.trim()==''){
		isOk = false;
		$("#edit-Procedure-display-Category-name").attr("class","Addonecuowu");
		$("#procedures-name-error-msg").show();
	}else{
		$("#edit-Procedure-display-Category-name").attr("class","Personalize_b_middle_b");
		$("#procedures-name-error-msg").hide();
	}
	if(displayCategorySelect=='new'){
		if(newdisplayCategory==undefined || newdisplayCategory.trim()==''){
			isOk = false;
			$("#edit-Procedure-new-display-Category").attr("class","Addonecuowu");
			$("#procedures-display-Category-error-msg").show();
		}else{
			$("#edit-Procedure-new-display-Category").attr("class","Personalize_b_middle_b");
			$("#procedures-display-Category-error-msg").hide();
		}
	}
	if(displayProceduresGroupSelect!=undefined && displayProceduresGroupSelect.indexOf("new")!=-1){
		if(newgroup==undefined || newgroup.trim()==''){
			isOk = false;
			$("#Procedures-new-group").attr("class","Addonecuowu");
			$("#procedures-display-group-error-msg").show();
		}else{
			$("#Procedures-new-group").attr("class","Personalize_b_middle_b");
			$("#procedures-display-group-error-msg").hide();
		}
	}
	if(isOk){
		$("#detils-error-msg").hide();
		var param = {
				proceduresId:proceduresId,						//工序ID
				
				proceduresCategoryId:CategorySelect,			//第一级工序类别ID
				proceduresCategorySubId:CategorySubselect,		//第二级工序子类别ID
				proceduresTypeId:ProceduresTypeselect,			//第三级工序类型ID
				
				newgroup:newgroup,
				newdisplayCategory:newdisplayCategory,
				
				categoryId:displayCategorySelect,				//工序显示归类ID
				displayPsGroup:displayProceduresGroupSelect,	//工序组
				displayName:displayCategoryname,				//显示_工序名称
				displayDescription:displayDescription,			//显示_工序描述
				displaySortRank:displayProcedureSortRank,		//显示_工序排序排名
				displayUnitCount:displayUnitCounSelect,			//显示_单位计数
				
				schedulingTurnAroundDays:TurnAroundDays,		//调度_运转天
				schedulingOverrideDefault:isOverrideDays,		//调度_默认重写
				schedulingIgnoreInboundDay:IgnoreInbound,		//调度_忽略入站交通天数
				schedulingIgnoreOutboundDay:IgnoreOutbound		//调度_忽略出战交通天数
		}
		return param;
	}else{
		$("#detils-error-msg").html('有你的表单提交的错误，请看下面的细节。').show();
	}
	
	return isOk;
	
}

function settingNumber(id,type){
	var obj = $("#"+id);
	if('plus'==type){
		var val = obj.val();
		obj.val(parseInt(val)+1);
	}else if('minus'==type){
		var val = obj.val();
		if(val-1>=0){
			obj.val(val-1);
		}
	}
}

function getSubCategory(value){
	if(value==undefined || value.trim()==''){
		$("#procedures-Category-Sub-select-li").hide();
		$("#procedures-procedures-Type-select-li").hide();
		return;
	}
	$$ajax( {
		url : "labAction/setting/getSubCategory.do",
		data : {id:value},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			$("#procedures-Category-Sub-select").html(JSON.subCategory);
			$("#procedures-procedures-Type-select").html(JSON.proceduresType);
			$("#procedures-Category-Sub-select-li").show();
			$("#procedures-procedures-Type-select-li").show();
			hideAttr(value);
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function getProceduresType(value){
	if(value==undefined || value.trim()==''){
		$("#procedures-procedures-Type-select-li").hide();
		return;
	}
	$$ajax( {
		url : "labAction/setting/getProceduresType.do",
		data : {id:value},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#procedures-procedures-Type-select").html(data);
			$("#procedures-procedures-Type-select-li").show();
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}
function isNewCategory(value){
	if(value!=undefined && value=='new'){
		$("#new-Procedures-Category-div").show(500);
	}else{
		$("#new-Procedures-Category-div").hide(500);
		$("#procedures-display-Category-error-msg").hide(500);
	}
}

function showOverride(){
	var isOverrideDays = $("#isOverrideDays").attr('checked')!=undefined?"checked":"false";
	if(isOverrideDays=='checked'){
		$("#OverrideDays-li").show(500);
		$("#default-10-days").attr("style","text-decoration: line-through");
	}else{
		$("#OverrideDays-li").hide(500);
		$("#default-10-days").attr("style","");
	}
}

/***
 * @param item 加载的项目
 * @param isReload 当前操作是否是重新加载
 */
function procedure(item,isReload){
	$("#edit-Procedures-general-div").hide();
	$("#edit-Procedures-attributes-div").hide();
	$("#edit-Procedures-externalLinks-div").hide();
	$("#edit-Procedures-pricing-div").hide();
	
	//外包联系和价格加载标识
	var isLoad = true;
	
	//isReload ：工序和属性重新加载标识
	if("general"==item){
		$("#edit-Procedures-attributes-div").hide();
		$("#edit-Procedures-general-div").show();
		isLoad = false;
	}else if("attributes"==item){
		if($("#edit-Procedures-attributes-div").html().trim()!=''){
			$("#edit-Procedures-general-div").hide();
			$("#edit-Procedures-attributes-div").show();
			isLoad = false;
		}
	}
	
	if(isReload || isLoad){
		var params = {method:item,id:$("#operation-procedure-id").val(),type:$("#operation-flag").val()}
		$$ajax( {
			url : "labAction/query.do",
			data : params,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
			$("#edit-Procedures-"+item+"-div").html("数据加载中...").show();
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				$("#edit-Procedures-"+item+"-div").html(data);
				//新增并且下一步时，重新加载刷新上一个面板的内容
				if(true!=isReload){
					$("#edit-Procedures-"+item+"-div").show();
				}
				//隐藏对应的
				if("attributes"==item){
					hideAttr($("#edit-Procedure-Category-select").val());
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
		//隐藏对应的
		if("attributes"==item){
			hideAttr($("#edit-Procedure-Category-select").val());
		}
	}
}
function hideAttr(id){
	var key = $("#"+id).attr("key");
	if($("#edit-Procedures-attributes-div").html()!=undefined 
			&& $("#edit-Procedures-attributes-div").html().trim()!=""){
		$("form[name='procedure-attributes-form'] ul li").each(function (ii){
			var list = $(this);
			for(var i=0;i<list.length;i++){
				var inCategory = $(list.eq(i)).attr("inCategory");
				if(key!=undefined && inCategory.indexOf(key+"")!=-1){
					$(list.eq(i)).show();
					$(list.eq(i)).find("select[name='presence']").each(function (j){
						 $(this).attr("flag","show");
					 });
				}else{
					$(list.eq(i)).hide();
					 $(list.eq(i)).find("select[name='presence']").each(function (j){
						 $(this).attr("flag","hide");
					 });
				}
			}
		});
	}
	changeAttrValue(key);
}

function changeAttrValue(key){
	if(key=="Fixed Restoration"){
		$("select[id='procedure-attributes-Shade-Value'] option").each(function (op){
			var val = $(this).attr("value");
			if(val.indexOf("K-")!=-1 || val.indexOf("BF-")!=-1 || val.indexOf("PO-")!=-1
					|| val.indexOf("BB-")!=-1|| val.indexOf("TB-")!=-1|| val.indexOf("VP-")!=-1|| val.indexOf("IL-")!=-1){
				$(this).hide();
			}else{
				$(this).show();
			}
		});
		
		$("input[type='checkbox']").each(function (op){
			var val = $(this).attr("value");
			if(val.indexOf("C-CC")!=-1 || val.indexOf("C-WW")!=-1 || val.indexOf("C-R-")!=-1 || val=="C-T"|| val=="C-V"){
				$(this).closest("label").hide();
			}else{
				$(this).closest("label").show();
			}
		});
		
		
	}else if(key=="Removable Restoration"){
		$("select[id='procedure-attributes-Shade-Value'] option").each(function (op){
			var val = $(this).attr("value");
			if(val.indexOf("K-")!=-1 || val.indexOf("BF-")!=-1 || val.indexOf("PO-")!=-1
					|| val.indexOf("BB-")!=-1|| val.indexOf("TB-")!=-1|| val.indexOf("VP-")!=-1|| val.indexOf("IL-")!=-1 || val.indexOf("OTHER")!=-1){
				$(this).show();
			}else{
				$(this).hide();
			}
		});
		
		$("input[type='checkbox']").each(function (op){
			var val = $(this).attr("value");
			if(val.indexOf("C-CC")!=-1 || val.indexOf("C-WW")!=-1 || val.indexOf("C-R-")!=-1 || val=="C-T"|| val=="C-V"){
				$(this).closest("label").show();
			}
		});
	}
}


function goHomeByProcedure(){
	window.location.href = webContext + "/labAction/setting/caseSetting.do?menu=procedure&item=labProcedures";
}

function editProcedure(isNext){
	var type = "add";
	var proceduresId = $("#operation-procedure-id").val();
	//第一次进入页面
	var url = "labAction/setting/saveProcedure.do";
	//第二次增加一般信息后，刷新面板就成了修改，id不为空就是修改
	if(proceduresId!=undefined && proceduresId.trim()!=''){
		type = "update";
		url = "labAction/setting/updateProcedure.do";
	}
	var result = verificationsProcedure(proceduresId);
	if(result!=false){
		$$ajax( {
			url : url,
			data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					if(type=='add'){
						alert(JSON.info.msg);
						$("#operation-procedure-id").val(JSON.info.id);
						procedure('general',true);// 重新加载,刷新内容
						if(isNext!=undefined && isNext.trim()=='next' ){
							//下一步
							procedure('attributes');
						}else{
							//调回首页列表
							goHomeByProcedure();
						}
					}else{
						alert(JSON.info);
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
function verificationsLink(link_id){
	var param = {
			id:link_id,
			proceduresId:$("#operation-procedure-id").val(),
			outPartnerLabId:$("#out-link-plab").val(),
			outProceduresId:$("#out-link-pro").val(),
			autoRoute:$("#out-link-Auto-Route").attr('checked')!=undefined?"checked":"false",
			type:$("#out-link-Sirona-Connect-Type").val(),
			design:$("#out-link-Sirona-Connect-Design").val(),
			material:$("#out-link-Sirona-Connect-Material").val()
	}
	return param;
}

function editOutLink(link_id,isNext){
	if(checkProcedures()){
		var type = "add";
		if(link_id!=undefined && link_id.trim()!=''){
			type = "update";
		}
		var param = verificationsLink(link_id);
		$$ajax( {
			url : "labAction/setting/saveOutLink.do?otype="+type,
			data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert(JSON.info);
					if(type=='add'){
						if(isNext=='next'){
							procedure('pricing');
						}else{
							// 调回首页列表
							goHomeByProcedure();
						}
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
function verificationsAttrbutes(attributes_id){
	var param = {
			attributes_id : attributes_id,
			procedures_id : $("#operation-procedure-id").val(),
			teeth_presence : $("#procedure-attributes-Teeth-Presence").val(),
			teeth_d_value : $("#procedure-attributes-Teeth-Value").val(),
			shade_presence : $("#procedure-attributes-Shade-Presence").val(),
			shade_d_value : $("#procedure-attributes-Shade-Value").val(),
			stump_shade_presence : $("#procedure-attributes-Stump-Shade-Presence").val(),
			stump_shade_d_value : $("#procedure-attributes-Stump-Shade-Value").val(),
			
			alloy_material_presence : $("#procedure-attributes-Alloy-Material-Presence").val()+"",
			alloy_material_d_value : $("#procedure-attributes-Alloy-Material-Value").val()+"",
			coping_presence : $("#procedure-attributes-Coping-Presence").val()+"",
			coping_d_value : $("#procedure-attributes-Coping-Value").val()+"",
			pontic_contours_presence : $("#procedure-attributes-Pontic_Contours-Presence").val()+"",
			pontic_contours_d_value : $("#procedure-attributes-Pontic_Contours-Value").val()+"",
			margin_presence : $("#procedure-attributes-Margin-Presence").val()+"",
			margin_d_value : $("#procedure-attributes-Margin-Value").val()+"",
			rpd_presence : $("#procedure-attributes-RPD-Presence").val()+"",
			rpd_d_value : $("#procedure-attributes-RPD-Value").val()+"",
			contacts_embrasures_presence : $("#procedure-attributes-Contacts_Embrasures-Presence").val()+"",
			contacts_embrasures_d_value : $("#procedure-attributes-Contacts_Embrasures-Value").val()+"",
			occlusal_contact_presence : $("#procedure-attributes-Occlusal_Contact-Presence").val()+"",
			occlusal_contact_d_value : $("#procedure-attributes-Occlusal_Contact-Value").val()+"",
			insufficient_room_presence : $("#procedure-attributes-Insufficient_Room-Presence").val()+"",
			insufficient_room_d_value : $("#procedure-attributes-Insufficient_Room-Value").val()+"",
			retention_presence : $("#procedure-attributes-Retention-Presence").val()+"",
			retention_d_value : $("#procedure-attributes-Retention-Value").val()+"",
			margin_position_presence : $("#procedure-attributes-Margin_Position-Presence").val()+"",
			margin_position_d_value : $("#procedure-attributes-Margin_Position-Value").val()+"",
			emergence_width_presence : $("#procedure-attributes-Emergence_Width-Presence").val()+"",
			emergence_width_d_value : $("#procedure-attributes-Emergence_Width-Value").val()+"",
			staining_presence : $("#procedure-attributes-Staining-Presence").val()+"",
			staining_d_value : $("#procedure-attributes-Staining-Value").val()+"",
			stain_placement_presence : $("#procedure-attributes-Stain_Placement-Presence").val()+"",
			stain_placement_d_value : $("#procedure-attributes-Stain_Placement-Value").val()+"",
			surface_texture_presence : $("#procedure-attributes-Surface_Texture-Presence").val()+"",
			surface_texture_d_value : $("#procedure-attributes-Surface_Texture-Value").val()+"",
			surface_finish_presence : $("#procedure-attributes-Surface_Finish-Presence").val()+"",
			surface_finish_d_value : $("#procedure-attributes-Surface_Finish-Value").val()+"",
			translucency_shade_presence : $("#procedure-attributes-Translucency_Shade-Presence").val()+"",
			translucency_shade_d_value : $("#procedure-attributes-Translucency_Shade-Value").val()+"",
			translucency_volume_presence : $("#procedure-attributes-Translucency_Volume-Presence").val()+"",
			translucency_volume_d_value : $("#procedure-attributes-Translucency_Volume-Value").val()+"",
			
			
			locators_presence : $("#procedure-attributes-locators-Presence").val()+"",
			locators_d_value : $("#procedure-attributes-locators-Value").val()+"",
			id_presence : $("#procedure-attributes-id-Presence").val()+"",
			id_d_value : $("#procedure-attributes-id-Value").val()+"",
			reinforcements_presence : $("#procedure-attributes-Reinforcements-Presence").val()+"",
			reinforcements_d_value : $("#procedure-attributes-Reinforcements-Value").val()+"",
			mould_presence : $("#procedure-attributes-Mould-Presence").val()+"",
			mould_d_value : $("#procedure-attributes-Mould-Value").val()+"",
			tissueAcrylicShade_presence : $("#procedure-attributes-tissueAcrylicShade-Presence").val()+"",
			tissueAcrylicShade_d_value : $("#procedure-attributes-tissueAcrylicShade-Value").val()+"",
			sportsGuardColor_presence : $("#procedure-attributes-sportsGuardColor-Presence").val()+"",
			sportsGuardColor_d_value : $("#procedure-attributes-sportsGuardColor-Value").val()+"",
			
			
			ballClasp_presence : $("#procedure-attributes-ballClasp-Presence").val()+"",
			retentionSpur_presence : $("#procedure-attributes-retentionSpur-Presence").val()+"",
			arrowClasp_presence : $("#procedure-attributes-arrowClasp-Presence").val()+"",
			adamsClasp_presence : $("#procedure-attributes-adamsClasp-Presence").val()+"",
			cclasp_presence : $("#procedure-attributes-cclasp-Presence").val()+"",
			rest_presence : $("#procedure-attributes-rest-Presence").val()+"",
			spring_presence : $("#procedure-attributes-spring-Presence").val()+"",
			labialWire_presence : $("#procedure-attributes-labialWire-Presence").val()+"",
			bitePlate_presence : $("#procedure-attributes-bitePlate-Presence").val()+"",
			expansionScrew_presence : $("#procedure-attributes-expansionScrew-Presence").val()+"",
			pontic_presence : $("#procedure-attributes-pontic-Presence").val()+"",
			crozatClasp_presence : $("#procedure-attributes-crozatClasp-Presence").val()+"",
			color_presence : $("#procedure-attributes-color-Presence").val()+"",
			design_presence : $("#procedure-attributes-design-Presence").val()+"",
			ballClasp_d_value : $("#procedure-attributes-ballClasp-Value").val()+"",
			retentionSpur_d_value : $("#procedure-attributes-retentionSpur-Value").val()+"",
			arrowClasp_d_value : $("#procedure-attributes-arrowClasp-Value").val()+"",
			adamsClasp_d_value : $("#procedure-attributes-adamsClasp-Value").val()+"",
			cclasp_d_value : $("#procedure-attributes-cclasp-Value").val()+"",
			rest_d_value : $("#procedure-attributes-rest-Value").val()+"",
			spring_d_value : $("#procedure-attributes-spring-Value").val()+"",
			labialWire_d_value : $("#procedure-attributes-labialWire-Value").val()+"",
			bitePlate_d_value : $("#procedure-attributes-bitePlate-Value").val()+"",
			expansionScrew_d_value : $("#procedure-attributes-expansionScrew-Value").val()+"",
			pontic_d_value : $("#procedure-attributes-pontic-Value").val()+"",
			crozatClasp_d_value : $("#procedure-attributes-crozatClasp-Value").val()+"",
			color_d_value : $("#procedure-attributes-color-Value").val()+"",
			design_d_value : $("#procedure-attributes-design-Value").val()+"",
			
			
			system_presence : $("#procedure-attributes-system-Presence").val()+"",
			diameter_presence : $("#procedure-attributes-diameter-Presence").val()+"",
			style_presence : $("#procedure-attributes-style-Presence").val()+"",
			marker_presence : $("#procedure-attributes-marker-Presence").val()+"",
			system_d_value : $("#procedure-attributes-system-Value").val()+"",
			diameter_d_value : $("#procedure-attributes-diameter-Value").val()+"",
			style_d_value : $("#procedure-attributes-style-Value").val()+"",
			marker_d_value : $("#procedure-attributes-marker-Value").val()+""

	}
	return param;
}

function editAttrbutes(attributes_id,isNext){
	/***
	 * 第一步：先保存工序信息
	 */
	var type = "add";
	var proceduresId = $("#operation-procedure-id").val();
	//第一次进入页面
	var url = "labAction/setting/saveProcedure.do";
	//第二次增加一般信息后，刷新面板就成了修改，id不为空就是修改
	if(proceduresId!=undefined && proceduresId.trim()!=''){
		type = "update";
		url = "labAction/setting/updateProcedure.do";
	}
	var result = verificationsProcedure(proceduresId);
	if(result!=false){
		$$ajax( {
			url : url,
			data : result,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					if(type=='add'){
						$("#operation-procedure-id").val(JSON.info.id);
						procedure('general',true);//重新加载,刷新内容
					}
					/***
					 * 第二步：保存属性信息
					 */
					if(checkProcedures()){
						type = "add";
						if(attributes_id!=undefined && attributes_id.trim()!=''){
							type = "update";
						}
						$("form[name='procedure-attributes-form'] ul li").each(function (ii){
							var list = $(this);
							for(var i=0;i<list.length;i++){
								$(list.eq(i)).find("select[name='presence']").each(function (j){
									 var presence = $(this).attr("flag");
									 if(presence=='hide'){
										 $(this).val("NOT_APPLICABLE");
									 }
								 });
							}
						});
						var param = verificationsAttrbutes(attributes_id);
						$$ajax( {
							url : "labAction/setting/saveAttrbutes.do?type="+type,
							data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
							beforeSend : function(XMLHttpRequest) {
								$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
							},
							success : function(data, textStatus) {
								var JSON = eval('(' + data + ')');
								if (JSON.result != 'TRUE') {
									alert(JSON.failReasons);
								} else {
									alert(JSON.info);
									if(type=='add'){
										if(isNext=='next'){
											procedure('attributes',true);//重新加载,刷新内容
											procedure('externalLinks');
										}else{
											// 调回首页列表
											goHomeByProcedure();
										}
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

function editPrice(isNext){
	var proceduresId = $("#operation-procedure-id").val();
	if(checkProcedures()){
		var json = new Array();
		$("#price-table tr[name='Each-price']").each(function (ii){
			var list = $(this);
			for(var i=0;i<list.length;i++){
				 var price = "";
				 var attr = new Array();
				 var group = "";
				 $(list[i]).find("td").each(function (j){
					if(j==0){
						price = $(this).html();
					}else if(j==1){
						$(list[i]).find("strong").each(function (k){
							var id = $(this).attr("id");
							var value = $(this).attr("value");
							attr[k]={id:id,value:value}
						});
					}else if(j==2){
						group = $(this).attr("id");
					}
				 });
				 json[ii]={price:price,attr:attr,group:group}
			}
		});
		var param = {
			param:JSON.stringify(json),proceduresId:proceduresId
		}
		$$ajax( {
			url :  "labAction/setting/updatePrice.do",
			data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				var JSON = eval('(' + data + ')');
				if (JSON.result != 'TRUE') {
					alert(JSON.failReasons);
				} else {
					alert("保存成功");
					if(isNext=='next'){
						// 调回首页列表
						goHomeByProcedure();
					}else{
						procedure('pricing');
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

function checkProcedures(){
	var proceduresId = $("#operation-procedure-id").val();
	if(proceduresId==undefined || proceduresId.trim()==''){
		alert('请先增加工序一般信息');
		$("#detils-error-msg").html('请先增加工序一般信息').show();
		return false;
	}
	return true;
}
function savePrice(){
	var select = "";
	var id = $("#edit-price-id").val();
	var price = $("#edit-price-price").val();
	var priceGroup = $("#add-pro-price-group-id").val();
	var priceGroupName = $("#"+priceGroup).html();
	if(priceGroup=='new'){
		priceGroupName = $("#edit-price-new-group").val();
		if(priceGroupName==undefined || priceGroupName.trim()==''){
			alert("组别名称不能为空");
			return;
		}
	}
	var arr = new Array();
	$("select[name='select-price-attr']").each(function (ii){
		var list = $(this);
		for(var i=0;i<list.length;i++){
			var id = $(list.eq(i)).attr("id");
			var labName = $("#"+id+"-label").html();
			var value = $(list.eq(i)).val()+"";
			if(value!="null" && value!=null && value!=undefined && value.trim()!=''){
				var ids = value.split(",");
				var title = "";
				for ( var j = 0; j < ids.length; j++) {
					title+=$("#"+id+"-"+ids[j]).html()+";";
				}
				if(title!="undefined;"){
					arr[ii]={id:id,value:value}
					//select += "<strong id=\""+id+"\" value=\""+value+"\">"+labName+"</strong>："+title+"<br/>";
				}
			}
		}
	});
	var proceduresId = $("#operation-procedure-id").val();
	var param ={proceduresId:proceduresId,price:price,group:priceGroup,attr:arr,newGroupName:priceGroupName}
	//var trid = new Date().getTime();
	//var html = "<tr class=\"LabDetails_f_h\" name=\"Each-price\" id=\""+trid+"\"><td name=\"price\">"+price+"</td><td>"+select+"</td><td id=\""+priceGroup+"\">"+priceGroupName+"</td><td class=\"UserAccounts_a\"><a href=\"javascript:void(0)\" onclick=\"showAddPriceDialog('"+trid+"')\">修改</a><a href=\"javascript:void(0)\" onclick=\"removeTr('"+trid+"');\">删除</a></td></tr>";
	//$("#price-table").append(html);
	$$ajax( {
		url :  "labAction/setting/addOrUpdatePrice.do",
		data : {param:JSON.stringify(param),id:id},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			var JSON = eval('(' + data + ')');
			if (JSON.result != 'TRUE') {
				alert(JSON.failReasons);
			} else {
				$("#add-pro-price-div").dialog('destroy');
				procedure('pricing');
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

function showAddPriceDialog(id){
	if(!checkProcedures()){
		return;
	}
	//查询工序价格属性
	$$ajax( {
		url :  "labAction/setting/queryPriceAttr.do",
		data : {id:$("#operation-procedure-id").val(),priceId:id},type : "POST",async : true,cache : false,global : false,dataType : "html",
		beforeSend : function(XMLHttpRequest) {
			$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
		},
		success : function(data, textStatus) {
			$("#add-pro-price-div").html(data);
			var val = $("#edit-Procedure-Category-select").val();
			var key = $("#"+val).attr("key");
			changeAttrValue(key);
			var title = "增加价格";
			if(id!=null && id!=undefined && id.trim()!=''){
				title = "编辑价格";
			}
			$("#add-pro-price-div").dialog( {
				bgiframe : true,
				autoOpen : false,
				title : title,
				width : 850,
				height : 700,
				modal : true,
				draggable : true,
				resizable : true,
				closeText : "close",
				buttons : {
					'取消' : function() {
						$("#add-pro-price-div").dialog('destroy');
					},
					'保存' : function() {
						var price = $("#edit-price-price").val();
						var priceGroup = $("#add-pro-price-group-id").val();
						if(!parseInt(price)>0){
							alert("请填写正确的价格");
						}else if(priceGroup==null || priceGroup==undefined || priceGroup.trim()==''){
							alert("请选择价格组");
						}else{
							savePrice();
						}
					}
				}
			});
			$("#add-pro-price-div").dialog('open');
		},
		error : function(e) {
			alertError(e);
		},
		complete : function(msg) {
			$("#data-loading-div").hide();
		}
	});
}

function newPriceGroup(value){
	if(value=='new'){
		$("#edit-price-new-group-li").show(500);
	}else{
		$("#edit-price-new-group-li").hide(500);
	}
}


function deleteDisplayCategory(id){
	if (!confirm("确认删除吗？")) {
        return;
    }
	$$ajax( {
		url :  "labProcedureAction/deleteDisplayCategory.do",
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
				query('displayCategories');
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

function showProcedureCharacteristic(type){
	$("#lab_DDXDentalPractice_CaseSetting-characteristic").dialog( {
		bgiframe : true,
		autoOpen : false,
		title : "工序特征",
		width : 1000,
		height : 650,
		modal : true,
		draggable : true,
		resizable : true,
		closeText : "close",
		buttons : {
			'关闭' : function() {
				$("#lab_DDXDentalPractice_CaseSetting-characteristic").dialog('destroy');
			}
		}
	});
	$("#lab_DDXDentalPractice_CaseSetting-characteristic").dialog('open');
	query(type);
}

function onchangePlab(labId){
	if(labId!=undefined && labId.trim()!=''){
		$$ajax( {
			url :  "labAction/setting/loadOutLinkProList.do",
			data : {requestLabId:labId},type : "POST",async : true,cache : false,global : false,dataType : "html",
			beforeSend : function(XMLHttpRequest) {
				$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
			},
			success : function(data, textStatus) {
				$("#out-link-pro-select-div").html(data);
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

function deleteProcedure(id){
	if (!confirm("确认删除吗？")) {
        return;
    }
	if(id!=undefined && id.trim()!=''){
		$$ajax( {
			url :  "labAction/setting/deleteProcedure.do",
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
					query('labProcedures');
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