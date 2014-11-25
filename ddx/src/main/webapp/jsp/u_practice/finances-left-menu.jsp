<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePayment&id=${requestAccountLab.id}">
            	账户支付
        </a>
    </li>
    <li class="secs"><a href="#">账户档案</a></li>
    <li>
        <a href="${pageContext.request.contextPath}/practiceAction/practice.do?portal=financePricerList&id=${requestAccountLab.id}">
            	价格列表
        </a>
    </li>
    
</ul>
