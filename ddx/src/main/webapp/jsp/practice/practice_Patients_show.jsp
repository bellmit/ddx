<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="gcsyshyzx">

<div class="Cases">
<div class="Cases_top">临床</div>
<div class="Cases_bottom">
<div class="Cases_bottom_left">
	<jsp:include page="practice-center-left-menu.jsp"/>
</div>
<div class="Cases_bottom_right">
<div class="Cases_bottom_right_a">患者</div>
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
		<input name="input" type="text" value="${search }" id="search-patient"/>
		<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listPatients('1','Y')"/>
		</a>
	</div>
</div>
<!-- 索搜框结束-->
</div>
<div class="Settings_Practices_middle_a_right">
<!--<ul>
<li class="UserAccounts"><a href="#"></a></li>
</ul>-->
</div>
</div>
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.frist }到${datas.last },共${datas.total }个</div>
<div class="Settings_Practices_middle_right">
<c:choose>
	<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset-1},'');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset+1},'');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
  <tr class="Settings_Practices_middle_c_a">
  	<td> 
    <span>姓</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>名</span>
    <span><a href="#" class="Settings_Practices_middle_c_a_b"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab20_19.jpg"/></a></span>
    </td>
    <td>
    <span>出生日期</span>
    <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>性别</span>
     <span><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Settings_Practices_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath }/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td></td>
</tr>
<c:forEach items="${datas.datas}" var="patient">
	<tr>
	    <td class="practicemonthPatients_a"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patient&id=${patient.id}">${patient.firstName }</a></td>
	    <td class="practicemonthPatients_a"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patient&id=${patient.id}">${patient.lastName }</a></td>
	    <td>${patient.birthday }</td>
	    <td>
	    <c:if test="${patient.sex eq '0' }">
	    	男
	    </c:if>
	    <c:if test="${patient.sex eq '1' }">
	    	女
	    </c:if>
	    </td>
	    <td class="practicemonthPatients"><a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=patient&id=${patient.id}">查看</a></td>
  	</tr>
</c:forEach>
</table>
</div>
<div class="Settings_Practices_middle_b">
<div class="Settings_Practices_middle_b_left">显示从${datas.frist }到${datas.last },共${datas.total }个</div>
<div class="Settings_Practices_middle_b_right">
<c:choose>
	<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset-1},'');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset+1},'');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
</div>
</div>
</div>
</div>
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
