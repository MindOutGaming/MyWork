<%-- 
    Document   : dashboard
    Created on : 21-Mar-2023, 12:42:10 PM
    Author     : sohel1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Admin Dashboard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="js/index.js"></script>
    </head>
    <body>
        <%
            if (session.getAttribute("loggedin") == null) {
                // dashboard to index.jsp
                response.sendRedirect("index.jsp");
            }
        %>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Admin Dashboard</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Dashboard</a></li>
                    <li><a href="#" onclick="StudentsLoader()">Students</a></li>
                    <li><a href="#">Exams</a></li>
                    <li><a href="#">Results</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
                    <li><a href="#" onclick="logoutUser()"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </nav>
        <div id="ajax" class="container-fluid">
            
        </div>
    </body>
</html>
