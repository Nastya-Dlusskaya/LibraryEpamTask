<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.03.2018
  Time: 8:55
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
    <h1>
        Add ${title}
    </h1>
    <form name="add" method="post" action="/" class="form">
        <c:if test="${title eq 'author'}">
            <input type="hidden" name="command" value="add_author"/>
        </c:if>
        <c:if test="${title eq 'publisher'}">
            <input type="hidden" name="command" value="add_publisher"/>
        </c:if>

        <c:if test="${title eq 'author'}">
            <h3>Last name of author</h3>
            <input type="text" name="lastNameAuthor" required/>

            <h3>First name of author</h3>

            <input type="text" name="firstNameAuthor" required/>

        </c:if>
        <c:if test="${title eq 'publisher'}">
            <h3>Name of publisher</h3>
            <input type="text" name="namePublisher" required/>
        </c:if>
        <br/>
        <input type="submit" value="Add">
    </form>

    <div align="center">
        <table border="1">
            <thead>
            <tr>
                <c:if test="${title eq 'author'}">
                    <th>Last name</th>
                    <th>First name</th>
                </c:if>
                <c:if test="${title eq 'publisher'}">
                    <th>Publisher</th>
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
</body>
</html>
