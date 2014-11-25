<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/u_lab/js/jquery.multiselect.js"></script>
<script type="text/javascript">
	$(function() {
		$("select[name='select-price-attr']").multiselect( {
			noneSelectedText : "请选择属性",
			selectedList : 1
		});
	});
</script>
<div class="Personalize" >

	<div class="Personalize_a">
	</div>
	<div class="Personalize_b">
		<div class="Personalize_b_top"></div>
		<div class="Personalize_b_middle">
			<form action="" method="get">
				<ul>
					<li>
						<div class="Personalize_b_middle_left">
							工序价格
						</div>
						<div class="General_middle_bottom_b_middle_right">
						<div class="DDXDentalPractice_Preferences">
							<div class="DDXDentalPractice_Preferences_left">
								<input name="" type="text" value="${price.price }"
									id="edit-price-price" />
									<input type="hidden" value="${price.id }"
									id="edit-price-id" />
							</div>
							<div class="DDXDentalPractice_Preferences_right">
								<div class="DDXDentalPractice_Preferences_right_top">
									<a href="javascript:void(0)"
										onclick="settingNumber('edit-price-price','plus')"><img
											src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg"
											onclick="settingNumber('edit-price-price','plus')" />
									</a>
								</div>
								<div class="DDXDentalPractice_Preferences_right_bottom">
									<a href="javascript:void(0)"
										onclick="settingNumber('edit-price-price','minus')"><img
											src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg"
											onclick="settingNumber('edit-price-price','minus')" />
									</a>
								</div>
							</div>
						</div>
					</div>
					</li>
					<li>
						<div class="Personalize_b_middle_left">
							<span>工序组别</span>
						</div>
						<div class="Personalize_b_middle_right">
							<select id="add-pro-price-group-id" onchange="newPriceGroup(this.value)">
								<option value=""></option>
								<option value="new">新建组别</option>
								<c:forEach items="${groupList}" var="g">
									<c:choose>
										<c:when test="${g.id==price.priceGroupId}">
											<option id="${g.id }" value="${g.id }" title="${g.name }" selected="selected">${g.name }</option>
										</c:when>
										<c:otherwise>
											<option id="${g.id }" value="${g.id }" title="${g.name }">${g.name }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</li>
					<li style="display: none;" id="edit-price-new-group-li">
						<div class="Personalize_b_middle_left">
							<span>新建组别</span>
						</div>
						<div class="Personalize_b_middle_right">
							<input type="text" class="Personalize_b_middle_b" value="" id="edit-price-new-group" />
						</div>
					</li>
				</ul>
			</form>
		</div>
		<div class="Personalize_b_bottom"></div>
	</div>
	<div class="Personalize_a">
		价格属性
	</div>
	<div class="Personalize_b">
		<div class="Personalize_b_top"></div>
		<div class="Personalize_b_middle">
			<form action="" method="get">
				<ul>
					<li>
						<div class="Personalize_b_middle_right">
							这里需要依赖工序属性，请先选择程序的属性
						</div>
					</li>
				</ul>
				<c:forEach items="${datas}" var="data">
					<ul>
						<li>
							<div class="Personalize_b_middle_left">
								<span id="${data.id }-label">${data.label }</span>
							</div>
							<div class="Personalize_b_middle_left">
								<select name="select-price-attr" id="${data.id }" multiple="multiple">
									${data.option }
								</select>
							</div>
						</li>
					</ul>
				</c:forEach>
			</form>
		</div>
		<div class="Personalize_b_bottom"></div>
	</div>
</div>