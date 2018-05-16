<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="pagination" prefix="p"%>

<html>
<head>
    <title>Librarian</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="/css/style-desktop.css" type="text/css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
    <fmt:bundle basename="locale">
        <fmt:message key="local.librarian.table.caption.orderedBook" var="orderedBook"/>
        <fmt:message key="local.librarian.table.header.returnedBook" var="returnedBook"/>
        <fmt:message key="local.librarian.table.header.reader" var="reader"/>
        <fmt:message key="local.librarian.table.header.book" var="book"/>
        <fmt:message key="local.librarian.table.header.orderDate" var="orderDate"/>
        <fmt:message key="local.librarian.table.header.plannedHandOutDate" var="plannedHandOutDate"/>
        <fmt:message key="local.librarian.table.header.status" var="status"/>
        <fmt:message key="local.librarian.table.header.place" var="place"/>
        <fmt:message key="local.librarian.table.header.plannedReturnDate" var="plannedReturnDate"/>
        <fmt:message key="local.librarian.table.header.takeBook" var="takeBook"/>
        <fmt:message key="local.librarian.table.postpone" var="postpone"/>
        <fmt:message key="local.librarian.table.hall" var="hall"/>
        <fmt:message key="local.librarian.table.home" var="home"/>
        <fmt:message key="local.librarian.table.cancel" var="cancel"/>
        <fmt:message key="local.librarian.table.takeBook" var="takeBookLink"/>
    </fmt:bundle>
</head>
<body>

<section>
    <jsp:include page="../header.jsp"/>
    <jsp:include page="librarian_menu.jsp"/>

    <c:if test="${not empty orders}">
        <table border="1">
            <c:if test="${typeTable eq 'Ordered book'}">
                <caption>${orderedBook}</caption>
            </c:if>
            <c:if test="${typeTable eq 'Returned book'}">
                <caption>${returnedBook}</caption>
            </c:if>
            <thead>
            <tr>
                <th>ID</th>
                <th>${reader}</th>
                <th>${book}</th>
                <c:if test="${typeTable eq 'Ordered book'}">
                    <th>${orderDate}</th>
                    <th>${plannedHandOutDate}</th>
                    <th>${status}</th>
                </c:if>
                <c:if test="${typeTable eq 'Returned book'}">
                    <th>${place}</th>
                    <th>${plannedReturnDate}</th>
                    <th>${takeBook}</th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.id}"></c:out></td>
                    <td><c:out value="${order.reader}"/></td>
                    <td><c:out value="${order.book}"/></td>
                    <c:if test="${typeTable eq 'Ordered book'}">
                        <th><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.orderDate}"/></th>
                        <th><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.plannedHandOutDate}"/></th>
                        <th>
                            <c:choose>
                                <c:when test="${order.plannedHandOutDate == null}">
                                    <a href="?command=postpone&id=<c:out value="${order.id}"/>">${postpone}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="?command=hand&id=<c:out value="${order.id}"/>&type=hall">${hall}</a>
                                    <a href="?command=hand&id=<c:out value="${order.id}"/>&type=home">${home}</a>
                                    <a href="?command=cancel_order&id=<c:out value="${order.id}"/>">${cancel}</a>
                                </c:otherwise>
                            </c:choose>
                        </th>
                    </c:if>
                    <c:if test="${typeTable eq 'Returned book'}">
                        <td><c:out value="${order.place}"/></td>
                        <th><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${order.plannedReturnDate}"/></th>
                        <th>
                            <a href="?command=return_book&id=<c:out value="${order.id}"/>">${takeBookLink}</a>
                        </th>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="pagination">
            <c:if test="${typeTable eq 'Ordered book'}">
                <p:pagination currentPage="${currentPage}" maxPage="${maxPage}" command="librarian"/>
            </c:if>
            <c:if test="${typeTable eq 'Returned book'}">
                <p:pagination currentPage="${currentPage}" maxPage="${maxPage}" command="show_page_return_book"/>
            </c:if>
        </div>
    </c:if>
</section>
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
