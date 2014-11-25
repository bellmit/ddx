<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>
            <jsp:include page="../common.jsp" />
            
            <head>
                <title>
                    	临床医生会员中心首页
                </title>
                <link href="../common/css/commom.css" rel="stylesheet" type="text/css"
                />
                <link href="../u_lab/css/u_lab.css" rel="stylesheet" type="text/css" />
                <link href="css/u_practice.css" rel="stylesheet" type="text/css" />
                <script type="text/javascript" src="js/u_practice_index.js">
                </script>
            </head>
            
            <body>
                <div class="page">
                    <jsp:include page="head-dashboard.jsp" />
                    <!--头部结束-->
                    <!--中间开始-->
                    <div class="center">
                        <!--工厂实验室会员中心开始-->
                        <div class="gcsyshyzx">
                            <div class="Cases">
                                <div class="Cases_top">
                                    	入口
                                </div>
                                <div class="Cases_bottom">
                                    <div class="Cases_bottom_left">
                                        <ul>
                                            <li>
                                                <a href="javascript:void(0);" id="addLabT_id">
                                                    	新增技工间
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    Tour
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    	培训
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="Cases_bottom_right">
                                        <!--临床医生会员中心开始-->
                                        <div class="zsyshyzx">
                                            <ul>
                                                <li class="zsyshyzx_a">
                                                    	欢迎进入DDX
                                                </li>
                                                <li class="zsyshyzx_b">
                                                    	设置技工间工序
                                                </li>
                                                <li class="zsyshyzx_c">
                                                    	开始你要设置工序，你可以在技工间管理软件中设置你的工序。
                                                </li>
                                                <li class="zsyshyzx_c">
                                                    	我们建议你花几分钟观看导游视频熟悉ddx，或安排培训。
                                                </li>
                                                <li class="zsyshyzx_b">
                                                    Tour
                                                </li>
                                                <li class="zsyshyzx_d">
                                                    <img src="../u_lab/images/u_lab_15.jpg" />
                                                </li>
                                                <li class="zsyshyzx_c">
                                                    <span>
                                                        	观看账号设置
                                                    </span>
                                                    <span class="gcsyshyzx_e">
                                                        <a href="#">
                                                            	订单提交和其他的视频
                                                        </a>
                                                    </span>
                                                    <span>
                                                        	了解ddx
                                                    </span>
                                                </li>
                                                <li class="zsyshyzx_b">
                                                   	 培训
                                                </li>
                                                <li class="zsyshyzx_c">
                                                    <span>
                                                        	安排
                                                    </span>
                                                    <span class="zsyshyzx_e">
                                                        <a href="#">
                                                            	一个15分钟的WEB演示
                                                        </a>
                                                    </span>
                                                    <span>
                                                        	与我们的DDX培训员
                                                    </span>
                                                </li>
                                                <li class="zsyshyzx_b">
                                                    	需要帮助？
                                                </li>
                                                <li class="zsyshyzx_c">
                                                    <span>
                                                        	记得阅读右上角的帮助菜单下的
                                                    </span>
                                                    <span class="zsyshyzx_e">
                                                        <a href="#">
                                                            DDX用户手册
                                                        </a>
                                                    </span>
                                                    <span>
                                                        	当你遇到问题时可以使用反馈表单。
                                                    </span>
                                                </li>
                                            </ul>
                                        </div>
                                        <!--临床医生会员中心结束-->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--工厂实验室会员中心结束-->
                    </div>
                    <!--中间结束-->
                    <!--底部开始-->
                    <jsp:include page="../bottom.jsp">
                    </jsp:include>
                    <!--底部结束-->
                </div>
            </body>
        
        </html>