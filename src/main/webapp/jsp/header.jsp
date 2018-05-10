<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="locale">
    <fmt:message key="local.header.libraryIcon" var="icon"/>
    <fmt:message key="local.header.logout" var="logout"/>
    <fmt:message key="local.footer.language.russian" var="russianLanguage"/>
    <fmt:message key="local.footer.language.english" var="englishLanguage"/>
</fmt:bundle>
<div>

    <div id="header" class="container">

        <div id="logo"><h1>${icon}</h1></div>
        <nav id="nav">
            <ul>
                <li>
                    <a href="/?command=change_language&language=ru">${russianLanguage}</a>
                    <a href="/?command=change_language&language=en">${englishLanguage}</a>
                </li>
                <li>
                    <a>${user}</a>
                </li>
                <li>
                    <a class="${user != null ? "" : "hide"}" href="/?command=logout">
                        ${logout}
                    </a>
                </li>
            </ul>
        </nav>
    </div>


</div>