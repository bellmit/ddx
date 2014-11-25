<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/reports_patients.js"></script> 

<div class="center">
<!--工厂实验室会员中心开始-->
<div class="Patients">
<div class="Patients_a">患者</div>
<div class="Patients_b">
<div class="Patients_b_top"></div>
<div class="Patients_b_middle">
<form action="" method="get">
<div class="Patients_b_middle_a">
<div class="Patients_b_middle_a_left">
<!-- 索搜框开始 -->
<div class="Settings_Practices_middle_a_leftsearch">
	<div class="Settings_Practices_middle_a_leftsearch01">
		搜 索：
	</div>
	<div class="Settings_Practices_middle_a_leftsearch02">
		<input name="input" type="text" value="${search }" id="search-patient"/>
		<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" onclick="listPatients('1','search')"/>
		</a>
	</div>
</div>
<!-- 索搜框结束-->
</div>
<div class="Patients_b_middle_a_right"></div>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${datas.frist }到${datas.last },共${datas.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset-1},'page');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset+1},'page');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"/></a></a></span>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
</c:choose>
</div>
</div>
<div class="Patients_b_middle_c">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr class="Patients_b_middle_c_a">
    <td>
    <span>姓</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>名</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>医生</span>
    </td>
    <td>
    <span>出生日期</span>
    <span><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab9_14.jpg"/></a></div><div class="Patients_b_middle_c_a_a"><a href="#"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_17.jpg"/></a></div>
    </span>
    </td>
    <td>
    <span>性别</span>
    <span><a href="#" class="Patients_b_middle_c_a_b"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab20_19.jpg"/></a></span>
    </td>
    <td></td>
</tr>
<c:forEach items="${datas.datas }" var="obj" varStatus="i">
	<c:choose>
		<c:when test="${(i.index+1)%2 eq 1 }">
			<tr class="odd">
		</c:when>
		<c:otherwise>
			<tr class="even">
		</c:otherwise>
	</c:choose>
		<td>${obj.firstName }</td>
		<td>${obj.lastName }</td>
		<td></td>
		<td>${obj.birthday }</td>
		<td>
			<c:choose>
				<c:when test="${obj.sex == '0' }">
					男
				</c:when>
				<c:otherwise>
					女
				</c:otherwise>
			</c:choose>
		</td>
		<td class="Patients_b_middle_c_a_operate">
			<a href="${pageContext.request.contextPath}/labAction/reports/patient.do?id=${obj.id}">查看</a>
		</td>
	</tr>
</c:forEach>
  
</table>
</div>
<div class="Patients_b_middle_b">
<div class="Patients_b_middle_b_left">显示从${datas.frist }到${datas.last },共${datas.total }个</div>
<div class="Patients_b_middle_right">
<c:choose>
	<c:when test="${datas.offset==datas.totalPage and datas.offset==1}">
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"></a></span>
		<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab11_09.jpg"></a></span>
	</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${datas.offset<=datas.totalPage and datas.offset>1}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset-1},'page');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/up.jpg"/></a></span>
				</c:when>
				<c:otherwise>
				<span><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab10_07.jpg"/></a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${datas.offset<datas.totalPage}">
				<span><a href="javascript:void(0)" onclick="listPatients(${datas.offset+1},'page');"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/next.jpg"/></a></span>
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
<div class="Patients_b_bottom"></div>
</div>
</div>
<!--工厂实验室会员中心结束-->
</div>