<%-- 
    Document   : students
    Created on : 09-Jun-2023, 12:04:37 PM
    Author     : sohel1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
<%
    String str = (String)request.getAttribute("process");
    if (str.equals("load")) {
%>
<ul class="nav nav-pills">
  <li class="active"><a href="#">Add Students</a></li>
  <li><a href="#">Edit Students</a></li>
  <li><a href="#">Delete Students</a></li>
  <li><a href="#">View Students</a></li>
</ul>
<% } %>
<%
    if (str.equals("add")) {
%>
<div>Coming Soon!</div>
<% } %>
--%>

<c:if test="${process eq 'add'}">
    <div>Coming Soon!</div>
</c:if>
<c:if test="${process eq 'load'}">
    <ul class="nav nav-pills">
        <li class="active" onclick="AddStudentsLoader()"><a href="#">Add Students</a></li>
        <li><a href="#" onclick="ViewStudentsLoader('editstudents')">Edit Students</a></li>
        <li><a href="#" onclick="ViewStudentsLoader('deletestudents')">Delete Students</a></li>
        <li><a href="#" onclick="ViewStudentsLoader('viewstudents')">View Students</a></li>
    </ul>
    <div id="studentload" class="container-fluid p-5">

    </div>

</c:if>
