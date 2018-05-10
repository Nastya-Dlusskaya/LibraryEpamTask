<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/style-desktop.css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
    <fmt:bundle basename="locale">
        <fmt:message key="local.adminAuthorOrPublisher.add" var="add"/>
        <fmt:message key="local.adminAuthorOrPublisher.lastNameAuthor" var="lastNameAuthor"/>
        <fmt:message key="local.adminAuthorOrPublisher.firstNameAuthor" var="firstNameAuthor"/>
        <fmt:message key="local.adminAuthorOrPublisher.namePublisher" var="namePublisher"/>
        <fmt:message key="local.adminAuthorOrPublisher.button" var="addButton"/>
        <fmt:message key="local.adminAuthorOrPublisher.table.lastName" var="lastNameAuthorHeader"/>
        <fmt:message key="local.adminAuthorOrPublisher.table.firstName" var="firstNameAuthorHeader"/>
        <fmt:message key="local.adminAuthorOrPublisher.table.publisher" var="namePublisherHeader"/>
        <fmt:message key="local.error.required" var="lastNameAuthorRequired"/>
        <fmt:message key="local.error.required" var="firstNameAuthorRequired"/>
        <fmt:message key="local.error.required" var="namePublisherRequired"/>
        <fmt:message key="local.error.minLength.lastNameAuthor" var="lastNameAuthorMinLength"/>
        <fmt:message key="local.error.minLength.firstNameAuthor" var="firstNameAuthorMinLength"/>
        <fmt:message key="local.error.minLength.namePublisher" var="namePublisherMinLength"/>
        <fmt:message key="local.error.maxLength.lastNameAuthor" var="lastNameAuthorMaxLength"/>
        <fmt:message key="local.error.maxLength.firstNameAuthor" var="firstNameAuthorMaxLenght"/>
        <fmt:message key="local.error.maxLength.namePublisher" var="namePublisherMaxLength"/>
    </fmt:bundle>
</head>
<body>
<input type="hidden" name="typePage">
<jsp:include page="../header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<section>
    <h1>
        ${add} ${title}
    </h1>
    <c:if test="${title eq 'author'}">
        <form name="addAuthor" method="post" action="/" class="form">

            <input type="hidden" name="command" value="add_author"/>

            <h3>${lastNameAuthor}</h3>
            <input type="text" name="lastNameAuthor" id="lastNameAuthor"
                   data-msg-lastName-required="${lastNameAuthorRequired}"
                   data-msg-lastName-minlength="${lastNameAuthorMinLength}"
                   data-msg-lastName-maxlength="${lastNameAuthorMaxLength}"/>

            <h3>${firstNameAuthor}</h3>
            <input type="text" name="firstNameAuthor" id="firstNameAuthor"
                   data-msg-firstName-required="${firstNameAuthorRequired}"
                   data-msg-firstName-minlength="${firstNameAuthorMinLength}"
                   data-msg-firstName-maxlength="${firstNameAuthorMaxLenght}"/>
            <br/>
            <input type="submit" value="${addButton}">
        </form>
    </c:if>
    <c:if test="${title eq 'publisher'}">
        <form name="addPublisher" method="post" action="/" class="form">

            <input type="hidden" name="command" value="add_publisher"/>
            <h3>${namePublisher}</h3>
            <input type="text" name="namePublisher" id="namePublisher"
                   data-msg-namePublisher-required="${namePublisherRequired}"
                   data-msg-namePublisher-minlength="${namePublisherMinLength}"
                   data-msg-namePublisher-maxlength="${namePublisherMaxLength}"/>
            <br/>
            <input type="submit" value="${addButton}">
        </form>
    </c:if>
    <div align="center">
        <table border="1">
            <thead>
            <tr>
                <c:if test="${title eq 'author'}">
                    <th>${lastNameAuthorHeader}</th>
                    <th>${firstNameAuthorHeader}</th>
                </c:if>
                <c:if test="${title eq 'publisher'}">
                    <th>${namePublisherHeader}</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="entity" items="${entities}">
                <tr>
                    <c:if test="${title eq 'author'}">
                        <td><c:out value="${entity.lastName}"/></td>
                        <td><c:out value="${entity.firstName}"/></td>
                    </c:if>
                    <c:if test="${title eq 'publisher'}">
                        <td><c:out value="${entity.name}"/></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<jsp:include page="../footer.jsp"/>
<script src="/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/js/vendor/jquery.validate.min.js"></script>
<script src="/js/validation/admin_add_author_or_publisher.js"></script>
</body>
</html>
