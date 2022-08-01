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
        <link href="${css}/bootstrap.css" rel="stylesheet" />
        <link href="${css}/bootstrap.min.css" rel="stylesheet" />
        <link href="${css}/app.css" rel="stylesheet" />
        <link href="${css}/styles.css" rel="stylesheet" />
        <link href="${css}/dataTables.bootstrap5.css" rel="stylesheet" />
        <link href="${css}/popProducts.css" rel="stylesheet" />
        <link href="${css}/singleProduct.css" rel="stylesheet" />
        <link href="${css}/footer.css" rel="stylesheet" />
        <link href="${css}/manageProducts.css" rel="stylesheet" />
        <link href="${css}/switch.css" rel="stylesheet" />

        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>
    <body id="page-top">


        <div class="wrapper">

            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Shop</a>
                    </div>
                </div>
            </nav>
            <!-- About-->

            <div class="content">

                <div class="container">

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

                    <div class="row">

                        <div class="col-md-offset-3 col-md-6">

                            <div class="panel panel-primary">

                                <div class="panel-heading">
                                    <h4>Login</h4>
                                </div>

                                <div class="panel-body">
                                    <form action="${pageContext.request.contextPath}/login" method="POST" class="form-horizontal"
                                          id="loginForm"
                                          >
                                        <div class="form-group">
                                            <label for="username" class="col-md-4 control-label">Email: </label>
                                            <div class="col-md-8">
                                                <input type="text" name="username" id="username" class="form-control"/>
                                            </div>
                                        </div>
                                        &nbsp;&nbsp;&nbsp;
                                        <div class="form-group">
                                            <label for="password" class="col-md-4 control-label">Password: </label>
                                            <div class="col-md-8">
                                                <input type="password" name="password" id="password" class="form-control"/>
                                            </div>
                                        </div>
                                        &nbsp;&nbsp;&nbsp;
                                        <div class="form-group">
                                            <div class="col-md-offset-4 col-md-8">
                                                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                                                <input type="submit" value="Login" class="btn btn-primary"/>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                                <div class="panel-footer">
                                    <div class="text-right">
                                        New User - <a href="${pageContext.request.contextPath}/register">Register Here</a>
                                    </div>
                                </div>

                            </div> 

                        </div>

                    </div>    

                </div>


            </div>

            <!-- Footer-->
            <footer class="about footer_area">
                <jsp:include page="fragment/footer.jsp" />
            </footer>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
            <script src="${js}/jquery.js"></script>
            <script src="${js}/bootstrap.min.js"></script>
            <script src="${js}/bootbox.min.js"></script>
            <script src="${js}/jquery.validate.js"></script>
            <script src="${js}/app.js"></script>
            <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

        </div>
    </body>
</html>
