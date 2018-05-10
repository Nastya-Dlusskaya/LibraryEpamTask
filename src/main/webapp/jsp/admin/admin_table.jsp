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
        <fmt:message key="local.adminTable.caption.search" var="search"/>
        <fmt:message key="local.adminTable.caption.table.books" var="books"/>
        <fmt:message key="local.adminTable.caption.table.librarians" var="librarians"/>
        <fmt:message key="local.adminTable.caption.table.readers" var="readers"/>
        <fmt:message key="local.adminTable.caption.lastName" var="lastName"/>
        <fmt:message key="local.adminTable.caption.firstName" var="firstName"/>
        <fmt:message key="local.adminTable.caption.lastNameAuthor" var="lastNameAuthor"/>
        <fmt:message key="local.adminTable.caption.nameBook" var="nameBook"/>
        <fmt:message key="local.adminTable.table.author" var="author"/>
        <fmt:message key="local.adminTable.table.name" var="name"/>
        <fmt:message key="local.adminTable.table.publisher" var="publisher"/>
        <fmt:message key="local.adminTable.table.amount" var="amount"/>
        <fmt:message key="local.adminTable.table.action" var="action"/>
        <fmt:message key="local.adminTable.table.acton.edit" var="actionEdit"/>
        <fmt:message key="local.adminTable.table.action.delete" var="actionDelete"/>
        <fmt:message key="local.adminTable.button.search" var="searchButton"/>
    </fmt:bundle>
</head>
<body>
<input type="hidden" name="typePage">
<jsp:include page="../header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<section>
    <form name="search" method="post" action="/" class="form">
        <h1>
            ${search}
            <c:if test="${typePage eq 'Books'}">
                ${books}
            </c:if>
            <c:if test="${typePage eq 'Readers'}">
                ${readers}
            </c:if>
            <c:if test="${typePage eq 'Librarians'}">
                ${librarians}
            </c:if>
        </h1>
        <c:if test="${typePage eq 'Readers' || typePage eq 'Librarians'}">
            <h3>${lastName}</h3>
            <input type="text" name="last_name"/>
            <br/>
            <h3>${firstName}</h3>
            <input type="text" name="first_name"/>
            <input type="hidden" name="command" value="search_person"/>
        </c:if>

        <c:if test="${typePage eq 'Books'}">
            <h3>${lastNameAuthor}</h3>
            <input type="text" name="last_name"/>
            <br/>
            <h3>${nameBook}</h3>
            <input type="text" name="name_book"/>
            <input type="hidden" name="command" value="search_book"/>
        </c:if>
        <br/>
        <input type="submit" name="${searchButton}"/>
    </form>
    <c:if test="${not empty entities}">
        <table border="1">
            <caption>
                <c:if test="${typePage eq 'Books'}">
                    ${books}
                </c:if>
                <c:if test="${typePage eq 'Readers'}">
                    ${readers}
                </c:if>
                <c:if test="${typePage eq 'Librarians'}">
                    ${librarians}
                </c:if>
            </caption>
            <thead>
            <tr>
                <c:if test="${typePage eq 'Readers' || typePage eq 'Librarians'}">
                    <th>${lastName}</th>
                    <th>${firstName}</th>
                </c:if>
                <c:if test="${typePage eq 'Books'}">
                    <th>${author}</th>
                    <th>${name}</th>
                    <th>${publisher}</th>
                    <th>${amount}</th>
                </c:if>
                <th>${action}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="entity" items="${entities}">
                <tr>
                    <c:choose>
                        <c:when test="${typePage eq 'Books'}">
                            <td>
                                <c:out value="${entity.author}"/>
                            </td>
                            <td>
                                <c:out value="${entity.name}"/>
                            </td>
                            <td>
                                <c:out value="${entity.publisher}"/>
                            </td>
                            <td>
                                <c:out value="${entity.amount}"/>
                            </td>
                            <td>
                                <a href="/?command=show_add_or_edit_book&idBook=<c:out value="${entity.id}"/>">
                                        ${actionEdit}
                                </a>
                                <br>
                                <a href="/?command=delete_book&idBook=<c:out value="${entity.id}"/>">
                                        ${actionDelete}
                                </a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <c:out value="${entity.lastName}"/>
                            </td>
                            <td>
                                <c:out value="${entity.firstName}"/>
                            </td>
                            <td>
                                <a href="/?command=show_add_or_edit_person&idPerson=<c:out value="${entity.id}"/>">
                                        ${actionEdit}
                                </a>
                                <br>
                                <a href="/?command=delete_person&idPerson=<c:out value="${entity.id}"/>">
                                        ${actionDelete}
                                </a>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</section>

<jsp:include page="../footer.jsp"/>
</body>
</html>
