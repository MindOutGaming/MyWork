<%-- 
    Document   : studentajax
    Created on : 16-Jun-2023, 12:10:49 PM
    Author     : sohel1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${process eq 'viewstudents' or process eq 'editstudents' or process eq 'deletestudents'}">
    <table class="table">
        <thead>
        <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>State</th>
        <th>City</th>
        </tr>
        </thead>
        <tbody>
    <%
        ResultSet rs = (ResultSet)request.getAttribute("result");
        while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("address")%></td>
        <td><%=rs.getString("email")%></td>
        <td><%=rs.getString("state")%></td>
        <td><%=rs.getString("city")%></td>
        <c:if test="${process eq 'editstudents'}">
            <td><input type="button" class="btn-warning" value="EDIT"/></td>
        </c:if>
        <c:if test="${process eq 'deletestudents'}">
            <td><input type="button" class="btn-danger" value="DELETE"/></td>
        </c:if>
    </tr>
    <%
        }
    %>
    </tbody>
    </table>
</c:if>
<c:if test="${process eq 'addstudents'}">
    <div class="mx-auto" style="width:75%">
        <h2>Add Students Form</h2>
        <form id="studentform">
            <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name">
          </div>
            <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name="address">
          </div>
          <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" id="email" name="email">
          </div>
            <div class="form-group">
            <label for="state">State:</label>
            <input type="text" class="form-control" id="state" name="state">
          </div>
            <div class="form-group">
            <label for="city">City:</label>
            <input type="text" class="form-control" id="city" name="city">
          </div>
          <button class="btn btn-primary" onclick="return ValidateStudentForm()">Add Students</button>
          <button type="reset" class="btn btn-warning">RESET</button>
        </form>
    </div>
    <div id="processAjax">
        
    </div>
</c:if>

