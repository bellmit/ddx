<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){		
		 $(".menu_all .first").click(function(){
			 $('.menuu_s').hide();
			$(this).find(".menuu_s").toggle();
			$(".menu_all .first1").find(".menuu_s").hide();
		});		
		 $(document).on('click', function(e) {
        if ($('.menu_all li').is(e.target) || $('.menu_all li').has(e.target).length) {
          return;
		}
              $('.menuu_s').hide();

  });
		 });
</script>
<div class="Cases_bottom_right_a">搁置类型</div>
<div class="Settings_Practices">
<div class="Settings_Practices_top"></div>
<div class="Settings_Practices_middle">
<form method="get" action="">
<div class="Settings_Practices_middle_a">
<div class="Settings_Practices_middle_a_left">
<div class="Settings_Practices_middle_a_leftsearch">
	<div class="Settings_Practices_middle_a_leftsearch01">
		搜 索：
	</div>
	<div class="Settings_Practices_middle_a_leftsearch02">
		<input name="input" type="text" value="${search }" id="search-OnHold" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'')"/>
		<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listHoldType('1')"/>
		</a>
	</div>
</div>
</div>
<div class="Settings_Practices_middle_a_right">
<ul>
<li class="LabCaseSettingCoupons_b"><a href="javascript:void(0)" onclick="showAddHoldTypeDialog()">增加</a></li>
</ul>
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
				<span><a href="javascript:void(0)" onclick="listHoldType(${datas.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listHoldType(${datas.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
    <span>名称</span>
    <span><a class="Settings_Practices_middle_c_a_b" href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg"></a></span>
    </td>
    <td></td>
 </tr>
  <c:forEach items="${datas.datas}" var="caseh">
  <tr>
    <td>${caseh.name }</td>
    <td class="General_RemakeTypes">
    <div class="LabDetails_f_e">
    <div class="LabDetails_f_e_left"><a href="javascript:void(0)" onclick="showAddHoldTypeDialog('${caseh.id}')">修改</a></div>
       <div class="LabDetails_f_e_right">
	    	 <!--小菜单下拉开始-->
			   <ol class="menu_all">
			     <li class="first"><a href="javascript:void(0)"></a>         	
			     <ol class="menuu_s">
			     <li>
			       <ol class="menu_bgrightcenter">
			     <li class="menu_bgrighttop"><img src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg" width="160" height="4" /></li>
			     <li class="menu_bgdelete"><a href="javascript:void(0)" onclick="deleteHold('${caseh.id}')">删 除</a></li>
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
				<span><a href="javascript:void(0)" onclick="listHoldType(${datas.offset-1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listHoldType(${datas.offset+1});"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
<div id="add_lab_onhold" style="display: none;">
	<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a"></div>
<div class="Personalize">
<div class="Personalize_a"></div>
<div class="Personalize_b">
<div class="Personalize_b_top"></div>
<div class="Personalize_b_middle">
<form method="get" action="">
<ul>
<li>
<div class="Personalize_b_middle_left" id="addholdname"><span>名称</span><span class="Personalize_b_middle_a">*</span></div>
<div class="Personalize_b_middle_right">
<input type="hidden" class="Personalize_b_middle_b" name="" id="edit-lab-hold-id">
<input type="text" class="Personalize_b_middle_b" name="" id="edit-lab-hold"> 
</div>

<div class="Personalize_b_middle_left">&nbsp;</div>
		<div class="Personalize_b_middle_right" style="display: none;" id="editErrorMessage"><i class="Addonecuowu_b">请输入保持类型名称</i></div>
		
</li>
<li>
<div class="Personalize_b_middle_left">&nbsp;</div>
<div class="Personalize_b_middle_right"><span class="UserAccountsAdd"><a href="javascript:void(0)"  id="save-function">保存</a></span></div>
</li>
</ul>
</form>
</div>
<div class="Personalize_b_bottom"></div>
</div>
</div>
</div>
</div>