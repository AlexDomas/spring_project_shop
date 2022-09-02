<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Shop - Flow Exception</title>

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

<body>

    <div class="wrapper">

         <%@include file="../fragment/flows-header.jsp" %>


        <div class="content">

            <div class="container">

                <div class="row">

                    <div class="col-xs-12">


                        <div class="jumbotron">

                            <h1>Please contact your administrator!</h1>
                            <hr/>

                            <blockquote style="word-wrap:break-word">

                                ${flowExecutionException}

                            </blockquote>						

                            <blockquote style="word-wrap:break-word">

                                ${rootCauseException}

                            </blockquote>						

                        </div>


                    </div>					

                </div>

            </div>

        </div>


        <%@include file="../fragment/flows-footer.jsp" %>

    </div>


</body>


</html>