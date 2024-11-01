<%-- 
    Document   : jstlexample
    Created on : 14-Jun-2023, 11:56:33 AM
    Author     : sohel1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Example</title>
    </head>
    <body>
        <!--
        <c:set var="name" value="Hi, Yagnik"/>
        <%--
            String name = "Hi, Yagnik";
        --%>
        <h1>${name}</h1>
        <%--
            out.println("<h1>"+name+"</h1>");
        --%>
        <h2>${2 + 2}</h2>
        <h3>${"hello" == "hello"}</h3>
        
        <c:set var="process" value="add"/>
        
        <c:if test="${process eq 'add'}">
            <h1>I am add function.</h1>
        </c:if>
        <c:if test="${process eq 'delete'}">
            <h1>I am delete function.</h1>
        </c:if>
        
        <c:set var="process" value="ali"/>
        <c:choose>
            <c:when test="${process eq 'add'}">
                <h1>I am an add function from choose.</h1>
            </c:when>

            <c:when test="${process eq 'delete'}">
                <h1>I am an delete function from choose.</h1>
            </c:when>

            <c:otherwise>
                <h1>I am an otherwise function from choose.</h1>
            </c:otherwise>
        </c:choose>
        
        
        <c:forEach begin="1" end="10" step="1" var="i">
            <h1>the value is ${i}</h1>
        </c:forEach>
        -->
        
        <%-- out.print("Hello, Jugal!"); --%>
        <c:out value="Hello, Jugal!"/>
    </body>
</html>
