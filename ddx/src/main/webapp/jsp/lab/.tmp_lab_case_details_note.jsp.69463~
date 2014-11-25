<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>note</title>
<link href="${pageContext.request.contextPath}/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
(function($){
	$(document).ready(function(){
		//支持的浏览器有： 火狐、谷歌、360、ie8及以上版本
		CKEDITOR.replace('case_note');
		
		CKEDITOR.on( 'instanceReady', function( ev ){
			$('#ckeditor_able').val('Y');
		});
		
		$('#caseId').click(function(){
			var ck_able = $('#ckeditor_able').val();
			var content = '';
			if(ck_able == 'Y'){
				content = CKEDITOR.instances.case_note.getData()
			}else{
				content = $('#case_note').val();
			}
	
			if (content == "") {
				$('#case_note_info').show();
				alert('内容不能为空');
				$('#case_note_info').find('i').eq(0).html('内容不能为空');
				return;
			}else if(content.length > 300){
				$('#case_note_info').show();
				alert('标签字数过多');
				$('#case_note_info').find('i').eq(0).html('标签字数过多');
				return;
			}else{
				$('#case_note_info').hide();
			}
			
			 $.post(
	    			 "/ddx" + "/casesAction/cases/addNote.do",
	    			 {
	    				 caseId:$('#caseId').val(),
	    				 caseNote:content	 
	    			 },
	    			 function(result){
	    				 var JSON = eval('(' + result + ')');
	    				 var flag = JSON.flag;
	            		 if(flag == 'success'){
	            			 parent.location.reload();
	            			 window.close();		            			 
	            		 }
	    	});
		});
	});         
})(jQuery);
</script>
</head>
<body>
<form id="case_note_form" accept-charset="utf-8" name="case_note_form" method="post" >
<div style="height: 90%;width: 98%;">
	<div>
		<input type="hidden" id="caseId" name="caseId" value="${cases.caseId }" />
		<input type="hidden" id="ckeditor_able" value="" />
	</div>
	<div>
		<textarea id="case_note" rows="10" cols="60" name="case_note"></textarea>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/ckeditor/ckeditor.js"></script>
	</div>
<div id="case_note_info" style="display: none;">
	<div class="PartnerLabsadminqianjin_right_middle_left">&nbsp;</div>
	<div class="PartnerLabsadminqianjin_right_middle_right"><i class="practiceindex_Invite_cuowu_a">内容不能为空</i></div>
</div>
</div>
</form>
</body>
</html>