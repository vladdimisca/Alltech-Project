<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Samsung Curved TV</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="scripts/products.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}products.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
    <h3>Samsung Smart Curved LED TV, 123 cm, 49RU7302, 4K Ultra HD</h3>
    <hr>

    <div class="row">

        <div class="mydiv">
            <div class="row">
                <div class="column">
                    <img src="photos/Curved.jpeg" alt="TV" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="photos/Curved2.jpeg" alt="TV" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="photos/Curved3.jpeg" alt="TV" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="photos/Curved4.jpg" alt="TV" style="width:100%" onclick="myFunction(this);">
                </div>
            </div>

            <div class="gallery">
                <img src="photos/Curved.jpeg" alt="TV" id="expandedImg" style="width:100%">
                <div id="imgtext"></div>
            </div>
        </div>

        <div class="mydiv" >
            <div class="mydiv2">

                <div class="price">
                    <p>$450 </p>
                </div>
                <br>
                <br>
                <hr>
                <ul>Main features:
                    <li>
                        Diagonal display: 123 cm
                    </li>
                    <li>
                        Image clarity: 4K
                    </li>
                    <li>
                        TV type: Smart TV
                    </li>
                    <li>
                        Display technology: LED
                    </li>
                    <li>
                        Special technology: HDR
                    </li>
                </ul>
                <hr>
                <p style="text-align: center;">In stock</p>
                <hr>
            </div>
            <button class="cart" id="curvedTV">
                Add to Cart
                <i class="fa fa-shopping-cart" style="color: white;"></i>
            </button>
        </div>
    </div>

    <br>
    <h2>Specifications</h2>
    <table class="specifications">
        <tr>
            <th>GENERAL CHARACTERISTICS</th>
        </tr>
        <tr>
            <td>Diagonal display</td>
            <td>123 cm</td>
        </tr>
        <tr>
            <td>TV type</td>
            <td>Smart TV</td>
        </tr>
        <tr>
            <td>Display technology</td>
            <td>LED</td>
        </tr>
        <tr>
            <td>Special technology</td>
            <td>HDR</td>
        </tr>
        <tr>
            <td>Image clarity</td>
            <td>4K </td>
        </tr>
        <tr>
            <td>Year of occurrence</td>
            <td>2019</td>
        </tr>
        <tr>
            <td>Color</td>
            <td>Black</td>
        </tr>
        <tr>
            <td>Display format </td>
            <td>Curved</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>SMART TV</th>
        </tr>
        <tr>
            <td>Operating system</td>
            <td>Tizen</td>
        </tr>
        <tr>
            <td>Video Streaming Applications</td>
            <td>YouTube, Netflix, HBOGo</td>
        </tr>
        <tr>
            <td>Key Features</td>
            <td>Screen Mirroring</td>
        </tr>
        <tr>
            <td>Smart voice assistant</td>
            <td>Alexa</td>
        </tr>
        <tr>
            <td>Mirroring</td>
            <td>iOS, Android</td>
        </tr>
        <tr>
            <td>Processor type</td>
            <td>Quad core </td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>VIDEO FEATURES</th>
        </tr>
        <tr>
            <td>Resolution</td>
            <td>3840 x 2160</td>
        </tr>
        <tr>
            <td>HDR technology type</td>
            <td>HDR 10+</td>
        </tr>
        <tr>
            <td>Integrated digital tuner</td>
            <td>	DVB-T2, DVB-C</td>
        </tr>
        <tr>
            <td>Image technologies</td>
            <td>Contrast Enhancer, Pur Color, UHD Dimming, UHD Engine, Mod Film, Mod Natural</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>AUDIO FEATURES</th>
        </tr>
        <tr>
            <td>Audio technologies</td>
            <td>Dolby Digital Plus, Multiroom Link</td>
        </tr>
        <tr>
            <td>Audio system</td>
            <td>2</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>CONNECTIVITY</th>
        </tr>
        <tr>
            <td>Wireless Conectivity</td>
            <td>Wi-Fi</td>
        </tr>
        <tr>
            <td>Interface</td>
            <td>	3 x HDMI <br>
                1 x RJ-45 <br>
                1 x S/PDIF <br>
                CI + slot <br>
                2 x USB <br>
                1 x AV <br>
                1 x YPbPr</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>ENERGY CONSUMPTION</th>
        </tr>
        <tr>
            <td>Energy efficiency</td>
            <td>Class A</td>
        </tr>
        <tr>
            <td>Electricity consumption</td>
            <td>33.1 W, 91 W, 125 W</td>
        </tr>
        <tr>
            <td>Power consumed in stand-by </td>
            <td>0.5 W</td>
        </tr>
        <tr>
            <td>Annual energy consumption</td>
            <td>126 kWh</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>DIMENSIONS</th>
        </tr>
        <tr>
            <td>Size without stand</td>
            <td>1101.5 x 638.5 x 95.7 mm</td>
        </tr>
        <tr>
            <td>Size with stand</td>
            <td>1101.5 x 717.4 x 261.3 mm</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>ACCESSORY</th>
        </tr>
        <tr>
            <td>Package Contents</td>
            <td>Power cable, Remote, User manual</td>
        </tr>
    </table>
</div>

<div class="container">
    <h2 class="center" style="font-family: Trebuchet MS, Helvetica, sans-serif; ">Comments Section</h2>
    <div class="comments">
        <form action="">
            <textarea  id="styledTextArea"  onkeyup="autoGrow(this);" placeholder="Enter your comment here..."></textarea>
            <br><br>
            <input id="styledInput" value="Send Comment" type="submit">
        </form>
    </div>
    <h3 style = "font-family: Trebuchet MS, Helvetica, sans-serif;">Comments: </h3>
</div>
</body>
</html>
