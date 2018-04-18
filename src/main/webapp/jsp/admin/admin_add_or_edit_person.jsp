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
    <c:if test="${person != null}">
    <form name="edit_person" method="post" action="/" class="form">
        <input type="hidden" name="command" value="edit_person"/>
        </c:if>
        <c:if test="${person == null}">
        <form action="add_person" method="post" action="/" class="form">
            <input type="hidden" name="command" value="add_person"/>
            </c:if>
            <c:if test="${person != null}">
            <h2>Edit person</h2>
            </c:if>
            <c:if test="${person == null}">
            <h2>Add person</h2>
            </c:if>

            <h3>Last name of person</h3>

            <input type="text" name="lastName" value="<c:out value="${person.lastName}"/>"/>

            <h3>First name of person</h3>

            <input type="text" name="firstName" value="<c:out value="${person.firstName}"/>"/>

            <h3>Role</h3>

            <ul>
                <li>
                    <input type="radio" name="selector" id="librarian" value="librarian">
                    <label for="librarian">Librarian</label>
                </li>
                <li>
                    <input type="radio" name="selector" id="reader" value="reader" checked="checked">
                    <label for="reader">Reader</label>
                </li>
            </ul>
    <c:if test="${person == null}">
            <h3>Login</h3>

            <input type="text" name="login" value="<c:out value="${login}"/>"/>

            <h3>Password</h3>

            <input type="text" name="password" value="<c:out value="${password}"/>"/>
            </c:if>
            <br>
            <input type="submit" value="Save">
</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>
