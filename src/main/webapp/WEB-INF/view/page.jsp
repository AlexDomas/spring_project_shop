<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>

<spring:url var="css" value="/css" />
<spring:url var="js" value="/js" />
<spring:url var="img" value="/img" />
<spring:url var="video" value="/video"/>
<spring:url var="imgPopularProducts" value="/black"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="noindex,follow" />
        <meta name="_csrf" content="${_csrf.token}">
        <meta name="_csrf_header" content="${_csrf.headerName}">
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
        <link href="${css}/slider.css" rel="stylesheet" />
        
        <link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>
    <body id="page-top">

        <div class="se-pre-con"></div>

        <div class="wrapper">

            <jsp:include page="fragment/header.jsp" />

            <!-- About-->

            <div class="content">

                <c:if test="${userClickHome == true}">
                    <jsp:include page="home.jsp" />
                </c:if>

                <c:if test="${userClickPopularProducts == true}">
                    <jsp:include page="popularProducts.jsp" />
                </c:if>

                <c:if test="${userClickAbout == true}">
                    <jsp:include page="about.jsp" />
                </c:if>

                <c:if test="${userClickContact == true}">
                    <jsp:include page="contact.jsp" />
                </c:if>

                <c:if test="${userClickNews == true}">
                    <jsp:include page="news.jsp" />
                </c:if>

                <c:if test="${userClickReviews == true}">
                    <jsp:include page="reviews.jsp" />
                </c:if>

                <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
                    <jsp:include page="listAllProducts.jsp" />
                </c:if>

                <c:if test="${userClickShowProduct == true}">
                    <jsp:include page="singleProduct.jsp" />
                </c:if>
                
                <c:if test="${userClickManageProducts == true}">
                    <jsp:include page="manageProducts.jsp" />
                </c:if>
                
                <c:if test="${userClickShowCart == true}">
                    <jsp:include page="cart.jsp" />
                </c:if>

            </div>

            <!-- Footer-->
            <footer class="about footer_area">
                <jsp:include page="fragment/footer.jsp" />
            </footer>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
            <script src="${js}/jquery.js"></script>
            <script src="${js}/jquery.dataTables.js"></script>
            <script src="${js}/dataTables.bootstrap.js"></script>
            <script src="${js}/bootstrap.min.js"></script>
            <script src="${js}/scripts.js"></script>
            <script src="${js}/singleProduct.js"></script>
            <script src="${js}/bootbox.min.js"></script>
            <script src="${js}/activeUserSignal.js"></script>
            <script src="${js}/jquery.validate.js"></script>
            <script src="${js}/app.js"></script>
            <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

        </div>
    </body>
</html>
