<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>
            
            <head>
                <title>
                    技工间-我的账户
                </title>
                <link href="${pageContext.request.contextPath}/jsp/common/css/commom.css"
                rel="stylesheet" type="text/css" />
                <link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"
                rel="stylesheet" type="text/css" />
                <link href="${pageContext.request.contextPath}/jsp/lab/css/lab.css" rel="stylesheet"
                type="text/css" />
                <script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/user.js">
                </script>
            </head>
            
            <body>
                <div class="page">
                    <!--底部开始-->
                    <jsp:include page="../head.jsp" />
                    <!--头部结束-->
                    <!--中间开始-->
                    <div class="center">
                        <!--工厂实验室会员中心开始-->
                        <div class="gcsyshyzx">
                            <div class="Cases">
                                <div class="Cases_top">
                                    编辑用户
                                </div>
                                <div class="Cases_bottom">
                                    <!--左边菜单开始-->
                                    <jsp:include page="../left.jsp" />
                                    <!--左边菜单结束-->
                                        <jsp:include page="u_lab_Setting_UserEdit_div.jsp?url=labAction/setting/updateUser.do"/>
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