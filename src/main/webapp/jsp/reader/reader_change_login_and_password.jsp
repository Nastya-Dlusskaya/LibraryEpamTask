<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.04.2018
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/style-desktop.css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="reader_menu.jsp"/>
<section>
    <form name="changeLoginAndPassword" method="post" action="/" class="form">
        <input type="hidden" name="command" value="change_login_and_password"/>
        <h3>
            Login
        </h3>
        <input type="text" name="login" value="${user.login}" required="required"/>
        <h3>
            Password
        </h3>
        <input type="text" name="password" value="${user.password}" required="required"/>
        <br/>
        <input type="submit" value="Save"/>
    </form>
</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>
