<%--
  Created by IntelliJ IDEA.
  User: daria
  Date: 16.06.2024
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../components/header.jsp"%>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form action="signup.do" method="get">
    <h1>Create username and password for SignIn</h1>
    <label for="username">Username</label>
    <input id="username" name="username" type="text">
    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <label for="confirmPassword">Confirm password</label>
    <input id="confirmPassword" name="confirmPassword" type="password">
    <input type="submit" value="Sign up">
</form>
</body>
</html>
