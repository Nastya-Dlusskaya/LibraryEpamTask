<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Reader</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/style-desktop.css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
    <fmt:bundle basename="locale">
        <fmt:message key="local.reader.header.search" var="search"/>
        <fmt:message key="local.reader.header.lastNameAuthor" var="lastNameAuthor"/>
        <fmt:message key="local.reader.header.nameBook" var="nameBook"/>
        <fmt:message key="local.reader.button.searchButton" var="searchButton"/>
        <fmt:message key="local.reader.table.header.author" var="authorHeader"/>
        <fmt:message key="local.reader.table.header.nameBook" var="nameBookHeader"/>
        <fmt:message key="local.reader.table.header.publisher" var="publisherHeader"/>
        <fmt:message key="local.reader.table.header.amountBook" var="amountBookHeader"/>
        <fmt:message key="local.reader.table.header.order" var="orderHeader"/>
        <fmt:message key="local.reader.table.orderBook" var="orderBook"/>
    </fmt:bundle>
</head>
<body>
<section>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="reader_menu.jsp"/>
    <form name="search" method="post" action="/" class="form">
        <input type="hidden" name="command" value="search_book"/>
        <h1>
            ${search}
        </h1>
        <h3>${lastNameAuthor}</h3>
        <input type="text" name="last_name" id="last_name"/>
        <h3>${nameBook}</h3>
        <input type="text" name="name_book" id="name_book"/>
        <br>
        <input type="submit" value="${searchButton}"/>
    </form>

    <div class="error">
        ${bookOrder}
        ${emptyRequest}
        ${noDate}
    </div>

    <div class="u12">
        <c:if test="${not empty entities}">
        <table border="1" cellpadding="6">
            <thead>
            <tr>
                <th>${authorHeader}</th>
                <th>${nameBookHeader}</th>
                <th>${publisherHeader}</th>
                <th>${amountBookHeader}</th>
                <th>${orderHeader}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${entities}">
                <tr>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.name}"/></td>
                    <td><c:out value="${book.publisher}"/></td>
                    <td><c:out value="${book.amount}"/></td>
                    <td>
                        <c:if test="${book.amount > 0}">
                            <a href="/?command=order&idBook=<c:out value="${book.id}"/>">
                                ${orderBook}
                            </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
    </c:if>
</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>
