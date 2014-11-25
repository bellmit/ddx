<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<div class="Cases_bottom_right_a">工序列表</div>
<div class="Settings_Practices">
<div class="Settings_Practices_top"></div>
<div class="Settings_Practices_middle">
<form method="get" action="">
<div class="Settings_Practices_middle_a">
<div class="Settings_Practices_middle_a_left">
<!-- 索搜框开始 -->
<div class="Settings_Practices_middle_a_leftsearch">
	<div class="Settings_Practices_middle_a_leftsearch01">
		搜 索：
	</div>
	<div class="Settings_Practices_middle_a_leftsearch02">
		<input name="input" type="text" value="${search }" id="search-procedure" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"/>
		<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listLabProcedures('1')"/>
		</a>
	</div>
</div>
<!-- 索搜框结束-->
</div>
<div class="Settings_Practices_middle_a_right">

<ul>
	<li class="UserAccounts"><a href="${pageContext.request.contextPath}/labAction/setting/procedure.do" onclick="javascript:void(0)">增加</a></li>
</ul>
	<!-- 
 	<div class="LabDetails_f_e">
    <div class="LabDetails_f_e_left"><a href="${pageContext.request.contextPath}/labAction/setting/procedure.do">新增</a></div>
    <div class="LabDetails_f_e_right" style="text-align: left">
		   <ol class="menu_all">
		     <li class="first"><a href="javascript:void(0)"></a>         	
		     <ol class="menuu_s">
		     <li>
		       <ol class="menu_bgrightcenter">
		     <li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
		     <li class="menu_bgright"><a href="javascript:void(0)">批量修改</a></li>
		     <li class="menu_bgrightbottom"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg" width="160" height="4" /></li>
		       </ol>
		       </li>
		     </ol>
		        </li>
		</ol>
    </div>
    </div>
 -->
</div>
</div>
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.frist }到${datas.last }共${datas.total }个</div>
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
				<span><a href="javascript:void(0)" onclick="listLabProcedures(${datas.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listLabProcedures(${datas.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
<div class="Settings_Practices_middle_c">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr class="Settings_Practices_middle_c_a">
  <td> 
    <span>工序名称</span>
    <span><a class="Settings_Practices_middle_c_a_b" href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg"></a></span>
    </td>
    <td>
    <span>工序类别.</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"></a></div>
    </span>
    </td>
    <td>
    <span>周转天数</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"></a></div>
    </span>
    </td>
    <td>
    <span>排序</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"></a></div>
    </span>
    </td>
    <td></td>
 </tr>
  <c:forEach items="${datas.datas}" var="pro">
  	  <tr>
    <td style="width: 50%;">
	    <div>${pro.procedure.displayName }</div>
	 	<div><strong> 属性:</strong> ${pro.attr } </div>
 	</td>
    <td>${pro.category } </td>
    <td>${pro.procedure.schedulingTurnAroundDays }</td>
    <td>${pro.procedure.displaySortRank }</td>
    <td class="General_RemakeTypes">
    <div class="LabDetails_f_e">
    <div class="LabDetails_f_e_left"><a href="${pageContext.request.contextPath}/labAction/setting/procedure.do?id=${pro.procedure.proceduresId }">编辑</a></div>
    <div class="LabDetails_f_e_right">
    	 <!--小菜单下拉开始-->
		   <ol class="menu_all">
		     <li class="first"><a href="javascript:void(0)"></a>         	
		     <ol class="menuu_s">
		     <li>
		       <ol class="menu_bgrightcenter">
		     <li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
		     <!-- 
		     <li class="menu_bgright"><a href="javascript:void(0)">复制</a></li>
		      -->
		     <li class="menu_bgdelete"><a href="javascript:void(0)" onclick="deleteProcedure('${pro.procedure.proceduresId}')">删 除</a></li>
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
  </tr>
  </c:forEach>
</tbody></table>
</div>
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.frist }到${datas.last }共${datas.total }个</div>
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
				<span><a href="javascript:void(0)" onclick="listLabProcedures(${datas.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listLabProcedures(${datas.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
</form>
</div>
<div class="Settings_Practices_bottom"></div>
</div>

<!-- 新增工序DIV 开始 -->
<div id="new_procedure_div" style="display: none;">
	<iframe ></iframe>
</div>
<!-- 新增工序DIV 结束 -->