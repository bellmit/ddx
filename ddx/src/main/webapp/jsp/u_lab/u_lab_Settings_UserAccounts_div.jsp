<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<div class="Cases_bottom_right_a">用户列表</div>
<div class="Settings_Practices">
<div class="Settings_Practices_top"></div>
<div class="Settings_Practices_middle">
<form action="" method="get">
<div class="Settings_Practices_middle_a">
<div class="Settings_Practices_middle_a_left">
<!-- 索搜框开始 -->
<div class="Settings_Practices_middle_a_leftsearch">
	<div class="Settings_Practices_middle_a_leftsearch01">
		搜 索：
	</div>
	<div class="Settings_Practices_middle_a_leftsearch02">
		<input name="input" type="text" value="${search }" id="search-users" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"/>
		<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listLabUsers('1')"/>
		</a>
	</div>
</div>
<!-- 索搜框结束-->
</div>
<div class="Settings_Practices_middle_a_right">
<ul>
<li class="UserAccounts"><a href="javascript:void(0)" onclick="showAddUserDialog();">增加</a></li>
</ul>
</div>
</div>

<!-- 翻页处理 begin -->
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${pm.frist }到${pm.last }，共${pm.total }</div>
<div class="Settings_Practices_middle_b_right">
	<c:choose>
		<c:when test="${pm.offset==pm.totalPage and pm.offset==1}">
			<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
			<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></span>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${pm.offset<=pm.totalPage and pm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listLabUsers(${pm.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pm.offset<pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listLabUsers(${pm.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</div>
</div>
<!-- 翻页处理 end -->

<div class="Settings_Practices_middle_c">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr class="Settings_Practices_middle_c_a">
    <td> 
    <span>编号</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div>
    <div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>用户</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div>
    <div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>名称</span>
     <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div>
     <div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>姓氏</span>
    <span><a href="#" class="Settings_Practices_middle_c_a_b"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg"/></a></span>
    </td>
    <td></td>
    
    <c:forEach items="${pm.datas}" var="user">
		<tr>
			<td>${user.accountId }</td>
			<td>
				<c:choose>
					<c:when test="${user.isMain=='true' }">
						${user.email }<font color="red">（主账户）</font>
					</c:when>
					<c:otherwise>
						${user.email }
					</c:otherwise>
				</c:choose>
			</td>
			<td>${user.lastName }</td>
			<td>${user.firstName }</td>
			
			<c:choose>
				<c:when test="${user.isMain=='true' }">
					   <td class="UserAccounts_a">
					   		<a href="${pageContext.request.contextPath }/userAction/getUser.do?userId=${user.accountId}">编辑</a>
					   </td>
				</c:when>
				<c:otherwise>
					    <td class="General_RemakeTypes">
							<!-- <a href="${pageContext.request.contextPath }/userAction/getUser.do?userId=${user.accountId}">编辑</a>  -->
							<!--<div class="LabDetails_f_e">
							    <div class="LabDetails_f_e_left"><a href="${pageContext.request.contextPath }/userAction/getUser.do?userId=${user.accountId}">编辑</a></div>
							    <div class="LabDetails_f_e_right">
							    	<div id="u-lab-delete-user"><a href="javascript:void(0)" onclick="deleteLabUser(${user.accountId});"></a></div>
							    </div>
						    </div>
						    -->
						    <div class="LabDetails_f_e">
							    <div class="LabDetails_f_e_left"><a href="${pageContext.request.contextPath }/userAction/getUser.do?userId=${user.accountId}">编辑</a></div>
							    <div class="LabDetails_f_e_right">
							    	 <!--小菜单下拉开始-->
									   <ol class="menu_all">
									     <li class="first">
											<a href="javascript:void(0)"></a>    
									     <ol class="menuu_s">
									     <li>
									       <ol class="menu_bgrightcenter">
									     <li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
											<li class="menu_bgdelete"><a href="javascript:void(0)" onclick="deleteLabUser(${user.accountId});">删 除</a></li>
									     <li class="menu_bgrightbottom"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg" width="160" height="4" /></li>
									       </ol>
									       </li>
									     </ol>
									        </li>
									</ol>
									    <!--小菜单下拉结束-->
							    </div>
					      </div>
						</td>
				</c:otherwise>
			 </c:choose>
		</tr>
	</c:forEach>
</tr>
</table>
</div>

<!-- 翻页处理 begin -->
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${pm.frist }到${pm.last }，共${pm.total }</div>
<div class="Settings_Practices_middle_b_right">
	<c:choose>
		<c:when test="${pm.offset==pm.totalPage and pm.offset==1}">
			<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
			<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></span>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${pm.offset<=pm.totalPage and pm.offset>1}">
				<span><a href="javascript:void(0)" onclick="listLabUsers(${pm.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pm.offset<pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listLabUsers(${pm.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</div>
</div>
<!-- 翻页处理 end -->

</form>
</div>
<div class="Settings_Practices_bottom"></div>
</div>