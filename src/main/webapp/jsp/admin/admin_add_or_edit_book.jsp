<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/style-desktop.css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<section>
    <c:if test="${book != null}">
    <form name="edit_book" method="post" action="/" id="form">
        <input type="hidden" name="command" value="edit_book"/>
        <input type="hidden" name="idBook" value="${book.id}"/>
        </c:if>
        <c:if test="${book == null}">
        <form action="add_book" method="post" action="/" class="form">
            <input type="hidden" name="command" value="add_book"/>
            </c:if>
            <c:if test="${book != null}">
            <h2>Edit book</h2>
            </c:if>
            <c:if test="${book == null}">
            <h2>Add book</h2>
            </c:if>
            <h3>Author</h3>

            <select name="listAuthor" class="select">
                <c:forEach var="author" items="${authors}">
                    <option value="<c:out value="${author.id}"/>">
                        <c:out value="${author}"/>
                    </option>
                </c:forEach>
            </select>

            <h3>Name of book</h3>

            <input type="text" name="nameBook" value="<c:out value="${book.name}"/>" required/>

            <h3>Publisher</h3>

            <select name="listPublishers" class="select">
                <c:forEach var="publisher" items="${publishers}">
                    <option value="<c:out value="${publisher.id}"/>">
                        <p><c:out value="${publisher}"/></p>
                    </option>
                </c:forEach>
            </select>
            <h3>Amount</h3>

            <input type="number" name="amount" value="<c:out value="${book.amount}"/>" required/>
            <br/>
            <input type="submit" value="Save">

</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>
