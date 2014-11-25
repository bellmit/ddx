<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.springframework.web.context.ContextLoader"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.upcera.ddx.service.user.IUserService"%>
<%@page import="com.upcera.ddx.entity.User"%>
<%@page import="com.upcera.ddx.service.lab.ILabService"%>
<%@page import="com.upcera.ddx.entity.Lab"%>
<%@page import="com.upcera.ddx.service.practice.IPracticeService"%>
<%@page import="com.upcera.ddx.entity.Practice"%>
<%@page import="java.util.List"%>
<%@page import="com.upcera.ddx.common.security.CtyptoUtil"%>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="com.upcera.ddx.constans.Constans"%>
<%@page import="java.util.Map"%><link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
<jsp:include page="common.jsp" />
<jsp:include page="box/box_AddUserAccount.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/session.js"></script>
<script type="text/javascript">
	$(function(){
		$(".menu01 .first").click(function(){
			$(this).find(".menu_s").toggle();
			$(this).siblings().find(".menu_s").hide();
		});   
	});
</script>
<% 
	WebApplicationContext con = ContextLoader.getCurrentWebApplicationContext();
	IUserService userService = con.getBean(IUserService.class);
	User user = userService.getSessionUserByLoginEmail();
	ILabService labService = con.getBean(ILabService.class);
	IPracticeService practiceService =  con.getBean(IPracticeService.class);
	
%>
<div class="top_a_right">
	<ul class="menu01">
    	<li class="first" style="color: #FFFFFF;text-decoration:underline;cursor: pointer;padding: 1px;"><%=user.getFirstName() %><%=user.getLastName() %>
	   	 	<div class="menu_sa"> 
	              <div class="menu_ss"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg05.png" width="225" height="10" /></div>
	              <div class="menu_s1">
	                	<p class="sec">
	                		<s:authorize ifAllGranted="ROLE_LAB">
	                			<a href="${pageContext.request.contextPath}/userAction/getUser.do?userId=<%=user.getAccountId() %>">我的账户</a>
	                		</s:authorize>
	                		<s:authorize ifAllGranted="ROLE_PRACTICE">
	                			<a href="${pageContext.request.contextPath}/practiceAction/getUser.do?userId=<%=user.getAccountId() %>">我的账户</a>
	                		</s:authorize>
	                	</p>
	                    <h1 style="color: black">切换到</h1> 
	                    <%
	                   //查找我的主用户
                	   User manUser = userService.get(ToolsKit.EmptyCheckUtil.isNotEmpty(user.getParentId())?user.getParentId():0);
	                    if(ToolsKit.EmptyCheckUtil.isNotEmpty(manUser)){
	                  		String manPassword = CtyptoUtil.DecryptString(manUser.getPassword());
	                  		if(ToolsKit.EmptyCheckUtil.isNotEmpty(manUser.getLabId())){
	               				Lab ilab = labService.get(manUser.getLabId());%>
	                  					<p class="sec04"><a href="javascript:void(0)" 
	                  					onclick="switchLogin('${pageContext.request.contextPath}/lab_login','<%=manUser.getEmail() %>','<%=manPassword %>');"><%=manUser.getLastName() %>@<%=ilab.getName() %></a></p>
	                  		<%}
	               			if(ToolsKit.EmptyCheckUtil.isNotEmpty(manUser.getPracticeId())){
	               				Practice ipra = practiceService.get(manUser.getPracticeId());%>
	                  					<p class="sec04"><a href="javascript:void(0)" 
	                  					onclick="switchLogin('${pageContext.request.contextPath}/practice_login','<%=manUser.getEmail() %>','<%=manPassword %>');"><%=manUser.getLastName() %>@<%=ipra.getName() %></a></p>
	                  		<%}
	                    }
	                  	//查找组内成员用户（当前用户为主用户）
	                  	List<Map<String, Object>> resultMap = userService.getSessionUserGroupUnit(user.getAccountId());
	                  	if(ToolsKit.EmptyCheckUtil.isEmpty(resultMap)){
	                  		//查找组内兄弟用户（当前用户为子用户）
	                  		if(ToolsKit.EmptyCheckUtil.isNotEmpty(manUser)){
	                  			resultMap = userService.getSessionUserGroupUnit(manUser.getAccountId());
	                  		}
	                  	}
	                  	if(ToolsKit.EmptyCheckUtil.isNotEmpty(resultMap)){
              				for(int i=0;i<resultMap.size();i++){%>
               					<p class="sec01">
                   					<a href="javascript:void(0)" 
                   					onclick="switchLogin('${pageContext.request.contextPath}/<%=resultMap.get(i).get("logType")%>',
                   					'<%=resultMap.get(i).get("userEmal")%>',
                   					'<%=CtyptoUtil.DecryptString(String.valueOf(resultMap.get(i).get("password"))) %>');">
                   						<%=resultMap.get(i).get("userLastName")%>@<%=resultMap.get(i).get("unitName")%>
                   					</a>
               					</p>
               				<%}
              			}
                    	if(ToolsKit.EmptyCheckUtil.isEmpty(manUser)){%>
                    			<p class="sec02"><a href="javascript:void(0)" onclick="showAddUserGroupDialog();">绑定账户</a></p>
                    	<%} %>                   
	                    <p class="sec03"><a href="${pageContext.request.contextPath}/lab_logout">注销</a></p>
	        	 </div>
	            <div class="menu_s2"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg04.png" width="225" height="4" /></div>
	            <div>
	            	<form action="" method="post" name="switchForm" id="switchForm">
	            		<input type="hidden" id="switchForm-username" name="j_username"/>
						<input type="hidden" id="switchForm-password" name="j_password"/>
	            	</form>
	            </div>
	         </div>
        </li>
        <li class="first" style="color: #FFFFFF;padding: 1px;">@</li>
        <%
        	boolean islab = false;
	    	if(Constans.UNIT_LAB.equals(user.getUnitType())){
	    		islab = true;
	    }%>
        <li class="first" style="color: #FFFFFF;text-decoration:underline;cursor: pointer;padding: 1px;"><%=userService.getSessionUnitName() %>
		   	  <div class="menu_sa" style="width: 160px;">
                  <div class="menu_ss"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg06.png" width="160" height="10" /></div>
	              <div class="menu_ss1">
               			<%if(islab){%>
             					<p class="secc03"><a href="${pageContext.request.contextPath}/labAction/setting.do">技工间设置</a></p>
             					<p class="secc04"><a href="${pageContext.request.contextPath}/labAction/setting/users.do">用户</a></p>
             					<p class="secc05"><a href="${pageContext.request.contextPath}/labAction/setting/details.do">技工间详情</a></p>
             				<%}else{%>
              				<p class="secc"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patients">患者</a></p>                  
                    		<!-- <p class="secc01"><a href="">日历</a></p> -->
                    		<p class="secc02"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=arrive_cases">抵达订单</a></p>
                    		<p class="secc03"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=tagged_cases">标签订单</a></p>
                    		<%
                    			if("true".equals(user.getIsMain()) || "true".equals(user.getManagerAccount())){
                    				%>
                    					<p class="secc04"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=users">用户信息</a></p>
                    				<%
                    			}%>
                   		  	<p class="secc05"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=practice">临床详情</a></p>
           				<%}%>
		        </div>
           		<div class="menu_ss2"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.png" width="160" height="4" /></div>
            </div>
        </li>
    </ul>
</div>


