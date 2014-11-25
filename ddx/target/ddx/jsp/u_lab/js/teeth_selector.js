/**
 * 选牙齿相关代码
 */

//显示teeth选择dialog
function showTeethDialog(obj) {
	var _confirm = false;
    $("#selector_teeth_dialog").dialog({
        resizable: true,
        height: 530,
        width: 760,
        modal: true,
        title: '选择牙齿',
        buttons: {
            "确定": function() {
            	setTeethValue($(this),obj);
            	_confirm = true;
            	$(this).dialog('close');
			}
        },
        open:function(){
        	_setTeethDialog($(this),obj);
        	_setTeethInfo(obj);
        },
        close:function(){
        	if(_confirm){
        		_clearTeethInfo($(this));                        		
        	}
        }
    });
	
}

//区分牙齿部位
function specifyRegions(){
	if($("#specify_regions").is(":checked")){
		$("#shade_whole").val('');
		$("#whole").hide();
		$("#regions").show();
	}else{
		$("#shade_g").val('');
		$("#shade_b").val('');
		$("#shade_i").val('');
		$("#whole").show();
		$("#regions").hide();
	}							
}

//判断值是否为空
function isNull(obj){
	var flag = 0;
	if(obj == undefined || obj == ''){
		flag = !flag;
	}
	return flag;
}

//是否存在值 
function _specifyValue(){
	var flag = false;
	if($('#shade_whole').val() != ''){
		flag = true;
	}
	if($('#shade_g').val() != ''){
		flag = true;
	}
	if($('#shade_b').val() != ''){
		flag = true;
	}
	if($('#shade_i').val() != ''){
		flag = true;
	}
	return flag;
}

//selector_shade_dialog保存信息 
function _getShadeValue($this){
	if(_specifyValue()){
		if($this.attr('ttype')=='shade_selector'){
			$this.parent().addClass("selected");            				
		}else{
			$this.parent().addClass("selected01");
		}
	}else{
		if($this.attr('ttype')=='shade_selector'){
			$this.parent().removeClass("selected");            				
		}else{
			$this.parent().removeClass("selected01");
		}
	}
	if($('#shade_whole').val() != ''){
		$this.attr('data-whole',$('#shade_whole').val()).addClass("saved_data");
	}else{
		$this.attr('data-whole',$('#shade_whole').val()).removeClass("saved_data");
		$this.attr('data-g',$('#shade_g').val()).addClass($('#shade_g').val() != '' ? "saved_data":"");
		$this.attr('data-b',$('#shade_b').val()).addClass($('#shade_b').val() != '' ? "saved_data":"");
		$this.attr('data-i',$('#shade_i').val()).addClass($('#shade_i').val() != '' ? "saved_data":"");
	}
}

//selector_shade_dialog初始化
function _open($this){
	var data_whole = $this.attr('data-whole');
	if(data_whole != undefined){
		$('#shade_whole').val(data_whole);
	}else{
		$('#shade_g').val($this.attr('data-g'));
		$('#shade_b').val($this.attr('data-b'));
		$('#shade_i').val($this.attr('data-i'));
	}
	if($("#specify_regions").is(":checked")){
		$("#whole").hide();
		$("#regions").show();
	}else{
		$("#whole").show();
		$("#regions").hide();
	}
}

//清除弹出框的值 
function clearShade(){
	if($("#specify_regions").is(":checked")){
		$("#specify_regions").removeAttr("checked");
		$("#shade_g").val('');
		$("#shade_b").val('');
		$("#shade_i").val('');
		$("#whole").show();
		$("#regions").hide();
	}else{
		$("#shade_whole").val('');
	}
	
	$('.box_shade>ul').show();
}

//牙齿、比色卡赋值 
function setTeethValue(obj,teethObj){
  	var $this = obj;
  	var $teeth = $(teethObj);
  	//牙位 
		var teeth = new Array();
		//teeth shade
		var shade = new Array();
		//teeth stump
		var stump = new Array();
  	//循环获取选中的 td（牙齿区域）
  	$("td[class='t_c']").each(function (ii){
  		//当前td对象 
  		var $this = $(this);
			var tt = $this.find('span').eq(0).text();
  		teeth.push(tt);
  		var ixs = $this.find('a');
  		var whole_shade = $this.find('a').eq(0).attr('data-whole');
  		var g_shade = $this.find('a').eq(0).attr('data-g');
  		var b_shade = $this.find('a').eq(0).attr('data-b');
  		var i_shade = $this.find('a').eq(0).attr('data-i');
  		!isNull(whole_shade) ?shade.push(whole_shade + ' ' + tt):'';
  		!isNull(g_shade) ?shade.push(g_shade + ' ' + tt + ' G'):'';
  		!isNull(b_shade) ?shade.push(b_shade + ' ' + tt + ' B'):'';
  		!isNull(i_shade) ?shade.push(i_shade + ' ' + tt + ' I'):'';
  		
  		var whole_stump = $this.find('a').eq(1).attr('data-whole');
  		var g_stump = $this.find('a').eq(1).attr('data-g');
  		var b_stump = $this.find('a').eq(1).attr('data-b');
  		var i_stump = $this.find('a').eq(1).attr('data-i');
  		!isNull(whole_stump) ?stump.push(whole_stump + ' ' + tt):'';
  		!isNull(g_stump) ?stump.push(g_stump + ' ' + tt + ' G'):'';
  		!isNull(b_stump) ?stump.push(b_stump + ' ' + tt + ' B'):'';
  		!isNull(i_stump) ?stump.push(i_stump + ' ' + tt + ' I'):'';
  		
  	});
  	var teeth_attr_div = $teeth.parents('div').eq(1);
  	teeth_attr_div.find('#getTeeth_presence').eq(0).val(teeth.join(','));
   	teeth_attr_div.find('#getStump_shade_presence').eq(0).val(stump.join(';'));
   	teeth_attr_div.find('#getShade_presence').eq(0).val(shade.join(';'))
  }

//牙齿信息清除 
function _clearTeethInfo(obj){
	$("td[class='t_c']").each(function (ii){
 		//当前td对象 
 		var $this = $(this);
 		//shade 
 		var a = $this.find('a').eq(0);
 		if(a.hasClass('saved_data')){
 			a.removeClass('saved_data');
 			a.attr('data-whole','');
 			a.attr('data-g','');
 			a.attr('data-b','');
 			a.attr('data-i','');
 			a.parent().removeClass('selected');
 		}
 		// stump shade
 		var b = $this.find('a').eq(1);
 		if(b.hasClass('saved_data')){
 			b.removeClass('saved_data');
 			b.attr('data-whole','');
 			b.attr('data-g','');
 			b.attr('data-b','');
 			b.attr('data-i','');
 			b.parent().removeClass('selected01');
 		}
 		$this.removeClass('t_c');
 		
 	});
}

//打开时要判断Teeth 、Shade、Stump Shade这三个属性 是否存在
function _setTeethDialog(thisDiloag,obj){
	/**
	 *	有几种情况:1/只有Teeth;2/有shade,无Stump Shade;3/有Stump Shade,无Shade 
	 */
	var $this = $(obj).closest('div[name=procedure-div]');
	var teeth_attr = $this.find('#getTeeth_presence');
	var shade_attr = $this.find('#getShade_presence');
	var stump_attr = $this.find('#getStump_shade_presence');
	shade_attr.length==0?thisDiloag.find('span.tooth_select').hide():thisDiloag.find('span.tooth_select').show();
	stump_attr.length==0?thisDiloag.find('span.tooth_select01').hide():thisDiloag.find('span.tooth_select01').show();
	 
}

//牙齿信息 设置 
function _setTeethInfo(obj){
	var $this = $(obj).closest('div[name=procedure-div]');
	var teeth_v = $this.find('#getTeeth_presence').eq(0).val();
	var shade_v = $this.find('#getShade_presence').eq(0).val();
	var stump_v = $this.find('#getStump_shade_presence').eq(0).val();
	//选择的牙齿数组
	var teeth_array = new Array();
	
	teeth_array = getTeethPos(teeth_v,shade_v,stump_v);

	for(var i=0;i<teeth_array.length;i++){
		if(teeth_array[i]!=undefined){
			$('#selector_td_'+teeth_array[i]).addClass('t_c');
		}
	}
	
	//选择的shade
	var teeth_shade_arry = new Array();
	if(shade_v != undefined && shade_v != ''){
		teeth_shade_arry = shade_v.split(';');
		for(var i=0;i<teeth_shade_arry.length;i++){
			var tsa_array =teeth_shade_arry[i].split(' ');
			if(tsa_array.length == 3){
				//tsa_array[2] is for the teeth position
				//tsa_array[0] is for the teeth color
				//tsa_array[1] is for the teeth part
				var t_position = tsa_array[1];
				var t_color = tsa_array[0];
				var t_part = tsa_array[2];
				var attr = (t_part == 'G')?'data-g':(t_part == 'B'?'data-b':'data-i');
				$('#selector_td_'+t_position).hasClass('t_c')?$('#selector_td_'+tsa_array[1]).addClass('t_c'):'';
				$('#selector_td_'+t_position).find('a[ttype=shade_selector]').eq(0).attr(''+attr+'',t_color).addClass('saved_data');
				$('#selector_td_'+t_position).find('a[ttype=shade_selector]').eq(0).parent().addClass('selected');
			}else if(tsa_array.length == 2){
				var t_position = tsa_array[1];
				var t_color = tsa_array[0];
				$('#selector_td_'+t_position).hasClass('t_c')?$('#selector_td_'+tsa_array[1]).addClass('t_c'):'';
				$('#selector_td_'+t_position).find('a[ttype=shade_selector]').eq(0).attr('data-whole',t_color).addClass('saved_data');
				$('#selector_td_'+t_position).find('a[ttype=shade_selector]').eq(0).parent().addClass('selected');
			}
		}
	}
	
	//选择的stump shade
	var teeth_stump_arry = new Array();
	if(stump_v != undefined && stump_v != ''){
		teeth_stump_arry = stump_v.split(';');
		for(var i=0;i<teeth_stump_arry.length;i++){
			var tsa_array = teeth_stump_arry[i].split(' ');
			if(tsa_array.length == 2){
				var t_position = tsa_array[1];
				var t_color = tsa_array[0];
				$('#selector_td_'+t_position).hasClass('t_c')?$('#selector_td_'+tsa_array[1]).addClass('t_c'):'';
				$('#selector_td_'+t_position).find('a[ttype=stump_selector]').eq(0).attr('data-whole',t_color).addClass('saved_data');
				$('#selector_td_'+t_position).find('a[ttype=stump_selector]').eq(0).parent().addClass('selected01');
			}
		}
	}
	
}

function getTeethPos(teeth_v,shade_v,stump_v){
	var teeth_array = new Array();
	if(teeth_v != undefined && teeth_v != ''){
		teeth_array = teeth_v.split(',')
	}
	
	
	var teeth_shade_arry = new Array();
	if(shade_v != undefined && shade_v != ''){
		teeth_shade_arry = shade_v.split(';');
		for(var i=0;i<teeth_shade_arry.length;i++){
			var tsa_array =teeth_shade_arry[i].split(' ');
			teeth_array.push(tsa_array[1]);
		}
	}
	
	var teeth_stump_arry = new Array();
	if(stump_v != undefined && stump_v != ''){
		teeth_stump_arry = stump_v.split(';');
		for(var i=0;i<teeth_stump_arry.length;i++){
			var tsa_array = teeth_stump_arry[i].split(' ');
			teeth_array.push(tsa_array[1]);
		}
	}
	//js数组去重
	var n = {},r=[]; //n为hash表，r为临时数组
	for(var i = 0; i < teeth_array.length; i++) //遍历当前数组
	{
		if (!n[teeth_array[i]]) //如果hash表中没有当前项
		{
			n[teeth_array[i]] = true; //存入hash表
			r.push(teeth_array[i]); //把当前数组的当前项push到临时数组里面
		}
	}
	return r;

}

