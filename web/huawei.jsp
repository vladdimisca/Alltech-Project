<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Huawei Smartphone</title>
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
    <h3>Huawei P30 Lite Mobile Phone, Dual SIM, 128GB, 4GB RAM, 32MP Selfie Camera, 4G, Black</h3>
    <hr>

    <div class="row">

        <div class="mydiv">
            <div class="row">
                <div class="column">
                    <img src="huawei.jpg" alt="Huawei" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="huawei2.jpg" alt="Huawei" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="huawei3.jpg" alt="Huawei" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="huawei4.jpg" alt="Huawei" style="width:100%" onclick="myFunction(this);">
                </div>
            </div>

            <div class="gallery">
                <img src="huawei.jpg" id="expandedImg" style="width:100%">
                <div id="imgtext"></div>
            </div>
        </div>

        <div class="mydiv" >
            <div class="mydiv2">
                <span class="price">
                    <p>$250 </p>
                </span>
                <br>
                <br>
                <hr>
                <ul>Main features:
                    <li>
                        Internal memory: 128 GB
                    </li>
                    <li>
                        Operating system: Android
                    </li>
                    <li>
                        RAM memory: 4 GB
                    </li>
                    <li>
                        Screen size: 6.15 inches
                    </li>
                </ul>
                <hr>
                <p style="text-align: center;">In stock</p>
                <hr>
            </div>
            <button class="cart" >
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
            <td>Dual SIM</td>
        </tr>
        <tr>
            <td>SIM type </td>
            <td>Nano SIM</td>
        </tr>
        <tr>
            <td>Operating system</td>
            <td>Android</td>
        </tr>
        <tr>
            <td>operating system version</td>
            <td>Android 9</td>
        </tr>
        <tr>
            <td>Number of cores</td>
            <td>8</td>
        </tr>
        <tr>
            <td>Processor model</td>
            <td>HiSilicon Kirin 710</td>
        </tr>
        <tr>
            <td>Processor frequency</td>
            <td>2.2 GHz, 1.7 GHz</td>
        </tr>
        <tr>
            <td>Technologies</td>
            <td>2G, 3G, 4G</td>
        </tr>
        <tr>
            <td>Connectivity</td>
            <td>	Wi-Fi, Bluetooth, NFC, GPS</td>
        </tr>
        <tr>
            <td>Sensors</td>
            <td>Accelerometer, Gyroscope, Footprint, Compass, Proximity sensor, Light sensor</td>
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
            <td>72.7 x 152.9 x 7.4 mm</td>
        </tr>
        <tr>
            <td>RO-ALERT</td>
            <td>Yes</td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>159 g</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>DISPLAY</th>
        </tr>
        <tr>
            <td>Diagonal display</td>
            <td>6.15 inch</td>
        </tr>
        <tr>
            <td>Display type</td>
            <td>IPS</td>
        </tr>
        <tr>
            <td>Resolution</td>
            <td>1080 x 2312</td>
        </tr>
        <tr>
            <td>Display functions</td>
            <td>Multi-touch, 415 PPI</td>
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
            <td>128 GB</td>
        </tr>
        <tr>
            <td>Memory card slot</td>
            <td>MicroSD</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>CONNECTIVITY & PORT</th>
        </tr>
        <tr>
            <td>Ports</td>
            <td>	USB Type C, Jack 3.5 mm</td>
        </tr>
        <tr>
            <td>Bluetooth version</td>
            <td>4.2</td>
        </tr>
        <tr>
            <td>Standard Wi-Fi</td>
            <td>802.11 a/b/g/n/ac</td>
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
            <td>48 MP Wide, 8 MP Ultrawide, 2 MP Depth</td>
        </tr>
        <tr>
            <td>Number of cameras</td>
            <td>4</td>
        </tr>
        <tr>
            <td>Front camera resolution</td>
            <td>32 Mpx</td>
        </tr>
        <tr>
            <td>Video resolution</td>
            <td>Full HD</td>
        </tr>
        <tr>
            <td>Photo / video features</td>
            <td>HDR, Panorama</td>
        </tr>
        <tr>
            <td>Flash</td>
            <td>Yes</td>
        </tr>
        <br>
        <table class="specifications">
            <tr>
                <th>POWER</th>
            </tr>
            <tr>
                <td>Battery type</td>
                <td>Li-Po</td>
            </tr>
            <tr>
                <td>Battery capacity</td>
                <td>3340 mAh</td>
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
