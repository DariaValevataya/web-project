<%--
  Created by IntelliJ IDEA.
  User: daria
  Date: 09.06.2024
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/hello-servlet" method="get">
    <h1>Input your username and password for LogIn</h1>
    <label for="username">Username</label>
    <input id="username" name="username" type="text">
    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <input type="submit" value="Login">
</form>
</body>
</html>
