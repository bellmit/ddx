<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/practice/css/practice.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/lab/css/lab.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/jsp/box/css/box.css"  rel="stylesheet" type="text/css"/>
<div class="top">
	<div class="top_a">
		<div class="top_a_left">
			<a href="#"><img src="${pageContext.request.contextPath}/jsp/common/images/loginlogo.gif" /></a>
		</div>
			<!-- 头部会话窗口-->
			<jsp:include page="../session.jsp"/>
	</div>
	<div class="top_b">
		<div class="top_b_left">
			<!-- 头部菜单 -->
			<jsp:include page="menu-practice.jsp" />
		</div>
		<div class="top_b_right">
			<!-- 头部搜索窗口 -->
			<jsp:include page="../serache.jsp" />
		</div>
	</div>
</div>
<script type="text/javascript"	src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.easing.1.3.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/jsp/u_lab/js/xixi.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/practice/js/practice_index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/partner-lab.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>

<script type="text/javascript">
	$(function() {
		$(".menu_all .first").click(function() {
			$(this).find(".menuu_xiao").toggle();
			$(".menu_all .first1").find(".menuu_xiao").hide();
		});
		$(".menu_all .first1").click(function() {
			$(this).find(".menuu_xiao").toggle();
			$(".menu_all .first").find(".menuu_xiao").hide();
		});
		$(document).on(
				'click',
				function(e) {
					if ($('.menu_all li').is(e.target)
							|| $('.menu_all li').has(e.target).length) {
						return;
					}
					$('.menuu_xiao').hide();

				});
	});
	
	$(function(){		
		 $(".menu_all .menuright").click(function(){
			$(this).find(".menuright01").toggle();
			$(this).siblings().find(".menuright01").hide();
		});			
		 $(document).on('click', function(e) {
        if ($('.menu_all li').is(e.target) || $('.menu_all li').has(e.target).length) {
          return;
		}
              $('.menuright01').hide();

  });
		 });

	function initHtml(){
		$('#Search-PartnerLabs-div').show();
		$("#hideSearch-span").hide();
	}
</script>