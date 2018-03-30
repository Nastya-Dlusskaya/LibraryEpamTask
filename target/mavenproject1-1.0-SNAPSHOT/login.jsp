<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.03.2018
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>local.namePage.login</title>
</head>
<body>
<div id="login-form">
    <h1>Login</h1>
        <form name="LoginForm" method="post" action="login">
            <input type="hidden" name="command" value="login"/>
            Login
            <input type="text" name="login" value="" required="required">
            Password
            <input type="password" name="password" value="" required="required">
            <div class="error-login">
                ${wrongAction}
                ${nullPage}
            </div>
            <input type="submit" value="Log in">
        </form>
</div>
</body>
</html>
