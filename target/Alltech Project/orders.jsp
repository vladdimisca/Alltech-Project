<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My orders</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}orders.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="scripts/orders.js"></script>
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

<div class="container">
    <h2 class = "center">My orders</h2>
    <hr>
    <p id = "ordersMessage">You are not logged in.</p>
    <div class="archive">
        <div class="grow">
            <article class="article">
                <p class="par" style="font-weight: bold">Order number: 5 </p>
                <hr class="new1">
                <p class="center">Date: 01/06/2020</p>
                <hr class="new1">
                <p class="center">Phone number: 0725342724</p>
                <hr class="new1">
                <p class="price"> $650</p>
                <hr class="new1">
                <p class="center">Delivery method: Cash on delivery</p>
                <a href="#">
                    <button class="cart">
                        View order
                    </button>
                </a>
            </article>
        </div>
        <div class="grow">
            <article class="article">
                <p class="par" style="font-weight: bold">Order number: 5 </p>
                <hr class="new1">
                <p class="center">Date: 01/06/2020</p>
                <hr class="new1">
                <p class="center">Phone number: 0725342724</p>
                <hr class="new1">
                <p class="price"> $650</p>
                <hr class="new1">
                <p class="center">Delivery method: Cash on delivery</p>
                <a href="#">
                    <button class="cart">
                        View order
                    </button>
                </a>
            </article>
        </div>
        <div class="grow">
        <article class="article">
            <p class="par" style="font-weight: bold">Order number: 5 </p>
            <hr class="new1">
            <p class="center">Date: 01/06/2020</p>
            <hr class="new1">
            <p class="center">Phone number: 0725342724</p>
            <hr class="new1">
            <p class="price"> $650</p>
            <hr class="new1">
            <p class="center">Delivery method: Cash on delivery</p>
            <a href="#">
                <button class="cart">
                    View order
                </button>
            </a>
        </article>
    </div>
    </div>
</div>
</body>
</html>
