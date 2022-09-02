<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="./js/angular.js"></script>

<script src="./js/productController.js"></script>

<spring:url var="imgPopularProducts" value="/black"/>

<div class="container" ng-app="ShoppingApp" ng-controller="ProductController as pCtrl" >

    <div class="row" ng-init="pCtrl.fetchProducts()">

        <div class="col-md-3">



            <div id="productCatalog" class="panel panel-default collapse">
                &nbsp;
                <div class="product-catalog"> Product catalog</div>
                &nbsp;
                <div class="list-categories">
                    <c:forEach items="${categories}" var="category">
                        <a href="${pageContext.request.contextPath}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
                    </c:forEach>

                </div>


            </div>
        </div>

        <div class="col-md-9">

            <%@include file="./fragment/slider.jsp"%>

            &nbsp;
            <div class="row">
                <div class="col-xs-12">
                    <h3 class="article">Our Most Viewed Products</h3>
                    <hr/>
                </div>
            </div>
            &nbsp;
            <div class="row is-table-row">

                <div class="col-sm-4 col-xs-2" id="product" ng-repeat="product in pCtrl.mvProducts">                    	

                    <div class="thumbnail">
                        <img ng-src="${imgPopularProducts}/{{product.code}}.jpg" alt="{{product.name}}" class="loadingImg">
                        <div class="desc">
                            <div class="cell">
                                <p class="desc-option"><span class="title">Details:</span>{{product.description}}</p>
                            </div>
                        </div>
                    </div>
                    &nbsp;
                    <h5 class="product-name">{{product.name}}</h5>
                    <h5 class="product-info">Brand: {{product.brand}}</h5>
                    <h5 class="product-info">Views: {{product.views}}</h5>
                    <hr/>
                    <div class="caption">

                        <h4 class="pull-right" id="product-price">Price: &#36; {{product.unitPrice}}</h4>
                        <a ng-href="${contextRoot}/show/{{product.id}}/product" class="button-pop-product">View</a>
                    </div>
                </div>



                <div class="col-sm-4 col-lg-4 col-md-4">
                    <h4>Checkout more products!</h4>
                    <hr/>
                    <a class="button-pop-product" href="${contextRoot}/show/all/products">More Products</a>
                </div>

            </div>

            <div class="row">
                <div class="col-xs-12">
                    <h3 class="article">Our Most Purchased Products</h3>
                    <hr/>
                </div>
            </div>
            &nbsp;
            <div class="row is-table-row">

                <div class="col-sm-4" ng-repeat="product in pCtrl.mpProducts">     


                    <div class="thumbnail">
                        <img ng-src="${imgPopularProducts}/{{product.code}}.jpg" alt="{{product.name}}" class="loadingImg">
                        <div class="desc">
                            <div class="cell">
                                <p class="desc-option"><span class="title">Details:</span>{{product.description}}</p>
                            </div>
                        </div>
                    </div>
                    &nbsp;
                    <h5 class="product-name">{{product.name}}</h5>
                    <h5 class="product-info">Brand: {{product.brand}}</h5>
                    <h5 class="product-info">Purchases: {{product.purchases}}</h5>
                    <hr/>
                    <div class="caption">
                        <h4 class="pull-right" id="product-price">Price: &#36; {{product.unitPrice}}</h4>

                        <a ng-href="${contextRoot}/show/{{product.id}}/product" class="button-pop-product">View</a>
                    </div>
                </div>


                <div class="col-sm-4 col-lg-4 col-md-4">
                    <h4>Checkout more products!</h4>
                    <hr/>

                    <a class="button-pop-product" href="${contextRoot}/show/all/products">More Products</a>
                </div>

            </div>

        </div>

    </div>

</div>