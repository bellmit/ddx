<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.multiselect.js"></script>
<script type="text/javascript">
	$(function() {
		$("#coupons_institution").multiselect( {
			selectedList : 3,
			noneSelectedText : "未选择机构"
		});
	});
</script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <body>
            <div id="add_coupons" style="display: none;">
                <div class="Cases_bottom_right">
                    <div class="Cases_bottom_right_a">
                        新增优惠劵
                    </div>
                    <div class="Personalize">
                        <div class="Addonecuowu_c" style="display: none;" id="errormessage">
                            你提交的表单有错误请查看一下详情
                        </div>
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
                                                <span class="Personalize_b_middle_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <select name="" size="1" id="UseType" onchange="changeCouponsType(this.value);">
                                                    <option value="S">
                                                        单次使用
                                                    </option>
                                                    <option value="M">
                                                        多次使用
                                                    </option>
                                                </select>
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
                                        <li id="amount-li">
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                   赠送张数
                                                </span>
                                                <span class="Personalize_b_middle_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <select name="" size="1" id="amount">
                                                    <% for(int i=1;i<61;i++){ %>
                                                        <option value="<%= i %>">
                                                            <%=i %>
                                                        </option>
                                                        <% }%>
                                                </select>
                                            </div>
                                        </li>
                                        <li id="maxUse-li">
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    最大使用次数
                                                </span>
                                                <span class="Personalize_b_middle_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <input type="text" id="maxUse" class="Personalize_b_middle_b" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" onblur="this.value=this.value.replace(/\D/g,'')"/>
                                            </div>
                                            <div class="Personalize_b_middle_right" style="display: none;" id="error_maxUse">
                                                <i class="Addonecuowu_b">
                                                    请输入一个有效整数
                                                </i>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                前缀代码
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <input name="" type="text" class="Personalize_b_middle_b" id="coupons_prefix"
                                                />
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    生效时间
                                                </span>
                                                <span class="Personalize_b_middle_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    <input name="" type="text" class="Personalize_b_middle_b" id="coupons_Effective"
                                                    readonly="readonly" onclick="WdatePicker({el:'coupons_Effective',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d}'})"
                                                    />
                                                </span>
                                                <span class="Personalize_b_middle_d">
                                                    <a href="javascript:void(0)" onclick="WdatePicker({el:'coupons_Effective',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d}'})">
                                                    </a>
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right" style="display: none;" id="error_coupons_Effective">
                                                <i class="Addonecuowu_b">
                                                    请输入一个有效的日期
                                                </i>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    失效时间
                                                </span>
                                                <span class="Personalize_b_middle_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    <input name="" type="text" class="Personalize_b_middle_b" id="coupons_expiry"
                                                    readonly="readonly" onclick="WdatePicker({el:'coupons_expiry',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d}'})"
                                                    />
                                                </span>
                                                <span class="Personalize_b_middle_d">
                                                    <a href="javascript:void(0)" onclick="WdatePicker({el:'coupons_expiry',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d}'})">
                                                    </a>
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right" style="display: none;" id="error_coupons_expiry">
                                                <i class="Addonecuowu_b">
                                                    请输入一个有效的日期
                                                </i>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                <span>
                                                    折扣类型
                                                </span>
                                                <span class="Personalize_b_middle_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    <select id="discount-type" onchange="changeShowTypeFlag(this.value);">
                                                        <option value="P">
                                                            百分比
                                                        </option>
                                                        <option value="F">
                                                            固定金额
                                                        </option>
                                                    </select>
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
                                                <span class="Personalize_b_middle_a">
                                                    *
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right">
                                                <span>
                                                    <input name="" type="text" class="Personalize_b_middle_b" id="coupons_discount"
                                                    onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" onblur="this.value=this.value.replace(/\D/g,'')"
                                                    maxlength="3"/>
                                                </span>
                                                <span style="margin-top: 6px;" id="discount-type-flag">%</span>
                                                <span>
                                                </span>
                                            </div>
                                            <div class="Personalize_b_middle_right" style="display: none;" id="error_coupons_discount">
                                                <i class="Addonecuowu_b">
                                                    请输入一个有效的折扣率
                                                </i>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                机构
                                            </div>
                                            <div class="" id="coupons_practice">
                                                <select name="" multiple="multiple" id="coupons_institution">
                                                    <c:forEach items="${datas.boundCoupons }" var="bound">
                                                        <option value="${bound.id }-${bound.type }">
                                                            ${bound.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="Personalize_b_middle_left">
                                                工序
                                            </div>
                                            <div class="Personalize_b_middle_right" id="coupons_procedure">
                                                <select name="" size="1" id="coupons_process">
                                                	<option value="">不指定工序</option>
                                                    <c:forEach items="${datas.pro }" var="p">
                                                        ${p }
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                            <div class="Personalize_b_bottom">
                            </div>
                        </div>
                        <div class="Addone">
                            <a href="javascript:void(0)" onclick="saveCoupons()" id="bound_function">
                                保存
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </body>