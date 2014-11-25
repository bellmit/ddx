<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<script type="text/javascript">
	function resLogin(webContext){
		window.location.href = "http://"+location.host+webContext;
	}
</script>
</head>
<body>
<h1>您的会话超时了！！！！！！！！<a href="javascript:void(0)" onclick="resLogin('${pageContext.request.contextPath}');">重新登录</a></h1>
</body>
</html>
