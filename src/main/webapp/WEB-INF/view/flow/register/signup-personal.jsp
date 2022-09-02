<%@include file="../fragment/flows-header.jsp"%>

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
        <title>Shop - Register</title>

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
        <link href="${css}/register.css" media="screen" rel="stylesheet" type="text/css">
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

        <div id="register">

            <h3 class="text-center">SIGN UP</h3>
            &nbsp;&nbsp;&nbsp;
            <sf:form
                method="POST"
                class="form-horizontal"
                id="registerForm"
                modelAttribute="user"
                >

                <fieldset class="clearfix">

                    <sf:errors path="firstName" cssClass="help-block" element="em"/> 
                    <p><span class="fontawesome-user"></span><sf:input type="text" path="firstName" name="firstName" id="firstName" placeholder="First Name"/></p>

                    <sf:errors path="lastName" cssClass="help-block" element="em"/> 
                    <p><span class="fontawesome-user"></span><sf:input type="text" path="lastName" name="lastName" id="lastName" placeholder="Last Name"/></p>

                    <sf:errors path="email" cssClass="help-block" element="em"/>
                    <p><i class="bi bi-envelope-fill"></i><sf:input type="text" path="email" name="email" id="email"
                              placeholder="Email"/></p>

                    <sf:errors path="contactNumber" cssClass="help-block" element="em"/> 
                    <p><i class="bi bi-telephone-fill"></i><sf:input type="text" path="contactNumber" name="contactNumber" id="contactNumber"
                              placeholder="Contact Number" maxlength="10" /></p>
                        

                    <sf:errors path="password" cssClass="help-block" element="em"/> 
                    <p><i class="bi bi-eye-slash" id="eye"></i><sf:input type="password" name="password" id="password" path="password"
                              placeholder="Password" /></p>

                    <sf:errors path="confirmPassword" cssClass="help-block" element="em"/> 
                    <p><i class="bi bi-eye-slash" id="eye"></i><sf:input type="password" name="confirmPassword" id="password" path="confirmPassword"
                              placeholder="Confirm Password" /></p>
                        
                    <div class="form-group">
                        <label class="control-label col-md-4">Select Role</label>
                        <div class="col-md-8">
                            <label class="radio-inline">
                                <sf:radiobutton path="role" value="USER" checked="checked"/> User 				
                            </label>
                            <label class="radio-inline">
                                <sf:radiobutton path="role" value="SUPPLIER"/> Supplier
                            </label>
                        </div>
                    </div>							

                    <p><span class="glyphicon glyphicon-chevron-right"></span><input type="submit" name="_eventId_billing" value="Next - Billing"/></p>

                </fieldset>

            </sf:form>

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
