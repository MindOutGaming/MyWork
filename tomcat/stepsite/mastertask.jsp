<%-- 
    Document   : mastertask
    Created on : 17-Jun-2023, 1:24:51 PM
    Author     : sohel1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${process eq 'insertStudents'}">
    <input type="hidden" value="${status}" id="status"/>
</c:if>