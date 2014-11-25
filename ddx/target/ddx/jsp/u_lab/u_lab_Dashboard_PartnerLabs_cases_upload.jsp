<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单附件上传</title>
<link href="${pageContext.request.contextPath}/js/tools/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/uploadify/jquery.uploadify.min.js?ver=<%=(new Random()).nextInt(1000000000) %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/uploadify/swfobject.js"></script>
<script type="text/javascript">
$(function(){
	$("#file_upload").uploadify({
	    //开启调试
	    'debug' : false,
	    //是否自动上传
	    'auto':false,
	    //超时时间
	    'successTimeout':99999,
	    'buttonText':'上传附件',
	    //附带值
	    'formData':{
	        'caseId':'${cases.caseId}'
	    },
	    //flash
	    'swf': "../js/tools/uploadify/uploadify.swf",
	    //不执行默认的onSelect事件
	    'overrideEvents' : ['onDialogClose'],
	    //文件选择后的容器ID
	    'queueID':'uploadfileQueue',
	    //服务器端脚本使用的文件对象的名称 $_FILES个['upload']
	    //'fileObjName':'upload',
	    //上传处理程序
	    'uploader':'upload.do',
	    //浏览按钮的背景图片路径
	    //'buttonImage':'upbutton.gif',
	    //浏览按钮的宽度
	    'width':'100',
	    //浏览按钮的高度
	    'height':'32',
	    //expressInstall.swf文件的路径。
	    //'expressInstall':'expressInstall.swf',
	    //在浏览窗口底部的文件类型下拉菜单中显示的文本
	    'fileTypeDesc':'支持的格式：',
	    //允许上传的文件后缀
	    'fileTypeExts':'*.jpg;*.jpge;*.gif;*.png',
	    //上传文件的大小限制
	    'fileSizeLimit':'3MB',
	    'uploadLimit':2,
	    //上传数量
	    'queueSizeLimit' : 2,
	    //每次更新上载的文件的进展
	    'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
	         //有时候上传进度什么想自己个性化控制，可以利用这个方法
	         //使用方法见官方说明
	    },
	    //选择上传文件后调用
	    'onSelect' : function(file) {
	    	/* alert( 'id: ' + file.id 
	    			　　+ ' - 索引: ' + file.index 
	    			　　+ ' - 文件名: ' + file.name 
	    			　　+ ' - 文件大小: ' + file.size 
	    			　　+ ' - 类型: ' + file.type 
	    			　　+ ' - 创建日期: ' + file.creationdate 
	    			　　+ ' - 修改日期: ' + file.modificationdate 
	    			　　+ ' - 文件状态: ' + file.filestatus);    */  
	    },
	    //返回一个错误，选择文件的时候触发
	    'onSelectError':function(file, errorCode, errorMsg){
	        switch(errorCode) {
	            case -100:
	                alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");
	                break;
	            case -110:
	                alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");
	                break;
	            case -120:
	                alert("文件 ["+file.name+"] 大小异常！");
	                break;
	            case -130:
	                alert("文件 ["+file.name+"] 类型不正确！");
	                break;
	        }
	    },
	    //检测FLASH失败调用
	    'onFallback':function(){
	        alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
	    },
	    //上传到服务器，服务器返回相应信息到data里
	    'onUploadSuccess':function(file, data, response){
	    	var data = eval('('+data+')');
	    	var genre = data.genre;
	    	var flag = data.flag;
	    	var obj = data.obj;
	    	if(genre == 'upload'){
	    		if(flag = 'success'){
	    			 var params = {
	    					caseId:obj.caseId,
	    					fileName:obj.fileName,
	    					filePath:obj.filePath
	    			};
	    			saveAttachInfo("/casesAction/addAttachInfo.do",params);
	    		}
	    	}
	    }
	    
	});	
	
	$("#tips").click(function() {
        var $this = $(this);
        $this.parent().siblings("ul").first().toggle("normal");
    });
	
});

function saveAttachInfo(url,params){
	$.ajax({
		url: '${pageContext.request.contextPath}' + url,
		type: 'POST',
		data:params,
		dataType: 'text',
		error: function(){
			flag = false;
		},
		success: function(result){
			if(result == 'success'){
				$("#data-loading-div").find("#msg").html('上传成功，两秒后自动关闭...').end().show().delay(2000).hide(0);
				window.setTimeout(function() {
					if (window.opener && !window.opener.closed) {
	                    window.opener.location.href = window.opener.location.href;
	                    window.close();
	                } else {
	                    window.location = webContext + '/casesAction/getDataById.do?caseId='+params.caseId;
	                }	                
	            }, 2000);
			}else{
				alert('上传失败');
			}
		}

		});
}

</script>
</head>
<body>
<div id="data-loading-div" class="flashload" style="display: none;">
  <table>
    <tr>
      <td>
        <img src="${pageContext.request.contextPath}/img/dataload.gif">
      </td>
      <td id="msg">
        	正在加载数据... ...
      </td>
    </tr>
  </table>
</div>
<div>
<fieldset>
<legend>文件上传</legend>
<p>
给订单#${cases.caseId }上传文件
</p>
<p>
<a href="javascript:void(0)" id="tips"><strong>提示</strong></a>
</p>
<ul style="display: none;">
<li>每次最多上传两个文件</li>
<li>目前仅支持*.jpg;*.jpge;*.gif;*.png格式的文件</li>
<li>每个文件的大小必须小于3M</li>
</ul>
<p>
<div id="uploadfileQueue"></div>
</p>
<p>
<input type="file" name="file_upload" id="file_upload" multipe="multipe" />
</p>
<p>
	<a href="javascript:$('#file_upload').uploadify('upload', '*')">开始上传</a>&nbsp;
</p>
</fieldset>
</div>
</body>
</html>
