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
        <fmt:message key="local.adminAddOrEditPerson.caption.edit" var="edit"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.add" var="add"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.lastName" var="lastName"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.firstName" var="firstName"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.role" var="role"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.role.librarian" var="librarian"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.role.reader" var="reader"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.login" var="loginCaption"/>
        <fmt:message key="local.adminAddOrEditPerson.caption.password" var="passwordCaption"/>
        <fmt:message key="local.error.required" var="required"/>
        <fmt:message key="local.error.minLength.lastNamePerson" var="lastNamePersonMinLength"/>
        <fmt:message key="local.error.maxLength.lastNamePerson" var="lastNamePersonMaxLength"/>
        <fmt:message key="local.error.minLength.firstNamePerson" var="firstNamePersonMinLength"/>
        <fmt:message key="local.error.maxLength.firstNamePerson" var="firstNamePersonMaxLength"/>
        <fmt:message key="local.error.minLength.login" var="loginMinLength"/>
        <fmt:message key="local.error.maxLength.login" var="loginMaxLength"/>
        <fmt:message key="local.error.minLength.password" var="passwordMinLength"/>
        <fmt:message key="local.error.maxLength.password" var="passwordMaxLength"/>
        <fmt:message key="local.adminAddOrEditPerson.button" var="save"/>
    </fmt:bundle>
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<section>
    <c:if test="${person != null}">
    <form name="editPersonForm" method="post" action="/" class="form">
        <input type="hidden" name="command" value="edit_person"/>
        </c:if>
        <c:if test="${person == null}">
        <form name="addPersonForm" method="post" action="/" class="form">
            <input type="hidden" name="command" value="add_person"/>
            </c:if>
            <c:if test="${person != null}">
                <h2>${edit}</h2>
            </c:if>
            <c:if test="${person == null}">
                <h2>${add}</h2>
            </c:if>
            <h3>${lastName}</h3>
            <input type="text" id="lastName" name="lastName" value="<c:out value="${person.lastName}"/>"
                   data-msg-lastName-required="${required}"
                   data-msg-lastName-minlength="${lastNamePersonMinLength}"
                   data-msg-lastName-maxlength="${lastNamePersonMaxLength}"
                   data-msg-lastName-pattern="najnfwhvebljhfa"/>
            <h3>${firstName}</h3>
            <input type="text" id="firstName" name="firstName" value="<c:out value="${person.firstName}"/>"
                   data-msg-firstName-required="${required}"
                   data-msg-firstName-minlength="${firstNamePersonMinLength}"
                   data-msg-firstName-maxlength="${firstNamePersonMaxLength}"/>
            <h3>${role}</h3>

            <ul>
                <li>
                    <input type="radio" name="selector" id="librarian" value="librarian">
                    <label for="librarian">${librarian}</label>
                </li>
                <li>
                    <input type="radio" name="selector" id="reader" value="reader" checked="checked">
                    <label for="reader">${reader}</label>
                </li>
            </ul>

            <c:if test="${person == null}">
                <h3>${loginCaption}</h3>
                <input type="text" id="login" name="login" value="<c:out value="${login}"/>"
                       data-msg-login-required="${required}"
                       data-msg-login-minlength="${loginMinLength}"
                       data-msg-login-maxlength="${loginMaxLength}"/>
                <h3>${passwordCaption}</h3>
                <input type="text" id="password" name="password" value="<c:out value="${password}"/>"
                       data-msg-password-required="${required}"
                       data-msg-password-minlength="${passwordMinLength}"
                       data-msg-password-maxlength="${passwordMaxLength}"/>
            </c:if>
            <br/>
            <input type="submit" value="${save}">
        </form>
    </form>
</section>
<jsp:include page="../footer.jsp"/>
<script src="/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/js/vendor/jquery.validate.min.js"></script>
<script src="/js/validation/admin_add_or_edit_person.js"></script>
</body>
</html>
