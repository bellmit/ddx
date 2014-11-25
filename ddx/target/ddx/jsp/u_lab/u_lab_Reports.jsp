<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.Date"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit.DateUtil"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Calendar"%><html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>工厂实验室报告</title>
		<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/reports_remake.js"></script>
		<script type="text/javascript">
			function updateImgs(obj){
				obj.src = webContext + "/kaptchaAction/getVerify.do?" + Math.floor(Math.random() * 100);
			}
			function showResults(){
				if($("#Finance-result-div").attr("flag")=='hide'){
					$("#Finance-result-div").show(500);
					$("#Finance-result-div").attr("flag",'show');
				}else if($("#Finance-result-div").attr("flag")=='show'){
					$("#Finance-result-div").hide(500);
					$("#Finance-result-div").attr("flag",'hide');
				}
			}
		</script>
	</head>
	<body>
		<div id="no-data-div" class="flashload" style="display: none;">
		  <table>
		    <tr>
		      <td>
		        <img src="${pageContext.request.contextPath}/img/dataload.gif">
		      </td>
		      <td id="msg">
		        	没有数据... ...
		      </td>
		    </tr>
		  </table>
		</div>
		<div class="page">
			<!--底部开始-->
			<jsp:include page="../head.jsp" />
			<!--头部结束-->
			<!--中间开始-->
			<div class="center">
				<!--工厂实验室会员中心开始-->
				<div class="reports">
					<div class="reports_top" style="margin-top: 30px;">
						报告
					</div>
					<div class="reports_bottom">
						<div class="reports_bottom_a">
							<a href="javascript:void(0)" onclick="$('.reports_bottom_c').slideToggle();">订单重做</a>
						</div>
						<div class="reports_bottom_b">
							查看已被重做的订单和原因。
						</div>
						<div class="reports_bottom_c" style="display: none;">
							<div class="reports_bottom_c_a">搜索条件</div>
							<div class="reports_bottom_c_b">
							<div class="reports_bottom_c_b_top"></div>
							<div class="reports_bottom_c_b_middle">
							<form action="" method="post">
							<ul>
							<li>
							<div class="reports_bottom_c_b_middle_left"><span>开始时间</span><span class="reports_bottom_c_b_middle_a">*</span></div>
							<div class="reports_bottom_c_b_middle_right">
								<input name="startDate" id="startDate" type="text" onclick="WdatePicker()" class="reports_bottom_c_b_middle_b"/>
							</li>
							<li>
							<div class="reports_bottom_c_b_middle_left"><span>结束时间</span><span class="reports_bottom_c_b_middle_a">*</span></div>
							<div class="reports_bottom_c_b_middle_right">
								<input name="endDate" id="endDate" type="text" onclick="WdatePicker()" class="reports_bottom_c_b_middle_b"/>
							</div>
							</li>
							<li>
							<div class="reports_bottom_c_b_middle_left"><span>临床</span></div>
							<div class="reports_bottom_c_b_middle_right">
								<select id="unitId" class="reports_bottom_c_b_middle_b" name="practice_id">
									<option label="All" value="">All</option>
									${filterOptions }
								</select>
							</div>
							</li>
							<li>
							<div class="reports_bottom_c_b_middle_left"><span>格式</span><span class="reports_bottom_c_b_middle_a">*</span></div>
							<div class="reports_bottom_c_b_middle_right">
								<select class="reports_bottom_c_b_middle_b" name="format" id="cases_remakes_format">
									<option value="">On Screen</option>
									<option value="csv">Csv(Excel)</option>
								</select>
							</div>
							</li>
							<li>
							<div class="reports_bottom_c_b_middle_left"></div>
							<div class="reports_bottom_c_b_middle_right">
							<span class="reports_bottom_c_b_middle_c"><a href="javascript:void(0)" onclick="queryCaseRemake()">查询</a></span>
							</div>
							</li>
							</ul>
							</form>
							</div>
							<div class="reports_bottom_c_b_bottom"></div>
							</div>
							</div>
						<div class="reports_bottom_a">
							<a href="${pageContext.request.contextPath}/labAction/reports/patients.do">患者</a>
						</div>
						<div class="reports_bottom_b">
							查看患者的记录。
						</div>
						<div class="reports_bottom_a">
							<a href="javascript:void(0)" onclick="showResults();">财务报表</a>
						</div>
						<div class="reports_bottom_b">
							查看您的技工间的财务报表
						</div>
						<div id="Finance-result-div" style="width: 100%;margin-left: 15px;display: none;" flag="hide">
							<table style="width: 100%;">
								<tr>
									<%
										Date date = ToolsKit.DateUtil.nowDate();
									%>
										<td style="width: 10%;"><input type="radio" checked="checked" name="report-radio" value="<%=ToolsKit.DateUtil.formatDate(date,"yyyy-MM") %>"/><%=ToolsKit.DateUtil.formatDate(date,"yyyy年MM月") %></td>
									<%
										for (int i = 1; i <=5; i++) {
											Date dates = ToolsKit.DateUtil.add(date,Calendar.MONTH,-i);
									%>
										<td style="width: 10%;"><input type="radio" name="report-radio" value="<%=ToolsKit.DateUtil.formatDate(dates,"yyyy-MM") %>"/><%=ToolsKit.DateUtil.formatDate(dates,"yyyy年MM月") %></td>
									<%
										}
									%>
									<td style="width: 50%;"></td>
								</tr>
								<tr>
									<td colspan="6"><input type="radio" name="report-radio" value="custom"/>自定义时间：
									<input type="text" id="custom-reports-date-begin" onclick="WdatePicker({el:'custom-reports-date-begin'})" readonly="readonly"/>
									~
									<input type="text" id="custom-reports-date-end" onclick="WdatePicker({el:'custom-reports-date-end'})"  readonly="readonly"/></td>
								</tr>
								<!-- 
								<tr>
									<td colspan="6">
											验证码：
										<input type="text" id="reports-valicode"/>
										<a href="javascript:void(0)">
                                           <img title="点击刷新验证码" src="${pageContext.request.contextPath}/kaptchaAction/getVerify.do" onclick="updateImgs(this);"/>
                                        </a>
									</td>
								</tr>
								 -->
								<tr>
									<td colspan="3" class="UserAccounts_a" align="left">
											<a onclick="financeResults()" href="javascript:void(0)">查询</a>
									</td>
									<td colspan="3"></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<!--工厂实验室会员中心结束-->
			</div>
			<!--中间结束-->
			<!--底部开始-->
			<jsp:include page="../bottom.jsp" />
			<!--底部结束-->
		</div>
	</body>
</html>
