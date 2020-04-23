<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Dell Laptop</title>
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
    <h3>Dell Inspiron 15 3584 Laptop with Intel® Core ™ i3-7020U 2.30 GHz, 15.6 ", Full HD, 4GB, 128GB SSD, Intel HD Graphics 620, Intel HD Graphics 620, Ubuntu, Black</h3>
    <hr>

    <div class="row">

        <div class="mydiv">
            <div class="row">
                <div class="column">
                    <img src="dell.jpg" alt="Dell" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="dell2.jpg" alt="Dell" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="dell3.jpg" alt="Dell" style="width:100%" onclick="myFunction(this);">
                </div>
                <div class="column">
                    <img src="dell4.jpg" alt="Dell" style="width:100%" onclick="myFunction(this);">
                </div>
            </div>

            <div class="gallery">
                <img src="dell.jpg" id="expandedImg" style="width:100%">
                <div id="imgtext"></div>
            </div>
        </div>

        <div class="mydiv" >
            <div class="mydiv2">

                <span class="price">
                    <p>$370 </p>
                </span>
                <br>
                <br>
                <hr>
                <ul>Main features:
                    <li>
                        Processor type: i3
                    </li>
                    <li>
                        Memory capacity: 4 GB
                    </li>
                    <li>
                        Diagonal display: 15.6 inches
                    </li>
                    <li>
                        Storage type: SSD
                    </li>
                    <li>
                        Processor manufacturer: Intel®
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
    <h2>Specifications</h2>
    <table class="specifications">
        <tr>
            <th>PROCESOR</th>
        </tr>
        <tr>
            <td>Processor manufacturer</td>
            <td>Intel®</td>
        </tr>
        <tr>
            <td>Processor type</td>
            <td>i3</td>
        </tr>
        <tr>
            <td>Processor model</td>
            <td>7020U</td>
        </tr>
        <tr>
            <td>Architecture</td>
            <td>Kaby Lake</td>
        </tr>
        <tr>
            <td>Number of cores</td>
            <td>2</td>
        </tr>
        <tr>
            <td>Nominal frequency</td>
            <td>2.3 GHz</td>
        </tr>
        <tr>
            <td>Cache</td>
            <td>3072 KB</td>
        </tr>
        <tr>
            <td>Processor technology</td>
            <td>14 nm</td>
        </tr>
        <tr>
            <td>Integrated graphics processor</td>
            <td>Intel® HD Graphics 620</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>DISPLAY</th>
        </tr>
        <tr>
            <td>Diagonal display</td>
            <td>15.6 inch</td>
        </tr>
        <tr>
            <td>Display format</td>
            <td>Full HD</td>
        </tr>
        <tr>
            <td>Display technology</td>
            <td>LCD LED</td>
        </tr>
        <tr>
            <td>Refresh rate</td>
            <td>60 Hz</td>
        </tr>
        <tr>
            <td>Display finish</td>
            <td>Anti-Glare</td>
        </tr>
        <tr>
            <td>Resolution</td>
            <td>1920 x 1080</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>MEMORY</th>
        </tr>
        <tr>
            <td>Memory capacity</td>
            <td>4 GB</td>
        </tr>
        <tr>
            <td>Memory type</td>
            <td>DDR4 </td>
        </tr>
        <tr>
            <td>Number of slots</td>
            <td>2</td>
        </tr>
        <tr>
            <td>Slots occupied</td>
            <td>1</td>
        </tr>
        <tr>
            <td>Frequency </td>
            <td>2666 MHz</td>
        </tr>
        <tr>
            <td>Maximum supported memory capacity</td>
            <td>16 GB</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>HARD DISK</th>
        </tr>
        <tr>
            <td>Storage type</td>
            <td>SSD</td>
        </tr>
        <tr>
            <td>SSD capacity</td>
            <td>128 GB</td>
        </tr>
        <tr>
            <td>SSD interface</td>
            <td>M.2</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>MULTIMEDIA</th>
        </tr>
        <tr>
            <td>WEB Camera</td>
            <td>HD</td>
        </tr>
        <tr>
            <td>Audio </td>
            <td> Stereo speakers, Dual microphones</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>CONNECTIVITY & PORT</th>
        </tr>
        <tr>
            <td>Ports</td>
            <td>2 x USB 3.1 <br>
                1 x USB 2.0 <br>
                1 x HDMI <br>
                1 x RJ-45 <br>
                1 x Audio Out / Microphone</td>
        </tr>
        <tr>
            <td>Card reader</td>
            <td>SD</td>
        </tr>
        <tr>
            <td>Wireless</td>
            <td>802.11 ac</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>SOFTWARE</th>
        </tr>
        <tr>
            <td>Operating system</td>
            <td>Ubuntu</td>
        </tr>
    </table>
    <br>
    <table class="specifications">
        <tr>
            <th>GENERAL CHARACTERISTICS</th>
        </tr>
        <tr>
            <td>Manufacturer platform</td>
            <td>Dell Inspiron 3584</td>
        </tr>
        <tr>
            <td>Numeric keypad</td>
            <td>Yes</td>
        </tr>
        <tr>
            <td>Dimensions (W x H x D) </td>
            <td>380 x 20 x 258 mm</td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>2 Kg</td>
        </tr>
        <tr>
            <td>Security</td>
            <td>BIOS Password, Security lock</td>
        </tr>
        <tr>
            <td>Keyboard language </td>
            <td>International keyboard</td>
        </tr>
        <tr>
            <td>Color</td>
            <td> Black</td>
        </tr>
        <tr>
            <td>Key Features</td>
            <td>Webcam, Touchpad that supports multiple touch gestures</td>
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
