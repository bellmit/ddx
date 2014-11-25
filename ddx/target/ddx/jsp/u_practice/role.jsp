<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select  id="user_type" title="用户角色">
    <option value="" label=""></option>
    <option value="PRACTICE_PROVIDER" <c:if test="${MyUser.role == 'PRACTICE_PROVIDER' }">selected="selected"</c:if> label="">临床医生</option>
    <option value="PRACTICE_STUDENT_PROVIDER" <c:if test="${MyUser.role == 'PRACTICE_STUDENT_PROVIDER' }">selected="selected"</c:if>  label="">齿科学生</option>
    <option value="PRACTICE_FACULTY_PROVIDER" <c:if test="${MyUser.role == 'PRACTICE_FACULTY_PROVIDER' }">selected="selected"</c:if>  label="">齿科教员</option>
    <option value="PRACTICE_DENTAL_HYGIENIST" <c:if test="${MyUser.role == 'PRACTICE_DENTAL_HYGIENIST' }">selected="selected"</c:if>  label="">齿科保健师</option>
    <option value="PRACTICE_DENTAL_ASSISTANT" <c:if test="${MyUser.role == 'PRACTICE_DENTAL_ASSISTANT' }">selected="selected"</c:if>  label="">医生助理</option>
    <option value="PRACTICE_CLINIC_DIRECTOR" <c:if test="${MyUser.role == 'PRACTICE_CLINIC_DIRECTOR' }">selected="selected"</c:if>  label="">临床主任</option>
    <option value="PRACTICE_OFFICE_MANAGER" <c:if test="${MyUser.role == 'PRACTICE_OFFICE_MANAGER' }">selected="selected"</c:if>  label="">办公室管理员</option>
    <option value="PRACTICE_FRONT_DESK" <c:if test="${MyUser.role == 'PRACTICE_FRONT_DESK' }">selected="selected"</c:if>  label="">前台服务</option>
    <option value="PRACTICE_BOOKKEEPER" <c:if test="${MyUser.role == 'PRACTICE_BOOKKEEPER' }">selected="selected"</c:if>  label="">财务人员</option>
    <option value="PRACTICE_LAB_TECHNICIAN" <c:if test="${MyUser.role == 'PRACTICE_LAB_TECHNICIAN' }">selected="selected"</c:if>  label="">技工</option>
    <option value="ADMINISTRATOR" <c:if test="${MyUser.role == 'ADMINISTRATOR' }">selected="selected"</c:if>  label="">管理员</option>
</select>
