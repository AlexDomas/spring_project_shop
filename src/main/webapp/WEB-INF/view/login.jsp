<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>

<spring:url var="css" value="/css" />
<spring:url var="js" value="/js" />
<spring:url var="video" value="/video"/>



<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="noindex,follow" />
        <title>Shop - ${title}</title>

        <script>

            window.menu = '${title}';

            window.contextRoot = '${contextRoot}'

        </script>

        <link rel="icon" type="image/x-icon" href="./assets/favicon.ico" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
        <link href="${css}/login.css" media="screen" rel="stylesheet" type="text/css">
        <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">



        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Shop</a>
            </div>

        </nav>


        <div id="login">

            <c:if test="${not empty message}">
                <div class="row">
                    <div class="col-xs-12 col-md-offset-2 col-md-8">
                        <div class="alert alert-danger">${message}</div>
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty logout}">
                <div class="row">
                    <div class="col-xs-12 col-md-offset-2 col-md-8">
                        <div class="alert alert-success">${logout}</div>
                    </div>
                </div>
            </c:if>

            <h3 class="text-center">LOG IN</h3>
            &nbsp;&nbsp;&nbsp;
            <form action="${pageContext.request.contextPath}/login" method="POST" class="form-horizontal"
                  id="loginForm"
                  >
                <fieldset class="clearfix">
                    <p><span class="fontawesome-user"></span><input type="text" name="username" id="username" value="Login" onBlur="if (this.value == '')
                                        this.value = 'Логин'" onFocus="if (this.value == 'Логин')
                                                    this.value = ''" required></p>
                    &nbsp;&nbsp;&nbsp;
               
                    <p><i class="bi bi-eye-slash" id="eye"></i><input type="password" name="password" id="password" value="Password" onBlur="if (this.value == '')
                                this.value = 'Пароль'" onFocus="if (this.value == 'Пароль')
                                            this.value = ''" required></p>
                    &nbsp;&nbsp;&nbsp;

                    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <p><input type="submit" value="LOG IN"/></p>

                </fieldset>
            </form>

            <p>Don't have an account? - <a href="${pageContext.request.contextPath}/register">Register Here</a><span class="fontawesome-arrow-right"></span></p>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
        <script src="${js}/jquery.js"></script>
        <script src="${js}/bootstrap.min.js"></script>
        <script src="${js}/bootbox.min.js"></script>
        <script src="${js}/jquery.validate.js"></script>
        <script src="${js}/app.js"></script>
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>


    </body>
</html>