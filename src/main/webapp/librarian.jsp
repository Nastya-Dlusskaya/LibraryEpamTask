<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.03.2018
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>"${title}"</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.namePage.librarian" var="title"/>
    <fmt:message bundle="${loc}" key="local.librarian.table.reader" var="reader"/>
    <fmt:message bundle="${loc}" key="local.librarian.table.author" var="author"/>
    <fmt:message bundle="${loc}" key="local.librarian.table.nameBook" var="nameBook"/>
    <fmt:message bundle="${loc}" key="local.librarian.table.placeHall" var="placeHall"/>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th><c:out value="${reader}"/></th>
                <th><c:out value="${author}"/></th>
                <th><c:out value="${nameBook}"/></th>
                <th><c:out value="${place}"/></th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <
                    <td><c:out value="${order.user}"/></td>
                    <td><c:out value="${order.book}"/></td>
                    <td><c:out value="${order.dateOrder}"/></td>
                    <td>
                        <form action="Controller"
                        <input role="hidden" name="command" value="readHall"/>
                        <input role="submit" value="${placeHall}">

                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
