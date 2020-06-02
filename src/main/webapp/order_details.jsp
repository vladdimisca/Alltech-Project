<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}register.css">
    <script src="scripts/order_details.js"></script>
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
                <a href="user_profile.jsp" class="nav-link">Account</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="orders.jsp" class="nav-link">My Orders</a>
            </li>
            <li class="nav-item">
                <a href="shopping_cart.jsp" class="nav-link active">Shopping Cart</a>
            </li>
        </ul>
    </div>
</nav>

<form name="orderForm" method="post" action="order" id="orderForm">
    <div class="container">
        <h2 class="center">Order Details</h2>
        <hr>

        <label for="phoneNumber" class="required"><b>Phone number</b></label>
        <input pattern="[0-9]+" type="text" placeholder="Enter Phone Number" name="phoneNumber" id="phoneNumber" required title="Digits only">

        <label for="address" class="required"><b>Full address</b></label>
        <input type="text" placeholder="Enter Full Address" name="address" id="address" required title="Enter your full address">

        <p class="required"><b>Delivery method</b></p>

        <fieldset id="delivery" aria-required="true">
            <input type="radio" id="cashOnDelivery" value="1" name="delivery" checked="checked" required>
            <label for="cashOnDelivery">Cash on delivery (+5$)</label>

            <br>

            <input type="radio" id="personal" value="2" name="delivery">
            <label for="personal">Pick from our store </label>
        </fieldset>

        <br>

        <p id="totalPrice" style="font-size: x-large;"><b>Total price: </b></p>

        <button id="order" type="submit" class="registerbtn">Order</button>
    </div>
</form>
</body>
</html>
