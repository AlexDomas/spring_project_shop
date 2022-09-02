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
        <link href="${css}/confirm.css" media="screen" rel="stylesheet" type="text/css">
        <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">


        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>

    <body>    
        <div class="container">

            <div id="personal">
                &nbsp;
                <div class="text-center">
                    <h3>Personal Details</h3>
                </div>
                &nbsp;
                <div class="text-center">

                    <h5>User - ${registerDto.user.firstName} ${registerDto.user.lastName}</h5>
                    &nbsp;
                    <div class="text-center">
                        <h5>Email: ${registerDto.user.email}</h5>
                        &nbsp;
                        <h5>Contact Number: ${registerDto.user.contactNumber}</h5>
                        &nbsp;
                        <h5>Role: ${registerDto.user.role}</h5>
                        
                    </div>
                </div>

                &nbsp;
                <div class="text-center">
                    <p>
                        <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit Personal Information</a>
                    </p>
                </div>
                &nbsp;

            </div>

            <div id="billing">        
                &nbsp;
                <div class="text-center">
                    <h3>Billing Address</h3>
                </div>
                &nbsp;
                <div class="text-center">

                    <h5>State: ${registerDto.billing.state} - Country: ${registerDto.billing.country}</h5>
                    &nbsp;
                    <h5>Address Line One: ${registerDto.billing.addressLineOne} </h5>
                    &nbsp;
                    <h5>Address Line Two: ${registerDto.billing.addressLineTwo} </h5>
                    &nbsp;
                    <h5>City: ${registerDto.billing.city} - Postal Code: ${registerDto.billing.postalCode}</h5>

                </div>
                &nbsp;
                <div class="text-center">
                    <p>
                        <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit Billing Information</a>
                    </p>
                </div>
                &nbsp;

            </div>



            <div class="text-center">

                <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>

            </div>
        </div>

    </body>
