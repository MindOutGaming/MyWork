<%-- 
    Document   : sessionexample
    Created on : 08-Jun-2023, 11:53:19 AM
    Author     : sohel1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session Example Page</title>
    </head>
    <body>
        <!-- implicit object -->
        <%-- jsp comments --%>
        <%--
            out
            session
            request
            response
        --%>
        <%
            Integer counter = 0;
            if (session.getAttribute("counter") != null) {
                counter = (Integer)session.getAttribute("counter") + 1;
            }
            session.setAttribute("counter", counter);
        %>
        The counter value is <%=session.getAttribute("counter")%>
    </body>
</html>
