<!DOCTYPE html PUBLIC"-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <title>
                	工厂实验室-价格列表
            </title>
            <link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/>
            <link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css" />
            <link href="${pageContext.request.contextPath}/jsp/practice/css/practice.css" rel="stylesheet" type="text/css"/>
            <link href="${pageContext.request.contextPath}/jsp/u_practice/css/u_practice.css" rel="stylesheet" type="text/css">
        </head>
        
        <body>
            <div class="page">
                <!--底部开始-->
               <jsp:include page="../head-dashboard.jsp" />
            <!--头部结束-->
            <!--中间开始-->
            <div class="center">
                <!--工厂实验室会员中心开始-->
                <div class="gcsyshyzx">
                    <div class="Cases">
                        <div class="Cases_top">
                            	账务管理
                        </div>
                        <div class="Cases_bottom">
                            <div class="Cases_bottom_left">
                                <jsp:include page="finances-left-menu.jsp"/>
                            </div>
                            <div class="Cases_bottom_right">
                                <div class="Cases_bottom_right_a">
                                    ${requestAccountLab.name }:授权价格列表(非公开)
                                </div>
                                <div class="practice_FinancesPriceList">
                                    <form action="" method="get">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td class="practice_FinancesPriceList_a">
                                                    <a href="#">工序说明
                                                    </a>
                                                </td>
                                                <td class="practice_FinancesPriceList_b">
                                                    <a href="#">类别
                                                    </a>
                                                </td>
                                                <td class="practice_FinancesPriceList_c">
                                                    <a href="#">价格
                                                    </a>
                                                </td>
                                                <td class="practice_FinancesPriceList_d">
                                                    <a href="#">工序周期
                                                    </a>
                                                </td>
                                            </tr>
                                            <c:if test="${!empty datas}">
											<c:forEach items="${datas}" var="data">
												<tr>
													<td><h2>${data.displayDescription }</h2>
													
														<c:forEach items="${data.attrbutesList}" var="al">
															<div><span style="width: 100px;margin-left: 30px;"><strong>${al.lable }</strong>:${al.attr }</span></div>
														</c:forEach>
													</td>
													<td>${data.categoryName }</td>
													<td>${data.price }</td>
													<td>${data.turnAroundDays }</td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty datas}">
											<tr align="center">
												<td colspan="4" align="center">暂无数据</td>
											</tr>
										</c:if>
				                                            
                                        </table>
                                    </form>
                                </div>
                            </div>
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