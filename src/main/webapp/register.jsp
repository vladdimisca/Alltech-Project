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
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}register.css">
        <script src="scripts/register.js"></script>
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
                    <a href="register.jsp" class="nav-link active">Account</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="orders.jsp" class="nav-link">My Orders</a>
                </li>
                <li class="nav-item">
                    <a href="shopping_cart.jsp" class="nav-link">Shopping Cart</a>
                </li>
            </ul>
        </div>
    </nav>

        <form name="registerForm" method="post" action="register" id="registerForm">
            <div class="container">
                <h2 class="center">Create an account</h2>
                <hr>

                <label for="firstName" class="required"><b>First Name</b></label>
                <input pattern="[a-zA-Z -]+" type="text" placeholder="Enter First Name" name="firstName" id="firstName" required title="Alphabets only">

                <label for="lastName" class="required"><b>Last Name</b></label>
                <input pattern="[a-zA-Z -]+" type="text" placeholder="Enter Last Name" name="lastName" id="lastName" required title="Alphabets only">

                <label for="email" class="required"><b>Email</b></label>
                <input type="text" pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
                       placeholder="Enter Email" name="email" id="email" required title="Email pattern needed">

                <label for="password" class="required"><b>Password</b></label>
                <input pattern=".{5,12}" type="password" placeholder="Enter Password" name="password" id="password" required title="Length has to be from 5 to 12 characters">

                <hr>
                <p>By creating an account you agree to our <a href="privacy.jsp">Terms & Privacy</a>.</p>

                <button type="submit" class="registerbtn">Register</button>
            </div>

            <div class="container signin center">
                <p>Already have an account? <a href="sign_in.jsp">Sign in</a>.</p>
            </div>
        </form>
    </body>
</html>
