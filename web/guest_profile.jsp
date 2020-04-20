<%--
  Created by IntelliJ IDEA.
  User: vladd
  Date: 4/19/2020
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Guest Profile</title>
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

        <form name="registerForm" method="post" action="guest_profile">
        <div class="container">
            <h1 class="center">Create an account</h1>
            <hr>
                <label for="first-name" class="required"><b>First Name</b></label>
                <input pattern="[a-zA-Z]+" type="text" placeholder="Enter First Name" name="first-name" id="first-name" required title="Alphabets only">

                <label for="last-name" class="required"><b>Last Name</b></label>
                <input pattern="[a-zA-Z]+" type="text" placeholder="Enter Last Name" name="last-name" id="last-name" required title="Alphabets only">

                <label for="email" class="required"><b>Email</b></label>
                <input pattern="^(?=[A-Z0-9][A-Z0-9@._%+-]{5,253}+$)[A-Z0-9._%+-]{1,64}+@(?:(?=[A-Z0-9-]{1,63}+\.)[A-Z0-9]++(?:-[A-Z0-9]++)*+\.){1,8}+[A-Z]{2,63}+$" type="text" placeholder="Enter Email" name="email" id="email" required title="Email pattern needed">

                <label for="psw" class="required"><b>Password</b></label>
                <input pattern=".{5,12}" type="password" placeholder="Enter Password" name="psw" id="psw" required title="Length has to be from 5 to 12 characters">

                <c:if test="${not empty param.message}">
                    <h4>${param.message}</h4>
                </c:if>

                <hr>
                <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

                <button type="submit" class="registerbtn">Register</button>
                
            </div>

            <div class="container signin center">
                <p>Already have an account? <a href="sign_in.jsp">Sign in</a>.</p>
            </div>
        </form>
    </body>
</html>
