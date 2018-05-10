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
        <fmt:message key="local.error.required" var="required"/>
        <fmt:message key="local.error.minLength.login" var="loginMinLength"/>
        <fmt:message key="local.error.maxLength.login" var="loginMaxLength"/>
        <fmt:message key="local.error.minLength.password" var="passwordMinLength"/>
        <fmt:message key="local.error.maxLength.password" var="passwordMaxLength"/>
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
               data-msg-login-required="${required}"
               data-msg-login-minlength="${loginMinLength}"
               data-msg-login-maxlength="${loginMaxLength}"/>
        <h3>
            ${password}
        </h3>
        <input type="text" name="password" value="${user.password}" id="password"
               data-msg-password-required="${required}"
               data-msg-password-minlength="${passwordMinLength}"
               data-msg-password-maxlength="${passwordMaxLength}"/>
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
