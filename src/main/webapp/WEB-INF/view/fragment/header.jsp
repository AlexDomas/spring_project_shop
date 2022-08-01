
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
                <security:authorize access="hasAuthority('SUPPLIER')">
                    <li id="manageProducts" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/manage/products">Manage Products</a></li>
                </security:authorize>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="isAnonymous()">
                    <li id="register" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/register">Sign Up</a></li>
                    <li id="login" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a></li>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a href="javascript:void(0)"
                           class="btn btn-default dropdown-toggle"
                           id="dropdownMenu1"
                           data-toggle="dropdown">
                            ${userModel.fullName}
                            <span class="caret"></span>
                        </a>

                        <ul class="dropdown-menu">
                            <security:authorize access="hasAuthority('USER')">
                                <li>
                                    <a id="cart" href="${pageContext.request.contextPath}/cart">
                                        <i class="bi bi-cart-plus-fill"></i>&nbsp;
                                        <span class="badge">${userModel.cart.cartLines}</span>
                                        &nbsp; - &nbsp;&#36; ${userModel.cart.grandTotal}
                                    </a>
                                </li>
                                <li class="divider" role="separator"></li>
                                </security:authorize>
                            <li>
                                <a href="${pageContext.request.contextPath}/permorm-logout">Logout</a>
                            </li>
                        </ul>
                    </li>
                </security:authorize>
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
    
<script>
    window.userRole = '${userModel.role}';
</script>
        
