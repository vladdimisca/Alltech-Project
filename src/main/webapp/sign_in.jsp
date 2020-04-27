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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}register.css">
    <script src="scripts/sign_in.js"></script>
</head>

<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
        <a href="index.jsp" class="navbar-brand">Alltech</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#Menu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="Menu">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Products</a>
                    <div class="dropdown-menu bg-dark">
                        <a href="televisions.jsp" class="dropdown-item nav-item">Televisions</a>
                        <a href="laptops.jsp" class="dropdown-item nav-item">Laptops</a>
                        <a href="phones.jsp" class="dropdown-item nav-item">Smartphones</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a href="register.jsp" class="nav-link">Account</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="shopping_cart.jsp" class="nav-link">Shopping Cart</a>
                </li>
            </ul>
        </div>
    </nav>

    <form name="loginForm" action="sign_in" method="post" id="loginForm">
        <div class="container">

            <h2 class="center">Sign in to your account</h2>
            <hr>

            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" id="email" required>

            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" id="password" required>

            <c:if test="${not empty param.message}">
                <h4>${param.message}</h4>
            </c:if>

            <hr>
            <button type="submit" class="registerbtn">Sign in</button>
        </div>

        <div class="container signin center">
            <p>Don't have an account? <a href="register.jsp">Register</a>.</p>
        </div>
    </form>
</body>
</html>
