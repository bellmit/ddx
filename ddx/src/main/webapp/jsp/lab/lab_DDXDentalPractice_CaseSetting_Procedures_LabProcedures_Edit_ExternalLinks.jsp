<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/lab/js/menu-dropdown.js"></script>
<div class="General_middle_bottom_a">
	外包工序的链接
</div>
<div class="General_middle_bottom_b">
	<div class="General_middle_bottom_b_top"></div>
	<div class="General_middle_bottom_b_middle">
		<form method="get" action="">
			<ul>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						外包机构
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="" id="out-link-plab" onchange="onchangePlab(this.value);">
							<option value=""></option>
							<c:forEach items="${datas.listLab}" var="plab">
								<c:choose>
									<c:when test="${datas.link.outPartnerLabId==plab.id}">
										<option value="${plab.id }" selected="selected">
											${plab.name }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${plab.id }">
											${plab.name }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						外包工序
					</div>
					<div class="General_middle_bottom_b_middle_right" id="out-link-pro-select-div">
						<jsp:include page="out-link-pro-select.jsp"></jsp:include>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						自动匹配
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<c:choose>
							<c:when test="${datas.link.autoRoute=='checked'}">
								<input type="checkbox" checked="checked" id="out-link-Auto-Route"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="out-link-Auto-Route"/>
							</c:otherwise>
						</c:choose>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<div class="General_middle_bottom_b_bottom"></div>
</div>
<div class="General_middle_bottom_a">
	西诺德
</div>
<div class="General_middle_bottom_b">
	<div class="General_middle_bottom_b_top"></div>
	<div class="General_middle_bottom_b_middle">
		<form method="get" action="">
			<ul>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						修复类型
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name="" id="out-link-Sirona-Connect-Type">
							<option value=""></option>
							<c:forEach items="${datas.sironaConnectType}" var="type">
								<c:choose>
									<c:when test="${datas.link.type==type.key}">
										<option value="${type.key }" selected="selected">
											${type.value }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${type.key }">
											${type.value }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						设计
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name=""  id="out-link-Sirona-Connect-Design">
							<option value=""></option>
							<c:forEach items="${datas.sironaConnectDesign}" var="design">
								<c:choose>
									<c:when test="${datas.link.design==design.key}">
										<option value="${design.key }" selected="selected">
											${design.value }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${design.key }">
											${design.value }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>
				<li>
					<div class="General_middle_bottom_b_middle_left">
						材料
					</div>
					<div class="General_middle_bottom_b_middle_right">
						<select size="1" name=""  id="out-link-Sirona-Connect-Material">
							<option value=""></option>
							<c:forEach items="${datas.sironaConnectMaterial}" var="material">
								<c:choose>
									<c:when test="${datas.link.material==material.key}">
										<option value="${material.key }" selected="selected">
											${material.value }
										</option>
									</c:when>
									<c:otherwise>
										<option value="${material.key }">
											${material.value }
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<div class="General_middle_bottom_b_bottom"></div>
</div>
<c:choose>
	<c:when test="${datas.type=='add' and empty datas.link.id}">
		<div class="LabDetails_f_e LabDetails_f_e_center">
			<div class="LabDetails_f_e_left">
				<a href="javascript:void(0)"
					onclick="editOutLink('','');">保存</a>
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
											onclick="editOutLink('','next');">保存并下一步</a>
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
			<a href="javascript:void(0)" onclick="editOutLink('${datas.link.id}','')">提交</a>
		</div>
	</c:otherwise>
</c:choose>