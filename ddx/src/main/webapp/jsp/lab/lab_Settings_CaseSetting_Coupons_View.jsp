<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.multiselect.js"></script>
<script type="text/javascript">
	$(function() {
		$("#update_coupons_institution").multiselect( {
			selectedList : 3,
			noneSelectedText : "未选择机构"
		});
	});
</script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <body>
            <div id="add_coupons">
                <div class="Cases_bottom_right">
                    <div class="Cases_bottom_right_a">
                        优惠劵详细信息
                    </div>
                    <div class="Personalize">
                        
                        <div class="Personalize_a">
                            优惠类型
                        </div>
                        <div class="Personalize_b">
                            <div class="Personalize_b_top">
                            </div>
                            <div class="Personalize_b_middle">
                                <form action="" method="get">
                                    <ul>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    类型
                                                </span>
                                                
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <c:choose>
				                                    <c:when test="${result.caseCoupons.useType=='S'}">
				                                        	单次使用
				                                    </c:when>
				                                    <c:otherwise>
				                                        	多次使用
				                                    </c:otherwise>
				                                </c:choose>
                                            </div>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                            <div class="Personalize_b_bottom">
                            </div>
                        </div>
                        <div class="Personalize_a">
                            详情
                        </div>
                        <div class="Personalize_b">
                            <div class="Personalize_b_top">
                            </div>
                            <div class="Personalize_b_middle">
                                <form action="" method="get">
                                    <ul>
                                    	 <li>
                                            <div class="Personalize_b_middle_left">
                                                代码
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                ${result.caseCoupons.prefix}
                                            </div>
                                        </li>
                                    	<c:if test="${result.caseCoupons.useType=='M'}">
                                    		<li>
	                                            <div class="Personalize_b_middle_left">
	                                                <span>
	                                                    最大使用次数
	                                                </span>
	                                              
	                                            </div>
	                                            <div class="Personalize_b_middle_right">
	                                               ${ result.caseCoupons.maxUse}
	                                            </div>
	                                        </li>
	                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    剩余使用次数
                                                </span>
                                                
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                ${result.caseCoupons.maxUse-result.caseCoupons.useFrequency}
                                            </div>
                                        </li>
                                    	</c:if>
                                        
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    生效时间
                                                </span>
                                                
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    ${result.caseCoupons.effective}
                                                </span>
                                            </div>
                                           
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    失效时间
                                                </span>
                                                
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    ${result.caseCoupons.expiry}
                                                </span>
                                            </div>
                                           
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    折扣类型
                                                </span>
                                               
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    <c:choose>
					                                    <c:when test="${result.caseCoupons.discountType=='P'}">
					                                        	百分比
					                                    </c:when>
					                                    <c:otherwise>
					                                        	固定金额
					                                    </c:otherwise>
					                                </c:choose>
                                                </span>
                                                <span>
                                                </span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    折扣
                                                </span>
                                                
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    <c:choose>
					                                    <c:when test="${result.caseCoupons.discountType=='P'}">
					                                        	${result.caseCoupons.discount}%
					                                    </c:when>
					                                    <c:otherwise>
					                                        	${result.caseCoupons.discount}￥
					                                    </c:otherwise>
					                                </c:choose>
                                                </span>
                                                <span>
                                                </span>
                                            </div>
                                            
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                机构
                                            </div>
                                            <div class="" id="update_coupons_practice">
                                                <c:choose>
				                                    <c:when test="${!empty result.unit}">
				                                    	<a href="${pageContext.request.contextPath}/labAction/setting/practices.do?initId=${result.unit.id }&initType=${result.unitType }">${result.unit.name }</a>
				                                    </c:when>
				                                    <c:otherwise>
				                                    	无指定机构
				                                    </c:otherwise>
				                                </c:choose>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                工序
                                            </div>
                                            <div class="Personalize_b_middle_right" id="update_coupons_procedure">
                                                <c:choose>
				                                    <c:when test="${!empty result.proName}">
				                                    	<a href="${pageContext.request.contextPath}/labAction/setting/procedure.do?id=${result.caseCoupons.proceduresid }">${result.proName }</a>
				                                    </c:when>
				                                    <c:otherwise>
				                                    	无指定工序
				                                    </c:otherwise>
				                                </c:choose>
                                            </div>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                            <div class="Personalize_b_bottom">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>