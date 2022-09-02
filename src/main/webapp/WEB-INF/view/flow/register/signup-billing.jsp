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
        <title>Shop - Billing</title>

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
        <link href="${css}/billing.css" media="screen" rel="stylesheet" type="text/css">
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

        <div id="billing">

            <h3 class="text-center">BILLING</h3>
            &nbsp;&nbsp;&nbsp;

            <sf:form
                method="POST"
                modelAttribute="billing"
                class="form-horizontal"
                id="billingForm"
                >

                <fieldset class="clearfix">

                    <sf:errors path="addressLineOne" cssClass="help-block" element="em"/> 
                    <p><i class="bi bi-geo-alt-fill"></i><sf:input type="text" path="addressLineOne" name="addressLineOne" id="addressLineOne"
                              placeholder="Address Line One" /></p>

                    <sf:errors path="addressLineTwo" cssClass="help-block" element="em"/> 
                    <p><i class="bi bi-geo-alt-fill"></i><sf:input type="text" path="addressLineTwo" name="addressLineTwo" id="addressLineTwo"
                              placeholder="Address Line Two" /></p>

                    <sf:errors path="city" cssClass="help-block" element="em"/> 
                    <p><i class="bi bi-building"></i><sf:input type="text" path="city" name="city" id="city"
                              placeholder="City Name" /></p>

                    <sf:errors path="postalCode" cssClass="help-block" element="em"/> 
                    <p> <i class="bi bi-mailbox"></i> <sf:input type="text" path="postalCode" name="postalCode" id="postalCode"
                              placeholder="Postal Code" /></p>

                    <sf:errors path="state" cssClass="help-block" element="em"/> 
                    <p><i class="bi bi-reception-4"></i><sf:input type="text" path="state" name="state" id="state"
                              placeholder="State Name" /></p>

                    <sf:errors path="country" cssClass="help-block" element="em"/>
                    <p><i class="bi bi-flag"></i><sf:input type="text" path="country" name="country" id="country"
                              placeholder="Country Name"/></p>

                    <p><input type="submit" name="_eventId_personal" value="Back - Personal"/></p>
                    <p><span class="glyphicon glyphicon-chevron-right"></span><input type="submit" name="_eventId_confirm" value="Next - Confirm"/></p>

                </fieldset>
            </sf:form>					


        </div>


    </body>
