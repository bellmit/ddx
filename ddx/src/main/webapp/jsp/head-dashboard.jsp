<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<link href="${pageContext.request.contextPath}/jsp/box/css/box.css"  rel="stylesheet" type="text/css"/>
<div class="top">
	<div class="top_a">
		<div class="top_a_left">
			<a href="#"><img src="${pageContext.request.contextPath}/jsp/common/images/loginlogo.gif" /></a>
		</div>
			<!-- 头部会话窗口-->
			<jsp:include page="session.jsp"/>
	</div>
	<div class="top_b">
		<div class="top_b_left">
			<!-- 头部菜单 -->
			<jsp:include page="box/menu-dashboard.jsp" />
		</div>
		<div class="top_b_right">
			<!-- 头部搜索窗口 -->
			<jsp:include page="serache.jsp" />
		</div>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/u_lab_cases.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/teeth_selector.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/xixi.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/tagit.js"></script>
<script type="text/javascript">
     $(document).ready(function() {

    	 var v = ','+'${cases.enclosures}'+',';
         $('#enclosures option').each(function(){
           if(v.indexOf(','+this.value+',')!=-1){
        	   this.selected=true;
           }
         });
         
	  });
</script>