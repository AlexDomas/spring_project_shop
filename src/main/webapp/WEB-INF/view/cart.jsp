
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="availableCount" value="${userProfileDataDto.cart.cartLines}" />

<div class="cart">
    <div class="container">

        &nbsp;
        <c:if test="${not empty message}">
            <div class="alert alert-info">
                <h2 class="text-center">
                    ${message}
                </h2>
            </div>
        </c:if>

        <c:choose>

            <c:when test="${not empty cartLines}">

                <table id="cart" class="table table-condensed">
                    <thead>
                        <tr>
                            <th style="width:15%">View</th>
                            <th style="width:22%; ">Description</th>
                            <th style="width:10%;">Price</th>
                            <th style="width:8%">Quantity</th>
                            <th style="width:10%" class="text-center">Subtotal</th>
                            <th style="width:15%">Refresh</th>
                            <th style="width:20%">Delete</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${cartLines}" var="cartLine">
                            <tr>
                                <td>
                                    <div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/img/products/black/${cartLine.product.code}.jpg" alt="${cartLine.product.name}" class="img-responsive cartImg"/></div>
                                </td>
                                <td data-th="Product">
                                    <div class="row">
                                        <div class="col-sm-10">
                                            <h4 class="nomargin">${cartLine.product.name}
                                                <c:if test="${cartLine.available == false}">
                                                    <strong class="unvailable">(Not Available)</strong>
                                                </c:if>
                                            </h4>
                                            <p>Brand - ${cartLine.product.brand}</p>
                                            <p>Description - ${cartLine.product.description}</p>
                                        </div>
                                    </div>
                                </td>
                                <td data-th="Price">&#36; ${cartLine.buyingPrice}</td>
                                <td data-th="Quantity">
                                    <input type="number" id="count_${cartLine.id}" min="1" max="10" class="form-control text-center" value="${cartLine.productCount}">
                                </td>
                                <td data-th="Subtotal" class="text-center">&#36; ${cartLine.total}</td>
                                <td class="actions" data-th="">
                                    <button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm"><i class="bi bi-arrow-clockwise"></i></button>

                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a>		
                                </td>
                            </tr>

                        </c:forEach>

                    </tbody>
                    <tfoot>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/show/all/products" class="btn btn-warning"><i class="bi bi-caret-left"></i> Continue Shopping</a></td>
                            <td colspan="4" class="hidden-xs"></td>
                            <td class="hidden-xs text-center"><strong>Total &#36; ${userProfileDataDto.cart.grandTotal}</strong></td>

                            <c:choose>
                                <c:when test="${availableCount != 0}">
                                    <td><a href="${pageContext.request.contextPath}/cart/validate" class="btn btn-success btn-block">Checkout <span class="glyphicon bi-caret-right"></span></a></td>
                                        </c:when>							
                                        <c:otherwise>
                                    <td><a href="javascript:void(0)" class="btn btn-success btn-block disabled"><strike>Checkout <span class="bi bi-caret-right"></span></strike></a></td>
                                            </c:otherwise>
                                        </c:choose>		
                        </tr>
                    </tfoot>
                </table>
                &nbsp;

            </c:when>



            <c:otherwise>

                <div class="jumbotron">

                    <div class="text-center">

                        <h1 class="emptyCart">Your cart is Empty!</h1>

                    </div>

                </div>

            </c:otherwise>
        </c:choose>


    </div>

</div>