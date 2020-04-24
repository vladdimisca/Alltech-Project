<%--
  Created by IntelliJ IDEA.
  User: vladd
  Date: 4/18/2020
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Alltech</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}index.css">
    <script src="scripts/index.js"></script>
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
    <div id = "cf">
      <img class = "bottom" src="photo1.jpg" alt="photo1" >
      <img class = "top" src="photo5.jpg" alt="photo2" >
    </div>
    <div class="wrapper"><h1>Alltech</h1></div>
    <h3> The site of your technology</h3>

    <p>We offer a variety of products that might interest you.</p>
    <p class="margin">Choose the category you want to buy from.</p>

    <div class="archive">
      <a class="grow" href="televisions.jsp">
        <article class="article">
          <img  src="tv.jpg" alt="TV" >
          <p class="par"> Televisions</p>
        </article>
      </a>
      <a class="grow" href="laptops.jsp">
        <article class="article">
          <img  src="laptop.jpg" alt="laptop" >
          <p class="par"> Laptops</p>
        </article>
      </a>
      <a class="grow" href="phones.jsp">
        <article class="article">
          <img  src="phone1.jpg" alt="phone" >
        </article>
          <p class="par"> Smartphones</p>
      </a>
    </div>
  </div>
  </body>
</html>
