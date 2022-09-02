<div class="productList">
    <div class="container-fluid">

        <div class="row">

            <div class="col-lg-2">

                <%@include file="fragment/aside.jsp" %>

            </div>

            <div class="col-md-10">

                <div class="row">

                    <div class="col-lg-12">

                        <c:if test="${userClickAllProducts == true}">

                            <script>
                                window.categoryId = '';

                            </script>

                        </c:if>

                        <c:if test="${userClickCategoryProducts == true}">

                            <script>
                                window.categoryId = '${category.id}';

                            </script>

                        </c:if>

                    </div>

                </div>

                &nbsp;
                <div class="row">
                    <div class="col-xs-9">

                        <div class="table-responsive">

                            <div class="container-fluid">

                                <table id="productListTable" class="table table-bordered">

                                    <thead>

                                        <tr>
                                            <th>Image</th>
                                            <th>Name</th>
                                            <th>Brand</th>
                                            <th>Price</th>
                                            <th>Qty. Available</th>
                                            <th>Show Single Product</th>
                                            <th>Add To Shopping Cart</th>
                                        </tr>

                                    </thead>

                                    <tfoot>

                                        <tr>
                                            <th>Image</th>
                                            <th>Name</th>
                                            <th>Brand</th>
                                            <th>Price</th>
                                            <th>Qty. Available</th>
                                            <th>Show Single Product</th>
                                            <th>Add To Shopping Cart</th>
                                        </tr>

                                    </tfoot>

                                </table>
                            </div>
                        </div>

                    </div>

                </div>


            </div>

        </div>

    </div>

</div>
