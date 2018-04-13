<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.03.2018
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <div id="header" class="container">

        <div id="logo"><h1>Library</h1></div>
        <div id="user">
            <a class="${user != null ? "" : "hide"}" href="/?command=logout">
                    ${user}
            </a>
        </div>
    </div>


</div>