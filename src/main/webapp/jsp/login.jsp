<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>local.namePage.login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="../css/style-desktop.css" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css" />
</head>
<body class="homepage">
    <div class="wrapper">

        <div id="header-wrapper">

            <header>
                <jsp:include page="header.jsp"/>
            </header>

            <div id="banner">
                <section class="12u">
                    <header>
                        <h2>Login</h2>
                    </header>
                    <form name="LoginForm" method="post" action="/" class="form">
                        <input type="hidden" name="command" value="login"/>
                        <h3>
                            User name
                        </h3>
                        <input type="text" name="login" value="" required="required"/>
                        <h3>
                            Password
                        </h3>
                        <input type="password" name="password" value="" required="required"/>
                        <div class="error-login">
                            ${wrongAction}
                            ${nullPage}
                        </div>
                        <input type="submit" value="Log in"/>
                    </form>

                </section>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</body>
</html>
