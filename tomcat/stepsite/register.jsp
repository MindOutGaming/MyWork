<%-- 
    Document   : register
    Created on : 06-Jun-2023, 12:32:47 PM
    Author     : sohel1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STEP - Registration Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/index.js"></script>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-fluid w-75">
            <form>
                <div class="mb-3 mt-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter Username" name="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password">
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Confirm Password:</label>
                    <input type="password" class="form-control" id="cpassword" placeholder="Enter Confirm Password" name="cpassword">
                </div>
                <button class="btn btn-primary" onclick="return validateForm()">Submit</button>
                <button type="reset" class="btn btn-warning">RESET</button>
            </form>
            <br/>
            If you are already registered, kindly login here: <a href="index.jsp" class="link-primary">Login Form</a>
        </div>
    </body>
</html>
