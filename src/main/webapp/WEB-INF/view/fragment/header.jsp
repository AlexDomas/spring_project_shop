
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

            </ul>

            <nav class="nav navbar-nav navbar-right">
                <security:authorize access="isAnonymous()">
                    <li id="register" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/register">Sign Up</a></li>
                    <li id="login" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a></li>
                    </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <div class="dropdown" id="userCart">
                        <a href="javascript:void(0)"
                           class="btn btn-default dropdown-toggle"
                           id="dropdownMenu1"
                           data-toggle="dropdown">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" id="svg8" version="1.1" viewBox="0 0 95.05 113.63">
                            <defs id="defs2">
                            <linearGradient id="linearGradient857">
                            <stop id="stop853" offset="0" stop-color="#d089ff" stop-opacity="1"/>
                            <stop id="stop855" offset="1" stop-color="#7f00f5" stop-opacity="1"/>
                            </linearGradient>
                            <linearGradient id="linearGradient859" x1="37.47" x2="62.79" y1="9.1" y2="90.19" gradientUnits="userSpaceOnUse" xlink:href="#linearGradient857"/>
                            </defs>
                            <g id="layer1"  transform="translate(.28 -.13)">

                            <path id="flame" fill="url(#linearGradient859)" fill-opacity="1" stroke-width=".87" d="M76.12 66.56c0 15.63-13.23 28.31-29.54 28.31-16.3 0-29.73-12.68-29.53-28.31.28-21.7 21.5-33.27 22.1-50.09 10.79 2.2 36.97 24.8 36.97 50.09z" opacity="1"/>

                            <circle class="loader" id="ci1" cx="46.58" cy="66.56" r="1"  />
                            <circle class="loader" id="ci2" cx="46.58" cy="66.56" r="1"  />
                            <circle class="loader" id="ci3" cx="46.58" cy="66.56" r="1"  />
                            <circle class="loader" id="ci4" cx="46.58" cy="66.56" r="1"  />


                            <path id="rect848" fill="#7f00f5" fill-opacity="1" stroke-width=".4" d="M103.06 22.47h16.68v7.2h-13.22c-.67 0-.88.58-.88.58z" opacity="1" transform="rotate(39.18)"/>
                            <path id="circle843" fill="#21034f" fill-opacity="1" stroke-width=".4" d="M50.77 61.02a7 7 0 10-8.78 10.9c3.44 2.77 5.95 1.3 8.68 3.5l25.66 20.66 5.36-6.65L56.45 69.1c-3.21-2.59-1.98-5.1-5.68-8.08z" opacity="1"/>
                            <ellipse id="path851" cx="46.37" cy="63.24" fill="#d594ff" fill-opacity="1" stroke-width=".4" opacity="1" rx="2.01" ry="1.24"/>
                            </g>
                            </svg>
                            ${userProfileDataDto.firstName} ${userProfileDataDto.lastName}
                            <span class="caret"></span>
                        </a>
                           

                        <ul class="dropdown-menu">
                            <security:authorize access="hasAuthority('USER')">
                                <li>
                                    <a id="cart-caret" href="${pageContext.request.contextPath}/cart/show">
                                        <i class="bi bi-cart-plus-fill"></i>&nbsp;
                                        <span class="badge">${userProfileDataDto.cart.cartLines}</span>
                                        &nbsp; - &nbsp;&#36; ${userProfileDataDto.cart.grandTotal}
                                    </a>
                                </li>
                                <li class="divider burger-menu" role="separator"></li>
                                </security:authorize>
                                <security:authorize access="hasAuthority('SUPPLIER')">
                                <li><a id="cart-caret" href="${pageContext.request.contextPath}/manage/products"><i class="bi bi-gear-fill"></i>&nbsp;&nbsp;&nbsp;Manage Products</a></li>
                                <li class="divider burger-menu" role="separator"></li>
                                </security:authorize>
                            <li>
                                <a href="${pageContext.request.contextPath}/edit_profile"><i class="bi bi-person-square"></i>&nbsp;&nbsp;&nbsp;Edit Profile</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/change_password"><i class="bi bi-pencil-square"></i>&nbsp;&nbsp;&nbsp;Change Password</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/perform-logout"><i class="bi bi-box-arrow-right"></i>&nbsp;&nbsp;&nbsp;Logout</a>
                            </li>
                        </ul>
                    </div>
                </security:authorize>
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
    window.userRole = '${userProfileDataDto.role}';
</script>

