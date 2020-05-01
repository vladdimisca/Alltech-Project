<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Apple iPhone</title>
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
    <h3>Apple iPhone 11 Mobile Phone, 64GB, Black</h3>
    <hr>

    <div class="row">

        <div class="mydiv">
            <div class="row">
                <div class="column">
                    <img src="photos/apple.jpg" alt="Apple" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="photos/apple2.jpg" alt="Apple" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="photos/apple3.jpg" alt="Apple" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="photos/apple4.jpg" alt="Apple" style="width:100%" onclick="myFunction(this);">
                </div>
            </div>

            <div class="gallery">
                <img src="photos/apple.jpg" alt="Apple" id="expandedImg" style="width:100%">
                <div id="imgtext"></div>
            </div>
        </div>

        <div class="mydiv" >
            <div class="mydiv2">

                <div class="price">
                    <p>$829 </p>
                </div>
                <br>
                <br>
                <hr>
                <ul>Main features:
                    <li>
                        Internal memory: 64 GB
                    </li>
                    <li>
                        Operating system: iOS
                    </li>
                    <li>
                        RAM memory: 4 GB
                    </li>
                    <li>
                        Screen size: 6.1 inches
                    </li>
                </ul>
                <hr>
                <p style="text-align: center;" id="stock">In stock</p>
                <hr>
            </div>
            <button class="cart" id="applePhone">
                Add to Cart
                <i class="fa fa-shopping-cart" style="color: white;"></i>
            </button>
        </div>
    </div>

    <br>
    <br>
    <br>
    <h2>Specifications</h2>
    <table class="specifications">
        <tr>
            <th>GENERAL CHARACTERISTICS</th>
        </tr>
        <tr>
            <td>Phone type</td>
            <td>Smartphone</td>
        </tr>
        <tr>
            <td>SIM slots</td>
            <td>Single SIM</td>
        </tr>
        <tr>
            <td>SIM type </td>
            <td>Nano SIM</td>
        </tr>
        <tr>
            <td>Operating system</td>
            <td>iOS</td>
        </tr>
        <tr>
            <td>operating system version</td>
            <td>iOS 13</td>
        </tr>
        <tr>
            <td>Number of cores</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Processor frequency</td>
            <td>2.65 GHz, 1.8 GHz</td>
        </tr>
        <tr>
            <td>Technologies</td>
            <td>2G, 3G, 4G</td>
        </tr>
        <tr>
            <td>Connectivity</td>
            <td>Wi-Fi, Bluetooth, NFC, GPS</td>
        </tr>
        <tr>
            <td>Sensors</td>
            <td>Barometer, Accelerometer, Gyroscope, Facial recognition, Footprint, Compass, Proximity sensor, Light sensor</td>
        </tr>
        <tr>
            <td>Package content</td>
            <td>Phone, Phone charger, Headphones</td>
        </tr>
        <tr>
            <td>Color</td>
            <td>Black</td>
        </tr>
        <tr>
            <td>Dimensions</td>
            <td>75.7 x 150.9 x 8.3 mm</td>
        </tr>
        <tr>
            <td>RO-ALERT</td>
            <td>Yes</td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>194 g</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>DISPLAY</th>
        </tr>
        <tr>
            <td>Diagonal display</td>
            <td>6.1 inch</td>
        </tr>
        <tr>
            <td>Display type</td>
            <td>IPS</td>
        </tr>
        <tr>
            <td>Resolution</td>
            <td>828 x 1792</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>MEMORY</th>
        </tr>
        <tr>
            <td>Memory RAM</td>
            <td>4 GB</td>
        </tr>
        <tr>
            <td>Intern memory</td>
            <td>64 GB</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>CONNECTIVITY & PORT</th>
        </tr>
        <tr>
            <td>Ports</td>
            <td>Lightning</td>
        </tr>
        <tr>
            <td>Bluetooth version</td>
            <td>5.0, A2DP, LE</td>
        </tr>
        <tr>
            <td>Standard Wi-Fi</td>
            <td>Dual Band, Wi-fi hotspot, 802.11ax 2x2</td>
        </tr>
    </table>
    <br>
    <br>
    <table class="specifications">
        <tr>
            <th>PHOTO VIDEO</th>
        </tr>
        <tr>
            <td>Main camera resolution</td>
            <td>12 MP Wide, 12 MP Ultrawide</td>
        </tr>
        <tr>
            <td>Number of cameras</td>
            <td>3</td>
        </tr>
        <tr>
            <td>Front camera resolution</td>
            <td>12 Mpx</td>
        </tr>
        <tr>
            <td>Video resolution</td>
            <td>Full HD, 4K</td>
        </tr>
        <tr>
            <td>Photo / video features</td>
            <td>HDR, Panorama, Slow motion, Time-lapse, Geotagging</td>
        </tr>
        <tr>
            <td>Flash</td>
            <td>Yes</td>
        </tr>
    </table>
        <br>
        <table class="specifications">
            <tr>
                <th>POWER</th>
            </tr>
            <tr>
                <td>Battery type</td>
                <td>Li-Ion</td>
            </tr>
            <tr>
                <td>Battery capacity</td>
                <td>3110 mAh</td>
            </tr>
        </table>
</div>

<div class="container" id="commentSection">
    <h2 class="center" style="font-family: Trebuchet MS, Helvetica, sans-serif; ">Comments Section</h2>
    <div class="comments">
        <form action="comments" id="commentForm">
            <textarea minlength="2" maxlength="300" id="styledTextArea"  onkeyup="autoGrow(this);" placeholder="Enter your comment here..."></textarea>
            <br><br>
            <input id="styledInput" value="Send Comment" type="submit">
        </form>
    </div>
    <h3 style = "font-family: Trebuchet MS, Helvetica, sans-serif;">Comments: </h3>
    <p id="commentP">There are no comments to display!</p>
</div>
</body>
</html>
