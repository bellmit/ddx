<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="Cases_bottom_right_a">
	分配运送服务
</div>
<div class="Personalize">
	<div class="Personalize_a">
		运送类型
	</div>
	<div class="Personalize_b">
		<div class="Personalize_b_top"></div>
		<div class="Personalize_b_middle">
			<form method="get" action="">
				<ul>
					<li>
						<div class="Personalize_b_middle_left">
							<span>运送类型</span><span class="Personalize_b_middle_a">*</span>
						</div>
						<div class="Personalize_b_middle_right">
							<select id="practices-shipping-select" size="1" name="" onchange="changeShippingGroup();">
								<option value="">请选择一个组别</option>
								<c:forEach items="${sList}" var="g">
									<option value="${g.id }">${g.service }</option>
								</c:forEach>
							</select>
						</div>
					</li>
					<li id="no-select-shipping-error" style="display: none;">
						<div class="Personalize_b_middle_left">
							&nbsp;
						</div>
						<div class="Personalize_b_middle_right">
							<i class="Addonecuowu_b">必须选择一个运送服务去分配</i>
						</div>
					</li>
				</ul>
			</form>
		</div>
		<div class="Personalize_b_bottom"></div>
	</div>
	<div class="Personalize_a">
		机构
	</div>
	<div class="Personalize_b">
		<div class="Personalize_b_top"></div>
		<div class="Personalize_b_middle">
			<form method="get" action="">
				<ul>
					<li>
						<table id="assign-shipping-unit">
							<c:forEach items="${requestUnit}" var="unit">
								<tr id="${unit.id }" type=${unit.type }>
									<td width="200">${unit.name }</td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><input type="checkbox" id="${unit.id }-checkbox" value="${unit.shippingId }"/></td>
									<td>&nbsp;&nbsp;&nbsp;</td>
									<td width="100" id="${unit.id }-shippingName">(${unit.shippingName })</td>
								</tr>
							</c:forEach>
						</table>
					</li>
					<li>
						这将删除机构运输天进行重写。
					</li>
					<li>
						<div class="Personalize_b_middle_left">
							&nbsp;
						</div>
						<div class="Personalize_b_middle_right">
							<dl>
								<dt class="UserAccountsAdd">
									<a href="javascript:void(0)" onclick="saveChangeShippingGroup();">保存</a>
								</dt>
							</dl>
						</div>
					</li>
				</ul>
			</form>
		</div>
		<div class="Personalize_b_bottom"></div>
	</div>
</div>
