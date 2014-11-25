<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<script type="text/javascript">
 	function removeTr(id){
 	 	if(!confirm("确认删除？")){
			return;
 	 	}
		$("#"+id).remove();
	}
	function updateTr(id){
				
	}
</script>
<div class="LabDetails_f">
	<form method="get" action="">
		<table width="700" border="0" cellspacing="0" cellpadding="0" style="margin-top:25px; table-layout:fixed">

			<tbody id="price-table">
				<tr>
					<td class="DDXAdsadmin_a">
						<a href="javascript:void(0)">价格</a>
					</td>
					<td class="DDXAdsadmin_b">
						<a href="javascript:void(0)">属性</a>
					</td>
					<td class="DDXAdsadmin_c">
						<a href="javascript:void(0)">组别</a>
					</td>
					<td class="Pricing"></td>
				</tr>
				<c:forEach items="${datas.price}" var="p">
					<tr class="LabDetails_f_h" name="Each-price" id="${p.id }" onmouseout="$(this).attr('style','background-color: #FBFBFB;')" onmouseover="$(this).attr('style','background-color: #ededed;')">
						<td name="price">
							${p.price }
						</td>
						<td>
							${p.attributes }
						</td>
						<td id="${p.priceGroupId }">
							${p.priceGroupName }
						</td>
						<td class="UserAccounts_a">
							<a href="javascript:void(0)" onclick="showAddPriceDialog('${p.id}')">修改</a><a href="javascript:void(0)" onclick="removeTr('${p.id}');">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="General_SchedulingHolidays_bottom">
			<a href="javascript:void(0)" onclick="showAddPriceDialog();"></a>
		</div>
	</form>
</div>
<c:choose>
	<c:when test="${datas.type=='add' and empty datas.price}">
		<div class="LabDetails_f_e LabDetails_f_e_center">
			<div class="LabDetails_f_e_left">
				<a href="javascript:void(0)"
					onclick="editPrice();">保存</a>
			</div>
			<div class="LabDetails_f_e_right">
				<!--小菜单下拉开始-->
				<ol class="menu_all">
					<li class="first">
						<a href="javascript:void(0)"></a>
						<ol class="menuu_s">
							<li>
								<ol class="menu_bgrightcenter">
									<li class="menu_bgrighttop">
										<img
											src="${pageContext.request.contextPath}/jsp/box/images/menu_bg077.jpg"
											width="160" height="4" />
									</li>
									<li class="menu_bgright">
										<a href="javascript:void(0)"
											onclick="editPrice('next');">保存并下一步</a>
									</li>
									<li class="menu_bgrightbottom">
										<img
											src="${pageContext.request.contextPath}/jsp/box/images/menu_bg07.jpg"
											width="160" height="4" />
									</li>
								</ol>
							</li>
						</ol>
					</li>
				</ol>
				<!--小菜单下拉结束-->
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="Addone">
			<a href="javascript:void(0)" onclick="editPrice()">提交</a>
		</div>
	</c:otherwise>
</c:choose>
<div id="add-pro-price-div" style="display: none;"></div>