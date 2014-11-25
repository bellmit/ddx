<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <div class="box_editcontentleft" id="add-cases-procedures-left">
 	<c:forEach items="${left}" var="ll">
     	<p>
		         <span class="biaoti_add01">
		             <c:choose>
						<c:when test="${ll.need=='REQUIRED'}">
							<span class="biaocolor">*</span>
						</c:when>
						<c:otherwise>
							<span class="biaocolor">&nbsp;</span>
						</c:otherwise>
					</c:choose>
		             ${ll.label }
		         </span>
	         	${ll.option }${ll.input }
	         	<c:if test="${ll.id=='getTeeth_presence' or ll.id=='getShade_presence' or ll.id=='getStump_shade_presence'}">
		         	<img width="38" height="26" onclick="showTeethDialog(this);" onmouseout="this.src='${pageContext.request.contextPath}/jsp/box/images/box_tooth.jpg'"
		         		onmouseover="this.src='${pageContext.request.contextPath}/jsp/box/images/box_tooth01.jpg'"
		         				src="${pageContext.request.contextPath}/jsp/box/images/box_tooth.jpg">
	         	</c:if>
	     </p>
     </c:forEach>
 </div>
 <div class="box_editcontentright" id="add-cases-procedures-right">
 	<c:forEach items="${right}" var="rr">
	     <p class="box_editcontentrightp">
	         <span class="biaoti_add02">
		              <c:choose>
						<c:when test="${rr.need=='REQUIRED'}">
							<span class="biaocolor">*</span>
						</c:when>
						<c:otherwise>
							<span class="biaocolor">&nbsp;</span>
						</c:otherwise>
					</c:choose>
		             ${rr.label }
	         </span>
	         ${rr.option }${rr.input }
	         <c:if test="${rr.id=='getTeeth_presence' or rr.id=='getShade_presence' or rr.id=='getStump_shade_presence'}">
		         	<img width="38" height="26" onclick="showTeethDialog(this);" onmouseout="this.src='${pageContext.request.contextPath}/jsp/box/images/box_tooth.jpg'"
		         		onmouseover="this.src='${pageContext.request.contextPath}/jsp/box/images/box_tooth01.jpg'"
		         				src="${pageContext.request.contextPath}/jsp/box/images/box_tooth.jpg">
		     </c:if>
	     </p>
     </c:forEach>
 </div>

