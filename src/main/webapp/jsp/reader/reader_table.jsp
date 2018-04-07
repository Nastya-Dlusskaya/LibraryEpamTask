<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.03.2018
  Time: 18:35
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
    <jsp:include page="reader_menu.jsp"/>
    <section>
        <table border="1">
            <caption>${captionBook}</caption>
            <thead>
            <tr>
                <th>Author</th>
                <th>Name of book</th>
                <c:if test="${captionBook eq 'Archive'}">
                    <th>Hand out date</th>
                    <th>Returned Date</th>
                </c:if>
                <c:if test="${captionBook eq 'Current book'}">
                    <th>Hand out date</th>
                    <th>Planned return date</th>
                </c:if>
                <c:if test="${captionBook eq 'Ordered book'}">
                    <th>Ordered date</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.reader}"/></td>
                    <td><c:out value="${order.book}"/></td>
                    <c:if test="${captionBook eq 'Archive'}">
                        <td><c:out value="${order.handOutDate}"/></td>
                        <td><c:out value="${order.actualReturnDate}"/></td>
                    </c:if>
                    <c:if test="${captionBook eq 'Current book'}">
                        <td><c:out value="${order.handOutDate}"/></td>
                        <td><c:out value="${order.plannedReturnDate}"/></td>
                    </c:if>
                    <c:if test="${captionBook eq 'Ordered book'}">
                        <td><c:out value="${order.orderDate}"/></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
