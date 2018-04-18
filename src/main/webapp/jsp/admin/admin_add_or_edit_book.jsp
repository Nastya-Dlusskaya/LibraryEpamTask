<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.03.2018
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
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
        </c:if>
        <c:if test="${book == null}">
        <form action="add_book" method="post" action="/" class="form">
            <input type="hidden" name="command" value="add_book"/>
            </c:if>

            <c:if test="${book != null}">
            <h2>Edit book</h2>
            </c:if>
            <c:if test="${book == null}">
            <h2>Add new book</h2>
            </c:if>
            <h3>Author</h3>
            <%--<select multiple name="authors" size="7">--%>
                <%--<c:forEach var="author" items="${authors}">--%>
                    <%--<option>--%>
                        <%--<c:out value="${author}"/>--%>
                    <%--</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
            <div id="dropdown" class="dropdown-content">
                <input type="text" placeholder="Search author" id="searchInput" onclick="showAuthor()" onkeyup="searchAuthor()">

                <c:forEach var="author" items="${authors}">
                    <a href="<c:out value="${author}"/>"><c:out value="${author}"/></a>
                </c:forEach>
            </div>


            <h3>Name of book</h3>

            <input type="text" name="name" value="<c:out value="${book.name}"/>"/>
            <h3>Publisher</h3>

            <select multiple name="publishers" size="7">
                <c:forEach var="publisher" items="${publishers}">
                    <option>
                        <c:out value="${publisher}"/>
                    </option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Save">

</section>
<jsp:include page="../footer.jsp"/>
<script src="/js/dropdown.js"/>
</body>
</html>
