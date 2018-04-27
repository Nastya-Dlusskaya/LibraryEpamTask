<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="locale">
    <fmt:message key="local.adminMenu.addReader" var="addReader"/>
    <fmt:message key="local.adminMenu.addLibrarian" var="addLibrarian"/>
    <fmt:message key="local.adminMenu.addBook" var="addBook"/>
    <fmt:message key="local.adminMenu.addAuthor" var="addAuthor"/>
    <fmt:message key="local.adminMenu.addPublisher" var="addPublisher"/>
    <fmt:message key="local.adminMenu.searchReader" var="searchReader"/>
    <fmt:message key="local.adminMenu.searchLibrarian" var="searchLibrarian"/>
    <fmt:message key="local.adminMenu.searchBook" var="searchBook"/>
</fmt:bundle>
<nav class="topnav">
    <ul >
        <li>
            <a href="/?command=show_add_or_edit_person&type=add">
                ${addReader}
            </a>
        </li>

        <li>
            <a href="/?command=show_add_or_edit_book">
                ${addBook}
            </a>
        </li>

        <li>
            <a href="/?command=show_add_author">
                ${addAuthor}
            </a>
        </li>

        <li>
            <a href="/?command=show_add_publisher">
                ${addPublisher}
            </a>
        </li>

        <li>
            <a href="/?command=show_search_person&type=reader">
                ${searchReader}
            </a>
        </li>

        <li>
            <a href="/?command=show_search_person&type=librarian">
                ${searchLibrarian}
            </a>
        </li>

        <li>
            <a href="/?command=show_search_book">
                ${searchBook}
            </a>
        </li>
    </ul>
</nav>
