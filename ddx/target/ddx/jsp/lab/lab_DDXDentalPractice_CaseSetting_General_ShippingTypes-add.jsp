<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
	<div class="Personalize">
		<div class="Personalize_a">
		</div>
		<div class="Personalize_b">
			<div class="Personalize_b_top"></div>
			<div class="Personalize_b_middle">
				<form method="get" action="">
					<ul>
						<li>
							<div class="Personalize_b_middle_left">
								<span>服务类型</span><span class="Personalize_b_middle_a">*</span>
							</div>
							<div class="Personalize_b_middle_right">
								<input type="text" class="Personalize_b_middle_b" name="" id="add-shipping-service">
								<input type="hidden" id="add-shipping-id" value=""/>
							</div>
						</li>
						<li style="display: none;" id="add-shipping-service-message">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">必须输入服务名称</i></div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>物流公司</span><span class="Personalize_b_middle_a">*</span>
							</div>
							<div class="Personalize_b_middle_right">
								<select size="1" name="" id="add-shipping-company">
									<option value="">
										请选择公司
									</option>
									<option value="邮政">
										邮政
									</option>
									<option value="顺丰">
										顺丰
									</option>
									<option value="韵达">
										韵达
									</option>
									<option value="圆通">
										圆通
									</option>
									<option value="申通">
										申通
									</option>
								</select>
							</div>
						</li>
						<li style="display: none;" id="add-shipping-company-message">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">必须选择运送公司</i></div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>寄来在途时间</span><span
									class="Personalize_b_middle_a">*</span>
							</div>
							<div class="Personalize_b_middle_right">
								<div class="Scan_b_middle_right_left_b_top">
									<div class="Scan_b_middle_right_left_b_top_left">
										<input type="text" name="" id="add-shipping-in-days">
									</div>
									<div class="Scan_b_middle_right_left_b_top_right">
										<div class="Scan_b_middle_right_left_b_top_right_top">
											<a href="javascript:void(0)" onclick="settingNumber('add-shipping-in-days','plus')"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg">
											</a>
										</div>
										<div class="Scan_b_middle_right_left_b_top_right_bottom">
											<a href="javascript:void(0)" onclick="settingNumber('add-shipping-in-days','minus')"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg">
											</a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li style="display: none;" id="add-shipping-in-days-message">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入入境运输天</i></div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								<span>寄回在途时间</span><span
									class="Personalize_b_middle_a">*</span>
							</div>
							<div class="Personalize_b_middle_right">
								<div class="Scan_b_middle_right_left_b_top">
									<div class="Scan_b_middle_right_left_b_top_left">
										<input type="text" name="" id="add-shipping-out-days">
									</div>
									<div class="Scan_b_middle_right_left_b_top_right">
										<div class="Scan_b_middle_right_left_b_top_right_top">
											<a href="javascript:void(0)" onclick="settingNumber('add-shipping-out-days','plus')"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/Scan_03.jpg">
											</a>
										</div>
										<div class="Scan_b_middle_right_left_b_top_right_bottom">
											<a href="javascript:void(0)" onclick="settingNumber('add-shipping-out-days','minus')"><img src="${pageContext.request.contextPath}/jsp/u_lab/images/scan_06.jpg">
											</a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li style="display: none;" id="add-shipping-out-days-message">
							<div class="Personalize_b_middle_left">&nbsp;</div>
							<div class="Personalize_b_middle_right"><i class="Addonecuowu_b">请输入出境运输天</i></div>
						</li>
						<li>
							<div class="Personalize_b_middle_left">
								&nbsp;
							</div>
							<div class="Personalize_b_middle_right">
								<dl>
									<dt class="UserAccountsAdd">
										<a href="javascript:void(0)" onclick="addOrUpdateShippingType();">保存</a>
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

