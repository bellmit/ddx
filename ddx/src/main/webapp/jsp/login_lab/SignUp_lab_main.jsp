<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
    <html xmlns="http://www.w3.org/1999/xhtml">
        <jsp:include page="../common.jsp" />
        
        <head>
            <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>
                	工厂实验室-注册
            </title>
            <link href="../common/css/commom.css" rel="stylesheet" type="text/css"
            />
            <link href="css/login_lab.css" rel="stylesheet" type="text/css" />
            <script type="text/javascript" src="js/lab-signUp.js">
            </script>
        </head>
        
        <body>
            <div class="page">
                <!--头部开始-->
                <jsp:include page="../head-signUp.jsp" />
                <!--头部结束-->
                <!--中间开始-->
                <div class="center">
                    <!--工厂实验室注册第二步开始-->
                    <div class="gcsyszcdeb">
                        <div class="gcsyszcdeb_left" style="margin-top: 20px;">
                            <div class="gcsyszcdeb_left_a">
                                	注册技工间账户
                            </div>
                            <div class="gcsyszcdeb_left_e" id="signUp-errors" style="display: none;">
                                	你提交的表单有错误，请查看一下明细
                            </div>
                            <div class="gcsyszcdeb_left_b" style="margin-top: 25px;display: none;">
                                	DDS技工间账号类型
                            </div>
                            <div class="gcsyszcdeb_left_c" style="display: none;">
                                <div class="gcsyszcdeb_left_c_top">
                                </div>
                                <div class="gcsyszcdeb_left_c_middle">
                                    <form action="" method="get">
                                        <ul>
                                            <li>
                                                	你如何使用DDS？你将使用:
                                            </li>
                                            <li>
                                                <span>
                                                    <img src="images/SignUp2_07.jpg" />
                                                </span>
                                                <span class="center_b_middle_right_h">
                                                    	具有DDS功能技工间管理软件
                                                </span>
                                                <span>
                                                    (如: ABS, inventrix, Labnet, Magic Touch DLCPM),
                                                </span>
                                                <span>
                                                    <a href="#">
                                                        <img src="images/SignUp_07.jpg" />
                                                    </a>
                                                </span>
                                            </li>
                                            <li>
                                                <span>
                                                    <img src="images/SignUp2_07.jpg" />
                                                </span>
                                                <span>
                                                    	或单独运行的
                                                </span>
                                                <span class="center_b_middle_right_h">
                                                    DDX订单管理软件？
                                                </span>
                                                <span>
                                                    <a href="#">
                                                        <img src="images/SignUp_07.jpg" />
                                                    </a>
                                                </span>
                                            </li>
                                            <li>
                                                <span class="center_b_middle_right_d">
                                                    Not sure?
                                                </span>
                                                <span class="center_b_middle_right_e">
                                                    <a href="#">
                                                       	 哪个版本最适合你的技工间.
                                                    </a>
                                                </span>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                      	 账号类型
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <select name="" size="1" id="signup-lab-account-type" disabled="disabled">
                                                        <option value="1">
                                                            ABS演化| DDS启动的ABS演化实验室管理软件
                                                        </option>
                                                        <option value="2">
                                                            inventrix Labtrac|启用DDS inventrix Labtrac实验室管理软件
                                                        </option>
                                                        <option value="3">
                                                            LABNET| DDX启用LABNET技工间管理软件
                                                        </option>
                                                        <option value="4">
                                                            	魔术触控软件（DLCPM）|牙科技工间客户结算和付款生产管理
                                                        </option>
                                                        <option value="5" selected="selected">
                                                            DDX个案经理进行实验室|单机和基于Web的DDX个案管理
                                                        </option>
                                                    </select>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-type-title">
                                                    <i class="center_e">
                                                        	请输入一个有效的邮箱地址
                                                    </i>
                                                </div>
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                                <div class="gcsyszcdeb_left_c_bottom">
                                </div>
                            </div>
                            <div class="gcsyszcdeb_left_b" style="margin-top: 20px;">
                               	 	账号信息
                            </div>
                            <div class="gcsyszcdeb_left_c">
                                <div class="gcsyszcdeb_left_c_top">
                                </div>
                                <div class="gcsyszcdeb_left_c_middle">
                                    <form action="" method="get">
                                        <ul>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                   	 昵称
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="gcsyszcdeb_left_c_middle_right_a" id="signup-lab-account-Salutation"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                       	 姓
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-account-FirstName"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-FirstName-title">
                                                    <i class="center_e">
                                                        	请输入你的姓氏
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	名
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-account-LastName"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-LastName-title">
                                                    <i class="center_e">
                                                        	请输入你的名字
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	邮箱
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-account-Email"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-Email-title">
                                                    <i class="center_e">
                                                        	请输入一个有效的邮箱地址
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	邮箱确认
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-account-ConfirmEmail"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-ConfirmEmail-title">
                                                    <i class="center_e">
                                                        	必须是相同的电子邮件
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                       	 密码
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="password" class="center_b_middle_right_a" id="signup-lab-account-Password"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-Password-title">
                                                    <i class="center_e">
                                                        	密码长度至少6位
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                       	 确认密码
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="password" class="center_b_middle_right_a" id="signup-lab-account-ConfirmPassword"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-ConfirmPassword-title">
                                                    <i class="center_e">
                                                       	 两次密码输入不一致
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                   新闻资讯
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="checkbox" value="" id="signup-lab-account-isDDXNewsletter" checked="checked"
                                                    />
                                                </div>
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                                <div class="gcsyszcdeb_left_c_bottom">
                                </div>
                            </div>
                            <div class="gcsyszcdeb_left_b">
                                	机构信息
                            </div>
                            <div class="gcsyszcdeb_left_c">
                                <div class="gcsyszcdeb_left_c_top">
                                </div>
                                <div class="gcsyszcdeb_left_c_middle">
                                    <form action="" method="get">
                                        <ul>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                       全称
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-name"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-name-title">
                                                    <i class="center_e">
                                                        	请输入您的技工间名称
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	地址
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-Address"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-Address-title">
                                                    <i class="center_e">
                                                        	请输入您的技工间地址
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	地址2
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-Address2"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	国家
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <select name="" size="1" id="signup-lab-Country">
                                                        <option value="中国">
                                                            	中国
                                                        </option>
                                                    </select>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	省份
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <select name="" size="1" id="signup-lab-State">
                                                       <jsp:include page="../state.jsp"></jsp:include>
                                                    </select>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	城市
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-City"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-City-title">
                                                    <i class="center_e">
                                                        	请输入您的技工间所在城市
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	邮编
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-PostalCode"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-PostalCode-title">
                                                    <i class="center_e">
                                                        	请输入您的技工间邮编
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                       		电话
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-Telephone"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-Telephone-title">
                                                    <i class="center_e">
                                                        	请输入您的技工间电话
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                   	 邮箱
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-Email"
                                                    />
                                                </div>
                                            </li>
                                            <!-- 
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                       	 时区
                                                    </span>
                                                    <span class="center_b_middle_left_a">
                                                        *
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <select name="" size="1" id="signup-lab-TimeZone">
                                                        <option value="1">
                                                            1
                                                        </option>
                                                        <option value="2">
                                                            2
                                                        </option>
                                                        <option value="3">
                                                            3
                                                        </option>
                                                        <option value="4">
                                                            4
                                                        </option>
                                                        <option value="5">
                                                            5
                                                        </option>
                                                    </select>
                                                </div>
                                            </li>
                                            
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    	子网域
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <span>
                                                        http://
                                                    </span>
                                                    <span>
                                                    </span>
                                                    <input name="" type="text" class="gcsyszcdeb_left_c_middle_right_b" id="signup-lab-Subdomain"
                                                    />
                                                    <span>
                                                        .ddxdemo.com
                                                    </span>
                                                </div>
                                            </li>
                                             -->
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    	服务
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <dl>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isFixedRestorations"
                                                                />
                                                            </span>
                                                            <span>
                                                             		  固定修复
                                                            </span>
                                                        </dt>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isRemovableRestorations"
                                                                />
                                                            </span>
                                                            <span>
                                                                	活动修复
                                                            </span>
                                                        </dt>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isDentalAppliancesOrthodontics"
                                                                />
                                                            </span>
                                                            <span>
                                                                	口腔正畸
                                                            </span>
                                                        </dt>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isImplantRestorations"
                                                                />
                                                            </span>
                                                            <span>
                                                                	种植修复
                                                            </span>
                                                        </dt>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isDentalWingsServices"
                                                                />
                                                            </span>
                                                            <span>
                                                                义齿设计
                                                            </span>
                                                        </dt>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isE4DServices"
                                                                />
                                                            </span>
                                                            <span>
                                                               模型打印
                                                            </span>
                                                        </dt>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isLavaCOSServices"
                                                                />
                                                            </span>
                                                            <span>
                                                               锆牙切削
                                                            </span>
                                                        </dt>
                                                        <dt>
                                                            <span>
                                                                <input name="" type="checkbox" value="" id="signup-lab-isZirluxFCServices"
                                                                />
                                                            </span>
                                                            <span>
                                                               代工服务
                                                            </span>
                                                        </dt>
                                                    </dl>
                                                </div>
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                                <div class="gcsyszcdeb_left_c_bottom">
                                </div>
                            </div>
                            <div class="gcsyszcdeb_left_b">
                                	
                            </div>
                            <div class="gcsyszcdeb_left_c">
                                <div class="gcsyszcdeb_left_c_top">
                                </div>
                                <div class="gcsyszcdeb_left_c_middle">
                                    <form action="" method="get">
                                        <ul>
                                           <!--  <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    	认证培训
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <span>
                                                        <input name="" type="checkbox" value="" id="signup-lab-account-isCertifiedTraining"
                                                        />
                                                    </span>
                                                    <span>
                                                       	 联系我参加DDX认证培训
                                                    </span>
                                                </div>
                                            </li> -->
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                    <span>
                                                        	我同意
                                                    </span>
                                                    <span class="center_b_middle_right_e">
                                                        <a href="javascript:void(0)" onclick="showLabServiceAgree();">
                                                            
                                                        </a>
                                                     
                                                        <a href="javascript:void(0)" onclick="showLabSignupTerms();">
                                                            	使用条款
                                                        </a>
                                                    </span>
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <span>
                                                        <input name="" type="checkbox" value="" id="signup-lab-account-isAgree"
                                                        />
                                                    </span>
                                                </div>
                                            </li>
                                            <!-- <li>
                                            <div class="gcsyszcdeb_left_c_middle_left"><span class="center_b_middle_right_e"><a href="#">条款</a></span><span>＆</span><span class="center_b_middle_right_e"><a href="#">使用条款</a></span></div>
                                            <div class="gcsyszcdeb_left_c_middle_right"></div>
                                            </li>
                                            -->
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-isAgree-title">
                                                    <i class="center_e">
                                                        	你必须同意许可，服务条款，使用条款
                                                    </i>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                   	 验证码
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <a href="javascript:void(0)">
                                                        <img src="${pageContext.request.contextPath}/kaptchaAction/getVerify.do" onclick="updateImg(this);"/>
                                                    </a>不区分大小写、点击图片刷新验证码
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right">
                                                    <input name="" type="text" class="center_b_middle_right_a" id="signup-lab-account-VerificationCode"
                                                    />
                                                </div>
                                            </li>
                                            <li>
                                                <div class="gcsyszcdeb_left_c_middle_left">
                                                </div>
                                                <div class="gcsyszcdeb_left_c_middle_right" style="display: none;" id="signup-lab-account-VerificationCode-title">
                                                    <i class="center_e" id="signup-lab-account-VerificationCode-title-msg">
                                                        	请输入以上图片的验证码
                                                    </i>
                                                </div>
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                                <div class="gcsyszcdeb_left_c_bottom">
                                </div>
                            </div>
                            <div class="gcsyszcdeb_left_d">
                                <a href="javascript:void(0)" onclick="signupLabAccount();">
                                    &nbsp;&nbsp;&nbsp;注册
                                </a>
                            </div>
                        </div>
                        <div class="gcsyszcdeb_right">
                        </div>
                    </div>
                    <div>
                        <form action="${pageContext.request.contextPath}/sigup_login" id="sigupLoginForm"
                        name="sigupLoginForm" method="post">
                            <input type="hidden" id="sigupLoginForm-username" name="j_username" />
                            <input type="hidden" id="sigupLoginForm-password" name="j_password" />
                        </form>
                    </div>
                    <!--工厂实验室注册第二步结束-->
                </div>
                <!--中间结束-->
                <!--底部开始-->
                <jsp:include page="../bottom.jsp" />
                <!--底部结束-->
            </div>
        </body>
    
    </html>