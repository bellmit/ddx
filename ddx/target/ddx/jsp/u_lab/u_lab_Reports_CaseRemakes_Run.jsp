<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.upcera.ddx.common.util.ToolsKit"%>
<%@page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common.jsp" />
<head>
<title>重制订单</title>
<link href="${pageContext.request.contextPath}/jsp/common/css/commom.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/jsp/u_lab/css/u_lab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/reports_remake.js"></script>
</head>

<body> 
<div id="no-data-div" class="flashload" style="display: none;">
  <table>
    <tr>
      <td>
        <img src="${pageContext.request.contextPath}/img/dataload.gif">
      </td>
      <td id="msg">
        	没有数据... ...
      </td>
    </tr>
  </table>
</div>
<div class="page">
<!--底部开始-->
<jsp:include page="../head.jsp" />
<!--头部结束-->
<!--中间开始-->
<div class="center">
<!--工厂实验室会员中心开始-->
<div class="Parameters">
<div class="Parameters_a">
<div class="Parameters_a_left"><fmt:formatDate value="${startDate }" type="date" pattern="yyyy-MM-dd" /> 至 <fmt:formatDate value="${endDate }" type="date" pattern="yyyy-MM-dd" /> 的重制订单</div>
<div class="Parameters_a_right"><a href="javascript:void(0)" onclick="$('.Parameters_b').slideToggle()">高级搜索</a></div>
</div>
<div class="Parameters_b" style="display: none;">
<div class="Parameters_b_a">搜索条件</div>
<div class="Parameters_b_b">
<div class="Parameters_b_b_top"></div>
<div class="Parameters_b_b_middle">
<form action="" method="get">
<ul>
<li>
<div class="Parameters_b_b_middle_left"><span>开始时间</span><span class="Parameters_b_b_middle_a">*</span></div>
<div class="Parameters_b_b_middle_right"><input name="startDate" id="startDate" value="<fmt:formatDate value='${startDate }' pattern='yyyy-MM-dd'/>" type="text" onclick="WdatePicker()" class="Parameters_b_b_middle_b" /></div>
</li>
<li>
<div class="Parameters_b_b_middle_left"><span>结束时间</span><span class="Parameters_b_b_middle_a">*</span></div>
<div class="Parameters_b_b_middle_right"><input name="endDate" id="endDate" value="<fmt:formatDate value='${endDate }' pattern='yyyy-MM-dd'/>" type="text" onclick="WdatePicker()" class="Parameters_b_b_middle_b"/></div>
</li>
<li>
<div class="Parameters_b_b_middle_left"><span>临床</span><span class="Parameters_b_b_middle_a">*</span></div>
<div class="Parameters_b_b_middle_right">
	<select id="unitId" class="reports_bottom_c_b_middle_b" name="practice_id">
		<option label="All" value="">All</option>
		${filterOptions }
	</select>
</div>
</li>
<li>
<div class="Parameters_b_b_middle_left"><span>格式</span><span class="Parameters_b_b_middle_a">*</span></div>
<div class="Parameters_b_b_middle_right">
<select class="reports_bottom_c_b_middle_b" name="format" id="cases_remakes_format">
	<option value="">On Screen</option>
	<option value="csv">Csv(Excel)</option>
</select>
</div>
</li>
<li>
<div class="Parameters_b_b_middle_left"></div>
<div class="Parameters_b_b_middle_right">
<span class="Parameters_b_b_middle_c"><a href="javascript:void(0)" onclick="queryCaseRemake()">查询</a></span>
</div>
</li>
</ul>
</form>
</div>
<div class="Parameters_b_b_bottom"></div>
</div>
</div>
<div class="Parameters_c">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="cases-list">
  <tr class="Parameters_c_a">
    <td>临床</td>
    <td>订单</td>
    <td>原因</td>
    <td>源单</td>
  </tr>
  <c:choose>
  	<c:when test="${pm.total eq 0 }">
  		 <tr>
		    <td colspan="4">这里没有订单显示</td>
		 </tr>
  	</c:when>
  	<c:otherwise>
		<c:forEach items="${pm.datas }" var="obj" varStatus="i">
		  	<c:choose>
				<c:when test="${(i.index+1)%2 eq 1 }">
					<tr class="odd">
				</c:when>
				<c:otherwise>
					<tr class="even">
				</c:otherwise>
			</c:choose>
			    <td>${obj.practice }</td>
			    <td>
			    	<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${obj.caseId }" style="text-decoration: underline;" >#${obj.caseId }</a>
				</td>
			    <td>${obj.remakeTypeNam }</td>
			    <td>
			    	<a href="${pageContext.request.contextPath}/casesAction/lab/cases/getCase.do?caseId=${obj.returnSId }" style="text-decoration: underline;" >#${obj.returnSId }</a>
			    </td>
		  </tr>
  </c:forEach>  	
  	</c:otherwise>
  </c:choose>
  
</table>
</div>
</div>
<!--工厂实验室会员中心结束-->
</div>
<!--中间结束-->
<!--底部开始-->
<jsp:include page="../bottom.jsp" />
<!--底部结束-->
</div>
</body>
</html>
