<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="locale">
    <fmt:message key="local.readerMenu.archive" var="archive"/>
    <fmt:message key="local.readerMenu.currentBook" var="currentBook"/>
    <fmt:message key="local.readerMenu.orderingBook" var="orderingBook"/>
    <fmt:message key="local.readerMenu.searchBook" var="searchBook"/>
    <fmt:message key="local.readerMenu.personalSettings" var="personalSettings"/>
</fmt:bundle>
<nav class="topnav">
    <ul>
        <li>
            <a href="/controller?command=archive_book&page=1">
                ${archive}
            </a>
        </li>

        <li>
            <a href="/controller?command=current_book&page=1">
                ${currentBook}
            </a>
        </li>

        <li>
            <a href="/controller?command=ordered_book&page=1">
                ${orderingBook}
            </a>
        </li>

        <li>
            <a href="/controller?command=reader">
                ${searchBook}
            </a>
        </li>

        <li>
            <a href="/controller?command=show_change_login_and_password">
                ${personalSettings}
            </a>
        </li>
    </ul>
</nav>
