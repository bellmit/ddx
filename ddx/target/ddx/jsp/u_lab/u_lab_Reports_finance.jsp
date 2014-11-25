<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>
            	订单财务报表
        </title>
        <style>
            body{ font-size:12px;} li,ul,table,tr,td{ margin:0; padding:0} .box_clear{
            clear:both} .financial_all{ text-align:center;} .financial_left{ float:left;
            width:100px; height:auto; min-height:40px; line-height:40px} .financial_right{
            float:left; width:735px} .financial_right01{ float:right; width:75px; height:auto;
            min-height:40px; line-height:40px} .financial_content{ width:928px; font-size:12px;}
            .financial_contenttop01{ font-size:14px; font-weight:bold; text-align:center;
            line-height:40px} .financial_contenttop02{ width:750px; margin:0 auto}
            .financial_content table{ border-collapse: collapse; border-spacing: 0;
            font-size:12px; text-align:center} .financial_contenttop02 tr{ height:30px;
            line-height:30px;} .financial_contenttop03{ border:1px solid #e1e1e1;}
            .financialtr_detail01 td{ border:1px solid #e1e1e1; border-top:none;} .financial_contentcenter{
            margin-top:20px;} .financial_contentcenter table{ border:1px solid #e1e1e1;
            border-top:none} .financialtr{ height:45px; line-height:45px; background:#dbecf6;
            font-size:14px; font-weight:bold; border:1px solid #e1e1e1; text-align:center;}
            .financialtr_detail01{ height:40px; min-height:40px; line-height:22px;}
            .financialtd{ line-height:22px;} .financial_contentbottom{ text-align:right;}
            .financial_contentbottom li{ display:inline; width:50px; height:40px; line-height:40px;
            overflow:hidden} .financial_contentbottom li a{ color:#1870b0; text-decoration:none}
            .financial_contentbottom li a:hover{ color:#0cf}
            
            #fullbg{background-color: Gray;display:none;z-index:3;position:absolute;left:0px;top:0px;filter:Alpha(Opacity=30);/* IE */-moz-opacity:0.4;/* Moz + FF */opacity: 0.4;}  
            #dialog {position:absolute;width:200px;height:30px;background:#7CADCE;display: none;z-index: 5;}  
            #main {  
                height: 1500px;  
            }  
        </style>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.0.min.js"></script>
        <script type="text/javascript">
        	function showProDet(id){
				var flag = $("#"+id).attr("flag");
				if("hide"==flag){
					$("#"+id).attr("flag","show");
					$("#report-a-onclik-"+id).html("[-]");
					$("#"+id).show(500);
				}else{
					$("#"+id).attr("flag","hide");
					$("#report-a-onclik-"+id).html("[+]");
					$("#"+id).hide(500);
				}
            }
            function showAlltr(){
				var flag = $("#report-a-onclik-all").attr("flag");
				$("tr[name='pro-det-tr']").each(function (i){
					if("hide"==flag){
						$(this).show();
					}else{
						$(this).hide();
					}
				});
				$("a[name='pro-det-a']").each(function (i){
					if("hide"==flag){
						$(this).html("[-]");
					}else{
						$(this).html("[+]");
					}
				});
				
				if("hide"==flag){
					$("#report-a-onclik-all").html("[-]");
					$("#report-a-onclik-all").attr("flag","show");
				}else{
					$("#report-a-onclik-all").html("[+]");
					$("#report-a-onclik-all").attr("flag","hide");
				}
            }

            //显示灰色JS遮罩层  
            function showBg(ct,content){  
                var bH=$("body").height();  
                var bW=$("body").width()+16;  
                var objWH=getObjWh(ct);  
                $("#fullbg").css({width:bW,height:bH,display:"block"});  
                var tbT=objWH.split("|")[0]+"px";  
                var tbL=objWH.split("|")[1]+"px";  
                $("#"+ct).css({top:tbT,left:tbL,display:"block"});  
                $("#"+content).html("<div style='text-align:center'>正在加载，请稍后...</div>");  
                $(window).scroll(function(){resetBg()});  
                $(window).resize(function(){resetBg()});  
            }  
            function getObjWh(obj){  
                var st=document.documentElement.scrollTop;//滚动条距顶部的距离  
                var sl=document.documentElement.scrollLeft;//滚动条距左边的距离  
                var ch=document.documentElement.clientHeight;//屏幕的高度  
                var cw=document.documentElement.clientWidth;//屏幕的宽度  
                var objH=$("#"+obj).height();//浮动对象的高度  
                var objW=$("#"+obj).width();//浮动对象的宽度  
                var objT=Number(st)+(Number(ch)-Number(objH))/2;  
                var objL=Number(sl)+(Number(cw)-Number(objW))/2;  
                return objT+"|"+objL;  
            }  
            function resetBg(){  
                var fullbg=$("#fullbg").css("display");  
                if(fullbg=="block"){  
                    var bH2=$("body").height();  
                    var bW2=$("body").width()+16;  
                    $("#fullbg").css({width:bW2,height:bH2});  
                    var objV=getObjWh("dialog");  
                    var tbT=objV.split("|")[0]+"px";  
                    var tbL=objV.split("|")[1]+"px";  
                    $("#dialog").css({top:tbT,left:tbL});  
                }  
            }  
 
            //关闭灰色JS遮罩层和操作窗口  
            function closeBg(){  
                $("#fullbg").css("display","none");  
                $("#dialog").css("display","none");  
            }  
        </script>
    </head>
    
    <body>
    	 <!-- JS遮罩层 --> 
        <div id="fullbg"></div> 
        <!-- end JS遮罩层 --> 
         <!-- 对话框 --> 
        <div id="dialog"> 
            <div id="dialog_content"></div> 
            
            <div style="text-align: center;">
            	<a href="javascript:void(0)" onclick="closeBg();">关闭</a> 
            </div> 
            
        </div> 
        <!-- JS遮罩层上方的对话框 --> 
        <div class="financial_content" align="center">
            <div class="financial_contenttop">
                <div class="financial_contenttop01">
                    ${datas.unitName }的订单财务报表
                </div>
                <div class="financial_contenttop02">
                    <table>
                        <tr>
                            <td width="150" class="financial_contenttop03">
                                	起止日期：
                            </td>
                            <td width="300" class="financial_contenttop03">
                                ${datas.beginTime }&nbsp;至&nbsp;${datas.endTime }
                            </td>
                            <td width="150" class="financial_contenttop03">
                                	查询日期：
                            </td>
                            <td width="150" class="financial_contenttop03">
                                ${datas.queryTime }
                            </td>
                        </tr>
                        <tr>
                            <td class="financial_contenttop03">
                                	费用合计：
                            </td>
                            <td class="financial_contenttop03">
                                	￥${datas.totalFee }
                            </td>
                            <td colspan="2" class="financial_contenttop03">
                                &nbsp;
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            
            <div class="financial_contentbottom" style="margin-top: 20px;">
                <ul>
                    <li>
                        	第${datas.resultPM.offset }页
                    </li>
                    <li>
                        	共${datas.resultPM.totalPage }页
                    </li>
                    <li>
                        <a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=1">
                            	首页
                        </a>
                    </li>
                    <li>
                    	<c:choose>
                    		<c:when test="${datas.resultPM.offset > 1 }">
                    			<a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=${datas.resultPM.offset - 1 }">
                            		上一页
                        		</a>
                    		</c:when>
                    		<c:otherwise>
                    			上一页
                    		</c:otherwise>
                    	</c:choose>
                    </li>
                    <li>
                    	<c:choose>
                    		<c:when test="${datas.resultPM.offset < datas.resultPM.totalPage }">
                    			<a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=${datas.resultPM.offset + 1 }">
                            		下一页
                       			</a>
                    		</c:when>
                    		<c:otherwise>
                   			 	下一页
                    		</c:otherwise>
                    	</c:choose>
                    </li>
                    <li>
                        <a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=${datas.resultPM.totalPage }">
                            	尾页
                        </a>
                    </li>
                </ul>
            </div>
            
            <div class="financial_contentcenter"  style="margin-top: 5px;">
                <table width="920">
                    <tr class="financialtr">
                        <td width="100">
                            	机构名称
                        </td>
                        <td width="65">
                            	订单号
                        </td>
                        <td width="140">
                            	下单日期
                        </td>
                        <td width="240">
                            	工序描述
                        </td>
                        <!-- 
                        <td width="70">
                            	牙齿数量
                        </td>
                         -->
                        <td width="90">
                            	金额
                        </td>
                        <td width="50">
                            	折扣
                        </td>
                        <td width="80">
                            	备注
                        </td>
                        <td width="80">
                            	金额小计
                        </td>
                    </tr>
                </table>
                <c:forEach items="${datas.resultPM.datas}" var="lab" varStatus="labindex">
	                <!--整个技工间复制开始-->
	                <table width="920" class="financial_all">
	                    <tr>
	                        <td>
	                            <div class="financial_left">
	                                ${lab.name }
	                            </div>
	                            <div class="financial_right">
	                                <table width="735">
	                                	<c:forEach items="${lab.data}" var="cases" varStatus="casesindex">
		                                 	<!--单行复制开始-->
		                                    <tr class="financialtr_detail01">
		                                        <td width="65">
		                                            ${cases.caseId }
		                                        </td>
		                                        <td width="140">
		                                            ${cases.createDate }
		                                        </td>
		                                        <td width="240" class="financialtd">
		                                            <div style="width: 100%">
		                                            	<table style="width: 100%">
		                                            		<c:if test="${labindex.index==0 and casesindex.index==0}">
		                                            			<tr  style="width: 100%;background-color: #F0F0F0;">
		                                            				<td  style="width: 10%">数量</td>
		                                            				<td  style="width: 90%">工序
		                                            					<a href="javascript:void(0)" style="text-decoration: none" id="report-a-onclik-all" flag="hide" onclick="showAlltr();">[+]</a>
		                                            				</td>
		                                            			</tr>
		                                            		</c:if>
		                                            		<c:forEach items="${cases.proceduresDetailed }" var="det" varStatus="i">
		                                            			<tr style="width: 100%;">
		                                            				<td style="width: 10%"></td>
		                                            				<td style="width: 90%"></td>
		                                            			</tr>
		                                            			<tr style="width: 100%;">
			                                            			<td style="width: 10%"><a href="javascript:void(0)" style="text-decoration: none" title="${det.ps }">${det.count }</a></td>
			                                            			<td style="width: 90%">
			                                            				${det.procedure_name }
			                                            				<a href="javascript:void(0)" name="pro-det-a" style="text-decoration: none" id="report-a-onclik-${cases.caseId }-${det.id}-${i.index }" onclick="showProDet('${cases.caseId }-${det.id}-${i.index }')">[+]</a>
			                                            			</td>
		                                            			</tr>
		                                            			<tr style="display: none;" id="${cases.caseId }-${det.id}-${i.index }" name="pro-det-tr" flag="hide">
		                                            				<td></td>
		                                            				<td>
		                                            					<div style="width: 100%">
		                                            						<table style="text-align: left;" style="width: 100%">
		                                            							<c:forEach items="${det.attrList}" var="attr">
		                                            								<tr>
		                                            									<td>${attr.lable }</td>
		                                            									<td>${attr.valueDes }</td>
		                                            								</tr>
		                                            							</c:forEach>
		                                            						</table>
		                                            					</div>
		                                            				</td>
		                                            			</tr>
		                                            		</c:forEach>
		                                            	</table>
		                                            </div>
		                                        </td>
		                                        <!--  
		                                        <td width="70">
		                                            
		                                        </td>
		                                         -->
		                                        <td width="90">
		                                            ${cases.finishPrice }
		                                        </td>
		                                        <td width="50">
		                                            ${cases.discount }
		                                            <c:if test="${!empty cases.discount and cases.discount>0}">
		                                            	<c:if test="${cases.discountType eq 'P'}">
		                                            		%
		                                            	</c:if>
		                                            	<c:if test="${cases.discountType eq 'F'}">
		                                            		￥
		                                            	</c:if>
		                                            </c:if>
		                                        </td>
		                                        <td width="80">
		                                             ${cases.remarks }
		                                        </td>
		                                   	</tr>
		                                    <!--单行复制结束-->
	                                    </c:forEach>
	                                </table>
	                            </div>
	                            <div class="financial_right01">
	                                	￥ ${lab.totalPrice }
	                            </div>
	                        </td>
	                    </tr>
	                </table>
                <!--整个技工间复制结束-->
                </c:forEach>
            </div>
            <div class="box_clear"></div>
            <div class="financial_contentbottom">
                <ul>
                    <li>
                        	第${datas.resultPM.offset }页
                    </li>
                    <li>
                        	共${datas.resultPM.totalPage }页
                    </li>
                    <li>
                        <a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=1">
                            	首页
                        </a>
                    </li>
                    <li>
                    	<c:choose>
                    		<c:when test="${datas.resultPM.offset > 1 }">
                    			<a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=${datas.resultPM.offset - 1 }">
                            		上一页
                        		</a>
                    		</c:when>
                    		<c:otherwise>
                    			上一页
                    		</c:otherwise>
                    	</c:choose>
                    </li>
                    <li>
                    	<c:choose>
                    		<c:when test="${datas.resultPM.offset < datas.resultPM.totalPage }">
                    			<a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=${datas.resultPM.offset + 1 }">
                            		下一页
                       			</a>
                    		</c:when>
                    		<c:otherwise>
                   			 	下一页
                    		</c:otherwise>
                    	</c:choose>
                    </li>
                    <li>
                        <a onclick="showBg('dialog','dialog_content');" href="${pageContext.request.contextPath}/labAction/financeResults.do?beginTime=${datas.beginTime }&endTime=${datas.endTime }&type=${datas.type }&pageNo=${datas.resultPM.totalPage }">
                            	尾页
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </body>

</html>