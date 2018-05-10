<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../css/style-desktop.css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
    <fmt:bundle basename="locale">
        <fmt:message key="local.loginPage.loginHeader" var="formLogin"/>
        <fmt:message key="local.loginPage.userName" var="userName"/>
        <fmt:message key="local.loginPage.password" var="password"/>
        <fmt:message key="local.loginPage.button" var="buttonName"/>
    </fmt:bundle>
</head>
<body>
<div class="wrapper">
    <jsp:include page="header.jsp"/>
    <div id="header-wrapper">
        <div id="banner">
            <section class="12u">
                <header>
                    <h2>${formLogin}</h2>
                </header>
                <form name="LoginForm" method="post" action="/" class="form">
                    <input type="hidden" name="command" value="login"/>
                    <h3>
                        ${userName}
                    </h3>
                    <input type="text" name="login" value=""/>
                    <h3>
                        ${password}
                    </h3>
                    <input type="password" name="password" required/>
                    <div class="error">
                        ${wrongAction}
                        ${nullPage}
                    </div>
                    <input type="submit" id="loginButton" value="${buttonName}"/>
                </form>
            </section>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
