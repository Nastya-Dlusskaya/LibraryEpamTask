<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Reader</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/style-desktop.css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="reader_menu.jsp"/>
<section>
    <form name="search" method="post" action="/" class="form">
        <h1>
            Search
        </h1>
        Last name of author
        <input type="text" name="last_name"/>
        <br/>
        Name of book
        <input type="text" name="name_book"/>
        <input type="hidden" name="command" value="search_book"/>
        <input type="submit" name="search"/>
    </form>

    <div class="error-login">
        ${bookOrder}
        ${emptyRequest}
        ${noDate}
    </div>

    <div class="u12">
        <c:if test="${not empty books}">
        <table border="1" cellpadding="6">
            <thead>
            <tr>
                <th>ID</th>
                <th>Author</th>
                <th>Name of book</th>
                <th>Publisher</th>
                <th>Amount of book</th>
                <th>Order</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><c:out value="${book.idBook}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.name}"/></td>
                    <td><c:out value="${book.publisher}"/></td>
                    <td><c:out value="${book.amount}"/></td>
                    <td>
                        <c:if test="${book.amount > 0}">
                            <a href="/?command=order&idBook=<c:out value="${book.idBook}"/>">
                                Order book
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
