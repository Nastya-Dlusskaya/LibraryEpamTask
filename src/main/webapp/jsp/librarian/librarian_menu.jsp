<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="locale">
    <fmt:message key="local.librarianMenu.acceptBook" var="acceptBook"/>
    <fmt:message key="local.librarianMenu.handOutBook" var="handOutBook"/>
</fmt:bundle>
<nav class="topnav">
    <ul>
        <li>
            <a href="/?command=librarian&page=1">
                ${handOutBook}
            </a>
        </li>

        <li>
            <a href="/?command=show_page_return_book&page=1">
                ${acceptBook}
            </a>
        </li>

    </ul>
</nav>
