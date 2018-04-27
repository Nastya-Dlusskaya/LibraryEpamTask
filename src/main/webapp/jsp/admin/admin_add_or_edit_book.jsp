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
        <fmt:message key="local.adminAddOrEditBook.caption.edit" var="edit"/>
        <fmt:message key="local.adminAddOrEditBook.caption.add" var="add"/>
        <fmt:message key="local.adminAddOrEditBook.caption.author" var="author"/>
        <fmt:message key="local.adminAddOrEditBook.caption.nameBook" var="nameBook"/>
        <fmt:message key="local.adminAddOrEditBook.caption.publisher" var="publisher"/>
        <fmt:message key="local.adminAddOrEditBook.caption.amount" var="amount"/>
        <fmt:message key="local.adminAddOrEditBook.button" var="button"/>
    </fmt:bundle>
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<section>
    <c:if test="${book != null}">
    <form name="editBookForm" method="post" action="/" id="form">
        <input type="hidden" name="command" value="edit_book"/>
        <input type="hidden" name="idBook" value="${book.id}"/>
        </c:if>
        <c:if test="${book == null}">
        <form action="addBookForm" method="post" action="/" class="form">
            <input type="hidden" name="command" value="add_book"/>
            </c:if>
            <c:if test="${book != null}">
            <h2>${edit}</h2>
            </c:if>
            <c:if test="${book == null}">
            <h2>${add}</h2>
            </c:if>
            <h3>${author}</h3>

            <select name="listAuthor" class="select">
                <c:forEach var="author" items="${authors}">
                    <option value="<c:out value="${author.id}"/>">
                        <c:out value="${author}"/>
                    </option>
                </c:forEach>
            </select>

            <h3>${nameBook}</h3>

            <input type="text" name="nameBook" id="nameBook" value="<c:out value="${book.name}"/>"
                   data-msg-nameBook-required="${amount}"
                   data-msg-nameBook-minlength="${amount} ${amount}"
                   data-msg-nameBook-maxlength="${amount} ${amount} ${amount}"/>

            <h3>${publisher}</h3>

            <select name="listPublishers" class="select">
                <c:forEach var="publisher" items="${publishers}">
                    <option value="<c:out value="${publisher.id}"/>">
                        <p><c:out value="${publisher}"/></p>
                    </option>
                </c:forEach>
            </select>
            <h3>${amount}</h3>

            <input type="number" name="amount" id="amount" value="<c:out value="${book.amount}"/>"
                   data-msg-amount-required="${amount}"
                   data-msg-amount-number="${amount} ${amount}"/>
            <br/>
            <input type="submit" value="${button}">

</section>
<jsp:include page="../footer.jsp"/>
<script src="/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/js/vendor/jquery.validate.min.js"></script>
<script src="/js/validation/admin_add_or_edit_book.js"></script>
</body>
</html>
