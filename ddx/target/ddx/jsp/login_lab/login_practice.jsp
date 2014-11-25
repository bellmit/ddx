<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>
      临床-登陆
    </title>
    <link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/jsp/login_lab/css/login_lab.css" rel="stylesheet" type="text/css"/>
  </head>
<script type="text/javascript">
	function loginOnchange(){
	}
</script>
  <body>
    <div class="page">
      <!--头部开始-->
      <div class="top">
        <div class="top_a">
          <div class="top_a_left">
            <a href="#">
              <img src="${pageContext.request.contextPath}/jsp/common/images/loginlogo.gif"/>
            </a>
          </div>
          <div class="top_a_right">
            <ul>
              <li>
              <a href="#">
                UK
              </a>
            </li>
            <li class="top_a_right_a">
            ,
          </li>
          <li>
          <a href="#">
            Deutsch
          </a>
        </li>
        <li class="top_a_right_a">
        , 
      </li>
      <li>
      <a href="#">
        Nederlands
      </a>
    </li>
  </ul>
</div>
</div>
<div class="top_b">
  <div class="top_b_left">
    <ul>
      <li>
      <a href="#">
        Sign UP
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
<div class="center">
  <!--工厂实验室-登陆开始-->
  <div class="center_a">
    <div class="center_a_left">
      <img src="${pageContext.request.contextPath}/jsp/login_lab/images/login_lab1.jpg"/>
    </div>
    <div class="center_a_right">
      Login
    </div>
  </div>
  <div class="center_b">
    <div class="center_b_top">
    </div>
    <div class="center_b_middle">
    <font color="red">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</font>
      <form action="${pageContext.request.contextPath}/j_spring_security_check" name="loginForm" method="post">
        <ul>
          <li>
          <div class="center_b_middle_left">
           登陆到
          </div>
          <div class="center_b_middle_right">
            <select name="" size="1" id="selectLogin" onchange="loginOnchange();">
              <option value="1">
                技工间
              </option>
              <option value="2">
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
          <input name="j_username" type="text" class="center_b_middle_right_a"/>
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
        <input name="j_password" type="password" class="center_b_middle_right_a"/>
      </div>
    </li>
    <li>
    <div class="center_b_middle_left">
      安全
    </div>
    <div class="center_b_middle_right">
      <span class="center_b_middle_right_c">
        <input name="" type="radio" value="" checked="checked" />
      </span>
      <span class="center_b_middle_right_h">
        这是一条公共或共享计算机
      </span>
    </div>
  </li>
  <li>
  <div class="center_b_middle_left">
  </div>
  <div class="center_b_middle_right">
    <span class="center_b_middle_right_c">
      <input name="" type="radio" value="" />
    </span>
    <span class="center_b_middle_right_h">
     这是一台私人计算机
    </span>
  </div>
</li>
<li>
<div class="center_b_middle_left">
</div>
<div class="center_b_middle_right">
  	选择此选项，您确认本机符合组织的安全政策。
</div>
</li>
<li>
<div class="center_b_middle_left">
</div>
<div class="center_b_middle_right">
  <span class="center_b_middle_right_g">
    <a href="javascript:void(0)" onclick="document.loginForm.submit()"></a>
  </span>
</div>
</li>
<li>
<div class="center_b_middle_left">
</div>
<div class="center_b_middle_right">
  <span class="center_b_middle_right_f">
    <a href="#">
      忘记密码?
    </a>
  </span>
</div>
</li>
<li>
<div class="center_b_middle_left">
</div>
<div class="center_b_middle_right">
  <span class="center_b_middle_right_d">
    没有DDX账户?
  </span>
  <span class="center_b_middle_right_e">
    <a href="${pageContext.request.contextPath}/jsp/login_lab/SignUp_lab_option.jsp">
      注册
    </a>
  </span>
</div>
</li>
</ul>
</form>
</div>
<div class="center_b_bottom">
</div>
</div>
<!--工厂实验室-登陆结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<div class="bottom">
  <div class="bottom_left">
    <ul>
      <li>
      <a href="#">
        Terms of Use
      </a>
    </li>
    <li>
    <a href="#">
      Comments or Suggestions
    </a>
  </li>
</ul>
</div>
<div class="bottom_middle">
  Powered by UPCERA
</div>
<div class="bottom_right">
  Copyright 2014 Labnet Dental Lab Systems-All Rights Reserved
</div>
</div>
<!--底部结束-->
</div>
</body>
</html>
