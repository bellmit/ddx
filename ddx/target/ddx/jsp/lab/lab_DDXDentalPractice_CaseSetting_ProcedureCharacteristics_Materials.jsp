<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<div class="Cases_bottom_right_a">工序材料列表</div>
<div class="Settings_Practices">
<div class="Settings_Practices_top"></div>
<div class="Settings_Practices_middle">
<form method="get" action="">

<div class="Settings_Practices_middle_a">
<div class="Settings_Practices_middle_a_left">
<!-- 搜索框开始 -->
<div class="Settings_Practices_middle_a_leftsearch">
	<div class="Settings_Practices_middle_a_leftsearch01">
		搜 索：
	</div>
	<div class="Settings_Practices_middle_a_leftsearch02">
		<input name="input" type="text" value="${datas.search }" id="search" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"/>
		<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listCharacter('1','materials')"/>
		</a>
	</div>
</div>
<!-- 搜索框结束-->
</div>
<div class="Settings_Practices_middle_a_right">
<ul>
<li class="LabCaseSettingCoupons_b"><a href="javascript:void(0)" onclick="goMaterial(0);">增加</a></li>
</ul>
</div>
</div>
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.pm.frist }到${datas.pm.last },共${datas.pm.total }个</div>
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${datas.pm.offset==datas.pm.totalPage and datas.pm.offset==1}">
	<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
	<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${datas.pm.offset<=datas.pm.totalPage and datas.pm.offset>1}">
					<span><a href="javascript:void(0)" onclick="listCharacter(${datas.pm.offset-1},'materials');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
					</c:when>
					<c:otherwise>
					<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${datas.pm.offset<datas.pm.totalPage}">
					<span><a href="javascript:void(0)" onclick="listCharacter(${datas.pm.offset+1},'materials');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
  <tbody>
  <tr class="Settings_Practices_middle_c_a">
    <td>名称</td>
    <td>分类</td>
    <td></td> 
   </tr>
	<c:forEach items="${datas.pm.datas}" var="material">
  <tr>
    <td>
    	${material.characterName }
    </td>
    <td>
	  <c:if test="${material.classfication == 'High Noble' }">高惰性金属</c:if>
	  <c:if test="${material.classfication == 'Nobel' }">惰性金属</c:if>
	  <c:if test="${material.classfication == 'Base' }">盐基</c:if>
	  <c:if test="${material.classfication == 'Titanium' }">钛</c:if>
	  <c:if test="${material.classfication == 'Alumina Ceramic' }">氧化铝陶瓷</c:if>
	  <c:if test="${material.classfication == 'Yitrim Zirconia' }">氧化锆</c:if>
    </td>
    <td class="General_RemakeTypes">
    <div class="LabDetails_f_e">
    <div class="LabDetails_f_e_left">
    	<a href="javascript:void(0)" onclick="goMaterial('${material.id}',1)">修改</a>
    </div>
    
    
    <div class="LabDetails_f_e_right">
    	  <!--小菜单下拉开始-->
		   <ol class="menu_all">
		     <li class="first"><a href="javascript:void(0)"></a>         	
		     <ol class="menuu_s">
		     <li>
		       <ol class="menu_bgrightcenter">
		     <li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
		     <li class="menu_bgdelete"><a href="javascript:void(0)" onclick="delCharacter('delMaterial','${material.id}')">删除</a></li>
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

</tbody>
</table>
</div>
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.pm.frist }到${datas.pm.last },共${datas.pm.total }个</div>
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${datas.pm.offset==datas.pm.totalPage and datas.pm.offset==1}">
	<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
	<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${datas.pm.offset<=datas.pm.totalPage and datas.pm.offset>1}">
					<span><a href="javascript:void(0)" onclick="listCharacter(${datas.pm.offset-1},'materials');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
					</c:when>
					<c:otherwise>
					<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${datas.pm.offset<datas.pm.totalPage}">
					<span><a href="javascript:void(0)" onclick="listCharacter(${datas.pm.offset+1},'materials');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
