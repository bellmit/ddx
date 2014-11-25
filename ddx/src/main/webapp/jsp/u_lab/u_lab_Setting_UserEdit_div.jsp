<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
        <div class="Cases_bottom_right">
            <div class="Cases_bottom_right_a">
            <s:authorize ifAllGranted="ROLE_PRACTICE">
            	临床:
            </s:authorize>
            <s:authorize ifAllGranted="ROLE_LAB">
            	技工间:
            </s:authorize>
               	
            </div>
            <div class="Personalize">
                <div class="Addonecuowu_c" id="editErrorMessage" style="display: none;">
                    	您提交的表单有错误，请查看以下详情。
                </div>
                <div class="Personalize_a">
                    	账户信息
                </div>
                <div class="Personalize_b">
                    <div class="Personalize_b_top">
                    </div>
                    <div class="Personalize_b_middle">
                        <form action="" method="get">
                            <ul>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                       	 昵称
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input type="text" class="Personalize_b_middle_b" value="${MyUser.salutation }"
                                        id="edit-user-salutation" />
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        <span>
                                            	名
                                        </span>
                                        <span class="Personalize_b_middle_a">
                                            *
                                        </span>
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="text" class="Personalize_b_middle_b" value="${MyUser.lastName }"
                                        id="edit-user-lastName" />
                                    </div>
                                    <div class="Personalize_b_middle_left">
                                        &nbsp;
                                    </div>
                                    <div class="Personalize_b_middle_right" style="display: none;" id="edit-user-lastName-title">
                                        <i class="Addonecuowu_b">
                                            	请输入您的名字
                                        </i>
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        	首字母
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="text" class="Personalize_b_middle_b" value="${MyUser.accountInitial }"
                                        id="edit-user-accountInitial" />
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        <span>
                                           	 姓氏
                                        </span>
                                        <span class="Personalize_b_middle_a">
                                            *
                                        </span>
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="text" class="Personalize_b_middle_b" value="${MyUser.firstName }"
                                        id="edit-user-firstName" />
                                    </div>
                                    <div class="Personalize_b_middle_left">
                                        &nbsp;
                                    </div>
                                    <div class="Personalize_b_middle_right" style="display: none;" id="edit-user-firstName-title">
                                        <i class="Addonecuowu_b">
                                            	请输入您的姓氏
                                        </i>
                                    </div>
                                </li>
                                <s:authorize ifAllGranted="ROLE_PRACTICE">
									<li>
	                                    <div class="Personalize_b_middle_left">
	                                        	角色
	                                    </div>
	                                    <div class="Personalize_b_middle_right">
                                        	<jsp:include page="../u_practice/role.jsp"></jsp:include>
	                                    </div>
	                                    <div class="Personalize_b_middle_left">
                                        &nbsp;
	                                    </div>
	                                    <div class="Personalize_b_middle_right" style="display: none;" id="user_type-title">
	                                        <i class="Addonecuowu_b">
	                                            	请选择角色
	                                        </i>
	                                    </div>
                               	 	</li>
								</s:authorize>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        	外部ID
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="text" class="Personalize_b_middle_b" value="${MyUser.externalID }"
                                        id="edit-user-externalID" />
                                    </div>
                                </li>
                            </ul>
                        </form>
                    </div>
                    <div class="Personalize_b_bottom">
                    </div>
                </div>
                <div class="Personalize_a">
                    	身份验证
                </div>
                <div class="Personalize_b">
                    <div class="Personalize_b_top">
                    </div>
                    <div class="Personalize_b_middle">
                        <form action="" method="get">
                            <ul>
                                <li>
                                    <!-- <div class="Personalize_b_middle_left">编号</div>
                                    -->
                                    <div class="Personalize_b_middle_right">
                                        <!-- ${MyUser.accountId }-->
                                        <input type="hidden" id="edit-user-accountId" value="${MyUser.accountId }"
                                        />
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        <span>
                                            	邮箱
                                        </span>
                                        <span class="Personalize_b_middle_a">
                                            *
                                        </span>
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="text" class="Personalize_b_middle_b" value="${MyUser.email }"
                                        id="edit-user-email" />
                                    </div>
                                    <div class="Personalize_b_middle_left">
                                        &nbsp;
                                    </div>
                                    <div class="Personalize_b_middle_right" style="display: none;" id="edit-user-email-title">
                                        <i class="Addonecuowu_b">
                                            	请输入您的邮箱
                                        </i>
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        <span>
                                            	确认邮箱
                                        </span>
                                        <span class="Personalize_b_middle_a">
                                            *
                                        </span>
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="text" class="Personalize_b_middle_b" value="${MyUser.email }"
                                        id="edit-user-Confirm-email" />
                                    </div>
                                    <div class="Personalize_b_middle_left">
                                        &nbsp;
                                    </div>
                                    <div class="Personalize_b_middle_right" style="display: none;" id="edit-user-Confirm-email-title">
                                        <i class="Addonecuowu_b">
                                            	两次输入不一致
                                        </i>
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        <span>
                                          	  密码
                                        </span>
                                        <span class="Personalize_b_middle_a">
                                            *
                                        </span>
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="password" class="Personalize_b_middle_b" value="${password}"
                                        id="edit-user-password" />
                                    </div>
                                    <div class="Personalize_b_middle_left">
                                        &nbsp;
                                    </div>
                                    <div class="Personalize_b_middle_right" style="display: none;" id="edit-user-password-title">
                                        <i class="Addonecuowu_b">
                                            	请输入您的密码
                                        </i>
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        <span>
                                            	确认密码
                                        </span>
                                        <span class="Personalize_b_middle_a">
                                            *
                                        </span>
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <input name="" type="password" class="Personalize_b_middle_b" value="${password}"
                                        id="edit-user-Confirm-password" />
                                    </div>
                                    <div class="Personalize_b_middle_left">
                                        &nbsp;
                                    </div>
                                    <div class="Personalize_b_middle_right" style="display: none;" id="edit-user-Confirm-password-title">
                                        <i class="Addonecuowu_b">
                                            	两次密码输入不一致
                                        </i>
                                    </div>
                                </li>
                            </ul>
                        </form>
                    </div>
                    <div class="Personalize_b_bottom">
                    </div>
                </div>
                <div class="Personalize_a">
                    邮件订阅
                </div>
                <div class="Personalize_b">
                    <div class="Personalize_b_top">
                    </div>
                    <div class="Personalize_b_middle">
                        <form action="" method="get">
                            <ul>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                       新闻资讯
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <c:choose>
                                            <c:when test="${MyUser.ddxNewsletter=='checked'}">
                                                <input name="" type="checkbox" checked="checked" value="" id="edit-user-ddxNewsletter"
                                                />
                                            </c:when>
                                            <c:otherwise>
                                                <input name="" type="checkbox" value="" id="edit-user-ddxNewsletter" />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        每日总结
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <c:choose>
                                            <c:when test="${MyUser.ddxDailySummary=='checked'}">
                                                <input name="" type="checkbox" checked="checked" value="" id="edit-user-ddxDailySummary"
                                                />
                                            </c:when>
                                            <c:otherwise>
                                                <input name="" type="checkbox" value="" id="edit-user-ddxDailySummary"
                                                />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </li>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                      活动日志
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <dl>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.casesCreated==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-casesCreated"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-casesCreated" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	订单创建
                                                </span>
                                            </dt>
                                            <dd>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.casesCreatedPracticeUpdatesOnly==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" <c:if test="${LogSetting.casesCreated==true}">disabled="disabled"</c:if> id="edit-user-casesCreatedPracticeUpdatesOnly"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" <c:if test="${LogSetting.casesCreated==true}">disabled="disabled"</c:if> id="edit-user-casesCreatedPracticeUpdatesOnly"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	订单创建 - 只包括临床
                                                </span>
                                            </dd>
                                            <dd>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.casesCreatedLabUpdatesOnly==true}">
                                                            <input name="" type="checkbox" checked="checked" <c:if test="${LogSetting.casesCreated==true}">disabled="disabled"</c:if> value="" id="edit-user-casesCreatedLabUpdatesOnly"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" <c:if test="${LogSetting.casesCreated==true}">disabled="disabled"</c:if> value="" id="edit-user-casesCreatedLabUpdatesOnly"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	订单创建 - 只包括技工间
                                                </span>
                                            </dd>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.updatedCases==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-updatedCases"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-updatedCases" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	订单更新
                                                </span>
                                            </dt>
                                            <dd>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.updatedCasesPracticeUpdatesOnly==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" <c:if test="${LogSetting.updatedCases==true}">disabled="disabled"</c:if> id="edit-user-updatedCasesPracticeUpdatesOnly"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" <c:if test="${LogSetting.updatedCases==true}">disabled="disabled"</c:if> id="edit-user-updatedCasesPracticeUpdatesOnly"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	订单更新 - 只包括临床
                                                </span>
                                            </dd>
                                            <dd>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.updatedCasesLabUpdatesOnly==true}">
                                                            <input name="" type="checkbox" checked="checked" <c:if test="${LogSetting.updatedCases==true}">disabled="disabled"</c:if> value="" id="edit-user-updatedCasesLabUpdatesOnly"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" <c:if test="${LogSetting.updatedCases==true}">disabled="disabled"</c:if> id="edit-user-updatedCasesLabUpdatesOnly"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	订单更新- 只包括技工间
                                                </span>
                                            </dd>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.pickupRequests==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-pickupRequests"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-pickupRequests"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	取件要求
                                                </span>
                                            </dt>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.balancePayments==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-balancePayments"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-balancePayments"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                   	 付款
                                                </span>
                                            </dt>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.statements==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-statements"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-statements" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                   	 账单报表
                                                </span>
                                            </dt>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.invoices==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-invoices"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-invoices" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	发票
                                                </span>
                                            </dt>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.accounts==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-accounts"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-accounts" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	账户
                                                </span>
                                            </dt>
                                            <dd>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.accountsPracticeUpdatesOnly==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-accountsPracticeUpdatesOnly"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-accountsPracticeUpdatesOnly"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	账户- 只包括临床更新
                                                </span>
                                            </dd>
                                            <dd>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${LogSetting.accountsLabUpdatesOnly==true}">
                                                            <input name="" type="checkbox" checked="checked" value="" id="edit-user-accountsLabUpdatesOnly"
                                                            />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="" type="checkbox" value="" id="edit-user-accountsLabUpdatesOnly"
                                                            />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	账户 - 只包括技工间更新
                                                </span>
                                            </dd>
                                        </dl>
                                    </div>
                                </li>
                                <s:authorize ifAllGranted="ROLE_PRACTICE">
									<li>
	                                    <div class="Personalize_b_middle_left">
	                                    	自动跟踪订单
	                                    </div>
	                                    <div class="Personalize_b_middle_right">
	                                    	<select id="auto-Follow-Cases">
	                                    		<option value="">请选择</option>
	                                    		<option value="ALL" <c:if test="${MyUser.autoFollowCases == 'ALL' }">selected="selected"</c:if>>所有变更</option>
	                                    		<option value="LAB" <c:if test="${MyUser.autoFollowCases == 'LAB' }">selected="selected"</c:if>>技工间变更</option>
	                                    	</select>
	                                    </div>
                               	 	</li>
								</s:authorize>
                            </ul>
                        </form>
                    </div>
                    <div class="Personalize_b_bottom">
                    </div>
                </div>
                <div class="Personalize_a">
                    	偏好
                </div>
                <div class="Personalize_b">
                    <div class="Personalize_b_top">
                    </div>
                    <div class="Personalize_b_middle">
                        <form action="" method="get">
                            <ul>
                                <li>
                                    <div class="Personalize_b_middle_left">
                                        	牙位标记法
                                    </div>
                                    <div class="Personalize_b_middle_right">
                                        <dl>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${MyUser.teethNotation=='1'}">
                                                            <input name="teethNotation" type="radio" value="1" checked="checked" />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="teethNotation" type="radio" value="1" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    FDI
                                                </span>
                                            </dt>
                                            <dt>
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${MyUser.teethNotation=='2'}">
                                                            <input name="teethNotation" type="radio" value="2" checked="checked" />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input name="teethNotation" type="radio" value="2" />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span>
                                                    	普通的
                                                </span>
                                            </dt>
                                        </dl>
                                    </div>
                                </li>
                            </ul>
                        </form>
                    </div>
                    <div class="Personalize_b_bottom">
                    </div>
                </div>
                <s:authorize ifAllGranted="ROLE_PRACTICE">
                	<c:if test="${MyUser.isMain != 'true' and MyUser.accountId != sessionUser.accountId}">
                		<div class="Personalize_a">
                    	内部权限
	                	</div>
	                	<div class="Personalize_b">
		                    <div class="Personalize_b_top">
		                    </div>
		                    <div class="Personalize_b_middle">
		                        <form action="" method="get">
		                            <ul>
		                                <li>
		                                    <div class="Personalize_b_middle_left">
		                                        	管理用户
		                                    </div>
		                                    <div class="Personalize_b_middle_right">
		                                       	<input type="checkbox" id="manager-Account" <c:if test="${MyUser.managerAccount == 'true' }">checked="checked"</c:if>/>
		                                    </div>
		                                </li>
		                                 <li>
		                                    <div class="Personalize_b_middle_left">
		                                        	标签订单
		                                    </div>
		                                    <div class="Personalize_b_middle_right">
		                                       	<select id="create-CaseTags">
		                                       		<option value="true" <c:if test="${MyUser.createCaseTags == 'true' }">selected="selected"</c:if>>是</option>
		                                       		<option value="false" <c:if test="${MyUser.createCaseTags == 'false' }">selected="selected"</c:if>>否</option>
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
                    	技工间权限
                		</div>
	                	<div class="Personalize_b">
		                    <div class="Personalize_b_top">
		                    </div>
		                    <div class="Personalize_b_middle">
		                        <form action="" method="get">
		                            <ul>
		                                 <li id="Lab-Permissions-div">
		                                    
		                                </li>
		                            </ul>
		                        </form>
		                    </div>
		                    <div class="Personalize_b_bottom">
		                    </div>
		                </div>
                	</c:if>
				</s:authorize>
				
				<s:authorize ifAllGranted="ROLE_LAB">
                	<c:if test="${sessionUser.isMain == 'true' }">
                		<div class="Personalize_a">
                    	议价设置
	                	</div>
	                	<div class="Personalize_b">
		                    <div class="Personalize_b_top">
		                    </div>
		                    <div class="Personalize_b_middle">
		                        <form action="" method="get">
		                            <ul>
		                                 <li>
		                                    <div class="Personalize_b_middle_left">
		                                        	优惠限度
		                                    </div>
		                                    <div class="Personalize_b_middle_right">
										<input name="" type="text" class="Personalize_b_middle_b"
											id="preferential_limit" value="${MyUser.preferentialLimit }"
											onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
											onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"
											maxlength="2" />&nbsp;&nbsp;%
		                                    </div>
		                                </li>
		                            </ul>
		                        </form>
		                    </div>
		                    <div class="Personalize_b_bottom">
		                    </div>
		                </div>
		                
                	</c:if>
				</s:authorize>
				
				<div>
					<dl>
						<dt class="UserAccountsAdd">
		                  <a href="javascript:void(0)" onclick="editUser('<%=request.getParameter("url") %>');">
		                     	 提交
		                  </a>
	              		</dt>
					</dl>
				</div>
            </div>
        </div>
        <script>
	        $(function(){
	        	$('#edit-user-casesCreated').click(function(){
	        		if($(this).attr("checked")=='checked'){
	        			$("#edit-user-casesCreatedPracticeUpdatesOnly").attr("checked","checked").attr("disabled","disabled");
	        			$("#edit-user-casesCreatedLabUpdatesOnly").attr("checked","checked").attr("disabled","disabled");
	        		}else{
	        			$("#edit-user-casesCreatedPracticeUpdatesOnly").removeAttr("disabled");
	        			$("#edit-user-casesCreatedLabUpdatesOnly").removeAttr("disabled");
	        		}
	        	});
	        	$('#edit-user-updatedCases').click(function(){
	        		if($(this).attr("checked")=='checked'){
	        			$("#edit-user-updatedCasesPracticeUpdatesOnly").attr("checked","checked").attr("disabled","disabled");
	        			$("#edit-user-updatedCasesLabUpdatesOnly").attr("checked","checked").attr("disabled","disabled");
	        		}else{
	        			$("#edit-user-updatedCasesPracticeUpdatesOnly").removeAttr("disabled");
	        			$("#edit-user-updatedCasesLabUpdatesOnly").removeAttr("disabled");
	        		}
	        	});
	        });
        </script>