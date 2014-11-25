<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
    
<%@page import="com.upcera.ddx.constans.Constans"%><html xmlns="http://www.w3.org/1999/xhtml">
        <jsp:include page="../common.jsp" />
        <head>
            <title>
                工厂实验室-登陆
            </title>
            <link href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
            rel="stylesheet" type="text/css" />
            <link href="${pageContext.request.contextPath}/jsp/login_lab/css/login_lab.css"
            rel="stylesheet" type="text/css" />
            <script type="text/javascript" src="${pageContext.request.contextPath}/jsp/login_lab/js/login.js">
            </script>
        </head>
        
        <body>
            <div id="data-login-div" class="flashload" style="display: none;">
                <table>
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/img/dataload.gif">
                        </td>
                        <td id="msg">
                            登陆成功，正在跳转页面！！
                        </td>
                    </tr>
                </table>
            </div>
            <div class="page">
                <!--头部开始-->
                <div class="top">
                    <div class="top_a">
                        <div class="top_a_left">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/jsp/common/images/loginlogo.gif"
                                />
                            </a>
                        </div>
                        <div class="top_a_right">
                            <!--<ul>
                            <li><a href="#"> UK </a></li>
                            <li class="top_a_right_a">,</li>
                            <li><a href="#"> Deutsch </a></li>
                            <li class="top_a_right_a">,</li>
                            <li><a href="#"> Nederlands </a></li>
                            </ul>
                            -->
                        </div>
                    </div>
                    <div class="top_b">
                        <div class="top_b_left">
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/jsp/login_lab/SignUp_lab_option.jsp">
                                        注册
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="top_b_right">
                            <ul>
                                <li>
                                </li>
                                <li>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--头部结束-->
                <!--中间开始-->
                <!--广告开始-->
                   <script type="text/javascript" src="${pageContext.request.contextPath}/jsp/login_lab/js/lrtk.js"></script>
                   <SCRIPT type=text/javascript src="${pageContext.request.contextPath}/jsp/login_lab/js//jquery-1.4.2.min.js"></SCRIPT>
                   <script type="text/javascript">
                        $(document).ready(function(){
                        $(".gg_fbtn").click(function(){	
                        $(this).find("a").toggleClass("open");
                        $("#playBox").slideToggle("slow");
                        });
                      });
                    </script>
<div class="gg_fbtnall">
<div class="gg_fbtn"><a></a></div>
 <div id="playBox">
    <div class="pre"></div>
    <div class="next"></div>
    <div class="smalltitle">
      <ul>
        <li class="thistitle"></li>
        <li></li>
        <li></li>
      </ul>
    </div>
    <ul class="oUlplay">
       <li><img src="${pageContext.request.contextPath}/jsp/login_lab/images/1.jpg" /></li>
       <li><img src="${pageContext.request.contextPath}/jsp/login_lab/images/2.jpg" /></li>
       <li><img src="${pageContext.request.contextPath}/jsp/login_lab/images/3.jpg" /></li>
    </ul> 
</div>
</div>
<!--广告结束-->
                <div class="center">
                    <!--工厂实验室-登陆开始-->
                    <div class="center_a">
                        <div class="center_a_left">
                            <img src="${pageContext.request.contextPath}/jsp/login_lab/images/login_lab1.jpg"
                            />
                        </div>
                        <div class="center_a_right">
                            登陆
                        </div>
                    </div>
                    <div class="center_b">
                        <div class="center_b_top">
                        </div>
                        <div class="center_b_middle">
                            <div class="center_b_middle01" align="center">
                                <font color="red" id="login-sessionScope">
                                    ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}${errorMessage }
                                </font>
                                <form action="${pageContext.request.contextPath}" name="loginForm" method="post">
                                 		<%
                                 			String fate = "";
                                           	String userName = "";
                                           	String password = "";
                                            Cookie Cookies[]=request.getCookies();
                                            if(Cookies!=null){
                                            	for(int i=0;i < Cookies.length;i++){
                                            		String name = Cookies[i].getName();
                                            		if(Constans.MEMORY_USER_NAME.equals(name)){
                                            			userName = Cookies[i].getValue();
                                            		}
                                            		if(Constans.MEMORY_USER_PASSWORD.equals(name)){
                                            			password = Cookies[i].getValue();
                                            		}
                                            		if(Constans.MEMORY_USER_FATES.equals(name)){
                                            			fate = Cookies[i].getValue();
                                            		}
                                            	}
                                            }
                                       %>
                                    <ul>
                                        <li>
                                            <div class="center_b_middle_left">
                                                登陆到
                                            </div>
                                            <div class="center_b_middle_right">
                                                <select name="" size="1" id="selectFate">
                                                    <option value="1" id="option-lab" <%if("1".equals(fate)){%> selected="selected" <%} %>>
                                                        技工间
                                                    </option>
                                                    <option value="2" id="option-practice" <%if("2".equals(fate)){%> selected="selected" <%} %>>
                                                        临床
                                                    </option>
                                                </select>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="center_b_middle_left">
                                                <span>
                                                    邮箱
                                                </span>
                                                <span class="center_b_middle_left_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="center_b_middle_right">
                                                <input name="j_username" value="<%=userName %>" type="text" class="center_b_middle_right_a" id="login-username"
                                                />
                                            </div>
                                        </li>
                                        <li>
                                            <div class="center_b_middle_left">
                                                <span>
                                                    密码
                                                </span>
                                                <span class="center_b_middle_left_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="center_b_middle_right">
                                                <input name="j_password" type="password" value="<%=password %>" class="center_b_middle_right_a"
                                                id="login-password" onkeydown="onkeydownSubmit(this.event);" />
                                            </div>
                                        </li>
                                        <li>
                                            <div class="center_b_middle_left">
                                                安全
                                            </div>
                                            <div class="center_b_middle_right">
                                                <span class="center_b_middle_right_c">
                                                    <input name="security-type" type="radio" value="public" checked="checked" />
                                                </span>
                                                <span class="center_b_middle_right_h">
                                                    这是一台公共或共享计算机
                                                </span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="center_b_middle_left">
                                                &nbsp;
                                            </div>
                                            <div class="center_b_middle_right">
                                                <span class="center_b_middle_right_c">
                                                    <input name="security-type" type="radio" value="private" />
                                                </span>
                                                <span class="center_b_middle_right_h">
                                                    这是一台私人计算机
                                                </span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="center_b_middle_left">
                                                &nbsp;
                                            </div>
                                            <div class="center_b_middle_right">
                                                选择此选项，您确认本机符合组织的安全条款。
                                            </div>
                                        </li>
                                        <li>
                                            <div class="center_b_middle_left">
                                                &nbsp;
                                            </div>
                                            <div class="center_b_middle_right">
                                                <span class="center_b_middle_right_g">
                                                    <a href="javascript:void(0)" onclick="login()">
                                                        &nbsp&nbsp登陆
                                                    </a>
                                                </span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="center_b_middle_left">
                                                &nbsp;
                                            </div>
                                            <div class="center_b_middle_right">
                                                <span class="center_b_middle_right_f">
                                                    <a href="${pageContext.request.contextPath}/jsp/login_lab/login_lab_mimachongzhi.jsp">
                                                       	 忘记密码?
                                                    </a>
                                                     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                                     <a href="${pageContext.request.contextPath}/jsp/login_lab/SignUp_lab_option.jsp">
                                                        	注册
                                                    </a>
                                                </span>
                                            </div>
                                        </li>
                                        <!--  
                                        <li>
                                            <div class="center_b_middle_left">
                                                &nbsp;
                                            </div>
                                            <div class="center_b_middle_right">
                                                <span class="center_b_middle_right_d">
                                     
                                                </span>
                                                <span class="center_b_middle_right_e">
                                                    <a href="${pageContext.request.contextPath}/jsp/login_lab/SignUp_lab_option.jsp">
                                                        	注册
                                                    </a>
                                                </span>
                                            </div>
                                        </li>
                                        -->
                                    </ul>
                                </form>
                            </div>
                        </div>
                        <div class="center_b_bottom">
                        </div>
                    </div>
                    <!--工厂实验室-登陆结束-->
                </div>
                <!--中间结束-->
                <!--底部开始-->
                <jsp:include page="../bottom.jsp" />
                <!--底部结束-->
            </div>
        </body>
    
    </html>