<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../styles/header.css" rel="stylesheet">
    <title></title>
</head>
<body>
<header>
    <div id="menu-box">
        <div class="logo">
            <img id="logo-img" src="${pageContext.request.contextPath}/images/logo.jpg" alt="">
        </div>
        <div class="main-menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/pages/profile.jsp">Account</a></li>
                <li><a href="#">Page2</a></li>
                <li><a href="#">Page3</a></li>
                <li><a href="#">Page4</a></li>
                <li><a href="#">Page5</a></li>
                <li><a href="#">Page6</a></li>
            </ul>
        </div>
        <c:if test="${empty login}">
        <div class="menu-button">
            <a href="${pageContext.request.contextPath}/pages/login.jsp">
                <button id="login-button">Log in</button>
            </a>
            <a href="${pageContext.request.contextPath}/pages/signup.jsp">
                <button id="signup-button">Sign up</button>
            </a>
        </div>
        </c:if>
    </div>
</header>
</body>
</html>
