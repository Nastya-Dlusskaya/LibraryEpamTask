<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.03.2018
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/style-desktop.css" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css" />
</head>
<body>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="admin_menu.jsp"/>
    <section>
        <form name="search" method="post" action="/" class="form">
            <h1>
                Search ${caption}
            </h1>
            <c:if test="${caption eq 'Readers' || caption eq 'Librarians'}">
                <h3>Last Name</h3>
                <input type="text" name="last_name"/>
                <br/>
                <h3>First Name</h3>
                <input type="text" name="first_name"/>
                <input type="hidden" name="command" value="search_person"/>
            </c:if>

            <c:if test="${caption eq 'Books'}">
                <h3>Last name of author</h3>
                <input type="text" name="last_name"/>
                <br/>
                <h3>Name of book</h3>
                <input type="text" name="name_book"/>
                <input type="hidden" name="command" value="search_book"/>
            </c:if>
            <br/>
            <input type="submit" name="search"/>
        </form>
        <table border="1">
            <caption>${caption}</caption>
            <thead>
            <tr>
                <c:if test="${caption eq 'Readers' || caption eq 'Librarians'}">
                    <th>ID</th>
                    <th>Last name</th>
                    <th>First name</th>
                </c:if>
                <c:if test="${caption eq 'Books'}">
                    <th>Author</th>
                    <th>Name</th>
                    <th>Publisher</th>
                    <th>Amount</th>
                </c:if>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="entity" items="${entities}">
                <tr>
                    <c:if test="${caption eq 'Readers' || caption eq 'Librarians'}">
                        <td>
                            <c:out value="${entity.id}"/>
                        </td>
                        <td>
                            <c:out value="${entity.lastName}"/>
                        </td>
                        <td>
                            <c:out value="${entity.firstName}"/>
                        </td>
                        <td>
                            <a href="/?command=show_add_or_edit_person&idPerson=<c:out value="${entity.id}"/>">
                                Edit
                            </a>
                            <br>
                            <a href="/?command=deletePerson&idPerson=<c:out value="${entity.id}"/>">
                                Delete
                            </a>
                        </td>
                    </c:if>
                    <c:if test="${caption eq 'Books'}">
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
                                Edit
                            </a>
                            <br>
                            <a href="/?command=deleteBook&idBook=<c:out value="${entity.id}"/>">
                                Delete
                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
