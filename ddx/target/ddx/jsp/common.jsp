<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/ajaxUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/json/JSON.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tools/datePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ddx.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui-1.10.4.min.css">
<!-- 全局进度条 -->
<div id="data-loading-div" class="flashload" style="display: none;">
  <table>
    <tr>
      <td>
        <img src="${pageContext.request.contextPath}/img/dataload.gif">
      </td>
      <td id="msg">
        	正在加载数据... ...
      </td>
    </tr>
  </table>
</div>
<div id="exception-div" style="display: none;"></div>
