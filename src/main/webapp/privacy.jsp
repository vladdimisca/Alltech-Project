<%--
  Created by IntelliJ IDEA.
  User: vladd
  Date: 4/19/2020
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Terms & Privacy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}privacy.css">
    <script src="scripts/user_profile.js"></script>
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
    <h1 class="center">Conditions of Use and Privacy Notice</h1>
    <hr>
    <h4 class="center"> By using Alltech, you agree to these conditions. Please read them carefully.</h4>
    <br>
    <h5> &emsp; YOUR ACCOUNT</h5>
    <p>
        &emsp; You may need your own Alltech account to use certain Alltech Services, and you may be required to be logged in to the account and have a valid payment method associated with it. If there is a problem charging your selected payment method, we may charge any other valid payment method associated with your account. You are responsible for maintaining the confidentiality of your account and password and for restricting access to your account, and you agree to accept responsibility for all activities that occur under your account or password. Alltech does sell products for children, but it sells them to adults, who can purchase with a credit card or other permitted payment method. If you are under 18, you may use the Alltech Services only with involvement of a parent or guardian.
    </p>
    <h5> &emsp; COMMENTS AND COMMUNICATION</h5>
    <p>
        &emsp; You may post reviews, comments or other information, so long as the content is not illegal, obscene, threatening, defamatory, invasive of privacy, infringing of intellectual property rights (including publicity rights), or otherwise injurious to third parties or objectionable, and does not consist of or contain software viruses, political campaigning, commercial solicitation, chain letters, mass mailings, or any form of "spam" or unsolicited commercial electronic messages. You may not use a false e-mail address, impersonate any person or entity, or otherwise mislead as to the origin of a card or other content. Alltech reserves the right (but not the obligation) to remove or edit such content, but does not regularly review posted content.
    </p>
    <h5> &emsp; RISK OF LOSS</h5>
    <p>
        &emsp; All purchases of physical items from Alltech are made pursuant to a shipment contract. This means that the risk of loss and title for such items pass to you upon our delivery to the carrier.
    </p>
    <h5> &emsp; PRODUCT DESCRIPTIONS</h5>
    <p>
        &emsp; Alltech attempts to be as accurate as possible. However, Alltech does not warrant that product descriptions or other content of any Alltech Service is accurate, complete, reliable, current, or error-free. If a product offered by Alltech itself is not as described, your sole remedy is to return it in unused condition.
    </p>
    <h5> &emsp; RETURNS, REFUNDS AND TITLE</h5>
    <p>
        &emsp; Alltech does not take title to returned items until the item arrives at our fulfillment center. At our discretion, a refund may be issued without requiring a return. In this situation, Alltech does not take title to the refunded item.
    </p>
    <h5> &emsp; What Personal Information About Customers Does Alltech Collect?</h5>
    <p>
        &emsp; We collect your personal information in order to provide and continually improve our products and services. We collect the information you provide us in the authentication form, as well as other information, such as the items you add to your shopping cart, the home address you give us when placing an order and the comments you provide to the products marketed by us.
    </p>
    <h5> &emsp; For What Purposes Does Alltech Use Your Personal Information?</h5>
    <p>
        &emsp; We use your personal information to operate, provide, develop, and improve the products and services that we offer our customers. These purposes include:

        Purchase and delivery of products and services. We use your personal information to take and handle orders, deliver products and services, process payments, and communicate with you about orders, products and services, and promotional offers.
        Provide, troubleshoot, and improve Alltech Services. We use your personal information to provide functionality, analyze performance, fix errors, and improve the usability and effectiveness of the Alltech Services.
        Communicate with you. We use your personal information to communicate with you in relation to Alltech Services via different channels.
    </p>
    <h5> &emsp; Does Alltech Share Your Personal Information?</h5>
    <p>
        &emsp; Information about our customers is an important part of our business, and we are not in the business of selling our customers’ personal information to others.
    </p>
</div>

</body>
</html>
