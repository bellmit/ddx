<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
    <html xmlns="http://www.w3.org/1999/xhtml">
        <jsp:include page="../common.jsp" />
        <script type="text/javascript">
            function signup() {
                var type = $("#signup-select-type").val();
                if (type == '1') {
                    window.location.href = "http://" + location.host + webContext + "/jsp/login_lab/SignUp_lab_main.jsp";
                } else if (type == '2') {
                    window.location.href = "http://" + location.host + webContext + "/jsp/login_practice/SignUp_practice_two.jsp";
                } else {
                    alert("error");
                }
            }
        </script>
        
        <head>
            <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>
                	机构注册
            </title>
            <link href="../common/css/commom.css" rel="stylesheet" type="text/css"
            />
            <link href="css/login_lab.css" rel="stylesheet" type="text/css" />
        </head>
        
        <body>
            <div class="page">
                <!--头部开始-->
                <jsp:include page="../head-signUp.jsp" />
                <!--头部结束-->
                <!--中间开始-->
                <div class="center">
                    <!--工厂实验室-登陆开始-->
                    <div class="gcsyszc_a" style="margin-top: 20px;margin-left: 15px;">
                        	账户注册
                    </div>
                    <div class="mmcz" style="margin-left: 20px;">
                    </div>
                    <div class="center_b" id="gcsyszc">
                        <div class="center_b_top">
                        </div>
                        <div class="center_b_middle">
                            <div class="center_b_middle01">
                                <form action="" method="get">
                                    <ul>
                                        <li>
                                            <div class="mmcz_left">
                                                <span>
                                                    	机构类型
                                                </span>
                                                <span class="center_b_middle_left_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="mmcz_right">
                                                <select name="" size="1" id="signup-select-type">
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
                                            <div class="mmcz_left">
                                            </div>
                                            <div class="mmcz_right">
                                                <span class="gcsyszc_b">
                                                    <a href="javascript:void(0)" onclick="signup();">
                                                        &nbsp&nbsp&nbsp下一步
                                                    </a>
                                                </span>
                                            </div>
                                        </li>
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