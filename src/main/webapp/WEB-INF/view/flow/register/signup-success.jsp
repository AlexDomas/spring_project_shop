<%@include file="../fragment/flows-header.jsp" %>

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
        <link href="${css}/success.css" media="screen" rel="stylesheet" type="text/css">
        <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">


        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>

    <body>
        <video class="video_media"  src="${pageContext.request.contextPath}/video/green.mp4" 
               autoplay muted loop>
        </video>
        <div id="success">
            <div class="text-center">	
                &nbsp;
                &nbsp;
                <h1>Welcome to Shop</h1>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <h3>You can use your email address as username to login!</h3>
                &nbsp;&nbsp;&nbsp;
                <div>
                    <a href="${pageContext.request.contextPath}/login" class="btn btn-lg btn-success">Login Here</a>
                </div>
            </div>

        </div>
    </body>

