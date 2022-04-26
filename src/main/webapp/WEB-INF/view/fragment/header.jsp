
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="img" value="/img"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container px-4 px-lg-5">
        <a id="home" class="navbar-brand" href="${pageContext.request.contextPath}/home">Shop</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto my-2 my-lg-0">
                <li id="about" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About</a></li>
                <li id="listProducts" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/show/all/products">View Products</a></li>
                <li id="news" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/news">News</a></li>
                <li id="reviews" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/reviews">Reviews</a></li>
                <li id="contact" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a></li>
                <li id="manageProducts" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manage/products">Manage Products</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Masthead-->
<header style="background-image: url(${img}/scale_1200.jpg)" class="masthead">
    <div class="container px-4 px-lg-5 h-100">
        <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
            <div class="col-lg-8 align-self-end">
                <h1 class="text-white font-weight-bold">Your Favorite Place for Free Shopping</h1>
                <hr class="divider" />
            </div>
            <div class="col-lg-8 align-self-baseline">
                <p class="text-white-75 mb-5">
                    Shop is not only a store where you can buy something, but also a place where you can get certain services. </p>
                <a class="btn btn-primary btn-xl" href="#about">Find Out More</a>
            </div>
        </div>
    </div>
</header>
