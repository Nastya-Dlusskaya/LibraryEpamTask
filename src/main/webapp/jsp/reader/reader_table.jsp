<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="pagination" prefix="p"%>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/style-desktop.css" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css" />
</head>
<body>
    <section>
        <jsp:include page="../header.jsp"/>
        <jsp:include page="reader_menu.jsp"/>
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
                    <th>Status</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.reader}"/></td>
                    <td><c:out value="${order.book}"/></td>
                    <c:if test="${captionBook eq 'Archive'}">
                        <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.handOutDate}"/></td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.actualReturnDate}"/></td>
                    </c:if>
                    <c:if test="${captionBook eq 'Current book'}">
                        <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.handOutDate}"/></td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.plannedReturnDate}"/></td>
                    </c:if>
                    <c:if test="${captionBook eq 'Ordered book'}">
                        <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.orderDate}"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${order.plannedHandOutDate != null}">
                                    Book was postponed to
                                    <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.plannedHandOutDate}"/>
                                </c:when>
                                <c:otherwise>
                                    Book was ordered
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <div class="pagination">
            <c:if test="${captionBook eq 'Archive'}">
                <p:pagination currentPage="${currentPage}" maxPage="${maxPage}" command="archive_book"/>
            </c:if>
            <c:if test="${captionBook eq 'Current book'}">
                <p:pagination currentPage="${currentPage}" maxPage="${maxPage}" command="current_book"/>
            </c:if>
            <c:if test="${captionBook eq 'Ordered book'}">
                <p:pagination currentPage="${currentPage}" maxPage="${maxPage}" command="ordered_book"/>
            </c:if>
        </div>
        </tbody>
    </section>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
