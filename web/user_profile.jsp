<%--
  Created by IntelliJ IDEA.
  User: vladd
  Date: 4/20/2020
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}index.css">
    <script src="scripts/user_profile.js"></script>
</head>
<body>
    <c:if test="${not empty param.email}">
        <script>
            login('${param.email}')
        </script>
    </c:if>

    <nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
        <a href="index.jsp" class="navbar-brand">Alltech</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#Menu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="Menu">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Products</a>
                    <div class="dropdown-menu">
                        <a href="#" class="dropdown-item">Televisions</a>
                        <a href="#" class="dropdown-item">Laptops</a>
                        <a href="#" class="dropdown-item">Smartphones</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a href="user_profile.jsp" class="nav-link active">Account</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="shopping_cart.jsp" class="nav-link">Shopping Cart</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <h1 class="center">Account details</h1>
        <hr>

        <div id="logged"> </div>
        <hr>

        <h2>Actions</h2>

        <button class="button" onclick="logout()">Logout</button>
        <br>

        <button type="submit" class="button" onclick="deletionPage()">Delete account</button>
    </div>
</body>
</html>
