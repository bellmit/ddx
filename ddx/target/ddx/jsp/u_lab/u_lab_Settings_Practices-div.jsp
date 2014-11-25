<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<form action="" method="get">
<div class="Settings_Practices_middle_a">
<div class="Settings_Practices_middle_a_left">
<!--<span>搜索:</span>
<span>
<input name="" type="text" value="${search }" id="search-lab-practices"/>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" onclick="listLabAndPractices('1','${type}')">搜索</a>
</span>
-->

<div class="Settings_Practices_middle_a_leftsearch">
	<div class="Settings_Practices_middle_a_leftsearch01">
		搜 索：
	</div>
	<div class="Settings_Practices_middle_a_leftsearch02">
		<input name="input" type="text" value="${search }" id="search-lab-practices" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"/>
		<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listLabAndPractices('1','${type}')"/>
		</a>
	</div>
</div>
                      
                      
</div>
<div class="Settings_Practices_middle_a_right" style="text-align:left;">
<li class="LabDetails_a_right_b">
   <ol class="menu_all">
     <li class="first first01">
		<a href="javascript:void(0)">操作</a>    
	     <ol id="menuu_s01" class="menuu_s">
		     <li style=" width:160px;">
		       <ol class="menu_bgrightcenter">
		     	<li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
				<li class="menu_bgrighttop01"><a href="javascript:void(0)" onclick="Assign('assignPriceListGroups.do')">分配价格表组</a></li>		     	
				<li class="menu_bgrighttop01"><a href="javascript:void(0)" onclick="Assign('assignShippingServices.do')">分配送货服务</a></li>
				<!-- <li class="menu_bgrighttop01"><a href="javascript:void(0)" onclick="ExportToExcel()">导出到excel</a></li> -->
		     	<li class="menu_bgrightbottom"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg" width="160" height="4" /></li> 
		       </ol>
		     </li>
	     </ol>
     </li>
</ol>
</li>
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
				<span><a href="javascript:void(0)" onclick="listLabAndPractices('${type }',${pm.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pm.offset<pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listLabAndPractices('${type }',${pm.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
    <span>名称</span>
    <span><a href="#" class="Settings_Practices_middle_c_a_b"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg"/></a></span>
    </td>
    <td>
    <span>城市</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>省份</span>
     <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>国家</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>状态</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td></td>
</tr>
	<c:forEach items="${pm.datas}" var="data">
		<tr>
			<td class="">${data.name }</td>
			<td class="">${data.city }</td>
			<td class="">${data.state }</td>
			<td class="">${data.country }</td>
			<td class="">
				<c:if test="${data.accountStatus ==0}">
						审批通过
				</c:if>
				<c:if test="${data.accountStatus ==1}">
						已关闭
				</c:if>
				<c:if test="${data.accountStatus ==2}">
						待审批
				</c:if>
				<c:if test="${data.accountStatus !=0 and data.accountStatus !=1 and data.accountStatus !=2}">
						状态数据异常，请联系管理员
				</c:if>
			</td>
			<td class=UserAccounts_a><a href="javascript:void(0)" onclick="myCooperationPractices('${data.id }','${type }');">编辑</a></td>
		</tr>
	</c:forEach>
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
				<span><a href="javascript:void(0)" onclick="listLabAndPractices('${type }',${pm.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pm.offset<pm.totalPage}">
				<span><a href="javascript:void(0)" onclick="listLabAndPractices('${type }',${pm.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
