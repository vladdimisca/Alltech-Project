<%--
  Created by IntelliJ IDEA.
  User: vladd
  Date: 4/20/2020
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="register.css">
</head>
<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
        <a href="index.jsp" class="navbar-brand">Alltech</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#Menu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="Menu">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="#" class="nav-link">Products</a>
                </li>
                <li class="nav-item">
                    <a href="user_profile.jsp" class="nav-link active">Profile</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <h1 class="center">Your profile</h1>
        <h4>First Name: </h4>
        <h4>Last Name: </h4>
        <h4>Email: </h4>
        <h2 class="center">Actions</h2>
        <h4>Logout</h4>
        <h4>Delete your account</h4>
    </div>
</body>
</html>
