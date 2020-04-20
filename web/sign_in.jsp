<%--
  Created by IntelliJ IDEA.
  User: vladd
  Date: 4/19/2020
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="register.css">
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
    <a href="index.jsp" class="navbar-brand">Alltech</a>
    <button class="navbar-toggler" data-toggle="collapse" data-target="#Menu">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="Menu">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="#" class="nav-link">Products</a>
            </li>
            <li class="nav-item">
                <a href="guest_profile.jsp" class="nav-link active">Account</a>
            </li>
        </ul>
    </div>
</nav>

<form name="loginForm" method="post" action="sign_in">
    <div class="container">

        <h1 class="center">Sign in to your account</h1>
        <hr>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" id="email" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

        <c:if test="${not empty param.message}">
            <h4>${param.message}</h4>
        </c:if>

        <hr>
        <button type="submit" class="registerbtn">Sign in</button>
    </div>

    <div class="container signin center">
        <p>Don't have an account? <a href="guest_profile.jsp">Register</a>.</p>
    </div>
</form>
</body>
</html>
