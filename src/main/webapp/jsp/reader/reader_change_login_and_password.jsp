<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Change information</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/style-desktop.css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
    <fmt:bundle basename="locale">
        <fmt:message key="local.readerChange.login" var="login"/>
        <fmt:message key="local.readerChange.password" var="password"/>
        <fmt:message key="local.readerChange.button" var="saveButton"/>
    </fmt:bundle>

</head>
<body>
<section>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="reader_menu.jsp"/>
    <form name="changeLoginAndPassword" method="post" action="/" class="form">
        <input type="hidden" name="command" value="change_login_and_password"/>
        <h3>
            ${login}
        </h3>
        <input type="text" name="login" value="${user.login}" id="login"
               data-msg-login-required="${login}"
               data-msg-login-minlength="${login} ${login}"
               data-msg-login-maxlength="${login} ${login} ${login}"/>
        <h3>
            ${password}
        </h3>
        <input type="text" name="password" value="${user.password}" id="password"
               data-msg-password-required="${login}"
               data-msg-password-minlength="${login} ${login}"
               data-msg-password-maxlength="${login} ${login} ${login}"/>
        <br>
        <input type="submit" value="${saveButton}"/>
    </form>
</section>
<jsp:include page="../footer.jsp"/>
<script src="/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/js/vendor/jquery.validate.min.js"></script>
<script src="/js/validation/reader_change_login_and_password.js"></script>
</body>
</html>
