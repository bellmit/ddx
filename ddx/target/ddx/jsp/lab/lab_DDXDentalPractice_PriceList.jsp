<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function printit(){  
	if (confirm('确定打印吗？')){  
		bdhtml=window.document.body.innerHTML;// 获取当前页的html代码
		sprnstr="<!--startprint-->";// 设置打印开始区域
		eprnstr="<!--endprint-->";// 设置打印结束区域
		prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); // 从开始代码向后取html
		prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));// 从结束代码向前取html
		window.document.body.innerHTML=prnhtml;  
		window.print();  
		window.document.body.innerHTML=bdhtml;  
	}  
} 
</script>
<!--startprint-->
<div class="General_middle_bottom_a">报价单</div>
<div class="General_middle_bottom_b">
<div class="General_middle_bottom_b_top"></div>
<div class="General_middle_bottom_b_middle">

<div class="DDXDentalPractice_PriceList_f"><a
	href="javascript:void(0)" onclick="printit()">打印</a></div>

<div class="DDXDentalPractice_PriceList">
<form method="get" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0"  id="price-list-table">

	<tbody>
		<tr>
			<td class="DDXDentalPractice_PriceList_a"><a
				href="javascript:void(0)">工序名称</a></td>
			<td class="DDXDentalPractice_PriceList_b"><a
				href="javascript:void(0)">工序类别</a></td>
			<td class="DDXDentalPractice_PriceList_c"><a
				href="javascript:void(0)">价格</a></td>
			<td class="DDXDentalPractice_PriceList_d"><a
				href="javascript:void(0)">周转天数</a></td>
		</tr>

		<c:if test="${!empty datas}">
			<c:forEach items="${datas}" var="data">
				<tr>
					<td><h2>${data.displayDescription }</h2>
					
						<c:forEach items="${data.attrbutesList}" var="al">
							<div><span style="width: 100px;margin-left: 30px;"><strong>${al.lable }</strong>:${al.attr }</span></div>
						</c:forEach>
					</td>
					<td>${data.categoryName }</td>
					<td>${data.price }</td>
					<td>${data.turnAroundDays }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty datas}">
			<tr align="center">
				<td colspan="4" align="center">暂无数据</td>
			</tr>
		</c:if>
	</tbody>
</table>
</form>
</div>
</div>
<div class="General_middle_bottom_b_bottom"></div>
<div class="Addone"></div>
</div>
<!--endprint-->