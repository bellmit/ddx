<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script type="text/javascript">
            $(function() {
                $(".menu_all .first").click(function() {
                    $('.menuu_s').hide();
                    $(this).find(".menuu_s").toggle();
                    $(".menu_all .first1").find(".menuu_s").hide();
                });
                $(document).on('click',
                function(e) {
                    if ($('.menu_all li').is(e.target) || $('.menu_all li').has(e.target).length) {
                        return;
                    }
                    $('.menuu_s').hide();

                });
            });
        </script>
        <div class="Cases_bottom_right_a">
          优惠劵列表
        </div>
        <div class="Settings_Practices">
            <div class="Settings_Practices_top">
            </div>
            <div class="Settings_Practices_middle">
                <form method="get" action="">
                    <div class="Settings_Practices_middle_a">
                        <div class="Settings_Practices_middle_a_left">
                            <div class="Settings_Practices_middle_a_leftsearch">
                                <div class="Settings_Practices_middle_a_leftsearch01">
                                    搜 索：
                                </div>
                                <div class="Settings_Practices_middle_a_leftsearch02">
                                    <input name="input" type="text" value="${search }" id="search-coupons"
                                    onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')" />
                                    <a href="javascript:void(0)">
                                        <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg"
                                        onclick="listCoupons('1')" />
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="Settings_Practices_middle_a_right">
                            <ul>
                                <li class="LabCaseSettingCoupons_a">
                                    <a href="javascript:void(0)" onclick="stamp()">
                                        导出
                                    </a>
                                </li>
                                <li class="LabCaseSettingCoupons_b">
                                    <a href="javascript:void(0)" onclick="addCoupons()">
                                        增加
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="Settings_Practices_middle_b">
                        <div class="Settings_Practices_middle_b_left">
                            显示从${datas.datas.frist }到${datas.datas.last }共${datas.datas.total }个
                        </div>
                        <div class="Settings_Practices_middle_right">
                            <c:choose>
                                <c:when test="${datass.datass.offset==datass.datass.totalPage and datass.datass.offset==1}">
                                    <span>
                                        <a href="javascript:void(0)">
                                            <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg">
                                        </a>
                                    </span>
                                    <span>
                                        <a href="javascript:void(0)">
                                            <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg">
                                        </a>
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${datas.datas.offset<=datas.datas.totalPage and datas.datas.offset>1}">
                                            <span>
                                                <a href="javascript:void(0)" onclick="listCoupons(${datas.datas.offset-1});">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"
                                                    />
                                                </a>
                                            </span>
                                        </c:when>
                                        <c:otherwise>
                                            <span>
                                                <a href="javascript:void(0)">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"
                                                    />
                                                </a>
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${datas.datas.offset<datas.datas.totalPage}">
                                            <span>
                                                <a href="javascript:void(0)" onclick="listCoupons(${datas.datas.offset+1});">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"
                                                    />
                                                </a>
                                            </span>
                                        </c:when>
                                        <c:otherwise>
                                            <span>
                                                <a href="javascript:void(0)">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"
                                                    />
                                                </a>
                                                </a>
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="Settings_Practices_middle_c">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                                <tr class="Settings_Practices_middle_c_a">
                                    <td>
                                        <span>
                                            代码
                                        </span>
                                        <span>
                                            <div class="Settings_Practices_middle_c_a_a">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg">
                                                </a>
                                            </div>
                                            <div class="Settings_Practices_middle_c_a_a">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg">
                                                </a>
                                            </div>
                                        </span>
                                    </td>
                                    <td>
                                        <span>
                                            生效日期
                                        </span>
                                        <span>
                                            <a class="Settings_Practices_middle_c_a_b" href="#">
                                                <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg">
                                            </a>
                                        </span>
                                    </td>
                                    <td>
                                        <span>
                                            失效日期
                                        </span>
                                        <span>
                                            <a class="Settings_Practices_middle_c_a_b" href="#">
                                                <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg">
                                            </a>
                                        </span>
                                    </td>
                                    <td>
                                        <span>
                                            订单数
                                        </span>
                                        <span>
                                            <div class="Settings_Practices_middle_c_a_a">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg">
                                                </a>
                                            </div>
                                            <div class="Settings_Practices_middle_c_a_a">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg">
                                                </a>
                                            </div>
                                        </span>
                                    </td>
                                    <td>
                                        <span>
                                            折扣类型
                                        </span>
                                        <span>
                                            <a class="Settings_Practices_middle_c_a_b" href="#">
                                                <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg">
                                            </a>
                                        </span>
                                    </td>
                                    <td>
                                        <span>
                                            折扣
                                        </span>
                                        <span>
                                            <div class="Settings_Practices_middle_c_a_a">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg">
                                                </a>
                                            </div>
                                            <div class="Settings_Practices_middle_c_a_a">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg">
                                                </a>
                                            </div>
                                        </span>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                <c:forEach items="${datas.datas.datas }" var="coupons">
                                    <tr>
                                        <td>
                                            ${coupons.prefix }
                                        </td>
                                        <td>
                                            ${coupons.effective }
                                        </td>
                                        <td>
                                            ${coupons.expiry }
                                        </td>
                                        <td>
                                            ${coupons.claimed }
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${coupons.discountType =='P'}">
                                                    百分比
                                                </c:when>
                                                <c:otherwise>
                                                    固定金额
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            ${coupons.discount}
                                            <c:choose>
                                                <c:when test="${coupons.discountType =='P'}">
                                                    %
                                                </c:when>
                                                <c:otherwise>
                                                    	￥
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="General_RemakeTypes">
                                            <div class="LabDetails_f_e">
                                                <div class="LabDetails_f_e_left">
                                                    <a href="javascript:void(0)" onclick="showCouponsView('${coupons.id}')">
                                                        视图
                                                    </a>
                                                </div>
                                                <div class="LabDetails_f_e_right">
                                                    <!--小菜单下拉开始-->
                                                    <ol class="menu_all">
                                                        <li class="first">
                                                            <a href="javascript:void(0)">
                                                            </a>
                                                            <ol class="menuu_s">
                                                                <li>
                                                                    <ol class="menu_bgrightcenter">
                                                                        <li class="menu_bgrighttop">
                                                                            <img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg"
                                                                            width="160" height="4" />
                                                                        </li>
                                                                        <li class="menu_bgdelete">
                                                                            <a href="javascript:void(0)" onclick="deleteCoupons(${coupons.id })">
                                                                                删 除
                                                                            </a>
                                                                        </li>
                                                                        <li class="menu_bgrightbottom">
                                                                            <img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg"
                                                                            width="160" height="4" />
                                                                        </li>
                                                                    </ol>
                                                                </li>
                                                            </ol>
                                                        </li>
                                                    </ol>
                                                    <!--小菜单下拉结束-->
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="Settings_Practices_middle_b">
                        <div class="Settings_Practices_middle_b_left">
                            显示从${datas.datas.frist }到${datas.datas.last }共${datas.datas.total }个
                        </div>
                        <div class="Settings_Practices_middle_right">
                            <c:choose>
                                <c:when test="${datass.datass.offset==datass.datass.totalPage and datass.datass.offset==1}">
                                    <span>
                                        <a href="javascript:void(0)">
                                            <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg">
                                        </a>
                                    </span>
                                    <span>
                                        <a href="javascript:void(0)">
                                            <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg">
                                        </a>
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${datas.datas.offset<=datas.datas.totalPage and datas.datas.offset>1}">
                                            <span>
                                                <a href="javascript:void(0)" onclick="listCoupons(${datas.datas.offset-1});">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"
                                                    />
                                                </a>
                                            </span>
                                        </c:when>
                                        <c:otherwise>
                                            <span>
                                                <a href="javascript:void(0)">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"
                                                    />
                                                </a>
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${datas.datas.offset<datas.datas.totalPage}">
                                            <span>
                                                <a href="javascript:void(0)" onclick="listCoupons(${datas.datas.offset+1});">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"
                                                    />
                                                </a>
                                            </span>
                                        </c:when>
                                        <c:otherwise>
                                            <span>
                                                <a href="javascript:void(0)">
                                                    <img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"
                                                    />
                                                </a>
                                                </a>
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </form>
            </div>
            <div class="Settings_Practices_bottom">
            </div>
        </div>
        <div id="add-Coupons-div-html"></div>
        <div id="Coupons-view-html" style="display: none;"></div>