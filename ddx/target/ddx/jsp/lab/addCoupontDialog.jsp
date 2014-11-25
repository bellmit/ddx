<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@taglib prefix="s" uri="http://www.springframework.org/security/tags"
            %>
                <html xmlns="http://www.w3.org/1999/xhtml">
                    
                    <body>
                        <div class="box_clear">
                        </div>
                        <div class="NewCase_c_middle_righttop03">
                            <p>
                                <c:choose>
                                    <c:when test="${empty listCoupons}">
                                        	没有可用的优惠券
                                    </c:when>
                                    <c:otherwise>
                                        	选择一个优惠券编码
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <ul>
                                <li id="display_coupont">	
                                	<table class="cases-list" style="width: 100%;" align="center">
                                		<tr class="Patients_b_middle_c_a" align="center">
                                			<td align="center"><strong>代码</strong></td>
                                			<td align="center"><strong>优惠</strong></td>
                                			<td align="center"><strong>指定工序</strong></td>
                                			<td align="center"><strong>过期时间</strong></td>
                                		</tr>
                                		 <c:forEach items="${listCoupons}" var="labcoupons" varStatus="i">
                                		 	<tr align="center" <c:if test="${i.index%2==0 }">class="odd"</c:if><c:if test="${i.index%2!=0 }">class="even"</c:if>>
                                		 		<td align="center">
                                		 			<a href="javascript:void(0)" style="width: auto;" onclick="addCoupontToCases('${labcoupons.id}','${labcoupons.prefix }','${labcoupons.proceduresid }')">${labcoupons.prefix }</a>
                                		 		</td>
                                		 		<td align="center">
                                		 			<c:choose>
					                                    <c:when test="${labcoupons.discountType=='P'}">
					                                        	${labcoupons.discount }%
					                                    </c:when>
					                                    <c:otherwise>
					                                        	${labcoupons.discount }￥
					                                    </c:otherwise>
					                                </c:choose>
                                		 		</td>
                                		 		<td align="center">
					                                <c:choose>
					                                    <c:when test="${!empty labcoupons.proceduresid}">
					                                        	${labcoupons.proceduresName }
					                                    </c:when>
					                                    <c:otherwise>
					                                        	无指定
					                                    </c:otherwise>
					                                </c:choose>
                                		 		</td>
                                		 		<td align="center">
                                		 			${labcoupons.expiry }
                                		 		</td>
                                		 	</tr>
                                		 </c:forEach>
                                	</table>
                                </li>
                            </ul>
                        </div>
                    </body>
                
                </html>