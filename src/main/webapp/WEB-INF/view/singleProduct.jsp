<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main class="container-product">

    <div class="row">

        <div class="col-xs-12 col-sm-4">

            <div class="thumbnail">

                <!-- Left Column / Headphones Image -->
                <div class="left-column">
                    <img data-image="black" src="${pageContext.request.contextPath}/img/products/black/${product.code}.jpg" alt="">
                    <img data-image="blue" src="${pageContext.request.contextPath}/img/products/blue/${product.code}.jpg" alt="">
                    <img data-image="red" class="active" src="${pageContext.request.contextPath}/img/products/red/${product.code}.jpg" alt="">
                </div>

            </div>
        </div>


        <!-- Right Column -->
        <div class="right-column">

            <!-- Product Description -->
            <div class="product-description">
                <span>${product.brand}</span>
                <h1 >${product.name}</h1>
                <p>${product.description}</p>
            </div>

            <p style="color:#000000">Product code: ${product.code}</p>

            <!-- Product Configuration -->
            <div class="product-configuration">

                <!-- Product Color -->
                <div class="product-color">
                    <span style="color:#000000">Color </span>
                    <p>
                    <div class="color-choose">
                        <div>
                            <input data-image="red" type="radio" id="red" name="color" value="red" checked>
                            <label for="red"><span></span></label>
                        </div>
                        <div>
                            <input data-image="blue" type="radio" id="blue" name="color" value="blue">
                            <label for="blue"><span></span></label>
                        </div>
                        <div>
                            <input data-image="black" type="radio" id="black" name="color" value="black">
                            <label for="black"><span></span></label>
                        </div>
                    </div>

                </div>

                <!-- Cable Configuration -->
                <div class="cable-config">


                    <c:choose>
                        <c:when test="${product.quantity < 1}">

                            <h6 style="color:#000000">Qty. Available: <span style="color: red"> Out of Stock</span></h6>

                        </c:when>
                        <c:otherwise>

                            <h6 style="color:#000000">Qty. Available: ${product.quantity}</h6>

                        </c:otherwise>

                    </c:choose>

                    <a style="color:#9400D3" href="#">How to configurate your ${product.name}</a>
                    <p>
                </div>
            </div>

            <!-- Product Pricing -->
            <div class="product-price">
                <span>Price: <strong> &#36; ${product.unitPrice}</span>
                <c:choose>
                    <c:when test="${product.quantity < 1}">

                        <a href="javascript:void(0)" class="btn btn-primary btn-interact disabled">Add to cart</a>&#160;

                    </c:when>
                    <c:otherwise>

                        <a href="${pageContext.request.contextPath}/cart/add/${product.id}/product" class="btn btn-primary btn-interact"><i class="fa fa-shopping-cart"></i>&#160;&#160;&#160;Add to cart</a>&#160;&#160;

                    </c:otherwise>

                </c:choose>

                <a href="${pageContext.request.contextPath}/show/all/products" class="btn btn-primary btn-interact"><i class="bi bi-arrow-left-circle"></i>&#160;&#160;Back</a> 
            </div>

        </div>
    </div>




</main>
