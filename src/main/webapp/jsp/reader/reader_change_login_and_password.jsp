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
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="reader_menu.jsp"/>
<form name="changeLoginAndPassword" method="post" action="/" class="form">
    <input type="hidden" name="command" value="change_login_and_password"/>
    <h3>
        Login
    </h3>
    <input type="text" name="login" value="${user.login}" required="required"/>
    <h3>
        Password
    </h3>
    <input type="password" name="password" value="${user.password}" required="required"/>
    <input type="submit" value="Save"/>
</form>
<jsp:include page="../footer.jsp"/>
</body>
</html>
