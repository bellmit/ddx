<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@taglib prefix="s" uri="http://www.springframework.org/security/tags"
        %>
            <html xmlns="http://www.w3.org/1999/xhtml">
                <head>
                    <title>
                       	新建订单
                    </title>
                    <link href="${pageContext.request.contextPath}/jsp/common/css/commom.css"  rel="stylesheet" type="text/css" />
                    <link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css"  rel="stylesheet" type="text/css" />
                    <link href="${pageContext.request.contextPath}/css/tagit-simple-grey.css"  rel="stylesheet" type="text/css" />
                    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/ckeditor/ckeditor.js"></script>
                </head>
                <body>
                    <div class="page">
                        <jsp:include page="../head-dashboard.jsp" />
                        <!--头部结束-->
                        <!--中间开始-->
                        <div class="center">
                            <!--工厂实验室会员中心开始-->
                            <div class="Patients">
                                <div class="Patients_a">
                                    新建订单
                                </div>
                                <c:if test="${ !empty msg }">
                                 	<div class="NewCase_updated">${msg }</div>
                                </c:if>
                                <div class="NewCase">
                                    <div class="NewCase_a">
                                        <div class="NewCase_a_top">
                                            患者详情
                                        </div>
                                        <div class="NewCase_a_middle">
                                            <div class="NewCase_a_middle_left">
                                                <form action="" method="get" id="caseForm">
                                                    <ul>
                                                        <s:authorize ifAllGranted="ROLE_PRACTICE">
                                                        <c:if test="${ !empty providers }">
                                                            <li>
                                                                <div class="NewCase_a_middle_left_left">
                                                                    主治医师
                                                                </div>
                                                                <div class="NewCase_a_middle_left_right">
                                                                    <select id="providers">
                                                                        <c:forEach items="${providers }" var="provider">
                                                                            <option value="${provider.accountId}">
                                                                                ${provider.salutation}${provider.firstName}${provider.lastName}
                                                                            </option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </li>
                                                        </c:if>
                                                        </s:authorize>
                                                        <li>
                                                            <div class="NewCase_a_middle_left_left">
                                                                <span>
                                                                    姓
                                                                </span>
                                                                <span class="NewCase_a_middle_a">
                                                                    *
                                                                </span>
                                                            </div>
                                                            <div class="NewCase_a_middle_left_right">
                                                                <input name="" id="firstName" type="text" class="NewCase_a_middle_b" maxlength="10" value="${patient.firstName }"/>
                                                            </div>
                                                        </li>
                                                        <li style="display: none;" id="firstName_info">
															<div class="NewCase_a_middle_left_left">&nbsp;</div>
															<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请输入患者的姓</i></div>
														</li>

                                                        <li>
                                                            <div class="NewCase_a_middle_left_left">
                                                            <span>
                                                                名
                                                            </span>
                                                            <span class="NewCase_a_middle_a">
                                                                    *
                                                            </span>
                                                            </div>
                                                            <div class="NewCase_a_middle_left_right">
                                                                <input type="hidden" name="parentId" id="parentId" value="${cases.caseId }"
                                                                />
                                                                <input type="hidden" name="patientId" id="patientId" value="${patient.id }"/>
                                                                <input name="" id="lastName" type="text" maxlength="10" class="NewCase_a_middle_b" value="${patient.lastName }"/>
                                                            </div>
                                                        </li>
                                                        <li style="display: none;" id="lastName_info">
															<div class="NewCase_a_middle_left_left">&nbsp;</div>
															<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请输入患者的名</i></div>
														</li>
                                                    </ul>
                                                 </form>
                                            </div>
                                            <div class="NewCase_a_middle_right">
                                                <ul>
                                                    <li>
                                                        <div class="NewCase_a_middle_right_left">
                                                            性别
                                                        </div>
                                                        <div class="NewCase_a_middle_right_right">
                                                            <select name="" size="1" id="sex">
                                                                <option value="">
                                                                    --请选择--
                                                                </option>
                                                                <option value="0" <c:if test="${patient.sex eq '0' }">
                                                                    selected="selected"
                                                                    </c:if>
                                                                    >男
                                                                </option>
                                                                <option value="1" <c:if test="${patient.sex eq '1' }">
                                                                    selected="selected"
                                                                    </c:if>
                                                                    >女
                                                                </option>
                                                            </select>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="NewCase_a_middle_right_left">
                                                            病历
                                                        </div>
                                                        <div class="NewCase_a_middle_right_right">
                                                            <input name="" id="externalId" type="text" class="NewCase_a_middle_b"
                                                            value="${patient.externalId }" maxlength="10" />
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="NewCase_a_middle_right_left">
                                                            生日
                                                        </div>
                                                        <div class="NewCase_a_middle_right_right">
                                                            <span>
                                                                <input name="" id="birthday" readonly="readonly" onfocus="this.blur();" type="text" value="${patient.birthday }"
                                                                class="NewCase_a_middle_b" />
                                                            </span>
                                                            <span class="NewCase_a_middle_c">
                                                                <a href="javascript:void(0)" onclick="WdatePicker({el:'birthday',startDate:'1980-%M-%d',maxDate:'%y-%M-%d'})">
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="NewCase_a_bottom">
                                        </div>
                                    </div>
                                    <div class="NewCase_b">
                                        <div class="NewCase_b_top">
                                            制作需求
                                        </div>
                                        <div class="NewCase_b_middle">
                                            <div class="NewCase_b_middle_left">
                                                <ul>
                                                    <li>
                                                        <div class="NewCase_b_middle_left_left">
                                                            <span>
                                                                预寄出时间
                                                            </span>
                                                            <span class="NewCase_b_middle_a">
                                                                *
                                                            </span>
                                                        </div>
                                                        <div class="NewCase_b_middle_left_right">
                                                            <span>
                                                                <input name="" id="sendToLabDate" type="text" class="NewCase_b_middle_b" readonly="readonly"  onfocus="this.blur();" value="<fmt:formatDate value="${cases.sendToLabDate }" type="date" pattern="yyyy-MM-dd"/>"
                                                                />
                                                                
                                                            </span>
                                                            <span class="NewCase_b_middle_c">
                                                                <a href="javascript:void(0)" onclick="WdatePicker({el:'sendToLabDate',minDate:'%y-%M-%d'})">
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </li>
                                                    <li style="display: none;" id="sendToLabDate_info">
														<div class="NewCase_a_middle_left_left">&nbsp;</div>
														<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请选择发送日期</i></div>
													</li>
                                                    <s:authorize ifAllGranted="ROLE_LAB">
                                                    <li>
                                                        <div class="NewCase_b_middle_left_left">
                                                           预交付时间
                                                        </div>
                                                        <div class="NewCase_b_middle_left_right">
                                                            <span>
                                                                <input name="" id="deliveryDate" readonly="readonly" type="text" class="NewCase_b_middle_b"
                                                                />
                                                            </span>
                                                            <span class="NewCase_b_middle_c">
                                                                <a href="javascript:void(0)" onclick="WdatePicker({el:'deliveryDate',minDate:'%y-%M-%d'})">
                                                                </a>
                                                            </span>
                                                            <span class="NewCase_b_middle_e">
                                                                <a href="javascript:void(0)">
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </li>
                                                    </s:authorize>
                                                </ul>
                                            </div>
                                            <c:if test="${casesPermissions.caseEnclosures==true}">
                                            	<div class="NewCase_b_middle_right">
	                                                <ul>
	                                                    <li>
	                                                        <div class="NewCase_b_middle_right_left">
	                                                            	随单附件
	                                                        </div>
	                                                        <div class="NewCase_b_middle_right_right">
	                                                            <select name="enclosures" id="enclosures" style="width:200px" size="10"
	                                                            multiple="multiple">
	                                                                <c:forEach items="${enclosuresList}" var="enclosure">
	                                                                    <option value="${enclosure.id }">
	                                                                        ${enclosure.characterName }
	                                                                    </option>
	                                                                </c:forEach>
	                                                            </select>
	                                                        </div>
	                                                    </li>
	                                                </ul>
	                                            </div>
                                            </c:if>
                                            <p style="clear:both"></p>
                                            <div id="procedure-list-div">
                                            	<div id="add-procedure-div" class="newcase_middle" name="procedure-div">
                                                <ul>
                                                    <li class="newcase_middle01" id="procedure0">
                                                        <div class="NewCase_b_middle_left_left" style="display: table;">
                                                            <span>
                                                                工序
                                                            </span>
                                                            <span class="NewCase_b_middle_a">
                                                                *
                                                            </span>
                                                        </div>
                                                        <div class="NewCase_b_middle_left_right">
                                                            <span>
                                                                <%--session Lab ID --%>
                                                                   <%--  <input type="hidden" id="myLabId" value="${thisPractice.id }" /> --%>
                                                                    <%--伙伴技工间ID --%>
                                                                        <input type="hidden" id="partnerLabId" value="${requestAccountLab.id }"
                                                                        />
                                                                        <input type="hidden" id="procedureData" />
                                                                        <select name="select-procedure-name" size="1" id="procedure-select" class="procedure" onchange="loadProcedure('0',this.value)">
                                                                            <option value="">
                                                                                --请选择工序--
                                                                            </option>
                                                                            ${proOption }
                                                                        </select>
                                                            </span>
                                                            <span class="NewCase_b_middle_d">
                                                                <!-- <a href="javascript:void(0)" onclick="showProcedureDialog();">
                                                                </a> -->
                                                            </span>
                                                            <span style="display:none;" class="NewCase_b_middle_g">
                                                                <a href="javascript:void(0)">
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <!-- 工序属性 开始 -->
                                                        <div class="box_editcontent02" id="attributes-0">
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <p style="clear:both">
                                            </p>
                                            </div>
                                            
                                            <p style="clear:both"></p>
                                            
                                            <!-- 初始化一个div，用来增加工序选择窗口 -->
                                            <div style="display: none;" class="newcase_middle" id="init-select-procedure-div">
                                                <ul>
                                                    <li class="newcase_middle01" id="procedure0">
                                                        <div class="NewCase_b_middle_left_left" style="display: table;">
                                                            <span>
                                                                	工序
                                                            </span>
                                                            <span class="NewCase_b_middle_a">
                                                                *
                                                            </span>
                                                        </div>
                                                        <div class="NewCase_b_middle_left_right">
                                                            <span>
                                                                  <select name="select-procedure-name" size="1" id="procedure-select" class="procedure" onchange="loadProcedure('select-index',this.value)">
                                                                      <option value="">
                                                                          --请选择工序--
                                                                      </option>
                                                                      ${proOption }
                                                                  </select>
                                                            </span>
                                                            <span class="NewCase_b_middle_d">
                                                                <a href="javascript:void(0)" onclick="showProcedureDialog();">
                                                                </a>
                                                            </span>
                                                            <span class="NewCase_b_middle_g">
                                                                <a href="javascript:void(0)" onclick="delete-div-flag">
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <!-- 工序属性 开始 -->
                                                        <div class="box_editcontent02" id="attributes-index">
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                           
                                          <p style="clear:both"></p>
                                          
                                            <div class="newcase_middle">
                                                <ul>
                                                    <li>
                                                        <div class="NewCase_b_middle_left_left">
                                                            &nbsp;
                                                        </div>
                                                        <div class="NewCase_b_middle_left_right">
                                                            <span class="NewCase_b_middle_f">
                                                                <a href="javascript:void(0)" onclick="createNewProInput();">
                                                                    增加工序
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                             <div style="display: none;" id="procedure-select_info">
											 <div class="NewCase_a_middle_left_left">&nbsp;</div>
											 <div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">请选择具体的工序</i></div>
										    </div>
                                        </div>
                                        <div class="NewCase_b_bottom">
                                        </div>
                                    </div>
                                    <div class="NewCase_c">
                                        <div class="NewCase_c_top">
                                            备注
                                        </div>
                                        <div class="NewCase_c_middle">
                                            <div class="NewCase_c_middle_left">
                                            <li>
                                                <textarea name="caseNote" id="caseNote" class="ckeditor"></textarea>
                                            </li>
                                            <li style="display: none;" id="caseNote_info">
												<div class="NewCase_a_middle_left_left">&nbsp;</div>
												<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b"></i></div>
											</li>
                                            </div>
                                            <div class="NewCase_c_middle_right">
                                            <div class="NewCase_c_middle_righttop">
                                           
												<div class="NewCase_c_middle_righttop_left" style="width: auto;">
												使用优惠券&nbsp;
												<input  type="text" id="coupon_code"/>
												</div>
												<div class="NewCase_c_middle_righttop_right">
												<ul>
												<li class="NewCase_c_middle_righttop_rightli"><a href="javascript:void(0)" onclick="loadMyCoupon('${requestAccountLab.id }')"></a></li>
												<li class="NewCase_c_middle_righttop_rightli01"><a href="javascript:void(0)" onclick=removecoupont();>删除</a></li>
												<li class="NewCase_c_middle_righttop_rightli02"><a href="javascript:void(0)" onclick="apply('${requestAccountLab.id }');">应用</a></li>
												</ul>
												</div>
												</div>
												<div style="display: none;" id="coupon_error">
												<div class="box_clear"></div>
												<div class="NewCase_c_middle_righttop01" id="isValid-msg-div" style="padding-left: 0px;height: auto;font-weight: normal"></div>
												</div>
                                                <ul>
                                                    <li class="NewCase_c_middle_rightsd">
                                                        <ol>
                                                            <li class="NewCase_c_middle_right_right_a" id="isTryIn_li">
                                                                <input type="hidden" id="isTryIn" />
                                                                <input type="hidden" id="isEmeger" />
                                                                <input type="hidden" id="isFiles" />
                                                                <a id="isTryIn_a" href="javascript:void(0)" onclick="setAttr('isTryIn');">
                                                                    试戴
                                                                </a>
                                                            </li>
                                                            <c:if test="${casesPermissions.attachCaseFiles eq 'true' }">
                                                            	<li class="NewCase_c_middle_right_right_b" id="isEmeger_li">
                                                            	<a id="isEmeger_a" href="javascript:void(0)" onclick="setAttr('isEmeger');">                                       
                                                                  加急 
                                                               </a>
                                                            </li>
                                                            </c:if>
                                                            <c:if test="${casesPermissions.attachCaseFiles eq 'false' }">
                                                            	<li class="NewCase_c_middle_right_right_b_2" id="isEmeger_li">
                                                            	<a id="isEmeger_a" href="javascript:void(0)" onclick="setAttr('isEmeger');">                                       
                                                                  加急 
                                                               </a>
                                                            </li>
                                                            </c:if>
                                                            <c:if test="${casesPermissions.attachCaseFiles eq 'true' }">
                                                            <li class="NewCase_c_middle_right_right_e" id="isFiles_li">
                                                                <a id="isFiles_a" href="javascript:void(0)" onclick="setAttr('isFiles');">
                                                                    文件
                                                                </a>
                                                            </li>
                                                            </c:if>
                                                        </ol>
                                                    </li>
                                                    <%--技工间协议是否显示 --%>
                                                    <c:if test="${caseTerms.valid eq 'true' }">
                                                    <li class="NewCase_c_middle_rightsd">
                                                        <div class="NewCase_c_middle_right_left">
                                                            <input type="checkbox" id="terms"/>我同意所有的&nbsp;
                                                        </div>
                                                        <div class="NewCase_c_middle_right_right_01">
                                                            <a href="javascript:void(0);" onclick="showTermsDialog()">协议条款</a>
                                                        </div>
                                                    </li>
                                                    <li style="display: none;" id="terms_info">
											 			<div class="NewCase_a_middle_left_left">&nbsp;</div>
											 			<div class="NewCase_a_middle_left_right"><i class="Addonecuowu_b">您必须同意此协议条款</i></div>
										    		</li>
                                                    </c:if>
                                                    <%--创建标记的权限 --%>
                                                    <c:if test="${user.createCaseTags eq 'true' }">
                                                    <li class="NewCase_c_middle_rightsd">
                                                        <div class="NewCase_c_middle_right_left">
                                                            标签
                                                        </div>
                                                        <div class="NewCase_c_middle_right_right">
                                                        	<ul id="tags-ul"></ul>
                                                            <input name="tags"  id="tags" type="hidden" class="NewCase_c_middle_a" maxlength="30" />
                                                        </div>
                                                    </li>
                                                    <li class="NewCase_c_middle_rightsd" style="display: none;" id="tags_info">
                                                        <div class="NewCase_c_middle_right_left">
                                                        &nbsp;
                                                        </div>
                                                        <div class="NewCase_c_middle_right_right">
                                                        	<i class="Addonecuowu_b">标签字数过多</i>
                                                        </div>
                                                    </li>
                                                    </c:if>
                                                    
                                                    <li>
                                                        <ol>
                                                            <li class="NewCase_c_middle_right_right_c">
                                                                <a href="javascript:void(0)" onclick="saveCase(1);">
                                                                    提交订单
                                                                </a>
                                                                <%--订单创建的方式 --%>
                                                                <input type="hidden" id="newType" value="${newType }" />
                                                                <input type="hidden" id="returnSId" value="${cases.returnSId }" />
                                                                <input type="hidden" id="returnType" value="${cases.returnType }" />
                                                                <input type="hidden" id="remakeType" value="${cases.remakeType }" />
                                                                <input type="hidden" name="caseId" id="caseId" value="${cases.caseId }" />
                                                                <input type="hidden" name="patientId" id="patientId" value="${patient.id }" />
                                                                
                                                                <input type="hidden" id="term_valid" value="${caseTerms.valid}" />
                                                                <input type="hidden" id="filesPerm" value="${casesPermissions.attachCaseFiles }" />
                                                                <input type="hidden" id="tagsPerm" value="${user.createCaseTags }" />
                                                            </li>
                                                            <li class="NewCase_c_middle_right_right_d">
                                                            	 <!--小菜单下拉开始-->
																   <ol class="menu_all">
																     <li class="first">
																		<a href="javascript:void(0)"></a>    
																     <ol class="menuu_s">
																     <li>
																       <ol class="menu_bgrightcenter">
																     <li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
																	 <li id="menubgsave" class="menu_bgsave"><a href="javascript:void(0)" onclick="saveCase(2);">保存为草稿</a></li>
																     <li class="menu_bgrightbottom"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg" width="160" height="4" /></li>
																       </ol>
																       </li>
																     </ol>
																        </li>
																 </ol>
																<!--小菜单下拉结束-->
                                                            </li>
                                                        </ol>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="NewCase_c_bottom">
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
                    <!-- 工序选择界面div 开始 -->
                    <div id="procedure_window_div" style="display: none;">
                        <div class="box_selectprocedurecenter">
                            <div class="box_selectproceduretop">
                                <div class="box_selectproceduretop01">
                                    <span class="box_selectprocedurebiaoti">
                                        通过
                                    </span>
                                    <select id="procedure_filter_filter" class="box_date02">
                                        <option value="1">
                                            类别
                                        </option>
                                        <!-- <option value="2">代码</option> -->
                                    </select>
                                </div>
                                <div class="box_selectproceduretop02">
                                    <select id="procedure_filter_departments" class="box_date03">
                                        <option value="">
                                            所有
                                        </option>
                                        <c:forEach items="${displayCategoryList }" var="displayCategory">
                                            <option value="${displayCategory.id }">
                                                ${displayCategory.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="box_selectproceduretop03">
                                    <span class="box_selectprocedurebiaoti">
                                        搜索
                                    </span>
                                    <input id="procedure_filter_search" class="box_Time" type="Search" title=""
                                    maxlength="" name="Search">
                                </div>
                            </div>
                            <div class="box_selectprocedurecontent">
                                <h1>
                                    所有工序
                                </h1>
                                <h2>
                                    General Procedures
                                </h2>
                                <ul>
                                    <li class="box_selectprocedurecontentli">
                                        <a href="#">
                                            Denture Bite Block
                                        </a>
                                    </li>
                                </ul>
                                <c:forEach items="${displayCategoryList }" var="displayCategory">
                                    <h2>
                                        ${displayCategory.name}
                                    </h2>
                                    <ul>
                                        <c:forEach items="${procedureList }" var="procedure">
                                            <c:if test="${displayCategory.id eq procedure.categoryId  }">
                                                <li class="box_selectcontentfixedli" style="display:inline;">
                                                    <a href="javascript:void(0)" onclick="selectProcedure();">
                                                        ${procedure.displayName }
                                                    </a>
                                                    <c:if test="${procedure.displayDescription ne null}">
                                                        <span class="NewCase_b_middle_d">
                                                            <a href="javascript:void(0)" onclick="showProcedureEmbedDialog('${procedure.displayName }','${procedure.proceduresId}')">
                                                            </a>
                                                        </span>
                                                    </c:if>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <!-- 工序选择界面div 结束 -->
                    <!-- 工序描述窗体DIV 开始 -->
                    <div id="procedure_embed">
                    </div>
                    <!-- 工序描述窗体DIV 结束 -->
                    <!-- 牙齿选择dialog 开始 -->
                    <jsp:include page="teeth_tmpl.jsp" />
                    <!-- 牙齿选择dialog 结束 -->
                    
                    <%--用户使用协议及条款 --%>
                    <div id="terms_dialog" style="display: none;">
                    	<p>${caseTerms.terms }</p>
                    </div>
                    <div style="display: none;" id="addCoupon">
						<jsp:include page="addCoupontDialog.jsp" />
					</div>
                </body>
            
            </html>
            <script type="text/javascript">
            
            	$(function(){
            		
             		//初始化多选下拉框 
                    $("#enclosures").multiselect({
                        selectedList: 3
                    });
             		
             		//可选标签  
	                 var availableTags = '${tags}'.split(',');
	
	                 $('#tags-ul').tagit({
	                	 tagSource:availableTags,
	                	 singleField: true,             
	                     singleFieldNode: $('#tags'),
	                     maxTags:5
	                  });
	                 
	                 //重制订单		默认选中工序 
	                 if('${newType}'=='remake'){
	                	 var links = eval('${links}');
	                	 if(links != undefined && links != ''){
	                		 var len = links.length;
	                		 $.each(links,function(i){
	                			 if(i>0){
	                				 createNewProInput();
	                			 }
	                			 $('.procedure').eq(i).find('option[value='+links[i].procedure_id+']').attr("selected", "selected");
	                			 loadProAttr(''+i+'',links[i].procedure_id);
	                			 setProAttrVal(i,links[i].index,'${cases.caseId}');
	                		 });
	                	 }
	                 }
	                 
	                 //外包订单
	                 if('${newType}' == 'outsource'){
	                	 var links = '${outlinks}'.split(',');
	                	 if(links != undefined && links != ''){
	                		 var len = links.length;
	                		 $.each(links,function(i){
	                			 if(i>0){
	                				 createNewProInput();
	                			 }
	                			 $('.procedure').eq(i).find('option[value='+links[i]+']').attr("selected", "selected");
	                			 loadProAttr(''+i+'',links[i]);
	                		 });
	                	 }
	                 }
	                 
            	});
            	
            </script>