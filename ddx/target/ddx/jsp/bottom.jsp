<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="bottom">
<div class="bottom_left">
<ul>
	<li><a href="javascript:showLabSignupTerms();">使用条款</a></li>
	<li><a href="javascript:suggestions();">建议或意见</a></li>
	<li><a href="javascript:;privacy();">隐私政策</a></li>
</ul>
</div>
<div class="bottom_right">
<div class="bottom_middle">爱尔创技术支持</div>
<div class="bottom_right01">深圳爱尔创科技股份有限公司版权所有</div>
</div>
</div>

<!-- 使用条款 -->
<div id="lab-signup-terms" style="display: none;">
	<jsp:include page="login_lab/terms.jsp"></jsp:include>
</div>
<!-- 服务条款 -->
<div id="lab-signup-service-agree" style="display: none;">
	<jsp:include page="login_lab/service.jsp"></jsp:include>
</div>
<!-- 建议或意见 -->
<div id="lab-suggestions" style="display: none;">
	<table>
		<tr>
			<td>
				<textarea rows="20" cols="100"></textarea>
			</td>
		</tr>
	</table>
</div>
<!--隐私政策-->
<div id="lab_privacy" style="display: none;">
	<jsp:include page="login_lab/privacy.jsp"></jsp:include>
</div>