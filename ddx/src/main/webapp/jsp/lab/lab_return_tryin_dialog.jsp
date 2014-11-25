<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function showAttrX(id){
	var flag = $("#"+id+"-a-x").attr("flag");
	if(flag=='show'){
		$("#"+id+"-a-x").html("[+]");
		$("#"+id+"-tr-x").hide(500);
		$("#"+id+"-a-x").attr("flag","hide");
	}else{
		$("#"+id+"-a-x").html("[-]");
		$("#"+id+"-tr-x").show(500);
		$("#"+id+"-a-x").attr("flag","show");
	}
}
</script>    
<div class="LabDetails_f">
<form action="" method="get">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="LabDetails_f_b"><a href="javascript:void(0)">说明</a></td>
    <td class="LabDetails_f_b"><a href="javascript:void(0)"></a></td>
  </tr>
  
  <c:forEach items="${proceduresList}" var="pro">
  	<c:if test="${pro.isTryIn != 'ok' }">
  		<tr id="${pro.index }-tr-head" class="practiceCaseDetails_bottom_middle_bottom_b" onmouseover="$(this).attr('style','background-color: #ededed;')" onmouseout="$(this).attr('style','background-color: #ffffff;')">
		    <td onclick="showAttrX('${pro.index }');"><span>${pro.procedure_name }</span><span class="practiceCaseDetails_bottom_middle_bottom_b_c">&nbsp;&nbsp;&nbsp;
		    <a href="javascript:void(0)" id="${pro.index }-a-x" flag="hide">[+]</a></span>
		    </td>
		    <td>
		    	<input name="checkedTryIn" type="checkbox" id="markComplete_id" index="${pro.index }"/>
		    </td>
		  </tr>
		 </c:if>
		  <tr id="${pro.index }-tr-x" style="display: none;" class="LabDetails_f_h">
		  	<td style="padding: 0">
		  		<div>
		  			<table style="width: 100%;margin-left: 20px;">
		  					<c:forEach items="${pro.attrList}" var="attr">
		  						<c:if test="${!empty attr.valueDes }">
		  							<tr>
					  					<td style="padding: 0" class="LabDetails_f_b"><strong>${attr.lable }</strong></td>
					  				</tr>
					  				<tr>
					  					<td style="padding: 0" class="LabDetails_f_b">${attr.valueDes }</td>
				  					</tr>
		  						</c:if>
		  					</c:forEach>
		  			</table>
		  		</div>
		  	</td>
		  	<td></td>
		  </tr>
  </c:forEach>
</table>
</form>
</div>