<%--
  Created by IntelliJ IDEA.
  User: daria
  Date: 16.06.2024
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../components/header.jsp" %>
<html>
<head>
    <title>Sign up</title>
    <link href="../styles/signup.css" rel="stylesheet">
</head>
<body>
<div id="content">
<form action="signup.do" method="post">
    <div class="input-field">
        <label for="firstname">Firstname</label><br/>
        <input id="firstname" name="firstname" type="text">
    </div>
    <div class="input-field">
        <label for="lastname">Lastname</label><br/>
        <input id="lastname" name="lastname" type="text" >
    </div>
    <div class="input-field">
        <label for="phone">Phone</label><br/>
        <input id="phone" name="phone" type="text" placeholder="+375 XX XXX-XX-XX" >
    </div>
    <div class="input-field">
        <label for="email">Email</label><br/>
        <input id="email" name="email" type="text" >
    </div>
    <div class="input-field">
        <label for="login">Login</label><br/>
        <input id="login" name="login" type="text" >
    </div>
    <div class="input-field">
        <label for="password">Password</label><br/>
        <input id="password" name="password" type="password" >
    </div>
    <div class="input-field">
        <label for="confirmPassword">Confirm password</label><br/>
        <input id="confirmPassword" name="confirmPassword" type="password" ><br/>
    </div>
    <input class="inputSubmit" type="submit" value="Sign up">
</form>
</div>
<script src="../javascript/auth.js"></script>
</body>
</html>
