<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>	

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

        <link rel="icon" type="image/x-icon" href="./assets/favicon.ico" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
        <link href="${css}/editProfile.css" media="screen" rel="stylesheet" type="text/css">
        <link href="${css}/footer.css" media="screen" rel="stylesheet" type="text/css">
        <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">


        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>

    <body id="page-top">




        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Shop</a>
            </div>

        </nav>
        <!-- About-->



        <div id="editProfile">

            <c:if test="${not empty success}">
                <div class="alert alert-success">${success}</div>
            </c:if>

            <div class="text-center">
                <h3>Change Password</h3>
            </div>

            &nbsp;&nbsp;&nbsp;

            <sf:form action="${pageContext.request.contextPath}/change_password" method="POST" class="form-horizontal"
                     id="changePasswordForm" modelAttribute="changePasswordDto"
                     >
                <fieldset class="clearfix">

                    <label for="currentPassword" class="text-center label">Current Password: </label>
                    <p><i class="bi bi-eye-slash" id="eye"></i><sf:input type="password" name="currentPassword" id="password" path="currentPassword"/></p>
                        <sf:errors path="currentPassword" cssClass="help-block" element="em"/> 

                    <label for="newPassword" class="text-center label">New Password: </label>
                    <p><i class="bi bi-eye-slash" id="eye1"></i><sf:input type="password" name="newPassword" id="password1" path="newPassword"/></p>
                        <sf:errors path="newPassword" cssClass="help-block" element="em"/> 

                    <label for="confirmNewPassword" class="text-center label">New Confirm Password: </label>
                    <p><i class="bi bi-eye-slash" id="eye2"></i><sf:input type="password" name="confirmNewPassword" id="password2" path="confirmNewPassword"/></p>
                        <sf:errors path="confirmNewPassword" cssClass="help-block" element="em"/> 
                    &nbsp;&nbsp;&nbsp;
                    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="CHANGE"/>

                </fieldset>

            </sf:form>

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

    </body>
</html>
