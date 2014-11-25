<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<li class="Partner_Labs_a" style="display: none;" id="Search-PartnerLabs-div">
<form action="" method="get">
<span class="Partner_Labs_b">搜索</span>
<span>
<select name="country" id="Search-PartnerLabs-Country" title="Country" aria-disabled="false" class="Partner_Labs_c">
    <option value="CN" label="">中国</option>
</select>
</span>
<span class="Partner_Labs_b">通过</span>
<span>

<select name="by" id="Search-PartnerLabs-by" aria-disabled="false" class="Partner_Labs_d">
    <option value="name"  selected="selected" id="Search-PartnerLabs-labName">技工间名称</option>
    <option value="state" id="Search-PartnerLabs-state">省份</option>
    <option value="zip" id="Search-PartnerLabs-zip">邮编</option>
</select>
</span>
<span><input name="" type="text" class="Partner_Labs_e" id="Search-PartnerLabs-value"/></span>
<span class="Partner_Labs_f"><a href="javascript:void(0)" onclick="searchLabs('<%=request.getParameter("unit") %>');"></a></span>
<span class="PartnerLabsadminsousuo" id="hideSearch-span"><a href="javascript:void(0)" onclick="hideSearch();"></a></span>
</form>
</li>
<li id="PartnerLabsadmin_g"></li>
<div style="display: none;" id="Search-PartnerLabs-result-div"></div>
