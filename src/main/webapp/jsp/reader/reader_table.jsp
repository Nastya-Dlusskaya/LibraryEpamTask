<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="pagination" prefix="p"%>
<html>
<head>
    <title>Данные</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/style-desktop.css" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css"/>
    <fmt:bundle basename="locale">
        <fmt:message key="local.readerTable.table.header.author" var="authorHeader"/>
        <fmt:message key="local.readerTable.table.header.nameBook" var="nameBookHeader"/>
        <fmt:message key="local.readerTable.table.header.handOutDate" var="handOutDateHeader"/>
        <fmt:message key="local.readerTable.table.header.returnedDate" var="returnedDateHeader"/>
        <fmt:message key="local.readerTable.table.header.plannedReturnDate" var="plannedReturnDateHeader"/>
        <fmt:message key="local.readerTable.table.header.orderedDate" var="orderedDateHeader"/>
        <fmt:message key="local.readerTable.table.header.status" var="status"/>
        <fmt:message key="local.readerTable.table.bookPostpone" var="bookPostpone"/>
        <fmt:message key="local.readerTable.table.bookOrdered" var="bookOrdered"/>
    </fmt:bundle>
</head>
<body>
    <section>
        <jsp:include page="../header.jsp"/>
        <jsp:include page="reader_menu.jsp"/>
        <table border="1">
            <caption>${captionBook}</caption>
            <thead>
            <tr>
                <th>${authorHeader}</th>
                <th>${nameBookHeader}</th>
                <c:if test="${captionBook eq 'Archive'}">
                    <th>${handOutDateHeader}</th>
                    <th>${returnedDateHeader}</th>
                </c:if>
                <c:if test="${captionBook eq 'Current book'}">
                    <th>${handOutDateHeader}</th>
                    <th>${plannedReturnDateHeader}</th>
                </c:if>
                <c:if test="${captionBook eq 'Ordered book'}">
                    <th>${orderedDateHeader}</th>
                    <th>${status}</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.book.author}"/></td>
                    <td><c:out value="${order.book.name}"/></td>
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
                                    ${bookPostpone}
                                    <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.plannedHandOutDate}"/>
                                </c:when>
                                <c:otherwise>
                                    ${bookOrdered}
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
