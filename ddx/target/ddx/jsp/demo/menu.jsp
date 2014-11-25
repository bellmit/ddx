<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>ddx</title>
</head>
<jsp:include page="../head.jsp" />
<script type="text/javascript">
	function deleteUser(){
		var ids = $("#delete-user-id").val();
		if(ids.trim().length==0){
			alert("请输入ID！");
			return;
		}
		// 获取参数
		var param = {
				ids:ids
				}
			$$ajax( {
				// 发送请求地址
				url : "deleteUser.do",
				data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				// 获取返回值
				success : function(data, textStatus) {
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert("删除失败，原因: " + JSON.failReasons);
					} else {
						alert("删除成功");
					}
				},
				error : function(e) {
					alertError(e);
				},
				complete : function(msg) {
					$("#data-loading-div").hide();
				}
			})
	}
	function addUser(){
		var name = $("#add-user-name").val();
		if(name.trim().length==0){
			alert("请输入name！");
			return;
		}
		// 获取参数
		var param = {
				name:name
				}
			$$ajax( {
				// 发送请求地址
				url : "addUser.do",
				data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				// 获取返回值
				success : function(data, textStatus) {
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert("增加失败，原因: " + JSON.failReasons);
					} else {
						alert("增加成功");
					}
				},
				error : function(e) {
					alertError(e);
				},
				complete : function(msg) {
					$("#data-loading-div").hide();
				}
			})
	}


	function updateUser(){
		var id = $("#update-user-id").val();
		var name = $("#update-user-name").val();
		if(id.trim().length==0 || name.trim().length==0){
			alert("请输入ID和name！");
			return;
		}
		// 获取参数
		var param = {
				id:id,
				name:name
				}
			$$ajax( {
				// 发送请求地址
				url : "updateUser.do",
				data : param,type : "POST",async : true,cache : false,global : false,dataType : "html",
				beforeSend : function(XMLHttpRequest) {
					$("#data-loading-div").find(".msg").html('正在拼命的加载数据...').end().show();
				},
				// 获取返回值
				success : function(data, textStatus) {
					var JSON = eval('(' + data + ')');
					if (JSON.result != 'TRUE') {
						alert("修改失败，原因: " + JSON.failReasons);
					} else {
						alert("修改成功");
					}
				},
				error : function(e) {
					alertError(e);
				},
				complete : function(msg) {
					$("#data-loading-div").hide();
				}
			})
	}
</script>
<body>
<table>
	<tr>
		<td><a href="getUser.do">查看用户信息</a></td>
	</tr>
	<tr>
		<td>ID：<input type="text" id="delete-user-id" /><a
			href="javascript:void(0)" onclick="deleteUser();">删除用户</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>

		<td>用户名：<input type="text" id="add-user-name" /><a
			href="javascript:void(0)" onclick="addUser();">新增用户</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>

		<td>ID：<input type="text" id="update-user-id" />用户名：<input
			type="text" id="update-user-name" /><a href="javascript:void(0)"
			onclick="updateUser();">修改用户</a></td>
	</tr>
</table>
</body>
</html>