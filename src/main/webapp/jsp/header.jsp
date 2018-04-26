<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="locale">
    <fmt:message key="local.header.libraryIcon" var="icon"/>
</fmt:bundle>
<div>

    <div id="header" class="container">

        <div id="logo"><h1>${icon}</h1></div>
        <div id="user">
            <a class="${user != null ? "" : "hide"}" href="/?command=logout">
                ${user}
            </a>
        </div>
    </div>


</div>