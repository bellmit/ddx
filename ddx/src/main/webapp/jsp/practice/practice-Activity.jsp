<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<div class="practicerliebiao_a">
	<div class="practicerliebiao_a_left">
		<span>查看</span>
	</div>
	<div class="Lab_b_right_middle_bottom_b_right">
		<ul style="margin: 0px; padding: 0px;">
			<li class="top_b_right_a"
				style="margin: 0px; padding: 0px;width: 180px;">
				<form action="" method="get">
					<span class="top_b_right_a_left"> <input
							name="log_type" type="text" id="log_type"
							class="log large"
							style="height: 13px; * line-height: 13px; * vertical-align: middle;cursor: pointer;" />
					</span>
					<span class="top_b_right_a_right"> <!--<input	name="" type="image" src="${pageContext.request.contextPath}/jsp/u_lab/images/select.jpg"/>-->
						<img src="${pageContext.request.contextPath}/jsp/u_lab/images/select.jpg" style="cursor: pointer;" id="showOrHide-img"></img> </span>
				</form>
			</li>
		</ul>
		<div>
			<jsp:include page="../box/box_select.jsp" />
		</div>
	</div>
	<div class="practicerliebiao_a_right">
		<a href="#">订阅</a>
	</div>
</div>
<div class="practicerliebiao">
	<jsp:include page="../lab/lab-main-log.jsp"/>
</div>
<div>
	<div class="Lab_b_right_middle_bottom_d_b" style="float:left">
		<a href="#">新动态</a>
	</div>
	<div class="" style="float:left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div class="Lab_b_right_middle_bottom_d_a" style="float:left">
		<a href="#">旧动态</a>
	</div>
</div>
