<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Televisions</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
    <h3 style="font-size: 250%" class="center"> Televisions</h3>

    <div class="archive">
        <div class="grow">
                <article class="article">
                    <a href="samsung.jsp">
                    <img  src="photos/Samsung.jpeg" alt="samsung" >
                    <hr>
                    <p class="par">Samsung Smart LED TV, 108 cm, 43RU7092,4K Ultra HD</p>
                    <hr>
                    <p class="price"> $299</p>
                    <hr>
                    </a>
                    <button class="cart" >
                         Add to Cart
                        <i class="fa fa-shopping-cart" style="color: white;"></i>
                     </button>
                </article>
        </div>
        <div class="grow">
                <article class="article">
                    <a href="LG.jsp">
                        <img  src="photos/LG.jpg" alt="samsung" >
                        <hr>
                        <p class="par">LG Smart LED TV, 108 cm, 43UM7450PLA, 4K Ultra HD</p>
                        <hr>
                        <p class="price"> $390</p>
                        <hr>
                    </a>
                    <button class="cart" >
                        Add to Cart
                        <i class="fa fa-shopping-cart" style="color: white;"></i>
                    </button>
            </article>
        </div>
        <div class="grow">
            <article class="article">
                <a href="curvedTV.jsp">
                    <img  src="photos/Curved.jpeg" alt="Samsung Curved TV" >
                    <hr>
                    <p class="par">Samsung Smart Curved LED TV, 123 cm, 49RU7302, 4K</p>
                    <hr>
                    <p class="price"> $450</p>
                    <hr>
                </a>
                <button class="cart" >
                    Add to Cart
                    <i class="fa fa-shopping-cart" style="color: white;"></i>
                </button>
            </article>
        </div>
    </div>
</div>
</body>
</html>
