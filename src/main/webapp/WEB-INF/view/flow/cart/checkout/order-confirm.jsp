<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>

<spring:url var="css" value="/css" />
<spring:url var="js" value="/js" />
<spring:url var="video" value="/video"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

    <%@include file="../../fragment/flows-header.jsp" %>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="noindex,follow" />
        <title>Shop - Order Confirm</title>

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
        <link href="${css}/order-address.css" media="screen" rel="stylesheet" type="text/css">
        <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">


        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>

    <body>
        <div class="content" id="order-info">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-offset-2 col-md-8">
                        <div class="alert alert-success">Your Order Is Confirmed!</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="invoice-title">
                            <h2 class="invoice-title">Invoice</h2><h3 class="pull-right" id="orderId">Order # ${orderDetail.id}</h3>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-xs-6">
                                <address id="billingAddress">
                                    <strong>Billed To:</strong><br>
                                    &nbsp;&nbsp;
                                    ${orderDetail.user.firstName} ${orderDetail.user.lastName}<br>
                                    ${orderDetail.billing.addressLineOne}<br>
                                    ${orderDetail.billing.addressLineTwo}<br>
                                    ${orderDetail.billing.city} - ${orderDetail.billing.postalCode}<br>
                                    ${orderDetail.billing.state} - ${orderDetail.billing.country}
                                    &nbsp;&nbsp;
                                    <br>
                                    Order Date: ${orderDetail.orderDate}<br><br>
                                </address>
                                &nbsp;&nbsp;
                            </div>
                            <div class="col-xs-6">
                                <address id="shippingAddress">
                                    <strong>Shipped To:</strong><br>
                                    &nbsp;&nbsp;
                                    ${orderDetail.user.firstName} ${orderDetail.user.lastName}<br>
                                    ${orderDetail.shipping.addressLineOne}<br>
                                    ${orderDetail.shipping.addressLineTwo}<br>
                                    ${orderDetail.shipping.city} - ${orderDetail.shipping.postalCode}<br>
                                    ${orderDetail.shipping.state} - ${orderDetail.shipping.country}
                                    &nbsp;&nbsp;
                                    <br>
                                    Payment Method: Card Payment <br>
                                    Email Address: ${orderDetail.user.email}
                                </address>
                                &nbsp;&nbsp;

                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-12">

                        &nbsp;&nbsp;
                        <h3 class="text-center" id="order-summary"><strong>Order summary</strong></h3>
                        &nbsp;&nbsp;

                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <td><strong>Item</strong></td>
                                        <td class="text-center"><strong>Price</strong></td>
                                        <td class="text-center"><strong>Quantity</strong></td>
                                        <td class="text-center"><strong>Totals</strong></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- foreach ($order->lineItems as $line) or some such thing here -->
                                    <c:forEach items="${orderDetail.orderItems}" var="orderItem">
                                        <tr>
                                            <td>${orderItem.product.name}</td>
                                            <td class="text-center">&#36; ${orderItem.buyingPrice}</td>
                                            <td class="text-center">${orderItem.productCount}</td>
                                            <td class="text-center">&#36; ${orderItem.total}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
                <div class="text-center">
                    <a href="${pageContext.request.contextPath}/show/all/products" class="btn btn-lg btn-warning">Continue Shopping</a>
                </div>
                &nbsp;&nbsp;
            </div>

            <%@include file="../../fragment/flows-footer.jsp" %>
        </div>

    </body>
</html>