<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/style.css"/>
<link rel="stylesheet" href="../css/style-desktop.css"/>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.footer.rightsReserved" var="rightsReserved"/>
    <fmt:message key="local.footer.language.russian" var="russianLanguage"/>
    <fmt:message key="local.footer.language.english" var="englishLanguage"/>
</fmt:bundle>

<footer>
    <span id="copyright">
        <p>${rightsReserved}</p>
    </span>
    <span id="locale">
        <a href="/?command=change_language&language=ru">${russianLanguage}</a>
        <a href="/?command=change_language&language=en">${englishLanguage}</a>
    </span>
</footer>
