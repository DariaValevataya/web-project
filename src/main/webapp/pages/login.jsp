<%--
  Created by IntelliJ IDEA.
  User: daria
  Date: 09.06.2024
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../components/header.jsp" %>
<html>
<head>
    <title>Login</title>
    <link href="../styles/login.css" rel="stylesheet">
</head>
<body>
<div id="content">
    <form action="login.do" method="get">
        <div class="input-field">
            <label for="login">Login</label><br/>
            <input id="login" name="login" type="text">
        </div>
        <div class="input-field">
            <label for="password">Password</label><br/>
            <input id="password" name="password" type="password">
        </div>
        <input class="inputSubmit" type="submit" value="Log in">
    </form>
</div>
</body>
</html>
